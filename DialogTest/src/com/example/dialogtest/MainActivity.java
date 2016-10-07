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
		//ʹ�õ�ʱ�����ͨ�����������ø赥���ݣ�����ֱ���ֶ�����
		initData();
		//��ʼ���ؼ�
		initView();
		//��ʼ������¼�
		initEvent();
		
	}
	private void initEvent() {
		// TODO �Զ����ɵķ������
		dialog.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO �Զ����ɵķ������
				songlistDialog = new SonglistDialog(MainActivity.this);  
				songlistDialog.onQuitClickListener(new SonglistDialog.onCancelClickListener() {
					
					@Override
					public void onCancelClick() {
						// TODO �Զ����ɵķ������
						Log.i("������Ӧ", "-------------------");
						songlistDialog.dismiss();
					}
				});
				songlistDialog.onItemClickListener(songlist_list, new SonglistDialog.onItemClickListener() {
					
					@Override
					public void onItemClick() {
						// TODO �Զ����ɵķ������
						//��SonglistDialog������
						//Log.i(position+"", songlist_list.get(position).getSonglistName());
					}
				});
				songlistDialog.onCreateNewSonglistClickListener(new OnCreateNewSonglistClickListener() {
					
					@Override
					public void onCreateNewSonglistClick() {
						// TODO �Զ����ɵķ������
						songlistDialog.dismiss();
						Log.i("�ղص��赥��dialog��ʧ", "�½��赥��dialog����");
						createDialog=new CreateSonglistDialog(MainActivity.this);
						createDialog.setYesOnclickListener(new CreateSonglistDialog.onYesOnclickListener() {
								
							@Override
							public void onYesClick(String content) {
								// TODO �Զ����ɵķ������
								createDialog.dismiss();
								Log.i("�ܹ���ȡ����������", content);
							}
						});
						createDialog.onQuitClickListener(new CreateSonglistDialog.onCancelClickListener() {

							@Override
							public void onCancelClick() {
								// TODO �Զ����ɵķ������
									
								createDialog.dismiss();
							}
						});
						createDialog.show();
					}
				});
				songlistDialog.OnStorageToMyStorageSongClickListener(new OnStorageToMyStorageSongClickListener() {
					
					@Override
					public void onStorageToMyStorageSongClick() {
						// TODO �Զ����ɵķ������
						songlistDialog.dismiss();
						Log.i("�ղص��赥��dialog��ʧ", "�ղص���ϲ��������");
					}
				});
				songlistDialog.setSongCount(803);
				songlistDialog.show();   
			}
		});
		
		dialog2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO �Զ����ɵķ������
				
				createDialog=new CreateSonglistDialog(MainActivity.this);
				createDialog.setYesOnclickListener(new CreateSonglistDialog.onYesOnclickListener() {
					
					@Override
					public void onYesClick(String content) {
						// TODO �Զ����ɵķ������
						createDialog.dismiss();
						Log.i("�ܹ���ȡ����������", content);
					}
				});
				createDialog.onQuitClickListener(new CreateSonglistDialog.onCancelClickListener() {

					@Override
					public void onCancelClick() {
						// TODO �Զ����ɵķ������
						
						createDialog.dismiss();
					}
				});
				createDialog.show();
				createDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
				
			}
		});
	}
	
	private void initView() {
		// TODO �Զ����ɵķ������
		dialog=(Button) findViewById(R.id.dialog);
		dialog2=(Button) findViewById(R.id.dialog2);
	}
	
	private void initData() {
		// TODO �Զ����ɵķ������
		Songlist songlist1=new Songlist("http://120.76.251.184:8080/pic/songlist1.png","��ʻר�ø赥",10);
		Songlist songlist2=new Songlist("http://120.76.251.184:8080/pic/songlist1.png","��ɽר�ø赥",20);
		Songlist songlist3=new Songlist("http://120.76.251.184:8080/pic/songlist1.png","�ܲ�ר�ø赥",30);
		Songlist songlist4=new Songlist("http://120.76.251.184:8080/pic/songlist1.png","LOLר�ø赥",40);
		Songlist songlist5=new Songlist("http://120.76.251.184:8080/pic/songlist1.png","����ר�ø赥",50);
		Songlist songlist6=new Songlist("http://120.76.251.184:8080/pic/songlist1.png","����ר�ø赥",60);
		Songlist songlist7=new Songlist("http://120.76.251.184:8080/pic/songlist1.png","����ר�ø赥",70);
		songlist_list.add(songlist1);
		songlist_list.add(songlist2);
		songlist_list.add(songlist3);
		songlist_list.add(songlist4);
		songlist_list.add(songlist5);
		songlist_list.add(songlist6);
		songlist_list.add(songlist7);
	}
}
