package kotlinx.coroutines.internal;

import kotlin.Result;
import kotlin.jvm.b.l;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import kotlin.k;

/* compiled from: ExceptionsConstuctor.kt */
/* loaded from: classes4.dex */
public final class ExceptionsConstuctorKt$safeCtor$1 extends Lambda implements l<Throwable, Throwable> {
    final /* synthetic */ l $block;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExceptionsConstuctorKt$safeCtor$1(l lVar) {
        super(1);
        this.$block = lVar;
    }

    public final Throwable invoke(Throwable e2) {
        Object obj;
        j.f(e2, "e");
        try {
            Result.a aVar = Result.Companion;
            obj = Result.m1constructorimpl((Throwable) this.$block.invoke(e2));
        } catch (Throwable th) {
            Result.a aVar2 = Result.Companion;
            obj = Result.m1constructorimpl(k.a(th));
        }
        if (Result.m7isFailureimpl(obj)) {
            obj = null;
        }
        return (Throwable) obj;
    }
}
