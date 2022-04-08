package com.google.android.exoplayer2.metadata.scte35;

import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.d;
import com.google.android.exoplayer2.metadata.g;
import com.google.android.exoplayer2.util.c0;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.l0;
import java.nio.ByteBuffer;

/* compiled from: SpliceInfoDecoder.java */
/* loaded from: classes.dex */
public final class a extends g {
    private final d0 a = new d0();

    /* renamed from: b  reason: collision with root package name */
    private final c0 f2612b = new c0();

    /* renamed from: c  reason: collision with root package name */
    private l0 f2613c;

    @Override // com.google.android.exoplayer2.metadata.g
    protected Metadata b(d dVar, ByteBuffer byteBuffer) {
        l0 l0Var = this.f2613c;
        if (l0Var == null || dVar.p1 != l0Var.e()) {
            l0 l0Var2 = new l0(dVar.x);
            this.f2613c = l0Var2;
            l0Var2.a(dVar.x - dVar.p1);
        }
        byte[] array = byteBuffer.array();
        int limit = byteBuffer.limit();
        this.a.N(array, limit);
        this.f2612b.o(array, limit);
        this.f2612b.r(39);
        long h = (this.f2612b.h(1) << 32) | this.f2612b.h(32);
        this.f2612b.r(20);
        int h2 = this.f2612b.h(12);
        int h3 = this.f2612b.h(8);
        Metadata.Entry entry = null;
        this.a.Q(14);
        if (h3 == 0) {
            entry = new SpliceNullCommand();
        } else if (h3 == 255) {
            entry = PrivateCommand.a(this.a, h2, h);
        } else if (h3 == 4) {
            entry = SpliceScheduleCommand.a(this.a);
        } else if (h3 == 5) {
            entry = SpliceInsertCommand.a(this.a, h, this.f2613c);
        } else if (h3 == 6) {
            entry = TimeSignalCommand.a(this.a, h, this.f2613c);
        }
        return entry == null ? new Metadata(new Metadata.Entry[0]) : new Metadata(entry);
    }
}
