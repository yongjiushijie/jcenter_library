package com.ejjx.library.base;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

import com.ejjx.library.bean.BaseMsgEvent;
import com.ejjx.library.loading.LoadingDialog;
import com.ejjx.library.utils.SystemBarTintManager;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

/**
 * Created by wangchao on 2016/9/22.
 * bese class 页面传值 页面跳转
 */
public abstract class BaseAbsActivity extends AppCompatActivity {

    private Intent mIntent = null;
    private LoadingDialog mLoadingDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle extras = getIntent().getExtras();
        if (null != extras) {
            getExtraEvent(extras);
        }

        if (isBindEventBus()) {
            EventBus.getDefault().register(this);
        }
    }

    /**
     * 获取EventBus发送的信息
     *
     * @param baseMessageEvent
     */
    @Subscribe
    public void onEvent(BaseMsgEvent baseMessageEvent) {
    }

    /**
     * 获取页面传值
     */
    protected void getExtraEvent(Bundle extras) {
    }

    /**
     * 设置顶部颜色
     *
     * @return true ?透明:黑灰
     */
    protected abstract int getColor();

    /**
     * 是否设置systembar
     *
     * @return
     */
    protected abstract boolean isSetSystemBar();


    /**
     * is bind eventBus
     *
     * @return
     */
    protected abstract boolean isBindEventBus();

    /**
     * 启动页面跳转
     *
     * @param cls
     */
    public void startIntent(Class<?> cls) {
        this.startIntent(this, cls);
    }

    /**
     * 启动页面跳转
     *
     * @param cls
     */
    public void startIntent(Class<?> cls, Bundle bundle) {
        this.startIntent(this, cls, bundle);
    }

    /**
     * 启动页面跳转
     *
     * @param context
     * @param cls
     */
    public void startIntent(Context context, Class<?> cls) {
        this.startIntent(context, cls, null);
    }

    /**
     * 启动页面跳转
     *
     * @param context
     * @param cls
     * @param bundle
     */
    public void startIntent(Context context, Class<?> cls, Bundle bundle) {
        mIntent = new Intent(context, cls);
        if (bundle != null) {
            mIntent.putExtras(bundle);
        }
        context.startActivity(mIntent);
    }

    /**
     * toggle show loading
     *
     * @param
     */
    protected void toggleShowDialogLoading(String msg) {
        if (mLoadingDialog != null && mLoadingDialog.isShowing()) {
            return;
        }
        mLoadingDialog = new LoadingDialog.Builder(this).setMessage(msg).create();
        mLoadingDialog.setCancelable(true);
        mLoadingDialog.show();
    }


    protected void toggleDismissDialogLoading() {
        if (mLoadingDialog != null && mLoadingDialog.isShowing()) {
            mLoadingDialog.dismiss();
            mLoadingDialog = null;
        }
    }


    /**
     * 设置状态栏背景色彩
     *
     * @param color
     */
    protected void setupSystemBar(int color) {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.KITKAT) {
            Window window = getWindow();
            window.setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
        SystemBarTintManager tintManager = new SystemBarTintManager(this);
        tintManager.setStatusBarTintEnabled(true);
        tintManager.setNavigationBarTintEnabled(true);
        tintManager.setStatusBarTintResource(color);
    }

    @Override
    protected void onDestroy() {
        if (isBindEventBus()) {
            EventBus.getDefault().unregister(this);
        }
        if (mLoadingDialog != null && mLoadingDialog.isShowing()) {
            mLoadingDialog.dismiss();
            mLoadingDialog = null;
        }
        super.onDestroy();
    }
}
