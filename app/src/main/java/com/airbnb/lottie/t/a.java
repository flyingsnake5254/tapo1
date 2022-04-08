package com.airbnb.lottie.t;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.Nullable;
import com.airbnb.lottie.model.h;
import com.airbnb.lottie.v.d;
import java.util.HashMap;
import java.util.Map;

/* compiled from: FontAssetManager.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: d  reason: collision with root package name */
    private final AssetManager f1128d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private com.airbnb.lottie.a f1129e;
    private final h<String> a = new h<>();

    /* renamed from: b  reason: collision with root package name */
    private final Map<h<String>, Typeface> f1126b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    private final Map<String, Typeface> f1127c = new HashMap();

    /* renamed from: f  reason: collision with root package name */
    private String f1130f = ".ttf";

    public a(Drawable.Callback callback, @Nullable com.airbnb.lottie.a aVar) {
        this.f1129e = aVar;
        if (!(callback instanceof View)) {
            d.c("LottieDrawable must be inside of a view for images to work.");
            this.f1128d = null;
            return;
        }
        this.f1128d = ((View) callback).getContext().getAssets();
    }

    private Typeface a(String str) {
        String b2;
        Typeface typeface = this.f1127c.get(str);
        if (typeface != null) {
            return typeface;
        }
        Typeface typeface2 = null;
        com.airbnb.lottie.a aVar = this.f1129e;
        if (aVar != null) {
            typeface2 = aVar.a(str);
        }
        com.airbnb.lottie.a aVar2 = this.f1129e;
        if (!(aVar2 == null || typeface2 != null || (b2 = aVar2.b(str)) == null)) {
            typeface2 = Typeface.createFromAsset(this.f1128d, b2);
        }
        if (typeface2 == null) {
            typeface2 = Typeface.createFromAsset(this.f1128d, "fonts/" + str + this.f1130f);
        }
        this.f1127c.put(str, typeface2);
        return typeface2;
    }

    private Typeface d(Typeface typeface, String str) {
        boolean contains = str.contains("Italic");
        boolean contains2 = str.contains("Bold");
        int i = (!contains || !contains2) ? contains ? 2 : contains2 ? 1 : 0 : 3;
        return typeface.getStyle() == i ? typeface : Typeface.create(typeface, i);
    }

    public Typeface b(String str, String str2) {
        this.a.b(str, str2);
        Typeface typeface = this.f1126b.get(this.a);
        if (typeface != null) {
            return typeface;
        }
        Typeface d2 = d(a(str), str2);
        this.f1126b.put(this.a, d2);
        return d2;
    }

    public void c(@Nullable com.airbnb.lottie.a aVar) {
        this.f1129e = aVar;
    }
}
