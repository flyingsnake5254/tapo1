package org.bouncycastle.pqc.crypto.xmss;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes4.dex */
public final class c implements q {
    private static final Map<String, c> a;

    /* renamed from: b  reason: collision with root package name */
    private final int f17450b;

    /* renamed from: c  reason: collision with root package name */
    private final String f17451c;

    static {
        HashMap hashMap = new HashMap();
        hashMap.put(a("SHA-256", 32, 16, 67, 10), new c(16777217, "XMSS_SHA2-256_W16_H10"));
        hashMap.put(a("SHA-256", 32, 16, 67, 16), new c(33554434, "XMSS_SHA2-256_W16_H16"));
        hashMap.put(a("SHA-256", 32, 16, 67, 20), new c(50331651, "XMSS_SHA2-256_W16_H20"));
        hashMap.put(a("SHA-512", 64, 16, 131, 10), new c(67108868, "XMSS_SHA2-512_W16_H10"));
        hashMap.put(a("SHA-512", 64, 16, 131, 16), new c(83886085, "XMSS_SHA2-512_W16_H16"));
        hashMap.put(a("SHA-512", 64, 16, 131, 20), new c(100663302, "XMSS_SHA2-512_W16_H20"));
        hashMap.put(a("SHAKE128", 32, 16, 67, 10), new c(117440519, "XMSS_SHAKE128_W16_H10"));
        hashMap.put(a("SHAKE128", 32, 16, 67, 16), new c(134217736, "XMSS_SHAKE128_W16_H16"));
        hashMap.put(a("SHAKE128", 32, 16, 67, 20), new c(150994953, "XMSS_SHAKE128_W16_H20"));
        hashMap.put(a("SHAKE256", 64, 16, 131, 10), new c(167772170, "XMSS_SHAKE256_W16_H10"));
        hashMap.put(a("SHAKE256", 64, 16, 131, 16), new c(184549387, "XMSS_SHAKE256_W16_H16"));
        hashMap.put(a("SHAKE256", 64, 16, 131, 20), new c(201326604, "XMSS_SHAKE256_W16_H20"));
        a = Collections.unmodifiableMap(hashMap);
    }

    private c(int i, String str) {
        this.f17450b = i;
        this.f17451c = str;
    }

    private static String a(String str, int i, int i2, int i3, int i4) {
        Objects.requireNonNull(str, "algorithmName == null");
        return str + "-" + i + "-" + i2 + "-" + i3 + "-" + i4;
    }

    public static c b(String str, int i, int i2, int i3, int i4) {
        Objects.requireNonNull(str, "algorithmName == null");
        return a.get(a(str, i, i2, i3, i4));
    }

    public String toString() {
        return this.f17451c;
    }
}
