package com.example.Events;

import com.example.mix_music.SelectVoiceActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;



public class SetVoiceButtonListener extends Activity implements OnClickListener {
	
	private int index;//指定是第几个按钮的音效
	private Context context;
	
	public SetVoiceButtonListener(Context c, int i){
		context = c;
		index = i;
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		Intent intent = new Intent(context, SelectVoiceActivity.class);
		intent.putExtra("INDEX", index);
		context.startActivity(intent);
	}

}
