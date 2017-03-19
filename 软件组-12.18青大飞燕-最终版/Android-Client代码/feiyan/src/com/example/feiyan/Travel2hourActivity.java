package com.example.feiyan;

import com.example.feiyan_Home.LujingChoiceActivity;
import com.example.feiyanbaiduAPI.MainActivity;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Travel2hourActivity extends Activity {
	Button btn1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_travel2hour);
		 btn1 = (Button) findViewById(R.id.button1);
		 btn1.setOnClickListener(new OnClickListener() {
		      @Override
		      public void onClick(View v) {
		        // TODO Auto-generated method stub
		    	  Intent intent1 = new Intent();  
			  		//第一个参数指的就是要跳转的那个Activity  
			  		//第二个指的是跳到的那个Activity  
			  	  intent1.setClass(Travel2hourActivity.this, MainActivity.class); 
			  	  Travel2hourActivity.this.startActivity(intent1);
		 
		      }
		    });
		
		
	}

	 
 

}
