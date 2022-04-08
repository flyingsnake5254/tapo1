package com.tplink.iot.Utils.y0;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.c;
import io.reactivex.g0.j;
import io.reactivex.l0.a;
import io.reactivex.q;

/* compiled from: GlideFileUtils.java */
/* loaded from: classes2.dex */
public class e {
    public static q<Bitmap> a(final Context context, final String str) {
        return q.f0(str).L0(a.c()).g0(new j() { // from class: com.tplink.iot.Utils.y0.b
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                Bitmap bitmap;
                String str2 = (String) obj;
                bitmap = c.u(context).k().B0(str).E0().get();
                return bitmap;
            }
        });
    }

    public static q<Drawable> b(final Context context, final String str) {
        return q.f0(str).L0(a.c()).g0(new j() { // from class: com.tplink.iot.Utils.y0.a
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                Drawable drawable;
                String str2 = (String) obj;
                drawable = c.u(context).s(str).E0().get();
                return drawable;
            }
        });
    }
}
