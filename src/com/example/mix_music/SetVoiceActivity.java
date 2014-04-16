package com.example.mix_music;

import com.example.adapters.SetVoiceGridViewAdapter;
import com.example.myView.MyGridView;
import com.example.tools.StaticValue;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.Window;
import android.view.WindowManager;
import android.view.GestureDetector.SimpleOnGestureListener;

public class SetVoiceActivity extends Activity {
	
	private GestureDetector detector;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_setvoice);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		
		detector = new GestureDetector(this, new SimpleOnGestureListener(){

			@Override
			public boolean onScroll(MotionEvent e1, MotionEvent e2,
					float distanceX, float distanceY) {
				// TODO Auto-generated method stub
				if(e1.getX()>50){
					return false;
				}else{
					SetVoiceActivity.this.finish();
					overridePendingTransition(R.anim.in_from_left, R.anim.out_from_right);
					return true;
				}
			}
			
		});
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onStart();
		
		MyGridView grid = (MyGridView)findViewById(R.id.setvoicegridView);
		grid.setAdapter(new SetVoiceGridViewAdapter(this));
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		detector.onTouchEvent(event);
		return super.onTouchEvent(event);
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		if(keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0)
		{
			SetVoiceActivity.this.finish();
			overridePendingTransition(R.anim.in_from_left, R.anim.out_from_right);
			return true;
		}
		
		return super.onKeyDown(keyCode, event);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		getMenuInflater().inflate(R.menu.setvoicemenu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch (item.getItemId()) {
		case R.id.set_defaut_voice:
			SharedPreferences sp = getSharedPreferences(StaticValue.VOICE_PREFERENCES, MODE_PRIVATE);
			SharedPreferences.Editor editor = sp.edit();
			editor.putBoolean(StaticValue.VOICE_DEFAULT, true);
			for(int i=0;i<StaticValue.GRIDVIEW_AMOUNT;i++){
				editor.putString(StaticValue.VOICE_NAME + i, "");
			}
			editor.commit();
			startActivity(new Intent(SetVoiceActivity.this,SetVoiceActivity.class));
			finish();
			break;

		default:
			break;
		}
		
		return super.onOptionsItemSelected(item);
	}

}
