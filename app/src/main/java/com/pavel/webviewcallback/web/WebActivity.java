package com.pavel.webviewcallback.web;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.webkit.ConsoleMessage;
import android.webkit.CookieManager;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebStorage;
import android.webkit.WebView;

import androidx.appcompat.app.AppCompatActivity;

import com.pavel.webviewcallback.R;

public class WebActivity extends AppCompatActivity {

  private String TAG = "CustomWebViewClient";
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_web);

    String extra = getIntent().getStringExtra(TokenActivityKt.EXTRA_TOKEN);

    initWebView(extra);
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
      WebView.setWebContentsDebuggingEnabled(true);
    }
  }

  private void initWebView(String token) {
    WebView webView = findViewById(R.id.webView);
    webView.getSettings().setJavaScriptEnabled(true);
    webView.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
    webView.setVerticalScrollBarEnabled(false);
    webView.getSettings().setDomStorageEnabled(true);
    webView.getSettings().setAllowFileAccess(true);
    webView.setHorizontalScrollBarEnabled(false);
    webView.getSettings().setUseWideViewPort(false);
    //webView.clearCache(true);
    webView.addJavascriptInterface(new WebViewJsInterface(this), "iscreen");
    webView.setWebViewClient(new CustomWebViewClient(this));
//    webView.setWebContentsDebuggingEnabled(true);
//
//    WebStorage.getInstance().deleteAllData();
//
//    // Clear all the cookies
//    CookieManager.getInstance().removeAllCookies(null);
//    CookieManager.getInstance().flush();
//
//    webView.clearCache(true);
//    webView.clearFormData();
//    webView.clearHistory();
//    webView.clearSslPreferences();
    webView.setWebChromeClient(new WebChromeClient() {
      @Override
      public boolean onConsoleMessage(ConsoleMessage consoleMessage) {

        Log.d(TAG, consoleMessage.message() + " -- From line "
                + consoleMessage.lineNumber() + " of "
                + consoleMessage.sourceId());
        return super.onConsoleMessage(consoleMessage);
      }
    });
    webView.loadUrl("https://stage.rockstreamer.com?token="+token);
  }
}