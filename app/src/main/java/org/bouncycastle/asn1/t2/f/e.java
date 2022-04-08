package org.bouncycastle.asn1.t2.f;

import io.netty.util.internal.StringUtil;

/* loaded from: classes4.dex */
public class e {
    private String a;

    /* renamed from: b  reason: collision with root package name */
    private int f16920b;

    /* renamed from: c  reason: collision with root package name */
    private char f16921c;

    /* renamed from: d  reason: collision with root package name */
    private StringBuffer f16922d;

    public e(String str) {
        this(str, StringUtil.COMMA);
    }

    public e(String str, char c2) {
        this.f16922d = new StringBuffer();
        this.a = str;
        this.f16920b = -1;
        this.f16921c = c2;
    }

    public boolean a() {
        return this.f16920b != this.a.length();
    }

    public String b() {
        if (this.f16920b == this.a.length()) {
            return null;
        }
        int i = this.f16920b + 1;
        this.f16922d.setLength(0);
        boolean z = false;
        boolean z2 = false;
        while (i != this.a.length()) {
            char charAt = this.a.charAt(i);
            if (charAt == '\"') {
                if (!z) {
                    z2 = !z2;
                }
            } else if (!z && !z2) {
                if (charAt == '\\') {
                    this.f16922d.append(charAt);
                    z = true;
                } else if (charAt == this.f16921c) {
                    break;
                } else {
                    this.f16922d.append(charAt);
                }
                i++;
            }
            this.f16922d.append(charAt);
            z = false;
            i++;
        }
        this.f16920b = i;
        return this.f16922d.toString();
    }
}
