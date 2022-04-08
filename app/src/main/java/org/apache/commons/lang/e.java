package org.apache.commons.lang;

import java.util.ArrayList;
import org.apache.commons.lang.text.b;

/* compiled from: StringUtils.java */
/* loaded from: classes4.dex */
public class e {
    public static boolean a(String str) {
        return str == null || str.length() == 0;
    }

    public static String b(Object[] objArr, String str) {
        if (objArr == null) {
            return null;
        }
        return c(objArr, str, 0, objArr.length);
    }

    public static String c(Object[] objArr, String str, int i, int i2) {
        if (objArr == null) {
            return null;
        }
        if (str == null) {
            str = "";
        }
        int i3 = i2 - i;
        if (i3 <= 0) {
            return "";
        }
        b bVar = new b(i3 * ((objArr[i] == null ? 16 : objArr[i].toString().length()) + str.length()));
        for (int i4 = i; i4 < i2; i4++) {
            if (i4 > i) {
                bVar.f(str);
            }
            if (objArr[i4] != null) {
                bVar.e(objArr[i4]);
            }
        }
        return bVar.toString();
    }

    public static String[] d(String str, String str2) {
        return e(str, str2, -1, false);
    }

    private static String[] e(String str, String str2, int i, boolean z) {
        int i2;
        int i3;
        boolean z2;
        boolean z3;
        if (str == null) {
            return null;
        }
        int length = str.length();
        if (length == 0) {
            return a.f16629c;
        }
        ArrayList arrayList = new ArrayList();
        if (str2 == null) {
            i2 = 0;
            z3 = false;
            z2 = false;
            i3 = 0;
            int i4 = 1;
            while (i2 < length) {
                if (Character.isWhitespace(str.charAt(i2))) {
                    if (z3 || z) {
                        i4++;
                        if (i4 == i) {
                            i2 = length;
                            z2 = false;
                        } else {
                            z2 = true;
                        }
                        arrayList.add(str.substring(i3, i2));
                        z3 = false;
                    }
                    i3 = i2 + 1;
                    i2 = i3;
                } else {
                    i2++;
                    z3 = true;
                    z2 = false;
                }
            }
        } else if (str2.length() == 1) {
            char charAt = str2.charAt(0);
            i2 = 0;
            z3 = false;
            z2 = false;
            i3 = 0;
            int i5 = 1;
            while (i2 < length) {
                if (str.charAt(i2) == charAt) {
                    if (z3 || z) {
                        i5++;
                        if (i5 == i) {
                            i2 = length;
                            z2 = false;
                        } else {
                            z2 = true;
                        }
                        arrayList.add(str.substring(i3, i2));
                        z3 = false;
                    }
                    i3 = i2 + 1;
                    i2 = i3;
                } else {
                    i2++;
                    z3 = true;
                    z2 = false;
                }
            }
        } else {
            i2 = 0;
            z3 = false;
            z2 = false;
            i3 = 0;
            int i6 = 1;
            while (i2 < length) {
                if (str2.indexOf(str.charAt(i2)) >= 0) {
                    if (z3 || z) {
                        i6++;
                        if (i6 == i) {
                            i2 = length;
                            z2 = false;
                        } else {
                            z2 = true;
                        }
                        arrayList.add(str.substring(i3, i2));
                        z3 = false;
                    }
                    i3 = i2 + 1;
                    i2 = i3;
                } else {
                    i2++;
                    z3 = true;
                    z2 = false;
                }
            }
        }
        if (z3 || (z && z2)) {
            arrayList.add(str.substring(i3, i2));
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }
}
