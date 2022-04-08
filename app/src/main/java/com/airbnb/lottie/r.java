package com.airbnb.lottie;

import androidx.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;

/* compiled from: TextDelegate.java */
/* loaded from: classes.dex */
public class r {
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private final LottieAnimationView f1051b;
    private final Map<String, String> a = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    private boolean f1053d = true;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private final f f1052c = null;

    public r(LottieAnimationView lottieAnimationView) {
        this.f1051b = lottieAnimationView;
    }

    private String a(String str) {
        return str;
    }

    public final String b(String str) {
        if (this.f1053d && this.a.containsKey(str)) {
            return this.a.get(str);
        }
        String a = a(str);
        if (this.f1053d) {
            this.a.put(str, a);
        }
        return a;
    }
}
