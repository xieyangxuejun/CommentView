package com.foretree.commment.util;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.provider.Browser;
import android.support.annotation.NonNull;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.View;

import com.foretree.commment.Constants;
import com.foretree.commment.TouchableSpan;
import com.foretree.commment.callback.OnCommentTouchListener;
import com.foretree.commment.twitter.Extractor;
import com.foretree.commment.twitter.Type;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <p>
 * Html标签工具类
 * </p>
 */
public class SpanUtil {


    /**
     * 获取评论评论中加入@和#的文字解析
     * @param name
     * @param toReplyName
     * @param content
     * @param selectColor
     * @param cashTags
     * @param hashTags
     * @param callback
     * @return
     */
    public static Spannable getCommentSpan(String name, String toReplyName,
                                           String content, int selectColor,
                                           @NonNull List<Extractor.Entity> cashTags,
                                           @NonNull List<Extractor.Entity> hashTags,
                                           OnCommentTouchListener callback) {
        SpannableStringBuilder ssb = new SpannableStringBuilder();
        //name
        ssb.append(getClickableSpan(name, selectColor, callback));
        if (!TextUtils.isEmpty(toReplyName)) {
            //~回复~
            ssb.append(Constants.REPLY_TEXT);
            ssb.append(getClickableSpan(toReplyName, selectColor, callback));
        }
        //:
        ssb.append(Constants.COLON);
        //content
        ssb.append(getCommentSpan(content, selectColor, cashTags, hashTags, callback));
        return ssb;
    }

    public static SpannableString getCommentSpan(String content, int selectColor,
                                                 @NonNull List<Extractor.Entity> cashTags,
                                                 @NonNull List<Extractor.Entity> hashTags,
                                                 OnCommentTouchListener callback) {
        SpannableString ss = new SpannableString(content);
        //@
        setListSpan(selectColor, cashTags, callback, ss);
        //#
        setListSpan(selectColor, hashTags, callback, ss);
        return ss;
    }

    /**
     * 描述: 每一个spannable都需要单独的spannable对象设置,
     * 不然多个循环使用同一个只有last现实.
     * @param selectColor
     * @param list
     * @param callback
     * @param ss
     */
    private static void setListSpan(int selectColor, @NonNull List<Extractor.Entity> list,
                                    OnCommentTouchListener callback, SpannableString ss) {
        for (Extractor.Entity en : list) {
            TouchableSpan touchableSpan = new TouchableSpan(en.getType(), en.getValue(), callback);
            ss.setSpan(touchableSpan, en.getStart(), en.getEnd(), Constants.SPAN_FLAGS);
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(selectColor);
            ss.setSpan(foregroundColorSpan, en.getStart(), en.getEnd(), Constants.SPAN_FLAGS);
        }
    }


    public static Spannable getCommentSpan(String name, String toReplyName, String content, int selectColor, OnCommentTouchListener callback) {
        SpannableStringBuilder ssb = new SpannableStringBuilder();
        ssb.append(getClickableSpan(name, selectColor, callback));

        if (!TextUtils.isEmpty(toReplyName)) {
            ssb.append(Constants.REPLY_TEXT);
            ssb.append(getClickableSpan(toReplyName, selectColor, callback));
        }

        ssb.append(Constants.COLON);
        return ssb;
    }

    /**
     * 文字内容加粗
     *
     * @param content 文字内容
     * @return 返回Spannable
     */
    public static Spannable dealContentForBold(String content) {
        if (TextUtil.isNull(content)) {
            return new SpannableString("");
        }
        SpannableString spannableString = new SpannableString(content);
        setBoldLinkSpan(spannableString, 0, spannableString.length());
        return spannableString;
    }

    /**
     * 设置加粗的style
     *
     * @param SS    内容
     * @param start 开始位置 [
     * @param end   结束位置 )
     */
    public static void setBoldLinkSpan(Spannable SS, int start, int end) {
        SS.setSpan(new StyleSpan(Typeface.BOLD), start, end, Constants.SPAN_FLAGS);
    }

    public static Spannable getBoldSpan(String content) {
        if (TextUtils.isEmpty(content)) {
            return null;
        }
        SpannableString spannableString = new SpannableString(content);
        spannableString.setSpan(new StyleSpan(Typeface.BOLD), 0, content.length(), Constants.SPAN_FLAGS);
        return spannableString;
    }

    /**
     * 获取点击的span
     * @param textStr
     * @param color
     * @param callback
     * @return
     */
    @NonNull
    public static SpannableString getClickableSpan( String textStr, int color, OnCommentTouchListener callback) {
        SpannableString ss = new SpannableString(textStr);
        TouchableSpan touchableSpan = new TouchableSpan(Type.NONE, textStr, callback);
        ss.setSpan(touchableSpan, 0, textStr.length(), Constants.SPAN_FLAGS);
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(color);
        ss.setSpan(foregroundColorSpan, 0, textStr.length(), Constants.SPAN_FLAGS);
        return ss;
    }

    public static SpannableStringBuilder formatUrlString(String contentStr){
        SpannableStringBuilder sp;
        if(!TextUtils.isEmpty(contentStr)){

            sp = new SpannableStringBuilder(contentStr);
            try {
                //处理url匹配
                Pattern urlPattern = Pattern.compile("(http|https|ftp|svn)://([a-zA-Z0-9]+[/?.?])" +
                        "+[a-zA-Z0-9]*\\??([a-zA-Z0-9]*=[a-zA-Z0-9]*&?)*");
                Matcher urlMatcher = urlPattern.matcher(contentStr);

                while (urlMatcher.find()) {
                    final String url = urlMatcher.group();
                    if(!TextUtils.isEmpty(url)){
                        sp.setSpan(new ClickableSpan(){
                            @Override
                            public void onClick(View widget) {
                                Uri uri = Uri.parse(url);
                                Context context = widget.getContext();
                                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                                intent.putExtra(Browser.EXTRA_APPLICATION_ID, context.getPackageName());
                                context.startActivity(intent);
                            }
                        }, urlMatcher.start(), urlMatcher.end(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                    }
                }

                //处理电话匹配
                Pattern phonePattern = Pattern.compile("[1][34578][0-9]{9}");
                Matcher phoneMatcher = phonePattern.matcher(contentStr);
                while (phoneMatcher.find()) {
                    final String phone = phoneMatcher.group();
                    if(!TextUtils.isEmpty(phone)){
                        sp.setSpan(new ClickableSpan(){
                            @Override
                            public void onClick(View widget) {
                                Context context = widget.getContext();
                                //用intent启动拨打电话
                                Intent intent = new Intent(Intent.ACTION_DIAL,Uri.parse("tel:"+phone));
                                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                context.startActivity(intent);
                            }
                        }, phoneMatcher.start(), phoneMatcher.end(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                    }
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }else{
            sp = new SpannableStringBuilder();
        }
        return sp;
    }
}
