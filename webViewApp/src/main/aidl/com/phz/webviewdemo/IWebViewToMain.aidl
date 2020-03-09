// IWebViewToMain.aidl
package com.phz.webviewdemo;
import com.phz.webviewdemo.ICallBackFromMainToWeb;
// Declare any non-default types here with import statements

//所有非基本类型的参数都需要一个定向
//in 表示数据只能由客户端流向服务端
//out 表示数据只能由服务端流向客户端
//inout 则表示数据可以在服务端与客户端之间双向流通

interface IWebViewToMain {
        void execute(String cmd, String content,in ICallBackFromMainToWeb cb);
}
