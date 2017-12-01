package com.foretree.commentview.comment;

import java.nio.ByteBuffer;

public interface OnIllegalArgumentException {
    void onException(IllegalArgumentException illegalArgumentException, ByteBuffer byteBuffer, int i, int i2);
}