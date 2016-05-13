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
	
	private LoadingView loadingView; //游戏初始窗口
	private SoundPlayer soundPlayer; //音乐播放器
	private MainView mainview; //游戏主窗口
	
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
	 **如果不存在mainView实例则创建新的实例，否则置为null，并且创建mainView实例
	 **同时setContentView为mainView、loadingView置为null
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
