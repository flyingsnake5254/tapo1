package com.tplink.libtpnetwork.cameranetwork.h4.m4.b;

import androidx.annotation.NonNull;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;

/* compiled from: CookieJarWrapper.java */
/* loaded from: classes3.dex */
public class a implements CookieJar {
    private WeakReference<b> a;

    /* renamed from: b  reason: collision with root package name */
    private String f14789b;

    public a(@NonNull b bVar, @NonNull String str) {
        this.a = new WeakReference<>(bVar);
        this.f14789b = str;
    }

    @Override // okhttp3.CookieJar
    public List<Cookie> loadForRequest(@NonNull HttpUrl httpUrl) {
        b bVar = this.a.get();
        ArrayList arrayList = new ArrayList();
        if (bVar != null) {
            Map<String, String> c2 = bVar.c(this.f14789b);
            String b2 = bVar.b(this.f14789b);
            if (c2 != null) {
                for (Map.Entry<String, String> entry : c2.entrySet()) {
                    arrayList.add(new Cookie.Builder().name(entry.getKey()).value(entry.getValue()).domain(b2).build());
                }
            }
        }
        return arrayList;
    }

    @Override // okhttp3.CookieJar
    public void saveFromResponse(@NonNull HttpUrl httpUrl, @NonNull List<Cookie> list) {
        b bVar = this.a.get();
        if (bVar != null) {
            for (Cookie cookie : list) {
                bVar.a(this.f14789b, cookie.name(), cookie.value());
            }
        }
    }
}
