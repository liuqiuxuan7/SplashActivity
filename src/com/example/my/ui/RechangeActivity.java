package com.example.my.ui;


import com.example.my.R;
import com.example.my.R.array;
import com.example.my.R.id;
import com.example.my.R.layout;
import com.example.my.utils.CommonTools;

import android.os.Build;
import android.os.Bundle;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;

import android.text.InputType;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Toast;

public class RechangeActivity extends Activity implements OnClickListener{
  ImageView img_overflower;
  EditText et_rechange_money,et_rechange;
  Button btnRechange,img_btn_rechange_banck;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_rechange);
		
		img_overflower=(ImageView)findViewById(R.id.img_overflower);
		img_btn_rechange_banck=(Button)findViewById(R.id.btn_rechange_back);
		et_rechange_money=(EditText)findViewById(R.id.et_rechange_money);
		et_rechange=(EditText)findViewById(R.id.et_rechange);
		btnRechange=(Button)findViewById(R.id.btn_rechange);
		img_btn_rechange_banck.setOnClickListener(this);
		img_overflower.setOnClickListener(this);
		btnRechange.setOnClickListener(this);
		et_rechange.requestFocus();
		et_rechange.setInputType(InputType.TYPE_CLASS_PHONE);
		
		
	
	}//显示列表项

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.img_overflower:
			String[] items=getResources().getStringArray(R.array.dialog1_items);
			new AlertDialog.Builder(this).setTitle("选择充值的金额").setItems(items,new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface arg0, int arg1) {
					switch(arg1){
					case 0:
						et_rechange_money.setText("充值30元");
					break;
					case 1:
						et_rechange_money.setText("充值50元");
					break;
					case 2:
						et_rechange_money.setText("充值100元");
					break;
					case 3:
						et_rechange_money.setText("充值200元");
					break;
					case 4:
						et_rechange_money.setText("充值300元");
					break;
					case 5:
						et_rechange_money.setText("充值500元");
					break;
					
					}
				}
			}).create().show();
			
			break;
			
		case R.id.btn_rechange:
			Toast.makeText(this, "充值成功", 5000).show();
			break;
		case R.id.btn_rechange_back:
			finish();
			break;
		}
		
	}

}
