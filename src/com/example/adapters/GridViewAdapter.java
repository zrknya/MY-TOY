package com.example.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageButton;

import com.example.Events.*;

import com.example.mix_music.R;
import com.example.myView.MyImageButton;
import com.example.tools.StaticValue;

public class GridViewAdapter extends BaseAdapter {

	private Context context;
	public GridViewAdapter(Context c){
		context = c;
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return StaticValue.GRIDVIEW_AMOUNT;
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	@Override
	public View getView(int arg0, View arg1, ViewGroup arg2) {
		// TODO Auto-generated method stub
		MyImageButton button = new MyImageButton(context);
		int position = arg0;

		ButtonListener buttonListener = new ButtonListener(context, position);	
		button.setBackgroundResource(R.drawable.play_button);
		button.setLayoutParams(new GridView.LayoutParams(LayoutParams.MATCH_PARENT, arg2.getWidth()/3-13));
		//button.setPadding(100, 100, 100, 100);
		button.setFocusable(true);
		button.setOnTouchListener(buttonListener);
		
		return button;
	}

}
