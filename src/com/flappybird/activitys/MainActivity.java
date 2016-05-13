package com.flappybird.activitys;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.flappybird.config.Config;
import com.flappybird.util.SoundPlayer;
import com.flappybird.view.LoadingView;
import com.flappybird.view.MainView;


public class MainActivity extends Activity {
	
	private LoadingView loadingView; //��Ϸ��ʼ����
	private SoundPlayer soundPlayer; //���ֲ�����
	private MainView mainview; //��Ϸ������
	
	private Handler handler = new Handler(){
		@Override
		public void handleMessage(Message msg){
			if(msg.what == Config.TO_MAIN_VIEW){
				toMainView();
			}
		}
	};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.soundPlayer = new SoundPlayer(this);
		this.soundPlayer.initSounds();
		this.loadingView = new LoadingView(MainActivity.this, soundPlayer);
        setContentView(loadingView);
    	
    }
	/**
	 **���������mainViewʵ���򴴽��µ�ʵ����������Ϊnull�����Ҵ���mainViewʵ��
	 **ͬʱsetContentViewΪmainView��loadingView��Ϊnull
	 */
	protected void toMainView() {
		if(this.mainview == null){
			this.mainview = new MainView(this,soundPlayer);
		}else{
			this.mainview =null;
			this.mainview = new MainView(this,soundPlayer);
		}
		this.setContentView(this.mainview);
		this.loadingView = null;
	}
	public Handler getHandler() {
		return this.handler;
	}
}
