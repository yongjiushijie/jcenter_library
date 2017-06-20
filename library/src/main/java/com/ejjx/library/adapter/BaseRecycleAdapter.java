package com.ejjx.library.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;

import com.ejjx.library.listener.PositionListener;

import java.util.ArrayList;


/**
 * author: wangchao {wangchao@ejiajx.com}
 * date:on 2017/5/12
 * Recyclerview  adapter
 */
public abstract class BaseRecycleAdapter<T, E extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<E> {
    protected Context mContext;
    protected LayoutInflater layoutInflater;
    protected ArrayList<T> mDataSource = new ArrayList<>();
    protected PositionListener positionListener;

    public BaseRecycleAdapter(Context context) {
        this.mContext = context;
        layoutInflater = layoutInflater.from(context);
    }

    /**
     * 设置item点击接口
     *
     * @param positionListener
     */
    public void setListener(PositionListener positionListener) {
        this.positionListener = positionListener;
    }

    /**
     * 更新数据
     *
     * @param itemDatas
     * @param isClear   是否刷新
     */
    public void update(ArrayList itemDatas, boolean isClear) {
        if (isClear)
            this.mDataSource.clear();
        if (itemDatas != null && !itemDatas.isEmpty()) {
            this.mDataSource.addAll(itemDatas);
        }
        notifyDataSetChanged();
    }

    /**
     * 删除item
     *
     * @param position item 所在位置
     */
    public void updateRemove(int position) {
        mDataSource.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, getItemCount());
    }

    @Override
    public int getItemCount() {
        return mDataSource.size();
    }
}