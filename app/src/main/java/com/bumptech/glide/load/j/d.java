package com.bumptech.glide.load.j;

import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.d;
import com.bumptech.glide.load.f;
import com.bumptech.glide.load.j.n;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

/* compiled from: ByteBufferFileLoader.java */
/* loaded from: classes.dex */
public class d implements n<File, ByteBuffer> {

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ByteBufferFileLoader.java */
    /* loaded from: classes.dex */
    public static final class a implements com.bumptech.glide.load.data.d<ByteBuffer> {

        /* renamed from: c  reason: collision with root package name */
        private final File f1548c;

        a(File file) {
            this.f1548c = file;
        }

        @Override // com.bumptech.glide.load.data.d
        @NonNull
        public Class<ByteBuffer> a() {
            return ByteBuffer.class;
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
        public void e(@NonNull Priority priority, @NonNull d.a<? super ByteBuffer> aVar) {
            try {
                aVar.f(com.bumptech.glide.util.a.a(this.f1548c));
            } catch (IOException e2) {
                if (Log.isLoggable("ByteBufferFileLoader", 3)) {
                    Log.d("ByteBufferFileLoader", "Failed to obtain ByteBuffer for file", e2);
                }
                aVar.c(e2);
            }
        }
    }

    /* compiled from: ByteBufferFileLoader.java */
    /* loaded from: classes.dex */
    public static class b implements o<File, ByteBuffer> {
        @Override // com.bumptech.glide.load.j.o
        public void a() {
        }

        @Override // com.bumptech.glide.load.j.o
        @NonNull
        public n<File, ByteBuffer> c(@NonNull r rVar) {
            return new d();
        }
    }

    /* renamed from: c */
    public n.a<ByteBuffer> b(@NonNull File file, int i, int i2, @NonNull f fVar) {
        return new n.a<>(new com.bumptech.glide.o.b(file), new a(file));
    }

    /* renamed from: d */
    public boolean a(@NonNull File file) {
        return true;
    }
}
