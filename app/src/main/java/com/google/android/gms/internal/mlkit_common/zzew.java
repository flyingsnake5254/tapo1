package com.google.android.gms.internal.mlkit_common;

import java.lang.reflect.Type;

/* JADX WARN: Init of enum zza can be incorrect */
/* JADX WARN: Init of enum zzaa can be incorrect */
/* JADX WARN: Init of enum zzab can be incorrect */
/* JADX WARN: Init of enum zzac can be incorrect */
/* JADX WARN: Init of enum zzad can be incorrect */
/* JADX WARN: Init of enum zzae can be incorrect */
/* JADX WARN: Init of enum zzaf can be incorrect */
/* JADX WARN: Init of enum zzag can be incorrect */
/* JADX WARN: Init of enum zzah can be incorrect */
/* JADX WARN: Init of enum zzai can be incorrect */
/* JADX WARN: Init of enum zzaj can be incorrect */
/* JADX WARN: Init of enum zzak can be incorrect */
/* JADX WARN: Init of enum zzal can be incorrect */
/* JADX WARN: Init of enum zzam can be incorrect */
/* JADX WARN: Init of enum zzan can be incorrect */
/* JADX WARN: Init of enum zzao can be incorrect */
/* JADX WARN: Init of enum zzap can be incorrect */
/* JADX WARN: Init of enum zzaq can be incorrect */
/* JADX WARN: Init of enum zzar can be incorrect */
/* JADX WARN: Init of enum zzas can be incorrect */
/* JADX WARN: Init of enum zzat can be incorrect */
/* JADX WARN: Init of enum zzau can be incorrect */
/* JADX WARN: Init of enum zzav can be incorrect */
/* JADX WARN: Init of enum zzaw can be incorrect */
/* JADX WARN: Init of enum zzax can be incorrect */
/* JADX WARN: Init of enum zzb can be incorrect */
/* JADX WARN: Init of enum zzc can be incorrect */
/* JADX WARN: Init of enum zzd can be incorrect */
/* JADX WARN: Init of enum zze can be incorrect */
/* JADX WARN: Init of enum zzf can be incorrect */
/* JADX WARN: Init of enum zzg can be incorrect */
/* JADX WARN: Init of enum zzh can be incorrect */
/* JADX WARN: Init of enum zzi can be incorrect */
/* JADX WARN: Init of enum zzj can be incorrect */
/* JADX WARN: Init of enum zzk can be incorrect */
/* JADX WARN: Init of enum zzl can be incorrect */
/* JADX WARN: Init of enum zzm can be incorrect */
/* JADX WARN: Init of enum zzn can be incorrect */
/* JADX WARN: Init of enum zzo can be incorrect */
/* JADX WARN: Init of enum zzp can be incorrect */
/* JADX WARN: Init of enum zzq can be incorrect */
/* JADX WARN: Init of enum zzr can be incorrect */
/* JADX WARN: Init of enum zzs can be incorrect */
/* JADX WARN: Init of enum zzt can be incorrect */
/* JADX WARN: Init of enum zzu can be incorrect */
/* JADX WARN: Init of enum zzv can be incorrect */
/* JADX WARN: Init of enum zzw can be incorrect */
/* JADX WARN: Init of enum zzx can be incorrect */
/* JADX WARN: Init of enum zzy can be incorrect */
/* JADX WARN: Init of enum zzz can be incorrect */
/* compiled from: com.google.mlkit:common@@16.0.0 */
/* loaded from: classes.dex */
public enum zzew {
    DOUBLE(0, r7, r8),
    FLOAT(1, r7, r9),
    INT64(2, r7, r10),
    UINT64(3, r7, r10),
    INT32(4, r7, r11),
    FIXED64(5, r7, r10),
    FIXED32(6, r7, r11),
    BOOL(7, r7, r12),
    STRING(8, r7, r13),
    MESSAGE(9, r7, r14),
    BYTES(10, r7, r15),
    UINT32(11, r7, r11),
    ENUM(12, r7, r16),
    SFIXED32(13, r7, r11),
    SFIXED64(14, r7, r10),
    SINT32(15, r7, r11),
    SINT64(16, r7, r10),
    GROUP(17, r7, r14),
    DOUBLE_LIST(18, r7, r8),
    FLOAT_LIST(19, r7, r9),
    INT64_LIST(20, r7, r10),
    UINT64_LIST(21, r7, r10),
    INT32_LIST(22, r7, r11),
    FIXED64_LIST(23, r7, r10),
    FIXED32_LIST(24, r7, r11),
    BOOL_LIST(25, r7, r12),
    STRING_LIST(26, r7, r13),
    MESSAGE_LIST(27, r7, r14),
    BYTES_LIST(28, r7, r15),
    UINT32_LIST(29, r7, r11),
    ENUM_LIST(30, r7, r16),
    SFIXED32_LIST(31, r7, r11),
    SFIXED64_LIST(32, r7, r10),
    SINT32_LIST(33, r7, r11),
    SINT64_LIST(34, r7, r10),
    DOUBLE_LIST_PACKED(35, r13, r8),
    FLOAT_LIST_PACKED(36, r13, r9),
    INT64_LIST_PACKED(37, r13, r10),
    UINT64_LIST_PACKED(38, r13, r10),
    INT32_LIST_PACKED(39, r13, r11),
    FIXED64_LIST_PACKED(40, r13, r10),
    FIXED32_LIST_PACKED(41, r13, r11),
    BOOL_LIST_PACKED(42, r13, r12),
    UINT32_LIST_PACKED(43, r13, r11),
    ENUM_LIST_PACKED(44, r13, r16),
    SFIXED32_LIST_PACKED(45, r13, r11),
    SFIXED64_LIST_PACKED(46, r13, r8),
    SINT32_LIST_PACKED(47, r13, zzfj.INT),
    SINT64_LIST_PACKED(48, r13, r8),
    GROUP_LIST(49, r7, r14),
    MAP(50, zzey.MAP, zzfj.VOID);
    
    private static final zzew[] zzbe;
    private static final Type[] zzbf = new Type[0];
    private final zzfj zzaz;
    private final int zzba;
    private final zzey zzbb;
    private final Class<?> zzbc;
    private final boolean zzbd;

    static {
        zzey zzeyVar = zzey.SCALAR;
        zzfj zzfjVar = zzfj.DOUBLE;
        zzfj zzfjVar2 = zzfj.FLOAT;
        zzfj zzfjVar3 = zzfj.LONG;
        zzfj zzfjVar4 = zzfj.INT;
        zzfj zzfjVar5 = zzfj.BOOLEAN;
        zzfj zzfjVar6 = zzfj.STRING;
        zzfj zzfjVar7 = zzfj.MESSAGE;
        zzfj zzfjVar8 = zzfj.BYTE_STRING;
        zzfj zzfjVar9 = zzfj.ENUM;
        zzey zzeyVar2 = zzey.VECTOR;
        zzey zzeyVar3 = zzey.PACKED_VECTOR;
        zzfj zzfjVar10 = zzfj.LONG;
        zzew[] values = values();
        zzbe = new zzew[values.length];
        for (zzew zzewVar : values) {
            zzbe[zzewVar.zzba] = zzewVar;
        }
    }

    zzew(int i, zzey zzeyVar, zzfj zzfjVar) {
        int i2;
        this.zzba = i;
        this.zzbb = zzeyVar;
        this.zzaz = zzfjVar;
        int i3 = zzev.zza[zzeyVar.ordinal()];
        boolean z = true;
        if (i3 == 1) {
            this.zzbc = zzfjVar.zza();
        } else if (i3 != 2) {
            this.zzbc = null;
        } else {
            this.zzbc = zzfjVar.zza();
        }
        this.zzbd = (zzeyVar != zzey.SCALAR || (i2 = zzev.zzb[zzfjVar.ordinal()]) == 1 || i2 == 2 || i2 == 3) ? false : z;
    }

    public final int zza() {
        return this.zzba;
    }
}
