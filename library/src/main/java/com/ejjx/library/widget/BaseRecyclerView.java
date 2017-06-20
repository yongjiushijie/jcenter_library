package com.ejjx.library.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

/**
 * recyclerivew
 * author :Created by wangchao {wangchao@ejiajx.com}
 * date : 2017/5/12.
 */
public class BaseRecyclerView extends RecyclerView {

    private int layoutMode;
    public static final int LIST = 1;
    public static final int GRID = 2;
    private LayoutManager layoutManager;

    public BaseRecyclerView(Context context) {
        super(context);
    }

    public BaseRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public BaseRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    /**
     * 设置RecyclerView 的 layout 模式
     *
     * @param layoutMode
     */

    /**
     * 设置 RecyclerView 的layout 模式
     *
     * @param layoutMode    选择当前layout 模式
     * @param orientation   recyclerView的方向
     * @param reverseLayout recyclerView 一个方向数值，当true，layout form end to start
     * @param spanCount     如果选择gradview形式的列表结构，需要提供显示的列，别的没有作用
     */
    public void setLayoutManager(int layoutMode, int orientation, boolean reverseLayout, int spanCount) {
        switch (layoutMode) {
            case LIST:
                layoutManager = new LinearLayoutManager(getContext(), orientation, reverseLayout);
                break;
            case GRID:
                layoutManager = new GridLayoutManager(getContext(), spanCount, orientation, reverseLayout);
                break;
        }
        setLayoutManager(layoutManager);
    }


}
