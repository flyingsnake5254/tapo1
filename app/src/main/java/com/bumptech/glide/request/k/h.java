package com.bumptech.glide.request.k;

import androidx.annotation.NonNull;
import com.bumptech.glide.util.j;

/* compiled from: SimpleTarget.java */
@Deprecated
/* loaded from: classes.dex */
public abstract class h<Z> extends a<Z> {

    /* renamed from: d  reason: collision with root package name */
    private final int f1750d;

    /* renamed from: f  reason: collision with root package name */
    private final int f1751f;

    public h() {
        this(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    @Override // com.bumptech.glide.request.k.j
    public void a(@NonNull i iVar) {
    }

    @Override // com.bumptech.glide.request.k.j
    public final void j(@NonNull i iVar) {
        if (j.u(this.f1750d, this.f1751f)) {
            iVar.d(this.f1750d, this.f1751f);
            return;
        }
        throw new IllegalArgumentException("Width and height must both be > 0 or Target#SIZE_ORIGINAL, but given width: " + this.f1750d + " and height: " + this.f1751f + ", either provide dimensions in the constructor or call override()");
    }

    public h(int i, int i2) {
        this.f1750d = i;
        this.f1751f = i2;
    }
}
