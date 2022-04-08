package com.google.android.datatransport.h;

import android.content.Context;
import androidx.annotation.RestrictTo;
import com.google.android.datatransport.b;
import com.google.android.datatransport.f;
import com.google.android.datatransport.g;
import com.google.android.datatransport.h.x.e;
import com.google.android.datatransport.h.y.a;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.q;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.s;
import java.util.Collections;
import java.util.Set;

/* compiled from: TransportRuntime.java */
/* loaded from: classes.dex */
public class r implements q {
    private static volatile s a;

    /* renamed from: b  reason: collision with root package name */
    private final a f1886b;

    /* renamed from: c  reason: collision with root package name */
    private final a f1887c;

    /* renamed from: d  reason: collision with root package name */
    private final e f1888d;

    /* renamed from: e  reason: collision with root package name */
    private final q f1889e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(a aVar, a aVar2, e eVar, q qVar, s sVar) {
        this.f1886b = aVar;
        this.f1887c = aVar2;
        this.f1888d = eVar;
        this.f1889e = qVar;
        sVar.a();
    }

    private i b(m mVar) {
        return i.a().i(this.f1886b.a()).k(this.f1887c.a()).j(mVar.g()).h(new h(mVar.b(), mVar.d())).g(mVar.c().a()).d();
    }

    public static r c() {
        s sVar = a;
        if (sVar != null) {
            return sVar.c();
        }
        throw new IllegalStateException("Not initialized!");
    }

    private static Set<b> d(f fVar) {
        if (fVar instanceof g) {
            return Collections.unmodifiableSet(((g) fVar).a());
        }
        return Collections.singleton(b.b("proto"));
    }

    public static void f(Context context) {
        if (a == null) {
            synchronized (r.class) {
                if (a == null) {
                    a = e.e().a(context).build();
                }
            }
        }
    }

    @Override // com.google.android.datatransport.h.q
    public void a(m mVar, g gVar) {
        this.f1888d.a(mVar.f().e(mVar.c().c()), b(mVar), gVar);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public q e() {
        return this.f1889e;
    }

    public f g(f fVar) {
        return new o(d(fVar), n.a().b(fVar.getName()).c(fVar.getExtras()).a(), this);
    }
}
