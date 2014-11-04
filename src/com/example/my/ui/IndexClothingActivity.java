package com.example.my.ui;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.toolbox.ImageLoader;
import com.example.my.R;
import com.example.my.grally.ClothingAdapter;
import com.example.my.model.ClothingModel;
import com.example.my.sql.DataUtil;
import com.example.my.utils.RequestQueueSingleton;

public class IndexClothingActivity extends Activity {
	Gallery gallery;
	GridView clothgridview;
	ClothMoreAdapter clothMoreAdapter;

	List<ClothingModel> listCloth = new ArrayList<ClothingModel>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_index_clothingcity);

		listCloth=DataUtil.getClothCatagories(this);
		
	
		
		gallery = (Gallery) findViewById(R.id.index_clothingcity_gallery);
		ClothingAdapter clothAdapter = new ClothingAdapter(this);
		gallery.setAdapter(clothAdapter);
		
		clothgridview = (GridView) findViewById(R.id.gridview_clothingcity);		
		clothMoreAdapter = new ClothMoreAdapter();	
		clothgridview.setAdapter(clothMoreAdapter);
		


	}

	private class ClothMoreAdapter extends BaseAdapter {

		@Override
		public int getCount() {

			return listCloth.size();
		}

		@Override
		public Object getItem(int position) {

			return listCloth.get(position);
		}

		@Override
		public long getItemId(int arg0) {

			return arg0;
		}

		@Override
		public View getView(final int position, View convertView,
				ViewGroup parent) {
			View childView;

			childView = LayoutInflater.from(IndexClothingActivity.this)
					.inflate(R.layout.view_lv_clothing, null);
			ImageView image = (ImageView) childView
					.findViewById(R.id.img_show_second);
			TextView textName = (TextView) childView
					.findViewById(R.id.text_cloth_name);
			TextView textPrice = (TextView) childView
					.findViewById(R.id.text_cloth_price);
            
			
			textName.setText(listCloth.get(position).getTitle());
			textPrice.setText("￥" + listCloth.get(position).getPrice()+ "");

			// 点击跳转到商品信息详情的界面
			childView.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View arg0) {
					Intent intent=new Intent(IndexClothingActivity.this,ClothPurseActivity.class);
					intent.putExtra("ClothId", listCloth.get(position).getId());
					intent.putExtra("ClothName", listCloth.get(position).getName());
					intent.putExtra("ClothTitle", listCloth.get(position).getTitle());
					intent.putExtra("ClothPrice", listCloth.get(position).getPrice());
					intent.putExtra("ClothColor1", listCloth.get(position).getColor1());
					intent.putExtra("ClothColor2", listCloth.get(position).getColor2());
					intent.putExtra("ClothColor3", listCloth.get(position).getColor3());
					intent.putExtra("ClothSize1", listCloth.get(position).getSize1());
					intent.putExtra("ClothSize2", listCloth.get(position).getSize2());
					intent.putExtra("ClothSize3", listCloth.get(position).getSize3());
					intent.putExtra("ClothSize4", listCloth.get(position).getSize4());
					intent.putExtra("ClothSize5", listCloth.get(position).getSize5());
					intent.putExtra("ClothStore", listCloth.get(position).getStore());
					
					startActivity(intent);

				}
			});

			ImageLoader loader = RequestQueueSingleton.getInstance(
					IndexClothingActivity.this).getImageLoader();
			loader.get(listCloth.get(position).getName(), ImageLoader
					.getImageListener(image, R.drawable.ic_launcher,
							R.drawable.ic_launcher), 300, 300);
			return childView;
		}
	}

	
	
}
