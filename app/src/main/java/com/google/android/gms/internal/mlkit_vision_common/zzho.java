package com.google.android.gms.internal.mlkit_vision_common;

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
/* compiled from: com.google.mlkit:vision-common@@16.0.0 */
/* loaded from: classes.dex */
public enum zzho {
    DOUBLE(zzhv.DOUBLE, 1),
    FLOAT(zzhv.FLOAT, 5),
    INT64(r5, 0),
    UINT64(r5, 0),
    INT32(r11, 0),
    FIXED64(r5, 1),
    FIXED32(r11, 5),
    BOOL(zzhv.BOOLEAN, 0),
    STRING(r13, 2) { // from class: com.google.android.gms.internal.mlkit_vision_common.zzhr
    },
    GROUP(r13, 3) { // from class: com.google.android.gms.internal.mlkit_vision_common.zzhq
    },
    MESSAGE(r13, 2) { // from class: com.google.android.gms.internal.mlkit_vision_common.zzht
    },
    BYTES(r13, 2) { // from class: com.google.android.gms.internal.mlkit_vision_common.zzhs
    },
    UINT32(r11, 0),
    ENUM(zzhv.ENUM, 0),
    SFIXED32(r11, 5),
    SFIXED64(r5, 1),
    SINT32(r11, 0),
    SINT64(r5, 0);
    
    private final zzhv zzs;
    private final int zzt;

    static {
        zzhv zzhvVar = zzhv.LONG;
        zzhv zzhvVar2 = zzhv.INT;
        final zzhv zzhvVar3 = zzhv.STRING;
        final zzhv zzhvVar4 = zzhv.MESSAGE;
        final zzhv zzhvVar5 = zzhv.BYTE_STRING;
    }

    zzho(zzhv zzhvVar, int i) {
        this.zzs = zzhvVar;
        this.zzt = i;
    }

    public final zzhv zza() {
        return this.zzs;
    }

    public final int zzb() {
        return this.zzt;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* synthetic */ zzho(zzhv zzhvVar, int i, zzhp zzhpVar) {
        this(zzhvVar, i);
    }
}
