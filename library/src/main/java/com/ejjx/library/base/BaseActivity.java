package com.ejjx.library.base;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;

import com.umeng.analytics.MobclickAgent;

import butterknife.ButterKnife;


/**
 * Created by wangchao on 2017/5/16.
 * 绑定Butternife
 */
public abstract class BaseActivity extends BaseAbsActivity implements BaseView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(this.contentViewID());

        ButterKnife.bind(this);
        setStatusBar();
        initialize();
    }

    @Override
    protected void onResume() {
        super.onResume();
        MobclickAgent.onResume(this);
    }

    /**
     * Activity 关联布局文件
     *
     * @return
     */
    protected abstract int contentViewID();

    /**
     * 对象初始化，方法调用
     */
    protected abstract void initialize();


    @Override
    public void showDialog(String msg) {
        toggleShowDialogLoading(msg);
    }

    @Override
    public void dismissDialog() {
        toggleDismissDialogLoading();
    }

    /**
     * isn't  status bar transparent
     * true?transparent : toolbar color
     */
    private void setStatusBar() {
        if (isSetSystemBar()) {
            if (getColor() == 0) {
                setupSystemBar(Color.TRANSPARENT);
            } else {
                setupSystemBar(getColor());
            }
        }
    }

    @Override
    public Resources getResources() {
        Resources res = super.getResources();
        Configuration config = new Configuration();
        config.setToDefaults();
        res.updateConfiguration(config, res.getDisplayMetrics());
        return res;
    }


    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    public void finish() {
        super.finish();
    }

    public void onPause() {
        super.onPause();
        MobclickAgent.onPause(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
