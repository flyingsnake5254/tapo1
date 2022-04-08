package com.bumptech.glide.load.j;

import android.content.res.AssetManager;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.data.d;
import com.bumptech.glide.load.data.h;
import com.bumptech.glide.load.data.m;
import com.bumptech.glide.load.f;
import com.bumptech.glide.load.j.n;
import java.io.InputStream;

/* compiled from: AssetUriLoader.java */
/* loaded from: classes.dex */
public class a<Data> implements n<Uri, Data> {
    private static final int a = 22;

    /* renamed from: b  reason: collision with root package name */
    private final AssetManager f1544b;

    /* renamed from: c  reason: collision with root package name */
    private final AbstractC0053a<Data> f1545c;

    /* compiled from: AssetUriLoader.java */
    /* renamed from: com.bumptech.glide.load.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface AbstractC0053a<Data> {
        d<Data> b(AssetManager assetManager, String str);
    }

    /* compiled from: AssetUriLoader.java */
    /* loaded from: classes.dex */
    public static class b implements o<Uri, ParcelFileDescriptor>, AbstractC0053a<ParcelFileDescriptor> {
        private final AssetManager a;

        public b(AssetManager assetManager) {
            this.a = assetManager;
        }

        @Override // com.bumptech.glide.load.j.o
        public void a() {
        }

        @Override // com.bumptech.glide.load.j.a.AbstractC0053a
        public d<ParcelFileDescriptor> b(AssetManager assetManager, String str) {
            return new h(assetManager, str);
        }

        @Override // com.bumptech.glide.load.j.o
        @NonNull
        public n<Uri, ParcelFileDescriptor> c(r rVar) {
            return new a(this.a, this);
        }
    }

    /* compiled from: AssetUriLoader.java */
    /* loaded from: classes.dex */
    public static class c implements o<Uri, InputStream>, AbstractC0053a<InputStream> {
        private final AssetManager a;

        public c(AssetManager assetManager) {
            this.a = assetManager;
        }

        @Override // com.bumptech.glide.load.j.o
        public void a() {
        }

        @Override // com.bumptech.glide.load.j.a.AbstractC0053a
        public d<InputStream> b(AssetManager assetManager, String str) {
            return new m(assetManager, str);
        }

        @Override // com.bumptech.glide.load.j.o
        @NonNull
        public n<Uri, InputStream> c(r rVar) {
            return new a(this.a, this);
        }
    }

    public a(AssetManager assetManager, AbstractC0053a<Data> aVar) {
        this.f1544b = assetManager;
        this.f1545c = aVar;
    }

    /* renamed from: c */
    public n.a<Data> b(@NonNull Uri uri, int i, int i2, @NonNull f fVar) {
        return new n.a<>(new com.bumptech.glide.o.b(uri), this.f1545c.b(this.f1544b, uri.toString().substring(a)));
    }

    /* renamed from: d */
    public boolean a(@NonNull Uri uri) {
        return "file".equals(uri.getScheme()) && !uri.getPathSegments().isEmpty() && "android_asset".equals(uri.getPathSegments().get(0));
    }
}
