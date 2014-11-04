package com.example.my.ui;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
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
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;

import com.example.my.R;
import com.example.my.model.BagsModel;
import com.example.my.sql.DataUtil;
import com.example.my.ui.base.BaseActivity;
import com.example.my.utils.RequestQueueSingleton;

public class IndexBagsActivity extends BaseActivity implements OnClickListener {

	private GridView gridview;
	private Button btnBags1, btnBags2, btnBags3;
	private BagsAdapter bagsAdapter=null;
	List<BagsModel> listBags1 = new ArrayList<BagsModel>();
	List<BagsModel> listBags2 = new ArrayList<BagsModel>();
	List<BagsModel> listBags3 = new ArrayList<BagsModel>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_index_bags);
		listBags1=DataUtil.getBags1(this);
		listBags2=DataUtil.getBags2(this);
		listBags3=DataUtil.getBags3(this);
		
		gridview = (GridView) findViewById(R.id.grid_bags);
		btnBags1=(Button)findViewById(R.id.btn_bag1);
		btnBags2=(Button)findViewById(R.id.btn_bag2);
		btnBags3=(Button)findViewById(R.id.btn_bag3);
		btnBags1.setOnClickListener(this);
		btnBags2.setOnClickListener(this);
		btnBags3.setOnClickListener(this);
		
		if(bagsAdapter==null){
		bagsAdapter = new BagsAdapter(0);
		gridview.setAdapter(bagsAdapter);
		
		
	gridview.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int position,
					long arg3) {
				 Intent intent = new Intent(IndexBagsActivity.this,BagsPurseActivity.class);
				  switch (bagsAdapter.i) {
				case 0: 
					intent.putExtra("bagsAdapter", 0);
					intent.putExtra("Bags1Id", listBags1.get(position).getId());
					intent.putExtra("Bags1Url", listBags1.get(position).getUrl());
					intent.putExtra("Bags1Title", listBags1.get(position).getTitle());
					intent.putExtra("Bags1Price", listBags1.get(position).getPrice());
					intent.putExtra("Bags1Color1", listBags1.get(position).getColor1());
					intent.putExtra("Bags1Color2", listBags1.get(position).getColor2());
					intent.putExtra("Bags1Color3", listBags1.get(position).getColor3());
					intent.putExtra("Bags1Store", listBags1.get(position).getStore());
					break;

				case 1:
					intent.putExtra("bagsAdapter", 1);
					intent.putExtra("Bags2Id", listBags2.get(position).getId());
					intent.putExtra("Bags2Url", listBags2.get(position).getUrl());
					intent.putExtra("Bags2Title", listBags2.get(position).getTitle());
					intent.putExtra("Bags2Price", listBags2.get(position).getPrice());
					intent.putExtra("Bags2Color1", listBags2.get(position).getColor1());
					intent.putExtra("Bags2Color2", listBags2.get(position).getColor2());
					intent.putExtra("Bags2Color3", listBags2.get(position).getColor3());
					intent.putExtra("Bags2Store", listBags1.get(position).getStore());
					break;
					
				case 2:
					intent.putExtra("bagsAdapter", 2);
					intent.putExtra("Bags3Id", listBags3.get(position).getId());
					intent.putExtra("Bags3Url", listBags3.get(position).getUrl());
					intent.putExtra("Bags3Title", listBags3.get(position).getTitle());
					intent.putExtra("Bags3Price", listBags3.get(position).getPrice());
					intent.putExtra("Bags3Color1", listBags3.get(position).getColor1());
					intent.putExtra("Bags3Color2", listBags3.get(position).getColor2());
					intent.putExtra("Bags3Color3", listBags3.get(position).getColor3());
					intent.putExtra("Bags3Store", listBags1.get(position).getStore());
					break;
				}
				    
					
						
					
				 
				 startActivity(intent);
				 
				
			}
		});
		}
	}

	public class BagsAdapter extends BaseAdapter {

		public int i = 0;
		// 有参构造函数
		public BagsAdapter(int i) {

			this.i = i;
		}

		@Override
		public int getCount() {

			switch (i) {
			case 0:
				return listBags1.size();
			case 1:
				

				return listBags2.size();
			case 2:
	
				return listBags3.size();
			}
			return i;

		}

		@Override
		public Object getItem(int arg0) {

			return null;
		}

		@Override
		public long getItemId(int arg0) {

			return 0;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {

			View childView;

			childView = LayoutInflater.from(IndexBagsActivity.this).inflate(
					R.layout.view_gv_list, null);
			ImageView image = (ImageView) childView.findViewById(R.id.img_bags);
			TextView textName = (TextView) childView
					.findViewById(R.id.text_bags_name);
			TextView textPrice = (TextView) childView
					.findViewById(R.id.text_bags_price);

			BagsModel bags = null;
			switch (i) {
			case 0:
				bags = listBags1.get(position);
	
				break;
			case 1:
				bags = listBags2.get(position);

				break;
			case 2:
				
				bags = listBags3.get(position);
				break;
			}

			textName.setText(bags.getTitle());
			textPrice.setText("￥" + bags.getPrice() + "");

			ImageLoader loader = RequestQueueSingleton.getInstance(
					IndexBagsActivity.this).getImageLoader();
			loader.get(bags.getUrl(), ImageLoader.getImageListener(image,
					R.drawable.ic_launcher, R.drawable.ic_launcher), 300, 300);
			return childView;
		}

	}

	@Override
	protected void findViewById() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void initView() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_bag1:
			gridview.setAdapter(null);
			bagsAdapter = new BagsAdapter(0);
			gridview.setAdapter(bagsAdapter);
			/*gridview.setOnItemClickListener(new OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> arg0, View arg1,
						int arg2, long arg3) {
					Intent intent = new Intent(IndexBagsActivity.this,ClothPurseActivity.class);
					 startActivity(intent);
					
				}
			});
*/
			break;
		case R.id.btn_bag2:
			gridview.setAdapter(null);
			bagsAdapter = new BagsAdapter(1);
			gridview.setAdapter(bagsAdapter);
			/*gridview.setOnItemClickListener(new OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> arg0, View arg1,
						int arg2, long arg3) {
					Intent intent = new Intent(IndexBagsActivity.this,ClothPurseActivity.class);
					 startActivity(intent);
					
				}
			});
*/
			break;
		case R.id.btn_bag3:
			gridview.setAdapter(null);
			bagsAdapter = new BagsAdapter(2);
			gridview.setAdapter(bagsAdapter);
			/*gridview.setOnItemClickListener(new OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> arg0, View arg1,
						int arg2, long arg3) {
					Intent intent = new Intent(IndexBagsActivity.this,ClothPurseActivity.class);
					 startActivity(intent);
					
				}
			});*/

			break;

		}

	}

}
