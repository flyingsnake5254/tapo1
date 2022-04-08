package kotlinx.android.extensions;

import kotlin.jvm.internal.f;

/* compiled from: CacheImplementation.kt */
/* loaded from: classes4.dex */
public enum CacheImplementation {
    SPARSE_ARRAY,
    HASH_MAP,
    NO_CACHE;
    
    public static final a Companion = new a(null);
    private static final CacheImplementation DEFAULT = HASH_MAP;

    /* compiled from: CacheImplementation.kt */
    /* loaded from: classes4.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }
}
