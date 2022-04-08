package kotlinx.coroutines.internal;

import java.lang.reflect.Constructor;
import kotlin.Result;
import kotlin.TypeCastException;
import kotlin.jvm.b.l;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import kotlin.k;

/* compiled from: ExceptionsConstuctor.kt */
/* loaded from: classes4.dex */
public final class ExceptionsConstuctorKt$createConstructor$$inlined$safeCtor$2 extends Lambda implements l<Throwable, Throwable> {
    final /* synthetic */ Constructor $constructor$inlined;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExceptionsConstuctorKt$createConstructor$$inlined$safeCtor$2(Constructor constructor) {
        super(1);
        this.$constructor$inlined = constructor;
    }

    public final Throwable invoke(Throwable e2) {
        Object obj;
        Object newInstance;
        j.f(e2, "e");
        try {
            Result.a aVar = Result.Companion;
            newInstance = this.$constructor$inlined.newInstance(e2);
        } catch (Throwable th) {
            Result.a aVar2 = Result.Companion;
            obj = Result.m1constructorimpl(k.a(th));
        }
        if (newInstance != null) {
            obj = Result.m1constructorimpl((Throwable) newInstance);
            if (Result.m7isFailureimpl(obj)) {
                obj = null;
            }
            return (Throwable) obj;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Throwable");
    }
}
