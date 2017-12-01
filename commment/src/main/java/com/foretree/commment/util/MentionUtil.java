package com.foretree.commment.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * mention Util
 * <p>
 */
public class MentionUtil {

    private final static String VALID_MENTION = "[\\w\\-]{2,}";

    public static void extractLastMentionUserName(String text) {
        if (text == null) {
            return;
        }

        if (text.length() == 0) {
            return;
        }

        boolean found = false;
        for (char c : text.toCharArray()) {
            if (c == '@' || c == '＠') {
                found = true;
                break;
            }
        }
        if (!found) {
            return;
        }

        Matcher matcher = Pattern.compile(VALID_MENTION).matcher(text);
        while (matcher.find()) {
            String after = text.substring(matcher.end());
        }
    }
}