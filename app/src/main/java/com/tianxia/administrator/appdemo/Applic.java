package com.tianxia.administrator.appdemo;

import android.app.Application;
import android.content.Context;
import android.os.Environment;
import android.util.Log;

import com.dodola.rocoofix.RocooFix;

import java.io.File;

/**
 * Created by Administrator on 16-6-14.
 */
public class Applic extends Application {
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        String absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
        //打补丁
        RocooFix.init(this);
        if(new File(absolutePath+"/patch.jar").exists()){
            Log.i("ceshi","you file");
            RocooFix.applyPatch(this, absolutePath + "/patch.jar");
        }else{
            Log.i("ceshi","no file");
        }
        //RocooFix.initPathFromAssets(this, "patch.jar");
    }
}
