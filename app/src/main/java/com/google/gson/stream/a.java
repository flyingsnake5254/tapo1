package com.google.gson.stream;

import com.google.gson.internal.e;
import io.netty.util.internal.StringUtil;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import java.util.Objects;

/* compiled from: JsonReader.java */
/* loaded from: classes2.dex */
public class a implements Closeable {

    /* renamed from: c  reason: collision with root package name */
    private static final char[] f4929c = ")]}'\n".toCharArray();
    private String H3;
    private int[] I3;
    private int J3;

    /* renamed from: d  reason: collision with root package name */
    private final Reader f4930d;
    private long p2;
    private int p3;

    /* renamed from: f  reason: collision with root package name */
    private boolean f4931f = false;
    private final char[] q = new char[1024];
    private int x = 0;
    private int y = 0;
    private int z = 0;
    private int p0 = 0;
    int p1 = 0;
    private String[] K3 = new String[32];
    private int[] L3 = new int[32];

    /* compiled from: JsonReader.java */
    /* renamed from: com.google.gson.stream.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    class C0180a extends e {
        C0180a() {
        }

        @Override // com.google.gson.internal.e
        public void a(a aVar) throws IOException {
            if (aVar instanceof com.google.gson.internal.bind.a) {
                ((com.google.gson.internal.bind.a) aVar).V();
                return;
            }
            int i = aVar.p1;
            if (i == 0) {
                i = aVar.i();
            }
            if (i == 13) {
                aVar.p1 = 9;
            } else if (i == 12) {
                aVar.p1 = 8;
            } else if (i == 14) {
                aVar.p1 = 10;
            } else {
                throw new IllegalStateException("Expected a name but was " + aVar.G() + aVar.v());
            }
        }
    }

    static {
        e.a = new C0180a();
    }

    public a(Reader reader) {
        int[] iArr = new int[32];
        this.I3 = iArr;
        this.J3 = 0;
        this.J3 = 0 + 1;
        iArr[0] = 6;
        Objects.requireNonNull(reader, "in == null");
        this.f4930d = reader;
    }

    private int B(boolean z) throws IOException {
        char[] cArr = this.q;
        int i = this.x;
        int i2 = this.y;
        while (true) {
            if (i == i2) {
                this.x = i;
                if (l(1)) {
                    i = this.x;
                    i2 = this.y;
                } else if (!z) {
                    return -1;
                } else {
                    throw new EOFException("End of input" + v());
                }
            }
            int i3 = i + 1;
            char c2 = cArr[i];
            if (c2 == '\n') {
                this.z++;
                this.p0 = i3;
            } else if (!(c2 == ' ' || c2 == '\r' || c2 == '\t')) {
                if (c2 == '/') {
                    this.x = i3;
                    if (i3 == i2) {
                        this.x = i3 - 1;
                        boolean l = l(2);
                        this.x++;
                        if (!l) {
                            return c2;
                        }
                    }
                    e();
                    int i4 = this.x;
                    char c3 = cArr[i4];
                    if (c3 == '*') {
                        this.x = i4 + 1;
                        if (N("*/")) {
                            i = this.x + 2;
                            i2 = this.y;
                        } else {
                            throw R("Unterminated comment");
                        }
                    } else if (c3 != '/') {
                        return c2;
                    } else {
                        this.x = i4 + 1;
                        O();
                        i = this.x;
                        i2 = this.y;
                    }
                } else if (c2 == '#') {
                    this.x = i3;
                    e();
                    O();
                    i = this.x;
                    i2 = this.y;
                } else {
                    this.x = i3;
                    return c2;
                }
            }
            i = i3;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x005c, code lost:
        if (r1 != null) goto L_0x006c;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x005e, code lost:
        r1 = new java.lang.StringBuilder(java.lang.Math.max((r2 - r2) * 2, 16));
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x006c, code lost:
        r1.append(r0, r2, r2 - r2);
        r9.x = r2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String D(char r10) throws java.io.IOException {
        /*
            r9 = this;
            char[] r0 = r9.q
            r1 = 0
        L_0x0003:
            int r2 = r9.x
            int r3 = r9.y
        L_0x0007:
            r4 = r3
            r3 = r2
        L_0x0009:
            r5 = 16
            r6 = 1
            if (r2 >= r4) goto L_0x005c
            int r7 = r2 + 1
            char r2 = r0[r2]
            if (r2 != r10) goto L_0x0028
            r9.x = r7
            int r7 = r7 - r3
            int r7 = r7 - r6
            if (r1 != 0) goto L_0x0020
            java.lang.String r10 = new java.lang.String
            r10.<init>(r0, r3, r7)
            return r10
        L_0x0020:
            r1.append(r0, r3, r7)
            java.lang.String r10 = r1.toString()
            return r10
        L_0x0028:
            r8 = 92
            if (r2 != r8) goto L_0x004f
            r9.x = r7
            int r7 = r7 - r3
            int r7 = r7 - r6
            if (r1 != 0) goto L_0x0040
            int r1 = r7 + 1
            int r1 = r1 * 2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            int r1 = java.lang.Math.max(r1, r5)
            r2.<init>(r1)
            r1 = r2
        L_0x0040:
            r1.append(r0, r3, r7)
            char r2 = r9.K()
            r1.append(r2)
            int r2 = r9.x
            int r3 = r9.y
            goto L_0x0007
        L_0x004f:
            r5 = 10
            if (r2 != r5) goto L_0x005a
            int r2 = r9.z
            int r2 = r2 + r6
            r9.z = r2
            r9.p0 = r7
        L_0x005a:
            r2 = r7
            goto L_0x0009
        L_0x005c:
            if (r1 != 0) goto L_0x006c
            int r1 = r2 - r3
            int r1 = r1 * 2
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            int r1 = java.lang.Math.max(r1, r5)
            r4.<init>(r1)
            r1 = r4
        L_0x006c:
            int r4 = r2 - r3
            r1.append(r0, r3, r4)
            r9.x = r2
            boolean r2 = r9.l(r6)
            if (r2 == 0) goto L_0x007a
            goto L_0x0003
        L_0x007a:
            java.lang.String r10 = "Unterminated string"
            java.io.IOException r10 = r9.R(r10)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.stream.a.D(char):java.lang.String");
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x004a, code lost:
        e();
     */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x008a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String F() throws java.io.IOException {
        /*
            r6 = this;
            r0 = 0
            r1 = 0
        L_0x0002:
            r2 = 0
        L_0x0003:
            int r3 = r6.x
            int r4 = r3 + r2
            int r5 = r6.y
            if (r4 >= r5) goto L_0x004e
            char[] r4 = r6.q
            int r3 = r3 + r2
            char r3 = r4[r3]
            r4 = 9
            if (r3 == r4) goto L_0x005c
            r4 = 10
            if (r3 == r4) goto L_0x005c
            r4 = 12
            if (r3 == r4) goto L_0x005c
            r4 = 13
            if (r3 == r4) goto L_0x005c
            r4 = 32
            if (r3 == r4) goto L_0x005c
            r4 = 35
            if (r3 == r4) goto L_0x004a
            r4 = 44
            if (r3 == r4) goto L_0x005c
            r4 = 47
            if (r3 == r4) goto L_0x004a
            r4 = 61
            if (r3 == r4) goto L_0x004a
            r4 = 123(0x7b, float:1.72E-43)
            if (r3 == r4) goto L_0x005c
            r4 = 125(0x7d, float:1.75E-43)
            if (r3 == r4) goto L_0x005c
            r4 = 58
            if (r3 == r4) goto L_0x005c
            r4 = 59
            if (r3 == r4) goto L_0x004a
            switch(r3) {
                case 91: goto L_0x005c;
                case 92: goto L_0x004a;
                case 93: goto L_0x005c;
                default: goto L_0x0047;
            }
        L_0x0047:
            int r2 = r2 + 1
            goto L_0x0003
        L_0x004a:
            r6.e()
            goto L_0x005c
        L_0x004e:
            char[] r3 = r6.q
            int r3 = r3.length
            if (r2 >= r3) goto L_0x005e
            int r3 = r2 + 1
            boolean r3 = r6.l(r3)
            if (r3 == 0) goto L_0x005c
            goto L_0x0003
        L_0x005c:
            r0 = r2
            goto L_0x007e
        L_0x005e:
            if (r1 != 0) goto L_0x006b
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r3 = 16
            int r3 = java.lang.Math.max(r2, r3)
            r1.<init>(r3)
        L_0x006b:
            char[] r3 = r6.q
            int r4 = r6.x
            r1.append(r3, r4, r2)
            int r3 = r6.x
            int r3 = r3 + r2
            r6.x = r3
            r2 = 1
            boolean r2 = r6.l(r2)
            if (r2 != 0) goto L_0x0002
        L_0x007e:
            if (r1 != 0) goto L_0x008a
            java.lang.String r1 = new java.lang.String
            char[] r2 = r6.q
            int r3 = r6.x
            r1.<init>(r2, r3, r0)
            goto L_0x0095
        L_0x008a:
            char[] r2 = r6.q
            int r3 = r6.x
            r1.append(r2, r3, r0)
            java.lang.String r1 = r1.toString()
        L_0x0095:
            int r2 = r6.x
            int r2 = r2 + r0
            r6.x = r2
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.stream.a.F():java.lang.String");
    }

    private int H() throws IOException {
        String str;
        String str2;
        int i;
        char c2 = this.q[this.x];
        if (c2 == 't' || c2 == 'T') {
            i = 5;
            str2 = "true";
            str = "TRUE";
        } else if (c2 == 'f' || c2 == 'F') {
            i = 6;
            str2 = "false";
            str = "FALSE";
        } else if (c2 != 'n' && c2 != 'N') {
            return 0;
        } else {
            i = 7;
            str2 = "null";
            str = "NULL";
        }
        int length = str2.length();
        for (int i2 = 1; i2 < length; i2++) {
            if (this.x + i2 >= this.y && !l(i2 + 1)) {
                return 0;
            }
            char c3 = this.q[this.x + i2];
            if (!(c3 == str2.charAt(i2) || c3 == str.charAt(i2))) {
                return 0;
            }
        }
        if ((this.x + length < this.y || l(length + 1)) && u(this.q[this.x + length])) {
            return 0;
        }
        this.x += length;
        this.p1 = i;
        return i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:49:0x0095, code lost:
        if (u(r14) != false) goto L_0x00cd;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0097, code lost:
        if (r9 != 2) goto L_0x00bb;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0099, code lost:
        if (r10 == false) goto L_0x00bb;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x009f, code lost:
        if (r11 != Long.MIN_VALUE) goto L_0x00a3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00a1, code lost:
        if (r13 == false) goto L_0x00bb;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00a7, code lost:
        if (r11 != 0) goto L_0x00ab;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00a9, code lost:
        if (r13 != false) goto L_0x00bb;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00ab, code lost:
        if (r13 == false) goto L_0x00ae;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00ae, code lost:
        r11 = -r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00af, code lost:
        r18.p2 = r11;
        r18.x += r8;
        r18.p1 = 15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00ba, code lost:
        return 15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00bb, code lost:
        if (r9 == 2) goto L_0x00c6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00be, code lost:
        if (r9 == 4) goto L_0x00c6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x00c1, code lost:
        if (r9 != 7) goto L_0x00c4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00c4, code lost:
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00c6, code lost:
        r18.p3 = r8;
        r18.p1 = 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x00cc, code lost:
        return 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x00cd, code lost:
        return 0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int I() throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 252
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.stream.a.I():int");
    }

    private void J(int i) {
        int i2 = this.J3;
        int[] iArr = this.I3;
        if (i2 == iArr.length) {
            int i3 = i2 * 2;
            this.I3 = Arrays.copyOf(iArr, i3);
            this.L3 = Arrays.copyOf(this.L3, i3);
            this.K3 = (String[]) Arrays.copyOf(this.K3, i3);
        }
        int[] iArr2 = this.I3;
        int i4 = this.J3;
        this.J3 = i4 + 1;
        iArr2[i4] = i;
    }

    private char K() throws IOException {
        int i;
        int i2;
        if (this.x != this.y || l(1)) {
            char[] cArr = this.q;
            int i3 = this.x;
            int i4 = i3 + 1;
            this.x = i4;
            char c2 = cArr[i3];
            if (c2 == '\n') {
                this.z++;
                this.p0 = i4;
            } else if (!(c2 == '\"' || c2 == '\'' || c2 == '/' || c2 == '\\')) {
                if (c2 == 'b') {
                    return '\b';
                }
                if (c2 == 'f') {
                    return '\f';
                }
                if (c2 == 'n') {
                    return '\n';
                }
                if (c2 == 'r') {
                    return StringUtil.CARRIAGE_RETURN;
                }
                if (c2 == 't') {
                    return '\t';
                }
                if (c2 != 'u') {
                    throw R("Invalid escape sequence");
                } else if (i4 + 4 <= this.y || l(4)) {
                    char c3 = 0;
                    int i5 = this.x;
                    int i6 = i5 + 4;
                    while (i5 < i6) {
                        char c4 = this.q[i5];
                        char c5 = (char) (c3 << 4);
                        if (c4 < '0' || c4 > '9') {
                            if (c4 >= 'a' && c4 <= 'f') {
                                i = c4 - 'a';
                            } else if (c4 < 'A' || c4 > 'F') {
                                throw new NumberFormatException("\\u" + new String(this.q, this.x, 4));
                            } else {
                                i = c4 - 'A';
                            }
                            i2 = i + 10;
                        } else {
                            i2 = c4 - '0';
                        }
                        c3 = (char) (c5 + i2);
                        i5++;
                    }
                    this.x += 4;
                    return c3;
                } else {
                    throw R("Unterminated escape sequence");
                }
            }
            return c2;
        }
        throw R("Unterminated escape sequence");
    }

    private void M(char c2) throws IOException {
        char[] cArr = this.q;
        do {
            int i = this.x;
            int i2 = this.y;
            while (i < i2) {
                int i3 = i + 1;
                char c3 = cArr[i];
                if (c3 == c2) {
                    this.x = i3;
                    return;
                } else if (c3 == '\\') {
                    this.x = i3;
                    K();
                    i = this.x;
                    i2 = this.y;
                } else {
                    if (c3 == '\n') {
                        this.z++;
                        this.p0 = i3;
                    }
                    i = i3;
                }
            }
            this.x = i;
        } while (l(1));
        throw R("Unterminated string");
    }

    private boolean N(String str) throws IOException {
        int length = str.length();
        while (true) {
            if (this.x + length > this.y && !l(length)) {
                return false;
            }
            char[] cArr = this.q;
            int i = this.x;
            if (cArr[i] == '\n') {
                this.z++;
                this.p0 = i + 1;
            } else {
                for (int i2 = 0; i2 < length; i2++) {
                    if (this.q[this.x + i2] != str.charAt(i2)) {
                        break;
                    }
                }
                return true;
            }
            this.x++;
        }
    }

    private void O() throws IOException {
        char c2;
        do {
            if (this.x < this.y || l(1)) {
                char[] cArr = this.q;
                int i = this.x;
                int i2 = i + 1;
                this.x = i2;
                c2 = cArr[i];
                if (c2 == '\n') {
                    this.z++;
                    this.p0 = i2;
                    return;
                }
            } else {
                return;
            }
        } while (c2 != '\r');
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0048, code lost:
        e();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void P() throws java.io.IOException {
        /*
            r4 = this;
        L_0x0000:
            r0 = 0
        L_0x0001:
            int r1 = r4.x
            int r2 = r1 + r0
            int r3 = r4.y
            if (r2 >= r3) goto L_0x0051
            char[] r2 = r4.q
            int r1 = r1 + r0
            char r1 = r2[r1]
            r2 = 9
            if (r1 == r2) goto L_0x004b
            r2 = 10
            if (r1 == r2) goto L_0x004b
            r2 = 12
            if (r1 == r2) goto L_0x004b
            r2 = 13
            if (r1 == r2) goto L_0x004b
            r2 = 32
            if (r1 == r2) goto L_0x004b
            r2 = 35
            if (r1 == r2) goto L_0x0048
            r2 = 44
            if (r1 == r2) goto L_0x004b
            r2 = 47
            if (r1 == r2) goto L_0x0048
            r2 = 61
            if (r1 == r2) goto L_0x0048
            r2 = 123(0x7b, float:1.72E-43)
            if (r1 == r2) goto L_0x004b
            r2 = 125(0x7d, float:1.75E-43)
            if (r1 == r2) goto L_0x004b
            r2 = 58
            if (r1 == r2) goto L_0x004b
            r2 = 59
            if (r1 == r2) goto L_0x0048
            switch(r1) {
                case 91: goto L_0x004b;
                case 92: goto L_0x0048;
                case 93: goto L_0x004b;
                default: goto L_0x0045;
            }
        L_0x0045:
            int r0 = r0 + 1
            goto L_0x0001
        L_0x0048:
            r4.e()
        L_0x004b:
            int r1 = r4.x
            int r1 = r1 + r0
            r4.x = r1
            return
        L_0x0051:
            int r1 = r1 + r0
            r4.x = r1
            r0 = 1
            boolean r0 = r4.l(r0)
            if (r0 != 0) goto L_0x0000
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.stream.a.P():void");
    }

    private IOException R(String str) throws IOException {
        throw new MalformedJsonException(str + v());
    }

    private void e() throws IOException {
        if (!this.f4931f) {
            throw R("Use JsonReader.setLenient(true) to accept malformed JSON");
        }
    }

    private void g() throws IOException {
        B(true);
        int i = this.x - 1;
        this.x = i;
        char[] cArr = f4929c;
        if (i + cArr.length <= this.y || l(cArr.length)) {
            int i2 = 0;
            while (true) {
                char[] cArr2 = f4929c;
                if (i2 >= cArr2.length) {
                    this.x += cArr2.length;
                    return;
                } else if (this.q[this.x + i2] == cArr2[i2]) {
                    i2++;
                } else {
                    return;
                }
            }
        }
    }

    private boolean l(int i) throws IOException {
        int i2;
        int i3;
        char[] cArr = this.q;
        int i4 = this.p0;
        int i5 = this.x;
        this.p0 = i4 - i5;
        int i6 = this.y;
        if (i6 != i5) {
            int i7 = i6 - i5;
            this.y = i7;
            System.arraycopy(cArr, i5, cArr, 0, i7);
        } else {
            this.y = 0;
        }
        this.x = 0;
        do {
            Reader reader = this.f4930d;
            int i8 = this.y;
            int read = reader.read(cArr, i8, cArr.length - i8);
            if (read == -1) {
                return false;
            }
            i2 = this.y + read;
            this.y = i2;
            if (this.z == 0 && (i3 = this.p0) == 0 && i2 > 0 && cArr[0] == 65279) {
                this.x++;
                this.p0 = i3 + 1;
                i++;
                continue;
            }
        } while (i2 < i);
        return true;
    }

    private boolean u(char c2) throws IOException {
        if (c2 == '\t' || c2 == '\n' || c2 == '\f' || c2 == '\r' || c2 == ' ') {
            return false;
        }
        if (c2 != '#') {
            if (c2 == ',') {
                return false;
            }
            if (!(c2 == '/' || c2 == '=')) {
                if (c2 == '{' || c2 == '}' || c2 == ':') {
                    return false;
                }
                if (c2 != ';') {
                    switch (c2) {
                        case '[':
                        case ']':
                            return false;
                        case '\\':
                            break;
                        default:
                            return true;
                    }
                }
            }
        }
        e();
        return false;
    }

    public String A() throws IOException {
        String str;
        int i = this.p1;
        if (i == 0) {
            i = i();
        }
        if (i == 14) {
            str = F();
        } else if (i == 12) {
            str = D('\'');
        } else if (i == 13) {
            str = D(StringUtil.DOUBLE_QUOTE);
        } else {
            throw new IllegalStateException("Expected a name but was " + G() + v());
        }
        this.p1 = 0;
        this.K3[this.J3 - 1] = str;
        return str;
    }

    public void C() throws IOException {
        int i = this.p1;
        if (i == 0) {
            i = i();
        }
        if (i == 7) {
            this.p1 = 0;
            int[] iArr = this.L3;
            int i2 = this.J3 - 1;
            iArr[i2] = iArr[i2] + 1;
            return;
        }
        throw new IllegalStateException("Expected null but was " + G() + v());
    }

    public String E() throws IOException {
        String str;
        int i = this.p1;
        if (i == 0) {
            i = i();
        }
        if (i == 10) {
            str = F();
        } else if (i == 8) {
            str = D('\'');
        } else if (i == 9) {
            str = D(StringUtil.DOUBLE_QUOTE);
        } else if (i == 11) {
            str = this.H3;
            this.H3 = null;
        } else if (i == 15) {
            str = Long.toString(this.p2);
        } else if (i == 16) {
            str = new String(this.q, this.x, this.p3);
            this.x += this.p3;
        } else {
            throw new IllegalStateException("Expected a string but was " + G() + v());
        }
        this.p1 = 0;
        int[] iArr = this.L3;
        int i2 = this.J3 - 1;
        iArr[i2] = iArr[i2] + 1;
        return str;
    }

    public JsonToken G() throws IOException {
        int i = this.p1;
        if (i == 0) {
            i = i();
        }
        switch (i) {
            case 1:
                return JsonToken.BEGIN_OBJECT;
            case 2:
                return JsonToken.END_OBJECT;
            case 3:
                return JsonToken.BEGIN_ARRAY;
            case 4:
                return JsonToken.END_ARRAY;
            case 5:
            case 6:
                return JsonToken.BOOLEAN;
            case 7:
                return JsonToken.NULL;
            case 8:
            case 9:
            case 10:
            case 11:
                return JsonToken.STRING;
            case 12:
            case 13:
            case 14:
                return JsonToken.NAME;
            case 15:
            case 16:
                return JsonToken.NUMBER;
            case 17:
                return JsonToken.END_DOCUMENT;
            default:
                throw new AssertionError();
        }
    }

    public final void L(boolean z) {
        this.f4931f = z;
    }

    public void Q() throws IOException {
        int i = 0;
        do {
            int i2 = this.p1;
            if (i2 == 0) {
                i2 = i();
            }
            if (i2 == 3) {
                J(1);
            } else if (i2 == 1) {
                J(3);
            } else {
                if (i2 == 4) {
                    this.J3--;
                } else if (i2 == 2) {
                    this.J3--;
                } else {
                    if (i2 == 14 || i2 == 10) {
                        P();
                    } else if (i2 == 8 || i2 == 12) {
                        M('\'');
                    } else if (i2 == 9 || i2 == 13) {
                        M(StringUtil.DOUBLE_QUOTE);
                    } else if (i2 == 16) {
                        this.x += this.p3;
                    }
                    this.p1 = 0;
                }
                i--;
                this.p1 = 0;
            }
            i++;
            this.p1 = 0;
        } while (i != 0);
        int[] iArr = this.L3;
        int i3 = this.J3;
        int i4 = i3 - 1;
        iArr[i4] = iArr[i4] + 1;
        this.K3[i3 - 1] = "null";
    }

    public void a() throws IOException {
        int i = this.p1;
        if (i == 0) {
            i = i();
        }
        if (i == 3) {
            J(1);
            this.L3[this.J3 - 1] = 0;
            this.p1 = 0;
            return;
        }
        throw new IllegalStateException("Expected BEGIN_ARRAY but was " + G() + v());
    }

    public void c() throws IOException {
        int i = this.p1;
        if (i == 0) {
            i = i();
        }
        if (i == 1) {
            J(3);
            this.p1 = 0;
            return;
        }
        throw new IllegalStateException("Expected BEGIN_OBJECT but was " + G() + v());
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.p1 = 0;
        this.I3[0] = 8;
        this.J3 = 1;
        this.f4930d.close();
    }

    public String getPath() {
        StringBuilder sb = new StringBuilder();
        sb.append('$');
        int i = this.J3;
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = this.I3[i2];
            if (i3 == 1 || i3 == 2) {
                sb.append('[');
                sb.append(this.L3[i2]);
                sb.append(']');
            } else if (i3 == 3 || i3 == 4 || i3 == 5) {
                sb.append('.');
                String[] strArr = this.K3;
                if (strArr[i2] != null) {
                    sb.append(strArr[i2]);
                }
            }
        }
        return sb.toString();
    }

    int i() throws IOException {
        int B;
        int[] iArr = this.I3;
        int i = this.J3;
        int i2 = iArr[i - 1];
        if (i2 == 1) {
            iArr[i - 1] = 2;
        } else if (i2 == 2) {
            int B2 = B(true);
            if (B2 != 44) {
                if (B2 == 59) {
                    e();
                } else if (B2 == 93) {
                    this.p1 = 4;
                    return 4;
                } else {
                    throw R("Unterminated array");
                }
            }
        } else if (i2 == 3 || i2 == 5) {
            iArr[i - 1] = 4;
            if (i2 == 5 && (B = B(true)) != 44) {
                if (B == 59) {
                    e();
                } else if (B == 125) {
                    this.p1 = 2;
                    return 2;
                } else {
                    throw R("Unterminated object");
                }
            }
            int B3 = B(true);
            if (B3 == 34) {
                this.p1 = 13;
                return 13;
            } else if (B3 == 39) {
                e();
                this.p1 = 12;
                return 12;
            } else if (B3 != 125) {
                e();
                this.x--;
                if (u((char) B3)) {
                    this.p1 = 14;
                    return 14;
                }
                throw R("Expected name");
            } else if (i2 != 5) {
                this.p1 = 2;
                return 2;
            } else {
                throw R("Expected name");
            }
        } else if (i2 == 4) {
            iArr[i - 1] = 5;
            int B4 = B(true);
            if (B4 != 58) {
                if (B4 == 61) {
                    e();
                    if (this.x < this.y || l(1)) {
                        char[] cArr = this.q;
                        int i3 = this.x;
                        if (cArr[i3] == '>') {
                            this.x = i3 + 1;
                        }
                    }
                } else {
                    throw R("Expected ':'");
                }
            }
        } else if (i2 == 6) {
            if (this.f4931f) {
                g();
            }
            this.I3[this.J3 - 1] = 7;
        } else if (i2 == 7) {
            if (B(false) == -1) {
                this.p1 = 17;
                return 17;
            }
            e();
            this.x--;
        } else if (i2 == 8) {
            throw new IllegalStateException("JsonReader is closed");
        }
        int B5 = B(true);
        if (B5 == 34) {
            this.p1 = 9;
            return 9;
        } else if (B5 != 39) {
            if (!(B5 == 44 || B5 == 59)) {
                if (B5 == 91) {
                    this.p1 = 3;
                    return 3;
                } else if (B5 != 93) {
                    if (B5 != 123) {
                        this.x--;
                        int H = H();
                        if (H != 0) {
                            return H;
                        }
                        int I = I();
                        if (I != 0) {
                            return I;
                        }
                        if (u(this.q[this.x])) {
                            e();
                            this.p1 = 10;
                            return 10;
                        }
                        throw R("Expected value");
                    }
                    this.p1 = 1;
                    return 1;
                } else if (i2 == 1) {
                    this.p1 = 4;
                    return 4;
                }
            }
            if (i2 == 1 || i2 == 2) {
                e();
                this.x--;
                this.p1 = 7;
                return 7;
            }
            throw R("Unexpected value");
        } else {
            e();
            this.p1 = 8;
            return 8;
        }
    }

    public void j() throws IOException {
        int i = this.p1;
        if (i == 0) {
            i = i();
        }
        if (i == 4) {
            int i2 = this.J3 - 1;
            this.J3 = i2;
            int[] iArr = this.L3;
            int i3 = i2 - 1;
            iArr[i3] = iArr[i3] + 1;
            this.p1 = 0;
            return;
        }
        throw new IllegalStateException("Expected END_ARRAY but was " + G() + v());
    }

    public void k() throws IOException {
        int i = this.p1;
        if (i == 0) {
            i = i();
        }
        if (i == 2) {
            int i2 = this.J3 - 1;
            this.J3 = i2;
            this.K3[i2] = null;
            int[] iArr = this.L3;
            int i3 = i2 - 1;
            iArr[i3] = iArr[i3] + 1;
            this.p1 = 0;
            return;
        }
        throw new IllegalStateException("Expected END_OBJECT but was " + G() + v());
    }

    public boolean s() throws IOException {
        int i = this.p1;
        if (i == 0) {
            i = i();
        }
        return (i == 2 || i == 4) ? false : true;
    }

    public final boolean t() {
        return this.f4931f;
    }

    public String toString() {
        return getClass().getSimpleName() + v();
    }

    String v() {
        return " at line " + (this.z + 1) + " column " + ((this.x - this.p0) + 1) + " path " + getPath();
    }

    public boolean w() throws IOException {
        int i = this.p1;
        if (i == 0) {
            i = i();
        }
        if (i == 5) {
            this.p1 = 0;
            int[] iArr = this.L3;
            int i2 = this.J3 - 1;
            iArr[i2] = iArr[i2] + 1;
            return true;
        } else if (i == 6) {
            this.p1 = 0;
            int[] iArr2 = this.L3;
            int i3 = this.J3 - 1;
            iArr2[i3] = iArr2[i3] + 1;
            return false;
        } else {
            throw new IllegalStateException("Expected a boolean but was " + G() + v());
        }
    }

    public double x() throws IOException {
        int i = this.p1;
        if (i == 0) {
            i = i();
        }
        if (i == 15) {
            this.p1 = 0;
            int[] iArr = this.L3;
            int i2 = this.J3 - 1;
            iArr[i2] = iArr[i2] + 1;
            return this.p2;
        }
        if (i == 16) {
            this.H3 = new String(this.q, this.x, this.p3);
            this.x += this.p3;
        } else if (i == 8 || i == 9) {
            this.H3 = D(i == 8 ? '\'' : StringUtil.DOUBLE_QUOTE);
        } else if (i == 10) {
            this.H3 = F();
        } else if (i != 11) {
            throw new IllegalStateException("Expected a double but was " + G() + v());
        }
        this.p1 = 11;
        double parseDouble = Double.parseDouble(this.H3);
        if (this.f4931f || (!Double.isNaN(parseDouble) && !Double.isInfinite(parseDouble))) {
            this.H3 = null;
            this.p1 = 0;
            int[] iArr2 = this.L3;
            int i3 = this.J3 - 1;
            iArr2[i3] = iArr2[i3] + 1;
            return parseDouble;
        }
        throw new MalformedJsonException("JSON forbids NaN and infinities: " + parseDouble + v());
    }

    public int y() throws IOException {
        int i = this.p1;
        if (i == 0) {
            i = i();
        }
        if (i == 15) {
            long j = this.p2;
            int i2 = (int) j;
            if (j == i2) {
                this.p1 = 0;
                int[] iArr = this.L3;
                int i3 = this.J3 - 1;
                iArr[i3] = iArr[i3] + 1;
                return i2;
            }
            throw new NumberFormatException("Expected an int but was " + this.p2 + v());
        }
        if (i == 16) {
            this.H3 = new String(this.q, this.x, this.p3);
            this.x += this.p3;
        } else if (i == 8 || i == 9 || i == 10) {
            if (i == 10) {
                this.H3 = F();
            } else {
                this.H3 = D(i == 8 ? '\'' : StringUtil.DOUBLE_QUOTE);
            }
            try {
                int parseInt = Integer.parseInt(this.H3);
                this.p1 = 0;
                int[] iArr2 = this.L3;
                int i4 = this.J3 - 1;
                iArr2[i4] = iArr2[i4] + 1;
                return parseInt;
            } catch (NumberFormatException unused) {
            }
        } else {
            throw new IllegalStateException("Expected an int but was " + G() + v());
        }
        this.p1 = 11;
        double parseDouble = Double.parseDouble(this.H3);
        int i5 = (int) parseDouble;
        if (i5 == parseDouble) {
            this.H3 = null;
            this.p1 = 0;
            int[] iArr3 = this.L3;
            int i6 = this.J3 - 1;
            iArr3[i6] = iArr3[i6] + 1;
            return i5;
        }
        throw new NumberFormatException("Expected an int but was " + this.H3 + v());
    }

    public long z() throws IOException {
        int i = this.p1;
        if (i == 0) {
            i = i();
        }
        if (i == 15) {
            this.p1 = 0;
            int[] iArr = this.L3;
            int i2 = this.J3 - 1;
            iArr[i2] = iArr[i2] + 1;
            return this.p2;
        }
        if (i == 16) {
            this.H3 = new String(this.q, this.x, this.p3);
            this.x += this.p3;
        } else if (i == 8 || i == 9 || i == 10) {
            if (i == 10) {
                this.H3 = F();
            } else {
                this.H3 = D(i == 8 ? '\'' : StringUtil.DOUBLE_QUOTE);
            }
            try {
                long parseLong = Long.parseLong(this.H3);
                this.p1 = 0;
                int[] iArr2 = this.L3;
                int i3 = this.J3 - 1;
                iArr2[i3] = iArr2[i3] + 1;
                return parseLong;
            } catch (NumberFormatException unused) {
            }
        } else {
            throw new IllegalStateException("Expected a long but was " + G() + v());
        }
        this.p1 = 11;
        double parseDouble = Double.parseDouble(this.H3);
        long j = (long) parseDouble;
        if (j == parseDouble) {
            this.H3 = null;
            this.p1 = 0;
            int[] iArr3 = this.L3;
            int i4 = this.J3 - 1;
            iArr3[i4] = iArr3[i4] + 1;
            return j;
        }
        throw new NumberFormatException("Expected a long but was " + this.H3 + v());
    }
}
