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
	private ListView listview;	//������ʾ�Ѵ����赥���б�
    private ImageView cancel_img;	//ȡ����ʾ������
    private TextView songcounts_tv;	//��ʾ����ϲ�������֡��б��и�������Ŀ
    private LinearLayout create_new_layout;	//�����¸赥�Ĳ���
    private LinearLayout my_storage_layout;	//��ϲ�������ֵĲ���
    private Context context;	
    private AddToStorageSonglistAdapter adapter;
    private int songCount;
    private ArrayList<Songlist> songlist_list;	//�赥���б�
    private onCancelClickListener oncancelClickListener;//ȡ��������ļ���
    private onItemClickListener onitemClickListener;	//listviewѡ����Ŀ������
    private OnCreateNewSonglistClickListener onCreateNewSonglistClickListener;	//"�����¸赥"���ֵļ�����
    private OnStorageToMyStorageSongClickListener onStorageToMyStorageSongClickListener; //"�ղ�����ϲ��������"���ֵļ�����
 
    
    public void onQuitClickListener( onCancelClickListener oncancelClickListener) {     
        this.oncancelClickListener = oncancelClickListener;  
    }  

    public void onItemClickListener(ArrayList<Songlist> songlist_list,onItemClickListener onitemClickListener){
    	this.songlist_list=songlist_list;
    	this.onitemClickListener=onitemClickListener;
    }

    public SonglistDialog(Context context) {  
    	
    	//�ؼ��ķ����style�������ã�����ΪMyDialog
    	
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
        //���հ״�����ȡ������  
        setCanceledOnTouchOutside(false);  
  
        //��ʼ������ؼ�  
        initView();  
        //��ʼ����������  
        initData();  
        //��ʼ������ؼ����¼�  
        initEvent();  
          
    }  
  
    /** 
     * ��ʼ������ļ����� 
     */  
    private void initEvent() {  
        //����ȷ����ť�������������ṩ����  
    	
    	cancel_img.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO �Զ����ɵķ������
				oncancelClickListener.onCancelClick();
			}
			
		});
    	listview.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				// TODO �Զ����ɵķ������
				Log.i(position+"", songlist_list.get(position).getSonglistName());
			}
		});
    	
    	create_new_layout.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO �Զ����ɵķ������
				onCreateNewSonglistClickListener.onCreateNewSonglistClick();
			}
		});
    	my_storage_layout.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO �Զ����ɵķ������
				onStorageToMyStorageSongClickListener.onStorageToMyStorageSongClick();
			}
		});
    }  
  
    /** 
     * ��ʼ������ؼ�����ʾ���� 
     */  
    private void initData() {  
        //��������˸赥���б�����������listview  
      
        if(songlist_list!=null){
        	adapter=new AddToStorageSonglistAdapter(context, songlist_list);
        	listview.setAdapter(adapter);
        }
        
        //�����˸�����������ʼ�����赥����TextView
        songcounts_tv.setText("����"+songCount+"�׸���");
    }  
  
    /** 
     * ��ʼ������ؼ� 
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
