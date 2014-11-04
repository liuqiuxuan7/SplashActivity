package com.example.my.ui;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

import com.android.volley.Request.Method;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.my.R;
import com.example.my.R.layout;
import com.example.my.R.menu;
import com.example.my.grally.TuanAdapter;
import com.example.my.model.StaticComm;
import com.example.my.model.TuanModel;
import com.example.my.utils.JsonUtil;
import com.example.my.utils.SignCreateUitl;



import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

public class TuanActivity extends Activity implements OnItemClickListener{
   private ListView lvTuan;
   private List<String >id_list;
   private Intent intent;
   private String date;
   private String city;
   private StringRequest request;
   private List<TuanModel> listTuan;
   private TuanAdapter tuanAdapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tuan);
		
		findView();
		loadId();
	}

	

	private void findView() {
		lvTuan=(ListView)findViewById(R.id.list_tuan);
		lvTuan.setOnItemClickListener(this);
		
	}
    
	//所有的团购列表
	private List<String>loadId(){
		try {
			request = new StringRequest(Method.GET, StaticComm.HttP_CURRENT + 
					"appkey="+ StaticComm.AppKey + SignCreateUitl.getSign(
							SignCreateUitl.createParamMap("city=全国")) + "&city=" + 
					URLEncoder.encode("全国", "utf-8") ,

					new Response.Listener<String>() {
				@Override
				public void onResponse(String response) {
					//id解析
					String data = JsonUtil.getJsonValueByKey(response, "id_list");
					List<String> dataList = JsonUtil.toJsonStrList(data);
					
					StringBuffer sb = new StringBuffer("");
					for(int i = 0; i<40;i++)
					{
						if(i==0){
							sb.append(dataList.get(i));
						}else{
							sb.append(","+dataList.get(i));
						}
					}
					listTuan(sb.toString());
				}
			}, new Response.ErrorListener() {
			
				@Override
				public void onErrorResponse(VolleyError error) {
					Toast.makeText(TuanActivity.this, error.getMessage(), 5000).show();
					
				}
			});
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	
	
	Volley.newRequestQueue(this).add(request);
		return id_list;
		
	}
	
	//解析IDS
    private List<TuanModel> listTuan(final String ids) {
    	
    	StringRequest request = new StringRequest(Method.GET, 
    			StaticComm.HTTP_TODAY_PURCHASE_INFO + "appkey=" + StaticComm.AppKey + 
    			SignCreateUitl.getSign(SignCreateUitl.createParamMap("deal_ids=" + ids)) + "&deal_ids=" + ids,
    			new Response.Listener<String>() {
    		@Override
    		public void onResponse(String response) {
    			
    			String data = JsonUtil.getJsonValueByKey(response, "deals");
    			
    			listTuan = JsonUtil.toObjectList(data,TuanModel.class);
    			
    			
    			System.out.println();
    			
    			if(tuanAdapter == null) {
    				tuanAdapter = new TuanAdapter(TuanActivity.this, listTuan);
    				lvTuan.setAdapter(tuanAdapter);
    			}
    		}
				}, new Response.ErrorListener() {
					@Override
					public void onErrorResponse(VolleyError error) {
					 Toast.makeText(TuanActivity.this, error.getMessage(), 5000).show();						
					}
				});
    	Volley.newRequestQueue(this).add(request);
		return listTuan;
    }
	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
        intent=new Intent();
		intent.setClass(TuanActivity.this, TuanDetialsActivity.class);
		intent.putExtra("info", listTuan.get(position).deal_id + "");
		startActivity(intent);
		
	}

}
