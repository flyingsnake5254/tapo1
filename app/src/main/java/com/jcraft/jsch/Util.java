package com.jcraft.jsch;

import androidx.exifinterface.media.ExifInterface;
import com.tplink.iot.Utils.hls.c;
import com.tplink.libtpmediastatistics.SSLClient;
import io.netty.handler.codec.http.HttpConstants;
import io.netty.handler.codec.memcache.binary.BinaryMemcacheOpcodes;
import io.netty.handler.codec.memcache.binary.DefaultBinaryMemcacheRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.util.Vector;

/* loaded from: classes2.dex */
class Util {
    private static final byte[] b64 = str2byte("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=");
    private static String[] chars = {"0", "1", ExifInterface.GPS_MEASUREMENT_2D, ExifInterface.GPS_MEASUREMENT_3D, "4", "5", "6", "7", "8", "9", "a", "b", c.n, "d", "e", "f"};
    static final byte[] empty = str2byte("");

    Util() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean array_equals(byte[] bArr, byte[] bArr2) {
        int length = bArr.length;
        if (length != bArr2.length) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            if (bArr[i] != bArr2[i]) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String byte2str(byte[] bArr, String str) {
        return byte2str(bArr, 0, bArr.length, str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void bzero(byte[] bArr) {
        if (bArr != null) {
            for (int i = 0; i < bArr.length; i++) {
                bArr[i] = 0;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String checkTilde(String str) {
        try {
            return str.startsWith("~") ? str.replace("~", System.getProperty("user.home")) : str;
        } catch (SecurityException unused) {
            return str;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Socket createSocket(final String str, final int i, int i2) throws JSchException {
        String str2;
        if (i2 == 0) {
            try {
                return new Socket(str, i);
            } catch (Exception e2) {
                throw new JSchException(e2.toString(), e2);
            }
        } else {
            final Socket[] socketArr = new Socket[1];
            final Exception[] excArr = new Exception[1];
            Thread thread = new Thread(new Runnable() { // from class: com.jcraft.jsch.Util.1
                @Override // java.lang.Runnable
                public void run() {
                    Socket[] socketArr2 = socketArr;
                    socketArr2[0] = null;
                    try {
                        socketArr2[0] = new Socket(str, i);
                    } catch (Exception e3) {
                        excArr[0] = e3;
                        Socket[] socketArr3 = socketArr;
                        if (socketArr3[0] != null && socketArr3[0].isConnected()) {
                            try {
                                socketArr[0].close();
                            } catch (Exception unused) {
                            }
                        }
                        socketArr[0] = null;
                    }
                }
            });
            thread.setName("Opening Socket " + str);
            thread.start();
            try {
                thread.join(i2);
                str2 = "timeout: ";
            } catch (InterruptedException unused) {
                str2 = "";
            }
            if (socketArr[0] != null && socketArr[0].isConnected()) {
                return socketArr[0];
            }
            String str3 = str2 + "socket is not established";
            if (excArr[0] != null) {
                str3 = excArr[0].toString();
            }
            thread.interrupt();
            throw new JSchException(str3, excArr[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String diffString(String str, String[] strArr) {
        String[] split = split(str, SSLClient.COMMA);
        String str2 = null;
        for (int i = 0; i < split.length; i++) {
            int i2 = 0;
            while (true) {
                if (i2 < strArr.length) {
                    if (split[i].equals(strArr[i2])) {
                        break;
                    }
                    i2++;
                } else if (str2 == null) {
                    str2 = split[i];
                } else {
                    str2 = str2 + SSLClient.COMMA + split[i];
                }
            }
        }
        return str2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] fromBase64(byte[] bArr, int i, int i2) throws JSchException {
        try {
            byte[] bArr2 = new byte[i2];
            int i3 = i;
            int i4 = 0;
            while (true) {
                if (i3 >= i + i2) {
                    break;
                }
                int i5 = i3 + 1;
                bArr2[i4] = (byte) ((val(bArr[i3]) << 2) | ((val(bArr[i5]) & 48) >>> 4));
                int i6 = i3 + 2;
                if (bArr[i6] == 61) {
                    i4++;
                    break;
                }
                bArr2[i4 + 1] = (byte) (((val(bArr[i5]) & BinaryMemcacheOpcodes.PREPEND) << 4) | ((val(bArr[i6]) & 60) >>> 2));
                int i7 = i3 + 3;
                if (bArr[i7] == 61) {
                    i4 += 2;
                    break;
                }
                bArr2[i4 + 2] = (byte) (((val(bArr[i6]) & 3) << 6) | (val(bArr[i7]) & 63));
                i4 += 3;
                i3 += 4;
            }
            byte[] bArr3 = new byte[i4];
            System.arraycopy(bArr2, 0, bArr3, 0, i4);
            return bArr3;
        } catch (ArrayIndexOutOfBoundsException e2) {
            throw new JSchException("fromBase64: invalid base64 data", e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] fromFile(String str) throws IOException {
        String checkTilde = checkTilde(str);
        File file = new File(checkTilde);
        FileInputStream fileInputStream = new FileInputStream(checkTilde);
        try {
            int length = (int) file.length();
            byte[] bArr = new byte[length];
            int i = 0;
            while (true) {
                int read = fileInputStream.read(bArr, i, length - i);
                if (read <= 0) {
                    fileInputStream.close();
                    return bArr;
                }
                i += read;
            }
        } finally {
            fileInputStream.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String getFingerPrint(HASH hash, byte[] bArr) {
        try {
            hash.init();
            int i = 0;
            hash.update(bArr, 0, bArr.length);
            byte[] digest = hash.digest();
            StringBuffer stringBuffer = new StringBuffer();
            while (i < digest.length) {
                int i2 = digest[i] & 255;
                stringBuffer.append(chars[(i2 >>> 4) & 15]);
                stringBuffer.append(chars[i2 & 15]);
                i++;
                if (i < digest.length) {
                    stringBuffer.append(SSLClient.COLON);
                }
            }
            return stringBuffer.toString();
        } catch (Exception unused) {
            return "???";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean glob(byte[] bArr, byte[] bArr2) {
        return glob0(bArr, 0, bArr2, 0);
    }

    private static boolean glob0(byte[] bArr, int i, byte[] bArr2, int i2) {
        if (bArr2.length <= 0 || bArr2[0] != 46) {
            return glob(bArr, i, bArr2, i2);
        }
        if (bArr.length <= 0 || bArr[0] != 46) {
            return false;
        }
        if (bArr.length == 2 && bArr[1] == 42) {
            return true;
        }
        return glob(bArr, i + 1, bArr2, i2 + 1);
    }

    static String quote(String str) {
        byte[] str2byte = str2byte(str);
        int i = 0;
        for (byte b2 : str2byte) {
            if (b2 == 92 || b2 == 63 || b2 == 42) {
                i++;
            }
        }
        if (i == 0) {
            return str;
        }
        byte[] bArr = new byte[str2byte.length + i];
        int i2 = 0;
        for (byte b3 : str2byte) {
            if (b3 == 92 || b3 == 63 || b3 == 42) {
                i2++;
                bArr[i2] = 92;
            }
            i2++;
            bArr[i2] = b3;
        }
        return byte2str(bArr);
    }

    private static int skipUTF8Char(byte b2) {
        if (((byte) (b2 & DefaultBinaryMemcacheRequest.REQUEST_MAGIC_BYTE)) == 0) {
            return 1;
        }
        if (((byte) (b2 & 224)) == -64) {
            return 2;
        }
        return ((byte) (b2 & 240)) == -32 ? 3 : 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String[] split(String str, String str2) {
        if (str == null) {
            return null;
        }
        byte[] str2byte = str2byte(str);
        Vector vector = new Vector();
        int i = 0;
        while (true) {
            int indexOf = str.indexOf(str2, i);
            if (indexOf < 0) {
                break;
            }
            vector.addElement(byte2str(str2byte, i, indexOf - i));
            i = indexOf + 1;
        }
        vector.addElement(byte2str(str2byte, i, str2byte.length - i));
        int size = vector.size();
        String[] strArr = new String[size];
        for (int i2 = 0; i2 < size; i2++) {
            strArr[i2] = (String) vector.elementAt(i2);
        }
        return strArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] str2byte(String str, String str2) {
        if (str == null) {
            return null;
        }
        try {
            return str.getBytes(str2);
        } catch (UnsupportedEncodingException unused) {
            return str.getBytes();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] toBase64(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[i2 * 2];
        int i3 = ((i2 / 3) * 3) + i;
        int i4 = i;
        int i5 = 0;
        while (i4 < i3) {
            int i6 = i5 + 1;
            byte[] bArr3 = b64;
            bArr2[i5] = bArr3[(bArr[i4] >>> 2) & 63];
            int i7 = i4 + 1;
            int i8 = i6 + 1;
            bArr2[i6] = bArr3[((bArr[i4] & 3) << 4) | ((bArr[i7] >>> 4) & 15)];
            int i9 = i4 + 2;
            int i10 = ((bArr[i7] & BinaryMemcacheOpcodes.PREPEND) << 2) | ((bArr[i9] >>> 6) & 3);
            int i11 = i8 + 1;
            bArr2[i8] = bArr3[i10];
            i5 = i11 + 1;
            bArr2[i11] = bArr3[bArr[i9] & 63];
            i4 += 3;
        }
        int i12 = (i + i2) - i3;
        if (i12 == 1) {
            int i13 = i5 + 1;
            byte[] bArr4 = b64;
            bArr2[i5] = bArr4[(bArr[i4] >>> 2) & 63];
            int i14 = i13 + 1;
            bArr2[i13] = bArr4[((bArr[i4] & 3) << 4) & 63];
            int i15 = i14 + 1;
            bArr2[i14] = HttpConstants.EQUALS;
            i5 = i15 + 1;
            bArr2[i15] = HttpConstants.EQUALS;
        } else if (i12 == 2) {
            int i16 = i5 + 1;
            byte[] bArr5 = b64;
            bArr2[i5] = bArr5[(bArr[i4] >>> 2) & 63];
            int i17 = i4 + 1;
            int i18 = i16 + 1;
            bArr2[i16] = bArr5[((bArr[i4] & 3) << 4) | ((bArr[i17] >>> 4) & 15)];
            int i19 = i18 + 1;
            bArr2[i18] = bArr5[((bArr[i17] & BinaryMemcacheOpcodes.PREPEND) << 2) & 63];
            i5 = i19 + 1;
            bArr2[i19] = HttpConstants.EQUALS;
        }
        byte[] bArr6 = new byte[i5];
        System.arraycopy(bArr2, 0, bArr6, 0, i5);
        return bArr6;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String toHex(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        int i = 0;
        while (i < bArr.length) {
            String hexString = Integer.toHexString(bArr[i] & 255);
            StringBuilder sb = new StringBuilder();
            sb.append("0x");
            sb.append(hexString.length() == 1 ? "0" : "");
            sb.append(hexString);
            stringBuffer.append(sb.toString());
            i++;
            if (i < bArr.length) {
                stringBuffer.append(SSLClient.COLON);
            }
        }
        return stringBuffer.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String unquote(String str) {
        byte[] str2byte = str2byte(str);
        byte[] unquote = unquote(str2byte);
        return str2byte.length == unquote.length ? str : byte2str(unquote);
    }

    private static byte val(byte b2) {
        if (b2 == 61) {
            return (byte) 0;
        }
        int i = 0;
        while (true) {
            byte[] bArr = b64;
            if (i >= bArr.length) {
                return (byte) 0;
            }
            if (b2 == bArr[i]) {
                return (byte) i;
            }
            i++;
        }
    }

    static String byte2str(byte[] bArr, int i, int i2, String str) {
        try {
            return new String(bArr, i, i2, str);
        } catch (UnsupportedEncodingException unused) {
            return new String(bArr, i, i2);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0034, code lost:
        if (r9 >= r0) goto L_0x003d;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0038, code lost:
        if (r8[r9] != 42) goto L_0x003d;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x003a, code lost:
        r9 = r9 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x003d, code lost:
        if (r0 != r9) goto L_0x0040;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x003f, code lost:
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0040, code lost:
        r3 = r8[r9];
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0042, code lost:
        if (r3 != 63) goto L_0x0056;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0044, code lost:
        if (r11 >= r2) goto L_0x0055;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x004a, code lost:
        if (glob(r8, r9, r10, r11) == false) goto L_0x004d;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x004c, code lost:
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x004d, code lost:
        r11 = r11 + skipUTF8Char(r10[r11]);
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0055, code lost:
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0056, code lost:
        if (r3 != 92) goto L_0x0080;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0058, code lost:
        r9 = r9 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0059, code lost:
        if (r9 != r0) goto L_0x005c;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x005b, code lost:
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x005c, code lost:
        r0 = r8[r9];
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x005e, code lost:
        if (r11 >= r2) goto L_0x007f;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0062, code lost:
        if (r0 != r10[r11]) goto L_0x0077;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0074, code lost:
        if (glob(r8, skipUTF8Char(r0) + r9, r10, skipUTF8Char(r10[r11]) + r11) == false) goto L_0x0077;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0076, code lost:
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0077, code lost:
        r11 = r11 + skipUTF8Char(r10[r11]);
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x007f, code lost:
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0080, code lost:
        if (r11 >= r2) goto L_0x0095;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0084, code lost:
        if (r3 != r10[r11]) goto L_0x008d;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x008a, code lost:
        if (glob(r8, r9, r10, r11) == false) goto L_0x008d;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x008c, code lost:
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x008d, code lost:
        r11 = r11 + skipUTF8Char(r10[r11]);
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0095, code lost:
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean glob(byte[] r8, int r9, byte[] r10, int r11) {
        /*
            Method dump skipped, instructions count: 219
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jcraft.jsch.Util.glob(byte[], int, byte[], int):boolean");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] str2byte(String str) {
        return str2byte(str, "UTF-8");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String byte2str(byte[] bArr) {
        return byte2str(bArr, 0, bArr.length, "UTF-8");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String byte2str(byte[] bArr, int i, int i2) {
        return byte2str(bArr, i, i2, "UTF-8");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] unquote(byte[] bArr) {
        int length = bArr.length;
        int i = 0;
        while (i < length) {
            if (bArr[i] == 92) {
                int i2 = i + 1;
                if (i2 == length) {
                    break;
                }
                System.arraycopy(bArr, i2, bArr, i, bArr.length - i2);
                length--;
                i = i2;
            } else {
                i++;
            }
        }
        if (length == bArr.length) {
            return bArr;
        }
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, length);
        return bArr2;
    }
}
