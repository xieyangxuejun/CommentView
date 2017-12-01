package com.foretree.commentview.comment;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextUtils;
import android.util.SparseArray;

import java.lang.ref.SoftReference;

public class ETPaint extends Paint {
    private static SoftReference<SparseArray<Bitmap>> d = null;
    private static int[] e;
    private static Canvas f = null;
    private ETFont a;
    private Paint b;
    private FontMetrics c;

    public ETPaint() {
        this(0);
    }

    public ETPaint(int i) {
        super(i);
        this.a = new ETFont(0, null, 0.0f);
    }

    public Paint a() {
        return this.b;
    }

    public void setTextSize(float f) {
        super.setTextSize(f);
        this.a.setSize(f);
        if (this.b != null) {
            this.b.setTextSize(f);
        }
//        this.c = ETSpace.a().a(this.a);
    }

    public void setColor(int i) {
        super.setColor(i);
        this.a.setColor(i);
        if (this.b != null) {
            this.b.setColor(i);
        }
    }

    public void setFakeBoldText(boolean z) {
        super.setFakeBoldText(z);
        if (this.b != null) {
            this.b.setFakeBoldText(z);
        }
        this.a.setBold(z);
//        this.c = ETSpace.a().a(this.a);
    }

    public String b() {
        return this.a.getPath();
    }

    public void a(int i, String str, Paint paint) {
        this.a.setId(i);
        this.a.setPath(str);
        if (this.b == null) {
            this.b = paint;
        }
        a(paint);
        if (c()) {
//            ETSpace.a().a(3, 1048576);
//            if (!ETSpace.a().b().native_isFontLoaded(i)) {
//                ETSpace.a().b().native_loadFont(str, i, true);
//            }
//            this.c = ETSpace.a().a(this.a);
        }
    }

    private void a(Paint paint) {
        setTextSize(paint.getTextSize());
        setColor(paint.getColor());
        setFakeBoldText(paint.isFakeBoldText());
    }

    public int getTextWidths(String str, int i, int i2, float[] fArr) {
        if (!c()) {
            return super.getTextWidths(str, i, i2, fArr);
        }
        if (str == null) {
            throw new IllegalArgumentException("text cannot be null");
        } else if ((((i | i2) | (i2 - i)) | (str.length() - i2)) < 0) {
            throw new IndexOutOfBoundsException();
        } else if (i2 - i > fArr.length) {
            throw new ArrayIndexOutOfBoundsException();
        } else if (str.length() == 0 || i == i2) {
            return 0;
        } else {
//            return ETSpace.a().a(str, i, i2, this.a, this.b, fArr);
            return 0;
        }
    }

    public float measureText(String str) {
        return measureText(str, 0, str.length());
    }

    public float measureText(String str, int i, int i2) {
        if (!c()) {
            return super.measureText(str, i, i2);
        }
        if (str == null) {
            throw new IllegalArgumentException("text cannot be null");
        } else if ((((i | i2) | (i2 - i)) | (str.length() - i2)) < 0) {
            throw new IndexOutOfBoundsException();
        } else if (str.length() == 0 || i == i2) {
            return 0.0f;
        } else {
//            return ETSpace.a().a(str, i, i2, this.a, this.b);
            return 0;
        }
    }

    private boolean c() {
        return !TextUtils.isEmpty(this.a.getPath());
    }

    public void a(String str, int i, float f, float f2, Canvas canvas, Bitmap bitmap) {
//        if (bitmap == null) {
//            Bitmap a = a(i);
//            if (a == null || ETSpace.a().b() == null) {
//                canvas.drawText(str, f, f2 - ascent(), this.b);
//                return;
//            }
//            if (f == null) {
//                f = new Canvas();
//            }
//            f.setBitmap(a);
//            ETSpace.a().b().native_spaceDrawText(str, f, a, 0, 0, this.a, this.b);
//            int width = a.getWidth();
//            int height = a.getHeight();
//            int i2 = width * height;
//            if (e == null || e.length < i2) {
//                try {
//                    e = new int[i2];
//                } catch (OutOfMemoryError e) {
//                    e.printStackTrace();
//                    canvas.drawText(str, f, f2 - ascent(), this.b);
//                    return;
//                }
//            }
//            a.getPixels(e, 0, width, 0, 0, width, height);
//            canvas.drawBitmap(e, 0, width, f, f2, width, height, true, this.b);
//        } else if (ETSpace.a().b() == null || !d()) {
//            canvas.drawText(str, f, f2 - ascent(), this.b);
//        } else {
//            ETSpace.a().b().native_spaceDrawText(str, canvas, bitmap, (int) f, (int) f2, this.a, this.b);
//        }
    }

    private boolean d() {
        if (this.a == null || TextUtils.isEmpty(this.a.mFontPath)) {
            return false;
        }
        return false;
//        return !ETSpace.a().b().native_isFontLoaded(this.a.mFontId) ? ETSpace.a().b().native_loadFont(this.a.mFontPath, this.a.mFontId, true) : true;
    }

    private static synchronized Bitmap a(int i) {
        Bitmap bitmap;
        synchronized (ETPaint.class) {
            SparseArray sparseArray;
            if (d == null) {
                d = new SoftReference(new SparseArray(5));
            }
            SparseArray sparseArray2 = (SparseArray) d.get();
            if (sparseArray2 == null) {
                sparseArray2 = new SparseArray(5);
                d = new SoftReference(sparseArray2);
                sparseArray = sparseArray2;
            } else {
                sparseArray = sparseArray2;
            }
            bitmap = (Bitmap) sparseArray.get(i);
            if (bitmap == null) {
                try {
                    bitmap = Bitmap.createBitmap(ViewUtils.getScreenWidth(), i, Bitmap.Config.ARGB_8888);
                    sparseArray.put(i, bitmap);
                } catch (OutOfMemoryError e) {
                    e.printStackTrace();
                    bitmap = null;
                }
            }
            bitmap.eraseColor(0);
        }
        return bitmap;
    }

    public float descent() {
        if (!c() || this.c == null) {
            return super.descent();
        }
        return this.c.descent;
    }

    public float ascent() {
        if (!c() || this.c == null) {
            return super.ascent();
        }
        return this.c.ascent;
    }

    public FontMetrics getFontMetrics() {
        if (this.c == null) {
            return super.getFontMetrics();
        }
        return this.c;
    }
}