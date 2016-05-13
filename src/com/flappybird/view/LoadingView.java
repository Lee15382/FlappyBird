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
 * @author Lee *����������
 */
public class LoadingView extends BaseView {

	private Bitmap bgImg; // ����
	private Bitmap logoImg;// logo
	private Bitmap textImg; // �ı�ͼƬ

	private float logoImgX;
	private float logoImgY;
	private float textImgX;
	private float textImgY;


	private Rect rect;// ��ʾ����ϵ�е�һ���������

	// ��������Ŀ�ȼ��߶�
	private float strWidth;
	private float strHeight;

	private float textX;
	private float textY;

	/**
	 * *���캯��
	 * 
	 * @param context
	 *            ��ǰActivity��������
	 * @param soundPlayer
	 *            ���빹���SoundPlayerʵ��
	 */
	public LoadingView(Context context, SoundPlayer soundPlayer) {
		super(context, soundPlayer);
		rect = new Rect();
		this.thread = new Thread(this); // �滭�߳�
	}

	@Override
	public void surfaceCreated(SurfaceHolder arg0) {
		super.surfaceCreated(arg0);
		initBitmap();
		// ���滭�߳�
		if (this.thread.isAlive()) {
			this.thread.start();
		} else {
			this.thread = new Thread(this);
			this.thread.start();
		}
	}

	@Override
	public void initBitmap() {
		// ���õ�ǰ�������桢logo��textLogo
		this.bgImg = BitmapFactory
				.decodeResource(getResources(), R.drawable.bg);
		this.logoImg = BitmapFactory.decodeResource(getResources(),
				R.drawable.logo);
		this.textImg = BitmapFactory.decodeResource(getResources(),
				R.drawable.text_logo);
		// ������Ƭ���ű���
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

	// ��ͼ����
	@Override
	public void drawSelf() {
		try {
			canvas = sfh.lockCanvas(); // @L ���canvas�Ĵ�С������canvas
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
	 * ��Surface���ݻ�ǰ�����surfaceDestroyed�������ú��������ú�Ͳ��ܼ���ʹ��Surface�ˣ�һ���ڸú�����������ʹ�õ���Դ��
	 */

	@Override
	public void surfaceDestroyed(SurfaceHolder arg0) {
		super.surfaceDestroyed(arg0);
		release();
	}

	// �ͷ�ͼƬ��Դ
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
