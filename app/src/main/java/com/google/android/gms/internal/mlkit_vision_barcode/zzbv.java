package com.google.android.gms.internal.mlkit_vision_barcode;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
/* loaded from: classes.dex */
public enum zzbv implements zzgf {
    NO_ERROR(0),
    INCOMPATIBLE_INPUT(1),
    INCOMPATIBLE_OUTPUT(2),
    INCOMPATIBLE_TFLITE_VERSION(3),
    MISSING_OP(4),
    DATA_TYPE_ERROR(6),
    TFLITE_INTERNAL_ERROR(7),
    TFLITE_UNKNOWN_ERROR(8),
    MEDIAPIPE_ERROR(9),
    TIME_OUT_FETCHING_MODEL_METADATA(5),
    MODEL_NOT_DOWNLOADED(100),
    URI_EXPIRED(101),
    NO_NETWORK_CONNECTION(102),
    METERED_NETWORK(103),
    DOWNLOAD_FAILED(104),
    MODEL_INFO_DOWNLOAD_UNSUCCESSFUL_HTTP_STATUS(105),
    MODEL_INFO_DOWNLOAD_NO_HASH(106),
    MODEL_INFO_DOWNLOAD_CONNECTION_FAILED(107),
    NO_VALID_MODEL(108),
    LOCAL_MODEL_INVALID(109),
    REMOTE_MODEL_INVALID(110),
    REMOTE_MODEL_LOADER_ERROR(111),
    REMOTE_MODEL_LOADER_LOADS_NO_MODEL(112),
    SMART_REPLY_LANG_ID_DETECTAION_FAILURE(113),
    MODEL_NOT_REGISTERED(114),
    MODEL_TYPE_MISUSE(115),
    MODEL_HASH_MISMATCH(116),
    UNKNOWN_ERROR(9999);
    
    private static final zzge<zzbv> zzac = new zzge<zzbv>() { // from class: com.google.android.gms.internal.mlkit_vision_barcode.zzbu
    };
    private final int zzad;

    zzbv(int i) {
        this.zzad = i;
    }

    public static zzgh zzb() {
        return zzbx.zza;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return "<" + zzbv.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzad + " name=" + name() + '>';
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzgf
    public final int zza() {
        return this.zzad;
    }
}
