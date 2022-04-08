package com.google.android.exoplayer2.source.hls.playlist;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.offline.StreamKey;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* compiled from: HlsMasterPlaylist.java */
/* loaded from: classes.dex */
public final class f extends h {

    /* renamed from: d  reason: collision with root package name */
    public static final f f3291d = new f("", Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), null, Collections.emptyList(), false, Collections.emptyMap(), Collections.emptyList());

    /* renamed from: e  reason: collision with root package name */
    public final List<Uri> f3292e;

    /* renamed from: f  reason: collision with root package name */
    public final List<b> f3293f;
    public final List<a> g;
    public final List<a> h;
    public final List<a> i;
    public final List<a> j;
    @Nullable
    public final Format k;
    @Nullable
    public final List<Format> l;
    public final Map<String, String> m;
    public final List<DrmInitData> n;

    /* compiled from: HlsMasterPlaylist.java */
    /* loaded from: classes.dex */
    public static final class a {
        @Nullable
        public final Uri a;

        /* renamed from: b  reason: collision with root package name */
        public final Format f3294b;

        /* renamed from: c  reason: collision with root package name */
        public final String f3295c;

        /* renamed from: d  reason: collision with root package name */
        public final String f3296d;

        public a(@Nullable Uri uri, Format format, String str, String str2) {
            this.a = uri;
            this.f3294b = format;
            this.f3295c = str;
            this.f3296d = str2;
        }
    }

    /* compiled from: HlsMasterPlaylist.java */
    /* loaded from: classes.dex */
    public static final class b {
        public final Uri a;

        /* renamed from: b  reason: collision with root package name */
        public final Format f3297b;
        @Nullable

        /* renamed from: c  reason: collision with root package name */
        public final String f3298c;
        @Nullable

        /* renamed from: d  reason: collision with root package name */
        public final String f3299d;
        @Nullable

        /* renamed from: e  reason: collision with root package name */
        public final String f3300e;
        @Nullable

        /* renamed from: f  reason: collision with root package name */
        public final String f3301f;

        public b(Uri uri, Format format, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4) {
            this.a = uri;
            this.f3297b = format;
            this.f3298c = str;
            this.f3299d = str2;
            this.f3300e = str3;
            this.f3301f = str4;
        }

        public static b b(Uri uri) {
            return new b(uri, new Format.b().S("0").K("application/x-mpegURL").E(), null, null, null, null);
        }

        public b a(Format format) {
            return new b(this.a, format, this.f3298c, this.f3299d, this.f3300e, this.f3301f);
        }
    }

    public f(String str, List<String> list, List<b> list2, List<a> list3, List<a> list4, List<a> list5, List<a> list6, @Nullable Format format, @Nullable List<Format> list7, boolean z, Map<String, String> map, List<DrmInitData> list8) {
        super(str, list, z);
        this.f3292e = Collections.unmodifiableList(f(list2, list3, list4, list5, list6));
        this.f3293f = Collections.unmodifiableList(list2);
        this.g = Collections.unmodifiableList(list3);
        this.h = Collections.unmodifiableList(list4);
        this.i = Collections.unmodifiableList(list5);
        this.j = Collections.unmodifiableList(list6);
        this.k = format;
        this.l = list7 != null ? Collections.unmodifiableList(list7) : null;
        this.m = Collections.unmodifiableMap(map);
        this.n = Collections.unmodifiableList(list8);
    }

    private static void b(List<a> list, List<Uri> list2) {
        for (int i = 0; i < list.size(); i++) {
            Uri uri = list.get(i).a;
            if (uri != null && !list2.contains(uri)) {
                list2.add(uri);
            }
        }
    }

    private static <T> List<T> d(List<T> list, int i, List<StreamKey> list2) {
        ArrayList arrayList = new ArrayList(list2.size());
        for (int i2 = 0; i2 < list.size(); i2++) {
            T t = list.get(i2);
            int i3 = 0;
            while (true) {
                if (i3 < list2.size()) {
                    StreamKey streamKey = list2.get(i3);
                    if (streamKey.f3092d == i && streamKey.f3093f == i2) {
                        arrayList.add(t);
                        break;
                    }
                    i3++;
                }
            }
        }
        return arrayList;
    }

    public static f e(String str) {
        return new f("", Collections.emptyList(), Collections.singletonList(b.b(Uri.parse(str))), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), null, null, false, Collections.emptyMap(), Collections.emptyList());
    }

    private static List<Uri> f(List<b> list, List<a> list2, List<a> list3, List<a> list4, List<a> list5) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            Uri uri = list.get(i).a;
            if (!arrayList.contains(uri)) {
                arrayList.add(uri);
            }
        }
        b(list2, arrayList);
        b(list3, arrayList);
        b(list4, arrayList);
        b(list5, arrayList);
        return arrayList;
    }

    /* renamed from: c */
    public f a(List<StreamKey> list) {
        return new f(this.a, this.f3314b, d(this.f3293f, 0, list), Collections.emptyList(), d(this.h, 1, list), d(this.i, 2, list), Collections.emptyList(), this.k, this.l, this.f3315c, this.m, this.n);
    }
}
