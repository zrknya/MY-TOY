package com.example.adapters;

import java.io.File;
import java.util.ArrayList;

import com.example.Events.SetVoiceButtonListener;
import com.example.tools.StaticValue;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;

import com.example.mix_music.R;

public class SetVoiceGridViewAdapter extends BaseAdapter {

	private Context context;
	public SetVoiceGridViewAdapter(Context c){
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
		return null;
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int arg0, View arg1, ViewGroup arg2) {
		// TODO Auto-generated method stub
		SetVoiceButtonListener buttonListener = new SetVoiceButtonListener(context, arg0);
		
		SharedPreferences sp = context.getSharedPreferences(StaticValue.VOICE_PREFERENCES, context.MODE_PRIVATE);
		String[] voiceName = sp.getString(StaticValue.VOICE_NAME + arg0, "").split("/");
		
		Button button = new Button(context);
		button.setTextColor(0xffadadad);
		button.setBackgroundResource(R.drawable.set_button);
		button.setText(voiceName[voiceName.length-1] == "" ? "Î´Ñ¡Ôñ" : voiceName[voiceName.length-1]);
		button.setPadding(100, 100, 100, 100);
		button.setHeight(arg2.getWidth()/3-13);
		button.setClickable(true);
		button.setOnClickListener(buttonListener);
		
		return button;
	}

}
