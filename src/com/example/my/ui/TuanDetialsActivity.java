package com.example.my.ui;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import com.android.volley.Request.Method;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.my.R;

import com.example.my.model.StaticComm;
import com.example.my.model.TuanModel;
import com.example.my.utils.JsonUtil;
import com.example.my.utils.RequestQueueSingleton;
import com.example.my.utils.SignCreateUitl;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.Html;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class TuanDetialsActivity extends Activity {
	   Intent intent;
	   Gallery gallery;
	   StringRequest request;
	   private ViewPager vpPicture;
		private List<ImageView> pictures;
		private String id;
		private List<TuanModel> listTuans=new ArrayList<TuanModel>();
		private TextView tvPublishDate, tvDeadline,tv_tuan_detials,
		tv_tuan_title,tv_tuan_description,tv_tuan_restrictions;
		List<String> imags;
		List<ImageView> cacheView;
		private TuanModel tuanModel1,tuanModel2,tuanModel3;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tuan_detials);
		cacheView = new ArrayList<ImageView>();
		Intent intent = getIntent();
		id = intent.getStringExtra("info");
		
		loadImage();
		
	}
	
	private void findView(){
	/*	gallery=(Gallery)findViewById(R.id.gallery_tuan_detials);*/
		vpPicture = (ViewPager) findViewById(R.id.vp_picture);
		MyPageAdapter adapter = new MyPageAdapter();
		vpPicture.setAdapter(adapter);
		
		tvPublishDate = (TextView) findViewById(R.id.tv_publish_date);
		tvDeadline = (TextView) findViewById(R.id.tv_deadline_data);
		tv_tuan_detials=(TextView)findViewById(R.id.tv_tuan_detials);
		tv_tuan_restrictions=(TextView)findViewById(R.id.tv_tuan_restrictions);
		tv_tuan_title=(TextView)findViewById(R.id.tv_tuan_title);
		tv_tuan_description=(TextView)findViewById(R.id.tv_tuan_description);
	}
	
	private List<TuanModel>loadImage(){		
			try {
				request = new StringRequest(Method.GET, 
						 StaticComm.HTTP_TODAY_PURCHASE_INFO+"appkey="
				        +StaticComm.AppKey
						+SignCreateUitl.getSign(SignCreateUitl
								.createParamMap("deal_ids="+id))
						+"&deal_ids="+id, 
						new Response.Listener<String>() {

					@Override
					public void onResponse(String response) {
						String data=JsonUtil.getJsonValueByKey(response, "deals");
						
						listTuans=JsonUtil.toObjectList(data, TuanModel.class);
						
						List<String>list=JsonUtil.toJsonStrList(data);
						
						String picture = JsonUtil.getJsonValueByKey(list.get(0), "more_image_urls");
						 imags = JsonUtil.toJsonStrList(picture);
						 findView();
						String res=JsonUtil.getJsonValueByKey(list.get(0), "restrictions");
						tuanModel1=JsonUtil.toObject(res, TuanModel.class);
						tv_tuan_restrictions.setText(tuanModel1.special_tips);
						
						tv_tuan_detials.setText(listTuans.get(0).detials);
						tvPublishDate.setText(listTuans.get(0).publish_date);
						tvDeadline.setText(listTuans.get(0).purchase_deadline);
						tv_tuan_title.setText(listTuans.get(0).title);
						tv_tuan_description.setText(listTuans.get(0).description);
						
						
					}
				}, new Response.ErrorListener() {

					@Override
					public void onErrorResponse(VolleyError error) {
						Toast.makeText(TuanDetialsActivity.this, error.getMessage(), 5000).show();
						
					}
				});
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		Volley.newRequestQueue(this).add(request);
		return listTuans;
		
	}
	

	//vIEWPager适配器
	class MyPageAdapter extends PagerAdapter {

		@Override
		public int getCount() {
			return imags.size();
		}

		@Override
		public Object instantiateItem(ViewGroup container, int position) {
			ImageView view = new ImageView(TuanDetialsActivity.this);
			
				ViewPager.LayoutParams lps = new ViewPager.LayoutParams();
				lps.width = ViewPager.LayoutParams.MATCH_PARENT;
				lps.height = ViewPager.LayoutParams.MATCH_PARENT;
				view.setLayoutParams(lps);
			

			getRemoteImage(view, position);
			
			container.addView(view);
			cacheView.add(view);
			return view;
		}

		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			return arg0 == arg1;
		}
		
		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
			container.removeView(cacheView.get(position));
		}
	}

	//获取更多图片
	private void getRemoteImage(ImageView view, int i) {

		// 图片地址
		String imgUrl = imags.get(i);
		// 下载图片
		ImageLoader imageLoader = RequestQueueSingleton.getInstance(
				TuanDetialsActivity.this).getImageLoader();
		// 图片地址，默认图片，错误图片
		imageLoader.get(imgUrl, imageLoader.getImageListener(view,
				R.drawable.a, R.drawable.a), 300, 200);
	}
}
