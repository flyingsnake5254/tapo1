package kotlin.coroutines.jvm.internal;

import kotlin.coroutines.c;
import kotlin.jvm.internal.h;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.m;

/* compiled from: ContinuationImpl.kt */
/* loaded from: classes4.dex */
public abstract class SuspendLambda extends ContinuationImpl implements h<Object> {
    private final int arity;

    public SuspendLambda(int i, c<Object> cVar) {
        super(cVar);
        this.arity = i;
    }

    @Override // kotlin.jvm.internal.h
    public int getArity() {
        return this.arity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public String toString() {
        if (getCompletion() != null) {
            return super.toString();
        }
        String j = m.j(this);
        j.d(j, "Reflection.renderLambdaToString(this)");
        return j;
    }

    public SuspendLambda(int i) {
        this(i, null);
    }
}
