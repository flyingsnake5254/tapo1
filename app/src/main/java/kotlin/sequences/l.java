package kotlin.sequences;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.n;
import kotlin.jvm.internal.j;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: _Sequences.kt */
/* loaded from: classes4.dex */
public class l extends k {

    /* compiled from: Iterables.kt */
    /* loaded from: classes4.dex */
    public static final class a implements Iterable<T>, kotlin.jvm.internal.r.a {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ f f16371c;

        public a(f fVar) {
            this.f16371c = fVar;
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            return this.f16371c.iterator();
        }
    }

    public static <T> Iterable<T> d(f<? extends T> asIterable) {
        j.e(asIterable, "$this$asIterable");
        return new a(asIterable);
    }

    public static <T, K> f<T> e(f<? extends T> distinctBy, kotlin.jvm.b.l<? super T, ? extends K> selector) {
        j.e(distinctBy, "$this$distinctBy");
        j.e(selector, "selector");
        return new c(distinctBy, selector);
    }

    public static <T> f<T> f(f<? extends T> filterNot, kotlin.jvm.b.l<? super T, Boolean> predicate) {
        j.e(filterNot, "$this$filterNot");
        j.e(predicate, "predicate");
        return new d(filterNot, false, predicate);
    }

    public static <T, R> f<R> g(f<? extends T> map, kotlin.jvm.b.l<? super T, ? extends R> transform) {
        j.e(map, "$this$map");
        j.e(transform, "transform");
        return new m(map, transform);
    }

    public static final <T, C extends Collection<? super T>> C h(f<? extends T> toCollection, C destination) {
        j.e(toCollection, "$this$toCollection");
        j.e(destination, "destination");
        Iterator<? extends T> it = toCollection.iterator();
        while (it.hasNext()) {
            destination.add(it.next());
        }
        return destination;
    }

    public static <T> List<T> i(f<? extends T> toList) {
        List<T> i;
        j.e(toList, "$this$toList");
        i = n.i(j(toList));
        return i;
    }

    public static final <T> List<T> j(f<? extends T> toMutableList) {
        j.e(toMutableList, "$this$toMutableList");
        return (List) h(toMutableList, new ArrayList());
    }
}
