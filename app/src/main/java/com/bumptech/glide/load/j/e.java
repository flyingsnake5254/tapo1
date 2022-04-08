package com.bumptech.glide.load.j;

import android.util.Base64;
import androidx.annotation.NonNull;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.d;
import com.bumptech.glide.load.f;
import com.bumptech.glide.load.j.n;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: DataUrlLoader.java */
/* loaded from: classes.dex */
public final class e<Model, Data> implements n<Model, Data> {
    private final a<Data> a;

    /* compiled from: DataUrlLoader.java */
    /* loaded from: classes.dex */
    public interface a<Data> {
        Class<Data> a();

        Data b(String str) throws IllegalArgumentException;

        void close(Data data) throws IOException;
    }

    /* compiled from: DataUrlLoader.java */
    /* loaded from: classes.dex */
    private static final class b<Data> implements d<Data> {

        /* renamed from: c  reason: collision with root package name */
        private final String f1549c;

        /* renamed from: d  reason: collision with root package name */
        private final a<Data> f1550d;

        /* renamed from: f  reason: collision with root package name */
        private Data f1551f;

        b(String str, a<Data> aVar) {
            this.f1549c = str;
            this.f1550d = aVar;
        }

        @Override // com.bumptech.glide.load.data.d
        @NonNull
        public Class<Data> a() {
            return this.f1550d.a();
        }

        @Override // com.bumptech.glide.load.data.d
        public void b() {
            try {
                this.f1550d.close(this.f1551f);
            } catch (IOException unused) {
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

        /* JADX WARN: Type inference failed for: r2v3, types: [java.lang.Object, Data] */
        @Override // com.bumptech.glide.load.data.d
        public void e(@NonNull Priority priority, @NonNull d.a<? super Data> aVar) {
            try {
                Data b2 = this.f1550d.b(this.f1549c);
                this.f1551f = b2;
                aVar.f(b2);
            } catch (IllegalArgumentException e2) {
                aVar.c(e2);
            }
        }
    }

    /* compiled from: DataUrlLoader.java */
    /* loaded from: classes.dex */
    public static final class c<Model> implements o<Model, InputStream> {
        private final a<InputStream> a = new a();

        /* compiled from: DataUrlLoader.java */
        /* loaded from: classes.dex */
        class a implements a<InputStream> {
            a() {
            }

            @Override // com.bumptech.glide.load.j.e.a
            public Class<InputStream> a() {
                return InputStream.class;
            }

            /* renamed from: c */
            public void close(InputStream inputStream) throws IOException {
                inputStream.close();
            }

            /* renamed from: d */
            public InputStream b(String str) {
                if (str.startsWith("data:image")) {
                    int indexOf = str.indexOf(44);
                    if (indexOf == -1) {
                        throw new IllegalArgumentException("Missing comma in data URL.");
                    } else if (str.substring(0, indexOf).endsWith(";base64")) {
                        return new ByteArrayInputStream(Base64.decode(str.substring(indexOf + 1), 0));
                    } else {
                        throw new IllegalArgumentException("Not a base64 image data URL.");
                    }
                } else {
                    throw new IllegalArgumentException("Not a valid image data URL.");
                }
            }
        }

        @Override // com.bumptech.glide.load.j.o
        public void a() {
        }

        @Override // com.bumptech.glide.load.j.o
        @NonNull
        public n<Model, InputStream> c(@NonNull r rVar) {
            return new e(this.a);
        }
    }

    public e(a<Data> aVar) {
        this.a = aVar;
    }

    @Override // com.bumptech.glide.load.j.n
    public boolean a(@NonNull Model model) {
        return model.toString().startsWith("data:image");
    }

    @Override // com.bumptech.glide.load.j.n
    public n.a<Data> b(@NonNull Model model, int i, int i2, @NonNull f fVar) {
        return new n.a<>(new com.bumptech.glide.o.b(model), new b(model.toString(), this.a));
    }
}
