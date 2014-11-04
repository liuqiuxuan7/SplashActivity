package com.example.my.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.my.R;
import com.example.my.ui.base.BaseActivity;


public class CategoryActivity extends BaseActivity {

	private ListView catergory_listview;
	private LayoutInflater layoutInflater;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_category);
		findViewById();
		initView();
	}

	@Override
	protected void findViewById() {
		catergory_listview=(ListView)this.findViewById(R.id.catergory_listview);

		catergory_listview.setAdapter(new CatergorAdapter());
		catergory_listview.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> adapterview, View view, int position,
					long id) {
				switch (position) {
				//衣服
				case 0:
					Intent intent=new Intent(CategoryActivity.this,IndexClothingActivity.class);
					startActivity(intent);
					break;
                //图书
                case 1:
                	Intent intent1=new Intent(CategoryActivity.this,IndexEbookActivity.class);
					startActivity(intent1);
					break;
				
				//鞋子	
                case 2:
                	Intent intent2=new Intent(CategoryActivity.this,IndexShoesActivity.class);
					startActivity(intent2);
					break;
					
					//包包
                case 3:
                	Intent intent3=new Intent(CategoryActivity.this,IndexBagsActivity.class);
					startActivity(intent3);
                	break;
                	
                	//护肤
                case 4:
                	Intent intent4=new Intent(CategoryActivity.this,IndexProtectionActivity.class);
					startActivity(intent4);
                	break;
                	
                	//配饰
                case 5:
                	Intent intent5=new Intent(CategoryActivity.this,IndexOrnamentActivity.class);
					startActivity(intent5);
                	break;
                	
                	//男生
                case 6:
                	Intent intent6=new Intent(CategoryActivity.this,IndexManActivity.class);
					startActivity(intent6);
                	break;
                	//其他
                case 7:
                	Intent intent7=new Intent(CategoryActivity.this,IndexOtherActivity.class);
					startActivity(intent7);
                	break;
				}
				
			}
		});
	}

	@Override
	protected void initView() {
		// TODO Auto-generated method stub

	}
	
	private class CatergorAdapter extends BaseAdapter{

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return mImageIds.length;
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
			layoutInflater=LayoutInflater.from(CategoryActivity.this);
			
			//组装数据
			if(convertView==null){
				convertView=layoutInflater.inflate(R.layout.activity_category_item, null);
				holder.image=(ImageView) convertView.findViewById(R.id.catergory_image);
				holder.title=(TextView) convertView.findViewById(R.id.catergoryitem_title);
				holder.content=(TextView) convertView.findViewById(R.id.catergoryitem_content);
				//使用tag存储数据
				convertView.setTag(holder);
			}else{
				holder=(ViewHolder) convertView.getTag();
			}
			holder.image.setImageResource(mImageIds[position]);
			holder.title.setText(mTitleValues[position]);
			holder.content.setText(mContentValues[position]);
		//	holder.title.setText(array[position]);
			
			return convertView;
		
		}
		
		
		
	}
	
	
	// 适配显示的图片数组
				private Integer[] mImageIds = {R.drawable.catagory_1,R.drawable.catagory_2,R.drawable.catagory_3,R.drawable.catagory_4,
						R.drawable.catagory_5,R.drawable.catagory_6,R.drawable.catagory_7,R.drawable.catagory_8
						 };
				//给照片添加文字显示(Title)
				private String[] mTitleValues = {"衣服",  "图书", "鞋子", "包包","护肤",
						"配饰", "男生" ,"其他"};
				
				private String[] mContentValues={"连衣裙/套装/毛衣", "电子书/图书/小说","高跟鞋/单鞋/帆布鞋","复古包/双肩包",  "面部护理/口腔护理", 
						"挂饰/耳环/围巾","男装/鞋子","其他"};
			

		 public static class ViewHolder {
				ImageView image;
				TextView title;
				TextView content;
			}
	
	

}
