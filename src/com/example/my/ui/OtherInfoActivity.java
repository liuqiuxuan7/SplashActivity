package com.example.my.ui;

import com.example.my.R;
import com.example.my.R.layout;
import com.example.my.R.menu;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class OtherInfoActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_other_info);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.other_info, menu);
		return true;
	}

}
