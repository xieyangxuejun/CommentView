package com.foretree.commment;

import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.widget.TextView;

import com.foretree.commment.base.DataBindingFrameLayout;
import com.foretree.commment.callback.OnEditChangedListener;
import com.foretree.commment.databinding.ViewInputCommentBinding;
import com.foretree.commment.twitter.Type;

/**
 * 评论弹窗输入 ==> 识别 @ 和 #
 * Created by silen on 04/12/2017.
 */

public class CommentEditText extends DataBindingFrameLayout<ViewInputCommentBinding> implements TextView.OnEditorActionListener, TextWatcher{
    private OnEditChangedListener mChangeListener;

    public void setEditChangeListener(OnEditChangedListener listener) {
        this.mChangeListener = listener;
    }

    public CommentEditText(Context context) {
        super(context);
    }

    public CommentEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CommentEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.view_input_comment;
    }

    @Override
    protected void onAfterViews(Context context) {
        getBinding().textInputEtCommentMessage.addTextChangedListener(this);
        getBinding().textInputEtCommentMessage.setOnEditorActionListener(this);
    }

    /*-----------------------绑定监听------------------------*/
    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        return false;
    }


    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        CharSequence text = s.subSequence(start, s.length());
        if (TextUtils.equals(text, Constants.CASH_TAG) && mChangeListener != null) {
            mChangeListener.OnExtractor(Type.CASHTAG);
        }
    }

    @Override
    public void afterTextChanged(Editable s) {
        //todo 添加过滤
        if (mChangeListener != null) mChangeListener.OnAfterText(s);
    }
}
