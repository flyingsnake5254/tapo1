package com.tplink.libtpgoogleassistant.repository;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class b implements HostnameVerifier {
    public static final /* synthetic */ b a = new b();

    private /* synthetic */ b() {
    }

    @Override // javax.net.ssl.HostnameVerifier
    public final boolean verify(String str, SSLSession sSLSession) {
        return OAuthCloudRepository.h(str, sSLSession);
    }
}
