package org.libsdl.app;

import java.io.File;
import java.io.IOException;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;

public class MythCopyEx extends Activity {

    //设置解压目的路径  
    public static String OUTPUT_DIRECTORY = Environment  
            .getExternalStorageDirectory().getAbsolutePath() + "/files";  
  
    @Override  
    public void onCreate(Bundle savedInstanceState) {  
    	File file  = new File(OUTPUT_DIRECTORY + "/files/game");
		if(file.exists()){

			Intent intent = new Intent();
			Bundle bundle = new Bundle();
			intent.putExtras(bundle);
			intent.setClass(MythCopyEx.this, SDLActivity.class);
			startActivity(intent);
			finish();
		}else{
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
