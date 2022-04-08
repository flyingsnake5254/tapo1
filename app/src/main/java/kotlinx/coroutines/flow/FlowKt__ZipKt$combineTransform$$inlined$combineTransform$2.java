package kotlinx.coroutines.flow;

import kotlin.coroutines.c;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.b.a;
import kotlin.jvm.b.p;
import kotlin.jvm.b.q;
import kotlin.jvm.b.t;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.j;
import kotlin.k;
import kotlinx.coroutines.flow.internal.CombineKt;

/* compiled from: Zip.kt */
@d(c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransform$$inlined$combineTransform$2", f = "Zip.kt", l = {260}, m = "invokeSuspend")
/* loaded from: classes4.dex */
public final class FlowKt__ZipKt$combineTransform$$inlined$combineTransform$2 extends SuspendLambda implements p<b<? super R>, c<? super kotlin.p>, Object> {
    final /* synthetic */ a[] $flows;
    final /* synthetic */ t $transform$inlined;
    Object L$0;
    int label;
    private b p$;

    /* compiled from: Zip.kt */
    /* renamed from: kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransform$$inlined$combineTransform$2$1  reason: invalid class name */
    /* loaded from: classes4.dex */
    public static final class AnonymousClass1 extends Lambda implements a<Object[]> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.b.a
        public final Object[] invoke() {
            return new Object[FlowKt__ZipKt$combineTransform$$inlined$combineTransform$2.this.$flows.length];
        }
    }

    /* compiled from: Zip.kt */
    @d(c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransform$$inlined$combineTransform$2$2", f = "Zip.kt", l = {}, m = "invokeSuspend")
    /* renamed from: kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransform$$inlined$combineTransform$2$2  reason: invalid class name */
    /* loaded from: classes4.dex */
    public static final class AnonymousClass2 extends SuspendLambda implements q<b<? super R>, Object[], c<? super kotlin.p>, Object> {
        Object L$0;
        Object L$1;
        int label;
        private b p$;
        private Object[] p$0;

        public AnonymousClass2(c cVar) {
            super(3, cVar);
        }

        public final c<kotlin.p> create(b<? super R> create, Object[] it, c<? super kotlin.p> continuation) {
            j.f(create, "$this$create");
            j.f(it, "it");
            j.f(continuation, "continuation");
            AnonymousClass2 r0 = new AnonymousClass2(continuation);
            r0.p$ = create;
            r0.p$0 = it;
            return r0;
        }

        @Override // kotlin.jvm.b.q
        public final Object invoke(Object obj, Object[] objArr, c<? super kotlin.p> cVar) {
            return ((AnonymousClass2) create((b) obj, objArr, cVar)).invokeSuspend(kotlin.p.a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            b.d();
            if (this.label == 0) {
                k.b(obj);
                b bVar = this.p$;
                Object[] objArr = this.p$0;
                FlowKt__ZipKt$combineTransform$$inlined$combineTransform$2.this.$transform$inlined.invoke(bVar, objArr[0], objArr[1], objArr[2], objArr[3], this);
                return kotlin.p.a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invokeSuspend$$forInline(Object obj) {
            b bVar = this.p$;
            Object[] objArr = this.p$0;
            FlowKt__ZipKt$combineTransform$$inlined$combineTransform$2.this.$transform$inlined.invoke(bVar, objArr[0], objArr[1], objArr[2], objArr[3], this);
            return kotlin.p.a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowKt__ZipKt$combineTransform$$inlined$combineTransform$2(a[] aVarArr, c cVar, t tVar) {
        super(2, cVar);
        this.$flows = aVarArr;
        this.$transform$inlined = tVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final c<kotlin.p> create(Object obj, c<?> completion) {
        j.f(completion, "completion");
        FlowKt__ZipKt$combineTransform$$inlined$combineTransform$2 flowKt__ZipKt$combineTransform$$inlined$combineTransform$2 = new FlowKt__ZipKt$combineTransform$$inlined$combineTransform$2(this.$flows, completion, this.$transform$inlined);
        flowKt__ZipKt$combineTransform$$inlined$combineTransform$2.p$ = (b) obj;
        return flowKt__ZipKt$combineTransform$$inlined$combineTransform$2;
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(Object obj, c<? super kotlin.p> cVar) {
        return ((FlowKt__ZipKt$combineTransform$$inlined$combineTransform$2) create(obj, cVar)).invokeSuspend(kotlin.p.a);
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
        AnonymousClass1 r1 = new AnonymousClass1();
        AnonymousClass2 r2 = new AnonymousClass2(null);
        i.c(0);
        CombineKt.c(bVar, aVarArr, r1, r2, this);
        i.c(2);
        i.c(1);
        return kotlin.p.a;
    }
}
