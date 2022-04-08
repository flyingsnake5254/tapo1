package com.bumptech.glide.load;

import android.content.Context;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.engine.u;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/* compiled from: MultiTransformation.java */
/* loaded from: classes.dex */
public class d<T> implements i<T> {

    /* renamed from: b  reason: collision with root package name */
    private final Collection<? extends i<T>> f1348b;

    @SafeVarargs
    public d(@NonNull i<T>... iVarArr) {
        if (iVarArr.length != 0) {
            this.f1348b = Arrays.asList(iVarArr);
            return;
        }
        throw new IllegalArgumentException("MultiTransformation must contain at least one Transformation");
    }

    @Override // com.bumptech.glide.load.i
    @NonNull
    public u<T> a(@NonNull Context context, @NonNull u<T> uVar, int i, int i2) {
        Iterator<? extends i<T>> it = this.f1348b.iterator();
        u<T> uVar2 = uVar;
        while (it.hasNext()) {
            u<T> a = ((i) it.next()).a(context, uVar2, i, i2);
            if (uVar2 != null && !uVar2.equals(uVar) && !uVar2.equals(a)) {
                uVar2.c();
            }
            uVar2 = a;
        }
        return uVar2;
    }

    @Override // com.bumptech.glide.load.c
    public void b(@NonNull MessageDigest messageDigest) {
        Iterator<? extends i<T>> it = this.f1348b.iterator();
        while (it.hasNext()) {
            ((i) it.next()).b(messageDigest);
        }
    }

    @Override // com.bumptech.glide.load.c
    public boolean equals(Object obj) {
        if (obj instanceof d) {
            return this.f1348b.equals(((d) obj).f1348b);
        }
        return false;
    }

    @Override // com.bumptech.glide.load.c
    public int hashCode() {
        return this.f1348b.hashCode();
    }
}
