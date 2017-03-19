package com.nfc.test;
 
import com.example.feiyan.R;
import com.example.feiyan_Menue.YoujiActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentFilter;
import android.nfc.NdefMessage;
import android.nfc.NdefRecord;
import android.nfc.NfcAdapter;
import android.nfc.tech.MifareClassic;
import android.nfc.tech.NfcA;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
/** 
 * @author 1246802560@qq.com (钟云杰)
 * Nfc 标签的扫描 
 */
 
@SuppressLint("NewApi")
public class ReadTag extends Activity {
	private NfcAdapter nfcAdapter;
	private TextView resultText;
	private PendingIntent pendingIntent;
	private IntentFilter[] mFilters;
	private String[][] mTechLists;
	private Button mJumpTagBtn;
	private boolean isFirst = true;

	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// 获取nfc适配器，判断设备是否支持NFC功能
		nfcAdapter = NfcAdapter.getDefaultAdapter(this);
		if (nfcAdapter == null) {
			Toast.makeText(this, getResources().getString(R.string.no_nfc),
					Toast.LENGTH_SHORT).show();
			finish();
			return;
		} else if (!nfcAdapter.isEnabled()) {
			Toast.makeText(this, getResources().getString(R.string.open_nfc),
					Toast.LENGTH_SHORT).show();
			finish();
			return;
		}
		setContentView(R.layout.read_tag);
		// 显示结果Text
		resultText = (TextView) findViewById(R.id.read_tag_textview);
		// 写入标签按钮
//		mJumpTagBtn = (Button) findViewById(R.id.jump);
//		mJumpTagBtn.setOnClickListener(new WriteBtnOnClick());

		pendingIntent = PendingIntent.getActivity(this, 0, new Intent(this,
				getClass()).addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP), 0);
		IntentFilter ndef = new IntentFilter(NfcAdapter.ACTION_TECH_DISCOVERED);
		ndef.addCategory("*/*");
		mFilters = new IntentFilter[] { ndef };// 过滤器
		mTechLists = new String[][] {
				new String[] { MifareClassic.class.getName() },
				new String[] { NfcA.class.getName() } };// 允许扫描的标签类型

	}

	@SuppressLint("NewApi")
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		nfcAdapter.enableForegroundDispatch(this, pendingIntent, mFilters,
				mTechLists);
		if (isFirst) {
			if (NfcAdapter.ACTION_TECH_DISCOVERED.equals(getIntent().getAction())) {
				String result = processIntent(getIntent());
				resultText.setText(result);
			}
			isFirst = false;
		}

	}
	/**
	 * 获取tab标签中的内容
	 * 
	 * @param intent
	 * @return
	 */
	@SuppressLint("NewApi")
	private String processIntent(Intent intent) {
		Parcelable[] rawmsgs = intent
				.getParcelableArrayExtra(NfcAdapter.EXTRA_NDEF_MESSAGES);
		NdefMessage msg = (NdefMessage) rawmsgs[0];
		NdefRecord[] records = msg.getRecords();
		String resultStr = new String(records[0].getPayload());
		return resultStr;
	}

	@Override
	protected void onNewIntent(Intent intent) {
		// TODO Auto-generated method stub
		super.onNewIntent(intent);
		if (NfcAdapter.ACTION_TECH_DISCOVERED.equals(intent.getAction())) {
			String result = processIntent(intent);
			resultText.setText("马上为您讲解的是"+result+"号景点");
			int id=Integer.parseInt(result);	 
          //跳转相应的景点介绍页面
			switch (id) {
			case 1:
		     Intent intent1 = new Intent();  
	        //第一个参数指的就是要跳转的那个Activity  
	       //第二个指的是跳到的那个Activity  
	        intent1.setClass(ReadTag.this, NfcTest01Activity.class); 
	        ReadTag.this.startActivity(intent1);
				break;
			case 2:
				Intent intent2 = new Intent();  
		        //第一个参数指的就是要跳转的那个Activity  
		       //第二个指的是跳到的那个Activity  
		        intent2.setClass(ReadTag.this, NfcTest02Activity.class); 
		        ReadTag.this.startActivity(intent2);
				 
				break;
			case 3:
				  
					   
				break;
			case 4:
			 
				break;
			default:
				 Toast t1=Toast.makeText(getApplicationContext(), "不是数字嘛嘛嘛嘛嘛~~~~~~", Toast.LENGTH_SHORT);
				 t1.show();
				break;
			}
			 
		}
	}

	
	/**
	 * 按钮点击事件
	 * 
	 *
	 * 
//	 */
//	class WriteBtnOnClick implements OnClickListener {
//
//		@Override
//		public void onClick(View v) {
//			// TODO Auto-generated method stub
//			switch (v.getId()) {
//			case R.id.jump:
//				Intent intent = new Intent(ReadTag.this, WriteTag.class);
//				startActivity(intent);
//			default:
//				break;
//			}
//		}

//	}

}
