package com.fuentesedge20.empleoenper;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class TODOSFragment extends Fragment {


    private View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_todo, container, false);

        WebView myWebView = (WebView)view.findViewById(R.id.WebViewEmpleos);
        myWebView.loadUrl("https://www.trabajando.pe/");
        myWebView.setWebViewClient(new MyWebViewClient());
        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        return view;
    }
    private class MyWebViewClient extends WebViewClient {

    }
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        WebView mWebView;
        mWebView = (WebView) view.findViewById(R.id.WebViewEmpleos);
        if (event.getAction() == KeyEvent.ACTION_DOWN) {
            switch (keyCode) {
                case KeyEvent.KEYCODE_BACK:
                    if (mWebView.canGoBack()) {
                        mWebView.goBack();
                    } else {

                    }
                    return true;
            }
        }
        return onKeyDown(keyCode, event);
    }


}
