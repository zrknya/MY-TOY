package com.example.Events;

import com.example.mix_music.R;
import com.example.tools.StaticValue;

import android.content.Context;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.net.Uri;
import android.os.Environment;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnTouchListener;
import android.widget.Toast;

public class ButtonListener implements OnTouchListener, OnClickListener {

	private Context context;
	private MediaPlayer media = new MediaPlayer();
	private int position;
	private static final int START = 1;
	private static final int STOP = 0;
	private int state = STOP;
	private Integer[] audioList = {R.raw.audio1,R.raw.audio2,R.raw.audio3,
								R.raw.audio4,R.raw.audio5,R.raw.audio6,
								R.raw.audio7,R.raw.audio8,R.raw.audio9,
								R.raw.audio10,R.raw.audio11,R.raw.audio12};
	
	public ButtonListener(Context c, int i){
		context = c;
		position = i;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(state == START){
			media.stop();
			media.release();
			state = STOP;
		}
	}

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		// TODO Auto-generated method stub
		SharedPreferences sp = context.getSharedPreferences(StaticValue.VOICE_PREFERENCES, context.MODE_PRIVATE);
		int volume = sp.getInt(StaticValue.VOLUME_NAME + position, 100);
		
		if(state == STOP){
			try {
				// media = MediaPlayer.create(context, Uri.parse(Environment.getExternalStorageDirectory().getPath()+"/Music/回レ! 雪月花 Remix.wav"));
				if (sp.getBoolean(StaticValue.VOICE_DEFAULT, true)) {
					//media = MediaPlayer.create(context, audioList[position]);
				} else {
					media = MediaPlayer.create(
							context,
							Uri.parse(sp.getString(StaticValue.VOICE_NAME
									+ position, "")));
				}
				media.setVolume(volume / 100f, volume / 100f);// 设置音量
				media.setOnPreparedListener(new OnPreparedListener() {

					@Override
					public void onPrepared(MediaPlayer mp) {
						// TODO Auto-generated method stub
						media.setLooping(true);
						media.start();
					}

				});
				state = START;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		return false;
	}

}
