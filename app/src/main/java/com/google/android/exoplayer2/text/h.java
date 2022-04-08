package com.google.android.exoplayer2.text;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.text.m.d;
import com.google.android.exoplayer2.text.u.c;
import com.google.android.exoplayer2.text.u.i;

/* compiled from: SubtitleDecoderFactory.java */
/* loaded from: classes.dex */
public interface h {
    public static final h a = new a();

    /* compiled from: SubtitleDecoderFactory.java */
    /* loaded from: classes.dex */
    class a implements h {
        a() {
        }

        @Override // com.google.android.exoplayer2.text.h
        public boolean a(Format format) {
            String str = format.H3;
            return "text/vtt".equals(str) || "text/x-ssa".equals(str) || "application/ttml+xml".equals(str) || "application/x-mp4-vtt".equals(str) || "application/x-subrip".equals(str) || "application/x-quicktime-tx3g".equals(str) || "application/cea-608".equals(str) || "application/x-mp4-cea-608".equals(str) || "application/cea-708".equals(str) || "application/dvbsubs".equals(str) || "application/pgs".equals(str);
        }

        @Override // com.google.android.exoplayer2.text.h
        public g b(Format format) {
            String str = format.H3;
            if (str != null) {
                char c2 = 65535;
                switch (str.hashCode()) {
                    case -1351681404:
                        if (str.equals("application/dvbsubs")) {
                            c2 = 0;
                            break;
                        }
                        break;
                    case -1248334819:
                        if (str.equals("application/pgs")) {
                            c2 = 1;
                            break;
                        }
                        break;
                    case -1026075066:
                        if (str.equals("application/x-mp4-vtt")) {
                            c2 = 2;
                            break;
                        }
                        break;
                    case -1004728940:
                        if (str.equals("text/vtt")) {
                            c2 = 3;
                            break;
                        }
                        break;
                    case 691401887:
                        if (str.equals("application/x-quicktime-tx3g")) {
                            c2 = 4;
                            break;
                        }
                        break;
                    case 822864842:
                        if (str.equals("text/x-ssa")) {
                            c2 = 5;
                            break;
                        }
                        break;
                    case 930165504:
                        if (str.equals("application/x-mp4-cea-608")) {
                            c2 = 6;
                            break;
                        }
                        break;
                    case 1566015601:
                        if (str.equals("application/cea-608")) {
                            c2 = 7;
                            break;
                        }
                        break;
                    case 1566016562:
                        if (str.equals("application/cea-708")) {
                            c2 = '\b';
                            break;
                        }
                        break;
                    case 1668750253:
                        if (str.equals("application/x-subrip")) {
                            c2 = '\t';
                            break;
                        }
                        break;
                    case 1693976202:
                        if (str.equals("application/ttml+xml")) {
                            c2 = '\n';
                            break;
                        }
                        break;
                }
                switch (c2) {
                    case 0:
                        return new com.google.android.exoplayer2.text.n.a(format.J3);
                    case 1:
                        return new com.google.android.exoplayer2.text.o.a();
                    case 2:
                        return new c();
                    case 3:
                        return new i();
                    case 4:
                        return new com.google.android.exoplayer2.text.t.a(format.J3);
                    case 5:
                        return new com.google.android.exoplayer2.text.q.a(format.J3);
                    case 6:
                    case 7:
                        return new com.google.android.exoplayer2.text.m.c(str, format.Z3, 16000L);
                    case '\b':
                        return new d(format.Z3, format.J3);
                    case '\t':
                        return new com.google.android.exoplayer2.text.r.a();
                    case '\n':
                        return new com.google.android.exoplayer2.text.s.c();
                }
            }
            String valueOf = String.valueOf(str);
            throw new IllegalArgumentException(valueOf.length() != 0 ? "Attempted to create decoder for unsupported MIME type: ".concat(valueOf) : new String("Attempted to create decoder for unsupported MIME type: "));
        }
    }

    boolean a(Format format);

    g b(Format format);
}
