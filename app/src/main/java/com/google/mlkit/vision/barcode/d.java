package com.google.mlkit.vision.barcode;

import android.graphics.Matrix;
import android.graphics.Point;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.vision.Frame;
import com.google.android.libraries.barhopper.Barcode;
import com.google.android.libraries.barhopper.BarhopperV2;
import com.google.android.libraries.barhopper.RecognitionOptions;
import com.google.mlkit.vision.barcode.internal.BarcodeScannerOptionsParcel;
import com.google.mlkit.vision.barcode.internal.a;
import com.google.mlkit.vision.common.internal.VisionImageMetadataParcel;
import java.nio.ByteBuffer;
import java.util.ArrayList;

/* compiled from: com.google.mlkit:barcode-scanning@@16.0.1 */
/* loaded from: classes2.dex */
final class d extends a.AbstractBinderC0182a {
    private final RecognitionOptions a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private BarhopperV2 f4989b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(BarcodeScannerOptionsParcel barcodeScannerOptionsParcel) {
        RecognitionOptions recognitionOptions = new RecognitionOptions();
        this.a = recognitionOptions;
        recognitionOptions.a(barcodeScannerOptionsParcel.f4992c);
    }

    @Override // com.google.mlkit.vision.barcode.internal.a
    public final IObjectWrapper a(IObjectWrapper iObjectWrapper, @NonNull VisionImageMetadataParcel visionImageMetadataParcel) {
        Point[] pointArr;
        if (this.f4989b == null) {
            Log.w("BarcodeScannerImpl", "Start method should be called first before scanning.");
            BarhopperV2 barhopperV2 = new BarhopperV2();
            this.f4989b = barhopperV2;
            barhopperV2.a();
        }
        Frame frame = (Frame) ObjectWrapper.unwrap(iObjectWrapper);
        ByteBuffer grayscaleImageData = frame.getGrayscaleImageData();
        Barcode[] barcodeArr = null;
        if (frame.getBitmap() != null) {
            barcodeArr = this.f4989b.g(frame.getBitmap(), this.a);
        } else if (grayscaleImageData != null) {
            if (grayscaleImageData.isDirect()) {
                barcodeArr = this.f4989b.c(visionImageMetadataParcel.f5004c, visionImageMetadataParcel.f5005d, grayscaleImageData, this.a);
            } else if (!grayscaleImageData.hasArray() || grayscaleImageData.arrayOffset() != 0) {
                byte[] bArr = new byte[grayscaleImageData.remaining()];
                grayscaleImageData.get(bArr);
                barcodeArr = this.f4989b.e(visionImageMetadataParcel.f5004c, visionImageMetadataParcel.f5005d, bArr, this.a);
            } else {
                barcodeArr = this.f4989b.e(visionImageMetadataParcel.f5004c, visionImageMetadataParcel.f5005d, grayscaleImageData.array(), this.a);
            }
        }
        ArrayList arrayList = new ArrayList();
        Matrix a = visionImageMetadataParcel.a();
        for (Barcode barcode : barcodeArr) {
            if (!(barcode.cornerPoints == null || a == null)) {
                float[] fArr = new float[8];
                int i = 0;
                while (true) {
                    if (i >= barcode.cornerPoints.length) {
                        break;
                    }
                    int i2 = i * 2;
                    fArr[i2] = pointArr[i].x;
                    fArr[i2 + 1] = pointArr[i].y;
                    i++;
                }
                a.mapPoints(fArr);
                int i3 = visionImageMetadataParcel.x;
                int i4 = 0;
                while (true) {
                    Point[] pointArr2 = barcode.cornerPoints;
                    if (i4 < pointArr2.length) {
                        Point point = pointArr2[(i4 + i3) % pointArr2.length];
                        int i5 = i4 * 2;
                        point.x = (int) fArr[i5];
                        point.y = (int) fArr[i5 + 1];
                        i4++;
                    }
                }
            }
            arrayList.add(new f(barcode));
        }
        return ObjectWrapper.wrap(arrayList);
    }

    @Override // com.google.mlkit.vision.barcode.internal.a
    public final void a_() {
        if (this.f4989b == null) {
            BarhopperV2 barhopperV2 = new BarhopperV2();
            this.f4989b = barhopperV2;
            barhopperV2.a();
        }
    }

    @Override // com.google.mlkit.vision.barcode.internal.a
    public final void zzb() {
        BarhopperV2 barhopperV2 = this.f4989b;
        if (barhopperV2 != null) {
            barhopperV2.close();
            this.f4989b = null;
        }
    }
}
