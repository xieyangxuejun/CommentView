package com.foretree.commment;

import android.text.style.ClickableSpan;
import android.view.View;

import com.foretree.commment.listener.OnCommentTouchListener;

/**
 *
 * Created by silen on 30/11/2017.
 */

public class TouchableSpan extends ClickableSpan {
    private String mText;
    private OnCommentTouchListener callback;

    public void setCallback( OnCommentTouchListener callback) {
        this.callback = callback;
    }

    public TouchableSpan(String text) {
        this.mText = text;
    }

    @Override
    public void onClick(View widget) {
        callback.onItemClick(widget, mText);
    }
}
