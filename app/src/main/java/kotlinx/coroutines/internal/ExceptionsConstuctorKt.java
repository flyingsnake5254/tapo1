package kotlinx.coroutines.internal;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Comparator;
import java.util.List;
import java.util.WeakHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Result;
import kotlin.collections.i;
import kotlin.jvm.b.l;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import kotlin.k;
import kotlin.p;
import kotlinx.coroutines.w;

/* compiled from: ExceptionsConstuctor.kt */
/* loaded from: classes4.dex */
public final class ExceptionsConstuctorKt {
    private static final int a = d(Throwable.class, -1);

    /* renamed from: b  reason: collision with root package name */
    private static final ReentrantReadWriteLock f16465b = new ReentrantReadWriteLock();

    /* renamed from: c  reason: collision with root package name */
    private static final WeakHashMap<Class<? extends Throwable>, l<Throwable, Throwable>> f16466c = new WeakHashMap<>();

    /* compiled from: Comparisons.kt */
    /* loaded from: classes4.dex */
    public static final class a<T> implements Comparator<T> {
        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            int a;
            Constructor it = (Constructor) t2;
            j.b(it, "it");
            Integer valueOf = Integer.valueOf(it.getParameterTypes().length);
            Constructor it2 = (Constructor) t;
            j.b(it2, "it");
            a = kotlin.q.b.a(valueOf, Integer.valueOf(it2.getParameterTypes().length));
            return a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ExceptionsConstuctor.kt */
    /* loaded from: classes4.dex */
    public static final class b extends Lambda implements l {

        /* renamed from: c  reason: collision with root package name */
        public static final b f16467c = new b();

        b() {
            super(1);
        }

        /* renamed from: a */
        public final Void invoke(Throwable it) {
            j.f(it, "it");
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ExceptionsConstuctor.kt */
    /* loaded from: classes4.dex */
    public static final class c extends Lambda implements l {

        /* renamed from: c  reason: collision with root package name */
        public static final c f16468c = new c();

        c() {
            super(1);
        }

        /* renamed from: a */
        public final Void invoke(Throwable it) {
            j.f(it, "it");
            return null;
        }
    }

    private static final l<Throwable, Throwable> a(Constructor<?> constructor) {
        Class<?>[] parameterTypes = constructor.getParameterTypes();
        int length = parameterTypes.length;
        if (length == 0) {
            return new ExceptionsConstuctorKt$createConstructor$$inlined$safeCtor$4(constructor);
        }
        if (length == 1) {
            Class<?> cls = parameterTypes[0];
            if (j.a(cls, Throwable.class)) {
                return new ExceptionsConstuctorKt$createConstructor$$inlined$safeCtor$2(constructor);
            }
            if (j.a(cls, String.class)) {
                return new ExceptionsConstuctorKt$createConstructor$$inlined$safeCtor$3(constructor);
            }
            return null;
        } else if (length == 2 && j.a(parameterTypes[0], String.class) && j.a(parameterTypes[1], Throwable.class)) {
            return new ExceptionsConstuctorKt$createConstructor$$inlined$safeCtor$1(constructor);
        } else {
            return null;
        }
    }

    private static final int b(Class<?> cls, int i) {
        do {
            Field[] declaredFields = cls.getDeclaredFields();
            j.b(declaredFields, "declaredFields");
            int i2 = 0;
            for (Field it : declaredFields) {
                j.b(it, "it");
                if (!Modifier.isStatic(it.getModifiers())) {
                    i2++;
                }
            }
            i += i2;
            cls = cls.getSuperclass();
        } while (cls != null);
        return i;
    }

    static /* synthetic */ int c(Class cls, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        return b(cls, i);
    }

    private static final int d(Class<?> cls, int i) {
        Object obj;
        kotlin.jvm.a.c(cls);
        try {
            Result.a aVar = Result.Companion;
            obj = Result.m1constructorimpl(Integer.valueOf(c(cls, 0, 1, null)));
        } catch (Throwable th) {
            Result.a aVar2 = Result.Companion;
            obj = Result.m1constructorimpl(k.a(th));
        }
        obj = Integer.valueOf(i);
        if (Result.m7isFailureimpl(obj)) {
        }
        return ((Number) obj).intValue();
    }

    public static final <E extends Throwable> E e(E exception) {
        Object obj;
        List<Constructor> v;
        j.f(exception, "exception");
        Object obj2 = null;
        if (exception instanceof w) {
            try {
                Result.a aVar = Result.Companion;
                obj = Result.m1constructorimpl(((w) exception).createCopy());
            } catch (Throwable th) {
                Result.a aVar2 = Result.Companion;
                obj = Result.m1constructorimpl(k.a(th));
            }
            if (!Result.m7isFailureimpl(obj)) {
                obj2 = obj;
            }
            return (E) ((Throwable) obj2);
        }
        ReentrantReadWriteLock reentrantReadWriteLock = f16465b;
        ReentrantReadWriteLock.ReadLock readLock = reentrantReadWriteLock.readLock();
        readLock.lock();
        try {
            l<Throwable, Throwable> lVar = f16466c.get(exception.getClass());
            if (lVar != null) {
                return (E) lVar.invoke(exception);
            }
            int i = 0;
            if (a != d(exception.getClass(), 0)) {
                ReentrantReadWriteLock.ReadLock readLock2 = reentrantReadWriteLock.readLock();
                int readHoldCount = reentrantReadWriteLock.getWriteHoldCount() == 0 ? reentrantReadWriteLock.getReadHoldCount() : 0;
                for (int i2 = 0; i2 < readHoldCount; i2++) {
                    readLock2.unlock();
                }
                ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();
                writeLock.lock();
                try {
                    f16466c.put(exception.getClass(), b.f16467c);
                    p pVar = p.a;
                    return null;
                } finally {
                    while (i < readHoldCount) {
                        readLock2.lock();
                        i++;
                    }
                    writeLock.unlock();
                }
            } else {
                Constructor<?>[] constructors = exception.getClass().getConstructors();
                j.b(constructors, "exception.javaClass.constructors");
                v = i.v(constructors, new a());
                l<Throwable, Throwable> lVar2 = null;
                for (Constructor constructor : v) {
                    j.b(constructor, "constructor");
                    lVar2 = a(constructor);
                    if (lVar2 != null) {
                        break;
                    }
                }
                ReentrantReadWriteLock reentrantReadWriteLock2 = f16465b;
                ReentrantReadWriteLock.ReadLock readLock3 = reentrantReadWriteLock2.readLock();
                int readHoldCount2 = reentrantReadWriteLock2.getWriteHoldCount() == 0 ? reentrantReadWriteLock2.getReadHoldCount() : 0;
                for (int i3 = 0; i3 < readHoldCount2; i3++) {
                    readLock3.unlock();
                }
                ReentrantReadWriteLock.WriteLock writeLock2 = reentrantReadWriteLock2.writeLock();
                writeLock2.lock();
                try {
                    f16466c.put(exception.getClass(), lVar2 != null ? lVar2 : c.f16468c);
                    p pVar2 = p.a;
                    while (i < readHoldCount2) {
                        readLock3.lock();
                        i++;
                    }
                    writeLock2.unlock();
                    if (lVar2 != null) {
                        return (E) lVar2.invoke(exception);
                    }
                    return null;
                } finally {
                    while (i < readHoldCount2) {
                        readLock3.lock();
                        i++;
                    }
                    writeLock2.unlock();
                }
            }
        } finally {
            readLock.unlock();
        }
    }
}
