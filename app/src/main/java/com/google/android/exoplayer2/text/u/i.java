package com.google.android.exoplayer2.text.u;

import android.text.TextUtils;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.google.android.exoplayer2.text.d;
import com.google.android.exoplayer2.text.f;
import com.google.android.exoplayer2.util.d0;
import java.util.ArrayList;

/* compiled from: WebvttDecoder.java */
/* loaded from: classes.dex */
public final class i extends d {
    private final d0 o = new d0();
    private final e p = new e();

    public i() {
        super("WebvttDecoder");
    }

    private static int B(d0 d0Var) {
        int i = -1;
        int i2 = 0;
        while (i == -1) {
            i2 = d0Var.e();
            String p = d0Var.p();
            if (p == null) {
                i = 0;
            } else if ("STYLE".equals(p)) {
                i = 2;
            } else {
                i = p.startsWith("NOTE") ? 1 : 3;
            }
        }
        d0Var.P(i2);
        return i;
    }

    private static void C(d0 d0Var) {
        do {
        } while (!TextUtils.isEmpty(d0Var.p()));
    }

    @Override // com.google.android.exoplayer2.text.d
    protected f y(byte[] bArr, int i, boolean z) throws SubtitleDecoderException {
        g m;
        this.o.N(bArr, i);
        ArrayList arrayList = new ArrayList();
        try {
            j.e(this.o);
            do {
            } while (!TextUtils.isEmpty(this.o.p()));
            ArrayList arrayList2 = new ArrayList();
            while (true) {
                int B = B(this.o);
                if (B == 0) {
                    return new k(arrayList2);
                }
                if (B == 1) {
                    C(this.o);
                } else if (B == 2) {
                    if (arrayList2.isEmpty()) {
                        this.o.p();
                        arrayList.addAll(this.p.d(this.o));
                    } else {
                        throw new SubtitleDecoderException("A style block was found after the first cue.");
                    }
                } else if (B == 3 && (m = h.m(this.o, arrayList)) != null) {
                    arrayList2.add(m);
                }
            }
        } catch (ParserException e2) {
            throw new SubtitleDecoderException(e2);
        }
    }
}
