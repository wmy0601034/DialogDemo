package com.example.dialogtest.view;

import java.util.ArrayList;
import com.example.dialogtest.AddToStorageSonglistAdapter;
import com.example.dialogtest.R;
import com.example.dialogtest.Songlist;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class SonglistDialog extends Dialog {
	private ListView listview;	//用于显示已创建歌单的列表
    private ImageView cancel_img;	//取消显示弹出框
    private TextView songcounts_tv;	//显示“我喜爱的音乐”列表中歌曲的数目
    private LinearLayout create_new_layout;	//创建新歌单的布局
    private LinearLayout my_storage_layout;	//我喜欢的音乐的布局
    private Context context;	
    private AddToStorageSonglistAdapter adapter;
    private int songCount;
    private ArrayList<Songlist> songlist_list;	//歌单的列表
    private onCancelClickListener oncancelClickListener;//取消弹出框的监听
    private onItemClickListener onitemClickListener;	//listview选择条目监听器
    private OnCreateNewSonglistClickListener onCreateNewSonglistClickListener;	//"创建新歌单"布局的监听器
    private OnStorageToMyStorageSongClickListener onStorageToMyStorageSongClickListener; //"收藏至我喜欢的音乐"布局的监听器
 
    
    public void onQuitClickListener( onCancelClickListener oncancelClickListener) {     
        this.oncancelClickListener = oncancelClickListener;  
    }  

    public void onItemClickListener(ArrayList<Songlist> songlist_list,onItemClickListener onitemClickListener){
    	this.songlist_list=songlist_list;
    	this.onitemClickListener=onitemClickListener;
    }

    public SonglistDialog(Context context) {  
    	
    	//控件的风格在style里面设置，主题为MyDialog
    	
        super(context, R.style.MyDialog);  
        this.context=context;
    }  
    
    public void onCreateNewSonglistClickListener(OnCreateNewSonglistClickListener onCreateNewSonglistClickListener){
    	this.onCreateNewSonglistClickListener=onCreateNewSonglistClickListener;
    }
  
    public void OnStorageToMyStorageSongClickListener(OnStorageToMyStorageSongClickListener onStorageToMyStorageSongClickListener){
    	this.onStorageToMyStorageSongClickListener=onStorageToMyStorageSongClickListener;
    }
    @Override  
    protected void onCreate(Bundle savedInstanceState) {  
        super.onCreate(savedInstanceState);  
        setContentView(R.layout.dialog_layout);  
        //按空白处不能取消动画  
        setCanceledOnTouchOutside(false);  
  
        //初始化界面控件  
        initView();  
        //初始化界面数据  
        initData();  
        //初始化界面控件的事件  
        initEvent();  
          
    }  
  
    /** 
     * 初始化界面的监听器 
     */  
    private void initEvent() {  
        //设置确定按钮被点击后，向外界提供监听  
    	
    	cancel_img.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO 自动生成的方法存根
				oncancelClickListener.onCancelClick();
			}
			
		});
    	listview.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				// TODO 自动生成的方法存根
				Log.i(position+"", songlist_list.get(position).getSonglistName());
			}
		});
    	
    	create_new_layout.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO 自动生成的方法存根
				onCreateNewSonglistClickListener.onCreateNewSonglistClick();
			}
		});
    	my_storage_layout.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO 自动生成的方法存根
				onStorageToMyStorageSongClickListener.onStorageToMyStorageSongClick();
			}
		});
    }  
  
    /** 
     * 初始化界面控件的显示数据 
     */  
    private void initData() {  
        //如果传入了歌单的列表，将其适配至listview  
      
        if(songlist_list!=null){
        	adapter=new AddToStorageSonglistAdapter(context, songlist_list);
        	listview.setAdapter(adapter);
        }
        
        //传入了歌曲数量，初始化至歌单数的TextView
        songcounts_tv.setText("共有"+songCount+"首歌曲");
    }  
  
    /** 
     * 初始化界面控件 
     */  
    private void initView() {  
    	create_new_layout=(LinearLayout) findViewById(R.id.id_new_songlist_layout);
    	my_storage_layout=(LinearLayout) findViewById(R.id.id_my_storage_layout);
    	cancel_img=(ImageView) findViewById(R.id.id_cancel_img);
    	listview=(ListView) findViewById(R.id.id_listview);
    	songcounts_tv=(TextView) findViewById(R.id.id_songcount_tv);
    }  
    
    public void setSongCount(int songCount){
    	this.songCount=songCount;
    }
  
    public interface onCancelClickListener {  
        public void onCancelClick();
    }
    
    public interface onItemClickListener{
    	public void onItemClick();
    }
    
    public interface OnCreateNewSonglistClickListener{
    	public void onCreateNewSonglistClick();
    }
    
    public interface OnStorageToMyStorageSongClickListener{
    	public void onStorageToMyStorageSongClick();
    }
    
}  
