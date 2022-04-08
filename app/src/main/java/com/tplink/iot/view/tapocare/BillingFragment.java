package com.tplink.iot.view.tapocare;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.PointerIconCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import com.android.billingclient.api.Purchase;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;
import com.tplink.iot.R;
import com.tplink.iot.Utils.s0;
import com.tplink.iot.Utils.x0.w;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.view.firmware.FirmwareSlideActivity;
import com.tplink.iot.view.tapocare.BillingFragment;
import com.tplink.iot.viewmodel.billing.BillingViewModel;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class BillingFragment extends Fragment implements k, View.OnClickListener {

    /* renamed from: c  reason: collision with root package name */
    private static final String f9784c = BillingFragment.class.getSimpleName();
    private long I3;
    private String L3;

    /* renamed from: d  reason: collision with root package name */
    private BillingViewModel f9785d;

    /* renamed from: f  reason: collision with root package name */
    private Toolbar f9786f;
    private View p0;
    private View p1;
    private TextView q;
    private TextView x;
    private ProgressBar y;
    private WebView z;
    private boolean p2 = true;
    private boolean p3 = false;
    private String H3 = com.tplink.iot.Utils.v0.e.x();
    private int J3 = 100;
    private boolean K3 = false;

    /* loaded from: classes2.dex */
    public class a extends WebChromeClient {
        public a() {
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i) {
            super.onProgressChanged(webView, i);
            String str = BillingFragment.f9784c;
            b.d.w.c.a.c(str, "onProgressChanged:" + i);
        }

        @Override // android.webkit.WebChromeClient
        public void onReceivedTitle(WebView webView, String str) {
            super.onReceivedTitle(webView, str);
            if (str != null && !str.contains(Constants.IPC_BUNDLE_KEY_SEND_ERROR) && !str.contains("Error") && !str.contains("http")) {
                b.d.w.c.a.e(BillingFragment.f9784c, str);
                BillingFragment.this.m1(str);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b extends WebViewClient {
        public b() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            String str2 = BillingFragment.f9784c;
            b.d.w.c.a.c(str2, "onPageFinished:" + str);
            if (!BillingFragment.this.p2) {
                BillingFragment.this.p1.setVisibility(BillingFragment.this.z.canGoBack() ? 0 : 4);
            }
            if (Uri.decode(str).equals(BillingFragment.this.H3)) {
                webView.getSettings().setBlockNetworkImage(false);
                BillingFragment.this.p3 = true;
                if (BillingFragment.this.L3 != null) {
                    BillingFragment.this.z.setVisibility(0);
                    BillingFragment.this.p0.setVisibility(8);
                    BillingFragment.this.z.loadUrl(BillingFragment.this.L3);
                    b.d.w.c.a.c(BillingFragment.f9784c, BillingFragment.this.L3);
                }
            }
            BillingFragment.this.z.setVisibility(0);
            BillingFragment.this.p0.setVisibility(8);
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            String str2 = BillingFragment.f9784c;
            b.d.w.c.a.c(str2, "onPageStarted:" + str);
            BillingFragment.this.I3 = System.currentTimeMillis();
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            super.onReceivedError(webView, webResourceRequest, webResourceError);
            if (Build.VERSION.SDK_INT >= 23) {
                String str = BillingFragment.f9784c;
                b.d.w.c.a.c(str, "onReceivedError:" + ((Object) webResourceError.getDescription()));
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c {
        public c() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public /* synthetic */ void b() {
            FragmentActivity activity = BillingFragment.this.getActivity();
            if (activity != null && !activity.isFinishing() && !activity.isDestroyed()) {
                activity.finish();
            }
        }

        @JavascriptInterface
        public void postMessage(String str) {
            if (str != null) {
                try {
                    String string = new JSONObject(str).getString("message");
                    if (string != null && "done".equals(string)) {
                        BillingFragment.this.getActivity().getWindow().getDecorView().postDelayed(new Runnable() { // from class: com.tplink.iot.view.tapocare.d
                            @Override // java.lang.Runnable
                            public final void run() {
                                BillingFragment.c.this.b();
                            }
                        }, 500L);
                    }
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d {
        public d() {
        }

        @JavascriptInterface
        public void postMessage() {
            BillingFragment.this.f9785d.l0();
        }
    }

    /* loaded from: classes2.dex */
    public class e {
        public e() {
        }

        @JavascriptInterface
        public void postMessage(String str) {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.setData(Uri.parse(str));
            if (BillingFragment.this.getActivity() != null && intent.resolveActivity(BillingFragment.this.getActivity().getPackageManager()) != null) {
                BillingFragment.this.startActivity(intent);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class f {
        public f() {
        }

        @JavascriptInterface
        public void postMessage(String str) {
            if (BillingFragment.this.K3) {
                String str2 = BillingFragment.f9784c;
                b.d.w.c.a.i(str2, "retry:" + BillingFragment.this.J3);
                if (BillingFragment.this.J3 == -300) {
                    BillingFragment.this.f9785d.m0().L0(io.reactivex.l0.a.c()).F0();
                } else if (BillingFragment.this.J3 == -200) {
                    BillingFragment.this.f9785d.n0().L0(io.reactivex.l0.a.c()).F0();
                } else if (BillingFragment.this.J3 == 100 && BillingFragment.this.getActivity() != null) {
                    BillingFragment.this.getActivity().finish();
                }
            } else {
                String str3 = BillingFragment.f9784c;
                b.d.w.c.a.i(str3, "purchase() is invoked by web with purchaseParamsJsonStr:" + str);
                BillingViewModel billingViewModel = BillingFragment.this.f9785d;
                FragmentActivity activity = BillingFragment.this.getActivity();
                Objects.requireNonNull(activity);
                billingViewModel.k(activity, str);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class g {
        public g() {
        }

        @JavascriptInterface
        public void postMessage(String str) {
            FirmwareSlideActivity.q1(BillingFragment.this.getActivity(), "web");
            BillingFragment.this.S0();
        }
    }

    private void R0() {
        this.f9785d.n().observe(this, new Observer() { // from class: com.tplink.iot.view.tapocare.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                BillingFragment.this.k1((Boolean) obj);
            }
        });
        this.f9785d.r().observe(this, new Observer() { // from class: com.tplink.iot.view.tapocare.h
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                BillingFragment.this.U0((List) obj);
            }
        });
        this.f9785d.p().observe(this, new Observer() { // from class: com.tplink.iot.view.tapocare.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                BillingFragment.this.T0((Integer) obj);
            }
        });
        this.f9785d.s().observe(this, new Observer() { // from class: com.tplink.iot.view.tapocare.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                BillingFragment.this.V0((List) obj);
            }
        });
        this.f9785d.u().observe(this, new Observer() { // from class: com.tplink.iot.view.tapocare.f
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                BillingFragment.this.X0((String) obj);
            }
        });
        this.f9785d.t().observe(this, new Observer() { // from class: com.tplink.iot.view.tapocare.g
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                BillingFragment.this.W0((Integer) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S0() {
        FragmentActivity activity = getActivity();
        if (activity instanceof BaseActivity) {
            ((BaseActivity) activity).finish();
            activity.overridePendingTransition(0, R.anim.translate_between_interface_bottom_out);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T0(Integer num) {
        String str = f9784c;
        StringBuilder sb = new StringBuilder();
        sb.append("handlePurchaseEvent:");
        sb.append(num == null ? "null" : num);
        b.d.w.c.a.c(str, sb.toString());
        if (num != null) {
            switch (num.intValue()) {
                case 1001:
                case PointerIconCompat.TYPE_CROSSHAIR /* 1007 */:
                    s0.p(getActivity(), getString(R.string.tapo_care_purchase_error));
                    break;
                case 1002:
                    s0.p(getActivity(), getString(R.string.tapo_care_purchase_not_support));
                    break;
                case 1003:
                    s0.p(getActivity(), getString(R.string.tapo_care_purchase_cancel));
                    break;
                case 1004:
                    s0.p(getActivity(), getString(R.string.tapo_care_plan_unavailable));
                    break;
                case 1005:
                    s0.p(getActivity(), getString(R.string.tapo_care_plan_purchased));
                    break;
                case PointerIconCompat.TYPE_CELL /* 1006 */:
                    s0.p(getActivity(), getString(R.string.tapo_care_plan_under_another_id));
                    break;
            }
            if (num.intValue() != 0) {
                w.D(num.toString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U0(List<Purchase> list) {
        if (list != null) {
            Iterator<Purchase> it = list.iterator();
            while (it.hasNext()) {
                String str = f9784c;
                b.d.w.c.a.c(str, "queryPurchase:" + it.next().toString());
            }
        }
        this.f9785d.j(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V0(List<Purchase> list) {
        if (list != null) {
            Iterator<Purchase> it = list.iterator();
            while (it.hasNext()) {
                String str = f9784c;
                b.d.w.c.a.c(str, "PurchaseUpdate:" + it.next().toString());
            }
        }
        this.f9785d.h(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W0(Integer num) {
        if (num != null) {
            this.J3 = num.intValue();
            this.K3 = true;
            int intValue = num.intValue();
            if (intValue == -300) {
                if (this.p3) {
                    this.z.loadUrl(String.format("javascript:appApi.inAppPurchaseEnd('%s','%s')", -1, ""));
                }
                b.d.w.c.a.c(f9784c, "SubscriptionState.ACKNOWLEDGEMENT_ERROR");
            } else if (intValue == -200) {
                if (this.p3) {
                    this.z.loadUrl(String.format("javascript:appApi.inAppPurchaseEnd('%s','%s')", -1, ""));
                }
                b.d.w.c.a.c(f9784c, "SubscriptionState.VERIFICATION_ERROR");
            } else if (intValue == 100) {
                if (this.p3) {
                    this.z.loadUrl(String.format("javascript:appApi.inAppPurchaseEnd('%s','%s')", 0, this.f9785d.o()));
                }
                b.d.w.c.a.c(f9784c, "SubscriptionState.VERIFICATION_SUCCESS");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X0(String str) {
        this.L3 = str;
        if (str != null && this.p3) {
            b.d.w.c.a.c(f9784c, str);
            this.z.loadUrl(str);
            this.z.setVisibility(0);
        }
    }

    private void Y0(View view) {
        this.f9786f = (Toolbar) view.findViewById(R.id.toolbar);
        View findViewById = view.findViewById(R.id.ll_dialog_title);
        int i = 8;
        this.f9786f.setVisibility(this.p2 ? 0 : 8);
        if (!this.p2) {
            i = 0;
        }
        findViewById.setVisibility(i);
        this.q = (TextView) view.findViewById(R.id.toolbar_title);
        this.x = (TextView) view.findViewById(R.id.tv_dialog_title);
        this.f9786f.setTitle("");
        view.findViewById(R.id.tv_dialog_menu).setOnClickListener(this);
        View findViewById2 = view.findViewById(R.id.iv_dialog_title);
        this.p1 = findViewById2;
        findViewById2.setOnClickListener(this);
        this.y = (ProgressBar) view.findViewById(R.id.pb_billing);
        WebView webView = (WebView) view.findViewById(R.id.wv_billing);
        this.z = webView;
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setDefaultTextEncodingName("UTF-8");
        settings.setBlockNetworkImage(true);
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 21) {
            settings.setMixedContentMode(2);
        }
        if (i2 >= 19) {
            WebView.setWebContentsDebuggingEnabled(true);
        }
        this.z.setWebChromeClient(new a());
        this.z.setWebViewClient(new b());
        this.z.addJavascriptInterface(new f(), FirebaseAnalytics.Event.PURCHASE);
        this.z.addJavascriptInterface(new c(), "backToApp");
        this.z.addJavascriptInterface(new g(), "upgradeHardware");
        this.z.addJavascriptInterface(new d(), "loadAppProductList");
        this.z.addJavascriptInterface(new e(), "openBrowser");
        this.p0 = view.findViewById(R.id.ll_network_error);
        view.findViewById(R.id.tv_retry).setOnClickListener(new View.OnClickListener() { // from class: com.tplink.iot.view.tapocare.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                BillingFragment.this.f1(view2);
            }
        });
        l1(10);
        this.z.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e1 */
    public /* synthetic */ void f1(View view) {
        j1();
    }

    public static BillingFragment h1(String str) {
        return i1(true, str);
    }

    public static BillingFragment i1(boolean z, String str) {
        BillingFragment billingFragment = new BillingFragment();
        Bundle bundle = new Bundle();
        bundle.putBoolean("full_screen", z);
        bundle.putString("url", str);
        billingFragment.setArguments(bundle);
        return billingFragment;
    }

    private void j1() {
        if (this.L3 == null) {
            this.f9785d.l0();
        } else {
            this.z.reload();
        }
        this.z.setVisibility(0);
        this.p0.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k1(Boolean bool) {
        if (bool == null) {
            return;
        }
        if (bool.booleanValue()) {
            s0.l(getActivity());
        } else {
            s0.g();
        }
    }

    private void l1(int i) {
        this.y.setVisibility(8);
    }

    @Override // com.tplink.iot.view.tapocare.k
    public boolean d() {
        WebView webView;
        if (this.K3 || this.z.getUrl().contains("tapolist") || (webView = this.z) == null || !webView.canGoBack()) {
            return false;
        }
        this.z.goBack();
        return true;
    }

    public void m1(String str) {
        if (str == null) {
            str = "";
        }
        if (this.p2) {
            this.q.setText(str);
        } else {
            this.x.setText(str);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id != R.id.iv_dialog_title) {
            if (id == R.id.tv_dialog_menu) {
                S0();
            }
        } else if (this.K3 || this.z.getUrl().contains("tapolist")) {
            S0();
        } else {
            d();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.p2 = arguments.getBoolean("full_screen", true);
            this.H3 = arguments.getString("url");
        }
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        FragmentActivity activity = getActivity();
        Objects.requireNonNull(activity);
        this.f9785d = (BillingViewModel) ViewModelProviders.of(activity).get(BillingViewModel.class);
        View inflate = layoutInflater.inflate(R.layout.fragment_billing, viewGroup, false);
        Y0(inflate);
        b.d.w.c.a.c(f9784c, this.H3);
        this.z.loadUrl(this.H3);
        R0();
        return inflate;
    }
}
