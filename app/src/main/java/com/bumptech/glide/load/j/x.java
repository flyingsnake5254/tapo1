package com.bumptech.glide.load.j;

import android.net.Uri;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.f;
import com.bumptech.glide.load.j.n;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* compiled from: UrlUriLoader.java */
/* loaded from: classes.dex */
public class x<Data> implements n<Uri, Data> {
    private static final Set<String> a = Collections.unmodifiableSet(new HashSet(Arrays.asList("http", "https")));

    /* renamed from: b  reason: collision with root package name */
    private final n<g, Data> f1591b;

    /* compiled from: UrlUriLoader.java */
    /* loaded from: classes.dex */
    public static class a implements o<Uri, InputStream> {
        @Override // com.bumptech.glide.load.j.o
        public void a() {
        }

        @Override // com.bumptech.glide.load.j.o
        @NonNull
        public n<Uri, InputStream> c(r rVar) {
            return new x(rVar.d(g.class, InputStream.class));
        }
    }

    public x(n<g, Data> nVar) {
        this.f1591b = nVar;
    }

    /* renamed from: c */
    public n.a<Data> b(@NonNull Uri uri, int i, int i2, @NonNull f fVar) {
        return this.f1591b.b(new g(uri.toString()), i, i2, fVar);
    }

    /* renamed from: d */
    public boolean a(@NonNull Uri uri) {
        return a.contains(uri.getScheme());
    }
}
