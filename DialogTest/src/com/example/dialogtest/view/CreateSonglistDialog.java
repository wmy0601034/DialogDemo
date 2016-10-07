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
	private onYesOnclickListener yesOnclickListener;//ȷ����ť������˵ļ�����  
    private onCancelClickListener oncancelClickListener;
	public CreateSonglistDialog(Context context) {
		super(context, R.style.MyDialog);  
		// TODO �Զ����ɵĹ��캯�����
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
        //���հ״�����ȡ������  
        setCanceledOnTouchOutside(false);  
  
        //��ʼ������ؼ�  
        initView();  
        //��ʼ������ؼ����¼�  
        initEvent();  
          
    }
	
	private void initEvent() {
		// TODO �Զ����ɵķ������
		ensure_tv.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO �Զ����ɵķ������
				 yesOnclickListener.onYesClick(songlistName_ed.getText().toString());  
			}
		});
		
		cancel_tv.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO �Զ����ɵķ������
				if(oncancelClickListener!=null){
					oncancelClickListener.onCancelClick();
				}
			}
		});
		
		cancel_img.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO �Զ����ɵķ������
				if(oncancelClickListener!=null){
					oncancelClickListener.onCancelClick();
				}
			}
		});
		songlistName_ed.setOnFocusChangeListener(new View.OnFocusChangeListener() {
			
			@Override
			public void onFocusChange(View v, boolean hasFocus) {
				// TODO �Զ����ɵķ������
				if(hasFocus){
					getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
				}
			}
		});
	}
	
	private void initView() {
		// TODO �Զ����ɵķ������
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
