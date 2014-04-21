package com.example.mix_music;

import com.example.Events.SelectVoiceListListener;
import com.example.Events.VolumeBarListener;
import com.example.tools.StaticValue;
import com.example.tools.VoiceFileList;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.io.File;
import java.util.ArrayList;

public class SelectVoiceActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_selectvoice);
		
		ArrayList<File> voiceFileList = VoiceFileList.getList(Environment.getExternalStorageDirectory().getPath()+StaticValue.VOICE_DIRECTORY);
		ArrayList<String> voiceNameList = new ArrayList<String>();
		for (File f : voiceFileList) {
			voiceNameList.add(f.getName());
		}
		
		ListView list = (ListView)findViewById(R.id.SelectVoiceList);
		list.setAdapter(new ArrayAdapter<String>(this, R.layout.listitem_selectvoice, voiceNameList));
		list.setOnItemClickListener(new SelectVoiceListListener(SelectVoiceActivity.this, voiceFileList));
		
		SharedPreferences sp = getSharedPreferences(StaticValue.VOICE_PREFERENCES, MODE_PRIVATE);
		int progress = sp.getInt(StaticValue.VOLUME_NAME + getIntent().getExtras().getInt("INDEX"), 100);
		
		TextView volumeText = (TextView)findViewById(R.id.TxtVolume);
		volumeText.setText(progress + "%");
		SeekBar volumeBar = (SeekBar)findViewById(R.id.Volume);
		volumeBar.setProgress(progress);
		volumeBar.setOnSeekBarChangeListener(new VolumeBarListener(this, volumeText));
	}

}
