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
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class BuyLotteryActivity extends Activity implements OnClickListener{
	private Button  jingqitouzhu_btn;
	private Button shouchang_btn;
	private Button zhuihao_btn;
	private Button touzhu_btn;
	private TextView buylottery_title;
	private TextView buylottery_title2;
	private LinearLayout buylottery_frame_item1;
	private LinearLayout buylottery_frame_item2;
	private LinearLayout buylottery_frame_item3;
	private RelativeLayout buylottery_changeframe;
	private View view;
	private LayoutParams params;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_buy_lottery);
		initialWidget();
		
	}
   
	private void initialWidget(){
		Intent intent=getIntent();
		Bundle bundle=intent.getExtras();
		buylottery_title = (TextView)findViewById(R.id.buylottery_title);
		buylottery_title2 = (TextView)findViewById(R.id.buylottery_title2);
		buylottery_title.setText(bundle.getString("buylottery_title").toString());
		buylottery_title2.setText("奖池：----");
		
		//底部的按钮选项
		jingqitouzhu_btn = (Button)findViewById(R.id.buylottery_bottom1);
		shouchang_btn = (Button)findViewById(R.id.buylottery_bottom2);
		zhuihao_btn = (Button)findViewById(R.id.buylottery_bottom3);
		touzhu_btn = (Button)findViewById(R.id.buylottery_bottom4);
		
		//顶部的按钮
		buylottery_frame_item1 = (LinearLayout)findViewById(R.id.buylottery_frame_item1);
		buylottery_frame_item2 = (LinearLayout)findViewById(R.id.buylottery_frame_item2);
		buylottery_frame_item3 = (LinearLayout)findViewById(R.id.buylottery_frame_item3);
		buylottery_changeframe = (RelativeLayout)findViewById(R.id.buylottery_changeframe);
		
		buylottery_frame_item1.setOnClickListener(this);
		buylottery_frame_item2.setOnClickListener(this);
		buylottery_frame_item3.setOnClickListener(this);
		
		View view = getLayoutInflater().inflate(R.layout.buylottery_shuangsheqiu_frame1, null);  
		LayoutParams params = new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT);  
		buylottery_changeframe.addView(view, params);  
		initEvent();
			
		
	}

	private void initEvent() {
		// TODO Auto-generated method stub
		jingqitouzhu_btn.setOnClickListener(this);
		shouchang_btn.setOnClickListener(this);
		zhuihao_btn.setOnClickListener(this);
		touzhu_btn.setOnClickListener(this);
		
	}
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		finish();
	}

	@Override
	public void onClick(View v) {
	 switch (v.getId()) {
	case R.id.buylottery_frame_item1:
		resetToNormal(v);
		buylottery_changeframe.removeAllViews();
		view = BuyLotteryActivity.this.getLayoutInflater().inflate(R.layout.buylottery_shuangsheqiu_frame1, null);  
		params = new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT);  
		buylottery_changeframe.addView(view, params);  
		break;
	case R.id.buylottery_frame_item2:
		resetToNormal(v);
		buylottery_changeframe.removeAllViews();
		view = BuyLotteryActivity.this.getLayoutInflater().inflate(R.layout.buylottery_shuangsheqiu_frame1, null);  
		params = new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT);  
		buylottery_changeframe.addView(view, params);  
		break;
	case R.id.buylottery_frame_item3:
		resetToNormal(v);
		buylottery_changeframe.removeAllViews();
		view = BuyLotteryActivity.this.getLayoutInflater().inflate(R.layout.buylottery_shuangsheqiu_frame1, null);  
		params = new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT);  
		buylottery_changeframe.addView(view, params);  
		break;
	case R.id.buylottery_bottom1:
		break;
	case R.id.buylottery_bottom2:
		break;
	case R.id.buylottery_bottom3:
		break;
	case R.id.buylottery_bottom4:
		break;
	
	}
		
	}

	private void resetToNormal(View v) {
		LinearLayout lin1 = (LinearLayout)findViewById(R.id.buylottery_frame_item1);
		LinearLayout lin2 = (LinearLayout)findViewById(R.id.buylottery_frame_item2);
		LinearLayout lin3 = (LinearLayout)findViewById(R.id.buylottery_frame_item3);
		lin1.setBackgroundResource(R.drawable.tab2);
		lin2.setBackgroundResource(R.drawable.tab2);
		lin3.setBackgroundResource(R.drawable.tab2);
		v.setBackgroundResource(R.drawable.tab1);
		
	}
}
