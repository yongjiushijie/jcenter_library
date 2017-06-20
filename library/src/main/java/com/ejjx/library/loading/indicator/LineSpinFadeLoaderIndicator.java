package com.ejjx.library.loading.indicator;


import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

/**
 * author :Created by wangchao {wangchao@ejiajx.com}
 * date : 2017/5/12.
 */
public class LineSpinFadeLoaderIndicator extends BallSpinFadeLoaderIndicator {


    @Override
    public void draw(Canvas canvas, Paint paint) {
        float radius=getWidth()/10;
        for (int i = 0; i < 8; i++) {
            canvas.save();
            Point point=circleAt(getWidth(),getHeight(),getWidth()/2.5f-radius,i*(Math.PI/4));
            canvas.translate(point.x, point.y);
            canvas.scale(scaleFloats[i], scaleFloats[i]);
            canvas.rotate(i*45);
            paint.setAlpha(alphas[i]);
            RectF rectF=new RectF(-radius,-radius/1.5f,1.5f*radius,radius/1.5f);
            /*RectF rectF=new RectF(0,0,2*radius,1f*radius);*/
            canvas.drawRoundRect(rectF,5,5,paint);
            canvas.restore();
        }
    }

}
