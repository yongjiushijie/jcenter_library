package com.ejjx.library.loading.indicator;


import android.animation.ValueAnimator;

/**
 * author :Created by wangchao {wangchao@ejiajx.com}
 * date : 2017/5/12.
 */
public class LineScalePulseOutRapidIndicator extends LineScaleIndicator {

    @Override
    public void createAnimation() {
        long[] delays=new long[]{400,200,0,200,400};
        for (int i = 0; i < 5; i++) {
            final int index=i;
            ValueAnimator scaleAnim=ValueAnimator.ofFloat(1,0.4f,1);
            scaleAnim.setDuration(1000);
            scaleAnim.setRepeatCount(-1);
            scaleAnim.setStartDelay(delays[i]);
            scaleAnim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    scaleYFloats[index] = (float) animation.getAnimatedValue();
                    postInvalidate();
                }
            });
            scaleAnim.start();
        }
    }

}
