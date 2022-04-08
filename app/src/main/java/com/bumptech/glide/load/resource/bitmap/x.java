package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.engine.u;
import com.bumptech.glide.load.engine.z.b;
import com.bumptech.glide.load.engine.z.e;
import com.bumptech.glide.load.f;
import com.bumptech.glide.load.g;
import com.bumptech.glide.load.resource.bitmap.k;
import com.bumptech.glide.util.c;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: StreamBitmapDecoder.java */
/* loaded from: classes.dex */
public class x implements g<InputStream, Bitmap> {
    private final k a;

    /* renamed from: b  reason: collision with root package name */
    private final b f1661b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: StreamBitmapDecoder.java */
    /* loaded from: classes.dex */
    public static class a implements k.b {
        private final u a;

        /* renamed from: b  reason: collision with root package name */
        private final c f1662b;

        a(u uVar, c cVar) {
            this.a = uVar;
            this.f1662b = cVar;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.k.b
        public void a(e eVar, Bitmap bitmap) throws IOException {
            IOException a = this.f1662b.a();
            if (a != null) {
                if (bitmap != null) {
                    eVar.c(bitmap);
                }
                throw a;
            }
        }

        @Override // com.bumptech.glide.load.resource.bitmap.k.b
        public void b() {
            this.a.c();
        }
    }

    public x(k kVar, b bVar) {
        this.a = kVar;
        this.f1661b = bVar;
    }

    /* renamed from: c */
    public u<Bitmap> b(@NonNull InputStream inputStream, int i, int i2, @NonNull f fVar) throws IOException {
        u uVar;
        boolean z;
        if (inputStream instanceof u) {
            uVar = (u) inputStream;
            z = false;
        } else {
            uVar = new u(inputStream, this.f1661b);
            z = true;
        }
        c c2 = c.c(uVar);
        try {
            return this.a.g(new com.bumptech.glide.util.g(c2), i, i2, fVar, new a(uVar, c2));
        } finally {
            c2.e();
            if (z) {
                uVar.e();
            }
        }
    }

    /* renamed from: d */
    public boolean a(@NonNull InputStream inputStream, @NonNull f fVar) {
        return this.a.p(inputStream);
    }
}
