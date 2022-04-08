package com.google.android.gms.internal.vision;

import java.io.IOException;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
/* loaded from: classes.dex */
public abstract class zzgf extends zzfn {
    private static final Logger logger = Logger.getLogger(zzgf.class.getName());
    private static final boolean zztg = zzju.zzik();
    zzgh zzth;

    /* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
    /* loaded from: classes.dex */
    public static class zza extends IOException {
        zza() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }

        zza(Throwable th) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.", th);
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        zza(java.lang.String r3, java.lang.Throwable r4) {
            /*
                r2 = this;
                java.lang.String r0 = "CodedOutputStream was writing to a flat byte array and ran out of space.: "
                java.lang.String r3 = java.lang.String.valueOf(r3)
                int r1 = r3.length()
                if (r1 == 0) goto L_0x0011
                java.lang.String r3 = r0.concat(r3)
                goto L_0x0016
            L_0x0011:
                java.lang.String r3 = new java.lang.String
                r3.<init>(r0)
            L_0x0016:
                r2.<init>(r3, r4)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.zzgf.zza.<init>(java.lang.String, java.lang.Throwable):void");
        }
    }

    private zzgf() {
    }

    private static long zzaa(long j) {
        return (j >> 63) ^ (j << 1);
    }

    public static int zzb(double d2) {
        return 8;
    }

    public static int zzbb(int i) {
        return zzbd(i << 3);
    }

    public static int zzbc(int i) {
        if (i >= 0) {
            return zzbd(i);
        }
        return 10;
    }

    public static int zzbd(int i) {
        if ((i & (-128)) == 0) {
            return 1;
        }
        if ((i & (-16384)) == 0) {
            return 2;
        }
        if (((-2097152) & i) == 0) {
            return 3;
        }
        return (i & (-268435456)) == 0 ? 4 : 5;
    }

    public static int zzbe(int i) {
        return zzbd(zzbi(i));
    }

    public static int zzbf(int i) {
        return 4;
    }

    public static int zzbg(int i) {
        return 4;
    }

    public static int zzbh(int i) {
        return zzbc(i);
    }

    private static int zzbi(int i) {
        return (i >> 31) ^ (i << 1);
    }

    @Deprecated
    public static int zzbj(int i) {
        return zzbd(i);
    }

    public static int zzc(int i, zzfm zzfmVar) {
        int zzbb = zzbb(i);
        int size = zzfmVar.size();
        return zzbb + zzbd(size) + size;
    }

    public static int zzd(int i, long j) {
        return zzbb(i) + zzw(j);
    }

    public static zzgf zze(byte[] bArr) {
        return new zzb(bArr, 0, bArr.length);
    }

    public static int zzf(int i, long j) {
        return zzbb(i) + zzw(zzaa(j));
    }

    public static int zzg(int i, long j) {
        return zzbb(i) + 8;
    }

    public static int zzh(int i, long j) {
        return zzbb(i) + 8;
    }

    public static int zzl(int i, int i2) {
        return zzbb(i) + zzbc(i2);
    }

    public static int zzl(boolean z) {
        return 1;
    }

    public static int zzm(int i, int i2) {
        return zzbb(i) + zzbd(i2);
    }

    public static int zzn(int i, int i2) {
        return zzbb(i) + zzbd(zzbi(i2));
    }

    public static int zzo(int i, int i2) {
        return zzbb(i) + 4;
    }

    public static int zzp(int i, int i2) {
        return zzbb(i) + 4;
    }

    public static int zzq(int i, int i2) {
        return zzbb(i) + zzbc(i2);
    }

    public static int zzt(float f2) {
        return 4;
    }

    public static int zzv(long j) {
        return zzw(j);
    }

    public static int zzw(long j) {
        int i;
        if (((-128) & j) == 0) {
            return 1;
        }
        if (j < 0) {
            return 10;
        }
        if (((-34359738368L) & j) != 0) {
            i = 6;
            j >>>= 28;
        } else {
            i = 2;
        }
        if (((-2097152) & j) != 0) {
            i += 2;
            j >>>= 14;
        }
        return (j & (-16384)) != 0 ? i + 1 : i;
    }

    public static int zzx(long j) {
        return zzw(zzaa(j));
    }

    public static int zzy(long j) {
        return 8;
    }

    public static int zzy(String str) {
        int i;
        try {
            i = zzjx.zza(str);
        } catch (zzka unused) {
            i = str.getBytes(zzgy.UTF_8).length;
        }
        return zzbd(i) + i;
    }

    public static int zzz(long j) {
        return 8;
    }

    public abstract void writeTag(int i, int i2) throws IOException;

    public final void zza(int i, float f2) throws IOException {
        zzk(i, Float.floatToRawIntBits(f2));
    }

    public abstract void zza(int i, long j) throws IOException;

    public abstract void zza(int i, zzfm zzfmVar) throws IOException;

    public abstract void zza(int i, zzih zzihVar) throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void zza(int i, zzih zzihVar, zziw zziwVar) throws IOException;

    public abstract void zza(int i, String str) throws IOException;

    public abstract void zza(int i, boolean z) throws IOException;

    public abstract void zza(zzfm zzfmVar) throws IOException;

    public abstract void zzax(int i) throws IOException;

    public abstract void zzay(int i) throws IOException;

    public final void zzaz(int i) throws IOException {
        zzay(zzbi(i));
    }

    public final void zzb(int i, long j) throws IOException {
        zza(i, zzaa(j));
    }

    public abstract void zzb(int i, zzfm zzfmVar) throws IOException;

    public abstract void zzb(zzih zzihVar) throws IOException;

    public abstract void zzba(int i) throws IOException;

    public abstract void zzc(byte b2) throws IOException;

    public abstract void zzc(int i, long j) throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void zze(byte[] bArr, int i, int i2) throws IOException;

    public abstract int zzfh();

    public final void zzfi() {
        if (zzfh() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    public abstract void zzh(int i, int i2) throws IOException;

    public abstract void zzi(int i, int i2) throws IOException;

    public final void zzj(int i, int i2) throws IOException {
        zzi(i, zzbi(i2));
    }

    public abstract void zzk(int i, int i2) throws IOException;

    public final void zzk(boolean z) throws IOException {
        zzc(z ? (byte) 1 : (byte) 0);
    }

    public final void zzs(float f2) throws IOException {
        zzba(Float.floatToRawIntBits(f2));
    }

    public abstract void zzs(long j) throws IOException;

    public final void zzt(long j) throws IOException {
        zzs(zzaa(j));
    }

    public abstract void zzu(long j) throws IOException;

    public abstract void zzx(String str) throws IOException;

    /* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
    /* loaded from: classes.dex */
    static class zzb extends zzgf {
        private final byte[] buffer;
        private final int limit;
        private final int offset;
        private int position;

        zzb(byte[] bArr, int i, int i2) {
            super();
            Objects.requireNonNull(bArr, "buffer");
            int i3 = i2 + 0;
            if ((i2 | 0 | (bArr.length - i3)) >= 0) {
                this.buffer = bArr;
                this.offset = 0;
                this.position = 0;
                this.limit = i3;
                return;
            }
            throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", Integer.valueOf(bArr.length), 0, Integer.valueOf(i2)));
        }

        private final void write(byte[] bArr, int i, int i2) throws IOException {
            try {
                System.arraycopy(bArr, i, this.buffer, this.position, i2);
                this.position += i2;
            } catch (IndexOutOfBoundsException e2) {
                throw new zza(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.position), Integer.valueOf(this.limit), Integer.valueOf(i2)), e2);
            }
        }

        @Override // com.google.android.gms.internal.vision.zzgf
        public final void writeTag(int i, int i2) throws IOException {
            zzay((i << 3) | i2);
        }

        @Override // com.google.android.gms.internal.vision.zzgf
        public final void zza(int i, long j) throws IOException {
            writeTag(i, 0);
            zzs(j);
        }

        @Override // com.google.android.gms.internal.vision.zzgf
        public final void zzax(int i) throws IOException {
            if (i >= 0) {
                zzay(i);
            } else {
                zzs(i);
            }
        }

        @Override // com.google.android.gms.internal.vision.zzgf
        public final void zzay(int i) throws IOException {
            if (!zzgf.zztg || zzff.zzds() || zzfh() < 5) {
                while ((i & (-128)) != 0) {
                    try {
                        byte[] bArr = this.buffer;
                        int i2 = this.position;
                        this.position = i2 + 1;
                        bArr[i2] = (byte) ((i & 127) | 128);
                        i >>>= 7;
                    } catch (IndexOutOfBoundsException e2) {
                        throw new zza(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.position), Integer.valueOf(this.limit), 1), e2);
                    }
                }
                byte[] bArr2 = this.buffer;
                int i3 = this.position;
                this.position = i3 + 1;
                bArr2[i3] = (byte) i;
            } else if ((i & (-128)) == 0) {
                byte[] bArr3 = this.buffer;
                int i4 = this.position;
                this.position = i4 + 1;
                zzju.zza(bArr3, i4, (byte) i);
            } else {
                byte[] bArr4 = this.buffer;
                int i5 = this.position;
                this.position = i5 + 1;
                zzju.zza(bArr4, i5, (byte) (i | 128));
                int i6 = i >>> 7;
                if ((i6 & (-128)) == 0) {
                    byte[] bArr5 = this.buffer;
                    int i7 = this.position;
                    this.position = i7 + 1;
                    zzju.zza(bArr5, i7, (byte) i6);
                    return;
                }
                byte[] bArr6 = this.buffer;
                int i8 = this.position;
                this.position = i8 + 1;
                zzju.zza(bArr6, i8, (byte) (i6 | 128));
                int i9 = i6 >>> 7;
                if ((i9 & (-128)) == 0) {
                    byte[] bArr7 = this.buffer;
                    int i10 = this.position;
                    this.position = i10 + 1;
                    zzju.zza(bArr7, i10, (byte) i9);
                    return;
                }
                byte[] bArr8 = this.buffer;
                int i11 = this.position;
                this.position = i11 + 1;
                zzju.zza(bArr8, i11, (byte) (i9 | 128));
                int i12 = i9 >>> 7;
                if ((i12 & (-128)) == 0) {
                    byte[] bArr9 = this.buffer;
                    int i13 = this.position;
                    this.position = i13 + 1;
                    zzju.zza(bArr9, i13, (byte) i12);
                    return;
                }
                byte[] bArr10 = this.buffer;
                int i14 = this.position;
                this.position = i14 + 1;
                zzju.zza(bArr10, i14, (byte) (i12 | 128));
                byte[] bArr11 = this.buffer;
                int i15 = this.position;
                this.position = i15 + 1;
                zzju.zza(bArr11, i15, (byte) (i12 >>> 7));
            }
        }

        @Override // com.google.android.gms.internal.vision.zzgf
        public final void zzb(int i, zzfm zzfmVar) throws IOException {
            writeTag(1, 3);
            zzi(2, i);
            zza(3, zzfmVar);
            writeTag(1, 4);
        }

        @Override // com.google.android.gms.internal.vision.zzgf
        public final void zzba(int i) throws IOException {
            try {
                byte[] bArr = this.buffer;
                int i2 = this.position;
                int i3 = i2 + 1;
                this.position = i3;
                bArr[i2] = (byte) i;
                int i4 = i3 + 1;
                this.position = i4;
                bArr[i3] = (byte) (i >> 8);
                int i5 = i4 + 1;
                this.position = i5;
                bArr[i4] = (byte) (i >> 16);
                this.position = i5 + 1;
                bArr[i5] = (byte) (i >>> 24);
            } catch (IndexOutOfBoundsException e2) {
                throw new zza(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.position), Integer.valueOf(this.limit), 1), e2);
            }
        }

        @Override // com.google.android.gms.internal.vision.zzgf
        public final void zzc(int i, long j) throws IOException {
            writeTag(i, 1);
            zzu(j);
        }

        @Override // com.google.android.gms.internal.vision.zzgf
        public final void zze(byte[] bArr, int i, int i2) throws IOException {
            zzay(i2);
            write(bArr, 0, i2);
        }

        @Override // com.google.android.gms.internal.vision.zzgf
        public final int zzfh() {
            return this.limit - this.position;
        }

        @Override // com.google.android.gms.internal.vision.zzgf
        public final void zzh(int i, int i2) throws IOException {
            writeTag(i, 0);
            zzax(i2);
        }

        @Override // com.google.android.gms.internal.vision.zzgf
        public final void zzi(int i, int i2) throws IOException {
            writeTag(i, 0);
            zzay(i2);
        }

        @Override // com.google.android.gms.internal.vision.zzgf
        public final void zzk(int i, int i2) throws IOException {
            writeTag(i, 5);
            zzba(i2);
        }

        @Override // com.google.android.gms.internal.vision.zzgf
        public final void zzs(long j) throws IOException {
            if (!zzgf.zztg || zzfh() < 10) {
                while ((j & (-128)) != 0) {
                    try {
                        byte[] bArr = this.buffer;
                        int i = this.position;
                        this.position = i + 1;
                        bArr[i] = (byte) ((((int) j) & 127) | 128);
                        j >>>= 7;
                    } catch (IndexOutOfBoundsException e2) {
                        throw new zza(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.position), Integer.valueOf(this.limit), 1), e2);
                    }
                }
                byte[] bArr2 = this.buffer;
                int i2 = this.position;
                this.position = i2 + 1;
                bArr2[i2] = (byte) j;
                return;
            }
            while ((j & (-128)) != 0) {
                byte[] bArr3 = this.buffer;
                int i3 = this.position;
                this.position = i3 + 1;
                zzju.zza(bArr3, i3, (byte) ((((int) j) & 127) | 128));
                j >>>= 7;
            }
            byte[] bArr4 = this.buffer;
            int i4 = this.position;
            this.position = i4 + 1;
            zzju.zza(bArr4, i4, (byte) j);
        }

        @Override // com.google.android.gms.internal.vision.zzgf
        public final void zzu(long j) throws IOException {
            try {
                byte[] bArr = this.buffer;
                int i = this.position;
                int i2 = i + 1;
                this.position = i2;
                bArr[i] = (byte) j;
                int i3 = i2 + 1;
                this.position = i3;
                bArr[i2] = (byte) (j >> 8);
                int i4 = i3 + 1;
                this.position = i4;
                bArr[i3] = (byte) (j >> 16);
                int i5 = i4 + 1;
                this.position = i5;
                bArr[i4] = (byte) (j >> 24);
                int i6 = i5 + 1;
                this.position = i6;
                bArr[i5] = (byte) (j >> 32);
                int i7 = i6 + 1;
                this.position = i7;
                bArr[i6] = (byte) (j >> 40);
                int i8 = i7 + 1;
                this.position = i8;
                bArr[i7] = (byte) (j >> 48);
                this.position = i8 + 1;
                bArr[i8] = (byte) (j >> 56);
            } catch (IndexOutOfBoundsException e2) {
                throw new zza(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.position), Integer.valueOf(this.limit), 1), e2);
            }
        }

        @Override // com.google.android.gms.internal.vision.zzgf
        public final void zzx(String str) throws IOException {
            int i = this.position;
            try {
                int zzbd = zzgf.zzbd(str.length() * 3);
                int zzbd2 = zzgf.zzbd(str.length());
                if (zzbd2 == zzbd) {
                    int i2 = i + zzbd2;
                    this.position = i2;
                    int zza = zzjx.zza(str, this.buffer, i2, zzfh());
                    this.position = i;
                    zzay((zza - i) - zzbd2);
                    this.position = zza;
                    return;
                }
                zzay(zzjx.zza(str));
                this.position = zzjx.zza(str, this.buffer, this.position, zzfh());
            } catch (zzka e2) {
                this.position = i;
                zza(str, e2);
            } catch (IndexOutOfBoundsException e3) {
                throw new zza(e3);
            }
        }

        @Override // com.google.android.gms.internal.vision.zzgf
        public final void zza(int i, boolean z) throws IOException {
            writeTag(i, 0);
            zzc(z ? (byte) 1 : (byte) 0);
        }

        @Override // com.google.android.gms.internal.vision.zzgf
        public final void zzc(byte b2) throws IOException {
            try {
                byte[] bArr = this.buffer;
                int i = this.position;
                this.position = i + 1;
                bArr[i] = b2;
            } catch (IndexOutOfBoundsException e2) {
                throw new zza(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.position), Integer.valueOf(this.limit), 1), e2);
            }
        }

        @Override // com.google.android.gms.internal.vision.zzgf
        public final void zza(int i, String str) throws IOException {
            writeTag(i, 2);
            zzx(str);
        }

        @Override // com.google.android.gms.internal.vision.zzgf
        public final void zzb(zzih zzihVar) throws IOException {
            zzay(zzihVar.zzgg());
            zzihVar.zzb(this);
        }

        @Override // com.google.android.gms.internal.vision.zzfn
        public final void zzc(byte[] bArr, int i, int i2) throws IOException {
            write(bArr, i, i2);
        }

        @Override // com.google.android.gms.internal.vision.zzgf
        public final void zza(int i, zzfm zzfmVar) throws IOException {
            writeTag(i, 2);
            zza(zzfmVar);
        }

        @Override // com.google.android.gms.internal.vision.zzgf
        public final void zza(zzfm zzfmVar) throws IOException {
            zzay(zzfmVar.size());
            zzfmVar.zza(this);
        }

        @Override // com.google.android.gms.internal.vision.zzgf
        final void zza(int i, zzih zzihVar, zziw zziwVar) throws IOException {
            writeTag(i, 2);
            zzey zzeyVar = (zzey) zzihVar;
            int zzdm = zzeyVar.zzdm();
            if (zzdm == -1) {
                zzdm = zziwVar.zzs(zzeyVar);
                zzeyVar.zzae(zzdm);
            }
            zzay(zzdm);
            zziwVar.zza(zzihVar, this.zzth);
        }

        @Override // com.google.android.gms.internal.vision.zzgf
        public final void zza(int i, zzih zzihVar) throws IOException {
            writeTag(1, 3);
            zzi(2, i);
            writeTag(3, 2);
            zzb(zzihVar);
            writeTag(1, 4);
        }
    }

    public static int zzb(int i, float f2) {
        return zzbb(i) + 4;
    }

    public final void zza(int i, double d2) throws IOException {
        zzc(i, Double.doubleToRawLongBits(d2));
    }

    public static int zzb(int i, double d2) {
        return zzbb(i) + 8;
    }

    public static int zzd(int i, zzfm zzfmVar) {
        return (zzbb(1) << 1) + zzm(2, i) + zzc(3, zzfmVar);
    }

    public static int zze(int i, long j) {
        return zzbb(i) + zzw(j);
    }

    public static int zzf(byte[] bArr) {
        int length = bArr.length;
        return zzbd(length) + length;
    }

    public final void zza(double d2) throws IOException {
        zzu(Double.doubleToRawLongBits(d2));
    }

    public static int zza(int i, zzhm zzhmVar) {
        int zzbb = zzbb(i);
        int zzgg = zzhmVar.zzgg();
        return zzbb + zzbd(zzgg) + zzgg;
    }

    public static int zzb(int i, boolean z) {
        return zzbb(i) + 1;
    }

    public static int zzc(zzih zzihVar) {
        int zzgg = zzihVar.zzgg();
        return zzbd(zzgg) + zzgg;
    }

    public static int zzb(int i, String str) {
        return zzbb(i) + zzy(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzb(int i, zzih zzihVar, zziw zziwVar) {
        return zzbb(i) + zza(zzihVar, zziwVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Deprecated
    public static int zzc(int i, zzih zzihVar, zziw zziwVar) {
        int zzbb = zzbb(i) << 1;
        zzey zzeyVar = (zzey) zzihVar;
        int zzdm = zzeyVar.zzdm();
        if (zzdm == -1) {
            zzdm = zziwVar.zzs(zzeyVar);
            zzeyVar.zzae(zzdm);
        }
        return zzbb + zzdm;
    }

    @Deprecated
    public static int zzd(zzih zzihVar) {
        return zzihVar.zzgg();
    }

    public static int zza(zzhm zzhmVar) {
        int zzgg = zzhmVar.zzgg();
        return zzbd(zzgg) + zzgg;
    }

    public static int zzb(int i, zzih zzihVar) {
        return (zzbb(1) << 1) + zzm(2, i) + zzbb(3) + zzc(zzihVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(zzih zzihVar, zziw zziwVar) {
        zzey zzeyVar = (zzey) zzihVar;
        int zzdm = zzeyVar.zzdm();
        if (zzdm == -1) {
            zzdm = zziwVar.zzs(zzeyVar);
            zzeyVar.zzae(zzdm);
        }
        return zzbd(zzdm) + zzdm;
    }

    public static int zzb(int i, zzhm zzhmVar) {
        return (zzbb(1) << 1) + zzm(2, i) + zza(3, zzhmVar);
    }

    public static int zzb(zzfm zzfmVar) {
        int size = zzfmVar.size();
        return zzbd(size) + size;
    }

    final void zza(String str, zzka zzkaVar) throws IOException {
        logger.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) zzkaVar);
        byte[] bytes = str.getBytes(zzgy.UTF_8);
        try {
            zzay(bytes.length);
            zzc(bytes, 0, bytes.length);
        } catch (zza e2) {
            throw e2;
        } catch (IndexOutOfBoundsException e3) {
            throw new zza(e3);
        }
    }
}
