package org.bouncycastle.util.io.pem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes4.dex */
public class b implements c {
    private static final List a = Collections.unmodifiableList(new ArrayList());

    /* renamed from: b  reason: collision with root package name */
    private String f17521b;

    /* renamed from: c  reason: collision with root package name */
    private List f17522c;

    /* renamed from: d  reason: collision with root package name */
    private byte[] f17523d;

    public b(String str, List list, byte[] bArr) {
        this.f17521b = str;
        this.f17522c = Collections.unmodifiableList(list);
        this.f17523d = bArr;
    }

    public b(String str, byte[] bArr) {
        this(str, a, bArr);
    }

    @Override // org.bouncycastle.util.io.pem.c
    public b a() throws PemGenerationException {
        return this;
    }

    public byte[] b() {
        return this.f17523d;
    }

    public List c() {
        return this.f17522c;
    }

    public String d() {
        return this.f17521b;
    }
}
