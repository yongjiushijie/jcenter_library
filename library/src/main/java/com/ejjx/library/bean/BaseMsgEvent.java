package com.ejjx.library.bean;

/**
 * 发送消息时间
 * author :Created by wangchao {wangchao@ejiajx.com}
 * date : 2017/7/11.
 */

public class BaseMsgEvent<T> {

    private T bean;
    private int eventCode;

    public BaseMsgEvent(T bean) {
        this.bean = bean;
    }

    public BaseMsgEvent(T bean, int eventCode) {
        this.bean = bean;
        this.eventCode = eventCode;
    }

    public T getBean() {
        return bean;
    }

    public int getEventCode() {
        return eventCode;
    }
}
