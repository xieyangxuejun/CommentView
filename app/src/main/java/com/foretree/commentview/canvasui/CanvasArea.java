package com.foretree.commentview.canvasui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.ColorInt;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;

import java.util.HashMap;

public class CanvasArea implements CanvasElement {
    public static final float DEFAULT_BACKOFF_MULT = 1.0f;
    protected static HashMap<String, Object> mAreaCache = new HashMap();
    protected int borderColor;
    protected int borderRadius;
    protected int borderWidth;
    protected GradientDrawable borderedDrawable;
    public ClickListener clickListener;
    protected int height;
    protected String id;
    protected boolean isPressed;
    public LongClickListener longClickListener;
    private float mAlpha;
    protected Drawable mBackground;
    protected int mBottom;
    protected int mGravity;
    protected CanvasHost mHost;
    protected LayoutAttrSet mLayoutAttr;
    protected int mLeft;
    protected Handler mMainHandler;
    protected boolean mMeasureDirty;
    protected int mMeasuredHeight;
    protected int mMeasuredWidth;
    private CheckForLongPressRunnable mPendingCheckForLongPress;
    protected int mRight;
    protected int mTop;
    private int mVisibility;
    protected int paddingBottom;
    protected int paddingLeft;
    protected int paddingRight;
    protected int paddingTop;
    protected int width;

    /* compiled from: ProGuard */
    public interface ClickListener {
        void onClick(CanvasArea canvasArea, Object obj);
    }

    /* compiled from: ProGuard */
    public interface LongClickListener {
        void onLongClick(CanvasArea canvasArea, Object obj);
    }

    /* compiled from: ProGuard */
    private final class CheckForLongPressRunnable implements Runnable {
        private CheckForLongPressRunnable() {

        }

        public void run() {
            if (CanvasArea.this.isPressed) {
                CanvasArea.this.isPressed = false;
                CanvasArea.this.performLongClick();
            }
        }
    }

    public CanvasArea(CanvasHost canvasHost) {
        this(canvasHost, null);
    }

    public CanvasArea(CanvasHost canvasHost, LayoutAttrSet layoutAttrSet) {
        this.mGravity = 3;
        this.borderWidth = 0;
        this.borderColor = -1;
        this.borderRadius = 0;
        this.mVisibility = 0;
        this.mAlpha = DEFAULT_BACKOFF_MULT;
        this.isPressed = false;
        this.mMeasureDirty = false;
        this.mMainHandler = new Handler(Looper.getMainLooper());
        this.mHost = canvasHost;
        this.borderedDrawable = new GradientDrawable();
        setLayoutAttr(layoutAttrSet);
    }

    public void setLayoutAttr(LayoutAttrSet layoutAttrSet) {
        this.mLayoutAttr = layoutAttrSet;
        if (layoutAttrSet != null) {
            this.id = layoutAttrSet.id;
            setPadding(layoutAttrSet.leftPadding, layoutAttrSet.topPadding, layoutAttrSet.rightPadding, layoutAttrSet.bottomPadding);
            if (layoutAttrSet.hasAttr(LayoutAttrDefine.Gravity.Gravity)) {
                setGravity(LayoutAttrDefine.Gravity.parse(layoutAttrSet.getAttr(LayoutAttrDefine.Gravity.Gravity, LayoutAttrDefine.Gravity.DEF_LEFT)));
            }
            setBorderWidth(layoutAttrSet.getPostFixedAttr(LayoutAttrDefine.BorderWidth, this.borderWidth));
            setBorderRadius(layoutAttrSet.getPostFixedAttr(LayoutAttrDefine.BorderRadius, this.borderRadius));
            if (layoutAttrSet.getAttr(LayoutAttrDefine.BorderColor, null) != null) {
                String attr = layoutAttrSet.getAttr(LayoutAttrDefine.BorderColor, null);
                try {
                    setBorderColor(Color.parseColor(attr));
                } catch (IllegalArgumentException e) {
                    throw new IllegalArgumentException("the text " + attr + " can't be parsed as color string");
                }
            }
            if (layoutAttrSet.bg_color != -1 || (this.borderColor != -1 && this.borderWidth != 0)) {
                setBackgroundColor(layoutAttrSet.bg_color);
            }
        }
    }

    public String getId() {
        return this.id;
    }

    public LayoutAttrSet getLayoutAttr() {
        return this.mLayoutAttr;
    }

    public void setPadding(int i, int i2, int i3, int i4) {
        this.paddingLeft = i;
        this.paddingTop = i2;
        this.paddingRight = i3;
        this.paddingBottom = i4;
    }

    public int getPaddingLeft() {
        return this.paddingLeft;
    }

    public int getPaddingTop() {
        return this.paddingTop;
    }

    public int getPaddingRight() {
        return this.paddingRight;
    }

    public int getPaddingBottom() {
        return this.paddingBottom;
    }

    public int getLeft() {
        return this.mLeft;
    }

    public int getTop() {
        return this.mTop;
    }

    public int getRight() {
        return this.mRight;
    }

    public int getBottom() {
        return this.mBottom;
    }

    public int getWidth() {
        return this.mRight - this.mLeft;
    }

    public int getHeight() {
        return this.mBottom - this.mTop;
    }

    protected void setMeasuredDimension(int i, int i2) {
        this.mMeasuredWidth = i;
        this.mMeasuredHeight = i2;
    }

    public int getMeasuredWidth() {
        return this.mMeasuredWidth;
    }

    public int getMeasuredHeight() {
        return this.mMeasuredHeight;
    }

    public int getVisibility() {
        return this.mVisibility;
    }

    public void setVisibility(int i) {
        if (this.mVisibility != i) {
            this.mVisibility = i;
        }
    }

    public void setGravity(int i) {
        if (this.mGravity != i) {
            this.mGravity = i;
        }
    }

    public int getGravity() {
        return this.mGravity;
    }

    public float getAlpha() {
        return this.mAlpha;
    }

    public void setAlpha(float f) {
        if (this.mAlpha != f) {
            this.mAlpha = f;
        }
    }

    public void requestLayout() {
        if (isUIThread()) {
            this.mHost.requestLayout();
        } else {
            this.mMainHandler.post(new Runnable() {
                public void run() {
                    CanvasArea.this.mHost.requestLayout();
                }
            });
        }
    }

    public Context getContext() {
        return this.mHost.getContext();
    }

    public void setBackgroundColor(@ColorInt int i) {
        if (i != -1) {
            this.borderedDrawable.setColor(i);
        }
        setBackgroundDrawable(this.borderedDrawable);
    }

    public void setBackgroundDrawable(Drawable drawable) {
        this.mBackground = drawable;
    }

    public final void draw(Canvas canvas) {
        if (this.mVisibility == 0) {
            int saveCount = canvas.getSaveCount();
            canvas.save();
            canvas.clipRect(0, 0, this.width, this.height);
            if (this.mBackground != null) {
                this.mBackground.setBounds(0, 0, this.width, this.height);
                this.mBackground.draw(canvas);
            }
            onDraw(canvas);
            canvas.restoreToCount(saveCount);
        }
    }

    protected void onDraw(Canvas canvas) {
    }

    public final void measure(int i, int i2) {
        onMeasure(i, i2);
    }

    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(View.MeasureSpec.getSize(i), MeasureSpec.getSize(i2));
    }

    public final void layout(int i, int i2, int i3, int i4) {
        this.mLeft = i;
        this.mTop = i2;
        this.mRight = i3;
        this.mBottom = i4;
        this.width = i3 - i;
        this.height = i4 - i2;
        onLayout(i, i2, i3, i4);
    }

    protected void onLayout(int i, int i2, int i3, int i4) {
        this.borderedDrawable.setBounds(new Rect(0, 0, this.width, this.height));
    }

    protected final void addAreaCache(String str, Object obj) {
        if (!TextUtils.isEmpty(str)) {
            mAreaCache.put(str, obj);
        }
    }

    protected final Object getAreaCache(String str) {
        return !TextUtils.isEmpty(str) ? mAreaCache.get(str) : mAreaCache.get(str);
    }

    protected String generateCacheKey() {
        return null;
    }

    private boolean isUIThread() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    public void invalidate() {
        this.mHost.postInvalidate();
    }

    public int resolveSize(int i, int i2) {
        int mode = MeasureSpec.getMode(i2);
        int size = MeasureSpec.getSize(i2);
        switch (mode) {
            case Integer.MIN_VALUE:
                if (size < i) {
                    return size;
                }
                return i;
            case 1073741824:
                return size;
            default:
                return i;
        }
    }

    private void checkForLongClick() {
        if (this.mPendingCheckForLongPress == null) {
            this.mPendingCheckForLongPress = new CheckForLongPressRunnable();
        }
        this.mMainHandler.removeCallbacks(this.mPendingCheckForLongPress);
        this.mMainHandler.postDelayed(this.mPendingCheckForLongPress, (long) ViewConfiguration.getLongPressTimeout());
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return onTouchEvent(motionEvent);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                if (!(this.clickListener == null && this.longClickListener == null)) {
                    this.isPressed = true;
                    if (this.longClickListener == null) {
                        return true;
                    }
                    checkForLongClick();
                    return true;
                }
            case 1:
                if (this.isPressed) {
                    this.isPressed = false;
                    this.mMainHandler.removeCallbacks(this.mPendingCheckForLongPress);
                    return performClick();
                }
                break;
            case 3:
                this.isPressed = false;
                this.mMainHandler.removeCallbacks(this.mPendingCheckForLongPress);
                break;
        }
        return false;
    }

    public boolean performClick() {
        if (this.clickListener == null) {
            return false;
        }
        this.clickListener.onClick(this, null);
        return true;
    }

    private void performLongClick() {
        if (this.longClickListener != null) {
            this.longClickListener.onLongClick(this, null);
        }
    }

    public void setMeasureDirty(boolean z) {
        this.mMeasureDirty = z;
    }

    public int getBorderWidth() {
        return this.borderWidth;
    }

    public void setBorderWidth(int i) {
        this.borderWidth = i;
        this.borderedDrawable.setStroke(i, this.borderColor);
        invalidate();
    }

    public int getBorderColor() {
        return this.borderColor;
    }

    public void setBorderColor(int i) {
        this.borderColor = i;
        this.borderedDrawable.setStroke(this.borderWidth, i);
        invalidate();
    }

    public int getBorderRadius() {
        return this.borderRadius;
    }

    public void setBorderRadius(int i) {
        this.borderRadius = i;
        this.borderedDrawable.setCornerRadius((float) i);
        invalidate();
    }
}