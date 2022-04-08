package com.tplink.iot.view.wss;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import androidx.annotation.RequiresApi;
import com.tplink.iot.R;
import com.tplink.iot.Utils.t0;
import com.tplink.iot.base.BaseActivity;

/* loaded from: classes2.dex */
public class WssAmazonInstrWebActivity extends BaseActivity implements View.OnClickListener {
    private View p0;
    private boolean p1;
    private String p2;
    private WebView y = null;
    private ProgressBar z = null;
    private boolean p3 = false;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class b extends WebViewClient {
        private b() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            if (!WssAmazonInstrWebActivity.this.p1 && WssAmazonInstrWebActivity.this.p0 != null && WssAmazonInstrWebActivity.this.y != null) {
                WssAmazonInstrWebActivity.this.p0.setVisibility(8);
                WssAmazonInstrWebActivity.this.y.setVisibility(0);
            }
        }

        @Override // android.webkit.WebViewClient
        @RequiresApi(api = 23)
        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            super.onReceivedError(webView, webResourceRequest, webResourceError);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            super.onReceivedError(webView, i, str, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class c extends WebChromeClient {
        private c() {
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i) {
            if (i == 100) {
                WssAmazonInstrWebActivity.this.z.setVisibility(8);
            } else {
                WssAmazonInstrWebActivity.this.z.setProgress(i);
            }
        }

        @Override // android.webkit.WebChromeClient
        public void onReceivedTitle(WebView webView, String str) {
            if (WssAmazonInstrWebActivity.this.p3) {
                WssAmazonInstrWebActivity.this.c1(str);
            }
        }
    }

    public static void j1(Activity activity, String str) {
        Intent intent = new Intent(activity, WssAmazonInstrWebActivity.class);
        intent.putExtra("UrlExtra", str);
        activity.startActivity(intent);
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    private void k1() {
        c1("");
        View findViewById = findViewById(R.id.web_refresh_layout);
        this.p0 = findViewById;
        findViewById.setOnClickListener(this);
        ProgressBar progressBar = (ProgressBar) findViewById(R.id.web_progressbar);
        this.z = progressBar;
        progressBar.setMax(100);
        WebView webView = (WebView) findViewById(R.id.webview);
        this.y = webView;
        n1(webView.getSettings());
        this.y.setWebViewClient(new b());
        this.y.setWebChromeClient(new c());
    }

    public static void l1(Context context, String str) {
        Intent intent = new Intent(context, WssAmazonInstrWebActivity.class);
        intent.putExtra("UrlExtra", str);
        intent.putExtra("ShowTitleExtra", true);
        context.startActivity(intent);
    }

    private void m1() {
        if (t0.g(this)) {
            this.p1 = false;
            this.z.setProgress(0);
            this.z.setVisibility(0);
            this.p0.setVisibility(8);
            this.y.loadUrl(this.p2);
            return;
        }
        this.p1 = true;
        this.p0.setVisibility(0);
        this.y.setVisibility(8);
        this.z.setVisibility(8);
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    private void n1(WebSettings webSettings) {
        webSettings.setJavaScriptEnabled(true);
    }

    @Override // com.tplink.iot.base.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.y.canGoBack()) {
            this.y.goBack();
        } else {
            finish();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.web_refresh_layout) {
            m1();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_wss_amazon_instr_web);
        this.p2 = getIntent().getStringExtra("UrlExtra");
        this.p3 = getIntent().getBooleanExtra("ShowTitleExtra", false);
        k1();
        m1();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        WebView webView = this.y;
        if (webView != null) {
            webView.stopLoading();
            this.y.getSettings().setJavaScriptEnabled(false);
            this.y.clearHistory();
            this.y.removeAllViews();
            this.y.destroy();
            this.y = null;
        }
        super.onDestroy();
    }
}
