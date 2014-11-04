package com.example.my.sql;

import java.util.ArrayList;
import java.util.List;

import com.example.my.model.BagsModel;
import com.example.my.model.ClothingModel;
import com.example.my.model.EbookModel;
import com.example.my.model.Protection;
import com.example.my.model.ShoesModel;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class DataUtil {

	//获取衣服的数据库内容
	public static List<ClothingModel> getClothCatagories(Context context) {
	//	new SqliteData(context).initialData(context);
		SqliteData Sqlite = new SqliteData(context);
		SQLiteDatabase db = Sqlite.getSqlDb();
		
		String[] columns = new String[] { "id",
				"name","title","price","color1","color2","color3","size1","size2","size3","size4","size5","store",};

		List<ClothingModel> ClothCatagoryList = new ArrayList<ClothingModel>();
		Cursor c = db.rawQuery("select * from books",null);
		while (c.moveToNext()) {
			ClothingModel cloth = new ClothingModel();
			cloth.setId(c.getInt(c.getColumnIndexOrThrow("id")));
			cloth.setName(c.getString(c.getColumnIndexOrThrow("name")));
			cloth.setTitle(c.getString(c.getColumnIndexOrThrow("title")));
			cloth.setPrice(c.getFloat(c.getColumnIndexOrThrow("price")));
			cloth.setColor1(c.getString(c.getColumnIndexOrThrow("color1")));
			cloth.setColor2(c.getString(c.getColumnIndexOrThrow("color2")));
			cloth.setColor3(c.getString(c.getColumnIndexOrThrow("color3")));
			cloth.setSize1(c.getString(c.getColumnIndexOrThrow("size1")));
			cloth.setSize2(c.getString(c.getColumnIndexOrThrow("size2")));
			cloth.setSize3(c.getString(c.getColumnIndexOrThrow("size3")));
			cloth.setSize4(c.getString(c.getColumnIndexOrThrow("size4")));
			cloth.setSize5(c.getString(c.getColumnIndexOrThrow("size5")));
			cloth.setStore(c.getInt(c.getColumnIndexOrThrow("store")));
			
			ClothCatagoryList.add(cloth);
		}
		// 关闭Cursor对象和SQLiteDatabase对象
		c.close();
		db.close();

		return ClothCatagoryList;
	}
	
	//获取图书的数据库内容
	public static List<EbookModel>getBooks(Context context){
		
		SqliteData Sqlite=new SqliteData(context);
		SQLiteDatabase db=Sqlite.getSqlDb();
		
		String[] columns=new String[]{"id",
				"title","price","url","store","press","autor"};
		
		List<EbookModel>listEbook=new ArrayList<EbookModel>();
		Cursor c=db.rawQuery("select * from ebooks", null);
		while(c.moveToNext()){
			EbookModel ebook=new EbookModel();
			ebook.setId(c.getInt(c.getColumnIndexOrThrow("id")));
			ebook.setTitle(c.getString(c.getColumnIndexOrThrow("title")));
			ebook.setPrice(c.getFloat(c.getColumnIndexOrThrow("price")));
			ebook.setUrl(c.getString(c.getColumnIndexOrThrow("url")));	
			ebook.setStore(c.getInt(c.getColumnIndexOrThrow("store")));
			ebook.setAutor(c.getString(c.getColumnIndexOrThrow("autor")));
			ebook.setPress(c.getString(c.getColumnIndexOrThrow("press")));
			listEbook.add(ebook);
			
		}
		c.close();
		db.close();
		return listEbook;
		
	}
	
	//获取鞋子的数据库内容
	public static List<ShoesModel> getShoes(Context context){
		SqliteData Sqlite=new SqliteData(context);
		SQLiteDatabase db=Sqlite.getSqlDb();
		String[] colums=new String[]{"id",
				"title,","price","url","size1","size2","size3",
				"size4","color1","color2","color1"};
		List<ShoesModel>listShoes=new ArrayList<ShoesModel>();
		Cursor c=db.rawQuery("select * from shoes", null);
		while(c.moveToNext()){
			ShoesModel shoes=new ShoesModel();
			shoes.setId(c.getInt(c.getColumnIndexOrThrow("id")));
			shoes.setPrice(c.getFloat(c.getColumnIndexOrThrow("price")));
			shoes.setTitle(c.getString(c.getColumnIndexOrThrow("title")));
			shoes.setUrl(c.getString(c.getColumnIndexOrThrow("url")));
			
			shoes.setSize1(c.getString(c.getColumnIndexOrThrow("size1")));
			shoes.setSize2(c.getString(c.getColumnIndexOrThrow("size2")));
			shoes.setSize3(c.getString(c.getColumnIndexOrThrow("size3")));
			shoes.setSize4(c.getString(c.getColumnIndexOrThrow("size4")));
			
			shoes.setColor1(c.getString(c.getColumnIndexOrThrow("color1")));
			shoes.setColor2(c.getString(c.getColumnIndexOrThrow("color2")));
			shoes.setColor3(c.getString(c.getColumnIndexOrThrow("color3")));
			listShoes.add(shoes);
		}
		c.close();
		db.close();
		return listShoes;
		
	}
	
	//获取包包的数据库内容
	public static List<BagsModel>getBags1(Context context){
		
		SqliteData Sqlite=new SqliteData(context);
		SQLiteDatabase db=Sqlite.getSqlDb();
		
		String[] columns=new String[]{"id",
				"title","price","url","color1","color2","color3","store"};
		
		List<BagsModel>listBags1=new ArrayList<BagsModel>();
		Cursor c=db.rawQuery("select * from bags1", null);
		while(c.moveToNext()){
			BagsModel bags1=new BagsModel();
			bags1.setId(c.getInt(c.getColumnIndexOrThrow("id")));
			bags1.setTitle(c.getString(c.getColumnIndexOrThrow("title")));
			bags1.setPrice(c.getFloat(c.getColumnIndexOrThrow("price")));
			bags1.setUrl(c.getString(c.getColumnIndexOrThrow("url")));
			bags1.setColor1(c.getString(c.getColumnIndexOrThrow("color1")));
			bags1.setColor2(c.getString(c.getColumnIndexOrThrow("color2")));
			bags1.setColor3(c.getString(c.getColumnIndexOrThrow("color3")));
			bags1.setStore(c.getInt(c.getColumnIndexOrThrow("store")));
			listBags1.add(bags1);
			
		}
		c.close();
		db.close();
		return listBags1;
		
	}
	
	//获取包包的数据库内容
		public static List<BagsModel>getBags2(Context context){
			
			SqliteData Sqlite=new SqliteData(context);
			SQLiteDatabase db=Sqlite.getSqlDb();
			
			String[] columns=new String[]{"id",
					"title","price","url","color1","color2","color3","store"};
			
			List<BagsModel>listBags2=new ArrayList<BagsModel>();
			Cursor c=db.rawQuery("select * from bags2", null);
			while(c.moveToNext()){
				BagsModel bags2=new BagsModel();
				bags2.setId(c.getInt(c.getColumnIndexOrThrow("id")));
				bags2.setTitle(c.getString(c.getColumnIndexOrThrow("title")));
				bags2.setPrice(c.getFloat(c.getColumnIndexOrThrow("price")));
				bags2.setUrl(c.getString(c.getColumnIndexOrThrow("url")));
				bags2.setColor1(c.getString(c.getColumnIndexOrThrow("color1")));
				bags2.setColor2(c.getString(c.getColumnIndexOrThrow("color2")));
				bags2.setColor3(c.getString(c.getColumnIndexOrThrow("color3")));
				bags2.setStore(c.getInt(c.getColumnIndexOrThrow("store")));
				listBags2.add(bags2);
				
			}
			c.close();
			db.close();
			return listBags2;
			
		}
		//获取包包的数据库内容
		public static List<BagsModel>getBags3(Context context){
			
			SqliteData Sqlite=new SqliteData(context);
			SQLiteDatabase db=Sqlite.getSqlDb();
			
			String[] columns=new String[]{"id",
					"title","price","url","color1","color2","color3",""};
			
			List<BagsModel>listBags3=new ArrayList<BagsModel>();
			Cursor c=db.rawQuery("select * from bags3", null);
			while(c.moveToNext()){
				BagsModel bags3=new BagsModel();
				bags3.setId(c.getInt(c.getColumnIndexOrThrow("id")));
				bags3.setTitle(c.getString(c.getColumnIndexOrThrow("title")));
				bags3.setPrice(c.getFloat(c.getColumnIndexOrThrow("price")));
				bags3.setUrl(c.getString(c.getColumnIndexOrThrow("url")));
				bags3.setColor1(c.getString(c.getColumnIndexOrThrow("color1")));
				bags3.setColor2(c.getString(c.getColumnIndexOrThrow("color2")));
				bags3.setColor3(c.getString(c.getColumnIndexOrThrow("color3")));
				bags3.setStore(c.getInt(c.getColumnIndexOrThrow("store")));
				listBags3.add(bags3);
				
			}
			c.close();
			db.close();
			return listBags3;	
		}
	
		
		//获取护肤的数据库内容
		public static List<Protection> getProtecttion(Context context){
			
			SqliteData Sqlite=new SqliteData(context);
			SQLiteDatabase db=Sqlite.getSqlDb();
			
			String[] columns=new String[]{"id",
					"title","price","url","store"};
			
			List<Protection>listProtetctions=new ArrayList<Protection>();
			Cursor c=db.rawQuery("select * from protection", null);
			while(c.moveToNext()){
				Protection p=new Protection();
				p.setId(c.getInt(c.getColumnIndexOrThrow("id")));
				p.setTitle(c.getString(c.getColumnIndexOrThrow("title")));
				p.setPrice(c.getFloat(c.getColumnIndexOrThrow("price")));
				p.setUrl(c.getString(c.getColumnIndexOrThrow("url")));	
				p.setStore(c.getInt(c.getColumnIndexOrThrow("store")));
				
				listProtetctions.add(p);
				
			}
			c.close();
			db.close();
			return listProtetctions;	
		}
		
		//获取配饰的数据库内容
		public static List<Protection>getOrnament(Context context){
			SqliteData sqlite=new SqliteData(context);
			SQLiteDatabase db=sqlite.getSqlDb();
			String[] columns=new String[]{
					"title","price","url","store"};
			List<Protection>listOrnament=new ArrayList<Protection>();
			Cursor c=db.rawQuery("select *from ornament", null);
			while(c.moveToNext()){
				Protection p=new Protection();
				p.setId(c.getInt(c.getColumnIndexOrThrow("id")));
				p.setTitle(c.getString(c.getColumnIndexOrThrow("title")));
				p.setPrice(c.getFloat(c.getColumnIndexOrThrow("price")));
				p.setUrl(c.getString(c.getColumnIndexOrThrow("url")));	
				p.setStore(c.getInt(c.getColumnIndexOrThrow("store")));
				
				listOrnament.add(p);
				
			}
			c.close();
			db.close();
			return listOrnament;
			}
		
		//获取男装的数据库内容
				public static List<Protection>getMan(Context context){
					SqliteData sqlite=new SqliteData(context);
					SQLiteDatabase db=sqlite.getSqlDb();
					String[] columns=new String[]{
							"title","price","url","store"};
					List<Protection>listMen=new ArrayList<Protection>();
					Cursor c=db.rawQuery("select *from man", null);
					while(c.moveToNext()){
						Protection p=new Protection();
						p.setId(c.getInt(c.getColumnIndexOrThrow("id")));
						p.setTitle(c.getString(c.getColumnIndexOrThrow("title")));
						p.setPrice(c.getFloat(c.getColumnIndexOrThrow("price")));
						p.setUrl(c.getString(c.getColumnIndexOrThrow("url")));	
						p.setStore(c.getInt(c.getColumnIndexOrThrow("store")));
						
						listMen.add(p);
						
					}
					c.close();
					db.close();
					return listMen;
					}
				//获取其他的数据库内容
				public static List<Protection>getOther(Context context){
					SqliteData sqlite=new SqliteData(context);
					SQLiteDatabase db=sqlite.getSqlDb();
					String[] columns=new String[]{
							"title","price","url","store"};
					List<Protection>listOthers=new ArrayList<Protection>();
					Cursor c=db.rawQuery("select *from other", null);
					while(c.moveToNext()){
						Protection p=new Protection();
						p.setId(c.getInt(c.getColumnIndexOrThrow("id")));
						p.setTitle(c.getString(c.getColumnIndexOrThrow("title")));
						p.setPrice(c.getFloat(c.getColumnIndexOrThrow("price")));
						p.setUrl(c.getString(c.getColumnIndexOrThrow("url")));	
						p.setStore(c.getInt(c.getColumnIndexOrThrow("store")));
						
						listOthers.add(p);
						
					}
					c.close();
					db.close();
					return listOthers;
					}
				
	
}
