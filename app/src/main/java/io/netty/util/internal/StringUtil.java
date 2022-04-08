package io.netty.util.internal;

import io.netty.handler.codec.memcache.binary.BinaryMemcacheOpcodes;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public final class StringUtil {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final char CARRIAGE_RETURN = '\r';
    public static final char COMMA = ',';
    private static final int CSV_NUMBER_ESCAPE_CHARACTERS = 7;
    public static final char DOUBLE_QUOTE = '\"';
    public static final String EMPTY_STRING = "";
    private static final byte[] HEX2B;
    public static final char LINE_FEED = '\n';
    private static final char PACKAGE_SEPARATOR_CHAR = '.';
    public static final char SPACE = ' ';
    public static final char TAB = '\t';
    public static final String NEWLINE = SystemPropertyUtil.get("line.separator", "\n");
    private static final String[] BYTE2HEX_PAD = new String[256];
    private static final String[] BYTE2HEX_NOPAD = new String[256];

    static {
        String str;
        int i = 0;
        while (true) {
            String[] strArr = BYTE2HEX_PAD;
            if (i < strArr.length) {
                String hexString = Integer.toHexString(i);
                if (i > 15) {
                    str = hexString;
                } else {
                    str = '0' + hexString;
                }
                strArr[i] = str;
                BYTE2HEX_NOPAD[i] = hexString;
                i++;
            } else {
                byte[] bArr = new byte[65536];
                HEX2B = bArr;
                Arrays.fill(bArr, (byte) -1);
                bArr[48] = 0;
                bArr[49] = 1;
                bArr[50] = 2;
                bArr[51] = 3;
                bArr[52] = 4;
                bArr[53] = 5;
                bArr[54] = 6;
                bArr[55] = 7;
                bArr[56] = 8;
                bArr[57] = 9;
                bArr[65] = 10;
                bArr[66] = 11;
                bArr[67] = 12;
                bArr[68] = 13;
                bArr[69] = 14;
                bArr[70] = BinaryMemcacheOpcodes.PREPEND;
                bArr[97] = 10;
                bArr[98] = 11;
                bArr[99] = 12;
                bArr[100] = 13;
                bArr[101] = 14;
                bArr[102] = BinaryMemcacheOpcodes.PREPEND;
                return;
            }
        }
    }

    private StringUtil() {
    }

    public static String byteToHexString(int i) {
        return BYTE2HEX_NOPAD[i & 255];
    }

    public static String byteToHexStringPadded(int i) {
        return BYTE2HEX_PAD[i & 255];
    }

    public static boolean commonSuffixOfLength(String str, String str2, int i) {
        return str != null && str2 != null && i >= 0 && str.regionMatches(str.length() - i, str2, str2.length() - i, i);
    }

    public static byte decodeHexByte(CharSequence charSequence, int i) {
        int decodeHexNibble = decodeHexNibble(charSequence.charAt(i));
        int decodeHexNibble2 = decodeHexNibble(charSequence.charAt(i + 1));
        if (decodeHexNibble != -1 && decodeHexNibble2 != -1) {
            return (byte) ((decodeHexNibble << 4) + decodeHexNibble2);
        }
        throw new IllegalArgumentException(String.format("invalid hex byte '%s' at index %d of '%s'", charSequence.subSequence(i, i + 2), Integer.valueOf(i), charSequence));
    }

    public static byte[] decodeHexDump(CharSequence charSequence, int i, int i2) {
        if (i2 < 0 || (i2 & 1) != 0) {
            throw new IllegalArgumentException("length: " + i2);
        } else if (i2 == 0) {
            return EmptyArrays.EMPTY_BYTES;
        } else {
            byte[] bArr = new byte[i2 >>> 1];
            for (int i3 = 0; i3 < i2; i3 += 2) {
                bArr[i3 >>> 1] = decodeHexByte(charSequence, i + i3);
            }
            return bArr;
        }
    }

    public static int decodeHexNibble(char c2) {
        return HEX2B[c2];
    }

    public static boolean endsWith(CharSequence charSequence, char c2) {
        int length = charSequence.length();
        return length > 0 && charSequence.charAt(length - 1) == c2;
    }

    public static CharSequence escapeCsv(CharSequence charSequence) {
        return escapeCsv(charSequence, false);
    }

    private static int indexOfFirstNonOwsChar(CharSequence charSequence, int i) {
        int i2 = 0;
        while (i2 < i && isOws(charSequence.charAt(i2))) {
            i2++;
        }
        return i2;
    }

    private static int indexOfLastNonOwsChar(CharSequence charSequence, int i, int i2) {
        int i3 = i2 - 1;
        while (i3 > i && isOws(charSequence.charAt(i3))) {
            i3--;
        }
        return i3;
    }

    public static int indexOfNonWhiteSpace(CharSequence charSequence, int i) {
        while (i < charSequence.length()) {
            if (!Character.isWhitespace(charSequence.charAt(i))) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static int indexOfWhiteSpace(CharSequence charSequence, int i) {
        while (i < charSequence.length()) {
            if (Character.isWhitespace(charSequence.charAt(i))) {
                return i;
            }
            i++;
        }
        return -1;
    }

    private static boolean isDoubleQuote(char c2) {
        return c2 == '\"';
    }

    public static boolean isNullOrEmpty(String str) {
        return str == null || str.isEmpty();
    }

    private static boolean isOws(char c2) {
        return c2 == ' ' || c2 == '\t';
    }

    public static boolean isSurrogate(char c2) {
        return c2 >= 55296 && c2 <= 57343;
    }

    public static CharSequence join(CharSequence charSequence, Iterable<? extends CharSequence> iterable) {
        ObjectUtil.checkNotNull(charSequence, "separator");
        ObjectUtil.checkNotNull(iterable, "elements");
        Iterator<? extends CharSequence> it = iterable.iterator();
        if (!it.hasNext()) {
            return "";
        }
        CharSequence charSequence2 = (CharSequence) it.next();
        if (!it.hasNext()) {
            return charSequence2;
        }
        StringBuilder sb = new StringBuilder(charSequence2);
        do {
            sb.append(charSequence);
            sb.append((CharSequence) it.next());
        } while (it.hasNext());
        return sb;
    }

    public static int length(String str) {
        if (str == null) {
            return 0;
        }
        return str.length();
    }

    private static IllegalArgumentException newInvalidEscapedCsvFieldException(CharSequence charSequence, int i) {
        return new IllegalArgumentException("invalid escaped CSV field: " + ((Object) charSequence) + " index: " + i);
    }

    public static String simpleClassName(Object obj) {
        return obj == null ? "null_object" : simpleClassName(obj.getClass());
    }

    public static String substringAfter(String str, char c2) {
        int indexOf = str.indexOf(c2);
        if (indexOf >= 0) {
            return str.substring(indexOf + 1);
        }
        return null;
    }

    public static String toHexString(byte[] bArr) {
        return toHexString(bArr, 0, bArr.length);
    }

    public static String toHexStringPadded(byte[] bArr) {
        return toHexStringPadded(bArr, 0, bArr.length);
    }

    public static CharSequence trimOws(CharSequence charSequence) {
        int length = charSequence.length();
        if (length == 0) {
            return charSequence;
        }
        int indexOfFirstNonOwsChar = indexOfFirstNonOwsChar(charSequence, length);
        int indexOfLastNonOwsChar = indexOfLastNonOwsChar(charSequence, indexOfFirstNonOwsChar, length);
        return (indexOfFirstNonOwsChar == 0 && indexOfLastNonOwsChar == length + (-1)) ? charSequence : charSequence.subSequence(indexOfFirstNonOwsChar, indexOfLastNonOwsChar + 1);
    }

    public static CharSequence unescapeCsv(CharSequence charSequence) {
        int length = ((CharSequence) ObjectUtil.checkNotNull(charSequence, "value")).length();
        if (length == 0) {
            return charSequence;
        }
        int i = length - 1;
        boolean z = false;
        if (isDoubleQuote(charSequence.charAt(0)) && isDoubleQuote(charSequence.charAt(i)) && length != 1) {
            z = true;
        }
        if (!z) {
            validateCsvFormat(charSequence);
            return charSequence;
        }
        StringBuilder stringBuilder = InternalThreadLocalMap.get().stringBuilder();
        int i2 = 1;
        while (i2 < i) {
            char charAt = charSequence.charAt(i2);
            if (charAt == '\"') {
                int i3 = i2 + 1;
                if (!isDoubleQuote(charSequence.charAt(i3)) || i3 == i) {
                    throw newInvalidEscapedCsvFieldException(charSequence, i2);
                }
                i2 = i3;
            }
            stringBuilder.append(charAt);
            i2++;
        }
        return stringBuilder.toString();
    }

    public static List<CharSequence> unescapeCsvFields(CharSequence charSequence) {
        ArrayList arrayList = new ArrayList(2);
        StringBuilder stringBuilder = InternalThreadLocalMap.get().stringBuilder();
        int length = charSequence.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            char charAt = charSequence.charAt(i);
            if (!z) {
                if (!(charAt == '\n' || charAt == '\r')) {
                    if (charAt != '\"') {
                        if (charAt != ',') {
                            stringBuilder.append(charAt);
                        } else {
                            arrayList.add(stringBuilder.toString());
                            stringBuilder.setLength(0);
                        }
                    } else if (stringBuilder.length() == 0) {
                        z = true;
                    }
                }
                throw newInvalidEscapedCsvFieldException(charSequence, i);
            } else if (charAt != '\"') {
                stringBuilder.append(charAt);
            } else if (i == length) {
                arrayList.add(stringBuilder.toString());
                return arrayList;
            } else {
                i++;
                char charAt2 = charSequence.charAt(i);
                if (charAt2 == '\"') {
                    stringBuilder.append(DOUBLE_QUOTE);
                } else if (charAt2 == ',') {
                    arrayList.add(stringBuilder.toString());
                    stringBuilder.setLength(0);
                    z = false;
                } else {
                    throw newInvalidEscapedCsvFieldException(charSequence, i - 1);
                }
            }
            i++;
        }
        if (!z) {
            arrayList.add(stringBuilder.toString());
            return arrayList;
        }
        throw newInvalidEscapedCsvFieldException(charSequence, length);
    }

    private static void validateCsvFormat(CharSequence charSequence) {
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            char charAt = charSequence.charAt(i);
            if (charAt == '\n' || charAt == '\r' || charAt == '\"' || charAt == ',') {
                throw newInvalidEscapedCsvFieldException(charSequence, i);
            }
        }
    }

    public static <T extends Appendable> T byteToHexString(T t, int i) {
        try {
            t.append(byteToHexString(i));
        } catch (IOException e2) {
            PlatformDependent.throwException(e2);
        }
        return t;
    }

    public static <T extends Appendable> T byteToHexStringPadded(T t, int i) {
        try {
            t.append(byteToHexStringPadded(i));
        } catch (IOException e2) {
            PlatformDependent.throwException(e2);
        }
        return t;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00bb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.CharSequence escapeCsv(java.lang.CharSequence r7, boolean r8) {
        /*
            Method dump skipped, instructions count: 224
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.util.internal.StringUtil.escapeCsv(java.lang.CharSequence, boolean):java.lang.CharSequence");
    }

    public static String simpleClassName(Class<?> cls) {
        String name = ((Class) ObjectUtil.checkNotNull(cls, "clazz")).getName();
        int lastIndexOf = name.lastIndexOf(46);
        return lastIndexOf > -1 ? name.substring(lastIndexOf + 1) : name;
    }

    public static String toHexString(byte[] bArr, int i, int i2) {
        return ((StringBuilder) toHexString(new StringBuilder(i2 << 1), bArr, i, i2)).toString();
    }

    public static String toHexStringPadded(byte[] bArr, int i, int i2) {
        return ((StringBuilder) toHexStringPadded(new StringBuilder(i2 << 1), bArr, i, i2)).toString();
    }

    public static <T extends Appendable> T toHexString(T t, byte[] bArr) {
        return (T) toHexString(t, bArr, 0, bArr.length);
    }

    public static <T extends Appendable> T toHexStringPadded(T t, byte[] bArr) {
        return (T) toHexStringPadded(t, bArr, 0, bArr.length);
    }

    public static <T extends Appendable> T toHexString(T t, byte[] bArr, int i, int i2) {
        if (i2 == 0) {
            return t;
        }
        int i3 = i2 + i;
        int i4 = i3 - 1;
        while (i < i4 && bArr[i] == 0) {
            i++;
        }
        int i5 = i + 1;
        byteToHexString(t, bArr[i]);
        toHexStringPadded(t, bArr, i5, i3 - i5);
        return t;
    }

    public static <T extends Appendable> T toHexStringPadded(T t, byte[] bArr, int i, int i2) {
        int i3 = i2 + i;
        while (i < i3) {
            byteToHexStringPadded(t, bArr[i]);
            i++;
        }
        return t;
    }

    public static byte[] decodeHexDump(CharSequence charSequence) {
        return decodeHexDump(charSequence, 0, charSequence.length());
    }
}
