package kotlinx.coroutines.internal;

import java.util.List;
import kotlin.jvm.internal.j;
import kotlinx.coroutines.m1;

/* compiled from: MainDispatchers.kt */
/* loaded from: classes4.dex */
public final class m {
    public static final m1 a(MainDispatcherFactory tryCreateDispatcher, List<? extends MainDispatcherFactory> factories) {
        j.f(tryCreateDispatcher, "$this$tryCreateDispatcher");
        j.f(factories, "factories");
        try {
            return tryCreateDispatcher.b(factories);
        } catch (Throwable th) {
            return new n(th, tryCreateDispatcher.a());
        }
    }
}
