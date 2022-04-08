package com.google.common.util.concurrent;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.n1;
import com.google.common.collect.o1;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;
import java.util.logging.Level;
import java.util.logging.Logger;

@CanIgnoreReturnValue
/* loaded from: classes2.dex */
public class CycleDetectingLockFactory {
    private static final ConcurrentMap<Class<? extends Enum>, Map<? extends Enum, c>> a = new o1().h().f();

    /* renamed from: b  reason: collision with root package name */
    private static final Logger f4780b = Logger.getLogger(CycleDetectingLockFactory.class.getName());

    /* renamed from: c  reason: collision with root package name */
    private static final ThreadLocal<ArrayList<c>> f4781c = new a();

    /* JADX WARN: Failed to restore enum class, 'enum' modifier removed */
    /* loaded from: classes2.dex */
    public static abstract class Policies extends Enum<Policies> {
        private static final /* synthetic */ Policies[] $VALUES;
        public static final Policies DISABLED;
        public static final Policies THROW;
        public static final Policies WARN;

        /* JADX WARN: Failed to restore enum class, 'enum' modifier removed */
        /* loaded from: classes2.dex */
        static class a extends Policies {
            a(String str, int i) {
                super(str, i, null);
            }

            @Override // com.google.common.util.concurrent.CycleDetectingLockFactory.Policies
            public void handlePotentialDeadlock(PotentialDeadlockException potentialDeadlockException) {
                throw potentialDeadlockException;
            }
        }

        /* JADX WARN: Failed to restore enum class, 'enum' modifier removed */
        /* loaded from: classes2.dex */
        static class b extends Policies {
            b(String str, int i) {
                super(str, i, null);
            }

            @Override // com.google.common.util.concurrent.CycleDetectingLockFactory.Policies
            public void handlePotentialDeadlock(PotentialDeadlockException potentialDeadlockException) {
                CycleDetectingLockFactory.f4780b.log(Level.SEVERE, "Detected potential deadlock", (Throwable) potentialDeadlockException);
            }
        }

        /* JADX WARN: Failed to restore enum class, 'enum' modifier removed */
        /* loaded from: classes2.dex */
        static class c extends Policies {
            c(String str, int i) {
                super(str, i, null);
            }

            @Override // com.google.common.util.concurrent.CycleDetectingLockFactory.Policies
            public void handlePotentialDeadlock(PotentialDeadlockException potentialDeadlockException) {
            }
        }

        static {
            a aVar = new a("THROW", 0);
            THROW = aVar;
            b bVar = new b("WARN", 1);
            WARN = bVar;
            c cVar = new c("DISABLED", 2);
            DISABLED = cVar;
            $VALUES = new Policies[]{aVar, bVar, cVar};
        }

        private Policies(String str, int i) {
        }

        public static Policies valueOf(String str) {
            return (Policies) Enum.valueOf(Policies.class, str);
        }

        public static Policies[] values() {
            return (Policies[]) $VALUES.clone();
        }

        public abstract /* synthetic */ void handlePotentialDeadlock(PotentialDeadlockException potentialDeadlockException);

        /* synthetic */ Policies(String str, int i, a aVar) {
            this(str, i);
        }
    }

    /* loaded from: classes2.dex */
    public static final class PotentialDeadlockException extends b {
        private final b conflictingStackTrace;

        /* synthetic */ PotentialDeadlockException(c cVar, c cVar2, b bVar, a aVar) {
            this(cVar, cVar2, bVar);
        }

        public b getConflictingStackTrace() {
            return this.conflictingStackTrace;
        }

        @Override // java.lang.Throwable
        public String getMessage() {
            StringBuilder sb = new StringBuilder(super.getMessage());
            for (Throwable th = this.conflictingStackTrace; th != null; th = th.getCause()) {
                sb.append(", ");
                sb.append(th.getMessage());
            }
            return sb.toString();
        }

        private PotentialDeadlockException(c cVar, c cVar2, b bVar) {
            super(cVar, cVar2);
            this.conflictingStackTrace = bVar;
            initCause(bVar);
        }
    }

    /* loaded from: classes2.dex */
    static class a extends ThreadLocal<ArrayList<c>> {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: a */
        public ArrayList<c> initialValue() {
            return n1.k(3);
        }
    }

    /* loaded from: classes2.dex */
    private static class b extends IllegalStateException {
        static final StackTraceElement[] EMPTY_STACK_TRACE = new StackTraceElement[0];
        static final ImmutableSet<String> EXCLUDED_CLASS_NAMES = ImmutableSet.of(CycleDetectingLockFactory.class.getName(), b.class.getName(), c.class.getName());

        b(c cVar, c cVar2) {
            super(cVar.a() + " -> " + cVar2.a());
            StackTraceElement[] stackTrace = getStackTrace();
            int length = stackTrace.length;
            for (int i = 0; i < length; i++) {
                if (d.class.getName().equals(stackTrace[i].getClassName())) {
                    setStackTrace(EMPTY_STACK_TRACE);
                    return;
                } else if (!EXCLUDED_CLASS_NAMES.contains(stackTrace[i].getClassName())) {
                    setStackTrace((StackTraceElement[]) Arrays.copyOfRange(stackTrace, i, length));
                    return;
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    private static class c {
        final String a;

        String a() {
            return this.a;
        }
    }

    /* loaded from: classes2.dex */
    public static final class d<E extends Enum<E>> extends CycleDetectingLockFactory {
    }
}
