package com.phz.webviewdemo;

import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author 彭海卓 on 2019/12/2
 * @introduction
 */
public class Util {
    public static void writeBytesToFile(InputStream is, File file) throws IOException {
        FileOutputStream fos = null;
        try {
            byte[] data = new byte[2048];
            int nbread = 0;
            fos = new FileOutputStream(file);
            while((nbread=is.read(data))>-1){
                fos.write(data,0,nbread);
            }
        }
        catch (Exception ex) {
            Log.e("Exception",ex.getMessage());
        }
        finally{
            if (fos!=null){
                fos.close();
            }
        }
    }
}
