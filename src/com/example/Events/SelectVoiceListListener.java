package com.example.Events;

import java.io.File;
import java.util.ArrayList;

import com.example.tools.StaticValue;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

public class SelectVoiceListListener implements OnItemClickListener {

	private Activity activity;
	private ArrayList<File> voiceList;//装着音效的列表
	public SelectVoiceListListener(Activity a, ArrayList<File> l){
		activity = a;
		voiceList = l;
	}
	
	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		// TODO Auto-generated method stub
		Bundle bundle = activity.getIntent().getExtras();
		int index = bundle.getInt("INDEX");
		
		SharedPreferences sp = activity.getSharedPreferences(StaticValue.VOICE_PREFERENCES, activity.MODE_PRIVATE);
		SharedPreferences.Editor editor = sp.edit();
		editor.putString(StaticValue.VOICE_NAME + index , voiceList.get(arg2).getAbsolutePath());
		editor.putBoolean(StaticValue.VOICE_DEFAULT, false);
		editor.commit();
		
		activity.finish();
	}

}
