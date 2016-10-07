package com.example.dialogtest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO 自动生成的方法存根
		super.onCreate(savedInstanceState);
		setContentView(R.layout.second_activity);
		TextView songlistName_tv=(TextView) findViewById(R.id.id_songlistname_tv);
		Intent intent=getIntent();
		songlistName_tv.setText(intent.getStringExtra("songlist"));
	}
}
