package com.phz.webviewdemo;

import android.annotation.SuppressLint;
import android.os.RemoteException;
import android.util.Log;
import android.webkit.JavascriptInterface;

import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/**
 * @author 彭海卓 on 2019/12/3
 * @introduction
 */
public class JsBridge extends Object {


    IWebViewToMain service;

    public JsBridge(@Nullable IWebViewToMain mainAppService) {
        service = mainAppService;
    }



    //@SuppressLint("JavascriptInterface")
    @JavascriptInterface
    public void printLog(String s) {
        Log.e("JsCallJava", s);
    }

    //@SuppressLint("JavascriptInterface")
    @JavascriptInterface
    public void printLogNew(String s) {
        Log.e("JsCallJavaNew", s);
    }

    @SuppressLint("JavascriptInterface")
    @JavascriptInterface
    public void post(String command, String param) {
        Log.e("command", command);
        Log.e("param", param);
        try {
            service.execute(command, param);
        } catch (RemoteException e) {
            e.printStackTrace();
        }

    }
}
