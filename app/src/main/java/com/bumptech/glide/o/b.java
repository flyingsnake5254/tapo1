package com.bumptech.glide.o;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.c;
import com.bumptech.glide.util.i;
import java.security.MessageDigest;

/* compiled from: ObjectKey.java */
/* loaded from: classes.dex */
public final class b implements c {

    /* renamed from: b  reason: collision with root package name */
    private final Object f1713b;

    public b(@NonNull Object obj) {
        this.f1713b = i.d(obj);
    }

    @Override // com.bumptech.glide.load.c
    public void b(@NonNull MessageDigest messageDigest) {
        messageDigest.update(this.f1713b.toString().getBytes(c.a));
    }

    @Override // com.bumptech.glide.load.c
    public boolean equals(Object obj) {
        if (obj instanceof b) {
            return this.f1713b.equals(((b) obj).f1713b);
        }
        return false;
    }

    @Override // com.bumptech.glide.load.c
    public int hashCode() {
        return this.f1713b.hashCode();
    }

    public String toString() {
        return "ObjectKey{object=" + this.f1713b + '}';
    }
}
