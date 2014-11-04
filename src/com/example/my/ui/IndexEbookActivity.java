package com.example.my.ui;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.example.my.R;
import com.example.my.grally.ImageAdapter;
import com.example.my.model.EbookModel;
import com.example.my.sql.DataUtil;
import com.example.my.utils.RequestQueueSingleton;

public class IndexEbookActivity extends Activity {
	 Gallery gallery;
	 GridView gv_book;
	 List<EbookModel>listebook=new ArrayList<EbookModel>();
	 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_index_ebooks);
		listebook=DataUtil.getBooks(this);
		
		gallery=(Gallery)findViewById(R.id.index_ebook_gallery);
		
		/*CoverFlow cf=new CoverFlow(this);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);*/
	        ImageAdapter imageAdapter = new ImageAdapter(this);  
	   
	       /* cf.setAdapter(imageAdapter);  
	        cf.setSelection(2, true);  
	        cf.setAnimationDuration(1000); */
	        gallery.setAdapter(imageAdapter);
	        
	        gv_book=(GridView)findViewById(R.id.gv_book);
	        EbookAdapter ebookAdapter=new EbookAdapter();
	        gv_book.setAdapter(ebookAdapter);
	        
	     
	        
		
	}

	private class EbookAdapter extends BaseAdapter{

		@Override
		public int getCount() {
			
			return listebook.size();
		}

		@Override
		public Object getItem(int position) {
			
			return listebook.get(position);
		}

		@Override
		public long getItemId(int position) {
			
			return position;
		}

		@Override
		public View getView(final int position, View convertView, ViewGroup parent) {
			View childView;

			childView = LayoutInflater.from(IndexEbookActivity.this)
					.inflate(R.layout.view_lv_clothing, null);
			ImageView image = (ImageView) childView
					.findViewById(R.id.img_show_second);
			TextView textName = (TextView) childView
					.findViewById(R.id.text_cloth_name);
			TextView textPrice = (TextView) childView
					.findViewById(R.id.text_cloth_price);
            
			childView.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					Intent intent=new Intent(IndexEbookActivity.this,EbookPurseActivity.class);
					intent.putExtra("EbookId", listebook.get(position).getId());
					intent.putExtra("EbookUrl", listebook.get(position).getUrl());
					intent.putExtra("EbookTitle", listebook.get(position).getTitle());
					intent.putExtra("EbookPrice", listebook.get(position).getPrice());
					intent.putExtra("EbookStore", listebook.get(position).getStore());
					intent.putExtra("EbookPress", listebook.get(position).getPress());
					intent.putExtra("EbookAutor", listebook.get(position).getAutor());
					startActivity(intent);
				}
			});
			
			textName.setText(listebook.get(position).getTitle());
			textPrice.setText("￥" + listebook.get(position).getPrice()+ "");
			
			ImageLoader loader = RequestQueueSingleton.getInstance(
					IndexEbookActivity.this).getImageLoader();
			loader.get(listebook.get(position).getUrl(), ImageLoader
					.getImageListener(image, R.drawable.ic_launcher,
							R.drawable.ic_launcher), 300, 300);
			return childView;
		}
		
	}
	

}
