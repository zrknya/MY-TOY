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
		if( event.getY() > this.getHeight() || event.getRawY() < this.getY()){//当手指延Y轴划出按钮范围松开时，跳过onclick，实现音乐持续播放
			return false;
		}
		if(event.getX() > this.getWidth() || event.getRawX() < this.getX()){//当手指延X轴划出按钮范围松开时，告诉onclick暂停播放
			ISPAUSE = true;
		}
		boolean b = super.onTouchEvent(event);
		return b;
	}
	
}
