package com.ejjx.versions;

import android.os.Bundle;

import com.sk.library.base.BaseActivity;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void getExtraEvent(Bundle extras) {
        super.getExtraEvent(extras);
    }

    @Override
    protected int contentViewID() {
        return 0;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initialize() {

    }
}
