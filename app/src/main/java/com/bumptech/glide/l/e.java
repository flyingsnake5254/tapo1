package com.bumptech.glide.l;

import android.graphics.Bitmap;
import android.util.Log;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentTransaction;
import com.bumptech.glide.l.a;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Iterator;

/* compiled from: StandardGifDecoder.java */
/* loaded from: classes.dex */
public class e implements a {
    private static final String a = "e";
    @ColorInt

    /* renamed from: b  reason: collision with root package name */
    private int[] f1340b;
    @ColorInt

    /* renamed from: c  reason: collision with root package name */
    private final int[] f1341c;

    /* renamed from: d  reason: collision with root package name */
    private final a.AbstractC0042a f1342d;

    /* renamed from: e  reason: collision with root package name */
    private ByteBuffer f1343e;

    /* renamed from: f  reason: collision with root package name */
    private byte[] f1344f;
    private short[] g;
    private byte[] h;
    private byte[] i;
    private byte[] j;
    @ColorInt
    private int[] k;
    private int l;
    private c m;
    private Bitmap n;
    private boolean o;
    private int p;
    private int q;
    private int r;
    private int s;
    @Nullable
    private Boolean t;
    @NonNull
    private Bitmap.Config u;

    public e(@NonNull a.AbstractC0042a aVar, c cVar, ByteBuffer byteBuffer, int i) {
        this(aVar);
        q(cVar, byteBuffer, i);
    }

    @ColorInt
    private int i(int i, int i2, int i3) {
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        for (int i9 = i; i9 < this.q + i; i9++) {
            byte[] bArr = this.j;
            if (i9 >= bArr.length || i9 >= i2) {
                break;
            }
            int i10 = this.f1340b[bArr[i9] & 255];
            if (i10 != 0) {
                i4 += (i10 >> 24) & 255;
                i5 += (i10 >> 16) & 255;
                i6 += (i10 >> 8) & 255;
                i7 += i10 & 255;
                i8++;
            }
        }
        int i11 = i + i3;
        for (int i12 = i11; i12 < this.q + i11; i12++) {
            byte[] bArr2 = this.j;
            if (i12 >= bArr2.length || i12 >= i2) {
                break;
            }
            int i13 = this.f1340b[bArr2[i12] & 255];
            if (i13 != 0) {
                i4 += (i13 >> 24) & 255;
                i5 += (i13 >> 16) & 255;
                i6 += (i13 >> 8) & 255;
                i7 += i13 & 255;
                i8++;
            }
        }
        if (i8 == 0) {
            return 0;
        }
        return ((i4 / i8) << 24) | ((i5 / i8) << 16) | ((i6 / i8) << 8) | (i7 / i8);
    }

    private void j(b bVar) {
        int i;
        int[] iArr = this.k;
        int i2 = bVar.f1329d;
        int i3 = this.q;
        int i4 = i2 / i3;
        int i5 = bVar.f1327b / i3;
        int i6 = bVar.f1328c / i3;
        int i7 = bVar.a / i3;
        boolean z = this.l == 0;
        int i8 = this.s;
        int i9 = this.r;
        byte[] bArr = this.j;
        int[] iArr2 = this.f1340b;
        Boolean bool = this.t;
        int i10 = 8;
        int i11 = 0;
        int i12 = 1;
        for (int i13 = 0; i13 < i4; i13++) {
            bool = bool;
            if (bVar.f1330e) {
                if (i11 >= i4) {
                    i4 = i4;
                    int i14 = i12 + 1;
                    if (i14 == 2) {
                        i12 = i14;
                        i11 = 4;
                    } else if (i14 == 3) {
                        i12 = i14;
                        i11 = 2;
                        i10 = 4;
                    } else if (i14 != 4) {
                        i12 = i14;
                    } else {
                        i12 = i14;
                        i11 = 1;
                        i10 = 2;
                    }
                } else {
                    i4 = i4;
                }
                i = i11 + i10;
            } else {
                i4 = i4;
                i = i11;
                i11 = i13;
            }
            int i15 = i11 + i5;
            boolean z2 = i3 == 1;
            if (i15 < i9) {
                int i16 = i15 * i8;
                int i17 = i16 + i7;
                int i18 = i17 + i6;
                int i19 = i16 + i8;
                if (i19 < i18) {
                    i18 = i19;
                }
                i11 = i;
                int i20 = i13 * i3 * bVar.f1328c;
                if (z2) {
                    int i21 = i17;
                    while (i21 < i18) {
                        int i22 = iArr2[bArr[i20] & 255];
                        if (i22 != 0) {
                            iArr[i21] = i22;
                        } else if (z && bool == null) {
                            bool = Boolean.TRUE;
                        }
                        i20 += i3;
                        i21++;
                        i5 = i5;
                    }
                } else {
                    i5 = i5;
                    int i23 = ((i18 - i17) * i3) + i20;
                    int i24 = i17;
                    while (i24 < i18) {
                        int i25 = i(i20, i23, bVar.f1328c);
                        if (i25 != 0) {
                            iArr[i24] = i25;
                        } else if (z && bool == null) {
                            bool = Boolean.TRUE;
                        }
                        i20 += i3;
                        i24++;
                        i6 = i6;
                    }
                }
            } else {
                i11 = i;
            }
            i6 = i6;
        }
        if (this.t == null) {
            this.t = Boolean.valueOf(bool == null ? false : bool.booleanValue());
        }
    }

    private void k(b bVar) {
        b bVar2 = bVar;
        int[] iArr = this.k;
        int i = bVar2.f1329d;
        int i2 = bVar2.f1327b;
        int i3 = bVar2.f1328c;
        int i4 = bVar2.a;
        boolean z = this.l == 0;
        int i5 = this.s;
        byte[] bArr = this.j;
        int[] iArr2 = this.f1340b;
        int i6 = 0;
        byte b2 = -1;
        while (i6 < i) {
            int i7 = (i6 + i2) * i5;
            int i8 = i7 + i4;
            int i9 = i8 + i3;
            int i10 = i7 + i5;
            if (i10 < i9) {
                i9 = i10;
            }
            int i11 = bVar2.f1328c * i6;
            int i12 = i8;
            while (i12 < i9) {
                byte b3 = bArr[i11];
                int i13 = b3 & 255;
                if (i13 != b2) {
                    int i14 = iArr2[i13];
                    if (i14 != 0) {
                        iArr[i12] = i14;
                    } else {
                        b2 = b3;
                    }
                }
                i11++;
                i12++;
                i = i;
            }
            i6++;
            bVar2 = bVar;
        }
        Boolean bool = this.t;
        this.t = Boolean.valueOf((bool != null && bool.booleanValue()) || (this.t == null && z && b2 != -1));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void l(b bVar) {
        int i;
        int i2;
        short s;
        e eVar = this;
        if (bVar != null) {
            eVar.f1343e.position(bVar.j);
        }
        if (bVar == null) {
            c cVar = eVar.m;
            i = cVar.f1336f;
            i2 = cVar.g;
        } else {
            i = bVar.f1328c;
            i2 = bVar.f1329d;
        }
        int i3 = i * i2;
        byte[] bArr = eVar.j;
        if (bArr == null || bArr.length < i3) {
            eVar.j = eVar.f1342d.b(i3);
        }
        byte[] bArr2 = eVar.j;
        if (eVar.g == null) {
            eVar.g = new short[4096];
        }
        short[] sArr = eVar.g;
        if (eVar.h == null) {
            eVar.h = new byte[4096];
        }
        byte[] bArr3 = eVar.h;
        if (eVar.i == null) {
            eVar.i = new byte[FragmentTransaction.TRANSIT_FRAGMENT_OPEN];
        }
        byte[] bArr4 = eVar.i;
        int p = p();
        int i4 = 1 << p;
        int i5 = i4 + 1;
        int i6 = i4 + 2;
        int i7 = p + 1;
        int i8 = (1 << i7) - 1;
        int i9 = 0;
        for (int i10 = 0; i10 < i4; i10++) {
            sArr[i10] = 0;
            bArr3[i10] = (byte) i10;
        }
        byte[] bArr5 = eVar.f1344f;
        int i11 = i7;
        int i12 = i6;
        int i13 = i8;
        int i14 = 0;
        int i15 = 0;
        int i16 = 0;
        int i17 = 0;
        int i18 = 0;
        int i19 = -1;
        int i20 = 0;
        int i21 = 0;
        while (true) {
            if (i9 >= i3) {
                break;
            }
            if (i14 == 0) {
                i14 = o();
                if (i14 <= 0) {
                    eVar.p = 3;
                    break;
                }
                i15 = 0;
            }
            i17 += (bArr5[i15] & 255) << i16;
            int i22 = i16 + 8;
            i15++;
            i14--;
            while (true) {
                if (i22 < i11) {
                    i19 = i19;
                    i12 = i12;
                    i16 = i22;
                    eVar = this;
                    i20 = i20;
                    i7 = i7;
                    i11 = i11;
                    break;
                }
                int i23 = i17 & i13;
                i17 >>= i11;
                i22 -= i11;
                if (i23 == i4) {
                    i13 = i8;
                    i11 = i7;
                    i12 = i6;
                    i6 = i12;
                    i19 = -1;
                } else if (i23 == i5) {
                    i16 = i22;
                    i20 = i20;
                    i12 = i12;
                    i7 = i7;
                    i6 = i6;
                    i19 = i19;
                    i11 = i11;
                    eVar = this;
                    break;
                } else if (i19 == -1) {
                    bArr2[i18] = bArr3[i23];
                    i18++;
                    i9++;
                    i19 = i23;
                    i20 = i19;
                    i6 = i6;
                    i22 = i22;
                } else {
                    if (i23 >= i12) {
                        bArr4[i21] = (byte) i20;
                        i21++;
                        s = i19;
                    } else {
                        s = i23;
                    }
                    while (s >= i4) {
                        bArr4[i21] = bArr3[s];
                        i21++;
                        s = sArr[s];
                    }
                    i20 = bArr3[s] & 255;
                    byte b2 = (byte) i20;
                    bArr2[i18] = b2;
                    while (true) {
                        i18++;
                        i9++;
                        if (i21 <= 0) {
                            break;
                        }
                        i21--;
                        bArr2[i18] = bArr4[i21];
                    }
                    if (i12 < 4096) {
                        sArr[i12] = (short) i19;
                        bArr3[i12] = b2;
                        i12++;
                        if ((i12 & i13) == 0 && i12 < 4096) {
                            i11++;
                            i13 += i12;
                        }
                    }
                    i19 = i23;
                    i6 = i6;
                    i22 = i22;
                    bArr4 = bArr4;
                }
            }
        }
        Arrays.fill(bArr2, i18, i3, (byte) 0);
    }

    private Bitmap n() {
        Boolean bool = this.t;
        Bitmap c2 = this.f1342d.c(this.s, this.r, (bool == null || bool.booleanValue()) ? Bitmap.Config.ARGB_8888 : this.u);
        c2.setHasAlpha(true);
        return c2;
    }

    private int o() {
        int p = p();
        if (p <= 0) {
            return p;
        }
        ByteBuffer byteBuffer = this.f1343e;
        byteBuffer.get(this.f1344f, 0, Math.min(p, byteBuffer.remaining()));
        return p;
    }

    private int p() {
        return this.f1343e.get() & 255;
    }

    private Bitmap r(b bVar, b bVar2) {
        int i;
        int i2;
        Bitmap bitmap;
        int[] iArr = this.k;
        int i3 = 0;
        if (bVar2 == null) {
            Bitmap bitmap2 = this.n;
            if (bitmap2 != null) {
                this.f1342d.a(bitmap2);
            }
            this.n = null;
            Arrays.fill(iArr, 0);
        }
        if (bVar2 != null && bVar2.g == 3 && this.n == null) {
            Arrays.fill(iArr, 0);
        }
        if (bVar2 != null && (i2 = bVar2.g) > 0) {
            if (i2 == 2) {
                if (!bVar.f1331f) {
                    c cVar = this.m;
                    i3 = cVar.l;
                    if (bVar.k == null || cVar.j != bVar.h) {
                    }
                }
                int i4 = bVar2.f1329d;
                int i5 = this.q;
                int i6 = i4 / i5;
                int i7 = bVar2.f1327b / i5;
                int i8 = bVar2.f1328c / i5;
                int i9 = bVar2.a / i5;
                int i10 = this.s;
                int i11 = (i7 * i10) + i9;
                int i12 = (i6 * i10) + i11;
                while (i11 < i12) {
                    int i13 = i11 + i8;
                    for (int i14 = i11; i14 < i13; i14++) {
                        iArr[i14] = i3;
                    }
                    i11 += this.s;
                }
            } else if (i2 == 3 && (bitmap = this.n) != null) {
                int i15 = this.s;
                bitmap.getPixels(iArr, 0, i15, 0, 0, i15, this.r);
            }
        }
        l(bVar);
        if (bVar.f1330e || this.q != 1) {
            j(bVar);
        } else {
            k(bVar);
        }
        if (this.o && ((i = bVar.g) == 0 || i == 1)) {
            if (this.n == null) {
                this.n = n();
            }
            Bitmap bitmap3 = this.n;
            int i16 = this.s;
            bitmap3.setPixels(iArr, 0, i16, 0, 0, i16, this.r);
        }
        Bitmap n = n();
        int i17 = this.s;
        n.setPixels(iArr, 0, i17, 0, 0, i17, this.r);
        return n;
    }

    @Override // com.bumptech.glide.l.a
    @Nullable
    public synchronized Bitmap a() {
        if (this.m.f1333c <= 0 || this.l < 0) {
            String str = a;
            if (Log.isLoggable(str, 3)) {
                Log.d(str, "Unable to decode frame, frameCount=" + this.m.f1333c + ", framePointer=" + this.l);
            }
            this.p = 1;
        }
        int i = this.p;
        if (!(i == 1 || i == 2)) {
            this.p = 0;
            if (this.f1344f == null) {
                this.f1344f = this.f1342d.b(255);
            }
            b bVar = this.m.f1335e.get(this.l);
            int i2 = this.l - 1;
            b bVar2 = i2 >= 0 ? this.m.f1335e.get(i2) : null;
            int[] iArr = bVar.k;
            if (iArr == null) {
                iArr = this.m.a;
            }
            this.f1340b = iArr;
            if (iArr == null) {
                String str2 = a;
                if (Log.isLoggable(str2, 3)) {
                    Log.d(str2, "No valid color table found for frame #" + this.l);
                }
                this.p = 1;
                return null;
            }
            if (bVar.f1331f) {
                System.arraycopy(iArr, 0, this.f1341c, 0, iArr.length);
                int[] iArr2 = this.f1341c;
                this.f1340b = iArr2;
                iArr2[bVar.h] = 0;
                if (bVar.g == 2 && this.l == 0) {
                    this.t = Boolean.TRUE;
                }
            }
            return r(bVar, bVar2);
        }
        String str3 = a;
        if (Log.isLoggable(str3, 3)) {
            Log.d(str3, "Unable to decode frame, status=" + this.p);
        }
        return null;
    }

    @Override // com.bumptech.glide.l.a
    public void b() {
        this.l = (this.l + 1) % this.m.f1333c;
    }

    @Override // com.bumptech.glide.l.a
    public int c() {
        return this.m.f1333c;
    }

    @Override // com.bumptech.glide.l.a
    public void clear() {
        this.m = null;
        byte[] bArr = this.j;
        if (bArr != null) {
            this.f1342d.e(bArr);
        }
        int[] iArr = this.k;
        if (iArr != null) {
            this.f1342d.f(iArr);
        }
        Bitmap bitmap = this.n;
        if (bitmap != null) {
            this.f1342d.a(bitmap);
        }
        this.n = null;
        this.f1343e = null;
        this.t = null;
        byte[] bArr2 = this.f1344f;
        if (bArr2 != null) {
            this.f1342d.e(bArr2);
        }
    }

    @Override // com.bumptech.glide.l.a
    public void d(@NonNull Bitmap.Config config) {
        if (config == Bitmap.Config.ARGB_8888 || config == Bitmap.Config.RGB_565) {
            this.u = config;
            return;
        }
        throw new IllegalArgumentException("Unsupported format: " + config + ", must be one of " + Bitmap.Config.ARGB_8888 + " or " + Bitmap.Config.RGB_565);
    }

    @Override // com.bumptech.glide.l.a
    public int e() {
        int i;
        if (this.m.f1333c <= 0 || (i = this.l) < 0) {
            return 0;
        }
        return m(i);
    }

    @Override // com.bumptech.glide.l.a
    public void f() {
        this.l = -1;
    }

    @Override // com.bumptech.glide.l.a
    public int g() {
        return this.l;
    }

    @Override // com.bumptech.glide.l.a
    @NonNull
    public ByteBuffer getData() {
        return this.f1343e;
    }

    @Override // com.bumptech.glide.l.a
    public int h() {
        return this.f1343e.limit() + this.j.length + (this.k.length * 4);
    }

    public int m(int i) {
        if (i >= 0) {
            c cVar = this.m;
            if (i < cVar.f1333c) {
                return cVar.f1335e.get(i).i;
            }
        }
        return -1;
    }

    public synchronized void q(@NonNull c cVar, @NonNull ByteBuffer byteBuffer, int i) {
        if (i > 0) {
            int highestOneBit = Integer.highestOneBit(i);
            this.p = 0;
            this.m = cVar;
            this.l = -1;
            ByteBuffer asReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
            this.f1343e = asReadOnlyBuffer;
            asReadOnlyBuffer.position(0);
            this.f1343e.order(ByteOrder.LITTLE_ENDIAN);
            this.o = false;
            Iterator<b> it = cVar.f1335e.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (it.next().g == 3) {
                        this.o = true;
                        break;
                    }
                } else {
                    break;
                }
            }
            this.q = highestOneBit;
            int i2 = cVar.f1336f;
            this.s = i2 / highestOneBit;
            int i3 = cVar.g;
            this.r = i3 / highestOneBit;
            this.j = this.f1342d.b(i2 * i3);
            this.k = this.f1342d.d(this.s * this.r);
        } else {
            throw new IllegalArgumentException("Sample size must be >=0, not: " + i);
        }
    }

    public e(@NonNull a.AbstractC0042a aVar) {
        this.f1341c = new int[256];
        this.u = Bitmap.Config.ARGB_8888;
        this.f1342d = aVar;
        this.m = new c();
    }
}
