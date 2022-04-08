package com.tplink.libtpimagedownloadmedia.loader;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import androidx.annotation.CheckResult;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.c;
import com.bumptech.glide.i;
import com.bumptech.glide.manager.l;
import com.bumptech.glide.manager.q;
import com.bumptech.glide.request.g;
import java.io.File;

/* compiled from: GlideRequests.java */
/* loaded from: classes3.dex */
public class d extends i {
    public d(@NonNull c cVar, @NonNull l lVar, @NonNull q qVar, @NonNull Context context) {
        super(cVar, lVar, qVar, context);
    }

    @NonNull
    /* renamed from: C */
    public synchronized d g(@NonNull g gVar) {
        return (d) super.g(gVar);
    }

    @NonNull
    @CheckResult
    /* renamed from: D */
    public <ResourceType> c<ResourceType> i(@NonNull Class<ResourceType> cls) {
        return new c<>(this.q, this, cls, this.x);
    }

    @NonNull
    @CheckResult
    /* renamed from: E */
    public c<Bitmap> k() {
        return (c) super.k();
    }

    @NonNull
    @CheckResult
    /* renamed from: F */
    public c<Drawable> l() {
        return (c) super.l();
    }

    @NonNull
    @CheckResult
    /* renamed from: G */
    public c<Drawable> q(@Nullable File file) {
        return (c) super.q(file);
    }

    @NonNull
    @CheckResult
    /* renamed from: H */
    public c<Drawable> r(@Nullable Object obj) {
        return (c) super.r(obj);
    }

    @NonNull
    @CheckResult
    /* renamed from: I */
    public c<Drawable> s(@Nullable String str) {
        return (c) super.s(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bumptech.glide.i
    public void x(@NonNull g gVar) {
        if (gVar instanceof b) {
            super.x(gVar);
        } else {
            super.x(new b().a(gVar));
        }
    }
}
