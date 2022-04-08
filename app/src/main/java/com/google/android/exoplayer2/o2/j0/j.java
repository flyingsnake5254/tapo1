package com.google.android.exoplayer2.o2.j0;

import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.id3.ApicFrame;
import com.google.android.exoplayer2.metadata.id3.CommentFrame;
import com.google.android.exoplayer2.metadata.id3.Id3Frame;
import com.google.android.exoplayer2.metadata.id3.InternalFrame;
import com.google.android.exoplayer2.metadata.id3.TextInformationFrame;
import com.google.android.exoplayer2.metadata.mp4.MdtaMetadataEntry;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.u;
import io.netty.handler.codec.http.HttpHeaders;
import org.eclipse.paho.client.mqttv3.MqttTopic;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MetadataUtil.java */
/* loaded from: classes.dex */
public final class j {
    @VisibleForTesting
    static final String[] a = {"Blues", "Classic Rock", "Country", "Dance", "Disco", "Funk", "Grunge", "Hip-Hop", "Jazz", "Metal", "New Age", "Oldies", "Other", "Pop", "R&B", "Rap", "Reggae", "Rock", "Techno", "Industrial", "Alternative", "Ska", "Death Metal", "Pranks", "Soundtrack", "Euro-Techno", "Ambient", "Trip-Hop", "Vocal", "Jazz+Funk", "Fusion", "Trance", "Classical", "Instrumental", "Acid", "House", "Game", "Sound Clip", "Gospel", "Noise", "AlternRock", "Bass", "Soul", "Punk", "Space", "Meditative", "Instrumental Pop", "Instrumental Rock", "Ethnic", "Gothic", "Darkwave", "Techno-Industrial", "Electronic", "Pop-Folk", "Eurodance", "Dream", "Southern Rock", "Comedy", "Cult", "Gangsta", "Top 40", "Christian Rap", "Pop/Funk", "Jungle", "Native American", "Cabaret", "New Wave", "Psychadelic", "Rave", "Showtunes", HttpHeaders.Names.TRAILER, "Lo-Fi", "Tribal", "Acid Punk", "Acid Jazz", "Polka", "Retro", "Musical", "Rock & Roll", "Hard Rock", "Folk", "Folk-Rock", "National Folk", "Swing", "Fast Fusion", "Bebob", "Latin", "Revival", "Celtic", "Bluegrass", "Avantgarde", "Gothic Rock", "Progressive Rock", "Psychedelic Rock", "Symphonic Rock", "Slow Rock", "Big Band", "Chorus", "Easy Listening", "Acoustic", "Humour", "Speech", "Chanson", "Opera", "Chamber Music", "Sonata", "Symphony", "Booty Bass", "Primus", "Porn Groove", "Satire", "Slow Jam", "Club", "Tango", "Samba", "Folklore", "Ballad", "Power Ballad", "Rhythmic Soul", "Freestyle", "Duet", "Punk Rock", "Drum Solo", "A capella", "Euro-House", "Dance Hall", "Goa", "Drum & Bass", "Club-House", "Hardcore", "Terror", "Indie", "BritPop", "Afro-Punk", "Polsk Punk", "Beat", "Christian Gangsta Rap", "Heavy Metal", "Black Metal", "Crossover", "Contemporary Christian", "Christian Rock", "Merengue", "Salsa", "Thrash Metal", "Anime", "Jpop", "Synthpop", "Abstract", "Art Rock", "Baroque", "Bhangra", "Big beat", "Breakbeat", "Chillout", "Downtempo", "Dub", "EBM", "Eclectic", "Electro", "Electroclash", "Emo", "Experimental", "Garage", "Global", "IDM", "Illbient", "Industro-Goth", "Jam Band", "Krautrock", "Leftfield", "Lounge", "Math Rock", "New Romantic", "Nu-Breakz", "Post-Punk", "Post-Rock", "Psytrance", "Shoegaze", "Space Rock", "Trop Rock", "World Music", "Neoclassical", "Audiobook", "Audio theatre", "Neue Deutsche Welle", "Podcast", "Indie-Rock", "G-Funk", "Dubstep", "Garage Rock", "Psybient"};

    @Nullable
    private static CommentFrame a(int i, d0 d0Var) {
        int n = d0Var.n();
        if (d0Var.n() == 1684108385) {
            d0Var.Q(8);
            String y = d0Var.y(n - 16);
            return new CommentFrame("und", y, y);
        }
        String valueOf = String.valueOf(e.a(i));
        u.h("MetadataUtil", valueOf.length() != 0 ? "Failed to parse comment attribute: ".concat(valueOf) : new String("Failed to parse comment attribute: "));
        return null;
    }

    @Nullable
    private static ApicFrame b(d0 d0Var) {
        int n = d0Var.n();
        if (d0Var.n() == 1684108385) {
            int b2 = e.b(d0Var.n());
            String str = b2 == 13 ? "image/jpeg" : b2 == 14 ? "image/png" : null;
            if (str == null) {
                StringBuilder sb = new StringBuilder(41);
                sb.append("Unrecognized cover art flags: ");
                sb.append(b2);
                u.h("MetadataUtil", sb.toString());
                return null;
            }
            d0Var.Q(4);
            int i = n - 16;
            byte[] bArr = new byte[i];
            d0Var.j(bArr, 0, i);
            return new ApicFrame(str, null, 3, bArr);
        }
        u.h("MetadataUtil", "Failed to parse cover art attribute");
        return null;
    }

    @Nullable
    public static Metadata.Entry c(d0 d0Var) {
        int e2 = d0Var.e() + d0Var.n();
        int n = d0Var.n();
        int i = (n >> 24) & 255;
        try {
            if (i == 169 || i == 253) {
                int i2 = 16777215 & n;
                if (i2 == 6516084) {
                    return a(n, d0Var);
                }
                if (i2 == 7233901 || i2 == 7631467) {
                    return h(n, "TIT2", d0Var);
                }
                if (i2 == 6516589 || i2 == 7828084) {
                    return h(n, "TCOM", d0Var);
                }
                if (i2 == 6578553) {
                    return h(n, "TDRC", d0Var);
                }
                if (i2 == 4280916) {
                    return h(n, "TPE1", d0Var);
                }
                if (i2 == 7630703) {
                    return h(n, "TSSE", d0Var);
                }
                if (i2 == 6384738) {
                    return h(n, "TALB", d0Var);
                }
                if (i2 == 7108978) {
                    return h(n, "USLT", d0Var);
                }
                if (i2 == 6776174) {
                    return h(n, "TCON", d0Var);
                }
                if (i2 == 6779504) {
                    return h(n, "TIT1", d0Var);
                }
            } else if (n == 1735291493) {
                return g(d0Var);
            } else {
                if (n == 1684632427) {
                    return d(n, "TPOS", d0Var);
                }
                if (n == 1953655662) {
                    return d(n, "TRCK", d0Var);
                }
                if (n == 1953329263) {
                    return i(n, "TBPM", d0Var, true, false);
                }
                if (n == 1668311404) {
                    return i(n, "TCMP", d0Var, true, true);
                }
                if (n == 1668249202) {
                    return b(d0Var);
                }
                if (n == 1631670868) {
                    return h(n, "TPE2", d0Var);
                }
                if (n == 1936682605) {
                    return h(n, "TSOT", d0Var);
                }
                if (n == 1936679276) {
                    return h(n, "TSO2", d0Var);
                }
                if (n == 1936679282) {
                    return h(n, "TSOA", d0Var);
                }
                if (n == 1936679265) {
                    return h(n, "TSOP", d0Var);
                }
                if (n == 1936679791) {
                    return h(n, "TSOC", d0Var);
                }
                if (n == 1920233063) {
                    return i(n, "ITUNESADVISORY", d0Var, false, false);
                }
                if (n == 1885823344) {
                    return i(n, "ITUNESGAPLESS", d0Var, false, true);
                }
                if (n == 1936683886) {
                    return h(n, "TVSHOWSORT", d0Var);
                }
                if (n == 1953919848) {
                    return h(n, "TVSHOW", d0Var);
                }
                if (n == 757935405) {
                    return e(d0Var, e2);
                }
            }
            String valueOf = String.valueOf(e.a(n));
            u.b("MetadataUtil", valueOf.length() != 0 ? "Skipped unknown metadata entry: ".concat(valueOf) : new String("Skipped unknown metadata entry: "));
            return null;
        } finally {
            d0Var.P(e2);
        }
    }

    @Nullable
    private static TextInformationFrame d(int i, String str, d0 d0Var) {
        int n = d0Var.n();
        if (d0Var.n() == 1684108385 && n >= 22) {
            d0Var.Q(10);
            int J = d0Var.J();
            if (J > 0) {
                StringBuilder sb = new StringBuilder(11);
                sb.append(J);
                String sb2 = sb.toString();
                int J2 = d0Var.J();
                if (J2 > 0) {
                    String valueOf = String.valueOf(sb2);
                    StringBuilder sb3 = new StringBuilder(valueOf.length() + 12);
                    sb3.append(valueOf);
                    sb3.append(MqttTopic.TOPIC_LEVEL_SEPARATOR);
                    sb3.append(J2);
                    sb2 = sb3.toString();
                }
                return new TextInformationFrame(str, null, sb2);
            }
        }
        String valueOf2 = String.valueOf(e.a(i));
        u.h("MetadataUtil", valueOf2.length() != 0 ? "Failed to parse index/count attribute: ".concat(valueOf2) : new String("Failed to parse index/count attribute: "));
        return null;
    }

    @Nullable
    private static Id3Frame e(d0 d0Var, int i) {
        String str = null;
        String str2 = null;
        int i2 = -1;
        int i3 = -1;
        while (d0Var.e() < i) {
            int e2 = d0Var.e();
            int n = d0Var.n();
            int n2 = d0Var.n();
            d0Var.Q(4);
            if (n2 == 1835360622) {
                str = d0Var.y(n - 12);
            } else if (n2 == 1851878757) {
                str2 = d0Var.y(n - 12);
            } else {
                if (n2 == 1684108385) {
                    i2 = e2;
                    i3 = n;
                }
                d0Var.Q(n - 12);
            }
        }
        if (str == null || str2 == null || i2 == -1) {
            return null;
        }
        d0Var.P(i2);
        d0Var.Q(16);
        return new InternalFrame(str, str2, d0Var.y(i3 - 16));
    }

    @Nullable
    public static MdtaMetadataEntry f(d0 d0Var, int i, String str) {
        while (true) {
            int e2 = d0Var.e();
            if (e2 >= i) {
                return null;
            }
            int n = d0Var.n();
            if (d0Var.n() == 1684108385) {
                int n2 = d0Var.n();
                int n3 = d0Var.n();
                int i2 = n - 16;
                byte[] bArr = new byte[i2];
                d0Var.j(bArr, 0, i2);
                return new MdtaMetadataEntry(str, bArr, n3, n2);
            }
            d0Var.P(e2 + n);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x001c  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0014  */
    @androidx.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static com.google.android.exoplayer2.metadata.id3.TextInformationFrame g(com.google.android.exoplayer2.util.d0 r3) {
        /*
            int r3 = j(r3)
            r0 = 0
            if (r3 <= 0) goto L_0x0011
            java.lang.String[] r1 = com.google.android.exoplayer2.o2.j0.j.a
            int r2 = r1.length
            if (r3 > r2) goto L_0x0011
            int r3 = r3 + (-1)
            r3 = r1[r3]
            goto L_0x0012
        L_0x0011:
            r3 = r0
        L_0x0012:
            if (r3 == 0) goto L_0x001c
            com.google.android.exoplayer2.metadata.id3.TextInformationFrame r1 = new com.google.android.exoplayer2.metadata.id3.TextInformationFrame
            java.lang.String r2 = "TCON"
            r1.<init>(r2, r0, r3)
            return r1
        L_0x001c:
            java.lang.String r3 = "MetadataUtil"
            java.lang.String r1 = "Failed to parse standard genre code"
            com.google.android.exoplayer2.util.u.h(r3, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.o2.j0.j.g(com.google.android.exoplayer2.util.d0):com.google.android.exoplayer2.metadata.id3.TextInformationFrame");
    }

    @Nullable
    private static TextInformationFrame h(int i, String str, d0 d0Var) {
        int n = d0Var.n();
        if (d0Var.n() == 1684108385) {
            d0Var.Q(8);
            return new TextInformationFrame(str, null, d0Var.y(n - 16));
        }
        String valueOf = String.valueOf(e.a(i));
        u.h("MetadataUtil", valueOf.length() != 0 ? "Failed to parse text attribute: ".concat(valueOf) : new String("Failed to parse text attribute: "));
        return null;
    }

    @Nullable
    private static Id3Frame i(int i, String str, d0 d0Var, boolean z, boolean z2) {
        int j = j(d0Var);
        if (z2) {
            j = Math.min(1, j);
        }
        if (j < 0) {
            String valueOf = String.valueOf(e.a(i));
            u.h("MetadataUtil", valueOf.length() != 0 ? "Failed to parse uint8 attribute: ".concat(valueOf) : new String("Failed to parse uint8 attribute: "));
            return null;
        } else if (z) {
            return new TextInformationFrame(str, null, Integer.toString(j));
        } else {
            return new CommentFrame("und", str, Integer.toString(j));
        }
    }

    private static int j(d0 d0Var) {
        d0Var.Q(4);
        if (d0Var.n() == 1684108385) {
            d0Var.Q(8);
            return d0Var.D();
        }
        u.h("MetadataUtil", "Failed to parse uint8 attribute value");
        return -1;
    }

    public static void k(int i, com.google.android.exoplayer2.o2.u uVar, Format.b bVar) {
        if (i == 1 && uVar.a()) {
            bVar.M(uVar.f3071b).N(uVar.f3072c);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x000b, code lost:
        if (r6 != null) goto L_0x003d;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void l(int r5, @androidx.annotation.Nullable com.google.android.exoplayer2.metadata.Metadata r6, @androidx.annotation.Nullable com.google.android.exoplayer2.metadata.Metadata r7, com.google.android.exoplayer2.Format.b r8, com.google.android.exoplayer2.metadata.Metadata... r9) {
        /*
            com.google.android.exoplayer2.metadata.Metadata r0 = new com.google.android.exoplayer2.metadata.Metadata
            r1 = 0
            com.google.android.exoplayer2.metadata.Metadata$Entry[] r2 = new com.google.android.exoplayer2.metadata.Metadata.Entry[r1]
            r0.<init>(r2)
            r2 = 1
            if (r5 != r2) goto L_0x000e
            if (r6 == 0) goto L_0x003c
            goto L_0x003d
        L_0x000e:
            r6 = 2
            if (r5 != r6) goto L_0x003c
            if (r7 == 0) goto L_0x003c
            r5 = 0
        L_0x0014:
            int r6 = r7.d()
            if (r5 >= r6) goto L_0x003c
            com.google.android.exoplayer2.metadata.Metadata$Entry r6 = r7.c(r5)
            boolean r3 = r6 instanceof com.google.android.exoplayer2.metadata.mp4.MdtaMetadataEntry
            if (r3 == 0) goto L_0x0039
            com.google.android.exoplayer2.metadata.mp4.MdtaMetadataEntry r6 = (com.google.android.exoplayer2.metadata.mp4.MdtaMetadataEntry) r6
            java.lang.String r3 = r6.f2582c
            java.lang.String r4 = "com.android.capture.fps"
            boolean r3 = r4.equals(r3)
            if (r3 == 0) goto L_0x0039
            com.google.android.exoplayer2.metadata.Metadata r5 = new com.google.android.exoplayer2.metadata.Metadata
            com.google.android.exoplayer2.metadata.Metadata$Entry[] r7 = new com.google.android.exoplayer2.metadata.Metadata.Entry[r2]
            r7[r1] = r6
            r5.<init>(r7)
            r6 = r5
            goto L_0x003d
        L_0x0039:
            int r5 = r5 + 1
            goto L_0x0014
        L_0x003c:
            r6 = r0
        L_0x003d:
            int r5 = r9.length
        L_0x003e:
            if (r1 >= r5) goto L_0x0049
            r7 = r9[r1]
            com.google.android.exoplayer2.metadata.Metadata r6 = r6.b(r7)
            int r1 = r1 + 1
            goto L_0x003e
        L_0x0049:
            int r5 = r6.d()
            if (r5 <= 0) goto L_0x0052
            r8.X(r6)
        L_0x0052:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.o2.j0.j.l(int, com.google.android.exoplayer2.metadata.Metadata, com.google.android.exoplayer2.metadata.Metadata, com.google.android.exoplayer2.Format$b, com.google.android.exoplayer2.metadata.Metadata[]):void");
    }
}
