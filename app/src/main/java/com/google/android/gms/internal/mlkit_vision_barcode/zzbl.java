package com.google.android.gms.internal.mlkit_vision_barcode;

import androidx.core.app.FrameMetricsAggregator;
import com.google.android.gms.internal.mlkit_vision_barcode.zzdv;
import com.google.android.gms.internal.mlkit_vision_barcode.zzga;
import com.google.android.gms.internal.mlkit_vision_barcode.zzkf;
import com.google.firebase.messaging.ServiceStarter;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
/* loaded from: classes.dex */
public final class zzbl {

    /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
    /* loaded from: classes.dex */
    public static final class zzab extends zzga<zzab, zza> implements zzhm {
        private static final zzab zzj;
        private static volatile zzhu<zzab> zzk;
        private int zzc;
        private long zzd;
        private long zze;
        private long zzf;
        private long zzg;
        private long zzh;
        private long zzi;

        /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
        /* loaded from: classes.dex */
        public static final class zza extends zzga.zzb<zzab, zza> implements zzhm {
            private zza() {
                super(zzab.zzj);
            }

            /* synthetic */ zza(zzbk zzbkVar) {
                this();
            }

            public final zza zza(long j) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zzab) this.zza).zza(j);
                return this;
            }

            public final zza zzb(long j) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zzab) this.zza).zzb(j);
                return this;
            }

            public final zza zzc(long j) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zzab) this.zza).zzc(j);
                return this;
            }

            public final zza zzd(long j) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zzab) this.zza).zzd(j);
                return this;
            }

            public final zza zze(long j) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zzab) this.zza).zze(j);
                return this;
            }

            public final zza zzf(long j) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zzab) this.zza).zzf(j);
                return this;
            }
        }

        static {
            zzab zzabVar = new zzab();
            zzj = zzabVar;
            zzga.zza(zzab.class, zzabVar);
        }

        private zzab() {
        }

        public static zza zza() {
            return zzj.zzh();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(long j) {
            this.zzc |= 1;
            this.zzd = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzb(long j) {
            this.zzc |= 2;
            this.zze = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzc(long j) {
            this.zzc |= 4;
            this.zzf = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzd(long j) {
            this.zzc |= 8;
            this.zzg = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zze(long j) {
            this.zzc |= 16;
            this.zzh = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzf(long j) {
            this.zzc |= 32;
            this.zzi = j;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzga
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzbk.zza[i - 1]) {
                case 1:
                    return new zzab();
                case 2:
                    return new zza(null);
                case 3:
                    return zzga.zza(zzj, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ဃ\u0000\u0002ဃ\u0001\u0003ဃ\u0002\u0004ဃ\u0003\u0005ဃ\u0004\u0006ဃ\u0005", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi"});
                case 4:
                    return zzj;
                case 5:
                    zzhu<zzab> zzhuVar = zzk;
                    if (zzhuVar == null) {
                        synchronized (zzab.class) {
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

    /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
    /* loaded from: classes.dex */
    public static final class zzaj extends zzga<zzaj, zzb> implements zzhm {
        private static final zzaj zze;
        private static volatile zzhu<zzaj> zzf;
        private int zzc;
        private int zzd;

        /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
        /* loaded from: classes.dex */
        public enum zza implements zzgf {
            UNKNOWN(0),
            TRANSLATE(1);
            
            private static final zzge<zza> zzc = new zzcn();
            private final int zzd;

            zza(int i) {
                this.zzd = i;
            }

            public static zzgh zzb() {
                return zzcm.zza;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "<" + zza.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzd + " name=" + name() + '>';
            }

            @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzgf
            public final int zza() {
                return this.zzd;
            }
        }

        /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
        /* loaded from: classes.dex */
        public static final class zzb extends zzga.zzb<zzaj, zzb> implements zzhm {
            private zzb() {
                super(zzaj.zze);
            }

            /* synthetic */ zzb(zzbk zzbkVar) {
                this();
            }
        }

        static {
            zzaj zzajVar = new zzaj();
            zze = zzajVar;
            zzga.zza(zzaj.class, zzajVar);
        }

        private zzaj() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzga
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzbk.zza[i - 1]) {
                case 1:
                    return new zzaj();
                case 2:
                    return new zzb(null);
                case 3:
                    return zzga.zza(zze, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဌ\u0000", new Object[]{"zzc", "zzd", zza.zzb()});
                case 4:
                    return zze;
                case 5:
                    zzhu<zzaj> zzhuVar = zzf;
                    if (zzhuVar == null) {
                        synchronized (zzaj.class) {
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
    public static final class zzc extends zzga<zzc, zza> implements zzhm {
        private static final zzc zzg;
        private static volatile zzhu<zzc> zzh;
        private int zzc;
        private zzb zzd;
        private int zze;
        private zzab zzf;

        /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
        /* loaded from: classes.dex */
        public static final class zza extends zzga.zzb<zzc, zza> implements zzhm {
            private zza() {
                super(zzc.zzg);
            }

            public final zza zza(zzb zzbVar) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zzc) this.zza).zza(zzbVar);
                return this;
            }

            /* synthetic */ zza(zzbk zzbkVar) {
                this();
            }

            public final zza zza(int i) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zzc) this.zza).zzb(i);
                return this;
            }

            public final zza zza(zzab zzabVar) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zzc) this.zza).zza(zzabVar);
                return this;
            }
        }

        static {
            zzc zzcVar = new zzc();
            zzg = zzcVar;
            zzga.zza(zzc.class, zzcVar);
        }

        private zzc() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(zzb zzbVar) {
            zzbVar.getClass();
            this.zzd = zzbVar;
            this.zzc |= 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzb(int i) {
            this.zzc |= 2;
            this.zze = i;
        }

        /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
        /* loaded from: classes.dex */
        public static final class zzb extends zzga<zzb, zza> implements zzhm {
            private static final zzgi<Integer, zzao.zza> zzj = new zzbm();
            private static final zzgi<Integer, zzao.zzb> zzl = new zzbn();
            private static final zzb zzm;
            private static volatile zzhu<zzb> zzn;
            private int zzc;
            private int zzd;
            private boolean zze;
            private boolean zzf;
            private zzae zzg;
            private zzdv.zza zzh;
            private zzgj zzi = zzga.zzk();
            private zzgj zzk = zzga.zzk();

            /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
            /* loaded from: classes.dex */
            public static final class zza extends zzga.zzb<zzb, zza> implements zzhm {
                private zza() {
                    super(zzb.zzm);
                }

                public final zza zza(zzbv zzbvVar) {
                    if (this.zzb) {
                        zzc();
                        this.zzb = false;
                    }
                    ((zzb) this.zza).zza(zzbvVar);
                    return this;
                }

                public final zza zzb(Iterable<? extends zzao.zzb> iterable) {
                    if (this.zzb) {
                        zzc();
                        this.zzb = false;
                    }
                    ((zzb) this.zza).zzb(iterable);
                    return this;
                }

                /* synthetic */ zza(zzbk zzbkVar) {
                    this();
                }

                public final zza zza(boolean z) {
                    if (this.zzb) {
                        zzc();
                        this.zzb = false;
                    }
                    ((zzb) this.zza).zza(z);
                    return this;
                }

                public final zza zza(zzae zzaeVar) {
                    if (this.zzb) {
                        zzc();
                        this.zzb = false;
                    }
                    ((zzb) this.zza).zza(zzaeVar);
                    return this;
                }

                public final zza zza(zzdv.zza zzaVar) {
                    if (this.zzb) {
                        zzc();
                        this.zzb = false;
                    }
                    ((zzb) this.zza).zza(zzaVar);
                    return this;
                }

                public final zza zza(Iterable<? extends zzao.zza> iterable) {
                    if (this.zzb) {
                        zzc();
                        this.zzb = false;
                    }
                    ((zzb) this.zza).zza(iterable);
                    return this;
                }
            }

            static {
                zzb zzbVar = new zzb();
                zzm = zzbVar;
                zzga.zza(zzb.class, zzbVar);
            }

            private zzb() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void zza(zzbv zzbvVar) {
                this.zzd = zzbvVar.zza();
                this.zzc |= 1;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void zzb(Iterable<? extends zzao.zzb> iterable) {
                zzgj zzgjVar = this.zzk;
                if (!zzgjVar.zza()) {
                    this.zzk = zzga.zza(zzgjVar);
                }
                for (zzao.zzb zzbVar : iterable) {
                    this.zzk.zzd(zzbVar.zza());
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void zza(boolean z) {
                this.zzc |= 4;
                this.zzf = z;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void zza(zzae zzaeVar) {
                zzaeVar.getClass();
                this.zzg = zzaeVar;
                this.zzc |= 8;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void zza(zzdv.zza zzaVar) {
                zzaVar.getClass();
                this.zzh = zzaVar;
                this.zzc |= 16;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void zza(Iterable<? extends zzao.zza> iterable) {
                zzgj zzgjVar = this.zzi;
                if (!zzgjVar.zza()) {
                    this.zzi = zzga.zza(zzgjVar);
                }
                for (zzao.zza zzaVar : iterable) {
                    this.zzi.zzd(zzaVar.zza());
                }
            }

            public static zza zza() {
                return zzm.zzh();
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzga
            public final Object zza(int i, Object obj, Object obj2) {
                switch (zzbk.zza[i - 1]) {
                    case 1:
                        return new zzb();
                    case 2:
                        return new zza(null);
                    case 3:
                        return zzga.zza(zzm, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0002\u0000\u0001ဌ\u0000\u0002ဇ\u0001\u0003ဇ\u0002\u0004ဉ\u0003\u0005ဉ\u0004\u0006\u001e\u0007\u001e", new Object[]{"zzc", "zzd", zzbv.zzb(), "zze", "zzf", "zzg", "zzh", "zzi", zzao.zza.zzb(), "zzk", zzao.zzb.zzb()});
                    case 4:
                        return zzm;
                    case 5:
                        zzhu<zzb> zzhuVar = zzn;
                        if (zzhuVar == null) {
                            synchronized (zzb.class) {
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
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(zzab zzabVar) {
            zzabVar.getClass();
            this.zzf = zzabVar;
            this.zzc |= 4;
        }

        public static zza zza() {
            return zzg.zzh();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzga
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzbk.zza[i - 1]) {
                case 1:
                    return new zzc();
                case 2:
                    return new zza(null);
                case 3:
                    return zzga.zza(zzg, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဋ\u0001\u0003ဉ\u0002", new Object[]{"zzc", "zzd", "zze", "zzf"});
                case 4:
                    return zzg;
                case 5:
                    zzhu<zzc> zzhuVar = zzh;
                    if (zzhuVar == null) {
                        synchronized (zzc.class) {
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
    public static final class zzae extends zzga<zzae, zza> implements zzhm {
        private static final zzae zzg;
        private static volatile zzhu<zzae> zzh;
        private int zzc;
        private int zzd;
        private int zze;
        private int zzf;

        /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
        /* loaded from: classes.dex */
        public static final class zza extends zzga.zzb<zzae, zza> implements zzhm {
            private zza() {
                super(zzae.zzg);
            }

            public final zza zza(zzb zzbVar) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zzae) this.zza).zza(zzbVar);
                return this;
            }

            /* synthetic */ zza(zzbk zzbkVar) {
                this();
            }

            public final zza zza(int i) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zzae) this.zza).zzb(i);
                return this;
            }
        }

        /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
        /* loaded from: classes.dex */
        public enum zzb implements zzgf {
            UNKNOWN_FORMAT(0),
            NV16(1),
            NV21(2),
            YV12(3),
            YUV_420_888(7),
            JPEG(8),
            BITMAP(4),
            CM_SAMPLE_BUFFER_REF(5),
            UI_IMAGE(6);
            
            private static final zzge<zzb> zzj = new zzci();
            private final int zzk;

            zzb(int i) {
                this.zzk = i;
            }

            public static zzgh zzb() {
                return zzcj.zza;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "<" + zzb.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzk + " name=" + name() + '>';
            }

            @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzgf
            public final int zza() {
                return this.zzk;
            }
        }

        static {
            zzae zzaeVar = new zzae();
            zzg = zzaeVar;
            zzga.zza(zzae.class, zzaeVar);
        }

        private zzae() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(zzb zzbVar) {
            this.zzd = zzbVar.zza();
            this.zzc |= 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzb(int i) {
            this.zzc |= 2;
            this.zze = i;
        }

        public static zza zza() {
            return zzg.zzh();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzga
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzbk.zza[i - 1]) {
                case 1:
                    return new zzae();
                case 2:
                    return new zza(null);
                case 3:
                    return zzga.zza(zzg, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဋ\u0001\u0003ဋ\u0002", new Object[]{"zzc", "zzd", zzb.zzb(), "zze", "zzf"});
                case 4:
                    return zzg;
                case 5:
                    zzhu<zzae> zzhuVar = zzh;
                    if (zzhuVar == null) {
                        synchronized (zzae.class) {
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
    public static final class zzaf extends zzga<zzaf, zza> implements zzhm {
        private static final zzaf zzl;
        private static volatile zzhu<zzaf> zzm;
        private int zzc;
        private long zzd;
        private int zze;
        private boolean zzf;
        private boolean zzg;
        private boolean zzh;
        private boolean zzi;
        private int zzj;
        private zzgl<zzbf> zzk = zzga.zzm();

        /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
        /* loaded from: classes.dex */
        public static final class zza extends zzga.zzb<zzaf, zza> implements zzhm {
            private zza() {
                super(zzaf.zzl);
            }

            public final zza zza(long j) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zzaf) this.zza).zza(j);
                return this;
            }

            public final zza zzb(boolean z) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zzaf) this.zza).zzb(true);
                return this;
            }

            public final zza zzc(boolean z) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zzaf) this.zza).zzc(true);
                return this;
            }

            /* synthetic */ zza(zzbk zzbkVar) {
                this();
            }

            public final zza zza(zzbv zzbvVar) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zzaf) this.zza).zza(zzbvVar);
                return this;
            }

            public final zza zza(boolean z) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zzaf) this.zza).zza(z);
                return this;
            }
        }

        static {
            zzaf zzafVar = new zzaf();
            zzl = zzafVar;
            zzga.zza(zzaf.class, zzafVar);
        }

        private zzaf() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(long j) {
            this.zzc |= 1;
            this.zzd = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzb(boolean z) {
            this.zzc |= 8;
            this.zzg = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzc(boolean z) {
            this.zzc |= 16;
            this.zzh = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(zzbv zzbvVar) {
            this.zze = zzbvVar.zza();
            this.zzc |= 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(boolean z) {
            this.zzc |= 4;
            this.zzf = z;
        }

        public static zza zza() {
            return zzl.zzh();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzga
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzbk.zza[i - 1]) {
                case 1:
                    return new zzaf();
                case 2:
                    return new zza(null);
                case 3:
                    return zzga.zza(zzl, "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0001\u0000\u0001ဃ\u0000\u0002ဌ\u0001\u0003ဇ\u0002\u0004ဇ\u0003\u0005ဇ\u0004\u0006ဇ\u0005\u0007ဋ\u0006\b\u001b", new Object[]{"zzc", "zzd", "zze", zzbv.zzb(), "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", zzbf.class});
                case 4:
                    return zzl;
                case 5:
                    zzhu<zzaf> zzhuVar = zzm;
                    if (zzhuVar == null) {
                        synchronized (zzaf.class) {
                            zzhuVar = zzm;
                            if (zzhuVar == null) {
                                zzhuVar = new zzga.zza<>(zzl);
                                zzm = zzhuVar;
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
    public static final class zzad extends zzga.zzc<zzad, zza> implements zzhm {
        private static final zzad zzbd;
        private static volatile zzhu<zzad> zzbe;
        private zzp zzaa;
        private zzm zzab;
        private zzo zzac;
        private zzr zzad;
        private zzq zzae;
        private zzs zzaf;
        private zzt zzag;
        private zzu zzah;
        private zzv zzai;
        private zzw zzaj;
        private zzj zzak;
        private zzl zzal;
        private zzk zzam;
        private zzah zzan;
        private zzaa zzao;
        private zza zzap;
        private zzb zzaq;
        private zzd zzar;
        private zzc zzas;
        private zze zzat;
        private zzf zzau;
        private zzi zzav;
        private zzg zzaw;
        private zzh zzax;
        private zzbg zzaz;
        private zzag zzba;
        private zzaj zzbb;
        private int zzd;
        private int zze;
        private zzbh zzf;
        private int zzg;
        private boolean zzh;
        private zzak zzi;
        private zzz zzj;
        private zzy zzk;
        private zzx zzl;
        private zzap zzm;
        private zzbd zzn;
        private zzao zzo;
        private zzaq zzp;
        private zzas zzq;
        private zzar zzr;
        private zzav zzs;
        private zzay zzt;
        private zzax zzu;
        private zzaz zzv;
        private zzbb zzw;
        private zzbc zzx;
        private zzau zzy;
        private zzbe zzz;
        private byte zzbc = 2;
        private zzgl<zzkf.zzf> zzay = zzga.zzm();

        static {
            zzad zzadVar = new zzad();
            zzbd = zzadVar;
            zzga.zza(zzad.class, zzadVar);
        }

        private zzad() {
        }

        public static zza zza(zzad zzadVar) {
            return (zza) zzbd.zza(zzadVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(zzao zzaoVar) {
            zzaoVar.getClass();
            this.zzo = zzaoVar;
            this.zzd |= 512;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(zzbh zzbhVar) {
            zzbhVar.getClass();
            this.zzf = zzbhVar;
            this.zzd |= 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(zzc zzcVar) {
            zzcVar.getClass();
            this.zzas = zzcVar;
            this.zze |= 128;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(zzbw zzbwVar) {
            this.zzg = zzbwVar.zza();
            this.zzd |= 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(boolean z) {
            this.zzd |= 4;
            this.zzh = z;
        }

        public static zza zzb() {
            return (zza) zzbd.zzh();
        }

        public final zzbh zza() {
            zzbh zzbhVar = this.zzf;
            return zzbhVar == null ? zzbh.zzc() : zzbhVar;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzga
        public final Object zza(int i, Object obj, Object obj2) {
            int i2 = 1;
            switch (zzbk.zza[i - 1]) {
                case 1:
                    return new zzad();
                case 2:
                    return new zza(null);
                case 3:
                    return zzga.zza(zzbd, "\u00011\u0000\u0002\u000131\u0000\u0001\u0001\u0001ဉ\u0000\u0002ဌ\u0001\u0003ဉ\u0003\u0004ဉ\u0005\u0005ဉ\u0007\u0006ဉ\b\u0007ဉ\t\bဉ\u0015\tဉ\u0016\nဉ\u0017\u000bဉ\u0018\fဉ\u0019\rဉ\u001a\u000eဉ\u001b\u000fဉ\u001c\u0010ဉ\u001d\u0011ဉ\u001e\u0012ဉ\f\u0013ဉ\u0012\u0014ဉ\u0004\u0015ဉ\u0013\u0016ဉ\u0014\u0017ဉ\u001f\u0018ဉ \u0019ဉ!\u001aဉ\r\u001bဉ\u000e\u001cဉ\u000f\u001dဉ\u0006\u001eဉ$\u001fဉ% ဉ&!ဉ'\"ဉ(#ဉ)$ဉ*%ဇ\u0002'ဉ\"(ဉ#)Л*ဉ-,ဉ\u0010-ဉ\u0011.ဉ+/ဉ,0ဉ\n1ဉ\u000b2ဉ.3ဉ/", new Object[]{"zzd", "zze", "zzf", "zzg", zzbw.zzb(), "zzi", "zzk", "zzm", "zzn", "zzo", "zzaa", "zzab", "zzac", "zzad", "zzae", "zzaf", "zzag", "zzah", "zzai", "zzaj", "zzr", "zzx", "zzj", "zzy", "zzz", "zzak", "zzal", "zzam", "zzs", "zzt", "zzu", "zzl", "zzap", "zzaq", "zzar", "zzas", "zzat", "zzau", "zzav", "zzh", "zzan", "zzao", "zzay", zzkf.zzf.class, "zzaz", "zzv", "zzw", "zzaw", "zzax", "zzp", "zzq", "zzba", "zzbb"});
                case 4:
                    return zzbd;
                case 5:
                    zzhu<zzad> zzhuVar = zzbe;
                    if (zzhuVar == null) {
                        synchronized (zzad.class) {
                            zzhuVar = zzbe;
                            if (zzhuVar == null) {
                                zzhuVar = new zzga.zza<>(zzbd);
                                zzbe = zzhuVar;
                            }
                        }
                    }
                    return zzhuVar;
                case 6:
                    return Byte.valueOf(this.zzbc);
                case 7:
                    if (obj == null) {
                        i2 = 0;
                    }
                    this.zzbc = (byte) i2;
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
        /* loaded from: classes.dex */
        public static final class zza extends zzga.zzd<zzad, zza> implements zzhm {
            private zza() {
                super(zzad.zzbd);
            }

            /* synthetic */ zza(zzbk zzbkVar) {
                this();
            }

            public final zza zza(zzbh.zza zzaVar) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zzad) this.zza).zza((zzbh) ((zzga) zzaVar.zzg()));
                return this;
            }

            public final zzbh zza() {
                return ((zzad) this.zza).zza();
            }

            public final zza zza(zzbw zzbwVar) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zzad) this.zza).zza(zzbwVar);
                return this;
            }

            public final zza zza(boolean z) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zzad) this.zza).zza(z);
                return this;
            }

            public final zza zza(zzao zzaoVar) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zzad) this.zza).zza(zzaoVar);
                return this;
            }

            public final zza zza(zzao.zzc zzcVar) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zzad) this.zza).zza((zzao) ((zzga) zzcVar.zzg()));
                return this;
            }

            public final zza zza(zzc.zza zzaVar) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zzad) this.zza).zza((zzc) ((zzga) zzaVar.zzg()));
                return this;
            }
        }
    }

    /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
    /* loaded from: classes.dex */
    public static final class zzao extends zzga<zzao, zzc> implements zzhm {
        private static final zzgi<Integer, zza> zzg = new zzcx();
        private static final zzgi<Integer, zzb> zzi = new zzcw();
        private static final zzao zzk;
        private static volatile zzhu<zzao> zzl;
        private int zzc;
        private zzaf zzd;
        private zzdv.zza zze;
        private zzgj zzf = zzga.zzk();
        private zzgj zzh = zzga.zzk();
        private zzae zzj;

        /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
        /* loaded from: classes.dex */
        public enum zza implements zzgf {
            FORMAT_UNKNOWN(0),
            FORMAT_CODE_128(1),
            FORMAT_CODE_39(2),
            FORMAT_CODE_93(4),
            FORMAT_CODABAR(8),
            FORMAT_DATA_MATRIX(16),
            FORMAT_EAN_13(32),
            FORMAT_EAN_8(64),
            FORMAT_ITF(128),
            FORMAT_QR_CODE(256),
            FORMAT_UPC_A(512),
            FORMAT_UPC_E(1024),
            FORMAT_PDF417(2048),
            FORMAT_AZTEC(4096);
            
            private static final zzge<zza> zzo = new zzcy();
            private final int zzp;

            zza(int i) {
                this.zzp = i;
            }

            public static zzgh zzb() {
                return zzcz.zza;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "<" + zza.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzp + " name=" + name() + '>';
            }

            @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzgf
            public final int zza() {
                return this.zzp;
            }
        }

        /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
        /* loaded from: classes.dex */
        public enum zzb implements zzgf {
            TYPE_UNKNOWN(0),
            TYPE_CONTACT_INFO(1),
            TYPE_EMAIL(2),
            TYPE_ISBN(3),
            TYPE_PHONE(4),
            TYPE_PRODUCT(5),
            TYPE_SMS(6),
            TYPE_TEXT(7),
            TYPE_URL(8),
            TYPE_WIFI(9),
            TYPE_GEO(10),
            TYPE_CALENDAR_EVENT(11),
            TYPE_DRIVER_LICENSE(12);
            
            private static final zzge<zzb> zzn = new zzdb();
            private final int zzo;

            zzb(int i) {
                this.zzo = i;
            }

            public static zzgh zzb() {
                return zzda.zza;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "<" + zzb.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzo + " name=" + name() + '>';
            }

            @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzgf
            public final int zza() {
                return this.zzo;
            }
        }

        /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
        /* loaded from: classes.dex */
        public static final class zzc extends zzga.zzb<zzao, zzc> implements zzhm {
            private zzc() {
                super(zzao.zzk);
            }

            public final zzc zza(zzaf.zza zzaVar) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zzao) this.zza).zza((zzaf) ((zzga) zzaVar.zzg()));
                return this;
            }

            public final zzc zzb(Iterable<? extends zzb> iterable) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zzao) this.zza).zzb(iterable);
                return this;
            }

            /* synthetic */ zzc(zzbk zzbkVar) {
                this();
            }

            public final zzc zza(zzdv.zza zzaVar) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zzao) this.zza).zza(zzaVar);
                return this;
            }

            public final zzc zza(Iterable<? extends zza> iterable) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zzao) this.zza).zza(iterable);
                return this;
            }

            public final zzc zza(zzae zzaeVar) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zzao) this.zza).zza(zzaeVar);
                return this;
            }
        }

        static {
            zzao zzaoVar = new zzao();
            zzk = zzaoVar;
            zzga.zza(zzao.class, zzaoVar);
        }

        private zzao() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(zzaf zzafVar) {
            zzafVar.getClass();
            this.zzd = zzafVar;
            this.zzc |= 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzb(Iterable<? extends zzb> iterable) {
            zzgj zzgjVar = this.zzh;
            if (!zzgjVar.zza()) {
                this.zzh = zzga.zza(zzgjVar);
            }
            for (zzb zzbVar : iterable) {
                this.zzh.zzd(zzbVar.zza());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(zzdv.zza zzaVar) {
            zzaVar.getClass();
            this.zze = zzaVar;
            this.zzc |= 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(Iterable<? extends zza> iterable) {
            zzgj zzgjVar = this.zzf;
            if (!zzgjVar.zza()) {
                this.zzf = zzga.zza(zzgjVar);
            }
            for (zza zzaVar : iterable) {
                this.zzf.zzd(zzaVar.zza());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(zzae zzaeVar) {
            zzaeVar.getClass();
            this.zzj = zzaeVar;
            this.zzc |= 4;
        }

        public static zzc zza() {
            return zzk.zzh();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzga
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzbk.zza[i - 1]) {
                case 1:
                    return new zzao();
                case 2:
                    return new zzc(null);
                case 3:
                    return zzga.zza(zzk, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0002\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003\u001e\u0004\u001e\u0005ဉ\u0002", new Object[]{"zzc", "zzd", "zze", "zzf", zza.zzb(), "zzh", zzb.zzb(), "zzj"});
                case 4:
                    return zzk;
                case 5:
                    zzhu<zzao> zzhuVar = zzl;
                    if (zzhuVar == null) {
                        synchronized (zzao.class) {
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
    public static final class zzbh extends zzga<zzbh, zza> implements zzhm {
        private static final zzbh zzo;
        private static volatile zzhu<zzbh> zzp;
        private int zzc;
        private String zzd = "";
        private String zze = "";
        private String zzf = "";
        private String zzg = "";
        private String zzh = "";
        private String zzi = "";
        private String zzj = "";
        private zzgl<String> zzk = zzga.zzm();
        private String zzl = "";
        private boolean zzm;
        private boolean zzn;

        /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
        /* loaded from: classes.dex */
        public static final class zza extends zzga.zzb<zzbh, zza> implements zzhm {
            private zza() {
                super(zzbh.zzo);
            }

            public final zza zza(String str) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zzbh) this.zza).zza(str);
                return this;
            }

            public final zza zzb(String str) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zzbh) this.zza).zzb(str);
                return this;
            }

            public final zza zzc(String str) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zzbh) this.zza).zzc(str);
                return this;
            }

            public final zza zzd(String str) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zzbh) this.zza).zzd(str);
                return this;
            }

            public final zza zze(String str) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zzbh) this.zza).zze(str);
                return this;
            }

            /* synthetic */ zza(zzbk zzbkVar) {
                this();
            }

            public final zza zza(Iterable<String> iterable) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zzbh) this.zza).zza(iterable);
                return this;
            }

            public final zza zzb(boolean z) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zzbh) this.zza).zzb(true);
                return this;
            }

            public final zza zza(boolean z) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zzbh) this.zza).zza(true);
                return this;
            }
        }

        static {
            zzbh zzbhVar = new zzbh();
            zzo = zzbhVar;
            zzga.zza(zzbh.class, zzbhVar);
        }

        private zzbh() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(String str) {
            str.getClass();
            this.zzc |= 1;
            this.zzd = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzb(String str) {
            str.getClass();
            this.zzc |= 2;
            this.zze = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzc(String str) {
            str.getClass();
            this.zzc |= 8;
            this.zzg = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzd(String str) {
            str.getClass();
            this.zzc |= 16;
            this.zzh = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zze(String str) {
            str.getClass();
            this.zzc |= 128;
            this.zzl = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzb(boolean z) {
            this.zzc |= 512;
            this.zzn = z;
        }

        public static zzbh zzc() {
            return zzo;
        }

        public final String zza() {
            return this.zzh;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(Iterable<String> iterable) {
            zzgl<String> zzglVar = this.zzk;
            if (!zzglVar.zza()) {
                int size = zzglVar.size();
                this.zzk = zzglVar.zza(size == 0 ? 10 : size << 1);
            }
            zzer.zza(iterable, this.zzk);
        }

        public static zza zzb() {
            return zzo.zzh();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(boolean z) {
            this.zzc |= 256;
            this.zzm = z;
        }

        public static zza zza(zzbh zzbhVar) {
            return zzo.zza(zzbhVar);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzga
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzbk.zza[i - 1]) {
                case 1:
                    return new zzbh();
                case 2:
                    return new zza(null);
                case 3:
                    return zzga.zza(zzo, "\u0001\u000b\u0000\u0001\u0001\u000b\u000b\u0000\u0001\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004ဈ\u0003\u0005ဈ\u0004\u0006ဈ\u0005\u0007ဈ\u0006\b\u001a\tဈ\u0007\nဇ\b\u000bဇ\t", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", "zzm", "zzn"});
                case 4:
                    return zzo;
                case 5:
                    zzhu<zzbh> zzhuVar = zzp;
                    if (zzhuVar == null) {
                        synchronized (zzbh.class) {
                            zzhuVar = zzp;
                            if (zzhuVar == null) {
                                zzhuVar = new zzga.zza<>(zzo);
                                zzp = zzhuVar;
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
    public static final class zzam extends zzga<zzam, zza> implements zzhm {
        private static final zzam zzh;
        private static volatile zzhu<zzam> zzi;
        private int zzc;
        private zzal zzd;
        private zzb zze;
        private zzb zzf;
        private boolean zzg;

        /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
        /* loaded from: classes.dex */
        public static final class zza extends zzga.zzb<zzam, zza> implements zzhm {
            private zza() {
                super(zzam.zzh);
            }

            /* synthetic */ zza(zzbk zzbkVar) {
                this();
            }
        }

        static {
            zzam zzamVar = new zzam();
            zzh = zzamVar;
            zzga.zza(zzam.class, zzamVar);
        }

        private zzam() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzga
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzbk.zza[i - 1]) {
                case 1:
                    return new zzam();
                case 2:
                    return new zza(null);
                case 3:
                    return zzga.zza(zzh, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002\u0004ဇ\u0003", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg"});
                case 4:
                    return zzh;
                case 5:
                    zzhu<zzam> zzhuVar = zzi;
                    if (zzhuVar == null) {
                        synchronized (zzam.class) {
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

        /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
        /* loaded from: classes.dex */
        public static final class zzb extends zzga<zzb, zza> implements zzhm {
            private static final zzb zzh;
            private static volatile zzhu<zzb> zzi;
            private int zzc;
            private boolean zzd;
            private boolean zze;
            private boolean zzf;
            private boolean zzg;

            /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
            /* loaded from: classes.dex */
            public static final class zza extends zzga.zzb<zzb, zza> implements zzhm {
                private zza() {
                    super(zzb.zzh);
                }

                /* synthetic */ zza(zzbk zzbkVar) {
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
                switch (zzbk.zza[i - 1]) {
                    case 1:
                        return new zzb();
                    case 2:
                        return new zza(null);
                    case 3:
                        return zzga.zza(zzh, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဇ\u0000\u0002ဇ\u0001\u0003ဇ\u0002\u0004ဇ\u0003", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg"});
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
    public static final class zzau extends zzga<zzau, zza> implements zzhm {
        private static final zzau zzh;
        private static volatile zzhu<zzau> zzi;
        private int zzc;
        private zzaf zzd;
        private zzai zze;
        private zzc zzf;
        private zzd zzg;

        /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
        /* loaded from: classes.dex */
        public static final class zza extends zzga.zzb<zzau, zza> implements zzhm {
            private zza() {
                super(zzau.zzh);
            }

            /* synthetic */ zza(zzbk zzbkVar) {
                this();
            }
        }

        static {
            zzau zzauVar = new zzau();
            zzh = zzauVar;
            zzga.zza(zzau.class, zzauVar);
        }

        private zzau() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzga
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzbk.zza[i - 1]) {
                case 1:
                    return new zzau();
                case 2:
                    return new zza(null);
                case 3:
                    return zzga.zza(zzh, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002\u0004ဉ\u0003", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg"});
                case 4:
                    return zzh;
                case 5:
                    zzhu<zzau> zzhuVar = zzi;
                    if (zzhuVar == null) {
                        synchronized (zzau.class) {
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

        /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
        /* loaded from: classes.dex */
        public static final class zzb extends zzga<zzb, zza> implements zzhm {
            private static final zzb zzf;
            private static volatile zzhu<zzb> zzg;
            private int zzc;
            private float zzd;
            private String zze = "";

            /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
            /* loaded from: classes.dex */
            public static final class zza extends zzga.zzb<zzb, zza> implements zzhm {
                private zza() {
                    super(zzb.zzf);
                }

                /* synthetic */ zza(zzbk zzbkVar) {
                    this();
                }
            }

            static {
                zzb zzbVar = new zzb();
                zzf = zzbVar;
                zzga.zza(zzb.class, zzbVar);
            }

            private zzb() {
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzga
            public final Object zza(int i, Object obj, Object obj2) {
                switch (zzbk.zza[i - 1]) {
                    case 1:
                        return new zzb();
                    case 2:
                        return new zza(null);
                    case 3:
                        return zzga.zza(zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ခ\u0000\u0002ဈ\u0001", new Object[]{"zzc", "zzd", "zze"});
                    case 4:
                        return zzf;
                    case 5:
                        zzhu<zzb> zzhuVar = zzg;
                        if (zzhuVar == null) {
                            synchronized (zzb.class) {
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
        public static final class zzc extends zzga<zzc, zza> implements zzhm {
            private static final zzc zze;
            private static volatile zzhu<zzc> zzf;
            private int zzc;
            private zzb zzd;

            /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
            /* loaded from: classes.dex */
            public static final class zza extends zzga.zzb<zzc, zza> implements zzhm {
                private zza() {
                    super(zzc.zze);
                }

                /* synthetic */ zza(zzbk zzbkVar) {
                    this();
                }
            }

            static {
                zzc zzcVar = new zzc();
                zze = zzcVar;
                zzga.zza(zzc.class, zzcVar);
            }

            private zzc() {
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzga
            public final Object zza(int i, Object obj, Object obj2) {
                switch (zzbk.zza[i - 1]) {
                    case 1:
                        return new zzc();
                    case 2:
                        return new zza(null);
                    case 3:
                        return zzga.zza(zze, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"zzc", "zzd"});
                    case 4:
                        return zze;
                    case 5:
                        zzhu<zzc> zzhuVar = zzf;
                        if (zzhuVar == null) {
                            synchronized (zzc.class) {
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
        public static final class zzd extends zzga<zzd, zza> implements zzhm {
            private static final zzd zzd;
            private static volatile zzhu<zzd> zze;
            private zzgl<zzb> zzc = zzga.zzm();

            /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
            /* loaded from: classes.dex */
            public static final class zza extends zzga.zzb<zzd, zza> implements zzhm {
                private zza() {
                    super(zzd.zzd);
                }

                /* synthetic */ zza(zzbk zzbkVar) {
                    this();
                }
            }

            static {
                zzd zzdVar = new zzd();
                zzd = zzdVar;
                zzga.zza(zzd.class, zzdVar);
            }

            private zzd() {
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzga
            public final Object zza(int i, Object obj, Object obj2) {
                switch (zzbk.zza[i - 1]) {
                    case 1:
                        return new zzd();
                    case 2:
                        return new zza(null);
                    case 3:
                        return zzga.zza(zzd, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzc", zzb.class});
                    case 4:
                        return zzd;
                    case 5:
                        zzhu<zzd> zzhuVar = zze;
                        if (zzhuVar == null) {
                            synchronized (zzd.class) {
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
    }

    /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
    /* loaded from: classes.dex */
    public static final class zzbc extends zzga<zzbc, zzb> implements zzhm {
        private static final zzbc zzi;
        private static volatile zzhu<zzbc> zzj;
        private int zzc;
        private zzaf zzd;
        private zzgl<zzc> zze = zzga.zzm();
        private int zzf;
        private int zzg;
        private int zzh;

        /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
        /* loaded from: classes.dex */
        public enum zza implements zzgf {
            NO_ERROR(0),
            STATUS_SENSITIVE_TOPIC(1),
            STATUS_QUALITY_THRESHOLDED(2),
            STATUS_INTERNAL_ERROR(3),
            STATUS_NOT_SUPPORTED_LANGUAGE(101),
            STATUS_32_BIT_CPU(1001),
            STATUS_32_BIT_APP(1002);
            
            private static final zzge<zza> zzh = new zzdk();
            private final int zzi;

            zza(int i) {
                this.zzi = i;
            }

            public static zzgh zzb() {
                return zzdj.zza;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "<" + zza.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzi + " name=" + name() + '>';
            }

            @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzgf
            public final int zza() {
                return this.zzi;
            }
        }

        /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
        /* loaded from: classes.dex */
        public static final class zzb extends zzga.zzb<zzbc, zzb> implements zzhm {
            private zzb() {
                super(zzbc.zzi);
            }

            /* synthetic */ zzb(zzbk zzbkVar) {
                this();
            }
        }

        static {
            zzbc zzbcVar = new zzbc();
            zzi = zzbcVar;
            zzga.zza(zzbc.class, zzbcVar);
        }

        private zzbc() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzga
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzbk.zza[i - 1]) {
                case 1:
                    return new zzbc();
                case 2:
                    return new zzb(null);
                case 3:
                    return zzga.zza(zzi, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0000\u0001ဉ\u0000\u0002\u001b\u0003ဌ\u0001\u0004င\u0002\u0005င\u0003", new Object[]{"zzc", "zzd", "zze", zzc.class, "zzf", zza.zzb(), "zzg", "zzh"});
                case 4:
                    return zzi;
                case 5:
                    zzhu<zzbc> zzhuVar = zzj;
                    if (zzhuVar == null) {
                        synchronized (zzbc.class) {
                            zzhuVar = zzj;
                            if (zzhuVar == null) {
                                zzhuVar = new zzga.zza<>(zzi);
                                zzj = zzhuVar;
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
        public static final class zzc extends zzga<zzc, zza> implements zzhm {
            private static final zzc zze;
            private static volatile zzhu<zzc> zzf;
            private int zzc;
            private float zzd;

            /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
            /* loaded from: classes.dex */
            public static final class zza extends zzga.zzb<zzc, zza> implements zzhm {
                private zza() {
                    super(zzc.zze);
                }

                /* synthetic */ zza(zzbk zzbkVar) {
                    this();
                }
            }

            static {
                zzc zzcVar = new zzc();
                zze = zzcVar;
                zzga.zza(zzc.class, zzcVar);
            }

            private zzc() {
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzga
            public final Object zza(int i, Object obj, Object obj2) {
                switch (zzbk.zza[i - 1]) {
                    case 1:
                        return new zzc();
                    case 2:
                        return new zza(null);
                    case 3:
                        return zzga.zza(zze, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ခ\u0000", new Object[]{"zzc", "zzd"});
                    case 4:
                        return zze;
                    case 5:
                        zzhu<zzc> zzhuVar = zzf;
                        if (zzhuVar == null) {
                            synchronized (zzc.class) {
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
    }

    /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
    /* loaded from: classes.dex */
    public static final class zza extends zzga<zza, C0119zza> implements zzhm {
        private static final zza zzg;
        private static volatile zzhu<zza> zzh;
        private int zzc;
        private zzb zzd;
        private int zze;
        private zzab zzf;

        /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
        /* renamed from: com.google.android.gms.internal.mlkit_vision_barcode.zzbl$zza$zza  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0119zza extends zzga.zzb<zza, C0119zza> implements zzhm {
            private C0119zza() {
                super(zza.zzg);
            }

            /* synthetic */ C0119zza(zzbk zzbkVar) {
                this();
            }
        }

        static {
            zza zzaVar = new zza();
            zzg = zzaVar;
            zzga.zza(zza.class, zzaVar);
        }

        private zza() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzga
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzbk.zza[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new C0119zza(null);
                case 3:
                    return zzga.zza(zzg, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဋ\u0001\u0003ဉ\u0002", new Object[]{"zzc", "zzd", "zze", "zzf"});
                case 4:
                    return zzg;
                case 5:
                    zzhu<zza> zzhuVar = zzh;
                    if (zzhuVar == null) {
                        synchronized (zza.class) {
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

        /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
        /* loaded from: classes.dex */
        public static final class zzb extends zzga<zzb, C0120zza> implements zzhm {
            private static final zzb zzh;
            private static volatile zzhu<zzb> zzi;
            private int zzc;
            private int zzd;
            private boolean zze;
            private zzae zzf;
            private zzam zzg;

            /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
            /* renamed from: com.google.android.gms.internal.mlkit_vision_barcode.zzbl$zza$zzb$zza  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            public static final class C0120zza extends zzga.zzb<zzb, C0120zza> implements zzhm {
                private C0120zza() {
                    super(zzb.zzh);
                }

                /* synthetic */ C0120zza(zzbk zzbkVar) {
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
                switch (zzbk.zza[i - 1]) {
                    case 1:
                        return new zzb();
                    case 2:
                        return new C0120zza(null);
                    case 3:
                        return zzga.zza(zzh, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဇ\u0001\u0003ဉ\u0002\u0004ဉ\u0003", new Object[]{"zzc", "zzd", zzbv.zzb(), "zze", "zzf", "zzg"});
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
    public static final class zzai extends zzga<zzai, zza> implements zzhm {
        private static final zzai zzg;
        private static volatile zzhu<zzai> zzh;
        private int zzc;
        private float zzd;
        private float zze;
        private float zzf;

        /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
        /* loaded from: classes.dex */
        public static final class zza extends zzga.zzb<zzai, zza> implements zzhm {
            private zza() {
                super(zzai.zzg);
            }

            /* synthetic */ zza(zzbk zzbkVar) {
                this();
            }
        }

        static {
            zzai zzaiVar = new zzai();
            zzg = zzaiVar;
            zzga.zza(zzai.class, zzaiVar);
        }

        private zzai() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzga
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzbk.zza[i - 1]) {
                case 1:
                    return new zzai();
                case 2:
                    return new zza(null);
                case 3:
                    return zzga.zza(zzg, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ခ\u0000\u0002ခ\u0001\u0003ခ\u0002", new Object[]{"zzc", "zzd", "zze", "zzf"});
                case 4:
                    return zzg;
                case 5:
                    zzhu<zzai> zzhuVar = zzh;
                    if (zzhuVar == null) {
                        synchronized (zzai.class) {
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
    public static final class zzap extends zzga<zzap, zza> implements zzhm {
        private static final zzap zzj;
        private static volatile zzhu<zzap> zzk;
        private int zzc;
        private zzaf zzd;
        private zzdv.zzb zze;
        private zzae zzf;
        private zzac zzg;
        private int zzh;
        private int zzi;

        /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
        /* loaded from: classes.dex */
        public static final class zza extends zzga.zzb<zzap, zza> implements zzhm {
            private zza() {
                super(zzap.zzj);
            }

            /* synthetic */ zza(zzbk zzbkVar) {
                this();
            }
        }

        static {
            zzap zzapVar = new zzap();
            zzj = zzapVar;
            zzga.zza(zzap.class, zzapVar);
        }

        private zzap() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzga
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzbk.zza[i - 1]) {
                case 1:
                    return new zzap();
                case 2:
                    return new zza(null);
                case 3:
                    return zzga.zza(zzj, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002\u0004ဉ\u0003\u0005ဋ\u0004\u0006ဋ\u0005", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi"});
                case 4:
                    return zzj;
                case 5:
                    zzhu<zzap> zzhuVar = zzk;
                    if (zzhuVar == null) {
                        synchronized (zzap.class) {
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

    /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
    /* loaded from: classes.dex */
    public static final class zzar extends zzga<zzar, zza> implements zzhm {
        private static final zzar zzi;
        private static volatile zzhu<zzar> zzj;
        private int zzc;
        private zzaf zzd;
        private zzat zze;
        private zzae zzf;
        private int zzg;
        private float zzh;

        /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
        /* loaded from: classes.dex */
        public static final class zza extends zzga.zzb<zzar, zza> implements zzhm {
            private zza() {
                super(zzar.zzi);
            }

            /* synthetic */ zza(zzbk zzbkVar) {
                this();
            }
        }

        static {
            zzar zzarVar = new zzar();
            zzi = zzarVar;
            zzga.zza(zzar.class, zzarVar);
        }

        private zzar() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzga
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzbk.zza[i - 1]) {
                case 1:
                    return new zzar();
                case 2:
                    return new zza(null);
                case 3:
                    return zzga.zza(zzi, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002\u0004ဋ\u0003\u0005ခ\u0004", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh"});
                case 4:
                    return zzi;
                case 5:
                    zzhu<zzar> zzhuVar = zzj;
                    if (zzhuVar == null) {
                        synchronized (zzar.class) {
                            zzhuVar = zzj;
                            if (zzhuVar == null) {
                                zzhuVar = new zzga.zza<>(zzi);
                                zzj = zzhuVar;
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
    public static final class zzat extends zzga<zzat, zza> implements zzhm {
        private static final zzat zzg;
        private static volatile zzhu<zzat> zzh;
        private int zzc;
        private int zzd;
        private float zze;
        private zzam zzf;

        /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
        /* loaded from: classes.dex */
        public static final class zza extends zzga.zzb<zzat, zza> implements zzhm {
            private zza() {
                super(zzat.zzg);
            }

            /* synthetic */ zza(zzbk zzbkVar) {
                this();
            }
        }

        static {
            zzat zzatVar = new zzat();
            zzg = zzatVar;
            zzga.zza(zzat.class, zzatVar);
        }

        private zzat() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzga
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzbk.zza[i - 1]) {
                case 1:
                    return new zzat();
                case 2:
                    return new zza(null);
                case 3:
                    return zzga.zza(zzg, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဋ\u0000\u0002ခ\u0001\u0003ဉ\u0002", new Object[]{"zzc", "zzd", "zze", "zzf"});
                case 4:
                    return zzg;
                case 5:
                    zzhu<zzat> zzhuVar = zzh;
                    if (zzhuVar == null) {
                        synchronized (zzat.class) {
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
    public static final class zzaz extends zzga<zzaz, zza> implements zzhm {
        private static final zzaz zzg;
        private static volatile zzhu<zzaz> zzh;
        private int zzc;
        private zzaf zzd;
        private zzae zze;
        private zzba zzf;

        /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
        /* loaded from: classes.dex */
        public static final class zza extends zzga.zzb<zzaz, zza> implements zzhm {
            private zza() {
                super(zzaz.zzg);
            }

            /* synthetic */ zza(zzbk zzbkVar) {
                this();
            }
        }

        static {
            zzaz zzazVar = new zzaz();
            zzg = zzazVar;
            zzga.zza(zzaz.class, zzazVar);
        }

        private zzaz() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzga
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzbk.zza[i - 1]) {
                case 1:
                    return new zzaz();
                case 2:
                    return new zza(null);
                case 3:
                    return zzga.zza(zzg, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002", new Object[]{"zzc", "zzd", "zze", "zzf"});
                case 4:
                    return zzg;
                case 5:
                    zzhu<zzaz> zzhuVar = zzh;
                    if (zzhuVar == null) {
                        synchronized (zzaz.class) {
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
    public static final class zzb extends zzga<zzb, zza> implements zzhm {
        private static final zzb zzg;
        private static volatile zzhu<zzb> zzh;
        private int zzc;
        private C0121zzb zzd;
        private int zze;
        private zzab zzf;

        /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
        /* loaded from: classes.dex */
        public static final class zza extends zzga.zzb<zzb, zza> implements zzhm {
            private zza() {
                super(zzb.zzg);
            }

            /* synthetic */ zza(zzbk zzbkVar) {
                this();
            }
        }

        static {
            zzb zzbVar = new zzb();
            zzg = zzbVar;
            zzga.zza(zzb.class, zzbVar);
        }

        private zzb() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzga
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzbk.zza[i - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return new zza(null);
                case 3:
                    return zzga.zza(zzg, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဋ\u0001\u0003ဉ\u0002", new Object[]{"zzc", "zzd", "zze", "zzf"});
                case 4:
                    return zzg;
                case 5:
                    zzhu<zzb> zzhuVar = zzh;
                    if (zzhuVar == null) {
                        synchronized (zzb.class) {
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

        /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
        /* renamed from: com.google.android.gms.internal.mlkit_vision_barcode.zzbl$zzb$zzb  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0121zzb extends zzga<C0121zzb, zza> implements zzhm {
            private static final C0121zzb zzi;
            private static volatile zzhu<C0121zzb> zzj;
            private int zzc;
            private int zzd;
            private boolean zze;
            private zzgl<zzy.zzb> zzf = zzga.zzm();
            private zzgl<zzy.zzb> zzg = zzga.zzm();
            private zzam zzh;

            /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
            /* renamed from: com.google.android.gms.internal.mlkit_vision_barcode.zzbl$zzb$zzb$zza */
            /* loaded from: classes.dex */
            public static final class zza extends zzga.zzb<C0121zzb, zza> implements zzhm {
                private zza() {
                    super(C0121zzb.zzi);
                }

                /* synthetic */ zza(zzbk zzbkVar) {
                    this();
                }
            }

            static {
                C0121zzb zzbVar = new C0121zzb();
                zzi = zzbVar;
                zzga.zza(C0121zzb.class, zzbVar);
            }

            private C0121zzb() {
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzga
            public final Object zza(int i, Object obj, Object obj2) {
                switch (zzbk.zza[i - 1]) {
                    case 1:
                        return new C0121zzb();
                    case 2:
                        return new zza(null);
                    case 3:
                        return zzga.zza(zzi, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0002\u0000\u0001ဌ\u0000\u0002ဇ\u0001\u0003\u001b\u0004\u001b\u0005ဉ\u0002", new Object[]{"zzc", "zzd", zzbv.zzb(), "zze", "zzf", zzy.zzb.class, "zzg", zzy.zzb.class, "zzh"});
                    case 4:
                        return zzi;
                    case 5:
                        zzhu<C0121zzb> zzhuVar = zzj;
                        if (zzhuVar == null) {
                            synchronized (C0121zzb.class) {
                                zzhuVar = zzj;
                                if (zzhuVar == null) {
                                    zzhuVar = new zzga.zza<>(zzi);
                                    zzj = zzhuVar;
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
    public static final class zzbb extends zzga<zzbb, zza> implements zzhm {
        private static final zzbb zzf;
        private static volatile zzhu<zzbb> zzg;
        private int zzc;
        private zzaf zzd;
        private zzae zze;

        /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
        /* loaded from: classes.dex */
        public static final class zza extends zzga.zzb<zzbb, zza> implements zzhm {
            private zza() {
                super(zzbb.zzf);
            }

            /* synthetic */ zza(zzbk zzbkVar) {
                this();
            }
        }

        static {
            zzbb zzbbVar = new zzbb();
            zzf = zzbbVar;
            zzga.zza(zzbb.class, zzbbVar);
        }

        private zzbb() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzga
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzbk.zza[i - 1]) {
                case 1:
                    return new zzbb();
                case 2:
                    return new zza(null);
                case 3:
                    return zzga.zza(zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001", new Object[]{"zzc", "zzd", "zze"});
                case 4:
                    return zzf;
                case 5:
                    zzhu<zzbb> zzhuVar = zzg;
                    if (zzhuVar == null) {
                        synchronized (zzbb.class) {
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
    public static final class zzbd extends zzga<zzbd, zza> implements zzhm {
        private static final zzbd zzf;
        private static volatile zzhu<zzbd> zzg;
        private int zzc;
        private zzaf zzd;
        private zzae zze;

        /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
        /* loaded from: classes.dex */
        public static final class zza extends zzga.zzb<zzbd, zza> implements zzhm {
            private zza() {
                super(zzbd.zzf);
            }

            /* synthetic */ zza(zzbk zzbkVar) {
                this();
            }
        }

        static {
            zzbd zzbdVar = new zzbd();
            zzf = zzbdVar;
            zzga.zza(zzbd.class, zzbdVar);
        }

        private zzbd() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzga
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzbk.zza[i - 1]) {
                case 1:
                    return new zzbd();
                case 2:
                    return new zza(null);
                case 3:
                    return zzga.zza(zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001", new Object[]{"zzc", "zzd", "zze"});
                case 4:
                    return zzf;
                case 5:
                    zzhu<zzbd> zzhuVar = zzg;
                    if (zzhuVar == null) {
                        synchronized (zzbd.class) {
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
    public static final class zzbi extends zzga<zzbi, zza> implements zzhm {
        private static final zzbi zzf;
        private static volatile zzhu<zzbi> zzg;
        private int zzc;
        private String zzd = "";
        private String zze = "";

        /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
        /* loaded from: classes.dex */
        public static final class zza extends zzga.zzb<zzbi, zza> implements zzhm {
            private zza() {
                super(zzbi.zzf);
            }

            /* synthetic */ zza(zzbk zzbkVar) {
                this();
            }
        }

        static {
            zzbi zzbiVar = new zzbi();
            zzf = zzbiVar;
            zzga.zza(zzbi.class, zzbiVar);
        }

        private zzbi() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzga
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzbk.zza[i - 1]) {
                case 1:
                    return new zzbi();
                case 2:
                    return new zza(null);
                case 3:
                    return zzga.zza(zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001", new Object[]{"zzc", "zzd", "zze"});
                case 4:
                    return zzf;
                case 5:
                    zzhu<zzbi> zzhuVar = zzg;
                    if (zzhuVar == null) {
                        synchronized (zzbi.class) {
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
        private zzb zzd;
        private int zze;
        private zzab zzf;

        /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
        /* loaded from: classes.dex */
        public static final class zza extends zzga.zzb<zzd, zza> implements zzhm {
            private zza() {
                super(zzd.zzg);
            }

            /* synthetic */ zza(zzbk zzbkVar) {
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
            switch (zzbk.zza[i - 1]) {
                case 1:
                    return new zzd();
                case 2:
                    return new zza(null);
                case 3:
                    return zzga.zza(zzg, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဋ\u0001\u0003ဉ\u0002", new Object[]{"zzc", "zzd", "zze", "zzf"});
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

        /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
        /* loaded from: classes.dex */
        public static final class zzb extends zzga<zzb, zza> implements zzhm {
            private static final zzb zzj;
            private static volatile zzhu<zzb> zzk;
            private int zzc;
            private int zzd;
            private boolean zze;
            private zzae zzf;
            private zzac zzg;
            private int zzh;
            private int zzi;

            /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
            /* loaded from: classes.dex */
            public static final class zza extends zzga.zzb<zzb, zza> implements zzhm {
                private zza() {
                    super(zzb.zzj);
                }

                /* synthetic */ zza(zzbk zzbkVar) {
                    this();
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
                switch (zzbk.zza[i - 1]) {
                    case 1:
                        return new zzb();
                    case 2:
                        return new zza(null);
                    case 3:
                        return zzga.zza(zzj, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဇ\u0001\u0003ဉ\u0002\u0004ဉ\u0003\u0005ဋ\u0004\u0006ဋ\u0005", new Object[]{"zzc", "zzd", zzbv.zzb(), "zze", "zzf", "zzg", "zzh", "zzi"});
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

    /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
    /* loaded from: classes.dex */
    public static final class zze extends zzga<zze, zza> implements zzhm {
        private static final zze zzg;
        private static volatile zzhu<zze> zzh;
        private int zzc;
        private zzb zzd;
        private int zze;
        private zzab zzf;

        /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
        /* loaded from: classes.dex */
        public static final class zza extends zzga.zzb<zze, zza> implements zzhm {
            private zza() {
                super(zze.zzg);
            }

            /* synthetic */ zza(zzbk zzbkVar) {
                this();
            }
        }

        static {
            zze zzeVar = new zze();
            zzg = zzeVar;
            zzga.zza(zze.class, zzeVar);
        }

        private zze() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzga
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzbk.zza[i - 1]) {
                case 1:
                    return new zze();
                case 2:
                    return new zza(null);
                case 3:
                    return zzga.zza(zzg, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဋ\u0001\u0003ဉ\u0002", new Object[]{"zzc", "zzd", "zze", "zzf"});
                case 4:
                    return zzg;
                case 5:
                    zzhu<zze> zzhuVar = zzh;
                    if (zzhuVar == null) {
                        synchronized (zze.class) {
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

        /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
        /* loaded from: classes.dex */
        public static final class zzb extends zzga<zzb, zza> implements zzhm {
            private static final zzb zzh;
            private static volatile zzhu<zzb> zzi;
            private int zzc;
            private int zzd;
            private boolean zze;
            private zzae zzf;
            private zzat zzg;

            /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
            /* loaded from: classes.dex */
            public static final class zza extends zzga.zzb<zzb, zza> implements zzhm {
                private zza() {
                    super(zzb.zzh);
                }

                /* synthetic */ zza(zzbk zzbkVar) {
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
                switch (zzbk.zza[i - 1]) {
                    case 1:
                        return new zzb();
                    case 2:
                        return new zza(null);
                    case 3:
                        return zzga.zza(zzh, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဇ\u0001\u0003ဉ\u0002\u0004ဉ\u0003", new Object[]{"zzc", "zzd", zzbv.zzb(), "zze", "zzf", "zzg"});
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
    public static final class zzf extends zzga<zzf, zza> implements zzhm {
        private static final zzf zzg;
        private static volatile zzhu<zzf> zzh;
        private int zzc;
        private zzb zzd;
        private int zze;
        private zzab zzf;

        /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
        /* loaded from: classes.dex */
        public static final class zza extends zzga.zzb<zzf, zza> implements zzhm {
            private zza() {
                super(zzf.zzg);
            }

            /* synthetic */ zza(zzbk zzbkVar) {
                this();
            }
        }

        static {
            zzf zzfVar = new zzf();
            zzg = zzfVar;
            zzga.zza(zzf.class, zzfVar);
        }

        private zzf() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzga
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzbk.zza[i - 1]) {
                case 1:
                    return new zzf();
                case 2:
                    return new zza(null);
                case 3:
                    return zzga.zza(zzg, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဋ\u0001\u0003ဉ\u0002", new Object[]{"zzc", "zzd", "zze", "zzf"});
                case 4:
                    return zzg;
                case 5:
                    zzhu<zzf> zzhuVar = zzh;
                    if (zzhuVar == null) {
                        synchronized (zzf.class) {
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

        /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
        /* loaded from: classes.dex */
        public static final class zzb extends zzga<zzb, zza> implements zzhm {
            private static final zzb zzi;
            private static volatile zzhu<zzb> zzj;
            private int zzc;
            private int zzd;
            private boolean zze;
            private boolean zzf;
            private zzae zzg;
            private zzaw zzh;

            /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
            /* loaded from: classes.dex */
            public static final class zza extends zzga.zzb<zzb, zza> implements zzhm {
                private zza() {
                    super(zzb.zzi);
                }

                /* synthetic */ zza(zzbk zzbkVar) {
                    this();
                }
            }

            static {
                zzb zzbVar = new zzb();
                zzi = zzbVar;
                zzga.zza(zzb.class, zzbVar);
            }

            private zzb() {
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzga
            public final Object zza(int i, Object obj, Object obj2) {
                switch (zzbk.zza[i - 1]) {
                    case 1:
                        return new zzb();
                    case 2:
                        return new zza(null);
                    case 3:
                        return zzga.zza(zzi, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဇ\u0001\u0003ဇ\u0002\u0004ဉ\u0003\u0005ဉ\u0004", new Object[]{"zzc", "zzd", zzbv.zzb(), "zze", "zzf", "zzg", "zzh"});
                    case 4:
                        return zzi;
                    case 5:
                        zzhu<zzb> zzhuVar = zzj;
                        if (zzhuVar == null) {
                            synchronized (zzb.class) {
                                zzhuVar = zzj;
                                if (zzhuVar == null) {
                                    zzhuVar = new zzga.zza<>(zzi);
                                    zzj = zzhuVar;
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
    public static final class zzg extends zzga<zzg, zza> implements zzhm {
        private static final zzg zzg;
        private static volatile zzhu<zzg> zzh;
        private int zzc;
        private zzb zzd;
        private int zze;
        private zzab zzf;

        /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
        /* loaded from: classes.dex */
        public static final class zza extends zzga.zzb<zzg, zza> implements zzhm {
            private zza() {
                super(zzg.zzg);
            }

            /* synthetic */ zza(zzbk zzbkVar) {
                this();
            }
        }

        static {
            zzg zzgVar = new zzg();
            zzg = zzgVar;
            zzga.zza(zzg.class, zzgVar);
        }

        private zzg() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzga
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzbk.zza[i - 1]) {
                case 1:
                    return new zzg();
                case 2:
                    return new zza(null);
                case 3:
                    return zzga.zza(zzg, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဋ\u0001\u0003ဉ\u0002", new Object[]{"zzc", "zzd", "zze", "zzf"});
                case 4:
                    return zzg;
                case 5:
                    zzhu<zzg> zzhuVar = zzh;
                    if (zzhuVar == null) {
                        synchronized (zzg.class) {
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

        /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
        /* loaded from: classes.dex */
        public static final class zzb extends zzga<zzb, zza> implements zzhm {
            private static final zzb zzh;
            private static volatile zzhu<zzb> zzi;
            private int zzc;
            private int zzd;
            private boolean zze;
            private zzae zzf;
            private zzba zzg;

            /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
            /* loaded from: classes.dex */
            public static final class zza extends zzga.zzb<zzb, zza> implements zzhm {
                private zza() {
                    super(zzb.zzh);
                }

                /* synthetic */ zza(zzbk zzbkVar) {
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
                switch (zzbk.zza[i - 1]) {
                    case 1:
                        return new zzb();
                    case 2:
                        return new zza(null);
                    case 3:
                        return zzga.zza(zzh, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဇ\u0001\u0003ဉ\u0002\u0004ဉ\u0003", new Object[]{"zzc", "zzd", zzbv.zzb(), "zze", "zzf", "zzg"});
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
    public static final class zzh extends zzga<zzh, zza> implements zzhm {
        private static final zzh zzg;
        private static volatile zzhu<zzh> zzh;
        private int zzc;
        private zzb zzd;
        private int zze;
        private zzab zzf;

        /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
        /* loaded from: classes.dex */
        public static final class zza extends zzga.zzb<zzh, zza> implements zzhm {
            private zza() {
                super(zzh.zzg);
            }

            /* synthetic */ zza(zzbk zzbkVar) {
                this();
            }
        }

        static {
            zzh zzhVar = new zzh();
            zzg = zzhVar;
            zzga.zza(zzh.class, zzhVar);
        }

        private zzh() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzga
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzbk.zza[i - 1]) {
                case 1:
                    return new zzh();
                case 2:
                    return new zza(null);
                case 3:
                    return zzga.zza(zzg, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဋ\u0001\u0003ဉ\u0002", new Object[]{"zzc", "zzd", "zze", "zzf"});
                case 4:
                    return zzg;
                case 5:
                    zzhu<zzh> zzhuVar = zzh;
                    if (zzhuVar == null) {
                        synchronized (zzh.class) {
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

        /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
        /* loaded from: classes.dex */
        public static final class zzb extends zzga<zzb, zza> implements zzhm {
            private static final zzb zzg;
            private static volatile zzhu<zzb> zzh;
            private int zzc;
            private int zzd;
            private boolean zze;
            private zzae zzf;

            /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
            /* loaded from: classes.dex */
            public static final class zza extends zzga.zzb<zzb, zza> implements zzhm {
                private zza() {
                    super(zzb.zzg);
                }

                /* synthetic */ zza(zzbk zzbkVar) {
                    this();
                }
            }

            static {
                zzb zzbVar = new zzb();
                zzg = zzbVar;
                zzga.zza(zzb.class, zzbVar);
            }

            private zzb() {
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzga
            public final Object zza(int i, Object obj, Object obj2) {
                switch (zzbk.zza[i - 1]) {
                    case 1:
                        return new zzb();
                    case 2:
                        return new zza(null);
                    case 3:
                        return zzga.zza(zzg, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဇ\u0001\u0003ဉ\u0002", new Object[]{"zzc", "zzd", zzbv.zzb(), "zze", "zzf"});
                    case 4:
                        return zzg;
                    case 5:
                        zzhu<zzb> zzhuVar = zzh;
                        if (zzhuVar == null) {
                            synchronized (zzb.class) {
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
        private static final zzi zzg;
        private static volatile zzhu<zzi> zzh;
        private int zzc;
        private zzb zzd;
        private int zze;
        private zzab zzf;

        /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
        /* loaded from: classes.dex */
        public static final class zza extends zzga.zzb<zzi, zza> implements zzhm {
            private zza() {
                super(zzi.zzg);
            }

            /* synthetic */ zza(zzbk zzbkVar) {
                this();
            }
        }

        static {
            zzi zziVar = new zzi();
            zzg = zziVar;
            zzga.zza(zzi.class, zziVar);
        }

        private zzi() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzga
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzbk.zza[i - 1]) {
                case 1:
                    return new zzi();
                case 2:
                    return new zza(null);
                case 3:
                    return zzga.zza(zzg, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဋ\u0001\u0003ဉ\u0002", new Object[]{"zzc", "zzd", "zze", "zzf"});
                case 4:
                    return zzg;
                case 5:
                    zzhu<zzi> zzhuVar = zzh;
                    if (zzhuVar == null) {
                        synchronized (zzi.class) {
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

        /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
        /* loaded from: classes.dex */
        public static final class zzb extends zzga<zzb, zza> implements zzhm {
            private static final zzb zzh;
            private static volatile zzhu<zzb> zzi;
            private int zzc;
            private int zzd;
            private boolean zze;
            private boolean zzf;
            private zzae zzg;

            /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
            /* loaded from: classes.dex */
            public static final class zza extends zzga.zzb<zzb, zza> implements zzhm {
                private zza() {
                    super(zzb.zzh);
                }

                /* synthetic */ zza(zzbk zzbkVar) {
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
                switch (zzbk.zza[i - 1]) {
                    case 1:
                        return new zzb();
                    case 2:
                        return new zza(null);
                    case 3:
                        return zzga.zza(zzh, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဇ\u0001\u0003ဇ\u0002\u0004ဉ\u0003", new Object[]{"zzc", "zzd", zzbv.zzb(), "zze", "zzf", "zzg"});
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
    public static final class zzk extends zzga<zzk, zza> implements zzhm {
        private static final zzk zzi;
        private static volatile zzhu<zzk> zzj;
        private int zzc;
        private zzaf zzd;
        private zzam zze;
        private long zzf;
        private float zzg;
        private zzae zzh;

        /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
        /* loaded from: classes.dex */
        public static final class zza extends zzga.zzb<zzk, zza> implements zzhm {
            private zza() {
                super(zzk.zzi);
            }

            /* synthetic */ zza(zzbk zzbkVar) {
                this();
            }
        }

        static {
            zzk zzkVar = new zzk();
            zzi = zzkVar;
            zzga.zza(zzk.class, zzkVar);
        }

        private zzk() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzga
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzbk.zza[i - 1]) {
                case 1:
                    return new zzk();
                case 2:
                    return new zza(null);
                case 3:
                    return zzga.zza(zzi, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဃ\u0002\u0004ခ\u0003\u0005ဉ\u0004", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh"});
                case 4:
                    return zzi;
                case 5:
                    zzhu<zzk> zzhuVar = zzj;
                    if (zzhuVar == null) {
                        synchronized (zzk.class) {
                            zzhuVar = zzj;
                            if (zzhuVar == null) {
                                zzhuVar = new zzga.zza<>(zzi);
                                zzj = zzhuVar;
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
    public static final class zzm extends zzga<zzm, zza> implements zzhm {
        private static final zzm zzg;
        private static volatile zzhu<zzm> zzh;
        private int zzc;
        private zzaf zzd;
        private zzn zze;
        private zzae zzf;

        /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
        /* loaded from: classes.dex */
        public static final class zza extends zzga.zzb<zzm, zza> implements zzhm {
            private zza() {
                super(zzm.zzg);
            }

            /* synthetic */ zza(zzbk zzbkVar) {
                this();
            }
        }

        static {
            zzm zzmVar = new zzm();
            zzg = zzmVar;
            zzga.zza(zzm.class, zzmVar);
        }

        private zzm() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzga
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzbk.zza[i - 1]) {
                case 1:
                    return new zzm();
                case 2:
                    return new zza(null);
                case 3:
                    return zzga.zza(zzg, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002", new Object[]{"zzc", "zzd", "zze", "zzf"});
                case 4:
                    return zzg;
                case 5:
                    zzhu<zzm> zzhuVar = zzh;
                    if (zzhuVar == null) {
                        synchronized (zzm.class) {
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
    public static final class zzo extends zzga<zzo, zza> implements zzhm {
        private static final zzo zzg;
        private static volatile zzhu<zzo> zzh;
        private int zzc;
        private zzaf zzd;
        private zzn zze;
        private zzae zzf;

        /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
        /* loaded from: classes.dex */
        public static final class zza extends zzga.zzb<zzo, zza> implements zzhm {
            private zza() {
                super(zzo.zzg);
            }

            /* synthetic */ zza(zzbk zzbkVar) {
                this();
            }
        }

        static {
            zzo zzoVar = new zzo();
            zzg = zzoVar;
            zzga.zza(zzo.class, zzoVar);
        }

        private zzo() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzga
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzbk.zza[i - 1]) {
                case 1:
                    return new zzo();
                case 2:
                    return new zza(null);
                case 3:
                    return zzga.zza(zzg, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002", new Object[]{"zzc", "zzd", "zze", "zzf"});
                case 4:
                    return zzg;
                case 5:
                    zzhu<zzo> zzhuVar = zzh;
                    if (zzhuVar == null) {
                        synchronized (zzo.class) {
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
    public static final class zzp extends zzga<zzp, zza> implements zzhm {
        private static final zzp zzg;
        private static volatile zzhu<zzp> zzh;
        private int zzc;
        private zzaf zzd;
        private zzn zze;
        private zzae zzf;

        /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
        /* loaded from: classes.dex */
        public static final class zza extends zzga.zzb<zzp, zza> implements zzhm {
            private zza() {
                super(zzp.zzg);
            }

            /* synthetic */ zza(zzbk zzbkVar) {
                this();
            }
        }

        static {
            zzp zzpVar = new zzp();
            zzg = zzpVar;
            zzga.zza(zzp.class, zzpVar);
        }

        private zzp() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzga
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzbk.zza[i - 1]) {
                case 1:
                    return new zzp();
                case 2:
                    return new zza(null);
                case 3:
                    return zzga.zza(zzg, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002", new Object[]{"zzc", "zzd", "zze", "zzf"});
                case 4:
                    return zzg;
                case 5:
                    zzhu<zzp> zzhuVar = zzh;
                    if (zzhuVar == null) {
                        synchronized (zzp.class) {
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
    public static final class zzq extends zzga<zzq, zza> implements zzhm {
        private static final zzq zzg;
        private static volatile zzhu<zzq> zzh;
        private int zzc;
        private zzaf zzd;
        private zzn zze;
        private zzae zzf;

        /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
        /* loaded from: classes.dex */
        public static final class zza extends zzga.zzb<zzq, zza> implements zzhm {
            private zza() {
                super(zzq.zzg);
            }

            /* synthetic */ zza(zzbk zzbkVar) {
                this();
            }
        }

        static {
            zzq zzqVar = new zzq();
            zzg = zzqVar;
            zzga.zza(zzq.class, zzqVar);
        }

        private zzq() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzga
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzbk.zza[i - 1]) {
                case 1:
                    return new zzq();
                case 2:
                    return new zza(null);
                case 3:
                    return zzga.zza(zzg, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002", new Object[]{"zzc", "zzd", "zze", "zzf"});
                case 4:
                    return zzg;
                case 5:
                    zzhu<zzq> zzhuVar = zzh;
                    if (zzhuVar == null) {
                        synchronized (zzq.class) {
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
    public static final class zzr extends zzga<zzr, zza> implements zzhm {
        private static final zzr zzg;
        private static volatile zzhu<zzr> zzh;
        private int zzc;
        private zzaf zzd;
        private zzn zze;
        private zzae zzf;

        /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
        /* loaded from: classes.dex */
        public static final class zza extends zzga.zzb<zzr, zza> implements zzhm {
            private zza() {
                super(zzr.zzg);
            }

            /* synthetic */ zza(zzbk zzbkVar) {
                this();
            }
        }

        static {
            zzr zzrVar = new zzr();
            zzg = zzrVar;
            zzga.zza(zzr.class, zzrVar);
        }

        private zzr() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzga
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzbk.zza[i - 1]) {
                case 1:
                    return new zzr();
                case 2:
                    return new zza(null);
                case 3:
                    return zzga.zza(zzg, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002", new Object[]{"zzc", "zzd", "zze", "zzf"});
                case 4:
                    return zzg;
                case 5:
                    zzhu<zzr> zzhuVar = zzh;
                    if (zzhuVar == null) {
                        synchronized (zzr.class) {
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
    public static final class zzs extends zzga<zzs, zza> implements zzhm {
        private static final zzs zzg;
        private static volatile zzhu<zzs> zzh;
        private int zzc;
        private zzaf zzd;
        private zzn zze;
        private zzae zzf;

        /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
        /* loaded from: classes.dex */
        public static final class zza extends zzga.zzb<zzs, zza> implements zzhm {
            private zza() {
                super(zzs.zzg);
            }

            /* synthetic */ zza(zzbk zzbkVar) {
                this();
            }
        }

        static {
            zzs zzsVar = new zzs();
            zzg = zzsVar;
            zzga.zza(zzs.class, zzsVar);
        }

        private zzs() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzga
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzbk.zza[i - 1]) {
                case 1:
                    return new zzs();
                case 2:
                    return new zza(null);
                case 3:
                    return zzga.zza(zzg, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002", new Object[]{"zzc", "zzd", "zze", "zzf"});
                case 4:
                    return zzg;
                case 5:
                    zzhu<zzs> zzhuVar = zzh;
                    if (zzhuVar == null) {
                        synchronized (zzs.class) {
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
    public static final class zzt extends zzga<zzt, zza> implements zzhm {
        private static final zzt zzg;
        private static volatile zzhu<zzt> zzh;
        private int zzc;
        private zzaf zzd;
        private zzn zze;
        private zzae zzf;

        /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
        /* loaded from: classes.dex */
        public static final class zza extends zzga.zzb<zzt, zza> implements zzhm {
            private zza() {
                super(zzt.zzg);
            }

            /* synthetic */ zza(zzbk zzbkVar) {
                this();
            }
        }

        static {
            zzt zztVar = new zzt();
            zzg = zztVar;
            zzga.zza(zzt.class, zztVar);
        }

        private zzt() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzga
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzbk.zza[i - 1]) {
                case 1:
                    return new zzt();
                case 2:
                    return new zza(null);
                case 3:
                    return zzga.zza(zzg, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002", new Object[]{"zzc", "zzd", "zze", "zzf"});
                case 4:
                    return zzg;
                case 5:
                    zzhu<zzt> zzhuVar = zzh;
                    if (zzhuVar == null) {
                        synchronized (zzt.class) {
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
    public static final class zzu extends zzga<zzu, zza> implements zzhm {
        private static final zzu zzg;
        private static volatile zzhu<zzu> zzh;
        private int zzc;
        private zzaf zzd;
        private zzn zze;
        private zzae zzf;

        /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
        /* loaded from: classes.dex */
        public static final class zza extends zzga.zzb<zzu, zza> implements zzhm {
            private zza() {
                super(zzu.zzg);
            }

            /* synthetic */ zza(zzbk zzbkVar) {
                this();
            }
        }

        static {
            zzu zzuVar = new zzu();
            zzg = zzuVar;
            zzga.zza(zzu.class, zzuVar);
        }

        private zzu() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzga
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzbk.zza[i - 1]) {
                case 1:
                    return new zzu();
                case 2:
                    return new zza(null);
                case 3:
                    return zzga.zza(zzg, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002", new Object[]{"zzc", "zzd", "zze", "zzf"});
                case 4:
                    return zzg;
                case 5:
                    zzhu<zzu> zzhuVar = zzh;
                    if (zzhuVar == null) {
                        synchronized (zzu.class) {
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
    public static final class zzv extends zzga<zzv, zza> implements zzhm {
        private static final zzv zzg;
        private static volatile zzhu<zzv> zzh;
        private int zzc;
        private zzaf zzd;
        private zzn zze;
        private zzae zzf;

        /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
        /* loaded from: classes.dex */
        public static final class zza extends zzga.zzb<zzv, zza> implements zzhm {
            private zza() {
                super(zzv.zzg);
            }

            /* synthetic */ zza(zzbk zzbkVar) {
                this();
            }
        }

        static {
            zzv zzvVar = new zzv();
            zzg = zzvVar;
            zzga.zza(zzv.class, zzvVar);
        }

        private zzv() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzga
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzbk.zza[i - 1]) {
                case 1:
                    return new zzv();
                case 2:
                    return new zza(null);
                case 3:
                    return zzga.zza(zzg, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002", new Object[]{"zzc", "zzd", "zze", "zzf"});
                case 4:
                    return zzg;
                case 5:
                    zzhu<zzv> zzhuVar = zzh;
                    if (zzhuVar == null) {
                        synchronized (zzv.class) {
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
    public static final class zzw extends zzga<zzw, zza> implements zzhm {
        private static final zzw zzg;
        private static volatile zzhu<zzw> zzh;
        private int zzc;
        private zzaf zzd;
        private zzn zze;
        private zzae zzf;

        /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
        /* loaded from: classes.dex */
        public static final class zza extends zzga.zzb<zzw, zza> implements zzhm {
            private zza() {
                super(zzw.zzg);
            }

            /* synthetic */ zza(zzbk zzbkVar) {
                this();
            }
        }

        static {
            zzw zzwVar = new zzw();
            zzg = zzwVar;
            zzga.zza(zzw.class, zzwVar);
        }

        private zzw() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzga
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzbk.zza[i - 1]) {
                case 1:
                    return new zzw();
                case 2:
                    return new zza(null);
                case 3:
                    return zzga.zza(zzg, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002", new Object[]{"zzc", "zzd", "zze", "zzf"});
                case 4:
                    return zzg;
                case 5:
                    zzhu<zzw> zzhuVar = zzh;
                    if (zzhuVar == null) {
                        synchronized (zzw.class) {
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
    public static final class zzy extends zzga<zzy, zza> implements zzhm {
        private static final zzy zzi;
        private static volatile zzhu<zzy> zzj;
        private int zzc;
        private zzaf zzd;
        private zzam zze;
        private zzgl<zzb> zzf = zzga.zzm();
        private zzgl<zzb> zzg = zzga.zzm();
        private long zzh;

        /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
        /* loaded from: classes.dex */
        public static final class zza extends zzga.zzb<zzy, zza> implements zzhm {
            private zza() {
                super(zzy.zzi);
            }

            /* synthetic */ zza(zzbk zzbkVar) {
                this();
            }
        }

        static {
            zzy zzyVar = new zzy();
            zzi = zzyVar;
            zzga.zza(zzy.class, zzyVar);
        }

        private zzy() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzga
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzbk.zza[i - 1]) {
                case 1:
                    return new zzy();
                case 2:
                    return new zza(null);
                case 3:
                    return zzga.zza(zzi, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0002\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003\u001b\u0004\u001b\u0005ဃ\u0002", new Object[]{"zzc", "zzd", "zze", "zzf", zzb.class, "zzg", zzb.class, "zzh"});
                case 4:
                    return zzi;
                case 5:
                    zzhu<zzy> zzhuVar = zzj;
                    if (zzhuVar == null) {
                        synchronized (zzy.class) {
                            zzhuVar = zzj;
                            if (zzhuVar == null) {
                                zzhuVar = new zzga.zza<>(zzi);
                                zzj = zzhuVar;
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
            private static final zzb zzf;
            private static volatile zzhu<zzb> zzg;
            private int zzc;
            private int zzd;
            private zzgj zze = zzga.zzk();

            /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
            /* loaded from: classes.dex */
            public static final class zza extends zzga.zzb<zzb, zza> implements zzhm {
                private zza() {
                    super(zzb.zzf);
                }

                /* synthetic */ zza(zzbk zzbkVar) {
                    this();
                }
            }

            /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
            /* renamed from: com.google.android.gms.internal.mlkit_vision_barcode.zzbl$zzy$zzb$zzb  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            public enum EnumC0122zzb implements zzgf {
                UNKNOWN_DATA_TYPE(0),
                TYPE_FLOAT32(1),
                TYPE_INT32(2),
                TYPE_BYTE(3),
                TYPE_LONG(4);
                
                private static final zzge<EnumC0122zzb> zzf = new zzbr();
                private final int zzg;

                EnumC0122zzb(int i) {
                    this.zzg = i;
                }

                public static zzgh zzb() {
                    return zzbs.zza;
                }

                @Override // java.lang.Enum
                public final String toString() {
                    return "<" + EnumC0122zzb.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzg + " name=" + name() + '>';
                }

                @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzgf
                public final int zza() {
                    return this.zzg;
                }
            }

            static {
                zzb zzbVar = new zzb();
                zzf = zzbVar;
                zzga.zza(zzb.class, zzbVar);
            }

            private zzb() {
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzga
            public final Object zza(int i, Object obj, Object obj2) {
                switch (zzbk.zza[i - 1]) {
                    case 1:
                        return new zzb();
                    case 2:
                        return new zza(null);
                    case 3:
                        return zzga.zza(zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001ဌ\u0000\u0002\u0016", new Object[]{"zzc", "zzd", EnumC0122zzb.zzb(), "zze"});
                    case 4:
                        return zzf;
                    case 5:
                        zzhu<zzb> zzhuVar = zzg;
                        if (zzhuVar == null) {
                            synchronized (zzb.class) {
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
    }

    /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
    /* loaded from: classes.dex */
    public static final class zzaa extends zzga<zzaa, zza> implements zzhm {
        private static final zzaa zzg;
        private static volatile zzhu<zzaa> zzh;
        private int zzc;
        private int zzd;
        private boolean zze;
        private String zzf = "";

        /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
        /* loaded from: classes.dex */
        public static final class zza extends zzga.zzb<zzaa, zza> implements zzhm {
            private zza() {
                super(zzaa.zzg);
            }

            /* synthetic */ zza(zzbk zzbkVar) {
                this();
            }
        }

        static {
            zzaa zzaaVar = new zzaa();
            zzg = zzaaVar;
            zzga.zza(zzaa.class, zzaaVar);
        }

        private zzaa() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzga
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzbk.zza[i - 1]) {
                case 1:
                    return new zzaa();
                case 2:
                    return new zza(null);
                case 3:
                    return zzga.zza(zzg, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဇ\u0001\u0003ဈ\u0002", new Object[]{"zzc", "zzd", zzal.zzb.zzb(), "zze", "zzf"});
                case 4:
                    return zzg;
                case 5:
                    zzhu<zzaa> zzhuVar = zzh;
                    if (zzhuVar == null) {
                        synchronized (zzaa.class) {
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
    public static final class zzah extends zzga<zzah, zza> implements zzhm {
        private static final zzah zzg;
        private static volatile zzhu<zzah> zzh;
        private int zzc;
        private int zzd;
        private boolean zze;
        private String zzf = "";

        /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
        /* loaded from: classes.dex */
        public static final class zza extends zzga.zzb<zzah, zza> implements zzhm {
            private zza() {
                super(zzah.zzg);
            }

            /* synthetic */ zza(zzbk zzbkVar) {
                this();
            }
        }

        static {
            zzah zzahVar = new zzah();
            zzg = zzahVar;
            zzga.zza(zzah.class, zzahVar);
        }

        private zzah() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzga
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzbk.zza[i - 1]) {
                case 1:
                    return new zzah();
                case 2:
                    return new zza(null);
                case 3:
                    return zzga.zza(zzg, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဇ\u0001\u0003ဈ\u0002", new Object[]{"zzc", "zzd", zzal.zzb.zzb(), "zze", "zzf"});
                case 4:
                    return zzg;
                case 5:
                    zzhu<zzah> zzhuVar = zzh;
                    if (zzhuVar == null) {
                        synchronized (zzah.class) {
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
    public static final class zzan extends zzga<zzan, zza> implements zzhm {
        private static final zzan zzh;
        private static volatile zzhu<zzan> zzi;
        private int zzc;
        private int zzd;
        private float zze;
        private int zzf;
        private int zzg;

        /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
        /* loaded from: classes.dex */
        public static final class zza extends zzga.zzb<zzan, zza> implements zzhm {
            private zza() {
                super(zzan.zzh);
            }

            /* synthetic */ zza(zzbk zzbkVar) {
                this();
            }
        }

        /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
        /* loaded from: classes.dex */
        public enum zzb implements zzgf {
            CATEGORY_UNKNOWN(0),
            CATEGORY_HOME_GOOD(1),
            CATEGORY_FASHION_GOOD(2),
            CATEGORY_ANIMAL(3),
            CATEGORY_FOOD(4),
            CATEGORY_PLACE(5),
            CATEGORY_PLANT(6);
            
            private static final zzge<zzb> zzh = new zzcu();
            private final int zzi;

            zzb(int i) {
                this.zzi = i;
            }

            public static zzgh zzb() {
                return zzcv.zza;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "<" + zzb.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzi + " name=" + name() + '>';
            }

            @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzgf
            public final int zza() {
                return this.zzi;
            }
        }

        static {
            zzan zzanVar = new zzan();
            zzh = zzanVar;
            zzga.zza(zzan.class, zzanVar);
        }

        private zzan() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzga
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzbk.zza[i - 1]) {
                case 1:
                    return new zzan();
                case 2:
                    return new zza(null);
                case 3:
                    return zzga.zza(zzh, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဌ\u0000\u0002ခ\u0001\u0003င\u0002\u0004ဋ\u0003", new Object[]{"zzc", "zzd", zzb.zzb(), "zze", "zzf", "zzg"});
                case 4:
                    return zzh;
                case 5:
                    zzhu<zzan> zzhuVar = zzi;
                    if (zzhuVar == null) {
                        synchronized (zzan.class) {
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

    /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
    /* loaded from: classes.dex */
    public static final class zzaq extends zzga<zzaq, zza> implements zzhm {
        private static final zzaq zzf;
        private static volatile zzhu<zzaq> zzg;
        private int zzc;
        private zzat zzd;
        private int zze;

        /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
        /* loaded from: classes.dex */
        public static final class zza extends zzga.zzb<zzaq, zza> implements zzhm {
            private zza() {
                super(zzaq.zzf);
            }

            /* synthetic */ zza(zzbk zzbkVar) {
                this();
            }
        }

        static {
            zzaq zzaqVar = new zzaq();
            zzf = zzaqVar;
            zzga.zza(zzaq.class, zzaqVar);
        }

        private zzaq() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzga
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzbk.zza[i - 1]) {
                case 1:
                    return new zzaq();
                case 2:
                    return new zza(null);
                case 3:
                    return zzga.zza(zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဌ\u0001", new Object[]{"zzc", "zzd", "zze", zzbv.zzb()});
                case 4:
                    return zzf;
                case 5:
                    zzhu<zzaq> zzhuVar = zzg;
                    if (zzhuVar == null) {
                        synchronized (zzaq.class) {
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
    public static final class zzas extends zzga<zzas, zza> implements zzhm {
        private static final zzgi<Integer, zzbv> zzf = new zzdc();
        private static final zzas zzj;
        private static volatile zzhu<zzas> zzk;
        private int zzc;
        private zzat zzd;
        private long zzg;
        private long zzh;
        private zzgj zze = zzga.zzk();
        private zzgl<zzbf> zzi = zzga.zzm();

        /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
        /* loaded from: classes.dex */
        public static final class zza extends zzga.zzb<zzas, zza> implements zzhm {
            private zza() {
                super(zzas.zzj);
            }

            /* synthetic */ zza(zzbk zzbkVar) {
                this();
            }
        }

        static {
            zzas zzasVar = new zzas();
            zzj = zzasVar;
            zzga.zza(zzas.class, zzasVar);
        }

        private zzas() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzga
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzbk.zza[i - 1]) {
                case 1:
                    return new zzas();
                case 2:
                    return new zza(null);
                case 3:
                    return zzga.zza(zzj, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0002\u0000\u0001ဉ\u0000\u0002\u001e\u0003ဃ\u0001\u0004ဃ\u0002\u0005\u001b", new Object[]{"zzc", "zzd", "zze", zzbv.zzb(), "zzg", "zzh", "zzi", zzbf.class});
                case 4:
                    return zzj;
                case 5:
                    zzhu<zzas> zzhuVar = zzk;
                    if (zzhuVar == null) {
                        synchronized (zzas.class) {
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

    /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
    /* loaded from: classes.dex */
    public static final class zzav extends zzga<zzav, zza> implements zzhm {
        private static final zzav zzf;
        private static volatile zzhu<zzav> zzg;
        private int zzc;
        private zzaw zzd;
        private int zze;

        /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
        /* loaded from: classes.dex */
        public static final class zza extends zzga.zzb<zzav, zza> implements zzhm {
            private zza() {
                super(zzav.zzf);
            }

            /* synthetic */ zza(zzbk zzbkVar) {
                this();
            }
        }

        static {
            zzav zzavVar = new zzav();
            zzf = zzavVar;
            zzga.zza(zzav.class, zzavVar);
        }

        private zzav() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzga
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzbk.zza[i - 1]) {
                case 1:
                    return new zzav();
                case 2:
                    return new zza(null);
                case 3:
                    return zzga.zza(zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဌ\u0001", new Object[]{"zzc", "zzd", "zze", zzbv.zzb()});
                case 4:
                    return zzf;
                case 5:
                    zzhu<zzav> zzhuVar = zzg;
                    if (zzhuVar == null) {
                        synchronized (zzav.class) {
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
    public static final class zzaw extends zzga<zzaw, zza> implements zzhm {
        private static final zzaw zzj;
        private static volatile zzhu<zzaw> zzk;
        private int zzc;
        private int zzd;
        private boolean zze;
        private boolean zzf;
        private int zzg;
        private float zzh;
        private zzam zzi;

        /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
        /* loaded from: classes.dex */
        public static final class zza extends zzga.zzb<zzaw, zza> implements zzhm {
            private zza() {
                super(zzaw.zzj);
            }

            /* synthetic */ zza(zzbk zzbkVar) {
                this();
            }
        }

        /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
        /* loaded from: classes.dex */
        public enum zzb implements zzgf {
            MODE_UNSPECIFIED(0),
            STREAM(1),
            SINGLE_IMAGE(2);
            
            private static final zzge<zzb> zzd = new zzdd();
            private final int zze;

            zzb(int i) {
                this.zze = i;
            }

            public static zzgh zzb() {
                return zzde.zza;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "<" + zzb.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zze + " name=" + name() + '>';
            }

            @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzgf
            public final int zza() {
                return this.zze;
            }
        }

        static {
            zzaw zzawVar = new zzaw();
            zzj = zzawVar;
            zzga.zza(zzaw.class, zzawVar);
        }

        private zzaw() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzga
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzbk.zza[i - 1]) {
                case 1:
                    return new zzaw();
                case 2:
                    return new zza(null);
                case 3:
                    return zzga.zza(zzj, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဇ\u0001\u0003ဇ\u0002\u0004ဋ\u0003\u0005ခ\u0004\u0006ဉ\u0005", new Object[]{"zzc", "zzd", zzb.zzb(), "zze", "zzf", "zzg", "zzh", "zzi"});
                case 4:
                    return zzj;
                case 5:
                    zzhu<zzaw> zzhuVar = zzk;
                    if (zzhuVar == null) {
                        synchronized (zzaw.class) {
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

    /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
    /* loaded from: classes.dex */
    public static final class zzax extends zzga<zzax, zza> implements zzhm {
        private static final zzax zzh;
        private static volatile zzhu<zzax> zzi;
        private int zzc;
        private zzaf zzd;
        private zzae zze;
        private zzaw zzf;
        private zzgl<zzan> zzg = zzga.zzm();

        /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
        /* loaded from: classes.dex */
        public static final class zza extends zzga.zzb<zzax, zza> implements zzhm {
            private zza() {
                super(zzax.zzh);
            }

            /* synthetic */ zza(zzbk zzbkVar) {
                this();
            }
        }

        static {
            zzax zzaxVar = new zzax();
            zzh = zzaxVar;
            zzga.zza(zzax.class, zzaxVar);
        }

        private zzax() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzga
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzbk.zza[i - 1]) {
                case 1:
                    return new zzax();
                case 2:
                    return new zza(null);
                case 3:
                    return zzga.zza(zzh, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002\u0004\u001b", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", zzan.class});
                case 4:
                    return zzh;
                case 5:
                    zzhu<zzax> zzhuVar = zzi;
                    if (zzhuVar == null) {
                        synchronized (zzax.class) {
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

    /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
    /* loaded from: classes.dex */
    public static final class zzay extends zzga<zzay, zza> implements zzhm {
        private static final zzay zzi;
        private static volatile zzhu<zzay> zzj;
        private int zzc;
        private zzaw zzd;
        private int zze;
        private long zzf;
        private long zzg;
        private zzgl<zzbf> zzh = zzga.zzm();

        /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
        /* loaded from: classes.dex */
        public static final class zza extends zzga.zzb<zzay, zza> implements zzhm {
            private zza() {
                super(zzay.zzi);
            }

            /* synthetic */ zza(zzbk zzbkVar) {
                this();
            }
        }

        static {
            zzay zzayVar = new zzay();
            zzi = zzayVar;
            zzga.zza(zzay.class, zzayVar);
        }

        private zzay() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzga
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzbk.zza[i - 1]) {
                case 1:
                    return new zzay();
                case 2:
                    return new zza(null);
                case 3:
                    return zzga.zza(zzi, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0000\u0001ဉ\u0000\u0002ဌ\u0001\u0003ဃ\u0002\u0004ဃ\u0003\u0005\u001b", new Object[]{"zzc", "zzd", "zze", zzbv.zzb(), "zzf", "zzg", "zzh", zzbf.class});
                case 4:
                    return zzi;
                case 5:
                    zzhu<zzay> zzhuVar = zzj;
                    if (zzhuVar == null) {
                        synchronized (zzay.class) {
                            zzhuVar = zzj;
                            if (zzhuVar == null) {
                                zzhuVar = new zzga.zza<>(zzi);
                                zzj = zzhuVar;
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
    public static final class zzbe extends zzga<zzbe, zza> implements zzhm {
        private static final zzbe zzl;
        private static volatile zzhu<zzbe> zzm;
        private int zzc;
        private zzaf zzd;
        private zzbi zze;
        private int zzf;
        private int zzg;
        private int zzh;
        private int zzi;
        private int zzj;
        private int zzk;

        /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
        /* loaded from: classes.dex */
        public static final class zza extends zzga.zzb<zzbe, zza> implements zzhm {
            private zza() {
                super(zzbe.zzl);
            }

            /* synthetic */ zza(zzbk zzbkVar) {
                this();
            }
        }

        /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
        /* loaded from: classes.dex */
        public enum zzb implements zzgf {
            NO_ERROR(0),
            METADATA_FILE_UNAVAILABLE(1),
            METADATA_ENTRY_NOT_FOUND(2),
            METADATA_JSON_INVALID(3),
            METADATA_HASH_NOT_FOUND(4),
            DOWNLOAD_MANAGER_SERVICE_MISSING(5),
            DOWNLOAD_MANAGER_HTTP_UNKNOWN_STATUS(6),
            DOWNLOAD_MANAGER_HTTP_BAD_REQUEST(400),
            DOWNLOAD_MANAGER_HTTP_UNAUTHORIZED(401),
            DOWNLOAD_MANAGER_HTTP_FORBIDDEN(403),
            DOWNLOAD_MANAGER_HTTP_NOT_FOUND(404),
            DOWNLOAD_MANAGER_HTTP_REQUEST_TIMEOUT(408),
            DOWNLOAD_MANAGER_HTTP_ABORTED(409),
            DOWNLOAD_MANAGER_HTTP_TOO_MANY_REQUESTS(429),
            DOWNLOAD_MANAGER_HTTP_CANCELLED(499),
            DOWNLOAD_MANAGER_HTTP_UNIMPLEMENTED(501),
            DOWNLOAD_MANAGER_HTTP_INTERNAL_SERVICE_ERROR(ServiceStarter.ERROR_UNKNOWN),
            DOWNLOAD_MANAGER_HTTP_SERVICE_UNAVAILABLE(503),
            DOWNLOAD_MANAGER_HTTP_DEADLINE_EXCEEDED(504),
            DOWNLOAD_MANAGER_HTTP_NETWORK_AUTHENTICATION_REQUIRED(FrameMetricsAggregator.EVERY_DURATION),
            DOWNLOAD_MANAGER_FILE_ERROR(7),
            DOWNLOAD_MANAGER_UNHANDLED_HTTP_CODE(8),
            DOWNLOAD_MANAGER_HTTP_DATA_ERROR(9),
            DOWNLOAD_MANAGER_TOO_MANY_REDIRECTS(10),
            DOWNLOAD_MANAGER_INSUFFICIENT_SPACE(11),
            DOWNLOAD_MANAGER_DEVICE_NOT_FOUND(12),
            DOWNLOAD_MANAGER_CANNOT_RESUME(13),
            DOWNLOAD_MANAGER_FILE_ALREADY_EXISTS(14),
            DOWNLOAD_MANAGER_UNKNOWN_ERROR(15),
            POST_DOWNLOAD_FILE_NOT_FOUND(16),
            POST_DOWNLOAD_MOVE_FILE_FAILED(17),
            POST_DOWNLOAD_UNZIP_FAILED(18),
            RAPID_RESPONSE_COULD_NOT_BE_WRITTEN(19),
            DRIVER_OBJECT_DEALLOCATED(20);
            
            private static final zzge<zzb> zzai = new zzdl();
            private final int zzaj;

            zzb(int i) {
                this.zzaj = i;
            }

            public static zzgh zzb() {
                return zzdm.zza;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "<" + zzb.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzaj + " name=" + name() + '>';
            }

            @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzgf
            public final int zza() {
                return this.zzaj;
            }
        }

        static {
            zzbe zzbeVar = new zzbe();
            zzl = zzbeVar;
            zzga.zza(zzbe.class, zzbeVar);
        }

        private zzbe() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzga
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzbk.zza[i - 1]) {
                case 1:
                    return new zzbe();
                case 2:
                    return new zza(null);
                case 3:
                    return zzga.zza(zzl, "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003င\u0002\u0004င\u0003\u0005င\u0004\u0006င\u0005\u0007ဌ\u0006\bင\u0007", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", zzb.zzb(), "zzk"});
                case 4:
                    return zzl;
                case 5:
                    zzhu<zzbe> zzhuVar = zzm;
                    if (zzhuVar == null) {
                        synchronized (zzbe.class) {
                            zzhuVar = zzm;
                            if (zzhuVar == null) {
                                zzhuVar = new zzga.zza<>(zzl);
                                zzm = zzhuVar;
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
    public static final class zzbf extends zzga<zzbf, zzb> implements zzhm {
        private static final zzbf zzf;
        private static volatile zzhu<zzbf> zzg;
        private int zzc;
        private int zzd;
        private int zze;

        /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
        /* loaded from: classes.dex */
        public enum zza implements zzgf {
            UNKNOWN(0),
            CANONICAL(1),
            TFLITE(2),
            TFLITE_SUPPORT(3);
            
            private static final zzge<zza> zze = new zzdo();
            private final int zzf;

            zza(int i) {
                this.zzf = i;
            }

            public static zzgh zzb() {
                return zzdn.zza;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "<" + zza.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzf + " name=" + name() + '>';
            }

            @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzgf
            public final int zza() {
                return this.zzf;
            }
        }

        /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
        /* loaded from: classes.dex */
        public static final class zzb extends zzga.zzb<zzbf, zzb> implements zzhm {
            private zzb() {
                super(zzbf.zzf);
            }

            /* synthetic */ zzb(zzbk zzbkVar) {
                this();
            }
        }

        static {
            zzbf zzbfVar = new zzbf();
            zzf = zzbfVar;
            zzga.zza(zzbf.class, zzbfVar);
        }

        private zzbf() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzga
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzbk.zza[i - 1]) {
                case 1:
                    return new zzbf();
                case 2:
                    return new zzb(null);
                case 3:
                    return zzga.zza(zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဌ\u0000\u0002င\u0001", new Object[]{"zzc", "zzd", zza.zzb(), "zze"});
                case 4:
                    return zzf;
                case 5:
                    zzhu<zzbf> zzhuVar = zzg;
                    if (zzhuVar == null) {
                        synchronized (zzbf.class) {
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
        private static final zzj zze;
        private static volatile zzhu<zzj> zzf;
        private int zzc;
        private int zzd;

        /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
        /* loaded from: classes.dex */
        public static final class zza extends zzga.zzb<zzj, zza> implements zzhm {
            private zza() {
                super(zzj.zze);
            }

            /* synthetic */ zza(zzbk zzbkVar) {
                this();
            }
        }

        static {
            zzj zzjVar = new zzj();
            zze = zzjVar;
            zzga.zza(zzj.class, zzjVar);
        }

        private zzj() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzga
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzbk.zza[i - 1]) {
                case 1:
                    return new zzj();
                case 2:
                    return new zza(null);
                case 3:
                    return zzga.zza(zze, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဌ\u0000", new Object[]{"zzc", "zzd", zzbv.zzb()});
                case 4:
                    return zze;
                case 5:
                    zzhu<zzj> zzhuVar = zzf;
                    if (zzhuVar == null) {
                        synchronized (zzj.class) {
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
    public static final class zzl extends zzga<zzl, zza> implements zzhm {
        private static final zzgi<Integer, zzbv> zzg = new zzbo();
        private static final zzl zzi;
        private static volatile zzhu<zzl> zzj;
        private int zzc;
        private zzam zzd;
        private zzam zze;
        private zzgj zzf = zzga.zzk();
        private long zzh;

        /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
        /* loaded from: classes.dex */
        public static final class zza extends zzga.zzb<zzl, zza> implements zzhm {
            private zza() {
                super(zzl.zzi);
            }

            /* synthetic */ zza(zzbk zzbkVar) {
                this();
            }
        }

        static {
            zzl zzlVar = new zzl();
            zzi = zzlVar;
            zzga.zza(zzl.class, zzlVar);
        }

        private zzl() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzga
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzbk.zza[i - 1]) {
                case 1:
                    return new zzl();
                case 2:
                    return new zza(null);
                case 3:
                    return zzga.zza(zzi, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003\u001e\u0004ဃ\u0002", new Object[]{"zzc", "zzd", "zze", "zzf", zzbv.zzb(), "zzh"});
                case 4:
                    return zzi;
                case 5:
                    zzhu<zzl> zzhuVar = zzj;
                    if (zzhuVar == null) {
                        synchronized (zzl.class) {
                            zzhuVar = zzj;
                            if (zzhuVar == null) {
                                zzhuVar = new zzga.zza<>(zzi);
                                zzj = zzhuVar;
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
    public static final class zzn extends zzga<zzn, zzb> implements zzhm {
        private static final zzn zzf;
        private static volatile zzhu<zzn> zzg;
        private int zzc;
        private int zzd;
        private int zze;

        /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
        /* loaded from: classes.dex */
        public enum zza implements zzgf {
            UNKNOWN_MODEL_TYPE(0),
            STABLE_MODEL(1),
            LATEST_MODEL(2);
            
            private static final zzge<zza> zzd = new zzbq();
            private final int zze;

            zza(int i) {
                this.zze = i;
            }

            public static zzgh zzb() {
                return zzbp.zza;
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
        /* loaded from: classes.dex */
        public static final class zzb extends zzga.zzb<zzn, zzb> implements zzhm {
            private zzb() {
                super(zzn.zzf);
            }

            /* synthetic */ zzb(zzbk zzbkVar) {
                this();
            }
        }

        static {
            zzn zznVar = new zzn();
            zzf = zznVar;
            zzga.zza(zzn.class, zznVar);
        }

        private zzn() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzga
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzbk.zza[i - 1]) {
                case 1:
                    return new zzn();
                case 2:
                    return new zzb(null);
                case 3:
                    return zzga.zza(zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001င\u0000\u0002ဌ\u0001", new Object[]{"zzc", "zzd", "zze", zza.zzb()});
                case 4:
                    return zzf;
                case 5:
                    zzhu<zzn> zzhuVar = zzg;
                    if (zzhuVar == null) {
                        synchronized (zzn.class) {
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
    public static final class zzx extends zzga<zzx, zza> implements zzhm {
        private static final zzx zzf;
        private static volatile zzhu<zzx> zzg;
        private int zzc;
        private zzam zzd;
        private int zze;

        /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
        /* loaded from: classes.dex */
        public static final class zza extends zzga.zzb<zzx, zza> implements zzhm {
            private zza() {
                super(zzx.zzf);
            }

            /* synthetic */ zza(zzbk zzbkVar) {
                this();
            }
        }

        static {
            zzx zzxVar = new zzx();
            zzf = zzxVar;
            zzga.zza(zzx.class, zzxVar);
        }

        private zzx() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzga
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzbk.zza[i - 1]) {
                case 1:
                    return new zzx();
                case 2:
                    return new zza(null);
                case 3:
                    return zzga.zza(zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဌ\u0001", new Object[]{"zzc", "zzd", "zze", zzbv.zzb()});
                case 4:
                    return zzf;
                case 5:
                    zzhu<zzx> zzhuVar = zzg;
                    if (zzhuVar == null) {
                        synchronized (zzx.class) {
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
    public static final class zzz extends zzga<zzz, zza> implements zzhm {
        private static final zzgi<Integer, zzbv> zzg = new zzbt();
        private static final zzz zzj;
        private static volatile zzhu<zzz> zzk;
        private int zzc;
        private zzam zzd;
        private zzam zze;
        private zzgj zzf = zzga.zzk();
        private long zzh;
        private boolean zzi;

        /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
        /* loaded from: classes.dex */
        public static final class zza extends zzga.zzb<zzz, zza> implements zzhm {
            private zza() {
                super(zzz.zzj);
            }

            /* synthetic */ zza(zzbk zzbkVar) {
                this();
            }
        }

        static {
            zzz zzzVar = new zzz();
            zzj = zzzVar;
            zzga.zza(zzz.class, zzzVar);
        }

        private zzz() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzga
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzbk.zza[i - 1]) {
                case 1:
                    return new zzz();
                case 2:
                    return new zza(null);
                case 3:
                    return zzga.zza(zzj, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003\u001e\u0004ဃ\u0002\u0005ဇ\u0003", new Object[]{"zzc", "zzd", "zze", "zzf", zzbv.zzb(), "zzh", "zzi"});
                case 4:
                    return zzj;
                case 5:
                    zzhu<zzz> zzhuVar = zzk;
                    if (zzhuVar == null) {
                        synchronized (zzz.class) {
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

    /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
    /* loaded from: classes.dex */
    public static final class zzag extends zzga<zzag, zzb> implements zzhm {
        private static final zzag zzk;
        private static volatile zzhu<zzag> zzl;
        private int zzc;
        private long zzd;
        private int zze;
        private int zzf;
        private int zzg;
        private int zzh;
        private int zzi;
        private int zzj;

        /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
        /* loaded from: classes.dex */
        public enum zza implements zzgf {
            SOURCE_UNKNOWN(0),
            BITMAP(1),
            BYTEARRAY(2),
            BYTEBUFFER(3),
            FILEPATH(4),
            ANDROID_MEDIA_IMAGE(5);
            
            private static final zzge<zza> zzg = new zzcl();
            private final int zzh;

            zza(int i) {
                this.zzh = i;
            }

            public static zzgh zzb() {
                return zzck.zza;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "<" + zza.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzh + " name=" + name() + '>';
            }

            @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzgf
            public final int zza() {
                return this.zzh;
            }
        }

        /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
        /* loaded from: classes.dex */
        public static final class zzb extends zzga.zzb<zzag, zzb> implements zzhm {
            private zzb() {
                super(zzag.zzk);
            }

            /* synthetic */ zzb(zzbk zzbkVar) {
                this();
            }
        }

        static {
            zzag zzagVar = new zzag();
            zzk = zzagVar;
            zzga.zza(zzag.class, zzagVar);
        }

        private zzag() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzga
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzbk.zza[i - 1]) {
                case 1:
                    return new zzag();
                case 2:
                    return new zzb(null);
                case 3:
                    return zzga.zza(zzk, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0000\u0000\u0001ဃ\u0000\u0002ဌ\u0001\u0003ဌ\u0002\u0004ဋ\u0003\u0005ဋ\u0004\u0006ဋ\u0005\u0007ဋ\u0006", new Object[]{"zzc", "zzd", "zze", zza.zzb(), "zzf", zzae.zzb.zzb(), "zzg", "zzh", "zzi", "zzj"});
                case 4:
                    return zzk;
                case 5:
                    zzhu<zzag> zzhuVar = zzl;
                    if (zzhuVar == null) {
                        synchronized (zzag.class) {
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
    public static final class zzak extends zzga<zzak, zzb> implements zzhm {
        private static final zzak zzj;
        private static volatile zzhu<zzak> zzk;
        private int zzc;
        private zzam zzd;
        private long zze;
        private int zzf;
        private long zzg;
        private int zzh;
        private long zzi;

        /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
        /* loaded from: classes.dex */
        public enum zza implements zzgf {
            UNKNOWN_STATUS(0),
            EXPLICITLY_REQUESTED(1),
            IMPLICITLY_REQUESTED(2),
            MODEL_INFO_RETRIEVAL_SUCCEEDED(3),
            MODEL_INFO_RETRIEVAL_FAILED(4),
            SCHEDULED(5),
            DOWNLOADING(6),
            SUCCEEDED(7),
            FAILED(8),
            LIVE(9),
            UPDATE_AVAILABLE(10),
            DOWNLOADED(11);
            
            private static final zzge<zza> zzm = new zzcp();
            private final int zzn;

            zza(int i) {
                this.zzn = i;
            }

            public static zzgh zzb() {
                return zzco.zza;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "<" + zza.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzn + " name=" + name() + '>';
            }

            @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzgf
            public final int zza() {
                return this.zzn;
            }
        }

        /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
        /* loaded from: classes.dex */
        public static final class zzb extends zzga.zzb<zzak, zzb> implements zzhm {
            private zzb() {
                super(zzak.zzj);
            }

            /* synthetic */ zzb(zzbk zzbkVar) {
                this();
            }
        }

        static {
            zzak zzakVar = new zzak();
            zzj = zzakVar;
            zzga.zza(zzak.class, zzakVar);
        }

        private zzak() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzga
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzbk.zza[i - 1]) {
                case 1:
                    return new zzak();
                case 2:
                    return new zzb(null);
                case 3:
                    return zzga.zza(zzj, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဃ\u0001\u0003ဌ\u0002\u0004ဃ\u0003\u0005ဌ\u0004\u0006ဂ\u0005", new Object[]{"zzc", "zzd", "zze", "zzf", zzbv.zzb(), "zzg", "zzh", zza.zzb(), "zzi"});
                case 4:
                    return zzj;
                case 5:
                    zzhu<zzak> zzhuVar = zzk;
                    if (zzhuVar == null) {
                        synchronized (zzak.class) {
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

    /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
    /* loaded from: classes.dex */
    public static final class zzal extends zzga<zzal, zza> implements zzhm {
        private static final zzal zzl;
        private static volatile zzhu<zzal> zzm;
        private int zzc;
        private int zzf;
        private int zzi;
        private long zzj;
        private boolean zzk;
        private String zzd = "";
        private String zze = "";
        private String zzg = "";
        private String zzh = "";

        /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
        /* loaded from: classes.dex */
        public static final class zza extends zzga.zzb<zzal, zza> implements zzhm {
            private zza() {
                super(zzal.zzl);
            }

            /* synthetic */ zza(zzbk zzbkVar) {
                this();
            }
        }

        /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
        /* loaded from: classes.dex */
        public enum zzb implements zzgf {
            TYPE_UNKNOWN(0),
            CUSTOM(1),
            AUTOML_IMAGE_LABELING(2),
            BASE_TRANSLATE(3),
            CUSTOM_OBJECT_DETECTION(4),
            CUSTOM_IMAGE_LABELING(5),
            BASE_ENTITY_EXTRACTION(6);
            
            private static final zzge<zzb> zzh = new zzcq();
            private final int zzi;

            zzb(int i) {
                this.zzi = i;
            }

            public static zzgh zzb() {
                return zzcr.zza;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "<" + zzb.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzi + " name=" + name() + '>';
            }

            @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzgf
            public final int zza() {
                return this.zzi;
            }
        }

        /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
        /* loaded from: classes.dex */
        public enum zzc implements zzgf {
            SOURCE_UNKNOWN(0),
            APP_ASSET(1),
            LOCAL(2),
            CLOUD(3),
            SDK_BUILT_IN(4);
            
            private static final zzge<zzc> zzf = new zzct();
            private final int zzg;

            zzc(int i) {
                this.zzg = i;
            }

            public static zzgh zzb() {
                return zzcs.zza;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "<" + zzc.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzg + " name=" + name() + '>';
            }

            @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzgf
            public final int zza() {
                return this.zzg;
            }
        }

        static {
            zzal zzalVar = new zzal();
            zzl = zzalVar;
            zzga.zza(zzal.class, zzalVar);
        }

        private zzal() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzga
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzbk.zza[i - 1]) {
                case 1:
                    return new zzal();
                case 2:
                    return new zza(null);
                case 3:
                    return zzga.zza(zzl, "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဌ\u0002\u0004ဈ\u0003\u0005ဈ\u0004\u0006ဌ\u0005\u0007ဃ\u0006\bဇ\u0007", new Object[]{"zzc", "zzd", "zze", "zzf", zzc.zzb(), "zzg", "zzh", "zzi", zzb.zzb(), "zzj", "zzk"});
                case 4:
                    return zzl;
                case 5:
                    zzhu<zzal> zzhuVar = zzm;
                    if (zzhuVar == null) {
                        synchronized (zzal.class) {
                            zzhuVar = zzm;
                            if (zzhuVar == null) {
                                zzhuVar = new zzga.zza<>(zzl);
                                zzm = zzhuVar;
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
    public static final class zzba extends zzga<zzba, zzb> implements zzhm {
        private static final zzba zzf;
        private static volatile zzhu<zzba> zzg;
        private int zzc;
        private int zzd;
        private int zze;

        /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
        /* loaded from: classes.dex */
        public enum zza implements zzgf {
            INVALID_MODE(0),
            STREAM(1),
            SINGLE_IMAGE(2);
            
            private static final zzge<zza> zzd = new zzdg();
            private final int zze;

            zza(int i) {
                this.zze = i;
            }

            public static zzgh zzb() {
                return zzdf.zza;
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
        /* loaded from: classes.dex */
        public static final class zzb extends zzga.zzb<zzba, zzb> implements zzhm {
            private zzb() {
                super(zzba.zzf);
            }

            /* synthetic */ zzb(zzbk zzbkVar) {
                this();
            }
        }

        /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
        /* loaded from: classes.dex */
        public enum zzc implements zzgf {
            UNKNOWN_PERFORMANCE(0),
            FAST(1),
            ACCURATE(2);
            
            private static final zzge<zzc> zzd = new zzdh();
            private final int zze;

            zzc(int i) {
                this.zze = i;
            }

            public static zzgh zzb() {
                return zzdi.zza;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "<" + zzc.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zze + " name=" + name() + '>';
            }

            @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzgf
            public final int zza() {
                return this.zze;
            }
        }

        static {
            zzba zzbaVar = new zzba();
            zzf = zzbaVar;
            zzga.zza(zzba.class, zzbaVar);
        }

        private zzba() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzga
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzbk.zza[i - 1]) {
                case 1:
                    return new zzba();
                case 2:
                    return new zzb(null);
                case 3:
                    return zzga.zza(zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဌ\u0001", new Object[]{"zzc", "zzd", zza.zzb(), "zze", zzc.zzb()});
                case 4:
                    return zzf;
                case 5:
                    zzhu<zzba> zzhuVar = zzg;
                    if (zzhuVar == null) {
                        synchronized (zzba.class) {
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
    public static final class zzbg extends zzga<zzbg, zzb> implements zzhm {
        private static final zzgi<Integer, zza> zzf = new zzdp();
        private static final zzgi<Integer, zza> zzh = new zzdr();
        private static final zzgi<Integer, zza> zzj = new zzdq();
        private static final zzbg zzl;
        private static volatile zzhu<zzbg> zzm;
        private int zzc;
        private long zzd;
        private zzgj zze = zzga.zzk();
        private zzgj zzg = zzga.zzk();
        private zzgj zzi = zzga.zzk();
        private int zzk;

        /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
        /* loaded from: classes.dex */
        public enum zza implements zzgf {
            UNKNOWN_ERROR(0),
            NO_CONNECTION(1),
            RPC_ERROR(2),
            RPC_RETURNED_INVALID_RESULT(3),
            RPC_RETURNED_MALFORMED_RESULT(4),
            RPC_EXPONENTIAL_BACKOFF_FAILED(5),
            DIRECTORY_CREATION_FAILED(10),
            FILE_WRITE_FAILED_DISK_FULL(11),
            FILE_WRITE_FAILED(12),
            FILE_READ_FAILED(13),
            FILE_READ_RETURNED_INVALID_DATA(14),
            FILE_READ_RETURNED_MALFORMED_DATA(15);
            
            private static final zzge<zza> zzm = new zzdt();
            private final int zzn;

            zza(int i) {
                this.zzn = i;
            }

            public static zzgh zzb() {
                return zzds.zza;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "<" + zza.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzn + " name=" + name() + '>';
            }

            @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzgf
            public final int zza() {
                return this.zzn;
            }
        }

        /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
        /* loaded from: classes.dex */
        public static final class zzb extends zzga.zzb<zzbg, zzb> implements zzhm {
            private zzb() {
                super(zzbg.zzl);
            }

            /* synthetic */ zzb(zzbk zzbkVar) {
                this();
            }
        }

        static {
            zzbg zzbgVar = new zzbg();
            zzl = zzbgVar;
            zzga.zza(zzbg.class, zzbgVar);
        }

        private zzbg() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzga
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzbk.zza[i - 1]) {
                case 1:
                    return new zzbg();
                case 2:
                    return new zzb(null);
                case 3:
                    return zzga.zza(zzl, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0003\u0000\u0001ဃ\u0000\u0002\u001e\u0003\u001e\u0004\u001e\u0005င\u0001", new Object[]{"zzc", "zzd", "zze", zza.zzb(), "zzg", zza.zzb(), "zzi", zza.zzb(), "zzk"});
                case 4:
                    return zzl;
                case 5:
                    zzhu<zzbg> zzhuVar = zzm;
                    if (zzhuVar == null) {
                        synchronized (zzbg.class) {
                            zzhuVar = zzm;
                            if (zzhuVar == null) {
                                zzhuVar = new zzga.zza<>(zzl);
                                zzm = zzhuVar;
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
    public static final class zzac extends zzga<zzac, zza> implements zzhm {
        private static final zzac zzj;
        private static volatile zzhu<zzac> zzk;
        private int zzc;
        private int zzd;
        private int zze;
        private int zzf;
        private int zzg;
        private boolean zzh;
        private float zzi;

        /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
        /* loaded from: classes.dex */
        public static final class zza extends zzga.zzb<zzac, zza> implements zzhm {
            private zza() {
                super(zzac.zzj);
            }

            /* synthetic */ zza(zzbk zzbkVar) {
                this();
            }
        }

        /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
        /* loaded from: classes.dex */
        public enum zzb implements zzgf {
            UNKNOWN_CLASSIFICATIONS(0),
            NO_CLASSIFICATIONS(1),
            ALL_CLASSIFICATIONS(2);
            
            private static final zzge<zzb> zzd = new zzca();
            private final int zze;

            zzb(int i) {
                this.zze = i;
            }

            public static zzgh zzb() {
                return zzcb.zza;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "<" + zzb.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zze + " name=" + name() + '>';
            }

            @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzgf
            public final int zza() {
                return this.zze;
            }
        }

        /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
        /* loaded from: classes.dex */
        public enum zzc implements zzgf {
            UNKNOWN_CONTOURS(0),
            NO_CONTOURS(1),
            ALL_CONTOURS(2);
            
            private static final zzge<zzc> zzd = new zzcd();
            private final int zze;

            zzc(int i) {
                this.zze = i;
            }

            public static zzgh zzb() {
                return zzcc.zza;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "<" + zzc.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zze + " name=" + name() + '>';
            }

            @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzgf
            public final int zza() {
                return this.zze;
            }
        }

        /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
        /* loaded from: classes.dex */
        public enum zzd implements zzgf {
            UNKNOWN_LANDMARKS(0),
            NO_LANDMARKS(1),
            ALL_LANDMARKS(2);
            
            private static final zzge<zzd> zzd = new zzce();
            private final int zze;

            zzd(int i) {
                this.zze = i;
            }

            public static zzgh zzb() {
                return zzcf.zza;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "<" + zzd.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zze + " name=" + name() + '>';
            }

            @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzgf
            public final int zza() {
                return this.zze;
            }
        }

        /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
        /* loaded from: classes.dex */
        public enum zze implements zzgf {
            UNKNOWN_PERFORMANCE(0),
            FAST(1),
            ACCURATE(2);
            
            private static final zzge<zze> zzd = new zzch();
            private final int zze;

            zze(int i) {
                this.zze = i;
            }

            public static zzgh zzb() {
                return zzcg.zza;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "<" + zze.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zze + " name=" + name() + '>';
            }

            @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzgf
            public final int zza() {
                return this.zze;
            }
        }

        static {
            zzac zzacVar = new zzac();
            zzj = zzacVar;
            zzga.zza(zzac.class, zzacVar);
        }

        private zzac() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzga
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzbk.zza[i - 1]) {
                case 1:
                    return new zzac();
                case 2:
                    return new zza(null);
                case 3:
                    return zzga.zza(zzj, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဌ\u0001\u0003ဌ\u0002\u0004ဌ\u0003\u0005ဇ\u0004\u0006ခ\u0005", new Object[]{"zzc", "zzd", zzd.zzb(), "zze", zzb.zzb(), "zzf", zze.zzb(), "zzg", zzc.zzb(), "zzh", "zzi"});
                case 4:
                    return zzj;
                case 5:
                    zzhu<zzac> zzhuVar = zzk;
                    if (zzhuVar == null) {
                        synchronized (zzac.class) {
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
