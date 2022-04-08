package b.d.c.a.h;

/* compiled from: TACommitBus.java */
/* loaded from: classes3.dex */
public class j {
    private static j a;

    /* renamed from: b  reason: collision with root package name */
    private k f134b;

    public static j a() {
        if (a == null) {
            synchronized (j.class) {
                if (a == null) {
                    a = new j();
                }
            }
        }
        return a;
    }

    public void b(String str) {
        k kVar = this.f134b;
        if (kVar != null) {
            kVar.a(str);
        }
    }

    public void c(k kVar) {
        if (kVar != null) {
            this.f134b = kVar;
        }
    }

    public void d() {
        if (this.f134b != null) {
            this.f134b = null;
        }
    }
}
