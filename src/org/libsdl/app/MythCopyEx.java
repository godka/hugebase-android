package org.libsdl.app;

import java.io.File;
import java.io.IOException;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;

public class MythCopyEx extends Activity {

    //���ý�ѹĿ��·��  
     
  
    @Override  
    public void onCreate(Bundle savedInstanceState) {  
        super.onCreate(savedInstanceState);
        final String OUTPUT_DIRECTORY = Environment.getExternalStorageDirectory().getPath() + "/Android/data/" + this.getPackageName() + "/files/";
     	
    	File file  = new File(OUTPUT_DIRECTORY + "/game");
		if(file.exists()){

			Intent intent = new Intent();
			Bundle bundle = new Bundle();
			intent.putExtras(bundle);
			intent.setClass(MythCopyEx.this, SDLActivity.class);
			startActivity(intent);
			finish();
		}else{
			file.mkdirs();
			final ProgressDialog dialog = new ProgressDialog(MythCopyEx.this);  
			dialog.setTitle("��ʾ");  
			dialog.setMessage("���ڽ�ѹ�ļ������Ժ�");  
			dialog.show();//��ʾ�Ի���  
    		new Thread(){  
    			public void run() {  
                //�����߳�����ͬ�����Ƿ�ʽ��ѹ  
    				try {  
    					MythUnzipfiles.unZip(MythCopyEx.this, "game.zip", OUTPUT_DIRECTORY, true);  
    					Intent intent = new Intent();
    					Bundle bundle = new Bundle();
    					intent.putExtras(bundle);
    					intent.setClass(MythCopyEx.this, SDLActivity.class);
    					startActivity(intent);
    					finish();
    					System.exit(0);
    				} catch (IOException e) {  
                    // TODO Auto-generated catch block  
    					e.printStackTrace();  
    				}  
    				dialog.cancel();//��ѹ��ɺ�رնԻ���  
    			}                     
    		}.start();  
		}
    }
}
