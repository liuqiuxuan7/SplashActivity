package com.example.my.ui;

import java.util.ArrayList;
import java.util.List;

import com.android.volley.toolbox.ImageLoader;
import com.example.my.R;
import com.example.my.R.layout;
import com.example.my.R.menu;
import com.example.my.model.Protection;
import com.example.my.sql.DataUtil;

import com.example.my.utils.RequestQueueSingleton;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

public class IndexOtherActivity extends Activity {
    GridView grid_other;
	
	OtherAdapter otherAdapter;

	List<Protection> listOther = new ArrayList<Protection>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_index_other);

		listOther=DataUtil.getOther(this);
		
	
		
		/*gallery = (Gallery) findViewById(R.id.index_clothingcity_gallery);
		ClothingAdapter clothAdapter = new ClothingAdapter(this);
		gallery.setAdapter(clothAdapter);*/
		
		grid_other = (GridView) findViewById(R.id.grid_other);		
		otherAdapter = new OtherAdapter();	
		grid_other.setAdapter(otherAdapter);
		
	}
	private class OtherAdapter extends BaseAdapter {

		@Override
		public int getCount() {

			return listOther.size();
		}

		@Override
		public Object getItem(int position) {

			return listOther.get(position);
		}

		@Override
		public long getItemId(int arg0) {

			return arg0;
		}

		@Override
		public View getView(final int position, View convertView,
				ViewGroup parent) {
			View childView;

			childView = LayoutInflater.from(IndexOtherActivity.this)
					.inflate(R.layout.view_lv_clothing, null);
			ImageView image = (ImageView) childView
					.findViewById(R.id.img_show_second);
			TextView textName = (TextView) childView
					.findViewById(R.id.text_cloth_name);
			TextView textPrice = (TextView) childView
					.findViewById(R.id.text_cloth_price);
            
			
			textName.setText(listOther.get(position).getTitle());
			textPrice.setText("￥" + listOther.get(position).getPrice()+ "");

			// 点击跳转到商品信息详情的界面
			/*childView.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View arg0) {
					Intent intent=new Intent(IndexOtherActivity.this,ClothPurseActivity.class);
					intent.putExtra("ProtectionId", listOther.get(position).getId());
					intent.putExtra("ProtectionTitle", listOther.get(position).getTitle());
					intent.putExtra("ProtectionPrice", listOther.get(position).getPrice());	
					intent.putExtra("ProtectionStore", listOther.get(position).getStore());
					
					startActivity(intent);

				}
			});*/

			ImageLoader loader = RequestQueueSingleton.getInstance(
					IndexOtherActivity.this).getImageLoader();
			loader.get(listOther.get(position).getUrl(), ImageLoader
					.getImageListener(image, R.drawable.ic_launcher,
							R.drawable.ic_launcher), 300, 300);
			return childView;
		}
	}
}
