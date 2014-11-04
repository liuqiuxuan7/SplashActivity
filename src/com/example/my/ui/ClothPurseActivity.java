package com.example.my.ui;

import com.android.volley.toolbox.ImageLoader;
import com.example.my.R;

import com.example.my.model.CollectionModel;
import com.example.my.model.CollectionTools;
import com.example.my.model.ShoppingCartModel;
import com.example.my.model.ShoppingTools;
import com.example.my.utils.CommonTools;
import com.example.my.utils.RequestQueueSingleton;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout.LayoutParams;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class ClothPurseActivity extends Activity implements OnClickListener{
  ImageView imageView;
  LinearLayout  ll_color,ll_size;
  TextView text_price,tv_name,tv_inventory;
  Button btn_shopping,bt_addcollect;
  LayoutParams params ;
  EditText et_count_cloth;
  int store;
  Intent intent;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cloth_purse);
		
		initialWidget();
		intent=this.getIntent();
		loadImage();
		loadPrice();
		loadColor();
	}
	private void initialWidget(){
		imageView=(ImageView)findViewById(R.id.image_detail);
		text_price=(TextView)findViewById(R.id.text_price);
		tv_inventory=(TextView)findViewById(R.id.tv_inventory);
		
		tv_name=(TextView)findViewById(R.id.tv_name);
		ll_color=(LinearLayout)findViewById(R.id.ll_color);
		ll_size=(LinearLayout)findViewById(R.id.ll_size);
		et_count_cloth=(EditText)findViewById(R.id.et_count_cloth);
		
		
		btn_shopping=(Button)findViewById(R.id.btn_shopping);
		btn_shopping.setOnClickListener(this);
		bt_addcollect=(Button)findViewById(R.id.bt_addcollect);
		bt_addcollect.setOnClickListener(this);
		
	}
	private void loadImage(){
            String url= intent.getStringExtra("ClothName");          
		    ImageLoader loader = RequestQueueSingleton.getInstance(
			ClothPurseActivity.this).getImageLoader();
	        loader.get(url, ImageLoader.getImageListener(imageView,
			R.drawable.ic_launcher, R.drawable.ic_launcher), 300, 300);
	}
	
	private void loadPrice(){
		Float price=intent.getFloatExtra("ClothPrice", -1);
	    text_price.setText("￥"+price+"");
	    String title=intent.getStringExtra("ClothTitle");
	    tv_name.setText(title);	   
	    
	    store=intent.getIntExtra("ClothStore", -1);
	    tv_inventory.setText(store+"");
	    
	}
	
	//动态加载颜色
	private void loadColor(){
		 String color1=intent.getStringExtra("ClothColor1");  
	   // params=new LayoutParams(width, height);
		 params=new LayoutParams(90,50);
		// params.setMargins(left, top, right, bottom);
		 params.setMargins(16, 0, 4, 8);		 
		 TextView view=new TextView(ClothPurseActivity.this);
		 view.setLayoutParams(params);
		 view.setText(color1);
		 ll_color.addView(view);
		 
		 String color2=intent.getStringExtra("ClothColor2");    
		 params=new LayoutParams(90,50);
		 params.setMargins(16, 0, 4, 8);		 
		 TextView view2=new TextView(ClothPurseActivity.this);
		 view2.setLayoutParams(params);
		 view2.setText(color2);
		 ll_color.addView(view2);
		 
		 String color3=intent.getStringExtra("ClothColor3");    
		 params=new LayoutParams(90,50);
		 params.setMargins(16, 0, 4, 8);		 
		 TextView view3=new TextView(ClothPurseActivity.this);
		 view3.setLayoutParams(params);
		 view3.setText(color3);
		 ll_color.addView(view3);
		
		 
		 
		 String size1=intent.getStringExtra("ClothSize1");
		 params=new LayoutParams(50,50);
		 params.setMargins(16, 0, 4, 8);	
		 TextView btn1=new TextView(ClothPurseActivity.this);	
		 btn1.setLayoutParams(params);
		 btn1.setText(size1);
		 ll_size.addView(btn1);
		 
		 String size2=intent.getStringExtra("ClothSize2");
		 params=new LayoutParams(50,50);
		 params.setMargins(16, 0, 4, 8);	
		 TextView btn2=new TextView(ClothPurseActivity.this);	
		 btn2.setLayoutParams(params);
		 btn2.setText(size2);
		 ll_size.addView(btn2);
		 
		 String size3=intent.getStringExtra("ClothSize3");
		 params=new LayoutParams(50,50);
		 params.setMargins(16, 0, 4, 8);	
		 TextView btn3=new TextView(ClothPurseActivity.this);	
		 btn3.setLayoutParams(params);
		 btn3.setText(size3);
		 ll_size.addView(btn3);
		 
		 String size4=intent.getStringExtra("ClothSize4");
		 params=new LayoutParams(50,50);
		 params.setMargins(16, 0, 4, 8);	
		 TextView btn4=new TextView(ClothPurseActivity.this);	
		 btn4.setLayoutParams(params);
		 btn4.setText(size4);
		 ll_size.addView(btn4);
		 
		 String size5=intent.getStringExtra("ClothSize5");
		 params=new LayoutParams(50,50);
		 params.setMargins(16, 0, 4, 8);	
		 TextView btn5=new TextView(ClothPurseActivity.this);	
		 btn5.setLayoutParams(params);
		 btn5.setText(size5);
		 ll_size.addView(btn5);	
		 
	}
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_shopping:
			
			ShoppingCartModel scm = new ShoppingCartModel();
			scm.setTitle(intent.getStringExtra("ClothTitle"));
			scm.setPrice(intent.getFloatExtra("ClothPrice", -1));
			scm.setUrl(intent.getStringExtra("ClothName"));
			if(!"".equals(et_count_cloth.getText().toString())){
				int i=Integer.parseInt(et_count_cloth.getText().toString());
				   scm.setNum(i);	
				  if(i<=store&&i>0&&!"".equals(et_count_cloth.getText().toString())){
					  ShoppingTools.getListInstance().add(scm);
					  Toast.makeText(this, "成功加入購物車", Toast.LENGTH_LONG).show();
				  }else{
					  new AlertDialog.Builder(this)./*setTitle("请重新输入库存量").*/setMessage("请重新输入库存量").
						/*setNegativeButton("取消", null).*/setPositiveButton("确定", null).create().show();
				  }
				
			}else{
				 new AlertDialog.Builder(this)./*setTitle("请输入库存量").*/setMessage("请输入库存量").
					/*setNegativeButton("取消", null).*/setPositiveButton("确定", null).create().show();
			}
			
			
			
			/*CommonTools.showShortToast(ClothPurseActivity.this, "成功加入购物车");*/
			
			
			break;
    case R.id.bt_addcollect:
    	   CollectionModel cm=new CollectionModel();
    	   cm.setTitle(intent.getStringExtra("ClothTitle"));
    	   cm.setPrice(intent.getFloatExtra("ClothPrice", -1));
    	   cm.setUrl(intent.getStringExtra("ClothName"));
    	   CollectionTools.getInstance().add(cm);
    	   Toast.makeText(this, "成功添加收藏", Toast.LENGTH_LONG).show();
    	   break;
		
		}
		
	}

}
