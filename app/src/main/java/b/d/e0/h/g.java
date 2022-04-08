package b.d.e0.h;

import android.graphics.Bitmap;
import androidx.core.view.ViewCompat;

/* compiled from: PlanarYUVLuminanceSource.java */
/* loaded from: classes3.dex */
public final class g extends f {

    /* renamed from: c  reason: collision with root package name */
    private final byte[] f417c;

    /* renamed from: d  reason: collision with root package name */
    private final int f418d;

    /* renamed from: e  reason: collision with root package name */
    private final int f419e;

    /* renamed from: f  reason: collision with root package name */
    private final int f420f;
    private final int g;

    public g(byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6) {
        super(i5, i6);
        if (i5 + i3 > i || i6 + i4 > i2) {
            throw new IllegalArgumentException("Crop rectangle does not fit within image data.");
        }
        this.f417c = bArr;
        this.f418d = i;
        this.f419e = i2;
        this.f420f = i3;
        this.g = i4;
    }

    @Override // b.d.e0.h.f
    public byte[] b(int i, byte[] bArr) {
        if (i < 0 || i >= a()) {
            throw new IllegalArgumentException("Requested row is outside the image: " + i);
        }
        int c2 = c();
        if (bArr == null || bArr.length < c2) {
            bArr = new byte[c2];
        }
        System.arraycopy(this.f417c, ((i + this.g) * this.f418d) + this.f420f, bArr, 0, c2);
        return bArr;
    }

    public Bitmap d() {
        int c2 = c();
        int a = a();
        int[] iArr = new int[c2 * a];
        byte[] bArr = this.f417c;
        int i = (this.g * this.f418d) + this.f420f;
        for (int i2 = 0; i2 < a; i2++) {
            int i3 = i2 * c2;
            for (int i4 = 0; i4 < c2; i4++) {
                iArr[i3 + i4] = ((bArr[i + i4] & 255) * 65793) | ViewCompat.MEASURED_STATE_MASK;
            }
            i += this.f418d;
        }
        Bitmap createBitmap = Bitmap.createBitmap(c2, a, Bitmap.Config.ARGB_8888);
        createBitmap.setPixels(iArr, 0, c2, 0, 0, c2, a);
        return createBitmap;
    }
}
