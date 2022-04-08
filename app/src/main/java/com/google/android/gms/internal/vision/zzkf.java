package com.google.android.gms.internal.vision;

/* JADX WARN: Init of enum zzacd can be incorrect */
/* JADX WARN: Init of enum zzace can be incorrect */
/* JADX WARN: Init of enum zzacf can be incorrect */
/* JADX WARN: Init of enum zzacg can be incorrect */
/* JADX WARN: Init of enum zzach can be incorrect */
/* JADX WARN: Init of enum zzacj can be incorrect */
/* JADX WARN: Init of enum zzack can be incorrect */
/* JADX WARN: Init of enum zzacl can be incorrect */
/* JADX WARN: Init of enum zzacm can be incorrect */
/* JADX WARN: Init of enum zzacn can be incorrect */
/* JADX WARN: Init of enum zzacp can be incorrect */
/* JADX WARN: Init of enum zzacq can be incorrect */
/* JADX WARN: Init of enum zzacr can be incorrect */
/* JADX WARN: Init of enum zzacs can be incorrect */
/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
/* loaded from: classes.dex */
public enum zzkf {
    DOUBLE(zzki.DOUBLE, 1),
    FLOAT(zzki.FLOAT, 5),
    INT64(r5, 0),
    UINT64(r5, 0),
    INT32(r11, 0),
    FIXED64(r5, 1),
    FIXED32(r11, 5),
    BOOL(zzki.BOOLEAN, 0),
    STRING(r13, 2) { // from class: com.google.android.gms.internal.vision.zzke
    },
    GROUP(r13, 3) { // from class: com.google.android.gms.internal.vision.zzkh
    },
    MESSAGE(r13, 2) { // from class: com.google.android.gms.internal.vision.zzkg
    },
    BYTES(r13, 2) { // from class: com.google.android.gms.internal.vision.zzkj
    },
    UINT32(r11, 0),
    ENUM(zzki.ENUM, 0),
    SFIXED32(r11, 5),
    SFIXED64(r5, 1),
    SINT32(r11, 0),
    SINT64(r5, 0);
    
    private final zzki zzact;
    private final int zzacu;

    static {
        zzki zzkiVar = zzki.LONG;
        zzki zzkiVar2 = zzki.INT;
        final zzki zzkiVar3 = zzki.STRING;
        final zzki zzkiVar4 = zzki.MESSAGE;
        final zzki zzkiVar5 = zzki.BYTE_STRING;
    }

    zzkf(zzki zzkiVar, int i) {
        this.zzact = zzkiVar;
        this.zzacu = i;
    }

    public final zzki zziq() {
        return this.zzact;
    }

    public final int zzir() {
        return this.zzacu;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* synthetic */ zzkf(zzki zzkiVar, int i, zzkc zzkcVar) {
        this(zzkiVar, i);
    }
}
