package com.google.android.exoplayer2.extractor.flv;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.audio.m;
import com.google.android.exoplayer2.extractor.flv.TagPayloadReader;
import com.google.android.exoplayer2.o2.b0;
import com.google.android.exoplayer2.util.d0;
import java.util.Collections;

/* compiled from: AudioTagPayloadReader.java */
/* loaded from: classes.dex */
final class b extends TagPayloadReader {

    /* renamed from: b  reason: collision with root package name */
    private static final int[] f2250b = {5512, 11025, 22050, 44100};

    /* renamed from: c  reason: collision with root package name */
    private boolean f2251c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f2252d;

    /* renamed from: e  reason: collision with root package name */
    private int f2253e;

    public b(b0 b0Var) {
        super(b0Var);
    }

    @Override // com.google.android.exoplayer2.extractor.flv.TagPayloadReader
    protected boolean b(d0 d0Var) throws TagPayloadReader.UnsupportedFormatException {
        if (!this.f2251c) {
            int D = d0Var.D();
            int i = (D >> 4) & 15;
            this.f2253e = i;
            if (i == 2) {
                this.a.d(new Format.b().e0("audio/mpeg").H(1).f0(f2250b[(D >> 2) & 3]).E());
                this.f2252d = true;
            } else if (i == 7 || i == 8) {
                this.a.d(new Format.b().e0(i == 7 ? "audio/g711-alaw" : "audio/g711-mlaw").H(1).f0(8000).E());
                this.f2252d = true;
            } else if (i != 10) {
                int i2 = this.f2253e;
                StringBuilder sb = new StringBuilder(39);
                sb.append("Audio format not supported: ");
                sb.append(i2);
                throw new TagPayloadReader.UnsupportedFormatException(sb.toString());
            }
            this.f2251c = true;
        } else {
            d0Var.Q(1);
        }
        return true;
    }

    @Override // com.google.android.exoplayer2.extractor.flv.TagPayloadReader
    protected boolean c(d0 d0Var, long j) throws ParserException {
        if (this.f2253e == 2) {
            int a = d0Var.a();
            this.a.c(d0Var, a);
            this.a.e(j, 1, a, 0, null);
            return true;
        }
        int D = d0Var.D();
        if (D == 0 && !this.f2252d) {
            int a2 = d0Var.a();
            byte[] bArr = new byte[a2];
            d0Var.j(bArr, 0, a2);
            m.b f2 = m.f(bArr);
            this.a.d(new Format.b().e0("audio/mp4a-latm").I(f2.f2092c).H(f2.f2091b).f0(f2.a).T(Collections.singletonList(bArr)).E());
            this.f2252d = true;
            return false;
        } else if (this.f2253e == 10 && D != 1) {
            return false;
        } else {
            int a3 = d0Var.a();
            this.a.c(d0Var, a3);
            this.a.e(j, 1, a3, 0, null);
            return true;
        }
    }
}
