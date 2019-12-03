package com.phz.webviewdemo;

import android.annotation.SuppressLint;
import android.util.Log;
import android.webkit.JavascriptInterface;

/**
 * @author 彭海卓 on 2019/12/3
 * @introduction
 */
public class JsBridge extends Object{
    @SuppressLint("JavascriptInterface")
    @JavascriptInterface
    public void printLog(String s){
        Log.e("JsCallJava",s);
    }

    @SuppressLint("JavascriptInterface")
    @JavascriptInterface
    public void printLogNew(String s){
        Log.e("JsCallJavaNew",s);
    }
}
