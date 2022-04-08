package kotlin.coroutines;

import java.io.Serializable;
import java.util.Objects;
import kotlin.coroutines.f;
import kotlin.jvm.b.p;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.jvm.internal.j;

/* compiled from: CoroutineContextImpl.kt */
/* loaded from: classes4.dex */
public final class CombinedContext implements f, Serializable {
    private final f.b element;
    private final f left;

    /* compiled from: CoroutineContextImpl.kt */
    /* loaded from: classes4.dex */
    private static final class a implements Serializable {

        /* renamed from: c  reason: collision with root package name */
        public static final C0319a f16324c = new C0319a(null);

        /* renamed from: d  reason: collision with root package name */
        private final f[] f16325d;

        /* compiled from: CoroutineContextImpl.kt */
        /* renamed from: kotlin.coroutines.CombinedContext$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public static final class C0319a {
            private C0319a() {
            }

            public /* synthetic */ C0319a(kotlin.jvm.internal.f fVar) {
                this();
            }
        }

        public a(f[] elements) {
            j.e(elements, "elements");
            this.f16325d = elements;
        }
    }

    /* compiled from: CoroutineContextImpl.kt */
    /* loaded from: classes4.dex */
    static final class b extends Lambda implements p<String, f.b, String> {

        /* renamed from: c  reason: collision with root package name */
        public static final b f16326c = new b();

        b() {
            super(2);
        }

        /* renamed from: a */
        public final String invoke(String acc, f.b element) {
            j.e(acc, "acc");
            j.e(element, "element");
            if (acc.length() == 0) {
                return element.toString();
            }
            return acc + ", " + element;
        }
    }

    /* compiled from: CoroutineContextImpl.kt */
    /* loaded from: classes4.dex */
    static final class c extends Lambda implements p<kotlin.p, f.b, kotlin.p> {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ f[] f16327c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Ref$IntRef f16328d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(f[] fVarArr, Ref$IntRef ref$IntRef) {
            super(2);
            this.f16327c = fVarArr;
            this.f16328d = ref$IntRef;
        }

        public final void a(kotlin.p pVar, f.b element) {
            j.e(pVar, "<anonymous parameter 0>");
            j.e(element, "element");
            f[] fVarArr = this.f16327c;
            Ref$IntRef ref$IntRef = this.f16328d;
            int i = ref$IntRef.element;
            ref$IntRef.element = i + 1;
            fVarArr[i] = element;
        }

        @Override // kotlin.jvm.b.p
        public /* bridge */ /* synthetic */ kotlin.p invoke(kotlin.p pVar, f.b bVar) {
            a(pVar, bVar);
            return kotlin.p.a;
        }
    }

    public CombinedContext(f left, f.b element) {
        j.e(left, "left");
        j.e(element, "element");
        this.left = left;
        this.element = element;
    }

    private final boolean contains(f.b bVar) {
        return j.a(get(bVar.getKey()), bVar);
    }

    private final boolean containsAll(CombinedContext combinedContext) {
        while (contains(combinedContext.element)) {
            f fVar = combinedContext.left;
            if (fVar instanceof CombinedContext) {
                combinedContext = (CombinedContext) fVar;
            } else {
                Objects.requireNonNull(fVar, "null cannot be cast to non-null type kotlin.coroutines.CoroutineContext.Element");
                return contains((f.b) fVar);
            }
        }
        return false;
    }

    private final int size() {
        int i = 2;
        CombinedContext combinedContext = this;
        while (true) {
            f fVar = combinedContext.left;
            if (!(fVar instanceof CombinedContext)) {
                fVar = null;
            }
            combinedContext = (CombinedContext) fVar;
            if (combinedContext == null) {
                return i;
            }
            i++;
        }
    }

    private final Object writeReplace() {
        int size = size();
        f[] fVarArr = new f[size];
        Ref$IntRef ref$IntRef = new Ref$IntRef();
        boolean z = false;
        ref$IntRef.element = 0;
        fold(kotlin.p.a, new c(fVarArr, ref$IntRef));
        if (ref$IntRef.element == size) {
            z = true;
        }
        if (z) {
            return new a(fVarArr);
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof CombinedContext) {
                CombinedContext combinedContext = (CombinedContext) obj;
                if (combinedContext.size() != size() || !combinedContext.containsAll(this)) {
                }
            }
            return false;
        }
        return true;
    }

    @Override // kotlin.coroutines.f
    public <R> R fold(R r, p<? super R, ? super f.b, ? extends R> operation) {
        j.e(operation, "operation");
        return (R) operation.invoke((Object) this.left.fold(r, operation), this.element);
    }

    @Override // kotlin.coroutines.f
    public <E extends f.b> E get(f.c<E> key) {
        j.e(key, "key");
        CombinedContext combinedContext = this;
        while (true) {
            E e2 = (E) combinedContext.element.get(key);
            if (e2 != null) {
                return e2;
            }
            f fVar = combinedContext.left;
            if (!(fVar instanceof CombinedContext)) {
                return (E) fVar.get(key);
            }
            combinedContext = (CombinedContext) fVar;
        }
    }

    public int hashCode() {
        return this.left.hashCode() + this.element.hashCode();
    }

    @Override // kotlin.coroutines.f
    public f minusKey(f.c<?> key) {
        j.e(key, "key");
        if (this.element.get(key) != null) {
            return this.left;
        }
        f minusKey = this.left.minusKey(key);
        return minusKey == this.left ? this : minusKey == EmptyCoroutineContext.INSTANCE ? this.element : new CombinedContext(minusKey, this.element);
    }

    @Override // kotlin.coroutines.f
    public f plus(f context) {
        j.e(context, "context");
        return f.a.a(this, context);
    }

    public String toString() {
        return "[" + ((String) fold("", b.f16326c)) + "]";
    }
}
