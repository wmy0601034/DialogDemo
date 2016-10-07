package com.example.dialogtest.view;
import com.example.dialogtest.R;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class CreateSonglistDialog extends Dialog {
	private TextView ensure_tv;
	private TextView cancel_tv;
	private ImageView cancel_img;
	private EditText songlistName_ed;
	private String content;
	private onYesOnclickListener yesOnclickListener;//确定按钮被点击了的监听器  
    private onCancelClickListener oncancelClickListener;
	public CreateSonglistDialog(Context context) {
		super(context, R.style.MyDialog);  
		// TODO 自动生成的构造函数存根
	}
	 
	 public void setYesOnclickListener( onYesOnclickListener onYesOnclickListener) {  
	        
	        this.yesOnclickListener = onYesOnclickListener;  
	    }  
	
	 public void onQuitClickListener(onCancelClickListener onCancelClickListener1) {  
	       
	        this.oncancelClickListener = onCancelClickListener1;  
	    }
	
	@Override  
	protected void onCreate(Bundle savedInstanceState) {  
        super.onCreate(savedInstanceState);  
        setContentView(R.layout.create_songlist_dialog);  
        //按空白处不能取消动画  
        setCanceledOnTouchOutside(false);  
  
        //初始化界面控件  
        initView();  
        //初始化界面控件的事件  
        initEvent();  
          
    }
	
	private void initEvent() {
		// TODO 自动生成的方法存根
		ensure_tv.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO 自动生成的方法存根
				 yesOnclickListener.onYesClick(songlistName_ed.getText().toString());  
			}
		});
		
		cancel_tv.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO 自动生成的方法存根
				if(oncancelClickListener!=null){
					oncancelClickListener.onCancelClick();
				}
			}
		});
		
		cancel_img.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO 自动生成的方法存根
				if(oncancelClickListener!=null){
					oncancelClickListener.onCancelClick();
				}
			}
		});
		songlistName_ed.setOnFocusChangeListener(new View.OnFocusChangeListener() {
			
			@Override
			public void onFocusChange(View v, boolean hasFocus) {
				// TODO 自动生成的方法存根
				if(hasFocus){
					getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
				}
			}
		});
	}
	
	private void initView() {
		// TODO 自动生成的方法存根
		ensure_tv=(TextView) findViewById(R.id.id_ensure_tv);
		cancel_tv=(TextView) findViewById(R.id.id_cancel_tv);
		cancel_img=(ImageView) findViewById(R.id.id_cancel_img);
		songlistName_ed=(EditText) findViewById(R.id.id_songlistName_ed);
	}
	
	
	  public interface onYesOnclickListener {  
	      public void onYesClick(String content);  
	    }  
	  
	  public interface onNoOnclickListener {  
	      public void onNoClick();  
	    }  
	    
	  public interface onCancelClickListener {  
	      public void onCancelClick();
	    }    
	    
}
