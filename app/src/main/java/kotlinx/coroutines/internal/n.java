package kotlinx.coroutines.internal;

import kotlin.jvm.internal.f;
import kotlin.jvm.internal.j;
import kotlinx.coroutines.m1;

/* compiled from: MainDispatchers.kt */
/* loaded from: classes4.dex */
final class n extends m1 {

    /* renamed from: c  reason: collision with root package name */
    private final Throwable f16492c;

    /* renamed from: d  reason: collision with root package name */
    private final String f16493d;

    public /* synthetic */ n(Throwable th, String str, int i, f fVar) {
        this(th, (i & 2) != 0 ? null : str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0023, code lost:
        if (r1 != null) goto L_0x0028;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final java.lang.Void w() {
        /*
            r4 = this;
            java.lang.Throwable r0 = r4.f16492c
            if (r0 == 0) goto L_0x0037
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Module with the Main dispatcher had failed to initialize"
            r0.append(r1)
            java.lang.String r1 = r4.f16493d
            if (r1 == 0) goto L_0x0026
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = ". "
            r2.append(r3)
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            if (r1 == 0) goto L_0x0026
            goto L_0x0028
        L_0x0026:
            java.lang.String r1 = ""
        L_0x0028:
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.Throwable r2 = r4.f16492c
            r1.<init>(r0, r2)
            throw r1
        L_0x0037:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "Module with the Main dispatcher is missing. Add dependency providing the Main dispatcher, e.g. 'kotlinx-coroutines-android'"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.n.w():java.lang.Void");
    }

    @Override // kotlinx.coroutines.y
    public boolean isDispatchNeeded(kotlin.coroutines.f context) {
        j.f(context, "context");
        w();
        throw null;
    }

    @Override // kotlinx.coroutines.y
    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("Main[missing");
        if (this.f16492c != null) {
            str = ", cause=" + this.f16492c;
        } else {
            str = "";
        }
        sb.append(str);
        sb.append(']');
        return sb.toString();
    }

    @Override // kotlinx.coroutines.m1
    public m1 u() {
        return this;
    }

    /* renamed from: v */
    public Void dispatch(kotlin.coroutines.f context, Runnable block) {
        j.f(context, "context");
        j.f(block, "block");
        w();
        throw null;
    }

    public n(Throwable th, String str) {
        this.f16492c = th;
        this.f16493d = str;
    }
}
