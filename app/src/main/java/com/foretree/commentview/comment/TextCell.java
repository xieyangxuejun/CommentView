package com.foretree.commentview.comment;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.Pair;

import java.io.Serializable;

public class TextCell implements Serializable, Cloneable {
    public static final int FLAG_EMO = 256;
    public static final int FLAG_EMO_MASK = 1044480;
    public static final int FLAG_EMO_SEQ = 4096;
    public static final int FLAG_LINEBREAK_MASK = 267386880;
    public static final int FLAG_LINEBREAK_SEQ = 1048576;
    public static final int FLAG_TYPE_MASK = 255;
    public static final int SIGN_ADV_SUMMARY = 18;
    public static final int SIGN_COLOR = 9;
    public static final int SIGN_COMMENT = 7;
    public static final int SIGN_FEED_OWNER = 6;
    public static final int SIGN_GOTO_DETAIL = 5;
    public static final int SIGN_LIKE_NICKNAME = 17;
    public static final int SIGN_LINEBREAK = 16;
    public static final int SIGN_NORMAL = 0;
    public static final int SIGN_PACK_OR_UNPACK = 18;
    public static final int SIGN_REPLY = 8;
    public static final int SIGN_TOPIC = 1;
    public static final int SIGN_URL = 4;
    public static final int SIGN_USER = 3;
    public static final int SIGN_WALL = 2;
    static final String ellipsis = "...";
    private static Paint sDebugPaint = null;
    private static final long serialVersionUID = 5342730555874002105L;
    private boolean canCopy;
    protected float fontSize;
    public boolean isBreak;
    public boolean isDrawableLoaded;
    public boolean isPresseding;
    public int linebreak;
    public int linebreakSeq;
    protected int linkColor;
    protected int mShadowColor;
    protected int mShadowRadius;
    protected int mShadowX;
    protected int mShadowY;
    public boolean needHighLight;
    private Pair<Integer, Integer> points;
    public String post;
    public transient Rect rect;
    public String text;
    private int textColor;
    public int type;
    private Long uin;
    private String url;
    public boolean useDefaultFont;
    protected boolean useHanyiColorFont;
    public boolean useSuperFont;

    public TextCell() {
        this.needHighLight = false;
        this.useDefaultFont = false;
        this.useHanyiColorFont = true;
        this.isBreak = false;
        this.linebreakSeq = 0;
        this.isPresseding = false;
        this.type = 0;
        this.canCopy = true;
        this.isDrawableLoaded = true;
        this.linebreak = 0;
        this.useSuperFont = true;
        this.type = 0;
    }

    public TextCell(int i) {
        this.needHighLight = false;
        this.useDefaultFont = false;
        this.useHanyiColorFont = true;
        this.isBreak = false;
        this.linebreakSeq = 0;
        this.isPresseding = false;
        this.type = 0;
        this.canCopy = true;
        this.isDrawableLoaded = true;
        this.linebreak = 0;
        this.useSuperFont = true;
        this.type = i;
    }

    public TextCell(int i, String str) {
        this.needHighLight = false;
        this.useDefaultFont = false;
        this.useHanyiColorFont = true;
        this.isBreak = false;
        this.linebreakSeq = 0;
        this.isPresseding = false;
        this.type = 0;
        this.canCopy = true;
        this.isDrawableLoaded = true;
        this.linebreak = 0;
        this.useSuperFont = true;
        this.type = i;
        this.text = str;
    }

    public void a(int i, int i2, int i3, int i4) {
        this.mShadowRadius = i;
        this.mShadowX = i2;
        this.mShadowY = i3;
        this.mShadowColor = i4;
    }

    public void a(float f) {
        this.fontSize = f;
    }

    public void b(int i) {
        this.linkColor = i;
    }

    public void c(boolean z) {
        this.canCopy = z;
    }

    public boolean i() {
        return this.canCopy;
    }

    public boolean c() {
        return false;
    }

    public boolean a() {
        int i = this.type & 255;
        return !(i == 0 || i == 16 || i == 7 || i == 8);
    }

    public boolean b() {
        return true;
    }

    public float a(Paint paint) {
        Typeface d = d(paint);
        if ((this.useDefaultFont || !this.useHanyiColorFont) && (paint instanceof ETPaint)) {
            paint = ((ETPaint) paint).a();
        }
        float measureText = paint.measureText(this.text);
        if (measureText <= 0.0f) {
            measureText = c(paint);
        }
        if (d != null) {
            paint.setTypeface(d);
        }
        return measureText;
    }

    protected float c(Paint paint) {
        float f = 0.0f;
        if (!TextUtils.isEmpty(this.text)) {
            Typeface d = d(paint);
            if ((this.useDefaultFont || !this.useHanyiColorFont) && (paint instanceof ETPaint)) {
                paint = ((ETPaint) paint).a();
            }
            int length = this.text.length();
            int i = 0;
            while (i < length) {
                int charCount = Character.charCount(this.text.codePointAt(i));
                float measureText = paint.measureText(this.text, i, i + charCount) + f;
                i += charCount;
                f = measureText;
            }
            if (d != null) {
                paint.setTypeface(d);
            }
        }
        return f;
    }

    public int e() {
        if (this.text != null) {
            return this.text.length();
        }
        return 0;
    }

    public int a(Paint paint, int i, int i2, float[] fArr) {
        int i3 = 0;
        if (!TextUtils.isEmpty(this.text)) {
            int i4 = i + i2;
            if (i4 > this.text.length()) {
                i4 = this.text.length();
            }
            if (i < i4) {
                Typeface d = d(paint);
                if ((this.useDefaultFont || !this.useHanyiColorFont) && (paint instanceof ETPaint)) {
                    paint = ((ETPaint) paint).a();
                }
                i3 = paint.getTextWidths(this.text, i, i4, fArr);
                if (d != null) {
                    paint.setTypeface(d);
                }
            }
        }
        return i3;
    }

    public int a(Paint paint, int i, int i2, float[] fArr, float[] fArr2) {
        return a(paint, i, i2, fArr);
    }

    public void a(Long l) {
        this.uin = l;
    }

    public void b(String str) {
        this.url = str;
    }

    public Long j() {
        return this.uin;
    }

    public int b(Paint paint) {
        return (int) (paint.descent() - paint.ascent());
    }

    public String k() {
        return this.url;
    }

    public String d() {
        if (this.text == null) {
            return "";
        }
        return this.text;
    }

    public void a(Canvas canvas, Paint paint, int i, Rect rect, int i2, int i3, Bitmap bitmap) {
        Paint a;
        float f;
        Shader shader;
        Typeface d = d(paint);
        if ((this.useDefaultFont || !this.useHanyiColorFont) && (paint instanceof ETPaint)) {
            a = ((ETPaint) paint).a();
        } else {
            a = paint;
        }
        if ((this.type & 255) == 0) {
            a.setColor(i2);
        } else {
            a.setColor(i3);
        }
        if (this.useSuperFont) {
            f = 0.0f;
            shader = null;
        } else {
            Shader shader2 = a.getShader();
            a.setShader(null);
            a.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
            float textSize = a.getTextSize();
            a.setTextSize(this.fontSize);
            f = textSize;
            shader = shader2;
        }
        int descent = rect.top + ((int) (((((float) i) - a.descent()) - a.ascent()) / 2.0f));
        String str = this.text;
        if (this.text.endsWith("\r\n")) {
            str = this.text.substring(0, this.text.length() - 2);
        } else if (this.text.endsWith(IOUtils.LINE_SEPARATOR_UNIX)) {
            str = this.text.substring(0, this.text.length() - 1);
        }
        if (FeedGlobalEnv.v().m()) {
            canvas.drawRect(rect, m());
        }
        if (a instanceof ETPaint) {
            ((ETPaint) a).a(str, i, (float) rect.left, (float) rect.top, canvas, bitmap);
        } else {
            canvas.drawText(str, (float) rect.left, (float) descent, a);
        }
        if (d != null) {
            a.setTypeface(d);
        }
        if (!this.useSuperFont) {
            a.setTextSize(f);
            a.setShader(shader);
            a.setShadowLayer((float) this.mShadowRadius, (float) this.mShadowX, (float) this.mShadowY, this.mShadowColor);
        }
    }

    public TextCell g() {
        try {
            return (TextCell) clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    public int l() {
        return this.type;
    }

    protected static Paint m() {
        if (sDebugPaint == null) {
            sDebugPaint = new Paint();
            sDebugPaint.setStyle(Paint.Style.STROKE);
            sDebugPaint.setColor(-6737203);
        }
        return sDebugPaint;
    }

    protected Typeface d(Paint paint) {
        Object obj;
        Typeface typeface;
        Paint paint2;
        if (this.useHanyiColorFont || !(paint instanceof ETPaint)) {
            obj = null;
            typeface = null;
            paint2 = paint;
        } else {
            paint = ((ETPaint) paint).a();
            Typeface typeface2 = paint.getTypeface();
            paint.setTypeface(null);
            typeface = typeface2;
            obj = 1;
            paint2 = paint;
        }
        if (!this.useDefaultFont) {
            return typeface;
        }
        if (paint2 instanceof ETPaint) {
            paint2 = ((ETPaint) paint2).a();
        }
        if (obj != null) {
            return typeface;
        }
        typeface = paint2.getTypeface();
        paint2.setTypeface(null);
        return typeface;
    }
}