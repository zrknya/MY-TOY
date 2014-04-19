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
		{//当手指划出按钮范围松开时，跳过onclick，实现音乐持续播放
			return false;
		}
		boolean b = super.onTouchEvent(event);
		return b;
	}
	
}
