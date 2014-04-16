package com.example.justTest;

import com.example.mix_music.R;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class TestActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_test);
		
		SharedPreferences sp = getSharedPreferences("testSP", MODE_PRIVATE);
		SharedPreferences.Editor edt= sp.edit();
		edt.putString("HW", "hello world");
		edt.commit();
		
		TextView text1 = (TextView)findViewById(R.id.textView1);
		text1.setText(sp.getString("HW", ""));
	}

}
