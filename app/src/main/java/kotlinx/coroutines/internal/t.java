package kotlinx.coroutines.internal;

import kotlin.jvm.internal.j;

/* compiled from: Symbol.kt */
/* loaded from: classes4.dex */
public final class t {
    private final String a;

    public t(String symbol) {
        j.f(symbol, "symbol");
        this.a = symbol;
    }

    public String toString() {
        return this.a;
    }
}
