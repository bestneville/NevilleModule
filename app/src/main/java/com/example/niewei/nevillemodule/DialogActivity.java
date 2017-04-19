package com.example.niewei.nevillemodule;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.TextView;

import com.example.mylibrary.dialog.DialogHelper;
import com.example.mylibrary.dialog.interfaces.DialogLayoutListener;
import com.example.niewei.nevillemodule.utils.ToastTools;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DialogActivity extends FragmentActivity {

    @BindView(R.id.tv_with_layout1)
    TextView tvWithLayout1;
    @BindView(R.id.tv_with_layout2)
    TextView tvWithLayout2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
        ButterKnife.bind(this);
    }


    @OnClick(R.id.tv_with_layout1)
    public void onViewClicked1() {
        DialogHelper.showWithLayout(this, DialogHelper.DIALOG_NORMAL, R.layout.dialog_with1, true, new DialogLayoutListener() {
            @Override
            public void dialogLayout(View view) {
                TextView tv_commit = (TextView) view.findViewById(R.id.tv_commit);
                tv_commit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ToastTools.showToast("66666");
                    }
                });
            }
        });
    }


    @OnClick(R.id.tv_with_layout2)
    public void onViewClicked2() {
        DialogHelper.showWithLayout(this,DialogHelper.DIALOG_BOTTOM_POP,R.layout.dialog_with2,true,null);
    }
}
