package com.ejjx.library.widget;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * 处理滑动冲突
 * author: wangchao {wangchao@ejiajx.com}
 * date:on 2017/6/5
 */

public class BaseCoordinatorLayout extends CoordinatorLayout {

    private float xDistance, yDistance, lastX, lastY;

    public BaseCoordinatorLayout(Context context) {
        super(context);
    }

    public BaseCoordinatorLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BaseCoordinatorLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
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
