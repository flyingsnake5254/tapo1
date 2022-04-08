package com.google.android.exoplayer2.o2.h0;

import android.support.v4.media.session.PlaybackStateCompat;
import com.google.android.exoplayer2.o2.k;
import com.google.android.exoplayer2.util.d0;
import java.io.IOException;

/* compiled from: Sniffer.java */
/* loaded from: classes.dex */
final class f {
    private final d0 a = new d0(8);

    /* renamed from: b  reason: collision with root package name */
    private int f2738b;

    private long a(k kVar) throws IOException {
        int i = 0;
        kVar.n(this.a.d(), 0, 1);
        int i2 = this.a.d()[0] & 255;
        if (i2 == 0) {
            return Long.MIN_VALUE;
        }
        int i3 = 128;
        int i4 = 0;
        while ((i2 & i3) == 0) {
            i3 >>= 1;
            i4++;
        }
        int i5 = i2 & (~i3);
        kVar.n(this.a.d(), 1, i4);
        while (i < i4) {
            i++;
            i5 = (this.a.d()[i] & 255) + (i5 << 8);
        }
        this.f2738b += i4 + 1;
        return i5;
    }

    public boolean b(k kVar) throws IOException {
        long a;
        int i;
        long a2 = kVar.a();
        long j = PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
        int i2 = (a2 > (-1L) ? 1 : (a2 == (-1L) ? 0 : -1));
        if (i2 != 0 && a2 <= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID) {
            j = a2;
        }
        int i3 = (int) j;
        kVar.n(this.a.d(), 0, 4);
        long F = this.a.F();
        this.f2738b = 4;
        while (F != 440786851) {
            int i4 = this.f2738b + 1;
            this.f2738b = i4;
            if (i4 == i3) {
                return false;
            }
            kVar.n(this.a.d(), 0, 1);
            F = ((F << 8) & (-256)) | (this.a.d()[0] & 255);
        }
        long a3 = a(kVar);
        long j2 = this.f2738b;
        if (a3 == Long.MIN_VALUE) {
            return false;
        }
        if (i2 != 0 && j2 + a3 >= a2) {
            return false;
        }
        while (true) {
            int i5 = this.f2738b;
            long j3 = j2 + a3;
            if (i5 >= j3) {
                return ((long) i5) == j3;
            }
            if (a(kVar) != Long.MIN_VALUE && (a = a(kVar)) >= 0 && a <= 2147483647L) {
                if (i != 0) {
                    int i6 = (int) a;
                    kVar.h(i6);
                    this.f2738b += i6;
                }
            }
        }
    }
}
