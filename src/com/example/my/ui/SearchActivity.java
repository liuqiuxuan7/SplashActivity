package com.example.my.ui;

import java.util.List;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import cn.sharesdk.framework.ShareSDK;

import com.android.volley.toolbox.ImageLoader;
import com.example.my.R;
import com.example.my.model.CollectionModel;
import com.example.my.model.CollectionTools;
import com.example.my.ui.base.BaseActivity;
import com.example.my.utils.CommonTools;
import com.example.my.utils.RequestQueueSingleton;
import com.example.my.widgets.AutoClearEditText;
import com.example.xcommodity.share.OnekeyShare;


public class SearchActivity extends BaseActivity {

	private AutoClearEditText mEditText = null;
	private ImageButton mImageButton = null;
	ListView list_collection;
	List<CollectionModel>data;
	TextView info;
	CollectionAdapter collectionAdapter=null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_search);
		data=CollectionTools.getInstance();
		
		findViewById();
		if(data.size()<1){
			
			info.setText("~亲~收藏还是空的~");		  			
		}
		if (collectionAdapter==null) {
			 info.setText("");	
			 
			 collectionAdapter=new CollectionAdapter();
			 list_collection.setAdapter(collectionAdapter);
		}
		
		initView();
	}

	@Override
	protected void findViewById() {
		// TODO Auto-generated method stub
		mEditText = (AutoClearEditText) findViewById(R.id.search_edit);
		mImageButton = (ImageButton) findViewById(R.id.search_button);
		list_collection=(ListView)findViewById(R.id.list_collection);
		info=(TextView)findViewById(R.id.tv_info);
	}

	@Override
	protected void initView() {
		// TODO Auto-generated method stub
		mEditText.requestFocus();
		mImageButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				CommonTools.showShortToast(SearchActivity.this, "亲，该功能暂未开放");
			}
		});
	}
	
	private class CollectionAdapter extends BaseAdapter{

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
			childView = LayoutInflater.from(SearchActivity.this)
					.inflate(R.layout.view_collection_listview, null);
			ImageView image = (ImageView) childView
					.findViewById(R.id.img_shopping);
			TextView textName = (TextView) childView
					.findViewById(R.id.text_shopping_name);
			TextView textPrice = (TextView) childView
					.findViewById(R.id.text_shopping_price);
			
			
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
			
			Button btn_share=(Button)childView.findViewById(R.id.btn_share);
			btn_share.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					showShare(data.get(position).getUrl());
					
				}
			});
			textName.setText(data.get(position).getTitle());
			textPrice.setText("￥"+data.get(position).getPrice()+"");
			
			ImageLoader loader = RequestQueueSingleton.getInstance(
					SearchActivity.this).getImageLoader();
			loader.get(data.get(position).getUrl(), ImageLoader
					.getImageListener(image, R.drawable.ic_launcher,
							R.drawable.ic_launcher), 300, 300);
			
			return childView	;
		}
		
	}
	
	private void showShare(String url) {
		
        ShareSDK.initSDK(this);
        OnekeyShare oks = new OnekeyShare();
        //关闭sso授权
        oks.disableSSOWhenAuthorize();
        
        // 分享时Notification的图标和文字
        oks.setNotification(R.drawable.ic_launcher, getString(R.string.app_name));
        // title标题，印象笔记、邮箱、信息、微信、人人网和QQ空间使用
        oks.setTitle(getString(R.string.share));
        // titleUrl是标题的网络链接，仅在人人网和QQ空间使用
        oks.setTitleUrl("http://sharesdk.cn");
        // text是分享文本，所有平台都需要这个字段
        oks.setText("我是分享文本");
        // imagePath是图片的本地路径，Linked-In以外的平台都支持此参数
//        oks.setImagePath(url);
        oks.setImageUrl(url);
      /*  oks.setImageUrl("http://img0.bdstatic.com/img/image/9f0af582c37d7bff4027fa2b981d8b511413964498.jpg");*/
        System.out.println(url);
        // url仅在微信（包括好友和朋友圈）中使用
        oks.setUrl("http://sharesdk.cn");
        // comment是我对这条分享的评论，仅在人人网和QQ空间使用
        oks.setComment("我是测试评论文本");
        // site是分享此内容的网站名称，仅在QQ空间使用
        oks.setSite(getString(R.string.app_name));
        // siteUrl是分享此内容的网站地址，仅在QQ空间使用
        oks.setSiteUrl("http://sharesdk.cn");

        // 启动分享GUI
        oks.show(this);
   }
}
