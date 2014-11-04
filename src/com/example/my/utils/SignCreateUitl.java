package com.example.my.utils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.spx.codec.digest.DigestUtils;


public class SignCreateUitl {
	private static String App_key ="68820431";
	private static String Secret = "1635278699b94ba0a20e5b1f5ba692af";
	
	
	
	
	
	
	
	public static Map<String, String> createParamMap(String paramStr){
		//key1=value1&key2=value2
		//һ���ָ�õ�����Ե��ַ�����
		String[] s1 = paramStr.split("&");
		//�����ָװ����ݵ�map
		Map<String,String> paramMap = new HashMap<String,String>();
		
		
		for(String p:s1){
			String[] s2 = p.split("=");
			paramMap.put(s2[0],s2[1]);
		}
		
		
		return paramMap;
	}

	public static String create(String appkey , Map<String,String> paramMap, String secret){
		
		//����������
		String[] keys = (String[]) paramMap.keySet().toArray(new String[0]);
		Arrays.sort(keys);
		//ƴ��
		StringBuilder sb = new StringBuilder();
		sb.append(appkey);
		//ѭ��������ȡ����ֵƴ��
		for(String key:keys){
			sb.append(key).append(paramMap.get(key));
		}
		//ƴ��β��
		sb.append(secret);  
		  
		
		
		String codeStr = sb.toString();
		
		String sign =DigestUtils.shaHex(codeStr).toUpperCase();
		return "sign=" + sign;
		
	}
	
	
	public static String create(String appkey, String secret){
		
		StringBuilder sb = new StringBuilder();
		sb.append(appkey);
		sb.append(secret);
		String codes = sb.toString();
		String sign = DigestUtils.shaHex(codes).toUpperCase();
		return "sign=" + sign;
		
	}

	public static String getSign(){
		return create(App_key, Secret);
	}
	public static String getSign(Map<String, String> paramMap){
		return create(App_key, paramMap, Secret);
	}
}
