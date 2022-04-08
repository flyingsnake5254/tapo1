package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.source.x;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.upstream.n;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.o0;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

/* compiled from: ParsingLoadable.java */
/* loaded from: classes.dex */
public final class y<T> implements Loader.e {
    public final long a;

    /* renamed from: b  reason: collision with root package name */
    public final n f3872b;

    /* renamed from: c  reason: collision with root package name */
    public final int f3873c;

    /* renamed from: d  reason: collision with root package name */
    private final z f3874d;

    /* renamed from: e  reason: collision with root package name */
    private final a<? extends T> f3875e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private volatile T f3876f;

    /* compiled from: ParsingLoadable.java */
    /* loaded from: classes.dex */
    public interface a<T> {
        T a(Uri uri, InputStream inputStream) throws IOException;
    }

    public y(l lVar, Uri uri, int i, a<? extends T> aVar) {
        this(lVar, new n.b().i(uri).b(1).a(), i, aVar);
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.e
    public final void a() throws IOException {
        this.f3874d.r();
        m mVar = new m(this.f3874d, this.f3872b);
        try {
            mVar.c();
            this.f3876f = (T) this.f3875e.a((Uri) g.e(this.f3874d.getUri()), mVar);
        } finally {
            o0.m(mVar);
        }
    }

    public long b() {
        return this.f3874d.o();
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.e
    public final void c() {
    }

    public Map<String, List<String>> d() {
        return this.f3874d.q();
    }

    @Nullable
    public final T e() {
        return this.f3876f;
    }

    public Uri f() {
        return this.f3874d.p();
    }

    public y(l lVar, n nVar, int i, a<? extends T> aVar) {
        this.f3874d = new z(lVar);
        this.f3872b = nVar;
        this.f3873c = i;
        this.f3875e = aVar;
        this.a = x.a();
    }
}
