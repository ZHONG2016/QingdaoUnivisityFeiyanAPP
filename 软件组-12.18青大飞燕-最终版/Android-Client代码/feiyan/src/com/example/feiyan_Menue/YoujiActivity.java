package com.example.feiyan_Menue;

import com.example.feiyan.R;
import com.example.feiyan.R.id;
import com.example.feiyan.R.layout;
 

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class YoujiActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
 
		setContentView(R.layout.menu_youji);
		WebView webView = (WebView) findViewById(R.id.webView1);
 
		webView.getSettings().setJavaScriptEnabled(true);
		webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
	    WebSettings s = webView.getSettings();     
		s.setBuiltInZoomControls(true);     
		s.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);     
		s.setUseWideViewPort(true);     
		s.setLoadWithOverviewMode(true);     
		s.setSavePassword(true);     
		s.setSaveFormData(true);     
		s.setJavaScriptEnabled(true);  
		// enable navigator.geolocation     
		s.setGeolocationEnabled(true);     
		s.setGeolocationDatabasePath("/data/data/org.itri.html5webview/databases/");     // enable Web Storage: localStorage, sessionStorage     
		s.setDomStorageEnabled(true);  
		webView.requestFocus();  
		webView.setScrollBarStyle(0);
		webView.loadUrl("http://115.159.226.182:8080/Friendship/index.html");
	    webView.setWebViewClient(new HelloWebViewClient ());//点击的每一步都嵌套在webview中
	}

	 private class HelloWebViewClient extends WebViewClient {
	        @Override
	        public boolean shouldOverrideUrlLoading(WebView view, String url) {
	            view.loadUrl(url);
	            return true;
	        }
	    }

}
