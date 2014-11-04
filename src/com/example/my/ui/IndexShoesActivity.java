package com.example.my.ui;

import java.util.ArrayList;
import java.util.List;

import com.android.volley.toolbox.ImageLoader;
import com.example.my.R;
import com.example.my.R.layout;
import com.example.my.R.menu;
import com.example.my.model.ShoesModel;
import com.example.my.sql.DataUtil;
import com.example.my.utils.RequestQueueSingleton;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

public class IndexShoesActivity extends Activity {
    GridView gridview;
	List<ShoesModel>listShoes=new ArrayList<ShoesModel>();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_index_shoes);		
	
	//创建帧动画来实现页面的切换
		 AnimationDrawable animation = new AnimationDrawable();
		    animation.addFrame(getResources().getDrawable(R.drawable.shoes), 1000);
		    animation.addFrame(getResources().getDrawable(R.drawable.shoes1), 1000);
		    animation.addFrame(getResources().getDrawable(R.drawable.shoes3), 1000);
		    animation.setOneShot(false);
		    ImageView imageAnim=(ImageView)findViewById(R.id.index_shoes_gallery);
		   
		    imageAnim.setBackgroundDrawable(animation);

		    // start the animation!
		    animation.start();
		
		listShoes=DataUtil.getShoes(this);
		gridview=(GridView)findViewById(R.id.gv_shoes);
		ShoesAdapter shoesAdapter=new ShoesAdapter();
		gridview.setAdapter(shoesAdapter);
		
	}

	
 	private class ShoesAdapter extends BaseAdapter {

		@Override
		public int getCount() {

			return listShoes.size();
		}

		@Override
		public Object getItem(int position) {

			return listShoes.get(position);
		}

		@Override
		public long getItemId(int arg0) {

			return arg0;
		}

		@Override
		public View getView(final int position, View convertView,
				ViewGroup parent) {
			View childView;

			childView = LayoutInflater.from(IndexShoesActivity.this)
					.inflate(R.layout.view_lv_clothing, null);
			ImageView image = (ImageView) childView
					.findViewById(R.id.img_show_second);
			TextView textName = (TextView) childView
					.findViewById(R.id.text_cloth_name);
			TextView textPrice = (TextView) childView
					.findViewById(R.id.text_cloth_price);
            
			
			textName.setText(listShoes.get(position).getTitle());
			textPrice.setText("￥" + listShoes.get(position).getPrice()+ "");

			// 点击跳转到商品信息详情的界面
			childView.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View arg0) {
					Intent intent=new Intent(IndexShoesActivity.this,ShoesPurseActivity.class);
					intent.putExtra("ShoesId", listShoes.get(position).getId());
					intent.putExtra("ShoesUrl", listShoes.get(position).getUrl());
					intent.putExtra("ShoesTitle", listShoes.get(position).getTitle());
					intent.putExtra("ShoesPrice", listShoes.get(position).getPrice());
					intent.putExtra("ShoesColor1", listShoes.get(position).getColor1());
					intent.putExtra("ShoesColor2", listShoes.get(position).getColor2());
					intent.putExtra("ShoesColor3", listShoes.get(position).getColor3());
					intent.putExtra("ShoesSize1", listShoes.get(position).getSize1());
					intent.putExtra("ShoesSize2", listShoes.get(position).getSize2());
					intent.putExtra("ShoesSize3", listShoes.get(position).getSize3());
					intent.putExtra("ShoesSize4", listShoes.get(position).getSize4());
				
					
					startActivity(intent);

				}
			});

			ImageLoader loader = RequestQueueSingleton.getInstance(
					IndexShoesActivity.this).getImageLoader();
			loader.get(listShoes.get(position).getUrl(), ImageLoader
					.getImageListener(image, R.drawable.ic_launcher,
							R.drawable.ic_launcher), 300, 300);
			return childView;
		}
	}


	
}
