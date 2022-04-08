package com.airbnb.lottie.t;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import androidx.annotation.Nullable;
import com.airbnb.lottie.g;
import com.airbnb.lottie.v.d;
import com.airbnb.lottie.v.h;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ImageAssetManager.java */
/* loaded from: classes.dex */
public class b {
    private static final Object a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private final Context f1131b;

    /* renamed from: c  reason: collision with root package name */
    private String f1132c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private com.airbnb.lottie.b f1133d;

    /* renamed from: e  reason: collision with root package name */
    private final Map<String, g> f1134e;

    public b(Drawable.Callback callback, String str, com.airbnb.lottie.b bVar, Map<String, g> map) {
        String str2;
        this.f1132c = str;
        if (!TextUtils.isEmpty(str)) {
            if (this.f1132c.charAt(str2.length() - 1) != '/') {
                this.f1132c += '/';
            }
        }
        if (!(callback instanceof View)) {
            d.c("LottieDrawable must be inside of a view for images to work.");
            this.f1134e = new HashMap();
            this.f1131b = null;
            return;
        }
        this.f1131b = ((View) callback).getContext();
        this.f1134e = map;
        d(bVar);
    }

    private Bitmap c(String str, @Nullable Bitmap bitmap) {
        synchronized (a) {
            this.f1134e.get(str).f(bitmap);
        }
        return bitmap;
    }

    @Nullable
    public Bitmap a(String str) {
        g gVar = this.f1134e.get(str);
        if (gVar == null) {
            return null;
        }
        Bitmap a2 = gVar.a();
        if (a2 != null) {
            return a2;
        }
        com.airbnb.lottie.b bVar = this.f1133d;
        if (bVar != null) {
            Bitmap a3 = bVar.a(gVar);
            if (a3 != null) {
                c(str, a3);
            }
            return a3;
        }
        String b2 = gVar.b();
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inScaled = true;
        options.inDensity = 160;
        if (!b2.startsWith("data:") || b2.indexOf("base64,") <= 0) {
            try {
                if (!TextUtils.isEmpty(this.f1132c)) {
                    AssetManager assets = this.f1131b.getAssets();
                    return c(str, h.l(BitmapFactory.decodeStream(assets.open(this.f1132c + b2), null, options), gVar.e(), gVar.c()));
                }
                throw new IllegalStateException("You must set an images folder before loading an image. Set it with LottieComposition#setImagesFolder or LottieDrawable#setImagesFolder");
            } catch (IOException e2) {
                d.d("Unable to open asset.", e2);
                return null;
            }
        } else {
            try {
                byte[] decode = Base64.decode(b2.substring(b2.indexOf(44) + 1), 0);
                return c(str, BitmapFactory.decodeByteArray(decode, 0, decode.length, options));
            } catch (IllegalArgumentException e3) {
                d.d("data URL did not have correct base64 format.", e3);
                return null;
            }
        }
    }

    public boolean b(Context context) {
        return (context == null && this.f1131b == null) || this.f1131b.equals(context);
    }

    public void d(@Nullable com.airbnb.lottie.b bVar) {
        this.f1133d = bVar;
    }
}
