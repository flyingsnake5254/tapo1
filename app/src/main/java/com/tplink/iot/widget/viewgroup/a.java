package com.tplink.iot.widget.viewgroup;

import com.tplink.iot.widget.viewgroup.AutoScrolledWebView;

/* loaded from: classes3.dex */
public final /* synthetic */ class a {
    public static final /* synthetic */ int[] a;

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ int[] f11897b;

    static {
        int[] iArr = new int[AutoScrolledWebView.AutoScrolledStrategy.values().length];
        a = iArr;
        AutoScrolledWebView.AutoScrolledStrategy autoScrolledStrategy = AutoScrolledWebView.AutoScrolledStrategy.NONE;
        iArr[autoScrolledStrategy.ordinal()] = 1;
        AutoScrolledWebView.AutoScrolledStrategy autoScrolledStrategy2 = AutoScrolledWebView.AutoScrolledStrategy.ALL;
        iArr[autoScrolledStrategy2.ordinal()] = 2;
        AutoScrolledWebView.AutoScrolledStrategy autoScrolledStrategy3 = AutoScrolledWebView.AutoScrolledStrategy.FIRST_ONLY;
        iArr[autoScrolledStrategy3.ordinal()] = 3;
        int[] iArr2 = new int[AutoScrolledWebView.AutoScrolledStrategy.values().length];
        f11897b = iArr2;
        iArr2[autoScrolledStrategy.ordinal()] = 1;
        iArr2[autoScrolledStrategy2.ordinal()] = 2;
        iArr2[autoScrolledStrategy3.ordinal()] = 3;
    }
}
