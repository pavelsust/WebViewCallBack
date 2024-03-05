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
    fun eventExecute(params: String, value:String) {
        Toast.makeText(context, "event $params", Toast.LENGTH_LONG).show()
        Toast.makeText(context, "value $value", Toast.LENGTH_LONG).show()
    }
}


// class WebViewJsInterface(private val context: Context) {
//    @JavascriptInterface
//    fun eventExecute(params: String?) {
//
//        //Logger.d("PartnerServiceDebugLog params: $params")
//
//        /*val bundle = Bundle()
//
//        if (!TextUtils.isEmpty(params)) {
//
//        val paramArray = params?.split(",")?.toTypedArray()
//
//        bundle.putString(paramArray?.getOrNull(0), paramArray?.getOrNull(1))
//
//        Application.logSDKEvent(partnerSlug, name, bundle)
//
//        }*/
//
//    }
//    @JavascriptInterface
//    fun tokenStatus(value: String?, message: String?) {
//        show("token is ${value}")
//        show("Message is ${message}")
//    }
//
//    @JavascriptInterface
//    fun contentChange(path: String?, isPremium: String?) {
//        show("Path: ${path}")
//        show("Premium: ${isPremium}")
//    }
//
//    fun show(message: String){
//        Toast.makeText(context , message , Toast.LENGTH_SHORT ).show()
//    }
//
//}
//
