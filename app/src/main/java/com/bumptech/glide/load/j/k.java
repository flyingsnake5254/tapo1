package com.bumptech.glide.load.j;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.d;
import com.bumptech.glide.load.f;
import com.bumptech.glide.load.j.n;
import java.io.File;
import java.io.FileNotFoundException;

/* compiled from: MediaStoreFileLoader.java */
/* loaded from: classes.dex */
public final class k implements n<Uri, File> {
    private final Context a;

    /* compiled from: MediaStoreFileLoader.java */
    /* loaded from: classes.dex */
    public static final class a implements o<Uri, File> {
        private final Context a;

        public a(Context context) {
            this.a = context;
        }

        @Override // com.bumptech.glide.load.j.o
        public void a() {
        }

        @Override // com.bumptech.glide.load.j.o
        @NonNull
        public n<Uri, File> c(r rVar) {
            return new k(this.a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: MediaStoreFileLoader.java */
    /* loaded from: classes.dex */
    public static class b implements d<File> {

        /* renamed from: c  reason: collision with root package name */
        private static final String[] f1567c = {"_data"};

        /* renamed from: d  reason: collision with root package name */
        private final Context f1568d;

        /* renamed from: f  reason: collision with root package name */
        private final Uri f1569f;

        b(Context context, Uri uri) {
            this.f1568d = context;
            this.f1569f = uri;
        }

        @Override // com.bumptech.glide.load.data.d
        @NonNull
        public Class<File> a() {
            return File.class;
        }

        @Override // com.bumptech.glide.load.data.d
        public void b() {
        }

        @Override // com.bumptech.glide.load.data.d
        public void cancel() {
        }

        @Override // com.bumptech.glide.load.data.d
        @NonNull
        public DataSource d() {
            return DataSource.LOCAL;
        }

        @Override // com.bumptech.glide.load.data.d
        public void e(@NonNull Priority priority, @NonNull d.a<? super File> aVar) {
            Cursor query = this.f1568d.getContentResolver().query(this.f1569f, f1567c, null, null, null);
            String str = null;
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        str = query.getString(query.getColumnIndexOrThrow("_data"));
                    }
                } finally {
                    query.close();
                }
            }
            if (TextUtils.isEmpty(str)) {
                aVar.c(new FileNotFoundException("Failed to find file path for: " + this.f1569f));
                return;
            }
            aVar.f(new File(str));
        }
    }

    public k(Context context) {
        this.a = context;
    }

    /* renamed from: c */
    public n.a<File> b(@NonNull Uri uri, int i, int i2, @NonNull f fVar) {
        return new n.a<>(new com.bumptech.glide.o.b(uri), new b(this.a, uri));
    }

    /* renamed from: d */
    public boolean a(@NonNull Uri uri) {
        return com.bumptech.glide.load.data.o.b.b(uri);
    }
}
