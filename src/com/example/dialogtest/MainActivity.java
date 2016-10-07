package com.example.dialogtest;

import java.util.ArrayList;
import com.example.dialogtest.view.CreateSonglistDialog;
import com.example.dialogtest.view.SonglistDialog;
import com.example.dialogtest.view.SonglistDialog.OnCreateNewSonglistClickListener;
import com.example.dialogtest.view.SonglistDialog.OnStorageToMyStorageSongClickListener;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {
	private Button dialog;
	private Button dialog2;
	private SonglistDialog songlistDialog;
	private CreateSonglistDialog createDialog;
	private ArrayList<Songlist> songlist_list=new ArrayList<Songlist>();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//使用的时候可以通过网络请求获得歌单数据，这里直接手动输入
		initData();
		//初始化控件
		initView();
		//初始化点击事件
		initEvent();
		
	}
	private void initEvent() {
		// TODO 自动生成的方法存根
		dialog.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO 自动生成的方法存根
				songlistDialog = new SonglistDialog(MainActivity.this);  
				songlistDialog.onQuitClickListener(new SonglistDialog.onCancelClickListener() {
					
					@Override
					public void onCancelClick() {
						// TODO 自动生成的方法存根
						Log.i("可以响应", "-------------------");
						songlistDialog.dismiss();
					}
				});
				songlistDialog.onItemClickListener(songlist_list, new SonglistDialog.onItemClickListener() {
					
					@Override
					public void onItemClick() {
						// TODO 自动生成的方法存根
						//在SonglistDialog里设置
						//Log.i(position+"", songlist_list.get(position).getSonglistName());
					}
				});
				songlistDialog.onCreateNewSonglistClickListener(new OnCreateNewSonglistClickListener() {
					
					@Override
					public void onCreateNewSonglistClick() {
						// TODO 自动生成的方法存根
						songlistDialog.dismiss();
						Log.i("收藏到歌单的dialog消失", "新建歌单的dialog弹出");
						createDialog=new CreateSonglistDialog(MainActivity.this);
						createDialog.setYesOnclickListener(new CreateSonglistDialog.onYesOnclickListener() {
								
							@Override
							public void onYesClick(String content) {
								// TODO 自动生成的方法存根
								createDialog.dismiss();
								Log.i("能够获取输入框的内容", content);
							}
						});
						createDialog.onQuitClickListener(new CreateSonglistDialog.onCancelClickListener() {

							@Override
							public void onCancelClick() {
								// TODO 自动生成的方法存根
									
								createDialog.dismiss();
							}
						});
						createDialog.show();
					}
				});
				songlistDialog.OnStorageToMyStorageSongClickListener(new OnStorageToMyStorageSongClickListener() {
					
					@Override
					public void onStorageToMyStorageSongClick() {
						// TODO 自动生成的方法存根
						songlistDialog.dismiss();
						Log.i("收藏到歌单的dialog消失", "收藏到我喜爱的音乐");
					}
				});
				songlistDialog.setSongCount(803);
				songlistDialog.show();   
			}
		});
		
		dialog2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO 自动生成的方法存根
				
				createDialog=new CreateSonglistDialog(MainActivity.this);
				createDialog.setYesOnclickListener(new CreateSonglistDialog.onYesOnclickListener() {
					
					@Override
					public void onYesClick(String content) {
						// TODO 自动生成的方法存根
						createDialog.dismiss();
						Log.i("能够获取输入框的内容", content);
					}
				});
				createDialog.onQuitClickListener(new CreateSonglistDialog.onCancelClickListener() {

					@Override
					public void onCancelClick() {
						// TODO 自动生成的方法存根
						
						createDialog.dismiss();
					}
				});
				createDialog.show();
				createDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
				
			}
		});
	}
	
	private void initView() {
		// TODO 自动生成的方法存根
		dialog=(Button) findViewById(R.id.dialog);
		dialog2=(Button) findViewById(R.id.dialog2);
	}
	
	private void initData() {
		// TODO 自动生成的方法存根
		Songlist songlist1=new Songlist("http://120.76.251.184:8080/pic/songlist1.png","驾驶专用歌单",10);
		Songlist songlist2=new Songlist("http://120.76.251.184:8080/pic/songlist1.png","登山专用歌单",20);
		Songlist songlist3=new Songlist("http://120.76.251.184:8080/pic/songlist1.png","跑步专用歌单",30);
		Songlist songlist4=new Songlist("http://120.76.251.184:8080/pic/songlist1.png","LOL专用歌单",40);
		Songlist songlist5=new Songlist("http://120.76.251.184:8080/pic/songlist1.png","健身专用歌单",50);
		Songlist songlist6=new Songlist("http://120.76.251.184:8080/pic/songlist1.png","读书专用歌单",60);
		Songlist songlist7=new Songlist("http://120.76.251.184:8080/pic/songlist1.png","工作专用歌单",70);
		songlist_list.add(songlist1);
		songlist_list.add(songlist2);
		songlist_list.add(songlist3);
		songlist_list.add(songlist4);
		songlist_list.add(songlist5);
		songlist_list.add(songlist6);
		songlist_list.add(songlist7);
	}
}
