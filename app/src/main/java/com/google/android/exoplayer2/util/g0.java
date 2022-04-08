package com.google.android.exoplayer2.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* compiled from: SlidingPercentile.java */
/* loaded from: classes.dex */
public class g0 {
    private static final Comparator<b> a = d.f3899c;

    /* renamed from: b  reason: collision with root package name */
    private static final Comparator<b> f3907b = e.f3902c;

    /* renamed from: c  reason: collision with root package name */
    private final int f3908c;
    private int g;
    private int h;
    private int i;

    /* renamed from: e  reason: collision with root package name */
    private final b[] f3910e = new b[5];

    /* renamed from: d  reason: collision with root package name */
    private final ArrayList<b> f3909d = new ArrayList<>();

    /* renamed from: f  reason: collision with root package name */
    private int f3911f = -1;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SlidingPercentile.java */
    /* loaded from: classes.dex */
    public static class b {
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public int f3912b;

        /* renamed from: c  reason: collision with root package name */
        public float f3913c;

        private b() {
        }
    }

    public g0(int i) {
        this.f3908c = i;
    }

    private void b() {
        if (this.f3911f != 1) {
            Collections.sort(this.f3909d, a);
            this.f3911f = 1;
        }
    }

    private void c() {
        if (this.f3911f != 0) {
            Collections.sort(this.f3909d, f3907b);
            this.f3911f = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ int e(b bVar, b bVar2) {
        return bVar.a - bVar2.a;
    }

    public void a(int i, float f2) {
        b bVar;
        b();
        int i2 = this.i;
        if (i2 > 0) {
            b[] bVarArr = this.f3910e;
            int i3 = i2 - 1;
            this.i = i3;
            bVar = bVarArr[i3];
        } else {
            bVar = new b();
        }
        int i4 = this.g;
        this.g = i4 + 1;
        bVar.a = i4;
        bVar.f3912b = i;
        bVar.f3913c = f2;
        this.f3909d.add(bVar);
        this.h += i;
        while (true) {
            int i5 = this.h;
            int i6 = this.f3908c;
            if (i5 > i6) {
                int i7 = i5 - i6;
                b bVar2 = this.f3909d.get(0);
                int i8 = bVar2.f3912b;
                if (i8 <= i7) {
                    this.h -= i8;
                    this.f3909d.remove(0);
                    int i9 = this.i;
                    if (i9 < 5) {
                        b[] bVarArr2 = this.f3910e;
                        this.i = i9 + 1;
                        bVarArr2[i9] = bVar2;
                    }
                } else {
                    bVar2.f3912b = i8 - i7;
                    this.h -= i7;
                }
            } else {
                return;
            }
        }
    }

    public float d(float f2) {
        c();
        float f3 = f2 * this.h;
        int i = 0;
        for (int i2 = 0; i2 < this.f3909d.size(); i2++) {
            b bVar = this.f3909d.get(i2);
            i += bVar.f3912b;
            if (i >= f3) {
                return bVar.f3913c;
            }
        }
        if (this.f3909d.isEmpty()) {
            return Float.NaN;
        }
        ArrayList<b> arrayList = this.f3909d;
        return arrayList.get(arrayList.size() - 1).f3913c;
    }

    public void g() {
        this.f3909d.clear();
        this.f3911f = -1;
        this.g = 0;
        this.h = 0;
    }
}
