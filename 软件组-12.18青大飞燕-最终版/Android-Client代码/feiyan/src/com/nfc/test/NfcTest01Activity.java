package com.nfc.test;

import com.dtr.zxing.activity.ResultActivity;
import com.dtr.zxing.activity.ResultActivity.MusicAsyTask;
import com.example.feiyan.R;
import com.example.mediaplay.ProgressToggleButton;
import com.example.mediaplay.ProgressToggleButton.onCheckChangesListener;

import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class NfcTest01Activity extends Activity {

	private ImageView mResultImage;
	private TextView mResultText;
	private ProgressToggleButton tDefult, tDiv, tplayer;
	private MediaPlayer mMediaPlayer;
    private SeekBar mSeekBar;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//设置无标题  
        requestWindowFeature(Window.FEATURE_NO_TITLE);  
        //设置全屏  
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,   
        WindowManager.LayoutParams.FLAG_FULLSCREEN);  
        
		setContentView(R.layout.activity_nfc_test01);
		WebView webView = (WebView) findViewById(R.id.webView_result);
		  //启用javascript  
         webView.getSettings().setJavaScriptEnabled(true);  
	   	webView.loadUrl("http://m.zhongyunjie.icoc.me/index.jsp");
//	   	http://m.zhongyunjie.icoc.me/col.jsp?id=107
	   	//播放景点介绍
		init();
		
	}
	private void init() {
//		tDefult = (ProgressToggleButton) findViewById(R.id.defult);
//		tDiv = (ProgressToggleButton) findViewById(R.id.user_div);
		tplayer = (ProgressToggleButton) findViewById(R.id.play);
		mSeekBar = (SeekBar) findViewById(R.id.seekbar);
		mMediaPlayer = MediaPlayer.create(NfcTest01Activity.this, R.raw.qdtushu);
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
