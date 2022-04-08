package b.d.w.h;

import android.util.Base64;
import io.netty.handler.codec.memcache.binary.BinaryMemcacheOpcodes;
import java.io.ByteArrayOutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

/* compiled from: CodecUtils.java */
/* loaded from: classes3.dex */
public class a {
    public static String a(String str) {
        return b.d(str) ? "" : new String(Base64.decode(str, 2));
    }

    public static String b(String str) {
        return b.d(str) ? "" : Base64.encodeToString(str.getBytes(), 2);
    }

    public static String c(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return Base64.encodeToString(bArr, 2);
    }

    public static byte[] d(byte[] bArr) {
        Deflater deflater = new Deflater();
        deflater.reset();
        deflater.setInput(bArr);
        deflater.finish();
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(bArr.length);
            byte[] bArr2 = new byte[1024];
            while (!deflater.finished()) {
                byteArrayOutputStream.write(bArr2, 0, deflater.deflate(bArr2));
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            bArr = byteArray;
        } catch (Exception unused) {
        }
        deflater.end();
        return bArr;
    }

    public static byte[] e(byte[] bArr) {
        Inflater inflater = new Inflater();
        inflater.reset();
        inflater.setInput(bArr);
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(bArr.length);
            byte[] bArr2 = new byte[1024];
            while (!inflater.finished()) {
                byteArrayOutputStream.write(bArr2, 0, inflater.inflate(bArr2));
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            bArr = byteArray;
        } catch (Exception unused) {
        }
        inflater.end();
        return bArr;
    }

    public static byte[] f(byte[] bArr) throws NoSuchAlgorithmException {
        MessageDigest instance = MessageDigest.getInstance("md5");
        instance.update(bArr);
        return instance.digest();
    }

    public static String g(String str) {
        try {
            return k(f(str.getBytes()));
        } catch (NoSuchAlgorithmException e2) {
            b.d.w.c.a.d(e2.toString());
            return str;
        }
    }

    public static String h(String str) {
        return i(str.getBytes());
    }

    public static String i(byte[] bArr) {
        try {
            return k(MessageDigest.getInstance("SHA1").digest(bArr));
        } catch (NoSuchAlgorithmException e2) {
            b.d.w.c.a.d(e2.toString());
            return "";
        }
    }

    public static byte[] j(String str) {
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            bArr[i] = Integer.valueOf(str.substring(i2, i2 + 2), 16).byteValue();
        }
        return bArr;
    }

    public static String k(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (byte b2 : bArr) {
            String hexString = Integer.toHexString(b2 & 255);
            if (hexString.length() == 1) {
                sb.append("0");
                sb.append(hexString);
            } else {
                sb.append(hexString);
            }
        }
        return sb.toString();
    }

    public static String l(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (byte b2 : bArr) {
            sb.append("0123456789ABCDEF".charAt((b2 >> 4) & 15));
            sb.append("0123456789ABCDEF".charAt(b2 & BinaryMemcacheOpcodes.PREPEND));
        }
        return sb.toString();
    }
}
