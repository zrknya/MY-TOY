package com.example.Events;

import com.example.tools.StaticValue;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

public class VolumeBarListener implements OnSeekBarChangeListener {
	
	private TextView textView;
	private Activity activity;
	
	public VolumeBarListener(Activity c, TextView t)
	{
		textView = t;
		activity = c;
	}

	@Override
	public void onProgressChanged(SeekBar arg0, int arg1, boolean arg2) {
		// TODO Auto-generated method stub
		textView.setText(arg1 + "%");
	}

	@Override
	public void onStartTrackingTouch(SeekBar arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStopTrackingTouch(SeekBar arg0) {
		// TODO Auto-generated method stub
		Bundle bundle = activity.getIntent().getExtras();
		int index = bundle.getInt("INDEX");
		
		SharedPreferences sp = activity.getSharedPreferences(StaticValue.VOICE_PREFERENCES, activity.MODE_PRIVATE);
		SharedPreferences.Editor editor = sp.edit();
		editor.putInt(StaticValue.VOLUME_NAME + index, arg0.getProgress());
		editor.commit();
	}

}
