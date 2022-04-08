package kotlinx.coroutines;

import kotlin.coroutines.d;
import kotlin.coroutines.f;
import kotlin.jvm.internal.j;
import kotlinx.coroutines.scheduling.b;

/* compiled from: CoroutineContext.kt */
/* loaded from: classes4.dex */
public final class x {
    private static final boolean a;

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0028, code lost:
        if (r0.equals("on") != false) goto L_0x0033;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0031, code lost:
        if (r0.equals("") != false) goto L_0x0033;
     */
    static {
        /*
            java.lang.String r0 = "kotlinx.coroutines.scheduler"
            java.lang.String r0 = kotlinx.coroutines.internal.u.d(r0)
            if (r0 != 0) goto L_0x0009
            goto L_0x0033
        L_0x0009:
            int r1 = r0.hashCode()
            if (r1 == 0) goto L_0x002b
            r2 = 3551(0xddf, float:4.976E-42)
            if (r1 == r2) goto L_0x0022
            r2 = 109935(0x1ad6f, float:1.54052E-40)
            if (r1 != r2) goto L_0x0037
            java.lang.String r1 = "off"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x0037
            r0 = 0
            goto L_0x0034
        L_0x0022:
            java.lang.String r1 = "on"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x0037
            goto L_0x0033
        L_0x002b:
            java.lang.String r1 = ""
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x0037
        L_0x0033:
            r0 = 1
        L_0x0034:
            kotlinx.coroutines.x.a = r0
            return
        L_0x0037:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "System property 'kotlinx.coroutines.scheduler' has unrecognized value '"
            r1.append(r2)
            r1.append(r0)
            r0 = 39
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r0 = r0.toString()
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.x.<clinit>():void");
    }

    public static final y a() {
        return a ? b.z : p.f16519f;
    }

    public static final String b(f coroutineName) {
        b0 b0Var;
        String str;
        j.f(coroutineName, "$this$coroutineName");
        if (!g0.c() || (b0Var = (b0) coroutineName.get(b0.f16424c)) == null) {
            return null;
        }
        c0 c0Var = (c0) coroutineName.get(c0.f16426c);
        if (c0Var == null || (str = c0Var.u()) == null) {
            str = "coroutine";
        }
        return str + '#' + b0Var.u();
    }

    public static final f c(d0 newCoroutineContext, f context) {
        j.f(newCoroutineContext, "$this$newCoroutineContext");
        j.f(context, "context");
        f plus = newCoroutineContext.getCoroutineContext().plus(context);
        f plus2 = g0.c() ? plus.plus(new b0(g0.b().incrementAndGet())) : plus;
        return (plus == n0.a() || plus.get(d.f16330e) != null) ? plus2 : plus2.plus(n0.a());
    }
}
