package com.handmark.pulltorefresh.library;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.util.AttributeSet;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.github.mikephil.charting.utils.Utils;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.tplink.libtpcontrols.s0;

/* loaded from: classes2.dex */
public class PullToRefreshWebView extends PullToRefreshBase<WebView> {
    private static final PullToRefreshBase.e<WebView> X3 = c.a;
    private final WebChromeClient Y3;

    /* loaded from: classes2.dex */
    class a extends WebChromeClient {
        a() {
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i) {
            if (i == 100) {
                PullToRefreshWebView.this.w();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @TargetApi(9)
    /* loaded from: classes2.dex */
    public final class b extends WebView {
        public b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        private int a() {
            return (int) Math.max((double) Utils.DOUBLE_EPSILON, Math.floor(((WebView) PullToRefreshWebView.this.H3).getContentHeight() * ((WebView) PullToRefreshWebView.this.H3).getScale()) - ((getHeight() - getPaddingBottom()) - getPaddingTop()));
        }

        @Override // android.view.View
        protected boolean overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
            boolean overScrollBy = super.overScrollBy(i, i2, i3, i4, i5, i6, i7, i8, z);
            f.b(PullToRefreshWebView.this, i, i3, i2, i4, a(), 2, 1.5f, z);
            return overScrollBy;
        }
    }

    public PullToRefreshWebView(Context context) {
        super(context);
        a aVar = new a();
        this.Y3 = aVar;
        setOnRefreshListener(X3);
        ((WebView) this.H3).setWebChromeClient(aVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: K */
    public WebView h(Context context, AttributeSet attributeSet) {
        WebView webView;
        if (Build.VERSION.SDK_INT >= 9) {
            webView = new b(context, attributeSet);
        } else {
            webView = new WebView(context, attributeSet);
        }
        webView.setId(s0.webview);
        return webView;
    }

    @Override // com.handmark.pulltorefresh.library.PullToRefreshBase
    public final PullToRefreshBase.Orientation getPullToRefreshScrollDirection() {
        return PullToRefreshBase.Orientation.VERTICAL;
    }

    @Override // com.handmark.pulltorefresh.library.PullToRefreshBase
    protected boolean p() {
        return ((float) ((WebView) this.H3).getScrollY()) >= ((float) Math.floor((double) (((float) ((WebView) this.H3).getContentHeight()) * ((WebView) this.H3).getScale()))) - ((float) ((WebView) this.H3).getHeight());
    }

    @Override // com.handmark.pulltorefresh.library.PullToRefreshBase
    protected boolean q() {
        return ((WebView) this.H3).getScrollY() == 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.handmark.pulltorefresh.library.PullToRefreshBase
    public void t(Bundle bundle) {
        super.t(bundle);
        ((WebView) this.H3).restoreState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.handmark.pulltorefresh.library.PullToRefreshBase
    public void u(Bundle bundle) {
        super.u(bundle);
        ((WebView) this.H3).saveState(bundle);
    }

    public PullToRefreshWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a aVar = new a();
        this.Y3 = aVar;
        setOnRefreshListener(X3);
        ((WebView) this.H3).setWebChromeClient(aVar);
    }
}
