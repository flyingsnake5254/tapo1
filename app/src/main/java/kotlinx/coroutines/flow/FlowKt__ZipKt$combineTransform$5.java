package kotlinx.coroutines.flow;

import kotlin.coroutines.c;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.b.a;
import kotlin.jvm.b.p;
import kotlin.jvm.b.q;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.j;
import kotlin.k;
import kotlinx.coroutines.flow.internal.CombineKt;

/* compiled from: Zip.kt */
@d(c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransform$5", f = "Zip.kt", l = {260}, m = "invokeSuspend")
/* loaded from: classes4.dex */
public final class FlowKt__ZipKt$combineTransform$5 extends SuspendLambda implements p<b<? super R>, c<? super kotlin.p>, Object> {
    final /* synthetic */ a[] $flows;
    final /* synthetic */ q $transform;
    Object L$0;
    int label;
    private b p$;

    /* compiled from: Zip.kt */
    /* renamed from: kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransform$5$1  reason: invalid class name */
    /* loaded from: classes4.dex */
    public static final class AnonymousClass1 extends Lambda implements a<T[]> {
        public AnonymousClass1() {
            super(0);
        }

        /* JADX WARN: Type inference failed for: r0v3, types: [T[], java.lang.Object[]] */
        @Override // kotlin.jvm.b.a
        public final T[] invoke() {
            int length = FlowKt__ZipKt$combineTransform$5.this.$flows.length;
            j.j(0, "T?");
            return new Object[length];
        }
    }

    /* compiled from: Zip.kt */
    @d(c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransform$5$2", f = "Zip.kt", l = {260}, m = "invokeSuspend")
    /* renamed from: kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransform$5$2  reason: invalid class name */
    /* loaded from: classes4.dex */
    public static final class AnonymousClass2 extends SuspendLambda implements q<b<? super R>, T[], c<? super kotlin.p>, Object> {
        Object L$0;
        Object L$1;
        int label;
        private b p$;
        private Object[] p$0;

        public AnonymousClass2(c cVar) {
            super(3, cVar);
        }

        public final c<kotlin.p> create(b<? super R> create, T[] it, c<? super kotlin.p> continuation) {
            j.f(create, "$this$create");
            j.f(it, "it");
            j.f(continuation, "continuation");
            AnonymousClass2 r0 = new AnonymousClass2(continuation);
            r0.p$ = create;
            r0.p$0 = it;
            return r0;
        }

        @Override // kotlin.jvm.b.q
        public final Object invoke(Object obj, Object obj2, c<? super kotlin.p> cVar) {
            return ((AnonymousClass2) create((b) obj, (Object[]) obj2, cVar)).invokeSuspend(kotlin.p.a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object d2;
            d2 = b.d();
            int i = this.label;
            if (i == 0) {
                k.b(obj);
                b bVar = this.p$;
                Object[] objArr = this.p$0;
                q qVar = FlowKt__ZipKt$combineTransform$5.this.$transform;
                this.L$0 = bVar;
                this.L$1 = objArr;
                this.label = 1;
                if (qVar.invoke(bVar, objArr, this) == d2) {
                    return d2;
                }
            } else if (i == 1) {
                Object[] objArr2 = (Object[]) this.L$1;
                b bVar2 = (b) this.L$0;
                k.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return kotlin.p.a;
        }

        public final Object invokeSuspend$$forInline(Object obj) {
            FlowKt__ZipKt$combineTransform$5.this.$transform.invoke(this.p$, this.p$0, this);
            return kotlin.p.a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowKt__ZipKt$combineTransform$5(a[] aVarArr, q qVar, c cVar) {
        super(2, cVar);
        this.$flows = aVarArr;
        this.$transform = qVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final c<kotlin.p> create(Object obj, c<?> completion) {
        j.f(completion, "completion");
        FlowKt__ZipKt$combineTransform$5 flowKt__ZipKt$combineTransform$5 = new FlowKt__ZipKt$combineTransform$5(this.$flows, this.$transform, completion);
        flowKt__ZipKt$combineTransform$5.p$ = (b) obj;
        return flowKt__ZipKt$combineTransform$5;
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(Object obj, c<? super kotlin.p> cVar) {
        return ((FlowKt__ZipKt$combineTransform$5) create(obj, cVar)).invokeSuspend(kotlin.p.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object d2;
        d2 = b.d();
        int i = this.label;
        if (i == 0) {
            k.b(obj);
            b bVar = this.p$;
            a[] aVarArr = this.$flows;
            j.i();
            AnonymousClass1 r3 = new AnonymousClass1();
            AnonymousClass2 r4 = new AnonymousClass2(null);
            this.L$0 = bVar;
            this.label = 1;
            if (CombineKt.c(bVar, aVarArr, r3, r4, this) == d2) {
                return d2;
            }
        } else if (i == 1) {
            b bVar2 = (b) this.L$0;
            k.b(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return kotlin.p.a;
    }

    public final Object invokeSuspend$$forInline(Object obj) {
        b bVar = this.p$;
        a[] aVarArr = this.$flows;
        j.i();
        AnonymousClass1 r1 = new AnonymousClass1();
        AnonymousClass2 r2 = new AnonymousClass2(null);
        i.c(0);
        CombineKt.c(bVar, aVarArr, r1, r2, this);
        i.c(2);
        i.c(1);
        return kotlin.p.a;
    }
}
