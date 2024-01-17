package com.pavel.webviewcallback.web;

import android.content.Context;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.widget.Toast;

/**
 * Created by anshul on 18/04/17.
 */

public class WebViewJsInterface {

  private WebView webView;
  private Context context;

  public WebViewJsInterface(Context context, WebView webView) {
    this.webView = webView;
    this.context=context;
  }

  @JavascriptInterface
  public void tokenStatus(boolean value, String message) {
    Toast.makeText(context, ""+value, Toast.LENGTH_LONG).show();
    Toast.makeText(context, ""+message, Toast.LENGTH_LONG).show();
  }

  @JavascriptInterface
  public void contentChange(String path, boolean isPremium) {
    Toast.makeText(context, ""+isPremium, Toast.LENGTH_LONG).show();
    Toast.makeText(context, ""+path, Toast.LENGTH_LONG).show();
  }

  @JavascriptInterface
  public void eventExecute(String params) {
    Toast.makeText(context, "event "+params, Toast.LENGTH_LONG).show();
  }

}
