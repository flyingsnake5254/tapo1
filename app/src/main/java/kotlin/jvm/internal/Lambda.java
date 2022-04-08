package kotlin.jvm.internal;

import java.io.Serializable;

/* compiled from: Lambda.kt */
/* loaded from: classes4.dex */
public abstract class Lambda<R> implements h<R>, Serializable {
    private final int arity;

    public Lambda(int i) {
        this.arity = i;
    }

    @Override // kotlin.jvm.internal.h
    public int getArity() {
        return this.arity;
    }

    public String toString() {
        String k = m.k(this);
        j.d(k, "Reflection.renderLambdaToString(this)");
        return k;
    }
}
