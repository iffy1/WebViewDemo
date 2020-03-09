package com.example.myapplication;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.alibaba.android.arouter.launcher.ARouter;
import com.phz.webviewdemo.ICallBackFromMainToWeb;
import com.phz.webviewdemo.IWebViewToMain;

/**
 * author : iffy
 * time   : 2020/03/08
 */
public class MainService extends Service {

    Binder b = new IWebViewToMain.Stub() {
        @Override
        public void execute(String cmd, String content, ICallBackFromMainToWeb cb) throws RemoteException {
            Log.e("iffy","主应用收到webview的请求"+content);
            cb.handleCallBack("我已经收到消息");
            if ("start_activity".equals(cmd)) {
                ARouter.getInstance().build(content).navigation();
            }
        }

        @Override
        public void linkToDeath(@NonNull DeathRecipient recipient, int flags) {
            super.linkToDeath(recipient, flags);
        }

        @Override
        public boolean unlinkToDeath(@NonNull DeathRecipient recipient, int flags) {
            return super.unlinkToDeath(recipient, flags);
        }
    };

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.e("iffy","开始bind onBind");
        return b;
    }


}
