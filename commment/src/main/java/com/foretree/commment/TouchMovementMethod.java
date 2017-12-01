package com.foretree.commment;

import android.content.Context;
import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.method.BaseMovementMethod;
import android.text.method.Touch;
import android.text.style.BackgroundColorSpan;
import android.text.style.ClickableSpan;
import android.view.MotionEvent;
import android.widget.TextView;

/**
 * 点击方法
 * create by silen on 2017/11/30
 */
public class TouchMovementMethod extends BaseMovementMethod {
    /**整个textView的背景色*/
    private int mTextViewBgColor;
    /**点击部分文字时部分文字的背景色*/
    private int mPressSpanBgColor;

    private BackgroundColorSpan mBgSpan;
    private ClickableSpan[] mClickLinks;
    private boolean mIsPassToTv = true;
    /**
     * true：响应textView的点击事件， false：响应设置的clickableSpan事件
     */
    public boolean isPassToTv() {
        return mIsPassToTv;
    }

    private void setPassToTv(boolean isPassToTv){
        this.mIsPassToTv = isPassToTv;
    }

    public TouchMovementMethod(Context context){
        this.mTextViewBgColor = context.getResources().getColor(R.color.colorTransparent);
        this.mPressSpanBgColor = context.getResources().getColor(R.color.colorPress);
    }

    /**
     * 设置文字正常状态
     * @param textViewBgColor
     */
    public void setTextViewBgColor(int textViewBgColor) {
        this.mTextViewBgColor = textViewBgColor;
    }

    /**
     * 设置文字点击时候的颜色
     * @param pressSpanBgColor
     */
    public void setPressSpanBgColor(int pressSpanBgColor) {
        this.mPressSpanBgColor = pressSpanBgColor;
    }

    public boolean onTouchEvent(TextView widget, Spannable buffer,
                                MotionEvent event) {

        int action = event.getAction();
        if(action == MotionEvent.ACTION_DOWN){
            int x = (int) event.getX();
            int y = (int) event.getY();

            x -= widget.getTotalPaddingLeft();
            y -= widget.getTotalPaddingTop();

            x += widget.getScrollX();
            y += widget.getScrollY();

            Layout layout = widget.getLayout();
            int line = layout.getLineForVertical(y);
            int off = layout.getOffsetForHorizontal(line, x);

            mClickLinks = buffer.getSpans(off, off, ClickableSpan.class);
            if(mClickLinks.length > 0){
                // 点击的是Span区域，不要把点击事件传递
                setPassToTv(false);
                Selection.setSelection(buffer,
                        buffer.getSpanStart(mClickLinks[0]),
                        buffer.getSpanEnd(mClickLinks[0]));
                //设置点击区域的背景色
                mBgSpan = new BackgroundColorSpan(mPressSpanBgColor);
                buffer.setSpan(mBgSpan,
                        buffer.getSpanStart(mClickLinks[0]),
                        buffer.getSpanEnd(mClickLinks[0]),
                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            }else{
                setPassToTv(true);
                // textView选中效果
                widget.setBackgroundColor(mPressSpanBgColor);
            }

        }else if(action == MotionEvent.ACTION_UP){
            if(mClickLinks.length > 0){
                mClickLinks[0].onClick(widget);
                if(mBgSpan != null){//移除点击时设置的背景span
                    buffer.removeSpan(mBgSpan);
                }
            }
            Selection.removeSelection(buffer);
            widget.setBackgroundColor(mTextViewBgColor);
        }else if(action == MotionEvent.ACTION_MOVE){
            //这种情况不用做处理
        }else{
            if(mBgSpan != null){//移除点击时设置的背景span
                buffer.removeSpan(mBgSpan);
            }
            widget.setBackgroundColor(mTextViewBgColor);
        }
        return Touch.onTouchEvent(widget, buffer, event);
    }
}