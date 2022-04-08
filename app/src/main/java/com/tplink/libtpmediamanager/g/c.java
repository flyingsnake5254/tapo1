package com.tplink.libtpmediamanager.g;

import androidx.annotation.NonNull;
import com.tplink.libtpappcommonmedia.bean.TPMediaDeviceContext;
import com.tplink.libtpmediastatistics.SSLClient;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/* compiled from: MediaRepositoryProvider.java */
/* loaded from: classes3.dex */
public class c {
    private static final String a = c.class.getSimpleName() + ".DefaultKey";

    /* renamed from: b  reason: collision with root package name */
    private final a f12581b;

    /* renamed from: c  reason: collision with root package name */
    private final e f12582c;

    /* compiled from: MediaRepositoryProvider.java */
    /* loaded from: classes3.dex */
    public interface a {
        @NonNull
        <T extends b> T a(@NonNull TPMediaDeviceContext tPMediaDeviceContext, @NonNull Class<T> cls);
    }

    /* compiled from: MediaRepositoryProvider.java */
    /* loaded from: classes3.dex */
    public static class b implements a {
        @Override // com.tplink.libtpmediamanager.g.c.a
        @NonNull
        public <T extends b> T a(@NonNull TPMediaDeviceContext tPMediaDeviceContext, @NonNull Class<T> cls) {
            try {
                Constructor<T> declaredConstructor = cls.getDeclaredConstructor(tPMediaDeviceContext.getClass());
                declaredConstructor.setAccessible(true);
                T newInstance = declaredConstructor.newInstance(tPMediaDeviceContext);
                newInstance.loadCacheData();
                return newInstance;
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

    public c(@NonNull a aVar, @NonNull e eVar) {
        this.f12581b = aVar;
        this.f12582c = eVar;
    }

    @NonNull
    public <T extends b> T a(@NonNull TPMediaDeviceContext tPMediaDeviceContext, @NonNull Class<T> cls) {
        String canonicalName = cls.getCanonicalName();
        if (canonicalName != null) {
            return (T) b(a + SSLClient.COLON + canonicalName, tPMediaDeviceContext, cls);
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    @NonNull
    public <T extends b> T b(@NonNull String str, @NonNull TPMediaDeviceContext tPMediaDeviceContext, @NonNull Class<T> cls) {
        T t = (T) this.f12582c.b(str);
        if (cls.isInstance(t)) {
            return t;
        }
        T t2 = (T) this.f12581b.a(tPMediaDeviceContext, cls);
        this.f12582c.c(str, t2);
        return t2;
    }
}
