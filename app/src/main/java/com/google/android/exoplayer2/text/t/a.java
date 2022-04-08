package com.google.android.exoplayer2.text.t;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.google.android.exoplayer2.text.c;
import com.google.android.exoplayer2.text.d;
import com.google.android.exoplayer2.text.f;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.o0;
import com.google.android.exoplayer2.util.u;
import com.google.common.base.e;
import io.netty.handler.codec.memcache.binary.BinaryMemcacheOpcodes;
import java.util.List;

/* compiled from: Tx3gDecoder.java */
/* loaded from: classes.dex */
public final class a extends d {
    private final d0 o = new d0();
    private final boolean p;
    private final int q;
    private final int r;
    private final String s;
    private final float t;
    private final int u;

    public a(List<byte[]> list) {
        super("Tx3gDecoder");
        String str = "sans-serif";
        boolean z = true;
        if (list.size() == 1 && (list.get(0).length == 48 || list.get(0).length == 53)) {
            byte[] bArr = list.get(0);
            this.q = bArr[24];
            this.r = ((bArr[26] & 255) << 24) | ((bArr[27] & 255) << 16) | ((bArr[28] & 255) << 8) | (bArr[29] & 255);
            this.s = "Serif".equals(o0.C(bArr, 43, bArr.length - 43)) ? "serif" : str;
            int i = bArr[25] * BinaryMemcacheOpcodes.DELETEQ;
            this.u = i;
            z = (bArr[0] & 32) == 0 ? false : z;
            this.p = z;
            if (z) {
                this.t = o0.o(((bArr[11] & 255) | ((bArr[10] & 255) << 8)) / i, 0.0f, 0.95f);
            } else {
                this.t = 0.85f;
            }
        } else {
            this.q = 0;
            this.r = -1;
            this.s = str;
            this.p = false;
            this.t = 0.85f;
            this.u = -1;
        }
    }

    private void B(d0 d0Var, SpannableStringBuilder spannableStringBuilder) throws SubtitleDecoderException {
        int i;
        C(d0Var.a() >= 12);
        int J = d0Var.J();
        int J2 = d0Var.J();
        d0Var.Q(2);
        int D = d0Var.D();
        d0Var.Q(1);
        int n = d0Var.n();
        if (J2 > spannableStringBuilder.length()) {
            int length = spannableStringBuilder.length();
            StringBuilder sb = new StringBuilder(68);
            sb.append("Truncating styl end (");
            sb.append(J2);
            sb.append(") to cueText.length() (");
            sb.append(length);
            sb.append(").");
            u.h("Tx3gDecoder", sb.toString());
            i = spannableStringBuilder.length();
        } else {
            i = J2;
        }
        if (J >= i) {
            StringBuilder sb2 = new StringBuilder(60);
            sb2.append("Ignoring styl with start (");
            sb2.append(J);
            sb2.append(") >= end (");
            sb2.append(i);
            sb2.append(").");
            u.h("Tx3gDecoder", sb2.toString());
            return;
        }
        E(spannableStringBuilder, D, this.q, J, i, 0);
        D(spannableStringBuilder, n, this.r, J, i, 0);
    }

    private static void C(boolean z) throws SubtitleDecoderException {
        if (!z) {
            throw new SubtitleDecoderException("Unexpected subtitle format.");
        }
    }

    private static void D(SpannableStringBuilder spannableStringBuilder, int i, int i2, int i3, int i4, int i5) {
        if (i != i2) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan((i >>> 8) | ((i & 255) << 24)), i3, i4, i5 | 33);
        }
    }

    private static void E(SpannableStringBuilder spannableStringBuilder, int i, int i2, int i3, int i4, int i5) {
        if (i != i2) {
            int i6 = i5 | 33;
            boolean z = true;
            boolean z2 = (i & 1) != 0;
            boolean z3 = (i & 2) != 0;
            if (z2) {
                if (z3) {
                    spannableStringBuilder.setSpan(new StyleSpan(3), i3, i4, i6);
                } else {
                    spannableStringBuilder.setSpan(new StyleSpan(1), i3, i4, i6);
                }
            } else if (z3) {
                spannableStringBuilder.setSpan(new StyleSpan(2), i3, i4, i6);
            }
            if ((i & 4) == 0) {
                z = false;
            }
            if (z) {
                spannableStringBuilder.setSpan(new UnderlineSpan(), i3, i4, i6);
            }
            if (!z && !z2 && !z3) {
                spannableStringBuilder.setSpan(new StyleSpan(0), i3, i4, i6);
            }
        }
    }

    private static void F(SpannableStringBuilder spannableStringBuilder, String str, int i, int i2) {
        if (str != "sans-serif") {
            spannableStringBuilder.setSpan(new TypefaceSpan(str), i, i2, 16711713);
        }
    }

    private static String G(d0 d0Var) throws SubtitleDecoderException {
        char g;
        C(d0Var.a() >= 2);
        int J = d0Var.J();
        if (J == 0) {
            return "";
        }
        if (d0Var.a() < 2 || ((g = d0Var.g()) != 65279 && g != 65534)) {
            return d0Var.B(J, e.f4125c);
        }
        return d0Var.B(J, e.f4128f);
    }

    @Override // com.google.android.exoplayer2.text.d
    protected f y(byte[] bArr, int i, boolean z) throws SubtitleDecoderException {
        this.o.N(bArr, i);
        String G = G(this.o);
        if (G.isEmpty()) {
            return b.f3569c;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(G);
        E(spannableStringBuilder, this.q, 0, 0, spannableStringBuilder.length(), 16711680);
        D(spannableStringBuilder, this.r, -1, 0, spannableStringBuilder.length(), 16711680);
        F(spannableStringBuilder, this.s, 0, spannableStringBuilder.length());
        float f2 = this.t;
        while (this.o.a() >= 8) {
            int e2 = this.o.e();
            int n = this.o.n();
            int n2 = this.o.n();
            boolean z2 = true;
            if (n2 == 1937013100) {
                if (this.o.a() < 2) {
                    z2 = false;
                }
                C(z2);
                int J = this.o.J();
                for (int i2 = 0; i2 < J; i2++) {
                    B(this.o, spannableStringBuilder);
                }
            } else if (n2 == 1952608120 && this.p) {
                if (this.o.a() < 2) {
                    z2 = false;
                }
                C(z2);
                f2 = o0.o(this.o.J() / this.u, 0.0f, 0.95f);
            }
            this.o.P(e2 + n);
        }
        return new b(new c.b().o(spannableStringBuilder).h(f2, 0).i(0).a());
    }
}
