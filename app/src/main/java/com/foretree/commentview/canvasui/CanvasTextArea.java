package com.foretree.commentview.canvasui;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.text.BoringLayout;
import android.text.Layout;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;

public class CanvasTextArea extends CanvasArea {
    protected static final String MaxLine = "max_line";
    private static final String TAG = CanvasTextArea.class.getSimpleName();
    protected static final String Text = "text";
    protected static final String TextAlignment = "text_alignment";
    protected static final String TextColor = "text_color";
    protected static final String TextSize = "text_size";
    private static final BoringLayout.Metrics UNKNOWN_BORING = new BoringLayout.Metrics();
    BoringLayout.Metrics mBoring;
    private TextCache mCacheText = null;
    private int mCurTextColor;
    private float mCurrTextSize;
    private TextUtils.TruncateAt mEllipsize;
    private boolean mIncludeFontPadding = true;
    private Alignment mLayoutAlignment = Alignment.ALIGN_NORMAL;
    private float mLineSpacingAdd = 0.0f;
    private float mLineSpacingMult = DEFAULT_BACKOFF_MULT;
    private int mMaxLines = Integer.MAX_VALUE;
    private int mOldMaxLines = Integer.MAX_VALUE;
    private final TextPaint mPaint = new TextPaint(1);
    private CharSequence mText = "";

    private class TextCache {
        private Bitmap mBitmap;
        private Layout mLayout;
        private int measuredHeight;
        private int measuredWidth;

        private TextCache() {
        }
    }

    public CanvasTextArea(CanvasHost canvasHost, LayoutAttrSet layoutAttrSet) {
        super(canvasHost, layoutAttrSet);
        this.mPaint.density = canvasHost.getContext().getResources().getDisplayMetrics().density;
        if (layoutAttrSet != null) {
            if (layoutAttrSet.getAttr(TextColor, null) != null) {
                String attr = layoutAttrSet.getAttr(TextColor, null);
                if (!TextUtils.isEmpty(attr)) {
                    try {
                        setTextColor(Color.parseColor(attr));
                    } catch (Exception e) {
                    }
                }
            }
            if (layoutAttrSet.hasAttr(TextSize)) {
                setTextSize((float) layoutAttrSet.getAttr(TextSize, 15));
            }
            if (layoutAttrSet.hasAttr(MaxLine)) {
                setMaxLines(layoutAttrSet.getAttr(MaxLine, Integer.MAX_VALUE));
            }
            if (layoutAttrSet.getAttr("text", null) != null) {
                CharSequence attr2 = layoutAttrSet.getAttr("text", null);
                if (!TextUtils.isEmpty(attr2)) {
                    setText(attr2);
                }
            }
            String str = "ALIGN_NORMAL";
            if (layoutAttrSet.hasAttr(TextAlignment)) {
                str = layoutAttrSet.getAttr(TextAlignment, "ALIGN_NORMAL");
            }
            boolean z = true;
            switch (str.hashCode()) {
                case -1371700497:
                    if (str.equals("ALIGN_CENTER")) {
                        z = true;
                        this.mLayoutAlignment = Alignment.ALIGN_CENTER;
                        break;
                    }
                    break;
                case -1047432319:
                    if (str.equals("ALIGN_NORMAL")) {
                        z = false;
                        this.mLayoutAlignment = Alignment.ALIGN_NORMAL;
                        break;
                    }
                    break;
                case 1015327489:
                    if (str.equals("ALIGN_OPPOSITE")) {
                        z = true;
                        this.mLayoutAlignment = Alignment.ALIGN_OPPOSITE;
                        break;
                    }
                    break;
                default:
                    throw new RuntimeException("Text alignment\"" + str + "\" is not supported");
            }
        }
        setEllipsize(TextUtils.TruncateAt.END);
    }

    private int getDesiredHeight() {
        if (this.mCacheText == null || this.mCacheText.mLayout == null) {
            return 0;
        }
        return (getPaddingTop() + getPaddingBottom()) + this.mCacheText.mLayout.getLineTop(Math.min(this.mMaxLines, this.mCacheText.mLayout.getLineCount()));
    }

    private Layout makeNewLayout(int i, BoringLayout.Metrics metrics, int i2, boolean z) {
        int i3;
        boolean z2;
        if (i < 0) {
            i3 = 0;
        } else {
            i3 = i;
        }
        this.mOldMaxLines = this.mMaxLines;
        if (this.mEllipsize != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        return makeSingleLayout(i3, metrics, i2, this.mLayoutAlignment, z2, this.mEllipsize, z);
    }

    private Layout makeSingleLayout(int i, BoringLayout.Metrics metrics, int i2, Alignment alignment, boolean z, TextUtils.TruncateAt truncateAt, boolean z2) {
        BoringLayout.Metrics isBoring;
        if (metrics == UNKNOWN_BORING) {
            isBoring = BoringLayout.isBoring(this.mText, this.mPaint, this.mBoring);
            if (isBoring != null) {
                this.mBoring = isBoring;
            }
        } else {
            isBoring = metrics;
        }
        if (isBoring != null) {
            if (isBoring.width <= i && (truncateAt == null || isBoring.width <= i2)) {
                return BoringLayout.make(this.mText, this.mPaint, i, alignment, this.mLineSpacingMult, this.mLineSpacingAdd, isBoring, this.mIncludeFontPadding);
            } else if (z && isBoring.width <= i) {
                return BoringLayout.make(this.mText, this.mPaint, i, alignment, this.mLineSpacingMult, this.mLineSpacingAdd, isBoring, this.mIncludeFontPadding, truncateAt, i2);
            } else if (z) {
                return StaticLayoutWithMaxLines.create(this.mText, 0, this.mText.length(), this.mPaint, i, alignment, this.mLineSpacingMult, this.mLineSpacingAdd, this.mIncludeFontPadding, truncateAt, i2, this.mMaxLines);
            } else {
                return new StaticLayout(this.mText, this.mPaint, i, alignment, this.mLineSpacingMult, this.mLineSpacingAdd, this.mIncludeFontPadding);
            }
        } else if (z) {
            return StaticLayoutWithMaxLines.create(this.mText, 0, this.mText.length(), this.mPaint, i, alignment, this.mLineSpacingMult, this.mLineSpacingAdd, this.mIncludeFontPadding, truncateAt, i2, this.mMaxLines);
        } else {
            return new StaticLayout(this.mText, this.mPaint, i, alignment, this.mLineSpacingMult, this.mLineSpacingAdd, this.mIncludeFontPadding);
        }
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.mCacheText = (TextCache) getAreaCache(generateCacheKey());
        if (this.mCacheText == null || this.mCacheText.mBitmap == null) {
            Bitmap createBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_4444);
            Canvas canvas2 = new Canvas(createBitmap);
            if (!(this.mCacheText == null || this.mCacheText.mLayout == null)) {
                this.mCacheText.mLayout.draw(canvas2);
                this.mCacheText.mBitmap = createBitmap;
            }
            canvas.drawBitmap(this.mCacheText.mBitmap, 0.0f, 0.0f, null);
            return;
        }
        canvas.drawBitmap(this.mCacheText.mBitmap, 0.0f, 0.0f, null);
    }

    protected void onMeasure(int i, int i2) {
        String generateCacheKey = generateCacheKey();
        this.mCacheText = (TextCache) getAreaCache(generateCacheKey);
        if (this.mCacheText == null || this.mCacheText.mLayout == null || this.mMeasureDirty) {
            this.mCacheText = new TextCache();
            addAreaCache(generateCacheKey, this.mCacheText);
            int mode = View.MeasureSpec.getMode(i);
            int mode2 = View.MeasureSpec.getMode(i2);
            int size = View.MeasureSpec.getSize(i);
            int size2 = View.MeasureSpec.getSize(i2);
            if (mode == 1073741824) {
                this.mCacheText.measuredWidth = size;
            } else {
                this.mBoring = BoringLayout.isBoring(this.mText, this.mPaint, UNKNOWN_BORING);
                if (this.mBoring == null || this.mBoring == UNKNOWN_BORING) {
                    this.mCacheText.measuredWidth = (int) Layout.getDesiredWidth(this.mText, this.mPaint);
                } else {
                    this.mCacheText.measuredWidth = this.mBoring.width;
                }
                TextCache textCache = this.mCacheText;
                textCache.measuredWidth = textCache.measuredWidth + (this.paddingLeft + this.paddingRight);
                if (mode == Integer.MIN_VALUE) {
                    this.mCacheText.measuredWidth = Math.min(size, this.mCacheText.measuredWidth);
                }
            }
            mode = (this.mCacheText.measuredWidth - this.paddingLeft) - this.paddingRight;
            this.mCacheText.mLayout = makeNewLayout(mode, this.mBoring, mode, false);
            if (mode2 == 1073741824) {
                this.mCacheText.measuredHeight = size2;
            } else {
                this.mCacheText.measuredHeight = getDesiredHeight();
                if (mode2 == Integer.MIN_VALUE) {
                    this.mCacheText.measuredHeight = Math.min(size2, this.mCacheText.measuredHeight);
                }
            }
            setMeasuredDimension(this.mCacheText.measuredWidth, this.mCacheText.measuredHeight);
            return;
        }
        setMeasuredDimension(this.mCacheText.measuredWidth, this.mCacheText.measuredHeight);
    }

    protected void onLayout(int i, int i2, int i3, int i4) {
    }

    public void setTextSize(float f) {
        setTextSize(2, f);
    }

    public void setTextSize(int i, float f) {
        float applyDimension = TypedValue.applyDimension(i, f, getContext().getResources().getDisplayMetrics());
        if (this.mPaint.getTextSize() != applyDimension) {
            this.mPaint.setTextSize(applyDimension);
            this.mCurrTextSize = applyDimension;
            requestLayout();
        }
    }

    public void setTextAlignment(Alignment alignment) {
        if (this.mLayoutAlignment != alignment) {
            this.mLayoutAlignment = alignment;
        }
    }

    public void setTextColor(int i) {
        this.mCurTextColor = i;
        this.mPaint.setColor(i);
    }

    public void setEllipsize(TextUtils.TruncateAt truncateAt) {
        if (this.mEllipsize != truncateAt) {
            this.mEllipsize = truncateAt;
        }
    }

    public void setMaxLines(int i) {
        this.mMaxLines = i;
    }

    public int getMaxLines() {
        return this.mMaxLines;
    }

    public void setText(CharSequence charSequence) {
        this.mText = charSequence;
        requestLayout();
    }

    public CharSequence getText() {
        return this.mText;
    }

    protected String generateCacheKey() {
        return this.mText.toString();
    }
}