package com.handmark.pulltorefresh.library;

import android.webkit.WebView;
import com.handmark.pulltorefresh.library.PullToRefreshBase;

/* compiled from: lambda */
/* loaded from: classes2.dex */
public final /* synthetic */ class c implements PullToRefreshBase.e {
    public static final /* synthetic */ c a = new c();

    private /* synthetic */ c() {
    }

    @Override // com.handmark.pulltorefresh.library.PullToRefreshBase.e
    public final void a(PullToRefreshBase pullToRefreshBase) {
        ((WebView) pullToRefreshBase.getRefreshableView()).reload();
    }
}
