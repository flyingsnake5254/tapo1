package kotlin.collections;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import kotlin.jvm.internal.j;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CollectionsJVM.kt */
/* loaded from: classes4.dex */
public class m {
    public static final <T> Object[] a(T[] copyToArrayOfAny, boolean z) {
        j.e(copyToArrayOfAny, "$this$copyToArrayOfAny");
        if (z && j.a(copyToArrayOfAny.getClass(), Object[].class)) {
            return copyToArrayOfAny;
        }
        Object[] copyOf = Arrays.copyOf(copyToArrayOfAny, copyToArrayOfAny.length, Object[].class);
        j.d(copyOf, "java.util.Arrays.copyOf(… Array<Any?>::class.java)");
        return copyOf;
    }

    public static <T> List<T> b(T t) {
        List<T> singletonList = Collections.singletonList(t);
        j.d(singletonList, "java.util.Collections.singletonList(element)");
        return singletonList;
    }
}
