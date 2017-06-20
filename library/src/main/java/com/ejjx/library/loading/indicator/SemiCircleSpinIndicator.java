package com.ejjx.library.loading.indicator;


import android.animation.ObjectAnimator;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;


/**
 * author :Created by wangchao {wangchao@ejiajx.com}
 * date : 2017/5/12.
 */
public class SemiCircleSpinIndicator extends BaseIndicatorController {


    @Override
    public void draw(Canvas canvas, Paint paint) {
        RectF rectF=new RectF(0,0,getWidth(),getHeight());
        canvas.drawArc(rectF,-60,120,false,paint);
    }

    @Override
    public void createAnimation() {
        ObjectAnimator rotateAnim=ObjectAnimator.ofFloat(getTarget(),"rotation",0,180,360);
        rotateAnim.setDuration(600);
        rotateAnim.setRepeatCount(-1);
        rotateAnim.start();
    }

    @Override
    public void stopAnimation() {

    }


}
