package kotlin.coroutines.jvm.internal;

import java.io.Serializable;
import kotlin.Result;
import kotlin.coroutines.c;
import kotlin.coroutines.f;
import kotlin.coroutines.intrinsics.a;
import kotlin.jvm.internal.j;
import kotlin.k;
import kotlin.p;

/* compiled from: ContinuationImpl.kt */
/* loaded from: classes4.dex */
public abstract class BaseContinuationImpl implements c<Object>, c, Serializable {
    private final c<Object> completion;

    public BaseContinuationImpl(c<Object> cVar) {
        this.completion = cVar;
    }

    public c<p> create(c<?> completion) {
        j.e(completion, "completion");
        throw new UnsupportedOperationException("create(Continuation) has not been overridden");
    }

    @Override // kotlin.coroutines.jvm.internal.c
    public c getCallerFrame() {
        c<Object> cVar = this.completion;
        if (!(cVar instanceof c)) {
            cVar = null;
        }
        return (c) cVar;
    }

    public final c<Object> getCompletion() {
        return this.completion;
    }

    @Override // kotlin.coroutines.c
    public abstract /* synthetic */ f getContext();

    @Override // kotlin.coroutines.jvm.internal.c
    public StackTraceElement getStackTraceElement() {
        return e.d(this);
    }

    protected abstract Object invokeSuspend(Object obj);

    protected void releaseIntercepted() {
    }

    @Override // kotlin.coroutines.c
    public final void resumeWith(Object obj) {
        Object invokeSuspend;
        BaseContinuationImpl baseContinuationImpl = this;
        while (true) {
            f.b(baseContinuationImpl);
            c<Object> cVar = baseContinuationImpl.completion;
            j.c(cVar);
            try {
                invokeSuspend = baseContinuationImpl.invokeSuspend(obj);
            } catch (Throwable th) {
                Result.a aVar = Result.Companion;
                obj = Result.m1constructorimpl(k.a(th));
            }
            if (invokeSuspend != a.d()) {
                Result.a aVar2 = Result.Companion;
                obj = Result.m1constructorimpl(invokeSuspend);
                baseContinuationImpl.releaseIntercepted();
                if (cVar instanceof BaseContinuationImpl) {
                    baseContinuationImpl = (BaseContinuationImpl) cVar;
                } else {
                    cVar.resumeWith(obj);
                    return;
                }
            } else {
                return;
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Continuation at ");
        Object stackTraceElement = getStackTraceElement();
        if (stackTraceElement == null) {
            stackTraceElement = getClass().getName();
        }
        sb.append(stackTraceElement);
        return sb.toString();
    }

    public c<p> create(Object obj, c<?> completion) {
        j.e(completion, "completion");
        throw new UnsupportedOperationException("create(Any?;Continuation) has not been overridden");
    }
}
