package org.apache.commons.io;

import io.netty.handler.codec.http.websocketx.WebSocketServerHandshaker;
import java.io.File;
import java.util.ArrayList;
import java.util.Stack;

/* compiled from: FilenameUtils.java */
/* loaded from: classes4.dex */
public class b {
    public static final String a = Character.toString('.');

    /* renamed from: b  reason: collision with root package name */
    private static final char f16622b = File.separatorChar;

    /* renamed from: c  reason: collision with root package name */
    private static final char f16623c;

    static {
        if (d()) {
            f16623c = '/';
        } else {
            f16623c = '\\';
        }
    }

    public static String a(String str) {
        if (str == null) {
            return null;
        }
        int b2 = b(str);
        return b2 == -1 ? "" : str.substring(b2 + 1);
    }

    public static int b(String str) {
        int lastIndexOf;
        if (str != null && c(str) <= (lastIndexOf = str.lastIndexOf(46))) {
            return lastIndexOf;
        }
        return -1;
    }

    public static int c(String str) {
        if (str == null) {
            return -1;
        }
        return Math.max(str.lastIndexOf(47), str.lastIndexOf(92));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean d() {
        return f16622b == '\\';
    }

    static String[] e(String str) {
        if (str.indexOf(63) == -1 && str.indexOf(42) == -1) {
            return new String[]{str};
        }
        char[] charArray = str.toCharArray();
        ArrayList arrayList = new ArrayList();
        StringBuilder sb = new StringBuilder();
        int length = charArray.length;
        int i = 0;
        char c2 = 0;
        while (i < length) {
            char c3 = charArray[i];
            if (c3 == '?' || c3 == '*') {
                if (sb.length() != 0) {
                    arrayList.add(sb.toString());
                    sb.setLength(0);
                }
                if (c3 == '?') {
                    arrayList.add("?");
                } else if (c2 != '*') {
                    arrayList.add(WebSocketServerHandshaker.SUB_PROTOCOL_WILDCARD);
                }
            } else {
                sb.append(c3);
            }
            i++;
            c2 = c3;
        }
        if (sb.length() != 0) {
            arrayList.add(sb.toString());
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public static boolean f(String str, String str2) {
        return g(str, str2, IOCase.SENSITIVE);
    }

    public static boolean g(String str, String str2, IOCase iOCase) {
        if (str == null && str2 == null) {
            return true;
        }
        if (str == null || str2 == null) {
            return false;
        }
        if (iOCase == null) {
            iOCase = IOCase.SENSITIVE;
        }
        String[] e2 = e(str2);
        Stack stack = new Stack();
        boolean z = false;
        int i = 0;
        int i2 = 0;
        do {
            if (stack.size() > 0) {
                int[] iArr = (int[]) stack.pop();
                i2 = iArr[0];
                i = iArr[1];
                z = true;
            }
            while (i2 < e2.length) {
                if (e2[i2].equals("?")) {
                    i++;
                    if (i > str.length()) {
                        break;
                    }
                    z = false;
                    i2++;
                } else if (e2[i2].equals(WebSocketServerHandshaker.SUB_PROTOCOL_WILDCARD)) {
                    if (i2 == e2.length - 1) {
                        i = str.length();
                    }
                    z = true;
                    i2++;
                } else {
                    if (z) {
                        i = iOCase.checkIndexOf(str, i, e2[i2]);
                        if (i == -1) {
                            break;
                        }
                        int checkIndexOf = iOCase.checkIndexOf(str, i + 1, e2[i2]);
                        if (checkIndexOf >= 0) {
                            stack.push(new int[]{i2, checkIndexOf});
                        }
                        i += e2[i2].length();
                        z = false;
                    } else {
                        if (!iOCase.checkRegionMatches(str, i, e2[i2])) {
                            break;
                        }
                        i += e2[i2].length();
                        z = false;
                    }
                    i2++;
                }
            }
            if (i2 == e2.length && i == str.length()) {
                return true;
            }
        } while (stack.size() > 0);
        return false;
    }
}
