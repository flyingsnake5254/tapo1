package com.bumptech.glide.load.engine.a0;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.c;
import com.bumptech.glide.load.engine.a0.h;
import com.bumptech.glide.load.engine.u;
import com.bumptech.glide.util.f;

/* compiled from: LruResourceCache.java */
/* loaded from: classes.dex */
public class g extends f<c, u<?>> implements h {

    /* renamed from: e  reason: collision with root package name */
    private h.a f1399e;

    public g(long j) {
        super(j);
    }

    @Override // com.bumptech.glide.load.engine.a0.h
    @SuppressLint({"InlinedApi"})
    public void a(int i) {
        if (i >= 40) {
            b();
        } else if (i >= 20 || i == 15) {
            m(h() / 2);
        }
    }

    @Override // com.bumptech.glide.load.engine.a0.h
    @Nullable
    public /* bridge */ /* synthetic */ u c(@NonNull c cVar, @Nullable u uVar) {
        return (u) super.k(cVar, uVar);
    }

    @Override // com.bumptech.glide.load.engine.a0.h
    @Nullable
    public /* bridge */ /* synthetic */ u d(@NonNull c cVar) {
        return (u) super.l(cVar);
    }

    @Override // com.bumptech.glide.load.engine.a0.h
    public void e(@NonNull h.a aVar) {
        this.f1399e = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: n */
    public int i(@Nullable u<?> uVar) {
        if (uVar == null) {
            return super.i(null);
        }
        return uVar.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: o */
    public void j(@NonNull c cVar, @Nullable u<?> uVar) {
        h.a aVar = this.f1399e;
        if (aVar != null && uVar != null) {
            aVar.a(uVar);
        }
    }
}
