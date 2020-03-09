// IWebViewToMain.aidl
package com.phz.webviewdemo;

import com.phz.webviewdemo.ICallBackFromMainToWeb;

// Declare any non-default types here with import statements

interface IWebViewToMain {
        void execute(String cmd, String content,in ICallBackFromMainToWeb cb);
}
