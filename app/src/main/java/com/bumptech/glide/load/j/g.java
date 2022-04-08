package com.bumptech.glide.load.j;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.c;
import com.bumptech.glide.util.i;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.util.Map;

/* compiled from: GlideUrl.java */
/* loaded from: classes.dex */
public class g implements c {

    /* renamed from: b  reason: collision with root package name */
    private final h f1555b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private final URL f1556c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private final String f1557d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private String f1558e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private URL f1559f;
    @Nullable
    private volatile byte[] g;
    private int h;

    public g(URL url) {
        this(url, h.f1560b);
    }

    private byte[] d() {
        if (this.g == null) {
            this.g = c().getBytes(c.a);
        }
        return this.g;
    }

    private String f() {
        if (TextUtils.isEmpty(this.f1558e)) {
            String str = this.f1557d;
            if (TextUtils.isEmpty(str)) {
                str = ((URL) i.d(this.f1556c)).toString();
            }
            this.f1558e = Uri.encode(str, "@#&=*+-_.,:!?()/~'%;$");
        }
        return this.f1558e;
    }

    private URL g() throws MalformedURLException {
        if (this.f1559f == null) {
            this.f1559f = new URL(f());
        }
        return this.f1559f;
    }

    @Override // com.bumptech.glide.load.c
    public void b(@NonNull MessageDigest messageDigest) {
        messageDigest.update(d());
    }

    public String c() {
        String str = this.f1557d;
        return str != null ? str : ((URL) i.d(this.f1556c)).toString();
    }

    public Map<String, String> e() {
        return this.f1555b.a();
    }

    @Override // com.bumptech.glide.load.c
    public boolean equals(Object obj) {
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return c().equals(gVar.c()) && this.f1555b.equals(gVar.f1555b);
    }

    public URL h() throws MalformedURLException {
        return g();
    }

    @Override // com.bumptech.glide.load.c
    public int hashCode() {
        if (this.h == 0) {
            int hashCode = c().hashCode();
            this.h = hashCode;
            this.h = (hashCode * 31) + this.f1555b.hashCode();
        }
        return this.h;
    }

    public String toString() {
        return c();
    }

    public g(String str) {
        this(str, h.f1560b);
    }

    public g(URL url, h hVar) {
        this.f1556c = (URL) i.d(url);
        this.f1557d = null;
        this.f1555b = (h) i.d(hVar);
    }

    public g(String str, h hVar) {
        this.f1556c = null;
        this.f1557d = i.b(str);
        this.f1555b = (h) i.d(hVar);
    }
}
