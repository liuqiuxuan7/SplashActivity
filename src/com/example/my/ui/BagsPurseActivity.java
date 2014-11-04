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
import android.app.AlertDialog;
import android.content.Intent;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.LinearLayout.LayoutParams;

public class BagsPurseActivity extends Activity implements OnClickListener{
	ImageView imageView;
	LinearLayout ll_color;
	TextView tv__bag_price, tv_bag_name,tv_bag_inventory;
	LayoutParams params;
	Button btn_bag_shopping;
	 EditText et_bag_count;
	Intent intent;
	int i,store;
 

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_bags_purse);
		i=getIntent().getIntExtra("bagsAdapter", -1);
		
		initialWidget();
		intent=this.getIntent();
		loadImage();
		loadPrice();
		loadColor();
	}

	private void initialWidget() {
		imageView = (ImageView) findViewById(R.id.image_bag_detail);
		ll_color = (LinearLayout) findViewById(R.id.ll_bag_color);
		tv__bag_price = (TextView) findViewById(R.id.tv_bag_price);
		et_bag_count=(EditText)findViewById(R.id.et_bag_count);
		
		tv_bag_name = (TextView) findViewById(R.id.tv_bag_name);
		tv_bag_inventory=(TextView)findViewById(R.id.tv_bag_inventory);
		btn_bag_shopping=(Button)findViewById(R.id.btn_bag_shopping);
		btn_bag_shopping.setOnClickListener(this);
	}

	private void loadImage() {
		switch (i) {
		case 0:                                 
			String url0= intent.getStringExtra("Bags1Url");
			ImageLoader loader0 = RequestQueueSingleton.getInstance(
					BagsPurseActivity.this).getImageLoader();
			loader0.get(url0, ImageLoader.getImageListener(imageView,
					R.drawable.ic_launcher, R.drawable.ic_launcher), 300, 300);
			break;

		case 1:
			String url1 = intent.getStringExtra("Bags2Url");
			ImageLoader loader1 = RequestQueueSingleton.getInstance(
					BagsPurseActivity.this).getImageLoader();
			loader1.get(url1, ImageLoader.getImageListener(imageView,
					R.drawable.ic_launcher, R.drawable.ic_launcher), 300, 300);
			break;
		case 2:
			String url2 = intent.getStringExtra("Bags3Url");
			ImageLoader loader2 = RequestQueueSingleton.getInstance(
					BagsPurseActivity.this).getImageLoader();
			loader2.get(url2, ImageLoader.getImageListener(imageView,
					R.drawable.ic_launcher, R.drawable.ic_launcher), 300, 300);
			break;
		}
		
	}

	private void loadPrice() {
		switch (i) {
		case 0:
			Float price = intent.getFloatExtra("Bags1Price", -1);
			tv__bag_price.setText("￥" + price + "");
			String title = intent.getStringExtra("Bags1Title");
			tv_bag_name.setText(title);
			store=intent.getIntExtra("Bags1Store", -1);
			tv_bag_inventory.setText(store+"");
		
			break;
		case 1:
			Float price1 = intent.getFloatExtra("Bags2Price", -1);
			tv__bag_price.setText("￥" + price1 + "");
			String title1 = intent.getStringExtra("Bags2Title");
			tv_bag_name.setText(title1);
			store=intent.getIntExtra("Bags2Store", -1);
			tv_bag_inventory.setText(store+"");
			break;
			
		case 2:
			Float price2 = intent.getFloatExtra("Bags3Price", -1);
			tv__bag_price.setText("￥" + price2 + "");
			String title2 = intent.getStringExtra("Bags3Title");
			tv_bag_name.setText(title2);	
			store=intent.getIntExtra("Bags3Store", -1);
			tv_bag_inventory.setText(store+"");
			break;
		
		}
	}

	// 动态加载颜色
	private void loadColor() {
		
		switch (i) {
		case 0:
			String color1 = intent.getStringExtra("Bags1Color1");
			// params=new LayoutParams(width, height);
			params = new LayoutParams(90, 50);
			// params.setMargins(left, top, right, bottom);
			params.setMargins(16, 0, 4, 8);
			TextView view = new TextView(BagsPurseActivity.this);
			view.setLayoutParams(params);
			view.setText(color1);
			ll_color.addView(view);
			
			String color2 = intent.getStringExtra("Bags1Color2");
			params = new LayoutParams(90, 50);
			params.setMargins(16, 0, 4, 8);
			TextView view2 = new TextView(BagsPurseActivity.this);
			view2.setLayoutParams(params);
			view2.setText(color2);
			ll_color.addView(view2);
			
			String color3 = intent.getStringExtra("Bags1Color3");
			params = new LayoutParams(90, 50);
			params.setMargins(16, 0, 4, 8);
			TextView view3 = new TextView(BagsPurseActivity.this);
			view3.setLayoutParams(params);
			view3.setText(color3);
			ll_color.addView(view3);
			break;
			
		case 1:

			String color21 = intent.getStringExtra("Bags2Color1");
			params = new LayoutParams(90, 50);
			params.setMargins(16, 0, 4, 8);
			TextView view21 = new TextView(BagsPurseActivity.this);
			view21.setLayoutParams(params);
			view21.setText(color21);
			ll_color.addView(view21);
			
			

			String color22=intent.getStringExtra("Bags2Color1");
			params = new LayoutParams(90, 50);
			params.setMargins(16, 0, 4, 8);
			TextView view22 = new TextView(BagsPurseActivity.this);
			view22.setLayoutParams(params);
			view22.setText(color22);
			ll_color.addView(view22);
			
			
			
			String color23 = intent.getStringExtra("Bags2Color3");
			params = new LayoutParams(90, 50);
			params.setMargins(16, 0, 4, 8);
			TextView view23 = new TextView(BagsPurseActivity.this);
			view23.setLayoutParams(params);
			view23.setText(color23);
			ll_color.addView(view23);
			break;
			
		case 2:
				String color31 = intent.getStringExtra("Bags3Color1");
				params = new LayoutParams(90, 50);
				params.setMargins(16, 0, 4, 8);
				TextView view31 = new TextView(BagsPurseActivity.this);
				view31.setLayoutParams(params);
				view31.setText(color31);
				ll_color.addView(view31);
				
				String color32 = intent.getStringExtra("Bags3Color2");
				params = new LayoutParams(90, 50);
				params.setMargins(16, 0, 4, 8);
				TextView view32 = new TextView(BagsPurseActivity.this);
				view32.setLayoutParams(params);
				view32.setText(color32);
				ll_color.addView(view32);
				
				String color33= intent.getStringExtra("Bags3Color3");
				params = new LayoutParams(90, 50);
				params.setMargins(16, 0, 4, 8);
				TextView view33 = new TextView(BagsPurseActivity.this);
				view33.setLayoutParams(params);
				view33.setText(color33);
				ll_color.addView(view33);
				break;
		}
			

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_bag_shopping:
			switch (i) {
			case 0:
				ShoppingCartModel scm=new ShoppingCartModel();
				scm.setUrl(intent.getStringExtra("Bags1Url"));
				scm.setTitle(intent.getStringExtra("Bags1Title"));
				scm.setPrice(intent.getFloatExtra("Bags1Price", -1));
				if(!"".equals(et_bag_count.getText().toString())){
					int i=Integer.parseInt(et_bag_count.getText().toString());
					   scm.setNum(i);	
					  if(i<=store&&i>0&&!"".equals(et_bag_count.getText().toString())){
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
				
				break;
			case 1:
				ShoppingCartModel scm1=new ShoppingCartModel();
				scm1.setUrl(intent.getStringExtra("Bags2Url"));
				scm1.setTitle(intent.getStringExtra("Bags2Title"));
				scm1.setPrice(intent.getFloatExtra("Bags2Price", -1));
				if(!"".equals(et_bag_count.getText().toString())){
					int i=Integer.parseInt(et_bag_count.getText().toString());
					   scm1.setNum(i);	
					  if(i<=store&&i>0&&!"".equals(et_bag_count.getText().toString())){
						  ShoppingTools.getListInstance().add(scm1);
						  Toast.makeText(this, "成功加入購物車", Toast.LENGTH_LONG).show();
					  }else{
						  new AlertDialog.Builder(this)./*setTitle("请重新输入库存量").*/setMessage("请重新输入库存量").
							/*setNegativeButton("取消", null).*/setPositiveButton("确定", null).create().show();
					  }
					
				}else{
					 new AlertDialog.Builder(this)./*setTitle("请输入库存量").*/setMessage("请输入库存量").
						/*setNegativeButton("取消", null).*/setPositiveButton("确定", null).create().show();
				}
				break;
			case 2:
				ShoppingCartModel scm2=new ShoppingCartModel();
				scm2.setUrl(intent.getStringExtra("Bags3Url"));
				scm2.setTitle(intent.getStringExtra("Bags3Title"));
				scm2.setPrice(intent.getFloatExtra("Bags3Price", -1));
				if(!"".equals(et_bag_count.getText().toString())){
					int i=Integer.parseInt(et_bag_count.getText().toString());
					   scm2.setNum(i);	
					  if(i<=store&&i>0&&!"".equals(et_bag_count.getText().toString())){
						  ShoppingTools.getListInstance().add(scm2);
						  Toast.makeText(this, "成功加入購物車", Toast.LENGTH_LONG).show();
					  }else{
						  new AlertDialog.Builder(this)./*setTitle("请重新输入库存量").*/setMessage("请重新输入库存量").
							/*setNegativeButton("取消", null).*/setPositiveButton("确定", null).create().show();
					  }
					
				}else{
					 new AlertDialog.Builder(this)./*setTitle("请输入库存量").*/setMessage("请输入库存量").
						/*setNegativeButton("取消", null).*/setPositiveButton("确定", null).create().show();
				}
				break;
				
			}
		case R.id.bt__bag_addcollect:
			switch (i) {
			case 0:
				CollectionModel cm=new CollectionModel();
				cm.setUrl(intent.getStringExtra("Bags1Url"));
				cm.setTitle(intent.getStringExtra("Bags1Title"));
				cm.setPrice(intent.getFloatExtra("Bags1Price", -1));
				CollectionTools.getInstance().add(cm);
				Toast.makeText(this, "成功添加收藏", Toast.LENGTH_LONG).show();
				break;
			case 1:
				CollectionModel cm1=new CollectionModel();
				cm1.setUrl(intent.getStringExtra("Bags2Url"));
				cm1.setTitle(intent.getStringExtra("Bags2Title"));
				cm1.setPrice(intent.getFloatExtra("Bags2Price", -1));
				CollectionTools.getInstance().add(cm1);
				Toast.makeText(this, "成功添加收藏", Toast.LENGTH_LONG).show();
				break;
			case 2:
				CollectionModel cm2=new CollectionModel();
				cm2.setUrl(intent.getStringExtra("Bags3Url"));
				cm2.setTitle(intent.getStringExtra("Bags3Title"));
				cm2.setPrice(intent.getFloatExtra("Bags3Price", -1));
				CollectionTools.getInstance().add(cm2);
				Toast.makeText(this, "成功添加收藏", Toast.LENGTH_LONG).show();
				break;
			
			}
		
		}
		
	}
}
