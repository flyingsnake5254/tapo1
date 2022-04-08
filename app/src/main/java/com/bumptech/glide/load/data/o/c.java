package com.bumptech.glide.load.data.o;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.d;
import com.bumptech.glide.load.data.g;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: ThumbFetcher.java */
/* loaded from: classes.dex */
public class c implements d<InputStream> {

    /* renamed from: c  reason: collision with root package name */
    private final Uri f1365c;

    /* renamed from: d  reason: collision with root package name */
    private final e f1366d;

    /* renamed from: f  reason: collision with root package name */
    private InputStream f1367f;

    /* compiled from: ThumbFetcher.java */
    /* loaded from: classes.dex */
    static class a implements d {
        private static final String[] a = {"_data"};

        /* renamed from: b  reason: collision with root package name */
        private final ContentResolver f1368b;

        a(ContentResolver contentResolver) {
            this.f1368b = contentResolver;
        }

        @Override // com.bumptech.glide.load.data.o.d
        public Cursor a(Uri uri) {
            return this.f1368b.query(MediaStore.Images.Thumbnails.EXTERNAL_CONTENT_URI, a, "kind = 1 AND image_id = ?", new String[]{uri.getLastPathSegment()}, null);
        }
    }

    /* compiled from: ThumbFetcher.java */
    /* loaded from: classes.dex */
    static class b implements d {
        private static final String[] a = {"_data"};

        /* renamed from: b  reason: collision with root package name */
        private final ContentResolver f1369b;

        b(ContentResolver contentResolver) {
            this.f1369b = contentResolver;
        }

        @Override // com.bumptech.glide.load.data.o.d
        public Cursor a(Uri uri) {
            return this.f1369b.query(MediaStore.Video.Thumbnails.EXTERNAL_CONTENT_URI, a, "kind = 1 AND video_id = ?", new String[]{uri.getLastPathSegment()}, null);
        }
    }

    @VisibleForTesting
    c(Uri uri, e eVar) {
        this.f1365c = uri;
        this.f1366d = eVar;
    }

    private static c c(Context context, Uri uri, d dVar) {
        return new c(uri, new e(com.bumptech.glide.c.c(context).j().g(), dVar, com.bumptech.glide.c.c(context).e(), context.getContentResolver()));
    }

    public static c f(Context context, Uri uri) {
        return c(context, uri, new a(context.getContentResolver()));
    }

    public static c g(Context context, Uri uri) {
        return c(context, uri, new b(context.getContentResolver()));
    }

    private InputStream h() throws FileNotFoundException {
        InputStream d2 = this.f1366d.d(this.f1365c);
        int a2 = d2 != null ? this.f1366d.a(this.f1365c) : -1;
        return a2 != -1 ? new g(d2, a2) : d2;
    }

    @Override // com.bumptech.glide.load.data.d
    @NonNull
    public Class<InputStream> a() {
        return InputStream.class;
    }

    @Override // com.bumptech.glide.load.data.d
    public void b() {
        InputStream inputStream = this.f1367f;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
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
    public void e(@NonNull Priority priority, @NonNull d.a<? super InputStream> aVar) {
        try {
            InputStream h = h();
            this.f1367f = h;
            aVar.f(h);
        } catch (FileNotFoundException e2) {
            if (Log.isLoggable("MediaStoreThumbFetcher", 3)) {
                Log.d("MediaStoreThumbFetcher", "Failed to find thumbnail file", e2);
            }
            aVar.c(e2);
        }
    }
}
