package kotlin.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.internal.j;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: _Maps.kt */
/* loaded from: classes4.dex */
public class f0 extends e0 {
    public static <K, V> List<Pair<K, V>> n(Map<? extends K, ? extends V> toList) {
        List<Pair<K, V>> b2;
        List<Pair<K, V>> d2;
        List<Pair<K, V>> d3;
        j.e(toList, "$this$toList");
        if (toList.size() == 0) {
            d3 = n.d();
            return d3;
        }
        Iterator<Map.Entry<? extends K, ? extends V>> it = toList.entrySet().iterator();
        if (!it.hasNext()) {
            d2 = n.d();
            return d2;
        }
        Map.Entry<? extends K, ? extends V> next = it.next();
        if (!it.hasNext()) {
            b2 = m.b(new Pair(next.getKey(), next.getValue()));
            return b2;
        }
        ArrayList arrayList = new ArrayList(toList.size());
        arrayList.add(new Pair(next.getKey(), next.getValue()));
        do {
            Map.Entry<? extends K, ? extends V> next2 = it.next();
            arrayList.add(new Pair(next2.getKey(), next2.getValue()));
        } while (it.hasNext());
        return arrayList;
    }
}
