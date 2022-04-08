package com.google.android.gms.internal.mlkit_vision_common;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

/* compiled from: com.google.mlkit:vision-common@@16.0.0 */
/* loaded from: classes.dex */
final class zzhg {
    static final boolean zza;
    private static final Unsafe zzc;
    private static final boolean zze;
    private static final boolean zzf;
    private static final zzd zzg;
    private static final boolean zzh;
    private static final boolean zzi;
    private static final long zzj;
    private static final long zzk;
    private static final long zzl;
    private static final long zzm;
    private static final long zzn;
    private static final long zzo;
    private static final long zzp;
    private static final long zzq;
    private static final long zzr;
    private static final long zzs;
    private static final long zzt;
    private static final long zzu;
    private static final long zzv;
    private static final long zzw;
    private static final int zzx;
    private static final Logger zzb = Logger.getLogger(zzhg.class.getName());
    private static final Class<?> zzd = zzdh.zzb();

    /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
    /* loaded from: classes.dex */
    static final class zzb extends zzd {
        zzb(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.android.gms.internal.mlkit_vision_common.zzhg.zzd
        public final byte zza(Object obj, long j) {
            return this.zza.getByte(obj, j);
        }

        @Override // com.google.android.gms.internal.mlkit_vision_common.zzhg.zzd
        public final boolean zzb(Object obj, long j) {
            return this.zza.getBoolean(obj, j);
        }

        @Override // com.google.android.gms.internal.mlkit_vision_common.zzhg.zzd
        public final float zzc(Object obj, long j) {
            return this.zza.getFloat(obj, j);
        }

        @Override // com.google.android.gms.internal.mlkit_vision_common.zzhg.zzd
        public final double zzd(Object obj, long j) {
            return this.zza.getDouble(obj, j);
        }

        @Override // com.google.android.gms.internal.mlkit_vision_common.zzhg.zzd
        public final void zza(Object obj, long j, byte b2) {
            this.zza.putByte(obj, j, b2);
        }

        @Override // com.google.android.gms.internal.mlkit_vision_common.zzhg.zzd
        public final void zza(Object obj, long j, boolean z) {
            this.zza.putBoolean(obj, j, z);
        }

        @Override // com.google.android.gms.internal.mlkit_vision_common.zzhg.zzd
        public final void zza(Object obj, long j, float f2) {
            this.zza.putFloat(obj, j, f2);
        }

        @Override // com.google.android.gms.internal.mlkit_vision_common.zzhg.zzd
        public final void zza(Object obj, long j, double d2) {
            this.zza.putDouble(obj, j, d2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
    /* loaded from: classes.dex */
    public static abstract class zzd {
        Unsafe zza;

        zzd(Unsafe unsafe) {
            this.zza = unsafe;
        }

        public abstract byte zza(Object obj, long j);

        public abstract void zza(Object obj, long j, byte b2);

        public abstract void zza(Object obj, long j, double d2);

        public abstract void zza(Object obj, long j, float f2);

        public final void zza(Object obj, long j, int i) {
            this.zza.putInt(obj, j, i);
        }

        public abstract void zza(Object obj, long j, boolean z);

        public abstract boolean zzb(Object obj, long j);

        public abstract float zzc(Object obj, long j);

        public abstract double zzd(Object obj, long j);

        public final int zze(Object obj, long j) {
            return this.zza.getInt(obj, j);
        }

        public final long zzf(Object obj, long j) {
            return this.zza.getLong(obj, j);
        }

        public final void zza(Object obj, long j, long j2) {
            this.zza.putLong(obj, j, j2);
        }
    }

    static {
        Unsafe zzc2 = zzc();
        zzc = zzc2;
        boolean zzd2 = zzd(Long.TYPE);
        zze = zzd2;
        boolean zzd3 = zzd(Integer.TYPE);
        zzf = zzd3;
        zzd zzdVar = null;
        if (zzc2 != null) {
            if (!zzdh.zza()) {
                zzdVar = new zzb(zzc2);
            } else if (zzd2) {
                zzdVar = new zzc(zzc2);
            } else if (zzd3) {
                zzdVar = new zza(zzc2);
            }
        }
        zzg = zzdVar;
        zzh = zze();
        zzi = zzd();
        long zzb2 = zzb(byte[].class);
        zzj = zzb2;
        zzk = zzb(boolean[].class);
        zzl = zzc(boolean[].class);
        zzm = zzb(int[].class);
        zzn = zzc(int[].class);
        zzo = zzb(long[].class);
        zzp = zzc(long[].class);
        zzq = zzb(float[].class);
        zzr = zzc(float[].class);
        zzs = zzb(double[].class);
        zzt = zzc(double[].class);
        zzu = zzb(Object[].class);
        zzv = zzc(Object[].class);
        Field zzf2 = zzf();
        zzw = (zzf2 == null || zzdVar == null) ? -1L : zzdVar.zza.objectFieldOffset(zzf2);
        zzx = (int) (7 & zzb2);
        zza = ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN;
    }

    private zzhg() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zza() {
        return zzi;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zzb() {
        return zzh;
    }

    private static int zzc(Class<?> cls) {
        if (zzi) {
            return zzg.zza.arrayIndexScale(cls);
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float zzd(Object obj, long j) {
        return zzg.zzc(obj, j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static double zze(Object obj, long j) {
        return zzg.zzd(obj, j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object zzf(Object obj, long j) {
        return zzg.zza.getObject(obj, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte zzk(Object obj, long j) {
        return (byte) (zza(obj, (-4) & j) >>> ((int) (((~j) & 3) << 3)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte zzl(Object obj, long j) {
        return (byte) (zza(obj, (-4) & j) >>> ((int) ((j & 3) << 3)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean zzm(Object obj, long j) {
        return zzk(obj, j) != 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean zzn(Object obj, long j) {
        return zzl(obj, j) != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> T zza(Class<T> cls) {
        try {
            return (T) zzc.allocateInstance(cls);
        } catch (InstantiationException e2) {
            throw new IllegalStateException(e2);
        }
    }

    private static int zzb(Class<?> cls) {
        if (zzi) {
            return zzg.zza.arrayBaseOffset(cls);
        }
        return -1;
    }

    private static boolean zzd() {
        Unsafe unsafe = zzc;
        if (unsafe == null) {
            return false;
        }
        try {
            Class<?> cls = unsafe.getClass();
            cls.getMethod("objectFieldOffset", Field.class);
            cls.getMethod("arrayBaseOffset", Class.class);
            cls.getMethod("arrayIndexScale", Class.class);
            Class<?> cls2 = Long.TYPE;
            cls.getMethod("getInt", Object.class, cls2);
            cls.getMethod("putInt", Object.class, cls2, Integer.TYPE);
            cls.getMethod("getLong", Object.class, cls2);
            cls.getMethod("putLong", Object.class, cls2, cls2);
            cls.getMethod("getObject", Object.class, cls2);
            cls.getMethod("putObject", Object.class, cls2, Object.class);
            if (zzdh.zza()) {
                return true;
            }
            cls.getMethod("getByte", Object.class, cls2);
            cls.getMethod("putByte", Object.class, cls2, Byte.TYPE);
            cls.getMethod("getBoolean", Object.class, cls2);
            cls.getMethod("putBoolean", Object.class, cls2, Boolean.TYPE);
            cls.getMethod("getFloat", Object.class, cls2);
            cls.getMethod("putFloat", Object.class, cls2, Float.TYPE);
            cls.getMethod("getDouble", Object.class, cls2);
            cls.getMethod("putDouble", Object.class, cls2, Double.TYPE);
            return true;
        } catch (Throwable th) {
            Logger logger = zzb;
            Level level = Level.WARNING;
            String valueOf = String.valueOf(th);
            StringBuilder sb = new StringBuilder(valueOf.length() + 71);
            sb.append("platform method missing - proto runtime falling back to safer methods: ");
            sb.append(valueOf);
            logger.logp(level, "com.google.protobuf.UnsafeUtil", "supportsUnsafeArrayOperations", sb.toString());
            return false;
        }
    }

    private static boolean zze() {
        Unsafe unsafe = zzc;
        if (unsafe == null) {
            return false;
        }
        try {
            Class<?> cls = unsafe.getClass();
            cls.getMethod("objectFieldOffset", Field.class);
            Class<?> cls2 = Long.TYPE;
            cls.getMethod("getLong", Object.class, cls2);
            if (zzf() == null) {
                return false;
            }
            if (zzdh.zza()) {
                return true;
            }
            cls.getMethod("getByte", cls2);
            cls.getMethod("putByte", cls2, Byte.TYPE);
            cls.getMethod("getInt", cls2);
            cls.getMethod("putInt", cls2, Integer.TYPE);
            cls.getMethod("getLong", cls2);
            cls.getMethod("putLong", cls2, cls2);
            cls.getMethod("copyMemory", cls2, cls2, cls2);
            cls.getMethod("copyMemory", Object.class, cls2, Object.class, cls2, cls2);
            return true;
        } catch (Throwable th) {
            Logger logger = zzb;
            Level level = Level.WARNING;
            String valueOf = String.valueOf(th);
            StringBuilder sb = new StringBuilder(valueOf.length() + 71);
            sb.append("platform method missing - proto runtime falling back to safer methods: ");
            sb.append(valueOf);
            logger.logp(level, "com.google.protobuf.UnsafeUtil", "supportsUnsafeByteBufferOperations", sb.toString());
            return false;
        }
    }

    /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
    /* loaded from: classes.dex */
    static final class zza extends zzd {
        zza(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.android.gms.internal.mlkit_vision_common.zzhg.zzd
        public final byte zza(Object obj, long j) {
            return zzhg.zza ? zzhg.zzk(obj, j) : zzhg.zzl(obj, j);
        }

        @Override // com.google.android.gms.internal.mlkit_vision_common.zzhg.zzd
        public final boolean zzb(Object obj, long j) {
            return zzhg.zza ? zzhg.zzm(obj, j) : zzhg.zzn(obj, j);
        }

        @Override // com.google.android.gms.internal.mlkit_vision_common.zzhg.zzd
        public final float zzc(Object obj, long j) {
            return Float.intBitsToFloat(zze(obj, j));
        }

        @Override // com.google.android.gms.internal.mlkit_vision_common.zzhg.zzd
        public final double zzd(Object obj, long j) {
            return Double.longBitsToDouble(zzf(obj, j));
        }

        @Override // com.google.android.gms.internal.mlkit_vision_common.zzhg.zzd
        public final void zza(Object obj, long j, byte b2) {
            if (zzhg.zza) {
                zzhg.zzc(obj, j, b2);
            } else {
                zzhg.zzd(obj, j, b2);
            }
        }

        @Override // com.google.android.gms.internal.mlkit_vision_common.zzhg.zzd
        public final void zza(Object obj, long j, boolean z) {
            if (zzhg.zza) {
                zzhg.zzd(obj, j, z);
            } else {
                zzhg.zze(obj, j, z);
            }
        }

        @Override // com.google.android.gms.internal.mlkit_vision_common.zzhg.zzd
        public final void zza(Object obj, long j, float f2) {
            zza(obj, j, Float.floatToIntBits(f2));
        }

        @Override // com.google.android.gms.internal.mlkit_vision_common.zzhg.zzd
        public final void zza(Object obj, long j, double d2) {
            zza(obj, j, Double.doubleToLongBits(d2));
        }
    }

    /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
    /* loaded from: classes.dex */
    static final class zzc extends zzd {
        zzc(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.android.gms.internal.mlkit_vision_common.zzhg.zzd
        public final byte zza(Object obj, long j) {
            return zzhg.zza ? zzhg.zzk(obj, j) : zzhg.zzl(obj, j);
        }

        @Override // com.google.android.gms.internal.mlkit_vision_common.zzhg.zzd
        public final boolean zzb(Object obj, long j) {
            return zzhg.zza ? zzhg.zzm(obj, j) : zzhg.zzn(obj, j);
        }

        @Override // com.google.android.gms.internal.mlkit_vision_common.zzhg.zzd
        public final float zzc(Object obj, long j) {
            return Float.intBitsToFloat(zze(obj, j));
        }

        @Override // com.google.android.gms.internal.mlkit_vision_common.zzhg.zzd
        public final double zzd(Object obj, long j) {
            return Double.longBitsToDouble(zzf(obj, j));
        }

        @Override // com.google.android.gms.internal.mlkit_vision_common.zzhg.zzd
        public final void zza(Object obj, long j, byte b2) {
            if (zzhg.zza) {
                zzhg.zzc(obj, j, b2);
            } else {
                zzhg.zzd(obj, j, b2);
            }
        }

        @Override // com.google.android.gms.internal.mlkit_vision_common.zzhg.zzd
        public final void zza(Object obj, long j, boolean z) {
            if (zzhg.zza) {
                zzhg.zzd(obj, j, z);
            } else {
                zzhg.zze(obj, j, z);
            }
        }

        @Override // com.google.android.gms.internal.mlkit_vision_common.zzhg.zzd
        public final void zza(Object obj, long j, float f2) {
            zza(obj, j, Float.floatToIntBits(f2));
        }

        @Override // com.google.android.gms.internal.mlkit_vision_common.zzhg.zzd
        public final void zza(Object obj, long j, double d2) {
            zza(obj, j, Double.doubleToLongBits(d2));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zzc(Object obj, long j) {
        return zzg.zzb(obj, j);
    }

    private static Field zzf() {
        Field zza2;
        if (zzdh.zza() && (zza2 = zza(Buffer.class, "effectiveDirectAddress")) != null) {
            return zza2;
        }
        Field zza3 = zza(Buffer.class, "address");
        if (zza3 == null || zza3.getType() != Long.TYPE) {
            return null;
        }
        return zza3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(Object obj, long j) {
        return zzg.zze(obj, j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long zzb(Object obj, long j) {
        return zzg.zzf(obj, j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Unsafe zzc() {
        try {
            return (Unsafe) AccessController.doPrivileged(new zzhi());
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zza(Object obj, long j, int i) {
        zzg.zza(obj, j, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zza(Object obj, long j, long j2) {
        zzg.zza(obj, j, j2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zzc(Object obj, long j, byte b2) {
        long j2 = (-4) & j;
        int zza2 = zza(obj, j2);
        int i = ((~((int) j)) & 3) << 3;
        zza(obj, j2, ((255 & b2) << i) | (zza2 & (~(255 << i))));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zza(Object obj, long j, boolean z) {
        zzg.zza(obj, j, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zza(Object obj, long j, float f2) {
        zzg.zza(obj, j, f2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zza(Object obj, long j, double d2) {
        zzg.zza(obj, j, d2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zza(Object obj, long j, Object obj2) {
        zzg.zza.putObject(obj, j, obj2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte zza(byte[] bArr, long j) {
        return zzg.zza(bArr, zzj + j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zza(byte[] bArr, long j, byte b2) {
        zzg.zza((Object) bArr, zzj + j, b2);
    }

    private static Field zza(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zze(Object obj, long j, boolean z) {
        zzd(obj, j, z ? (byte) 1 : (byte) 0);
    }

    private static boolean zzd(Class<?> cls) {
        if (!zzdh.zza()) {
            return false;
        }
        try {
            Class<?> cls2 = zzd;
            Class<?> cls3 = Boolean.TYPE;
            cls2.getMethod("peekLong", cls, cls3);
            cls2.getMethod("pokeLong", cls, Long.TYPE, cls3);
            Class<?> cls4 = Integer.TYPE;
            cls2.getMethod("pokeInt", cls, cls4, cls3);
            cls2.getMethod("peekInt", cls, cls3);
            cls2.getMethod("pokeByte", cls, Byte.TYPE);
            cls2.getMethod("peekByte", cls);
            cls2.getMethod("pokeByteArray", cls, byte[].class, cls4, cls4);
            cls2.getMethod("peekByteArray", cls, byte[].class, cls4, cls4);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zzd(Object obj, long j, byte b2) {
        long j2 = (-4) & j;
        int i = (((int) j) & 3) << 3;
        zza(obj, j2, ((255 & b2) << i) | (zza(obj, j2) & (~(255 << i))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zzd(Object obj, long j, boolean z) {
        zzc(obj, j, z ? (byte) 1 : (byte) 0);
    }
}
