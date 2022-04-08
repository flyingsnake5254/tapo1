package com.google.android.exoplayer2.metadata;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c2;
import com.google.android.exoplayer2.i1;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.u0;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.o0;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* compiled from: MetadataRenderer.java */
/* loaded from: classes.dex */
public final class f extends u0 implements Handler.Callback {
    private final c I3;
    private final e J3;
    @Nullable
    private final Handler K3;
    private final d L3;
    @Nullable
    private b M3;
    private boolean N3;
    private boolean O3;
    private long P3;
    private long Q3;
    @Nullable
    private Metadata R3;

    public f(e eVar, @Nullable Looper looper) {
        this(eVar, looper, c.a);
    }

    private void N(Metadata metadata, List<Metadata.Entry> list) {
        for (int i = 0; i < metadata.d(); i++) {
            Format g = metadata.c(i).g();
            if (g == null || !this.I3.a(g)) {
                list.add(metadata.c(i));
            } else {
                b b2 = this.I3.b(g);
                byte[] bArr = (byte[]) g.e(metadata.c(i).k());
                this.L3.f();
                this.L3.o(bArr.length);
                ((ByteBuffer) o0.i(this.L3.f2153f)).put(bArr);
                this.L3.p();
                Metadata a = b2.a(this.L3);
                if (a != null) {
                    N(a, list);
                }
            }
        }
    }

    private void O(Metadata metadata) {
        Handler handler = this.K3;
        if (handler != null) {
            handler.obtainMessage(0, metadata).sendToTarget();
        } else {
            P(metadata);
        }
    }

    private void P(Metadata metadata) {
        this.J3.w(metadata);
    }

    private boolean Q(long j) {
        boolean z;
        Metadata metadata = this.R3;
        if (metadata == null || this.Q3 > j) {
            z = false;
        } else {
            O(metadata);
            this.R3 = null;
            this.Q3 = -9223372036854775807L;
            z = true;
        }
        if (this.N3 && this.R3 == null) {
            this.O3 = true;
        }
        return z;
    }

    private void R() {
        if (!this.N3 && this.R3 == null) {
            this.L3.f();
            i1 A = A();
            int L = L(A, this.L3, 0);
            if (L == -4) {
                if (this.L3.k()) {
                    this.N3 = true;
                    return;
                }
                d dVar = this.L3;
                dVar.p1 = this.P3;
                dVar.p();
                Metadata a = ((b) o0.i(this.M3)).a(this.L3);
                if (a != null) {
                    ArrayList arrayList = new ArrayList(a.d());
                    N(a, arrayList);
                    if (!arrayList.isEmpty()) {
                        this.R3 = new Metadata(arrayList);
                        this.Q3 = this.L3.x;
                    }
                }
            } else if (L == -5) {
                this.P3 = ((Format) g.e(A.f2321b)).L3;
            }
        }
    }

    @Override // com.google.android.exoplayer2.u0
    protected void E() {
        this.R3 = null;
        this.Q3 = -9223372036854775807L;
        this.M3 = null;
    }

    @Override // com.google.android.exoplayer2.u0
    protected void G(long j, boolean z) {
        this.R3 = null;
        this.Q3 = -9223372036854775807L;
        this.N3 = false;
        this.O3 = false;
    }

    @Override // com.google.android.exoplayer2.u0
    protected void K(Format[] formatArr, long j, long j2) {
        this.M3 = this.I3.b(formatArr[0]);
    }

    @Override // com.google.android.exoplayer2.d2
    public int a(Format format) {
        if (!this.I3.a(format)) {
            return c2.a(0);
        }
        return c2.a(format.a4 == null ? 4 : 2);
    }

    @Override // com.google.android.exoplayer2.b2
    public boolean d() {
        return this.O3;
    }

    @Override // com.google.android.exoplayer2.b2
    public boolean g() {
        return true;
    }

    @Override // com.google.android.exoplayer2.b2, com.google.android.exoplayer2.d2
    public String getName() {
        return "MetadataRenderer";
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what == 0) {
            P((Metadata) message.obj);
            return true;
        }
        throw new IllegalStateException();
    }

    @Override // com.google.android.exoplayer2.b2
    public void t(long j, long j2) {
        boolean z = true;
        while (z) {
            R();
            z = Q(j);
        }
    }

    public f(e eVar, @Nullable Looper looper, c cVar) {
        super(5);
        this.J3 = (e) g.e(eVar);
        this.K3 = looper == null ? null : o0.u(looper, this);
        this.I3 = (c) g.e(cVar);
        this.L3 = new d();
        this.Q3 = -9223372036854775807L;
    }
}
