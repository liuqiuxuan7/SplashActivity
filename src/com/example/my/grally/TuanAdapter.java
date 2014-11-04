package com.example.my.grally;

import java.util.List;

import com.android.volley.toolbox.ImageLoader;
import com.example.my.R;
import com.example.my.model.TuanModel;
import com.example.my.utils.RequestQueueSingleton;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class TuanAdapter extends BaseAdapter{
	private Context mContext;
	private List<TuanModel> listTuans;
	
	public TuanAdapter(Context context, List<TuanModel> listTuan ) {
		this.mContext = context;
		this.listTuans = listTuan;
	}

	@Override
	public int getCount() {
		return listTuans.size();
	}

	@Override
	public Object getItem(int arg0) {
		return listTuans.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		return 0;
	}

	@Override
	public View getView(int position, View contentView, ViewGroup parent) {
		View view = contentView;
		ViewHolder holder;
		
		if(view == null) {
			holder = new ViewHolder();
			view = LayoutInflater.from(mContext).inflate(R.layout.view_tuan_list, null);
			

			holder.ivTodayPurchase = (ImageView) view.findViewById(R.id.iv_todaypurchase);
			
			holder.tvName = (TextView) view.findViewById(R.id.tv_name);
			holder.tvIsRequied = (TextView) view.findViewById(R.id.tv_is_reservation_required);
			holder.tvPrice = (TextView) view.findViewById(R.id.tv_price);
			
			view.setTag(holder);
		}else {
			holder = (ViewHolder) view.getTag();
		}

		// 图片地址
		String imgUrl = listTuans.get(position).image_url;
		// 下载图片
		ImageLoader imageLoader = RequestQueueSingleton.getInstance(
				mContext).getImageLoader();
		// 图片地址，默认图片，错误图片
		imageLoader.get(imgUrl, imageLoader.getImageListener(holder.ivTodayPurchase,
				R.drawable.a, R.drawable.a), 300, 200);
		
		holder.tvName.setText(listTuans.get(position).title);
		holder.tvPrice.setText(listTuans.get(position).description);
		
		//判断是否需要预约
		String isRequired = String.valueOf(listTuans.get(position).restrictions_is_refundable);
		if("0".equals(isRequired)) {
			holder.tvIsRequied.setText("免预约");
		}else {
			holder.tvIsRequied.setText("预约");
		}
		
		

		return view;
	}
	
	private class ViewHolder {
		ImageView ivTodayPurchase;
		TextView tvName, tvAddress, tvIsRequied, tvPrice;
	}
}
