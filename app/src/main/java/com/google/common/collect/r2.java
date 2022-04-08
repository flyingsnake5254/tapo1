package com.google.common.collect;

import com.google.common.collect.u1;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Map;

/* compiled from: Serialization.java */
/* loaded from: classes2.dex */
final class r2 {

    /* compiled from: Serialization.java */
    /* loaded from: classes2.dex */
    static final class b<T> {
        private final Field a;

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a(T t, int i) {
            try {
                this.a.set(t, Integer.valueOf(i));
            } catch (IllegalAccessException e2) {
                throw new AssertionError(e2);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void b(T t, Object obj) {
            try {
                this.a.set(t, obj);
            } catch (IllegalAccessException e2) {
                throw new AssertionError(e2);
            }
        }

        private b(Field field) {
            this.a = field;
            field.setAccessible(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> b<T> a(Class<T> cls, String str) {
        try {
            return new b<>(cls.getDeclaredField(str));
        } catch (NoSuchFieldException e2) {
            throw new AssertionError(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <K, V> void b(Map<K, V> map, ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        c(map, objectInputStream, objectInputStream.readInt());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public static <K, V> void c(Map<K, V> map, ObjectInputStream objectInputStream, int i) throws IOException, ClassNotFoundException {
        for (int i2 = 0; i2 < i; i2++) {
            map.put(objectInputStream.readObject(), objectInputStream.readObject());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <K, V> void d(r1<K, V> r1Var, ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        e(r1Var, objectInputStream, objectInputStream.readInt());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public static <K, V> void e(r1<K, V> r1Var, ObjectInputStream objectInputStream, int i) throws IOException, ClassNotFoundException {
        for (int i2 = 0; i2 < i; i2++) {
            Collection collection = r1Var.get(objectInputStream.readObject());
            int readInt = objectInputStream.readInt();
            for (int i3 = 0; i3 < readInt; i3++) {
                collection.add(objectInputStream.readObject());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <E> void f(u1<E> u1Var, ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        g(u1Var, objectInputStream, objectInputStream.readInt());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public static <E> void g(u1<E> u1Var, ObjectInputStream objectInputStream, int i) throws IOException, ClassNotFoundException {
        for (int i2 = 0; i2 < i; i2++) {
            u1Var.add(objectInputStream.readObject(), objectInputStream.readInt());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int h(ObjectInputStream objectInputStream) throws IOException {
        return objectInputStream.readInt();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <K, V> void i(Map<K, V> map, ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeInt(map.size());
        for (Map.Entry<K, V> entry : map.entrySet()) {
            objectOutputStream.writeObject(entry.getKey());
            objectOutputStream.writeObject(entry.getValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <K, V> void j(r1<K, V> r1Var, ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeInt(r1Var.asMap().size());
        for (Map.Entry<K, Collection<V>> entry : r1Var.asMap().entrySet()) {
            objectOutputStream.writeObject(entry.getKey());
            objectOutputStream.writeInt(entry.getValue().size());
            for (V v : entry.getValue()) {
                objectOutputStream.writeObject(v);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <E> void k(u1<E> u1Var, ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeInt(u1Var.entrySet().size());
        for (u1.a<E> aVar : u1Var.entrySet()) {
            objectOutputStream.writeObject(aVar.a());
            objectOutputStream.writeInt(aVar.getCount());
        }
    }
}
