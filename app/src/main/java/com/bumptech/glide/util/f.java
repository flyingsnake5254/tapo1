package com.bumptech.glide.util;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: LruCache.java */
/* loaded from: classes.dex */
public class f<T, Y> {
    private final Map<T, a<Y>> a = new LinkedHashMap(100, 0.75f, true);

    /* renamed from: b  reason: collision with root package name */
    private final long f1771b;

    /* renamed from: c  reason: collision with root package name */
    private long f1772c;

    /* renamed from: d  reason: collision with root package name */
    private long f1773d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LruCache.java */
    /* loaded from: classes.dex */
    public static final class a<Y> {
        final Y a;

        /* renamed from: b  reason: collision with root package name */
        final int f1774b;

        a(Y y, int i) {
            this.a = y;
            this.f1774b = i;
        }
    }

    public f(long j) {
        this.f1771b = j;
        this.f1772c = j;
    }

    private void f() {
        m(this.f1772c);
    }

    public void b() {
        m(0L);
    }

    @Nullable
    public synchronized Y g(@NonNull T t) {
        a<Y> aVar;
        aVar = this.a.get(t);
        return aVar != null ? aVar.a : null;
    }

    public synchronized long h() {
        return this.f1772c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int i(@Nullable Y y) {
        return 1;
    }

    protected void j(@NonNull T t, @Nullable Y y) {
    }

    @Nullable
    public synchronized Y k(@NonNull T t, @Nullable Y y) {
        int i = i(y);
        long j = i;
        Y y2 = null;
        if (j >= this.f1772c) {
            j(t, y);
            return null;
        }
        if (y != null) {
            this.f1773d += j;
        }
        a<Y> put = this.a.put(t, y == null ? null : new a<>(y, i));
        if (put != null) {
            this.f1773d -= put.f1774b;
            if (!put.a.equals(y)) {
                j(t, put.a);
            }
        }
        f();
        if (put != null) {
            y2 = put.a;
        }
        return y2;
    }

    @Nullable
    public synchronized Y l(@NonNull T t) {
        a<Y> remove = this.a.remove(t);
        if (remove == null) {
            return null;
        }
        this.f1773d -= remove.f1774b;
        return remove.a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized void m(long j) {
        while (this.f1773d > j) {
            Iterator<Map.Entry<T, a<Y>>> it = this.a.entrySet().iterator();
            Map.Entry<T, a<Y>> next = it.next();
            a<Y> value = next.getValue();
            this.f1773d -= value.f1774b;
            T key = next.getKey();
            it.remove();
            j(key, value.a);
        }
    }
}
