package com.bumptech.glide.l;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

/* compiled from: GifHeaderParser.java */
/* loaded from: classes.dex */
public class d {

    /* renamed from: b  reason: collision with root package name */
    private ByteBuffer f1337b;

    /* renamed from: c  reason: collision with root package name */
    private c f1338c;
    private final byte[] a = new byte[256];

    /* renamed from: d  reason: collision with root package name */
    private int f1339d = 0;

    private boolean b() {
        return this.f1338c.f1332b != 0;
    }

    private int d() {
        try {
            return this.f1337b.get() & 255;
        } catch (Exception unused) {
            this.f1338c.f1332b = 1;
            return 0;
        }
    }

    private void e() {
        this.f1338c.f1334d.a = n();
        this.f1338c.f1334d.f1327b = n();
        this.f1338c.f1334d.f1328c = n();
        this.f1338c.f1334d.f1329d = n();
        int d2 = d();
        boolean z = false;
        boolean z2 = (d2 & 128) != 0;
        int pow = (int) Math.pow(2.0d, (d2 & 7) + 1);
        b bVar = this.f1338c.f1334d;
        if ((d2 & 64) != 0) {
            z = true;
        }
        bVar.f1330e = z;
        if (z2) {
            bVar.k = g(pow);
        } else {
            bVar.k = null;
        }
        this.f1338c.f1334d.j = this.f1337b.position();
        r();
        if (!b()) {
            c cVar = this.f1338c;
            cVar.f1333c++;
            cVar.f1335e.add(cVar.f1334d);
        }
    }

    private void f() {
        int d2 = d();
        this.f1339d = d2;
        if (d2 > 0) {
            int i = 0;
            int i2 = 0;
            while (true) {
                try {
                    i2 = this.f1339d;
                    if (i < i2) {
                        i2 -= i;
                        this.f1337b.get(this.a, i, i2);
                        i += i2;
                    } else {
                        return;
                    }
                } catch (Exception e2) {
                    if (Log.isLoggable("GifHeaderParser", 3)) {
                        Log.d("GifHeaderParser", "Error Reading Block n: " + i + " count: " + i2 + " blockSize: " + this.f1339d, e2);
                    }
                    this.f1338c.f1332b = 1;
                    return;
                }
            }
        }
    }

    @Nullable
    private int[] g(int i) {
        byte[] bArr = new byte[i * 3];
        int[] iArr = null;
        try {
            this.f1337b.get(bArr);
            iArr = new int[256];
            int i2 = 0;
            int i3 = 0;
            while (i2 < i) {
                int i4 = i3 + 1;
                int i5 = bArr[i3] & 255;
                int i6 = i4 + 1;
                i3 = i6 + 1;
                i2++;
                iArr[i2] = (i5 << 16) | ViewCompat.MEASURED_STATE_MASK | ((bArr[i4] & 255) << 8) | (bArr[i6] & 255);
            }
        } catch (BufferUnderflowException e2) {
            if (Log.isLoggable("GifHeaderParser", 3)) {
                Log.d("GifHeaderParser", "Format Error Reading Color Table", e2);
            }
            this.f1338c.f1332b = 1;
        }
        return iArr;
    }

    private void h() {
        i(Integer.MAX_VALUE);
    }

    private void i(int i) {
        boolean z = false;
        while (!z && !b() && this.f1338c.f1333c <= i) {
            int d2 = d();
            if (d2 == 33) {
                int d3 = d();
                if (d3 == 1) {
                    q();
                } else if (d3 == 249) {
                    this.f1338c.f1334d = new b();
                    j();
                } else if (d3 == 254) {
                    q();
                } else if (d3 != 255) {
                    q();
                } else {
                    f();
                    StringBuilder sb = new StringBuilder();
                    for (int i2 = 0; i2 < 11; i2++) {
                        sb.append((char) this.a[i2]);
                    }
                    if (sb.toString().equals("NETSCAPE2.0")) {
                        m();
                    } else {
                        q();
                    }
                }
            } else if (d2 == 44) {
                c cVar = this.f1338c;
                if (cVar.f1334d == null) {
                    cVar.f1334d = new b();
                }
                e();
            } else if (d2 != 59) {
                this.f1338c.f1332b = 1;
            } else {
                z = true;
            }
        }
    }

    private void j() {
        d();
        int d2 = d();
        b bVar = this.f1338c.f1334d;
        int i = (d2 & 28) >> 2;
        bVar.g = i;
        boolean z = true;
        if (i == 0) {
            bVar.g = 1;
        }
        if ((d2 & 1) == 0) {
            z = false;
        }
        bVar.f1331f = z;
        int n = n();
        if (n < 2) {
            n = 10;
        }
        b bVar2 = this.f1338c.f1334d;
        bVar2.i = n * 10;
        bVar2.h = d();
        d();
    }

    private void k() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            sb.append((char) d());
        }
        if (!sb.toString().startsWith("GIF")) {
            this.f1338c.f1332b = 1;
            return;
        }
        l();
        if (this.f1338c.h && !b()) {
            c cVar = this.f1338c;
            cVar.a = g(cVar.i);
            c cVar2 = this.f1338c;
            cVar2.l = cVar2.a[cVar2.j];
        }
    }

    private void l() {
        this.f1338c.f1336f = n();
        this.f1338c.g = n();
        int d2 = d();
        c cVar = this.f1338c;
        cVar.h = (d2 & 128) != 0;
        cVar.i = (int) Math.pow(2.0d, (d2 & 7) + 1);
        this.f1338c.j = d();
        this.f1338c.k = d();
    }

    private void m() {
        do {
            f();
            byte[] bArr = this.a;
            if (bArr[0] == 1) {
                this.f1338c.m = ((bArr[2] & 255) << 8) | (bArr[1] & 255);
            }
            if (this.f1339d <= 0) {
                return;
            }
        } while (!b());
    }

    private int n() {
        return this.f1337b.getShort();
    }

    private void o() {
        this.f1337b = null;
        Arrays.fill(this.a, (byte) 0);
        this.f1338c = new c();
        this.f1339d = 0;
    }

    private void q() {
        int d2;
        do {
            d2 = d();
            this.f1337b.position(Math.min(this.f1337b.position() + d2, this.f1337b.limit()));
        } while (d2 > 0);
    }

    private void r() {
        d();
        q();
    }

    public void a() {
        this.f1337b = null;
        this.f1338c = null;
    }

    @NonNull
    public c c() {
        if (this.f1337b == null) {
            throw new IllegalStateException("You must call setData() before parseHeader()");
        } else if (b()) {
            return this.f1338c;
        } else {
            k();
            if (!b()) {
                h();
                c cVar = this.f1338c;
                if (cVar.f1333c < 0) {
                    cVar.f1332b = 1;
                }
            }
            return this.f1338c;
        }
    }

    public d p(@NonNull ByteBuffer byteBuffer) {
        o();
        ByteBuffer asReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
        this.f1337b = asReadOnlyBuffer;
        asReadOnlyBuffer.position(0);
        this.f1337b.order(ByteOrder.LITTLE_ENDIAN);
        return this;
    }
}
