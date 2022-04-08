package org.bouncycastle.util.test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.Provider;
import java.security.SecureRandom;
import org.bouncycastle.util.f;

/* loaded from: classes4.dex */
public class FixedSecureRandom extends SecureRandom {
    private static final boolean isAndroidStyle;
    private static final boolean isClasspathStyle;
    private static final boolean isRegularStyle;
    private byte[] _data;
    private int _index;
    private static BigInteger REGULAR = new BigInteger("01020304ffffffff0506070811111111", 16);
    private static BigInteger ANDROID = new BigInteger("1111111105060708ffffffff01020304", 16);
    private static BigInteger CLASSPATH = new BigInteger("3020104ffffffff05060708111111", 16);

    /* loaded from: classes4.dex */
    public static class a extends e {
        public a(int i, byte[] bArr) {
            super(FixedSecureRandom.expandToBitLength(i, bArr));
        }

        public a(byte[] bArr) {
            super(bArr);
        }
    }

    /* loaded from: classes4.dex */
    public static class b extends e {
        public b(byte[] bArr) {
            super(bArr);
        }
    }

    /* loaded from: classes4.dex */
    private static class c extends Provider {
        c() {
            super("BCFIPS_FIXED_RNG", 1.0d, "BCFIPS Fixed Secure Random Provider");
        }
    }

    /* loaded from: classes4.dex */
    private static class d extends SecureRandom {

        /* renamed from: c  reason: collision with root package name */
        byte[] f17526c = org.bouncycastle.util.encoders.d.a("01020304ffffffff0506070811111111");

        /* renamed from: d  reason: collision with root package name */
        int f17527d = 0;

        d() {
            super(null, new c());
        }

        @Override // java.security.SecureRandom, java.util.Random
        public void nextBytes(byte[] bArr) {
            System.arraycopy(this.f17526c, this.f17527d, bArr, 0, bArr.length);
            this.f17527d += bArr.length;
        }
    }

    /* loaded from: classes4.dex */
    public static class e {
        byte[] a;

        e(byte[] bArr) {
            this.a = bArr;
        }
    }

    static {
        BigInteger bigInteger = new BigInteger(128, new d());
        BigInteger bigInteger2 = new BigInteger(120, new d());
        isAndroidStyle = bigInteger.equals(ANDROID);
        isRegularStyle = bigInteger.equals(REGULAR);
        isClasspathStyle = bigInteger2.equals(CLASSPATH);
    }

    public FixedSecureRandom(byte[] bArr) {
        this(new e[]{new b(bArr)});
    }

    public FixedSecureRandom(e[] eVarArr) {
        super(null, new c());
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i = 0;
        if (isRegularStyle) {
            if (isClasspathStyle) {
                while (i != eVarArr.length) {
                    try {
                        if (eVarArr[i] instanceof a) {
                            byte[] bArr = eVarArr[i].a;
                            int length = bArr.length - (bArr.length % 4);
                            for (int length2 = (bArr.length - length) - 1; length2 >= 0; length2--) {
                                byteArrayOutputStream.write(bArr[length2]);
                            }
                            for (int length3 = bArr.length - length; length3 < bArr.length; length3 += 4) {
                                byteArrayOutputStream.write(bArr, length3, 4);
                            }
                        } else {
                            byteArrayOutputStream.write(eVarArr[i].a);
                        }
                        i++;
                    } catch (IOException unused) {
                        throw new IllegalArgumentException("can't save value source.");
                    }
                }
            } else {
                while (i != eVarArr.length) {
                    try {
                        byteArrayOutputStream.write(eVarArr[i].a);
                        i++;
                    } catch (IOException unused2) {
                        throw new IllegalArgumentException("can't save value source.");
                    }
                }
            }
        } else if (isAndroidStyle) {
            for (int i2 = 0; i2 != eVarArr.length; i2++) {
                try {
                    if (eVarArr[i2] instanceof a) {
                        byte[] bArr2 = eVarArr[i2].a;
                        int length4 = bArr2.length - (bArr2.length % 4);
                        int i3 = 0;
                        while (i3 < length4) {
                            i3 += 4;
                            byteArrayOutputStream.write(bArr2, bArr2.length - i3, 4);
                        }
                        if (bArr2.length - length4 != 0) {
                            for (int i4 = 0; i4 != 4 - (bArr2.length - length4); i4++) {
                                byteArrayOutputStream.write(0);
                            }
                        }
                        for (int i5 = 0; i5 != bArr2.length - length4; i5++) {
                            byteArrayOutputStream.write(bArr2[length4 + i5]);
                        }
                    } else {
                        byteArrayOutputStream.write(eVarArr[i2].a);
                    }
                } catch (IOException unused3) {
                    throw new IllegalArgumentException("can't save value source.");
                }
            }
        } else {
            throw new IllegalStateException("Unrecognized BigInteger implementation");
        }
        this._data = byteArrayOutputStream.toByteArray();
    }

    public FixedSecureRandom(byte[][] bArr) {
        this(buildDataArray(bArr));
    }

    private static b[] buildDataArray(byte[][] bArr) {
        b[] bVarArr = new b[bArr.length];
        for (int i = 0; i != bArr.length; i++) {
            bVarArr[i] = new b(bArr[i]);
        }
        return bVarArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte[] expandToBitLength(int i, byte[] bArr) {
        int i2;
        int i3;
        int i4 = (i + 7) / 8;
        if (i4 > bArr.length) {
            byte[] bArr2 = new byte[i4];
            System.arraycopy(bArr, 0, bArr2, i4 - bArr.length, bArr.length);
            if (isAndroidStyle && (i3 = i % 8) != 0) {
                f.d(f.a(bArr2, 0) << (8 - i3), bArr2, 0);
            }
            return bArr2;
        }
        if (isAndroidStyle && i < bArr.length * 8 && (i2 = i % 8) != 0) {
            f.d(f.a(bArr, 0) << (8 - i2), bArr, 0);
        }
        return bArr;
    }

    private int nextValue() {
        byte[] bArr = this._data;
        int i = this._index;
        this._index = i + 1;
        return bArr[i] & 255;
    }

    @Override // java.security.SecureRandom
    public byte[] generateSeed(int i) {
        byte[] bArr = new byte[i];
        nextBytes(bArr);
        return bArr;
    }

    public boolean isExhausted() {
        return this._index == this._data.length;
    }

    @Override // java.security.SecureRandom, java.util.Random
    public void nextBytes(byte[] bArr) {
        System.arraycopy(this._data, this._index, bArr, 0, bArr.length);
        this._index += bArr.length;
    }

    @Override // java.util.Random
    public int nextInt() {
        return (nextValue() << 24) | 0 | (nextValue() << 16) | (nextValue() << 8) | nextValue();
    }

    @Override // java.util.Random
    public long nextLong() {
        return (nextValue() << 56) | 0 | (nextValue() << 48) | (nextValue() << 40) | (nextValue() << 32) | (nextValue() << 24) | (nextValue() << 16) | (nextValue() << 8) | nextValue();
    }
}
