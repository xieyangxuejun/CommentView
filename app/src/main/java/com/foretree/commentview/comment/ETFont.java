package com.foretree.commentview.comment;

import android.graphics.Typeface;

public class ETFont {
    public static final int ENCODE_TIMEOUT_AND_DISCONNECTED = -129;
    public static final int ET_COLOR_BLACK = -16777216;
    public static final int ET_FONT_STYLE_BOLD = 1;
    public static final int ET_FONT_STYLE_CROCHET = 8;
    public static final int ET_FONT_STYLE_SHADOW = 128;
    private int mCrochetColor;
    private int mCrochetWidth;
    private boolean mDisableBackground = false;
    private boolean mDisableCrochet = true;
    private boolean mDisableShadow = true;
    public int mFontColor;
    public int mFontId;
    public String mFontPath;
    private int mFontSize;
    private final int mFontSizeMin = 8;
    private int mFontStyle;
    public int mFontType;
    private int mShadowBlurRadius;
    private int mShadowColor;
    private int mShadowOffsetX;
    private int mShadowOffsetY;
    public Typeface mTypeface;

    public ETFont(int i, String str, float f) {
        this.mFontId = i;
        this.mFontPath = str;
        setSize(f);
        this.mFontColor = -16777216;
        this.mFontStyle = 0;
    }

    public ETFont(int i, String str, float f, int i2, Typeface typeface) {
        this.mFontId = i;
        this.mFontPath = str;
        setSize(f);
        this.mFontColor = -16777216;
        this.mFontStyle = 0;
        this.mFontType = i2;
        this.mTypeface = typeface;
    }

    public void setId(int i) {
        this.mFontId = i;
    }

    public int getId() {
        return this.mFontId;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        ETFont eTFont = (ETFont) obj;
        if (this.mFontId == eTFont.mFontId && this.mFontColor == eTFont.mFontColor && this.mFontSize == eTFont.mFontSize && this.mFontStyle == eTFont.mFontStyle) {
            return true;
        }
        return false;
    }

    public void setBold(boolean z) {
        if (true == z) {
            this.mFontStyle |= 1;
        } else {
            this.mFontStyle &= -2;
        }
    }

    public boolean isBold() {
        if ((this.mFontStyle & 1) == 0) {
            return false;
        }
        return true;
    }

    public void setPath(String str) {
        this.mFontPath = str;
    }

    public String getPath() {
        return this.mFontPath;
    }

    public void setSize(float f) {
        int i = 8;
        int i2 = (int) f;
        if (i2 >= 8) {
            i = i2;
        }
        this.mFontSize = i;
    }

    public int getSize() {
        return this.mFontSize;
    }

    public void setColor(int i) {
        this.mFontColor = i;
    }

    public int getColor() {
        return this.mFontColor;
    }

    public void setShadow(boolean z, int i, int i2, int i3, int i4) {
        if (z) {
            this.mShadowColor = i;
            this.mShadowOffsetX = i2;
            this.mShadowOffsetY = i3;
            this.mShadowBlurRadius = i4;
            this.mFontStyle |= 128;
            return;
        }
        this.mFontStyle &= ENCODE_TIMEOUT_AND_DISCONNECTED;
    }

    public void setCrochet(boolean z, int i, int i2) {
        if (z) {
            this.mCrochetColor = i;
            this.mCrochetWidth = i2;
            this.mFontStyle |= 8;
            return;
        }
        this.mFontStyle &= -9;
    }

    public void disableEffects(boolean z, boolean z2, boolean z3) {
        this.mDisableBackground = z;
        this.mDisableShadow = z2;
        this.mDisableCrochet = z3;
    }

    public void copy(ETFont eTFont) {
        if (eTFont != null) {
            this.mFontId = eTFont.mFontId;
            this.mFontPath = eTFont.mFontPath;
            this.mFontSize = eTFont.mFontSize;
            this.mFontColor = eTFont.mFontColor;
            this.mFontStyle = eTFont.mFontStyle;
            this.mShadowColor = eTFont.mShadowColor;
            this.mShadowOffsetX = eTFont.mShadowOffsetX;
            this.mShadowOffsetY = eTFont.mShadowOffsetY;
            this.mShadowBlurRadius = eTFont.mShadowBlurRadius;
            this.mCrochetColor = eTFont.mCrochetColor;
            this.mCrochetWidth = eTFont.mCrochetWidth;
            this.mDisableBackground = eTFont.mDisableBackground;
            this.mDisableShadow = eTFont.mDisableShadow;
            this.mDisableCrochet = eTFont.mDisableCrochet;
        }
    }
}