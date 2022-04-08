package com.google.android.exoplayer2.o2;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.extractor.flv.c;
import com.google.android.exoplayer2.o2.e0.b;
import com.google.android.exoplayer2.o2.f0.d;
import com.google.android.exoplayer2.o2.g0.a;
import com.google.android.exoplayer2.o2.h0.e;
import com.google.android.exoplayer2.o2.j0.i;
import com.google.android.exoplayer2.o2.j0.k;
import com.google.android.exoplayer2.o2.l0.b0;
import com.google.android.exoplayer2.o2.l0.f;
import com.google.android.exoplayer2.o2.l0.h0;
import com.google.android.exoplayer2.o2.l0.j;
import com.google.android.exoplayer2.util.o;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: DefaultExtractorsFactory.java */
/* loaded from: classes.dex */
public final class h implements o {

    /* renamed from: b  reason: collision with root package name */
    private static final int[] f2711b = {5, 4, 12, 8, 3, 10, 9, 11, 6, 2, 0, 1, 7, 14};
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private static final Constructor<? extends j> f2712c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f2713d;

    /* renamed from: e  reason: collision with root package name */
    private int f2714e;

    /* renamed from: f  reason: collision with root package name */
    private int f2715f;
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;
    private int m;
    private int l = 1;
    private int n = 112800;

    static {
        Constructor<? extends j> constructor = null;
        try {
            if (Boolean.TRUE.equals(Class.forName("com.google.android.exoplayer2.ext.flac.FlacLibrary").getMethod("isAvailable", new Class[0]).invoke(null, new Object[0]))) {
                constructor = Class.forName("com.google.android.exoplayer2.ext.flac.FlacExtractor").asSubclass(j.class).getConstructor(Integer.TYPE);
            }
        } catch (ClassNotFoundException unused) {
        } catch (Exception e2) {
            throw new RuntimeException("Error instantiating FLAC extension", e2);
        }
        f2712c = constructor;
    }

    private void c(int i, List<j> list) {
        switch (i) {
            case 0:
                list.add(new f());
                return;
            case 1:
                list.add(new com.google.android.exoplayer2.o2.l0.h());
                return;
            case 2:
                list.add(new j(this.f2714e | (this.f2713d ? 1 : 0)));
                return;
            case 3:
                list.add(new b(this.f2715f | (this.f2713d ? 1 : 0)));
                return;
            case 4:
                Constructor<? extends j> constructor = f2712c;
                if (constructor != null) {
                    try {
                        list.add((j) constructor.newInstance(Integer.valueOf(this.g)));
                        return;
                    } catch (Exception e2) {
                        throw new IllegalStateException("Unexpected error creating FLAC extractor", e2);
                    }
                } else {
                    list.add(new d(this.g));
                    return;
                }
            case 5:
                list.add(new c());
                return;
            case 6:
                list.add(new e(this.h));
                return;
            case 7:
                list.add(new com.google.android.exoplayer2.o2.i0.f(this.k | (this.f2713d ? 1 : 0)));
                return;
            case 8:
                list.add(new i(this.j));
                list.add(new k(this.i));
                return;
            case 9:
                list.add(new com.google.android.exoplayer2.o2.k0.d());
                return;
            case 10:
                list.add(new b0());
                return;
            case 11:
                list.add(new h0(this.l, this.m, this.n));
                return;
            case 12:
                list.add(new com.google.android.exoplayer2.o2.m0.b());
                return;
            case 13:
            default:
                return;
            case 14:
                list.add(new a());
                return;
        }
    }

    @Override // com.google.android.exoplayer2.o2.o
    public synchronized j[] a(Uri uri, Map<String, List<String>> map) {
        ArrayList arrayList;
        int[] iArr;
        arrayList = new ArrayList(14);
        int b2 = o.b(map);
        if (b2 != -1) {
            c(b2, arrayList);
        }
        int c2 = o.c(uri);
        if (!(c2 == -1 || c2 == b2)) {
            c(c2, arrayList);
        }
        for (int i : f2711b) {
            if (!(i == b2 || i == c2)) {
                c(i, arrayList);
            }
        }
        return (j[]) arrayList.toArray(new j[arrayList.size()]);
    }

    @Override // com.google.android.exoplayer2.o2.o
    public synchronized j[] b() {
        return a(Uri.EMPTY, new HashMap());
    }
}
