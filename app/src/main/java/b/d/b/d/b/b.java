package b.d.b.d.b;

import androidx.annotation.NonNull;
import com.tplink.libtpmediastatistics.SSLClient;
import java.lang.reflect.InvocationTargetException;

/* compiled from: CloudRepositoryProvider.java */
/* loaded from: classes2.dex */
public class b {
    private static final String a = b.class.getSimpleName() + ".DefaultKey";

    /* renamed from: b  reason: collision with root package name */
    private final a f91b;

    /* renamed from: c  reason: collision with root package name */
    private final c f92c;

    /* compiled from: CloudRepositoryProvider.java */
    /* loaded from: classes2.dex */
    public interface a {
        @NonNull
        <T extends a> T create(@NonNull Class<T> cls);
    }

    /* compiled from: CloudRepositoryProvider.java */
    /* renamed from: b.d.b.d.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0014b implements a {
        @Override // b.d.b.d.b.b.a
        @NonNull
        public <T extends a> T create(@NonNull Class<T> cls) {
            try {
                return cls.newInstance();
            } catch (IllegalAccessException e2) {
                throw new RuntimeException("Cannot create an instance of " + cls, e2);
            } catch (InstantiationException e3) {
                throw new RuntimeException("Cannot create an instance of " + cls, e3);
            }
        }
    }

    /* compiled from: CloudRepositoryProvider.java */
    /* loaded from: classes2.dex */
    public static class c extends C0014b {
        protected final b.d.b.d.a.b a;

        public c(b.d.b.d.a.b bVar) {
            this.a = bVar;
        }

        @Override // b.d.b.d.b.b.C0014b, b.d.b.d.b.b.a
        @NonNull
        public <T extends a> T create(@NonNull Class<T> cls) {
            if (!a.class.isAssignableFrom(cls)) {
                return (T) super.create(cls);
            }
            try {
                return cls.getConstructor(b.d.b.d.a.b.class).newInstance(this.a);
            } catch (IllegalAccessException e2) {
                throw new RuntimeException("Cannot create an instance of " + cls, e2);
            } catch (InstantiationException e3) {
                throw new RuntimeException("Cannot create an instance of " + cls, e3);
            } catch (NoSuchMethodException e4) {
                throw new RuntimeException("Cannot create an instance of " + cls, e4);
            } catch (InvocationTargetException e5) {
                throw new RuntimeException("Cannot create an instance of " + cls, e5);
            }
        }
    }

    public b(@NonNull a aVar, @NonNull c cVar) {
        this.f91b = aVar;
        this.f92c = cVar;
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
        T t = (T) this.f92c.b(str);
        if (cls.isInstance(t)) {
            return t;
        }
        T t2 = (T) this.f91b.create(cls);
        this.f92c.c(str, t2);
        return t2;
    }
}
