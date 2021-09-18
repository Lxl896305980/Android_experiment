package com.example.mypropertyanimation;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ValueAnimator valueAnimator = ValueAnimator.ofFloat(0f, 1f);
        valueAnimator.setDuration(6000);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float value = (float) valueAnimator.getAnimatedValue();
                Log.e("ACE","onAnimationUpdate: " + value);
            }
        });
        valueAnimator.start();

        TextView textView = findViewById(R.id.tv);

//        //透明度
//        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(textView,
//                "alpha",0f,1f);

//        //旋转
//        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(textView,
//                "rotation",0,360);
//        //左上角坐标为（0,0），以下为绝对坐标，中心旋转为默认不写
//        textView.setPivotX(50);
//        textView.setPivotY(50);

        //缩放、透明度渐变、平移、旋转集合
        final AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(

                ObjectAnimator.ofFloat(textView, "scaleX", 0, 5)
                        .setDuration(6000),
                ObjectAnimator.ofFloat(textView, "scaleY", 0, 5)
                        .setDuration(6000),
                ObjectAnimator.ofFloat(textView,"alpha",0,1)
                        .setDuration(6000),
                ObjectAnimator.ofFloat(textView,"translationX",0,50)
                        .setDuration(6000),
                ObjectAnimator.ofFloat(textView,"translationY",0,50)
                        .setDuration(6000),
                ObjectAnimator.ofFloat(textView,"rotation",0,360)
                        .setDuration(6000)

        );
        animatorSet.start();


//        objectAnimator.setDuration(6000);
//        objectAnimator.start();
//
//        objectAnimator.addListener(new Animator.AnimatorListener() {
//            //动画开始时调用
//            @Override
//            public void onAnimationStart(Animator animator) {
//
//            }
//
//            //动画结束时调用
//            @Override
//            public void onAnimationEnd(Animator animator) {
//
//            }
//
//            //动画取消时调用
//            @Override
//            public void onAnimationCancel(Animator animator) {
//
//            }
//
//            //动画重复时调用
//            @Override
//            public void onAnimationRepeat(Animator animator) {
//
//            }
//        });
//
//        objectAnimator.addListener(new AnimatorListenerAdapter() {
//            @Override
//            public void onAnimationStart(Animator animation) {
//                super.onAnimationStart(animation);
//            }
//        });

        animatorSet.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {

            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });

        animatorSet.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationResume(Animator animation) {
                super.onAnimationResume(animation);
            }
        });

    }
}