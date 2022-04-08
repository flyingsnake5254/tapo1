package com.tplink.libmediakit.media.display.renderer;

import androidx.annotation.Nullable;
import com.tplink.libmediakit.jniinterface.DecoderProperty;
import java.nio.ByteBuffer;

/* loaded from: classes3.dex */
public class YUVBuffer {
    public static final int FRAME_FORMAT_I420 = 10;
    public static final int FRAME_FORMAT_NV12 = 11;
    @Nullable
    public ByteBuffer data;
    public int frameFormat;
    public int height;
    public int outputIndex;
    public long presentationTimeUs;
    public long timestamp;
    public int width;
    @Nullable
    public ByteBuffer[] yuvPlanes;
    @Nullable
    public int[] yuvStrides;

    public YUVBuffer() {
    }

    private boolean initForYuvFrame(int i, int i2, int i3, int i4, int i5, long j) {
        this.width = i;
        this.height = i2;
        this.frameFormat = i5;
        int i6 = (int) ((i2 + 1) / 2);
        if (!isNotSafeToMultiply(i3, i2) && !isNotSafeToMultiply(i4, i6)) {
            int i7 = i2 * i3;
            int i8 = i6 * i4;
            int i9 = (i8 * 2) + i7;
            if (i5 == 11) {
                i9 = i7 + i8;
            }
            if (!isNotSafeToMultiply(i8, 2) && i9 >= i7) {
                ByteBuffer byteBuffer = this.data;
                if (byteBuffer == null || byteBuffer.capacity() < i9) {
                    this.data = ByteBuffer.allocateDirect(i9);
                } else {
                    this.data.clear();
                }
                if (this.yuvPlanes == null) {
                    this.yuvPlanes = new ByteBuffer[3];
                }
                ByteBuffer byteBuffer2 = this.data;
                ByteBuffer[] byteBufferArr = this.yuvPlanes;
                byteBufferArr[0] = byteBuffer2.slice();
                byteBufferArr[0].limit(i7);
                byteBuffer2.position(i7);
                byteBufferArr[1] = byteBuffer2.slice();
                byteBufferArr[1].limit(i8);
                if (i5 != 11) {
                    byteBuffer2.position(i7 + i8);
                    byteBufferArr[2] = byteBuffer2.slice();
                    byteBufferArr[2].limit(i8);
                }
                if (this.yuvStrides == null) {
                    this.yuvStrides = new int[3];
                }
                int[] iArr = this.yuvStrides;
                iArr[0] = i3;
                iArr[1] = i4;
                if (i5 != 11) {
                    iArr[2] = i4;
                } else {
                    iArr[2] = 0;
                }
                this.presentationTimeUs = j;
                return true;
            }
        }
        return false;
    }

    private static boolean isNotSafeToMultiply(int i, int i2) {
        return i < 0 || i2 < 0 || (i2 > 0 && i >= Integer.MAX_VALUE / i2);
    }

    public boolean initParams(int i, int i2, int i3, int i4, int i5, int i6, int i7, long j, ByteBuffer byteBuffer) {
        int i8 = i == 19 ? 10 : 11;
        this.frameFormat = i8;
        this.width = i6;
        this.height = i7;
        int i9 = i8 == 10 ? i2 / 2 : i2;
        int i10 = (int) ((i7 + 1) / 2);
        if (!isNotSafeToMultiply(i2, i7) && !isNotSafeToMultiply(i9, i10)) {
            int i11 = this.height * i2;
            int i12 = i10 * i9;
            int i13 = i11 + i12;
            int i14 = this.frameFormat == 10 ? (i12 * 2) + i11 : i13;
            if (!isNotSafeToMultiply(i12, 2) && i14 >= i11) {
                ByteBuffer byteBuffer2 = this.data;
                if (byteBuffer2 == null || byteBuffer2.capacity() < i14) {
                    this.data = ByteBuffer.allocateDirect(i14);
                } else {
                    this.data.clear();
                }
                byteBuffer.position(i5 * i2);
                ByteBuffer slice = byteBuffer.slice();
                slice.limit(i11);
                this.data.put(slice);
                this.data.position(i11);
                int i15 = (i5 / 2) * i9;
                int i16 = (i2 * i4) + i15;
                byteBuffer.position(i16);
                ByteBuffer slice2 = byteBuffer.slice();
                slice2.limit(i12);
                this.data.put(slice2);
                this.data.position(i13);
                if (this.frameFormat == 10) {
                    byteBuffer.position(i15 + i16 + ((i9 * i4) / 2));
                    ByteBuffer slice3 = byteBuffer.slice();
                    slice3.limit(i12);
                    this.data.put(slice3);
                    this.data.position(i13 + i12);
                }
                this.data.flip();
                if (this.yuvPlanes == null) {
                    this.yuvPlanes = new ByteBuffer[3];
                }
                ByteBuffer byteBuffer3 = this.data;
                ByteBuffer[] byteBufferArr = this.yuvPlanes;
                byteBufferArr[0] = byteBuffer3.slice();
                byteBufferArr[0].limit(i11);
                byteBuffer3.position(i11);
                byteBufferArr[1] = byteBuffer3.slice();
                byteBufferArr[1].limit(i12);
                if (this.frameFormat != 11) {
                    byteBuffer3.position(i13);
                    byteBufferArr[2] = byteBuffer3.slice();
                    byteBufferArr[2].limit(i12);
                }
                if (this.yuvStrides == null) {
                    this.yuvStrides = new int[3];
                }
                int[] iArr = this.yuvStrides;
                iArr[0] = i2;
                iArr[1] = i9;
                if (this.frameFormat != 11) {
                    iArr[2] = i9;
                } else {
                    iArr[2] = 0;
                }
                this.presentationTimeUs = j;
                return true;
            }
        }
        return false;
    }

    public boolean initParamsInNative(int i, int i2, int i3, int i4, int i5, int i6, int i7, long j, ByteBuffer byteBuffer) {
        return DecoderProperty.b(i, i2, i3, i4, i5, i6, i7, j, byteBuffer, this) == 0;
    }

    public void release() {
        this.data = null;
        this.yuvPlanes = null;
    }

    public String toString() {
        return "YUVBuffer@" + Integer.toHexString(hashCode());
    }

    public YUVBuffer(int i) {
        this.outputIndex = i;
    }
}
