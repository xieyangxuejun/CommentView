package com.foretree.commentview.canvasui;

import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.Log;

import java.lang.reflect.Constructor;

public class StaticLayoutWithMaxLines {
    private static final boolean DEG = false;
    private static final String TAG = StaticLayoutWithMaxLines.class.getSimpleName();
    private static final String TEXT_DIRS_CLASS = "android.text.TextDirectionHeuristics";
    private static final String TEXT_DIR_CLASS = "android.text.TextDirectionHeuristic";
    private static final String TEXT_DIR_FIRSTSTRONG_LTR = "FIRSTSTRONG_LTR";
    private static Constructor<StaticLayout> sConstructor;
    private static Object[] sConstructorArgs;
    private static boolean sInitialized;
    private static Object sTextDirection;

    public static synchronized void ensureInitialized() {
        synchronized (StaticLayoutWithMaxLines.class) {
            if (!sInitialized) {
                try {
                    Class cls;
                    if (Build.VERSION.SDK_INT >= 18) {
                        cls = TextDirectionHeuristic.class;
                        sTextDirection = TextDirectionHeuristics.FIRSTSTRONG_LTR;
                    } else {
                        ClassLoader classLoader = StaticLayoutWithMaxLines.class.getClassLoader();
                        cls = classLoader.loadClass(TEXT_DIR_CLASS);
                        Class loadClass = classLoader.loadClass(TEXT_DIRS_CLASS);
                        sTextDirection = loadClass.getField(TEXT_DIR_FIRSTSTRONG_LTR).get(loadClass);
                    }
                    Class[] clsArr = new Class[]{CharSequence.class, Integer.TYPE, Integer.TYPE, TextPaint.class, Integer.TYPE, Layout.Alignment.class, cls, Float.TYPE, Float.TYPE, Boolean.TYPE, TextUtils.TruncateAt.class, Integer.TYPE, Integer.TYPE};
                    sConstructor = StaticLayout.class.getDeclaredConstructor(clsArr);
                    sConstructor.setAccessible(true);
                    sConstructorArgs = new Object[clsArr.length];
                    sInitialized = true;
                } catch (Throwable e) {
                    Log.e(TAG, "StaticLayout constructor with max lines not found.", e);
                    sInitialized = true;
                }
            }
        }
    }

    public static boolean isSupported() {
        if (Build.VERSION.SDK_INT < 14) {
            return false;
        }
        ensureInitialized();
        return sConstructor != null;
    }

    public static synchronized StaticLayout create(CharSequence charSequence, int i, int i2, TextPaint textPaint, int i3, Layout.Alignment alignment, float f, float f2, boolean z, TextUtils.TruncateAt truncateAt, int i4, int i5) {
        StaticLayout staticLayout;
        synchronized (StaticLayoutWithMaxLines.class) {
            ensureInitialized();
            try {
                sConstructorArgs[0] = charSequence;
                sConstructorArgs[1] = Integer.valueOf(i);
                sConstructorArgs[2] = Integer.valueOf(i2);
                sConstructorArgs[3] = textPaint;
                sConstructorArgs[4] = Integer.valueOf(i3);
                sConstructorArgs[5] = alignment;
                sConstructorArgs[6] = sTextDirection;
                sConstructorArgs[7] = Float.valueOf(f);
                sConstructorArgs[8] = Float.valueOf(f2);
                sConstructorArgs[9] = Boolean.valueOf(z);
                sConstructorArgs[10] = truncateAt;
                sConstructorArgs[11] = Integer.valueOf(i4);
                sConstructorArgs[12] = Integer.valueOf(i5);
                staticLayout = (StaticLayout) sConstructor.newInstance(sConstructorArgs);
            } catch (Exception e) {
                throw new IllegalStateException("Error creating StaticLayout with max lines: " + e);
            }
        }
        return staticLayout;
    }
}