package com.example.jiayuanfa.androidpropertyanimationtest;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.animation.BounceInterpolator;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.tv_hello_world);

//        testValueAnimator();
//        testObjectAnimator();
//        testAnimatorSet();
        testViewPropertyAnimator();
    }

    /**
     * ValueAnimator
     */
    private void testValueAnimator() {
        ValueAnimator valueAnimator = ValueAnimator.ofFloat(0f,5f,3f,10f);
        valueAnimator.setDuration(5000);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float currentAnimationValue = (float)valueAnimator.getAnimatedValue();
                Log.d("TAG", "current value is " + currentAnimationValue);
            }
        });
        valueAnimator.start();
    }

    /**
     * ObjectAnimator
     */
    private void testObjectAnimator() {
        // 隐藏再显示
//        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(textView,"alpha",1f,0f,1f);

        // 360旋转
//        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(textView,"rotation",0f,360f);

        // 向左平移500单位 再回归原位
//        float currentTranslation = textView.getTranslationX();
//        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(textView,"translationX",currentTranslation,-500f,currentTranslation);

        // 在垂直方向上 放大三倍 再还原
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(textView,"scaleY",1f,3f,1f);
        objectAnimator.setDuration(5000);
        objectAnimator.start();
    }

    /**
     * AnimatorSet
     */
    private void testAnimatorSet() {
        // 动画从左边移入 然后旋转 然后淡入淡出
        ObjectAnimator moveIn = ObjectAnimator.ofFloat(textView, "translationX", -500f, 0f);
        ObjectAnimator rotate = ObjectAnimator.ofFloat(textView, "rotation", 0f, 360f);
        ObjectAnimator fadeInOut = ObjectAnimator.ofFloat(textView, "alpha", 1f, 0f, 1f);
        AnimatorSet animSet = new AnimatorSet();
        animSet.play(rotate).with(fadeInOut).after(moveIn);
        animSet.setDuration(5000);
        animSet.start();

        // 使用监听器 监听动画的执行过程
        animSet.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                Log.d("TAG","动画结束");
            }
        });
    }

    /**
     * 使用XML来实现动画
     */
    private void testXmlAnimation() {
        Animator animator = AnimatorInflater.loadAnimator(this,R.animator.animator_group);
        animator.setTarget(textView);
        animator.start();
    }

    /**
     * ViewPropertyAnimator
     */
    private void testViewPropertyAnimator() {
        // 使用ViewPropertyAnimator来实现动画
        textView.animate().alpha(0f);
        textView.animate().x(500).y(500).setDuration(5000).setInterpolator(new BounceInterpolator());
    }

}
