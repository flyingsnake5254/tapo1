package com.tplink.iot.adapter.databinding;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.databinding.Observable;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.jvm.internal.j;

/* compiled from: Utils.kt */
/* loaded from: classes2.dex */
public final class g {
    public static final <T extends Parcelable> T a(T obj) {
        j.e(obj, "obj");
        Parcel obtain = Parcel.obtain();
        j.d(obtain, "Parcel.obtain()");
        obtain.writeParcelable(obj, 0);
        obtain.setDataPosition(0);
        T t = (T) obtain.readParcelable(obj.getClass().getClassLoader());
        obtain.recycle();
        return t;
    }

    public static final <T extends Serializable> T b(T obj) {
        Exception e2;
        ObjectInputStream objectInputStream;
        Object readObject;
        j.e(obj, "obj");
        T t = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(obj);
            objectOutputStream.close();
            objectInputStream = new ObjectInputStream(new ByteArrayInputStream(byteArrayOutputStream.toByteArray()));
            readObject = objectInputStream.readObject();
        } catch (Exception e3) {
            e2 = e3;
        }
        if (readObject != null) {
            t = (T) ((Serializable) readObject);
            try {
                objectInputStream.close();
            } catch (Exception e4) {
                e2 = e4;
                e2.printStackTrace();
                return t;
            }
            return t;
        }
        throw new NullPointerException("null cannot be cast to non-null type T");
    }

    public static final Object c(Object obj, int i) {
        if (obj != null) {
            if (obj instanceof Object[]) {
                Object[] objArr = (Object[]) obj;
                if (!(objArr.length == 0)) {
                    if (i >= objArr.length) {
                        i = objArr.length - 1;
                    }
                    return objArr[i];
                }
            } else if (obj instanceof List) {
                List list = (List) obj;
                if (!list.isEmpty()) {
                    if (i >= list.size()) {
                        i = list.size() - 1;
                    }
                    return list.get(i);
                }
            } else if (!obj.getClass().isArray()) {
                return obj;
            } else {
                int length = Array.getLength(obj);
                if (length != 0) {
                    if (i >= length) {
                        i = length - 1;
                    }
                    return Array.get(obj, i);
                }
            }
        }
        return null;
    }

    public static final int d(Object obj) {
        if (obj == null) {
            return 0;
        }
        if (obj instanceof Object[]) {
            return ((Object[]) obj).length;
        }
        if (obj instanceof List) {
            return ((List) obj).size();
        }
        if (obj.getClass().isArray()) {
            return Array.getLength(obj);
        }
        return 1;
    }

    public static final Object e(Object obj) {
        return obj instanceof Observable ? obj : obj instanceof c ? ((c) obj).a() : obj instanceof Serializable ? b((Serializable) obj) : obj instanceof Parcelable ? a((Parcelable) obj) : obj;
    }

    public static final void f(Object obj, ArrayList<Object> des) {
        Class<?> cls;
        j.e(des, "des");
        if (obj == null) {
            des.add(null);
            return;
        }
        if ((obj instanceof List) || (obj instanceof Object[]) || obj.getClass().isArray()) {
            int d2 = d(obj);
            for (int i = 0; i < d2; i++) {
                Object c2 = c(obj, i);
                if ((c2 instanceof List) || (c2 instanceof Object[]) || !(c2 == null || (cls = c2.getClass()) == null || !cls.isArray())) {
                    if (des.size() <= i) {
                        ArrayList arrayList = new ArrayList();
                        des.add(arrayList);
                        f(c2, arrayList);
                    } else if (!j.a(c2, des.get(i))) {
                        Object obj2 = des.get(i);
                        Objects.requireNonNull(obj2, "null cannot be cast to non-null type kotlin.collections.ArrayList<kotlin.Any?> /* = java.util.ArrayList<kotlin.Any?> */");
                        f(c2, (ArrayList) obj2);
                    }
                } else if (des.size() <= i) {
                    des.add(e(c2));
                } else if (!j.a(c2, des.get(i))) {
                    des.set(i, e(c2));
                }
            }
            int size = des.size() - 1;
            if (size >= d2) {
                while (true) {
                    des.remove(size);
                    if (size != d2) {
                        size--;
                    } else {
                        return;
                    }
                }
            }
        } else if (des.size() == 0) {
            des.add(e(obj));
        } else if (!j.a(des.get(0), obj)) {
            des.set(0, e(obj));
        }
    }
}
