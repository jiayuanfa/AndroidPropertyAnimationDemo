package com.example.jiayuanfa.androidpropertyanimationtest;

import android.animation.TimeInterpolator;

/**
 * Created by JiaYuanFa on 2017/8/24.
 *
 */

public class DecelerateAccelerateInterpolator implements TimeInterpolator {

    @Override
    public float getInterpolation(float input) {
        float result;
        if (input <= 0.5) {
            // 正弦函数实现一个减速的值
            result = (float) (Math.sin(Math.PI * input)) / 2;
        } else {
            // 然后余弦函数实现一个减速的值
            result = (float) (2 - Math.sin(Math.PI * input)) / 2;
        }
        return result;
    }

}


