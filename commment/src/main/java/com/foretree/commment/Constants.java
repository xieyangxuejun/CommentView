package com.foretree.commment;

import android.text.Spanned;

/**
 * 常量
 * Created by silen on 30/11/2017.
 */

public class Constants {
    final String TAG = BuildConfig.APPLICATION_ID;
    public final static String TEST_TEXT = "日本热 @日本語ハッシュタグ 我是谢杨学君 @小罗 @123 #الجزائر @abc 你好呀...大帅哥 " +
            "@zhangshuai 来参加 #邓师傅partty #谢劳版外卖 走起....... @长靖 吃鸡吃鸡0-0 url www.baidu.com";
    public final static int SPAN_FLAGS = Spanned.SPAN_EXCLUSIVE_EXCLUSIVE;
    public final static String EMPTY = " ";
    public final static String HASH_TAG = "#";
    public final static String CASH_TAG = "@";
    public final static String COMMA = ",";
    public final static String COLON = ":";
    public final static String SEMICOLON = ";";
    public final static String PLUS = "+";
    public final static String REPLY_TEXT = EMPTY.concat("回复").concat(EMPTY); //" 回复 "
}
