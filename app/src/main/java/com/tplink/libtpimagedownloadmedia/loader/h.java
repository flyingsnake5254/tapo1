package com.tplink.libtpimagedownloadmedia.loader;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.f;
import com.bumptech.glide.load.j.m;
import com.bumptech.glide.load.j.n;
import com.bumptech.glide.load.j.o;
import com.bumptech.glide.load.j.r;
import com.bumptech.glide.o.b;
import java.io.InputStream;

/* compiled from: ThumbnailImageLoader.java */
/* loaded from: classes3.dex */
public class h implements n<g, InputStream> {
    private final m<g, g> a;

    /* compiled from: ThumbnailImageLoader.java */
    /* loaded from: classes3.dex */
    public static class a implements o<g, InputStream> {
        private final m<g, g> a = new m<>(500);

        @Override // com.bumptech.glide.load.j.o
        public void a() {
        }

        @Override // com.bumptech.glide.load.j.o
        @NonNull
        public n<g, InputStream> c(@NonNull r rVar) {
            return new h(this.a);
        }
    }

    public h(m<g, g> mVar) {
        this.a = mVar;
    }

    @Nullable
    /* renamed from: c */
    public n.a<InputStream> b(@NonNull g gVar, int i, int i2, @NonNull f fVar) {
        m<g, g> mVar = this.a;
        if (mVar != null) {
            g a2 = mVar.a(gVar, 0, 0);
            if (a2 == null) {
                this.a.b(gVar, 0, 0, gVar);
            } else {
                gVar = a2;
            }
        }
        return new n.a<>(new b(gVar), new e(gVar));
    }

    /* renamed from: d */
    public boolean a(@NonNull g gVar) {
        return gVar.c() != null;
    }
}
