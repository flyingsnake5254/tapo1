package com.airbnb.lottie.model;

import androidx.annotation.RestrictTo;
import com.airbnb.lottie.model.content.j;
import java.util.List;

/* compiled from: FontCharacter.java */
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
public class c {
    private final List<j> a;

    /* renamed from: b  reason: collision with root package name */
    private final char f953b;

    /* renamed from: c  reason: collision with root package name */
    private final double f954c;

    /* renamed from: d  reason: collision with root package name */
    private final double f955d;

    /* renamed from: e  reason: collision with root package name */
    private final String f956e;

    /* renamed from: f  reason: collision with root package name */
    private final String f957f;

    public c(List<j> list, char c2, double d2, double d3, String str, String str2) {
        this.a = list;
        this.f953b = c2;
        this.f954c = d2;
        this.f955d = d3;
        this.f956e = str;
        this.f957f = str2;
    }

    public static int c(char c2, String str, String str2) {
        return ((((0 + c2) * 31) + str.hashCode()) * 31) + str2.hashCode();
    }

    public List<j> a() {
        return this.a;
    }

    public double b() {
        return this.f955d;
    }

    public int hashCode() {
        return c(this.f953b, this.f957f, this.f956e);
    }
}
