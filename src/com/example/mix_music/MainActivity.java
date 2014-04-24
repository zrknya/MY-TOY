package com.example.mix_music;

import java.io.File;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Environment;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.Toast;
import android.view.GestureDetector.SimpleOnGestureListener;

import com.example.adapters.GridViewAdapter;
import com.example.myView.MyGridView;
import com.example.tools.StaticValue;

public class MainActivity extends Activity {
	
	private GestureDetector detector;
	private boolean LOCKJUMP = false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		
		File file = new File(Environment.getExternalStorageDirectory().getPath()+StaticValue.VOICE_DIRECTORY);
		if(!file.exists())
		{
			file.mkdirs();
		}
		
		MyGridView grid = (MyGridView)findViewById(R.id.gridView1);
		grid.setAdapter(new GridViewAdapter(this));
		
		detector = new GestureDetector(this, new SimpleOnGestureListener(){

			@SuppressWarnings("deprecation")
			@Override
			public boolean onDown(MotionEvent e) {
				// TODO Auto-generated method stub
				if(e.getX()>getWindowManager().getDefaultDisplay().getWidth()-50){
					return true;
				}
				return super.onDown(e);
			}

			@SuppressWarnings("deprecation")
			@Override
			public boolean onScroll(MotionEvent e1, MotionEvent e2,
					float distanceX, float distanceY) {
				// TODO Auto-generated method stub
				if(e1.getX()<getWindowManager().getDefaultDisplay().getWidth()-50){
					return false;
				}else{
					if(!LOCKJUMP)
					{
						LOCKJUMP = true;
						startActivity(new Intent(MainActivity.this, SetVoiceActivity.class));
						overridePendingTransition(R.anim.in_from_right, R.anim.out_from_left);
					}
					return true;
				}
			}
			
		});
	}

	@Override
	public boolean dispatchTouchEvent(MotionEvent ev) {
		// TODO Auto-generated method stub
		if(detector.onTouchEvent(ev)){
			return true;
		}
		return super.dispatchTouchEvent(ev);
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		LOCKJUMP = false;
		super.onResume();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);		
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch(item.getItemId()){
		case R.id.action_settings:
			startActivity(new Intent(MainActivity.this, SetVoiceActivity.class));
			break;
		case R.id.Test:
			SharedPreferences sp = getSharedPreferences(StaticValue.VOICE_PREFERENCES, MODE_PRIVATE);
			String testStr = "";
			for(int i=0;i<StaticValue.GRIDVIEW_AMOUNT;i++){
				testStr = testStr + "\n" + "(" + i + ")" + sp.getString(StaticValue.VOICE_NAME+i, "");
			}
			Toast.makeText(MainActivity.this, testStr, Toast.LENGTH_SHORT).show();
			break;
		default:
			break;
		}
		
		return super.onOptionsItemSelected(item);
	}
	
}
