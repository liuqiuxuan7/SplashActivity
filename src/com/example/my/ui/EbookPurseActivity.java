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
import android.widget.Toast;


import android.widget.TextView;
import android.widget.LinearLayout.LayoutParams;

public class EbookPurseActivity extends Activity implements OnClickListener{
	  ImageView imageView;
	  TextView text_book_price,tv_book_name,tv_book_inventory,tv_public_name,tv_autor_name;
	  Button btn_book_shopping,bt_book_addcollect;
	  LayoutParams params ;
	  EditText et_count_book;
	  int store;
	  Intent intent;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ebook_purse);
		
		initialWidget();
		intent=this.getIntent();
		loadImage();
		loadPrice();
		
	}
	private void initialWidget() {
		imageView=(ImageView)findViewById(R.id.image_book_detail);
		text_book_price=(TextView)findViewById(R.id.text_book_price);
		tv_book_inventory=(TextView)findViewById(R.id.tv_book_inventory);
		
		tv_autor_name=(TextView)findViewById(R.id.tv_autor_name);
		tv_public_name=(TextView)findViewById(R.id.tv_public_name);
		
		tv_book_name=(TextView)findViewById(R.id.tv_book_name);
		et_count_book=(EditText)findViewById(R.id.et_count_book);
		
		
		btn_book_shopping=(Button)findViewById(R.id.btn_book_shopping);
		btn_book_shopping.setOnClickListener(this);
		bt_book_addcollect=(Button)findViewById(R.id.bt_book_addcollect);
		bt_book_addcollect.setOnClickListener(this);
		
	}
	private void loadPrice() {
		
		Float price=intent.getFloatExtra("EbookPrice", -1);
	    text_book_price.setText("￥"+price+"");
	    
	    String title=intent.getStringExtra("EbookTitle");
	    tv_book_name.setText(title);	   
	    
	    store=intent.getIntExtra("EbookStore", -1);
	    tv_book_inventory.setText(store+"");
		
	    String press=intent.getStringExtra("EbookPress");
	    tv_public_name.setText(press);
	    
	    String autor=intent.getStringExtra("EbookAutor");
	    tv_autor_name.setText(autor);
	}
	private void loadImage() {
		 String url= intent.getStringExtra("EbookUrl");          
		    ImageLoader loader = RequestQueueSingleton.getInstance(
			EbookPurseActivity.this).getImageLoader();
	        loader.get(url, ImageLoader.getImageListener(imageView,
			R.drawable.ic_launcher, R.drawable.ic_launcher), 300, 300);
		
	}
	
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_book_shopping:
			
			ShoppingCartModel scm = new ShoppingCartModel();
			scm.setTitle(intent.getStringExtra("EbookTitle"));
			scm.setPrice(intent.getFloatExtra("EbookPrice", -1));
			scm.setUrl(intent.getStringExtra("EbookUrl"));
			if(!"".equals(et_count_book.getText().toString())){
				int i=Integer.parseInt(et_count_book.getText().toString());
				   scm.setNum(i);	
				  if(i<=store&&i>0&&!"".equals(et_count_book.getText().toString())){
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
    case R.id.bt_book_addcollect:
    	   CollectionModel cm=new CollectionModel();
    	   cm.setTitle(intent.getStringExtra("EbookTitle"));
    	   cm.setPrice(intent.getFloatExtra("EbookPrice", -1));
    	   cm.setUrl(intent.getStringExtra("EbookUrl"));
    	   CollectionTools.getInstance().add(cm);
    	   Toast.makeText(this, "成功添加收藏", Toast.LENGTH_LONG).show();
    	   break;
		
		}
	}
	

	
}
