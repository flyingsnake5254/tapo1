package org.bouncycastle.pqc.crypto.xmss;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InvalidClassException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamClass;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import org.bouncycastle.crypto.g;

/* loaded from: classes4.dex */
public class u {

    /* loaded from: classes4.dex */
    private static class a extends ObjectInputStream {

        /* renamed from: c  reason: collision with root package name */
        private static final Set f17511c;

        /* renamed from: d  reason: collision with root package name */
        private final Class f17512d;

        /* renamed from: f  reason: collision with root package name */
        private boolean f17513f = false;

        static {
            HashSet hashSet = new HashSet();
            f17511c = hashSet;
            hashSet.add("java.util.TreeMap");
            hashSet.add("java.lang.Integer");
            hashSet.add("java.lang.Number");
            hashSet.add("org.bouncycastle.pqc.crypto.xmss.BDS");
            hashSet.add("java.util.ArrayList");
            hashSet.add("org.bouncycastle.pqc.crypto.xmss.XMSSNode");
            hashSet.add("[B");
            hashSet.add("java.util.LinkedList");
            hashSet.add("java.util.Stack");
            hashSet.add("java.util.Vector");
            hashSet.add("[Ljava.lang.Object;");
            hashSet.add("org.bouncycastle.pqc.crypto.xmss.BDSTreeHash");
        }

        a(Class cls, InputStream inputStream) throws IOException {
            super(inputStream);
            this.f17512d = cls;
        }

        @Override // java.io.ObjectInputStream
        protected Class<?> resolveClass(ObjectStreamClass objectStreamClass) throws IOException, ClassNotFoundException {
            if (!this.f17513f) {
                if (objectStreamClass.getName().equals(this.f17512d.getName())) {
                    this.f17513f = true;
                } else {
                    throw new InvalidClassException("unexpected class: ", objectStreamClass.getName());
                }
            } else if (!f17511c.contains(objectStreamClass.getName())) {
                throw new InvalidClassException("unexpected class: ", objectStreamClass.getName());
            }
            return super.resolveClass(objectStreamClass);
        }
    }

    public static long a(byte[] bArr, int i, int i2) {
        Objects.requireNonNull(bArr, "in == null");
        long j = 0;
        for (int i3 = i; i3 < i + i2; i3++) {
            j = (j << 8) | (bArr[i3] & 255);
        }
        return j;
    }

    public static int b(int i, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            if (((i >> i3) & 1) == 0) {
                return i3;
            }
        }
        return 0;
    }

    public static byte[] c(byte[] bArr) {
        Objects.requireNonNull(bArr, "in == null");
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    public static byte[][] d(byte[][] bArr) {
        if (!k(bArr)) {
            byte[][] bArr2 = new byte[bArr.length];
            for (int i = 0; i < bArr.length; i++) {
                bArr2[i] = new byte[bArr[i].length];
                System.arraycopy(bArr[i], 0, bArr2[i], 0, bArr[i].length);
            }
            return bArr2;
        }
        throw new NullPointerException("in has null pointers");
    }

    public static void e(byte[] bArr, byte[] bArr2, int i) {
        Objects.requireNonNull(bArr, "dst == null");
        Objects.requireNonNull(bArr2, "src == null");
        if (i < 0) {
            throw new IllegalArgumentException("offset hast to be >= 0");
        } else if (bArr2.length + i <= bArr.length) {
            for (int i2 = 0; i2 < bArr2.length; i2++) {
                bArr[i + i2] = bArr2[i2];
            }
        } else {
            throw new IllegalArgumentException("src length + offset must not be greater than size of destination");
        }
    }

    public static Object f(byte[] bArr, Class cls) throws IOException, ClassNotFoundException {
        a aVar = new a(cls, new ByteArrayInputStream(bArr));
        Object readObject = aVar.readObject();
        if (aVar.available() != 0) {
            throw new IOException("unexpected data found at end of ObjectInputStream");
        } else if (cls.isInstance(readObject)) {
            return readObject;
        } else {
            throw new IOException("unexpected class found in ObjectInputStream");
        }
    }

    public static byte[] g(byte[] bArr, int i, int i2) {
        Objects.requireNonNull(bArr, "src == null");
        if (i < 0) {
            throw new IllegalArgumentException("offset hast to be >= 0");
        } else if (i2 < 0) {
            throw new IllegalArgumentException("length hast to be >= 0");
        } else if (i + i2 <= bArr.length) {
            byte[] bArr2 = new byte[i2];
            for (int i3 = 0; i3 < i2; i3++) {
                bArr2[i3] = bArr[i + i3];
            }
            return bArr2;
        } else {
            throw new IllegalArgumentException("offset + length must not be greater then size of source array");
        }
    }

    public static int h(g gVar) {
        Objects.requireNonNull(gVar, "digest == null");
        String b2 = gVar.b();
        if (b2.equals("SHAKE128")) {
            return 32;
        }
        if (b2.equals("SHAKE256")) {
            return 64;
        }
        return gVar.e();
    }

    public static int i(long j, int i) {
        return (int) (j & ((1 << i) - 1));
    }

    public static long j(long j, int i) {
        return j >> i;
    }

    public static boolean k(byte[][] bArr) {
        if (bArr == null) {
            return true;
        }
        for (byte[] bArr2 : bArr) {
            if (bArr2 == null) {
                return true;
            }
        }
        return false;
    }

    public static boolean l(int i, long j) {
        if (j >= 0) {
            return j < (1 << i);
        }
        throw new IllegalStateException("index must not be negative");
    }

    public static boolean m(long j, int i, int i2) {
        return j != 0 && (j + 1) % ((long) Math.pow((double) (1 << i), (double) i2)) == 0;
    }

    public static int n(int i) {
        int i2 = 0;
        while (true) {
            i >>= 1;
            if (i == 0) {
                return i2;
            }
            i2++;
        }
    }

    public static byte[] o(Object obj) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(obj);
        objectOutputStream.flush();
        return byteArrayOutputStream.toByteArray();
    }

    public static byte[] p(long j, int i) {
        byte[] bArr = new byte[i];
        for (int i2 = i - 1; i2 >= 0; i2--) {
            bArr[i2] = (byte) j;
            j >>>= 8;
        }
        return bArr;
    }
}
