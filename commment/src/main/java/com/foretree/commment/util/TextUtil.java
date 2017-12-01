package com.foretree.commment.util;

import android.graphics.Bitmap;
import android.text.Spanned;

import java.util.Collection;
import java.util.Map;

public class TextUtil {

    public static boolean isNull(String content) {
        return !isValidate(content);
    }

    public static boolean isNull(Collection<?> content) {
        return !isValidate(content);
    }

    public static boolean isNull(Object model) {
        return !isValidate(model);
    }

    public static boolean isNull(Bitmap bitmap) {
        return !isValidate(bitmap);
    }

    public static boolean isNull(Spanned spanned) {
        return !isValidate(spanned);
    }

    public static boolean isNull(Map<String, String> map) {
        return !isValidate(map);
    }

    public static boolean isValidate(String content) {
        return content != null && !"".equals(content.trim());
    }

    public static boolean isValidate(Collection<?> list) {
        return (list != null) && (list.size() > 0);
    }

    public static boolean isValidate(Object model) {
        return (model != null);
    }

    public static boolean isValidate(int resId) {
        return (resId != 0) && (resId > 0);
    }

    public static boolean isValidate(Bitmap bitmap) {
        return (bitmap != null);
    }

    public static boolean isValidate(Map<String, String> comments) {
        return (comments != null && !comments.isEmpty());
    }

    public static boolean isValidate(Spanned usernameStatus) {
        return usernameStatus != null;
    }
}