package kotlinx.coroutines.internal;

import java.util.ArrayDeque;
import kotlin.Pair;
import kotlin.Result;
import kotlin.TypeCastException;
import kotlin.coroutines.jvm.internal.c;
import kotlin.jvm.internal.j;
import kotlin.k;
import kotlin.n;
import kotlin.text.v;
import kotlinx.coroutines.g0;

/* compiled from: StackTraceRecovery.kt */
/* loaded from: classes4.dex */
public final class s {
    private static final String a;

    /* renamed from: b  reason: collision with root package name */
    private static final String f16494b;

    static {
        Object obj;
        Object obj2;
        try {
            Result.a aVar = Result.Companion;
            Class<?> cls = Class.forName("kotlin.coroutines.jvm.internal.BaseContinuationImpl");
            j.b(cls, "Class.forName(baseContinuationImplClass)");
            obj = Result.m1constructorimpl(cls.getCanonicalName());
        } catch (Throwable th) {
            Result.a aVar2 = Result.Companion;
            obj = Result.m1constructorimpl(k.a(th));
        }
        if (Result.m4exceptionOrNullimpl(obj) != null) {
            obj = "kotlin.coroutines.jvm.internal.BaseContinuationImpl";
        }
        a = (String) obj;
        try {
            Result.a aVar3 = Result.Companion;
            Class<?> cls2 = Class.forName("kotlinx.coroutines.internal.s");
            j.b(cls2, "Class.forName(stackTraceRecoveryClass)");
            obj2 = Result.m1constructorimpl(cls2.getCanonicalName());
        } catch (Throwable th2) {
            Result.a aVar4 = Result.Companion;
            obj2 = Result.m1constructorimpl(k.a(th2));
        }
        if (Result.m4exceptionOrNullimpl(obj2) != null) {
            obj2 = "kotlinx.coroutines.internal.StackTraceRecoveryKt";
        }
        f16494b = (String) obj2;
    }

    public static final StackTraceElement a(String message) {
        j.f(message, "message");
        return new StackTraceElement("\b\b\b(" + message, "\b", "\b", -1);
    }

    private static final <E extends Throwable> Pair<E, StackTraceElement[]> b(E e2) {
        boolean z;
        Throwable cause = e2.getCause();
        if (cause == null || !j.a(cause.getClass(), e2.getClass())) {
            return n.a(e2, new StackTraceElement[0]);
        }
        StackTraceElement[] currentTrace = e2.getStackTrace();
        j.b(currentTrace, "currentTrace");
        int length = currentTrace.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                z = false;
                break;
            }
            StackTraceElement it = currentTrace[i];
            j.b(it, "it");
            if (g(it)) {
                z = true;
                break;
            }
            i++;
        }
        if (z) {
            return n.a(cause, currentTrace);
        }
        return n.a(e2, new StackTraceElement[0]);
    }

    private static final <E extends Throwable> E c(E e2, E e3, ArrayDeque<StackTraceElement> arrayDeque) {
        arrayDeque.addFirst(a("Coroutine boundary"));
        StackTraceElement[] causeTrace = e2.getStackTrace();
        j.b(causeTrace, "causeTrace");
        String baseContinuationImplClassName = a;
        j.b(baseContinuationImplClassName, "baseContinuationImplClassName");
        int f2 = f(causeTrace, baseContinuationImplClassName);
        int i = 0;
        if (f2 == -1) {
            Object[] array = arrayDeque.toArray(new StackTraceElement[0]);
            if (array != null) {
                e3.setStackTrace((StackTraceElement[]) array);
                return e3;
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
        }
        StackTraceElement[] stackTraceElementArr = new StackTraceElement[arrayDeque.size() + f2];
        for (int i2 = 0; i2 < f2; i2++) {
            stackTraceElementArr[i2] = causeTrace[i2];
        }
        for (StackTraceElement stackTraceElement : arrayDeque) {
            stackTraceElementArr[f2 + i] = stackTraceElement;
            i++;
        }
        e3.setStackTrace(stackTraceElementArr);
        return e3;
    }

    private static final ArrayDeque<StackTraceElement> d(c cVar) {
        ArrayDeque<StackTraceElement> arrayDeque = new ArrayDeque<>();
        StackTraceElement stackTraceElement = cVar.getStackTraceElement();
        if (stackTraceElement != null) {
            arrayDeque.add(stackTraceElement);
        }
        while (cVar != null) {
            cVar = cVar.getCallerFrame();
            if (cVar == null) {
                break;
            }
            StackTraceElement stackTraceElement2 = cVar.getStackTraceElement();
            if (stackTraceElement2 != null) {
                arrayDeque.add(stackTraceElement2);
            }
        }
        return arrayDeque;
    }

    private static final boolean e(StackTraceElement stackTraceElement, StackTraceElement stackTraceElement2) {
        return stackTraceElement.getLineNumber() == stackTraceElement2.getLineNumber() && j.a(stackTraceElement.getMethodName(), stackTraceElement2.getMethodName()) && j.a(stackTraceElement.getFileName(), stackTraceElement2.getFileName()) && j.a(stackTraceElement.getClassName(), stackTraceElement2.getClassName());
    }

    private static final int f(StackTraceElement[] stackTraceElementArr, String str) {
        int length = stackTraceElementArr.length;
        for (int i = 0; i < length; i++) {
            if (j.a(str, stackTraceElementArr[i].getClassName())) {
                return i;
            }
        }
        return -1;
    }

    public static final boolean g(StackTraceElement isArtificial) {
        boolean A;
        j.f(isArtificial, "$this$isArtificial");
        String className = isArtificial.getClassName();
        j.b(className, "className");
        A = v.A(className, "\b\b\b", false, 2, null);
        return A;
    }

    private static final void h(StackTraceElement[] stackTraceElementArr, ArrayDeque<StackTraceElement> arrayDeque) {
        int length = stackTraceElementArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                i = -1;
                break;
            } else if (g(stackTraceElementArr[i])) {
                break;
            } else {
                i++;
            }
        }
        int i2 = i + 1;
        int length2 = stackTraceElementArr.length - 1;
        if (length2 >= i2) {
            while (true) {
                StackTraceElement stackTraceElement = stackTraceElementArr[length2];
                StackTraceElement last = arrayDeque.getLast();
                j.b(last, "result.last");
                if (e(stackTraceElement, last)) {
                    arrayDeque.removeLast();
                }
                arrayDeque.addFirst(stackTraceElementArr[length2]);
                if (length2 != i2) {
                    length2--;
                } else {
                    return;
                }
            }
        }
    }

    private static final <E extends Throwable> E i(E e2, c cVar) {
        Pair b2 = b(e2);
        Throwable th = (Throwable) b2.component1();
        StackTraceElement[] stackTraceElementArr = (StackTraceElement[]) b2.component2();
        Throwable e3 = ExceptionsConstuctorKt.e(th);
        if (e3 == null) {
            return e2;
        }
        ArrayDeque<StackTraceElement> d2 = d(cVar);
        if (d2.isEmpty()) {
            return e2;
        }
        if (th != e2) {
            h(stackTraceElementArr, d2);
        }
        return (E) c(th, e3, d2);
    }

    public static final <E extends Throwable> E j(E exception) {
        Throwable e2;
        j.f(exception, "exception");
        return (g0.d() && (e2 = ExceptionsConstuctorKt.e(exception)) != null) ? (E) l(e2) : exception;
    }

    public static final <E extends Throwable> E k(E exception, kotlin.coroutines.c<?> continuation) {
        j.f(exception, "exception");
        j.f(continuation, "continuation");
        return (!g0.d() || !(continuation instanceof c)) ? exception : (E) i(exception, (c) continuation);
    }

    private static final <E extends Throwable> E l(E e2) {
        StackTraceElement stackTraceElement;
        StackTraceElement[] stackTrace = e2.getStackTrace();
        int length = stackTrace.length;
        j.b(stackTrace, "stackTrace");
        String stackTraceRecoveryClassName = f16494b;
        j.b(stackTraceRecoveryClassName, "stackTraceRecoveryClassName");
        int f2 = f(stackTrace, stackTraceRecoveryClassName);
        int i = f2 + 1;
        String baseContinuationImplClassName = a;
        j.b(baseContinuationImplClassName, "baseContinuationImplClassName");
        int f3 = f(stackTrace, baseContinuationImplClassName);
        int i2 = (length - f2) - (f3 == -1 ? 0 : length - f3);
        StackTraceElement[] stackTraceElementArr = new StackTraceElement[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            if (i3 == 0) {
                stackTraceElement = a("Coroutine boundary");
            } else {
                stackTraceElement = stackTrace[(i + i3) - 1];
            }
            stackTraceElementArr[i3] = stackTraceElement;
        }
        e2.setStackTrace(stackTraceElementArr);
        return e2;
    }

    public static final <E extends Throwable> E m(E exception) {
        E e2;
        j.f(exception, "exception");
        if (g0.d() && (e2 = (E) exception.getCause()) != null) {
            boolean z = true;
            if (!(!j.a(e2.getClass(), exception.getClass()))) {
                StackTraceElement[] stackTrace = exception.getStackTrace();
                j.b(stackTrace, "exception.stackTrace");
                int length = stackTrace.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        z = false;
                        break;
                    }
                    StackTraceElement it = stackTrace[i];
                    j.b(it, "it");
                    if (g(it)) {
                        break;
                    }
                    i++;
                }
                if (z) {
                    return e2;
                }
            }
        }
        return exception;
    }
}
