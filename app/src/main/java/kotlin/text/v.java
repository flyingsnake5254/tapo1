package kotlin.text;

import java.util.Collection;
import java.util.Iterator;
import kotlin.collections.z;
import kotlin.jvm.internal.j;
import kotlin.v.d;
import kotlin.v.g;

/* compiled from: StringsJVM.kt */
/* loaded from: classes4.dex */
public class v extends u {
    public static /* synthetic */ boolean A(String str, String str2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return y(str, str2, z);
    }

    public static final boolean o(String endsWith, String suffix, boolean z) {
        j.e(endsWith, "$this$endsWith");
        j.e(suffix, "suffix");
        if (!z) {
            return endsWith.endsWith(suffix);
        }
        return s(endsWith, endsWith.length() - suffix.length(), suffix, 0, suffix.length(), true);
    }

    public static /* synthetic */ boolean p(String str, String str2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return o(str, str2, z);
    }

    public static boolean q(String str, String str2, boolean z) {
        if (str == null) {
            return str2 == null;
        }
        if (!z) {
            return str.equals(str2);
        }
        return str.equalsIgnoreCase(str2);
    }

    public static boolean r(CharSequence isBlank) {
        boolean z;
        j.e(isBlank, "$this$isBlank");
        if (isBlank.length() != 0) {
            d F = w.F(isBlank);
            if (!(F instanceof Collection) || !((Collection) F).isEmpty()) {
                Iterator<Integer> it = F.iterator();
                while (it.hasNext()) {
                    if (!b.c(isBlank.charAt(((z) it).nextInt()))) {
                        z = false;
                        break;
                    }
                }
            }
            z = true;
            if (!z) {
                return false;
            }
        }
        return true;
    }

    public static final boolean s(String regionMatches, int i, String other, int i2, int i3, boolean z) {
        j.e(regionMatches, "$this$regionMatches");
        j.e(other, "other");
        if (!z) {
            return regionMatches.regionMatches(i, other, i2, i3);
        }
        return regionMatches.regionMatches(z, i, other, i2, i3);
    }

    public static final String t(String replace, char c2, char c3, boolean z) {
        j.e(replace, "$this$replace");
        if (!z) {
            String replace2 = replace.replace(c2, c3);
            j.d(replace2, "(this as java.lang.Strin…replace(oldChar, newChar)");
            return replace2;
        }
        StringBuilder sb = new StringBuilder(replace.length());
        for (int i = 0; i < replace.length(); i++) {
            char charAt = replace.charAt(i);
            if (c.d(charAt, c2, z)) {
                charAt = c3;
            }
            sb.append(charAt);
        }
        String sb2 = sb.toString();
        j.d(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    public static final String u(String replace, String oldValue, String newValue, boolean z) {
        int b2;
        j.e(replace, "$this$replace");
        j.e(oldValue, "oldValue");
        j.e(newValue, "newValue");
        int i = 0;
        int I = w.I(replace, oldValue, 0, z);
        if (I < 0) {
            return replace;
        }
        int length = oldValue.length();
        b2 = g.b(length, 1);
        int length2 = (replace.length() - length) + newValue.length();
        if (length2 >= 0) {
            StringBuilder sb = new StringBuilder(length2);
            do {
                sb.append((CharSequence) replace, i, I);
                sb.append(newValue);
                i = I + length;
                if (I >= replace.length()) {
                    break;
                }
                I = w.I(replace, oldValue, I + b2, z);
            } while (I > 0);
            sb.append((CharSequence) replace, i, replace.length());
            String sb2 = sb.toString();
            j.d(sb2, "stringBuilder.append(this, i, length).toString()");
            return sb2;
        }
        throw new OutOfMemoryError();
    }

    public static /* synthetic */ String v(String str, char c2, char c3, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        return t(str, c2, c3, z);
    }

    public static /* synthetic */ String w(String str, String str2, String str3, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        return u(str, str2, str3, z);
    }

    public static final boolean x(String startsWith, String prefix, int i, boolean z) {
        j.e(startsWith, "$this$startsWith");
        j.e(prefix, "prefix");
        if (!z) {
            return startsWith.startsWith(prefix, i);
        }
        return s(startsWith, i, prefix, 0, prefix.length(), z);
    }

    public static final boolean y(String startsWith, String prefix, boolean z) {
        j.e(startsWith, "$this$startsWith");
        j.e(prefix, "prefix");
        if (!z) {
            return startsWith.startsWith(prefix);
        }
        return s(startsWith, 0, prefix, 0, prefix.length(), z);
    }

    public static /* synthetic */ boolean z(String str, String str2, int i, boolean z, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z = false;
        }
        return x(str, str2, i, z);
    }
}
