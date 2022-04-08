package b.d.d.b;

import java.util.HashMap;

/* compiled from: MediaCloudRepositoryStore.java */
/* loaded from: classes3.dex */
public class f {
    private final HashMap<String, a> a = new HashMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    public final a a(String str) {
        return this.a.get(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(String str, a aVar) {
        this.a.put(str, aVar);
    }
}
