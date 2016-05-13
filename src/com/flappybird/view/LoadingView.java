/**
 * 
 */
package com.flappybird.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.os.Message;
import android.view.SurfaceHolder;

import com.example.flappybird.R;
import com.flappybird.config.Config;
import com.flappybird.config.Constants;
import com.flappybird.util.SoundPlayer;

/**
 * @author Lee *构建主界面
 */
public class LoadingView extends BaseView {

	private Bitmap bgImg; // 背景
	private Bitmap logoImg;// logo
	private Bitmap textImg; // 文本图片

	private float logoImgX;
	private float logoImgY;
	private float textImgX;
	private float textImgY;


	private Rect rect;// 表示坐标系中的一块矩形区域

	// 矩形区域的宽度及高度
	private float strWidth;
	private float strHeight;

	private float textX;
	private float textY;

	/**
	 * *构造函数
	 * 
	 * @param context
	 *            当前Activity的上下文
	 * @param soundPlayer
	 *            传入构造的SoundPlayer实例
	 */
	public LoadingView(Context context, SoundPlayer soundPlayer) {
		super(context, soundPlayer);
		rect = new Rect();
		this.thread = new Thread(this); // 绘画线程
	}

	@Override
	public void surfaceCreated(SurfaceHolder arg0) {
		super.surfaceCreated(arg0);
		initBitmap();
		// 检查绘画线程
		if (this.thread.isAlive()) {
			this.thread.start();
		} else {
			this.thread = new Thread(this);
			this.thread.start();
		}
	}

	@Override
	public void initBitmap() {
		// 设置当前背景界面、logo、textLogo
		this.bgImg = BitmapFactory
				.decodeResource(getResources(), R.drawable.bg);
		this.logoImg = BitmapFactory.decodeResource(getResources(),
				R.drawable.logo);
		this.textImg = BitmapFactory.decodeResource(getResources(),
				R.drawable.text_logo);
		// 背景退片缩放比例
		this.scaleX = Constants.SCREEN_WIDTH / this.bgImg.getWidth();
		this.scaleY = Constants.SCREEN_HEIGHT / this.bgImg.getHeight();

		this.textImgX = (Constants.SCREEN_WIDTH - this.textImg.getWidth()) / 2;
		this.textImgY = Constants.SCREEN_HEIGHT / 2 - this.textImg.getHeight()
				* 2;

		this.logoImgX = (Constants.SCREEN_WIDTH - this.logoImg.getWidth()) / 2;
		this.logoImgY = Constants.SCREEN_HEIGHT / 2 - this.logoImg.getWidth()
				* 0;
	}
	
	@Override
	public void run(){
		while (this.threadFlag){
			drawSelf();
			try {
				Thread.sleep(Config.LOADING_GAME_INTERVAL);
			} catch (Exception e) {
				e.printStackTrace();
			}
			this.threadFlag = false;
		}
		mainActivity.getHandler().sendEmptyMessage(Config.TO_MAIN_VIEW);
		System.out.println("yy");
	}

	// 绘图方法
	@Override
	public void drawSelf() {
		try {
			canvas = sfh.lockCanvas(); // @L 获得canvas的大小并锁定canvas
			canvas.save();
			canvas.scale(this.scaleX, this.scaleY);
			canvas.drawBitmap(bgImg, 0, 0, paint);
			canvas.restore();
			canvas.drawBitmap(textImg, textImgX, textImgY, paint);
			canvas.drawBitmap(logoImg, logoImgX, logoImgY, paint);
		} catch (Exception err) {
			err.printStackTrace();
		} finally {
			if (canvas != null) {
				sfh.unlockCanvasAndPost(canvas);
			}
		}
	}

	/*
	 * 当Surface被摧毁前会调用surfaceDestroyed函数，该函数被调用后就不能继续使用Surface了，一般在该函数中来清理使用的资源。
	 */

	@Override
	public void surfaceDestroyed(SurfaceHolder arg0) {
		super.surfaceDestroyed(arg0);
		release();
	}

	// 释放图片资源
	@Override
	public void release() {
		if (!this.bgImg.isRecycled()) {
			this.bgImg.recycle();
		}
		if (!this.logoImg.isRecycled()) {
			this.logoImg.recycle();
		}
		if (!this.textImg.isRecycled()) {
			this.textImg.recycle();
		}
	}
}
