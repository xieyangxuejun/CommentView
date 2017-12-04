package com.foretree.commment.callback;

import android.view.View;

import com.foretree.commment.twitter.Type;

/**
 * 包含点击和长按,后续加上其他的事件
 * Created by silen on 30/11/2017.
 */

public interface OnCommentTouchListener<T> {
    void onClick(View v, T item);
    void onLongClick(View v, T item);
    void onItemClick(View v, Type type, String text);
}
