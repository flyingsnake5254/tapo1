package com.google.android.exoplayer2.text.s;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.SpannableStringBuilder;
import android.util.Base64;
import android.util.Pair;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.text.c;
import com.google.android.exoplayer2.util.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TtmlNode.java */
/* loaded from: classes.dex */
public final class d {
    @Nullable
    public final String a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public final String f3551b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f3552c;

    /* renamed from: d  reason: collision with root package name */
    public final long f3553d;

    /* renamed from: e  reason: collision with root package name */
    public final long f3554e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public final g f3555f;
    @Nullable
    private final String[] g;
    public final String h;
    @Nullable
    public final String i;
    @Nullable
    public final d j;
    private final HashMap<String, Integer> k;
    private final HashMap<String, Integer> l;
    private List<d> m;

    private d(@Nullable String str, @Nullable String str2, long j, long j2, @Nullable g gVar, @Nullable String[] strArr, String str3, @Nullable String str4, @Nullable d dVar) {
        this.a = str;
        this.f3551b = str2;
        this.i = str4;
        this.f3555f = gVar;
        this.g = strArr;
        this.f3552c = str2 != null;
        this.f3553d = j;
        this.f3554e = j2;
        this.h = (String) g.e(str3);
        this.j = dVar;
        this.k = new HashMap<>();
        this.l = new HashMap<>();
    }

    private void b(Map<String, g> map, c.b bVar, int i, int i2, int i3) {
        g f2 = f.f(this.f3555f, this.g, map);
        SpannableStringBuilder spannableStringBuilder = (SpannableStringBuilder) bVar.e();
        if (spannableStringBuilder == null) {
            spannableStringBuilder = new SpannableStringBuilder();
            bVar.o(spannableStringBuilder);
        }
        if (f2 != null) {
            f.a(spannableStringBuilder, i, i2, f2, this.j, map, i3);
            if ("p".equals(this.a)) {
                if (f2.k() != Float.MAX_VALUE) {
                    bVar.m((f2.k() * (-90.0f)) / 100.0f);
                }
                if (f2.m() != null) {
                    bVar.p(f2.m());
                }
                if (f2.h() != null) {
                    bVar.j(f2.h());
                }
            }
        }
    }

    public static d c(@Nullable String str, long j, long j2, @Nullable g gVar, @Nullable String[] strArr, String str2, @Nullable String str3, @Nullable d dVar) {
        return new d(str, null, j, j2, gVar, strArr, str2, str3, dVar);
    }

    public static d d(String str) {
        return new d(null, f.b(str), -9223372036854775807L, -9223372036854775807L, null, null, "", null, null);
    }

    private static void e(SpannableStringBuilder spannableStringBuilder) {
        a[] aVarArr;
        for (a aVar : (a[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), a.class)) {
            spannableStringBuilder.replace(spannableStringBuilder.getSpanStart(aVar), spannableStringBuilder.getSpanEnd(aVar), "");
        }
        for (int i = 0; i < spannableStringBuilder.length(); i++) {
            if (spannableStringBuilder.charAt(i) == ' ') {
                int i2 = i + 1;
                int i3 = i2;
                while (i3 < spannableStringBuilder.length() && spannableStringBuilder.charAt(i3) == ' ') {
                    i3++;
                }
                int i4 = i3 - i2;
                if (i4 > 0) {
                    spannableStringBuilder.delete(i, i4 + i);
                }
            }
        }
        if (spannableStringBuilder.length() > 0 && spannableStringBuilder.charAt(0) == ' ') {
            spannableStringBuilder.delete(0, 1);
        }
        for (int i5 = 0; i5 < spannableStringBuilder.length() - 1; i5++) {
            if (spannableStringBuilder.charAt(i5) == '\n') {
                int i6 = i5 + 1;
                if (spannableStringBuilder.charAt(i6) == ' ') {
                    spannableStringBuilder.delete(i6, i5 + 2);
                }
            }
        }
        if (spannableStringBuilder.length() > 0 && spannableStringBuilder.charAt(spannableStringBuilder.length() - 1) == ' ') {
            spannableStringBuilder.delete(spannableStringBuilder.length() - 1, spannableStringBuilder.length());
        }
        for (int i7 = 0; i7 < spannableStringBuilder.length() - 1; i7++) {
            if (spannableStringBuilder.charAt(i7) == ' ') {
                int i8 = i7 + 1;
                if (spannableStringBuilder.charAt(i8) == '\n') {
                    spannableStringBuilder.delete(i7, i8);
                }
            }
        }
        if (spannableStringBuilder.length() > 0 && spannableStringBuilder.charAt(spannableStringBuilder.length() - 1) == '\n') {
            spannableStringBuilder.delete(spannableStringBuilder.length() - 1, spannableStringBuilder.length());
        }
    }

    private void i(TreeSet<Long> treeSet, boolean z) {
        boolean equals = "p".equals(this.a);
        boolean equals2 = "div".equals(this.a);
        if (z || equals || (equals2 && this.i != null)) {
            long j = this.f3553d;
            if (j != -9223372036854775807L) {
                treeSet.add(Long.valueOf(j));
            }
            long j2 = this.f3554e;
            if (j2 != -9223372036854775807L) {
                treeSet.add(Long.valueOf(j2));
            }
        }
        if (this.m != null) {
            for (int i = 0; i < this.m.size(); i++) {
                this.m.get(i).i(treeSet, z || equals);
            }
        }
    }

    private static SpannableStringBuilder k(String str, Map<String, c.b> map) {
        if (!map.containsKey(str)) {
            c.b bVar = new c.b();
            bVar.o(new SpannableStringBuilder());
            map.put(str, bVar);
        }
        return (SpannableStringBuilder) g.e(map.get(str).e());
    }

    private void n(long j, String str, List<Pair<String, String>> list) {
        if (!"".equals(this.h)) {
            str = this.h;
        }
        if (!m(j) || !"div".equals(this.a) || this.i == null) {
            for (int i = 0; i < g(); i++) {
                f(i).n(j, str, list);
            }
            return;
        }
        list.add(new Pair<>(str, this.i));
    }

    private void o(long j, Map<String, g> map, Map<String, e> map2, String str, Map<String, c.b> map3) {
        int i;
        if (m(j)) {
            String str2 = "".equals(this.h) ? str : this.h;
            Iterator<Map.Entry<String, Integer>> it = this.l.entrySet().iterator();
            while (true) {
                if (it.hasNext()) {
                    Map.Entry<String, Integer> next = it.next();
                    String key = next.getKey();
                    int intValue = this.k.containsKey(key) ? this.k.get(key).intValue() : 0;
                    int intValue2 = next.getValue().intValue();
                    if (intValue != intValue2) {
                        b(map, (c.b) g.e(map3.get(key)), intValue, intValue2, ((e) g.e(map2.get(str2))).j);
                    }
                }
            }
            for (i = 0; i < g(); i++) {
                f(i).o(j, map, map2, str2, map3);
            }
        }
    }

    private void p(long j, boolean z, String str, Map<String, c.b> map) {
        this.k.clear();
        this.l.clear();
        if (!"metadata".equals(this.a)) {
            if (!"".equals(this.h)) {
                str = this.h;
            }
            if (this.f3552c && z) {
                k(str, map).append((CharSequence) g.e(this.f3551b));
            } else if ("br".equals(this.a) && z) {
                k(str, map).append('\n');
            } else if (m(j)) {
                for (Map.Entry<String, c.b> entry : map.entrySet()) {
                    this.k.put(entry.getKey(), Integer.valueOf(((CharSequence) g.e(entry.getValue().e())).length()));
                }
                boolean equals = "p".equals(this.a);
                for (int i = 0; i < g(); i++) {
                    f(i).p(j, z || equals, str, map);
                }
                if (equals) {
                    f.c(k(str, map));
                }
                for (Map.Entry<String, c.b> entry2 : map.entrySet()) {
                    this.l.put(entry2.getKey(), Integer.valueOf(((CharSequence) g.e(entry2.getValue().e())).length()));
                }
            }
        }
    }

    public void a(d dVar) {
        if (this.m == null) {
            this.m = new ArrayList();
        }
        this.m.add(dVar);
    }

    public d f(int i) {
        List<d> list = this.m;
        if (list != null) {
            return list.get(i);
        }
        throw new IndexOutOfBoundsException();
    }

    public int g() {
        List<d> list = this.m;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public List<c> h(long j, Map<String, g> map, Map<String, e> map2, Map<String, String> map3) {
        List<Pair<String, String>> arrayList = new ArrayList<>();
        n(j, this.h, arrayList);
        TreeMap treeMap = new TreeMap();
        p(j, false, this.h, treeMap);
        o(j, map, map2, this.h, treeMap);
        ArrayList arrayList2 = new ArrayList();
        for (Pair<String, String> pair : arrayList) {
            String str = map3.get(pair.second);
            if (str != null) {
                byte[] decode = Base64.decode(str, 0);
                Bitmap decodeByteArray = BitmapFactory.decodeByteArray(decode, 0, decode.length);
                e eVar = (e) g.e(map2.get(pair.first));
                arrayList2.add(new c.b().f(decodeByteArray).k(eVar.f3556b).l(0).h(eVar.f3557c, 0).i(eVar.f3559e).n(eVar.f3560f).g(eVar.g).r(eVar.j).a());
            }
        }
        for (Map.Entry entry : treeMap.entrySet()) {
            e eVar2 = (e) g.e(map2.get(entry.getKey()));
            c.b bVar = (c.b) entry.getValue();
            e((SpannableStringBuilder) g.e(bVar.e()));
            bVar.h(eVar2.f3557c, eVar2.f3558d);
            bVar.i(eVar2.f3559e);
            bVar.k(eVar2.f3556b);
            bVar.n(eVar2.f3560f);
            bVar.q(eVar2.i, eVar2.h);
            bVar.r(eVar2.j);
            arrayList2.add(bVar.a());
        }
        return arrayList2;
    }

    public long[] j() {
        TreeSet<Long> treeSet = new TreeSet<>();
        int i = 0;
        i(treeSet, false);
        long[] jArr = new long[treeSet.size()];
        Iterator<Long> it = treeSet.iterator();
        while (it.hasNext()) {
            i++;
            jArr[i] = it.next().longValue();
        }
        return jArr;
    }

    @Nullable
    public String[] l() {
        return this.g;
    }

    public boolean m(long j) {
        long j2 = this.f3553d;
        return (j2 == -9223372036854775807L && this.f3554e == -9223372036854775807L) || (j2 <= j && this.f3554e == -9223372036854775807L) || ((j2 == -9223372036854775807L && j < this.f3554e) || (j2 <= j && j < this.f3554e));
    }
}
