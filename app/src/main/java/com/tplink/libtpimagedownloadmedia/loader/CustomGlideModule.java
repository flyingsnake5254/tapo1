package com.tplink.libtpimagedownloadmedia.loader;

import android.content.Context;
import androidx.annotation.NonNull;
import com.bumptech.glide.Registry;
import com.bumptech.glide.c;
import com.bumptech.glide.d;
import com.bumptech.glide.load.engine.j;
import com.bumptech.glide.m.a;
import com.bumptech.glide.request.g;
import com.tplink.libmediaapi.R;
import com.tplink.libtpimagedownloadmedia.loader.h;
import java.io.InputStream;

/* loaded from: classes3.dex */
public class CustomGlideModule extends a {
    @Override // com.bumptech.glide.m.c
    public void a(@NonNull Context context, @NonNull c cVar, @NonNull Registry registry) {
        registry.r(g.class, InputStream.class, new h.a());
    }

    @Override // com.bumptech.glide.m.a
    public void b(@NonNull Context context, @NonNull d dVar) {
        dVar.c(new g().k().V(R.drawable.glide_default).f(j.a));
    }

    @Override // com.bumptech.glide.m.a
    public boolean c() {
        return false;
    }
}
