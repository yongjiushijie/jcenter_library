package com.ejjx.library.widget;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * author :Created by wangchao {wangchao@ejiajx.com}
 * date : 2017/5/12.
 */

public class BaseSwipeLayout extends SwipeRefreshLayout {

    private float xDistance, yDistance, lastX, lastY;

    public BaseSwipeLayout(Context context) {
        super(context);
        initLayout();
    }

    public BaseSwipeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        initLayout();
    }

    private void initLayout() {
        setColorSchemeColors(Color.BLUE, Color.YELLOW, Color.RED);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                xDistance = yDistance = 0f;
                lastX = ev.getX();
                lastY = ev.getY();
                break;
            case MotionEvent.ACTION_MOVE:
                final float curX = ev.getX();
                final float curY = ev.getY();
                xDistance += Math.abs(curX - lastX);
                yDistance += Math.abs(curY - lastY);
                lastX = curX;
                lastY = curY;
                if (xDistance > yDistance)
                    return false;
        }

        return super.onInterceptTouchEvent(ev);
    }
}
