package com.example.niewei.nevillemodule.utils;


import android.content.Context;
import android.util.Log;




public class UncaughtException implements Thread.UncaughtExceptionHandler {


    private Context context;

    public UncaughtException(Context context) {
        this.context = context;
    }

    @Override
    public void uncaughtException(Thread thread, Throwable throwable) {
        Log.i("i", "------>" + Log.getStackTraceString(throwable));

    }
}
