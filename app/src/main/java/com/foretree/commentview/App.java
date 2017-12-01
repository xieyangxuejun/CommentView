package com.foretree.commentview;

import android.app.Application;
import android.content.Context;

/**
 * Created by silen on 30/11/2017.
 */

public class App extends Application {
    public static Context mContext;
    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
    }

    public static Context getContext() {
        return mContext;
    }
}
