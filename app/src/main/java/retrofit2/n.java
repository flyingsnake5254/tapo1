package retrofit2;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;
import retrofit2.c;
import retrofit2.f;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Platform.java */
/* loaded from: classes4.dex */
public class n {
    private static final n a = e();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Platform.java */
    /* loaded from: classes4.dex */
    public static class a extends n {

        /* compiled from: Platform.java */
        /* renamed from: retrofit2.n$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        static class ExecutorC0350a implements Executor {

            /* renamed from: c  reason: collision with root package name */
            private final Handler f17640c = new Handler(Looper.getMainLooper());

            ExecutorC0350a() {
            }

            @Override // java.util.concurrent.Executor
            public void execute(Runnable runnable) {
                this.f17640c.post(runnable);
            }
        }

        a() {
        }

        @Override // retrofit2.n
        List<? extends c.a> a(@Nullable Executor executor) {
            if (executor != null) {
                g gVar = new g(executor);
                return Build.VERSION.SDK_INT >= 24 ? Arrays.asList(e.a, gVar) : Collections.singletonList(gVar);
            }
            throw new AssertionError();
        }

        @Override // retrofit2.n
        public Executor b() {
            return new ExecutorC0350a();
        }

        @Override // retrofit2.n
        List<? extends f.a> c() {
            if (Build.VERSION.SDK_INT >= 24) {
                return Collections.singletonList(l.a);
            }
            return Collections.emptyList();
        }

        @Override // retrofit2.n
        int d() {
            return Build.VERSION.SDK_INT >= 24 ? 1 : 0;
        }

        @Override // retrofit2.n
        @IgnoreJRERequirement
        boolean h(Method method) {
            if (Build.VERSION.SDK_INT < 24) {
                return false;
            }
            return method.isDefault();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Platform.java */
    @IgnoreJRERequirement
    /* loaded from: classes4.dex */
    public static class b extends n {
        b() {
        }

        @Override // retrofit2.n
        List<? extends c.a> a(@Nullable Executor executor) {
            ArrayList arrayList = new ArrayList(2);
            arrayList.add(e.a);
            arrayList.add(new g(executor));
            return Collections.unmodifiableList(arrayList);
        }

        @Override // retrofit2.n
        List<? extends f.a> c() {
            return Collections.singletonList(l.a);
        }

        @Override // retrofit2.n
        int d() {
            return 1;
        }

        @Override // retrofit2.n
        Object g(Method method, Class<?> cls, Object obj, @Nullable Object... objArr) throws Throwable {
            Constructor declaredConstructor = MethodHandles.Lookup.class.getDeclaredConstructor(Class.class, Integer.TYPE);
            declaredConstructor.setAccessible(true);
            return ((MethodHandles.Lookup) declaredConstructor.newInstance(cls, -1)).unreflectSpecial(method, cls).bindTo(obj).invokeWithArguments(objArr);
        }

        @Override // retrofit2.n
        boolean h(Method method) {
            return method.isDefault();
        }
    }

    n() {
    }

    private static n e() {
        try {
            Class.forName("android.os.Build");
            if (Build.VERSION.SDK_INT != 0) {
                return new a();
            }
        } catch (ClassNotFoundException unused) {
        }
        try {
            Class.forName("java.util.Optional");
            return new b();
        } catch (ClassNotFoundException unused2) {
            return new n();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static n f() {
        return a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<? extends c.a> a(@Nullable Executor executor) {
        return Collections.singletonList(new g(executor));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public Executor b() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<? extends f.a> c() {
        return Collections.emptyList();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int d() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public Object g(Method method, Class<?> cls, Object obj, @Nullable Object... objArr) throws Throwable {
        throw new UnsupportedOperationException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean h(Method method) {
        return false;
    }
}
