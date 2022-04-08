package b.d.d.b;

import androidx.annotation.NonNull;
import java.util.HashMap;
import java.util.Map;

/* compiled from: HolderMediaAccountContext.java */
/* loaded from: classes3.dex */
public class b implements g {
    private static final C0016b a = new C0016b();

    /* renamed from: b  reason: collision with root package name */
    private f f181b = new f();

    /* compiled from: HolderMediaAccountContext.java */
    /* renamed from: b.d.d.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    static class C0016b {
        private Map<c, b> a;

        b a(c cVar) {
            b bVar = this.a.get(cVar);
            if (bVar != null) {
                return bVar;
            }
            b bVar2 = new b();
            this.a.put(cVar, bVar2);
            return bVar2;
        }

        private C0016b() {
            this.a = new HashMap();
        }
    }

    public static b b(c cVar) {
        return a.a(cVar);
    }

    @Override // b.d.d.b.g
    @NonNull
    public f a() {
        return this.f181b;
    }
}
