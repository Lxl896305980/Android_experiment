package com.example.mypropertyanimation;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
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

        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(textView,
                "translation",0,100);

        textView.setTranslationX(0);
        textView.setTranslationY(0);

        objectAnimator.setDuration(6000);
        objectAnimator.start();

        objectAnimator.addListener(new Animator.AnimatorListener() {
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

        objectAnimator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationStart(Animator animation) {
                super.onAnimationStart(animation);
            }
        });

    }
}