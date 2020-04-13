package com.example.hello;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.webkit.WebView;
import android.view.KeyEvent;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity {
    private WebView webview;

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Window window = getWindow();
        //隐藏标题栏
//        requestWindowFeature(Window.FEATURE_NO_TITLE);//隐藏状态栏
        //定义全屏参数
        int flag=WindowManager.LayoutParams.FLAG_FULLSCREEN;
        //设置当前窗体为全屏显示
        window.setFlags(flag, flag);

        //setContentView(R.layout.activity_main);
        //实例化WebView对象
        webview = new WebView(this);

        //[*关键的三行start]
        //设置WebView属性，能够执行Javascript脚本
        webview.getSettings().setJavaScriptEnabled(true);
        webview.getSettings().setAllowFileAccessFromFileURLs(true);
        webview.getSettings().setAllowUniversalAccessFromFileURLs(true);
        //[*关键的三行end]

        //加载需要显示的网页
        webview.loadUrl("https://wz71014q.github.io/");
        //设置Web视图
        setContentView(webview);
        this.getSupportActionBar().hide();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if((keyCode == KeyEvent.KEYCODE_BACK) && webview.canGoBack() ){
            webview.goBack();
            return  true;
        }
        return  false;
    }
}