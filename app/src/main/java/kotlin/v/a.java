package kotlin.v;

import java.lang.Comparable;
import kotlin.jvm.internal.j;

/* compiled from: Range.kt */
/* loaded from: classes4.dex */
public interface a<T extends Comparable<? super T>> {

    /* compiled from: Range.kt */
    /* renamed from: kotlin.v.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static final class C0324a {
        public static <T extends Comparable<? super T>> boolean a(a<T> aVar, T value) {
            j.e(value, "value");
            return value.compareTo(aVar.getStart()) >= 0 && value.compareTo(aVar.getEndInclusive()) <= 0;
        }

        public static <T extends Comparable<? super T>> boolean b(a<T> aVar) {
            return aVar.getStart().compareTo(aVar.getEndInclusive()) > 0;
        }
    }

    T getEndInclusive();

    T getStart();
}
