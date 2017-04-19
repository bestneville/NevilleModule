package com.example.niewei.nevillemodule.utils;

import android.view.Gravity;
import android.widget.Toast;

import com.example.niewei.nevillemodule.MyApplication;

public class ToastTools {
    public static Toast UPtoast;
    public static Toast mToast;
    public static int bottom_margin=150;
    /**
     * 显示吐司
     *
     * @param resId
     */
    public static void showToast(int resId) {
        try {
            if (mToast == null) {
                mToast = Toast.makeText(MyApplication.application, resId, Toast.LENGTH_LONG);
            } else {
                mToast.setText(resId);
            }
            mToast.setGravity(Gravity.BOTTOM, 0, bottom_margin);
            mToast.show();
        } catch (Exception e) {
        }
    }

    /**
     * 显示吐司
     *
     * @param content
     */
    public static void showToast(String content) {
        try {
            if (mToast == null) {
                mToast = Toast.makeText(MyApplication.application, content, Toast.LENGTH_LONG);
            } else {
                mToast.setText(content);
            }
            mToast.setGravity(Gravity.BOTTOM, 0, bottom_margin);
            mToast.show();
        } catch (Exception e) {
        }
    }

    public static void showToastCenter(String content) {
        try {
            if (mToast == null) {
                mToast = Toast.makeText(MyApplication.application, content, Toast.LENGTH_LONG);
            } else {
                mToast.setText(content);
            }
            mToast.setGravity(Gravity.CENTER, 0, 0);
            mToast.show();
        } catch (Exception e) {
        }
    }

    /**
     * 显示吐司
     *
     * @param content
     */
    public static void showToastLong(String content) {
        Toast.makeText(MyApplication.application, content, Toast.LENGTH_LONG).show();
    }
}
