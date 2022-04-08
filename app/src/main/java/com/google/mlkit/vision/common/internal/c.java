package com.google.mlkit.vision.common.internal;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.YuvImage;
import android.media.Image;
import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import b.b.a.a.a.a;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.mlkit.common.MlKitException;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

/* compiled from: com.google.mlkit:vision-common@@16.0.0 */
@KeepForSdk
/* loaded from: classes2.dex */
public class c {
    private static final c a = new c();

    private c() {
    }

    @KeepForSdk
    public static c d() {
        return a;
    }

    private static Bitmap e(Bitmap bitmap, int i, int i2, int i3) {
        if (i == 0) {
            return Bitmap.createBitmap(bitmap, 0, 0, i2, i3);
        }
        Matrix matrix = new Matrix();
        matrix.postRotate(i);
        return Bitmap.createBitmap(bitmap, 0, 0, i2, i3, matrix, true);
    }

    private final Bitmap f(ByteBuffer byteBuffer, int i, int i2, int i3) {
        byte[] j = j(a(byteBuffer), i, i2);
        return e(BitmapFactory.decodeByteArray(j, 0, j.length), i3, i, i2);
    }

    @VisibleForTesting
    private static ByteBuffer g(ByteBuffer byteBuffer, boolean z) {
        ByteBuffer byteBuffer2;
        int i;
        byteBuffer.rewind();
        int limit = byteBuffer.limit();
        int i2 = limit / 6;
        if (z) {
            byteBuffer2 = ByteBuffer.allocate(limit);
        } else {
            byteBuffer2 = ByteBuffer.allocateDirect(limit);
        }
        int i3 = 0;
        while (true) {
            i = i2 << 2;
            if (i3 < i) {
                byteBuffer2.put(i3, byteBuffer.get(i3));
                i3++;
            }
        }
        for (int i4 = 0; i4 < (i2 << 1); i4++) {
            byteBuffer2.put(i + i4, byteBuffer.get(((i4 % 2) * i2) + i + (i4 / 2)));
        }
        return byteBuffer2;
    }

    @VisibleForTesting
    @RequiresApi(19)
    private static ByteBuffer h(Image.Plane[] planeArr, int i, int i2) {
        int i3 = i * i2;
        byte[] bArr = new byte[((i3 / 4) * 2) + i3];
        ByteBuffer buffer = planeArr[1].getBuffer();
        ByteBuffer buffer2 = planeArr[2].getBuffer();
        int position = buffer2.position();
        int limit = buffer.limit();
        buffer2.position(position + 1);
        buffer.limit(limit - 1);
        int i4 = (i3 * 2) / 4;
        boolean z = buffer2.remaining() == i4 + (-2) && buffer2.compareTo(buffer) == 0;
        buffer2.position(position);
        buffer.limit(limit);
        if (z) {
            planeArr[0].getBuffer().get(bArr, 0, i3);
            ByteBuffer buffer3 = planeArr[1].getBuffer();
            planeArr[2].getBuffer().get(bArr, i3, 1);
            buffer3.get(bArr, i3 + 1, i4 - 1);
        } else {
            i(planeArr[0], i, i2, bArr, 0, 1);
            i(planeArr[1], i, i2, bArr, i3 + 1, 2);
            i(planeArr[2], i, i2, bArr, i3, 2);
        }
        return ByteBuffer.wrap(bArr);
    }

    @TargetApi(19)
    private static void i(Image.Plane plane, int i, int i2, byte[] bArr, int i3, int i4) {
        ByteBuffer buffer = plane.getBuffer();
        buffer.rewind();
        int limit = ((buffer.limit() + plane.getRowStride()) - 1) / plane.getRowStride();
        if (limit != 0) {
            int i5 = i / (i2 / limit);
            int i6 = 0;
            for (int i7 = 0; i7 < limit; i7++) {
                int i8 = i6;
                for (int i9 = 0; i9 < i5; i9++) {
                    bArr[i3] = buffer.get(i8);
                    i3 += i4;
                    i8 += plane.getPixelStride();
                }
                i6 += plane.getRowStride();
            }
        }
    }

    private static byte[] j(@NonNull byte[] bArr, int i, int i2) {
        byte[] bArr2;
        YuvImage yuvImage = new YuvImage(bArr, 17, i, i2, null);
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            yuvImage.compressToJpeg(new Rect(0, 0, i, i2), 100, byteArrayOutputStream);
            bArr2 = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
            } catch (IOException unused) {
                Log.w("ImageConvertUtils", "Error closing ByteArrayOutputStream");
                return bArr2;
            }
        } catch (IOException unused2) {
            bArr2 = null;
        }
        return bArr2;
    }

    @KeepForSdk
    public byte[] a(@NonNull ByteBuffer byteBuffer) {
        if (byteBuffer.hasArray() && byteBuffer.arrayOffset() == 0) {
            return byteBuffer.array();
        }
        byteBuffer.rewind();
        int limit = byteBuffer.limit();
        byte[] bArr = new byte[limit];
        byteBuffer.get(bArr, 0, limit);
        return bArr;
    }

    @NonNull
    @KeepForSdk
    public ByteBuffer b(@NonNull a aVar, boolean z) throws MlKitException {
        ByteBuffer byteBuffer;
        int d2 = aVar.d();
        if (d2 == -1) {
            Bitmap b2 = aVar.b();
            int width = b2.getWidth();
            int height = b2.getHeight();
            int i = width * height;
            int[] iArr = new int[i];
            b2.getPixels(iArr, 0, width, 0, 0, width, height);
            int ceil = (((int) Math.ceil(height / 2.0d)) * 2 * ((int) Math.ceil(width / 2.0d))) + i;
            if (z) {
                byteBuffer = ByteBuffer.allocate(ceil);
            } else {
                byteBuffer = ByteBuffer.allocateDirect(ceil);
            }
            int i2 = 0;
            int i3 = 0;
            for (int i4 = 0; i4 < height; i4++) {
                for (int i5 = 0; i5 < width; i5++) {
                    int i6 = (iArr[i2] >> 16) & 255;
                    int i7 = (iArr[i2] >> 8) & 255;
                    int i8 = iArr[i2] & 255;
                    int i9 = (((((i6 * 66) + (i7 * 129)) + (i8 * 25)) + 128) >> 8) + 16;
                    int i10 = (((((i6 * (-38)) - (i7 * 74)) + (i8 * 112)) + 128) >> 8) + 128;
                    int i11 = (((((i6 * 112) - (i7 * 94)) - (i8 * 18)) + 128) >> 8) + 128;
                    i3++;
                    byteBuffer.put(i3, (byte) (i9 < 0 ? 0 : Math.min(255, i9)));
                    if (i4 % 2 == 0 && i2 % 2 == 0) {
                        int i12 = i + 1;
                        byteBuffer.put(i, (byte) (i11 < 0 ? 0 : Math.min(255, i11)));
                        i = i12 + 1;
                        byteBuffer.put(i12, (byte) (i10 < 0 ? 0 : Math.min(255, i10)));
                    }
                    i2++;
                }
            }
            return byteBuffer;
        } else if (d2 != 17) {
            if (d2 != 35) {
                if (d2 == 842094169) {
                    return g(aVar.c(), z);
                }
                throw new MlKitException("Unsupported image format", 13);
            } else if (Build.VERSION.SDK_INT >= 19) {
                return h(aVar.f(), aVar.h(), aVar.e());
            } else {
                throw new MlKitException("Unsupported image format", 13);
            }
        } else if (!z) {
            return aVar.c();
        } else {
            ByteBuffer c2 = aVar.c();
            if (c2.hasArray()) {
                return c2;
            }
            c2.rewind();
            byte[] bArr = new byte[c2.limit()];
            c2.get(bArr);
            return ByteBuffer.wrap(bArr);
        }
    }

    @NonNull
    @KeepForSdk
    public Bitmap c(@NonNull a aVar) throws MlKitException {
        int d2 = aVar.d();
        if (d2 == -1) {
            return e(aVar.b(), aVar.g(), aVar.h(), aVar.e());
        }
        if (d2 == 17) {
            return f(aVar.c(), aVar.h(), aVar.e(), aVar.g());
        }
        if (d2 != 35) {
            if (d2 == 842094169) {
                ByteBuffer c2 = aVar.c();
                int h = aVar.h();
                int e2 = aVar.e();
                int g = aVar.g();
                byte[] j = j(g(c2, true).array(), h, e2);
                return e(BitmapFactory.decodeByteArray(j, 0, j.length), g, h, e2);
            }
            throw new MlKitException("Unsupported image format", 13);
        } else if (Build.VERSION.SDK_INT >= 19) {
            return f(h(aVar.f(), aVar.h(), aVar.e()), aVar.h(), aVar.e(), aVar.g());
        } else {
            throw new MlKitException("Unsupported image format", 13);
        }
    }
}
