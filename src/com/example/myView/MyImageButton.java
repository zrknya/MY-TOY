package com.example.myView;

import android.R.bool;
import android.content.Context;
import android.view.MotionEvent;
import android.widget.ImageButton;

public class MyImageButton extends ImageButton {
	
	public boolean ISPAUSE = false;

	public MyImageButton(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		if( event.getY() > this.getHeight() || event.getRawY() < this.getY()){//����ָ��Y�Ữ����ť��Χ�ɿ�ʱ������onclick��ʵ�����ֳ�������
			return false;
		}
		if(event.getX() > this.getWidth() || event.getRawX() < this.getX()){//����ָ��X�Ữ����ť��Χ�ɿ�ʱ������onclick��ͣ����
			ISPAUSE = true;
		}
		boolean b = super.onTouchEvent(event);
		return b;
	}
	
}
