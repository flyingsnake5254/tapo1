package com.tplink.iot.view.authflip;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentActivity;
import com.tplink.iot.R;
import com.tplink.iot.Utils.t0;
import java.util.Objects;

/* loaded from: classes2.dex */
public class WebViewFragment extends BaseAppFlipFragment {
    private WebView q = null;
    private ProgressBar x = null;
    private View y;
    private boolean z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FragmentActivity activity = WebViewFragment.this.getActivity();
            Objects.requireNonNull(activity);
            activity.onBackPressed();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class b extends WebViewClient {
        private b() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            if (!WebViewFragment.this.z && WebViewFragment.this.y != null && WebViewFragment.this.q != null) {
                WebViewFragment.this.y.setVisibility(8);
                WebViewFragment.this.q.setVisibility(0);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            super.onReceivedError(webView, webResourceRequest, webResourceError);
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            return false;
        }

        /* synthetic */ b(WebViewFragment webViewFragment, a aVar) {
            this();
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
                WebViewFragment.this.x.setVisibility(8);
            } else {
                WebViewFragment.this.x.setProgress(i);
            }
        }

        /* synthetic */ c(WebViewFragment webViewFragment, a aVar) {
            this();
        }
    }

    private void J0() {
        setHasOptionsMenu(true);
        ((Toolbar) this.f8326c.findViewById(R.id.toolbar)).setNavigationOnClickListener(new a());
        ProgressBar progressBar = (ProgressBar) this.f8326c.findViewById(R.id.web_progressbar);
        this.x = progressBar;
        progressBar.setMax(100);
        this.x.setVisibility(0);
        View findViewById = this.f8326c.findViewById(R.id.web_refresh_layout);
        this.y = findViewById;
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.tplink.iot.view.authflip.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WebViewFragment.this.L0(view);
            }
        });
        this.x.setProgress(0);
        WebView webView = (WebView) this.f8326c.findViewById(R.id.lwa_webview);
        this.q = webView;
        O0(webView.getSettings());
        this.q.setWebViewClient(new b(this, null));
        this.q.setWebChromeClient(new c(this, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: K0 */
    public /* synthetic */ void L0(View view) {
        N0();
    }

    private void N0() {
        if (t0.g(getActivity())) {
            this.z = false;
            this.x.setProgress(0);
            this.x.setVisibility(0);
            this.y.setVisibility(8);
            this.q.loadUrl(this.f8328f.w());
            return;
        }
        this.z = true;
        this.y.setVisibility(0);
        this.q.setVisibility(8);
        this.x.setVisibility(8);
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    private void O0(WebSettings webSettings) {
        webSettings.setJavaScriptEnabled(true);
    }

    @Override // com.tplink.iot.view.authflip.BaseAppFlipFragment
    public int A0() {
        return R.layout.fragment_webview;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        J0();
        N0();
    }
}
