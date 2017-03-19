package com.example.feiyan_Home;

import com.example.feiyan.R;
import com.example.feiyan.Travel1hourActivity;
import com.example.feiyan.Travel2hourActivity;
import com.example.feiyan.Travel3hourActivity;
import com.example.feiyan_Menue.YoujiActivity;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;


/** 
 * @author 1246802560@qq.com (钟云杰)
 */

public class LujingChoiceActivity extends Activity {
	Button btn1, btn2,btn3;
	Toast tst;
	
	
	
	
	
	
	//按钮事件处理的监听类
	class MyClickListener implements OnClickListener {
		 
	    @Override
	    public void onClick(View v) {
	      // TODO Auto-generated method stub
	      switch (v.getId()) {
	      case R.id.button1:
	    	  Intent intent1 = new Intent();  
	  		//第一个参数指的就是要跳转的那个Activity  
	  		//第二个指的是跳到的那个Activity  
	  		      intent1.setClass(LujingChoiceActivity.this, Travel1hourActivity.class); 
	  		      LujingChoiceActivity.this.startActivity(intent1);
//	  		      Toast t1=Toast.makeText(getApplicationContext(), "跳转没起作用~~~~~~", Toast.LENGTH_SHORT);
//			      t1.show();
	        break;
	      case R.id.button2:
	    	  Intent intent2 = new Intent();  
		  		//第一个参数指的就是要跳转的那个Activity  
		  		//第二个指的是跳到的那个Activity  
		  		      intent2.setClass(LujingChoiceActivity.this, Travel2hourActivity.class); 
		  		      LujingChoiceActivity.this.startActivity(intent2);
	        break;
	      default:
	    	  Intent intent3 = new Intent();  
		  		//第一个参数指的就是要跳转的那个Activity  
		  		//第二个指的是跳到的那个Activity  
		  		      intent3.setClass(LujingChoiceActivity.this, Travel3hourActivity.class); 
		  		      LujingChoiceActivity.this.startActivity(intent3);
	        break;
	      }
	    }
	  }
	 @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.choice_lujing);
	        btn1 = (Button) findViewById(R.id.button1);
	        btn2 = (Button) findViewById(R.id.button2);
	        btn3 = (Button) findViewById(R.id.button3);
	        btn1.setOnClickListener(new MyClickListener());
	        btn2.setOnClickListener(new MyClickListener());
	        btn3.setOnClickListener(new MyClickListener());
	    }
	 
}
