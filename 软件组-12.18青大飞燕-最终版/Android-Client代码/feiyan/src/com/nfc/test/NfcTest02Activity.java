package com.nfc.test;

import com.example.feiyan.R;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebView;

public class NfcTest02Activity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//设置无标题  
        requestWindowFeature(Window.FEATURE_NO_TITLE);  
        //设置全屏  
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,   
        WindowManager.LayoutParams.FLAG_FULLSCREEN);  
        
		setContentView(R.layout.activity_nfc_test02);
		WebView webView = (WebView) findViewById(R.id.webView1);
		  //启用javascript  
         webView.getSettings().setJavaScriptEnabled(true);  

		webView.loadUrl("http://m.zhongyunjie.icoc.me/index.jsp");
//		http://m.zhongyunjie.icoc.me/col.jsp?id=107
	}

 

}
