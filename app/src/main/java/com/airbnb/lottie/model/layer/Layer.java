package com.airbnb.lottie.model.layer;

import androidx.annotation.Nullable;
import com.airbnb.lottie.d;
import com.airbnb.lottie.model.content.Mask;
import com.airbnb.lottie.model.content.b;
import com.airbnb.lottie.model.i.j;
import com.airbnb.lottie.model.i.k;
import com.airbnb.lottie.model.i.l;
import com.airbnb.lottie.w.a;
import java.util.List;
import java.util.Locale;

/* loaded from: classes.dex */
public class Layer {
    private final List<b> a;

    /* renamed from: b  reason: collision with root package name */
    private final d f1030b;

    /* renamed from: c  reason: collision with root package name */
    private final String f1031c;

    /* renamed from: d  reason: collision with root package name */
    private final long f1032d;

    /* renamed from: e  reason: collision with root package name */
    private final LayerType f1033e;

    /* renamed from: f  reason: collision with root package name */
    private final long f1034f;
    @Nullable
    private final String g;
    private final List<Mask> h;
    private final l i;
    private final int j;
    private final int k;
    private final int l;
    private final float m;
    private final float n;
    private final int o;
    private final int p;
    @Nullable
    private final j q;
    @Nullable
    private final k r;
    @Nullable
    private final com.airbnb.lottie.model.i.b s;
    private final List<a<Float>> t;
    private final MatteType u;
    private final boolean v;

    /* loaded from: classes.dex */
    public enum LayerType {
        PRE_COMP,
        SOLID,
        IMAGE,
        NULL,
        SHAPE,
        TEXT,
        UNKNOWN
    }

    /* loaded from: classes.dex */
    public enum MatteType {
        NONE,
        ADD,
        INVERT,
        UNKNOWN
    }

    public Layer(List<b> list, d dVar, String str, long j, LayerType layerType, long j2, @Nullable String str2, List<Mask> list2, l lVar, int i, int i2, int i3, float f2, float f3, int i4, int i5, @Nullable j jVar, @Nullable k kVar, List<a<Float>> list3, MatteType matteType, @Nullable com.airbnb.lottie.model.i.b bVar, boolean z) {
        this.a = list;
        this.f1030b = dVar;
        this.f1031c = str;
        this.f1032d = j;
        this.f1033e = layerType;
        this.f1034f = j2;
        this.g = str2;
        this.h = list2;
        this.i = lVar;
        this.j = i;
        this.k = i2;
        this.l = i3;
        this.m = f2;
        this.n = f3;
        this.o = i4;
        this.p = i5;
        this.q = jVar;
        this.r = kVar;
        this.t = list3;
        this.u = matteType;
        this.s = bVar;
        this.v = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d a() {
        return this.f1030b;
    }

    public long b() {
        return this.f1032d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<a<Float>> c() {
        return this.t;
    }

    public LayerType d() {
        return this.f1033e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<Mask> e() {
        return this.h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MatteType f() {
        return this.u;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String g() {
        return this.f1031c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long h() {
        return this.f1034f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int i() {
        return this.p;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int j() {
        return this.o;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public String k() {
        return this.g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<b> l() {
        return this.a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int m() {
        return this.l;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int n() {
        return this.k;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int o() {
        return this.j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float p() {
        return this.n / this.f1030b.e();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public j q() {
        return this.q;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public k r() {
        return this.r;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public com.airbnb.lottie.model.i.b s() {
        return this.s;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float t() {
        return this.m;
    }

    public String toString() {
        return w("");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public l u() {
        return this.i;
    }

    public boolean v() {
        return this.v;
    }

    public String w(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(g());
        sb.append("\n");
        Layer s = this.f1030b.s(h());
        if (s != null) {
            sb.append("\t\tParents: ");
            sb.append(s.g());
            Layer s2 = this.f1030b.s(s.h());
            while (s2 != null) {
                sb.append("->");
                sb.append(s2.g());
                s2 = this.f1030b.s(s2.h());
            }
            sb.append(str);
            sb.append("\n");
        }
        if (!e().isEmpty()) {
            sb.append(str);
            sb.append("\tMasks: ");
            sb.append(e().size());
            sb.append("\n");
        }
        if (!(o() == 0 || n() == 0)) {
            sb.append(str);
            sb.append("\tBackground: ");
            sb.append(String.format(Locale.US, "%dx%d %X\n", Integer.valueOf(o()), Integer.valueOf(n()), Integer.valueOf(m())));
        }
        if (!this.a.isEmpty()) {
            sb.append(str);
            sb.append("\tShapes:\n");
            for (b bVar : this.a) {
                sb.append(str);
                sb.append("\t\t");
                sb.append(bVar);
                sb.append("\n");
            }
        }
        return sb.toString();
    }
}
