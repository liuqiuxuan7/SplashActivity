package com.example.my.ui;

import com.example.my.R;
import com.example.my.utils.BitmapUtil;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.view.LayoutInflater;

import android.view.View;
import android.view.ViewGroup;

import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

public class LotteryActivity extends Activity {
	private int screenWidth;
	private int screenHeight;
	
  ListView lvLottery;
  LotteryAdapter lotteryAdapter=new LotteryAdapter();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lottery);
		initTab1();
		
		
	}
	private void initTab1(){
		lvLottery=(ListView)findViewById(R.id.main_tab1_list);
		int[] colors = {Color.WHITE,Color.WHITE};
		lvLottery.setDivider(new GradientDrawable(Orientation.RIGHT_LEFT, colors));
		lvLottery.setDividerHeight(5);
		lvLottery.setFocusable(false);
		lvLottery.setAdapter(lotteryAdapter);
		lvLottery.setOnItemClickListener(new OnItemClickListener() {
		public void onItemClick(AdapterView<?> parent, View view, int position,long id) {
				Intent intent = new Intent(LotteryActivity.this,BuyLotteryActivity.class);
				Bundle bundle = new Bundle();
				TextView titleview = (TextView)view.findViewById(R.id.tab1_list_title);
				String title = (String) titleview.getText();
				bundle.putString("buylottery_title",title);
				intent.putExtras(bundle);
				startActivity(intent);
			}
		});
	}
	 private class LotteryAdapter extends BaseAdapter{

		@Override
		public int getCount() {
			return SystemData.main_tab1_list_icons.length;			
		}

		@Override
		public Object getItem(int arg0) {
			
			return arg0;
		}

		@Override
		public long getItemId(int position) {	
			return position;
		}

		@Override
		public View getView(int position, View arg1, ViewGroup arg2) {
			View view = LayoutInflater.from(LotteryActivity.this)
					.inflate(R.layout.main_tab1_sublist, null);
			
			ImageView imageView =(ImageView)view.findViewById(R.id.main_tab1_list_icon);
			imageView.setImageResource(SystemData.main_tab1_list_icons[position]);
			
			LinearLayout lin = (LinearLayout)view.findViewById(R.id.main_tab_center_sub);
			Bitmap backpic = BitmapFactory.decodeResource(getResources(),R.drawable.xuanhaochi);
			//Bitmap baBitmap=BitmapUtil.GetNewBitmap(oldBitmap, position, position, newWidth, newHeight);
			Bitmap newbackpic = BitmapUtil.GetNewBitmap(backpic, screenWidth, screenHeight, screenWidth-10, 70);
			BitmapDrawable drawpic = new BitmapDrawable(getResources(),newbackpic);//将Bitmap转换为Drawable
			
			TextView title = (TextView)view.findViewById(R.id.tab1_list_title);
			title.setText(SystemData.main_tab1_list_titles[position]);
			TextView text = (TextView)view.findViewById(R.id.tab1_list_text);
			text.setText(SystemData.main_tab1_list_texts[position]);
			
			lin.setBackgroundDrawable(drawpic);
			
			return view;
		}
		 
	 }

}
