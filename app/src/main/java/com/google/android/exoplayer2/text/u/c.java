package com.google.android.exoplayer2.text.u;

import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.google.android.exoplayer2.text.c;
import com.google.android.exoplayer2.text.d;
import com.google.android.exoplayer2.text.f;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.o0;
import java.util.ArrayList;
import java.util.Collections;

/* compiled from: Mp4WebvttDecoder.java */
/* loaded from: classes.dex */
public final class c extends d {
    private final d0 o = new d0();

    public c() {
        super("Mp4WebvttDecoder");
    }

    private static com.google.android.exoplayer2.text.c B(d0 d0Var, int i) throws SubtitleDecoderException {
        CharSequence charSequence = null;
        c.b bVar = null;
        while (i > 0) {
            if (i >= 8) {
                int n = d0Var.n();
                int n2 = d0Var.n();
                int i2 = n - 8;
                String C = o0.C(d0Var.d(), d0Var.e(), i2);
                d0Var.Q(i2);
                i = (i - 8) - i2;
                if (n2 == 1937011815) {
                    bVar = h.o(C);
                } else if (n2 == 1885436268) {
                    charSequence = h.q(null, C.trim(), Collections.emptyList());
                }
            } else {
                throw new SubtitleDecoderException("Incomplete vtt cue box header found.");
            }
        }
        if (charSequence == null) {
            charSequence = "";
        }
        if (bVar != null) {
            return bVar.o(charSequence).a();
        }
        return h.l(charSequence);
    }

    @Override // com.google.android.exoplayer2.text.d
    protected f y(byte[] bArr, int i, boolean z) throws SubtitleDecoderException {
        this.o.N(bArr, i);
        ArrayList arrayList = new ArrayList();
        while (this.o.a() > 0) {
            if (this.o.a() >= 8) {
                int n = this.o.n();
                if (this.o.n() == 1987343459) {
                    arrayList.add(B(this.o, n - 8));
                } else {
                    this.o.Q(n - 8);
                }
            } else {
                throw new SubtitleDecoderException("Incomplete Mp4Webvtt Top Level box header found.");
            }
        }
        return new d(arrayList);
    }
}
