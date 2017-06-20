package com.ejjx.library.listener;


import com.ejjx.library.bean.ErrorBean;

/**
 * author :Created by wangchao {wangchao@ejiajx.com}
 * date : 2017/5/12.
 */

public interface DataListener<T> {

    /**
     * url net is not block, and data is right
     *
     * @param data
     */
    void onSuccess(T data);

    /**
     * url net is not block, but data is error
     *
     * @param errorBean
     */
    void onError(ErrorBean errorBean);

    /**
     * url net is block
     *
     * @param msg
     */
    void onFailure(String msg);
}
