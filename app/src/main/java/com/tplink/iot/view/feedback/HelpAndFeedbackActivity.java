package com.tplink.iot.view.feedback;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.tplink.iot.R;
import com.tplink.iot.Utils.StatusBarUtils;
import com.tplink.iot.Utils.TPMaterialDialogV2;
import com.tplink.iot.Utils.t0;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.core.o;
import com.tplink.iot.model.about.d;
import com.tplink.iot.widget.viewgroup.AutoScrolledWebView;
import com.tplink.libtpnetwork.Utils.l;
import com.tplink.libtpnetwork.enumerate.EnumDeviceType;

/* loaded from: classes2.dex */
public class HelpAndFeedbackActivity extends BaseActivity {
    private String H3;
    @BindView
    TextView mFeedback;
    @BindView
    AutoScrolledWebView mFeedbackWebView;
    @BindView
    ProgressBar mLoadingProgress;
    @BindView
    View mRefreshLayout;
    private String p3;
    private boolean z;
    private MenuItem y = null;
    private boolean p0 = false;
    private String p1 = "";
    private String p2 = "";

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class b extends WebChromeClient {
        private b() {
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i) {
            if (i == 100) {
                HelpAndFeedbackActivity.this.mLoadingProgress.setVisibility(8);
            } else {
                HelpAndFeedbackActivity.this.mLoadingProgress.setProgress(i);
            }
        }
    }

    private void g1() {
        if (this.mFeedbackWebView.canGoBack()) {
            this.mFeedbackWebView.goBack();
        } else {
            finish();
        }
    }

    private void h1() {
        Bundle extras;
        if (!(getIntent() == null || (extras = getIntent().getExtras()) == null)) {
            this.p0 = extras.getBoolean("help_feed_back_device_setup_fail_flag");
            this.p1 = extras.getString("help_feed_back_device_faq_url", "");
            this.p2 = extras.getString("help_feed_back_device_name", "");
            this.p3 = extras.getString("help_feed_back_device_type", EnumDeviceType.UNKNOWN.getDeviceType());
            this.H3 = extras.getString("help_feed_back_feedback_category", "");
        }
        if (TextUtils.isEmpty(this.H3)) {
            this.H3 = EnumFeedbackCategory.fromDeviceType(this.p3).getValue();
        }
    }

    @SuppressLint({"JavascriptInterface"})
    private void i1() {
        c1(this.p2);
        this.mLoadingProgress.setMax(100);
        this.mLoadingProgress.setVisibility(0);
        this.mRefreshLayout.setVisibility(8);
        j1();
        this.mFeedbackWebView.setWebViewClient(new c());
        this.mFeedbackWebView.setWebChromeClient(new b());
    }

    private void j1() {
        this.mFeedbackWebView.getSettings().setJavaScriptEnabled(true);
        this.mFeedbackWebView.getSettings().setDefaultTextEncodingName("UTF-8");
        this.mFeedbackWebView.getSettings().setAllowFileAccess(true);
        this.mFeedbackWebView.getSettings().setAllowFileAccessFromFileURLs(true);
        this.mFeedbackWebView.getSettings().setAllowContentAccess(true);
        this.mFeedbackWebView.getSettings().setDomStorageEnabled(true);
        this.mFeedbackWebView.getSettings().setAppCacheEnabled(false);
        this.mFeedbackWebView.getSettings().setCacheMode(2);
        this.mFeedbackWebView.getSettings().setSupportZoom(false);
        this.mFeedbackWebView.getSettings().setBuiltInZoomControls(false);
        this.mFeedbackWebView.setLayerType(1, null);
    }

    public static void k1(Context context, String str, String str2, String str3, String str4, EnumFeedbackCategory enumFeedbackCategory) {
        Intent intent = new Intent(context, HelpAndFeedbackActivity.class);
        intent.putExtra("help_feed_back_device_faq_url", str);
        intent.putExtra("help_feed_back_device_name", str2);
        intent.putExtra("help_feed_back_device_type", str3);
        intent.putExtra("help_feed_back_device_model", str4);
        intent.putExtra("help_feed_back_feedback_category", enumFeedbackCategory.getValue());
        context.startActivity(intent);
    }

    public static void l1(Context context, String str, String str2, String str3, String str4) {
        Intent intent = new Intent(context, HelpAndFeedbackActivity.class);
        intent.putExtra("help_feed_back_device_setup_fail_flag", true);
        intent.putExtra("help_feed_back_device_faq_url", str);
        intent.putExtra("help_feed_back_device_name", str2);
        intent.putExtra("help_feed_back_device_type", str3);
        intent.putExtra("help_feed_back_device_model", str4);
        context.startActivity(intent);
    }

    public static void m1(Context context, String str, String str2, EnumFeedbackCategory enumFeedbackCategory) {
        Intent intent = new Intent(context, HelpAndFeedbackActivity.class);
        intent.putExtra("help_feed_back_device_faq_url", str);
        intent.putExtra("help_feed_back_device_name", str2);
        intent.putExtra("help_feed_back_feedback_category", enumFeedbackCategory.getValue());
        context.startActivity(intent);
    }

    private void n1() {
        if (t0.g(this)) {
            this.z = false;
            this.mLoadingProgress.setProgress(0);
            this.mLoadingProgress.setVisibility(0);
            b.d.w.c.a.e("Feedback", "FAQ URL: " + this.p1);
            this.mFeedbackWebView.loadUrl(this.p1);
            return;
        }
        this.z = true;
        this.mRefreshLayout.setVisibility(0);
        this.mFeedbackWebView.setVisibility(8);
        this.mLoadingProgress.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @OnClick
    public void gotoSelectFeedbackDeviceActivity() {
        Intent intent = new Intent(this, SelectFeedbackDeviceActivity.class);
        intent.putExtra("help_feed_back_device_type", this.p3);
        intent.putExtra("help_feed_back_feedback_category", this.H3);
        String a2 = d.a();
        if (this.p0) {
            intent.setClass(this, FeedBackWebActivity.class);
            intent.putExtra("feed_back_faq_params", d.c(this, null, this.p2));
        } else if (!this.p1.startsWith("https://www.tapo.com/app/#/faqList2?categoryType=") || !this.p1.contains(a2)) {
            intent.putExtra("help_feed_back_total_product_type", "");
        } else {
            intent.putExtra("help_feed_back_total_product_type", this.p1.replace(a2, "").substring(49));
        }
        startActivity(intent);
    }

    @Override // com.tplink.iot.base.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        g1();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    @SuppressLint({"SetJavaScriptEnabled"})
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (o.a() != 0) {
            setContentView(R.layout.activity_help_and_feed_back_webview);
            ButterKnife.a(this);
            StatusBarUtils.n(this, ContextCompat.getColor(this, R.color.common_colorPrimaryDark));
            h1();
            i1();
            n1();
        }
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.common_close, menu);
        MenuItem findItem = menu.findItem(R.id.common_close);
        this.y = findItem;
        findItem.setVisible(false);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        AutoScrolledWebView autoScrolledWebView;
        super.onDestroy();
        if (o.a() != 0 && (autoScrolledWebView = this.mFeedbackWebView) != null) {
            autoScrolledWebView.loadDataWithBaseURL(null, "", "text/html", "utf-8", null);
            this.mFeedbackWebView.clearHistory();
            ((ViewGroup) this.mFeedbackWebView.getParent()).removeView(this.mFeedbackWebView);
            this.mFeedbackWebView.destroy();
            this.mFeedbackWebView = null;
        }
    }

    @Override // com.tplink.iot.base.BaseActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == 16908332) {
            g1();
            return false;
        } else if (itemId != R.id.common_close) {
            return super.onOptionsItemSelected(menuItem);
        } else {
            finish();
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @OnClick
    public void refreshLayout() {
        n1();
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
                Intent intent = new Intent("android.intent.action.DIAL");
                intent.setData(Uri.parse(this.a));
                HelpAndFeedbackActivity.this.startActivity(intent);
            }
        }

        private c() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            HelpAndFeedbackActivity helpAndFeedbackActivity;
            View view;
            super.onPageFinished(webView, str);
            if (HelpAndFeedbackActivity.this.y != null) {
                MenuItem menuItem = HelpAndFeedbackActivity.this.y;
                AutoScrolledWebView autoScrolledWebView = HelpAndFeedbackActivity.this.mFeedbackWebView;
                menuItem.setVisible(autoScrolledWebView != null && autoScrolledWebView.canGoBack());
            }
            if (!HelpAndFeedbackActivity.this.z && (view = (helpAndFeedbackActivity = HelpAndFeedbackActivity.this).mRefreshLayout) != null && helpAndFeedbackActivity.mFeedbackWebView != null) {
                view.setVisibility(8);
                HelpAndFeedbackActivity.this.mFeedbackWebView.setVisibility(0);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            b.d.w.c.a.e("HelpAndFeedback", "onReceivedError: " + i + " description: " + str + " failingUrl: " + str2);
            super.onReceivedError(webView, i, str, str2);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
            b.d.w.c.a.e("HelpAndFeedback", "onReceivedHttpError WebResourceRequest: " + l.g(webResourceRequest));
            super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
        }

        @Override // android.webkit.WebViewClient
        @RequiresApi(api = 21)
        public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
            return super.shouldInterceptRequest(webView, webResourceRequest);
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (str.startsWith("tel:")) {
                new TPMaterialDialogV2.Builder(HelpAndFeedbackActivity.this).k(str.substring(4), R.color.feedback_call_title_color).l(R.string.common_cancel, R.color.common_iot_light_black, null).o(R.string.feed_back_hotline_call, R.color.common_iot_main_blue, new a(str)).g(8, 8).create().show();
                return true;
            } else if (str.startsWith("mailto:")) {
                Intent intent = new Intent("android.intent.action.SENDTO");
                intent.setData(Uri.parse(str));
                HelpAndFeedbackActivity.this.startActivity(intent);
                return true;
            } else {
                HelpAndFeedbackActivity.this.mLoadingProgress.setProgress(0);
                HelpAndFeedbackActivity.this.mLoadingProgress.setVisibility(0);
                return super.shouldOverrideUrlLoading(webView, str);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            b.d.w.c.a.e("HelpAndFeedback", "onReceivedError WebResourceRequest: " + l.g(webResourceRequest) + " WebResourceError: " + l.f(webResourceError));
            super.onReceivedError(webView, webResourceRequest, webResourceError);
        }
    }
}
