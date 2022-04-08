package com.google.android.exoplayer2.audio;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;

/* compiled from: OpusUtil.java */
/* loaded from: classes.dex */
public class f0 {
    public static List<byte[]> a(byte[] bArr) {
        long e2 = e(d(bArr));
        long e3 = e(3840L);
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(bArr);
        arrayList.add(b(e2));
        arrayList.add(b(e3));
        return arrayList;
    }

    private static byte[] b(long j) {
        return ByteBuffer.allocate(8).order(ByteOrder.nativeOrder()).putLong(j).array();
    }

    public static int c(byte[] bArr) {
        return bArr[9] & 255;
    }

    private static int d(byte[] bArr) {
        return (bArr[10] & 255) | ((bArr[11] & 255) << 8);
    }

    private static long e(long j) {
        return (j * 1000000000) / 48000;
    }
}
