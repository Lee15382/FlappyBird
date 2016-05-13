/**
 * 
 */
package com.flappybird.util;

import java.util.HashMap;

import android.media.AudioManager;
import android.media.SoundPool;

import com.example.flappybird.R;
import com.flappybird.activitys.MainActivity;

/**
 * @author Lee
 *播放器控制音频文�?
 */
public class SoundPlayer {
	
	private SoundPool soundPool; //使用SoundPool控制�?短的音频文件
	private MainActivity mainActivity;
	private HashMap<Integer,Integer> map;
	
	public SoundPlayer(MainActivity mainActivity){
		this.mainActivity = mainActivity;
		map = new HashMap<Integer, Integer>();
		/*
		 * maxStream�?8—�?? 同时播放的流的最大数量�?
		 *streamType：AudioManager.STREAM_MUSIC —�?? 流的类型，一般为STREAM_MUSIC(具体在AudioManager类中列出) 
		 *srcQuality:0 —�?? 采样率转化质量，当前无效果，使用0作为默认值�?
		 */
		soundPool = new SoundPool(8,AudioManager.STREAM_MUSIC, 0);
	}
	
	public void initSounds(){
		//load方法加载指定音频文件,并返回所加载的音频ID．此处使用HashMap来管理这些音频流 
		map.put(1, soundPool.load(mainActivity, R.raw.flappy,1)); //飞扬
		map.put(2, soundPool.load(mainActivity, R.raw.pass,1));   //通过管子
		map.put(3, soundPool.load(mainActivity, R.raw.hit,1)); 	  //撞击
		map.put(4, soundPool.load(mainActivity, R.raw.die,1));	  //死亡
		map.put(5,soundPool.load(mainActivity, R.raw.swooshing,1)); //切换
	}
	
	public void palySound(int sound,int loop){
		/*
		 * int soundID, float leftVolume, float rightVolume, int priority, int loop, float rate
		 * 	leftVolume和rightVolume表示左右音量
		 * priority表示优先�?,loop表示循环次数,rate表示速率速率�?�?0.5�?高为2�?1代表正常速度 
		 */
		soundPool.play(sound,1, 1, 1, loop, 1.0f);
	}
}




