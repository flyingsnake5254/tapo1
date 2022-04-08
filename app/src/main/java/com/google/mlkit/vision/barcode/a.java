package com.google.mlkit.vision.barcode;

import android.util.SparseArray;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.mlkit_vision_barcode.zzbl;
import com.google.mlkit.vision.barcode.internal.h;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
/* loaded from: classes2.dex */
public class a {
    private static final SparseArray<zzbl.zzao.zza> a;

    /* renamed from: b  reason: collision with root package name */
    private static final SparseArray<zzbl.zzao.zzb> f4984b;

    /* renamed from: c  reason: collision with root package name */
    private final h f4985c;

    static {
        SparseArray<zzbl.zzao.zza> sparseArray = new SparseArray<>();
        a = sparseArray;
        SparseArray<zzbl.zzao.zzb> sparseArray2 = new SparseArray<>();
        f4984b = sparseArray2;
        sparseArray.put(-1, zzbl.zzao.zza.FORMAT_UNKNOWN);
        sparseArray.put(1, zzbl.zzao.zza.FORMAT_CODE_128);
        sparseArray.put(2, zzbl.zzao.zza.FORMAT_CODE_39);
        sparseArray.put(4, zzbl.zzao.zza.FORMAT_CODE_93);
        sparseArray.put(8, zzbl.zzao.zza.FORMAT_CODABAR);
        sparseArray.put(16, zzbl.zzao.zza.FORMAT_DATA_MATRIX);
        sparseArray.put(32, zzbl.zzao.zza.FORMAT_EAN_13);
        sparseArray.put(64, zzbl.zzao.zza.FORMAT_EAN_8);
        sparseArray.put(128, zzbl.zzao.zza.FORMAT_ITF);
        sparseArray.put(256, zzbl.zzao.zza.FORMAT_QR_CODE);
        sparseArray.put(512, zzbl.zzao.zza.FORMAT_UPC_A);
        sparseArray.put(1024, zzbl.zzao.zza.FORMAT_UPC_E);
        sparseArray.put(2048, zzbl.zzao.zza.FORMAT_PDF417);
        sparseArray.put(4096, zzbl.zzao.zza.FORMAT_AZTEC);
        sparseArray2.put(0, zzbl.zzao.zzb.TYPE_UNKNOWN);
        sparseArray2.put(1, zzbl.zzao.zzb.TYPE_CONTACT_INFO);
        sparseArray2.put(2, zzbl.zzao.zzb.TYPE_EMAIL);
        sparseArray2.put(3, zzbl.zzao.zzb.TYPE_ISBN);
        sparseArray2.put(4, zzbl.zzao.zzb.TYPE_PHONE);
        sparseArray2.put(5, zzbl.zzao.zzb.TYPE_PRODUCT);
        sparseArray2.put(6, zzbl.zzao.zzb.TYPE_SMS);
        sparseArray2.put(7, zzbl.zzao.zzb.TYPE_TEXT);
        sparseArray2.put(8, zzbl.zzao.zzb.TYPE_URL);
        sparseArray2.put(9, zzbl.zzao.zzb.TYPE_WIFI);
        sparseArray2.put(10, zzbl.zzao.zzb.TYPE_GEO);
        sparseArray2.put(11, zzbl.zzao.zzb.TYPE_CALENDAR_EVENT);
        sparseArray2.put(12, zzbl.zzao.zzb.TYPE_DRIVER_LICENSE);
    }

    public a(@NonNull h hVar) {
        this.f4985c = (h) Preconditions.checkNotNull(hVar);
    }

    public int a() {
        int zzf = this.f4985c.zzf();
        if (zzf > 4096 || zzf == 0) {
            return -1;
        }
        return zzf;
    }

    @Nullable
    public String b() {
        return this.f4985c.zzc();
    }

    public int c() {
        return this.f4985c.zzg();
    }

    public final zzbl.zzao.zza d() {
        zzbl.zzao.zza zzaVar = a.get(a());
        return zzaVar == null ? zzbl.zzao.zza.FORMAT_UNKNOWN : zzaVar;
    }

    public final zzbl.zzao.zzb e() {
        zzbl.zzao.zzb zzbVar = f4984b.get(c());
        return zzbVar == null ? zzbl.zzao.zzb.TYPE_UNKNOWN : zzbVar;
    }
}
