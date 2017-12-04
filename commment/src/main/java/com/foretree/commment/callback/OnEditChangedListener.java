package com.foretree.commment.callback;

import android.text.Editable;

import com.foretree.commment.twitter.Type;

/**
 * 监听评论框输入问题监听
 * Created by silen on 04/12/2017.
 */

public interface OnEditChangedListener {
    void OnExtractor(Type type);
    void OnAfterText(Editable editable);
}
