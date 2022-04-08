package com.bumptech.glide.request.k;

import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.request.d;
import com.bumptech.glide.util.j;

/* compiled from: CustomTarget.java */
/* loaded from: classes.dex */
public abstract class c<T> implements j<T> {

    /* renamed from: c  reason: collision with root package name */
    private final int f1739c;

    /* renamed from: d  reason: collision with root package name */
    private final int f1740d;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private d f1741f;

    public c() {
        this(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    @Override // com.bumptech.glide.request.k.j
    public final void a(@NonNull i iVar) {
    }

    @Override // com.bumptech.glide.request.k.j
    public void b(@Nullable Drawable drawable) {
    }

    @Override // com.bumptech.glide.request.k.j
    @Nullable
    public final d c() {
        return this.f1741f;
    }

    @Override // com.bumptech.glide.request.k.j
    public final void f(@Nullable d dVar) {
        this.f1741f = dVar;
    }

    @Override // com.bumptech.glide.request.k.j
    public void h(@Nullable Drawable drawable) {
    }

    @Override // com.bumptech.glide.request.k.j
    public final void j(@NonNull i iVar) {
        iVar.d(this.f1739c, this.f1740d);
    }

    @Override // com.bumptech.glide.manager.m
    public void onDestroy() {
    }

    @Override // com.bumptech.glide.manager.m
    public void onStart() {
    }

    @Override // com.bumptech.glide.manager.m
    public void onStop() {
    }

    public c(int i, int i2) {
        if (j.u(i, i2)) {
            this.f1739c = i;
            this.f1740d = i2;
            return;
        }
        throw new IllegalArgumentException("Width and height must both be > 0 or Target#SIZE_ORIGINAL, but given width: " + i + " and height: " + i2);
    }
}
