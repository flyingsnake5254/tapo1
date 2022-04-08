package com.tplink.iot.view.about;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import com.tplink.iot.R;
import com.tplink.iot.Utils.StatusBarUtils;
import com.tplink.iot.Utils.TPMaterialDialogV2;
import com.tplink.iot.Utils.t0;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.core.o;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/* loaded from: classes2.dex */
public abstract class AbsCommonWebActivity extends BaseActivity implements View.OnClickListener {
    private boolean H3;
    private ProgressBar p0;
    private TPMaterialDialogV2 p1 = null;
    private String p2 = "";
    private MenuItem p3 = null;
    private WebView y;
    private View z;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class b extends WebChromeClient {
        private b() {
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i) {
            if (i == 100) {
                AbsCommonWebActivity.this.p0.setVisibility(8);
            } else {
                AbsCommonWebActivity.this.p0.setProgress(i);
            }
        }
    }

    private void m1() {
        if (this.y.canGoBack()) {
            this.y.goBack();
        } else {
            finish();
        }
    }

    @SuppressLint({"JavascriptInterface"})
    private void p1() {
        Intent intent = getIntent();
        if (intent != null) {
            this.p2 = intent.getStringExtra("url");
        }
        View findViewById = findViewById(R.id.webview_load_failed_layout);
        this.z = findViewById;
        findViewById.setVisibility(8);
        this.z.setOnClickListener(this);
        ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressbar);
        this.p0 = progressBar;
        progressBar.setMax(100);
        this.p0.setVisibility(0);
        WebView webView = (WebView) findViewById(R.id.webview);
        this.y = webView;
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setAllowFileAccess(true);
        settings.setSupportZoom(false);
        settings.setBuiltInZoomControls(false);
        this.y.setWebViewClient(new c());
        this.y.setWebChromeClient(new b());
        this.y.addJavascriptInterface(n1(), o1());
    }

    private void q1() {
        if (t0.g(this)) {
            this.H3 = false;
            this.p0.setProgress(0);
            this.p0.setVisibility(0);
            this.z.setVisibility(8);
            this.y.setVisibility(8);
            this.y.loadUrl(this.p2);
            return;
        }
        this.H3 = true;
        this.z.setVisibility(0);
        this.y.setVisibility(8);
        this.p0.setVisibility(8);
    }

    public abstract Object n1();

    public abstract String o1();

    @Override // com.tplink.iot.base.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        m1();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.webview_load_failed_layout) {
            q1();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    @SuppressLint({"SetJavaScriptEnabled"})
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_common_web);
        if (o.a() != 0) {
            setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
            String stringExtra = getIntent().getStringExtra("toolbar_title");
            if (!TextUtils.isEmpty(stringExtra)) {
                c1(stringExtra);
            }
            p1();
            q1();
            StatusBarUtils.n(this, ContextCompat.getColor(this, R.color.common_colorPrimaryDark));
        }
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.common_close, menu);
        MenuItem findItem = menu.findItem(R.id.common_close);
        this.p3 = findItem;
        findItem.setVisible(false);
        return true;
    }

    @Override // com.tplink.iot.base.BaseActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == R.id.common_close) {
            finish();
            return true;
        } else if (itemId != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        } else {
            m1();
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class c extends WebViewClient {

        /* loaded from: classes2.dex */
        class a implements TPMaterialDialogV2.d {
            final /* synthetic */ String a;

            a(String str) {
                this.a = str;
            }

            @Override // com.tplink.iot.Utils.TPMaterialDialogV2.d
            public void onClick(View view) {
                AbsCommonWebActivity.this.startActivity(new Intent("android.intent.action.DIAL", Uri.parse(this.a)));
            }
        }

        private c() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            if (AbsCommonWebActivity.this.p3 != null) {
                AbsCommonWebActivity.this.p3.setVisible(AbsCommonWebActivity.this.y != null && AbsCommonWebActivity.this.y.canGoBack());
            }
            if (!AbsCommonWebActivity.this.H3 && AbsCommonWebActivity.this.z != null && AbsCommonWebActivity.this.y != null) {
                AbsCommonWebActivity.this.z.setVisibility(8);
                AbsCommonWebActivity.this.y.setVisibility(0);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            AbsCommonWebActivity.this.H3 = true;
            if (!(AbsCommonWebActivity.this.z == null || AbsCommonWebActivity.this.y == null)) {
                AbsCommonWebActivity.this.z.setVisibility(0);
                AbsCommonWebActivity.this.y.setVisibility(8);
            }
            super.onReceivedError(webView, i, str, str2);
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (str.startsWith("tel:")) {
                if (Build.VERSION.SDK_INT < 19) {
                    try {
                        str = URLDecoder.decode(str, "utf-8");
                    } catch (UnsupportedEncodingException e2) {
                        e2.printStackTrace();
                    }
                }
                if (AbsCommonWebActivity.this.p1 == null) {
                    TPMaterialDialogV2.Builder builder = new TPMaterialDialogV2.Builder(AbsCommonWebActivity.this);
                    AbsCommonWebActivity.this.p1 = builder.k(str.substring(4), R.color.feedback_call_title_color).l(R.string.common_cancel, R.color.common_iot_light_black, null).o(R.string.feed_back_hotline_call, R.color.common_iot_main_blue, new a(str)).g(8, 8).create();
                }
                AbsCommonWebActivity.this.p1.show();
                return true;
            }
            webView.loadUrl(str);
            return true;
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            AbsCommonWebActivity.this.H3 = true;
            if (!(AbsCommonWebActivity.this.z == null || AbsCommonWebActivity.this.y == null)) {
                AbsCommonWebActivity.this.z.setVisibility(0);
                AbsCommonWebActivity.this.y.setVisibility(8);
            }
            super.onReceivedError(webView, webResourceRequest, webResourceError);
        }
    }
}
