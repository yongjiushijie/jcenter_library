package com.ejjx.library.listener;

/**
 * author :Created by wangchao {wangchao@ejiajx.com}
 * date : 2017/5/12.
 * ListView ,gridview ,recyclerver  item click
 */

public interface PositionListener<T> {
    public abstract void onPosition(T t, int type);
}
