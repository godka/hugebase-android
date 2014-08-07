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

    //设置解压目的路径  
     
  
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
			dialog.setTitle("提示");  
			dialog.setMessage("正在解压文件，请稍后！");  
			dialog.show();//显示对话框  
    		new Thread(){  
    			public void run() {  
                //在新线程中以同名覆盖方式解压  
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
    				dialog.cancel();//解压完成后关闭对话框  
    			}                     
    		}.start();  
		}
    }
}
