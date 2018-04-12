package com.baidu.duer.dcs.wx_animation;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;

public class    MainActivity extends Activity {
    /**
     * 在Android动画中，总共有两种类型的动画:
     * 		View Animation(视图动画)和Property Animator(属性动画)；
     * View Animation包括
     * 		Tween Animation（补间动画）和Frame Animation(逐帧动画)；
     * Property Animator包括
     * 		ValueAnimator和ObjectAnimation；
     * 首先，直观上，他们有如下三点不同：
     * 1、引入时间不同：View Animation是API Level 1就引入的。
     * 		Property Animation是API Level 11引入的，即Android 3.0才开始有Property Animation相关的API。
     * 2、所在包名不同：View Animation在包android.view.animation中。而Property Animation API在包 android.animation中。
     * 3、动画类的命名不同：View Animation中动画类取名都叫XXXXAnimation,而在Property Animator中动画类的取名则叫XXXXAnimator
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ImageView imageView = (ImageView) findViewById(R.id.image_view);

        //一、静态xml生成
        final Animation animation = AnimationUtils.loadAnimation(this, R.anim.set1);
		/*二、动态生成动画和插值器
		 * 1.ScaleAnimation
		 */
        final ScaleAnimation scaleAnimation = new ScaleAnimation
                (0.0f, 1.4f, 0.0f, 1.4f
                        , Animation.RELATIVE_TO_SELF, 0.5f
                        , Animation.RELATIVE_TO_SELF, 0.5f);
        scaleAnimation.setDuration(800);

        final AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);

        final RotateAnimation rotateAnimation = new RotateAnimation(0, 720
                , Animation.RELATIVE_TO_SELF, 0.5f
                , Animation.RELATIVE_TO_SELF, 0.5f);

        final TranslateAnimation translateAnimation = new TranslateAnimation(Animation.ABSOLUTE, 0
                , Animation.ABSOLUTE, -80
                , Animation.ABSOLUTE, 0
                , Animation.ABSOLUTE, -80);

        final AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation(alphaAnimation);
        animationSet.addAnimation(scaleAnimation);
        animationSet.addAnimation(rotateAnimation);
        animationSet.setDuration(2000);
        animationSet.setFillAfter(true);
        animationSet.setInterpolator(new AccelerateDecelerateInterpolator());

        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                //imageView.startAnimation(animation);
                //imageView.startAnimation(scaleAnimation);
                imageView.startAnimation(animationSet);
            }
        });
    }

}