package com.foretree.commment;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;

import com.foretree.commment.callback.OnCommentTouchListener;
import com.foretree.commment.twitter.Type;

/**
 *
 * Created by silen on 30/11/2017.
 */

public class TouchableSpan extends ClickableSpan {
    private String mText;
    private Type mType;
    private OnCommentTouchListener mCallback;

    public TouchableSpan(Type type, String text, OnCommentTouchListener callback) {
        this.mText = text;
        this.mType = type;
        this.mCallback = callback;
    }

    @Override
    public void onClick(View widget) {
        mCallback.onItemClick(widget, mType, mText);
    }

    @Override
    public void updateDrawState(TextPaint ds) {
        super.updateDrawState(ds);
        ds.setAntiAlias(true);
        ds.setUnderlineText(false);
    }
}
