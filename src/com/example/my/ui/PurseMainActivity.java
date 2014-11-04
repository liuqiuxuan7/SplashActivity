package com.example.my.ui;

import com.example.my.R;
import com.example.my.R.layout;
import com.example.my.R.menu;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class PurseMainActivity extends Activity implements OnClickListener{
   Button btn_back_buy,btn_goshop,btn_commit;
   Intent intent;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_purse_main);
		initialWidget();
	}

  private void initialWidget(){
	  btn_back_buy=(Button)findViewById(R.id.btn_back_buy);
	  btn_goshop=(Button)findViewById(R.id.btn_goshop);
	  btn_commit=(Button)findViewById(R.id.btn_commit);
	  
	  btn_back_buy.setOnClickListener(this);
	  btn_goshop.setOnClickListener(this);
	  btn_commit.setOnClickListener(this);
  }
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_goshop:
			intent=new Intent(PurseMainActivity.this,CategoryActivity.class);
			startActivity(intent);
			break;
        case R.id.btn_back_buy:
        	finish();
        	break;
		case R.id.btn_commit:		
		Toast.makeText(PurseMainActivity.this, "訂單提交成功", Toast.LENGTH_LONG).show();
		break;
		}
		
	}

}
