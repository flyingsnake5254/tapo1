package kotlin.internal;

import java.lang.reflect.Method;
import kotlin.jvm.internal.j;
import kotlin.u.b;
import kotlin.u.c;

/* compiled from: PlatformImplementations.kt */
/* loaded from: classes4.dex */
public class a {

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: PlatformImplementations.kt */
    /* renamed from: kotlin.internal.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static final class C0321a {
        public static final Method a;

        /* renamed from: b  reason: collision with root package name */
        public static final Method f16340b;

        /* renamed from: c  reason: collision with root package name */
        public static final C0321a f16341c = new C0321a();

        /* JADX WARN: Removed duplicated region for block: B:12:0x0046 A[LOOP:0: B:3:0x0015->B:12:0x0046, LOOP_END] */
        /* JADX WARN: Removed duplicated region for block: B:22:0x004a A[EDGE_INSN: B:22:0x004a->B:14:0x004a ?: BREAK  , SYNTHETIC] */
        static {
            /*
                kotlin.internal.a$a r0 = new kotlin.internal.a$a
                r0.<init>()
                kotlin.internal.a.C0321a.f16341c = r0
                java.lang.Class<java.lang.Throwable> r0 = java.lang.Throwable.class
                java.lang.reflect.Method[] r1 = r0.getMethods()
                java.lang.String r2 = "throwableMethods"
                kotlin.jvm.internal.j.d(r1, r2)
                int r2 = r1.length
                r3 = 0
                r4 = 0
            L_0x0015:
                java.lang.String r5 = "it"
                r6 = 0
                if (r4 >= r2) goto L_0x0049
                r7 = r1[r4]
                kotlin.jvm.internal.j.d(r7, r5)
                java.lang.String r8 = r7.getName()
                java.lang.String r9 = "addSuppressed"
                boolean r8 = kotlin.jvm.internal.j.a(r8, r9)
                if (r8 == 0) goto L_0x0042
                java.lang.Class[] r8 = r7.getParameterTypes()
                java.lang.String r9 = "it.parameterTypes"
                kotlin.jvm.internal.j.d(r8, r9)
                java.lang.Object r8 = kotlin.collections.e.s(r8)
                java.lang.Class r8 = (java.lang.Class) r8
                boolean r8 = kotlin.jvm.internal.j.a(r8, r0)
                if (r8 == 0) goto L_0x0042
                r8 = 1
                goto L_0x0043
            L_0x0042:
                r8 = 0
            L_0x0043:
                if (r8 == 0) goto L_0x0046
                goto L_0x004a
            L_0x0046:
                int r4 = r4 + 1
                goto L_0x0015
            L_0x0049:
                r7 = r6
            L_0x004a:
                kotlin.internal.a.C0321a.a = r7
                int r0 = r1.length
            L_0x004d:
                if (r3 >= r0) goto L_0x0065
                r2 = r1[r3]
                kotlin.jvm.internal.j.d(r2, r5)
                java.lang.String r4 = r2.getName()
                java.lang.String r7 = "getSuppressed"
                boolean r4 = kotlin.jvm.internal.j.a(r4, r7)
                if (r4 == 0) goto L_0x0062
                r6 = r2
                goto L_0x0065
            L_0x0062:
                int r3 = r3 + 1
                goto L_0x004d
            L_0x0065:
                kotlin.internal.a.C0321a.f16340b = r6
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.internal.a.C0321a.<clinit>():void");
        }

        private C0321a() {
        }
    }

    public void a(Throwable cause, Throwable exception) {
        j.e(cause, "cause");
        j.e(exception, "exception");
        Method method = C0321a.a;
        if (method != null) {
            method.invoke(cause, exception);
        }
    }

    public c b() {
        return new b();
    }
}
