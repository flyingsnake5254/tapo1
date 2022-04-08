package kotlin.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.j;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Iterables.kt */
/* loaded from: classes4.dex */
public class o extends n {
    public static <T> int l(Iterable<? extends T> collectionSizeOrDefault, int i) {
        j.e(collectionSizeOrDefault, "$this$collectionSizeOrDefault");
        return collectionSizeOrDefault instanceof Collection ? ((Collection) collectionSizeOrDefault).size() : i;
    }

    public static <T> List<T> m(Iterable<? extends Iterable<? extends T>> flatten) {
        j.e(flatten, "$this$flatten");
        ArrayList arrayList = new ArrayList();
        Iterator<? extends Iterable<? extends T>> it = flatten.iterator();
        while (it.hasNext()) {
            l.p(arrayList, (Iterable) it.next());
        }
        return arrayList;
    }
}
