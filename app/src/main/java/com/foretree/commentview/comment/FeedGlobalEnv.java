package com.foretree.commentview.comment;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.Log;
import android.view.View;

import java.util.concurrent.ExecutorService;

public abstract class FeedGlobalEnv {
    public static boolean c;
    static FeedGlobalEnv d;
    static Context e;
    static Application f;
    static int g;
    static int h;

    public static class EmoWindow {
    }

    public static class PhotoMode {
    }

    public abstract float a(float f);

    public abstract int a(int i);

    public abstract SharedPreferences a(Context context, long j);

    public abstract Bitmap a(Drawable drawable);

    public abstract Handler a();

    public abstract void a(int i, Context context, CharSequence charSequence);

    public abstract void a(View view);

    public abstract void a(Runnable runnable);

    public abstract void a(String str);

    public abstract void a(String str, long j);

    public abstract void a(String str, View view);

    public abstract boolean a(Context context);

    public abstract boolean a(Context context, String str);

    public abstract byte[] a(JceStruct jceStruct);

    public abstract int b();

    public abstract int b(int i);

    public abstract void b(Runnable runnable);

    public abstract float c();

    public abstract Drawable c(int i);

    public abstract void c(Runnable runnable);

    public abstract float d();

    public abstract int d(int i);

    public abstract void d(Runnable runnable);

    public abstract int e();

    public abstract void e(Runnable runnable);

    public abstract int f();

    public abstract void f(Runnable runnable);

    public abstract void g();

    public abstract boolean h();

    public abstract boolean i();

    public abstract void j();

    public abstract boolean k();

    public abstract boolean l();

    public abstract boolean m();

    public abstract boolean n();

    public abstract Handler o();

    public abstract ExecutorService p();

    public abstract int q();

    public abstract boolean r();

    public abstract boolean s();

    public abstract double t();

    public abstract String u();

    public static FeedGlobalEnv v() {
        if (d == null) {
        }
        if (d != null) {
            return d;
        }
        throw new RuntimeException("FeedGlobalEnv does not init");
    }

    public static void a(Context context, Application application, FeedGlobalEnv feedGlobalEnv, Log log) {
        d = feedGlobalEnv;
        e = context;
        f = application;
    }

    public static boolean w() {
        int i = g;
        g++;
        if (i < 0 || i >= h) {
            return false;
        }
        return true;
    }

    public static boolean x() {
        if (g < 0 || g >= h) {
            return false;
        }
        return true;
    }

    public static Context y() {
        if (e == null) {
        }
        return e;
    }

    public static Application z() {
        if (f == null) {
        }
        return f;
    }
}