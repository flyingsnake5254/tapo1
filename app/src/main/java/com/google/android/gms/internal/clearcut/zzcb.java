package com.google.android.gms.internal.clearcut;

import java.lang.reflect.Type;

/* JADX WARN: Init of enum zzgy can be incorrect */
/* JADX WARN: Init of enum zzgz can be incorrect */
/* JADX WARN: Init of enum zzha can be incorrect */
/* JADX WARN: Init of enum zzhb can be incorrect */
/* JADX WARN: Init of enum zzhc can be incorrect */
/* JADX WARN: Init of enum zzhd can be incorrect */
/* JADX WARN: Init of enum zzhe can be incorrect */
/* JADX WARN: Init of enum zzhf can be incorrect */
/* JADX WARN: Init of enum zzhg can be incorrect */
/* JADX WARN: Init of enum zzhh can be incorrect */
/* JADX WARN: Init of enum zzhi can be incorrect */
/* JADX WARN: Init of enum zzhj can be incorrect */
/* JADX WARN: Init of enum zzhk can be incorrect */
/* JADX WARN: Init of enum zzhl can be incorrect */
/* JADX WARN: Init of enum zzhm can be incorrect */
/* JADX WARN: Init of enum zzhn can be incorrect */
/* JADX WARN: Init of enum zzho can be incorrect */
/* JADX WARN: Init of enum zzhp can be incorrect */
/* JADX WARN: Init of enum zzhq can be incorrect */
/* JADX WARN: Init of enum zzhr can be incorrect */
/* JADX WARN: Init of enum zzhs can be incorrect */
/* JADX WARN: Init of enum zzht can be incorrect */
/* JADX WARN: Init of enum zzhu can be incorrect */
/* JADX WARN: Init of enum zzhv can be incorrect */
/* JADX WARN: Init of enum zzhw can be incorrect */
/* JADX WARN: Init of enum zzhx can be incorrect */
/* JADX WARN: Init of enum zzhy can be incorrect */
/* JADX WARN: Init of enum zzhz can be incorrect */
/* JADX WARN: Init of enum zzia can be incorrect */
/* JADX WARN: Init of enum zzib can be incorrect */
/* JADX WARN: Init of enum zzic can be incorrect */
/* JADX WARN: Init of enum zzid can be incorrect */
/* JADX WARN: Init of enum zzie can be incorrect */
/* JADX WARN: Init of enum zzif can be incorrect */
/* JADX WARN: Init of enum zzig can be incorrect */
/* JADX WARN: Init of enum zzih can be incorrect */
/* JADX WARN: Init of enum zzii can be incorrect */
/* JADX WARN: Init of enum zzij can be incorrect */
/* JADX WARN: Init of enum zzik can be incorrect */
/* JADX WARN: Init of enum zzil can be incorrect */
/* JADX WARN: Init of enum zzim can be incorrect */
/* JADX WARN: Init of enum zzin can be incorrect */
/* JADX WARN: Init of enum zzio can be incorrect */
/* JADX WARN: Init of enum zzip can be incorrect */
/* JADX WARN: Init of enum zziq can be incorrect */
/* JADX WARN: Init of enum zzir can be incorrect */
/* JADX WARN: Init of enum zzis can be incorrect */
/* JADX WARN: Init of enum zzit can be incorrect */
/* JADX WARN: Init of enum zziu can be incorrect */
/* JADX WARN: Init of enum zziv can be incorrect */
/* loaded from: classes.dex */
public enum zzcb {
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
    SINT32_LIST_PACKED(47, r13, zzcq.INT),
    SINT64_LIST_PACKED(48, r13, r8),
    GROUP_LIST(49, r7, r14),
    MAP(50, zzcd.MAP, zzcq.VOID);
    
    private static final zzcb[] zzjb;
    private static final Type[] zzjc = new Type[0];
    private final int id;
    private final zzcq zzix;
    private final zzcd zziy;
    private final Class<?> zziz;
    private final boolean zzja;

    static {
        zzcd zzcdVar = zzcd.SCALAR;
        zzcq zzcqVar = zzcq.DOUBLE;
        zzcq zzcqVar2 = zzcq.FLOAT;
        zzcq zzcqVar3 = zzcq.LONG;
        zzcq zzcqVar4 = zzcq.INT;
        zzcq zzcqVar5 = zzcq.BOOLEAN;
        zzcq zzcqVar6 = zzcq.STRING;
        zzcq zzcqVar7 = zzcq.MESSAGE;
        zzcq zzcqVar8 = zzcq.BYTE_STRING;
        zzcq zzcqVar9 = zzcq.ENUM;
        zzcd zzcdVar2 = zzcd.VECTOR;
        zzcd zzcdVar3 = zzcd.PACKED_VECTOR;
        zzcq zzcqVar10 = zzcq.LONG;
        zzcb[] values = values();
        zzjb = new zzcb[values.length];
        for (zzcb zzcbVar : values) {
            zzjb[zzcbVar.id] = zzcbVar;
        }
    }

    zzcb(int i, zzcd zzcdVar, zzcq zzcqVar) {
        int i2;
        this.id = i;
        this.zziy = zzcdVar;
        this.zzix = zzcqVar;
        int i3 = zzcc.zzje[zzcdVar.ordinal()];
        boolean z = true;
        this.zziz = (i3 == 1 || i3 == 2) ? zzcqVar.zzbq() : null;
        this.zzja = (zzcdVar != zzcd.SCALAR || (i2 = zzcc.zzjf[zzcqVar.ordinal()]) == 1 || i2 == 2 || i2 == 3) ? false : z;
    }

    public final int id() {
        return this.id;
    }
}
