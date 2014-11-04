package com.example.my.grally;

import java.util.ArrayList;
import java.util.List;

import com.android.volley.toolbox.ImageLoader;
import com.example.my.R;
import com.example.my.model.BagsModel;
import com.example.my.ui.IndexClothingActivity;
import com.example.my.utils.RequestQueueSingleton;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class BagsAdapter extends BaseAdapter{
	Context mContext;
   int i=0;
   private List<BagsModel>mlistbags1=new ArrayList<BagsModel>();
   private List<BagsModel>mlistbags2=new ArrayList<BagsModel>();
   private List<BagsModel>mlistbags3=new ArrayList<BagsModel>();
   
   
	//有参构造函数
	public BagsAdapter(int i,Context c){
		this.mContext=c;
		this.i=i;
	}
	
	@Override
	public int getCount() {
	
		switch (i) {
		 case 0:
			return mlistbags1.size();
         case 1:
			mlistbags2.size();
			
			return mlistbags2.size();
         case 2:
	        mlistbags3.size();
	        return mlistbags3.size();
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

		childView = LayoutInflater.from(mContext)
				.inflate(R.layout.view_gv_list, null);
		ImageView image = (ImageView) childView
				.findViewById(R.id.img_bags);
		TextView textName = (TextView) childView
				.findViewById(R.id.text_bags_name);
		TextView textPrice = (TextView) childView
				.findViewById(R.id.text_bags_price);
		
		BagsModel bags=null;
		switch (i) {
		 case 0:
			 bags =mlistbags1.get(position);
			 break;
        case 1:
			bags=mlistbags2.get(position);
			
			break;
        case 2:
	        mlistbags3.size();
	        bags=mlistbags3.get(position);
	        break;
		}
		
        
		
		textName.setText(bags.getTitle());
		textPrice.setText("￥" + bags.getPrice()+ "");

		// 点击跳转到商品信息详情的界面
		childView.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				
				/*  Intent intent = new Intent(ProductDetialsActivity.this,
				  ClothPurseActivity.class); Bundle bundle = new Bundle();
				  bundle.putString("id", listProducts.get(position).id +
				  ""); intent.putExtras(bundle); startActivity(intent);
				 
*/
			}
		});

		ImageLoader loader = RequestQueueSingleton.getInstance(
				mContext).getImageLoader();
		loader.get(bags.getUrl(), ImageLoader
				.getImageListener(image, R.drawable.ic_launcher,
						R.drawable.ic_launcher), 300, 300);
		return childView;
	}

}
