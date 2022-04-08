package com.tplink.libmediakit.jniinterface;

import androidx.annotation.NonNull;
import com.tplink.libmediakit.media.display.renderer.YUVBuffer;
import io.netty.handler.codec.memcache.binary.DefaultBinaryMemcacheRequest;
import java.nio.ByteBuffer;

/* loaded from: classes3.dex */
public class DecoderProperty {
    public static final byte[] a = {0, 0, 0, 1, 103, 77, 64, 40, -90, DefaultBinaryMemcacheRequest.REQUEST_MAGIC_BYTE, 120, 2, 39, -27, -101, 32, 0, 0, 3, 0, 32, 0, 0, 3, 3, -48, DefaultBinaryMemcacheRequest.REQUEST_MAGIC_BYTE};

    /* renamed from: b  reason: collision with root package name */
    public static final byte[] f11910b = {0, 0, 0, 0, 0, 0, 0, 0};

    /* loaded from: classes3.dex */
    public static class a {
        private int a;

        /* renamed from: b  reason: collision with root package name */
        private int f11911b;

        public int a() {
            return this.f11911b;
        }

        public int b() {
            return this.a;
        }

        public void c(int i) {
            this.f11911b = i;
        }

        public void d(int i) {
            this.a = i;
        }
    }

    static {
        System.loadLibrary("native-utils-lib");
    }

    public static int b(int i, int i2, int i3, int i4, int i5, int i6, int i7, long j, ByteBuffer byteBuffer, @NonNull YUVBuffer yUVBuffer) {
        return initYuvBufferNative(i, i2, i3, i4, i5, i6, i7, j, byteBuffer, yUVBuffer);
    }

    private static native int initYuvBufferNative(int i, int i2, int i3, int i4, int i5, int i6, int i7, long j, ByteBuffer byteBuffer, @NonNull YUVBuffer yUVBuffer);

    private native int[] parseH264Resolution(byte[] bArr, int i);

    public void a(byte[] bArr, a aVar) {
        int[] parseH264Resolution = parseH264Resolution(bArr, bArr.length);
        aVar.d(parseH264Resolution[0]);
        aVar.c(parseH264Resolution[1]);
    }
}
