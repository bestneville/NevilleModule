package com.example.niewei.nevillemodule;

import android.app.Application;
import android.content.Context;

import com.example.niewei.nevillemodule.utils.UncaughtException;

/**
 * Created by mxb on 2016/1/7.
 */
public class MyApplication extends Application {

    public static MyApplication application;
    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
        mContext = getApplicationContext();
        Thread.setDefaultUncaughtExceptionHandler(new UncaughtException(this));
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }

    public static Context getContext() {
        return mContext;
    }

}
