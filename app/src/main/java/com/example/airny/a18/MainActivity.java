package com.example.airny.a18;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {
    private WebView mWebView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mWebView = (WebView) findViewById(R.id.webView);
        //включаем поддержку javascript
        mWebView.getSettings().setJavaScriptEnabled(true);
        //указываем страницу загрузки
        mWebView.loadUrl("http://kdcorp.ru");
        mWebView.setWebViewClient(new MyWebViewClient());



    }

    public void onClick(View view) {
        Intent intent = new
                Intent("ru.airnya.Browser");
        intent.setData(Uri.parse("http://kdcorp.ru/"));
        Uri web = Uri.parse("http://www.google.com");
        Intent i = new Intent(Intent.ACTION_VIEW,web);
        startActivity( Intent.createChooser(i, "Choose Program"));
        startActivity(intent);
    }



    private class MyWebViewClient extends WebViewClient
    {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url)
        {
            view.loadUrl(url);
            return true;
        }


    }
        @Override
    public void onBackPressed() {
        if(mWebView.canGoBack()) {
            mWebView.goBack();
        } else{
            super.onBackPressed();
            }
        }
}

