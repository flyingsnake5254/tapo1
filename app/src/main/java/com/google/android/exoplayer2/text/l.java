package com.google.android.exoplayer2.text;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c2;
import com.google.android.exoplayer2.i1;
import com.google.android.exoplayer2.u0;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.o0;
import com.google.android.exoplayer2.util.u;
import com.google.android.exoplayer2.util.y;
import java.util.Collections;
import java.util.List;

/* compiled from: TextRenderer.java */
/* loaded from: classes.dex */
public final class l extends u0 implements Handler.Callback {
    @Nullable
    private final Handler I3;
    private final k J3;
    private final h K3;
    private final i1 L3;
    private boolean M3;
    private boolean N3;
    private boolean O3;
    private int P3;
    @Nullable
    private Format Q3;
    @Nullable
    private g R3;
    @Nullable
    private i S3;
    @Nullable
    private j T3;
    @Nullable
    private j U3;
    private int V3;
    private long W3;

    public l(k kVar, @Nullable Looper looper) {
        this(kVar, looper, h.a);
    }

    private void N() {
        W(Collections.emptyList());
    }

    private long O() {
        if (this.V3 == -1) {
            return Long.MAX_VALUE;
        }
        g.e(this.T3);
        if (this.V3 >= this.T3.d()) {
            return Long.MAX_VALUE;
        }
        return this.T3.c(this.V3);
    }

    private void P(SubtitleDecoderException subtitleDecoderException) {
        String valueOf = String.valueOf(this.Q3);
        StringBuilder sb = new StringBuilder(valueOf.length() + 39);
        sb.append("Subtitle decoding failed. streamFormat=");
        sb.append(valueOf);
        u.d("TextRenderer", sb.toString(), subtitleDecoderException);
        N();
        U();
    }

    private void Q() {
        this.O3 = true;
        this.R3 = this.K3.b((Format) g.e(this.Q3));
    }

    private void R(List<c> list) {
        this.J3.B(list);
    }

    private void S() {
        this.S3 = null;
        this.V3 = -1;
        j jVar = this.T3;
        if (jVar != null) {
            jVar.n();
            this.T3 = null;
        }
        j jVar2 = this.U3;
        if (jVar2 != null) {
            jVar2.n();
            this.U3 = null;
        }
    }

    private void T() {
        S();
        ((g) g.e(this.R3)).release();
        this.R3 = null;
        this.P3 = 0;
    }

    private void U() {
        T();
        Q();
    }

    private void W(List<c> list) {
        Handler handler = this.I3;
        if (handler != null) {
            handler.obtainMessage(0, list).sendToTarget();
        } else {
            R(list);
        }
    }

    @Override // com.google.android.exoplayer2.u0
    protected void E() {
        this.Q3 = null;
        this.W3 = -9223372036854775807L;
        N();
        T();
    }

    @Override // com.google.android.exoplayer2.u0
    protected void G(long j, boolean z) {
        N();
        this.M3 = false;
        this.N3 = false;
        this.W3 = -9223372036854775807L;
        if (this.P3 != 0) {
            U();
            return;
        }
        S();
        ((g) g.e(this.R3)).flush();
    }

    @Override // com.google.android.exoplayer2.u0
    protected void K(Format[] formatArr, long j, long j2) {
        this.Q3 = formatArr[0];
        if (this.R3 != null) {
            this.P3 = 1;
        } else {
            Q();
        }
    }

    public void V(long j) {
        g.g(m());
        this.W3 = j;
    }

    @Override // com.google.android.exoplayer2.d2
    public int a(Format format) {
        if (this.K3.a(format)) {
            return c2.a(format.a4 == null ? 4 : 2);
        } else if (y.p(format.H3)) {
            return c2.a(1);
        } else {
            return c2.a(0);
        }
    }

    @Override // com.google.android.exoplayer2.b2
    public boolean d() {
        return this.N3;
    }

    @Override // com.google.android.exoplayer2.b2
    public boolean g() {
        return true;
    }

    @Override // com.google.android.exoplayer2.b2, com.google.android.exoplayer2.d2
    public String getName() {
        return "TextRenderer";
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what == 0) {
            R((List) message.obj);
            return true;
        }
        throw new IllegalStateException();
    }

    @Override // com.google.android.exoplayer2.b2
    public void t(long j, long j2) {
        boolean z;
        if (m()) {
            long j3 = this.W3;
            if (j3 != -9223372036854775807L && j >= j3) {
                S();
                this.N3 = true;
            }
        }
        if (!this.N3) {
            if (this.U3 == null) {
                ((g) g.e(this.R3)).a(j);
                try {
                    this.U3 = ((g) g.e(this.R3)).b();
                } catch (SubtitleDecoderException e2) {
                    P(e2);
                    return;
                }
            }
            if (getState() == 2) {
                if (this.T3 != null) {
                    long O = O();
                    z = false;
                    while (O <= j) {
                        this.V3++;
                        O = O();
                        z = true;
                    }
                } else {
                    z = false;
                }
                j jVar = this.U3;
                if (jVar != null) {
                    if (jVar.k()) {
                        if (!z && O() == Long.MAX_VALUE) {
                            if (this.P3 == 2) {
                                U();
                            } else {
                                S();
                                this.N3 = true;
                            }
                        }
                    } else if (jVar.f2170d <= j) {
                        j jVar2 = this.T3;
                        if (jVar2 != null) {
                            jVar2.n();
                        }
                        this.V3 = jVar.a(j);
                        this.T3 = jVar;
                        this.U3 = null;
                        z = true;
                    }
                }
                if (z) {
                    g.e(this.T3);
                    W(this.T3.b(j));
                }
                if (this.P3 != 2) {
                    while (!this.M3) {
                        try {
                            i iVar = this.S3;
                            if (iVar == null) {
                                iVar = ((g) g.e(this.R3)).d();
                                if (iVar != null) {
                                    this.S3 = iVar;
                                } else {
                                    return;
                                }
                            }
                            if (this.P3 == 1) {
                                iVar.m(4);
                                ((g) g.e(this.R3)).c(iVar);
                                this.S3 = null;
                                this.P3 = 2;
                                return;
                            }
                            int L = L(this.L3, iVar, 0);
                            if (L == -4) {
                                if (iVar.k()) {
                                    this.M3 = true;
                                    this.O3 = false;
                                } else {
                                    Format format = this.L3.f2321b;
                                    if (format != null) {
                                        iVar.p1 = format.L3;
                                        iVar.p();
                                        this.O3 &= !iVar.l();
                                    } else {
                                        return;
                                    }
                                }
                                if (!this.O3) {
                                    ((g) g.e(this.R3)).c(iVar);
                                    this.S3 = null;
                                }
                            } else if (L == -3) {
                                return;
                            }
                        } catch (SubtitleDecoderException e3) {
                            P(e3);
                            return;
                        }
                    }
                }
            }
        }
    }

    public l(k kVar, @Nullable Looper looper, h hVar) {
        super(3);
        this.J3 = (k) g.e(kVar);
        this.I3 = looper == null ? null : o0.u(looper, this);
        this.K3 = hVar;
        this.L3 = new i1();
        this.W3 = -9223372036854775807L;
    }
}
