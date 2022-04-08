package androidx.collection;

import kotlin.jvm.b.l;
import kotlin.jvm.b.p;
import kotlin.jvm.b.r;
import kotlin.jvm.internal.j;

/* compiled from: LruCache.kt */
/* loaded from: classes.dex */
public final class LruCacheKt$lruCache$4 extends LruCache<K, V> {
    final /* synthetic */ l $create;
    final /* synthetic */ int $maxSize;
    final /* synthetic */ r $onEntryRemoved;
    final /* synthetic */ p $sizeOf;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LruCacheKt$lruCache$4(p pVar, l lVar, r rVar, int i, int i2) {
        super(i2);
        this.$sizeOf = pVar;
        this.$create = lVar;
        this.$onEntryRemoved = rVar;
        this.$maxSize = i;
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [V, java.lang.Object] */
    @Override // androidx.collection.LruCache
    protected V create(K key) {
        j.f(key, "key");
        return this.$create.invoke(key);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.collection.LruCache
    public void entryRemoved(boolean z, K key, V oldValue, V v) {
        j.f(key, "key");
        j.f(oldValue, "oldValue");
        this.$onEntryRemoved.invoke(Boolean.valueOf(z), key, oldValue, v);
    }

    @Override // androidx.collection.LruCache
    protected int sizeOf(K key, V value) {
        j.f(key, "key");
        j.f(value, "value");
        return ((Number) this.$sizeOf.invoke(key, value)).intValue();
    }
}
