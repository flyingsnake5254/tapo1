package kotlin.collections;

import kotlin.jvm.b.l;
import kotlin.jvm.internal.Lambda;

/* compiled from: Collections.kt */
/* loaded from: classes4.dex */
public final class CollectionsKt__CollectionsKt$binarySearchBy$1 extends Lambda implements l<T, Integer> {
    final /* synthetic */ Comparable $key;
    final /* synthetic */ l $selector;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CollectionsKt__CollectionsKt$binarySearchBy$1(l lVar, Comparable comparable) {
        super(1);
        this.$selector = lVar;
        this.$key = comparable;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.lang.Integer, int] */
    /* JADX WARN: Unknown variable types count: 1 */
    @Override // kotlin.jvm.b.l
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Integer invoke(T r2) {
        /*
            r1 = this;
            kotlin.jvm.b.l r0 = r1.$selector
            java.lang.Object r2 = r0.invoke(r2)
            java.lang.Comparable r2 = (java.lang.Comparable) r2
            java.lang.Comparable r0 = r1.$key
            int r2 = kotlin.q.a.a(r2, r0)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.collections.CollectionsKt__CollectionsKt$binarySearchBy$1.invoke(java.lang.Object):int");
    }
}
