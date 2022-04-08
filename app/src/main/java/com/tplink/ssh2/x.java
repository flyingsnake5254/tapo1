package com.tplink.ssh2;

import com.jcraft.jsch.JSch;
import io.reactivex.g0.j;
import io.reactivex.q;
import io.reactivex.t;
import javax.net.SocketFactory;

/* compiled from: SSH2Client.java */
/* loaded from: classes3.dex */
public class x implements w {
    private JSch a = new JSch();

    /* renamed from: b  reason: collision with root package name */
    private d0 f15202b;

    /* renamed from: c  reason: collision with root package name */
    private b0 f15203c;

    /* renamed from: d  reason: collision with root package name */
    private w f15204d;

    /* renamed from: e  reason: collision with root package name */
    private String f15205e;

    /* renamed from: f  reason: collision with root package name */
    private int f15206f;
    private String g;
    private String h;
    private int i;
    private e0 j;

    public x(String str, String str2, String str3, int i, int i2, w wVar, SocketFactory socketFactory) {
        this.f15205e = "";
        this.f15206f = 0;
        this.g = "";
        this.h = "";
        this.i = -1;
        this.g = str;
        this.h = str2;
        this.f15205e = str3;
        this.f15206f = i;
        this.i = i2;
        this.f15204d = wVar;
        if (socketFactory != null) {
            this.j = new e0(socketFactory);
        }
    }

    private t<a0> e(Integer num) {
        b0 b0Var = new b0("127.0.0.1", num.intValue(), this);
        this.f15203c = b0Var;
        return q.f0(b0Var).N(v.f15201c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public /* synthetic */ t g(d0 d0Var) throws Exception {
        return d0Var.w(this.a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public /* synthetic */ t i(a0 a0Var) throws Exception {
        if (a0Var.a() == 0) {
            return e(Integer.valueOf(this.f15202b.d()));
        }
        return q.f0(a0Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public /* synthetic */ t k(byte[] bArr) throws Exception {
        b0 b0Var = this.f15203c;
        if (b0Var == null) {
            return q.f0(new a0(6, "SSH2 nio Socket is null"));
        }
        return b0Var.s(bArr);
    }

    public void a() {
        b0 b0Var = this.f15203c;
        if (b0Var != null) {
            b0Var.a().F0();
            this.f15203c = null;
        }
        d0 d0Var = this.f15202b;
        if (d0Var != null) {
            d0Var.c().F0();
            this.f15202b = null;
        }
    }

    public q<a0> b() {
        d0 d0Var = new d0(this.f15205e, this.f15206f, this.g, this.h, this.i, this.j);
        this.f15202b = d0Var;
        return q.f0(d0Var).N(new j() { // from class: com.tplink.ssh2.c
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                return x.this.g((d0) obj);
            }
        }).N(new j() { // from class: com.tplink.ssh2.b
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                return x.this.i((a0) obj);
            }
        });
    }

    @Override // com.tplink.ssh2.w
    public void c(byte[] bArr) {
        w wVar = this.f15204d;
        if (wVar != null) {
            wVar.c(bArr);
        }
    }

    @Override // com.tplink.ssh2.w
    public void d(a0 a0Var, EnumSSH2Status enumSSH2Status) {
        if (enumSSH2Status == EnumSSH2Status.SSH2_STATUS_DISCONNECTED) {
            a();
        }
        w wVar = this.f15204d;
        if (wVar != null) {
            wVar.d(a0Var, enumSSH2Status);
        }
    }

    public q<a0> l(byte[] bArr) {
        return q.f0(bArr).N(new j() { // from class: com.tplink.ssh2.a
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                return x.this.k((byte[]) obj);
            }
        });
    }
}
