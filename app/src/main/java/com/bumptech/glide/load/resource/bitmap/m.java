package com.bumptech.glide.load.resource.bitmap;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import com.bumptech.glide.c;
import com.bumptech.glide.load.engine.u;
import com.bumptech.glide.load.engine.z.e;
import com.bumptech.glide.load.i;
import java.security.MessageDigest;

/* compiled from: DrawableTransformation.java */
/* loaded from: classes.dex */
public class m implements i<Drawable> {

    /* renamed from: b  reason: collision with root package name */
    private final i<Bitmap> f1641b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f1642c;

    public m(i<Bitmap> iVar, boolean z) {
        this.f1641b = iVar;
        this.f1642c = z;
    }

    private u<Drawable> d(Context context, u<Bitmap> uVar) {
        return s.f(context.getResources(), uVar);
    }

    @Override // com.bumptech.glide.load.i
    @NonNull
    public u<Drawable> a(@NonNull Context context, @NonNull u<Drawable> uVar, int i, int i2) {
        e f2 = c.c(context).f();
        Drawable drawable = uVar.get();
        u<Bitmap> a = l.a(f2, drawable, i, i2);
        if (a != null) {
            u<Bitmap> a2 = this.f1641b.a(context, a, i, i2);
            if (!a2.equals(a)) {
                return d(context, a2);
            }
            a2.c();
            return uVar;
        } else if (!this.f1642c) {
            return uVar;
        } else {
            throw new IllegalArgumentException("Unable to convert " + drawable + " to a Bitmap");
        }
    }

    @Override // com.bumptech.glide.load.c
    public void b(@NonNull MessageDigest messageDigest) {
        this.f1641b.b(messageDigest);
    }

    public i<BitmapDrawable> c() {
        return this;
    }

    @Override // com.bumptech.glide.load.c
    public boolean equals(Object obj) {
        if (obj instanceof m) {
            return this.f1641b.equals(((m) obj).f1641b);
        }
        return false;
    }

    @Override // com.bumptech.glide.load.c
    public int hashCode() {
        return this.f1641b.hashCode();
    }
}
