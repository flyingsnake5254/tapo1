package com.bumptech.glide.load.j;

import android.os.ParcelFileDescriptor;
import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.d;
import com.bumptech.glide.load.j.n;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: FileLoader.java */
/* loaded from: classes.dex */
public class f<Data> implements n<File, Data> {
    private final d<Data> a;

    /* compiled from: FileLoader.java */
    /* loaded from: classes.dex */
    public static class a<Data> implements o<File, Data> {
        private final d<Data> a;

        public a(d<Data> dVar) {
            this.a = dVar;
        }

        @Override // com.bumptech.glide.load.j.o
        public final void a() {
        }

        @Override // com.bumptech.glide.load.j.o
        @NonNull
        public final n<File, Data> c(@NonNull r rVar) {
            return new f(this.a);
        }
    }

    /* compiled from: FileLoader.java */
    /* loaded from: classes.dex */
    public static class b extends a<ParcelFileDescriptor> {

        /* compiled from: FileLoader.java */
        /* loaded from: classes.dex */
        class a implements d<ParcelFileDescriptor> {
            a() {
            }

            @Override // com.bumptech.glide.load.j.f.d
            public Class<ParcelFileDescriptor> a() {
                return ParcelFileDescriptor.class;
            }

            /* renamed from: c */
            public void close(ParcelFileDescriptor parcelFileDescriptor) throws IOException {
                parcelFileDescriptor.close();
            }

            /* renamed from: d */
            public ParcelFileDescriptor b(File file) throws FileNotFoundException {
                return ParcelFileDescriptor.open(file, 268435456);
            }
        }

        public b() {
            super(new a());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: FileLoader.java */
    /* loaded from: classes.dex */
    public static final class c<Data> implements com.bumptech.glide.load.data.d<Data> {

        /* renamed from: c  reason: collision with root package name */
        private final File f1552c;

        /* renamed from: d  reason: collision with root package name */
        private final d<Data> f1553d;

        /* renamed from: f  reason: collision with root package name */
        private Data f1554f;

        c(File file, d<Data> dVar) {
            this.f1552c = file;
            this.f1553d = dVar;
        }

        @Override // com.bumptech.glide.load.data.d
        @NonNull
        public Class<Data> a() {
            return this.f1553d.a();
        }

        @Override // com.bumptech.glide.load.data.d
        public void b() {
            Data data = this.f1554f;
            if (data != null) {
                try {
                    this.f1553d.close(data);
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

        /* JADX WARN: Type inference failed for: r3v3, types: [java.lang.Object, Data] */
        @Override // com.bumptech.glide.load.data.d
        public void e(@NonNull Priority priority, @NonNull d.a<? super Data> aVar) {
            try {
                Data b2 = this.f1553d.b(this.f1552c);
                this.f1554f = b2;
                aVar.f(b2);
            } catch (FileNotFoundException e2) {
                if (Log.isLoggable("FileLoader", 3)) {
                    Log.d("FileLoader", "Failed to open file", e2);
                }
                aVar.c(e2);
            }
        }
    }

    /* compiled from: FileLoader.java */
    /* loaded from: classes.dex */
    public interface d<Data> {
        Class<Data> a();

        Data b(File file) throws FileNotFoundException;

        void close(Data data) throws IOException;
    }

    /* compiled from: FileLoader.java */
    /* loaded from: classes.dex */
    public static class e extends a<InputStream> {

        /* compiled from: FileLoader.java */
        /* loaded from: classes.dex */
        class a implements d<InputStream> {
            a() {
            }

            @Override // com.bumptech.glide.load.j.f.d
            public Class<InputStream> a() {
                return InputStream.class;
            }

            /* renamed from: c */
            public void close(InputStream inputStream) throws IOException {
                inputStream.close();
            }

            /* renamed from: d */
            public InputStream b(File file) throws FileNotFoundException {
                return new FileInputStream(file);
            }
        }

        public e() {
            super(new a());
        }
    }

    public f(d<Data> dVar) {
        this.a = dVar;
    }

    /* renamed from: c */
    public n.a<Data> b(@NonNull File file, int i, int i2, @NonNull com.bumptech.glide.load.f fVar) {
        return new n.a<>(new com.bumptech.glide.o.b(file), new c(file, this.a));
    }

    /* renamed from: d */
    public boolean a(@NonNull File file) {
        return true;
    }
}
