package kotlin.coroutines.intrinsics;

import java.util.Objects;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.BaseContinuationImpl;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.RestrictedContinuationImpl;
import kotlin.coroutines.jvm.internal.f;
import kotlin.jvm.b.l;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.q;
import kotlin.k;
import kotlin.p;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IntrinsicsJvm.kt */
/* loaded from: classes4.dex */
public class IntrinsicsKt__IntrinsicsJvmKt {
    public static <T> c<p> a(final l<? super c<? super T>, ? extends Object> createCoroutineUnintercepted, c<? super T> completion) {
        c<p> cVar;
        j.e(createCoroutineUnintercepted, "$this$createCoroutineUnintercepted");
        j.e(completion, "completion");
        final c<?> a = f.a(completion);
        if (createCoroutineUnintercepted instanceof BaseContinuationImpl) {
            return ((BaseContinuationImpl) createCoroutineUnintercepted).create(a);
        }
        final kotlin.coroutines.f context = a.getContext();
        if (context == EmptyCoroutineContext.INSTANCE) {
            cVar = new RestrictedContinuationImpl(a) { // from class: kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$1
                private int label;

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                protected Object invokeSuspend(Object obj) {
                    int i = this.label;
                    if (i == 0) {
                        this.label = 1;
                        k.b(obj);
                        l lVar = createCoroutineUnintercepted;
                        Objects.requireNonNull(lVar, "null cannot be cast to non-null type (kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
                        return ((l) q.b(lVar, 1)).invoke(this);
                    } else if (i == 1) {
                        this.label = 2;
                        k.b(obj);
                        return obj;
                    } else {
                        throw new IllegalStateException("This coroutine had already completed".toString());
                    }
                }
            };
        } else {
            cVar = new ContinuationImpl(a, context) { // from class: kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$2
                private int label;

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                protected Object invokeSuspend(Object obj) {
                    int i = this.label;
                    if (i == 0) {
                        this.label = 1;
                        k.b(obj);
                        l lVar = createCoroutineUnintercepted;
                        Objects.requireNonNull(lVar, "null cannot be cast to non-null type (kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
                        return ((l) q.b(lVar, 1)).invoke(this);
                    } else if (i == 1) {
                        this.label = 2;
                        k.b(obj);
                        return obj;
                    } else {
                        throw new IllegalStateException("This coroutine had already completed".toString());
                    }
                }
            };
        }
        return cVar;
    }

    public static <R, T> c<p> b(final kotlin.jvm.b.p<? super R, ? super c<? super T>, ? extends Object> createCoroutineUnintercepted, final R r, c<? super T> completion) {
        c<p> cVar;
        j.e(createCoroutineUnintercepted, "$this$createCoroutineUnintercepted");
        j.e(completion, "completion");
        final c<?> a = f.a(completion);
        if (createCoroutineUnintercepted instanceof BaseContinuationImpl) {
            return ((BaseContinuationImpl) createCoroutineUnintercepted).create(r, a);
        }
        final kotlin.coroutines.f context = a.getContext();
        if (context == EmptyCoroutineContext.INSTANCE) {
            cVar = new RestrictedContinuationImpl(a) { // from class: kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$3
                private int label;

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                protected Object invokeSuspend(Object obj) {
                    int i = this.label;
                    if (i == 0) {
                        this.label = 1;
                        k.b(obj);
                        kotlin.jvm.b.p pVar = createCoroutineUnintercepted;
                        Objects.requireNonNull(pVar, "null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
                        return ((kotlin.jvm.b.p) q.b(pVar, 2)).invoke(r, this);
                    } else if (i == 1) {
                        this.label = 2;
                        k.b(obj);
                        return obj;
                    } else {
                        throw new IllegalStateException("This coroutine had already completed".toString());
                    }
                }
            };
        } else {
            cVar = new ContinuationImpl(a, context) { // from class: kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$4
                private int label;

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                protected Object invokeSuspend(Object obj) {
                    int i = this.label;
                    if (i == 0) {
                        this.label = 1;
                        k.b(obj);
                        kotlin.jvm.b.p pVar = createCoroutineUnintercepted;
                        Objects.requireNonNull(pVar, "null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
                        return ((kotlin.jvm.b.p) q.b(pVar, 2)).invoke(r, this);
                    } else if (i == 1) {
                        this.label = 2;
                        k.b(obj);
                        return obj;
                    } else {
                        throw new IllegalStateException("This coroutine had already completed".toString());
                    }
                }
            };
        }
        return cVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> c<T> c(c<? super T> intercepted) {
        c<T> cVar;
        j.e(intercepted, "$this$intercepted");
        ContinuationImpl continuationImpl = !(intercepted instanceof ContinuationImpl) ? null : intercepted;
        return (continuationImpl == null || (cVar = (c<T>) continuationImpl.intercepted()) == null) ? intercepted : cVar;
    }
}
