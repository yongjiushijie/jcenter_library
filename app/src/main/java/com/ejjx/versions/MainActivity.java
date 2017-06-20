package com.ejjx.versions;

import android.os.Bundle;

import com.ejjx.library.base.BaseActivity;
import com.ejjx.library.bean.ErrorBean;


public class MainActivity extends BaseActivity {

    @Override
    protected void getExtraEvent(Bundle extras) {
        super.getExtraEvent(extras);
    }

    @Override
    protected int getColor() {
        return 0;
    }

    @Override
    protected boolean isSetSystemBar() {
        return false;
    }

    @Override
    protected boolean isBindEventBus() {
        return false;
    }

    @Override
    protected int contentViewID() {
        return R.layout.activity_main;
    }

    @Override
    protected void initialize() {

    }

    @Override
    public void onError(ErrorBean errorBean) {

    }

    @Override
    public void onFailure(String errorMsg) {

    }
}
