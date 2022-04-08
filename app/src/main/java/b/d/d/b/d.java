package b.d.d.b;

import androidx.annotation.NonNull;
import com.tplink.libtpmediastatistics.SSLClient;

/* compiled from: MediaCloudRepositoryProvider.java */
/* loaded from: classes3.dex */
public class d {
    private static final String a = d.class.getSimpleName() + ".DefaultKey";

    /* renamed from: b  reason: collision with root package name */
    private final a f182b;

    /* renamed from: c  reason: collision with root package name */
    private final f f183c;

    /* compiled from: MediaCloudRepositoryProvider.java */
    /* loaded from: classes3.dex */
    public interface a {
        @NonNull
        <T extends a> T create(@NonNull Class<T> cls);
    }

    public d(@NonNull a aVar, @NonNull f fVar) {
        this.f182b = aVar;
        this.f183c = fVar;
    }

    @NonNull
    public <T extends a> T a(@NonNull Class<T> cls) {
        String canonicalName = cls.getCanonicalName();
        if (canonicalName != null) {
            return (T) b(a + SSLClient.COLON + canonicalName, cls);
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    @NonNull
    public <T extends a> T b(@NonNull String str, @NonNull Class<T> cls) {
        T t = (T) this.f183c.a(str);
        if (cls.isInstance(t)) {
            return t;
        }
        T t2 = (T) this.f182b.create(cls);
        this.f183c.b(str, t2);
        return t2;
    }
}
