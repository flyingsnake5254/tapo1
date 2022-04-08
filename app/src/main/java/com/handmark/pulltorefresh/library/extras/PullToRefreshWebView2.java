package com.handmark.pulltorefresh.library.extras;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.webkit.WebView;
import com.handmark.pulltorefresh.library.PullToRefreshWebView;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes2.dex */
public class PullToRefreshWebView2 extends PullToRefreshWebView {
    private a Z3;
    private final AtomicBoolean a4 = new AtomicBoolean(false);
    private final AtomicBoolean b4 = new AtomicBoolean(false);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public final class a {
        a() {
        }
    }

    public PullToRefreshWebView2(Context context) {
        super(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.handmark.pulltorefresh.library.PullToRefreshWebView
    @SuppressLint({"JavascriptInterface"})
    /* renamed from: K */
    public WebView h(Context context, AttributeSet attributeSet) {
        WebView K = super.h(context, attributeSet);
        a aVar = new a();
        this.Z3 = aVar;
        K.addJavascriptInterface(aVar, "ptr");
        return K;
    }

    @Override // com.handmark.pulltorefresh.library.PullToRefreshWebView, com.handmark.pulltorefresh.library.PullToRefreshBase
    protected boolean p() {
        getRefreshableView().loadUrl("javascript:isReadyForPullUp();");
        return this.b4.get();
    }

    @Override // com.handmark.pulltorefresh.library.PullToRefreshWebView, com.handmark.pulltorefresh.library.PullToRefreshBase
    protected boolean q() {
        getRefreshableView().loadUrl("javascript:isReadyForPullDown();");
        return this.a4.get();
    }

    public PullToRefreshWebView2(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
