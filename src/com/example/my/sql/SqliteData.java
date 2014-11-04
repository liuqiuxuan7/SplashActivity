package com.example.my.sql;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class SqliteData  {

	private static final String DATABASE_NAME = "BookCollection.db";
	private static final int DATABASE_VERSION = 1;
	static SQLiteDatabase db;
	
	public SqliteData(Context c) {
		File dir = c.getFilesDir();
		File books = new File(dir, DATABASE_NAME);
		initialData(c);
	}
	
	public static  void initialData(Context c) {
		File dir = c.getFilesDir();
		File books = new File(dir, DATABASE_NAME);
		
		/*if(books.exists()) {
			db=SQLiteDatabase.openDatabase(books.getAbsolutePath(), null, SQLiteDatabase.OPEN_READWRITE);
			return;
		}*/
		

		// 读gbk
		InputStream is = null;
		// 写utf8
		OutputStream fos = null;
		try {
			is = c.getAssets().open("bookdata.db");
			fos = new FileOutputStream(books);
		
			byte[] b = new byte[1024];
			int len;
			while((len = is.read(b)) != -1) {
				fos.write(b);
			}
			db=SQLiteDatabase.openDatabase(books.getAbsolutePath(), null, SQLiteDatabase.OPEN_READWRITE);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(is != null){
				try {
					is.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(fos != null){
				try {
					fos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}
	public SQLiteDatabase getSqlDb() {
		return db;
	}
	
}
