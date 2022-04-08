package com.google.android.gms.internal.mlkit_vision_barcode;

import com.google.android.gms.internal.mlkit_vision_barcode.zzga;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
/* loaded from: classes.dex */
public final class zzdv {

    /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
    /* loaded from: classes.dex */
    public static final class zza extends zzga<zza, C0123zza> implements zzhm {
        private static final zzgi<Integer, zzen> zzd = new zzdw();
        private static final zza zze;
        private static volatile zzhu<zza> zzf;
        private zzgj zzc = zzga.zzk();

        /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
        /* renamed from: com.google.android.gms.internal.mlkit_vision_barcode.zzdv$zza$zza  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0123zza extends zzga.zzb<zza, C0123zza> implements zzhm {
            private C0123zza() {
                super(zza.zze);
            }

            public final C0123zza zza(Iterable<? extends zzen> iterable) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zza) this.zza).zza(iterable);
                return this;
            }

            /* synthetic */ C0123zza(zzdu zzduVar) {
                this();
            }
        }

        static {
            zza zzaVar = new zza();
            zze = zzaVar;
            zzga.zza(zza.class, zzaVar);
        }

        private zza() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(Iterable<? extends zzen> iterable) {
            zzgj zzgjVar = this.zzc;
            if (!zzgjVar.zza()) {
                this.zzc = zzga.zza(zzgjVar);
            }
            for (zzen zzenVar : iterable) {
                this.zzc.zzd(zzenVar.zza());
            }
        }

        public static C0123zza zza() {
            return zze.zzh();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzga
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzdu.zza[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new C0123zza(null);
                case 3:
                    return zzga.zza(zze, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001e", new Object[]{"zzc", zzen.zzb()});
                case 4:
                    return zze;
                case 5:
                    zzhu<zza> zzhuVar = zzf;
                    if (zzhuVar == null) {
                        synchronized (zza.class) {
                            zzhuVar = zzf;
                            if (zzhuVar == null) {
                                zzhuVar = new zzga.zza<>(zze);
                                zzf = zzhuVar;
                            }
                        }
                    }
                    return zzhuVar;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }
    }

    /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
    /* loaded from: classes.dex */
    public static final class zzb extends zzga<zzb, C0124zzb> implements zzhm {
        private static final zzb zzj;
        private static volatile zzhu<zzb> zzk;
        private int zzc;
        private int zzd;
        private int zze;
        private int zzf;
        private boolean zzg;
        private boolean zzh;
        private float zzi;

        /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
        /* loaded from: classes.dex */
        public enum zza implements zzgf {
            CLASSIFICATION_UNKNOWN(0),
            CLASSIFICATION_NONE(1),
            CLASSIFICATION_ALL(2);
            
            private static final zzge<zza> zzd = new zzdy();
            private final int zze;

            zza(int i) {
                this.zze = i;
            }

            public static zzgh zzb() {
                return zzdx.zza;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "<" + zza.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zze + " name=" + name() + '>';
            }

            @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzgf
            public final int zza() {
                return this.zze;
            }
        }

        /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
        /* renamed from: com.google.android.gms.internal.mlkit_vision_barcode.zzdv$zzb$zzb  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0124zzb extends zzga.zzb<zzb, C0124zzb> implements zzhm {
            private C0124zzb() {
                super(zzb.zzj);
            }

            /* synthetic */ C0124zzb(zzdu zzduVar) {
                this();
            }
        }

        /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
        /* loaded from: classes.dex */
        public enum zzc implements zzgf {
            LANDMARK_UNKNOWN(0),
            LANDMARK_NONE(1),
            LANDMARK_ALL(2),
            LANDMARK_CONTOUR(3);
            
            private static final zzge<zzc> zze = new zzdz();
            private final int zzf;

            zzc(int i) {
                this.zzf = i;
            }

            public static zzgh zzb() {
                return zzea.zza;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "<" + zzc.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzf + " name=" + name() + '>';
            }

            @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzgf
            public final int zza() {
                return this.zzf;
            }
        }

        /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
        /* loaded from: classes.dex */
        public enum zzd implements zzgf {
            MODE_UNKNOWN(0),
            MODE_ACCURATE(1),
            MODE_FAST(2),
            MODE_SELFIE(3);
            
            private static final zzge<zzd> zze = new zzec();
            private final int zzf;

            zzd(int i) {
                this.zzf = i;
            }

            public static zzgh zzb() {
                return zzeb.zza;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "<" + zzd.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzf + " name=" + name() + '>';
            }

            @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzgf
            public final int zza() {
                return this.zzf;
            }
        }

        static {
            zzb zzbVar = new zzb();
            zzj = zzbVar;
            zzga.zza(zzb.class, zzbVar);
        }

        private zzb() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzga
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzdu.zza[i - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return new C0124zzb(null);
                case 3:
                    return zzga.zza(zzj, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဌ\u0001\u0003ဌ\u0002\u0004ဇ\u0003\u0005ဇ\u0004\u0006ခ\u0005", new Object[]{"zzc", "zzd", zzd.zzb(), "zze", zzc.zzb(), "zzf", zza.zzb(), "zzg", "zzh", "zzi"});
                case 4:
                    return zzj;
                case 5:
                    zzhu<zzb> zzhuVar = zzk;
                    if (zzhuVar == null) {
                        synchronized (zzb.class) {
                            zzhuVar = zzk;
                            if (zzhuVar == null) {
                                zzhuVar = new zzga.zza<>(zzj);
                                zzk = zzhuVar;
                            }
                        }
                    }
                    return zzhuVar;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }
    }
}
