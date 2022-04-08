package kotlinx.coroutines.flow.internal;

import kotlin.TypeCastException;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.b.p;
import kotlin.jvm.b.q;
import kotlin.jvm.internal.j;
import kotlin.k;
import kotlinx.coroutines.channels.r;
import kotlinx.coroutines.d0;
import kotlinx.coroutines.flow.b;
import kotlinx.coroutines.internal.t;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Combine.kt */
@d(c = "kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2", f = "Combine.kt", l = {146}, m = "invokeSuspend")
/* loaded from: classes4.dex */
public final class CombineKt$combineInternal$2 extends SuspendLambda implements p<d0, c<? super kotlin.p>, Object> {
    final /* synthetic */ q H3;

    /* renamed from: c  reason: collision with root package name */
    private d0 f16455c;

    /* renamed from: d  reason: collision with root package name */
    Object f16456d;

    /* renamed from: f  reason: collision with root package name */
    Object f16457f;
    int p0;
    final /* synthetic */ b p1;
    final /* synthetic */ kotlinx.coroutines.flow.a[] p2;
    final /* synthetic */ kotlin.jvm.b.a p3;
    Object q;
    Object x;
    Object y;
    int z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Combine.kt */
    /* loaded from: classes4.dex */
    public static final class a extends SuspendLambda implements p<Object, c<? super kotlin.p>, Object> {

        /* renamed from: c  reason: collision with root package name */
        private Object f16458c;

        /* renamed from: d  reason: collision with root package name */
        Object f16459d;

        /* renamed from: f  reason: collision with root package name */
        Object f16460f;
        final /* synthetic */ Boolean[] p0;
        final /* synthetic */ r[] p1;
        final /* synthetic */ Object[] p2;
        int q;
        final /* synthetic */ int x;
        final /* synthetic */ CombineKt$combineInternal$2 y;
        final /* synthetic */ int z;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(int i, c cVar, CombineKt$combineInternal$2 combineKt$combineInternal$2, int i2, Boolean[] boolArr, r[] rVarArr, Object[] objArr) {
            super(2, cVar);
            this.x = i;
            this.y = combineKt$combineInternal$2;
            this.z = i2;
            this.p0 = boolArr;
            this.p1 = rVarArr;
            this.p2 = objArr;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final c<kotlin.p> create(Object obj, c<?> completion) {
            j.f(completion, "completion");
            a aVar = new a(this.x, completion, this.y, this.z, this.p0, this.p1, this.p2);
            aVar.f16458c = obj;
            return aVar;
        }

        @Override // kotlin.jvm.b.p
        public final Object invoke(Object obj, c<? super kotlin.p> cVar) {
            return ((a) create(obj, cVar)).invokeSuspend(kotlin.p.a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object d2;
            boolean z;
            d2 = kotlin.coroutines.intrinsics.b.d();
            int i = this.q;
            if (i == 0) {
                k.b(obj);
                Object obj2 = this.f16458c;
                Object[] objArr = this.p2;
                objArr[this.x] = obj2;
                int length = objArr.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        z = true;
                        break;
                    }
                    if (!kotlin.coroutines.jvm.internal.a.a(objArr[i2] != null).booleanValue()) {
                        z = false;
                        break;
                    }
                    i2++;
                }
                if (z) {
                    Object[] objArr2 = (Object[]) this.y.p3.invoke();
                    int i3 = this.z;
                    for (int i4 = 0; i4 < i3; i4++) {
                        t tVar = d.a;
                        Object obj3 = this.p2[i4];
                        if (obj3 == tVar) {
                            obj3 = null;
                        }
                        objArr2[i4] = obj3;
                    }
                    CombineKt$combineInternal$2 combineKt$combineInternal$2 = this.y;
                    q qVar = combineKt$combineInternal$2.H3;
                    b bVar = combineKt$combineInternal$2.p1;
                    if (objArr2 != null) {
                        this.f16459d = obj2;
                        this.f16460f = objArr2;
                        this.q = 1;
                        if (qVar.invoke(bVar, objArr2, this) == d2) {
                            return d2;
                        }
                    } else {
                        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
                    }
                }
            } else if (i == 1) {
                Object[] objArr3 = (Object[]) this.f16460f;
                k.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return kotlin.p.a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CombineKt$combineInternal$2(b bVar, kotlinx.coroutines.flow.a[] aVarArr, kotlin.jvm.b.a aVar, q qVar, c cVar) {
        super(2, cVar);
        this.p1 = bVar;
        this.p2 = aVarArr;
        this.p3 = aVar;
        this.H3 = qVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final c<kotlin.p> create(Object obj, c<?> completion) {
        j.f(completion, "completion");
        CombineKt$combineInternal$2 combineKt$combineInternal$2 = new CombineKt$combineInternal$2(this.p1, this.p2, this.p3, this.H3, completion);
        combineKt$combineInternal$2.f16455c = (d0) obj;
        return combineKt$combineInternal$2;
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(d0 d0Var, c<? super kotlin.p> cVar) {
        return ((CombineKt$combineInternal$2) create(d0Var, cVar)).invokeSuspend(kotlin.p.a);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0123 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0091 A[SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:46:0x0124 -> B:47:0x012c). Please submit an issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r24) {
        /*
            Method dump skipped, instructions count: 307
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
