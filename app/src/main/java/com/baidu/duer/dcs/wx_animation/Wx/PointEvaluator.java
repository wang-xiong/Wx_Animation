package com.baidu.duer.dcs.wx_animation.Wx;

import android.animation.TypeEvaluator;

/**
 * Created by wx on 2016/9/15.
 */
public class PointEvaluator implements TypeEvaluator {

    @Override
    public Object evaluate(float fraction, Object startValue, Object endValue) {
        Point startPoit = (Point) startValue;
        Point endPoint = (Point) endValue;
        float x = startPoit.getX() + fraction*(endPoint.getX() - startPoit.getX());
        float y = startPoit.getY() + fraction*(endPoint.getY() - startPoit.getY());
        Point point = new Point(x, y);
        return point;
    }
}
