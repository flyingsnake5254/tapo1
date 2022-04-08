package com.tplink.libtpmediamanager.g;

import java.util.HashMap;

/* compiled from: MediaRepositoryStore.java */
/* loaded from: classes3.dex */
public class e {
    private final HashMap<String, b> a = new HashMap<>();

    public final void a() {
        for (b bVar : this.a.values()) {
            bVar.onCleared();
        }
        this.a.clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final b b(String str) {
        return this.a.get(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void c(String str, b bVar) {
        this.a.put(str, bVar);
    }
}
