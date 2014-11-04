package com.example.my.ui;

import com.android.volley.toolbox.ImageLoader;
import com.example.my.R;
import com.example.my.model.CollectionModel;
import com.example.my.model.CollectionTools;
import com.example.my.model.ShoppingCartModel;
import com.example.my.model.ShoppingTools;
import com.example.my.utils.RequestQueueSingleton;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.LinearLayout.LayoutParams;

public class ShoesPurseActivity extends Activity implements OnClickListener{
	ImageView imageView;
	  LinearLayout  ll_shoes_color,ll_shoes_size;
	  TextView text_price,tv_name;
	  LayoutParams params ;
	  Button btn_shose_shopping,bt_shose_addcollect;
	  Intent intent;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_shoes_purse);
		
		initialWidget();
		intent=this.getIntent();
		loadImage();
		loadPrice();
		loadColor();
		
	}
	private void initialWidget(){
		imageView=(ImageView)findViewById(R.id.image_shose_detail);
		text_price=(TextView)findViewById(R.id.text_shoes_price);
		tv_name=(TextView)findViewById(R.id.tv_shose_name);
		ll_shoes_color=(LinearLayout)findViewById(R.id.ll_shoes_color);
		ll_shoes_size=(LinearLayout)findViewById(R.id.ll_shoes_size);
		
		btn_shose_shopping=(Button)findViewById(R.id.btn_shose_shopping);
		bt_shose_addcollect=(Button)findViewById(R.id.bt_shose_addcollect);
		btn_shose_shopping.setOnClickListener(this);
		bt_shose_addcollect.setOnClickListener(this);
		
		
	}
	
	private void loadImage(){
			String urlShoes= intent.getStringExtra("ShoesUrl");          
		    ImageLoader loaderShoes = RequestQueueSingleton.getInstance(
			ShoesPurseActivity.this).getImageLoader();
	        loaderShoes.get(urlShoes, ImageLoader.getImageListener(imageView,
			R.drawable.ic_launcher, R.drawable.ic_launcher), 300, 300);
	
		}
	
	private void loadPrice(){

			Float priceShoes=intent.getFloatExtra("ShoesPrice", -1);
		    text_price.setText("￥"+priceShoes+"");
		    String titleShoes=intent.getStringExtra("ShoesTitle");
		    tv_name.setText(titleShoes);	
		    
	}

	//动态加载颜色
		private void loadColor(){
			 String color1=intent.getStringExtra("ShoesColor1");  
		   // params=new LayoutParams(width, height);
			 params=new LayoutParams(90,50);
			// params.setMargins(left, top, right, bottom);
			 params.setMargins(16, 0, 4, 8);		 
			 TextView view=new TextView(ShoesPurseActivity.this);
			 view.setLayoutParams(params);
			 view.setText(color1);
			 ll_shoes_color.addView(view);
			 
			 String color2=intent.getStringExtra("ShoesColor2");    
			 params=new LayoutParams(90,50);
			 params.setMargins(16, 0, 4, 8);		 
			 TextView view2=new TextView(ShoesPurseActivity.this);
			 view2.setLayoutParams(params);
			 view2.setText(color2);
			 ll_shoes_color.addView(view2);
			 
			 String color3=intent.getStringExtra("ShoesColor3");    
			 params=new LayoutParams(90,50);
			 params.setMargins(16, 0, 4, 8);		 
			 TextView view3=new TextView(ShoesPurseActivity.this);
			 view3.setLayoutParams(params);
			 view3.setText(color3);
			 ll_shoes_color.addView(view3);
			
			 
			
			 String size1=intent.getStringExtra("ShoesSize1");
			 params=new LayoutParams(50,50);
			 params.setMargins(16, 0, 4, 8);	
			 TextView btn1=new TextView(ShoesPurseActivity.this);	
			 btn1.setLayoutParams(params);
			 btn1.setText(size1);
			 ll_shoes_size.addView(btn1);
			 
			 String size2=intent.getStringExtra("ShoesSize2");
			 params=new LayoutParams(50,50);
			 params.setMargins(16, 0, 4, 8);	
			 TextView btn2=new TextView(ShoesPurseActivity.this);	
			 btn2.setLayoutParams(params);
			 btn2.setText(size2);
			 ll_shoes_size.addView(btn2);
			 
			 String size3=intent.getStringExtra("ShoesSize3");
			 params=new LayoutParams(50,50);
			 params.setMargins(16, 0, 4, 8);	
			 TextView btn3=new TextView(ShoesPurseActivity.this);	
			 btn3.setLayoutParams(params);
			 btn3.setText(size3);
			 ll_shoes_size.addView(btn3);
			 
			 String size4=intent.getStringExtra("ShoesSize4");
			 params=new LayoutParams(50,50);
			 params.setMargins(16, 0, 4, 8);	
			 TextView btn4=new TextView(ShoesPurseActivity.this);	
			 btn4.setLayoutParams(params);
			 btn4.setText(size4);
			 ll_shoes_size.addView(btn4);
			
			
			 
		}
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_shose_shopping:
			ShoppingCartModel scm=new ShoppingCartModel();
			scm.setUrl(intent.getStringExtra("ShoesUrl"));
			scm.setTitle(intent.getStringExtra("ShoesTitle"));
			scm.setPrice(intent.getFloatExtra("ShoesPrice", -1));
			ShoppingTools.getListInstance().add(scm);
			Toast.makeText(this, "成功加入購物車",Toast.LENGTH_LONG).show();
			break;
			case R.id.bt_shose_addcollect:
			CollectionModel cm=new CollectionModel();
	    	   cm.setTitle(intent.getStringExtra("ShoesTitle"));
	    	   cm.setPrice(intent.getFloatExtra("ShoesPrice", -1));
	    	   cm.setUrl(intent.getStringExtra("ShoesUrl"));
	    	   CollectionTools.getInstance().add(cm);
	    	   Toast.makeText(this, "成功添加收藏", Toast.LENGTH_LONG).show();
	    	   break;
		}
		
		
	}
}
