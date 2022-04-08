package com.google.android.gms.internal.vision;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
/* loaded from: classes.dex */
final class zzju {
    private static final boolean zzabe;
    private static final boolean zzabf;
    private static final zzd zzabg;
    private static final boolean zzabh;
    private static final long zzabi;
    private static final long zzabj;
    private static final long zzabk;
    private static final long zzabl;
    private static final long zzabm;
    private static final long zzabn;
    private static final long zzabo;
    private static final long zzabp;
    private static final long zzabq;
    private static final long zzabr;
    private static final long zzabs;
    private static final long zzabt;
    private static final long zzabu;
    private static final long zzabv;
    private static final int zzabw;
    static final boolean zzabx;
    private static final boolean zztg;
    private static final Unsafe zzzi;
    private static final Logger logger = Logger.getLogger(zzju.class.getName());
    private static final Class<?> zzsb = zzff.zzdt();

    /* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
    /* loaded from: classes.dex */
    static final class zzb extends zzd {
        zzb(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.android.gms.internal.vision.zzju.zzd
        public final void zza(Object obj, long j, boolean z) {
            this.zzaca.putBoolean(obj, j, z);
        }

        @Override // com.google.android.gms.internal.vision.zzju.zzd
        public final void zze(Object obj, long j, byte b2) {
            this.zzaca.putByte(obj, j, b2);
        }

        @Override // com.google.android.gms.internal.vision.zzju.zzd
        public final boolean zzm(Object obj, long j) {
            return this.zzaca.getBoolean(obj, j);
        }

        @Override // com.google.android.gms.internal.vision.zzju.zzd
        public final float zzn(Object obj, long j) {
            return this.zzaca.getFloat(obj, j);
        }

        @Override // com.google.android.gms.internal.vision.zzju.zzd
        public final double zzo(Object obj, long j) {
            return this.zzaca.getDouble(obj, j);
        }

        @Override // com.google.android.gms.internal.vision.zzju.zzd
        public final byte zzy(Object obj, long j) {
            return this.zzaca.getByte(obj, j);
        }

        @Override // com.google.android.gms.internal.vision.zzju.zzd
        public final void zza(Object obj, long j, float f2) {
            this.zzaca.putFloat(obj, j, f2);
        }

        @Override // com.google.android.gms.internal.vision.zzju.zzd
        public final void zza(Object obj, long j, double d2) {
            this.zzaca.putDouble(obj, j, d2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
    /* loaded from: classes.dex */
    public static abstract class zzd {
        Unsafe zzaca;

        zzd(Unsafe unsafe) {
            this.zzaca = unsafe;
        }

        public abstract void zza(Object obj, long j, double d2);

        public abstract void zza(Object obj, long j, float f2);

        public final void zza(Object obj, long j, long j2) {
            this.zzaca.putLong(obj, j, j2);
        }

        public abstract void zza(Object obj, long j, boolean z);

        public final void zzb(Object obj, long j, int i) {
            this.zzaca.putInt(obj, j, i);
        }

        public abstract void zze(Object obj, long j, byte b2);

        public final int zzk(Object obj, long j) {
            return this.zzaca.getInt(obj, j);
        }

        public final long zzl(Object obj, long j) {
            return this.zzaca.getLong(obj, j);
        }

        public abstract boolean zzm(Object obj, long j);

        public abstract float zzn(Object obj, long j);

        public abstract double zzo(Object obj, long j);

        public abstract byte zzy(Object obj, long j);
    }

    static {
        Unsafe zzim = zzim();
        zzzi = zzim;
        boolean zzk = zzk(Long.TYPE);
        zzabe = zzk;
        boolean zzk2 = zzk(Integer.TYPE);
        zzabf = zzk2;
        zzd zzdVar = null;
        if (zzim != null) {
            if (!zzff.zzds()) {
                zzdVar = new zzb(zzim);
            } else if (zzk) {
                zzdVar = new zzc(zzim);
            } else if (zzk2) {
                zzdVar = new zza(zzim);
            }
        }
        zzabg = zzdVar;
        zzabh = zzio();
        zztg = zzin();
        long zzi = zzi(byte[].class);
        zzabi = zzi;
        zzabj = zzi(boolean[].class);
        zzabk = zzj(boolean[].class);
        zzabl = zzi(int[].class);
        zzabm = zzj(int[].class);
        zzabn = zzi(long[].class);
        zzabo = zzj(long[].class);
        zzabp = zzi(float[].class);
        zzabq = zzj(float[].class);
        zzabr = zzi(double[].class);
        zzabs = zzj(double[].class);
        zzabt = zzi(Object[].class);
        zzabu = zzj(Object[].class);
        Field zzip = zzip();
        zzabv = (zzip == null || zzdVar == null) ? -1L : zzdVar.zzaca.objectFieldOffset(zzip);
        zzabw = (int) (7 & zzi);
        zzabx = ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN;
    }

    private zzju() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zza(Object obj, long j, long j2) {
        zzabg.zza(obj, j, j2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zzb(Object obj, long j, int i) {
        zzabg.zzb(obj, j, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zzc(Object obj, long j, boolean z) {
        zzb(obj, j, z ? (byte) 1 : (byte) 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> T zzh(Class<T> cls) {
        try {
            return (T) zzzi.allocateInstance(cls);
        } catch (InstantiationException e2) {
            throw new IllegalStateException(e2);
        }
    }

    private static int zzi(Class<?> cls) {
        if (zztg) {
            return zzabg.zzaca.arrayBaseOffset(cls);
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zzik() {
        return zztg;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zzil() {
        return zzabh;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Unsafe zzim() {
        try {
            return (Unsafe) AccessController.doPrivileged(new zzjw());
        } catch (Throwable unused) {
            return null;
        }
    }

    private static boolean zzin() {
        Unsafe unsafe = zzzi;
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
            if (zzff.zzds()) {
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
            Logger logger2 = logger;
            Level level = Level.WARNING;
            String valueOf = String.valueOf(th);
            StringBuilder sb = new StringBuilder(valueOf.length() + 71);
            sb.append("platform method missing - proto runtime falling back to safer methods: ");
            sb.append(valueOf);
            logger2.logp(level, "com.google.protobuf.UnsafeUtil", "supportsUnsafeArrayOperations", sb.toString());
            return false;
        }
    }

    private static boolean zzio() {
        Unsafe unsafe = zzzi;
        if (unsafe == null) {
            return false;
        }
        try {
            Class<?> cls = unsafe.getClass();
            cls.getMethod("objectFieldOffset", Field.class);
            Class<?> cls2 = Long.TYPE;
            cls.getMethod("getLong", Object.class, cls2);
            if (zzip() == null) {
                return false;
            }
            if (zzff.zzds()) {
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
            Logger logger2 = logger;
            Level level = Level.WARNING;
            String valueOf = String.valueOf(th);
            StringBuilder sb = new StringBuilder(valueOf.length() + 71);
            sb.append("platform method missing - proto runtime falling back to safer methods: ");
            sb.append(valueOf);
            logger2.logp(level, "com.google.protobuf.UnsafeUtil", "supportsUnsafeByteBufferOperations", sb.toString());
            return false;
        }
    }

    private static Field zzip() {
        Field zzb2;
        if (zzff.zzds() && (zzb2 = zzb(Buffer.class, "effectiveDirectAddress")) != null) {
            return zzb2;
        }
        Field zzb3 = zzb(Buffer.class, "address");
        if (zzb3 == null || zzb3.getType() != Long.TYPE) {
            return null;
        }
        return zzb3;
    }

    private static int zzj(Class<?> cls) {
        if (zztg) {
            return zzabg.zzaca.arrayIndexScale(cls);
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzk(Object obj, long j) {
        return zzabg.zzk(obj, j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long zzl(Object obj, long j) {
        return zzabg.zzl(obj, j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zzm(Object obj, long j) {
        return zzabg.zzm(obj, j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float zzn(Object obj, long j) {
        return zzabg.zzn(obj, j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static double zzo(Object obj, long j) {
        return zzabg.zzo(obj, j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object zzp(Object obj, long j) {
        return zzabg.zzaca.getObject(obj, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte zzq(Object obj, long j) {
        return (byte) (zzk(obj, (-4) & j) >>> ((int) (((~j) & 3) << 3)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte zzr(Object obj, long j) {
        return (byte) (zzk(obj, (-4) & j) >>> ((int) ((j & 3) << 3)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean zzs(Object obj, long j) {
        return zzq(obj, j) != 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean zzt(Object obj, long j) {
        return zzr(obj, j) != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zza(Object obj, long j, boolean z) {
        zzabg.zza(obj, j, z);
    }

    private static Field zzb(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    private static boolean zzk(Class<?> cls) {
        if (!zzff.zzds()) {
            return false;
        }
        try {
            Class<?> cls2 = zzsb;
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

    /* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
    /* loaded from: classes.dex */
    static final class zza extends zzd {
        zza(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.android.gms.internal.vision.zzju.zzd
        public final void zza(Object obj, long j, boolean z) {
            if (zzju.zzabx) {
                zzju.zzb(obj, j, z);
            } else {
                zzju.zzc(obj, j, z);
            }
        }

        @Override // com.google.android.gms.internal.vision.zzju.zzd
        public final void zze(Object obj, long j, byte b2) {
            if (zzju.zzabx) {
                zzju.zza(obj, j, b2);
            } else {
                zzju.zzb(obj, j, b2);
            }
        }

        @Override // com.google.android.gms.internal.vision.zzju.zzd
        public final boolean zzm(Object obj, long j) {
            return zzju.zzabx ? zzju.zzs(obj, j) : zzju.zzt(obj, j);
        }

        @Override // com.google.android.gms.internal.vision.zzju.zzd
        public final float zzn(Object obj, long j) {
            return Float.intBitsToFloat(zzk(obj, j));
        }

        @Override // com.google.android.gms.internal.vision.zzju.zzd
        public final double zzo(Object obj, long j) {
            return Double.longBitsToDouble(zzl(obj, j));
        }

        @Override // com.google.android.gms.internal.vision.zzju.zzd
        public final byte zzy(Object obj, long j) {
            return zzju.zzabx ? zzju.zzq(obj, j) : zzju.zzr(obj, j);
        }

        @Override // com.google.android.gms.internal.vision.zzju.zzd
        public final void zza(Object obj, long j, float f2) {
            zzb(obj, j, Float.floatToIntBits(f2));
        }

        @Override // com.google.android.gms.internal.vision.zzju.zzd
        public final void zza(Object obj, long j, double d2) {
            zza(obj, j, Double.doubleToLongBits(d2));
        }
    }

    /* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
    /* loaded from: classes.dex */
    static final class zzc extends zzd {
        zzc(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.android.gms.internal.vision.zzju.zzd
        public final void zza(Object obj, long j, boolean z) {
            if (zzju.zzabx) {
                zzju.zzb(obj, j, z);
            } else {
                zzju.zzc(obj, j, z);
            }
        }

        @Override // com.google.android.gms.internal.vision.zzju.zzd
        public final void zze(Object obj, long j, byte b2) {
            if (zzju.zzabx) {
                zzju.zza(obj, j, b2);
            } else {
                zzju.zzb(obj, j, b2);
            }
        }

        @Override // com.google.android.gms.internal.vision.zzju.zzd
        public final boolean zzm(Object obj, long j) {
            return zzju.zzabx ? zzju.zzs(obj, j) : zzju.zzt(obj, j);
        }

        @Override // com.google.android.gms.internal.vision.zzju.zzd
        public final float zzn(Object obj, long j) {
            return Float.intBitsToFloat(zzk(obj, j));
        }

        @Override // com.google.android.gms.internal.vision.zzju.zzd
        public final double zzo(Object obj, long j) {
            return Double.longBitsToDouble(zzl(obj, j));
        }

        @Override // com.google.android.gms.internal.vision.zzju.zzd
        public final byte zzy(Object obj, long j) {
            return zzju.zzabx ? zzju.zzq(obj, j) : zzju.zzr(obj, j);
        }

        @Override // com.google.android.gms.internal.vision.zzju.zzd
        public final void zza(Object obj, long j, float f2) {
            zzb(obj, j, Float.floatToIntBits(f2));
        }

        @Override // com.google.android.gms.internal.vision.zzju.zzd
        public final void zza(Object obj, long j, double d2) {
            zza(obj, j, Double.doubleToLongBits(d2));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zza(Object obj, long j, float f2) {
        zzabg.zza(obj, j, f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zzb(Object obj, long j, byte b2) {
        long j2 = (-4) & j;
        int i = (((int) j) & 3) << 3;
        zzb(obj, j2, ((255 & b2) << i) | (zzk(obj, j2) & (~(255 << i))));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zza(Object obj, long j, double d2) {
        zzabg.zza(obj, j, d2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zza(Object obj, long j, Object obj2) {
        zzabg.zzaca.putObject(obj, j, obj2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zzb(Object obj, long j, boolean z) {
        zza(obj, j, z ? (byte) 1 : (byte) 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte zza(byte[] bArr, long j) {
        return zzabg.zzy(bArr, zzabi + j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zza(byte[] bArr, long j, byte b2) {
        zzabg.zze(bArr, zzabi + j, b2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zza(Object obj, long j, byte b2) {
        long j2 = (-4) & j;
        int zzk = zzk(obj, j2);
        int i = ((~((int) j)) & 3) << 3;
        zzb(obj, j2, ((255 & b2) << i) | (zzk & (~(255 << i))));
    }
}
