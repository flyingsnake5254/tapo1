package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.c;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Jobs.java */
/* loaded from: classes.dex */
final class r {
    private final Map<c, l<?>> a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private final Map<c, l<?>> f1495b = new HashMap();

    private Map<c, l<?>> b(boolean z) {
        return z ? this.f1495b : this.a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public l<?> a(c cVar, boolean z) {
        return b(z).get(cVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(c cVar, l<?> lVar) {
        b(lVar.p()).put(cVar, lVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(c cVar, l<?> lVar) {
        Map<c, l<?>> b2 = b(lVar.p());
        if (lVar.equals(b2.get(cVar))) {
            b2.remove(cVar);
        }
    }
}
