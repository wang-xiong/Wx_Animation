package com.baidu.duer.dcs.wx_animation;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AccelerateInterpolator;
import android.widget.Button;
import android.widget.TextView;

public class AnimatorTestActivity extends Activity {
	private TextView textView;
	private Button button;
	private MyPointView myPointView;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.animator_activity_main);
		textView = (TextView) findViewById(R.id.tv);
		button = (Button) findViewById(R.id.btn);
		myPointView = (MyPointView) findViewById(R.id.my_point);
		button.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				//doValueAnimator();
				//doArgbAnimator();
				//doOfObjectAnimator();
				//myPointView.doPointAnim();
				//doPonitObjectAnimator();
				doOfPropertyValuesHolder();
			}
		});
	}

	protected void doPonitObjectAnimator() {
		ObjectAnimator animator = ObjectAnimator.ofInt(myPointView
				, "pointRadius", 0, 300, 100);
		animator.setDuration(2000);
		animator.start();
	}

	private void doValueAnimator() {
		//ValueAnimator animator = ValueAnimator.ofInt(0, 400);
		ValueAnimator animator = ValueAnimator.ofFloat(0.0f,400f,50f,300f);
		animator.setDuration(2000);
		animator.addUpdateListener(new AnimatorUpdateListener() {

			@Override
			public void onAnimationUpdate(ValueAnimator animation) {
				Float curValueFloat = (Float) animation.getAnimatedValue();
				int curValue = curValueFloat.intValue();
				textView.layout(curValue
						, curValue
						, curValue + textView.getWidth()
						, curValue + textView.getHeight());
			}
		});
		animator.start();
	}

	private void doArgbAnimator() {
		ValueAnimator animator = ValueAnimator.ofInt(0Xfffff00, 0Xff0000ff);
		animator.setEvaluator(new ArgbEvaluator());
		animator.setDuration(2000);
		animator.addUpdateListener(new AnimatorUpdateListener() {

			@Override
			public void onAnimationUpdate(ValueAnimator animation) {
				int curValue = (Integer) animation.getAnimatedValue();
				textView.setBackgroundColor(curValue);

			}
		});
		animator.start();
	}

	private void doOfObjectAnimator() {
		ValueAnimator animator = ValueAnimator.ofObject(new CharacterEvaluator()
				, new Character('A'), new Character('Z'));
		animator.setDuration(2000);
		animator.setInterpolator(new AccelerateInterpolator());
		animator.addUpdateListener(new AnimatorUpdateListener() {

			@Override
			public void onAnimationUpdate(ValueAnimator animation) {
				char text = (Character) animation.getAnimatedValue();
				textView.setText(String.valueOf(text));
			}
		});
		animator.start();
	}
	private class CharacterEvaluator implements TypeEvaluator<Character> {

		@Override
		public Character evaluate(float fraction, Character startValue,
								  Character endValue) {
			int startInt = (int) startValue;
			int endInt = (int) endValue;
			int curInt = (int) (startInt + fraction * (endInt - startInt));
			return (char) curInt;
		}

	}
	private void doOfPropertyValuesHolder() {
		PropertyValuesHolder rotationHolder = PropertyValuesHolder
				.ofFloat("Rotation",  60f, -60f, 40f, -40f, -20f, 20f, 10f, -10f, 0f);
		PropertyValuesHolder colorHolder = PropertyValuesHolder
				.ofInt("BackgroundColor", 0xffffffff, 0xffff00ff, 0xffffff00, 0xffffffff);
		ObjectAnimator animator = ObjectAnimator.ofPropertyValuesHolder(textView
				, rotationHolder, colorHolder);
		animator.setDuration(3000);
		animator.setInterpolator(new AccelerateInterpolator());
		animator.start();
	}
}
