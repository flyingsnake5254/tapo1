package com.bumptech.glide.load.engine;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.c;
import java.security.MessageDigest;

/* compiled from: DataCacheKey.java */
/* loaded from: classes.dex */
final class d implements c {

    /* renamed from: b  reason: collision with root package name */
    private final c f1430b;

    /* renamed from: c  reason: collision with root package name */
    private final c f1431c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, c cVar2) {
        this.f1430b = cVar;
        this.f1431c = cVar2;
    }

    @Override // com.bumptech.glide.load.c
    public void b(@NonNull MessageDigest messageDigest) {
        this.f1430b.b(messageDigest);
        this.f1431c.b(messageDigest);
    }

    @Override // com.bumptech.glide.load.c
    public boolean equals(Object obj) {
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return this.f1430b.equals(dVar.f1430b) && this.f1431c.equals(dVar.f1431c);
    }

    @Override // com.bumptech.glide.load.c
    public int hashCode() {
        return (this.f1430b.hashCode() * 31) + this.f1431c.hashCode();
    }

    public String toString() {
        return "DataCacheKey{sourceKey=" + this.f1430b + ", signature=" + this.f1431c + '}';
    }
}
