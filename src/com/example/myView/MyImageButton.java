package com.example.myView;

import android.R.bool;
import android.content.Context;
import android.view.MotionEvent;
import android.widget.ImageButton;

public class MyImageButton extends ImageButton {

	public MyImageButton(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		if(event.getX() > this.getWidth() || event.getY() > this.getHeight()
			|| event.getRawX() < this.getX() || event.getRawY() < this.getY())
		{//����ָ������ť��Χ�ɿ�ʱ������onclick��ʵ�����ֳ�������
			return false;
		}
		boolean b = super.onTouchEvent(event);
		return b;
	}
	
}
