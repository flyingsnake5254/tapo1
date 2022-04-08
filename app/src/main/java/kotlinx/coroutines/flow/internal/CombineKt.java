package kotlinx.coroutines.flow.internal;

import kotlin.TypeCastException;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.b.p;
import kotlin.jvm.b.q;
import kotlin.jvm.internal.j;
import kotlin.k;
import kotlinx.coroutines.channels.g;
import kotlinx.coroutines.channels.n;
import kotlinx.coroutines.channels.r;
import kotlinx.coroutines.channels.v;
import kotlinx.coroutines.d0;
import kotlinx.coroutines.e0;
import kotlinx.coroutines.flow.b;

/* compiled from: Combine.kt */
/* loaded from: classes4.dex */
public final class CombineKt {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Combine.kt */
    @d(c = "kotlinx.coroutines.flow.internal.CombineKt$asFairChannel$1", f = "Combine.kt", l = {144}, m = "invokeSuspend")
    /* loaded from: classes4.dex */
    public static final class a extends SuspendLambda implements p<kotlinx.coroutines.channels.p<? super Object>, c<? super kotlin.p>, Object> {

        /* renamed from: c  reason: collision with root package name */
        private kotlinx.coroutines.channels.p f16452c;

        /* renamed from: d  reason: collision with root package name */
        Object f16453d;

        /* renamed from: f  reason: collision with root package name */
        Object f16454f;
        Object q;
        int x;
        final /* synthetic */ kotlinx.coroutines.flow.a y;

        /* compiled from: Collect.kt */
        /* renamed from: kotlinx.coroutines.flow.internal.CombineKt$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public static final class C0326a implements b<Object> {
            final /* synthetic */ g a;

            public C0326a(g gVar) {
                this.a = gVar;
            }

            @Override // kotlinx.coroutines.flow.b
            public Object a(Object obj, c cVar) {
                g gVar = this.a;
                if (obj == null) {
                    obj = d.a;
                }
                return gVar.y0(obj, cVar);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(kotlinx.coroutines.flow.a aVar, c cVar) {
            super(2, cVar);
            this.y = aVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final c<kotlin.p> create(Object obj, c<?> completion) {
            j.f(completion, "completion");
            a aVar = new a(this.y, completion);
            aVar.f16452c = (kotlinx.coroutines.channels.p) obj;
            return aVar;
        }

        @Override // kotlin.jvm.b.p
        public final Object invoke(kotlinx.coroutines.channels.p<? super Object> pVar, c<? super kotlin.p> cVar) {
            return ((a) create(pVar, cVar)).invokeSuspend(kotlin.p.a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object d2;
            d2 = kotlin.coroutines.intrinsics.b.d();
            int i = this.x;
            if (i == 0) {
                k.b(obj);
                kotlinx.coroutines.channels.p pVar = this.f16452c;
                v c2 = pVar.c();
                if (c2 != null) {
                    g gVar = (g) c2;
                    kotlinx.coroutines.flow.a aVar = this.y;
                    C0326a aVar2 = new C0326a(gVar);
                    this.f16453d = pVar;
                    this.f16454f = gVar;
                    this.q = aVar;
                    this.x = 1;
                    if (aVar.a(aVar2, this) == d2) {
                        return d2;
                    }
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.channels.ChannelCoroutine<kotlin.Any>");
                }
            } else if (i == 1) {
                kotlinx.coroutines.flow.a aVar3 = (kotlinx.coroutines.flow.a) this.q;
                g gVar2 = (g) this.f16454f;
                kotlinx.coroutines.channels.p pVar2 = (kotlinx.coroutines.channels.p) this.f16453d;
                k.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return kotlin.p.a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r<Object> b(d0 d0Var, kotlinx.coroutines.flow.a<?> aVar) {
        return n.b(d0Var, null, 0, new a(aVar, null), 3, null);
    }

    public static final <R, T> Object c(b<? super R> bVar, kotlinx.coroutines.flow.a<? extends T>[] aVarArr, kotlin.jvm.b.a<T[]> aVar, q<? super b<? super R>, ? super T[], ? super c<? super kotlin.p>, ? extends Object> qVar, c<? super kotlin.p> cVar) {
        return e0.a(new CombineKt$combineInternal$2(bVar, aVarArr, aVar, qVar, null), cVar);
    }
}
