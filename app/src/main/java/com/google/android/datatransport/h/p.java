package com.google.android.datatransport.h;

import com.google.android.datatransport.b;
import com.google.android.datatransport.c;
import com.google.android.datatransport.d;
import com.google.android.datatransport.e;
import com.google.android.datatransport.g;

/* compiled from: TransportImpl.java */
/* loaded from: classes.dex */
final class p<T> implements e<T> {
    private final n a;

    /* renamed from: b  reason: collision with root package name */
    private final String f1882b;

    /* renamed from: c  reason: collision with root package name */
    private final b f1883c;

    /* renamed from: d  reason: collision with root package name */
    private final d<T, byte[]> f1884d;

    /* renamed from: e  reason: collision with root package name */
    private final q f1885e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(n nVar, String str, b bVar, d<T, byte[]> dVar, q qVar) {
        this.a = nVar;
        this.f1882b = str;
        this.f1883c = bVar;
        this.f1884d = dVar;
        this.f1885e = qVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void c(Exception exc) {
    }

    @Override // com.google.android.datatransport.e
    public void a(c<T> cVar, g gVar) {
        this.f1885e.a(m.a().e(this.a).c(cVar).f(this.f1882b).d(this.f1884d).b(this.f1883c).a(), gVar);
    }

    @Override // com.google.android.datatransport.e
    public void b(c<T> cVar) {
        a(cVar, a.a);
    }
}
