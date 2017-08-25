package com.example.jiayuanfa.androidpropertyanimationtest;

import android.animation.TypeEvaluator;

/**
 * Created by JiaYuanFa on 2017/8/24.
 */

public class PointEvaluator implements TypeEvaluator {

    /**
     * 通过两个Point点 来计算当前Point点的值
     * @param fraction
     * @param startValue
     * @param endValue
     * @return
     */
    @Override
    public Object evaluate(float fraction, Object startValue, Object endValue) {
        Point startPoint = (Point) startValue;
        Point endPoint = (Point) endValue;
        float x = startPoint.getX() + fraction * (endPoint.getX() - startPoint.getX());
        float y = startPoint.getY() + fraction * (endPoint.getY() - startPoint.getY());
        Point point = new Point(x, y);
        return point;
    }

}
