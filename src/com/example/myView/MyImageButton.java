package com.example.myView;

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
		super.onTouchEvent(event);
		return false;
	}
	
}
