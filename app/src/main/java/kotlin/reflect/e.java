package kotlin.reflect;

import kotlin.c;

/* compiled from: KFunction.kt */
/* loaded from: classes4.dex */
public interface e<R> extends b<R>, c<R> {
    boolean isExternal();

    boolean isInfix();

    boolean isInline();

    boolean isOperator();

    @Override // kotlin.reflect.b
    boolean isSuspend();
}
