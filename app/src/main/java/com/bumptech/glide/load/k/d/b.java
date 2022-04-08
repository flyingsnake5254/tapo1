package com.bumptech.glide.load.k.d;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.engine.u;
import com.bumptech.glide.util.i;

/* compiled from: BytesResource.java */
/* loaded from: classes.dex */
public class b implements u<byte[]> {

    /* renamed from: c  reason: collision with root package name */
    private final byte[] f1607c;

    public b(byte[] bArr) {
        this.f1607c = (byte[]) i.d(bArr);
    }

    @Override // com.bumptech.glide.load.engine.u
    public int a() {
        return this.f1607c.length;
    }

    @NonNull
    /* renamed from: b */
    public byte[] get() {
        return this.f1607c;
    }

    @Override // com.bumptech.glide.load.engine.u
    public void c() {
    }

    @Override // com.bumptech.glide.load.engine.u
    @NonNull
    public Class<byte[]> e() {
        return byte[].class;
    }
}
