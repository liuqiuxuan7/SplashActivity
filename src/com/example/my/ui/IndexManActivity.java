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
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.example.my.R;
import com.example.my.model.Protection;
import com.example.my.sql.DataUtil;

import com.example.my.utils.RequestQueueSingleton;

public class IndexManActivity extends Activity {
	GridView grid_man;
	
	ManAdapter manAdapter;

	List<Protection> listMan = new ArrayList<Protection>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_index_man);

		listMan=DataUtil.getMan(this);
		
	
		
		/*gallery = (Gallery) findViewById(R.id.index_clothingcity_gallery);
		ClothingAdapter clothAdapter = new ClothingAdapter(this);
		gallery.setAdapter(clothAdapter);*/
		
		grid_man = (GridView) findViewById(R.id.grid_man);		
		manAdapter = new ManAdapter();	
		grid_man.setAdapter(manAdapter);
		
	}
	private class ManAdapter extends BaseAdapter {

		@Override
		public int getCount() {

			return listMan.size();
		}

		@Override
		public Object getItem(int position) {

			return listMan.get(position);
		}

		@Override
		public long getItemId(int arg0) {

			return arg0;
		}

		@Override
		public View getView(final int position, View convertView,
				ViewGroup parent) {
			View childView;

			childView = LayoutInflater.from(IndexManActivity.this)
					.inflate(R.layout.view_lv_clothing, null);
			ImageView image = (ImageView) childView
					.findViewById(R.id.img_show_second);
			TextView textName = (TextView) childView
					.findViewById(R.id.text_cloth_name);
			TextView textPrice = (TextView) childView
					.findViewById(R.id.text_cloth_price);
            
			
			textName.setText(listMan.get(position).getTitle());
			textPrice.setText("￥" + listMan.get(position).getPrice()+ "");

			// 点击跳转到商品信息详情的界面
			/*childView.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View arg0) {
					Intent intent=new Intent(IndexManActivity.this,ClothPurseActivity.class);
					intent.putExtra("ProtectionId", listMan.get(position).getId());
					intent.putExtra("ProtectionTitle", listMan.get(position).getTitle());
					intent.putExtra("ProtectionPrice", listMan.get(position).getPrice());	
					intent.putExtra("ProtectionStore", listMan.get(position).getStore());
					
					startActivity(intent);

				}
			});*/

			ImageLoader loader = RequestQueueSingleton.getInstance(
					IndexManActivity.this).getImageLoader();
			loader.get(listMan.get(position).getUrl(), ImageLoader
					.getImageListener(image, R.drawable.ic_launcher,
							R.drawable.ic_launcher), 300, 300);
			return childView;
		}
	}

	
}
