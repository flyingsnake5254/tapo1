package com.google.android.gms.internal.mlkit_vision_common;

/* compiled from: com.google.mlkit:vision-common@@16.0.0 */
/* loaded from: classes.dex */
public enum zzcz implements zzep {
    UNRECOGNIZED(0),
    CODE_128(1),
    CODE_39(2),
    CODE_93(3),
    CODABAR(4),
    DATA_MATRIX(5),
    EAN_13(6),
    EAN_8(7),
    ITF(8),
    QR_CODE(9),
    UPC_A(10),
    UPC_E(11),
    PDF417(12),
    AZTEC(13),
    DATABAR(14),
    TEZ_CODE(16);
    
    private static final zzeo<zzcz> zzq = new zzeo<zzcz>() { // from class: com.google.android.gms.internal.mlkit_vision_common.zzcy
    };
    private final int zzr;

    zzcz(int i) {
        this.zzr = i;
    }

    public static zzer zzb() {
        return zzdb.zza;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return "<" + zzcz.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzr + " name=" + name() + '>';
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzep
    public final int zza() {
        return this.zzr;
    }
}
