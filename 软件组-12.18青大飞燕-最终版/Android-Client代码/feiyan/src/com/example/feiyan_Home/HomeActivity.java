package com.example.feiyan_Home;

  
import com.dtr.zxing.activity.CaptureActivity;

import com.example.feiyan.R;
import com.example.feiyan_Menue.YoujiActivity;
 
import com.nfc.test.ReadTag;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.app.FragmentTransaction;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.Menu;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.Toast;

/** 
 * @author 1246802560@qq.com (���ƽ�)
 */

public class HomeActivity extends Activity {

	private Fragment contentFragment;
	private RadioGroup myTabRg;
//	private FragmentChat chat;
//	private FragmentAddress address;
//	private FragmentFind find;
//	private FragmentMe me;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		//�����ޱ���  
        requestWindowFeature(Window.FEATURE_NO_TITLE);  
        //����ȫ��  
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,   
        WindowManager.LayoutParams.FLAG_FULLSCREEN);  
        
		setContentView(R.layout.index);
		
		WebView webView = (WebView) findViewById(R.id.webView);
		  //����javascript  
         webView.getSettings().setJavaScriptEnabled(true);  
		webView.loadUrl("http://m.feiyan20152016.icoc.me/index.jsp");
		//����Web��ͼ
        webView.setWebViewClient(new HelloWebViewClient ());
		initView();
		
	}
	 private class HelloWebViewClient extends WebViewClient {
	        @Override
	        public boolean shouldOverrideUrlLoading(WebView view, String url) {
	            view.loadUrl(url);
	            return true;
	        }
	    }
	public void initView() {
		 
		myTabRg = (RadioGroup) findViewById(R.id.tab_menu);
		myTabRg.setOnCheckedChangeListener(new OnCheckedChangeListener() {


			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				// TODO Auto-generated method stub
				switch (checkedId) {
				case R.id.youji:
				    Intent intent1 = new Intent();  
		//��һ������ָ�ľ���Ҫ��ת���Ǹ�Activity  
		//�ڶ���ָ�����������Ǹ�Activity  
		        intent1.setClass(HomeActivity.this, YoujiActivity.class); 
		        HomeActivity.this.startActivity(intent1);
					break;
				case R.id.lujing:
					  Intent intent2 = new Intent();  
						//��һ������ָ�ľ���Ҫ��ת���Ǹ�Activity  
						//�ڶ���ָ�����������Ǹ�Activity  
					   intent2.setClass(HomeActivity.this, LujingChoiceActivity.class); 
					    HomeActivity.this.startActivity(intent2);
//					    Toast t1=Toast.makeText(getApplicationContext(), "xingla~~~~~~", Toast.LENGTH_SHORT);
//					     t1.show();
					break;
				case R.id.saoyisao:
					   Intent intent3 = new Intent();  
						//��һ������ָ�ľ���Ҫ��ת���Ǹ�Activity  
						//�ڶ���ָ�����������Ǹ�Activity  
					   intent3.setClass(HomeActivity.this, CaptureActivity.class); 
					    HomeActivity.this.startActivity(intent3);
					    
					break;
				case R.id.tieyitie:
					Intent intent4 = new Intent();  
					//��һ������ָ�ľ���Ҫ��ת���Ǹ�Activity  
					//�ڶ���ָ�����������Ǹ�Activity  
				   intent4.setClass(HomeActivity.this, ReadTag.class); 
				    HomeActivity.this.startActivity(intent4);
				 
					break;
				default:
					break;
				}

			}
		});
	}
	
	
}
