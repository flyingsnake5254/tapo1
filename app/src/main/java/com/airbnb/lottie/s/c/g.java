package com.airbnb.lottie.s.c;

import android.graphics.Path;
import com.airbnb.lottie.model.content.Mask;
import com.airbnb.lottie.model.content.h;
import java.util.ArrayList;
import java.util.List;

/* compiled from: MaskKeyframeAnimation.java */
/* loaded from: classes.dex */
public class g {
    private final List<a<h, Path>> a;

    /* renamed from: b  reason: collision with root package name */
    private final List<a<Integer, Integer>> f1119b;

    /* renamed from: c  reason: collision with root package name */
    private final List<Mask> f1120c;

    public g(List<Mask> list) {
        this.f1120c = list;
        this.a = new ArrayList(list.size());
        this.f1119b = new ArrayList(list.size());
        for (int i = 0; i < list.size(); i++) {
            this.a.add(list.get(i).b().a());
            this.f1119b.add(list.get(i).c().a());
        }
    }

    public List<a<h, Path>> a() {
        return this.a;
    }

    public List<Mask> b() {
        return this.f1120c;
    }

    public List<a<Integer, Integer>> c() {
        return this.f1119b;
    }
}
