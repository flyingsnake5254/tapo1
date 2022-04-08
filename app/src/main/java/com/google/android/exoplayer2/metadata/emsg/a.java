package com.google.android.exoplayer2.metadata.emsg;

import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.d;
import com.google.android.exoplayer2.metadata.g;
import com.google.android.exoplayer2.util.d0;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* compiled from: EventMessageDecoder.java */
/* loaded from: classes.dex */
public final class a extends g {
    @Override // com.google.android.exoplayer2.metadata.g
    protected Metadata b(d dVar, ByteBuffer byteBuffer) {
        return new Metadata(c(new d0(byteBuffer.array(), byteBuffer.limit())));
    }

    public EventMessage c(d0 d0Var) {
        return new EventMessage((String) com.google.android.exoplayer2.util.g.e(d0Var.x()), (String) com.google.android.exoplayer2.util.g.e(d0Var.x()), d0Var.w(), d0Var.w(), Arrays.copyOfRange(d0Var.d(), d0Var.e(), d0Var.f()));
    }
}
