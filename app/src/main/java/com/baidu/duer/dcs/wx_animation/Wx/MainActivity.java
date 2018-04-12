package com.baidu.duer.dcs.wx_animation.Wx;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.widget.Button;
import android.widget.TextView;

import com.baidu.duer.dcs.wx_animation.R;

/**
 * android动画：1逐帧动画(frame-by-frame animation)
 *              2补间动画(tweened animation)：只能对View进行移动、缩放、旋转和淡入淡出
 *              3.属性动画(property animation)：Android3.0开始
 *  属性动画的核心类：ValueAnimator
 *                    ObjectAnimator
 *  1.Animator监听器:AnimatorListener接口；AnimatorListenerAdapter适配器继承了AnimatorListener
 *  2.利用XML方式实现
 *  ValueAnimator中，自定义实现接口TypeEvaluator
 *  Interpolator的用法:
 *  ViewPropertyAnimator:
 *
 *
 *LayoutInflater的作用：内部是利用pull解析
 *每一个视图的绘制分为三个阶段：onMeasure(), onLayout(), onDraw()
 *自定义View分为三种：
 * 自绘控件:重写onDraw()方法，见MyView1
 * 组合控件：例如TitleView
 * 继承控件: 例如MyListView
 *
 *
 */

public class MainActivity extends Activity {
    private Button test_button;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_wx);
        test_button = (Button) findViewById(R.id.test_button);
        textView = (TextView) findViewById(R.id.textView);
      /*  ValueAnimator animator = ValueAnimator.ofFloat(0f, 1f);
        animator.setDuration(2000);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float currentValue = (float) animation.getAnimatedValue();
                Log.d("TAG", "current value is " + currentValue);
            }
        });
        animator.start();*/
        test_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /* ObjectAnimator alpha = ObjectAnimator.ofFloat(textView, "alpha", 1f, 0f, 1f);
                ObjectAnimator rotate = ObjectAnimator.ofFloat(textView, "rotation", 0f, 360f);
                ObjectAnimator move = ObjectAnimator.ofFloat(textView, "translationX", -500f, 0f);
                AnimatorSet animationSet = new AnimatorSet();
                animationSet.play(rotate).with(alpha).after(move);
                animationSet.setDuration(5000);
                animationSet.start();
                 alpha.addListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {

                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {

                    }
                });
                alpha.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationCancel(Animator animation) {
                        super.onAnimationCancel(animation);
                    }
                });*/
               /* Animator animator = AnimatorInflater.loadAnimator(MainActivity.this,R.animator.anim);
                animator.setTarget(textView);
                animator.start();*/
                textView.animate().x(500).y(500).setDuration(2000).setInterpolator(new BounceInterpolator());
            }
        });


    }
}
