package com.bumptech.glide.load.j.y;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.provider.MediaStore;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.d;
import com.bumptech.glide.load.f;
import com.bumptech.glide.load.j.n;
import com.bumptech.glide.load.j.o;
import com.bumptech.glide.load.j.r;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;

/* compiled from: QMediaStoreUriLoader.java */
@RequiresApi(29)
/* loaded from: classes.dex */
public final class d<DataT> implements n<Uri, DataT> {
    private final Context a;

    /* renamed from: b  reason: collision with root package name */
    private final n<File, DataT> f1593b;

    /* renamed from: c  reason: collision with root package name */
    private final n<Uri, DataT> f1594c;

    /* renamed from: d  reason: collision with root package name */
    private final Class<DataT> f1595d;

    /* compiled from: QMediaStoreUriLoader.java */
    /* loaded from: classes.dex */
    private static abstract class a<DataT> implements o<Uri, DataT> {
        private final Context a;

        /* renamed from: b  reason: collision with root package name */
        private final Class<DataT> f1596b;

        a(Context context, Class<DataT> cls) {
            this.a = context;
            this.f1596b = cls;
        }

        @Override // com.bumptech.glide.load.j.o
        public final void a() {
        }

        @Override // com.bumptech.glide.load.j.o
        @NonNull
        public final n<Uri, DataT> c(@NonNull r rVar) {
            return new d(this.a, rVar.d(File.class, this.f1596b), rVar.d(Uri.class, this.f1596b), this.f1596b);
        }
    }

    /* compiled from: QMediaStoreUriLoader.java */
    @RequiresApi(29)
    /* loaded from: classes.dex */
    public static final class b extends a<ParcelFileDescriptor> {
        public b(Context context) {
            super(context, ParcelFileDescriptor.class);
        }
    }

    /* compiled from: QMediaStoreUriLoader.java */
    @RequiresApi(29)
    /* loaded from: classes.dex */
    public static final class c extends a<InputStream> {
        public c(Context context) {
            super(context, InputStream.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: QMediaStoreUriLoader.java */
    /* renamed from: com.bumptech.glide.load.j.y.d$d  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0058d<DataT> implements com.bumptech.glide.load.data.d<DataT> {

        /* renamed from: c  reason: collision with root package name */
        private static final String[] f1597c = {"_data"};

        /* renamed from: d  reason: collision with root package name */
        private final Context f1598d;

        /* renamed from: f  reason: collision with root package name */
        private final n<File, DataT> f1599f;
        private final f p0;
        private final Class<DataT> p1;
        private volatile boolean p2;
        @Nullable
        private volatile com.bumptech.glide.load.data.d<DataT> p3;
        private final n<Uri, DataT> q;
        private final Uri x;
        private final int y;
        private final int z;

        C0058d(Context context, n<File, DataT> nVar, n<Uri, DataT> nVar2, Uri uri, int i, int i2, f fVar, Class<DataT> cls) {
            this.f1598d = context.getApplicationContext();
            this.f1599f = nVar;
            this.q = nVar2;
            this.x = uri;
            this.y = i;
            this.z = i2;
            this.p0 = fVar;
            this.p1 = cls;
        }

        @Nullable
        private n.a<DataT> c() throws FileNotFoundException {
            if (Environment.isExternalStorageLegacy()) {
                return this.f1599f.b(h(this.x), this.y, this.z, this.p0);
            }
            return this.q.b(g() ? MediaStore.setRequireOriginal(this.x) : this.x, this.y, this.z, this.p0);
        }

        @Nullable
        private com.bumptech.glide.load.data.d<DataT> f() throws FileNotFoundException {
            n.a<DataT> c2 = c();
            if (c2 != null) {
                return c2.f1575c;
            }
            return null;
        }

        private boolean g() {
            return this.f1598d.checkSelfPermission("android.permission.ACCESS_MEDIA_LOCATION") == 0;
        }

        @NonNull
        private File h(Uri uri) throws FileNotFoundException {
            Cursor cursor = null;
            try {
                Cursor query = this.f1598d.getContentResolver().query(uri, f1597c, null, null, null);
                if (query == null || !query.moveToFirst()) {
                    throw new FileNotFoundException("Failed to media store entry for: " + uri);
                }
                String string = query.getString(query.getColumnIndexOrThrow("_data"));
                if (!TextUtils.isEmpty(string)) {
                    File file = new File(string);
                    query.close();
                    return file;
                }
                throw new FileNotFoundException("File path was empty in media store for: " + uri);
            } catch (Throwable th) {
                if (0 != 0) {
                    cursor.close();
                }
                throw th;
            }
        }

        @Override // com.bumptech.glide.load.data.d
        @NonNull
        public Class<DataT> a() {
            return this.p1;
        }

        @Override // com.bumptech.glide.load.data.d
        public void b() {
            com.bumptech.glide.load.data.d<DataT> dVar = this.p3;
            if (dVar != null) {
                dVar.b();
            }
        }

        @Override // com.bumptech.glide.load.data.d
        public void cancel() {
            this.p2 = true;
            com.bumptech.glide.load.data.d<DataT> dVar = this.p3;
            if (dVar != null) {
                dVar.cancel();
            }
        }

        @Override // com.bumptech.glide.load.data.d
        @NonNull
        public DataSource d() {
            return DataSource.LOCAL;
        }

        @Override // com.bumptech.glide.load.data.d
        public void e(@NonNull Priority priority, @NonNull d.a<? super DataT> aVar) {
            try {
                com.bumptech.glide.load.data.d<DataT> f2 = f();
                if (f2 == null) {
                    aVar.c(new IllegalArgumentException("Failed to build fetcher for: " + this.x));
                    return;
                }
                this.p3 = f2;
                if (this.p2) {
                    cancel();
                } else {
                    f2.e(priority, aVar);
                }
            } catch (FileNotFoundException e2) {
                aVar.c(e2);
            }
        }
    }

    d(Context context, n<File, DataT> nVar, n<Uri, DataT> nVar2, Class<DataT> cls) {
        this.a = context.getApplicationContext();
        this.f1593b = nVar;
        this.f1594c = nVar2;
        this.f1595d = cls;
    }

    /* renamed from: c */
    public n.a<DataT> b(@NonNull Uri uri, int i, int i2, @NonNull f fVar) {
        return new n.a<>(new com.bumptech.glide.o.b(uri), new C0058d(this.a, this.f1593b, this.f1594c, uri, i, i2, fVar, this.f1595d));
    }

    /* renamed from: d */
    public boolean a(@NonNull Uri uri) {
        return Build.VERSION.SDK_INT >= 29 && com.bumptech.glide.load.data.o.b.b(uri);
    }
}
