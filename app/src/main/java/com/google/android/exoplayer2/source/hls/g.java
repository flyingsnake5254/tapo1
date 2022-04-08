package com.google.android.exoplayer2.source.hls;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.o2.j;
import com.google.android.exoplayer2.o2.j0.i;
import com.google.android.exoplayer2.o2.k;
import com.google.android.exoplayer2.o2.l0.f;
import com.google.android.exoplayer2.o2.l0.h;
import com.google.android.exoplayer2.o2.l0.h0;
import com.google.android.exoplayer2.o2.l0.l;
import com.google.android.exoplayer2.util.l0;
import com.google.android.exoplayer2.util.o;
import com.google.android.exoplayer2.util.y;
import com.google.common.primitives.d;
import java.io.EOFException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* compiled from: DefaultHlsExtractorFactory.java */
/* loaded from: classes.dex */
public final class g implements k {

    /* renamed from: b  reason: collision with root package name */
    private static final int[] f3252b = {8, 13, 11, 2, 0, 1, 7};

    /* renamed from: c  reason: collision with root package name */
    private final int f3253c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f3254d;

    public g() {
        this(0, true);
    }

    private static void b(int i, List<Integer> list) {
        if (d.f(f3252b, i) != -1 && !list.contains(Integer.valueOf(i))) {
            list.add(Integer.valueOf(i));
        }
    }

    @Nullable
    @SuppressLint({"SwitchIntDef"})
    private j d(int i, Format format, @Nullable List<Format> list, l0 l0Var) {
        if (i == 0) {
            return new f();
        }
        if (i == 1) {
            return new h();
        }
        if (i == 2) {
            return new com.google.android.exoplayer2.o2.l0.j();
        }
        if (i == 7) {
            return new com.google.android.exoplayer2.o2.i0.f(0, 0L);
        }
        if (i == 8) {
            return e(l0Var, format, list);
        }
        if (i == 11) {
            return f(this.f3253c, this.f3254d, format, list, l0Var);
        }
        if (i != 13) {
            return null;
        }
        return new s(format.f2006f, l0Var);
    }

    private static i e(l0 l0Var, Format format, @Nullable List<Format> list) {
        int i = g(format) ? 4 : 0;
        if (list == null) {
            list = Collections.emptyList();
        }
        return new i(i, l0Var, null, list);
    }

    private static h0 f(int i, boolean z, Format format, @Nullable List<Format> list, l0 l0Var) {
        int i2 = i | 16;
        if (list != null) {
            i2 |= 32;
        } else if (z) {
            list = Collections.singletonList(new Format.b().e0("application/cea-608").E());
        } else {
            list = Collections.emptyList();
        }
        String str = format.p1;
        if (!TextUtils.isEmpty(str)) {
            if (!y.b(str, "audio/mp4a-latm")) {
                i2 |= 2;
            }
            if (!y.b(str, "video/avc")) {
                i2 |= 4;
            }
        }
        return new h0(2, l0Var, new l(i2, list));
    }

    private static boolean g(Format format) {
        Metadata metadata = format.p2;
        if (metadata == null) {
            return false;
        }
        for (int i = 0; i < metadata.d(); i++) {
            Metadata.Entry c2 = metadata.c(i);
            if (c2 instanceof HlsTrackMetadataEntry) {
                return !((HlsTrackMetadataEntry) c2).f3238f.isEmpty();
            }
        }
        return false;
    }

    /* JADX WARN: Finally extract failed */
    private static boolean h(j jVar, k kVar) throws IOException {
        try {
            boolean d2 = jVar.d(kVar);
            kVar.e();
            return d2;
        } catch (EOFException unused) {
            kVar.e();
            return false;
        } catch (Throwable th) {
            kVar.e();
            throw th;
        }
    }

    /* renamed from: c */
    public e a(Uri uri, Format format, @Nullable List<Format> list, l0 l0Var, Map<String, List<String>> map, k kVar) throws IOException {
        int a = o.a(format.H3);
        int b2 = o.b(map);
        int c2 = o.c(uri);
        int[] iArr = f3252b;
        ArrayList arrayList = new ArrayList(iArr.length);
        b(a, arrayList);
        b(b2, arrayList);
        b(c2, arrayList);
        for (int i : iArr) {
            b(i, arrayList);
        }
        j jVar = null;
        kVar.e();
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            int intValue = ((Integer) arrayList.get(i2)).intValue();
            j jVar2 = (j) com.google.android.exoplayer2.util.g.e(d(intValue, format, list, l0Var));
            if (h(jVar2, kVar)) {
                return new e(jVar2, format, l0Var);
            }
            if (jVar == null && (intValue == a || intValue == b2 || intValue == c2 || intValue == 11)) {
                jVar = jVar2;
            }
        }
        return new e((j) com.google.android.exoplayer2.util.g.e(jVar), format, l0Var);
    }

    public g(int i, boolean z) {
        this.f3253c = i;
        this.f3254d = z;
    }
}
