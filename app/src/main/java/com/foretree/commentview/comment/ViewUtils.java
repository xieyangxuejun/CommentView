package com.foretree.commentview.comment;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.TextView;

public class ViewUtils {
    private static boolean hasGetTypeface = false;
    private static int pixelPerCM = 0;
    private static double screenSizeCM = 0.0d;
    private static volatile Typeface typeface = null;

    private ViewUtils(){}

    public static void setEnableForAllChild(View view, boolean z) {
        if (view != null) {
            view.setEnabled(z);
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    setEnableForAllChild(viewGroup.getChildAt(i), z);
                }
            }
        }
    }

    public static float getSpValue(float f) {
        return TypedValue.applyDimension(2, f, Ext.g().getAppContext().getResources().getDisplayMetrics());
    }

    public static int getColorValue(int i) {
        return Ext.g().getAppContext().getResources().getColor(i);
    }

    public static boolean isChildOf(View view, View view2) {
        if (view == view2) {
            return true;
        }
        if (view2 instanceof ViewGroup) {
            int childCount = ((ViewGroup) view2).getChildCount();
            for (int i = 0; i < childCount; i++) {
                if (isChildOf(view, ((ViewGroup) view2).getChildAt(i))) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void getChildPos(View view, View view2, int[] iArr) {
        if (iArr != null && iArr.length >= 2) {
            int left;
            int i = 0;
            int i2 = 0;
            while (view.getParent() != null) {
                left = view.getLeft() + i2;
                i2 = view.getTop() + i;
                if (view.getParent() == view2) {
                    iArr[0] = left;
                    iArr[1] = i2;
                    if (iArr.length >= 4) {
                        iArr[2] = view.getMeasuredWidth();
                        iArr[3] = view.getMeasuredHeight();
                    }
                    if (view2 == null) {
                        iArr[0] = left;
                        iArr[1] = i2;
                    }
                }
                try {
                    View view3 = (View) view.getParent();
                    if (iArr.length >= 4) {
                        iArr[2] = view3.getMeasuredWidth();
                        iArr[3] = view3.getMeasuredHeight();
                    }
                    view = view3;
                    i = i2;
                    i2 = left;
                } catch (ClassCastException e) {
                }
            }
            left = i2;
            i2 = i;
            if (view2 == null) {
                iArr[0] = left;
                iArr[1] = i2;
            }
        }
    }

    public static String getActivityName(Context context) {
        if (!(context instanceof Activity) && (context instanceof ContextWrapper)) {
            context = ((ContextWrapper) context).getBaseContext();
        }
        return context.getClass().getName();
    }

//    public static int getStatusBarHeight(Context context) {
//        Resources resources = context.getResources();
//        int identifier = resources.getIdentifier("status_bar_height", "dimen", Config.DEFAULT_TERMINAL);
//        if (identifier > 0) {
//            return resources.getDimensionPixelSize(identifier);
//        }
//        return 0;
//    }

    public static float getScaledDensity() {
        return Ext.g().getAppContext().getResources().getDisplayMetrics().scaledDensity;
    }

    public static float getDensity() {
        return Ext.g().getDensity();
    }

    public static double getScreenSizeCM() {
        if (screenSizeCM <= 0.0d) {
            DisplayMetrics displayMetrics = Ext.g().getAppContext().getResources().getDisplayMetrics();
            screenSizeCM = Math.sqrt(Math.pow((double) displayMetrics.heightPixels, 2.0d) + Math.pow((double) displayMetrics.widthPixels, 2.0d)) / ((double) getPixelPerCM());
        }
        return screenSizeCM;
    }

    public static int getPixelPerCM() {
        if (pixelPerCM <= 0) {
            pixelPerCM = (int) (((double) Ext.g().getAppContext().getResources().getDisplayMetrics().xdpi) / 2.54d);
        }
        return pixelPerCM;
    }

    public static int getScreenWidth() {
        return Ext.g().getScreenWidth();
    }

    public static int getScreenHeight() {
        return Ext.g().getScreenHeight();
    }

    public static int dpToPx(float f) {
        return Math.round(getDensity() * f);
    }

    public static int PxToDp(float f) {
        return Math.round(f / getDensity());
    }

    public static int spToPx(float f) {
        return (int) ((Ext.g().getAppContext().getResources().getDisplayMetrics().scaledDensity * f) + 0.5f);
    }

    public static int pxTosp(float f) {
        return (int) ((f / Ext.g().getAppContext().getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    public static void setAlpha(View view, float f) {
        if (view != null) {
            if (VERSION.SDK_INT >= 11) {
                view.setAlpha(f);
                return;
            }
            Animation alphaAnimation = new AlphaAnimation(f, f);
            alphaAnimation.setDuration(0);
            alphaAnimation.setFillAfter(true);
            view.startAnimation(alphaAnimation);
        }
    }

    public static void setViewBackground(View view, Drawable drawable) {
        if (view != null) {
            if (VERSION.SDK_INT < 16) {
                view.setBackgroundDrawable(drawable);
            } else {
                view.setBackground(drawable);
            }
        }
    }

    public static Typeface getDeviceTypeface() {
        if (typeface == null && !hasGetTypeface) {
            synchronized (ViewUtils.class) {
                if (typeface == null) {
                    typeface = new TextView(Ext.getContext()).getTypeface();
                    hasGetTypeface = true;
                }
            }
        }
        return typeface;
    }

    public static void setScaleX(View view, float f) {
        if (view != null && Build.VERSION.SDK_INT >= 11) {
            view.setScaleX(f);
        }
    }

    public static void setScaleY(View view, float f) {
        if (view != null && Build.VERSION.SDK_INT >= 11) {
            view.setScaleY(f);
        }
    }

    public static void setPivotX(View view, float f) {
        if (view != null && VERSION.SDK_INT >= 11) {
            view.setPivotX(f);
        }
    }

    public static void setPivotY(View view, float f) {
        if (view != null && VERSION.SDK_INT >= 11) {
            view.setPivotY(f);
        }
    }

    public static void setTranslationX(View view, float f) {
        if (view != null && VERSION.SDK_INT >= 11) {
            view.setTranslationX(f);
        }
    }

    public static void setTranslationY(View view, float f) {
        if (view != null && VERSION.SDK_INT >= 11) {
            view.setTranslationY(f);
        }
    }
}