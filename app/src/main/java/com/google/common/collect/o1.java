package com.google.common.collect;

import com.google.common.base.Equivalence;
import com.google.common.base.c;
import com.google.common.base.j;
import com.google.common.base.n;
import com.google.common.collect.p1;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;

/* compiled from: MapMaker.java */
/* loaded from: classes2.dex */
public final class o1 {
    boolean a;

    /* renamed from: b  reason: collision with root package name */
    int f4550b = -1;

    /* renamed from: c  reason: collision with root package name */
    int f4551c = -1;
    @MonotonicNonNullDecl

    /* renamed from: d  reason: collision with root package name */
    p1.n f4552d;
    @MonotonicNonNullDecl

    /* renamed from: e  reason: collision with root package name */
    p1.n f4553e;
    @MonotonicNonNullDecl

    /* renamed from: f  reason: collision with root package name */
    Equivalence<Object> f4554f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a() {
        int i = this.f4551c;
        if (i == -1) {
            return 4;
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b() {
        int i = this.f4550b;
        if (i == -1) {
            return 16;
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Equivalence<Object> c() {
        return (Equivalence) j.a(this.f4554f, d().a());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public p1.n d() {
        return (p1.n) j.a(this.f4552d, p1.n.f4576c);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public p1.n e() {
        return (p1.n) j.a(this.f4553e, p1.n.f4576c);
    }

    public <K, V> ConcurrentMap<K, V> f() {
        if (!this.a) {
            return new ConcurrentHashMap(b(), 0.75f, a());
        }
        return p1.b(this);
    }

    o1 g(p1.n nVar) {
        p1.n nVar2 = this.f4552d;
        n.x(nVar2 == null, "Key strength was already set to %s", nVar2);
        this.f4552d = (p1.n) n.o(nVar);
        if (nVar != p1.n.f4576c) {
            this.a = true;
        }
        return this;
    }

    @CanIgnoreReturnValue
    public o1 h() {
        return g(p1.n.f4577d);
    }

    public String toString() {
        j.b b2 = j.b(this);
        int i = this.f4550b;
        if (i != -1) {
            b2.b("initialCapacity", i);
        }
        int i2 = this.f4551c;
        if (i2 != -1) {
            b2.b("concurrencyLevel", i2);
        }
        p1.n nVar = this.f4552d;
        if (nVar != null) {
            b2.d("keyStrength", c.e(nVar.toString()));
        }
        p1.n nVar2 = this.f4553e;
        if (nVar2 != null) {
            b2.d("valueStrength", c.e(nVar2.toString()));
        }
        if (this.f4554f != null) {
            b2.h("keyEquivalence");
        }
        return b2.toString();
    }
}
