package com.example.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;

import com.example.activitys.MainActivity;
import com.example.config.Constants;
import com.example.util.SoundPlayer;

public class BaseView extends SurfaceView implements Callback, Runnable {

	protected float scaleX;//背景图片缩放比例
	protected float scaleY;
	
	protected MainActivity mainActivity;
	protected SoundPlayer soundPlayer;
	
	protected Canvas canvas;//画布对象
	protected Paint paint;//画笔对象
	protected SurfaceHolder sfh;
	
	protected Thread thread;//绘画线程
	protected boolean threadFlag;//标记线程运行
	
	//构造函数
	public BaseView(Context context, SoundPlayer soundPlayer) {
		super(context);
		this.mainActivity = (MainActivity) context;
		this.soundPlayer = soundPlayer;
		this.sfh = this.getHolder();
		this.sfh.addCallback(this);
		this.paint = new Paint();
	}

	//线程运行的方法
	@Override
	public void run() {}
	
	//初始化图片资源
	public void initBitmap() {}
	
	//释放图片资源
	public void release() {}
	
	//绘图方法
	public void drawSelf() {}

	//视图改变的方法
	@Override
	public void surfaceChanged(SurfaceHolder arg0, int arg1, int arg2, int arg3) {}

	//视图创建的方法
	@Override
	public void surfaceCreated(SurfaceHolder arg0) {
		Constants.SCREEN_WIDTH= this.getWidth();//L此处以当前屏幕宽度获得屏幕宽度
		Constants.SCREEN_HEIGHT = this.getHeight();//L屏幕高度此处以当前屏幕高度获得屏幕高度
		this.threadFlag = true; //标记线程运行
	}

	//视图销毁的方法
	@Override
	public void surfaceDestroyed(SurfaceHolder arg0) {
		this.threadFlag = false;
	}
	
	public void setThreadFlag(boolean threadFlag) {
		this.threadFlag = threadFlag;
	}

}
