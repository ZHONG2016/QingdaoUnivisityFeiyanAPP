package com.example.mediaplay;

 
import com.example.feiyan.R;
import com.example.mediaplay.ProgressToggleButton;
import com.example.mediaplay.ProgressToggleButton.onCheckChangesListener;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.Toast;

/** 
 * @author 1246802560@qq.com (钟云杰)
 */

public class MainActivity extends Activity {
	private ProgressToggleButton tDefult, tDiv, tplayer;
	private MediaPlayer mMediaPlayer;
    private SeekBar mSeekBar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
        WebView webView = (WebView) findViewById(R.id.webView);
		webView.loadUrl("http://baidu.com");
		init();
		
	}

	private void init() {
//		tDefult = (ProgressToggleButton) findViewById(R.id.defult);
//		tDiv = (ProgressToggleButton) findViewById(R.id.user_div);
		tplayer = (ProgressToggleButton) findViewById(R.id.play);
		mSeekBar = (SeekBar) findViewById(R.id.seekbar);
		mMediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.qdtushu);
//		tDefult.setOnCheckChangesListener(new onCheckChangesListener() {
//
//			@Override
//			public void onchechkchanges(boolean isChecked) {
//				Toast.makeText(MainActivity.this, "默认样式被点�?,状�?�为" + isChecked,
//						Toast.LENGTH_SHORT).show();
//			}
//		});
//		tDiv.setOnCheckChangesListener(new onCheckChangesListener() {
//
//			@Override
//			public void onchechkchanges(boolean isChecked) {
//				Toast.makeText(MainActivity.this, "用户指定样式被点�?,状�?�为" + isChecked,
//						Toast.LENGTH_SHORT).show();
//			}
//		});
		tplayer.setOnCheckChangesListener(new onCheckChangesListener() {

			@Override
			public void onchechkchanges(boolean isChecked) {
				if (musicAsyTask != null) {
					musicAsyTask.cancel(true);
				}
				musicAsyTask = (MusicAsyTask) new MusicAsyTask().execute();
				if (isChecked) {
					mMediaPlayer.start();
				} else {
					mMediaPlayer.pause();
				}
			}
		});
		mSeekBar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {

			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				musicAsyTask = (MusicAsyTask) new MusicAsyTask().execute();
				Log.d("LOG", "finish");

			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				if (musicAsyTask != null) {
					musicAsyTask.cancel(true);
					musicAsyTask = null;
					Log.d("LOG", "starttoch");
				}
			}

			@Override
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {
				if (fromUser) {
					Log.d("LOG", progress + "");
					mMediaPlayer.seekTo((progress * mMediaPlayer.getDuration()) / 100);
					tplayer.setProgress(progress);
				}

			}
		});
	}

	private MusicAsyTask musicAsyTask;

	public class MusicAsyTask extends AsyncTask<Void, Integer, Void> {

		@Override
		protected Void doInBackground(Void... params) {
			publishProgress(getPercent(mMediaPlayer.getCurrentPosition(),
					mMediaPlayer.getDuration()));
			try {
				Thread.sleep(1000);
				this.doInBackground();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return null;
		}

		@Override
		protected void onProgressUpdate(Integer... values) {
			int progress = values[0];
			tplayer.setProgress(progress);
			mSeekBar.setProgress(progress);
			super.onProgressUpdate(values);
		}

	}

	/**
	 * 计算百分�?
	 * @param progress
	 *            当前进度
	 * @param total
	 *            总进�?
	 */
	public int getPercent(int progress, int total) {
		double baiy = progress * 1.0;
		double baiz = total * 1.0;
		double fen = baiy / baiz;
		return (int) (fen * 100);
	}

}
