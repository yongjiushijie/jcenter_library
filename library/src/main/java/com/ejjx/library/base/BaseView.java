package com.ejjx.library.base;


import com.ejjx.library.bean.ErrorBean;

/**
 * Created by wangchao on 2017/5/16.
 */

public interface BaseView {

    /**
     * data error
     *
     * @param errorBean
     */
    void onError(ErrorBean errorBean);

    /**
     * service fail
     *
     * @param errorMsg
     */
    void onFailure(String errorMsg);

    /**
     * dialog loading
     */
    void showDialog(String msg);

    /**
     * dismiss  dialog loading
     */
    void dismissDialog();
}
