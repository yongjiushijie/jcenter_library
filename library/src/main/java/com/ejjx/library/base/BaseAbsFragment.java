package com.ejjx.library.base;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ejjx.library.bean.BaseMsgEvent;
import com.ejjx.library.loading.LoadingDialog;
import com.umeng.analytics.MobclickAgent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.lang.reflect.Field;

import butterknife.ButterKnife;

/**
 * Fragment  基类
 * Created by wangchao on 2017/5/16.
 */

public abstract class BaseAbsFragment extends Fragment implements BaseView {

    private Intent mIntent = null;
    private LoadingDialog mLoadingDialog;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (isBindEventBus()) {
            EventBus.getDefault().register(this);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (getContentViewID() != 0) {
            return inflater.inflate(getContentViewID(), null);
        } else {
            return super.onCreateView(inflater, container, savedInstanceState);
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        MobclickAgent.onResume(getActivity());
    }

    /**
     * 获取EventBus发送的信息
     *
     * @param baseMessageEvent
     */
    @Subscribe
    public void onEvent(BaseMsgEvent baseMessageEvent) {
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        initialize();
    }


    /**
     * set layout xml
     *
     * @return
     */
    protected abstract int getContentViewID();

    /**
     * init object
     */
    protected abstract void initialize();


    /**
     * 是否绑定EventBus
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
        this.startIntent(getActivity(), cls);
    }

    /**
     * 启动页面跳转
     *
     * @param cls
     */
    public void startIntent(Class<?> cls, Bundle bundle) {
        this.startIntent(getActivity(), cls, bundle);
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


    @Override
    public void onDetach() {
        super.onDetach();
        try {
            Field childFragmentManager = Fragment.class.getDeclaredField("mChildFragmentManager");
            childFragmentManager.setAccessible(true);
            childFragmentManager.set(this, null);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void showDialog(String msg) {
        toggleShowDialogLoading(msg);
    }

    @Override
    public void dismissDialog() {
        toggleDismissDialogLoading();
    }

    /**
     * toggle show loading
     *
     * @param
     */
    protected void toggleShowDialogLoading(String msg) {
        mLoadingDialog = new LoadingDialog.Builder(getActivity()).setMessage(msg).create();
        mLoadingDialog.show();
    }


    protected void toggleDismissDialogLoading() {
        if (mLoadingDialog != null && mLoadingDialog.isShowing()) {
            mLoadingDialog.dismiss();
            mLoadingDialog = null;
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        MobclickAgent.onPause(getActivity());
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (isBindEventBus()) {
            EventBus.getDefault().unregister(this);
        }
    }
}
