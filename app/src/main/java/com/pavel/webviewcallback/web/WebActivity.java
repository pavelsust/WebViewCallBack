package com.pavel.webviewcallback.web;

import android.os.Build;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

import androidx.appcompat.app.AppCompatActivity;

import com.pavel.webviewcallback.R;

public class WebActivity extends AppCompatActivity {


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_web);
    initWebView();
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
      WebView.setWebContentsDebuggingEnabled(true);
    }
  }

  private void initWebView() {
    WebView webView = (WebView) findViewById(R.id.webView);
    webView.getSettings().setJavaScriptEnabled(true);
    webView.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
    webView.setVerticalScrollBarEnabled(false);
    webView.getSettings().setDomStorageEnabled(true);
    webView.getSettings().setAllowFileAccess(true);
    webView.setHorizontalScrollBarEnabled(false);
    webView.getSettings().setUseWideViewPort(false);
    webView.addJavascriptInterface(new WebViewJsInterface(this, webView), "iscreen");
    webView.setWebViewClient(new CustomWebViewClient());
    webView.loadUrl("https://dev.rockstreamer.com/video/5234?token=eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6NDEyOTcsInByb3ZpZGVyX2lkIjoicGhvbmUiLCJyb2xlIjowLCJ1c2VybmFtZSI6Iis4ODAxNzkzNzI2Nzc2IiwicGxhdGZvcm0iOiJpc2NyZWVuIiwicGFydG5lciI6IkdQX01ZR1AiLCJzdWJzY3JpYmUiOnRydWUsInBhY2thZ2VJbmZvIjp7Im5hbWUiOiJTdWJzY3JpYmUiLCJkZXNjcmlwdGlvbiI6IlN1YnNjcmliZSIsInByaWNlIjoiMzAiLCJ1bml0IjoiQkRUIiwiY291bnRyeUNvZGUiOiJCRCIsImNvbG9yQ29kZSI6bnVsbCwicHJvZHVjdElkIjoiR1BPQ0lTQ1JFRU5QMSIsInBheW1lbnRNZXRob2RUeXBlIjoic2VydmljZV9idW5kbGUiLCJleHBpcmVEYXRlIjoiMjAyNC0wMi0xNSJ9LCJpc1RWT0QiOnRydWUsInR2b2RFeHBpcmVEYXRlIjoiMjAyNC0wMi0xNSIsImlhdCI6MTcwNTQ5NDQ3OCwiZXhwIjoxNzA1NTgwODc4fQ.UAgtuynNSaMlN_Wqz3hFaYLOuqVD56b_xJKxS3ZqvzoDaq5sZMMm422uUstTFdIscGypWDh1EDj5DdtkywYsQ0bjOVBPre1nHYvtCSE5QTKtdYrmKh12LRBw4I5RKcDqXmKtALc8eyXV2vfFxihkx0_dooKojf9Jutnd8UIxDR_U__EvuCKYreYVpZgrjA8sqehFKt1KyLbS7Cc9z2uNPGExzSaBt0pGiqo2vnjVytwCQ4MUYb5g91dkn5-RSeqkXv3feOPeiG_EibxJZc2RTV0tz7qe751hgcBvjzPYmZ7RTMesp9yxKdt7hv5FcnKuKI6uTiThQc6c2o7pA9myFheLlYLkwOAgnakhhYKPzaj42odybhBasXF0-Q8RUntBHGbk0zknmxnxT4_Cmr72e09Rt33v690gnJh1CjQ_Ns9Becyt-XoItALudj9oa5IogrA-WpsyzRUonDnKXCQ7tMSpkMY3NfdY-HvLTBHQKiPFH8Z8ee5rLn_Qp9QYfkP7ZN3rWo2Rnv6IE3Fn6rxM_XaD-WUcBC_J47AoyMXYUTpaBrUWMbI_UYRD19TCHJvTfHBrSSHevtqovbjjk2LMAMoybDeT398DBy6_bjF4shvCT1oUC06LLgwc95ee1_GTbSxp91gVQY0HIYh4mHxlKCbNsOR7W13270ytqnEBv7c");
  }
}
