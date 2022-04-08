package com.google.android.libraries.barhopper;

import android.graphics.Bitmap;
import android.util.Log;
import java.io.Closeable;
import java.nio.ByteBuffer;

/* compiled from: com.google.mlkit:barcode-scanning@@16.0.1 */
/* loaded from: classes2.dex */
public class BarhopperV2 implements Closeable {

    /* renamed from: c  reason: collision with root package name */
    private static final String f4105c = BarhopperV2.class.getSimpleName();

    /* renamed from: d  reason: collision with root package name */
    private long f4106d;

    public BarhopperV2() {
        System.loadLibrary("barhopper_v2");
    }

    private native void closeNative(long j);

    private native long createNative();

    private native Barcode[] recognizeBitmapNative(long j, Bitmap bitmap, RecognitionOptions recognitionOptions);

    private native Barcode[] recognizeBufferNative(long j, int i, int i2, ByteBuffer byteBuffer, RecognitionOptions recognitionOptions);

    private native Barcode[] recognizeNative(long j, int i, int i2, byte[] bArr, RecognitionOptions recognitionOptions);

    public void a() {
        if (this.f4106d != 0) {
            Log.w(f4105c, "Native context already exists.");
            return;
        }
        long createNative = createNative();
        this.f4106d = createNative;
        if (createNative == 0) {
            throw new RuntimeException("Failed to create native context.");
        }
    }

    public Barcode[] c(int i, int i2, ByteBuffer byteBuffer, RecognitionOptions recognitionOptions) {
        long j = this.f4106d;
        if (j != 0) {
            return recognizeBufferNative(j, i, i2, byteBuffer, recognitionOptions);
        }
        throw new RuntimeException("Native context does not exist.");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        long j = this.f4106d;
        if (j != 0) {
            closeNative(j);
            this.f4106d = 0L;
        }
    }

    public Barcode[] e(int i, int i2, byte[] bArr, RecognitionOptions recognitionOptions) {
        long j = this.f4106d;
        if (j != 0) {
            return recognizeNative(j, i, i2, bArr, recognitionOptions);
        }
        throw new RuntimeException("Native context does not exist.");
    }

    protected void finalize() throws Throwable {
        try {
            close();
        } finally {
            super.finalize();
        }
    }

    public Barcode[] g(Bitmap bitmap, RecognitionOptions recognitionOptions) {
        long j = this.f4106d;
        if (j != 0) {
            return recognizeBitmapNative(j, bitmap, recognitionOptions);
        }
        throw new RuntimeException("Native context does not exist.");
    }
}
