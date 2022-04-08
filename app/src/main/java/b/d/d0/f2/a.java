package b.d.d0.f2;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* compiled from: FormatTransfer.java */
/* loaded from: classes3.dex */
public class a {
    public static byte[] a(int i) {
        return ByteBuffer.allocate(4).putInt(i).order(ByteOrder.BIG_ENDIAN).array();
    }

    public static byte[] b(short s) {
        return ByteBuffer.allocate(2).putShort(s).order(ByteOrder.BIG_ENDIAN).array();
    }

    public static int c(byte[] bArr, int i) {
        return ByteBuffer.wrap(bArr, i, 4).order(ByteOrder.BIG_ENDIAN).getInt();
    }

    public static short d(byte[] bArr, int i) {
        return ByteBuffer.wrap(bArr, i, 2).order(ByteOrder.BIG_ENDIAN).getShort();
    }
}
