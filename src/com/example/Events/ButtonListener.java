package com.example.Events;

import com.example.mix_music.R;
import com.example.tools.StaticValue;

import android.content.Context;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.net.Uri;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageButton;

public class ButtonListener implements OnTouchListener {

	private Context context;
	private MediaPlayer media = new MediaPlayer();
	private int position;
	private static final int PAUSE = 2;
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
	public boolean onTouch(View v, MotionEvent event) {
		// TODO Auto-generated method stub
		ImageButton button = (ImageButton)v;
		if(event.getActionMasked() == MotionEvent.ACTION_DOWN){
			button.setBackgroundResource(R.drawable.test_button_down);
			SharedPreferences sp = context.getSharedPreferences(StaticValue.VOICE_PREFERENCES, context.MODE_PRIVATE);
			int volume = sp.getInt(StaticValue.VOLUME_NAME + position, 100);
			
			try {
				if(state == STOP){
						// media = MediaPlayer.create(context, Uri.parse(Environment.getExternalStorageDirectory().getPath()+"/Music/回レ! 雪月花 Remix.wav"));
						if (sp.getBoolean(StaticValue.VOICE_DEFAULT, true)) {
							//media = MediaPlayer.create(context, audioList[position]);
						} else {
							media = MediaPlayer.create(
									context,
									Uri.parse(sp.getString(StaticValue.VOICE_NAME + position, "")));
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
					
				}
				else if(state == PAUSE){
					media.start();
					state = START;
				}
			} catch (Exception e) {
					// TODO: handle exception
			}
			
		}else if(event.getActionMasked() == MotionEvent.ACTION_UP){
			if(event.getY() > button.getHeight() || event.getRawY() < button.getY()){//当手指延Y轴划出按钮范围松开时，音乐持续播放
				return false;
			}
			if(event.getX() > button.getWidth() || event.getRawX() < button.getX()){//当手指延X轴划出按钮范围松开时，音乐暂停播放
				media.pause();
				state = PAUSE;
				button.setBackgroundResource(R.drawable.test_button_pause);
			}else{
				media.stop();
				media.release();
				state = STOP;
				button.setBackgroundResource(R.drawable.test_button);
			}
		}
		return false;
	}

}
