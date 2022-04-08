package com.bumptech.glide;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: GlideExperiments.java */
/* loaded from: classes.dex */
public class f {
    private final Map<Class<?>, ?> a;

    /* compiled from: GlideExperiments.java */
    /* loaded from: classes.dex */
    static final class a {
        private final Map<Class<?>, ?> a = new HashMap();

        /* JADX INFO: Access modifiers changed from: package-private */
        public f b() {
            return new f(this);
        }
    }

    f(a aVar) {
        this.a = Collections.unmodifiableMap(new HashMap(aVar.a));
    }

    public boolean a(Class<?> cls) {
        return this.a.containsKey(cls);
    }
}
