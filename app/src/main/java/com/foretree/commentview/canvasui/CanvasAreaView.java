package com.foretree.commentview.canvasui;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.os.Build;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class CanvasAreaView extends View implements CanvasHost {
    private CanvasArea mCanvasArea;

    public CanvasAreaView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    public void setContentAreaForJsonFile(String str) {
        try {
            final ArrayMap fields = getFields();
            ArrayMap[] methods = getMethods();
            final ArrayMap arrayMap = methods[0];
            final ArrayMap arrayMap2 = methods[1];
//            setCanvasArea(CanvasUIEngine.g().inflateCanvasArea((CanvasHost) this, str, new CanvasUIEngineInflateListener() {
//                public void didInflatedArea(CanvasArea canvasArea, String str) {
//                    if (fields.containsKey(str)) {
//                        Field field = (Field) fields.get(str);
//                        field.setAccessible(true);
//                        try {
//                            field.set(CanvasAreaView.this, canvasArea);
//                        } catch (IllegalAccessException e) {
//                            e.printStackTrace();
//                            throw new RuntimeException(e.getMessage());
//                        }
//                    }
//                    if (arrayMap.containsKey(str)) {
//                        canvasArea.clickListener = CanvasAreaView.getListener((Method) arrayMap.get(str), canvasArea, CanvasAreaView.this);
//                    }
//                    if (arrayMap2.containsKey(str)) {
//                        canvasArea.longClickListener = CanvasAreaView.getLongListener((Method) arrayMap2.get(str), canvasArea, CanvasAreaView.this);
//                    }
//                }
//            }));
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
            throw new RuntimeException(e2.getMessage());
        } catch (InvocationTargetException e3) {
            e3.printStackTrace();
            throw new RuntimeException(e3.getMessage());
        }
    }

    private static CanvasArea.ClickListener getListener(final Method method, CanvasArea canvasArea, final CanvasAreaView canvasAreaView) {
        Class[] parameterTypes = method.getParameterTypes();
        if (parameterTypes.length > 2) {
            throw new RuntimeException("arguments of event method should not be more than 2");
        }
        method.setAccessible(true);
        if (parameterTypes.length == 0) {
            return new CanvasArea.ClickListener() {
                public void onClick(CanvasArea canvasArea, Object obj) {
                    try {
                        method.invoke(canvasAreaView, new Object[0]);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                        throw new RuntimeException(e.getMessage());
                    } catch (InvocationTargetException e2) {
                        e2.printStackTrace();
                        throw new RuntimeException(e2.getMessage());
                    }
                }
            };
        }
        if (CanvasArea.class.isAssignableFrom(parameterTypes[0])) {
            return parameterTypes.length == 1 ? new CanvasArea.ClickListener() {
                public void onClick(CanvasArea canvasArea, Object obj) {
                    try {
                        method.invoke(canvasAreaView, new Object[]{canvasArea});
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                        throw new RuntimeException(e.getMessage());
                    } catch (InvocationTargetException e2) {
                        e2.printStackTrace();
                        throw new RuntimeException(e2.getMessage());
                    }
                }
            } : new CanvasArea.ClickListener() {
                public void onClick(CanvasArea canvasArea, Object obj) {
                    try {
                        method.invoke(canvasAreaView, new Object[]{canvasArea, obj});
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                        throw new RuntimeException(e.getMessage());
                    } catch (InvocationTargetException e2) {
                        e2.printStackTrace();
                        throw new RuntimeException(e2.getMessage());
                    }
                }
            };
        } else {
            throw new RuntimeException("clickEvent's first parameter should be CanvasArea");
        }
    }

    private static CanvasArea.LongClickListener getLongListener(final Method method, CanvasArea canvasArea, final CanvasAreaView canvasAreaView) {
        Class[] parameterTypes = method.getParameterTypes();
        if (parameterTypes.length > 2) {
            throw new RuntimeException("arguments of event method should not be more than 2");
        }
        method.setAccessible(true);
        if (parameterTypes.length == 0) {
            return new CanvasArea.LongClickListener() {
                public void onLongClick(CanvasArea canvasArea, Object obj) {
                    try {
                        method.invoke(canvasAreaView, new Object[0]);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                        throw new RuntimeException(e.getMessage());
                    } catch (InvocationTargetException e2) {
                        e2.printStackTrace();
                        throw new RuntimeException(e2.getMessage());
                    }
                }
            };
        }
        if (CanvasArea.class.isAssignableFrom(parameterTypes[0])) {
            return parameterTypes.length == 1 ? new CanvasArea.LongClickListener() {
                public void onLongClick(CanvasArea canvasArea, Object obj) {
                    try {
                        method.invoke(canvasAreaView, new Object[]{canvasArea});
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                        throw new RuntimeException(e.getMessage());
                    } catch (InvocationTargetException e2) {
                        e2.printStackTrace();
                        throw new RuntimeException(e2.getMessage());
                    }
                }
            } : new CanvasArea.LongClickListener() {
                public void onLongClick(CanvasArea canvasArea, Object obj) {
                    try {
                        method.invoke(canvasAreaView, new Object[]{canvasArea, obj});
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                        throw new RuntimeException(e.getMessage());
                    } catch (InvocationTargetException e2) {
                        e2.printStackTrace();
                        throw new RuntimeException(e2.getMessage());
                    }
                }
            };
        } else {
            throw new RuntimeException("clickEvent's first parameter should be CanvasArea");
        }
    }

    public CanvasArea findAreaById(String str) {
        if (!(this.mCanvasArea == null || TextUtils.isEmpty(str))) {
//            if (str.equals(this.mCanvasArea.getId())) {
//                return this.mCanvasArea;
//            }
//            if (this.mCanvasArea instanceof CanvasAreaGroup) {
//                return ((CanvasAreaGroup) this.mCanvasArea).findChildById(str);
//            }
        }
        return null;
    }

    public void setCanvasArea(CanvasArea canvasArea) {
        doSetUIElement(canvasArea);
    }

    public CanvasArea getCanvasArea() {
        return this.mCanvasArea;
    }

    private void doSetUIElement(CanvasArea canvasArea) {
        if (this.mCanvasArea != canvasArea) {
            this.mCanvasArea = canvasArea;
            requestLayout();
        }
    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    private ArrayMap<String, Field> getFields() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        ArrayMap<String, Field> arrayMap = new ArrayMap();
        for (Field field : getClass().getDeclaredFields()) {
//            if (field.getAnnotation(CanvasField.class) != null && CanvasArea.class.isAssignableFrom(field.getType())) {
//                arrayMap.put(field.getName(), field);
//            }
        }
        return arrayMap;
    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    private ArrayMap<String, Method>[] getMethods() {
        ArrayMap<String, Method>[] arrayMapArr = new ArrayMap[]{new ArrayMap(), new ArrayMap()};
        for (Method method : getClass().getDeclaredMethods()) {
//            for (Annotation annotation : method.getAnnotations()) {
//                if (annotation instanceof CanvasOnClick) {
//                    CanvasOnClick canvasOnClick = (CanvasOnClick) annotation;
//                    if (canvasOnClick.values().length != 0) {
//                        for (Object put : canvasOnClick.values()) {
//                            arrayMapArr[0].put(put, method);
//                        }
//                    }
//                    if (!(canvasOnClick.value().equals("0") || arrayMapArr[0].containsKey(canvasOnClick.value()))) {
//                        arrayMapArr[0].put(canvasOnClick.value(), method);
//                    }
//                } else if (annotation instanceof CanvasOnLongClick) {
//                    CanvasOnLongClick canvasOnLongClick = (CanvasOnLongClick) annotation;
//                    if (canvasOnLongClick.values().length != 0) {
//                        for (Object put2 : canvasOnLongClick.values()) {
//                            arrayMapArr[1].put(put2, method);
//                        }
//                    }
//                    if (!(canvasOnLongClick.value().equals("0") || arrayMapArr[1].containsKey(canvasOnLongClick.value()))) {
//                        arrayMapArr[1].put(canvasOnLongClick.value(), method);
//                    }
//                }
//            }
        }
        return arrayMapArr;
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int saveCount = canvas.getSaveCount();
        canvas.save();
        if (this.mCanvasArea != null) {
            this.mCanvasArea.draw(canvas);
        }
        canvas.restoreToCount(saveCount);
    }

    protected void onMeasure(int i, int i2) {
        int paddingRight;
        int i3 = 0;
        if (this.mCanvasArea != null) {
            i3 = getPaddingLeft();
            int paddingTop = getPaddingTop();
            paddingRight = getPaddingRight();
            int paddingBottom = getPaddingBottom();
            int size = MeasureSpec.getSize(i);
            int mode = MeasureSpec.getMode(i);
            int size2 = MeasureSpec.getSize(i2);
            int mode2 = MeasureSpec.getMode(i2);
            this.mCanvasArea.measure(MeasureSpec.makeMeasureSpec((size - i3) - paddingRight, mode), MeasureSpec.makeMeasureSpec((size2 - paddingTop) - paddingBottom, mode2));
            paddingRight += i3 + this.mCanvasArea.getMeasuredWidth();
            i3 = (this.mCanvasArea.getMeasuredHeight() + paddingTop) + paddingBottom;
        } else {
            paddingRight = 0;
        }
        setMeasuredDimension(Math.max(paddingRight, getSuggestedMinimumWidth()), Math.max(i3, getSuggestedMinimumHeight()));
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.mCanvasArea != null) {
            this.mCanvasArea.layout(getPaddingLeft(), getPaddingTop(), (i3 - i) - getPaddingRight(), (i4 - i2) - getPaddingBottom());
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.mCanvasArea != null) {
            return this.mCanvasArea.dispatchTouchEvent(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }
}