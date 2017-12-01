package com.foretree.commentview.canvasui;

import android.content.Context;

public interface CanvasHost {
    Context getContext();

    void invalidate();

    void invalidate(int i, int i2, int i3, int i4);

    void postInvalidate();

    void requestLayout();
}