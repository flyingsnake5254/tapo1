package org.bouncycastle.pqc.crypto.xmss;

import java.util.Objects;
import org.bouncycastle.crypto.g;

/* loaded from: classes4.dex */
final class j {
    private final q a;

    /* renamed from: b  reason: collision with root package name */
    private final g f17470b;

    /* renamed from: c  reason: collision with root package name */
    private final int f17471c;

    /* renamed from: d  reason: collision with root package name */
    private final int f17472d = 16;

    /* renamed from: e  reason: collision with root package name */
    private final int f17473e;

    /* renamed from: f  reason: collision with root package name */
    private final int f17474f;
    private final int g;

    /* JADX INFO: Access modifiers changed from: protected */
    public j(g gVar) {
        Objects.requireNonNull(gVar, "digest == null");
        this.f17470b = gVar;
        int h = u.h(gVar);
        this.f17471c = h;
        int ceil = (int) Math.ceil((h * 8) / u.n(16));
        this.f17474f = ceil;
        int floor = ((int) Math.floor(u.n((16 - 1) * ceil) / u.n(16))) + 1;
        this.g = floor;
        int i = ceil + floor;
        this.f17473e = i;
        i b2 = i.b(gVar.b(), h, 16, i);
        this.a = b2;
        if (b2 == null) {
            throw new IllegalArgumentException("cannot find OID for digest algorithm: " + gVar.b());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public g a() {
        return this.f17470b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int b() {
        return this.f17471c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int c() {
        return this.f17473e;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int d() {
        return this.f17472d;
    }
}
