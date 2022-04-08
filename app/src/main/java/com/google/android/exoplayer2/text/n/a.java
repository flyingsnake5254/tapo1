package com.google.android.exoplayer2.text.n;

import com.google.android.exoplayer2.text.d;
import com.google.android.exoplayer2.text.f;
import com.google.android.exoplayer2.util.d0;
import java.util.List;

/* compiled from: DvbDecoder.java */
/* loaded from: classes.dex */
public final class a extends d {
    private final b o;

    public a(List<byte[]> list) {
        super("DvbDecoder");
        d0 d0Var = new d0(list.get(0));
        this.o = new b(d0Var.J(), d0Var.J());
    }

    @Override // com.google.android.exoplayer2.text.d
    protected f y(byte[] bArr, int i, boolean z) {
        if (z) {
            this.o.r();
        }
        return new c(this.o.b(bArr, i));
    }
}
