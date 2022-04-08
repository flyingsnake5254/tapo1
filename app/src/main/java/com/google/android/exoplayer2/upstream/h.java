package com.google.android.exoplayer2.upstream;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.o0;
import java.util.ArrayList;
import java.util.Map;

/* compiled from: BaseDataSource.java */
/* loaded from: classes.dex */
public abstract class h implements l {

    /* renamed from: b  reason: collision with root package name */
    private final boolean f3819b;

    /* renamed from: c  reason: collision with root package name */
    private final ArrayList<a0> f3820c = new ArrayList<>(1);

    /* renamed from: d  reason: collision with root package name */
    private int f3821d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private n f3822e;

    /* JADX INFO: Access modifiers changed from: protected */
    public h(boolean z) {
        this.f3819b = z;
    }

    @Override // com.google.android.exoplayer2.upstream.l
    public final void b(a0 a0Var) {
        g.e(a0Var);
        if (!this.f3820c.contains(a0Var)) {
            this.f3820c.add(a0Var);
            this.f3821d++;
        }
    }

    @Override // com.google.android.exoplayer2.upstream.l
    public /* synthetic */ Map d() {
        return k.a(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void o(int i) {
        n nVar = (n) o0.i(this.f3822e);
        for (int i2 = 0; i2 < this.f3821d; i2++) {
            this.f3820c.get(i2).f(this, nVar, this.f3819b, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void p() {
        n nVar = (n) o0.i(this.f3822e);
        for (int i = 0; i < this.f3821d; i++) {
            this.f3820c.get(i).b(this, nVar, this.f3819b);
        }
        this.f3822e = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void q(n nVar) {
        for (int i = 0; i < this.f3821d; i++) {
            this.f3820c.get(i).i(this, nVar, this.f3819b);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void r(n nVar) {
        this.f3822e = nVar;
        for (int i = 0; i < this.f3821d; i++) {
            this.f3820c.get(i).h(this, nVar, this.f3819b);
        }
    }
}
