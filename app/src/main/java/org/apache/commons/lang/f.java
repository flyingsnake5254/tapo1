package org.apache.commons.lang;

import java.io.PrintStream;

/* compiled from: SystemUtils.java */
/* loaded from: classes4.dex */
public class f {
    public static final String K;
    public static final String L;
    public static final String M;
    public static final String N;
    public static final String O;
    public static final String P;
    public static final String Q;
    public static final float R;
    public static final int S;
    public static final boolean T;
    public static final boolean U;
    public static final boolean V;
    public static final boolean W;
    public static final boolean X;
    public static final boolean Y;
    public static final boolean Z;
    public static final boolean a0;
    public static final boolean b0;
    public static final boolean c0;
    public static final boolean d0;
    public static final boolean e0;
    public static final boolean f0;
    public static final boolean g0;
    public static final boolean h0;
    public static final boolean i0;
    public static final boolean j0;
    public static final boolean k0;
    public static final boolean l0;
    public static final boolean m0;
    public static final boolean n0;
    public static final boolean o0;
    public static final boolean p0;
    public static final boolean q0;
    public static final boolean r0;
    public static final boolean s0;
    public static final String a = g("awt.toolkit");

    /* renamed from: b  reason: collision with root package name */
    public static final String f16648b = g("file.encoding");

    /* renamed from: c  reason: collision with root package name */
    public static final String f16649c = g("file.separator");

    /* renamed from: d  reason: collision with root package name */
    public static final String f16650d = g("java.awt.fonts");

    /* renamed from: e  reason: collision with root package name */
    public static final String f16651e = g("java.awt.graphicsenv");

    /* renamed from: f  reason: collision with root package name */
    public static final String f16652f = g("java.awt.headless");
    public static final String g = g("java.awt.printerjob");
    public static final String h = g("java.class.path");
    public static final String i = g("java.class.version");
    public static final String j = g("java.compiler");
    public static final String k = g("java.endorsed.dirs");
    public static final String l = g("java.ext.dirs");
    public static final String m = g("java.home");
    public static final String n = g("java.io.tmpdir");
    public static final String o = g("java.library.path");
    public static final String p = g("java.runtime.name");
    public static final String q = g("java.runtime.version");
    public static final String r = g("java.specification.name");
    public static final String s = g("java.specification.vendor");
    public static final String t = g("java.specification.version");
    public static final String u = g("java.util.prefs.PreferencesFactory");
    public static final String v = g("java.vendor");
    public static final String w = g("java.vendor.url");
    public static final String x = g("java.version");
    public static final String y = g("java.vm.info");
    public static final String z = g("java.vm.name");
    public static final String A = g("java.vm.specification.name");
    public static final String B = g("java.vm.specification.vendor");
    public static final String C = g("java.vm.specification.version");
    public static final String D = g("java.vm.vendor");
    public static final String E = g("java.vm.version");
    public static final String F = g("line.separator");
    public static final String G = g("os.arch");
    public static final String H = g("os.name");
    public static final String I = g("os.version");
    public static final String J = g("path.separator");

    static {
        String str = "user.country";
        if (g(str) == null) {
            str = "user.region";
        }
        K = g(str);
        L = g("user.dir");
        M = g("user.home");
        N = g("user.language");
        O = g("user.name");
        P = g("user.timezone");
        Q = d();
        R = a();
        S = b();
        T = c("1.1");
        U = c("1.2");
        V = c("1.3");
        W = c("1.4");
        X = c("1.5");
        Y = c("1.6");
        Z = c("1.7");
        boolean f2 = f("AIX");
        a0 = f2;
        boolean f3 = f("HP-UX");
        b0 = f3;
        boolean f4 = f("Irix");
        c0 = f4;
        boolean z2 = false;
        boolean z3 = f("Linux") || f("LINUX");
        d0 = z3;
        e0 = f("Mac");
        boolean f5 = f("Mac OS X");
        f0 = f5;
        g0 = f("OS/2");
        boolean f6 = f("Solaris");
        h0 = f6;
        boolean f7 = f("SunOS");
        i0 = f7;
        if (f2 || f3 || f4 || z3 || f5 || f6 || f7) {
            z2 = true;
        }
        j0 = z2;
        k0 = f("Windows");
        l0 = e("Windows", "5.0");
        m0 = e("Windows 9", "4.0");
        n0 = e("Windows 9", "4.1");
        o0 = e("Windows", "4.9");
        p0 = f("Windows NT");
        q0 = e("Windows", "5.1");
        r0 = e("Windows", "6.0");
        s0 = e("Windows", "6.1");
    }

    private static float a() {
        return m(l(x, 3));
    }

    private static int b() {
        return n(l(x, 3));
    }

    private static boolean c(String str) {
        return i(Q, str);
    }

    private static String d() {
        if (x == null) {
            return null;
        }
        int i2 = 0;
        while (true) {
            String str = x;
            if (i2 >= str.length()) {
                return null;
            }
            char charAt = str.charAt(i2);
            if (charAt >= '0' && charAt <= '9') {
                return str.substring(i2);
            }
            i2++;
        }
    }

    private static boolean e(String str, String str2) {
        return j(H, I, str, str2);
    }

    private static boolean f(String str) {
        return k(H, str);
    }

    private static String g(String str) {
        try {
            return System.getProperty(str);
        } catch (SecurityException unused) {
            PrintStream printStream = System.err;
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Caught a SecurityException reading the system property '");
            stringBuffer.append(str);
            stringBuffer.append("'; the SystemUtils property value will default to null.");
            printStream.println(stringBuffer.toString());
            return null;
        }
    }

    public static boolean h(float f2) {
        return R >= f2;
    }

    static boolean i(String str, String str2) {
        if (str == null) {
            return false;
        }
        return str.startsWith(str2);
    }

    static boolean j(String str, String str2, String str3, String str4) {
        return str != null && str2 != null && str.startsWith(str3) && str2.startsWith(str4);
    }

    static boolean k(String str, String str2) {
        if (str == null) {
            return false;
        }
        return str.startsWith(str2);
    }

    private static int[] l(String str, int i2) {
        if (str == null) {
            return a.f16632f;
        }
        String[] d2 = e.d(str, "._- ");
        int min = Math.min(i2, d2.length);
        int[] iArr = new int[min];
        int i3 = 0;
        for (int i4 = 0; i4 < d2.length && i3 < i2; i4++) {
            String str2 = d2[i4];
            if (str2.length() > 0) {
                try {
                    iArr[i3] = Integer.parseInt(str2);
                    i3++;
                } catch (Exception unused) {
                }
            }
        }
        if (min <= i3) {
            return iArr;
        }
        int[] iArr2 = new int[i3];
        System.arraycopy(iArr, 0, iArr2, 0, i3);
        return iArr2;
    }

    private static float m(int[] iArr) {
        if (!(iArr == null || iArr.length == 0)) {
            if (iArr.length == 1) {
                return iArr[0];
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(iArr[0]);
            stringBuffer.append('.');
            for (int i2 = 1; i2 < iArr.length; i2++) {
                stringBuffer.append(iArr[i2]);
            }
            try {
                return Float.parseFloat(stringBuffer.toString());
            } catch (Exception unused) {
            }
        }
        return 0.0f;
    }

    private static int n(int[] iArr) {
        int i2 = 0;
        if (iArr == null) {
            return 0;
        }
        int length = iArr.length;
        if (length >= 1) {
            i2 = iArr[0] * 100;
        }
        if (length >= 2) {
            i2 += iArr[1] * 10;
        }
        return length >= 3 ? i2 + iArr[2] : i2;
    }
}
