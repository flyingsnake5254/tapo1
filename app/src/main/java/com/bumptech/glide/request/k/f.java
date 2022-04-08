package com.bumptech.glide.request.k;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.request.l.b;

/* compiled from: ImageViewTarget.java */
/* loaded from: classes.dex */
public abstract class f<Z> extends k<ImageView, Z> implements b.a {
    @Nullable
    private Animatable p1;

    public f(ImageView imageView) {
        super(imageView);
    }

    private void m(@Nullable Z z) {
        if (z instanceof Animatable) {
            Animatable animatable = (Animatable) z;
            this.p1 = animatable;
            animatable.start();
            return;
        }
        this.p1 = null;
    }

    private void p(@Nullable Z z) {
        o(z);
        m(z);
    }

    @Override // com.bumptech.glide.request.k.k, com.bumptech.glide.request.k.a, com.bumptech.glide.request.k.j
    public void b(@Nullable Drawable drawable) {
        super.b(drawable);
        p(null);
        n(drawable);
    }

    @Override // com.bumptech.glide.request.k.k, com.bumptech.glide.request.k.a, com.bumptech.glide.request.k.j
    public void d(@Nullable Drawable drawable) {
        super.d(drawable);
        Animatable animatable = this.p1;
        if (animatable != null) {
            animatable.stop();
        }
        p(null);
        n(drawable);
    }

    @Override // com.bumptech.glide.request.k.j
    public void e(@NonNull Z z, @Nullable b<? super Z> bVar) {
        if (bVar == null || !bVar.a(z, this)) {
            p(z);
        } else {
            m(z);
        }
    }

    @Override // com.bumptech.glide.request.k.a, com.bumptech.glide.request.k.j
    public void h(@Nullable Drawable drawable) {
        super.h(drawable);
        p(null);
        n(drawable);
    }

    public void n(Drawable drawable) {
        ((ImageView) this.q).setImageDrawable(drawable);
    }

    protected abstract void o(@Nullable Z z);

    @Override // com.bumptech.glide.request.k.a, com.bumptech.glide.manager.m
    public void onStart() {
        Animatable animatable = this.p1;
        if (animatable != null) {
            animatable.start();
        }
    }

    @Override // com.bumptech.glide.request.k.a, com.bumptech.glide.manager.m
    public void onStop() {
        Animatable animatable = this.p1;
        if (animatable != null) {
            animatable.stop();
        }
    }
}
