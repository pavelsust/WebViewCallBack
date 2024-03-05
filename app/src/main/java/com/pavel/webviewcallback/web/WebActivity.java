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
    webView.addJavascriptInterface(new WebViewJsInterface(this), "iscreen");
    webView.setWebViewClient(new CustomWebViewClient());
    webView.loadUrl("https://stage.rockstreamer.com/?token=eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6NDEzMDYsInByb3ZpZGVyX2lkIjoicGhvbmUiLCJyb2xlIjowLCJ1c2VybmFtZSI6Iis4ODAxMzEzODk5OTg2IiwicGxhdGZvcm0iOiJpc2NyZWVuIiwicGFydG5lciI6IkdQX01ZR1AiLCJzdWJzY3JpYmUiOmZhbHNlLCJwYWNrYWdlSW5mbyI6bnVsbCwiaXNUVk9EIjpmYWxzZSwidHZvZEV4cGlyZURhdGUiOiIxOTcwLTAxLTAxIiwiaWF0IjoxNzA5NjMxNjI4LCJleHAiOjE3MDk3MTgwMjh9.Ke8n2TDsWnU3MPNdhRc7Iw3cl51bPO3RwfZDATOMxr2tzwxbHLNGuOxnz47nWR946SkClBo-EifHUBXmEtjFt5SSeN1FN7uVadgVgnFlPoIZEt80uPLZEKvBXkrUgcGFSy635PrvxsPeMrYc5fn_tSOel9SCRtWmgqqL5Po4gFjowTG5Q0Suv6pPpwPcH8tOKH0EmsADtp_2S3ZTZTrmKy_DCskGEd9XuEYTG6FrE5V2-rktDHeik8gIPEisUOTTTvvae8_pv9qtzTf62NBIfpbFf1lMn9K5cGi9fhPdPJGxV9EQmIRClLv4Zu7Ty6OVqT2sRsV-ZV-Mhh7ppNv8XxyPSZcWO_sH1gZ7orvXbWl8mqQPrFXkRvhMdXvXJmRWUTaYttJKcMhOMFl9DNBMQ7HRxrhSDy4DhAn5uzNTkkmh1AL_eO0Avp8u5nbC0OWNudSxp3M7fuNliAlbzpK90k37FSQL7o_oIkRBClI3j0f5URIKtJ6uqA7UqJT2gCH_ykphCIZ8O-Y4uRYLITXxRCUWig5oG5hNrnOGsZndauQyvb3NG6HkvuvS27kJdvVQQRkUFBDpYivyCGRym1ZclA9JFi2lCI4-llE2IVRPy06an9A3UeeMbKmNknl_P6sp78krDQx4DXIoP_FqZJQXKdgo6M9jwgz9QHNxO8AW_r4");
  }
}