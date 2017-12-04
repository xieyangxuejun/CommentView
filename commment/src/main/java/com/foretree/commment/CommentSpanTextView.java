package com.foretree.commment;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.view.View;

import com.foretree.commment.bean.ICommentEntity;
import com.foretree.commment.callback.OnCommentTouchListener;
import com.foretree.commment.twitter.Extractor;
import com.foretree.commment.util.SpanUtil;

import java.util.List;

/**
 * 单行评论文字
 * 1. 评论别人
 * 2. 回复别人
 * Created by silen on 30/11/2017.
 */

public class CommentSpanTextView extends AppCompatTextView {

    private TouchMovementMethod mMovementMethod;
    private OnCommentTouchListener mItemTouchListener;
    private int mSelectColor;
    //识别提取mention和hashtag
    private Extractor mExtractor;

    public CommentSpanTextView(Context context) {
        this(context, null);
    }

    public CommentSpanTextView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CommentSpanTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initLayout(context, attrs, defStyleAttr);
    }

    /**
     * 初始化
     *
     * @param context
     * @param attrs
     * @param defStyleAttr
     */
    private void initLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.CommentSpanTextView);
        try {
            int pressColor = array.getColor(R.styleable.CommentSpanTextView_text_press_color, context.getResources().getColor(R.color.colorPress));
            mSelectColor = array.getColor(R.styleable.CommentSpanTextView_text_select_color, context.getResources().getColor(R.color.colorSelect));
            int cashtagColor = array.getColor(R.styleable.CommentSpanTextView_text_cashtag_color, context.getResources().getColor(R.color.colorSelect));
            int hashtagColor = array.getColor(R.styleable.CommentSpanTextView_text_hashtag_color, context.getResources().getColor(R.color.colorSelect));
            mMovementMethod = new TouchMovementMethod(context);
            mMovementMethod.setPressSpanBgColor(pressColor);
            setMovementMethod(mMovementMethod);
            mExtractor = new Extractor();
        } finally {
            array.recycle();
        }
    }

    /**
     * 设置
     *
     * @param item
     */
    public void setText(final ICommentEntity item, OnCommentTouchListener touchListener) {
        mItemTouchListener = touchListener;
        String name = item.getNickName();
        String toReplyName = item.getToNickName();
        String content = item.getContent();
        List<Extractor.Entity> cashTagsEntities = mExtractor.extractMentionsOrListsWithIndices(content);
        List<Extractor.Entity> HashTagsEntities = mExtractor.extractHashtagsWithIndices(content);

        setText(SpanUtil.getCommentSpan(
                name, toReplyName, content,
                mSelectColor, cashTagsEntities,HashTagsEntities,
                mItemTouchListener));

        //单击
        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mMovementMethod.isPassToTv()) {
                    if (mItemTouchListener != null) {
                        mItemTouchListener.onClick(v, item.getData());
                    }
                }
            }
        });
        //长按
        setOnLongClickListener(new OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (mMovementMethod.isPassToTv()) {
                    if (mItemTouchListener != null) {
                        mItemTouchListener.onLongClick(v, item.getData());
                    }
                    //这返回true会消费时间,但是touch没有up时间
                }
                return false;
            }
        });
    }
}
