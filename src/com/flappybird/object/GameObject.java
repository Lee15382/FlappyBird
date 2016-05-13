/**
 * 
 */
package com.flappybird.object;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * @author Lee
 * *��Ϸ�и��ֶ�������ļ̳��࣬���ɵ����� Bird��GameObject��Ground
 */
public abstract class GameObject {
	
	protected int currentFrame; //��ǰ����֡
	
	protected float obj_x; //�������Ͻ�����
	protected float obj_y;
	
	protected float obj_mid_x;//�������ĺ�����
	protected float obj_mid_y;//��������������
	
	protected float obj_width;//������
	protected float obj_height;//����߶�
	
	protected Resources resource; //ͼƬ��Դ����
	protected Paint paint; //���ʶ���
	
	public GameObject(Resources resources){
		this.resource = resources;
		this.paint = new Paint();
	}
	
	//�����˶��߼�
	public abstract void step();
	
	//��ͼ����
	public abstract void drawSelf(Canvas canvas);
	
	//��ʼ��ͼƬ��Դ
	public abstract void initBitmap();
	
	//�ͷ�ͼƬ��Դ
	public abstract void release();
	
	//����obj_x\obj_y\obj_mid_x\obj_mid_y\obj_width\obj_height
	//��set��get����

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
