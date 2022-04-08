package org.bouncycastle.util;

import io.netty.handler.codec.memcache.binary.BinaryMemcacheOpcodes;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.security.AccessController;
import java.security.PrivilegedAction;

/* loaded from: classes4.dex */
public final class i {
    private static String a;

    /* loaded from: classes4.dex */
    static class a implements PrivilegedAction<String> {
        a() {
        }

        /* renamed from: a */
        public String run() {
            return System.getProperty("line.separator");
        }
    }

    static {
        try {
            try {
                a = (String) AccessController.doPrivileged(new a());
            } catch (Exception unused) {
                a = String.format("%n", new Object[0]);
            }
        } catch (Exception unused2) {
            a = "\n";
        }
    }

    public static char[] a(byte[] bArr) {
        int length = bArr.length;
        char[] cArr = new char[length];
        for (int i = 0; i != length; i++) {
            cArr[i] = (char) (bArr[i] & 255);
        }
        return cArr;
    }

    public static String b(byte[] bArr) {
        return new String(a(bArr));
    }

    public static String c(byte[] bArr) {
        char c2;
        int i;
        byte b2;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i3 < bArr.length) {
            i4++;
            if ((bArr[i3] & 240) == 240) {
                i4++;
                i3 += 4;
            } else {
                i3 = (bArr[i3] & 224) == 224 ? i3 + 3 : (bArr[i3] & 192) == 192 ? i3 + 2 : i3 + 1;
            }
        }
        char[] cArr = new char[i4];
        int i5 = 0;
        while (i2 < bArr.length) {
            if ((bArr[i2] & 240) == 240) {
                int i6 = (((((bArr[i2] & 3) << 18) | ((bArr[i2 + 1] & 63) << 12)) | ((bArr[i2 + 2] & 63) << 6)) | (bArr[i2 + 3] & 63)) - 65536;
                c2 = (char) ((i6 & 1023) | 56320);
                i5++;
                cArr[i5] = (char) (55296 | (i6 >> 10));
                i2 += 4;
            } else if ((bArr[i2] & 224) == 224) {
                c2 = (char) (((bArr[i2] & BinaryMemcacheOpcodes.PREPEND) << 12) | ((bArr[i2 + 1] & 63) << 6) | (bArr[i2 + 2] & 63));
                i2 += 3;
            } else {
                if ((bArr[i2] & 208) == 208) {
                    i = (bArr[i2] & 31) << 6;
                    b2 = bArr[i2 + 1];
                } else if ((bArr[i2] & 192) == 192) {
                    i = (bArr[i2] & 31) << 6;
                    b2 = bArr[i2 + 1];
                } else {
                    c2 = (char) (bArr[i2] & 255);
                    i2++;
                }
                c2 = (char) (i | (b2 & 63));
                i2 += 2;
            }
            i5++;
            cArr[i5] = c2;
        }
        return new String(cArr);
    }

    public static String d() {
        return a;
    }

    public static byte[] e(String str) {
        int length = str.length();
        byte[] bArr = new byte[length];
        for (int i = 0; i != length; i++) {
            bArr[i] = (byte) str.charAt(i);
        }
        return bArr;
    }

    public static String f(String str) {
        char[] charArray = str.toCharArray();
        boolean z = false;
        for (int i = 0; i != charArray.length; i++) {
            char c2 = charArray[i];
            if ('A' <= c2 && 'Z' >= c2) {
                charArray[i] = (char) ((c2 - 'A') + 97);
                z = true;
            }
        }
        return z ? new String(charArray) : str;
    }

    public static void g(char[] cArr, OutputStream outputStream) throws IOException {
        char c2;
        int i;
        int i2 = 0;
        while (i2 < cArr.length) {
            char c3 = cArr[i2];
            char c4 = c3;
            if (c3 >= 128) {
                if (c3 < 2048) {
                    i = (c3 >> 6) | 192;
                } else if (c3 < 55296 || c3 > 57343) {
                    outputStream.write((c3 >> '\f') | 224);
                    i = ((c3 >> 6) & 63) | 128;
                } else {
                    i2++;
                    if (i2 < cArr.length) {
                        char c5 = cArr[i2];
                        if (c3 <= 56319) {
                            int i3 = (((c3 & 1023) << 10) | (c5 & 1023)) + 65536;
                            outputStream.write((i3 >> 18) | 240);
                            outputStream.write(((i3 >> 12) & 63) | 128);
                            outputStream.write(((i3 >> 6) & 63) | 128);
                            c2 = i3;
                            c4 = ((c2 == 1 ? 1 : 0) & 63) | 128;
                        } else {
                            throw new IllegalStateException("invalid UTF-16 codepoint");
                        }
                    } else {
                        throw new IllegalStateException("invalid UTF-16 codepoint");
                    }
                }
                outputStream.write(i);
                c2 = c3;
                c4 = ((c2 == 1 ? 1 : 0) & 63) | 128;
            }
            outputStream.write(c4 == 1 ? 1 : 0);
            i2++;
        }
    }

    public static byte[] h(String str) {
        return i(str.toCharArray());
    }

    public static byte[] i(char[] cArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            g(cArr, byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        } catch (IOException unused) {
            throw new IllegalStateException("cannot encode string to byte array!");
        }
    }

    public static String j(String str) {
        char[] charArray = str.toCharArray();
        boolean z = false;
        for (int i = 0; i != charArray.length; i++) {
            char c2 = charArray[i];
            if ('a' <= c2 && 'z' >= c2) {
                charArray[i] = (char) ((c2 - 'a') + 65);
                z = true;
            }
        }
        return z ? new String(charArray) : str;
    }
}
