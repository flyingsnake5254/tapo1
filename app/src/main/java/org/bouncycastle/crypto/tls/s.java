package org.bouncycastle.crypto.tls;

/* loaded from: classes4.dex */
public class s {
    public static String a(short s) {
        switch (s) {
            case 0:
                return "none";
            case 1:
                return "md5";
            case 2:
                return "sha1";
            case 3:
                return "sha224";
            case 4:
                return "sha256";
            case 5:
                return "sha384";
            case 6:
                return "sha512";
            default:
                return "UNKNOWN";
        }
    }

    public static String b(short s) {
        return a(s) + "(" + ((int) s) + ")";
    }

    public static boolean c(short s) {
        return 224 <= s && s <= 255;
    }
}
