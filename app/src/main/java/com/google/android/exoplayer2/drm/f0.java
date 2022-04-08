package com.google.android.exoplayer2.drm;

import com.google.android.exoplayer2.util.o0;
import java.util.UUID;

/* compiled from: FrameworkMediaCrypto.java */
/* loaded from: classes.dex */
public final class f0 implements d0 {
    public static final boolean a;

    /* renamed from: b  reason: collision with root package name */
    public final UUID f2215b;

    /* renamed from: c  reason: collision with root package name */
    public final byte[] f2216c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f2217d;

    static {
        boolean z;
        if ("Amazon".equals(o0.f3934c)) {
            String str = o0.f3935d;
            if ("AFTM".equals(str) || "AFTB".equals(str)) {
                z = true;
                a = z;
            }
        }
        z = false;
        a = z;
    }

    public f0(UUID uuid, byte[] bArr, boolean z) {
        this.f2215b = uuid;
        this.f2216c = bArr;
        this.f2217d = z;
    }
}
