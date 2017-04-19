package com.example.mylibrary.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.SparseArray;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.example.mylibrary.R;
import com.example.mylibrary.dialog.interfaces.DialogLayoutListener;


/**
 * Created by niewei on 2017/4/19.
 */

public class DialogHelper {
    public static final int DIALOG_NORMAL = 1;//普通
    public static final int DIALOG_BOTTOM_POP = 2;//底部弹出
    private static View content;

    /**
     * @param context
     * @param layout       布局文件
     * @param ifCancelAble 点击外部区域是否可消除
     * @param listener     回传布局，对应的控件行为从这里添加
     * @return
     */
    public static BaseDialog showWithLayout(Context context, int type, int layout, boolean ifCancelAble, DialogLayoutListener listener) {
        return initDialog(context, type, layout, ifCancelAble, listener);
    }


    private static BaseDialog initDialog(Context context, int type, int layout, boolean ifCancelAble, DialogLayoutListener listener) {
        BaseDialog mDialog;
        content = LayoutInflater.from(context).inflate(layout, null);
        mDialog = getDialogFromType(context, type);
        mDialog.setContentView(content);
        if (listener != null)
            listener.dialogLayout(content);
        mDialog.setCanceledOnTouchOutside(ifCancelAble);
        mDialog.setCancelable(ifCancelAble);
        try {
            if (mDialog.isShowing()) {
                mDialog.dismiss();
            }
            mDialog.show();
            switch (type) {
                case DIALOG_BOTTOM_POP:
                    setBottomStyle(mDialog);
                    break;
            }
        } catch (Exception e) {

        }
        return mDialog;
    }


    private static BaseDialog getDialogFromType(Context context, int type) {
        BaseDialog dialog = null;
        switch (type) {
            case DIALOG_NORMAL:
                dialog = new BaseDialog(context, R.style.Dialog_Transparent_Theme);
                break;
            case DIALOG_BOTTOM_POP:
                dialog = new BaseDialog(context, R.style.ActionSheetDialogStyle);
                break;
        }
        return dialog;
    }


    /**
     * 底部弹出样式
     */
    private static void setBottomStyle(Dialog mDialog) {
        Window window = mDialog.getWindow();
        window.setGravity(Gravity.BOTTOM);
        WindowManager.LayoutParams lp = window.getAttributes();
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        window.setAttributes(lp);
    }


}
