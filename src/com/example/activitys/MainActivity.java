package com.example.activitys;

import android.app.Activity;
import android.os.Bundle;

import com.example.util.SoundPlayer;
import com.example.view.LoadingView;


public class MainActivity extends Activity {
	
	private LoadingView loadingView;
	private SoundPlayer soundPlayer;
	
//	private Handler handler = new Handler(){
//		public void handMessage(Message msg){
//			
//		}
//	};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.soundPlayer = new SoundPlayer(this);
		this.soundPlayer.initSounds();
		this.loadingView = new LoadingView(this, soundPlayer);
        setContentView(loadingView);
    	
    }
//	public Handler getHandler() {
//		return this.handler;
//	}
}
