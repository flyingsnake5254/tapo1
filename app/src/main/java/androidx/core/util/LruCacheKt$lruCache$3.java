package androidx.core.util;

import kotlin.jvm.b.r;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import kotlin.p;

/* compiled from: LruCache.kt */
/* loaded from: classes.dex */
public final class LruCacheKt$lruCache$3 extends Lambda implements r<Boolean, K, V, V, p> {
    public static final LruCacheKt$lruCache$3 INSTANCE = new LruCacheKt$lruCache$3();

    public LruCacheKt$lruCache$3() {
        super(4);
    }

    @Override // kotlin.jvm.b.r
    public /* bridge */ /* synthetic */ p invoke(Boolean bool, Object obj, Object obj2, Object obj3) {
        invoke(bool.booleanValue(), (boolean) obj, obj2, obj3);
        return p.a;
    }

    public final void invoke(boolean z, K k, V v, V v2) {
        j.f(k, "<anonymous parameter 1>");
        j.f(v, "<anonymous parameter 2>");
    }
}
