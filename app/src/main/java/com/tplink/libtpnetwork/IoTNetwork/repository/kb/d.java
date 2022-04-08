package com.tplink.libtpnetwork.IoTNetwork.repository.kb;

import androidx.annotation.NonNull;
import com.tplink.libtpmediastatistics.SSLClient;
import com.tplink.libtpnetwork.cameranetwork.TPBaseDeviceContext;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/* compiled from: IoTDeviceRepositoryProvider.java */
/* loaded from: classes3.dex */
public class d {
    private static final String a = d.class.getSimpleName() + ".DefaultKey";

    /* renamed from: b  reason: collision with root package name */
    private final a f13335b;

    /* renamed from: c  reason: collision with root package name */
    private final f f13336c;

    /* compiled from: IoTDeviceRepositoryProvider.java */
    /* loaded from: classes3.dex */
    public interface a {
        @NonNull
        <T extends c> T a(@NonNull TPBaseDeviceContext tPBaseDeviceContext, @NonNull Class<T> cls);
    }

    /* compiled from: IoTDeviceRepositoryProvider.java */
    /* loaded from: classes3.dex */
    public static class b implements a {
        @Override // com.tplink.libtpnetwork.IoTNetwork.repository.kb.d.a
        @NonNull
        public <T extends c> T a(@NonNull TPBaseDeviceContext tPBaseDeviceContext, @NonNull Class<T> cls) {
            try {
                Constructor<T> declaredConstructor = cls.getDeclaredConstructor(tPBaseDeviceContext.getClass());
                declaredConstructor.setAccessible(true);
                T newInstance = declaredConstructor.newInstance(tPBaseDeviceContext);
                newInstance.c();
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

    public d(@NonNull a aVar, @NonNull f fVar) {
        this.f13335b = aVar;
        this.f13336c = fVar;
    }

    @NonNull
    public <T extends c> T a(@NonNull TPBaseDeviceContext tPBaseDeviceContext, @NonNull Class<T> cls) {
        String canonicalName = cls.getCanonicalName();
        if (canonicalName != null) {
            return (T) b(a + SSLClient.COLON + canonicalName, tPBaseDeviceContext, cls);
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    @NonNull
    public <T extends c> T b(@NonNull String str, @NonNull TPBaseDeviceContext tPBaseDeviceContext, @NonNull Class<T> cls) {
        T t = (T) this.f13336c.b(str);
        if (cls.isInstance(t)) {
            return t;
        }
        T t2 = (T) this.f13335b.a(tPBaseDeviceContext, cls);
        this.f13336c.c(str, t2);
        return t2;
    }
}
