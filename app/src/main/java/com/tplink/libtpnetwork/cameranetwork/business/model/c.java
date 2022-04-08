package com.tplink.libtpnetwork.cameranetwork.business.model;

import androidx.annotation.Nullable;
import com.tplink.libtpnetwork.cameranetwork.model.IntrusionSchedule;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

/* compiled from: AreaIntrusionSetting.java */
/* loaded from: classes3.dex */
public class c {
    private boolean a;

    /* renamed from: b  reason: collision with root package name */
    private List<a> f14118b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    private Map<DayOfWeek, List<IntrusionSchedule>> f14119c = new EnumMap(DayOfWeek.class);

    /* compiled from: AreaIntrusionSetting.java */
    /* loaded from: classes3.dex */
    public static class a {
        private int a;

        /* renamed from: b  reason: collision with root package name */
        private int f14120b;

        /* renamed from: c  reason: collision with root package name */
        private int f14121c;

        /* renamed from: d  reason: collision with root package name */
        private int f14122d;

        public a() {
        }

        public int a() {
            return this.f14122d;
        }

        public int b() {
            return this.f14121c;
        }

        public int c() {
            return this.a;
        }

        public int d() {
            return this.f14120b;
        }

        public void e(int i) {
            this.f14122d = i;
        }

        public boolean equals(@Nullable Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            if (obj == this) {
                return true;
            }
            a aVar = (a) obj;
            return aVar.a == this.a && aVar.f14120b == this.f14120b && aVar.f14121c == this.f14121c && aVar.f14122d == this.f14122d;
        }

        public void f(int i) {
            this.f14121c = i;
        }

        public void g(int i) {
            this.a = i;
        }

        public void h(int i) {
            this.f14120b = i;
        }

        public int hashCode() {
            return (((((this.a * 31) + this.f14120b) * 31) + this.f14121c) * 31) + this.f14122d;
        }

        public a(int i, int i2, int i3, int i4) {
            this.a = i;
            this.f14120b = i2;
            this.f14121c = i3;
            this.f14122d = i4;
        }
    }

    public List<a> a() {
        return Collections.unmodifiableList(this.f14118b);
    }

    public List<IntrusionSchedule> b(DayOfWeek dayOfWeek) {
        return Collections.unmodifiableList(this.f14119c.get(dayOfWeek));
    }

    public boolean c() {
        return this.a;
    }

    public void d(boolean z) {
        this.a = z;
    }

    public void e(List<a> list) {
        this.f14118b.clear();
        this.f14118b.addAll(list);
    }

    public boolean equals(Object obj) {
        if (obj instanceof c) {
            c cVar = (c) obj;
            if (cVar.a == this.a && cVar.f14118b.equals(this.f14118b)) {
                return true;
            }
        }
        return false;
    }

    public void f(DayOfWeek dayOfWeek, @Nullable List<IntrusionSchedule> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            arrayList.addAll(list);
        }
        this.f14119c.put(dayOfWeek, arrayList);
    }
}
