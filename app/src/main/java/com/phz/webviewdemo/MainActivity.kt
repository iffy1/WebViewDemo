package com.phz.webviewdemo

import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.ViewGroup
import android.webkit.JsPromptResult
import android.webkit.JsResult
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.FileProvider
import androidx.databinding.DataBindingUtil
import com.phz.webviewdemo.R.layout.activity_main
import com.phz.webviewdemo.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*
import java.io.File

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var wb:WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_main)
        binding=DataBindingUtil.setContentView(this, activity_main)
        wb= WebView(this)
        val layoutParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
        wb.settings.javaScriptEnabled=true
        //允许js弹窗
        wb.settings.javaScriptCanOpenWindowsAutomatically=true
        wb.settings.loadWithOverviewMode=true
        wb.settings.setSupportZoom(true)
        wb.settings.builtInZoomControls=true
        var file = File(cacheDir,"test.html")
        if (!file.exists()){
            file.createNewFile()
        }
        //曲线救国，我太难了，assets文件拿不到，只能复制一份
        Util.writeBytesToFile(assets.open("test.html"),file)
        var uri: Uri=FileProvider.getUriForFile(this, "com.phz.webviewdemo.provider", file)
        wb.addJavascriptInterface(JsBridge(),"jsb")
        wb.loadUrl(uri.toString())
        wb.webChromeClient=MyChromeClient()
        cl.addView(wb,layoutParams)

        bt.setOnClickListener {
            // 调用javascript的callJS()方法
//            wb.loadUrl("javascript:test(6,6)")
            wb.loadUrl("javascript:testPop()")
        }
    }

    class MyChromeClient: WebChromeClient() {
        override fun onJsAlert(
            view: WebView?,
            url: String?,
            message: String?,
            result: JsResult?
        ): Boolean {
            Log.e("onJsAlert", "$url|$message|$result")
            return super.onJsAlert(view, url, message, result)
        }

        override fun onJsPrompt(
            view: WebView?,
            url: String?,
            message: String?,
            defaultValue: String?,
            result: JsPromptResult?
        ): Boolean {
            Log.e("onJsPrompt", "$url|$message|$result")
            return super.onJsPrompt(view, url, message, defaultValue, result)
        }

        override fun onJsConfirm(
            view: WebView?,
            url: String?,
            message: String?,
            result: JsResult?
        ): Boolean {
            Log.e("onJsConfirm", "$url|$message|$result")
            return super.onJsConfirm(view, url, message, result)
        }
    }

}
