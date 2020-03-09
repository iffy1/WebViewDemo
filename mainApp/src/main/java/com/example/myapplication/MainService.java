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
import com.phz.webviewdemo.IWebViewToMain;

/**
 * author : iffy
 * time   : 2020/03/08
 */
public class MainService extends Service {

    Binder b = new IWebViewToMain.Stub() {
        @Override
        public void linkToDeath(@NonNull DeathRecipient recipient, int flags) {
            super.linkToDeath(recipient, flags);
        }

        @Override
        public boolean unlinkToDeath(@NonNull DeathRecipient recipient, int flags) {
            return super.unlinkToDeath(recipient, flags);
        }

        @Override
        public void execute(String cmd, String content) throws RemoteException {
            Log.e("iffy","主应用收到webview的请求"+content);
            if ("start_activity".equals(cmd)) {
//                Intent i = new Intent(MainService.this,TestaActivity.class);
//                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                startActivity(i);
                ARouter.getInstance().build(content).navigation();
            }
        }
    };

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.e("iffy","开始bind onBind");
        return b;
    }


}
