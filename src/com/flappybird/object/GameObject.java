/**
 * 
 */
package com.flappybird.object;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * @author Lee
 * *游戏中各种动画对象的继承类，集成的类有 Bird、GameObject、Ground
 */
public abstract class GameObject {
	
	protected int currentFrame; //当前动画帧
	
	protected float obj_x; //对象左上角坐标
	protected float obj_y;
	
	protected float obj_mid_x;//对象中心横坐标
	protected float obj_mid_y;//对象中心纵坐标
	
	protected float obj_width;//对象宽度
	protected float obj_height;//对象高度
	
	protected Resources resource; //图片资源对象
	protected Paint paint; //画笔对象
	
	public GameObject(Resources resources){
		this.resource = resources;
		this.paint = new Paint();
	}
	
	//对象运动逻辑
	public abstract void step();
	
	//绘图方法
	public abstract void drawSelf(Canvas canvas);
	
	//初始胡图片资源
	public abstract void initBitmap();
	
	//释放图片资源
	public abstract void release();
	
	//构建obj_x\obj_y\obj_mid_x\obj_mid_y\obj_width\obj_height
	//的set、get方法

	/**
	 * @return the obj_x
	 */
	public float getObj_x() {
		return obj_x;
	}

	/**
	 * @param obj_x the obj_x to set
	 */
	public void setObj_x(float obj_x) {
		this.obj_x = obj_x;
	}

	/**
	 * @return the obj_y
	 */
	public float getObj_y() {
		return obj_y;
	}

	/**
	 * @param obj_y the obj_y to set
	 */
	public void setObj_y(float obj_y) {
		this.obj_y = obj_y;
	}

	/**
	 * @return the obj_mid_x
	 */
	public float getObj_mid_x() {
		return obj_mid_x;
	}

	/**
	 * @param obj_mid_x the obj_mid_x to set
	 */
	public void setObj_mid_x(float obj_mid_x) {
		this.obj_mid_x = obj_mid_x;
	}

	/**
	 * @return the obg_mid_y
	 */
	public float getObg_mid_y() {
		return obj_mid_y;
	}

	/**
	 * @param obg_mid_y the obg_mid_y to set
	 */
	public void setObg_mid_y(float obg_mid_y) {
		this.obj_mid_y = obg_mid_y;
	}

	/**
	 * @return the obj_width
	 */
	public float getObj_width() {
		return obj_width;
	}

	/**
	 * @param obj_width the obj_width to set
	 */
	public void setObj_width(float obj_width) {
		this.obj_width = obj_width;
	}

	/**
	 * @return the obj_height
	 */
	public float getObj_height() {
		return obj_height;
	}

	/**
	 * @param obj_height the obj_height to set
	 */
	public void setObj_height(float obj_height) {
		this.obj_height = obj_height;
	}

	
	
	
	

}
