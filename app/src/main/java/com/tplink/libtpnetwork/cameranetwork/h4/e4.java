package com.tplink.libtpnetwork.cameranetwork.h4;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class e4 implements HostnameVerifier {
    public static final /* synthetic */ e4 a = new e4();

    private /* synthetic */ e4() {
    }

    @Override // javax.net.ssl.HostnameVerifier
    public final boolean verify(String str, SSLSession sSLSession) {
        return k4.c(str, sSLSession);
    }
}
