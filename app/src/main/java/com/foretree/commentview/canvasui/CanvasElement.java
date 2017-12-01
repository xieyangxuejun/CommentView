package com.foretree.commentview.canvasui;

import android.content.Context;
import android.graphics.Canvas;
import android.view.MotionEvent;

public interface CanvasElement {
    boolean dispatchTouchEvent(MotionEvent motionEvent);

    void draw(Canvas canvas);

    float getAlpha();

    int getBottom();

    Context getContext();

    int getGravity();

    int getHeight();

    int getLeft();

    int getMeasuredHeight();

    int getMeasuredWidth();

    int getPaddingBottom();

    int getPaddingLeft();

    int getPaddingRight();

    int getPaddingTop();

    int getRight();

    int getTop();

    int getVisibility();

    int getWidth();

    void invalidate();

    void layout(int left, int top, int right, int bottom);

    void measure(int i, int i2);

    void requestLayout();

    void setAlpha(float f);

    void setGravity(int gravity);

    void setPadding(int left, int top, int right, int bottom);

    void setVisibility(int visibility);
}