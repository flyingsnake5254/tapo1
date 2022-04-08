package androidx.core.util;

import android.util.LruCache;
import kotlin.jvm.b.l;
import kotlin.jvm.b.p;
import kotlin.jvm.b.r;
import kotlin.jvm.internal.j;

/* compiled from: LruCache.kt */
/* loaded from: classes.dex */
public final class LruCacheKt {
    public static final <K, V> LruCache<K, V> lruCache(int i, p<? super K, ? super V, Integer> sizeOf, l<? super K, ? extends V> create, r<? super Boolean, ? super K, ? super V, ? super V, kotlin.p> onEntryRemoved) {
        j.f(sizeOf, "sizeOf");
        j.f(create, "create");
        j.f(onEntryRemoved, "onEntryRemoved");
        return new LruCacheKt$lruCache$4(sizeOf, create, onEntryRemoved, i, i);
    }

    public static /* synthetic */ LruCache lruCache$default(int i, p sizeOf, l create, r onEntryRemoved, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            sizeOf = LruCacheKt$lruCache$1.INSTANCE;
        }
        if ((i2 & 4) != 0) {
            create = LruCacheKt$lruCache$2.INSTANCE;
        }
        if ((i2 & 8) != 0) {
            onEntryRemoved = LruCacheKt$lruCache$3.INSTANCE;
        }
        j.f(sizeOf, "sizeOf");
        j.f(create, "create");
        j.f(onEntryRemoved, "onEntryRemoved");
        return new LruCacheKt$lruCache$4(sizeOf, create, onEntryRemoved, i, i);
    }
}
