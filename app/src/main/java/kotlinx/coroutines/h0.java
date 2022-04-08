package kotlinx.coroutines;

import kotlin.Result;
import kotlin.coroutines.c;
import kotlin.jvm.internal.j;
import kotlin.k;

/* compiled from: DebugStrings.kt */
/* loaded from: classes4.dex */
public final class h0 {
    public static final String a(Object classSimpleName) {
        j.f(classSimpleName, "$this$classSimpleName");
        String simpleName = classSimpleName.getClass().getSimpleName();
        j.b(simpleName, "this::class.java.simpleName");
        return simpleName;
    }

    public static final String b(Object hexAddress) {
        j.f(hexAddress, "$this$hexAddress");
        String hexString = Integer.toHexString(System.identityHashCode(hexAddress));
        j.b(hexString, "Integer.toHexString(System.identityHashCode(this))");
        return hexString;
    }

    public static final String c(c<?> toDebugString) {
        Object obj;
        j.f(toDebugString, "$this$toDebugString");
        if (toDebugString instanceof j0) {
            return toDebugString.toString();
        }
        try {
            Result.a aVar = Result.Companion;
            obj = Result.m1constructorimpl(toDebugString + '@' + b(toDebugString));
        } catch (Throwable th) {
            Result.a aVar2 = Result.Companion;
            obj = Result.m1constructorimpl(k.a(th));
        }
        if (Result.m4exceptionOrNullimpl(obj) != null) {
            obj = toDebugString.getClass().getName() + '@' + b(toDebugString);
        }
        return (String) obj;
    }
}
