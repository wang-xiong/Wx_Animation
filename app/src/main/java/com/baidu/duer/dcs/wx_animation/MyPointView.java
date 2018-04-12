package com.baidu.duer.dcs.wx_animation;

import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.DecelerateInterpolator;

public class MyPointView extends View {
	//private MyPoint mPoint;
	private MyPoint mPoint = new MyPoint(100);
	public MyPointView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		if(mPoint != null) {
			Paint paint = new Paint();
			paint.setAntiAlias(true);
			paint.setColor(Color.RED);
			paint.setStyle(Style.FILL);
			canvas.drawCircle(300, 300, mPoint.getRadius(), paint);
		}
	}
	
	public void doPointAnim() {
		ValueAnimator animator = ValueAnimator.ofObject(new PointEvaluator()
				, new MyPoint(20), new MyPoint(200));
		animator.addUpdateListener(new AnimatorUpdateListener() {
			
			@Override
			public void onAnimationUpdate(ValueAnimator animation) {
				mPoint = (MyPoint) animation.getAnimatedValue();
				invalidate();
			}
		});
		animator.setDuration(2000);
		animator.setInterpolator(new DecelerateInterpolator());
		animator.start();
	}
	
	private class PointEvaluator implements TypeEvaluator<MyPoint> {

		@Override
		public MyPoint evaluate(float fraction, MyPoint startValue,
				MyPoint endValue) {
			int start = startValue.getRadius();
			int end = endValue.getRadius();
			int curInt = (int) (start + fraction * (end - start));
			return new MyPoint(curInt);
		}	
	}
	
	public void setPointRadius(int radius) {
		if(mPoint != null) {
			mPoint.setRadius(radius);
			invalidate();
		}
	}
}
