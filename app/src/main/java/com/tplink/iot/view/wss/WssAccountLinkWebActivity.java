package com.tplink.iot.view.wss;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.iot.R;
import com.tplink.iot.Utils.s0;
import com.tplink.iot.Utils.t0;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.viewmodel.wss.WssViewModel;
import com.tplink.libtpmediastatistics.SSLClient;
import com.tplink.libtpnetwork.libwss.bean.params.SkillActiveParams;

/* loaded from: classes2.dex */
public class WssAccountLinkWebActivity extends BaseActivity implements View.OnClickListener {
    private View p0;
    private WssViewModel p1;
    private boolean p2;
    private WebView y = null;
    private ProgressBar z = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements Observer<Boolean> {
        a() {
        }

        /* renamed from: a */
        public void onChanged(@Nullable Boolean bool) {
            s0.g();
            if (org.apache.commons.lang.b.b(bool)) {
                WssAccountLinkWebActivity.this.setResult(-1);
                WssAccountLinkWebActivity.this.overridePendingTransition(R.anim.translate_between_interface_bottom_in, R.anim.translate_between_interface_bottom_out);
                WssAccountLinkWebActivity.this.finish();
            } else if (bool != null && !bool.booleanValue()) {
                s0.s(WssAccountLinkWebActivity.this, R.string.common_operation_failed);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            s0.l(WssAccountLinkWebActivity.this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class c extends WebViewClient {
        private c() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            if (!WssAccountLinkWebActivity.this.p2 && WssAccountLinkWebActivity.this.p0 != null && WssAccountLinkWebActivity.this.y != null) {
                WssAccountLinkWebActivity.this.p0.setVisibility(8);
                WssAccountLinkWebActivity.this.y.setVisibility(0);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            super.onReceivedError(webView, webResourceRequest, webResourceError);
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            b.d.w.c.a.e("url", str + "");
            if (TextUtils.isEmpty(str) || !str.startsWith("https://alexa-ffs.tplinknbu.com/v1/public/ffs/redirect/android") || !str.contains("code=")) {
                return false;
            }
            StringBuilder sb = new StringBuilder();
            for (int indexOf = str.indexOf("code=") + 5; indexOf < str.length() && str.charAt(indexOf) != '&'; indexOf++) {
                sb.append(str.charAt(indexOf));
            }
            String sb2 = sb.toString();
            b.d.w.c.a.e("wss_code", sb2 + SSLClient.WHITE_SPACE);
            WssAccountLinkWebActivity.this.k1(sb2);
            return true;
        }

        /* synthetic */ c(WssAccountLinkWebActivity wssAccountLinkWebActivity, a aVar) {
            this();
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            super.onReceivedError(webView, i, str, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class d extends WebChromeClient {
        private d() {
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i) {
            if (i == 100) {
                WssAccountLinkWebActivity.this.z.setVisibility(8);
            } else {
                WssAccountLinkWebActivity.this.z.setProgress(i);
            }
        }

        /* synthetic */ d(WssAccountLinkWebActivity wssAccountLinkWebActivity, a aVar) {
            this();
        }
    }

    private void j1() {
        c1("");
        ProgressBar progressBar = (ProgressBar) findViewById(R.id.web_progressbar);
        this.z = progressBar;
        progressBar.setMax(100);
        this.z.setVisibility(0);
        View findViewById = findViewById(R.id.web_refresh_layout);
        this.p0 = findViewById;
        findViewById.setOnClickListener(this);
        this.z.setProgress(0);
        WebView webView = (WebView) findViewById(R.id.lwa_webview);
        this.y = webView;
        n1(webView.getSettings());
        this.y.setWebViewClient(new c(this, null));
        this.y.setWebChromeClient(new d(this, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k1(String str) {
        runOnUiThread(new b());
        SkillActiveParams skillActiveParams = new SkillActiveParams();
        skillActiveParams.setAmazonAuthCode(str);
        this.p1.h(skillActiveParams);
    }

    private void l1() {
        if (t0.g(this)) {
            this.p2 = false;
            this.z.setProgress(0);
            this.z.setVisibility(0);
            this.p0.setVisibility(8);
            this.y.loadUrl("https://www.amazon.com/ap/oa?client_id=amzn1.application-oa2-client.06037d9eeed544e1b0490368ab295cae&scope=alexa::skills:account_linking%20frustration_free_setup::device:setup&redirect_uri=https://alexa-ffs.tplinknbu.com/v1/public/ffs/redirect/android&response_type=code&stage=live");
            return;
        }
        this.p2 = true;
        this.p0.setVisibility(0);
        this.y.setVisibility(8);
        this.z.setVisibility(8);
    }

    private void m1() {
        this.p1.j().observe(this, new a());
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    private void n1(WebSettings webSettings) {
        webSettings.setJavaScriptEnabled(true);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.web_refresh_layout) {
            l1();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_wss_account_link_web);
        this.p1 = (WssViewModel) ViewModelProviders.of(this).get(WssViewModel.class);
        j1();
        l1();
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
