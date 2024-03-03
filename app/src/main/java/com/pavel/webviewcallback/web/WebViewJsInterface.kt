package com.pavel.webviewcallback.web

import android.content.Context
import android.webkit.JavascriptInterface
import android.widget.Toast


class WebViewJsInterface(private val context: Context) {
    @JavascriptInterface
    fun tokenStatus(value: Boolean, message: String) {
        Toast.makeText(context, "" + value, Toast.LENGTH_LONG).show()
        Toast.makeText(context, "" + message, Toast.LENGTH_LONG).show()
    }

    @JavascriptInterface
    fun contentChange(path: String, isPremium: Boolean) {
        Toast.makeText(context, "" + isPremium, Toast.LENGTH_LONG).show()
        Toast.makeText(context, "" + path, Toast.LENGTH_LONG).show()
    }

    @JavascriptInterface
    fun eventExecute(params: String) {
        Toast.makeText(context, "event $params", Toast.LENGTH_LONG).show()
    }

}

