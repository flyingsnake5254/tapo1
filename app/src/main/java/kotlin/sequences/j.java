package kotlin.sequences;

import java.util.Iterator;
import kotlin.jvm.b.l;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Sequences.kt */
/* loaded from: classes4.dex */
public class j extends i {

    /* compiled from: Sequences.kt */
    /* loaded from: classes4.dex */
    public static final class a implements f<T> {
        final /* synthetic */ Iterator a;

        public a(Iterator it) {
            this.a = it;
        }

        @Override // kotlin.sequences.f
        public Iterator<T> iterator() {
            return this.a;
        }
    }

    public static <T> f<T> a(Iterator<? extends T> asSequence) {
        kotlin.jvm.internal.j.e(asSequence, "$this$asSequence");
        return b(new a(asSequence));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> f<T> b(f<? extends T> constrainOnce) {
        kotlin.jvm.internal.j.e(constrainOnce, "$this$constrainOnce");
        return constrainOnce instanceof a ? constrainOnce : new a(constrainOnce);
    }

    public static <T> f<T> c(kotlin.jvm.b.a<? extends T> seedFunction, l<? super T, ? extends T> nextFunction) {
        kotlin.jvm.internal.j.e(seedFunction, "seedFunction");
        kotlin.jvm.internal.j.e(nextFunction, "nextFunction");
        return new e(seedFunction, nextFunction);
    }
}
