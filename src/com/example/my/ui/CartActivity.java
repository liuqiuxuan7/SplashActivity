package com.example.my.ui;

import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.example.my.R;
import com.example.my.model.ShoppingCartModel;
import com.example.my.model.ShoppingTools;
import com.example.my.ui.base.BaseActivity;
import com.example.my.utils.RequestQueueSingleton;


public class CartActivity extends BaseActivity  implements OnClickListener{
    ListView listCart;
    float price=0;
    List<ShoppingCartModel> data;
    Button  btn_acount,btn_back_cart;
    TextView tv_count_money;
    ShoppingAdapter shoppingAdapter=new ShoppingAdapter();
	private Intent mIntent;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cart);
		data = ShoppingTools.getListInstance();
		
		findViewById();
		
		listCart.setAdapter(shoppingAdapter);
		
		
		initView();
		
	}

	@Override
	protected void findViewById() {
		listCart=(ListView)findViewById(R.id.list_cart);
		tv_count_money=(TextView)findViewById(R.id.tv_count_money);
		for(ShoppingCartModel p:data){
			price+=p.getPrice()*p.getNum();	
		} 
		tv_count_money.setText(price+"");
		btn_acount=(Button)findViewById(R.id.btn_acount);
		btn_back_cart=(Button)findViewById(R.id.btn_back_cart);
		btn_acount.setOnClickListener(this);
		btn_back_cart.setOnClickListener(this);
		
		
	}

	@Override
	protected void initView() {
		

	}

	private class ShoppingAdapter extends BaseAdapter{

		@Override
		public int getCount() {
			
			return data.size();
		}

		@Override
		public Object getItem(int position) {
			
			return data.get(position);
		}

		@Override
		public long getItemId(int position) {
			
			return position;
		}

		@Override
		public View getView(final int position, View convertView, ViewGroup parent) {
			View childView;

			childView = LayoutInflater.from(CartActivity.this)
					.inflate(R.layout.view_cart_listview, null);
			ImageView image = (ImageView) childView
					.findViewById(R.id.img_shopping);
			TextView textName = (TextView) childView
					.findViewById(R.id.text_shopping_name);
			TextView textPrice = (TextView) childView
					.findViewById(R.id.text_shopping_price);
			TextView textCount=(TextView) childView
					.findViewById(R.id.tv_count);
			Button btn_cart_delete=(Button)childView.
					findViewById(R.id.btn_cart_delete);
			btn_cart_delete.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					if(data!=null){
						data.remove(position);
						notifyDataSetChanged();
					}
				}
			});
			
			textName.setText(data.get(position).getTitle());
			textPrice.setText("￥"+data.get(position).getPrice()+"");
			textCount.setText(data.get(position).getNum()+"");
			  
			ImageLoader loader = RequestQueueSingleton.getInstance(
					CartActivity.this).getImageLoader();
			loader.get(data.get(position).getUrl(), ImageLoader
					.getImageListener(image, R.drawable.ic_launcher,
							R.drawable.ic_launcher), 300, 300);
			
			
			return childView	;
		}
		
	}

	@Override
	public void onClick(View v) {
	  switch (v.getId()) {
	case R.id.btn_acount:
		Intent intent=new Intent(CartActivity.this,PurseMainActivity.class);
		startActivity(intent);
		break;

	case R.id.btn_back_cart:
		finish();
		
	}
		
	}

}
