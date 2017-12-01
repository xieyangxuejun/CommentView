package com.foretree.commentview.comment;

import android.app.Application;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.view.View;

import java.io.File;
import java.net.InetAddress;

public abstract class Ext {
    private static Application application = null;
    private static Context context = null;
    private static Ext g = null;

    public abstract boolean enableBitmapNativeAlloc();

    public abstract boolean fontInterceptorOnInterceptSetTextSize(View view, float f);

    public abstract Context getAppContext();

    public abstract InetAddress[] getBetterHostByName(String str, long j);

    public abstract String getBuilderNumber();

    public abstract long getCurUin();

    public abstract boolean getCurrentLoadingImgStatus();

    public abstract float getDensity();

    public abstract String getDeviceInfo();

    public abstract BitmapFactory.Options getOptions();

    public abstract String getPackageName();

    public abstract String getPackageNameForResource();

    public abstract String getPicPathFromContentURI(Uri uri);

    public abstract String getQUA();

    public abstract int getScreenHeight();

    public abstract int getScreenWidth();

    public abstract String getVersionName();

    public abstract void init();

    public abstract boolean is2G();

    public abstract boolean is3G();

    public abstract boolean isAvailable();

    public abstract boolean isEthernet();

    public abstract boolean isMobile();

    public abstract boolean isSafeMode();

    public abstract boolean isWap();

    public abstract boolean isWifi();

    public abstract boolean loadLibrary(String str);

    public abstract boolean packLogs(long j, File file, File file2);

    public abstract String readOperator();

    public abstract void reportToMM(String str, int i, String str2);

    public abstract void reportToMM(String str, int i, String str2, boolean z);

    public abstract void showAlertDialog(Context context, String str, String str2, String str3, View.OnClickListener onClickListener, String str4, View.OnClickListener onClickListener2);

    public static Ext g() {
        if (g != null) {
            return g;
        }
        throw new RuntimeException("Ext 没有初始化！！！");
    }

    public static void init(Application application, Ext ext) {
        context = application;
        application = application;
        g = ext;
        g.init();
    }

    public static Context getContext() {
        return context;
    }

    public static Application getApplication() {
        return application;
    }
}