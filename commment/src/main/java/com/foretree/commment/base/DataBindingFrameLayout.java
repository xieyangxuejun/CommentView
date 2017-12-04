package com.foretree.commment.base;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;

/**
 * author  xieyangxuejun
 * created 2017/10/17 14:40
 */
public abstract class DataBindingFrameLayout<B extends ViewDataBinding> extends FrameLayout {

    private B mBinding;

    public DataBindingFrameLayout(Context context) {
        this(context, null);
    }

    public DataBindingFrameLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DataBindingFrameLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
        onAfterViews(context);
    }

    protected void initView(Context context) {
        mBinding = DataBindingUtil.inflate(LayoutInflater.from(context), getLayoutId(), this, true);
    }

    protected abstract int getLayoutId();

    protected abstract void onAfterViews(Context context);

    public B getBinding() {
        return mBinding;
    }

}