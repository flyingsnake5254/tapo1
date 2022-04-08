package com.google.android.exoplayer2.source.hls.playlist;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.o2.j0.l;
import com.google.android.exoplayer2.source.hls.HlsTrackMetadataEntry;
import com.google.android.exoplayer2.source.hls.playlist.f;
import com.google.android.exoplayer2.source.hls.playlist.g;
import com.google.android.exoplayer2.upstream.y;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.n0;
import com.google.android.exoplayer2.util.o0;
import com.google.android.exoplayer2.util.u;
import com.google.android.exoplayer2.w0;
import com.google.common.collect.j1;
import com.tplink.libtpmediastatistics.SSLClient;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.TreeMap;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;
import org.eclipse.paho.client.mqttv3.MqttTopic;

/* loaded from: classes.dex */
public final class HlsPlaylistParser implements y.a<h> {
    private final f a0;
    @Nullable
    private final g b0;
    private static final Pattern a = Pattern.compile("AVERAGE-BANDWIDTH=(\\d+)\\b");

    /* renamed from: b  reason: collision with root package name */
    private static final Pattern f3274b = Pattern.compile("VIDEO=\"(.+?)\"");

    /* renamed from: c  reason: collision with root package name */
    private static final Pattern f3275c = Pattern.compile("AUDIO=\"(.+?)\"");

    /* renamed from: d  reason: collision with root package name */
    private static final Pattern f3276d = Pattern.compile("SUBTITLES=\"(.+?)\"");

    /* renamed from: e  reason: collision with root package name */
    private static final Pattern f3277e = Pattern.compile("CLOSED-CAPTIONS=\"(.+?)\"");

    /* renamed from: f  reason: collision with root package name */
    private static final Pattern f3278f = Pattern.compile("[^-]BANDWIDTH=(\\d+)\\b");
    private static final Pattern g = Pattern.compile("CHANNELS=\"(.+?)\"");
    private static final Pattern h = Pattern.compile("CODECS=\"(.+?)\"");
    private static final Pattern i = Pattern.compile("RESOLUTION=(\\d+x\\d+)");
    private static final Pattern j = Pattern.compile("FRAME-RATE=([\\d\\.]+)\\b");
    private static final Pattern k = Pattern.compile("#EXT-X-TARGETDURATION:(\\d+)\\b");
    private static final Pattern l = Pattern.compile("DURATION=([\\d\\.]+)\\b");
    private static final Pattern m = Pattern.compile("PART-TARGET=([\\d\\.]+)\\b");
    private static final Pattern n = Pattern.compile("#EXT-X-VERSION:(\\d+)\\b");
    private static final Pattern o = Pattern.compile("#EXT-X-PLAYLIST-TYPE:(.+)\\b");
    private static final Pattern p = Pattern.compile("CAN-SKIP-UNTIL=([\\d\\.]+)\\b");
    private static final Pattern q = c("CAN-SKIP-DATERANGES");
    private static final Pattern r = Pattern.compile("SKIPPED-SEGMENTS=(\\d+)\\b");
    private static final Pattern s = Pattern.compile("[:|,]HOLD-BACK=([\\d\\.]+)\\b");
    private static final Pattern t = Pattern.compile("PART-HOLD-BACK=([\\d\\.]+)\\b");
    private static final Pattern u = c("CAN-BLOCK-RELOAD");
    private static final Pattern v = Pattern.compile("#EXT-X-MEDIA-SEQUENCE:(\\d+)\\b");
    private static final Pattern w = Pattern.compile("#EXTINF:([\\d\\.]+)\\b");
    private static final Pattern x = Pattern.compile("#EXTINF:[\\d\\.]+\\b,(.+)");
    private static final Pattern y = Pattern.compile("LAST-MSN=(\\d+)\\b");
    private static final Pattern z = Pattern.compile("LAST-PART=(\\d+)\\b");
    private static final Pattern A = Pattern.compile("TIME-OFFSET=(-?[\\d\\.]+)\\b");
    private static final Pattern B = Pattern.compile("#EXT-X-BYTERANGE:(\\d+(?:@\\d+)?)\\b");
    private static final Pattern C = Pattern.compile("BYTERANGE=\"(\\d+(?:@\\d+)?)\\b\"");
    private static final Pattern D = Pattern.compile("BYTERANGE-START=(\\d+)\\b");
    private static final Pattern E = Pattern.compile("BYTERANGE-LENGTH=(\\d+)\\b");
    private static final Pattern F = Pattern.compile("METHOD=(NONE|AES-128|SAMPLE-AES|SAMPLE-AES-CENC|SAMPLE-AES-CTR)\\s*(?:,|$)");
    private static final Pattern G = Pattern.compile("KEYFORMAT=\"(.+?)\"");
    private static final Pattern H = Pattern.compile("KEYFORMATVERSIONS=\"(.+?)\"");
    private static final Pattern I = Pattern.compile("URI=\"(.+?)\"");
    private static final Pattern J = Pattern.compile("IV=([^,.*]+)");
    private static final Pattern K = Pattern.compile("TYPE=(AUDIO|VIDEO|SUBTITLES|CLOSED-CAPTIONS)");
    private static final Pattern L = Pattern.compile("TYPE=(PART|MAP)");
    private static final Pattern M = Pattern.compile("LANGUAGE=\"(.+?)\"");
    private static final Pattern N = Pattern.compile("NAME=\"(.+?)\"");
    private static final Pattern O = Pattern.compile("GROUP-ID=\"(.+?)\"");
    private static final Pattern P = Pattern.compile("CHARACTERISTICS=\"(.+?)\"");
    private static final Pattern Q = Pattern.compile("INSTREAM-ID=\"((?:CC|SERVICE)\\d+)\"");
    private static final Pattern R = c("AUTOSELECT");
    private static final Pattern S = c("DEFAULT");
    private static final Pattern T = c("FORCED");
    private static final Pattern U = c("INDEPENDENT");
    private static final Pattern V = c("GAP");
    private static final Pattern W = c("PRECISE");
    private static final Pattern X = Pattern.compile("VALUE=\"(.+?)\"");
    private static final Pattern Y = Pattern.compile("IMPORT=\"(.+?)\"");
    private static final Pattern Z = Pattern.compile("\\{\\$([a-zA-Z0-9\\-_]+)\\}");

    /* loaded from: classes.dex */
    public static final class DeltaUpdateException extends IOException {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private final BufferedReader a;

        /* renamed from: b  reason: collision with root package name */
        private final Queue<String> f3279b;
        @Nullable

        /* renamed from: c  reason: collision with root package name */
        private String f3280c;

        public a(Queue<String> queue, BufferedReader bufferedReader) {
            this.f3279b = queue;
            this.a = bufferedReader;
        }

        @EnsuresNonNullIf(expression = {"next"}, result = true)
        public boolean a() throws IOException {
            String trim;
            if (this.f3280c != null) {
                return true;
            }
            if (!this.f3279b.isEmpty()) {
                this.f3280c = (String) g.e(this.f3279b.poll());
                return true;
            }
            do {
                String readLine = this.a.readLine();
                this.f3280c = readLine;
                if (readLine == null) {
                    return false;
                }
                trim = readLine.trim();
                this.f3280c = trim;
            } while (trim.isEmpty());
            return true;
        }

        public String b() throws IOException {
            if (a()) {
                String str = this.f3280c;
                this.f3280c = null;
                return str;
            }
            throw new NoSuchElementException();
        }
    }

    public HlsPlaylistParser() {
        this(f.f3291d, null);
    }

    private static String A(String str, Map<String, String> map) {
        Matcher matcher = Z.matcher(str);
        StringBuffer stringBuffer = new StringBuffer();
        while (matcher.find()) {
            String group = matcher.group(1);
            if (map.containsKey(group)) {
                matcher.appendReplacement(stringBuffer, Matcher.quoteReplacement(map.get(group)));
            }
        }
        matcher.appendTail(stringBuffer);
        return stringBuffer.toString();
    }

    private static int B(BufferedReader bufferedReader, boolean z2, int i2) throws IOException {
        while (i2 != -1 && Character.isWhitespace(i2) && (z2 || !o0.l0(i2))) {
            i2 = bufferedReader.read();
        }
        return i2;
    }

    private static boolean b(BufferedReader bufferedReader) throws IOException {
        int read = bufferedReader.read();
        if (read == 239) {
            if (!(bufferedReader.read() == 187 && bufferedReader.read() == 191)) {
                return false;
            }
            read = bufferedReader.read();
        }
        int B2 = B(bufferedReader, true, read);
        for (int i2 = 0; i2 < 7; i2++) {
            if (B2 != "#EXTM3U".charAt(i2)) {
                return false;
            }
            B2 = bufferedReader.read();
        }
        return o0.l0(B(bufferedReader, false, B2));
    }

    private static Pattern c(String str) {
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 9);
        sb.append(str);
        sb.append("=(");
        sb.append("NO");
        sb.append("|");
        sb.append("YES");
        sb.append(")");
        return Pattern.compile(sb.toString());
    }

    private static DrmInitData d(@Nullable String str, DrmInitData.SchemeData[] schemeDataArr) {
        DrmInitData.SchemeData[] schemeDataArr2 = new DrmInitData.SchemeData[schemeDataArr.length];
        for (int i2 = 0; i2 < schemeDataArr.length; i2++) {
            schemeDataArr2[i2] = schemeDataArr[i2].a(null);
        }
        return new DrmInitData(str, schemeDataArr2);
    }

    @Nullable
    private static String e(long j2, @Nullable String str, @Nullable String str2) {
        if (str == null) {
            return null;
        }
        return str2 != null ? str2 : Long.toHexString(j2);
    }

    @Nullable
    private static f.b f(ArrayList<f.b> arrayList, String str) {
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            f.b bVar = arrayList.get(i2);
            if (str.equals(bVar.f3299d)) {
                return bVar;
            }
        }
        return null;
    }

    @Nullable
    private static f.b g(ArrayList<f.b> arrayList, String str) {
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            f.b bVar = arrayList.get(i2);
            if (str.equals(bVar.f3300e)) {
                return bVar;
            }
        }
        return null;
    }

    @Nullable
    private static f.b h(ArrayList<f.b> arrayList, String str) {
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            f.b bVar = arrayList.get(i2);
            if (str.equals(bVar.f3298c)) {
                return bVar;
            }
        }
        return null;
    }

    private static double j(String str, Pattern pattern) throws ParserException {
        return Double.parseDouble(z(str, pattern, Collections.emptyMap()));
    }

    @Nullable
    private static DrmInitData.SchemeData k(String str, String str2, Map<String, String> map) throws ParserException {
        String u2 = u(str, H, "1", map);
        if ("urn:uuid:edef8ba9-79d6-4ace-a3c8-27dcd51d21ed".equals(str2)) {
            String z2 = z(str, I, map);
            return new DrmInitData.SchemeData(w0.f4083d, "video/mp4", Base64.decode(z2.substring(z2.indexOf(44)), 0));
        } else if ("com.widevine".equals(str2)) {
            return new DrmInitData.SchemeData(w0.f4083d, "hls", o0.e0(str));
        } else {
            if (!"com.microsoft.playready".equals(str2) || !"1".equals(u2)) {
                return null;
            }
            String z3 = z(str, I, map);
            byte[] decode = Base64.decode(z3.substring(z3.indexOf(44)), 0);
            UUID uuid = w0.f4084e;
            return new DrmInitData.SchemeData(uuid, "video/mp4", l.a(uuid, decode));
        }
    }

    private static String l(String str) {
        return ("SAMPLE-AES-CENC".equals(str) || "SAMPLE-AES-CTR".equals(str)) ? "cenc" : "cbcs";
    }

    private static int m(String str, Pattern pattern) throws ParserException {
        return Integer.parseInt(z(str, pattern, Collections.emptyMap()));
    }

    private static long n(String str, Pattern pattern) throws ParserException {
        return Long.parseLong(z(str, pattern, Collections.emptyMap()));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [java.util.List] */
    private static f o(a aVar, String str) throws IOException {
        char c2;
        String str2;
        String str3;
        int i2;
        String str4;
        int i3;
        int i4;
        int i5;
        float f2;
        Uri uri;
        String str5 = str;
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        ArrayList arrayList5 = new ArrayList();
        ArrayList arrayList6 = new ArrayList();
        ArrayList arrayList7 = new ArrayList();
        ArrayList arrayList8 = new ArrayList();
        boolean z2 = false;
        boolean z3 = false;
        while (true) {
            String str6 = "application/x-mpegURL";
            if (aVar.a()) {
                String b2 = aVar.b();
                if (b2.startsWith("#EXT")) {
                    arrayList8.add(b2);
                }
                boolean startsWith = b2.startsWith("#EXT-X-I-FRAME-STREAM-INF");
                if (b2.startsWith("#EXT-X-DEFINE")) {
                    hashMap2.put(z(b2, N, hashMap2), z(b2, X, hashMap2));
                } else {
                    if (b2.equals("#EXT-X-INDEPENDENT-SEGMENTS")) {
                        hashMap = hashMap;
                        arrayList6 = arrayList6;
                        arrayList2 = arrayList2;
                        arrayList3 = arrayList3;
                        arrayList4 = arrayList4;
                        arrayList5 = arrayList5;
                        arrayList8 = arrayList8;
                        arrayList7 = arrayList7;
                        z2 = true;
                    } else if (b2.startsWith("#EXT-X-MEDIA")) {
                        arrayList6.add(b2);
                    } else if (b2.startsWith("#EXT-X-SESSION-KEY")) {
                        DrmInitData.SchemeData k2 = k(b2, u(b2, G, "identity", hashMap2), hashMap2);
                        if (k2 != null) {
                            arrayList7.add(new DrmInitData(l(z(b2, F, hashMap2)), k2));
                        }
                    } else if (b2.startsWith("#EXT-X-STREAM-INF") || startsWith) {
                        boolean contains = z3 | b2.contains("CLOSED-CAPTIONS=NONE");
                        if (startsWith) {
                            i3 = 16384;
                            z3 = contains;
                        } else {
                            z3 = contains;
                            i3 = 0;
                        }
                        int m2 = m(b2, f3278f);
                        arrayList7 = arrayList7;
                        arrayList5 = arrayList5;
                        int s2 = s(b2, a, -1);
                        String v2 = v(b2, h, hashMap2);
                        arrayList8 = arrayList8;
                        String v3 = v(b2, i, hashMap2);
                        if (v3 != null) {
                            arrayList4 = arrayList4;
                            String[] E0 = o0.E0(v3, "x");
                            int parseInt = Integer.parseInt(E0[0]);
                            i4 = Integer.parseInt(E0[1]);
                            if (parseInt <= 0 || i4 <= 0) {
                                i4 = -1;
                                i5 = -1;
                            } else {
                                i5 = parseInt;
                            }
                        } else {
                            arrayList4 = arrayList4;
                            i5 = -1;
                            i4 = -1;
                        }
                        arrayList3 = arrayList3;
                        String v4 = v(b2, j, hashMap2);
                        if (v4 != null) {
                            arrayList2 = arrayList2;
                            f2 = Float.parseFloat(v4);
                        } else {
                            arrayList2 = arrayList2;
                            f2 = -1.0f;
                        }
                        String v5 = v(b2, f3274b, hashMap2);
                        arrayList6 = arrayList6;
                        String v6 = v(b2, f3275c, hashMap2);
                        String v7 = v(b2, f3276d, hashMap2);
                        String v8 = v(b2, f3277e, hashMap2);
                        if (startsWith) {
                            uri = n0.d(str5, z(b2, I, hashMap2));
                        } else if (aVar.a()) {
                            uri = n0.d(str5, A(aVar.b(), hashMap2));
                        } else {
                            throw ParserException.createForMalformedManifest("#EXT-X-STREAM-INF must be followed by another line", null);
                        }
                        arrayList.add(new f.b(uri, new Format.b().R(arrayList.size()).K(str6).I(v2).G(s2).Z(m2).j0(i5).Q(i4).P(f2).c0(i3).E(), v5, v6, v7, v8));
                        hashMap = hashMap;
                        ArrayList arrayList9 = (ArrayList) hashMap.get(uri);
                        if (arrayList9 == null) {
                            arrayList9 = new ArrayList();
                            hashMap.put(uri, arrayList9);
                        }
                        arrayList9.add(new HlsTrackMetadataEntry.VariantInfo(s2, m2, v5, v6, v7, v8));
                        z2 = z2;
                    }
                    str5 = str;
                }
                hashMap = hashMap;
                arrayList6 = arrayList6;
                arrayList2 = arrayList2;
                arrayList3 = arrayList3;
                arrayList4 = arrayList4;
                arrayList5 = arrayList5;
                arrayList8 = arrayList8;
                arrayList7 = arrayList7;
                z2 = z2;
                str5 = str;
            } else {
                ArrayList arrayList10 = arrayList6;
                ArrayList arrayList11 = arrayList2;
                ArrayList arrayList12 = arrayList3;
                ArrayList arrayList13 = arrayList4;
                ArrayList arrayList14 = new ArrayList();
                HashSet hashSet = new HashSet();
                for (int i6 = 0; i6 < arrayList.size(); i6++) {
                    f.b bVar = (f.b) arrayList.get(i6);
                    if (hashSet.add(bVar.a)) {
                        g.g(bVar.f3297b.p2 == null);
                        arrayList14.add(bVar.a(bVar.f3297b.a().X(new Metadata(new HlsTrackMetadataEntry(null, null, (List) g.e((ArrayList) hashMap.get(bVar.a))))).E()));
                    }
                }
                Uri uri2 = null;
                ArrayList arrayList15 = null;
                Format format = null;
                int i7 = 0;
                while (i7 < arrayList10.size()) {
                    String str7 = (String) arrayList10.get(i7);
                    String z4 = z(str7, O, hashMap2);
                    String z5 = z(str7, N, hashMap2);
                    Format.b bVar2 = new Format.b();
                    StringBuilder sb = new StringBuilder(String.valueOf(z4).length() + 1 + String.valueOf(z5).length());
                    sb.append(z4);
                    sb.append(SSLClient.COLON);
                    sb.append(z5);
                    Format.b V2 = bVar2.S(sb.toString()).U(z5).K(str6).g0(x(str7)).c0(w(str7, hashMap2)).V(v(str7, M, hashMap2));
                    String v9 = v(str7, I, hashMap2);
                    if (v9 != null) {
                        uri2 = n0.d(str, v9);
                    }
                    arrayList10 = arrayList10;
                    Metadata metadata = new Metadata(new HlsTrackMetadataEntry(z4, z5, Collections.emptyList()));
                    String z6 = z(str7, K, hashMap2);
                    z6.hashCode();
                    switch (z6.hashCode()) {
                        case -959297733:
                            if (z6.equals("SUBTITLES")) {
                                c2 = 0;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case -333210994:
                            if (z6.equals("CLOSED-CAPTIONS")) {
                                c2 = 1;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case 62628790:
                            if (z6.equals("AUDIO")) {
                                c2 = 2;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case 81665115:
                            if (z6.equals("VIDEO")) {
                                c2 = 3;
                                break;
                            }
                            c2 = 65535;
                            break;
                        default:
                            c2 = 65535;
                            break;
                    }
                    switch (c2) {
                        case 0:
                            format = format;
                            arrayList12 = arrayList12;
                            arrayList11 = arrayList11;
                            f.b g2 = g(arrayList, z4);
                            if (g2 != null) {
                                String G2 = o0.G(g2.f3297b.p1, 3);
                                V2.I(G2);
                                str2 = com.google.android.exoplayer2.util.y.g(G2);
                            } else {
                                str2 = null;
                            }
                            if (str2 == null) {
                                str2 = "text/vtt";
                            }
                            V2.e0(str2).X(metadata);
                            if (uri2 != null) {
                                f.a aVar2 = new f.a(uri2, V2.E(), z4, z5);
                                arrayList13 = arrayList13;
                                arrayList13.add(aVar2);
                                break;
                            } else {
                                arrayList13 = arrayList13;
                                u.h("HlsPlaylistParser", "EXT-X-MEDIA tag with missing mandatory URI attribute: skipping");
                                break;
                            }
                        case 1:
                            format = format;
                            arrayList12 = arrayList12;
                            arrayList11 = arrayList11;
                            String z7 = z(str7, Q, hashMap2);
                            if (z7.startsWith("CC")) {
                                i2 = Integer.parseInt(z7.substring(2));
                                str3 = "application/cea-608";
                            } else {
                                i2 = Integer.parseInt(z7.substring(7));
                                str3 = "application/cea-708";
                            }
                            if (arrayList15 == null) {
                                arrayList15 = new ArrayList();
                            }
                            V2.e0(str3).F(i2);
                            arrayList15.add(V2.E());
                            arrayList13 = arrayList13;
                            break;
                        case 2:
                            arrayList11 = arrayList11;
                            f.b f3 = f(arrayList, z4);
                            if (f3 != null) {
                                format = format;
                                String G3 = o0.G(f3.f3297b.p1, 1);
                                V2.I(G3);
                                str4 = com.google.android.exoplayer2.util.y.g(G3);
                            } else {
                                format = format;
                                str4 = null;
                            }
                            String v10 = v(str7, g, hashMap2);
                            if (v10 != null) {
                                V2.H(Integer.parseInt(o0.F0(v10, MqttTopic.TOPIC_LEVEL_SEPARATOR)[0]));
                                if ("audio/eac3".equals(str4) && v10.endsWith("/JOC")) {
                                    V2.I("ec+3");
                                    str4 = "audio/eac3-joc";
                                }
                            }
                            V2.e0(str4);
                            if (uri2 != null) {
                                V2.X(metadata);
                                arrayList12 = arrayList12;
                                arrayList12.add(new f.a(uri2, V2.E(), z4, z5));
                            } else {
                                arrayList12 = arrayList12;
                                if (f3 != null) {
                                    format = V2.E();
                                }
                            }
                            arrayList13 = arrayList13;
                            break;
                        case 3:
                            f.b h2 = h(arrayList, z4);
                            if (h2 != null) {
                                Format format2 = h2.f3297b;
                                String G4 = o0.G(format2.p1, 2);
                                V2.I(G4).e0(com.google.android.exoplayer2.util.y.g(G4)).j0(format2.M3).Q(format2.N3).P(format2.O3);
                            }
                            if (uri2 != null) {
                                V2.X(metadata);
                                arrayList11 = arrayList11;
                                arrayList11.add(new f.a(uri2, V2.E(), z4, z5));
                                format = format;
                                arrayList13 = arrayList13;
                                arrayList12 = arrayList12;
                                break;
                            }
                        default:
                            format = format;
                            arrayList13 = arrayList13;
                            arrayList12 = arrayList12;
                            arrayList11 = arrayList11;
                            break;
                    }
                    i7++;
                    str6 = str6;
                    uri2 = null;
                }
                return new f(str, arrayList8, arrayList14, arrayList11, arrayList12, arrayList13, arrayList5, format, z3 ? Collections.emptyList() : arrayList15, z2, hashMap2, arrayList7);
            }
        }
    }

    private static g p(f fVar, @Nullable g gVar, a aVar, String str) throws IOException {
        boolean z2;
        ArrayList arrayList;
        long j2;
        DrmInitData drmInitData;
        g.d dVar;
        f fVar2 = fVar;
        g gVar2 = gVar;
        boolean z3 = fVar2.f3315c;
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        HashMap hashMap3 = new HashMap();
        ArrayList arrayList4 = new ArrayList();
        g.f fVar3 = new g.f(-9223372036854775807L, false, -9223372036854775807L, -9223372036854775807L, false);
        TreeMap treeMap = new TreeMap();
        String str2 = "";
        boolean z4 = z3;
        g.f fVar4 = fVar3;
        String str3 = str2;
        long j3 = 0;
        long j4 = 0;
        long j5 = 0;
        long j6 = 0;
        long j7 = 0;
        long j8 = 0;
        long j9 = 0;
        long j10 = 0;
        boolean z5 = false;
        int i2 = 0;
        long j11 = -9223372036854775807L;
        boolean z6 = false;
        int i3 = 0;
        int i4 = 1;
        long j12 = -9223372036854775807L;
        long j13 = -9223372036854775807L;
        boolean z7 = false;
        DrmInitData drmInitData2 = null;
        DrmInitData drmInitData3 = null;
        boolean z8 = false;
        g.b bVar = null;
        String str4 = null;
        long j14 = -1;
        String str5 = null;
        String str6 = null;
        int i5 = 0;
        boolean z9 = false;
        g.d dVar2 = null;
        while (aVar.a()) {
            String b2 = aVar.b();
            if (b2.startsWith("#EXT")) {
                arrayList4.add(b2);
            }
            if (b2.startsWith("#EXT-X-PLAYLIST-TYPE")) {
                String z10 = z(b2, o, hashMap);
                if ("VOD".equals(z10)) {
                    i2 = 1;
                } else if ("EVENT".equals(z10)) {
                    i2 = 2;
                }
            } else if (b2.equals("#EXT-X-I-FRAMES-ONLY")) {
                z9 = true;
            } else if (b2.startsWith("#EXT-X-START")) {
                j11 = (long) (j(b2, A) * 1000000.0d);
                z5 = q(b2, W, false);
            } else if (b2.startsWith("#EXT-X-SERVER-CONTROL")) {
                fVar4 = y(b2);
            } else if (b2.startsWith("#EXT-X-PART-INF")) {
                j13 = (long) (j(b2, m) * 1000000.0d);
            } else if (b2.startsWith("#EXT-X-MAP")) {
                String z11 = z(b2, I, hashMap);
                String v2 = v(b2, C, hashMap);
                if (v2 != null) {
                    String[] E0 = o0.E0(v2, "@");
                    j14 = Long.parseLong(E0[0]);
                    if (E0.length > 1) {
                        j5 = Long.parseLong(E0[1]);
                    }
                }
                int i6 = (j14 > (-1L) ? 1 : (j14 == (-1L) ? 0 : -1));
                if (i6 == 0) {
                    j5 = 0;
                }
                if (str4 == null || str5 != null) {
                    dVar2 = new g.d(z11, j5, j14, str4, str5);
                    if (i6 != 0) {
                        j5 += j14;
                    }
                    str4 = str4;
                    str5 = str5;
                    j14 = -1;
                } else {
                    throw ParserException.createForMalformedManifest("The encryption IV attribute must be present when an initialization segment is encrypted with METHOD=AES-128.", null);
                }
            } else {
                if (b2.startsWith("#EXT-X-TARGETDURATION")) {
                    j12 = 1000000 * m(b2, k);
                } else if (b2.startsWith("#EXT-X-MEDIA-SEQUENCE")) {
                    j8 = n(b2, v);
                    str5 = str5;
                    z5 = z5;
                    j4 = j8;
                    str4 = str4;
                } else if (b2.startsWith("#EXT-X-VERSION")) {
                    i4 = m(b2, n);
                } else {
                    if (b2.startsWith("#EXT-X-DEFINE")) {
                        String v3 = v(b2, Y, hashMap);
                        if (v3 != null) {
                            String str7 = fVar2.m.get(v3);
                            if (str7 != null) {
                                hashMap.put(v3, str7);
                            }
                        } else {
                            hashMap.put(z(b2, N, hashMap), z(b2, X, hashMap));
                        }
                        arrayList4 = arrayList4;
                        str2 = str2;
                        str4 = str4;
                        bVar = bVar;
                        j8 = j8;
                        hashMap3 = hashMap3;
                        str6 = str6;
                    } else {
                        if (b2.startsWith("#EXTINF")) {
                            str4 = str4;
                            j9 = (long) (j(b2, w) * 1000000.0d);
                            str3 = u(b2, x, str2, hashMap);
                            fVar2 = fVar;
                            str5 = str5;
                        } else {
                            str4 = str4;
                            if (b2.startsWith("#EXT-X-SKIP")) {
                                int m2 = m(b2, r);
                                com.google.android.exoplayer2.util.g.g(gVar2 != null && arrayList2.isEmpty());
                                int i7 = (int) (j4 - ((g) o0.i(gVar)).k);
                                int i8 = m2 + i7;
                                if (i7 < 0 || i8 > gVar2.r.size()) {
                                    throw new DeltaUpdateException();
                                }
                                str5 = str5;
                                long j15 = j7;
                                while (i7 < i8) {
                                    g.d dVar3 = gVar2.r.get(i7);
                                    if (j4 != gVar2.k) {
                                        dVar3 = dVar3.b(j15, (gVar2.j - i3) + dVar3.q);
                                    }
                                    arrayList2.add(dVar3);
                                    j15 += dVar3.f3309f;
                                    long j16 = dVar3.p2;
                                    if (j16 != -1) {
                                        j5 = dVar3.p1 + j16;
                                    }
                                    int i9 = dVar3.q;
                                    g.d dVar4 = dVar3.f3308d;
                                    DrmInitData drmInitData4 = dVar3.y;
                                    String str8 = dVar3.z;
                                    String str9 = dVar3.p0;
                                    if (str9 == null || !str9.equals(Long.toHexString(j8))) {
                                        str5 = dVar3.p0;
                                    }
                                    j8++;
                                    i7++;
                                    gVar2 = gVar;
                                    str4 = str8;
                                    j6 = j15;
                                    i5 = i9;
                                    i8 = i8;
                                    dVar2 = dVar4;
                                    drmInitData3 = drmInitData4;
                                    str2 = str2;
                                }
                                fVar2 = fVar;
                                gVar2 = gVar;
                                j7 = j15;
                            } else {
                                str2 = str2;
                                if (b2.startsWith("#EXT-X-KEY")) {
                                    String z12 = z(b2, F, hashMap);
                                    String u2 = u(b2, G, "identity", hashMap);
                                    if ("NONE".equals(z12)) {
                                        treeMap.clear();
                                        str4 = null;
                                        drmInitData3 = null;
                                        str5 = null;
                                    } else {
                                        String v4 = v(b2, J, hashMap);
                                        if ("identity".equals(u2)) {
                                            if ("AES-128".equals(z12)) {
                                                str4 = z(b2, I, hashMap);
                                                str5 = v4;
                                            }
                                            str5 = v4;
                                            str4 = null;
                                        } else {
                                            str6 = str6 == null ? l(z12) : str6;
                                            DrmInitData.SchemeData k2 = k(b2, u2, hashMap);
                                            if (k2 != null) {
                                                treeMap.put(u2, k2);
                                                str5 = v4;
                                                str4 = null;
                                                drmInitData3 = null;
                                            }
                                            str5 = v4;
                                            str4 = null;
                                        }
                                    }
                                    gVar2 = gVar;
                                    z5 = z5;
                                    str2 = str2;
                                } else {
                                    if (b2.startsWith("#EXT-X-BYTERANGE")) {
                                        String[] E02 = o0.E0(z(b2, B, hashMap), "@");
                                        j14 = Long.parseLong(E02[0]);
                                        if (E02.length > 1) {
                                            j5 = Long.parseLong(E02[1]);
                                        }
                                    } else if (b2.startsWith("#EXT-X-DISCONTINUITY-SEQUENCE")) {
                                        i3 = Integer.parseInt(b2.substring(b2.indexOf(58) + 1));
                                        fVar2 = fVar;
                                        gVar2 = gVar;
                                        str6 = str6;
                                        str5 = str5;
                                        str2 = str2;
                                        z6 = true;
                                    } else if (b2.equals("#EXT-X-DISCONTINUITY")) {
                                        i5++;
                                    } else if (b2.startsWith("#EXT-X-PROGRAM-DATE-TIME")) {
                                        if (j3 == 0) {
                                            j3 = w0.d(o0.y0(b2.substring(b2.indexOf(58) + 1))) - j7;
                                        } else {
                                            str4 = str4;
                                            arrayList4 = arrayList4;
                                            j8 = j8;
                                            str6 = str6;
                                            bVar = bVar;
                                            hashMap3 = hashMap3;
                                        }
                                    } else if (b2.equals("#EXT-X-GAP")) {
                                        fVar2 = fVar;
                                        gVar2 = gVar;
                                        str6 = str6;
                                        str5 = str5;
                                        str2 = str2;
                                        z8 = true;
                                    } else if (b2.equals("#EXT-X-INDEPENDENT-SEGMENTS")) {
                                        fVar2 = fVar;
                                        gVar2 = gVar;
                                        str6 = str6;
                                        str5 = str5;
                                        str2 = str2;
                                        z4 = true;
                                    } else if (b2.equals("#EXT-X-ENDLIST")) {
                                        fVar2 = fVar;
                                        gVar2 = gVar;
                                        str6 = str6;
                                        str5 = str5;
                                        str2 = str2;
                                        z7 = true;
                                    } else {
                                        if (b2.startsWith("#EXT-X-RENDITION-REPORT")) {
                                            str4 = str4;
                                            long t2 = t(b2, y, (j4 + arrayList2.size()) - (arrayList3.isEmpty() ? 1L : 0L));
                                            int s2 = s(b2, z, j13 != -9223372036854775807L ? (arrayList3.isEmpty() ? ((g.d) j1.f(arrayList2)).I3 : arrayList3).size() - 1 : -1);
                                            Uri parse = Uri.parse(n0.c(str, z(b2, I, hashMap)));
                                            hashMap3.put(parse, new g.c(parse, t2, s2));
                                            bVar = bVar;
                                            j8 = j8;
                                            hashMap3 = hashMap3;
                                            str6 = str6;
                                        } else {
                                            str4 = str4;
                                            if (b2.startsWith("#EXT-X-PRELOAD-HINT")) {
                                                bVar = bVar;
                                                if (bVar == null && "PART".equals(z(b2, L, hashMap))) {
                                                    String z13 = z(b2, I, hashMap);
                                                    long t3 = t(b2, D, -1L);
                                                    long t4 = t(b2, E, -1L);
                                                    String e2 = e(j8, str4, str5);
                                                    if (drmInitData3 != null || treeMap.isEmpty()) {
                                                        j8 = j8;
                                                        str6 = str6;
                                                    } else {
                                                        j8 = j8;
                                                        DrmInitData.SchemeData[] schemeDataArr = (DrmInitData.SchemeData[]) treeMap.values().toArray(new DrmInitData.SchemeData[0]);
                                                        str6 = str6;
                                                        DrmInitData drmInitData5 = new DrmInitData(str6, schemeDataArr);
                                                        if (drmInitData2 == null) {
                                                            drmInitData2 = d(str6, schemeDataArr);
                                                        }
                                                        drmInitData3 = drmInitData5;
                                                    }
                                                    int i10 = (t3 > (-1L) ? 1 : (t3 == (-1L) ? 0 : -1));
                                                    if (i10 == 0 || t4 != -1) {
                                                        bVar = new g.b(z13, dVar2, 0L, i5, j6, drmInitData3, str4, e2, i10 != 0 ? t3 : 0L, t4, false, false, true);
                                                    }
                                                    gVar2 = gVar;
                                                    str5 = str5;
                                                    hashMap3 = hashMap3;
                                                    z5 = z5;
                                                    str4 = str4;
                                                    str2 = str2;
                                                } else {
                                                    bVar = bVar;
                                                    hashMap3 = hashMap3;
                                                    str6 = str6;
                                                    j8 = j8;
                                                }
                                            } else {
                                                hashMap3 = hashMap3;
                                                str6 = str6;
                                                if (b2.startsWith("#EXT-X-PART")) {
                                                    String e3 = e(j8, str4, str5);
                                                    String z14 = z(b2, I, hashMap);
                                                    bVar = bVar;
                                                    long j17 = (long) (j(b2, l) * 1000000.0d);
                                                    boolean q2 = q(b2, U, false) | (z4 && arrayList3.isEmpty());
                                                    boolean q3 = q(b2, V, false);
                                                    String v5 = v(b2, C, hashMap);
                                                    if (v5 != null) {
                                                        String[] E03 = o0.E0(v5, "@");
                                                        j2 = Long.parseLong(E03[0]);
                                                        if (E03.length > 1) {
                                                            j10 = Long.parseLong(E03[1]);
                                                        }
                                                    } else {
                                                        j2 = -1;
                                                    }
                                                    int i11 = (j2 > (-1L) ? 1 : (j2 == (-1L) ? 0 : -1));
                                                    if (i11 == 0) {
                                                        j10 = 0;
                                                    }
                                                    if (drmInitData3 == null && !treeMap.isEmpty()) {
                                                        DrmInitData.SchemeData[] schemeDataArr2 = (DrmInitData.SchemeData[]) treeMap.values().toArray(new DrmInitData.SchemeData[0]);
                                                        DrmInitData drmInitData6 = new DrmInitData(str6, schemeDataArr2);
                                                        if (drmInitData2 == null) {
                                                            drmInitData2 = d(str6, schemeDataArr2);
                                                        }
                                                        drmInitData3 = drmInitData6;
                                                    }
                                                    arrayList3.add(new g.b(z14, dVar2, j17, i5, j6, drmInitData3, str4, e3, j10, j2, q3, q2, false));
                                                    j6 += j17;
                                                    if (i11 != 0) {
                                                        j10 += j2;
                                                    }
                                                    fVar2 = fVar;
                                                    gVar2 = gVar;
                                                    str6 = str6;
                                                    j8 = j8;
                                                    hashMap3 = hashMap3;
                                                    z5 = z5;
                                                    arrayList4 = arrayList4;
                                                    str5 = str5;
                                                } else {
                                                    bVar = bVar;
                                                    arrayList4 = arrayList4;
                                                    if (!b2.startsWith(MqttTopic.MULTI_LEVEL_WILDCARD)) {
                                                        String e4 = e(j8, str4, str5);
                                                        j8++;
                                                        String A2 = A(b2, hashMap);
                                                        g.d dVar5 = (g.d) hashMap2.get(A2);
                                                        int i12 = (j14 > (-1L) ? 1 : (j14 == (-1L) ? 0 : -1));
                                                        if (i12 == 0) {
                                                            j5 = 0;
                                                        } else {
                                                            if (z9 && dVar2 == null && dVar5 == null) {
                                                                dVar5 = new g.d(A2, 0L, j5, null, null);
                                                                hashMap2.put(A2, dVar5);
                                                            }
                                                            j5 = j5;
                                                        }
                                                        if (drmInitData3 != null || treeMap.isEmpty()) {
                                                            dVar = dVar5;
                                                            drmInitData = drmInitData3;
                                                        } else {
                                                            dVar = dVar5;
                                                            DrmInitData.SchemeData[] schemeDataArr3 = (DrmInitData.SchemeData[]) treeMap.values().toArray(new DrmInitData.SchemeData[0]);
                                                            drmInitData = new DrmInitData(str6, schemeDataArr3);
                                                            if (drmInitData2 == null) {
                                                                drmInitData2 = d(str6, schemeDataArr3);
                                                            }
                                                        }
                                                        if (dVar2 != null) {
                                                            dVar = dVar2;
                                                        }
                                                        arrayList2.add(new g.d(A2, dVar, str3, j9, i5, j7, drmInitData, str4, e4, j5, j14, z8, arrayList3));
                                                        j6 = j7 + j9;
                                                        arrayList3 = new ArrayList();
                                                        if (i12 != 0) {
                                                            j5 += j14;
                                                        }
                                                        fVar2 = fVar;
                                                        gVar2 = gVar;
                                                        drmInitData3 = drmInitData;
                                                        str6 = str6;
                                                        j9 = 0;
                                                        j7 = j6;
                                                        hashMap3 = hashMap3;
                                                        z5 = z5;
                                                        arrayList4 = arrayList4;
                                                        str3 = str2;
                                                        z8 = false;
                                                        j14 = -1;
                                                        str4 = str4;
                                                        bVar = bVar;
                                                        str5 = str5;
                                                        str2 = str3;
                                                    } else {
                                                        j8 = j8;
                                                    }
                                                }
                                            }
                                        }
                                        arrayList4 = arrayList4;
                                    }
                                    fVar2 = fVar;
                                    gVar2 = gVar;
                                    str6 = str6;
                                    str5 = str5;
                                    str2 = str2;
                                }
                                fVar2 = fVar;
                            }
                        }
                        z5 = z5;
                    }
                    z5 = z5;
                    fVar2 = fVar;
                    gVar2 = gVar;
                    str5 = str5;
                }
                str5 = str5;
                z5 = z5;
                str4 = str4;
            }
        }
        if (bVar != null) {
            arrayList3.add(bVar);
        }
        if (j3 != 0) {
            arrayList = arrayList3;
            z2 = true;
        } else {
            arrayList = arrayList3;
            z2 = false;
        }
        return new g(i2, str, arrayList4, j11, z5, j3, z6, i3, j4, i4, j12, j13, z4, z7, z2, drmInitData2, arrayList2, arrayList, fVar4, hashMap3);
    }

    private static boolean q(String str, Pattern pattern, boolean z2) {
        Matcher matcher = pattern.matcher(str);
        return matcher.find() ? "YES".equals(matcher.group(1)) : z2;
    }

    private static double r(String str, Pattern pattern, double d2) {
        Matcher matcher = pattern.matcher(str);
        return matcher.find() ? Double.parseDouble((String) com.google.android.exoplayer2.util.g.e(matcher.group(1))) : d2;
    }

    private static int s(String str, Pattern pattern, int i2) {
        Matcher matcher = pattern.matcher(str);
        return matcher.find() ? Integer.parseInt((String) com.google.android.exoplayer2.util.g.e(matcher.group(1))) : i2;
    }

    private static long t(String str, Pattern pattern, long j2) {
        Matcher matcher = pattern.matcher(str);
        return matcher.find() ? Long.parseLong((String) com.google.android.exoplayer2.util.g.e(matcher.group(1))) : j2;
    }

    private static String u(String str, Pattern pattern, String str2, Map<String, String> map) {
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            str2 = (String) com.google.android.exoplayer2.util.g.e(matcher.group(1));
        }
        return (map.isEmpty() || str2 == null) ? str2 : A(str2, map);
    }

    @Nullable
    private static String v(String str, Pattern pattern, Map<String, String> map) {
        return u(str, pattern, null, map);
    }

    private static int w(String str, Map<String, String> map) {
        String v2 = v(str, P, map);
        int i2 = 0;
        if (TextUtils.isEmpty(v2)) {
            return 0;
        }
        String[] E0 = o0.E0(v2, SSLClient.COMMA);
        if (o0.r(E0, "public.accessibility.describes-video")) {
            i2 = 512;
        }
        if (o0.r(E0, "public.accessibility.transcribes-spoken-dialog")) {
            i2 |= 4096;
        }
        if (o0.r(E0, "public.accessibility.describes-music-and-sound")) {
            i2 |= 1024;
        }
        return o0.r(E0, "public.easy-to-read") ? i2 | 8192 : i2;
    }

    private static int x(String str) {
        int i2 = q(str, S, false) ? 1 : 0;
        if (q(str, T, false)) {
            i2 |= 2;
        }
        return q(str, R, false) ? i2 | 4 : i2;
    }

    private static g.f y(String str) {
        double r2 = r(str, p, -9.223372036854776E18d);
        long j2 = -9223372036854775807L;
        long j3 = r2 == -9.223372036854776E18d ? -9223372036854775807L : (long) (r2 * 1000000.0d);
        boolean q2 = q(str, q, false);
        double r3 = r(str, s, -9.223372036854776E18d);
        long j4 = r3 == -9.223372036854776E18d ? -9223372036854775807L : (long) (r3 * 1000000.0d);
        double r4 = r(str, t, -9.223372036854776E18d);
        if (r4 != -9.223372036854776E18d) {
            j2 = (long) (r4 * 1000000.0d);
        }
        return new g.f(j3, q2, j4, j2, q(str, u, false));
    }

    private static String z(String str, Pattern pattern, Map<String, String> map) throws ParserException {
        String v2 = v(str, pattern, map);
        if (v2 != null) {
            return v2;
        }
        String pattern2 = pattern.pattern();
        StringBuilder sb = new StringBuilder(String.valueOf(pattern2).length() + 19 + String.valueOf(str).length());
        sb.append("Couldn't match ");
        sb.append(pattern2);
        sb.append(" in ");
        sb.append(str);
        throw ParserException.createForMalformedManifest(sb.toString(), null);
    }

    /* renamed from: i */
    public h a(Uri uri, InputStream inputStream) throws IOException {
        String trim;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        ArrayDeque arrayDeque = new ArrayDeque();
        try {
            if (b(bufferedReader)) {
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        trim = readLine.trim();
                        if (!trim.isEmpty()) {
                            if (!trim.startsWith("#EXT-X-STREAM-INF")) {
                                if (trim.startsWith("#EXT-X-TARGETDURATION") || trim.startsWith("#EXT-X-MEDIA-SEQUENCE") || trim.startsWith("#EXTINF") || trim.startsWith("#EXT-X-KEY") || trim.startsWith("#EXT-X-BYTERANGE") || trim.equals("#EXT-X-DISCONTINUITY") || trim.equals("#EXT-X-DISCONTINUITY-SEQUENCE") || trim.equals("#EXT-X-ENDLIST")) {
                                    break;
                                }
                                arrayDeque.add(trim);
                            } else {
                                arrayDeque.add(trim);
                                return o(new a(arrayDeque, bufferedReader), uri.toString());
                            }
                        }
                    } else {
                        o0.m(bufferedReader);
                        throw ParserException.createForMalformedManifest("Failed to parse the playlist, could not identify any tags.", null);
                    }
                }
                arrayDeque.add(trim);
                return p(this.a0, this.b0, new a(arrayDeque, bufferedReader), uri.toString());
            }
            throw ParserException.createForMalformedManifest("Input does not start with the #EXTM3U header.", null);
        } finally {
            o0.m(bufferedReader);
        }
    }

    public HlsPlaylistParser(f fVar, @Nullable g gVar) {
        this.a0 = fVar;
        this.b0 = gVar;
    }
}
