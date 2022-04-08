package com.google.android.exoplayer2.text.s;

import android.text.Layout;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.google.android.exoplayer2.text.d;
import com.google.android.exoplayer2.text.f;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.o0;
import com.google.android.exoplayer2.util.p0;
import com.google.android.exoplayer2.util.u;
import com.google.firebase.messaging.Constants;
import com.tplink.libtpcommonstream.stream.control.common.MotorDirection;
import com.tplink.libtpmediastatistics.SSLClient;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.eclipse.paho.client.mqttv3.MqttTopic;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/* compiled from: TtmlDecoder.java */
/* loaded from: classes.dex */
public final class c extends d {
    private static final Pattern o = Pattern.compile("^([0-9][0-9]+):([0-9][0-9]):([0-9][0-9])(?:(\\.[0-9]+)|:([0-9][0-9])(?:\\.([0-9]+))?)?$");
    private static final Pattern p = Pattern.compile("^([0-9]+(?:\\.[0-9]+)?)(h|m|s|ms|f|t)$");
    private static final Pattern q = Pattern.compile("^(([0-9]*.)?[0-9]+)(px|em|%)$");
    static final Pattern r = Pattern.compile("^([-+]?\\d+\\.?\\d*?)%$");
    static final Pattern s = Pattern.compile("^(\\d+\\.?\\d*?)% (\\d+\\.?\\d*?)%$");
    private static final Pattern t = Pattern.compile("^(\\d+\\.?\\d*?)px (\\d+\\.?\\d*?)px$");
    private static final Pattern u = Pattern.compile("^(\\d+) (\\d+)$");
    private static final b v = new b(30.0f, 1, 1);
    private static final a w = new a(32, 15);
    private final XmlPullParserFactory x;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: TtmlDecoder.java */
    /* loaded from: classes.dex */
    public static final class a {
        final int a;

        /* renamed from: b  reason: collision with root package name */
        final int f3547b;

        a(int i, int i2) {
            this.a = i;
            this.f3547b = i2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: TtmlDecoder.java */
    /* loaded from: classes.dex */
    public static final class b {
        final float a;

        /* renamed from: b  reason: collision with root package name */
        final int f3548b;

        /* renamed from: c  reason: collision with root package name */
        final int f3549c;

        b(float f2, int i, int i2) {
            this.a = f2;
            this.f3548b = i;
            this.f3549c = i2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: TtmlDecoder.java */
    /* renamed from: com.google.android.exoplayer2.text.s.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0087c {
        final int a;

        /* renamed from: b  reason: collision with root package name */
        final int f3550b;

        C0087c(int i, int i2) {
            this.a = i;
            this.f3550b = i2;
        }
    }

    public c() {
        super("TtmlDecoder");
        try {
            XmlPullParserFactory newInstance = XmlPullParserFactory.newInstance();
            this.x = newInstance;
            newInstance.setNamespaceAware(true);
        } catch (XmlPullParserException e2) {
            throw new RuntimeException("Couldn't create XmlPullParserFactory instance", e2);
        }
    }

    private static g B(@Nullable g gVar) {
        return gVar == null ? new g() : gVar;
    }

    private static boolean C(String str) {
        return str.equals("tt") || str.equals("head") || str.equals("body") || str.equals("div") || str.equals("p") || str.equals("span") || str.equals("br") || str.equals("style") || str.equals("styling") || str.equals("layout") || str.equals("region") || str.equals("metadata") || str.equals("image") || str.equals(Constants.ScionAnalytics.MessageType.DATA_MESSAGE) || str.equals("information");
    }

    @Nullable
    private static Layout.Alignment D(String str) {
        String e2 = com.google.common.base.c.e(str);
        e2.hashCode();
        char c2 = 65535;
        switch (e2.hashCode()) {
            case -1364013995:
                if (e2.equals("center")) {
                    c2 = 0;
                    break;
                }
                break;
            case 100571:
                if (e2.equals("end")) {
                    c2 = 1;
                    break;
                }
                break;
            case 3317767:
                if (e2.equals(MotorDirection.LEFT)) {
                    c2 = 2;
                    break;
                }
                break;
            case 108511772:
                if (e2.equals(MotorDirection.RIGHT)) {
                    c2 = 3;
                    break;
                }
                break;
            case 109757538:
                if (e2.equals("start")) {
                    c2 = 4;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                return Layout.Alignment.ALIGN_CENTER;
            case 1:
            case 3:
                return Layout.Alignment.ALIGN_OPPOSITE;
            case 2:
            case 4:
                return Layout.Alignment.ALIGN_NORMAL;
            default:
                return null;
        }
    }

    private static a E(XmlPullParser xmlPullParser, a aVar) throws SubtitleDecoderException {
        String attributeValue = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "cellResolution");
        if (attributeValue == null) {
            return aVar;
        }
        Matcher matcher = u.matcher(attributeValue);
        if (!matcher.matches()) {
            u.h("TtmlDecoder", attributeValue.length() != 0 ? "Ignoring malformed cell resolution: ".concat(attributeValue) : new String("Ignoring malformed cell resolution: "));
            return aVar;
        }
        try {
            int parseInt = Integer.parseInt((String) g.e(matcher.group(1)));
            int parseInt2 = Integer.parseInt((String) g.e(matcher.group(2)));
            if (parseInt != 0 && parseInt2 != 0) {
                return new a(parseInt, parseInt2);
            }
            StringBuilder sb = new StringBuilder(47);
            sb.append("Invalid cell resolution ");
            sb.append(parseInt);
            sb.append(SSLClient.WHITE_SPACE);
            sb.append(parseInt2);
            throw new SubtitleDecoderException(sb.toString());
        } catch (NumberFormatException unused) {
            u.h("TtmlDecoder", attributeValue.length() != 0 ? "Ignoring malformed cell resolution: ".concat(attributeValue) : new String("Ignoring malformed cell resolution: "));
            return aVar;
        }
    }

    private static void F(String str, g gVar) throws SubtitleDecoderException {
        Matcher matcher;
        String[] E0 = o0.E0(str, "\\s+");
        if (E0.length == 1) {
            matcher = q.matcher(str);
        } else if (E0.length == 2) {
            matcher = q.matcher(E0[1]);
            u.h("TtmlDecoder", "Multiple values in fontSize attribute. Picking the second value for vertical font size and ignoring the first.");
        } else {
            int length = E0.length;
            StringBuilder sb = new StringBuilder(52);
            sb.append("Invalid number of entries for fontSize: ");
            sb.append(length);
            sb.append(".");
            throw new SubtitleDecoderException(sb.toString());
        }
        if (matcher.matches()) {
            String str2 = (String) g.e(matcher.group(3));
            str2.hashCode();
            char c2 = 65535;
            switch (str2.hashCode()) {
                case 37:
                    if (str2.equals("%")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 3240:
                    if (str2.equals("em")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 3592:
                    if (str2.equals("px")) {
                        c2 = 2;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    gVar.z(3);
                    break;
                case 1:
                    gVar.z(2);
                    break;
                case 2:
                    gVar.z(1);
                    break;
                default:
                    StringBuilder sb2 = new StringBuilder(str2.length() + 30);
                    sb2.append("Invalid unit for fontSize: '");
                    sb2.append(str2);
                    sb2.append("'.");
                    throw new SubtitleDecoderException(sb2.toString());
            }
            gVar.y(Float.parseFloat((String) g.e(matcher.group(1))));
            return;
        }
        StringBuilder sb3 = new StringBuilder(String.valueOf(str).length() + 36);
        sb3.append("Invalid expression for fontSize: '");
        sb3.append(str);
        sb3.append("'.");
        throw new SubtitleDecoderException(sb3.toString());
    }

    private static b G(XmlPullParser xmlPullParser) throws SubtitleDecoderException {
        String attributeValue = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "frameRate");
        int parseInt = attributeValue != null ? Integer.parseInt(attributeValue) : 30;
        float f2 = 1.0f;
        String attributeValue2 = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "frameRateMultiplier");
        if (attributeValue2 != null) {
            String[] E0 = o0.E0(attributeValue2, SSLClient.WHITE_SPACE);
            if (E0.length == 2) {
                f2 = Integer.parseInt(E0[0]) / Integer.parseInt(E0[1]);
            } else {
                throw new SubtitleDecoderException("frameRateMultiplier doesn't have 2 parts");
            }
        }
        b bVar = v;
        int i = bVar.f3548b;
        String attributeValue3 = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "subFrameRate");
        if (attributeValue3 != null) {
            i = Integer.parseInt(attributeValue3);
        }
        int i2 = bVar.f3549c;
        String attributeValue4 = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "tickRate");
        if (attributeValue4 != null) {
            i2 = Integer.parseInt(attributeValue4);
        }
        return new b(parseInt * f2, i, i2);
    }

    private static Map<String, g> H(XmlPullParser xmlPullParser, Map<String, g> map, a aVar, @Nullable C0087c cVar, Map<String, e> map2, Map<String, String> map3) throws IOException, XmlPullParserException {
        do {
            xmlPullParser.next();
            if (p0.e(xmlPullParser, "style")) {
                String a2 = p0.a(xmlPullParser, "style");
                g M = M(xmlPullParser, new g());
                if (a2 != null) {
                    for (String str : N(a2)) {
                        M.a(map.get(str));
                    }
                }
                String g = M.g();
                if (g != null) {
                    map.put(g, M);
                }
            } else if (p0.e(xmlPullParser, "region")) {
                e K = K(xmlPullParser, aVar, cVar);
                if (K != null) {
                    map2.put(K.a, K);
                }
            } else if (p0.e(xmlPullParser, "metadata")) {
                I(xmlPullParser, map3);
            }
        } while (!p0.c(xmlPullParser, "head"));
        return map;
    }

    private static void I(XmlPullParser xmlPullParser, Map<String, String> map) throws IOException, XmlPullParserException {
        String a2;
        do {
            xmlPullParser.next();
            if (p0.e(xmlPullParser, "image") && (a2 = p0.a(xmlPullParser, "id")) != null) {
                map.put(a2, xmlPullParser.nextText());
            }
        } while (!p0.c(xmlPullParser, "metadata"));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private static d J(XmlPullParser xmlPullParser, @Nullable d dVar, Map<String, e> map, b bVar) throws SubtitleDecoderException {
        long j;
        long j2;
        char c2;
        int attributeCount = xmlPullParser.getAttributeCount();
        g M = M(xmlPullParser, null);
        String str = "";
        String str2 = null;
        long j3 = -9223372036854775807L;
        long j4 = -9223372036854775807L;
        long j5 = -9223372036854775807L;
        String[] strArr = null;
        for (int i = 0; i < attributeCount; i++) {
            String attributeName = xmlPullParser.getAttributeName(i);
            String attributeValue = xmlPullParser.getAttributeValue(i);
            attributeName.hashCode();
            switch (attributeName.hashCode()) {
                case -934795532:
                    if (attributeName.equals("region")) {
                        c2 = 0;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 99841:
                    if (attributeName.equals("dur")) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 100571:
                    if (attributeName.equals("end")) {
                        c2 = 2;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 93616297:
                    if (attributeName.equals("begin")) {
                        c2 = 3;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 109780401:
                    if (attributeName.equals("style")) {
                        c2 = 4;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1292595405:
                    if (attributeName.equals("backgroundImage")) {
                        c2 = 5;
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
                    if (map.containsKey(attributeValue)) {
                        str = attributeValue;
                        continue;
                    }
                case 1:
                    j5 = O(attributeValue, bVar);
                    break;
                case 2:
                    j4 = O(attributeValue, bVar);
                    break;
                case 3:
                    j3 = O(attributeValue, bVar);
                    break;
                case 4:
                    String[] N = N(attributeValue);
                    if (N.length > 0) {
                        strArr = N;
                        break;
                    }
                    break;
                case 5:
                    if (attributeValue.startsWith(MqttTopic.MULTI_LEVEL_WILDCARD)) {
                        str2 = attributeValue.substring(1);
                        break;
                    }
                    break;
            }
        }
        if (dVar != null) {
            long j6 = dVar.f3553d;
            j = -9223372036854775807L;
            if (j6 != -9223372036854775807L) {
                if (j3 != -9223372036854775807L) {
                    j3 += j6;
                }
                if (j4 != -9223372036854775807L) {
                    j4 += j6;
                }
            }
        } else {
            j = -9223372036854775807L;
        }
        if (j4 == j) {
            if (j5 != j) {
                j2 = j3 + j5;
            } else if (dVar != null) {
                long j7 = dVar.f3554e;
                if (j7 != j) {
                    j2 = j7;
                }
            }
            return d.c(xmlPullParser.getName(), j3, j2, M, strArr, str, str2, dVar);
        }
        j2 = j4;
        return d.c(xmlPullParser.getName(), j3, j2, M, strArr, str, str2, dVar);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x01ad, code lost:
        if (r0.equals("tb") == false) goto L_0x018f;
     */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0180  */
    @androidx.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static com.google.android.exoplayer2.text.s.e K(org.xmlpull.v1.XmlPullParser r17, com.google.android.exoplayer2.text.s.c.a r18, @androidx.annotation.Nullable com.google.android.exoplayer2.text.s.c.C0087c r19) {
        /*
            Method dump skipped, instructions count: 578
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.text.s.c.K(org.xmlpull.v1.XmlPullParser, com.google.android.exoplayer2.text.s.c$a, com.google.android.exoplayer2.text.s.c$c):com.google.android.exoplayer2.text.s.e");
    }

    private static float L(String str) {
        Matcher matcher = r.matcher(str);
        if (!matcher.matches()) {
            String valueOf = String.valueOf(str);
            u.h("TtmlDecoder", valueOf.length() != 0 ? "Invalid value for shear: ".concat(valueOf) : new String("Invalid value for shear: "));
            return Float.MAX_VALUE;
        }
        try {
            return Math.min(100.0f, Math.max(-100.0f, Float.parseFloat((String) g.e(matcher.group(1)))));
        } catch (NumberFormatException e2) {
            String valueOf2 = String.valueOf(str);
            u.i("TtmlDecoder", valueOf2.length() != 0 ? "Failed to parse shear: ".concat(valueOf2) : new String("Failed to parse shear: "), e2);
            return Float.MAX_VALUE;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x01f2, code lost:
        if (r3.equals("text") == false) goto L_0x01ea;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static com.google.android.exoplayer2.text.s.g M(org.xmlpull.v1.XmlPullParser r12, com.google.android.exoplayer2.text.s.g r13) {
        /*
            Method dump skipped, instructions count: 946
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.text.s.c.M(org.xmlpull.v1.XmlPullParser, com.google.android.exoplayer2.text.s.g):com.google.android.exoplayer2.text.s.g");
    }

    private static String[] N(String str) {
        String trim = str.trim();
        return trim.isEmpty() ? new String[0] : o0.E0(trim, "\\s+");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x00bf, code lost:
        if (r13.equals("ms") == false) goto L_0x00b7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static long O(java.lang.String r13, com.google.android.exoplayer2.text.s.c.b r14) throws com.google.android.exoplayer2.text.SubtitleDecoderException {
        /*
            Method dump skipped, instructions count: 336
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.text.s.c.O(java.lang.String, com.google.android.exoplayer2.text.s.c$b):long");
    }

    @Nullable
    private static C0087c P(XmlPullParser xmlPullParser) {
        String a2 = p0.a(xmlPullParser, "extent");
        if (a2 == null) {
            return null;
        }
        Matcher matcher = t.matcher(a2);
        if (!matcher.matches()) {
            u.h("TtmlDecoder", a2.length() != 0 ? "Ignoring non-pixel tts extent: ".concat(a2) : new String("Ignoring non-pixel tts extent: "));
            return null;
        }
        try {
            return new C0087c(Integer.parseInt((String) g.e(matcher.group(1))), Integer.parseInt((String) g.e(matcher.group(2))));
        } catch (NumberFormatException unused) {
            u.h("TtmlDecoder", a2.length() != 0 ? "Ignoring malformed tts extent: ".concat(a2) : new String("Ignoring malformed tts extent: "));
            return null;
        }
    }

    @Override // com.google.android.exoplayer2.text.d
    protected f y(byte[] bArr, int i, boolean z) throws SubtitleDecoderException {
        try {
            XmlPullParser newPullParser = this.x.newPullParser();
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = new HashMap();
            HashMap hashMap3 = new HashMap();
            hashMap2.put("", new e(""));
            C0087c cVar = null;
            newPullParser.setInput(new ByteArrayInputStream(bArr, 0, i), null);
            ArrayDeque arrayDeque = new ArrayDeque();
            b bVar = v;
            a aVar = w;
            h hVar = null;
            int i2 = 0;
            for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.getEventType()) {
                d dVar = (d) arrayDeque.peek();
                if (i2 == 0) {
                    String name = newPullParser.getName();
                    if (eventType == 2) {
                        if ("tt".equals(name)) {
                            bVar = G(newPullParser);
                            aVar = E(newPullParser, w);
                            cVar = P(newPullParser);
                        }
                        if (!C(name)) {
                            String valueOf = String.valueOf(newPullParser.getName());
                            u.f("TtmlDecoder", valueOf.length() != 0 ? "Ignoring unsupported tag: ".concat(valueOf) : new String("Ignoring unsupported tag: "));
                            i2++;
                            bVar = bVar;
                        } else if ("head".equals(name)) {
                            bVar = bVar;
                            H(newPullParser, hashMap, aVar, cVar, hashMap2, hashMap3);
                        } else {
                            bVar = bVar;
                            try {
                                d J = J(newPullParser, dVar, hashMap2, bVar);
                                arrayDeque.push(J);
                                if (dVar != null) {
                                    dVar.a(J);
                                }
                            } catch (SubtitleDecoderException e2) {
                                u.i("TtmlDecoder", "Suppressing parser error", e2);
                                i2++;
                            }
                        }
                        cVar = cVar;
                        aVar = aVar;
                    } else if (eventType == 4) {
                        ((d) g.e(dVar)).a(d.d(newPullParser.getText()));
                    } else if (eventType == 3) {
                        if (newPullParser.getName().equals("tt")) {
                            hVar = new h((d) g.e((d) arrayDeque.peek()), hashMap, hashMap2, hashMap3);
                        }
                        arrayDeque.pop();
                    }
                } else if (eventType == 2) {
                    i2++;
                } else if (eventType == 3) {
                    i2--;
                }
                newPullParser.next();
            }
            if (hVar != null) {
                return hVar;
            }
            throw new SubtitleDecoderException("No TTML subtitles found");
        } catch (IOException e3) {
            throw new IllegalStateException("Unexpected error when reading input.", e3);
        } catch (XmlPullParserException e4) {
            throw new SubtitleDecoderException("Unable to decode source", e4);
        }
    }
}
