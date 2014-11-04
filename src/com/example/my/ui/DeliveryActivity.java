package com.example.my.ui;

import java.util.ArrayList;
import java.util.List;

import com.example.my.R;
import com.example.my.R.layout;
import com.example.my.R.menu;
import com.example.my.model.DeliveryModel;


import android.os.Bundle;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class DeliveryActivity extends Activity {
	private LayoutInflater layoutInflater;
	List<DeliveryModel>listdelivery=new ArrayList<DeliveryModel>();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_delivery);
	}

	private class CatergorAdapter extends BaseAdapter{

		@Override
		public int getCount() {
		return 	listdelivery.size();
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return 0;
		}

		@SuppressWarnings("null")
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {

			ViewHolder holder=new ViewHolder();
			layoutInflater=LayoutInflater.from(DeliveryActivity.this);
			
			//组装数据
			if(convertView==null){
				convertView=layoutInflater.inflate(R.layout.view_list_delivery, null);
				holder.image=(ImageView) convertView.findViewById(R.id.catergory_image);
				holder.title=(TextView) convertView.findViewById(R.id.catergoryitem_title);
				holder.content=(TextView) convertView.findViewById(R.id.catergoryitem_content);
				//使用tag存储数据
				convertView.setTag(holder);
			}else{
				holder=(ViewHolder) convertView.getTag();
			}	
			   return convertView;
		}	
		
	}	
		 public static class ViewHolder {
				ImageView image;
				TextView title;
				TextView content;
			}
	
	

}
