package com.example.dialogtest;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class AddToStorageSonglistAdapter extends BaseAdapter {

	private Context context;
	private LayoutInflater inflater;
	private ArrayList<Songlist> songlist_list;
	public static final int MUSIC_PLAY=1;
	public static final int MUSIC_OPTIONS=0;
	
	public AddToStorageSonglistAdapter(Context context,ArrayList<Songlist> songlist_list) {
		this.songlist_list=songlist_list;
		this.context=context;
		inflater=LayoutInflater.from(context);
	}
	
	@Override
    public int getCount() {  
        return songlist_list.size();  
    }  

    public Object getItem(int position) {  
        return songlist_list.get(position);  
    }  

    public long getItemId(int position) {  
        return position;  
    }  

	public void updateData(ArrayList<Songlist> songlist_list){
		this.songlist_list=songlist_list;
		notifyDataSetChanged();
	}
	
    public View getView(final int position, View convertView, ViewGroup parent) {  
    	Holder holder;
    	final Songlist songlist=songlist_list.get(position);
        if (convertView == null) {  
            convertView = inflater.inflate(R.layout.songlist_item, null);  
            holder=new Holder(convertView);
            convertView.setTag(holder);
		}else{
			holder=(Holder) convertView.getTag();
		}
        holder.songlistname_tv.setText(songlist.getSonglistName());
    	holder.songcounts_tv.setText("共有"+songlist.getSongcount()+"首歌曲");
    	//使用的时候可以将cover_img的图片方式改为volley的三级缓存
    	holder.cover_img.setImageResource(R.drawable.album2);
        return convertView;  
    } 
    
   class Holder{
	   public TextView songlistname_tv;
	   public TextView songcounts_tv;
	   public ImageView cover_img;
	   public LinearLayout songlist_layout;
	   public Holder(View view){
	   songlistname_tv=(TextView) view.findViewById(R.id.id_songlistname_tv);
	   songcounts_tv=(TextView) view.findViewById(R.id.id_songcount_tv);
	   cover_img=(ImageView) view.findViewById(R.id.id_songlist_cover_img);
	   }
   }

}