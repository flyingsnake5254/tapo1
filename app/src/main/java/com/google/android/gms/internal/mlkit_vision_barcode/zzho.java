package com.google.android.gms.internal.mlkit_vision_barcode;

import com.github.mikephil.charting.utils.Utils;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import sun.misc.Unsafe;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
/* loaded from: classes.dex */
final class zzho<T> implements zzib<T> {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zziz.zzc();
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zzhk zzg;
    private final boolean zzh;
    private final boolean zzi;
    private final boolean zzj;
    private final boolean zzk;
    private final int[] zzl;
    private final int zzm;
    private final int zzn;
    private final zzht zzo;
    private final zzgu zzp;
    private final zzit<?, ?> zzq;
    private final zzfr<?> zzr;
    private final zzhh zzs;

    private zzho(int[] iArr, Object[] objArr, int i, int i2, zzhk zzhkVar, boolean z, boolean z2, int[] iArr2, int i3, int i4, zzht zzhtVar, zzgu zzguVar, zzit<?, ?> zzitVar, zzfr<?> zzfrVar, zzhh zzhhVar) {
        this.zzc = iArr;
        this.zzd = objArr;
        this.zze = i;
        this.zzf = i2;
        this.zzi = zzhkVar instanceof zzga;
        this.zzj = z;
        this.zzh = zzfrVar != null && zzfrVar.zza(zzhkVar);
        this.zzk = false;
        this.zzl = iArr2;
        this.zzm = i3;
        this.zzn = i4;
        this.zzo = zzhtVar;
        this.zzp = zzguVar;
        this.zzq = zzitVar;
        this.zzr = zzfrVar;
        this.zzg = zzhkVar;
        this.zzs = zzhhVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:159:0x033a  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x039c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static <T> com.google.android.gms.internal.mlkit_vision_barcode.zzho<T> zza(java.lang.Class<T> r33, com.google.android.gms.internal.mlkit_vision_barcode.zzhi r34, com.google.android.gms.internal.mlkit_vision_barcode.zzht r35, com.google.android.gms.internal.mlkit_vision_barcode.zzgu r36, com.google.android.gms.internal.mlkit_vision_barcode.zzit<?, ?> r37, com.google.android.gms.internal.mlkit_vision_barcode.zzfr<?> r38, com.google.android.gms.internal.mlkit_vision_barcode.zzhh r39) {
        /*
            Method dump skipped, instructions count: 1053
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_barcode.zzho.zza(java.lang.Class, com.google.android.gms.internal.mlkit_vision_barcode.zzhi, com.google.android.gms.internal.mlkit_vision_barcode.zzht, com.google.android.gms.internal.mlkit_vision_barcode.zzgu, com.google.android.gms.internal.mlkit_vision_barcode.zzit, com.google.android.gms.internal.mlkit_vision_barcode.zzfr, com.google.android.gms.internal.mlkit_vision_barcode.zzhh):com.google.android.gms.internal.mlkit_vision_barcode.zzho");
    }

    private static <T> long zze(T t, long j) {
        return ((Long) zziz.zzf(t, j)).longValue();
    }

    private static <T> boolean zzf(T t, long j) {
        return ((Boolean) zziz.zzf(t, j)).booleanValue();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzib
    public final void zzb(T t, T t2) {
        Objects.requireNonNull(t2);
        for (int i = 0; i < this.zzc.length; i += 3) {
            int zzc = zzc(i);
            long j = 1048575 & zzc;
            int i2 = this.zzc[i];
            switch ((zzc & 267386880) >>> 20) {
                case 0:
                    if (zza((zzho<T>) t2, i)) {
                        zziz.zza(t, j, zziz.zze(t2, j));
                        zzb((zzho<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (zza((zzho<T>) t2, i)) {
                        zziz.zza((Object) t, j, zziz.zzd(t2, j));
                        zzb((zzho<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (zza((zzho<T>) t2, i)) {
                        zziz.zza((Object) t, j, zziz.zzb(t2, j));
                        zzb((zzho<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if (zza((zzho<T>) t2, i)) {
                        zziz.zza((Object) t, j, zziz.zzb(t2, j));
                        zzb((zzho<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if (zza((zzho<T>) t2, i)) {
                        zziz.zza((Object) t, j, zziz.zza(t2, j));
                        zzb((zzho<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if (zza((zzho<T>) t2, i)) {
                        zziz.zza((Object) t, j, zziz.zzb(t2, j));
                        zzb((zzho<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if (zza((zzho<T>) t2, i)) {
                        zziz.zza((Object) t, j, zziz.zza(t2, j));
                        zzb((zzho<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if (zza((zzho<T>) t2, i)) {
                        zziz.zza(t, j, zziz.zzc(t2, j));
                        zzb((zzho<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if (zza((zzho<T>) t2, i)) {
                        zziz.zza(t, j, zziz.zzf(t2, j));
                        zzb((zzho<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 9:
                    zza(t, t2, i);
                    break;
                case 10:
                    if (zza((zzho<T>) t2, i)) {
                        zziz.zza(t, j, zziz.zzf(t2, j));
                        zzb((zzho<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if (zza((zzho<T>) t2, i)) {
                        zziz.zza((Object) t, j, zziz.zza(t2, j));
                        zzb((zzho<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if (zza((zzho<T>) t2, i)) {
                        zziz.zza((Object) t, j, zziz.zza(t2, j));
                        zzb((zzho<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if (zza((zzho<T>) t2, i)) {
                        zziz.zza((Object) t, j, zziz.zza(t2, j));
                        zzb((zzho<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 14:
                    if (zza((zzho<T>) t2, i)) {
                        zziz.zza((Object) t, j, zziz.zzb(t2, j));
                        zzb((zzho<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 15:
                    if (zza((zzho<T>) t2, i)) {
                        zziz.zza((Object) t, j, zziz.zza(t2, j));
                        zzb((zzho<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if (zza((zzho<T>) t2, i)) {
                        zziz.zza((Object) t, j, zziz.zzb(t2, j));
                        zzb((zzho<T>) t, i);
                        break;
                    } else {
                        break;
                    }
                case 17:
                    zza(t, t2, i);
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    this.zzp.zza(t, t2, j);
                    break;
                case 50:
                    zzid.zza(this.zzs, t, t2, j);
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                    if (zza((zzho<T>) t2, i2, i)) {
                        zziz.zza(t, j, zziz.zzf(t2, j));
                        zzb((zzho<T>) t, i2, i);
                        break;
                    } else {
                        break;
                    }
                case 60:
                    zzb(t, t2, i);
                    break;
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                    if (zza((zzho<T>) t2, i2, i)) {
                        zziz.zza(t, j, zziz.zzf(t2, j));
                        zzb((zzho<T>) t, i2, i);
                        break;
                    } else {
                        break;
                    }
                case 68:
                    zzb(t, t2, i);
                    break;
            }
        }
        zzid.zza(this.zzq, t, t2);
        if (this.zzh) {
            zzid.zza(this.zzr, t, t2);
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzib
    public final void zzc(T t) {
        int i;
        int i2 = this.zzm;
        while (true) {
            i = this.zzn;
            if (i2 >= i) {
                break;
            }
            long zzc = zzc(this.zzl[i2]) & 1048575;
            Object zzf = zziz.zzf(t, zzc);
            if (zzf != null) {
                zziz.zza(t, zzc, this.zzs.zzc(zzf));
            }
            i2++;
        }
        int length = this.zzl.length;
        while (i < length) {
            this.zzp.zza(t, this.zzl[i]);
            i++;
        }
        this.zzq.zzb(t);
        if (this.zzh) {
            this.zzr.zzc(t);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v23, types: [com.google.android.gms.internal.mlkit_vision_barcode.zzib] */
    /* JADX WARN: Type inference failed for: r1v30 */
    /* JADX WARN: Type inference failed for: r1v8, types: [com.google.android.gms.internal.mlkit_vision_barcode.zzib] */
    /* JADX WARN: Unknown variable types count: 1 */
    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzib
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean zzd(T r19) {
        /*
            Method dump skipped, instructions count: 320
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_barcode.zzho.zzd(java.lang.Object):boolean");
    }

    private final int zzc(int i) {
        return this.zzc[i + 1];
    }

    private static <T> float zzc(T t, long j) {
        return ((Float) zziz.zzf(t, j)).floatValue();
    }

    private final boolean zzc(T t, T t2, int i) {
        return zza((zzho<T>) t, i) == zza((zzho<T>) t2, i);
    }

    private final int zzd(int i) {
        return this.zzc[i + 2];
    }

    private static <T> int zzd(T t, long j) {
        return ((Integer) zziz.zzf(t, j)).intValue();
    }

    private final void zzb(T t, T t2, int i) {
        int zzc = zzc(i);
        int i2 = this.zzc[i];
        long j = zzc & 1048575;
        if (zza((zzho<T>) t2, i2, i)) {
            Object zzf = zziz.zzf(t, j);
            Object zzf2 = zziz.zzf(t2, j);
            if (zzf != null && zzf2 != null) {
                zziz.zza(t, j, zzgc.zza(zzf, zzf2));
                zzb((zzho<T>) t, i2, i);
            } else if (zzf2 != null) {
                zziz.zza(t, j, zzf2);
                zzb((zzho<T>) t, i2, i);
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzib
    public final int zzb(T t) {
        int i;
        int i2;
        long j;
        int i3;
        int zzb2;
        int i4;
        int i5;
        int i6;
        int i7;
        int zzb3;
        int i8;
        int i9;
        int i10;
        int i11 = 267386880;
        if (this.zzj) {
            Unsafe unsafe = zzb;
            int i12 = 0;
            int i13 = 0;
            while (i12 < this.zzc.length) {
                int zzc = zzc(i12);
                int i14 = (zzc & i11) >>> 20;
                int i15 = this.zzc[i12];
                long j2 = zzc & 1048575;
                int i16 = (i14 < zzfx.DOUBLE_LIST_PACKED.zza() || i14 > zzfx.SINT64_LIST_PACKED.zza()) ? 0 : this.zzc[i12 + 2] & 1048575;
                switch (i14) {
                    case 0:
                        if (zza((zzho<T>) t, i12)) {
                            zzb3 = zzfn.zzb(i15, (double) Utils.DOUBLE_EPSILON);
                            break;
                        } else {
                            continue;
                            i12 += 3;
                            i11 = 267386880;
                        }
                    case 1:
                        if (zza((zzho<T>) t, i12)) {
                            zzb3 = zzfn.zzb(i15, 0.0f);
                            break;
                        } else {
                            continue;
                            i12 += 3;
                            i11 = 267386880;
                        }
                    case 2:
                        if (zza((zzho<T>) t, i12)) {
                            zzb3 = zzfn.zzd(i15, zziz.zzb(t, j2));
                            break;
                        } else {
                            continue;
                            i12 += 3;
                            i11 = 267386880;
                        }
                    case 3:
                        if (zza((zzho<T>) t, i12)) {
                            zzb3 = zzfn.zze(i15, zziz.zzb(t, j2));
                            break;
                        } else {
                            continue;
                            i12 += 3;
                            i11 = 267386880;
                        }
                    case 4:
                        if (zza((zzho<T>) t, i12)) {
                            zzb3 = zzfn.zzf(i15, zziz.zza(t, j2));
                            break;
                        } else {
                            continue;
                            i12 += 3;
                            i11 = 267386880;
                        }
                    case 5:
                        if (zza((zzho<T>) t, i12)) {
                            zzb3 = zzfn.zzg(i15, 0L);
                            break;
                        } else {
                            continue;
                            i12 += 3;
                            i11 = 267386880;
                        }
                    case 6:
                        if (zza((zzho<T>) t, i12)) {
                            zzb3 = zzfn.zzi(i15, 0);
                            break;
                        } else {
                            continue;
                            i12 += 3;
                            i11 = 267386880;
                        }
                    case 7:
                        if (zza((zzho<T>) t, i12)) {
                            zzb3 = zzfn.zzb(i15, true);
                            break;
                        } else {
                            continue;
                            i12 += 3;
                            i11 = 267386880;
                        }
                    case 8:
                        if (zza((zzho<T>) t, i12)) {
                            Object zzf = zziz.zzf(t, j2);
                            if (zzf instanceof zzew) {
                                zzb3 = zzfn.zzc(i15, (zzew) zzf);
                                break;
                            } else {
                                zzb3 = zzfn.zzb(i15, (String) zzf);
                                break;
                            }
                        } else {
                            continue;
                            i12 += 3;
                            i11 = 267386880;
                        }
                    case 9:
                        if (zza((zzho<T>) t, i12)) {
                            zzb3 = zzid.zza(i15, zziz.zzf(t, j2), zza(i12));
                            break;
                        } else {
                            continue;
                            i12 += 3;
                            i11 = 267386880;
                        }
                    case 10:
                        if (zza((zzho<T>) t, i12)) {
                            zzb3 = zzfn.zzc(i15, (zzew) zziz.zzf(t, j2));
                            break;
                        } else {
                            continue;
                            i12 += 3;
                            i11 = 267386880;
                        }
                    case 11:
                        if (zza((zzho<T>) t, i12)) {
                            zzb3 = zzfn.zzg(i15, zziz.zza(t, j2));
                            break;
                        } else {
                            continue;
                            i12 += 3;
                            i11 = 267386880;
                        }
                    case 12:
                        if (zza((zzho<T>) t, i12)) {
                            zzb3 = zzfn.zzk(i15, zziz.zza(t, j2));
                            break;
                        } else {
                            continue;
                            i12 += 3;
                            i11 = 267386880;
                        }
                    case 13:
                        if (zza((zzho<T>) t, i12)) {
                            zzb3 = zzfn.zzj(i15, 0);
                            break;
                        } else {
                            continue;
                            i12 += 3;
                            i11 = 267386880;
                        }
                    case 14:
                        if (zza((zzho<T>) t, i12)) {
                            zzb3 = zzfn.zzh(i15, 0L);
                            break;
                        } else {
                            continue;
                            i12 += 3;
                            i11 = 267386880;
                        }
                    case 15:
                        if (zza((zzho<T>) t, i12)) {
                            zzb3 = zzfn.zzh(i15, zziz.zza(t, j2));
                            break;
                        } else {
                            continue;
                            i12 += 3;
                            i11 = 267386880;
                        }
                    case 16:
                        if (zza((zzho<T>) t, i12)) {
                            zzb3 = zzfn.zzf(i15, zziz.zzb(t, j2));
                            break;
                        } else {
                            continue;
                            i12 += 3;
                            i11 = 267386880;
                        }
                    case 17:
                        if (zza((zzho<T>) t, i12)) {
                            zzb3 = zzfn.zzc(i15, (zzhk) zziz.zzf(t, j2), zza(i12));
                            break;
                        } else {
                            continue;
                            i12 += 3;
                            i11 = 267386880;
                        }
                    case 18:
                        zzb3 = zzid.zzi(i15, zza(t, j2), false);
                        break;
                    case 19:
                        zzb3 = zzid.zzh(i15, zza(t, j2), false);
                        break;
                    case 20:
                        zzb3 = zzid.zza(i15, (List<Long>) zza(t, j2), false);
                        break;
                    case 21:
                        zzb3 = zzid.zzb(i15, (List<Long>) zza(t, j2), false);
                        break;
                    case 22:
                        zzb3 = zzid.zze(i15, zza(t, j2), false);
                        break;
                    case 23:
                        zzb3 = zzid.zzi(i15, zza(t, j2), false);
                        break;
                    case 24:
                        zzb3 = zzid.zzh(i15, zza(t, j2), false);
                        break;
                    case 25:
                        zzb3 = zzid.zzj(i15, zza(t, j2), false);
                        break;
                    case 26:
                        zzb3 = zzid.zza(i15, zza(t, j2));
                        break;
                    case 27:
                        zzb3 = zzid.zza(i15, zza(t, j2), zza(i12));
                        break;
                    case 28:
                        zzb3 = zzid.zzb(i15, zza(t, j2));
                        break;
                    case 29:
                        zzb3 = zzid.zzf(i15, zza(t, j2), false);
                        break;
                    case 30:
                        zzb3 = zzid.zzd(i15, zza(t, j2), false);
                        break;
                    case 31:
                        zzb3 = zzid.zzh(i15, zza(t, j2), false);
                        break;
                    case 32:
                        zzb3 = zzid.zzi(i15, zza(t, j2), false);
                        break;
                    case 33:
                        zzb3 = zzid.zzg(i15, zza(t, j2), false);
                        break;
                    case 34:
                        zzb3 = zzid.zzc(i15, zza(t, j2), false);
                        break;
                    case 35:
                        i9 = zzid.zzi((List) unsafe.getObject(t, j2));
                        if (i9 > 0) {
                            if (this.zzk) {
                                unsafe.putInt(t, i16, i9);
                            }
                            i10 = zzfn.zze(i15);
                            i8 = zzfn.zzg(i9);
                            zzb3 = i10 + i8 + i9;
                            break;
                        } else {
                            continue;
                            i12 += 3;
                            i11 = 267386880;
                        }
                    case 36:
                        i9 = zzid.zzh((List) unsafe.getObject(t, j2));
                        if (i9 > 0) {
                            if (this.zzk) {
                                unsafe.putInt(t, i16, i9);
                            }
                            i10 = zzfn.zze(i15);
                            i8 = zzfn.zzg(i9);
                            zzb3 = i10 + i8 + i9;
                            break;
                        } else {
                            continue;
                            i12 += 3;
                            i11 = 267386880;
                        }
                    case 37:
                        i9 = zzid.zza((List) unsafe.getObject(t, j2));
                        if (i9 > 0) {
                            if (this.zzk) {
                                unsafe.putInt(t, i16, i9);
                            }
                            i10 = zzfn.zze(i15);
                            i8 = zzfn.zzg(i9);
                            zzb3 = i10 + i8 + i9;
                            break;
                        } else {
                            continue;
                            i12 += 3;
                            i11 = 267386880;
                        }
                    case 38:
                        i9 = zzid.zzb((List) unsafe.getObject(t, j2));
                        if (i9 > 0) {
                            if (this.zzk) {
                                unsafe.putInt(t, i16, i9);
                            }
                            i10 = zzfn.zze(i15);
                            i8 = zzfn.zzg(i9);
                            zzb3 = i10 + i8 + i9;
                            break;
                        } else {
                            continue;
                            i12 += 3;
                            i11 = 267386880;
                        }
                    case 39:
                        i9 = zzid.zze((List) unsafe.getObject(t, j2));
                        if (i9 > 0) {
                            if (this.zzk) {
                                unsafe.putInt(t, i16, i9);
                            }
                            i10 = zzfn.zze(i15);
                            i8 = zzfn.zzg(i9);
                            zzb3 = i10 + i8 + i9;
                            break;
                        } else {
                            continue;
                            i12 += 3;
                            i11 = 267386880;
                        }
                    case 40:
                        i9 = zzid.zzi((List) unsafe.getObject(t, j2));
                        if (i9 > 0) {
                            if (this.zzk) {
                                unsafe.putInt(t, i16, i9);
                            }
                            i10 = zzfn.zze(i15);
                            i8 = zzfn.zzg(i9);
                            zzb3 = i10 + i8 + i9;
                            break;
                        } else {
                            continue;
                            i12 += 3;
                            i11 = 267386880;
                        }
                    case 41:
                        i9 = zzid.zzh((List) unsafe.getObject(t, j2));
                        if (i9 > 0) {
                            if (this.zzk) {
                                unsafe.putInt(t, i16, i9);
                            }
                            i10 = zzfn.zze(i15);
                            i8 = zzfn.zzg(i9);
                            zzb3 = i10 + i8 + i9;
                            break;
                        } else {
                            continue;
                            i12 += 3;
                            i11 = 267386880;
                        }
                    case 42:
                        i9 = zzid.zzj((List) unsafe.getObject(t, j2));
                        if (i9 > 0) {
                            if (this.zzk) {
                                unsafe.putInt(t, i16, i9);
                            }
                            i10 = zzfn.zze(i15);
                            i8 = zzfn.zzg(i9);
                            zzb3 = i10 + i8 + i9;
                            break;
                        } else {
                            continue;
                            i12 += 3;
                            i11 = 267386880;
                        }
                    case 43:
                        i9 = zzid.zzf((List) unsafe.getObject(t, j2));
                        if (i9 > 0) {
                            if (this.zzk) {
                                unsafe.putInt(t, i16, i9);
                            }
                            i10 = zzfn.zze(i15);
                            i8 = zzfn.zzg(i9);
                            zzb3 = i10 + i8 + i9;
                            break;
                        } else {
                            continue;
                            i12 += 3;
                            i11 = 267386880;
                        }
                    case 44:
                        i9 = zzid.zzd((List) unsafe.getObject(t, j2));
                        if (i9 > 0) {
                            if (this.zzk) {
                                unsafe.putInt(t, i16, i9);
                            }
                            i10 = zzfn.zze(i15);
                            i8 = zzfn.zzg(i9);
                            zzb3 = i10 + i8 + i9;
                            break;
                        } else {
                            continue;
                            i12 += 3;
                            i11 = 267386880;
                        }
                    case 45:
                        i9 = zzid.zzh((List) unsafe.getObject(t, j2));
                        if (i9 > 0) {
                            if (this.zzk) {
                                unsafe.putInt(t, i16, i9);
                            }
                            i10 = zzfn.zze(i15);
                            i8 = zzfn.zzg(i9);
                            zzb3 = i10 + i8 + i9;
                            break;
                        } else {
                            continue;
                            i12 += 3;
                            i11 = 267386880;
                        }
                    case 46:
                        i9 = zzid.zzi((List) unsafe.getObject(t, j2));
                        if (i9 > 0) {
                            if (this.zzk) {
                                unsafe.putInt(t, i16, i9);
                            }
                            i10 = zzfn.zze(i15);
                            i8 = zzfn.zzg(i9);
                            zzb3 = i10 + i8 + i9;
                            break;
                        } else {
                            continue;
                            i12 += 3;
                            i11 = 267386880;
                        }
                    case 47:
                        i9 = zzid.zzg((List) unsafe.getObject(t, j2));
                        if (i9 > 0) {
                            if (this.zzk) {
                                unsafe.putInt(t, i16, i9);
                            }
                            i10 = zzfn.zze(i15);
                            i8 = zzfn.zzg(i9);
                            zzb3 = i10 + i8 + i9;
                            break;
                        } else {
                            continue;
                            i12 += 3;
                            i11 = 267386880;
                        }
                    case 48:
                        i9 = zzid.zzc((List) unsafe.getObject(t, j2));
                        if (i9 > 0) {
                            if (this.zzk) {
                                unsafe.putInt(t, i16, i9);
                            }
                            i10 = zzfn.zze(i15);
                            i8 = zzfn.zzg(i9);
                            zzb3 = i10 + i8 + i9;
                            break;
                        } else {
                            continue;
                            i12 += 3;
                            i11 = 267386880;
                        }
                    case 49:
                        zzb3 = zzid.zzb(i15, (List<zzhk>) zza(t, j2), zza(i12));
                        break;
                    case 50:
                        zzb3 = this.zzs.zza(i15, zziz.zzf(t, j2), zzb(i12));
                        break;
                    case 51:
                        if (zza((zzho<T>) t, i15, i12)) {
                            zzb3 = zzfn.zzb(i15, (double) Utils.DOUBLE_EPSILON);
                            break;
                        } else {
                            continue;
                            i12 += 3;
                            i11 = 267386880;
                        }
                    case 52:
                        if (zza((zzho<T>) t, i15, i12)) {
                            zzb3 = zzfn.zzb(i15, 0.0f);
                            break;
                        } else {
                            continue;
                            i12 += 3;
                            i11 = 267386880;
                        }
                    case 53:
                        if (zza((zzho<T>) t, i15, i12)) {
                            zzb3 = zzfn.zzd(i15, zze(t, j2));
                            break;
                        } else {
                            continue;
                            i12 += 3;
                            i11 = 267386880;
                        }
                    case 54:
                        if (zza((zzho<T>) t, i15, i12)) {
                            zzb3 = zzfn.zze(i15, zze(t, j2));
                            break;
                        } else {
                            continue;
                            i12 += 3;
                            i11 = 267386880;
                        }
                    case 55:
                        if (zza((zzho<T>) t, i15, i12)) {
                            zzb3 = zzfn.zzf(i15, zzd(t, j2));
                            break;
                        } else {
                            continue;
                            i12 += 3;
                            i11 = 267386880;
                        }
                    case 56:
                        if (zza((zzho<T>) t, i15, i12)) {
                            zzb3 = zzfn.zzg(i15, 0L);
                            break;
                        } else {
                            continue;
                            i12 += 3;
                            i11 = 267386880;
                        }
                    case 57:
                        if (zza((zzho<T>) t, i15, i12)) {
                            zzb3 = zzfn.zzi(i15, 0);
                            break;
                        } else {
                            continue;
                            i12 += 3;
                            i11 = 267386880;
                        }
                    case 58:
                        if (zza((zzho<T>) t, i15, i12)) {
                            zzb3 = zzfn.zzb(i15, true);
                            break;
                        } else {
                            continue;
                            i12 += 3;
                            i11 = 267386880;
                        }
                    case 59:
                        if (zza((zzho<T>) t, i15, i12)) {
                            Object zzf2 = zziz.zzf(t, j2);
                            if (zzf2 instanceof zzew) {
                                zzb3 = zzfn.zzc(i15, (zzew) zzf2);
                                break;
                            } else {
                                zzb3 = zzfn.zzb(i15, (String) zzf2);
                                break;
                            }
                        } else {
                            continue;
                            i12 += 3;
                            i11 = 267386880;
                        }
                    case 60:
                        if (zza((zzho<T>) t, i15, i12)) {
                            zzb3 = zzid.zza(i15, zziz.zzf(t, j2), zza(i12));
                            break;
                        } else {
                            continue;
                            i12 += 3;
                            i11 = 267386880;
                        }
                    case 61:
                        if (zza((zzho<T>) t, i15, i12)) {
                            zzb3 = zzfn.zzc(i15, (zzew) zziz.zzf(t, j2));
                            break;
                        } else {
                            continue;
                            i12 += 3;
                            i11 = 267386880;
                        }
                    case 62:
                        if (zza((zzho<T>) t, i15, i12)) {
                            zzb3 = zzfn.zzg(i15, zzd(t, j2));
                            break;
                        } else {
                            continue;
                            i12 += 3;
                            i11 = 267386880;
                        }
                    case 63:
                        if (zza((zzho<T>) t, i15, i12)) {
                            zzb3 = zzfn.zzk(i15, zzd(t, j2));
                            break;
                        } else {
                            continue;
                            i12 += 3;
                            i11 = 267386880;
                        }
                    case 64:
                        if (zza((zzho<T>) t, i15, i12)) {
                            zzb3 = zzfn.zzj(i15, 0);
                            break;
                        } else {
                            continue;
                            i12 += 3;
                            i11 = 267386880;
                        }
                    case 65:
                        if (zza((zzho<T>) t, i15, i12)) {
                            zzb3 = zzfn.zzh(i15, 0L);
                            break;
                        } else {
                            continue;
                            i12 += 3;
                            i11 = 267386880;
                        }
                    case 66:
                        if (zza((zzho<T>) t, i15, i12)) {
                            zzb3 = zzfn.zzh(i15, zzd(t, j2));
                            break;
                        } else {
                            continue;
                            i12 += 3;
                            i11 = 267386880;
                        }
                    case 67:
                        if (zza((zzho<T>) t, i15, i12)) {
                            zzb3 = zzfn.zzf(i15, zze(t, j2));
                            break;
                        } else {
                            continue;
                            i12 += 3;
                            i11 = 267386880;
                        }
                    case 68:
                        if (zza((zzho<T>) t, i15, i12)) {
                            zzb3 = zzfn.zzc(i15, (zzhk) zziz.zzf(t, j2), zza(i12));
                            break;
                        } else {
                            continue;
                            i12 += 3;
                            i11 = 267386880;
                        }
                    default:
                        i12 += 3;
                        i11 = 267386880;
                }
                i13 += zzb3;
                i12 += 3;
                i11 = 267386880;
            }
            return i13 + zza((zzit) this.zzq, (Object) t);
        }
        Unsafe unsafe2 = zzb;
        int i17 = 0;
        int i18 = 1048575;
        int i19 = 0;
        for (int i20 = 0; i20 < this.zzc.length; i20 += 3) {
            int zzc2 = zzc(i20);
            int[] iArr = this.zzc;
            int i21 = iArr[i20];
            int i22 = (zzc2 & 267386880) >>> 20;
            if (i22 <= 17) {
                int i23 = iArr[i20 + 2];
                int i24 = i23 & 1048575;
                i = 1 << (i23 >>> 20);
                if (i24 != i18) {
                    i19 = unsafe2.getInt(t, i24);
                    i18 = i24;
                }
                i2 = i23;
            } else {
                i2 = (!this.zzk || i22 < zzfx.DOUBLE_LIST_PACKED.zza() || i22 > zzfx.SINT64_LIST_PACKED.zza()) ? 0 : this.zzc[i20 + 2] & 1048575;
                i = 0;
            }
            long j3 = zzc2 & 1048575;
            switch (i22) {
                case 0:
                    j = 0;
                    if ((i19 & i) != 0) {
                        i17 += zzfn.zzb(i21, (double) Utils.DOUBLE_EPSILON);
                        break;
                    }
                    break;
                case 1:
                    j = 0;
                    if ((i19 & i) != 0) {
                        i17 += zzfn.zzb(i21, 0.0f);
                        break;
                    }
                case 2:
                    j = 0;
                    if ((i19 & i) != 0) {
                        i3 = zzfn.zzd(i21, unsafe2.getLong(t, j3));
                        i17 += i3;
                    }
                    break;
                case 3:
                    j = 0;
                    if ((i19 & i) != 0) {
                        i3 = zzfn.zze(i21, unsafe2.getLong(t, j3));
                        i17 += i3;
                    }
                    break;
                case 4:
                    j = 0;
                    if ((i19 & i) != 0) {
                        i3 = zzfn.zzf(i21, unsafe2.getInt(t, j3));
                        i17 += i3;
                    }
                    break;
                case 5:
                    j = 0;
                    if ((i19 & i) != 0) {
                        i3 = zzfn.zzg(i21, 0L);
                        i17 += i3;
                    }
                    break;
                case 6:
                    if ((i19 & i) != 0) {
                        i17 += zzfn.zzi(i21, 0);
                        j = 0;
                        break;
                    }
                    j = 0;
                case 7:
                    if ((i19 & i) != 0) {
                        zzb2 = zzfn.zzb(i21, true);
                        i17 += zzb2;
                    }
                    j = 0;
                    break;
                case 8:
                    if ((i19 & i) != 0) {
                        Object object = unsafe2.getObject(t, j3);
                        if (object instanceof zzew) {
                            zzb2 = zzfn.zzc(i21, (zzew) object);
                        } else {
                            zzb2 = zzfn.zzb(i21, (String) object);
                        }
                        i17 += zzb2;
                    }
                    j = 0;
                    break;
                case 9:
                    if ((i19 & i) != 0) {
                        zzb2 = zzid.zza(i21, unsafe2.getObject(t, j3), zza(i20));
                        i17 += zzb2;
                    }
                    j = 0;
                    break;
                case 10:
                    if ((i19 & i) != 0) {
                        zzb2 = zzfn.zzc(i21, (zzew) unsafe2.getObject(t, j3));
                        i17 += zzb2;
                    }
                    j = 0;
                    break;
                case 11:
                    if ((i19 & i) != 0) {
                        zzb2 = zzfn.zzg(i21, unsafe2.getInt(t, j3));
                        i17 += zzb2;
                    }
                    j = 0;
                    break;
                case 12:
                    if ((i19 & i) != 0) {
                        zzb2 = zzfn.zzk(i21, unsafe2.getInt(t, j3));
                        i17 += zzb2;
                    }
                    j = 0;
                    break;
                case 13:
                    if ((i19 & i) != 0) {
                        i4 = zzfn.zzj(i21, 0);
                        i17 += i4;
                    }
                    j = 0;
                    break;
                case 14:
                    if ((i19 & i) != 0) {
                        zzb2 = zzfn.zzh(i21, 0L);
                        i17 += zzb2;
                    }
                    j = 0;
                    break;
                case 15:
                    if ((i19 & i) != 0) {
                        zzb2 = zzfn.zzh(i21, unsafe2.getInt(t, j3));
                        i17 += zzb2;
                    }
                    j = 0;
                    break;
                case 16:
                    if ((i19 & i) != 0) {
                        zzb2 = zzfn.zzf(i21, unsafe2.getLong(t, j3));
                        i17 += zzb2;
                    }
                    j = 0;
                    break;
                case 17:
                    if ((i19 & i) != 0) {
                        zzb2 = zzfn.zzc(i21, (zzhk) unsafe2.getObject(t, j3), zza(i20));
                        i17 += zzb2;
                    }
                    j = 0;
                    break;
                case 18:
                    zzb2 = zzid.zzi(i21, (List) unsafe2.getObject(t, j3), false);
                    i17 += zzb2;
                    j = 0;
                    break;
                case 19:
                    zzb2 = zzid.zzh(i21, (List) unsafe2.getObject(t, j3), false);
                    i17 += zzb2;
                    j = 0;
                    break;
                case 20:
                    zzb2 = zzid.zza(i21, (List<Long>) unsafe2.getObject(t, j3), false);
                    i17 += zzb2;
                    j = 0;
                    break;
                case 21:
                    zzb2 = zzid.zzb(i21, (List<Long>) unsafe2.getObject(t, j3), false);
                    i17 += zzb2;
                    j = 0;
                    break;
                case 22:
                    zzb2 = zzid.zze(i21, (List) unsafe2.getObject(t, j3), false);
                    i17 += zzb2;
                    j = 0;
                    break;
                case 23:
                    zzb2 = zzid.zzi(i21, (List) unsafe2.getObject(t, j3), false);
                    i17 += zzb2;
                    j = 0;
                    break;
                case 24:
                    zzb2 = zzid.zzh(i21, (List) unsafe2.getObject(t, j3), false);
                    i17 += zzb2;
                    j = 0;
                    break;
                case 25:
                    zzb2 = zzid.zzj(i21, (List) unsafe2.getObject(t, j3), false);
                    i17 += zzb2;
                    j = 0;
                    break;
                case 26:
                    zzb2 = zzid.zza(i21, (List) unsafe2.getObject(t, j3));
                    i17 += zzb2;
                    j = 0;
                    break;
                case 27:
                    zzb2 = zzid.zza(i21, (List<?>) unsafe2.getObject(t, j3), zza(i20));
                    i17 += zzb2;
                    j = 0;
                    break;
                case 28:
                    zzb2 = zzid.zzb(i21, (List) unsafe2.getObject(t, j3));
                    i17 += zzb2;
                    j = 0;
                    break;
                case 29:
                    zzb2 = zzid.zzf(i21, (List) unsafe2.getObject(t, j3), false);
                    i17 += zzb2;
                    j = 0;
                    break;
                case 30:
                    zzb2 = zzid.zzd(i21, (List) unsafe2.getObject(t, j3), false);
                    i17 += zzb2;
                    j = 0;
                    break;
                case 31:
                    zzb2 = zzid.zzh(i21, (List) unsafe2.getObject(t, j3), false);
                    i17 += zzb2;
                    j = 0;
                    break;
                case 32:
                    zzb2 = zzid.zzi(i21, (List) unsafe2.getObject(t, j3), false);
                    i17 += zzb2;
                    j = 0;
                    break;
                case 33:
                    zzb2 = zzid.zzg(i21, (List) unsafe2.getObject(t, j3), false);
                    i17 += zzb2;
                    j = 0;
                    break;
                case 34:
                    zzb2 = zzid.zzc(i21, (List) unsafe2.getObject(t, j3), false);
                    i17 += zzb2;
                    j = 0;
                    break;
                case 35:
                    i7 = zzid.zzi((List) unsafe2.getObject(t, j3));
                    if (i7 > 0) {
                        if (this.zzk) {
                            unsafe2.putInt(t, i2, i7);
                        }
                        i6 = zzfn.zze(i21);
                        i5 = zzfn.zzg(i7);
                        i4 = i6 + i5 + i7;
                        i17 += i4;
                    }
                    j = 0;
                    break;
                case 36:
                    i7 = zzid.zzh((List) unsafe2.getObject(t, j3));
                    if (i7 > 0) {
                        if (this.zzk) {
                            unsafe2.putInt(t, i2, i7);
                        }
                        i6 = zzfn.zze(i21);
                        i5 = zzfn.zzg(i7);
                        i4 = i6 + i5 + i7;
                        i17 += i4;
                    }
                    j = 0;
                    break;
                case 37:
                    i7 = zzid.zza((List) unsafe2.getObject(t, j3));
                    if (i7 > 0) {
                        if (this.zzk) {
                            unsafe2.putInt(t, i2, i7);
                        }
                        i6 = zzfn.zze(i21);
                        i5 = zzfn.zzg(i7);
                        i4 = i6 + i5 + i7;
                        i17 += i4;
                    }
                    j = 0;
                    break;
                case 38:
                    i7 = zzid.zzb((List) unsafe2.getObject(t, j3));
                    if (i7 > 0) {
                        if (this.zzk) {
                            unsafe2.putInt(t, i2, i7);
                        }
                        i6 = zzfn.zze(i21);
                        i5 = zzfn.zzg(i7);
                        i4 = i6 + i5 + i7;
                        i17 += i4;
                    }
                    j = 0;
                    break;
                case 39:
                    i7 = zzid.zze((List) unsafe2.getObject(t, j3));
                    if (i7 > 0) {
                        if (this.zzk) {
                            unsafe2.putInt(t, i2, i7);
                        }
                        i6 = zzfn.zze(i21);
                        i5 = zzfn.zzg(i7);
                        i4 = i6 + i5 + i7;
                        i17 += i4;
                    }
                    j = 0;
                    break;
                case 40:
                    i7 = zzid.zzi((List) unsafe2.getObject(t, j3));
                    if (i7 > 0) {
                        if (this.zzk) {
                            unsafe2.putInt(t, i2, i7);
                        }
                        i6 = zzfn.zze(i21);
                        i5 = zzfn.zzg(i7);
                        i4 = i6 + i5 + i7;
                        i17 += i4;
                    }
                    j = 0;
                    break;
                case 41:
                    i7 = zzid.zzh((List) unsafe2.getObject(t, j3));
                    if (i7 > 0) {
                        if (this.zzk) {
                            unsafe2.putInt(t, i2, i7);
                        }
                        i6 = zzfn.zze(i21);
                        i5 = zzfn.zzg(i7);
                        i4 = i6 + i5 + i7;
                        i17 += i4;
                    }
                    j = 0;
                    break;
                case 42:
                    i7 = zzid.zzj((List) unsafe2.getObject(t, j3));
                    if (i7 > 0) {
                        if (this.zzk) {
                            unsafe2.putInt(t, i2, i7);
                        }
                        i6 = zzfn.zze(i21);
                        i5 = zzfn.zzg(i7);
                        i4 = i6 + i5 + i7;
                        i17 += i4;
                    }
                    j = 0;
                    break;
                case 43:
                    i7 = zzid.zzf((List) unsafe2.getObject(t, j3));
                    if (i7 > 0) {
                        if (this.zzk) {
                            unsafe2.putInt(t, i2, i7);
                        }
                        i6 = zzfn.zze(i21);
                        i5 = zzfn.zzg(i7);
                        i4 = i6 + i5 + i7;
                        i17 += i4;
                    }
                    j = 0;
                    break;
                case 44:
                    i7 = zzid.zzd((List) unsafe2.getObject(t, j3));
                    if (i7 > 0) {
                        if (this.zzk) {
                            unsafe2.putInt(t, i2, i7);
                        }
                        i6 = zzfn.zze(i21);
                        i5 = zzfn.zzg(i7);
                        i4 = i6 + i5 + i7;
                        i17 += i4;
                    }
                    j = 0;
                    break;
                case 45:
                    i7 = zzid.zzh((List) unsafe2.getObject(t, j3));
                    if (i7 > 0) {
                        if (this.zzk) {
                            unsafe2.putInt(t, i2, i7);
                        }
                        i6 = zzfn.zze(i21);
                        i5 = zzfn.zzg(i7);
                        i4 = i6 + i5 + i7;
                        i17 += i4;
                    }
                    j = 0;
                    break;
                case 46:
                    i7 = zzid.zzi((List) unsafe2.getObject(t, j3));
                    if (i7 > 0) {
                        if (this.zzk) {
                            unsafe2.putInt(t, i2, i7);
                        }
                        i6 = zzfn.zze(i21);
                        i5 = zzfn.zzg(i7);
                        i4 = i6 + i5 + i7;
                        i17 += i4;
                    }
                    j = 0;
                    break;
                case 47:
                    i7 = zzid.zzg((List) unsafe2.getObject(t, j3));
                    if (i7 > 0) {
                        if (this.zzk) {
                            unsafe2.putInt(t, i2, i7);
                        }
                        i6 = zzfn.zze(i21);
                        i5 = zzfn.zzg(i7);
                        i4 = i6 + i5 + i7;
                        i17 += i4;
                    }
                    j = 0;
                    break;
                case 48:
                    i7 = zzid.zzc((List) unsafe2.getObject(t, j3));
                    if (i7 > 0) {
                        if (this.zzk) {
                            unsafe2.putInt(t, i2, i7);
                        }
                        i6 = zzfn.zze(i21);
                        i5 = zzfn.zzg(i7);
                        i4 = i6 + i5 + i7;
                        i17 += i4;
                    }
                    j = 0;
                    break;
                case 49:
                    zzb2 = zzid.zzb(i21, (List) unsafe2.getObject(t, j3), zza(i20));
                    i17 += zzb2;
                    j = 0;
                    break;
                case 50:
                    zzb2 = this.zzs.zza(i21, unsafe2.getObject(t, j3), zzb(i20));
                    i17 += zzb2;
                    j = 0;
                    break;
                case 51:
                    if (zza((zzho<T>) t, i21, i20)) {
                        zzb2 = zzfn.zzb(i21, (double) Utils.DOUBLE_EPSILON);
                        i17 += zzb2;
                    }
                    j = 0;
                    break;
                case 52:
                    if (zza((zzho<T>) t, i21, i20)) {
                        i4 = zzfn.zzb(i21, 0.0f);
                        i17 += i4;
                    }
                    j = 0;
                    break;
                case 53:
                    if (zza((zzho<T>) t, i21, i20)) {
                        zzb2 = zzfn.zzd(i21, zze(t, j3));
                        i17 += zzb2;
                    }
                    j = 0;
                    break;
                case 54:
                    if (zza((zzho<T>) t, i21, i20)) {
                        zzb2 = zzfn.zze(i21, zze(t, j3));
                        i17 += zzb2;
                    }
                    j = 0;
                    break;
                case 55:
                    if (zza((zzho<T>) t, i21, i20)) {
                        zzb2 = zzfn.zzf(i21, zzd(t, j3));
                        i17 += zzb2;
                    }
                    j = 0;
                    break;
                case 56:
                    if (zza((zzho<T>) t, i21, i20)) {
                        zzb2 = zzfn.zzg(i21, 0L);
                        i17 += zzb2;
                    }
                    j = 0;
                    break;
                case 57:
                    if (zza((zzho<T>) t, i21, i20)) {
                        i4 = zzfn.zzi(i21, 0);
                        i17 += i4;
                    }
                    j = 0;
                    break;
                case 58:
                    if (zza((zzho<T>) t, i21, i20)) {
                        zzb2 = zzfn.zzb(i21, true);
                        i17 += zzb2;
                    }
                    j = 0;
                    break;
                case 59:
                    if (zza((zzho<T>) t, i21, i20)) {
                        Object object2 = unsafe2.getObject(t, j3);
                        if (object2 instanceof zzew) {
                            zzb2 = zzfn.zzc(i21, (zzew) object2);
                        } else {
                            zzb2 = zzfn.zzb(i21, (String) object2);
                        }
                        i17 += zzb2;
                    }
                    j = 0;
                    break;
                case 60:
                    if (zza((zzho<T>) t, i21, i20)) {
                        zzb2 = zzid.zza(i21, unsafe2.getObject(t, j3), zza(i20));
                        i17 += zzb2;
                    }
                    j = 0;
                    break;
                case 61:
                    if (zza((zzho<T>) t, i21, i20)) {
                        zzb2 = zzfn.zzc(i21, (zzew) unsafe2.getObject(t, j3));
                        i17 += zzb2;
                    }
                    j = 0;
                    break;
                case 62:
                    if (zza((zzho<T>) t, i21, i20)) {
                        zzb2 = zzfn.zzg(i21, zzd(t, j3));
                        i17 += zzb2;
                    }
                    j = 0;
                    break;
                case 63:
                    if (zza((zzho<T>) t, i21, i20)) {
                        zzb2 = zzfn.zzk(i21, zzd(t, j3));
                        i17 += zzb2;
                    }
                    j = 0;
                    break;
                case 64:
                    if (zza((zzho<T>) t, i21, i20)) {
                        i4 = zzfn.zzj(i21, 0);
                        i17 += i4;
                    }
                    j = 0;
                    break;
                case 65:
                    if (zza((zzho<T>) t, i21, i20)) {
                        zzb2 = zzfn.zzh(i21, 0L);
                        i17 += zzb2;
                    }
                    j = 0;
                    break;
                case 66:
                    if (zza((zzho<T>) t, i21, i20)) {
                        zzb2 = zzfn.zzh(i21, zzd(t, j3));
                        i17 += zzb2;
                    }
                    j = 0;
                    break;
                case 67:
                    if (zza((zzho<T>) t, i21, i20)) {
                        zzb2 = zzfn.zzf(i21, zze(t, j3));
                        i17 += zzb2;
                    }
                    j = 0;
                    break;
                case 68:
                    if (zza((zzho<T>) t, i21, i20)) {
                        zzb2 = zzfn.zzc(i21, (zzhk) unsafe2.getObject(t, j3), zza(i20));
                        i17 += zzb2;
                    }
                    j = 0;
                    break;
                default:
                    j = 0;
                    break;
            }
        }
        int i25 = 0;
        int zza2 = i17 + zza((zzit) this.zzq, (Object) t);
        if (!this.zzh) {
            return zza2;
        }
        zzfs<?> zza3 = this.zzr.zza(t);
        for (int i26 = 0; i26 < zza3.zza.zzc(); i26++) {
            Map.Entry<?, Object> zzb4 = zza3.zza.zzb(i26);
            i25 += zzfs.zza((zzfu) zzb4.getKey(), zzb4.getValue());
        }
        for (Map.Entry<?, Object> entry : zza3.zza.zzd()) {
            i25 += zzfs.zza((zzfu) entry.getKey(), entry.getValue());
        }
        return zza2 + i25;
    }

    private static Field zza(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            String name = cls.getName();
            String arrays = Arrays.toString(declaredFields);
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 40 + name.length() + String.valueOf(arrays).length());
            sb.append("Field ");
            sb.append(str);
            sb.append(" for ");
            sb.append(name);
            sb.append(" not found. Known fields are ");
            sb.append(arrays);
            throw new RuntimeException(sb.toString());
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0038, code lost:
        if (com.google.android.gms.internal.mlkit_vision_barcode.zzid.zza(com.google.android.gms.internal.mlkit_vision_barcode.zziz.zzf(r10, r6), com.google.android.gms.internal.mlkit_vision_barcode.zziz.zzf(r11, r6)) != false) goto L_0x01c2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x006a, code lost:
        if (com.google.android.gms.internal.mlkit_vision_barcode.zzid.zza(com.google.android.gms.internal.mlkit_vision_barcode.zziz.zzf(r10, r6), com.google.android.gms.internal.mlkit_vision_barcode.zziz.zzf(r11, r6)) != false) goto L_0x01c2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x007e, code lost:
        if (com.google.android.gms.internal.mlkit_vision_barcode.zziz.zzb(r10, r6) == com.google.android.gms.internal.mlkit_vision_barcode.zziz.zzb(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0090, code lost:
        if (com.google.android.gms.internal.mlkit_vision_barcode.zziz.zza(r10, r6) == com.google.android.gms.internal.mlkit_vision_barcode.zziz.zza(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00a4, code lost:
        if (com.google.android.gms.internal.mlkit_vision_barcode.zziz.zzb(r10, r6) == com.google.android.gms.internal.mlkit_vision_barcode.zziz.zzb(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00b6, code lost:
        if (com.google.android.gms.internal.mlkit_vision_barcode.zziz.zza(r10, r6) == com.google.android.gms.internal.mlkit_vision_barcode.zziz.zza(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00c8, code lost:
        if (com.google.android.gms.internal.mlkit_vision_barcode.zziz.zza(r10, r6) == com.google.android.gms.internal.mlkit_vision_barcode.zziz.zza(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00da, code lost:
        if (com.google.android.gms.internal.mlkit_vision_barcode.zziz.zza(r10, r6) == com.google.android.gms.internal.mlkit_vision_barcode.zziz.zza(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00f0, code lost:
        if (com.google.android.gms.internal.mlkit_vision_barcode.zzid.zza(com.google.android.gms.internal.mlkit_vision_barcode.zziz.zzf(r10, r6), com.google.android.gms.internal.mlkit_vision_barcode.zziz.zzf(r11, r6)) != false) goto L_0x01c2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0106, code lost:
        if (com.google.android.gms.internal.mlkit_vision_barcode.zzid.zza(com.google.android.gms.internal.mlkit_vision_barcode.zziz.zzf(r10, r6), com.google.android.gms.internal.mlkit_vision_barcode.zziz.zzf(r11, r6)) != false) goto L_0x01c2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x011c, code lost:
        if (com.google.android.gms.internal.mlkit_vision_barcode.zzid.zza(com.google.android.gms.internal.mlkit_vision_barcode.zziz.zzf(r10, r6), com.google.android.gms.internal.mlkit_vision_barcode.zziz.zzf(r11, r6)) != false) goto L_0x01c2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x012e, code lost:
        if (com.google.android.gms.internal.mlkit_vision_barcode.zziz.zzc(r10, r6) == com.google.android.gms.internal.mlkit_vision_barcode.zziz.zzc(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0140, code lost:
        if (com.google.android.gms.internal.mlkit_vision_barcode.zziz.zza(r10, r6) == com.google.android.gms.internal.mlkit_vision_barcode.zziz.zza(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0154, code lost:
        if (com.google.android.gms.internal.mlkit_vision_barcode.zziz.zzb(r10, r6) == com.google.android.gms.internal.mlkit_vision_barcode.zziz.zzb(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0165, code lost:
        if (com.google.android.gms.internal.mlkit_vision_barcode.zziz.zza(r10, r6) == com.google.android.gms.internal.mlkit_vision_barcode.zziz.zza(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0178, code lost:
        if (com.google.android.gms.internal.mlkit_vision_barcode.zziz.zzb(r10, r6) == com.google.android.gms.internal.mlkit_vision_barcode.zziz.zzb(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x018b, code lost:
        if (com.google.android.gms.internal.mlkit_vision_barcode.zziz.zzb(r10, r6) == com.google.android.gms.internal.mlkit_vision_barcode.zziz.zzb(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x01a4, code lost:
        if (java.lang.Float.floatToIntBits(com.google.android.gms.internal.mlkit_vision_barcode.zziz.zzd(r10, r6)) == java.lang.Float.floatToIntBits(com.google.android.gms.internal.mlkit_vision_barcode.zziz.zzd(r11, r6))) goto L_0x01c2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x01bf, code lost:
        if (java.lang.Double.doubleToLongBits(com.google.android.gms.internal.mlkit_vision_barcode.zziz.zze(r10, r6)) == java.lang.Double.doubleToLongBits(com.google.android.gms.internal.mlkit_vision_barcode.zziz.zze(r11, r6))) goto L_0x01c2;
     */
    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzib
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean zza(T r10, T r11) {
        /*
            Method dump skipped, instructions count: 640
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_barcode.zzho.zza(java.lang.Object, java.lang.Object):boolean");
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzib
    public final int zza(T t) {
        int i;
        int i2;
        int length = this.zzc.length;
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4 += 3) {
            int zzc = zzc(i4);
            int i5 = this.zzc[i4];
            long j = 1048575 & zzc;
            int i6 = 37;
            switch ((zzc & 267386880) >>> 20) {
                case 0:
                    i2 = i3 * 53;
                    i = zzgc.zza(Double.doubleToLongBits(zziz.zze(t, j)));
                    i3 = i2 + i;
                    break;
                case 1:
                    i2 = i3 * 53;
                    i = Float.floatToIntBits(zziz.zzd(t, j));
                    i3 = i2 + i;
                    break;
                case 2:
                    i2 = i3 * 53;
                    i = zzgc.zza(zziz.zzb(t, j));
                    i3 = i2 + i;
                    break;
                case 3:
                    i2 = i3 * 53;
                    i = zzgc.zza(zziz.zzb(t, j));
                    i3 = i2 + i;
                    break;
                case 4:
                    i2 = i3 * 53;
                    i = zziz.zza(t, j);
                    i3 = i2 + i;
                    break;
                case 5:
                    i2 = i3 * 53;
                    i = zzgc.zza(zziz.zzb(t, j));
                    i3 = i2 + i;
                    break;
                case 6:
                    i2 = i3 * 53;
                    i = zziz.zza(t, j);
                    i3 = i2 + i;
                    break;
                case 7:
                    i2 = i3 * 53;
                    i = zzgc.zza(zziz.zzc(t, j));
                    i3 = i2 + i;
                    break;
                case 8:
                    i2 = i3 * 53;
                    i = ((String) zziz.zzf(t, j)).hashCode();
                    i3 = i2 + i;
                    break;
                case 9:
                    Object zzf = zziz.zzf(t, j);
                    if (zzf != null) {
                        i6 = zzf.hashCode();
                    }
                    i3 = (i3 * 53) + i6;
                    break;
                case 10:
                    i2 = i3 * 53;
                    i = zziz.zzf(t, j).hashCode();
                    i3 = i2 + i;
                    break;
                case 11:
                    i2 = i3 * 53;
                    i = zziz.zza(t, j);
                    i3 = i2 + i;
                    break;
                case 12:
                    i2 = i3 * 53;
                    i = zziz.zza(t, j);
                    i3 = i2 + i;
                    break;
                case 13:
                    i2 = i3 * 53;
                    i = zziz.zza(t, j);
                    i3 = i2 + i;
                    break;
                case 14:
                    i2 = i3 * 53;
                    i = zzgc.zza(zziz.zzb(t, j));
                    i3 = i2 + i;
                    break;
                case 15:
                    i2 = i3 * 53;
                    i = zziz.zza(t, j);
                    i3 = i2 + i;
                    break;
                case 16:
                    i2 = i3 * 53;
                    i = zzgc.zza(zziz.zzb(t, j));
                    i3 = i2 + i;
                    break;
                case 17:
                    Object zzf2 = zziz.zzf(t, j);
                    if (zzf2 != null) {
                        i6 = zzf2.hashCode();
                    }
                    i3 = (i3 * 53) + i6;
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    i2 = i3 * 53;
                    i = zziz.zzf(t, j).hashCode();
                    i3 = i2 + i;
                    break;
                case 50:
                    i2 = i3 * 53;
                    i = zziz.zzf(t, j).hashCode();
                    i3 = i2 + i;
                    break;
                case 51:
                    if (zza((zzho<T>) t, i5, i4)) {
                        i2 = i3 * 53;
                        i = zzgc.zza(Double.doubleToLongBits(zzb(t, j)));
                        i3 = i2 + i;
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (zza((zzho<T>) t, i5, i4)) {
                        i2 = i3 * 53;
                        i = Float.floatToIntBits(zzc(t, j));
                        i3 = i2 + i;
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (zza((zzho<T>) t, i5, i4)) {
                        i2 = i3 * 53;
                        i = zzgc.zza(zze(t, j));
                        i3 = i2 + i;
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (zza((zzho<T>) t, i5, i4)) {
                        i2 = i3 * 53;
                        i = zzgc.zza(zze(t, j));
                        i3 = i2 + i;
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (zza((zzho<T>) t, i5, i4)) {
                        i2 = i3 * 53;
                        i = zzd(t, j);
                        i3 = i2 + i;
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (zza((zzho<T>) t, i5, i4)) {
                        i2 = i3 * 53;
                        i = zzgc.zza(zze(t, j));
                        i3 = i2 + i;
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (zza((zzho<T>) t, i5, i4)) {
                        i2 = i3 * 53;
                        i = zzd(t, j);
                        i3 = i2 + i;
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (zza((zzho<T>) t, i5, i4)) {
                        i2 = i3 * 53;
                        i = zzgc.zza(zzf(t, j));
                        i3 = i2 + i;
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (zza((zzho<T>) t, i5, i4)) {
                        i2 = i3 * 53;
                        i = ((String) zziz.zzf(t, j)).hashCode();
                        i3 = i2 + i;
                        break;
                    } else {
                        break;
                    }
                case 60:
                    if (zza((zzho<T>) t, i5, i4)) {
                        i2 = i3 * 53;
                        i = zziz.zzf(t, j).hashCode();
                        i3 = i2 + i;
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (zza((zzho<T>) t, i5, i4)) {
                        i2 = i3 * 53;
                        i = zziz.zzf(t, j).hashCode();
                        i3 = i2 + i;
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (zza((zzho<T>) t, i5, i4)) {
                        i2 = i3 * 53;
                        i = zzd(t, j);
                        i3 = i2 + i;
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (zza((zzho<T>) t, i5, i4)) {
                        i2 = i3 * 53;
                        i = zzd(t, j);
                        i3 = i2 + i;
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (zza((zzho<T>) t, i5, i4)) {
                        i2 = i3 * 53;
                        i = zzd(t, j);
                        i3 = i2 + i;
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (zza((zzho<T>) t, i5, i4)) {
                        i2 = i3 * 53;
                        i = zzgc.zza(zze(t, j));
                        i3 = i2 + i;
                        break;
                    } else {
                        break;
                    }
                case 66:
                    if (zza((zzho<T>) t, i5, i4)) {
                        i2 = i3 * 53;
                        i = zzd(t, j);
                        i3 = i2 + i;
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (zza((zzho<T>) t, i5, i4)) {
                        i2 = i3 * 53;
                        i = zzgc.zza(zze(t, j));
                        i3 = i2 + i;
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (zza((zzho<T>) t, i5, i4)) {
                        i2 = i3 * 53;
                        i = zziz.zzf(t, j).hashCode();
                        i3 = i2 + i;
                        break;
                    } else {
                        break;
                    }
            }
        }
        int hashCode = (i3 * 53) + this.zzq.zza(t).hashCode();
        return this.zzh ? (hashCode * 53) + this.zzr.zza(t).hashCode() : hashCode;
    }

    private final void zza(T t, T t2, int i) {
        long zzc = zzc(i) & 1048575;
        if (zza((zzho<T>) t2, i)) {
            Object zzf = zziz.zzf(t, zzc);
            Object zzf2 = zziz.zzf(t2, zzc);
            if (zzf != null && zzf2 != null) {
                zziz.zza(t, zzc, zzgc.zza(zzf, zzf2));
                zzb((zzho<T>) t, i);
            } else if (zzf2 != null) {
                zziz.zza(t, zzc, zzf2);
                zzb((zzho<T>) t, i);
            }
        }
    }

    private static <UT, UB> int zza(zzit<UT, UB> zzitVar, T t) {
        return zzitVar.zzd(zzitVar.zza(t));
    }

    private static List<?> zza(Object obj, long j) {
        return (List) zziz.zzf(obj, j);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x0513  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0552  */
    /* JADX WARN: Removed duplicated region for block: B:333:0x0a2a  */
    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzib
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zza(T r14, com.google.android.gms.internal.mlkit_vision_barcode.zzjn r15) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 2916
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_barcode.zzho.zza(java.lang.Object, com.google.android.gms.internal.mlkit_vision_barcode.zzjn):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0495  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void zzb(T r18, com.google.android.gms.internal.mlkit_vision_barcode.zzjn r19) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1342
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_barcode.zzho.zzb(java.lang.Object, com.google.android.gms.internal.mlkit_vision_barcode.zzjn):void");
    }

    private final <K, V> void zza(zzjn zzjnVar, int i, Object obj, int i2) throws IOException {
        if (obj != null) {
            zzjnVar.zza(i, this.zzs.zza(zzb(i2)), this.zzs.zzb(obj));
        }
    }

    private static <UT, UB> void zza(zzit<UT, UB> zzitVar, T t, zzjn zzjnVar) throws IOException {
        zzitVar.zza((zzit<UT, UB>) zzitVar.zza(t), zzjnVar);
    }

    private final zzib zza(int i) {
        int i2 = (i / 3) << 1;
        zzib zzibVar = (zzib) this.zzd[i2];
        if (zzibVar != null) {
            return zzibVar;
        }
        zzib<T> zza2 = zzhw.zza().zza((Class) ((Class) this.zzd[i2 + 1]));
        this.zzd[i2] = zza2;
        return zza2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean zza(Object obj, int i, zzib zzibVar) {
        return zzibVar.zzd(zziz.zzf(obj, i & 1048575));
    }

    private static void zza(int i, Object obj, zzjn zzjnVar) throws IOException {
        if (obj instanceof String) {
            zzjnVar.zza(i, (String) obj);
        } else {
            zzjnVar.zza(i, (zzew) obj);
        }
    }

    private final boolean zza(T t, int i, int i2, int i3, int i4) {
        if (i2 == 1048575) {
            return zza((zzho<T>) t, i);
        }
        return (i3 & i4) != 0;
    }

    private final boolean zza(T t, int i) {
        int zzd = zzd(i);
        long j = zzd & 1048575;
        if (j == 1048575) {
            int zzc = zzc(i);
            long j2 = zzc & 1048575;
            switch ((zzc & 267386880) >>> 20) {
                case 0:
                    return zziz.zze(t, j2) != Utils.DOUBLE_EPSILON;
                case 1:
                    return zziz.zzd(t, j2) != 0.0f;
                case 2:
                    return zziz.zzb(t, j2) != 0;
                case 3:
                    return zziz.zzb(t, j2) != 0;
                case 4:
                    return zziz.zza(t, j2) != 0;
                case 5:
                    return zziz.zzb(t, j2) != 0;
                case 6:
                    return zziz.zza(t, j2) != 0;
                case 7:
                    return zziz.zzc(t, j2);
                case 8:
                    Object zzf = zziz.zzf(t, j2);
                    if (zzf instanceof String) {
                        return !((String) zzf).isEmpty();
                    }
                    if (zzf instanceof zzew) {
                        return !zzew.zza.equals(zzf);
                    }
                    throw new IllegalArgumentException();
                case 9:
                    return zziz.zzf(t, j2) != null;
                case 10:
                    return !zzew.zza.equals(zziz.zzf(t, j2));
                case 11:
                    return zziz.zza(t, j2) != 0;
                case 12:
                    return zziz.zza(t, j2) != 0;
                case 13:
                    return zziz.zza(t, j2) != 0;
                case 14:
                    return zziz.zzb(t, j2) != 0;
                case 15:
                    return zziz.zza(t, j2) != 0;
                case 16:
                    return zziz.zzb(t, j2) != 0;
                case 17:
                    return zziz.zzf(t, j2) != null;
                default:
                    throw new IllegalArgumentException();
            }
        } else {
            return (zziz.zza(t, j) & (1 << (zzd >>> 20))) != 0;
        }
    }

    private final Object zzb(int i) {
        return this.zzd[(i / 3) << 1];
    }

    private static <T> double zzb(T t, long j) {
        return ((Double) zziz.zzf(t, j)).doubleValue();
    }

    private final void zzb(T t, int i) {
        int zzd = zzd(i);
        long j = 1048575 & zzd;
        if (j != 1048575) {
            zziz.zza((Object) t, j, (1 << (zzd >>> 20)) | zziz.zza(t, j));
        }
    }

    private final void zzb(T t, int i, int i2) {
        zziz.zza((Object) t, zzd(i2) & 1048575, i);
    }

    private final boolean zza(T t, int i, int i2) {
        return zziz.zza(t, (long) (zzd(i2) & 1048575)) == i;
    }
}