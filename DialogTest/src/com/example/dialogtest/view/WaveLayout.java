package com.example.dialogtest.view;

import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.Animator.AnimatorListener;
import com.nineoldandroids.animation.ValueAnimator;
import com.nineoldandroids.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;

public class WaveLayout extends FrameLayout {
	private Paint paint;
	private float maxRadius;
	private float radius = 5;// ��寰�
	private int waveColor = Color.parseColor("#ffeeeeee");//娉㈢汗��棰���
	public WaveLayout(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init();
	}
	public WaveLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}
	public WaveLayout(Context context) {
		super(context);
		init();
	}
	private void init() {
		setWillNotDraw(false);
		paint = new Paint(Paint.ANTI_ALIAS_FLAG);
		paint.setColor(waveColor);
		paint.setStyle(Style.FILL_AND_STROKE);
	}
	/**
	 * 璁剧疆娉㈢汗��棰���
	 * @param waveColor
	 */
	public void setWaveColor(int waveColor){
		this.waveColor = waveColor;
		paint.setColor(waveColor);
	}

	@Override
	protected void onSizeChanged(int w, int h, int oldw, int oldh) {
		super.onSizeChanged(w, h, oldw, oldh);
		int width = getMeasuredWidth();
		int height = getMeasuredHeight();
		// ��澶у��寰�璁惧��涓哄�硅�绾跨���垮害锛�瀹介����骞虫�癸��跺��寮��瑰��
		maxRadius = (float) Math.sqrt(Math.pow(width, 2) + Math.pow(height, 2));
	}
	/**
	 * 褰�������姝ｅ�ㄧ��舵尝绾�
	 * @return
	 */
	public boolean isDrawingWave(){
		return drawAnimCount!=0;
	}
	/**
	 * 娓��ゆ按娉㈢汗
	 */
	public void clearWave(){
		if(valueAnimator!=null){
			valueAnimator.end();
		}
	}

	private float centerX, centerY;
	private boolean drawWave = false;
	private int drawAnimCount = 0;
	private ValueAnimator valueAnimator;
	@Override
	public boolean onInterceptTouchEvent(MotionEvent ev) {
		switch (ev.getAction()) {
		case MotionEvent.ACTION_DOWN:
			if(drawAnimCount!=0)break;
			drawWave = true;
			
			centerX = ev.getX();
			centerY = ev.getY();

			valueAnimator = ValueAnimator.ofFloat(radius,
					maxRadius);
			valueAnimator.addUpdateListener(new AnimatorUpdateListener() {
				@Override
				public void onAnimationUpdate(ValueAnimator animator) {
					float animatedValue = (Float) animator.getAnimatedValue();
					radius = animatedValue;
					postInvalidate();
				}
			});
			valueAnimator.setDuration(1000);
			valueAnimator.addListener(new DrawWaveAnimListener());
			valueAnimator.start();
			break;
		}
		return super.onInterceptTouchEvent(ev);
	}
	

	@Override
	protected void onDraw(final Canvas canvas) {
		if (isInEditMode() || !drawWave) {
			return;
		}
//		Log.e("tag", "radius: "+radius);
		canvas.drawCircle(centerX, centerY, radius, paint);
	}
	
	class DrawWaveAnimListener implements AnimatorListener{
		@Override
		public void onAnimationCancel(Animator arg0) {
		}
		@Override
		public void onAnimationEnd(Animator arg0) {
			drawWave = false;
			radius = 5;			
			drawAnimCount--;
		}
		@Override
		public void onAnimationRepeat(Animator arg0) {
		}
		@Override
		public void onAnimationStart(Animator arg0) {
			drawAnimCount++;
		}
	}

}
