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
    //webView.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
    webView.setVerticalScrollBarEnabled(false);
    webView.getSettings().setDomStorageEnabled(true);
    webView.getSettings().setAllowFileAccess(true);
    webView.setHorizontalScrollBarEnabled(false);
    webView.getSettings().setUseWideViewPort(false);
    webView.addJavascriptInterface(new WebViewJsInterface(this), "iscreen");
    webView.setWebViewClient(new CustomWebViewClient());
    webView.loadUrl("https://stage.rockstreamer.com?token=eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6NDEzOTMsInByb3ZpZGVyX2lkIjoicGhvbmUiLCJyb2xlIjowLCJ1c2VybmFtZSI6Iis4ODAxNzk4MDk5OTc3IiwicGxhdGZvcm0iOiJpc2NyZWVuIiwicGFydG5lciI6IkdQX01ZR1AiLCJzdWJzY3JpYmUiOmZhbHNlLCJwYWNrYWdlSW5mbyI6bnVsbCwiaXNUVk9EIjpmYWxzZSwidHZvZEV4cGlyZURhdGUiOiIxOTcwLTAxLTAxIiwiaWF0IjoxNzA5NDQ3MTYzLCJleHAiOjE3MDk1MzM1NjN9.Xq5c9wOy8hFOQWpcINHFyth1qQDdc8nXfFZ_ZVUiFM0oEDi7K0uIN71sKwGSU9QAqBGocwaXRFe1qAiPB078FkuyUP9z7zZNcfPAUoN0wCRNVtfUTIGZ3tnpIOlBHsxPd97LhAQJCENvkoD4owNJ4CsU2hTN-JFUCR8KqD0oTjkjGXQPsp6vj3ntkmD9L-FoZdwze55wJuJQ4ctGv2Y26Oxhr3REQ8Lsv4_Af_Jj89_DCfTUba3ts753KGzZ_U28NiFpK3UnIWD7nh-sHkFqxJp61jExvc3g0OB_sNGQ4zhMExBGNIOAe6kyvMPOirPkkdyP0pCSgG5HZCdPl30Y0eoQpXaXtAHPPmKhUW-6sSaFDjNPkgxNVCxfurTRMuU-rVXIJ1_1-ngodcnS9XVvvGsp6SOnsOkhrXO0Tt3xKkE53yfnjfdDCFWChY-M0c0_R4yMRI4eC3GvJ_LDW4vMpPQ2hAAZ1HVT0nkyxoilBzgsV24_bQt_ozp0cbjIvpzcMoY0zgGSVrjCVFhj4i94zws0DtxuJTTgX-V9o1QjdCPmbGjucd1B_3PLKlN8E3_nzgvjN_N7DCszgv0V1to76kinLzsQ5CsS9kB-KpSUYSFeZOezS3o4_JLIRPircOn8_SQ2X4hWw5ZkcQQh7bEQfXlO_vyvlDHLAbidhh8_Zyg");
  }
}
