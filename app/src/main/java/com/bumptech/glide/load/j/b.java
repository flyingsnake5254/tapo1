package com.bumptech.glide.load.j;

import androidx.annotation.NonNull;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.d;
import com.bumptech.glide.load.f;
import com.bumptech.glide.load.j.n;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* compiled from: ByteArrayLoader.java */
/* loaded from: classes.dex */
public class b<Data> implements n<byte[], Data> {
    private final AbstractC0055b<Data> a;

    /* compiled from: ByteArrayLoader.java */
    /* loaded from: classes.dex */
    public static class a implements o<byte[], ByteBuffer> {

        /* compiled from: ByteArrayLoader.java */
        /* renamed from: com.bumptech.glide.load.j.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class C0054a implements AbstractC0055b<ByteBuffer> {
            C0054a() {
            }

            @Override // com.bumptech.glide.load.j.b.AbstractC0055b
            public Class<ByteBuffer> a() {
                return ByteBuffer.class;
            }

            /* renamed from: c */
            public ByteBuffer b(byte[] bArr) {
                return ByteBuffer.wrap(bArr);
            }
        }

        @Override // com.bumptech.glide.load.j.o
        public void a() {
        }

        @Override // com.bumptech.glide.load.j.o
        @NonNull
        public n<byte[], ByteBuffer> c(@NonNull r rVar) {
            return new b(new C0054a());
        }
    }

    /* compiled from: ByteArrayLoader.java */
    /* renamed from: com.bumptech.glide.load.j.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface AbstractC0055b<Data> {
        Class<Data> a();

        Data b(byte[] bArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ByteArrayLoader.java */
    /* loaded from: classes.dex */
    public static class c<Data> implements com.bumptech.glide.load.data.d<Data> {

        /* renamed from: c  reason: collision with root package name */
        private final byte[] f1546c;

        /* renamed from: d  reason: collision with root package name */
        private final AbstractC0055b<Data> f1547d;

        c(byte[] bArr, AbstractC0055b<Data> bVar) {
            this.f1546c = bArr;
            this.f1547d = bVar;
        }

        @Override // com.bumptech.glide.load.data.d
        @NonNull
        public Class<Data> a() {
            return this.f1547d.a();
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
        public void e(@NonNull Priority priority, @NonNull d.a<? super Data> aVar) {
            aVar.f((Data) this.f1547d.b(this.f1546c));
        }
    }

    /* compiled from: ByteArrayLoader.java */
    /* loaded from: classes.dex */
    public static class d implements o<byte[], InputStream> {

        /* compiled from: ByteArrayLoader.java */
        /* loaded from: classes.dex */
        class a implements AbstractC0055b<InputStream> {
            a() {
            }

            @Override // com.bumptech.glide.load.j.b.AbstractC0055b
            public Class<InputStream> a() {
                return InputStream.class;
            }

            /* renamed from: c */
            public InputStream b(byte[] bArr) {
                return new ByteArrayInputStream(bArr);
            }
        }

        @Override // com.bumptech.glide.load.j.o
        public void a() {
        }

        @Override // com.bumptech.glide.load.j.o
        @NonNull
        public n<byte[], InputStream> c(@NonNull r rVar) {
            return new b(new a());
        }
    }

    public b(AbstractC0055b<Data> bVar) {
        this.a = bVar;
    }

    /* renamed from: c */
    public n.a<Data> b(@NonNull byte[] bArr, int i, int i2, @NonNull f fVar) {
        return new n.a<>(new com.bumptech.glide.o.b(bArr), new c(bArr, this.a));
    }

    /* renamed from: d */
    public boolean a(@NonNull byte[] bArr) {
        return true;
    }
}
