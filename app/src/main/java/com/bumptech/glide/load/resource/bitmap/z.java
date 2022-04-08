package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.engine.u;
import com.bumptech.glide.load.f;
import com.bumptech.glide.load.g;
import com.bumptech.glide.util.j;

/* compiled from: UnitBitmapDecoder.java */
/* loaded from: classes.dex */
public final class z implements g<Bitmap, Bitmap> {

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: UnitBitmapDecoder.java */
    /* loaded from: classes.dex */
    public static final class a implements u<Bitmap> {

        /* renamed from: c  reason: collision with root package name */
        private final Bitmap f1667c;

        a(@NonNull Bitmap bitmap) {
            this.f1667c = bitmap;
        }

        @Override // com.bumptech.glide.load.engine.u
        public int a() {
            return j.h(this.f1667c);
        }

        @NonNull
        /* renamed from: b */
        public Bitmap get() {
            return this.f1667c;
        }

        @Override // com.bumptech.glide.load.engine.u
        public void c() {
        }

        @Override // com.bumptech.glide.load.engine.u
        @NonNull
        public Class<Bitmap> e() {
            return Bitmap.class;
        }
    }

    /* renamed from: c */
    public u<Bitmap> b(@NonNull Bitmap bitmap, int i, int i2, @NonNull f fVar) {
        return new a(bitmap);
    }

    /* renamed from: d */
    public boolean a(@NonNull Bitmap bitmap, @NonNull f fVar) {
        return true;
    }
}
