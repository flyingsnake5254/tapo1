package com.google.android.gms.internal.mlkit_vision_barcode;

import com.google.android.gms.internal.mlkit_vision_barcode.zzga;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
/* loaded from: classes.dex */
public final class zzkf {

    /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
    /* loaded from: classes.dex */
    public static final class zzc extends zzga<zzc, zzb> implements zzhm {
        private static final zzc zzm;
        private static volatile zzhu<zzc> zzn;
        private int zzc;
        private int zzd;
        private int zze;
        private zza zzh;
        private zzd zzi;
        private int zzj;
        private int zzl;
        private String zzf = "";
        private String zzg = "";
        private zzgl<zzg> zzk = zzga.zzm();

        /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
        /* loaded from: classes.dex */
        public enum zza implements zzgf {
            UNKNOWN_ACTION(0),
            INITIALIZATION(1),
            COMPILATION(2),
            EXECUTION(3),
            TEARDOWN(4);
            
            private static final zzge<zza> zzf = new zzki();
            private final int zzg;

            zza(int i) {
                this.zzg = i;
            }

            public static zzgh zzb() {
                return zzkj.zza;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "<" + zza.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzg + " name=" + name() + '>';
            }

            @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzgf
            public final int zza() {
                return this.zzg;
            }
        }

        /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
        /* loaded from: classes.dex */
        public static final class zzb extends zzga.zzb<zzc, zzb> implements zzhm {
            private zzb() {
                super(zzc.zzm);
            }

            /* synthetic */ zzb(zzke zzkeVar) {
                this();
            }
        }

        /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
        /* loaded from: classes.dex */
        public enum zze implements zzgf {
            UNKNOWN_STATUS(0),
            COMPLETED_EVENT(1),
            MISSING_END_EVENT(2),
            HANG(3),
            ABANDONED_FROM_HANG(4),
            FORCED_CRASH_FROM_HANG(5);
            
            private static final zzge<zze> zzg = new zzkk();
            private final int zzh;

            zze(int i) {
                this.zzh = i;
            }

            public static zzgh zzb() {
                return zzkm.zza;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "<" + zze.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzh + " name=" + name() + '>';
            }

            @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzgf
            public final int zza() {
                return this.zzh;
            }
        }

        static {
            zzc zzcVar = new zzc();
            zzm = zzcVar;
            zzga.zza(zzc.class, zzcVar);
        }

        private zzc() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzga
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzke.zza[i - 1]) {
                case 1:
                    return new zzc();
                case 2:
                    return new zzb(null);
                case 3:
                    return zzga.zza(zzm, "\u0001\t\u0000\u0001\u0001\t\t\u0000\u0001\u0000\u0001ဌ\u0000\u0002ဌ\u0001\u0003ဈ\u0002\u0004ဈ\u0003\u0005ဉ\u0004\u0006ဉ\u0005\u0007င\u0006\b\u001b\tင\u0007", new Object[]{"zzc", "zzd", zza.zzb(), "zze", zze.zzb(), "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", zzg.class, "zzl"});
                case 4:
                    return zzm;
                case 5:
                    zzhu<zzc> zzhuVar = zzn;
                    if (zzhuVar == null) {
                        synchronized (zzc.class) {
                            zzhuVar = zzn;
                            if (zzhuVar == null) {
                                zzhuVar = new zzga.zza<>(zzm);
                                zzn = zzhuVar;
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

        /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
        /* renamed from: com.google.android.gms.internal.mlkit_vision_barcode.zzkf$zzc$zzc  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0127zzc extends zzga<C0127zzc, zza> implements zzhm {
            private static final C0127zzc zzf;
            private static volatile zzhu<C0127zzc> zzg;
            private int zzc;
            private int zzd;
            private int zze;

            /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
            /* renamed from: com.google.android.gms.internal.mlkit_vision_barcode.zzkf$zzc$zzc$zza */
            /* loaded from: classes.dex */
            public static final class zza extends zzga.zzb<C0127zzc, zza> implements zzhm {
                private zza() {
                    super(C0127zzc.zzf);
                }

                /* synthetic */ zza(zzke zzkeVar) {
                    this();
                }
            }

            static {
                C0127zzc zzcVar = new C0127zzc();
                zzf = zzcVar;
                zzga.zza(C0127zzc.class, zzcVar);
            }

            private C0127zzc() {
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzga
            public final Object zza(int i, Object obj, Object obj2) {
                switch (zzke.zza[i - 1]) {
                    case 1:
                        return new C0127zzc();
                    case 2:
                        return new zza(null);
                    case 3:
                        return zzga.zza(zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001င\u0000\u0002င\u0001", new Object[]{"zzc", "zzd", "zze"});
                    case 4:
                        return zzf;
                    case 5:
                        zzhu<C0127zzc> zzhuVar = zzg;
                        if (zzhuVar == null) {
                            synchronized (C0127zzc.class) {
                                zzhuVar = zzg;
                                if (zzhuVar == null) {
                                    zzhuVar = new zzga.zza<>(zzf);
                                    zzg = zzhuVar;
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
        public static final class zzd extends zzga<zzd, zza> implements zzhm {
            private static final zzd zzg;
            private static volatile zzhu<zzd> zzh;
            private int zzc;
            private C0127zzc zzd;
            private C0127zzc zze;
            private boolean zzf;

            /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
            /* loaded from: classes.dex */
            public static final class zza extends zzga.zzb<zzd, zza> implements zzhm {
                private zza() {
                    super(zzd.zzg);
                }

                /* synthetic */ zza(zzke zzkeVar) {
                    this();
                }
            }

            static {
                zzd zzdVar = new zzd();
                zzg = zzdVar;
                zzga.zza(zzd.class, zzdVar);
            }

            private zzd() {
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzga
            public final Object zza(int i, Object obj, Object obj2) {
                switch (zzke.zza[i - 1]) {
                    case 1:
                        return new zzd();
                    case 2:
                        return new zza(null);
                    case 3:
                        return zzga.zza(zzg, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဇ\u0002", new Object[]{"zzc", "zzd", "zze", "zzf"});
                    case 4:
                        return zzg;
                    case 5:
                        zzhu<zzd> zzhuVar = zzh;
                        if (zzhuVar == null) {
                            synchronized (zzd.class) {
                                zzhuVar = zzh;
                                if (zzhuVar == null) {
                                    zzhuVar = new zzga.zza<>(zzg);
                                    zzh = zzhuVar;
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

    /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
    /* loaded from: classes.dex */
    public static final class zzi extends zzga<zzi, zza> implements zzhm {
        private static final zzi zzd;
        private static volatile zzhu<zzi> zze;
        private zzgl<zzb> zzc = zzga.zzm();

        /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
        /* loaded from: classes.dex */
        public static final class zza extends zzga.zzb<zzi, zza> implements zzhm {
            private zza() {
                super(zzi.zzd);
            }

            /* synthetic */ zza(zzke zzkeVar) {
                this();
            }
        }

        static {
            zzi zziVar = new zzi();
            zzd = zziVar;
            zzga.zza(zzi.class, zziVar);
        }

        private zzi() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzga
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzke.zza[i - 1]) {
                case 1:
                    return new zzi();
                case 2:
                    return new zza(null);
                case 3:
                    return zzga.zza(zzd, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzc", zzb.class});
                case 4:
                    return zzd;
                case 5:
                    zzhu<zzi> zzhuVar = zze;
                    if (zzhuVar == null) {
                        synchronized (zzi.class) {
                            zzhuVar = zze;
                            if (zzhuVar == null) {
                                zzhuVar = new zzga.zza<>(zzd);
                                zze = zzhuVar;
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

        /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
        /* loaded from: classes.dex */
        public static final class zzb extends zzga<zzb, zza> implements zzhm {
            private static final zzb zzh;
            private static volatile zzhu<zzb> zzi;
            private int zzc;
            private int zze;
            private long zzg;
            private String zzd = "";
            private String zzf = "";

            /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
            /* loaded from: classes.dex */
            public static final class zza extends zzga.zzb<zzb, zza> implements zzhm {
                private zza() {
                    super(zzb.zzh);
                }

                /* synthetic */ zza(zzke zzkeVar) {
                    this();
                }
            }

            static {
                zzb zzbVar = new zzb();
                zzh = zzbVar;
                zzga.zza(zzb.class, zzbVar);
            }

            private zzb() {
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzga
            public final Object zza(int i, Object obj, Object obj2) {
                switch (zzke.zza[i - 1]) {
                    case 1:
                        return new zzb();
                    case 2:
                        return new zza(null);
                    case 3:
                        return zzga.zza(zzh, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဈ\u0000\u0002င\u0001\u0003ဈ\u0002\u0004ဂ\u0003", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg"});
                    case 4:
                        return zzh;
                    case 5:
                        zzhu<zzb> zzhuVar = zzi;
                        if (zzhuVar == null) {
                            synchronized (zzb.class) {
                                zzhuVar = zzi;
                                if (zzhuVar == null) {
                                    zzhuVar = new zzga.zza<>(zzh);
                                    zzi = zzhuVar;
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

    /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
    /* loaded from: classes.dex */
    public static final class zzb extends zzga<zzb, zza> implements zzhm {
        private static final zzb zzn;
        private static volatile zzhu<zzb> zzo;
        private int zzc;
        private int zzd;
        private String zze = "";
        private String zzf = "";
        private String zzg = "";
        private String zzh = "";
        private String zzi = "";
        private String zzj = "";
        private String zzk = "";
        private String zzl = "";
        private String zzm = "";

        /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
        /* loaded from: classes.dex */
        public static final class zza extends zzga.zzb<zzb, zza> implements zzhm {
            private zza() {
                super(zzb.zzn);
            }

            /* synthetic */ zza(zzke zzkeVar) {
                this();
            }
        }

        static {
            zzb zzbVar = new zzb();
            zzn = zzbVar;
            zzga.zza(zzb.class, zzbVar);
        }

        private zzb() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzga
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzke.zza[i - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return new zza(null);
                case 3:
                    return zzga.zza(zzn, "\u0001\n\u0000\u0001\u0001\n\n\u0000\u0000\u0000\u0001င\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004ဈ\u0003\u0005ဈ\u0004\u0006ဈ\u0005\u0007ဈ\u0006\bဈ\u0007\tဈ\b\nဈ\t", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", "zzm"});
                case 4:
                    return zzn;
                case 5:
                    zzhu<zzb> zzhuVar = zzo;
                    if (zzhuVar == null) {
                        synchronized (zzb.class) {
                            zzhuVar = zzo;
                            if (zzhuVar == null) {
                                zzhuVar = new zzga.zza<>(zzn);
                                zzo = zzhuVar;
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
    public static final class zzd extends zzga<zzd, zza> implements zzhm {
        private static final zzd zzk;
        private static volatile zzhu<zzd> zzl;
        private int zzc;
        private int zzg;
        private int zzh;
        private int zzj;
        private String zzd = "";
        private String zze = "";
        private String zzf = "";
        private String zzi = "";

        /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
        /* loaded from: classes.dex */
        public static final class zza extends zzga.zzb<zzd, zza> implements zzhm {
            private zza() {
                super(zzd.zzk);
            }

            /* synthetic */ zza(zzke zzkeVar) {
                this();
            }
        }

        static {
            zzd zzdVar = new zzd();
            zzk = zzdVar;
            zzga.zza(zzd.class, zzdVar);
        }

        private zzd() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzga
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzke.zza[i - 1]) {
                case 1:
                    return new zzd();
                case 2:
                    return new zza(null);
                case 3:
                    return zzga.zza(zzk, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004င\u0003\u0005င\u0004\u0006ဈ\u0005\u0007င\u0006", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj"});
                case 4:
                    return zzk;
                case 5:
                    zzhu<zzd> zzhuVar = zzl;
                    if (zzhuVar == null) {
                        synchronized (zzd.class) {
                            zzhuVar = zzl;
                            if (zzhuVar == null) {
                                zzhuVar = new zzga.zza<>(zzk);
                                zzl = zzhuVar;
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
    public static final class zze extends zzga<zze, zza> implements zzhm {
        private static final zze zze;
        private static volatile zzhu<zze> zzf;
        private int zzc;
        private int zzd;

        /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
        /* loaded from: classes.dex */
        public static final class zza extends zzga.zzb<zze, zza> implements zzhm {
            private zza() {
                super(zze.zze);
            }

            /* synthetic */ zza(zzke zzkeVar) {
                this();
            }
        }

        static {
            zze zzeVar = new zze();
            zze = zzeVar;
            zzga.zza(zze.class, zzeVar);
        }

        private zze() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzga
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzke.zza[i - 1]) {
                case 1:
                    return new zze();
                case 2:
                    return new zza(null);
                case 3:
                    return zzga.zza(zze, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001င\u0000", new Object[]{"zzc", "zzd"});
                case 4:
                    return zze;
                case 5:
                    zzhu<zze> zzhuVar = zzf;
                    if (zzhuVar == null) {
                        synchronized (zze.class) {
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
    public static final class zzg extends zzga<zzg, zza> implements zzhm {
        private static final zzg zzd;
        private static volatile zzhu<zzg> zze;
        private zzgj zzc = zzga.zzk();

        /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
        /* loaded from: classes.dex */
        public static final class zza extends zzga.zzb<zzg, zza> implements zzhm {
            private zza() {
                super(zzg.zzd);
            }

            /* synthetic */ zza(zzke zzkeVar) {
                this();
            }
        }

        static {
            zzg zzgVar = new zzg();
            zzd = zzgVar;
            zzga.zza(zzg.class, zzgVar);
        }

        private zzg() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzga
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzke.zza[i - 1]) {
                case 1:
                    return new zzg();
                case 2:
                    return new zza(null);
                case 3:
                    return zzga.zza(zzd, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u0016", new Object[]{"zzc"});
                case 4:
                    return zzd;
                case 5:
                    zzhu<zzg> zzhuVar = zze;
                    if (zzhuVar == null) {
                        synchronized (zzg.class) {
                            zzhuVar = zze;
                            if (zzhuVar == null) {
                                zzhuVar = new zzga.zza<>(zzd);
                                zze = zzhuVar;
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
    public static final class zzh extends zzga<zzh, zza> implements zzhm {
        private static final zzh zzf;
        private static volatile zzhu<zzh> zzg;
        private int zzc;
        private String zzd = "";
        private int zze;

        /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
        /* loaded from: classes.dex */
        public static final class zza extends zzga.zzb<zzh, zza> implements zzhm {
            private zza() {
                super(zzh.zzf);
            }

            /* synthetic */ zza(zzke zzkeVar) {
                this();
            }
        }

        static {
            zzh zzhVar = new zzh();
            zzf = zzhVar;
            zzga.zza(zzh.class, zzhVar);
        }

        private zzh() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzga
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzke.zza[i - 1]) {
                case 1:
                    return new zzh();
                case 2:
                    return new zza(null);
                case 3:
                    return zzga.zza(zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002င\u0001", new Object[]{"zzc", "zzd", "zze"});
                case 4:
                    return zzf;
                case 5:
                    zzhu<zzh> zzhuVar = zzg;
                    if (zzhuVar == null) {
                        synchronized (zzh.class) {
                            zzhuVar = zzg;
                            if (zzhuVar == null) {
                                zzhuVar = new zzga.zza<>(zzf);
                                zzg = zzhuVar;
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
    public static final class zza extends zzga<zza, C0126zza> implements zzhm {
        private static final zza zzf;
        private static volatile zzhu<zza> zzg;
        private int zzc;
        private int zzd;
        private zzj zze;

        /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
        /* renamed from: com.google.android.gms.internal.mlkit_vision_barcode.zzkf$zza$zza  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0126zza extends zzga.zzb<zza, C0126zza> implements zzhm {
            private C0126zza() {
                super(zza.zzf);
            }

            /* synthetic */ C0126zza(zzke zzkeVar) {
                this();
            }
        }

        /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
        /* loaded from: classes.dex */
        public enum zzb implements zzgf {
            UNKNOWN_ENGINE(0),
            TFLITE(1);
            
            private static final zzge<zzb> zzc = new zzkg();
            private final int zzd;

            zzb(int i) {
                this.zzd = i;
            }

            public static zzgh zzb() {
                return zzkh.zza;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "<" + zzb.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzd + " name=" + name() + '>';
            }

            @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzgf
            public final int zza() {
                return this.zzd;
            }
        }

        static {
            zza zzaVar = new zza();
            zzf = zzaVar;
            zzga.zza(zza.class, zzaVar);
        }

        private zza() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzga
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzke.zza[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new C0126zza(null);
                case 3:
                    return zzga.zza(zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဉ\u0001", new Object[]{"zzc", "zzd", zzb.zzb(), "zze"});
                case 4:
                    return zzf;
                case 5:
                    zzhu<zza> zzhuVar = zzg;
                    if (zzhuVar == null) {
                        synchronized (zza.class) {
                            zzhuVar = zzg;
                            if (zzhuVar == null) {
                                zzhuVar = new zzga.zza<>(zzf);
                                zzg = zzhuVar;
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
    public static final class zzj extends zzga<zzj, zza> implements zzhm {
        private static final zzj zzg;
        private static volatile zzhu<zzj> zzh;
        private int zzc;
        private int zzd;
        private zzh zze;
        private zze zzf;

        /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
        /* loaded from: classes.dex */
        public static final class zza extends zzga.zzb<zzj, zza> implements zzhm {
            private zza() {
                super(zzj.zzg);
            }

            /* synthetic */ zza(zzke zzkeVar) {
                this();
            }
        }

        /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
        /* loaded from: classes.dex */
        public enum zzb implements zzgf {
            DELEGATE_NONE(0),
            NNAPI(1),
            GPU(2),
            HEXAGON(3),
            EDGETPU(4);
            
            private static final zzge<zzb> zzf = new zzkp();
            private final int zzg;

            zzb(int i) {
                this.zzg = i;
            }

            public static zzgh zzb() {
                return zzkq.zza;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "<" + zzb.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzg + " name=" + name() + '>';
            }

            @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzgf
            public final int zza() {
                return this.zzg;
            }
        }

        static {
            zzj zzjVar = new zzj();
            zzg = zzjVar;
            zzga.zza(zzj.class, zzjVar);
        }

        private zzj() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzga
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzke.zza[i - 1]) {
                case 1:
                    return new zzj();
                case 2:
                    return new zza(null);
                case 3:
                    return zzga.zza(zzg, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဉ\u0001\u0003ဉ\u0002", new Object[]{"zzc", "zzd", zzb.zzb(), "zze", "zzf"});
                case 4:
                    return zzg;
                case 5:
                    zzhu<zzj> zzhuVar = zzh;
                    if (zzhuVar == null) {
                        synchronized (zzj.class) {
                            zzhuVar = zzh;
                            if (zzhuVar == null) {
                                zzhuVar = new zzga.zza<>(zzg);
                                zzh = zzhuVar;
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
    public static final class zzk extends zzga.zzc<zzk, zza> implements zzhm {
        private static final zzk zze;
        private static volatile zzhu<zzk> zzf;
        private byte zzd = 2;

        /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
        /* loaded from: classes.dex */
        public static final class zza extends zzga.zzd<zzk, zza> implements zzhm {
            private zza() {
                super(zzk.zze);
            }

            /* synthetic */ zza(zzke zzkeVar) {
                this();
            }
        }

        static {
            zzk zzkVar = new zzk();
            zze = zzkVar;
            zzga.zza(zzk.class, zzkVar);
        }

        private zzk() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzga
        public final Object zza(int i, Object obj, Object obj2) {
            int i2 = 1;
            switch (zzke.zza[i - 1]) {
                case 1:
                    return new zzk();
                case 2:
                    return new zza(null);
                case 3:
                    return zzga.zza(zze, "\u0001\u0000", (Object[]) null);
                case 4:
                    return zze;
                case 5:
                    zzhu<zzk> zzhuVar = zzf;
                    if (zzhuVar == null) {
                        synchronized (zzk.class) {
                            zzhuVar = zzf;
                            if (zzhuVar == null) {
                                zzhuVar = new zzga.zza<>(zze);
                                zzf = zzhuVar;
                            }
                        }
                    }
                    return zzhuVar;
                case 6:
                    return Byte.valueOf(this.zzd);
                case 7:
                    if (obj == null) {
                        i2 = 0;
                    }
                    this.zzd = (byte) i2;
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }
    }

    /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
    /* loaded from: classes.dex */
    public static final class zzf extends zzga<zzf, zza> implements zzhm {
        private static final zzf zzo;
        private static volatile zzhu<zzf> zzp;
        private int zzc;
        private zzb zzd;
        private zzi zze;
        private zzd zzf;
        private int zzg;
        private zzc zzh;
        private zzk zzi;
        private long zzj;
        private long zzk;
        private boolean zzl;
        private int zzm;
        private byte zzn = 2;

        /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
        /* loaded from: classes.dex */
        public static final class zza extends zzga.zzb<zzf, zza> implements zzhm {
            private zza() {
                super(zzf.zzo);
            }

            /* synthetic */ zza(zzke zzkeVar) {
                this();
            }
        }

        static {
            zzf zzfVar = new zzf();
            zzo = zzfVar;
            zzga.zza(zzf.class, zzfVar);
        }

        private zzf() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzga
        public final Object zza(int i, Object obj, Object obj2) {
            int i2 = 1;
            switch (zzke.zza[i - 1]) {
                case 1:
                    return new zzf();
                case 2:
                    return new zza(null);
                case 3:
                    return zzga.zza(zzo, "\u0001\n\u0000\u0001\u0001\n\n\u0000\u0000\u0001\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဌ\u0003\u0004ဉ\u0004\u0005ᐉ\u0005\u0006ဂ\u0006\u0007ဂ\u0007\bဇ\b\tင\t\nဉ\u0002", new Object[]{"zzc", "zzd", "zze", "zzg", zzkl.zzb(), "zzh", "zzi", "zzj", "zzk", "zzl", "zzm", "zzf"});
                case 4:
                    return zzo;
                case 5:
                    zzhu<zzf> zzhuVar = zzp;
                    if (zzhuVar == null) {
                        synchronized (zzf.class) {
                            zzhuVar = zzp;
                            if (zzhuVar == null) {
                                zzhuVar = new zzga.zza<>(zzo);
                                zzp = zzhuVar;
                            }
                        }
                    }
                    return zzhuVar;
                case 6:
                    return Byte.valueOf(this.zzn);
                case 7:
                    if (obj == null) {
                        i2 = 0;
                    }
                    this.zzn = (byte) i2;
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }
    }
}
