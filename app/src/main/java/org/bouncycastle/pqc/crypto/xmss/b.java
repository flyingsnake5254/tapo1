package org.bouncycastle.pqc.crypto.xmss;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes4.dex */
public final class b implements q {
    private static final Map<String, b> a;

    /* renamed from: b  reason: collision with root package name */
    private final int f17448b;

    /* renamed from: c  reason: collision with root package name */
    private final String f17449c;

    static {
        HashMap hashMap = new HashMap();
        hashMap.put(a("SHA-256", 32, 16, 67, 20, 2), new b(16777217, "XMSSMT_SHA2-256_W16_H20_D2"));
        hashMap.put(a("SHA-256", 32, 16, 67, 20, 4), new b(16777217, "XMSSMT_SHA2-256_W16_H20_D4"));
        hashMap.put(a("SHA-256", 32, 16, 67, 40, 2), new b(16777217, "XMSSMT_SHA2-256_W16_H40_D2"));
        hashMap.put(a("SHA-256", 32, 16, 67, 40, 2), new b(16777217, "XMSSMT_SHA2-256_W16_H40_D4"));
        hashMap.put(a("SHA-256", 32, 16, 67, 40, 4), new b(16777217, "XMSSMT_SHA2-256_W16_H40_D8"));
        hashMap.put(a("SHA-256", 32, 16, 67, 60, 8), new b(16777217, "XMSSMT_SHA2-256_W16_H60_D3"));
        hashMap.put(a("SHA-256", 32, 16, 67, 60, 6), new b(16777217, "XMSSMT_SHA2-256_W16_H60_D6"));
        hashMap.put(a("SHA-256", 32, 16, 67, 60, 12), new b(16777217, "XMSSMT_SHA2-256_W16_H60_D12"));
        hashMap.put(a("SHA2-512", 64, 16, 131, 20, 2), new b(16777217, "XMSSMT_SHA2-512_W16_H20_D2"));
        hashMap.put(a("SHA2-512", 64, 16, 131, 20, 4), new b(16777217, "XMSSMT_SHA2-512_W16_H20_D4"));
        hashMap.put(a("SHA2-512", 64, 16, 131, 40, 2), new b(16777217, "XMSSMT_SHA2-512_W16_H40_D2"));
        hashMap.put(a("SHA2-512", 64, 16, 131, 40, 4), new b(16777217, "XMSSMT_SHA2-512_W16_H40_D4"));
        hashMap.put(a("SHA2-512", 64, 16, 131, 40, 8), new b(16777217, "XMSSMT_SHA2-512_W16_H40_D8"));
        hashMap.put(a("SHA2-512", 64, 16, 131, 60, 3), new b(16777217, "XMSSMT_SHA2-512_W16_H60_D3"));
        hashMap.put(a("SHA2-512", 64, 16, 131, 60, 6), new b(16777217, "XMSSMT_SHA2-512_W16_H60_D6"));
        hashMap.put(a("SHA2-512", 64, 16, 131, 60, 12), new b(16777217, "XMSSMT_SHA2-512_W16_H60_D12"));
        hashMap.put(a("SHAKE128", 32, 16, 67, 20, 2), new b(16777217, "XMSSMT_SHAKE128_W16_H20_D2"));
        hashMap.put(a("SHAKE128", 32, 16, 67, 20, 4), new b(16777217, "XMSSMT_SHAKE128_W16_H20_D4"));
        hashMap.put(a("SHAKE128", 32, 16, 67, 40, 2), new b(16777217, "XMSSMT_SHAKE128_W16_H40_D2"));
        hashMap.put(a("SHAKE128", 32, 16, 67, 40, 4), new b(16777217, "XMSSMT_SHAKE128_W16_H40_D4"));
        hashMap.put(a("SHAKE128", 32, 16, 67, 40, 8), new b(16777217, "XMSSMT_SHAKE128_W16_H40_D8"));
        hashMap.put(a("SHAKE128", 32, 16, 67, 60, 3), new b(16777217, "XMSSMT_SHAKE128_W16_H60_D3"));
        hashMap.put(a("SHAKE128", 32, 16, 67, 60, 6), new b(16777217, "XMSSMT_SHAKE128_W16_H60_D6"));
        hashMap.put(a("SHAKE128", 32, 16, 67, 60, 12), new b(16777217, "XMSSMT_SHAKE128_W16_H60_D12"));
        hashMap.put(a("SHAKE256", 64, 16, 131, 20, 2), new b(16777217, "XMSSMT_SHAKE256_W16_H20_D2"));
        hashMap.put(a("SHAKE256", 64, 16, 131, 20, 4), new b(16777217, "XMSSMT_SHAKE256_W16_H20_D4"));
        hashMap.put(a("SHAKE256", 64, 16, 131, 40, 2), new b(16777217, "XMSSMT_SHAKE256_W16_H40_D2"));
        hashMap.put(a("SHAKE256", 64, 16, 131, 40, 4), new b(16777217, "XMSSMT_SHAKE256_W16_H40_D4"));
        hashMap.put(a("SHAKE256", 64, 16, 131, 40, 8), new b(16777217, "XMSSMT_SHAKE256_W16_H40_D8"));
        hashMap.put(a("SHAKE256", 64, 16, 131, 60, 3), new b(16777217, "XMSSMT_SHAKE256_W16_H60_D3"));
        hashMap.put(a("SHAKE256", 64, 16, 131, 60, 6), new b(16777217, "XMSSMT_SHAKE256_W16_H60_D6"));
        hashMap.put(a("SHAKE256", 64, 16, 131, 60, 12), new b(16777217, "XMSSMT_SHAKE256_W16_H60_D12"));
        a = Collections.unmodifiableMap(hashMap);
    }

    private b(int i, String str) {
        this.f17448b = i;
        this.f17449c = str;
    }

    private static String a(String str, int i, int i2, int i3, int i4, int i5) {
        Objects.requireNonNull(str, "algorithmName == null");
        return str + "-" + i + "-" + i2 + "-" + i3 + "-" + i4 + "-" + i5;
    }

    public static b b(String str, int i, int i2, int i3, int i4, int i5) {
        Objects.requireNonNull(str, "algorithmName == null");
        return a.get(a(str, i, i2, i3, i4, i5));
    }

    public String toString() {
        return this.f17449c;
    }
}
