package com.google.android.gms.internal.mlkit_vision_barcode;

/* JADX WARN: Init of enum zzc can be incorrect */
/* JADX WARN: Init of enum zzd can be incorrect */
/* JADX WARN: Init of enum zze can be incorrect */
/* JADX WARN: Init of enum zzf can be incorrect */
/* JADX WARN: Init of enum zzg can be incorrect */
/* JADX WARN: Init of enum zzi can be incorrect */
/* JADX WARN: Init of enum zzj can be incorrect */
/* JADX WARN: Init of enum zzk can be incorrect */
/* JADX WARN: Init of enum zzl can be incorrect */
/* JADX WARN: Init of enum zzm can be incorrect */
/* JADX WARN: Init of enum zzo can be incorrect */
/* JADX WARN: Init of enum zzp can be incorrect */
/* JADX WARN: Init of enum zzq can be incorrect */
/* JADX WARN: Init of enum zzr can be incorrect */
/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
/* loaded from: classes.dex */
public enum zzjh {
    DOUBLE(zzjk.DOUBLE, 1),
    FLOAT(zzjk.FLOAT, 5),
    INT64(r5, 0),
    UINT64(r5, 0),
    INT32(r11, 0),
    FIXED64(r5, 1),
    FIXED32(r11, 5),
    BOOL(zzjk.BOOLEAN, 0),
    STRING(r13, 2) { // from class: com.google.android.gms.internal.mlkit_vision_barcode.zzjg
    },
    GROUP(r13, 3) { // from class: com.google.android.gms.internal.mlkit_vision_barcode.zzjj
    },
    MESSAGE(r13, 2) { // from class: com.google.android.gms.internal.mlkit_vision_barcode.zzji
    },
    BYTES(r13, 2) { // from class: com.google.android.gms.internal.mlkit_vision_barcode.zzjl
    },
    UINT32(r11, 0),
    ENUM(zzjk.ENUM, 0),
    SFIXED32(r11, 5),
    SFIXED64(r5, 1),
    SINT32(r11, 0),
    SINT64(r5, 0);
    
    private final zzjk zzs;
    private final int zzt;

    static {
        zzjk zzjkVar = zzjk.LONG;
        zzjk zzjkVar2 = zzjk.INT;
        final zzjk zzjkVar3 = zzjk.STRING;
        final zzjk zzjkVar4 = zzjk.MESSAGE;
        final zzjk zzjkVar5 = zzjk.BYTE_STRING;
    }

    zzjh(zzjk zzjkVar, int i) {
        this.zzs = zzjkVar;
        this.zzt = i;
    }

    public final zzjk zza() {
        return this.zzs;
    }

    public final int zzb() {
        return this.zzt;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* synthetic */ zzjh(zzjk zzjkVar, int i, zzje zzjeVar) {
        this(zzjkVar, i);
    }
}
