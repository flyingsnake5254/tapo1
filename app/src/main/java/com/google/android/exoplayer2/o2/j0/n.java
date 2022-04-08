package com.google.android.exoplayer2.o2.j0;

import android.support.v4.media.session.PlaybackStateCompat;
import com.google.android.exoplayer2.o2.k;
import com.google.android.exoplayer2.util.d0;
import java.io.IOException;

/* compiled from: Sniffer.java */
/* loaded from: classes.dex */
final class n {
    private static final int[] a = {1769172845, 1769172786, 1769172787, 1769172788, 1769172789, 1769172790, 1769172793, 1635148593, 1752589105, 1751479857, 1635135537, 1836069937, 1836069938, 862401121, 862401122, 862417462, 862417718, 862414134, 862414646, 1295275552, 1295270176, 1714714144, 1801741417, 1295275600, 1903435808, 1297305174, 1684175153, 1769172332, 1885955686};

    private static boolean a(int i, boolean z) {
        if ((i >>> 8) == 3368816) {
            return true;
        }
        if (i == 1751476579 && z) {
            return true;
        }
        for (int i2 : a) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    public static boolean b(k kVar) throws IOException {
        return c(kVar, true, false);
    }

    private static boolean c(k kVar, boolean z, boolean z2) throws IOException {
        boolean z3;
        long a2 = kVar.a();
        long j = PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
        long j2 = -1;
        int i = (a2 > (-1L) ? 1 : (a2 == (-1L) ? 0 : -1));
        if (i != 0 && a2 <= PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM) {
            j = a2;
        }
        int i2 = (int) j;
        d0 d0Var = new d0(64);
        boolean z4 = false;
        int i3 = 0;
        boolean z5 = false;
        while (i3 < i2) {
            d0Var.L(8);
            byte[] d2 = d0Var.d();
            int i4 = z4 ? 1 : 0;
            int i5 = z4 ? 1 : 0;
            int i6 = z4 ? 1 : 0;
            int i7 = z4 ? 1 : 0;
            if (!kVar.c(d2, i4, 8, true)) {
                break;
            }
            long F = d0Var.F();
            int n = d0Var.n();
            int i8 = 16;
            if (F == 1) {
                kVar.n(d0Var.d(), 8, 8);
                d0Var.O(16);
                F = d0Var.w();
            } else {
                if (F == 0) {
                    long a3 = kVar.a();
                    if (a3 != j2) {
                        F = (a3 - kVar.g()) + 8;
                    }
                }
                i8 = 8;
            }
            long j3 = i8;
            if (F < j3) {
                return z4;
            }
            i3 += i8;
            if (n == 1836019574) {
                i2 += (int) F;
                if (i != 0 && i2 > a2) {
                    i2 = (int) a2;
                }
                j2 = -1;
            } else if (n == 1836019558 || n == 1836475768) {
                z3 = true;
                break;
            } else if ((i3 + F) - j3 >= i2) {
                break;
            } else {
                int i9 = (int) (F - j3);
                i3 += i9;
                if (n == 1718909296) {
                    if (i9 < 8) {
                        return false;
                    }
                    d0Var.L(i9);
                    kVar.n(d0Var.d(), 0, i9);
                    int i10 = i9 / 4;
                    int i11 = 0;
                    while (true) {
                        if (i11 >= i10) {
                            break;
                        }
                        if (i11 == 1) {
                            d0Var.Q(4);
                        } else if (a(d0Var.n(), z2)) {
                            z5 = true;
                            break;
                        }
                        i11++;
                    }
                    if (!z5) {
                        return false;
                    }
                } else if (i9 != 0) {
                    kVar.h(i9);
                }
                a2 = a2;
                j2 = -1;
                z4 = false;
            }
        }
        z3 = false;
        return z5 && z == z3;
    }

    public static boolean d(k kVar, boolean z) throws IOException {
        return c(kVar, false, z);
    }
}
