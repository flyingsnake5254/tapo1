package com.google.android.gms.internal.mlkit_common;

import androidx.core.app.FrameMetricsAggregator;
import com.google.android.gms.internal.mlkit_common.zzck;
import com.google.android.gms.internal.mlkit_common.zzez;
import com.google.android.gms.internal.mlkit_common.zzij;
import com.google.firebase.messaging.ServiceStarter;

/* compiled from: com.google.mlkit:common@@16.0.0 */
/* loaded from: classes.dex */
public final class zzaa {

    /* compiled from: com.google.mlkit:common@@16.0.0 */
    /* loaded from: classes.dex */
    public static final class zzaj extends zzez<zzaj, zzb> implements zzgj {
        private static final zzaj zze;
        private static volatile zzgr<zzaj> zzf;
        private int zzc;
        private int zzd;

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        /* loaded from: classes.dex */
        public enum zza implements zzfb {
            UNKNOWN(0),
            TRANSLATE(1);
            
            private static final zzfe<zza> zzc = new zzbd();
            private final int zzd;

            zza(int i) {
                this.zzd = i;
            }

            public static zzfd zzb() {
                return zzbe.zza;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "<" + zza.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzd + " name=" + name() + '>';
            }

            @Override // com.google.android.gms.internal.mlkit_common.zzfb
            public final int zza() {
                return this.zzd;
            }

            public static zza zza(int i) {
                if (i == 0) {
                    return UNKNOWN;
                }
                if (i != 1) {
                    return null;
                }
                return TRANSLATE;
            }
        }

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        /* loaded from: classes.dex */
        public static final class zzb extends zzez.zza<zzaj, zzb> implements zzgj {
            private zzb() {
                super(zzaj.zze);
            }

            public final zzb zza(zza zzaVar) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zzaj) this.zza).zza(zzaVar);
                return this;
            }

            /* synthetic */ zzb(zzac zzacVar) {
                this();
            }
        }

        static {
            zzaj zzajVar = new zzaj();
            zze = zzajVar;
            zzez.zza(zzaj.class, zzajVar);
        }

        private zzaj() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(zza zzaVar) {
            this.zzd = zzaVar.zza();
            this.zzc |= 1;
        }

        public static zzb zza() {
            return zze.zzh();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzaj>, com.google.android.gms.internal.mlkit_common.zzez$zzc] */
        /* JADX WARN: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_common.zzez
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_common.zzac.zza
                r4 = 1
                int r2 = r2 - r4
                r2 = r3[r2]
                r3 = 0
                switch(r2) {
                    case 1: goto L_0x0055;
                    case 2: goto L_0x004f;
                    case 3: goto L_0x0033;
                    case 4: goto L_0x0030;
                    case 5: goto L_0x0016;
                    case 6: goto L_0x0011;
                    case 7: goto L_0x0010;
                    default: goto L_0x000a;
                }
            L_0x000a:
                java.lang.UnsupportedOperationException r2 = new java.lang.UnsupportedOperationException
                r2.<init>()
                throw r2
            L_0x0010:
                return r3
            L_0x0011:
                java.lang.Byte r2 = java.lang.Byte.valueOf(r4)
                return r2
            L_0x0016:
                com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzaj> r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzaj.zzf
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_common.zzaa$zzaj> r3 = com.google.android.gms.internal.mlkit_common.zzaa.zzaj.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzaj> r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzaj.zzf     // Catch: all -> 0x002c
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_common.zzez$zzc r2 = new com.google.android.gms.internal.mlkit_common.zzez$zzc     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_common.zzaa$zzaj r4 = com.google.android.gms.internal.mlkit_common.zzaa.zzaj.zze     // Catch: all -> 0x002c
                r2.<init>(r4)     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_common.zzaa.zzaj.zzf = r2     // Catch: all -> 0x002c
            L_0x002a:
                monitor-exit(r3)     // Catch: all -> 0x002c
                goto L_0x002f
            L_0x002c:
                r2 = move-exception
                monitor-exit(r3)     // Catch: all -> 0x002c
                throw r2
            L_0x002f:
                return r2
            L_0x0030:
                com.google.android.gms.internal.mlkit_common.zzaa$zzaj r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzaj.zze
                return r2
            L_0x0033:
                r2 = 3
                java.lang.Object[] r2 = new java.lang.Object[r2]
                r3 = 0
                java.lang.String r0 = "zzc"
                r2[r3] = r0
                java.lang.String r3 = "zzd"
                r2[r4] = r3
                r3 = 2
                com.google.android.gms.internal.mlkit_common.zzfd r4 = com.google.android.gms.internal.mlkit_common.zzaa.zzaj.zza.zzb()
                r2[r3] = r4
                java.lang.String r3 = "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဌ\u0000"
                com.google.android.gms.internal.mlkit_common.zzaa$zzaj r4 = com.google.android.gms.internal.mlkit_common.zzaa.zzaj.zze
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_common.zzez.zza(r4, r3, r2)
                return r2
            L_0x004f:
                com.google.android.gms.internal.mlkit_common.zzaa$zzaj$zzb r2 = new com.google.android.gms.internal.mlkit_common.zzaa$zzaj$zzb
                r2.<init>(r3)
                return r2
            L_0x0055:
                com.google.android.gms.internal.mlkit_common.zzaa$zzaj r2 = new com.google.android.gms.internal.mlkit_common.zzaa$zzaj
                r2.<init>()
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzaa.zzaj.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: com.google.mlkit:common@@16.0.0 */
    /* loaded from: classes.dex */
    public static final class zzak extends zzez<zzak, zza> implements zzgj {
        private static final zzak zzj;
        private static volatile zzgr<zzak> zzk;
        private int zzc;
        private zzam zzd;
        private long zze;
        private int zzf;
        private long zzg;
        private int zzh;
        private long zzi;

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        /* loaded from: classes.dex */
        public static final class zza extends zzez.zza<zzak, zza> implements zzgj {
            private zza() {
                super(zzak.zzj);
            }

            public final zza zza(zzam zzamVar) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zzak) this.zza).zza(zzamVar);
                return this;
            }

            public final zza zzb(long j) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zzak) this.zza).zzb(j);
                return this;
            }

            public final zza zzc(long j) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zzak) this.zza).zzc(j);
                return this;
            }

            /* synthetic */ zza(zzac zzacVar) {
                this();
            }

            public final zza zza(long j) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zzak) this.zza).zza(j);
                return this;
            }

            public final zza zza(zzal zzalVar) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zzak) this.zza).zza(zzalVar);
                return this;
            }

            public final zza zza(zzb zzbVar) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zzak) this.zza).zza(zzbVar);
                return this;
            }
        }

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        /* loaded from: classes.dex */
        public enum zzb implements zzfb {
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
            
            private static final zzfe<zzb> zzm = new zzbf();
            private final int zzn;

            zzb(int i) {
                this.zzn = i;
            }

            public static zzfd zzb() {
                return zzbg.zza;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "<" + zzb.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzn + " name=" + name() + '>';
            }

            @Override // com.google.android.gms.internal.mlkit_common.zzfb
            public final int zza() {
                return this.zzn;
            }
        }

        static {
            zzak zzakVar = new zzak();
            zzj = zzakVar;
            zzez.zza(zzak.class, zzakVar);
        }

        private zzak() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(zzam zzamVar) {
            zzamVar.getClass();
            this.zzd = zzamVar;
            this.zzc |= 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzb(long j) {
            this.zzc |= 8;
            this.zzg = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzc(long j) {
            this.zzc |= 32;
            this.zzi = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(long j) {
            this.zzc |= 2;
            this.zze = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(zzal zzalVar) {
            this.zzf = zzalVar.zza();
            this.zzc |= 4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(zzb zzbVar) {
            this.zzh = zzbVar.zza();
            this.zzc |= 16;
        }

        public static zza zza() {
            return zzj.zzh();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzak>, com.google.android.gms.internal.mlkit_common.zzez$zzc] */
        /* JADX WARN: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_common.zzez
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_common.zzac.zza
                r4 = 1
                int r2 = r2 - r4
                r2 = r3[r2]
                r3 = 0
                switch(r2) {
                    case 1: goto L_0x0077;
                    case 2: goto L_0x0071;
                    case 3: goto L_0x0033;
                    case 4: goto L_0x0030;
                    case 5: goto L_0x0016;
                    case 6: goto L_0x0011;
                    case 7: goto L_0x0010;
                    default: goto L_0x000a;
                }
            L_0x000a:
                java.lang.UnsupportedOperationException r2 = new java.lang.UnsupportedOperationException
                r2.<init>()
                throw r2
            L_0x0010:
                return r3
            L_0x0011:
                java.lang.Byte r2 = java.lang.Byte.valueOf(r4)
                return r2
            L_0x0016:
                com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzak> r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzak.zzk
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_common.zzaa$zzak> r3 = com.google.android.gms.internal.mlkit_common.zzaa.zzak.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzak> r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzak.zzk     // Catch: all -> 0x002c
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_common.zzez$zzc r2 = new com.google.android.gms.internal.mlkit_common.zzez$zzc     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_common.zzaa$zzak r4 = com.google.android.gms.internal.mlkit_common.zzaa.zzak.zzj     // Catch: all -> 0x002c
                r2.<init>(r4)     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_common.zzaa.zzak.zzk = r2     // Catch: all -> 0x002c
            L_0x002a:
                monitor-exit(r3)     // Catch: all -> 0x002c
                goto L_0x002f
            L_0x002c:
                r2 = move-exception
                monitor-exit(r3)     // Catch: all -> 0x002c
                throw r2
            L_0x002f:
                return r2
            L_0x0030:
                com.google.android.gms.internal.mlkit_common.zzaa$zzak r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzak.zzj
                return r2
            L_0x0033:
                r2 = 9
                java.lang.Object[] r2 = new java.lang.Object[r2]
                r3 = 0
                java.lang.String r0 = "zzc"
                r2[r3] = r0
                java.lang.String r3 = "zzd"
                r2[r4] = r3
                r3 = 2
                java.lang.String r4 = "zze"
                r2[r3] = r4
                r3 = 3
                java.lang.String r4 = "zzf"
                r2[r3] = r4
                r3 = 4
                com.google.android.gms.internal.mlkit_common.zzfd r4 = com.google.android.gms.internal.mlkit_common.zzal.zzb()
                r2[r3] = r4
                r3 = 5
                java.lang.String r4 = "zzg"
                r2[r3] = r4
                r3 = 6
                java.lang.String r4 = "zzh"
                r2[r3] = r4
                r3 = 7
                com.google.android.gms.internal.mlkit_common.zzfd r4 = com.google.android.gms.internal.mlkit_common.zzaa.zzak.zzb.zzb()
                r2[r3] = r4
                r3 = 8
                java.lang.String r4 = "zzi"
                r2[r3] = r4
                java.lang.String r3 = "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဃ\u0001\u0003ဌ\u0002\u0004ဃ\u0003\u0005ဌ\u0004\u0006ဂ\u0005"
                com.google.android.gms.internal.mlkit_common.zzaa$zzak r4 = com.google.android.gms.internal.mlkit_common.zzaa.zzak.zzj
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_common.zzez.zza(r4, r3, r2)
                return r2
            L_0x0071:
                com.google.android.gms.internal.mlkit_common.zzaa$zzak$zza r2 = new com.google.android.gms.internal.mlkit_common.zzaa$zzak$zza
                r2.<init>(r3)
                return r2
            L_0x0077:
                com.google.android.gms.internal.mlkit_common.zzaa$zzak r2 = new com.google.android.gms.internal.mlkit_common.zzaa$zzak
                r2.<init>()
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzaa.zzak.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: com.google.mlkit:common@@16.0.0 */
    /* loaded from: classes.dex */
    public static final class zzad extends zzez.zze<zzad, zza> implements zzgj {
        private static final zzad zzbd;
        private static volatile zzgr<zzad> zzbe;
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
        private C0101zzaa zzao;
        private zza zzap;
        private zzb zzaq;
        private zzd zzar;
        private zzc zzas;
        private zze zzat;
        private zzf zzau;
        private zzi zzav;
        private zzg zzaw;
        private zzh zzax;
        private zzbf zzaz;
        private zzag zzba;
        private zzaj zzbb;
        private int zzd;
        private int zze;
        private zzbg zzf;
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
        private zzfi<zzij.zzf> zzay = zzez.zzl();

        static {
            zzad zzadVar = new zzad();
            zzbd = zzadVar;
            zzez.zza(zzad.class, zzadVar);
        }

        private zzad() {
        }

        public static zza zza(zzad zzadVar) {
            return (zza) zzbd.zza(zzadVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(zzaj zzajVar) {
            zzajVar.getClass();
            this.zzbb = zzajVar;
            this.zze |= 32768;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(zzak zzakVar) {
            zzakVar.getClass();
            this.zzi = zzakVar;
            this.zzd |= 8;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(zzbg zzbgVar) {
            zzbgVar.getClass();
            this.zzf = zzbgVar;
            this.zzd |= 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(zzap zzapVar) {
            this.zzg = zzapVar.zza();
            this.zzd |= 2;
        }

        public static zza zzb() {
            return (zza) zzbd.zzh();
        }

        public final zzbg zza() {
            zzbg zzbgVar = this.zzf;
            return zzbgVar == null ? zzbg.zzc() : zzbgVar;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Type inference failed for: r3v14, types: [com.google.android.gms.internal.mlkit_common.zzez$zzc, com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzad>] */
        /* JADX WARN: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_common.zzez
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object zza(int r3, java.lang.Object r4, java.lang.Object r5) {
            /*
                Method dump skipped, instructions count: 414
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzaa.zzad.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        /* loaded from: classes.dex */
        public static final class zza extends zzez.zzb<zzad, zza> implements zzgj {
            private zza() {
                super(zzad.zzbd);
            }

            /* synthetic */ zza(zzac zzacVar) {
                this();
            }

            public final zza zza(zzbg.zza zzaVar) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zzad) this.zza).zza((zzbg) ((zzez) zzaVar.zzh()));
                return this;
            }

            public final zzbg zza() {
                return ((zzad) this.zza).zza();
            }

            public final zza zza(zzap zzapVar) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zzad) this.zza).zza(zzapVar);
                return this;
            }

            public final zza zza(zzak.zza zzaVar) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zzad) this.zza).zza((zzak) ((zzez) zzaVar.zzh()));
                return this;
            }

            public final zza zza(zzaj.zzb zzbVar) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zzad) this.zza).zza((zzaj) ((zzez) zzbVar.zzh()));
                return this;
            }
        }
    }

    /* compiled from: com.google.mlkit:common@@16.0.0 */
    /* loaded from: classes.dex */
    public static final class zzal extends zzez<zzal, zzb> implements zzgj {
        private static final zzal zzl;
        private static volatile zzgr<zzal> zzm;
        private int zzc;
        private int zzf;
        private int zzi;
        private long zzj;
        private boolean zzk;
        private String zzd = "";
        private String zze = "";
        private String zzg = "";
        private String zzh = "";

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        /* loaded from: classes.dex */
        public enum zza implements zzfb {
            TYPE_UNKNOWN(0),
            CUSTOM(1),
            AUTOML_IMAGE_LABELING(2),
            BASE_TRANSLATE(3),
            CUSTOM_OBJECT_DETECTION(4),
            CUSTOM_IMAGE_LABELING(5);
            
            private static final zzfe<zza> zzg = new zzbi();
            private final int zzh;

            zza(int i) {
                this.zzh = i;
            }

            public static zzfd zzb() {
                return zzbh.zza;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "<" + zza.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzh + " name=" + name() + '>';
            }

            @Override // com.google.android.gms.internal.mlkit_common.zzfb
            public final int zza() {
                return this.zzh;
            }
        }

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        /* loaded from: classes.dex */
        public static final class zzb extends zzez.zza<zzal, zzb> implements zzgj {
            private zzb() {
                super(zzal.zzl);
            }

            public final zzb zza(String str) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zzal) this.zza).zza(str);
                return this;
            }

            public final zzb zzb(String str) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zzal) this.zza).zzb(str);
                return this;
            }

            /* synthetic */ zzb(zzac zzacVar) {
                this();
            }

            public final zzb zza(zzc zzcVar) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zzal) this.zza).zza(zzcVar);
                return this;
            }

            public final zzb zza(zza zzaVar) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zzal) this.zza).zza(zzaVar);
                return this;
            }
        }

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        /* loaded from: classes.dex */
        public enum zzc implements zzfb {
            SOURCE_UNKNOWN(0),
            APP_ASSET(1),
            LOCAL(2),
            CLOUD(3),
            SDK_BUILT_IN(4);
            
            private static final zzfe<zzc> zzf = new zzbj();
            private final int zzg;

            zzc(int i) {
                this.zzg = i;
            }

            public static zzfd zzb() {
                return zzbk.zza;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "<" + zzc.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzg + " name=" + name() + '>';
            }

            @Override // com.google.android.gms.internal.mlkit_common.zzfb
            public final int zza() {
                return this.zzg;
            }
        }

        static {
            zzal zzalVar = new zzal();
            zzl = zzalVar;
            zzez.zza(zzal.class, zzalVar);
        }

        private zzal() {
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
            this.zzc |= 16;
            this.zzh = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(zzc zzcVar) {
            this.zzf = zzcVar.zza();
            this.zzc |= 4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(zza zzaVar) {
            this.zzi = zzaVar.zza();
            this.zzc |= 32;
        }

        public static zzb zza() {
            return zzl.zzh();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzal>, com.google.android.gms.internal.mlkit_common.zzez$zzc] */
        /* JADX WARN: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_common.zzez
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_common.zzac.zza
                r4 = 1
                int r2 = r2 - r4
                r2 = r3[r2]
                r3 = 0
                switch(r2) {
                    case 1: goto L_0x0083;
                    case 2: goto L_0x007d;
                    case 3: goto L_0x0033;
                    case 4: goto L_0x0030;
                    case 5: goto L_0x0016;
                    case 6: goto L_0x0011;
                    case 7: goto L_0x0010;
                    default: goto L_0x000a;
                }
            L_0x000a:
                java.lang.UnsupportedOperationException r2 = new java.lang.UnsupportedOperationException
                r2.<init>()
                throw r2
            L_0x0010:
                return r3
            L_0x0011:
                java.lang.Byte r2 = java.lang.Byte.valueOf(r4)
                return r2
            L_0x0016:
                com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzal> r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzal.zzm
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_common.zzaa$zzal> r3 = com.google.android.gms.internal.mlkit_common.zzaa.zzal.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzal> r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzal.zzm     // Catch: all -> 0x002c
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_common.zzez$zzc r2 = new com.google.android.gms.internal.mlkit_common.zzez$zzc     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_common.zzaa$zzal r4 = com.google.android.gms.internal.mlkit_common.zzaa.zzal.zzl     // Catch: all -> 0x002c
                r2.<init>(r4)     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_common.zzaa.zzal.zzm = r2     // Catch: all -> 0x002c
            L_0x002a:
                monitor-exit(r3)     // Catch: all -> 0x002c
                goto L_0x002f
            L_0x002c:
                r2 = move-exception
                monitor-exit(r3)     // Catch: all -> 0x002c
                throw r2
            L_0x002f:
                return r2
            L_0x0030:
                com.google.android.gms.internal.mlkit_common.zzaa$zzal r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzal.zzl
                return r2
            L_0x0033:
                r2 = 11
                java.lang.Object[] r2 = new java.lang.Object[r2]
                r3 = 0
                java.lang.String r0 = "zzc"
                r2[r3] = r0
                java.lang.String r3 = "zzd"
                r2[r4] = r3
                r3 = 2
                java.lang.String r4 = "zze"
                r2[r3] = r4
                r3 = 3
                java.lang.String r4 = "zzf"
                r2[r3] = r4
                r3 = 4
                com.google.android.gms.internal.mlkit_common.zzfd r4 = com.google.android.gms.internal.mlkit_common.zzaa.zzal.zzc.zzb()
                r2[r3] = r4
                r3 = 5
                java.lang.String r4 = "zzg"
                r2[r3] = r4
                r3 = 6
                java.lang.String r4 = "zzh"
                r2[r3] = r4
                r3 = 7
                java.lang.String r4 = "zzi"
                r2[r3] = r4
                r3 = 8
                com.google.android.gms.internal.mlkit_common.zzfd r4 = com.google.android.gms.internal.mlkit_common.zzaa.zzal.zza.zzb()
                r2[r3] = r4
                r3 = 9
                java.lang.String r4 = "zzj"
                r2[r3] = r4
                r3 = 10
                java.lang.String r4 = "zzk"
                r2[r3] = r4
                java.lang.String r3 = "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဌ\u0002\u0004ဈ\u0003\u0005ဈ\u0004\u0006ဌ\u0005\u0007ဃ\u0006\bဇ\u0007"
                com.google.android.gms.internal.mlkit_common.zzaa$zzal r4 = com.google.android.gms.internal.mlkit_common.zzaa.zzal.zzl
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_common.zzez.zza(r4, r3, r2)
                return r2
            L_0x007d:
                com.google.android.gms.internal.mlkit_common.zzaa$zzal$zzb r2 = new com.google.android.gms.internal.mlkit_common.zzaa$zzal$zzb
                r2.<init>(r3)
                return r2
            L_0x0083:
                com.google.android.gms.internal.mlkit_common.zzaa$zzal r2 = new com.google.android.gms.internal.mlkit_common.zzaa$zzal
                r2.<init>()
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzaa.zzal.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: com.google.mlkit:common@@16.0.0 */
    /* loaded from: classes.dex */
    public static final class zzam extends zzez<zzam, zzb> implements zzgj {
        private static final zzam zzh;
        private static volatile zzgr<zzam> zzi;
        private int zzc;
        private zzal zzd;
        private zza zze;
        private zza zzf;
        private boolean zzg;

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        /* loaded from: classes.dex */
        public static final class zzb extends zzez.zza<zzam, zzb> implements zzgj {
            private zzb() {
                super(zzam.zzh);
            }

            public final zzb zza(zzal.zzb zzbVar) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zzam) this.zza).zza((zzal) ((zzez) zzbVar.zzh()));
                return this;
            }

            /* synthetic */ zzb(zzac zzacVar) {
                this();
            }
        }

        static {
            zzam zzamVar = new zzam();
            zzh = zzamVar;
            zzez.zza(zzam.class, zzamVar);
        }

        private zzam() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(zzal zzalVar) {
            zzalVar.getClass();
            this.zzd = zzalVar;
            this.zzc |= 1;
        }

        public static zzb zza() {
            return zzh.zzh();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzam>, com.google.android.gms.internal.mlkit_common.zzez$zzc] */
        /* JADX WARN: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_common.zzez
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_common.zzac.zza
                r4 = 1
                int r2 = r2 - r4
                r2 = r3[r2]
                r3 = 0
                switch(r2) {
                    case 1: goto L_0x005d;
                    case 2: goto L_0x0057;
                    case 3: goto L_0x0033;
                    case 4: goto L_0x0030;
                    case 5: goto L_0x0016;
                    case 6: goto L_0x0011;
                    case 7: goto L_0x0010;
                    default: goto L_0x000a;
                }
            L_0x000a:
                java.lang.UnsupportedOperationException r2 = new java.lang.UnsupportedOperationException
                r2.<init>()
                throw r2
            L_0x0010:
                return r3
            L_0x0011:
                java.lang.Byte r2 = java.lang.Byte.valueOf(r4)
                return r2
            L_0x0016:
                com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzam> r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzam.zzi
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_common.zzaa$zzam> r3 = com.google.android.gms.internal.mlkit_common.zzaa.zzam.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzam> r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzam.zzi     // Catch: all -> 0x002c
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_common.zzez$zzc r2 = new com.google.android.gms.internal.mlkit_common.zzez$zzc     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_common.zzaa$zzam r4 = com.google.android.gms.internal.mlkit_common.zzaa.zzam.zzh     // Catch: all -> 0x002c
                r2.<init>(r4)     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_common.zzaa.zzam.zzi = r2     // Catch: all -> 0x002c
            L_0x002a:
                monitor-exit(r3)     // Catch: all -> 0x002c
                goto L_0x002f
            L_0x002c:
                r2 = move-exception
                monitor-exit(r3)     // Catch: all -> 0x002c
                throw r2
            L_0x002f:
                return r2
            L_0x0030:
                com.google.android.gms.internal.mlkit_common.zzaa$zzam r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzam.zzh
                return r2
            L_0x0033:
                r2 = 5
                java.lang.Object[] r2 = new java.lang.Object[r2]
                r3 = 0
                java.lang.String r0 = "zzc"
                r2[r3] = r0
                java.lang.String r3 = "zzd"
                r2[r4] = r3
                r3 = 2
                java.lang.String r4 = "zze"
                r2[r3] = r4
                r3 = 3
                java.lang.String r4 = "zzf"
                r2[r3] = r4
                r3 = 4
                java.lang.String r4 = "zzg"
                r2[r3] = r4
                java.lang.String r3 = "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002\u0004ဇ\u0003"
                com.google.android.gms.internal.mlkit_common.zzaa$zzam r4 = com.google.android.gms.internal.mlkit_common.zzaa.zzam.zzh
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_common.zzez.zza(r4, r3, r2)
                return r2
            L_0x0057:
                com.google.android.gms.internal.mlkit_common.zzaa$zzam$zzb r2 = new com.google.android.gms.internal.mlkit_common.zzaa$zzam$zzb
                r2.<init>(r3)
                return r2
            L_0x005d:
                com.google.android.gms.internal.mlkit_common.zzaa$zzam r2 = new com.google.android.gms.internal.mlkit_common.zzaa$zzam
                r2.<init>()
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzaa.zzam.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        /* loaded from: classes.dex */
        public static final class zza extends zzez<zza, C0102zza> implements zzgj {
            private static final zza zzh;
            private static volatile zzgr<zza> zzi;
            private int zzc;
            private boolean zzd;
            private boolean zze;
            private boolean zzf;
            private boolean zzg;

            /* compiled from: com.google.mlkit:common@@16.0.0 */
            /* renamed from: com.google.android.gms.internal.mlkit_common.zzaa$zzam$zza$zza  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            public static final class C0102zza extends zzez.zza<zza, C0102zza> implements zzgj {
                private C0102zza() {
                    super(zza.zzh);
                }

                /* synthetic */ C0102zza(zzac zzacVar) {
                    this();
                }
            }

            static {
                zza zzaVar = new zza();
                zzh = zzaVar;
                zzez.zza(zza.class, zzaVar);
            }

            private zza() {
            }

            /* JADX INFO: Access modifiers changed from: protected */
            /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzam$zza>, com.google.android.gms.internal.mlkit_common.zzez$zzc] */
            /* JADX WARN: Unknown variable types count: 1 */
            @Override // com.google.android.gms.internal.mlkit_common.zzez
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
                /*
                    r1 = this;
                    int[] r3 = com.google.android.gms.internal.mlkit_common.zzac.zza
                    r4 = 1
                    int r2 = r2 - r4
                    r2 = r3[r2]
                    r3 = 0
                    switch(r2) {
                        case 1: goto L_0x005d;
                        case 2: goto L_0x0057;
                        case 3: goto L_0x0033;
                        case 4: goto L_0x0030;
                        case 5: goto L_0x0016;
                        case 6: goto L_0x0011;
                        case 7: goto L_0x0010;
                        default: goto L_0x000a;
                    }
                L_0x000a:
                    java.lang.UnsupportedOperationException r2 = new java.lang.UnsupportedOperationException
                    r2.<init>()
                    throw r2
                L_0x0010:
                    return r3
                L_0x0011:
                    java.lang.Byte r2 = java.lang.Byte.valueOf(r4)
                    return r2
                L_0x0016:
                    com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzam$zza> r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzam.zza.zzi
                    if (r2 != 0) goto L_0x002f
                    java.lang.Class<com.google.android.gms.internal.mlkit_common.zzaa$zzam$zza> r3 = com.google.android.gms.internal.mlkit_common.zzaa.zzam.zza.class
                    monitor-enter(r3)
                    com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzam$zza> r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzam.zza.zzi     // Catch: all -> 0x002c
                    if (r2 != 0) goto L_0x002a
                    com.google.android.gms.internal.mlkit_common.zzez$zzc r2 = new com.google.android.gms.internal.mlkit_common.zzez$zzc     // Catch: all -> 0x002c
                    com.google.android.gms.internal.mlkit_common.zzaa$zzam$zza r4 = com.google.android.gms.internal.mlkit_common.zzaa.zzam.zza.zzh     // Catch: all -> 0x002c
                    r2.<init>(r4)     // Catch: all -> 0x002c
                    com.google.android.gms.internal.mlkit_common.zzaa.zzam.zza.zzi = r2     // Catch: all -> 0x002c
                L_0x002a:
                    monitor-exit(r3)     // Catch: all -> 0x002c
                    goto L_0x002f
                L_0x002c:
                    r2 = move-exception
                    monitor-exit(r3)     // Catch: all -> 0x002c
                    throw r2
                L_0x002f:
                    return r2
                L_0x0030:
                    com.google.android.gms.internal.mlkit_common.zzaa$zzam$zza r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzam.zza.zzh
                    return r2
                L_0x0033:
                    r2 = 5
                    java.lang.Object[] r2 = new java.lang.Object[r2]
                    r3 = 0
                    java.lang.String r0 = "zzc"
                    r2[r3] = r0
                    java.lang.String r3 = "zzd"
                    r2[r4] = r3
                    r3 = 2
                    java.lang.String r4 = "zze"
                    r2[r3] = r4
                    r3 = 3
                    java.lang.String r4 = "zzf"
                    r2[r3] = r4
                    r3 = 4
                    java.lang.String r4 = "zzg"
                    r2[r3] = r4
                    java.lang.String r3 = "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဇ\u0000\u0002ဇ\u0001\u0003ဇ\u0002\u0004ဇ\u0003"
                    com.google.android.gms.internal.mlkit_common.zzaa$zzam$zza r4 = com.google.android.gms.internal.mlkit_common.zzaa.zzam.zza.zzh
                    java.lang.Object r2 = com.google.android.gms.internal.mlkit_common.zzez.zza(r4, r3, r2)
                    return r2
                L_0x0057:
                    com.google.android.gms.internal.mlkit_common.zzaa$zzam$zza$zza r2 = new com.google.android.gms.internal.mlkit_common.zzaa$zzam$zza$zza
                    r2.<init>(r3)
                    return r2
                L_0x005d:
                    com.google.android.gms.internal.mlkit_common.zzaa$zzam$zza r2 = new com.google.android.gms.internal.mlkit_common.zzaa$zzam$zza
                    r2.<init>()
                    return r2
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzaa.zzam.zza.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
            }
        }
    }

    /* compiled from: com.google.mlkit:common@@16.0.0 */
    /* loaded from: classes.dex */
    public static final class zzbg extends zzez<zzbg, zza> implements zzgj {
        private static final zzbg zzo;
        private static volatile zzgr<zzbg> zzp;
        private int zzc;
        private String zzd = "";
        private String zze = "";
        private String zzf = "";
        private String zzg = "";
        private String zzh = "";
        private String zzi = "";
        private String zzj = "";
        private zzfi<String> zzk = zzez.zzl();
        private String zzl = "";
        private boolean zzm;
        private boolean zzn;

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        /* loaded from: classes.dex */
        public static final class zza extends zzez.zza<zzbg, zza> implements zzgj {
            private zza() {
                super(zzbg.zzo);
            }

            public final zza zza(String str) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zzbg) this.zza).zza(str);
                return this;
            }

            public final zza zzb(String str) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zzbg) this.zza).zzb(str);
                return this;
            }

            public final zza zzc(String str) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zzbg) this.zza).zzc(str);
                return this;
            }

            public final zza zzd(String str) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zzbg) this.zza).zzd(str);
                return this;
            }

            public final zza zze(String str) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zzbg) this.zza).zze(str);
                return this;
            }

            /* synthetic */ zza(zzac zzacVar) {
                this();
            }

            public final zza zza(Iterable<String> iterable) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zzbg) this.zza).zza(iterable);
                return this;
            }

            public final zza zzb(boolean z) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zzbg) this.zza).zzb(true);
                return this;
            }

            public final zza zza(boolean z) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zzbg) this.zza).zza(true);
                return this;
            }
        }

        static {
            zzbg zzbgVar = new zzbg();
            zzo = zzbgVar;
            zzez.zza(zzbg.class, zzbgVar);
        }

        private zzbg() {
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

        public static zzbg zzc() {
            return zzo;
        }

        public final String zza() {
            return this.zzh;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(Iterable<String> iterable) {
            zzfi<String> zzfiVar = this.zzk;
            if (!zzfiVar.zza()) {
                int size = zzfiVar.size();
                this.zzk = zzfiVar.zzb(size == 0 ? 10 : size << 1);
            }
            zzdq.zza(iterable, this.zzk);
        }

        public static zza zzb() {
            return zzo.zzh();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(boolean z) {
            this.zzc |= 256;
            this.zzm = z;
        }

        public static zza zza(zzbg zzbgVar) {
            return zzo.zza(zzbgVar);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzbg>, com.google.android.gms.internal.mlkit_common.zzez$zzc] */
        /* JADX WARN: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_common.zzez
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_common.zzac.zza
                r4 = 1
                int r2 = r2 - r4
                r2 = r3[r2]
                r3 = 0
                switch(r2) {
                    case 1: goto L_0x0085;
                    case 2: goto L_0x007f;
                    case 3: goto L_0x0033;
                    case 4: goto L_0x0030;
                    case 5: goto L_0x0016;
                    case 6: goto L_0x0011;
                    case 7: goto L_0x0010;
                    default: goto L_0x000a;
                }
            L_0x000a:
                java.lang.UnsupportedOperationException r2 = new java.lang.UnsupportedOperationException
                r2.<init>()
                throw r2
            L_0x0010:
                return r3
            L_0x0011:
                java.lang.Byte r2 = java.lang.Byte.valueOf(r4)
                return r2
            L_0x0016:
                com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzbg> r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzbg.zzp
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_common.zzaa$zzbg> r3 = com.google.android.gms.internal.mlkit_common.zzaa.zzbg.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzbg> r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzbg.zzp     // Catch: all -> 0x002c
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_common.zzez$zzc r2 = new com.google.android.gms.internal.mlkit_common.zzez$zzc     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_common.zzaa$zzbg r4 = com.google.android.gms.internal.mlkit_common.zzaa.zzbg.zzo     // Catch: all -> 0x002c
                r2.<init>(r4)     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_common.zzaa.zzbg.zzp = r2     // Catch: all -> 0x002c
            L_0x002a:
                monitor-exit(r3)     // Catch: all -> 0x002c
                goto L_0x002f
            L_0x002c:
                r2 = move-exception
                monitor-exit(r3)     // Catch: all -> 0x002c
                throw r2
            L_0x002f:
                return r2
            L_0x0030:
                com.google.android.gms.internal.mlkit_common.zzaa$zzbg r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzbg.zzo
                return r2
            L_0x0033:
                r2 = 12
                java.lang.Object[] r2 = new java.lang.Object[r2]
                r3 = 0
                java.lang.String r0 = "zzc"
                r2[r3] = r0
                java.lang.String r3 = "zzd"
                r2[r4] = r3
                r3 = 2
                java.lang.String r4 = "zze"
                r2[r3] = r4
                r3 = 3
                java.lang.String r4 = "zzf"
                r2[r3] = r4
                r3 = 4
                java.lang.String r4 = "zzg"
                r2[r3] = r4
                r3 = 5
                java.lang.String r4 = "zzh"
                r2[r3] = r4
                r3 = 6
                java.lang.String r4 = "zzi"
                r2[r3] = r4
                r3 = 7
                java.lang.String r4 = "zzj"
                r2[r3] = r4
                r3 = 8
                java.lang.String r4 = "zzk"
                r2[r3] = r4
                r3 = 9
                java.lang.String r4 = "zzl"
                r2[r3] = r4
                r3 = 10
                java.lang.String r4 = "zzm"
                r2[r3] = r4
                r3 = 11
                java.lang.String r4 = "zzn"
                r2[r3] = r4
                java.lang.String r3 = "\u0001\u000b\u0000\u0001\u0001\u000b\u000b\u0000\u0001\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004ဈ\u0003\u0005ဈ\u0004\u0006ဈ\u0005\u0007ဈ\u0006\b\u001a\tဈ\u0007\nဇ\b\u000bဇ\t"
                com.google.android.gms.internal.mlkit_common.zzaa$zzbg r4 = com.google.android.gms.internal.mlkit_common.zzaa.zzbg.zzo
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_common.zzez.zza(r4, r3, r2)
                return r2
            L_0x007f:
                com.google.android.gms.internal.mlkit_common.zzaa$zzbg$zza r2 = new com.google.android.gms.internal.mlkit_common.zzaa$zzbg$zza
                r2.<init>(r3)
                return r2
            L_0x0085:
                com.google.android.gms.internal.mlkit_common.zzaa$zzbg r2 = new com.google.android.gms.internal.mlkit_common.zzaa$zzbg
                r2.<init>()
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzaa.zzbg.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: com.google.mlkit:common@@16.0.0 */
    /* loaded from: classes.dex */
    public static final class zzau extends zzez<zzau, zzb> implements zzgj {
        private static final zzau zzh;
        private static volatile zzgr<zzau> zzi;
        private int zzc;
        private zzaf zzd;
        private zzai zze;
        private zzc zzf;
        private zzd zzg;

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        /* loaded from: classes.dex */
        public static final class zzb extends zzez.zza<zzau, zzb> implements zzgj {
            private zzb() {
                super(zzau.zzh);
            }

            /* synthetic */ zzb(zzac zzacVar) {
                this();
            }
        }

        static {
            zzau zzauVar = new zzau();
            zzh = zzauVar;
            zzez.zza(zzau.class, zzauVar);
        }

        private zzau() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_common.zzez$zzc, com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzau>] */
        /* JADX WARN: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_common.zzez
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_common.zzac.zza
                r4 = 1
                int r2 = r2 - r4
                r2 = r3[r2]
                r3 = 0
                switch(r2) {
                    case 1: goto L_0x005d;
                    case 2: goto L_0x0057;
                    case 3: goto L_0x0033;
                    case 4: goto L_0x0030;
                    case 5: goto L_0x0016;
                    case 6: goto L_0x0011;
                    case 7: goto L_0x0010;
                    default: goto L_0x000a;
                }
            L_0x000a:
                java.lang.UnsupportedOperationException r2 = new java.lang.UnsupportedOperationException
                r2.<init>()
                throw r2
            L_0x0010:
                return r3
            L_0x0011:
                java.lang.Byte r2 = java.lang.Byte.valueOf(r4)
                return r2
            L_0x0016:
                com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzau> r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzau.zzi
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_common.zzaa$zzau> r3 = com.google.android.gms.internal.mlkit_common.zzaa.zzau.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzau> r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzau.zzi     // Catch: all -> 0x002c
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_common.zzez$zzc r2 = new com.google.android.gms.internal.mlkit_common.zzez$zzc     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_common.zzaa$zzau r4 = com.google.android.gms.internal.mlkit_common.zzaa.zzau.zzh     // Catch: all -> 0x002c
                r2.<init>(r4)     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_common.zzaa.zzau.zzi = r2     // Catch: all -> 0x002c
            L_0x002a:
                monitor-exit(r3)     // Catch: all -> 0x002c
                goto L_0x002f
            L_0x002c:
                r2 = move-exception
                monitor-exit(r3)     // Catch: all -> 0x002c
                throw r2
            L_0x002f:
                return r2
            L_0x0030:
                com.google.android.gms.internal.mlkit_common.zzaa$zzau r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzau.zzh
                return r2
            L_0x0033:
                r2 = 5
                java.lang.Object[] r2 = new java.lang.Object[r2]
                r3 = 0
                java.lang.String r0 = "zzc"
                r2[r3] = r0
                java.lang.String r3 = "zzd"
                r2[r4] = r3
                r3 = 2
                java.lang.String r4 = "zze"
                r2[r3] = r4
                r3 = 3
                java.lang.String r4 = "zzf"
                r2[r3] = r4
                r3 = 4
                java.lang.String r4 = "zzg"
                r2[r3] = r4
                java.lang.String r3 = "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002\u0004ဉ\u0003"
                com.google.android.gms.internal.mlkit_common.zzaa$zzau r4 = com.google.android.gms.internal.mlkit_common.zzaa.zzau.zzh
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_common.zzez.zza(r4, r3, r2)
                return r2
            L_0x0057:
                com.google.android.gms.internal.mlkit_common.zzaa$zzau$zzb r2 = new com.google.android.gms.internal.mlkit_common.zzaa$zzau$zzb
                r2.<init>(r3)
                return r2
            L_0x005d:
                com.google.android.gms.internal.mlkit_common.zzaa$zzau r2 = new com.google.android.gms.internal.mlkit_common.zzaa$zzau
                r2.<init>()
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzaa.zzau.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        /* loaded from: classes.dex */
        public static final class zza extends zzez<zza, C0103zza> implements zzgj {
            private static final zza zzf;
            private static volatile zzgr<zza> zzg;
            private int zzc;
            private float zzd;
            private String zze = "";

            /* compiled from: com.google.mlkit:common@@16.0.0 */
            /* renamed from: com.google.android.gms.internal.mlkit_common.zzaa$zzau$zza$zza  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            public static final class C0103zza extends zzez.zza<zza, C0103zza> implements zzgj {
                private C0103zza() {
                    super(zza.zzf);
                }

                /* synthetic */ C0103zza(zzac zzacVar) {
                    this();
                }
            }

            static {
                zza zzaVar = new zza();
                zzf = zzaVar;
                zzez.zza(zza.class, zzaVar);
            }

            private zza() {
            }

            /* JADX INFO: Access modifiers changed from: protected */
            /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzau$zza>, com.google.android.gms.internal.mlkit_common.zzez$zzc] */
            /* JADX WARN: Unknown variable types count: 1 */
            @Override // com.google.android.gms.internal.mlkit_common.zzez
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
                /*
                    r1 = this;
                    int[] r3 = com.google.android.gms.internal.mlkit_common.zzac.zza
                    r4 = 1
                    int r2 = r2 - r4
                    r2 = r3[r2]
                    r3 = 0
                    switch(r2) {
                        case 1: goto L_0x0053;
                        case 2: goto L_0x004d;
                        case 3: goto L_0x0033;
                        case 4: goto L_0x0030;
                        case 5: goto L_0x0016;
                        case 6: goto L_0x0011;
                        case 7: goto L_0x0010;
                        default: goto L_0x000a;
                    }
                L_0x000a:
                    java.lang.UnsupportedOperationException r2 = new java.lang.UnsupportedOperationException
                    r2.<init>()
                    throw r2
                L_0x0010:
                    return r3
                L_0x0011:
                    java.lang.Byte r2 = java.lang.Byte.valueOf(r4)
                    return r2
                L_0x0016:
                    com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzau$zza> r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzau.zza.zzg
                    if (r2 != 0) goto L_0x002f
                    java.lang.Class<com.google.android.gms.internal.mlkit_common.zzaa$zzau$zza> r3 = com.google.android.gms.internal.mlkit_common.zzaa.zzau.zza.class
                    monitor-enter(r3)
                    com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzau$zza> r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzau.zza.zzg     // Catch: all -> 0x002c
                    if (r2 != 0) goto L_0x002a
                    com.google.android.gms.internal.mlkit_common.zzez$zzc r2 = new com.google.android.gms.internal.mlkit_common.zzez$zzc     // Catch: all -> 0x002c
                    com.google.android.gms.internal.mlkit_common.zzaa$zzau$zza r4 = com.google.android.gms.internal.mlkit_common.zzaa.zzau.zza.zzf     // Catch: all -> 0x002c
                    r2.<init>(r4)     // Catch: all -> 0x002c
                    com.google.android.gms.internal.mlkit_common.zzaa.zzau.zza.zzg = r2     // Catch: all -> 0x002c
                L_0x002a:
                    monitor-exit(r3)     // Catch: all -> 0x002c
                    goto L_0x002f
                L_0x002c:
                    r2 = move-exception
                    monitor-exit(r3)     // Catch: all -> 0x002c
                    throw r2
                L_0x002f:
                    return r2
                L_0x0030:
                    com.google.android.gms.internal.mlkit_common.zzaa$zzau$zza r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzau.zza.zzf
                    return r2
                L_0x0033:
                    r2 = 3
                    java.lang.Object[] r2 = new java.lang.Object[r2]
                    r3 = 0
                    java.lang.String r0 = "zzc"
                    r2[r3] = r0
                    java.lang.String r3 = "zzd"
                    r2[r4] = r3
                    r3 = 2
                    java.lang.String r4 = "zze"
                    r2[r3] = r4
                    java.lang.String r3 = "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ခ\u0000\u0002ဈ\u0001"
                    com.google.android.gms.internal.mlkit_common.zzaa$zzau$zza r4 = com.google.android.gms.internal.mlkit_common.zzaa.zzau.zza.zzf
                    java.lang.Object r2 = com.google.android.gms.internal.mlkit_common.zzez.zza(r4, r3, r2)
                    return r2
                L_0x004d:
                    com.google.android.gms.internal.mlkit_common.zzaa$zzau$zza$zza r2 = new com.google.android.gms.internal.mlkit_common.zzaa$zzau$zza$zza
                    r2.<init>(r3)
                    return r2
                L_0x0053:
                    com.google.android.gms.internal.mlkit_common.zzaa$zzau$zza r2 = new com.google.android.gms.internal.mlkit_common.zzaa$zzau$zza
                    r2.<init>()
                    return r2
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzaa.zzau.zza.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
            }
        }

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        /* loaded from: classes.dex */
        public static final class zzc extends zzez<zzc, zza> implements zzgj {
            private static final zzc zze;
            private static volatile zzgr<zzc> zzf;
            private int zzc;
            private zza zzd;

            /* compiled from: com.google.mlkit:common@@16.0.0 */
            /* loaded from: classes.dex */
            public static final class zza extends zzez.zza<zzc, zza> implements zzgj {
                private zza() {
                    super(zzc.zze);
                }

                /* synthetic */ zza(zzac zzacVar) {
                    this();
                }
            }

            static {
                zzc zzcVar = new zzc();
                zze = zzcVar;
                zzez.zza(zzc.class, zzcVar);
            }

            private zzc() {
            }

            /* JADX INFO: Access modifiers changed from: protected */
            /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzau$zzc>, com.google.android.gms.internal.mlkit_common.zzez$zzc] */
            /* JADX WARN: Unknown variable types count: 1 */
            @Override // com.google.android.gms.internal.mlkit_common.zzez
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
                /*
                    r1 = this;
                    int[] r3 = com.google.android.gms.internal.mlkit_common.zzac.zza
                    r4 = 1
                    int r2 = r2 - r4
                    r2 = r3[r2]
                    r3 = 0
                    switch(r2) {
                        case 1: goto L_0x004e;
                        case 2: goto L_0x0048;
                        case 3: goto L_0x0033;
                        case 4: goto L_0x0030;
                        case 5: goto L_0x0016;
                        case 6: goto L_0x0011;
                        case 7: goto L_0x0010;
                        default: goto L_0x000a;
                    }
                L_0x000a:
                    java.lang.UnsupportedOperationException r2 = new java.lang.UnsupportedOperationException
                    r2.<init>()
                    throw r2
                L_0x0010:
                    return r3
                L_0x0011:
                    java.lang.Byte r2 = java.lang.Byte.valueOf(r4)
                    return r2
                L_0x0016:
                    com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzau$zzc> r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzau.zzc.zzf
                    if (r2 != 0) goto L_0x002f
                    java.lang.Class<com.google.android.gms.internal.mlkit_common.zzaa$zzau$zzc> r3 = com.google.android.gms.internal.mlkit_common.zzaa.zzau.zzc.class
                    monitor-enter(r3)
                    com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzau$zzc> r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzau.zzc.zzf     // Catch: all -> 0x002c
                    if (r2 != 0) goto L_0x002a
                    com.google.android.gms.internal.mlkit_common.zzez$zzc r2 = new com.google.android.gms.internal.mlkit_common.zzez$zzc     // Catch: all -> 0x002c
                    com.google.android.gms.internal.mlkit_common.zzaa$zzau$zzc r4 = com.google.android.gms.internal.mlkit_common.zzaa.zzau.zzc.zze     // Catch: all -> 0x002c
                    r2.<init>(r4)     // Catch: all -> 0x002c
                    com.google.android.gms.internal.mlkit_common.zzaa.zzau.zzc.zzf = r2     // Catch: all -> 0x002c
                L_0x002a:
                    monitor-exit(r3)     // Catch: all -> 0x002c
                    goto L_0x002f
                L_0x002c:
                    r2 = move-exception
                    monitor-exit(r3)     // Catch: all -> 0x002c
                    throw r2
                L_0x002f:
                    return r2
                L_0x0030:
                    com.google.android.gms.internal.mlkit_common.zzaa$zzau$zzc r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzau.zzc.zze
                    return r2
                L_0x0033:
                    r2 = 2
                    java.lang.Object[] r2 = new java.lang.Object[r2]
                    r3 = 0
                    java.lang.String r0 = "zzc"
                    r2[r3] = r0
                    java.lang.String r3 = "zzd"
                    r2[r4] = r3
                    java.lang.String r3 = "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000"
                    com.google.android.gms.internal.mlkit_common.zzaa$zzau$zzc r4 = com.google.android.gms.internal.mlkit_common.zzaa.zzau.zzc.zze
                    java.lang.Object r2 = com.google.android.gms.internal.mlkit_common.zzez.zza(r4, r3, r2)
                    return r2
                L_0x0048:
                    com.google.android.gms.internal.mlkit_common.zzaa$zzau$zzc$zza r2 = new com.google.android.gms.internal.mlkit_common.zzaa$zzau$zzc$zza
                    r2.<init>(r3)
                    return r2
                L_0x004e:
                    com.google.android.gms.internal.mlkit_common.zzaa$zzau$zzc r2 = new com.google.android.gms.internal.mlkit_common.zzaa$zzau$zzc
                    r2.<init>()
                    return r2
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzaa.zzau.zzc.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
            }
        }

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        /* loaded from: classes.dex */
        public static final class zzd extends zzez<zzd, zza> implements zzgj {
            private static final zzd zzd;
            private static volatile zzgr<zzd> zze;
            private zzfi<zza> zzc = zzez.zzl();

            /* compiled from: com.google.mlkit:common@@16.0.0 */
            /* loaded from: classes.dex */
            public static final class zza extends zzez.zza<zzd, zza> implements zzgj {
                private zza() {
                    super(zzd.zzd);
                }

                /* synthetic */ zza(zzac zzacVar) {
                    this();
                }
            }

            static {
                zzd zzdVar = new zzd();
                zzd = zzdVar;
                zzez.zza(zzd.class, zzdVar);
            }

            private zzd() {
            }

            /* JADX INFO: Access modifiers changed from: protected */
            /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzau$zzd>, com.google.android.gms.internal.mlkit_common.zzez$zzc] */
            /* JADX WARN: Unknown variable types count: 1 */
            @Override // com.google.android.gms.internal.mlkit_common.zzez
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
                /*
                    r1 = this;
                    int[] r3 = com.google.android.gms.internal.mlkit_common.zzac.zza
                    r4 = 1
                    int r2 = r2 - r4
                    r2 = r3[r2]
                    r3 = 0
                    switch(r2) {
                        case 1: goto L_0x004e;
                        case 2: goto L_0x0048;
                        case 3: goto L_0x0033;
                        case 4: goto L_0x0030;
                        case 5: goto L_0x0016;
                        case 6: goto L_0x0011;
                        case 7: goto L_0x0010;
                        default: goto L_0x000a;
                    }
                L_0x000a:
                    java.lang.UnsupportedOperationException r2 = new java.lang.UnsupportedOperationException
                    r2.<init>()
                    throw r2
                L_0x0010:
                    return r3
                L_0x0011:
                    java.lang.Byte r2 = java.lang.Byte.valueOf(r4)
                    return r2
                L_0x0016:
                    com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzau$zzd> r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzau.zzd.zze
                    if (r2 != 0) goto L_0x002f
                    java.lang.Class<com.google.android.gms.internal.mlkit_common.zzaa$zzau$zzd> r3 = com.google.android.gms.internal.mlkit_common.zzaa.zzau.zzd.class
                    monitor-enter(r3)
                    com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzau$zzd> r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzau.zzd.zze     // Catch: all -> 0x002c
                    if (r2 != 0) goto L_0x002a
                    com.google.android.gms.internal.mlkit_common.zzez$zzc r2 = new com.google.android.gms.internal.mlkit_common.zzez$zzc     // Catch: all -> 0x002c
                    com.google.android.gms.internal.mlkit_common.zzaa$zzau$zzd r4 = com.google.android.gms.internal.mlkit_common.zzaa.zzau.zzd.zzd     // Catch: all -> 0x002c
                    r2.<init>(r4)     // Catch: all -> 0x002c
                    com.google.android.gms.internal.mlkit_common.zzaa.zzau.zzd.zze = r2     // Catch: all -> 0x002c
                L_0x002a:
                    monitor-exit(r3)     // Catch: all -> 0x002c
                    goto L_0x002f
                L_0x002c:
                    r2 = move-exception
                    monitor-exit(r3)     // Catch: all -> 0x002c
                    throw r2
                L_0x002f:
                    return r2
                L_0x0030:
                    com.google.android.gms.internal.mlkit_common.zzaa$zzau$zzd r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzau.zzd.zzd
                    return r2
                L_0x0033:
                    r2 = 2
                    java.lang.Object[] r2 = new java.lang.Object[r2]
                    r3 = 0
                    java.lang.String r0 = "zzc"
                    r2[r3] = r0
                    java.lang.Class<com.google.android.gms.internal.mlkit_common.zzaa$zzau$zza> r3 = com.google.android.gms.internal.mlkit_common.zzaa.zzau.zza.class
                    r2[r4] = r3
                    java.lang.String r3 = "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b"
                    com.google.android.gms.internal.mlkit_common.zzaa$zzau$zzd r4 = com.google.android.gms.internal.mlkit_common.zzaa.zzau.zzd.zzd
                    java.lang.Object r2 = com.google.android.gms.internal.mlkit_common.zzez.zza(r4, r3, r2)
                    return r2
                L_0x0048:
                    com.google.android.gms.internal.mlkit_common.zzaa$zzau$zzd$zza r2 = new com.google.android.gms.internal.mlkit_common.zzaa$zzau$zzd$zza
                    r2.<init>(r3)
                    return r2
                L_0x004e:
                    com.google.android.gms.internal.mlkit_common.zzaa$zzau$zzd r2 = new com.google.android.gms.internal.mlkit_common.zzaa$zzau$zzd
                    r2.<init>()
                    return r2
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzaa.zzau.zzd.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
            }
        }
    }

    /* compiled from: com.google.mlkit:common@@16.0.0 */
    /* loaded from: classes.dex */
    public static final class zzbc extends zzez<zzbc, zza> implements zzgj {
        private static final zzbc zzi;
        private static volatile zzgr<zzbc> zzj;
        private int zzc;
        private zzaf zzd;
        private zzfi<zzc> zze = zzez.zzl();
        private int zzf;
        private int zzg;
        private int zzh;

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        /* loaded from: classes.dex */
        public static final class zza extends zzez.zza<zzbc, zza> implements zzgj {
            private zza() {
                super(zzbc.zzi);
            }

            /* synthetic */ zza(zzac zzacVar) {
                this();
            }
        }

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        /* loaded from: classes.dex */
        public enum zzb implements zzfb {
            NO_ERROR(0),
            STATUS_SENSITIVE_TOPIC(1),
            STATUS_QUALITY_THRESHOLDED(2),
            STATUS_INTERNAL_ERROR(3),
            STATUS_NOT_SUPPORTED_LANGUAGE(101),
            STATUS_32_BIT_CPU(1001),
            STATUS_32_BIT_APP(1002);
            
            private static final zzfe<zzb> zzh = new zzca();
            private final int zzi;

            zzb(int i) {
                this.zzi = i;
            }

            public static zzfd zzb() {
                return zzcb.zza;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "<" + zzb.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzi + " name=" + name() + '>';
            }

            @Override // com.google.android.gms.internal.mlkit_common.zzfb
            public final int zza() {
                return this.zzi;
            }
        }

        static {
            zzbc zzbcVar = new zzbc();
            zzi = zzbcVar;
            zzez.zza(zzbc.class, zzbcVar);
        }

        private zzbc() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_common.zzez$zzc, com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzbc>] */
        /* JADX WARN: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_common.zzez
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_common.zzac.zza
                r4 = 1
                int r2 = r2 - r4
                r2 = r3[r2]
                r3 = 0
                switch(r2) {
                    case 1: goto L_0x006f;
                    case 2: goto L_0x0069;
                    case 3: goto L_0x0033;
                    case 4: goto L_0x0030;
                    case 5: goto L_0x0016;
                    case 6: goto L_0x0011;
                    case 7: goto L_0x0010;
                    default: goto L_0x000a;
                }
            L_0x000a:
                java.lang.UnsupportedOperationException r2 = new java.lang.UnsupportedOperationException
                r2.<init>()
                throw r2
            L_0x0010:
                return r3
            L_0x0011:
                java.lang.Byte r2 = java.lang.Byte.valueOf(r4)
                return r2
            L_0x0016:
                com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzbc> r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzbc.zzj
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_common.zzaa$zzbc> r3 = com.google.android.gms.internal.mlkit_common.zzaa.zzbc.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzbc> r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzbc.zzj     // Catch: all -> 0x002c
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_common.zzez$zzc r2 = new com.google.android.gms.internal.mlkit_common.zzez$zzc     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_common.zzaa$zzbc r4 = com.google.android.gms.internal.mlkit_common.zzaa.zzbc.zzi     // Catch: all -> 0x002c
                r2.<init>(r4)     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_common.zzaa.zzbc.zzj = r2     // Catch: all -> 0x002c
            L_0x002a:
                monitor-exit(r3)     // Catch: all -> 0x002c
                goto L_0x002f
            L_0x002c:
                r2 = move-exception
                monitor-exit(r3)     // Catch: all -> 0x002c
                throw r2
            L_0x002f:
                return r2
            L_0x0030:
                com.google.android.gms.internal.mlkit_common.zzaa$zzbc r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzbc.zzi
                return r2
            L_0x0033:
                r2 = 8
                java.lang.Object[] r2 = new java.lang.Object[r2]
                r3 = 0
                java.lang.String r0 = "zzc"
                r2[r3] = r0
                java.lang.String r3 = "zzd"
                r2[r4] = r3
                r3 = 2
                java.lang.String r4 = "zze"
                r2[r3] = r4
                r3 = 3
                java.lang.Class<com.google.android.gms.internal.mlkit_common.zzaa$zzbc$zzc> r4 = com.google.android.gms.internal.mlkit_common.zzaa.zzbc.zzc.class
                r2[r3] = r4
                r3 = 4
                java.lang.String r4 = "zzf"
                r2[r3] = r4
                r3 = 5
                com.google.android.gms.internal.mlkit_common.zzfd r4 = com.google.android.gms.internal.mlkit_common.zzaa.zzbc.zzb.zzb()
                r2[r3] = r4
                r3 = 6
                java.lang.String r4 = "zzg"
                r2[r3] = r4
                r3 = 7
                java.lang.String r4 = "zzh"
                r2[r3] = r4
                java.lang.String r3 = "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0000\u0001ဉ\u0000\u0002\u001b\u0003ဌ\u0001\u0004င\u0002\u0005င\u0003"
                com.google.android.gms.internal.mlkit_common.zzaa$zzbc r4 = com.google.android.gms.internal.mlkit_common.zzaa.zzbc.zzi
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_common.zzez.zza(r4, r3, r2)
                return r2
            L_0x0069:
                com.google.android.gms.internal.mlkit_common.zzaa$zzbc$zza r2 = new com.google.android.gms.internal.mlkit_common.zzaa$zzbc$zza
                r2.<init>(r3)
                return r2
            L_0x006f:
                com.google.android.gms.internal.mlkit_common.zzaa$zzbc r2 = new com.google.android.gms.internal.mlkit_common.zzaa$zzbc
                r2.<init>()
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzaa.zzbc.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        /* loaded from: classes.dex */
        public static final class zzc extends zzez<zzc, zza> implements zzgj {
            private static final zzc zze;
            private static volatile zzgr<zzc> zzf;
            private int zzc;
            private float zzd;

            /* compiled from: com.google.mlkit:common@@16.0.0 */
            /* loaded from: classes.dex */
            public static final class zza extends zzez.zza<zzc, zza> implements zzgj {
                private zza() {
                    super(zzc.zze);
                }

                /* synthetic */ zza(zzac zzacVar) {
                    this();
                }
            }

            static {
                zzc zzcVar = new zzc();
                zze = zzcVar;
                zzez.zza(zzc.class, zzcVar);
            }

            private zzc() {
            }

            /* JADX INFO: Access modifiers changed from: protected */
            /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzbc$zzc>, com.google.android.gms.internal.mlkit_common.zzez$zzc] */
            /* JADX WARN: Unknown variable types count: 1 */
            @Override // com.google.android.gms.internal.mlkit_common.zzez
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
                /*
                    r1 = this;
                    int[] r3 = com.google.android.gms.internal.mlkit_common.zzac.zza
                    r4 = 1
                    int r2 = r2 - r4
                    r2 = r3[r2]
                    r3 = 0
                    switch(r2) {
                        case 1: goto L_0x004e;
                        case 2: goto L_0x0048;
                        case 3: goto L_0x0033;
                        case 4: goto L_0x0030;
                        case 5: goto L_0x0016;
                        case 6: goto L_0x0011;
                        case 7: goto L_0x0010;
                        default: goto L_0x000a;
                    }
                L_0x000a:
                    java.lang.UnsupportedOperationException r2 = new java.lang.UnsupportedOperationException
                    r2.<init>()
                    throw r2
                L_0x0010:
                    return r3
                L_0x0011:
                    java.lang.Byte r2 = java.lang.Byte.valueOf(r4)
                    return r2
                L_0x0016:
                    com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzbc$zzc> r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzbc.zzc.zzf
                    if (r2 != 0) goto L_0x002f
                    java.lang.Class<com.google.android.gms.internal.mlkit_common.zzaa$zzbc$zzc> r3 = com.google.android.gms.internal.mlkit_common.zzaa.zzbc.zzc.class
                    monitor-enter(r3)
                    com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzbc$zzc> r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzbc.zzc.zzf     // Catch: all -> 0x002c
                    if (r2 != 0) goto L_0x002a
                    com.google.android.gms.internal.mlkit_common.zzez$zzc r2 = new com.google.android.gms.internal.mlkit_common.zzez$zzc     // Catch: all -> 0x002c
                    com.google.android.gms.internal.mlkit_common.zzaa$zzbc$zzc r4 = com.google.android.gms.internal.mlkit_common.zzaa.zzbc.zzc.zze     // Catch: all -> 0x002c
                    r2.<init>(r4)     // Catch: all -> 0x002c
                    com.google.android.gms.internal.mlkit_common.zzaa.zzbc.zzc.zzf = r2     // Catch: all -> 0x002c
                L_0x002a:
                    monitor-exit(r3)     // Catch: all -> 0x002c
                    goto L_0x002f
                L_0x002c:
                    r2 = move-exception
                    monitor-exit(r3)     // Catch: all -> 0x002c
                    throw r2
                L_0x002f:
                    return r2
                L_0x0030:
                    com.google.android.gms.internal.mlkit_common.zzaa$zzbc$zzc r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzbc.zzc.zze
                    return r2
                L_0x0033:
                    r2 = 2
                    java.lang.Object[] r2 = new java.lang.Object[r2]
                    r3 = 0
                    java.lang.String r0 = "zzc"
                    r2[r3] = r0
                    java.lang.String r3 = "zzd"
                    r2[r4] = r3
                    java.lang.String r3 = "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ခ\u0000"
                    com.google.android.gms.internal.mlkit_common.zzaa$zzbc$zzc r4 = com.google.android.gms.internal.mlkit_common.zzaa.zzbc.zzc.zze
                    java.lang.Object r2 = com.google.android.gms.internal.mlkit_common.zzez.zza(r4, r3, r2)
                    return r2
                L_0x0048:
                    com.google.android.gms.internal.mlkit_common.zzaa$zzbc$zzc$zza r2 = new com.google.android.gms.internal.mlkit_common.zzaa$zzbc$zzc$zza
                    r2.<init>(r3)
                    return r2
                L_0x004e:
                    com.google.android.gms.internal.mlkit_common.zzaa$zzbc$zzc r2 = new com.google.android.gms.internal.mlkit_common.zzaa$zzbc$zzc
                    r2.<init>()
                    return r2
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzaa.zzbc.zzc.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
            }
        }
    }

    /* compiled from: com.google.mlkit:common@@16.0.0 */
    /* loaded from: classes.dex */
    public static final class zza extends zzez<zza, zzb> implements zzgj {
        private static final zza zzg;
        private static volatile zzgr<zza> zzh;
        private int zzc;
        private C0099zza zzd;
        private int zze;
        private zzab zzf;

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        /* loaded from: classes.dex */
        public static final class zzb extends zzez.zza<zza, zzb> implements zzgj {
            private zzb() {
                super(zza.zzg);
            }

            /* synthetic */ zzb(zzac zzacVar) {
                this();
            }
        }

        static {
            zza zzaVar = new zza();
            zzg = zzaVar;
            zzez.zza(zza.class, zzaVar);
        }

        private zza() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_common.zzez$zzc, com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zza>] */
        /* JADX WARN: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_common.zzez
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_common.zzac.zza
                r4 = 1
                int r2 = r2 - r4
                r2 = r3[r2]
                r3 = 0
                switch(r2) {
                    case 1: goto L_0x0058;
                    case 2: goto L_0x0052;
                    case 3: goto L_0x0033;
                    case 4: goto L_0x0030;
                    case 5: goto L_0x0016;
                    case 6: goto L_0x0011;
                    case 7: goto L_0x0010;
                    default: goto L_0x000a;
                }
            L_0x000a:
                java.lang.UnsupportedOperationException r2 = new java.lang.UnsupportedOperationException
                r2.<init>()
                throw r2
            L_0x0010:
                return r3
            L_0x0011:
                java.lang.Byte r2 = java.lang.Byte.valueOf(r4)
                return r2
            L_0x0016:
                com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zza> r2 = com.google.android.gms.internal.mlkit_common.zzaa.zza.zzh
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_common.zzaa$zza> r3 = com.google.android.gms.internal.mlkit_common.zzaa.zza.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zza> r2 = com.google.android.gms.internal.mlkit_common.zzaa.zza.zzh     // Catch: all -> 0x002c
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_common.zzez$zzc r2 = new com.google.android.gms.internal.mlkit_common.zzez$zzc     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_common.zzaa$zza r4 = com.google.android.gms.internal.mlkit_common.zzaa.zza.zzg     // Catch: all -> 0x002c
                r2.<init>(r4)     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_common.zzaa.zza.zzh = r2     // Catch: all -> 0x002c
            L_0x002a:
                monitor-exit(r3)     // Catch: all -> 0x002c
                goto L_0x002f
            L_0x002c:
                r2 = move-exception
                monitor-exit(r3)     // Catch: all -> 0x002c
                throw r2
            L_0x002f:
                return r2
            L_0x0030:
                com.google.android.gms.internal.mlkit_common.zzaa$zza r2 = com.google.android.gms.internal.mlkit_common.zzaa.zza.zzg
                return r2
            L_0x0033:
                r2 = 4
                java.lang.Object[] r2 = new java.lang.Object[r2]
                r3 = 0
                java.lang.String r0 = "zzc"
                r2[r3] = r0
                java.lang.String r3 = "zzd"
                r2[r4] = r3
                r3 = 2
                java.lang.String r4 = "zze"
                r2[r3] = r4
                r3 = 3
                java.lang.String r4 = "zzf"
                r2[r3] = r4
                java.lang.String r3 = "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဋ\u0001\u0003ဉ\u0002"
                com.google.android.gms.internal.mlkit_common.zzaa$zza r4 = com.google.android.gms.internal.mlkit_common.zzaa.zza.zzg
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_common.zzez.zza(r4, r3, r2)
                return r2
            L_0x0052:
                com.google.android.gms.internal.mlkit_common.zzaa$zza$zzb r2 = new com.google.android.gms.internal.mlkit_common.zzaa$zza$zzb
                r2.<init>(r3)
                return r2
            L_0x0058:
                com.google.android.gms.internal.mlkit_common.zzaa$zza r2 = new com.google.android.gms.internal.mlkit_common.zzaa$zza
                r2.<init>()
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzaa.zza.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        /* renamed from: com.google.android.gms.internal.mlkit_common.zzaa$zza$zza  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0099zza extends zzez<C0099zza, C0100zza> implements zzgj {
            private static final C0099zza zzh;
            private static volatile zzgr<C0099zza> zzi;
            private int zzc;
            private int zzd;
            private boolean zze;
            private zzae zzf;
            private zzam zzg;

            /* compiled from: com.google.mlkit:common@@16.0.0 */
            /* renamed from: com.google.android.gms.internal.mlkit_common.zzaa$zza$zza$zza  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            public static final class C0100zza extends zzez.zza<C0099zza, C0100zza> implements zzgj {
                private C0100zza() {
                    super(C0099zza.zzh);
                }

                /* synthetic */ C0100zza(zzac zzacVar) {
                    this();
                }
            }

            static {
                C0099zza zzaVar = new C0099zza();
                zzh = zzaVar;
                zzez.zza(C0099zza.class, zzaVar);
            }

            private C0099zza() {
            }

            /* JADX INFO: Access modifiers changed from: protected */
            /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zza$zza>, com.google.android.gms.internal.mlkit_common.zzez$zzc] */
            /* JADX WARN: Unknown variable types count: 1 */
            @Override // com.google.android.gms.internal.mlkit_common.zzez
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
                /*
                    r1 = this;
                    int[] r3 = com.google.android.gms.internal.mlkit_common.zzac.zza
                    r4 = 1
                    int r2 = r2 - r4
                    r2 = r3[r2]
                    r3 = 0
                    switch(r2) {
                        case 1: goto L_0x0064;
                        case 2: goto L_0x005e;
                        case 3: goto L_0x0033;
                        case 4: goto L_0x0030;
                        case 5: goto L_0x0016;
                        case 6: goto L_0x0011;
                        case 7: goto L_0x0010;
                        default: goto L_0x000a;
                    }
                L_0x000a:
                    java.lang.UnsupportedOperationException r2 = new java.lang.UnsupportedOperationException
                    r2.<init>()
                    throw r2
                L_0x0010:
                    return r3
                L_0x0011:
                    java.lang.Byte r2 = java.lang.Byte.valueOf(r4)
                    return r2
                L_0x0016:
                    com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zza$zza> r2 = com.google.android.gms.internal.mlkit_common.zzaa.zza.C0099zza.zzi
                    if (r2 != 0) goto L_0x002f
                    java.lang.Class<com.google.android.gms.internal.mlkit_common.zzaa$zza$zza> r3 = com.google.android.gms.internal.mlkit_common.zzaa.zza.C0099zza.class
                    monitor-enter(r3)
                    com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zza$zza> r2 = com.google.android.gms.internal.mlkit_common.zzaa.zza.C0099zza.zzi     // Catch: all -> 0x002c
                    if (r2 != 0) goto L_0x002a
                    com.google.android.gms.internal.mlkit_common.zzez$zzc r2 = new com.google.android.gms.internal.mlkit_common.zzez$zzc     // Catch: all -> 0x002c
                    com.google.android.gms.internal.mlkit_common.zzaa$zza$zza r4 = com.google.android.gms.internal.mlkit_common.zzaa.zza.C0099zza.zzh     // Catch: all -> 0x002c
                    r2.<init>(r4)     // Catch: all -> 0x002c
                    com.google.android.gms.internal.mlkit_common.zzaa.zza.C0099zza.zzi = r2     // Catch: all -> 0x002c
                L_0x002a:
                    monitor-exit(r3)     // Catch: all -> 0x002c
                    goto L_0x002f
                L_0x002c:
                    r2 = move-exception
                    monitor-exit(r3)     // Catch: all -> 0x002c
                    throw r2
                L_0x002f:
                    return r2
                L_0x0030:
                    com.google.android.gms.internal.mlkit_common.zzaa$zza$zza r2 = com.google.android.gms.internal.mlkit_common.zzaa.zza.C0099zza.zzh
                    return r2
                L_0x0033:
                    r2 = 6
                    java.lang.Object[] r2 = new java.lang.Object[r2]
                    r3 = 0
                    java.lang.String r0 = "zzc"
                    r2[r3] = r0
                    java.lang.String r3 = "zzd"
                    r2[r4] = r3
                    r3 = 2
                    com.google.android.gms.internal.mlkit_common.zzfd r4 = com.google.android.gms.internal.mlkit_common.zzal.zzb()
                    r2[r3] = r4
                    r3 = 3
                    java.lang.String r4 = "zze"
                    r2[r3] = r4
                    r3 = 4
                    java.lang.String r4 = "zzf"
                    r2[r3] = r4
                    r3 = 5
                    java.lang.String r4 = "zzg"
                    r2[r3] = r4
                    java.lang.String r3 = "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဇ\u0001\u0003ဉ\u0002\u0004ဉ\u0003"
                    com.google.android.gms.internal.mlkit_common.zzaa$zza$zza r4 = com.google.android.gms.internal.mlkit_common.zzaa.zza.C0099zza.zzh
                    java.lang.Object r2 = com.google.android.gms.internal.mlkit_common.zzez.zza(r4, r3, r2)
                    return r2
                L_0x005e:
                    com.google.android.gms.internal.mlkit_common.zzaa$zza$zza$zza r2 = new com.google.android.gms.internal.mlkit_common.zzaa$zza$zza$zza
                    r2.<init>(r3)
                    return r2
                L_0x0064:
                    com.google.android.gms.internal.mlkit_common.zzaa$zza$zza r2 = new com.google.android.gms.internal.mlkit_common.zzaa$zza$zza
                    r2.<init>()
                    return r2
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzaa.zza.C0099zza.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
            }
        }
    }

    /* compiled from: com.google.mlkit:common@@16.0.0 */
    /* loaded from: classes.dex */
    public static final class zzab extends zzez<zzab, zza> implements zzgj {
        private static final zzab zzj;
        private static volatile zzgr<zzab> zzk;
        private int zzc;
        private long zzd;
        private long zze;
        private long zzf;
        private long zzg;
        private long zzh;
        private long zzi;

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        /* loaded from: classes.dex */
        public static final class zza extends zzez.zza<zzab, zza> implements zzgj {
            private zza() {
                super(zzab.zzj);
            }

            /* synthetic */ zza(zzac zzacVar) {
                this();
            }
        }

        static {
            zzab zzabVar = new zzab();
            zzj = zzabVar;
            zzez.zza(zzab.class, zzabVar);
        }

        private zzab() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_common.zzez$zzc, com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzab>] */
        /* JADX WARN: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_common.zzez
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_common.zzac.zza
                r4 = 1
                int r2 = r2 - r4
                r2 = r3[r2]
                r3 = 0
                switch(r2) {
                    case 1: goto L_0x0067;
                    case 2: goto L_0x0061;
                    case 3: goto L_0x0033;
                    case 4: goto L_0x0030;
                    case 5: goto L_0x0016;
                    case 6: goto L_0x0011;
                    case 7: goto L_0x0010;
                    default: goto L_0x000a;
                }
            L_0x000a:
                java.lang.UnsupportedOperationException r2 = new java.lang.UnsupportedOperationException
                r2.<init>()
                throw r2
            L_0x0010:
                return r3
            L_0x0011:
                java.lang.Byte r2 = java.lang.Byte.valueOf(r4)
                return r2
            L_0x0016:
                com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzab> r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzab.zzk
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_common.zzaa$zzab> r3 = com.google.android.gms.internal.mlkit_common.zzaa.zzab.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzab> r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzab.zzk     // Catch: all -> 0x002c
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_common.zzez$zzc r2 = new com.google.android.gms.internal.mlkit_common.zzez$zzc     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_common.zzaa$zzab r4 = com.google.android.gms.internal.mlkit_common.zzaa.zzab.zzj     // Catch: all -> 0x002c
                r2.<init>(r4)     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_common.zzaa.zzab.zzk = r2     // Catch: all -> 0x002c
            L_0x002a:
                monitor-exit(r3)     // Catch: all -> 0x002c
                goto L_0x002f
            L_0x002c:
                r2 = move-exception
                monitor-exit(r3)     // Catch: all -> 0x002c
                throw r2
            L_0x002f:
                return r2
            L_0x0030:
                com.google.android.gms.internal.mlkit_common.zzaa$zzab r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzab.zzj
                return r2
            L_0x0033:
                r2 = 7
                java.lang.Object[] r2 = new java.lang.Object[r2]
                r3 = 0
                java.lang.String r0 = "zzc"
                r2[r3] = r0
                java.lang.String r3 = "zzd"
                r2[r4] = r3
                r3 = 2
                java.lang.String r4 = "zze"
                r2[r3] = r4
                r3 = 3
                java.lang.String r4 = "zzf"
                r2[r3] = r4
                r3 = 4
                java.lang.String r4 = "zzg"
                r2[r3] = r4
                r3 = 5
                java.lang.String r4 = "zzh"
                r2[r3] = r4
                r3 = 6
                java.lang.String r4 = "zzi"
                r2[r3] = r4
                java.lang.String r3 = "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ဃ\u0000\u0002ဃ\u0001\u0003ဃ\u0002\u0004ဃ\u0003\u0005ဃ\u0004\u0006ဃ\u0005"
                com.google.android.gms.internal.mlkit_common.zzaa$zzab r4 = com.google.android.gms.internal.mlkit_common.zzaa.zzab.zzj
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_common.zzez.zza(r4, r3, r2)
                return r2
            L_0x0061:
                com.google.android.gms.internal.mlkit_common.zzaa$zzab$zza r2 = new com.google.android.gms.internal.mlkit_common.zzaa$zzab$zza
                r2.<init>(r3)
                return r2
            L_0x0067:
                com.google.android.gms.internal.mlkit_common.zzaa$zzab r2 = new com.google.android.gms.internal.mlkit_common.zzaa$zzab
                r2.<init>()
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzaa.zzab.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: com.google.mlkit:common@@16.0.0 */
    /* loaded from: classes.dex */
    public static final class zzai extends zzez<zzai, zza> implements zzgj {
        private static final zzai zzg;
        private static volatile zzgr<zzai> zzh;
        private int zzc;
        private float zzd;
        private float zze;
        private float zzf;

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        /* loaded from: classes.dex */
        public static final class zza extends zzez.zza<zzai, zza> implements zzgj {
            private zza() {
                super(zzai.zzg);
            }

            /* synthetic */ zza(zzac zzacVar) {
                this();
            }
        }

        static {
            zzai zzaiVar = new zzai();
            zzg = zzaiVar;
            zzez.zza(zzai.class, zzaiVar);
        }

        private zzai() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzai>, com.google.android.gms.internal.mlkit_common.zzez$zzc] */
        /* JADX WARN: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_common.zzez
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_common.zzac.zza
                r4 = 1
                int r2 = r2 - r4
                r2 = r3[r2]
                r3 = 0
                switch(r2) {
                    case 1: goto L_0x0058;
                    case 2: goto L_0x0052;
                    case 3: goto L_0x0033;
                    case 4: goto L_0x0030;
                    case 5: goto L_0x0016;
                    case 6: goto L_0x0011;
                    case 7: goto L_0x0010;
                    default: goto L_0x000a;
                }
            L_0x000a:
                java.lang.UnsupportedOperationException r2 = new java.lang.UnsupportedOperationException
                r2.<init>()
                throw r2
            L_0x0010:
                return r3
            L_0x0011:
                java.lang.Byte r2 = java.lang.Byte.valueOf(r4)
                return r2
            L_0x0016:
                com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzai> r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzai.zzh
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_common.zzaa$zzai> r3 = com.google.android.gms.internal.mlkit_common.zzaa.zzai.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzai> r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzai.zzh     // Catch: all -> 0x002c
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_common.zzez$zzc r2 = new com.google.android.gms.internal.mlkit_common.zzez$zzc     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_common.zzaa$zzai r4 = com.google.android.gms.internal.mlkit_common.zzaa.zzai.zzg     // Catch: all -> 0x002c
                r2.<init>(r4)     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_common.zzaa.zzai.zzh = r2     // Catch: all -> 0x002c
            L_0x002a:
                monitor-exit(r3)     // Catch: all -> 0x002c
                goto L_0x002f
            L_0x002c:
                r2 = move-exception
                monitor-exit(r3)     // Catch: all -> 0x002c
                throw r2
            L_0x002f:
                return r2
            L_0x0030:
                com.google.android.gms.internal.mlkit_common.zzaa$zzai r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzai.zzg
                return r2
            L_0x0033:
                r2 = 4
                java.lang.Object[] r2 = new java.lang.Object[r2]
                r3 = 0
                java.lang.String r0 = "zzc"
                r2[r3] = r0
                java.lang.String r3 = "zzd"
                r2[r4] = r3
                r3 = 2
                java.lang.String r4 = "zze"
                r2[r3] = r4
                r3 = 3
                java.lang.String r4 = "zzf"
                r2[r3] = r4
                java.lang.String r3 = "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ခ\u0000\u0002ခ\u0001\u0003ခ\u0002"
                com.google.android.gms.internal.mlkit_common.zzaa$zzai r4 = com.google.android.gms.internal.mlkit_common.zzaa.zzai.zzg
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_common.zzez.zza(r4, r3, r2)
                return r2
            L_0x0052:
                com.google.android.gms.internal.mlkit_common.zzaa$zzai$zza r2 = new com.google.android.gms.internal.mlkit_common.zzaa$zzai$zza
                r2.<init>(r3)
                return r2
            L_0x0058:
                com.google.android.gms.internal.mlkit_common.zzaa$zzai r2 = new com.google.android.gms.internal.mlkit_common.zzaa$zzai
                r2.<init>()
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzaa.zzai.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: com.google.mlkit:common@@16.0.0 */
    /* loaded from: classes.dex */
    public static final class zzap extends zzez<zzap, zza> implements zzgj {
        private static final zzap zzj;
        private static volatile zzgr<zzap> zzk;
        private int zzc;
        private zzaf zzd;
        private zzck.zzb zze;
        private zzae zzf;
        private zzac zzg;
        private int zzh;
        private int zzi;

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        /* loaded from: classes.dex */
        public static final class zza extends zzez.zza<zzap, zza> implements zzgj {
            private zza() {
                super(zzap.zzj);
            }

            /* synthetic */ zza(zzac zzacVar) {
                this();
            }
        }

        static {
            zzap zzapVar = new zzap();
            zzj = zzapVar;
            zzez.zza(zzap.class, zzapVar);
        }

        private zzap() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_common.zzez$zzc, com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzap>] */
        /* JADX WARN: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_common.zzez
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_common.zzac.zza
                r4 = 1
                int r2 = r2 - r4
                r2 = r3[r2]
                r3 = 0
                switch(r2) {
                    case 1: goto L_0x0067;
                    case 2: goto L_0x0061;
                    case 3: goto L_0x0033;
                    case 4: goto L_0x0030;
                    case 5: goto L_0x0016;
                    case 6: goto L_0x0011;
                    case 7: goto L_0x0010;
                    default: goto L_0x000a;
                }
            L_0x000a:
                java.lang.UnsupportedOperationException r2 = new java.lang.UnsupportedOperationException
                r2.<init>()
                throw r2
            L_0x0010:
                return r3
            L_0x0011:
                java.lang.Byte r2 = java.lang.Byte.valueOf(r4)
                return r2
            L_0x0016:
                com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzap> r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzap.zzk
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_common.zzaa$zzap> r3 = com.google.android.gms.internal.mlkit_common.zzaa.zzap.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzap> r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzap.zzk     // Catch: all -> 0x002c
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_common.zzez$zzc r2 = new com.google.android.gms.internal.mlkit_common.zzez$zzc     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_common.zzaa$zzap r4 = com.google.android.gms.internal.mlkit_common.zzaa.zzap.zzj     // Catch: all -> 0x002c
                r2.<init>(r4)     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_common.zzaa.zzap.zzk = r2     // Catch: all -> 0x002c
            L_0x002a:
                monitor-exit(r3)     // Catch: all -> 0x002c
                goto L_0x002f
            L_0x002c:
                r2 = move-exception
                monitor-exit(r3)     // Catch: all -> 0x002c
                throw r2
            L_0x002f:
                return r2
            L_0x0030:
                com.google.android.gms.internal.mlkit_common.zzaa$zzap r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzap.zzj
                return r2
            L_0x0033:
                r2 = 7
                java.lang.Object[] r2 = new java.lang.Object[r2]
                r3 = 0
                java.lang.String r0 = "zzc"
                r2[r3] = r0
                java.lang.String r3 = "zzd"
                r2[r4] = r3
                r3 = 2
                java.lang.String r4 = "zze"
                r2[r3] = r4
                r3 = 3
                java.lang.String r4 = "zzf"
                r2[r3] = r4
                r3 = 4
                java.lang.String r4 = "zzg"
                r2[r3] = r4
                r3 = 5
                java.lang.String r4 = "zzh"
                r2[r3] = r4
                r3 = 6
                java.lang.String r4 = "zzi"
                r2[r3] = r4
                java.lang.String r3 = "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002\u0004ဉ\u0003\u0005ဋ\u0004\u0006ဋ\u0005"
                com.google.android.gms.internal.mlkit_common.zzaa$zzap r4 = com.google.android.gms.internal.mlkit_common.zzaa.zzap.zzj
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_common.zzez.zza(r4, r3, r2)
                return r2
            L_0x0061:
                com.google.android.gms.internal.mlkit_common.zzaa$zzap$zza r2 = new com.google.android.gms.internal.mlkit_common.zzaa$zzap$zza
                r2.<init>(r3)
                return r2
            L_0x0067:
                com.google.android.gms.internal.mlkit_common.zzaa$zzap r2 = new com.google.android.gms.internal.mlkit_common.zzaa$zzap
                r2.<init>()
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzaa.zzap.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: com.google.mlkit:common@@16.0.0 */
    /* loaded from: classes.dex */
    public static final class zzar extends zzez<zzar, zza> implements zzgj {
        private static final zzar zzi;
        private static volatile zzgr<zzar> zzj;
        private int zzc;
        private zzaf zzd;
        private zzat zze;
        private zzae zzf;
        private int zzg;
        private float zzh;

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        /* loaded from: classes.dex */
        public static final class zza extends zzez.zza<zzar, zza> implements zzgj {
            private zza() {
                super(zzar.zzi);
            }

            /* synthetic */ zza(zzac zzacVar) {
                this();
            }
        }

        static {
            zzar zzarVar = new zzar();
            zzi = zzarVar;
            zzez.zza(zzar.class, zzarVar);
        }

        private zzar() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_common.zzez$zzc, com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzar>] */
        /* JADX WARN: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_common.zzez
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_common.zzac.zza
                r4 = 1
                int r2 = r2 - r4
                r2 = r3[r2]
                r3 = 0
                switch(r2) {
                    case 1: goto L_0x0062;
                    case 2: goto L_0x005c;
                    case 3: goto L_0x0033;
                    case 4: goto L_0x0030;
                    case 5: goto L_0x0016;
                    case 6: goto L_0x0011;
                    case 7: goto L_0x0010;
                    default: goto L_0x000a;
                }
            L_0x000a:
                java.lang.UnsupportedOperationException r2 = new java.lang.UnsupportedOperationException
                r2.<init>()
                throw r2
            L_0x0010:
                return r3
            L_0x0011:
                java.lang.Byte r2 = java.lang.Byte.valueOf(r4)
                return r2
            L_0x0016:
                com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzar> r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzar.zzj
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_common.zzaa$zzar> r3 = com.google.android.gms.internal.mlkit_common.zzaa.zzar.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzar> r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzar.zzj     // Catch: all -> 0x002c
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_common.zzez$zzc r2 = new com.google.android.gms.internal.mlkit_common.zzez$zzc     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_common.zzaa$zzar r4 = com.google.android.gms.internal.mlkit_common.zzaa.zzar.zzi     // Catch: all -> 0x002c
                r2.<init>(r4)     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_common.zzaa.zzar.zzj = r2     // Catch: all -> 0x002c
            L_0x002a:
                monitor-exit(r3)     // Catch: all -> 0x002c
                goto L_0x002f
            L_0x002c:
                r2 = move-exception
                monitor-exit(r3)     // Catch: all -> 0x002c
                throw r2
            L_0x002f:
                return r2
            L_0x0030:
                com.google.android.gms.internal.mlkit_common.zzaa$zzar r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzar.zzi
                return r2
            L_0x0033:
                r2 = 6
                java.lang.Object[] r2 = new java.lang.Object[r2]
                r3 = 0
                java.lang.String r0 = "zzc"
                r2[r3] = r0
                java.lang.String r3 = "zzd"
                r2[r4] = r3
                r3 = 2
                java.lang.String r4 = "zze"
                r2[r3] = r4
                r3 = 3
                java.lang.String r4 = "zzf"
                r2[r3] = r4
                r3 = 4
                java.lang.String r4 = "zzg"
                r2[r3] = r4
                r3 = 5
                java.lang.String r4 = "zzh"
                r2[r3] = r4
                java.lang.String r3 = "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002\u0004ဋ\u0003\u0005ခ\u0004"
                com.google.android.gms.internal.mlkit_common.zzaa$zzar r4 = com.google.android.gms.internal.mlkit_common.zzaa.zzar.zzi
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_common.zzez.zza(r4, r3, r2)
                return r2
            L_0x005c:
                com.google.android.gms.internal.mlkit_common.zzaa$zzar$zza r2 = new com.google.android.gms.internal.mlkit_common.zzaa$zzar$zza
                r2.<init>(r3)
                return r2
            L_0x0062:
                com.google.android.gms.internal.mlkit_common.zzaa$zzar r2 = new com.google.android.gms.internal.mlkit_common.zzaa$zzar
                r2.<init>()
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzaa.zzar.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: com.google.mlkit:common@@16.0.0 */
    /* loaded from: classes.dex */
    public static final class zzat extends zzez<zzat, zza> implements zzgj {
        private static final zzat zzg;
        private static volatile zzgr<zzat> zzh;
        private int zzc;
        private int zzd;
        private float zze;
        private zzam zzf;

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        /* loaded from: classes.dex */
        public static final class zza extends zzez.zza<zzat, zza> implements zzgj {
            private zza() {
                super(zzat.zzg);
            }

            /* synthetic */ zza(zzac zzacVar) {
                this();
            }
        }

        static {
            zzat zzatVar = new zzat();
            zzg = zzatVar;
            zzez.zza(zzat.class, zzatVar);
        }

        private zzat() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_common.zzez$zzc, com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzat>] */
        /* JADX WARN: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_common.zzez
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_common.zzac.zza
                r4 = 1
                int r2 = r2 - r4
                r2 = r3[r2]
                r3 = 0
                switch(r2) {
                    case 1: goto L_0x0058;
                    case 2: goto L_0x0052;
                    case 3: goto L_0x0033;
                    case 4: goto L_0x0030;
                    case 5: goto L_0x0016;
                    case 6: goto L_0x0011;
                    case 7: goto L_0x0010;
                    default: goto L_0x000a;
                }
            L_0x000a:
                java.lang.UnsupportedOperationException r2 = new java.lang.UnsupportedOperationException
                r2.<init>()
                throw r2
            L_0x0010:
                return r3
            L_0x0011:
                java.lang.Byte r2 = java.lang.Byte.valueOf(r4)
                return r2
            L_0x0016:
                com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzat> r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzat.zzh
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_common.zzaa$zzat> r3 = com.google.android.gms.internal.mlkit_common.zzaa.zzat.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzat> r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzat.zzh     // Catch: all -> 0x002c
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_common.zzez$zzc r2 = new com.google.android.gms.internal.mlkit_common.zzez$zzc     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_common.zzaa$zzat r4 = com.google.android.gms.internal.mlkit_common.zzaa.zzat.zzg     // Catch: all -> 0x002c
                r2.<init>(r4)     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_common.zzaa.zzat.zzh = r2     // Catch: all -> 0x002c
            L_0x002a:
                monitor-exit(r3)     // Catch: all -> 0x002c
                goto L_0x002f
            L_0x002c:
                r2 = move-exception
                monitor-exit(r3)     // Catch: all -> 0x002c
                throw r2
            L_0x002f:
                return r2
            L_0x0030:
                com.google.android.gms.internal.mlkit_common.zzaa$zzat r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzat.zzg
                return r2
            L_0x0033:
                r2 = 4
                java.lang.Object[] r2 = new java.lang.Object[r2]
                r3 = 0
                java.lang.String r0 = "zzc"
                r2[r3] = r0
                java.lang.String r3 = "zzd"
                r2[r4] = r3
                r3 = 2
                java.lang.String r4 = "zze"
                r2[r3] = r4
                r3 = 3
                java.lang.String r4 = "zzf"
                r2[r3] = r4
                java.lang.String r3 = "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဋ\u0000\u0002ခ\u0001\u0003ဉ\u0002"
                com.google.android.gms.internal.mlkit_common.zzaa$zzat r4 = com.google.android.gms.internal.mlkit_common.zzaa.zzat.zzg
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_common.zzez.zza(r4, r3, r2)
                return r2
            L_0x0052:
                com.google.android.gms.internal.mlkit_common.zzaa$zzat$zza r2 = new com.google.android.gms.internal.mlkit_common.zzaa$zzat$zza
                r2.<init>(r3)
                return r2
            L_0x0058:
                com.google.android.gms.internal.mlkit_common.zzaa$zzat r2 = new com.google.android.gms.internal.mlkit_common.zzaa$zzat
                r2.<init>()
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzaa.zzat.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: com.google.mlkit:common@@16.0.0 */
    /* loaded from: classes.dex */
    public static final class zzaz extends zzez<zzaz, zza> implements zzgj {
        private static final zzaz zzg;
        private static volatile zzgr<zzaz> zzh;
        private int zzc;
        private zzaf zzd;
        private zzae zze;
        private zzba zzf;

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        /* loaded from: classes.dex */
        public static final class zza extends zzez.zza<zzaz, zza> implements zzgj {
            private zza() {
                super(zzaz.zzg);
            }

            /* synthetic */ zza(zzac zzacVar) {
                this();
            }
        }

        static {
            zzaz zzazVar = new zzaz();
            zzg = zzazVar;
            zzez.zza(zzaz.class, zzazVar);
        }

        private zzaz() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzaz>, com.google.android.gms.internal.mlkit_common.zzez$zzc] */
        /* JADX WARN: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_common.zzez
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_common.zzac.zza
                r4 = 1
                int r2 = r2 - r4
                r2 = r3[r2]
                r3 = 0
                switch(r2) {
                    case 1: goto L_0x0058;
                    case 2: goto L_0x0052;
                    case 3: goto L_0x0033;
                    case 4: goto L_0x0030;
                    case 5: goto L_0x0016;
                    case 6: goto L_0x0011;
                    case 7: goto L_0x0010;
                    default: goto L_0x000a;
                }
            L_0x000a:
                java.lang.UnsupportedOperationException r2 = new java.lang.UnsupportedOperationException
                r2.<init>()
                throw r2
            L_0x0010:
                return r3
            L_0x0011:
                java.lang.Byte r2 = java.lang.Byte.valueOf(r4)
                return r2
            L_0x0016:
                com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzaz> r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzaz.zzh
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_common.zzaa$zzaz> r3 = com.google.android.gms.internal.mlkit_common.zzaa.zzaz.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzaz> r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzaz.zzh     // Catch: all -> 0x002c
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_common.zzez$zzc r2 = new com.google.android.gms.internal.mlkit_common.zzez$zzc     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_common.zzaa$zzaz r4 = com.google.android.gms.internal.mlkit_common.zzaa.zzaz.zzg     // Catch: all -> 0x002c
                r2.<init>(r4)     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_common.zzaa.zzaz.zzh = r2     // Catch: all -> 0x002c
            L_0x002a:
                monitor-exit(r3)     // Catch: all -> 0x002c
                goto L_0x002f
            L_0x002c:
                r2 = move-exception
                monitor-exit(r3)     // Catch: all -> 0x002c
                throw r2
            L_0x002f:
                return r2
            L_0x0030:
                com.google.android.gms.internal.mlkit_common.zzaa$zzaz r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzaz.zzg
                return r2
            L_0x0033:
                r2 = 4
                java.lang.Object[] r2 = new java.lang.Object[r2]
                r3 = 0
                java.lang.String r0 = "zzc"
                r2[r3] = r0
                java.lang.String r3 = "zzd"
                r2[r4] = r3
                r3 = 2
                java.lang.String r4 = "zze"
                r2[r3] = r4
                r3 = 3
                java.lang.String r4 = "zzf"
                r2[r3] = r4
                java.lang.String r3 = "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002"
                com.google.android.gms.internal.mlkit_common.zzaa$zzaz r4 = com.google.android.gms.internal.mlkit_common.zzaa.zzaz.zzg
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_common.zzez.zza(r4, r3, r2)
                return r2
            L_0x0052:
                com.google.android.gms.internal.mlkit_common.zzaa$zzaz$zza r2 = new com.google.android.gms.internal.mlkit_common.zzaa$zzaz$zza
                r2.<init>(r3)
                return r2
            L_0x0058:
                com.google.android.gms.internal.mlkit_common.zzaa$zzaz r2 = new com.google.android.gms.internal.mlkit_common.zzaa$zzaz
                r2.<init>()
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzaa.zzaz.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: com.google.mlkit:common@@16.0.0 */
    /* loaded from: classes.dex */
    public static final class zzb extends zzez<zzb, C0105zzb> implements zzgj {
        private static final zzb zzg;
        private static volatile zzgr<zzb> zzh;
        private int zzc;
        private zza zzd;
        private int zze;
        private zzab zzf;

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        /* renamed from: com.google.android.gms.internal.mlkit_common.zzaa$zzb$zzb  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0105zzb extends zzez.zza<zzb, C0105zzb> implements zzgj {
            private C0105zzb() {
                super(zzb.zzg);
            }

            /* synthetic */ C0105zzb(zzac zzacVar) {
                this();
            }
        }

        static {
            zzb zzbVar = new zzb();
            zzg = zzbVar;
            zzez.zza(zzb.class, zzbVar);
        }

        private zzb() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_common.zzez$zzc, com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzb>] */
        /* JADX WARN: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_common.zzez
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_common.zzac.zza
                r4 = 1
                int r2 = r2 - r4
                r2 = r3[r2]
                r3 = 0
                switch(r2) {
                    case 1: goto L_0x0058;
                    case 2: goto L_0x0052;
                    case 3: goto L_0x0033;
                    case 4: goto L_0x0030;
                    case 5: goto L_0x0016;
                    case 6: goto L_0x0011;
                    case 7: goto L_0x0010;
                    default: goto L_0x000a;
                }
            L_0x000a:
                java.lang.UnsupportedOperationException r2 = new java.lang.UnsupportedOperationException
                r2.<init>()
                throw r2
            L_0x0010:
                return r3
            L_0x0011:
                java.lang.Byte r2 = java.lang.Byte.valueOf(r4)
                return r2
            L_0x0016:
                com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzb> r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzb.zzh
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_common.zzaa$zzb> r3 = com.google.android.gms.internal.mlkit_common.zzaa.zzb.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzb> r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzb.zzh     // Catch: all -> 0x002c
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_common.zzez$zzc r2 = new com.google.android.gms.internal.mlkit_common.zzez$zzc     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_common.zzaa$zzb r4 = com.google.android.gms.internal.mlkit_common.zzaa.zzb.zzg     // Catch: all -> 0x002c
                r2.<init>(r4)     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_common.zzaa.zzb.zzh = r2     // Catch: all -> 0x002c
            L_0x002a:
                monitor-exit(r3)     // Catch: all -> 0x002c
                goto L_0x002f
            L_0x002c:
                r2 = move-exception
                monitor-exit(r3)     // Catch: all -> 0x002c
                throw r2
            L_0x002f:
                return r2
            L_0x0030:
                com.google.android.gms.internal.mlkit_common.zzaa$zzb r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzb.zzg
                return r2
            L_0x0033:
                r2 = 4
                java.lang.Object[] r2 = new java.lang.Object[r2]
                r3 = 0
                java.lang.String r0 = "zzc"
                r2[r3] = r0
                java.lang.String r3 = "zzd"
                r2[r4] = r3
                r3 = 2
                java.lang.String r4 = "zze"
                r2[r3] = r4
                r3 = 3
                java.lang.String r4 = "zzf"
                r2[r3] = r4
                java.lang.String r3 = "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဋ\u0001\u0003ဉ\u0002"
                com.google.android.gms.internal.mlkit_common.zzaa$zzb r4 = com.google.android.gms.internal.mlkit_common.zzaa.zzb.zzg
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_common.zzez.zza(r4, r3, r2)
                return r2
            L_0x0052:
                com.google.android.gms.internal.mlkit_common.zzaa$zzb$zzb r2 = new com.google.android.gms.internal.mlkit_common.zzaa$zzb$zzb
                r2.<init>(r3)
                return r2
            L_0x0058:
                com.google.android.gms.internal.mlkit_common.zzaa$zzb r2 = new com.google.android.gms.internal.mlkit_common.zzaa$zzb
                r2.<init>()
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzaa.zzb.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        /* loaded from: classes.dex */
        public static final class zza extends zzez<zza, C0104zza> implements zzgj {
            private static final zza zzi;
            private static volatile zzgr<zza> zzj;
            private int zzc;
            private int zzd;
            private boolean zze;
            private zzfi<zzy.zza> zzf = zzez.zzl();
            private zzfi<zzy.zza> zzg = zzez.zzl();
            private zzam zzh;

            /* compiled from: com.google.mlkit:common@@16.0.0 */
            /* renamed from: com.google.android.gms.internal.mlkit_common.zzaa$zzb$zza$zza  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            public static final class C0104zza extends zzez.zza<zza, C0104zza> implements zzgj {
                private C0104zza() {
                    super(zza.zzi);
                }

                /* synthetic */ C0104zza(zzac zzacVar) {
                    this();
                }
            }

            static {
                zza zzaVar = new zza();
                zzi = zzaVar;
                zzez.zza(zza.class, zzaVar);
            }

            private zza() {
            }

            /* JADX INFO: Access modifiers changed from: protected */
            /* JADX WARN: Type inference failed for: r3v14, types: [com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzb$zza>, com.google.android.gms.internal.mlkit_common.zzez$zzc] */
            /* JADX WARN: Unknown variable types count: 1 */
            @Override // com.google.android.gms.internal.mlkit_common.zzez
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final java.lang.Object zza(int r3, java.lang.Object r4, java.lang.Object r5) {
                /*
                    r2 = this;
                    java.lang.Class<com.google.android.gms.internal.mlkit_common.zzaa$zzy$zza> r4 = com.google.android.gms.internal.mlkit_common.zzaa.zzy.zza.class
                    int[] r5 = com.google.android.gms.internal.mlkit_common.zzac.zza
                    r0 = 1
                    int r3 = r3 - r0
                    r3 = r5[r3]
                    r5 = 0
                    switch(r3) {
                        case 1: goto L_0x0073;
                        case 2: goto L_0x006d;
                        case 3: goto L_0x0035;
                        case 4: goto L_0x0032;
                        case 5: goto L_0x0018;
                        case 6: goto L_0x0013;
                        case 7: goto L_0x0012;
                        default: goto L_0x000c;
                    }
                L_0x000c:
                    java.lang.UnsupportedOperationException r3 = new java.lang.UnsupportedOperationException
                    r3.<init>()
                    throw r3
                L_0x0012:
                    return r5
                L_0x0013:
                    java.lang.Byte r3 = java.lang.Byte.valueOf(r0)
                    return r3
                L_0x0018:
                    com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzb$zza> r3 = com.google.android.gms.internal.mlkit_common.zzaa.zzb.zza.zzj
                    if (r3 != 0) goto L_0x0031
                    java.lang.Class<com.google.android.gms.internal.mlkit_common.zzaa$zzb$zza> r4 = com.google.android.gms.internal.mlkit_common.zzaa.zzb.zza.class
                    monitor-enter(r4)
                    com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzb$zza> r3 = com.google.android.gms.internal.mlkit_common.zzaa.zzb.zza.zzj     // Catch: all -> 0x002e
                    if (r3 != 0) goto L_0x002c
                    com.google.android.gms.internal.mlkit_common.zzez$zzc r3 = new com.google.android.gms.internal.mlkit_common.zzez$zzc     // Catch: all -> 0x002e
                    com.google.android.gms.internal.mlkit_common.zzaa$zzb$zza r5 = com.google.android.gms.internal.mlkit_common.zzaa.zzb.zza.zzi     // Catch: all -> 0x002e
                    r3.<init>(r5)     // Catch: all -> 0x002e
                    com.google.android.gms.internal.mlkit_common.zzaa.zzb.zza.zzj = r3     // Catch: all -> 0x002e
                L_0x002c:
                    monitor-exit(r4)     // Catch: all -> 0x002e
                    goto L_0x0031
                L_0x002e:
                    r3 = move-exception
                    monitor-exit(r4)     // Catch: all -> 0x002e
                    throw r3
                L_0x0031:
                    return r3
                L_0x0032:
                    com.google.android.gms.internal.mlkit_common.zzaa$zzb$zza r3 = com.google.android.gms.internal.mlkit_common.zzaa.zzb.zza.zzi
                    return r3
                L_0x0035:
                    r3 = 9
                    java.lang.Object[] r3 = new java.lang.Object[r3]
                    r5 = 0
                    java.lang.String r1 = "zzc"
                    r3[r5] = r1
                    java.lang.String r5 = "zzd"
                    r3[r0] = r5
                    r5 = 2
                    com.google.android.gms.internal.mlkit_common.zzfd r0 = com.google.android.gms.internal.mlkit_common.zzal.zzb()
                    r3[r5] = r0
                    r5 = 3
                    java.lang.String r0 = "zze"
                    r3[r5] = r0
                    r5 = 4
                    java.lang.String r0 = "zzf"
                    r3[r5] = r0
                    r5 = 5
                    r3[r5] = r4
                    r5 = 6
                    java.lang.String r0 = "zzg"
                    r3[r5] = r0
                    r5 = 7
                    r3[r5] = r4
                    r4 = 8
                    java.lang.String r5 = "zzh"
                    r3[r4] = r5
                    java.lang.String r4 = "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0002\u0000\u0001ဌ\u0000\u0002ဇ\u0001\u0003\u001b\u0004\u001b\u0005ဉ\u0002"
                    com.google.android.gms.internal.mlkit_common.zzaa$zzb$zza r5 = com.google.android.gms.internal.mlkit_common.zzaa.zzb.zza.zzi
                    java.lang.Object r3 = com.google.android.gms.internal.mlkit_common.zzez.zza(r5, r4, r3)
                    return r3
                L_0x006d:
                    com.google.android.gms.internal.mlkit_common.zzaa$zzb$zza$zza r3 = new com.google.android.gms.internal.mlkit_common.zzaa$zzb$zza$zza
                    r3.<init>(r5)
                    return r3
                L_0x0073:
                    com.google.android.gms.internal.mlkit_common.zzaa$zzb$zza r3 = new com.google.android.gms.internal.mlkit_common.zzaa$zzb$zza
                    r3.<init>()
                    return r3
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzaa.zzb.zza.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
            }
        }
    }

    /* compiled from: com.google.mlkit:common@@16.0.0 */
    /* loaded from: classes.dex */
    public static final class zzbb extends zzez<zzbb, zza> implements zzgj {
        private static final zzbb zzf;
        private static volatile zzgr<zzbb> zzg;
        private int zzc;
        private zzaf zzd;
        private zzae zze;

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        /* loaded from: classes.dex */
        public static final class zza extends zzez.zza<zzbb, zza> implements zzgj {
            private zza() {
                super(zzbb.zzf);
            }

            /* synthetic */ zza(zzac zzacVar) {
                this();
            }
        }

        static {
            zzbb zzbbVar = new zzbb();
            zzf = zzbbVar;
            zzez.zza(zzbb.class, zzbbVar);
        }

        private zzbb() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_common.zzez$zzc, com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzbb>] */
        /* JADX WARN: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_common.zzez
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_common.zzac.zza
                r4 = 1
                int r2 = r2 - r4
                r2 = r3[r2]
                r3 = 0
                switch(r2) {
                    case 1: goto L_0x0053;
                    case 2: goto L_0x004d;
                    case 3: goto L_0x0033;
                    case 4: goto L_0x0030;
                    case 5: goto L_0x0016;
                    case 6: goto L_0x0011;
                    case 7: goto L_0x0010;
                    default: goto L_0x000a;
                }
            L_0x000a:
                java.lang.UnsupportedOperationException r2 = new java.lang.UnsupportedOperationException
                r2.<init>()
                throw r2
            L_0x0010:
                return r3
            L_0x0011:
                java.lang.Byte r2 = java.lang.Byte.valueOf(r4)
                return r2
            L_0x0016:
                com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzbb> r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzbb.zzg
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_common.zzaa$zzbb> r3 = com.google.android.gms.internal.mlkit_common.zzaa.zzbb.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzbb> r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzbb.zzg     // Catch: all -> 0x002c
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_common.zzez$zzc r2 = new com.google.android.gms.internal.mlkit_common.zzez$zzc     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_common.zzaa$zzbb r4 = com.google.android.gms.internal.mlkit_common.zzaa.zzbb.zzf     // Catch: all -> 0x002c
                r2.<init>(r4)     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_common.zzaa.zzbb.zzg = r2     // Catch: all -> 0x002c
            L_0x002a:
                monitor-exit(r3)     // Catch: all -> 0x002c
                goto L_0x002f
            L_0x002c:
                r2 = move-exception
                monitor-exit(r3)     // Catch: all -> 0x002c
                throw r2
            L_0x002f:
                return r2
            L_0x0030:
                com.google.android.gms.internal.mlkit_common.zzaa$zzbb r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzbb.zzf
                return r2
            L_0x0033:
                r2 = 3
                java.lang.Object[] r2 = new java.lang.Object[r2]
                r3 = 0
                java.lang.String r0 = "zzc"
                r2[r3] = r0
                java.lang.String r3 = "zzd"
                r2[r4] = r3
                r3 = 2
                java.lang.String r4 = "zze"
                r2[r3] = r4
                java.lang.String r3 = "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001"
                com.google.android.gms.internal.mlkit_common.zzaa$zzbb r4 = com.google.android.gms.internal.mlkit_common.zzaa.zzbb.zzf
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_common.zzez.zza(r4, r3, r2)
                return r2
            L_0x004d:
                com.google.android.gms.internal.mlkit_common.zzaa$zzbb$zza r2 = new com.google.android.gms.internal.mlkit_common.zzaa$zzbb$zza
                r2.<init>(r3)
                return r2
            L_0x0053:
                com.google.android.gms.internal.mlkit_common.zzaa$zzbb r2 = new com.google.android.gms.internal.mlkit_common.zzaa$zzbb
                r2.<init>()
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzaa.zzbb.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: com.google.mlkit:common@@16.0.0 */
    /* loaded from: classes.dex */
    public static final class zzbd extends zzez<zzbd, zza> implements zzgj {
        private static final zzbd zzf;
        private static volatile zzgr<zzbd> zzg;
        private int zzc;
        private zzaf zzd;
        private zzae zze;

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        /* loaded from: classes.dex */
        public static final class zza extends zzez.zza<zzbd, zza> implements zzgj {
            private zza() {
                super(zzbd.zzf);
            }

            /* synthetic */ zza(zzac zzacVar) {
                this();
            }
        }

        static {
            zzbd zzbdVar = new zzbd();
            zzf = zzbdVar;
            zzez.zza(zzbd.class, zzbdVar);
        }

        private zzbd() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_common.zzez$zzc, com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzbd>] */
        /* JADX WARN: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_common.zzez
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_common.zzac.zza
                r4 = 1
                int r2 = r2 - r4
                r2 = r3[r2]
                r3 = 0
                switch(r2) {
                    case 1: goto L_0x0053;
                    case 2: goto L_0x004d;
                    case 3: goto L_0x0033;
                    case 4: goto L_0x0030;
                    case 5: goto L_0x0016;
                    case 6: goto L_0x0011;
                    case 7: goto L_0x0010;
                    default: goto L_0x000a;
                }
            L_0x000a:
                java.lang.UnsupportedOperationException r2 = new java.lang.UnsupportedOperationException
                r2.<init>()
                throw r2
            L_0x0010:
                return r3
            L_0x0011:
                java.lang.Byte r2 = java.lang.Byte.valueOf(r4)
                return r2
            L_0x0016:
                com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzbd> r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzbd.zzg
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_common.zzaa$zzbd> r3 = com.google.android.gms.internal.mlkit_common.zzaa.zzbd.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzbd> r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzbd.zzg     // Catch: all -> 0x002c
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_common.zzez$zzc r2 = new com.google.android.gms.internal.mlkit_common.zzez$zzc     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_common.zzaa$zzbd r4 = com.google.android.gms.internal.mlkit_common.zzaa.zzbd.zzf     // Catch: all -> 0x002c
                r2.<init>(r4)     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_common.zzaa.zzbd.zzg = r2     // Catch: all -> 0x002c
            L_0x002a:
                monitor-exit(r3)     // Catch: all -> 0x002c
                goto L_0x002f
            L_0x002c:
                r2 = move-exception
                monitor-exit(r3)     // Catch: all -> 0x002c
                throw r2
            L_0x002f:
                return r2
            L_0x0030:
                com.google.android.gms.internal.mlkit_common.zzaa$zzbd r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzbd.zzf
                return r2
            L_0x0033:
                r2 = 3
                java.lang.Object[] r2 = new java.lang.Object[r2]
                r3 = 0
                java.lang.String r0 = "zzc"
                r2[r3] = r0
                java.lang.String r3 = "zzd"
                r2[r4] = r3
                r3 = 2
                java.lang.String r4 = "zze"
                r2[r3] = r4
                java.lang.String r3 = "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001"
                com.google.android.gms.internal.mlkit_common.zzaa$zzbd r4 = com.google.android.gms.internal.mlkit_common.zzaa.zzbd.zzf
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_common.zzez.zza(r4, r3, r2)
                return r2
            L_0x004d:
                com.google.android.gms.internal.mlkit_common.zzaa$zzbd$zza r2 = new com.google.android.gms.internal.mlkit_common.zzaa$zzbd$zza
                r2.<init>(r3)
                return r2
            L_0x0053:
                com.google.android.gms.internal.mlkit_common.zzaa$zzbd r2 = new com.google.android.gms.internal.mlkit_common.zzaa$zzbd
                r2.<init>()
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzaa.zzbd.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: com.google.mlkit:common@@16.0.0 */
    /* loaded from: classes.dex */
    public static final class zzbh extends zzez<zzbh, zza> implements zzgj {
        private static final zzbh zzf;
        private static volatile zzgr<zzbh> zzg;
        private int zzc;
        private String zzd = "";
        private String zze = "";

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        /* loaded from: classes.dex */
        public static final class zza extends zzez.zza<zzbh, zza> implements zzgj {
            private zza() {
                super(zzbh.zzf);
            }

            /* synthetic */ zza(zzac zzacVar) {
                this();
            }
        }

        static {
            zzbh zzbhVar = new zzbh();
            zzf = zzbhVar;
            zzez.zza(zzbh.class, zzbhVar);
        }

        private zzbh() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzbh>, com.google.android.gms.internal.mlkit_common.zzez$zzc] */
        /* JADX WARN: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_common.zzez
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_common.zzac.zza
                r4 = 1
                int r2 = r2 - r4
                r2 = r3[r2]
                r3 = 0
                switch(r2) {
                    case 1: goto L_0x0053;
                    case 2: goto L_0x004d;
                    case 3: goto L_0x0033;
                    case 4: goto L_0x0030;
                    case 5: goto L_0x0016;
                    case 6: goto L_0x0011;
                    case 7: goto L_0x0010;
                    default: goto L_0x000a;
                }
            L_0x000a:
                java.lang.UnsupportedOperationException r2 = new java.lang.UnsupportedOperationException
                r2.<init>()
                throw r2
            L_0x0010:
                return r3
            L_0x0011:
                java.lang.Byte r2 = java.lang.Byte.valueOf(r4)
                return r2
            L_0x0016:
                com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzbh> r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzbh.zzg
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_common.zzaa$zzbh> r3 = com.google.android.gms.internal.mlkit_common.zzaa.zzbh.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzbh> r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzbh.zzg     // Catch: all -> 0x002c
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_common.zzez$zzc r2 = new com.google.android.gms.internal.mlkit_common.zzez$zzc     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_common.zzaa$zzbh r4 = com.google.android.gms.internal.mlkit_common.zzaa.zzbh.zzf     // Catch: all -> 0x002c
                r2.<init>(r4)     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_common.zzaa.zzbh.zzg = r2     // Catch: all -> 0x002c
            L_0x002a:
                monitor-exit(r3)     // Catch: all -> 0x002c
                goto L_0x002f
            L_0x002c:
                r2 = move-exception
                monitor-exit(r3)     // Catch: all -> 0x002c
                throw r2
            L_0x002f:
                return r2
            L_0x0030:
                com.google.android.gms.internal.mlkit_common.zzaa$zzbh r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzbh.zzf
                return r2
            L_0x0033:
                r2 = 3
                java.lang.Object[] r2 = new java.lang.Object[r2]
                r3 = 0
                java.lang.String r0 = "zzc"
                r2[r3] = r0
                java.lang.String r3 = "zzd"
                r2[r4] = r3
                r3 = 2
                java.lang.String r4 = "zze"
                r2[r3] = r4
                java.lang.String r3 = "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001"
                com.google.android.gms.internal.mlkit_common.zzaa$zzbh r4 = com.google.android.gms.internal.mlkit_common.zzaa.zzbh.zzf
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_common.zzez.zza(r4, r3, r2)
                return r2
            L_0x004d:
                com.google.android.gms.internal.mlkit_common.zzaa$zzbh$zza r2 = new com.google.android.gms.internal.mlkit_common.zzaa$zzbh$zza
                r2.<init>(r3)
                return r2
            L_0x0053:
                com.google.android.gms.internal.mlkit_common.zzaa$zzbh r2 = new com.google.android.gms.internal.mlkit_common.zzaa$zzbh
                r2.<init>()
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzaa.zzbh.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: com.google.mlkit:common@@16.0.0 */
    /* loaded from: classes.dex */
    public static final class zzc extends zzez<zzc, zzb> implements zzgj {
        private static final zzc zzg;
        private static volatile zzgr<zzc> zzh;
        private int zzc;
        private zza zzd;
        private int zze;
        private zzab zzf;

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        /* loaded from: classes.dex */
        public static final class zzb extends zzez.zza<zzc, zzb> implements zzgj {
            private zzb() {
                super(zzc.zzg);
            }

            /* synthetic */ zzb(zzac zzacVar) {
                this();
            }
        }

        static {
            zzc zzcVar = new zzc();
            zzg = zzcVar;
            zzez.zza(zzc.class, zzcVar);
        }

        private zzc() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_common.zzez$zzc, com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzc>] */
        /* JADX WARN: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_common.zzez
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_common.zzac.zza
                r4 = 1
                int r2 = r2 - r4
                r2 = r3[r2]
                r3 = 0
                switch(r2) {
                    case 1: goto L_0x0058;
                    case 2: goto L_0x0052;
                    case 3: goto L_0x0033;
                    case 4: goto L_0x0030;
                    case 5: goto L_0x0016;
                    case 6: goto L_0x0011;
                    case 7: goto L_0x0010;
                    default: goto L_0x000a;
                }
            L_0x000a:
                java.lang.UnsupportedOperationException r2 = new java.lang.UnsupportedOperationException
                r2.<init>()
                throw r2
            L_0x0010:
                return r3
            L_0x0011:
                java.lang.Byte r2 = java.lang.Byte.valueOf(r4)
                return r2
            L_0x0016:
                com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzc> r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzc.zzh
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_common.zzaa$zzc> r3 = com.google.android.gms.internal.mlkit_common.zzaa.zzc.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzc> r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzc.zzh     // Catch: all -> 0x002c
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_common.zzez$zzc r2 = new com.google.android.gms.internal.mlkit_common.zzez$zzc     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_common.zzaa$zzc r4 = com.google.android.gms.internal.mlkit_common.zzaa.zzc.zzg     // Catch: all -> 0x002c
                r2.<init>(r4)     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_common.zzaa.zzc.zzh = r2     // Catch: all -> 0x002c
            L_0x002a:
                monitor-exit(r3)     // Catch: all -> 0x002c
                goto L_0x002f
            L_0x002c:
                r2 = move-exception
                monitor-exit(r3)     // Catch: all -> 0x002c
                throw r2
            L_0x002f:
                return r2
            L_0x0030:
                com.google.android.gms.internal.mlkit_common.zzaa$zzc r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzc.zzg
                return r2
            L_0x0033:
                r2 = 4
                java.lang.Object[] r2 = new java.lang.Object[r2]
                r3 = 0
                java.lang.String r0 = "zzc"
                r2[r3] = r0
                java.lang.String r3 = "zzd"
                r2[r4] = r3
                r3 = 2
                java.lang.String r4 = "zze"
                r2[r3] = r4
                r3 = 3
                java.lang.String r4 = "zzf"
                r2[r3] = r4
                java.lang.String r3 = "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဋ\u0001\u0003ဉ\u0002"
                com.google.android.gms.internal.mlkit_common.zzaa$zzc r4 = com.google.android.gms.internal.mlkit_common.zzaa.zzc.zzg
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_common.zzez.zza(r4, r3, r2)
                return r2
            L_0x0052:
                com.google.android.gms.internal.mlkit_common.zzaa$zzc$zzb r2 = new com.google.android.gms.internal.mlkit_common.zzaa$zzc$zzb
                r2.<init>(r3)
                return r2
            L_0x0058:
                com.google.android.gms.internal.mlkit_common.zzaa$zzc r2 = new com.google.android.gms.internal.mlkit_common.zzaa$zzc
                r2.<init>()
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzaa.zzc.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        /* loaded from: classes.dex */
        public static final class zza extends zzez<zza, C0106zza> implements zzgj {
            private static final zzff<Integer, zzao.zza> zzj = new zzae();
            private static final zzff<Integer, zzao.zzb> zzl = new zzad();
            private static final zza zzm;
            private static volatile zzgr<zza> zzn;
            private int zzc;
            private int zzd;
            private boolean zze;
            private boolean zzf;
            private zzae zzg;
            private zzck.zza zzh;
            private zzfg zzi = zzez.zzk();
            private zzfg zzk = zzez.zzk();

            /* compiled from: com.google.mlkit:common@@16.0.0 */
            /* renamed from: com.google.android.gms.internal.mlkit_common.zzaa$zzc$zza$zza  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            public static final class C0106zza extends zzez.zza<zza, C0106zza> implements zzgj {
                private C0106zza() {
                    super(zza.zzm);
                }

                /* synthetic */ C0106zza(zzac zzacVar) {
                    this();
                }
            }

            /* JADX WARN: Type inference failed for: r0v0, types: [com.google.android.gms.internal.mlkit_common.zzff<java.lang.Integer, com.google.android.gms.internal.mlkit_common.zzaa$zzao$zza>, com.google.android.gms.internal.mlkit_common.zzae] */
            /* JADX WARN: Type inference failed for: r0v1, types: [com.google.android.gms.internal.mlkit_common.zzff<java.lang.Integer, com.google.android.gms.internal.mlkit_common.zzaa$zzao$zzb>, com.google.android.gms.internal.mlkit_common.zzad] */
            static {
                zza zzaVar = new zza();
                zzm = zzaVar;
                zzez.zza(zza.class, zzaVar);
            }

            private zza() {
            }

            /* JADX INFO: Access modifiers changed from: protected */
            /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_common.zzez$zzc, com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzc$zza>] */
            /* JADX WARN: Unknown variable types count: 1 */
            @Override // com.google.android.gms.internal.mlkit_common.zzez
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
                /*
                    r1 = this;
                    int[] r3 = com.google.android.gms.internal.mlkit_common.zzac.zza
                    r4 = 1
                    int r2 = r2 - r4
                    r2 = r3[r2]
                    r3 = 0
                    switch(r2) {
                        case 1: goto L_0x0085;
                        case 2: goto L_0x007f;
                        case 3: goto L_0x0033;
                        case 4: goto L_0x0030;
                        case 5: goto L_0x0016;
                        case 6: goto L_0x0011;
                        case 7: goto L_0x0010;
                        default: goto L_0x000a;
                    }
                L_0x000a:
                    java.lang.UnsupportedOperationException r2 = new java.lang.UnsupportedOperationException
                    r2.<init>()
                    throw r2
                L_0x0010:
                    return r3
                L_0x0011:
                    java.lang.Byte r2 = java.lang.Byte.valueOf(r4)
                    return r2
                L_0x0016:
                    com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzc$zza> r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzc.zza.zzn
                    if (r2 != 0) goto L_0x002f
                    java.lang.Class<com.google.android.gms.internal.mlkit_common.zzaa$zzc$zza> r3 = com.google.android.gms.internal.mlkit_common.zzaa.zzc.zza.class
                    monitor-enter(r3)
                    com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzc$zza> r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzc.zza.zzn     // Catch: all -> 0x002c
                    if (r2 != 0) goto L_0x002a
                    com.google.android.gms.internal.mlkit_common.zzez$zzc r2 = new com.google.android.gms.internal.mlkit_common.zzez$zzc     // Catch: all -> 0x002c
                    com.google.android.gms.internal.mlkit_common.zzaa$zzc$zza r4 = com.google.android.gms.internal.mlkit_common.zzaa.zzc.zza.zzm     // Catch: all -> 0x002c
                    r2.<init>(r4)     // Catch: all -> 0x002c
                    com.google.android.gms.internal.mlkit_common.zzaa.zzc.zza.zzn = r2     // Catch: all -> 0x002c
                L_0x002a:
                    monitor-exit(r3)     // Catch: all -> 0x002c
                    goto L_0x002f
                L_0x002c:
                    r2 = move-exception
                    monitor-exit(r3)     // Catch: all -> 0x002c
                    throw r2
                L_0x002f:
                    return r2
                L_0x0030:
                    com.google.android.gms.internal.mlkit_common.zzaa$zzc$zza r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzc.zza.zzm
                    return r2
                L_0x0033:
                    r2 = 11
                    java.lang.Object[] r2 = new java.lang.Object[r2]
                    r3 = 0
                    java.lang.String r0 = "zzc"
                    r2[r3] = r0
                    java.lang.String r3 = "zzd"
                    r2[r4] = r3
                    r3 = 2
                    com.google.android.gms.internal.mlkit_common.zzfd r4 = com.google.android.gms.internal.mlkit_common.zzal.zzb()
                    r2[r3] = r4
                    r3 = 3
                    java.lang.String r4 = "zze"
                    r2[r3] = r4
                    r3 = 4
                    java.lang.String r4 = "zzf"
                    r2[r3] = r4
                    r3 = 5
                    java.lang.String r4 = "zzg"
                    r2[r3] = r4
                    r3 = 6
                    java.lang.String r4 = "zzh"
                    r2[r3] = r4
                    r3 = 7
                    java.lang.String r4 = "zzi"
                    r2[r3] = r4
                    r3 = 8
                    com.google.android.gms.internal.mlkit_common.zzfd r4 = com.google.android.gms.internal.mlkit_common.zzaa.zzao.zza.zzb()
                    r2[r3] = r4
                    r3 = 9
                    java.lang.String r4 = "zzk"
                    r2[r3] = r4
                    r3 = 10
                    com.google.android.gms.internal.mlkit_common.zzfd r4 = com.google.android.gms.internal.mlkit_common.zzaa.zzao.zzb.zzb()
                    r2[r3] = r4
                    java.lang.String r3 = "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0002\u0000\u0001ဌ\u0000\u0002ဇ\u0001\u0003ဇ\u0002\u0004ဉ\u0003\u0005ဉ\u0004\u0006\u001e\u0007\u001e"
                    com.google.android.gms.internal.mlkit_common.zzaa$zzc$zza r4 = com.google.android.gms.internal.mlkit_common.zzaa.zzc.zza.zzm
                    java.lang.Object r2 = com.google.android.gms.internal.mlkit_common.zzez.zza(r4, r3, r2)
                    return r2
                L_0x007f:
                    com.google.android.gms.internal.mlkit_common.zzaa$zzc$zza$zza r2 = new com.google.android.gms.internal.mlkit_common.zzaa$zzc$zza$zza
                    r2.<init>(r3)
                    return r2
                L_0x0085:
                    com.google.android.gms.internal.mlkit_common.zzaa$zzc$zza r2 = new com.google.android.gms.internal.mlkit_common.zzaa$zzc$zza
                    r2.<init>()
                    return r2
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzaa.zzc.zza.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
            }
        }
    }

    /* compiled from: com.google.mlkit:common@@16.0.0 */
    /* loaded from: classes.dex */
    public static final class zzd extends zzez<zzd, zzb> implements zzgj {
        private static final zzd zzg;
        private static volatile zzgr<zzd> zzh;
        private int zzc;
        private zza zzd;
        private int zze;
        private zzab zzf;

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        /* loaded from: classes.dex */
        public static final class zzb extends zzez.zza<zzd, zzb> implements zzgj {
            private zzb() {
                super(zzd.zzg);
            }

            /* synthetic */ zzb(zzac zzacVar) {
                this();
            }
        }

        static {
            zzd zzdVar = new zzd();
            zzg = zzdVar;
            zzez.zza(zzd.class, zzdVar);
        }

        private zzd() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_common.zzez$zzc, com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzd>] */
        /* JADX WARN: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_common.zzez
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_common.zzac.zza
                r4 = 1
                int r2 = r2 - r4
                r2 = r3[r2]
                r3 = 0
                switch(r2) {
                    case 1: goto L_0x0058;
                    case 2: goto L_0x0052;
                    case 3: goto L_0x0033;
                    case 4: goto L_0x0030;
                    case 5: goto L_0x0016;
                    case 6: goto L_0x0011;
                    case 7: goto L_0x0010;
                    default: goto L_0x000a;
                }
            L_0x000a:
                java.lang.UnsupportedOperationException r2 = new java.lang.UnsupportedOperationException
                r2.<init>()
                throw r2
            L_0x0010:
                return r3
            L_0x0011:
                java.lang.Byte r2 = java.lang.Byte.valueOf(r4)
                return r2
            L_0x0016:
                com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzd> r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzd.zzh
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_common.zzaa$zzd> r3 = com.google.android.gms.internal.mlkit_common.zzaa.zzd.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzd> r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzd.zzh     // Catch: all -> 0x002c
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_common.zzez$zzc r2 = new com.google.android.gms.internal.mlkit_common.zzez$zzc     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_common.zzaa$zzd r4 = com.google.android.gms.internal.mlkit_common.zzaa.zzd.zzg     // Catch: all -> 0x002c
                r2.<init>(r4)     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_common.zzaa.zzd.zzh = r2     // Catch: all -> 0x002c
            L_0x002a:
                monitor-exit(r3)     // Catch: all -> 0x002c
                goto L_0x002f
            L_0x002c:
                r2 = move-exception
                monitor-exit(r3)     // Catch: all -> 0x002c
                throw r2
            L_0x002f:
                return r2
            L_0x0030:
                com.google.android.gms.internal.mlkit_common.zzaa$zzd r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzd.zzg
                return r2
            L_0x0033:
                r2 = 4
                java.lang.Object[] r2 = new java.lang.Object[r2]
                r3 = 0
                java.lang.String r0 = "zzc"
                r2[r3] = r0
                java.lang.String r3 = "zzd"
                r2[r4] = r3
                r3 = 2
                java.lang.String r4 = "zze"
                r2[r3] = r4
                r3 = 3
                java.lang.String r4 = "zzf"
                r2[r3] = r4
                java.lang.String r3 = "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဋ\u0001\u0003ဉ\u0002"
                com.google.android.gms.internal.mlkit_common.zzaa$zzd r4 = com.google.android.gms.internal.mlkit_common.zzaa.zzd.zzg
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_common.zzez.zza(r4, r3, r2)
                return r2
            L_0x0052:
                com.google.android.gms.internal.mlkit_common.zzaa$zzd$zzb r2 = new com.google.android.gms.internal.mlkit_common.zzaa$zzd$zzb
                r2.<init>(r3)
                return r2
            L_0x0058:
                com.google.android.gms.internal.mlkit_common.zzaa$zzd r2 = new com.google.android.gms.internal.mlkit_common.zzaa$zzd
                r2.<init>()
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzaa.zzd.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        /* loaded from: classes.dex */
        public static final class zza extends zzez<zza, C0107zza> implements zzgj {
            private static final zza zzj;
            private static volatile zzgr<zza> zzk;
            private int zzc;
            private int zzd;
            private boolean zze;
            private zzae zzf;
            private zzac zzg;
            private int zzh;
            private int zzi;

            /* compiled from: com.google.mlkit:common@@16.0.0 */
            /* renamed from: com.google.android.gms.internal.mlkit_common.zzaa$zzd$zza$zza  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            public static final class C0107zza extends zzez.zza<zza, C0107zza> implements zzgj {
                private C0107zza() {
                    super(zza.zzj);
                }

                /* synthetic */ C0107zza(zzac zzacVar) {
                    this();
                }
            }

            static {
                zza zzaVar = new zza();
                zzj = zzaVar;
                zzez.zza(zza.class, zzaVar);
            }

            private zza() {
            }

            /* JADX INFO: Access modifiers changed from: protected */
            /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzd$zza>, com.google.android.gms.internal.mlkit_common.zzez$zzc] */
            /* JADX WARN: Unknown variable types count: 1 */
            @Override // com.google.android.gms.internal.mlkit_common.zzez
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
                /*
                    r1 = this;
                    int[] r3 = com.google.android.gms.internal.mlkit_common.zzac.zza
                    r4 = 1
                    int r2 = r2 - r4
                    r2 = r3[r2]
                    r3 = 0
                    switch(r2) {
                        case 1: goto L_0x006f;
                        case 2: goto L_0x0069;
                        case 3: goto L_0x0033;
                        case 4: goto L_0x0030;
                        case 5: goto L_0x0016;
                        case 6: goto L_0x0011;
                        case 7: goto L_0x0010;
                        default: goto L_0x000a;
                    }
                L_0x000a:
                    java.lang.UnsupportedOperationException r2 = new java.lang.UnsupportedOperationException
                    r2.<init>()
                    throw r2
                L_0x0010:
                    return r3
                L_0x0011:
                    java.lang.Byte r2 = java.lang.Byte.valueOf(r4)
                    return r2
                L_0x0016:
                    com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzd$zza> r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzd.zza.zzk
                    if (r2 != 0) goto L_0x002f
                    java.lang.Class<com.google.android.gms.internal.mlkit_common.zzaa$zzd$zza> r3 = com.google.android.gms.internal.mlkit_common.zzaa.zzd.zza.class
                    monitor-enter(r3)
                    com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzd$zza> r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzd.zza.zzk     // Catch: all -> 0x002c
                    if (r2 != 0) goto L_0x002a
                    com.google.android.gms.internal.mlkit_common.zzez$zzc r2 = new com.google.android.gms.internal.mlkit_common.zzez$zzc     // Catch: all -> 0x002c
                    com.google.android.gms.internal.mlkit_common.zzaa$zzd$zza r4 = com.google.android.gms.internal.mlkit_common.zzaa.zzd.zza.zzj     // Catch: all -> 0x002c
                    r2.<init>(r4)     // Catch: all -> 0x002c
                    com.google.android.gms.internal.mlkit_common.zzaa.zzd.zza.zzk = r2     // Catch: all -> 0x002c
                L_0x002a:
                    monitor-exit(r3)     // Catch: all -> 0x002c
                    goto L_0x002f
                L_0x002c:
                    r2 = move-exception
                    monitor-exit(r3)     // Catch: all -> 0x002c
                    throw r2
                L_0x002f:
                    return r2
                L_0x0030:
                    com.google.android.gms.internal.mlkit_common.zzaa$zzd$zza r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzd.zza.zzj
                    return r2
                L_0x0033:
                    r2 = 8
                    java.lang.Object[] r2 = new java.lang.Object[r2]
                    r3 = 0
                    java.lang.String r0 = "zzc"
                    r2[r3] = r0
                    java.lang.String r3 = "zzd"
                    r2[r4] = r3
                    r3 = 2
                    com.google.android.gms.internal.mlkit_common.zzfd r4 = com.google.android.gms.internal.mlkit_common.zzal.zzb()
                    r2[r3] = r4
                    r3 = 3
                    java.lang.String r4 = "zze"
                    r2[r3] = r4
                    r3 = 4
                    java.lang.String r4 = "zzf"
                    r2[r3] = r4
                    r3 = 5
                    java.lang.String r4 = "zzg"
                    r2[r3] = r4
                    r3 = 6
                    java.lang.String r4 = "zzh"
                    r2[r3] = r4
                    r3 = 7
                    java.lang.String r4 = "zzi"
                    r2[r3] = r4
                    java.lang.String r3 = "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဇ\u0001\u0003ဉ\u0002\u0004ဉ\u0003\u0005ဋ\u0004\u0006ဋ\u0005"
                    com.google.android.gms.internal.mlkit_common.zzaa$zzd$zza r4 = com.google.android.gms.internal.mlkit_common.zzaa.zzd.zza.zzj
                    java.lang.Object r2 = com.google.android.gms.internal.mlkit_common.zzez.zza(r4, r3, r2)
                    return r2
                L_0x0069:
                    com.google.android.gms.internal.mlkit_common.zzaa$zzd$zza$zza r2 = new com.google.android.gms.internal.mlkit_common.zzaa$zzd$zza$zza
                    r2.<init>(r3)
                    return r2
                L_0x006f:
                    com.google.android.gms.internal.mlkit_common.zzaa$zzd$zza r2 = new com.google.android.gms.internal.mlkit_common.zzaa$zzd$zza
                    r2.<init>()
                    return r2
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzaa.zzd.zza.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
            }
        }
    }

    /* compiled from: com.google.mlkit:common@@16.0.0 */
    /* loaded from: classes.dex */
    public static final class zze extends zzez<zze, zzb> implements zzgj {
        private static final zze zzg;
        private static volatile zzgr<zze> zzh;
        private int zzc;
        private zza zzd;
        private int zze;
        private zzab zzf;

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        /* loaded from: classes.dex */
        public static final class zzb extends zzez.zza<zze, zzb> implements zzgj {
            private zzb() {
                super(zze.zzg);
            }

            /* synthetic */ zzb(zzac zzacVar) {
                this();
            }
        }

        static {
            zze zzeVar = new zze();
            zzg = zzeVar;
            zzez.zza(zze.class, zzeVar);
        }

        private zze() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_common.zzez$zzc, com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zze>] */
        /* JADX WARN: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_common.zzez
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_common.zzac.zza
                r4 = 1
                int r2 = r2 - r4
                r2 = r3[r2]
                r3 = 0
                switch(r2) {
                    case 1: goto L_0x0058;
                    case 2: goto L_0x0052;
                    case 3: goto L_0x0033;
                    case 4: goto L_0x0030;
                    case 5: goto L_0x0016;
                    case 6: goto L_0x0011;
                    case 7: goto L_0x0010;
                    default: goto L_0x000a;
                }
            L_0x000a:
                java.lang.UnsupportedOperationException r2 = new java.lang.UnsupportedOperationException
                r2.<init>()
                throw r2
            L_0x0010:
                return r3
            L_0x0011:
                java.lang.Byte r2 = java.lang.Byte.valueOf(r4)
                return r2
            L_0x0016:
                com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zze> r2 = com.google.android.gms.internal.mlkit_common.zzaa.zze.zzh
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_common.zzaa$zze> r3 = com.google.android.gms.internal.mlkit_common.zzaa.zze.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zze> r2 = com.google.android.gms.internal.mlkit_common.zzaa.zze.zzh     // Catch: all -> 0x002c
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_common.zzez$zzc r2 = new com.google.android.gms.internal.mlkit_common.zzez$zzc     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_common.zzaa$zze r4 = com.google.android.gms.internal.mlkit_common.zzaa.zze.zzg     // Catch: all -> 0x002c
                r2.<init>(r4)     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_common.zzaa.zze.zzh = r2     // Catch: all -> 0x002c
            L_0x002a:
                monitor-exit(r3)     // Catch: all -> 0x002c
                goto L_0x002f
            L_0x002c:
                r2 = move-exception
                monitor-exit(r3)     // Catch: all -> 0x002c
                throw r2
            L_0x002f:
                return r2
            L_0x0030:
                com.google.android.gms.internal.mlkit_common.zzaa$zze r2 = com.google.android.gms.internal.mlkit_common.zzaa.zze.zzg
                return r2
            L_0x0033:
                r2 = 4
                java.lang.Object[] r2 = new java.lang.Object[r2]
                r3 = 0
                java.lang.String r0 = "zzc"
                r2[r3] = r0
                java.lang.String r3 = "zzd"
                r2[r4] = r3
                r3 = 2
                java.lang.String r4 = "zze"
                r2[r3] = r4
                r3 = 3
                java.lang.String r4 = "zzf"
                r2[r3] = r4
                java.lang.String r3 = "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဋ\u0001\u0003ဉ\u0002"
                com.google.android.gms.internal.mlkit_common.zzaa$zze r4 = com.google.android.gms.internal.mlkit_common.zzaa.zze.zzg
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_common.zzez.zza(r4, r3, r2)
                return r2
            L_0x0052:
                com.google.android.gms.internal.mlkit_common.zzaa$zze$zzb r2 = new com.google.android.gms.internal.mlkit_common.zzaa$zze$zzb
                r2.<init>(r3)
                return r2
            L_0x0058:
                com.google.android.gms.internal.mlkit_common.zzaa$zze r2 = new com.google.android.gms.internal.mlkit_common.zzaa$zze
                r2.<init>()
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzaa.zze.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        /* loaded from: classes.dex */
        public static final class zza extends zzez<zza, C0108zza> implements zzgj {
            private static final zza zzh;
            private static volatile zzgr<zza> zzi;
            private int zzc;
            private int zzd;
            private boolean zze;
            private zzae zzf;
            private zzat zzg;

            /* compiled from: com.google.mlkit:common@@16.0.0 */
            /* renamed from: com.google.android.gms.internal.mlkit_common.zzaa$zze$zza$zza  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            public static final class C0108zza extends zzez.zza<zza, C0108zza> implements zzgj {
                private C0108zza() {
                    super(zza.zzh);
                }

                /* synthetic */ C0108zza(zzac zzacVar) {
                    this();
                }
            }

            static {
                zza zzaVar = new zza();
                zzh = zzaVar;
                zzez.zza(zza.class, zzaVar);
            }

            private zza() {
            }

            /* JADX INFO: Access modifiers changed from: protected */
            /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_common.zzez$zzc, com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zze$zza>] */
            /* JADX WARN: Unknown variable types count: 1 */
            @Override // com.google.android.gms.internal.mlkit_common.zzez
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
                /*
                    r1 = this;
                    int[] r3 = com.google.android.gms.internal.mlkit_common.zzac.zza
                    r4 = 1
                    int r2 = r2 - r4
                    r2 = r3[r2]
                    r3 = 0
                    switch(r2) {
                        case 1: goto L_0x0064;
                        case 2: goto L_0x005e;
                        case 3: goto L_0x0033;
                        case 4: goto L_0x0030;
                        case 5: goto L_0x0016;
                        case 6: goto L_0x0011;
                        case 7: goto L_0x0010;
                        default: goto L_0x000a;
                    }
                L_0x000a:
                    java.lang.UnsupportedOperationException r2 = new java.lang.UnsupportedOperationException
                    r2.<init>()
                    throw r2
                L_0x0010:
                    return r3
                L_0x0011:
                    java.lang.Byte r2 = java.lang.Byte.valueOf(r4)
                    return r2
                L_0x0016:
                    com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zze$zza> r2 = com.google.android.gms.internal.mlkit_common.zzaa.zze.zza.zzi
                    if (r2 != 0) goto L_0x002f
                    java.lang.Class<com.google.android.gms.internal.mlkit_common.zzaa$zze$zza> r3 = com.google.android.gms.internal.mlkit_common.zzaa.zze.zza.class
                    monitor-enter(r3)
                    com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zze$zza> r2 = com.google.android.gms.internal.mlkit_common.zzaa.zze.zza.zzi     // Catch: all -> 0x002c
                    if (r2 != 0) goto L_0x002a
                    com.google.android.gms.internal.mlkit_common.zzez$zzc r2 = new com.google.android.gms.internal.mlkit_common.zzez$zzc     // Catch: all -> 0x002c
                    com.google.android.gms.internal.mlkit_common.zzaa$zze$zza r4 = com.google.android.gms.internal.mlkit_common.zzaa.zze.zza.zzh     // Catch: all -> 0x002c
                    r2.<init>(r4)     // Catch: all -> 0x002c
                    com.google.android.gms.internal.mlkit_common.zzaa.zze.zza.zzi = r2     // Catch: all -> 0x002c
                L_0x002a:
                    monitor-exit(r3)     // Catch: all -> 0x002c
                    goto L_0x002f
                L_0x002c:
                    r2 = move-exception
                    monitor-exit(r3)     // Catch: all -> 0x002c
                    throw r2
                L_0x002f:
                    return r2
                L_0x0030:
                    com.google.android.gms.internal.mlkit_common.zzaa$zze$zza r2 = com.google.android.gms.internal.mlkit_common.zzaa.zze.zza.zzh
                    return r2
                L_0x0033:
                    r2 = 6
                    java.lang.Object[] r2 = new java.lang.Object[r2]
                    r3 = 0
                    java.lang.String r0 = "zzc"
                    r2[r3] = r0
                    java.lang.String r3 = "zzd"
                    r2[r4] = r3
                    r3 = 2
                    com.google.android.gms.internal.mlkit_common.zzfd r4 = com.google.android.gms.internal.mlkit_common.zzal.zzb()
                    r2[r3] = r4
                    r3 = 3
                    java.lang.String r4 = "zze"
                    r2[r3] = r4
                    r3 = 4
                    java.lang.String r4 = "zzf"
                    r2[r3] = r4
                    r3 = 5
                    java.lang.String r4 = "zzg"
                    r2[r3] = r4
                    java.lang.String r3 = "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဇ\u0001\u0003ဉ\u0002\u0004ဉ\u0003"
                    com.google.android.gms.internal.mlkit_common.zzaa$zze$zza r4 = com.google.android.gms.internal.mlkit_common.zzaa.zze.zza.zzh
                    java.lang.Object r2 = com.google.android.gms.internal.mlkit_common.zzez.zza(r4, r3, r2)
                    return r2
                L_0x005e:
                    com.google.android.gms.internal.mlkit_common.zzaa$zze$zza$zza r2 = new com.google.android.gms.internal.mlkit_common.zzaa$zze$zza$zza
                    r2.<init>(r3)
                    return r2
                L_0x0064:
                    com.google.android.gms.internal.mlkit_common.zzaa$zze$zza r2 = new com.google.android.gms.internal.mlkit_common.zzaa$zze$zza
                    r2.<init>()
                    return r2
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzaa.zze.zza.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
            }
        }
    }

    /* compiled from: com.google.mlkit:common@@16.0.0 */
    /* loaded from: classes.dex */
    public static final class zzf extends zzez<zzf, zzb> implements zzgj {
        private static final zzf zzg;
        private static volatile zzgr<zzf> zzh;
        private int zzc;
        private zza zzd;
        private int zze;
        private zzab zzf;

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        /* loaded from: classes.dex */
        public static final class zzb extends zzez.zza<zzf, zzb> implements zzgj {
            private zzb() {
                super(zzf.zzg);
            }

            /* synthetic */ zzb(zzac zzacVar) {
                this();
            }
        }

        static {
            zzf zzfVar = new zzf();
            zzg = zzfVar;
            zzez.zza(zzf.class, zzfVar);
        }

        private zzf() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_common.zzez$zzc, com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzf>] */
        /* JADX WARN: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_common.zzez
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_common.zzac.zza
                r4 = 1
                int r2 = r2 - r4
                r2 = r3[r2]
                r3 = 0
                switch(r2) {
                    case 1: goto L_0x0058;
                    case 2: goto L_0x0052;
                    case 3: goto L_0x0033;
                    case 4: goto L_0x0030;
                    case 5: goto L_0x0016;
                    case 6: goto L_0x0011;
                    case 7: goto L_0x0010;
                    default: goto L_0x000a;
                }
            L_0x000a:
                java.lang.UnsupportedOperationException r2 = new java.lang.UnsupportedOperationException
                r2.<init>()
                throw r2
            L_0x0010:
                return r3
            L_0x0011:
                java.lang.Byte r2 = java.lang.Byte.valueOf(r4)
                return r2
            L_0x0016:
                com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzf> r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzf.zzh
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_common.zzaa$zzf> r3 = com.google.android.gms.internal.mlkit_common.zzaa.zzf.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzf> r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzf.zzh     // Catch: all -> 0x002c
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_common.zzez$zzc r2 = new com.google.android.gms.internal.mlkit_common.zzez$zzc     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_common.zzaa$zzf r4 = com.google.android.gms.internal.mlkit_common.zzaa.zzf.zzg     // Catch: all -> 0x002c
                r2.<init>(r4)     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_common.zzaa.zzf.zzh = r2     // Catch: all -> 0x002c
            L_0x002a:
                monitor-exit(r3)     // Catch: all -> 0x002c
                goto L_0x002f
            L_0x002c:
                r2 = move-exception
                monitor-exit(r3)     // Catch: all -> 0x002c
                throw r2
            L_0x002f:
                return r2
            L_0x0030:
                com.google.android.gms.internal.mlkit_common.zzaa$zzf r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzf.zzg
                return r2
            L_0x0033:
                r2 = 4
                java.lang.Object[] r2 = new java.lang.Object[r2]
                r3 = 0
                java.lang.String r0 = "zzc"
                r2[r3] = r0
                java.lang.String r3 = "zzd"
                r2[r4] = r3
                r3 = 2
                java.lang.String r4 = "zze"
                r2[r3] = r4
                r3 = 3
                java.lang.String r4 = "zzf"
                r2[r3] = r4
                java.lang.String r3 = "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဋ\u0001\u0003ဉ\u0002"
                com.google.android.gms.internal.mlkit_common.zzaa$zzf r4 = com.google.android.gms.internal.mlkit_common.zzaa.zzf.zzg
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_common.zzez.zza(r4, r3, r2)
                return r2
            L_0x0052:
                com.google.android.gms.internal.mlkit_common.zzaa$zzf$zzb r2 = new com.google.android.gms.internal.mlkit_common.zzaa$zzf$zzb
                r2.<init>(r3)
                return r2
            L_0x0058:
                com.google.android.gms.internal.mlkit_common.zzaa$zzf r2 = new com.google.android.gms.internal.mlkit_common.zzaa$zzf
                r2.<init>()
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzaa.zzf.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        /* loaded from: classes.dex */
        public static final class zza extends zzez<zza, C0109zza> implements zzgj {
            private static final zza zzi;
            private static volatile zzgr<zza> zzj;
            private int zzc;
            private int zzd;
            private boolean zze;
            private boolean zzf;
            private zzae zzg;
            private zzaw zzh;

            /* compiled from: com.google.mlkit:common@@16.0.0 */
            /* renamed from: com.google.android.gms.internal.mlkit_common.zzaa$zzf$zza$zza  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            public static final class C0109zza extends zzez.zza<zza, C0109zza> implements zzgj {
                private C0109zza() {
                    super(zza.zzi);
                }

                /* synthetic */ C0109zza(zzac zzacVar) {
                    this();
                }
            }

            static {
                zza zzaVar = new zza();
                zzi = zzaVar;
                zzez.zza(zza.class, zzaVar);
            }

            private zza() {
            }

            /* JADX INFO: Access modifiers changed from: protected */
            /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzf$zza>, com.google.android.gms.internal.mlkit_common.zzez$zzc] */
            /* JADX WARN: Unknown variable types count: 1 */
            @Override // com.google.android.gms.internal.mlkit_common.zzez
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
                /*
                    r1 = this;
                    int[] r3 = com.google.android.gms.internal.mlkit_common.zzac.zza
                    r4 = 1
                    int r2 = r2 - r4
                    r2 = r3[r2]
                    r3 = 0
                    switch(r2) {
                        case 1: goto L_0x0069;
                        case 2: goto L_0x0063;
                        case 3: goto L_0x0033;
                        case 4: goto L_0x0030;
                        case 5: goto L_0x0016;
                        case 6: goto L_0x0011;
                        case 7: goto L_0x0010;
                        default: goto L_0x000a;
                    }
                L_0x000a:
                    java.lang.UnsupportedOperationException r2 = new java.lang.UnsupportedOperationException
                    r2.<init>()
                    throw r2
                L_0x0010:
                    return r3
                L_0x0011:
                    java.lang.Byte r2 = java.lang.Byte.valueOf(r4)
                    return r2
                L_0x0016:
                    com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzf$zza> r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzf.zza.zzj
                    if (r2 != 0) goto L_0x002f
                    java.lang.Class<com.google.android.gms.internal.mlkit_common.zzaa$zzf$zza> r3 = com.google.android.gms.internal.mlkit_common.zzaa.zzf.zza.class
                    monitor-enter(r3)
                    com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzf$zza> r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzf.zza.zzj     // Catch: all -> 0x002c
                    if (r2 != 0) goto L_0x002a
                    com.google.android.gms.internal.mlkit_common.zzez$zzc r2 = new com.google.android.gms.internal.mlkit_common.zzez$zzc     // Catch: all -> 0x002c
                    com.google.android.gms.internal.mlkit_common.zzaa$zzf$zza r4 = com.google.android.gms.internal.mlkit_common.zzaa.zzf.zza.zzi     // Catch: all -> 0x002c
                    r2.<init>(r4)     // Catch: all -> 0x002c
                    com.google.android.gms.internal.mlkit_common.zzaa.zzf.zza.zzj = r2     // Catch: all -> 0x002c
                L_0x002a:
                    monitor-exit(r3)     // Catch: all -> 0x002c
                    goto L_0x002f
                L_0x002c:
                    r2 = move-exception
                    monitor-exit(r3)     // Catch: all -> 0x002c
                    throw r2
                L_0x002f:
                    return r2
                L_0x0030:
                    com.google.android.gms.internal.mlkit_common.zzaa$zzf$zza r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzf.zza.zzi
                    return r2
                L_0x0033:
                    r2 = 7
                    java.lang.Object[] r2 = new java.lang.Object[r2]
                    r3 = 0
                    java.lang.String r0 = "zzc"
                    r2[r3] = r0
                    java.lang.String r3 = "zzd"
                    r2[r4] = r3
                    r3 = 2
                    com.google.android.gms.internal.mlkit_common.zzfd r4 = com.google.android.gms.internal.mlkit_common.zzal.zzb()
                    r2[r3] = r4
                    r3 = 3
                    java.lang.String r4 = "zze"
                    r2[r3] = r4
                    r3 = 4
                    java.lang.String r4 = "zzf"
                    r2[r3] = r4
                    r3 = 5
                    java.lang.String r4 = "zzg"
                    r2[r3] = r4
                    r3 = 6
                    java.lang.String r4 = "zzh"
                    r2[r3] = r4
                    java.lang.String r3 = "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဇ\u0001\u0003ဇ\u0002\u0004ဉ\u0003\u0005ဉ\u0004"
                    com.google.android.gms.internal.mlkit_common.zzaa$zzf$zza r4 = com.google.android.gms.internal.mlkit_common.zzaa.zzf.zza.zzi
                    java.lang.Object r2 = com.google.android.gms.internal.mlkit_common.zzez.zza(r4, r3, r2)
                    return r2
                L_0x0063:
                    com.google.android.gms.internal.mlkit_common.zzaa$zzf$zza$zza r2 = new com.google.android.gms.internal.mlkit_common.zzaa$zzf$zza$zza
                    r2.<init>(r3)
                    return r2
                L_0x0069:
                    com.google.android.gms.internal.mlkit_common.zzaa$zzf$zza r2 = new com.google.android.gms.internal.mlkit_common.zzaa$zzf$zza
                    r2.<init>()
                    return r2
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzaa.zzf.zza.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
            }
        }
    }

    /* compiled from: com.google.mlkit:common@@16.0.0 */
    /* loaded from: classes.dex */
    public static final class zzg extends zzez<zzg, zzb> implements zzgj {
        private static final zzg zzg;
        private static volatile zzgr<zzg> zzh;
        private int zzc;
        private zza zzd;
        private int zze;
        private zzab zzf;

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        /* loaded from: classes.dex */
        public static final class zzb extends zzez.zza<zzg, zzb> implements zzgj {
            private zzb() {
                super(zzg.zzg);
            }

            /* synthetic */ zzb(zzac zzacVar) {
                this();
            }
        }

        static {
            zzg zzgVar = new zzg();
            zzg = zzgVar;
            zzez.zza(zzg.class, zzgVar);
        }

        private zzg() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_common.zzez$zzc, com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzg>] */
        /* JADX WARN: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_common.zzez
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_common.zzac.zza
                r4 = 1
                int r2 = r2 - r4
                r2 = r3[r2]
                r3 = 0
                switch(r2) {
                    case 1: goto L_0x0058;
                    case 2: goto L_0x0052;
                    case 3: goto L_0x0033;
                    case 4: goto L_0x0030;
                    case 5: goto L_0x0016;
                    case 6: goto L_0x0011;
                    case 7: goto L_0x0010;
                    default: goto L_0x000a;
                }
            L_0x000a:
                java.lang.UnsupportedOperationException r2 = new java.lang.UnsupportedOperationException
                r2.<init>()
                throw r2
            L_0x0010:
                return r3
            L_0x0011:
                java.lang.Byte r2 = java.lang.Byte.valueOf(r4)
                return r2
            L_0x0016:
                com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzg> r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzg.zzh
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_common.zzaa$zzg> r3 = com.google.android.gms.internal.mlkit_common.zzaa.zzg.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzg> r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzg.zzh     // Catch: all -> 0x002c
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_common.zzez$zzc r2 = new com.google.android.gms.internal.mlkit_common.zzez$zzc     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_common.zzaa$zzg r4 = com.google.android.gms.internal.mlkit_common.zzaa.zzg.zzg     // Catch: all -> 0x002c
                r2.<init>(r4)     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_common.zzaa.zzg.zzh = r2     // Catch: all -> 0x002c
            L_0x002a:
                monitor-exit(r3)     // Catch: all -> 0x002c
                goto L_0x002f
            L_0x002c:
                r2 = move-exception
                monitor-exit(r3)     // Catch: all -> 0x002c
                throw r2
            L_0x002f:
                return r2
            L_0x0030:
                com.google.android.gms.internal.mlkit_common.zzaa$zzg r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzg.zzg
                return r2
            L_0x0033:
                r2 = 4
                java.lang.Object[] r2 = new java.lang.Object[r2]
                r3 = 0
                java.lang.String r0 = "zzc"
                r2[r3] = r0
                java.lang.String r3 = "zzd"
                r2[r4] = r3
                r3 = 2
                java.lang.String r4 = "zze"
                r2[r3] = r4
                r3 = 3
                java.lang.String r4 = "zzf"
                r2[r3] = r4
                java.lang.String r3 = "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဋ\u0001\u0003ဉ\u0002"
                com.google.android.gms.internal.mlkit_common.zzaa$zzg r4 = com.google.android.gms.internal.mlkit_common.zzaa.zzg.zzg
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_common.zzez.zza(r4, r3, r2)
                return r2
            L_0x0052:
                com.google.android.gms.internal.mlkit_common.zzaa$zzg$zzb r2 = new com.google.android.gms.internal.mlkit_common.zzaa$zzg$zzb
                r2.<init>(r3)
                return r2
            L_0x0058:
                com.google.android.gms.internal.mlkit_common.zzaa$zzg r2 = new com.google.android.gms.internal.mlkit_common.zzaa$zzg
                r2.<init>()
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzaa.zzg.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        /* loaded from: classes.dex */
        public static final class zza extends zzez<zza, C0110zza> implements zzgj {
            private static final zza zzh;
            private static volatile zzgr<zza> zzi;
            private int zzc;
            private int zzd;
            private boolean zze;
            private zzae zzf;
            private zzba zzg;

            /* compiled from: com.google.mlkit:common@@16.0.0 */
            /* renamed from: com.google.android.gms.internal.mlkit_common.zzaa$zzg$zza$zza  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            public static final class C0110zza extends zzez.zza<zza, C0110zza> implements zzgj {
                private C0110zza() {
                    super(zza.zzh);
                }

                /* synthetic */ C0110zza(zzac zzacVar) {
                    this();
                }
            }

            static {
                zza zzaVar = new zza();
                zzh = zzaVar;
                zzez.zza(zza.class, zzaVar);
            }

            private zza() {
            }

            /* JADX INFO: Access modifiers changed from: protected */
            /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzg$zza>, com.google.android.gms.internal.mlkit_common.zzez$zzc] */
            /* JADX WARN: Unknown variable types count: 1 */
            @Override // com.google.android.gms.internal.mlkit_common.zzez
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
                /*
                    r1 = this;
                    int[] r3 = com.google.android.gms.internal.mlkit_common.zzac.zza
                    r4 = 1
                    int r2 = r2 - r4
                    r2 = r3[r2]
                    r3 = 0
                    switch(r2) {
                        case 1: goto L_0x0064;
                        case 2: goto L_0x005e;
                        case 3: goto L_0x0033;
                        case 4: goto L_0x0030;
                        case 5: goto L_0x0016;
                        case 6: goto L_0x0011;
                        case 7: goto L_0x0010;
                        default: goto L_0x000a;
                    }
                L_0x000a:
                    java.lang.UnsupportedOperationException r2 = new java.lang.UnsupportedOperationException
                    r2.<init>()
                    throw r2
                L_0x0010:
                    return r3
                L_0x0011:
                    java.lang.Byte r2 = java.lang.Byte.valueOf(r4)
                    return r2
                L_0x0016:
                    com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzg$zza> r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzg.zza.zzi
                    if (r2 != 0) goto L_0x002f
                    java.lang.Class<com.google.android.gms.internal.mlkit_common.zzaa$zzg$zza> r3 = com.google.android.gms.internal.mlkit_common.zzaa.zzg.zza.class
                    monitor-enter(r3)
                    com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzg$zza> r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzg.zza.zzi     // Catch: all -> 0x002c
                    if (r2 != 0) goto L_0x002a
                    com.google.android.gms.internal.mlkit_common.zzez$zzc r2 = new com.google.android.gms.internal.mlkit_common.zzez$zzc     // Catch: all -> 0x002c
                    com.google.android.gms.internal.mlkit_common.zzaa$zzg$zza r4 = com.google.android.gms.internal.mlkit_common.zzaa.zzg.zza.zzh     // Catch: all -> 0x002c
                    r2.<init>(r4)     // Catch: all -> 0x002c
                    com.google.android.gms.internal.mlkit_common.zzaa.zzg.zza.zzi = r2     // Catch: all -> 0x002c
                L_0x002a:
                    monitor-exit(r3)     // Catch: all -> 0x002c
                    goto L_0x002f
                L_0x002c:
                    r2 = move-exception
                    monitor-exit(r3)     // Catch: all -> 0x002c
                    throw r2
                L_0x002f:
                    return r2
                L_0x0030:
                    com.google.android.gms.internal.mlkit_common.zzaa$zzg$zza r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzg.zza.zzh
                    return r2
                L_0x0033:
                    r2 = 6
                    java.lang.Object[] r2 = new java.lang.Object[r2]
                    r3 = 0
                    java.lang.String r0 = "zzc"
                    r2[r3] = r0
                    java.lang.String r3 = "zzd"
                    r2[r4] = r3
                    r3 = 2
                    com.google.android.gms.internal.mlkit_common.zzfd r4 = com.google.android.gms.internal.mlkit_common.zzal.zzb()
                    r2[r3] = r4
                    r3 = 3
                    java.lang.String r4 = "zze"
                    r2[r3] = r4
                    r3 = 4
                    java.lang.String r4 = "zzf"
                    r2[r3] = r4
                    r3 = 5
                    java.lang.String r4 = "zzg"
                    r2[r3] = r4
                    java.lang.String r3 = "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဇ\u0001\u0003ဉ\u0002\u0004ဉ\u0003"
                    com.google.android.gms.internal.mlkit_common.zzaa$zzg$zza r4 = com.google.android.gms.internal.mlkit_common.zzaa.zzg.zza.zzh
                    java.lang.Object r2 = com.google.android.gms.internal.mlkit_common.zzez.zza(r4, r3, r2)
                    return r2
                L_0x005e:
                    com.google.android.gms.internal.mlkit_common.zzaa$zzg$zza$zza r2 = new com.google.android.gms.internal.mlkit_common.zzaa$zzg$zza$zza
                    r2.<init>(r3)
                    return r2
                L_0x0064:
                    com.google.android.gms.internal.mlkit_common.zzaa$zzg$zza r2 = new com.google.android.gms.internal.mlkit_common.zzaa$zzg$zza
                    r2.<init>()
                    return r2
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzaa.zzg.zza.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
            }
        }
    }

    /* compiled from: com.google.mlkit:common@@16.0.0 */
    /* loaded from: classes.dex */
    public static final class zzh extends zzez<zzh, zzb> implements zzgj {
        private static final zzh zzg;
        private static volatile zzgr<zzh> zzh;
        private int zzc;
        private zza zzd;
        private int zze;
        private zzab zzf;

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        /* loaded from: classes.dex */
        public static final class zzb extends zzez.zza<zzh, zzb> implements zzgj {
            private zzb() {
                super(zzh.zzg);
            }

            /* synthetic */ zzb(zzac zzacVar) {
                this();
            }
        }

        static {
            zzh zzhVar = new zzh();
            zzg = zzhVar;
            zzez.zza(zzh.class, zzhVar);
        }

        private zzh() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_common.zzez$zzc, com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzh>] */
        /* JADX WARN: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_common.zzez
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_common.zzac.zza
                r4 = 1
                int r2 = r2 - r4
                r2 = r3[r2]
                r3 = 0
                switch(r2) {
                    case 1: goto L_0x0058;
                    case 2: goto L_0x0052;
                    case 3: goto L_0x0033;
                    case 4: goto L_0x0030;
                    case 5: goto L_0x0016;
                    case 6: goto L_0x0011;
                    case 7: goto L_0x0010;
                    default: goto L_0x000a;
                }
            L_0x000a:
                java.lang.UnsupportedOperationException r2 = new java.lang.UnsupportedOperationException
                r2.<init>()
                throw r2
            L_0x0010:
                return r3
            L_0x0011:
                java.lang.Byte r2 = java.lang.Byte.valueOf(r4)
                return r2
            L_0x0016:
                com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzh> r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzh.zzh
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_common.zzaa$zzh> r3 = com.google.android.gms.internal.mlkit_common.zzaa.zzh.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzh> r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzh.zzh     // Catch: all -> 0x002c
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_common.zzez$zzc r2 = new com.google.android.gms.internal.mlkit_common.zzez$zzc     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_common.zzaa$zzh r4 = com.google.android.gms.internal.mlkit_common.zzaa.zzh.zzg     // Catch: all -> 0x002c
                r2.<init>(r4)     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_common.zzaa.zzh.zzh = r2     // Catch: all -> 0x002c
            L_0x002a:
                monitor-exit(r3)     // Catch: all -> 0x002c
                goto L_0x002f
            L_0x002c:
                r2 = move-exception
                monitor-exit(r3)     // Catch: all -> 0x002c
                throw r2
            L_0x002f:
                return r2
            L_0x0030:
                com.google.android.gms.internal.mlkit_common.zzaa$zzh r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzh.zzg
                return r2
            L_0x0033:
                r2 = 4
                java.lang.Object[] r2 = new java.lang.Object[r2]
                r3 = 0
                java.lang.String r0 = "zzc"
                r2[r3] = r0
                java.lang.String r3 = "zzd"
                r2[r4] = r3
                r3 = 2
                java.lang.String r4 = "zze"
                r2[r3] = r4
                r3 = 3
                java.lang.String r4 = "zzf"
                r2[r3] = r4
                java.lang.String r3 = "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဋ\u0001\u0003ဉ\u0002"
                com.google.android.gms.internal.mlkit_common.zzaa$zzh r4 = com.google.android.gms.internal.mlkit_common.zzaa.zzh.zzg
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_common.zzez.zza(r4, r3, r2)
                return r2
            L_0x0052:
                com.google.android.gms.internal.mlkit_common.zzaa$zzh$zzb r2 = new com.google.android.gms.internal.mlkit_common.zzaa$zzh$zzb
                r2.<init>(r3)
                return r2
            L_0x0058:
                com.google.android.gms.internal.mlkit_common.zzaa$zzh r2 = new com.google.android.gms.internal.mlkit_common.zzaa$zzh
                r2.<init>()
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzaa.zzh.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        /* loaded from: classes.dex */
        public static final class zza extends zzez<zza, C0111zza> implements zzgj {
            private static final zza zzg;
            private static volatile zzgr<zza> zzh;
            private int zzc;
            private int zzd;
            private boolean zze;
            private zzae zzf;

            /* compiled from: com.google.mlkit:common@@16.0.0 */
            /* renamed from: com.google.android.gms.internal.mlkit_common.zzaa$zzh$zza$zza  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            public static final class C0111zza extends zzez.zza<zza, C0111zza> implements zzgj {
                private C0111zza() {
                    super(zza.zzg);
                }

                /* synthetic */ C0111zza(zzac zzacVar) {
                    this();
                }
            }

            static {
                zza zzaVar = new zza();
                zzg = zzaVar;
                zzez.zza(zza.class, zzaVar);
            }

            private zza() {
            }

            /* JADX INFO: Access modifiers changed from: protected */
            /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_common.zzez$zzc, com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzh$zza>] */
            /* JADX WARN: Unknown variable types count: 1 */
            @Override // com.google.android.gms.internal.mlkit_common.zzez
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
                /*
                    r1 = this;
                    int[] r3 = com.google.android.gms.internal.mlkit_common.zzac.zza
                    r4 = 1
                    int r2 = r2 - r4
                    r2 = r3[r2]
                    r3 = 0
                    switch(r2) {
                        case 1: goto L_0x005f;
                        case 2: goto L_0x0059;
                        case 3: goto L_0x0033;
                        case 4: goto L_0x0030;
                        case 5: goto L_0x0016;
                        case 6: goto L_0x0011;
                        case 7: goto L_0x0010;
                        default: goto L_0x000a;
                    }
                L_0x000a:
                    java.lang.UnsupportedOperationException r2 = new java.lang.UnsupportedOperationException
                    r2.<init>()
                    throw r2
                L_0x0010:
                    return r3
                L_0x0011:
                    java.lang.Byte r2 = java.lang.Byte.valueOf(r4)
                    return r2
                L_0x0016:
                    com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzh$zza> r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzh.zza.zzh
                    if (r2 != 0) goto L_0x002f
                    java.lang.Class<com.google.android.gms.internal.mlkit_common.zzaa$zzh$zza> r3 = com.google.android.gms.internal.mlkit_common.zzaa.zzh.zza.class
                    monitor-enter(r3)
                    com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzh$zza> r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzh.zza.zzh     // Catch: all -> 0x002c
                    if (r2 != 0) goto L_0x002a
                    com.google.android.gms.internal.mlkit_common.zzez$zzc r2 = new com.google.android.gms.internal.mlkit_common.zzez$zzc     // Catch: all -> 0x002c
                    com.google.android.gms.internal.mlkit_common.zzaa$zzh$zza r4 = com.google.android.gms.internal.mlkit_common.zzaa.zzh.zza.zzg     // Catch: all -> 0x002c
                    r2.<init>(r4)     // Catch: all -> 0x002c
                    com.google.android.gms.internal.mlkit_common.zzaa.zzh.zza.zzh = r2     // Catch: all -> 0x002c
                L_0x002a:
                    monitor-exit(r3)     // Catch: all -> 0x002c
                    goto L_0x002f
                L_0x002c:
                    r2 = move-exception
                    monitor-exit(r3)     // Catch: all -> 0x002c
                    throw r2
                L_0x002f:
                    return r2
                L_0x0030:
                    com.google.android.gms.internal.mlkit_common.zzaa$zzh$zza r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzh.zza.zzg
                    return r2
                L_0x0033:
                    r2 = 5
                    java.lang.Object[] r2 = new java.lang.Object[r2]
                    r3 = 0
                    java.lang.String r0 = "zzc"
                    r2[r3] = r0
                    java.lang.String r3 = "zzd"
                    r2[r4] = r3
                    r3 = 2
                    com.google.android.gms.internal.mlkit_common.zzfd r4 = com.google.android.gms.internal.mlkit_common.zzal.zzb()
                    r2[r3] = r4
                    r3 = 3
                    java.lang.String r4 = "zze"
                    r2[r3] = r4
                    r3 = 4
                    java.lang.String r4 = "zzf"
                    r2[r3] = r4
                    java.lang.String r3 = "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဇ\u0001\u0003ဉ\u0002"
                    com.google.android.gms.internal.mlkit_common.zzaa$zzh$zza r4 = com.google.android.gms.internal.mlkit_common.zzaa.zzh.zza.zzg
                    java.lang.Object r2 = com.google.android.gms.internal.mlkit_common.zzez.zza(r4, r3, r2)
                    return r2
                L_0x0059:
                    com.google.android.gms.internal.mlkit_common.zzaa$zzh$zza$zza r2 = new com.google.android.gms.internal.mlkit_common.zzaa$zzh$zza$zza
                    r2.<init>(r3)
                    return r2
                L_0x005f:
                    com.google.android.gms.internal.mlkit_common.zzaa$zzh$zza r2 = new com.google.android.gms.internal.mlkit_common.zzaa$zzh$zza
                    r2.<init>()
                    return r2
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzaa.zzh.zza.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
            }
        }
    }

    /* compiled from: com.google.mlkit:common@@16.0.0 */
    /* loaded from: classes.dex */
    public static final class zzi extends zzez<zzi, zzb> implements zzgj {
        private static final zzi zzg;
        private static volatile zzgr<zzi> zzh;
        private int zzc;
        private zza zzd;
        private int zze;
        private zzab zzf;

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        /* loaded from: classes.dex */
        public static final class zzb extends zzez.zza<zzi, zzb> implements zzgj {
            private zzb() {
                super(zzi.zzg);
            }

            /* synthetic */ zzb(zzac zzacVar) {
                this();
            }
        }

        static {
            zzi zziVar = new zzi();
            zzg = zziVar;
            zzez.zza(zzi.class, zziVar);
        }

        private zzi() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzi>, com.google.android.gms.internal.mlkit_common.zzez$zzc] */
        /* JADX WARN: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_common.zzez
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_common.zzac.zza
                r4 = 1
                int r2 = r2 - r4
                r2 = r3[r2]
                r3 = 0
                switch(r2) {
                    case 1: goto L_0x0058;
                    case 2: goto L_0x0052;
                    case 3: goto L_0x0033;
                    case 4: goto L_0x0030;
                    case 5: goto L_0x0016;
                    case 6: goto L_0x0011;
                    case 7: goto L_0x0010;
                    default: goto L_0x000a;
                }
            L_0x000a:
                java.lang.UnsupportedOperationException r2 = new java.lang.UnsupportedOperationException
                r2.<init>()
                throw r2
            L_0x0010:
                return r3
            L_0x0011:
                java.lang.Byte r2 = java.lang.Byte.valueOf(r4)
                return r2
            L_0x0016:
                com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzi> r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzi.zzh
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_common.zzaa$zzi> r3 = com.google.android.gms.internal.mlkit_common.zzaa.zzi.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzi> r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzi.zzh     // Catch: all -> 0x002c
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_common.zzez$zzc r2 = new com.google.android.gms.internal.mlkit_common.zzez$zzc     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_common.zzaa$zzi r4 = com.google.android.gms.internal.mlkit_common.zzaa.zzi.zzg     // Catch: all -> 0x002c
                r2.<init>(r4)     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_common.zzaa.zzi.zzh = r2     // Catch: all -> 0x002c
            L_0x002a:
                monitor-exit(r3)     // Catch: all -> 0x002c
                goto L_0x002f
            L_0x002c:
                r2 = move-exception
                monitor-exit(r3)     // Catch: all -> 0x002c
                throw r2
            L_0x002f:
                return r2
            L_0x0030:
                com.google.android.gms.internal.mlkit_common.zzaa$zzi r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzi.zzg
                return r2
            L_0x0033:
                r2 = 4
                java.lang.Object[] r2 = new java.lang.Object[r2]
                r3 = 0
                java.lang.String r0 = "zzc"
                r2[r3] = r0
                java.lang.String r3 = "zzd"
                r2[r4] = r3
                r3 = 2
                java.lang.String r4 = "zze"
                r2[r3] = r4
                r3 = 3
                java.lang.String r4 = "zzf"
                r2[r3] = r4
                java.lang.String r3 = "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဋ\u0001\u0003ဉ\u0002"
                com.google.android.gms.internal.mlkit_common.zzaa$zzi r4 = com.google.android.gms.internal.mlkit_common.zzaa.zzi.zzg
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_common.zzez.zza(r4, r3, r2)
                return r2
            L_0x0052:
                com.google.android.gms.internal.mlkit_common.zzaa$zzi$zzb r2 = new com.google.android.gms.internal.mlkit_common.zzaa$zzi$zzb
                r2.<init>(r3)
                return r2
            L_0x0058:
                com.google.android.gms.internal.mlkit_common.zzaa$zzi r2 = new com.google.android.gms.internal.mlkit_common.zzaa$zzi
                r2.<init>()
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzaa.zzi.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        /* loaded from: classes.dex */
        public static final class zza extends zzez<zza, C0112zza> implements zzgj {
            private static final zza zzh;
            private static volatile zzgr<zza> zzi;
            private int zzc;
            private int zzd;
            private boolean zze;
            private boolean zzf;
            private zzae zzg;

            /* compiled from: com.google.mlkit:common@@16.0.0 */
            /* renamed from: com.google.android.gms.internal.mlkit_common.zzaa$zzi$zza$zza  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            public static final class C0112zza extends zzez.zza<zza, C0112zza> implements zzgj {
                private C0112zza() {
                    super(zza.zzh);
                }

                /* synthetic */ C0112zza(zzac zzacVar) {
                    this();
                }
            }

            static {
                zza zzaVar = new zza();
                zzh = zzaVar;
                zzez.zza(zza.class, zzaVar);
            }

            private zza() {
            }

            /* JADX INFO: Access modifiers changed from: protected */
            /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_common.zzez$zzc, com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzi$zza>] */
            /* JADX WARN: Unknown variable types count: 1 */
            @Override // com.google.android.gms.internal.mlkit_common.zzez
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
                /*
                    r1 = this;
                    int[] r3 = com.google.android.gms.internal.mlkit_common.zzac.zza
                    r4 = 1
                    int r2 = r2 - r4
                    r2 = r3[r2]
                    r3 = 0
                    switch(r2) {
                        case 1: goto L_0x0064;
                        case 2: goto L_0x005e;
                        case 3: goto L_0x0033;
                        case 4: goto L_0x0030;
                        case 5: goto L_0x0016;
                        case 6: goto L_0x0011;
                        case 7: goto L_0x0010;
                        default: goto L_0x000a;
                    }
                L_0x000a:
                    java.lang.UnsupportedOperationException r2 = new java.lang.UnsupportedOperationException
                    r2.<init>()
                    throw r2
                L_0x0010:
                    return r3
                L_0x0011:
                    java.lang.Byte r2 = java.lang.Byte.valueOf(r4)
                    return r2
                L_0x0016:
                    com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzi$zza> r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzi.zza.zzi
                    if (r2 != 0) goto L_0x002f
                    java.lang.Class<com.google.android.gms.internal.mlkit_common.zzaa$zzi$zza> r3 = com.google.android.gms.internal.mlkit_common.zzaa.zzi.zza.class
                    monitor-enter(r3)
                    com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzi$zza> r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzi.zza.zzi     // Catch: all -> 0x002c
                    if (r2 != 0) goto L_0x002a
                    com.google.android.gms.internal.mlkit_common.zzez$zzc r2 = new com.google.android.gms.internal.mlkit_common.zzez$zzc     // Catch: all -> 0x002c
                    com.google.android.gms.internal.mlkit_common.zzaa$zzi$zza r4 = com.google.android.gms.internal.mlkit_common.zzaa.zzi.zza.zzh     // Catch: all -> 0x002c
                    r2.<init>(r4)     // Catch: all -> 0x002c
                    com.google.android.gms.internal.mlkit_common.zzaa.zzi.zza.zzi = r2     // Catch: all -> 0x002c
                L_0x002a:
                    monitor-exit(r3)     // Catch: all -> 0x002c
                    goto L_0x002f
                L_0x002c:
                    r2 = move-exception
                    monitor-exit(r3)     // Catch: all -> 0x002c
                    throw r2
                L_0x002f:
                    return r2
                L_0x0030:
                    com.google.android.gms.internal.mlkit_common.zzaa$zzi$zza r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzi.zza.zzh
                    return r2
                L_0x0033:
                    r2 = 6
                    java.lang.Object[] r2 = new java.lang.Object[r2]
                    r3 = 0
                    java.lang.String r0 = "zzc"
                    r2[r3] = r0
                    java.lang.String r3 = "zzd"
                    r2[r4] = r3
                    r3 = 2
                    com.google.android.gms.internal.mlkit_common.zzfd r4 = com.google.android.gms.internal.mlkit_common.zzal.zzb()
                    r2[r3] = r4
                    r3 = 3
                    java.lang.String r4 = "zze"
                    r2[r3] = r4
                    r3 = 4
                    java.lang.String r4 = "zzf"
                    r2[r3] = r4
                    r3 = 5
                    java.lang.String r4 = "zzg"
                    r2[r3] = r4
                    java.lang.String r3 = "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဇ\u0001\u0003ဇ\u0002\u0004ဉ\u0003"
                    com.google.android.gms.internal.mlkit_common.zzaa$zzi$zza r4 = com.google.android.gms.internal.mlkit_common.zzaa.zzi.zza.zzh
                    java.lang.Object r2 = com.google.android.gms.internal.mlkit_common.zzez.zza(r4, r3, r2)
                    return r2
                L_0x005e:
                    com.google.android.gms.internal.mlkit_common.zzaa$zzi$zza$zza r2 = new com.google.android.gms.internal.mlkit_common.zzaa$zzi$zza$zza
                    r2.<init>(r3)
                    return r2
                L_0x0064:
                    com.google.android.gms.internal.mlkit_common.zzaa$zzi$zza r2 = new com.google.android.gms.internal.mlkit_common.zzaa$zzi$zza
                    r2.<init>()
                    return r2
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzaa.zzi.zza.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
            }
        }
    }

    /* compiled from: com.google.mlkit:common@@16.0.0 */
    /* loaded from: classes.dex */
    public static final class zzk extends zzez<zzk, zza> implements zzgj {
        private static final zzk zzi;
        private static volatile zzgr<zzk> zzj;
        private int zzc;
        private zzaf zzd;
        private zzam zze;
        private long zzf;
        private float zzg;
        private zzae zzh;

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        /* loaded from: classes.dex */
        public static final class zza extends zzez.zza<zzk, zza> implements zzgj {
            private zza() {
                super(zzk.zzi);
            }

            /* synthetic */ zza(zzac zzacVar) {
                this();
            }
        }

        static {
            zzk zzkVar = new zzk();
            zzi = zzkVar;
            zzez.zza(zzk.class, zzkVar);
        }

        private zzk() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzk>, com.google.android.gms.internal.mlkit_common.zzez$zzc] */
        /* JADX WARN: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_common.zzez
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_common.zzac.zza
                r4 = 1
                int r2 = r2 - r4
                r2 = r3[r2]
                r3 = 0
                switch(r2) {
                    case 1: goto L_0x0062;
                    case 2: goto L_0x005c;
                    case 3: goto L_0x0033;
                    case 4: goto L_0x0030;
                    case 5: goto L_0x0016;
                    case 6: goto L_0x0011;
                    case 7: goto L_0x0010;
                    default: goto L_0x000a;
                }
            L_0x000a:
                java.lang.UnsupportedOperationException r2 = new java.lang.UnsupportedOperationException
                r2.<init>()
                throw r2
            L_0x0010:
                return r3
            L_0x0011:
                java.lang.Byte r2 = java.lang.Byte.valueOf(r4)
                return r2
            L_0x0016:
                com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzk> r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzk.zzj
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_common.zzaa$zzk> r3 = com.google.android.gms.internal.mlkit_common.zzaa.zzk.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzk> r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzk.zzj     // Catch: all -> 0x002c
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_common.zzez$zzc r2 = new com.google.android.gms.internal.mlkit_common.zzez$zzc     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_common.zzaa$zzk r4 = com.google.android.gms.internal.mlkit_common.zzaa.zzk.zzi     // Catch: all -> 0x002c
                r2.<init>(r4)     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_common.zzaa.zzk.zzj = r2     // Catch: all -> 0x002c
            L_0x002a:
                monitor-exit(r3)     // Catch: all -> 0x002c
                goto L_0x002f
            L_0x002c:
                r2 = move-exception
                monitor-exit(r3)     // Catch: all -> 0x002c
                throw r2
            L_0x002f:
                return r2
            L_0x0030:
                com.google.android.gms.internal.mlkit_common.zzaa$zzk r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzk.zzi
                return r2
            L_0x0033:
                r2 = 6
                java.lang.Object[] r2 = new java.lang.Object[r2]
                r3 = 0
                java.lang.String r0 = "zzc"
                r2[r3] = r0
                java.lang.String r3 = "zzd"
                r2[r4] = r3
                r3 = 2
                java.lang.String r4 = "zze"
                r2[r3] = r4
                r3 = 3
                java.lang.String r4 = "zzf"
                r2[r3] = r4
                r3 = 4
                java.lang.String r4 = "zzg"
                r2[r3] = r4
                r3 = 5
                java.lang.String r4 = "zzh"
                r2[r3] = r4
                java.lang.String r3 = "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဃ\u0002\u0004ခ\u0003\u0005ဉ\u0004"
                com.google.android.gms.internal.mlkit_common.zzaa$zzk r4 = com.google.android.gms.internal.mlkit_common.zzaa.zzk.zzi
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_common.zzez.zza(r4, r3, r2)
                return r2
            L_0x005c:
                com.google.android.gms.internal.mlkit_common.zzaa$zzk$zza r2 = new com.google.android.gms.internal.mlkit_common.zzaa$zzk$zza
                r2.<init>(r3)
                return r2
            L_0x0062:
                com.google.android.gms.internal.mlkit_common.zzaa$zzk r2 = new com.google.android.gms.internal.mlkit_common.zzaa$zzk
                r2.<init>()
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzaa.zzk.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: com.google.mlkit:common@@16.0.0 */
    /* loaded from: classes.dex */
    public static final class zzm extends zzez<zzm, zza> implements zzgj {
        private static final zzm zzg;
        private static volatile zzgr<zzm> zzh;
        private int zzc;
        private zzaf zzd;
        private zzn zze;
        private zzae zzf;

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        /* loaded from: classes.dex */
        public static final class zza extends zzez.zza<zzm, zza> implements zzgj {
            private zza() {
                super(zzm.zzg);
            }

            /* synthetic */ zza(zzac zzacVar) {
                this();
            }
        }

        static {
            zzm zzmVar = new zzm();
            zzg = zzmVar;
            zzez.zza(zzm.class, zzmVar);
        }

        private zzm() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzm>, com.google.android.gms.internal.mlkit_common.zzez$zzc] */
        /* JADX WARN: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_common.zzez
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_common.zzac.zza
                r4 = 1
                int r2 = r2 - r4
                r2 = r3[r2]
                r3 = 0
                switch(r2) {
                    case 1: goto L_0x0058;
                    case 2: goto L_0x0052;
                    case 3: goto L_0x0033;
                    case 4: goto L_0x0030;
                    case 5: goto L_0x0016;
                    case 6: goto L_0x0011;
                    case 7: goto L_0x0010;
                    default: goto L_0x000a;
                }
            L_0x000a:
                java.lang.UnsupportedOperationException r2 = new java.lang.UnsupportedOperationException
                r2.<init>()
                throw r2
            L_0x0010:
                return r3
            L_0x0011:
                java.lang.Byte r2 = java.lang.Byte.valueOf(r4)
                return r2
            L_0x0016:
                com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzm> r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzm.zzh
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_common.zzaa$zzm> r3 = com.google.android.gms.internal.mlkit_common.zzaa.zzm.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzm> r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzm.zzh     // Catch: all -> 0x002c
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_common.zzez$zzc r2 = new com.google.android.gms.internal.mlkit_common.zzez$zzc     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_common.zzaa$zzm r4 = com.google.android.gms.internal.mlkit_common.zzaa.zzm.zzg     // Catch: all -> 0x002c
                r2.<init>(r4)     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_common.zzaa.zzm.zzh = r2     // Catch: all -> 0x002c
            L_0x002a:
                monitor-exit(r3)     // Catch: all -> 0x002c
                goto L_0x002f
            L_0x002c:
                r2 = move-exception
                monitor-exit(r3)     // Catch: all -> 0x002c
                throw r2
            L_0x002f:
                return r2
            L_0x0030:
                com.google.android.gms.internal.mlkit_common.zzaa$zzm r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzm.zzg
                return r2
            L_0x0033:
                r2 = 4
                java.lang.Object[] r2 = new java.lang.Object[r2]
                r3 = 0
                java.lang.String r0 = "zzc"
                r2[r3] = r0
                java.lang.String r3 = "zzd"
                r2[r4] = r3
                r3 = 2
                java.lang.String r4 = "zze"
                r2[r3] = r4
                r3 = 3
                java.lang.String r4 = "zzf"
                r2[r3] = r4
                java.lang.String r3 = "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002"
                com.google.android.gms.internal.mlkit_common.zzaa$zzm r4 = com.google.android.gms.internal.mlkit_common.zzaa.zzm.zzg
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_common.zzez.zza(r4, r3, r2)
                return r2
            L_0x0052:
                com.google.android.gms.internal.mlkit_common.zzaa$zzm$zza r2 = new com.google.android.gms.internal.mlkit_common.zzaa$zzm$zza
                r2.<init>(r3)
                return r2
            L_0x0058:
                com.google.android.gms.internal.mlkit_common.zzaa$zzm r2 = new com.google.android.gms.internal.mlkit_common.zzaa$zzm
                r2.<init>()
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzaa.zzm.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: com.google.mlkit:common@@16.0.0 */
    /* loaded from: classes.dex */
    public static final class zzo extends zzez<zzo, zza> implements zzgj {
        private static final zzo zzg;
        private static volatile zzgr<zzo> zzh;
        private int zzc;
        private zzaf zzd;
        private zzn zze;
        private zzae zzf;

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        /* loaded from: classes.dex */
        public static final class zza extends zzez.zza<zzo, zza> implements zzgj {
            private zza() {
                super(zzo.zzg);
            }

            /* synthetic */ zza(zzac zzacVar) {
                this();
            }
        }

        static {
            zzo zzoVar = new zzo();
            zzg = zzoVar;
            zzez.zza(zzo.class, zzoVar);
        }

        private zzo() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzo>, com.google.android.gms.internal.mlkit_common.zzez$zzc] */
        /* JADX WARN: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_common.zzez
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_common.zzac.zza
                r4 = 1
                int r2 = r2 - r4
                r2 = r3[r2]
                r3 = 0
                switch(r2) {
                    case 1: goto L_0x0058;
                    case 2: goto L_0x0052;
                    case 3: goto L_0x0033;
                    case 4: goto L_0x0030;
                    case 5: goto L_0x0016;
                    case 6: goto L_0x0011;
                    case 7: goto L_0x0010;
                    default: goto L_0x000a;
                }
            L_0x000a:
                java.lang.UnsupportedOperationException r2 = new java.lang.UnsupportedOperationException
                r2.<init>()
                throw r2
            L_0x0010:
                return r3
            L_0x0011:
                java.lang.Byte r2 = java.lang.Byte.valueOf(r4)
                return r2
            L_0x0016:
                com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzo> r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzo.zzh
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_common.zzaa$zzo> r3 = com.google.android.gms.internal.mlkit_common.zzaa.zzo.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzo> r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzo.zzh     // Catch: all -> 0x002c
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_common.zzez$zzc r2 = new com.google.android.gms.internal.mlkit_common.zzez$zzc     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_common.zzaa$zzo r4 = com.google.android.gms.internal.mlkit_common.zzaa.zzo.zzg     // Catch: all -> 0x002c
                r2.<init>(r4)     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_common.zzaa.zzo.zzh = r2     // Catch: all -> 0x002c
            L_0x002a:
                monitor-exit(r3)     // Catch: all -> 0x002c
                goto L_0x002f
            L_0x002c:
                r2 = move-exception
                monitor-exit(r3)     // Catch: all -> 0x002c
                throw r2
            L_0x002f:
                return r2
            L_0x0030:
                com.google.android.gms.internal.mlkit_common.zzaa$zzo r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzo.zzg
                return r2
            L_0x0033:
                r2 = 4
                java.lang.Object[] r2 = new java.lang.Object[r2]
                r3 = 0
                java.lang.String r0 = "zzc"
                r2[r3] = r0
                java.lang.String r3 = "zzd"
                r2[r4] = r3
                r3 = 2
                java.lang.String r4 = "zze"
                r2[r3] = r4
                r3 = 3
                java.lang.String r4 = "zzf"
                r2[r3] = r4
                java.lang.String r3 = "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002"
                com.google.android.gms.internal.mlkit_common.zzaa$zzo r4 = com.google.android.gms.internal.mlkit_common.zzaa.zzo.zzg
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_common.zzez.zza(r4, r3, r2)
                return r2
            L_0x0052:
                com.google.android.gms.internal.mlkit_common.zzaa$zzo$zza r2 = new com.google.android.gms.internal.mlkit_common.zzaa$zzo$zza
                r2.<init>(r3)
                return r2
            L_0x0058:
                com.google.android.gms.internal.mlkit_common.zzaa$zzo r2 = new com.google.android.gms.internal.mlkit_common.zzaa$zzo
                r2.<init>()
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzaa.zzo.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: com.google.mlkit:common@@16.0.0 */
    /* loaded from: classes.dex */
    public static final class zzp extends zzez<zzp, zza> implements zzgj {
        private static final zzp zzg;
        private static volatile zzgr<zzp> zzh;
        private int zzc;
        private zzaf zzd;
        private zzn zze;
        private zzae zzf;

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        /* loaded from: classes.dex */
        public static final class zza extends zzez.zza<zzp, zza> implements zzgj {
            private zza() {
                super(zzp.zzg);
            }

            /* synthetic */ zza(zzac zzacVar) {
                this();
            }
        }

        static {
            zzp zzpVar = new zzp();
            zzg = zzpVar;
            zzez.zza(zzp.class, zzpVar);
        }

        private zzp() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzp>, com.google.android.gms.internal.mlkit_common.zzez$zzc] */
        /* JADX WARN: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_common.zzez
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_common.zzac.zza
                r4 = 1
                int r2 = r2 - r4
                r2 = r3[r2]
                r3 = 0
                switch(r2) {
                    case 1: goto L_0x0058;
                    case 2: goto L_0x0052;
                    case 3: goto L_0x0033;
                    case 4: goto L_0x0030;
                    case 5: goto L_0x0016;
                    case 6: goto L_0x0011;
                    case 7: goto L_0x0010;
                    default: goto L_0x000a;
                }
            L_0x000a:
                java.lang.UnsupportedOperationException r2 = new java.lang.UnsupportedOperationException
                r2.<init>()
                throw r2
            L_0x0010:
                return r3
            L_0x0011:
                java.lang.Byte r2 = java.lang.Byte.valueOf(r4)
                return r2
            L_0x0016:
                com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzp> r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzp.zzh
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_common.zzaa$zzp> r3 = com.google.android.gms.internal.mlkit_common.zzaa.zzp.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzp> r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzp.zzh     // Catch: all -> 0x002c
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_common.zzez$zzc r2 = new com.google.android.gms.internal.mlkit_common.zzez$zzc     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_common.zzaa$zzp r4 = com.google.android.gms.internal.mlkit_common.zzaa.zzp.zzg     // Catch: all -> 0x002c
                r2.<init>(r4)     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_common.zzaa.zzp.zzh = r2     // Catch: all -> 0x002c
            L_0x002a:
                monitor-exit(r3)     // Catch: all -> 0x002c
                goto L_0x002f
            L_0x002c:
                r2 = move-exception
                monitor-exit(r3)     // Catch: all -> 0x002c
                throw r2
            L_0x002f:
                return r2
            L_0x0030:
                com.google.android.gms.internal.mlkit_common.zzaa$zzp r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzp.zzg
                return r2
            L_0x0033:
                r2 = 4
                java.lang.Object[] r2 = new java.lang.Object[r2]
                r3 = 0
                java.lang.String r0 = "zzc"
                r2[r3] = r0
                java.lang.String r3 = "zzd"
                r2[r4] = r3
                r3 = 2
                java.lang.String r4 = "zze"
                r2[r3] = r4
                r3 = 3
                java.lang.String r4 = "zzf"
                r2[r3] = r4
                java.lang.String r3 = "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002"
                com.google.android.gms.internal.mlkit_common.zzaa$zzp r4 = com.google.android.gms.internal.mlkit_common.zzaa.zzp.zzg
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_common.zzez.zza(r4, r3, r2)
                return r2
            L_0x0052:
                com.google.android.gms.internal.mlkit_common.zzaa$zzp$zza r2 = new com.google.android.gms.internal.mlkit_common.zzaa$zzp$zza
                r2.<init>(r3)
                return r2
            L_0x0058:
                com.google.android.gms.internal.mlkit_common.zzaa$zzp r2 = new com.google.android.gms.internal.mlkit_common.zzaa$zzp
                r2.<init>()
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzaa.zzp.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: com.google.mlkit:common@@16.0.0 */
    /* loaded from: classes.dex */
    public static final class zzq extends zzez<zzq, zza> implements zzgj {
        private static final zzq zzg;
        private static volatile zzgr<zzq> zzh;
        private int zzc;
        private zzaf zzd;
        private zzn zze;
        private zzae zzf;

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        /* loaded from: classes.dex */
        public static final class zza extends zzez.zza<zzq, zza> implements zzgj {
            private zza() {
                super(zzq.zzg);
            }

            /* synthetic */ zza(zzac zzacVar) {
                this();
            }
        }

        static {
            zzq zzqVar = new zzq();
            zzg = zzqVar;
            zzez.zza(zzq.class, zzqVar);
        }

        private zzq() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_common.zzez$zzc, com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzq>] */
        /* JADX WARN: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_common.zzez
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_common.zzac.zza
                r4 = 1
                int r2 = r2 - r4
                r2 = r3[r2]
                r3 = 0
                switch(r2) {
                    case 1: goto L_0x0058;
                    case 2: goto L_0x0052;
                    case 3: goto L_0x0033;
                    case 4: goto L_0x0030;
                    case 5: goto L_0x0016;
                    case 6: goto L_0x0011;
                    case 7: goto L_0x0010;
                    default: goto L_0x000a;
                }
            L_0x000a:
                java.lang.UnsupportedOperationException r2 = new java.lang.UnsupportedOperationException
                r2.<init>()
                throw r2
            L_0x0010:
                return r3
            L_0x0011:
                java.lang.Byte r2 = java.lang.Byte.valueOf(r4)
                return r2
            L_0x0016:
                com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzq> r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzq.zzh
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_common.zzaa$zzq> r3 = com.google.android.gms.internal.mlkit_common.zzaa.zzq.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzq> r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzq.zzh     // Catch: all -> 0x002c
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_common.zzez$zzc r2 = new com.google.android.gms.internal.mlkit_common.zzez$zzc     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_common.zzaa$zzq r4 = com.google.android.gms.internal.mlkit_common.zzaa.zzq.zzg     // Catch: all -> 0x002c
                r2.<init>(r4)     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_common.zzaa.zzq.zzh = r2     // Catch: all -> 0x002c
            L_0x002a:
                monitor-exit(r3)     // Catch: all -> 0x002c
                goto L_0x002f
            L_0x002c:
                r2 = move-exception
                monitor-exit(r3)     // Catch: all -> 0x002c
                throw r2
            L_0x002f:
                return r2
            L_0x0030:
                com.google.android.gms.internal.mlkit_common.zzaa$zzq r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzq.zzg
                return r2
            L_0x0033:
                r2 = 4
                java.lang.Object[] r2 = new java.lang.Object[r2]
                r3 = 0
                java.lang.String r0 = "zzc"
                r2[r3] = r0
                java.lang.String r3 = "zzd"
                r2[r4] = r3
                r3 = 2
                java.lang.String r4 = "zze"
                r2[r3] = r4
                r3 = 3
                java.lang.String r4 = "zzf"
                r2[r3] = r4
                java.lang.String r3 = "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002"
                com.google.android.gms.internal.mlkit_common.zzaa$zzq r4 = com.google.android.gms.internal.mlkit_common.zzaa.zzq.zzg
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_common.zzez.zza(r4, r3, r2)
                return r2
            L_0x0052:
                com.google.android.gms.internal.mlkit_common.zzaa$zzq$zza r2 = new com.google.android.gms.internal.mlkit_common.zzaa$zzq$zza
                r2.<init>(r3)
                return r2
            L_0x0058:
                com.google.android.gms.internal.mlkit_common.zzaa$zzq r2 = new com.google.android.gms.internal.mlkit_common.zzaa$zzq
                r2.<init>()
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzaa.zzq.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: com.google.mlkit:common@@16.0.0 */
    /* loaded from: classes.dex */
    public static final class zzr extends zzez<zzr, zza> implements zzgj {
        private static final zzr zzg;
        private static volatile zzgr<zzr> zzh;
        private int zzc;
        private zzaf zzd;
        private zzn zze;
        private zzae zzf;

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        /* loaded from: classes.dex */
        public static final class zza extends zzez.zza<zzr, zza> implements zzgj {
            private zza() {
                super(zzr.zzg);
            }

            /* synthetic */ zza(zzac zzacVar) {
                this();
            }
        }

        static {
            zzr zzrVar = new zzr();
            zzg = zzrVar;
            zzez.zza(zzr.class, zzrVar);
        }

        private zzr() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_common.zzez$zzc, com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzr>] */
        /* JADX WARN: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_common.zzez
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_common.zzac.zza
                r4 = 1
                int r2 = r2 - r4
                r2 = r3[r2]
                r3 = 0
                switch(r2) {
                    case 1: goto L_0x0058;
                    case 2: goto L_0x0052;
                    case 3: goto L_0x0033;
                    case 4: goto L_0x0030;
                    case 5: goto L_0x0016;
                    case 6: goto L_0x0011;
                    case 7: goto L_0x0010;
                    default: goto L_0x000a;
                }
            L_0x000a:
                java.lang.UnsupportedOperationException r2 = new java.lang.UnsupportedOperationException
                r2.<init>()
                throw r2
            L_0x0010:
                return r3
            L_0x0011:
                java.lang.Byte r2 = java.lang.Byte.valueOf(r4)
                return r2
            L_0x0016:
                com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzr> r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzr.zzh
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_common.zzaa$zzr> r3 = com.google.android.gms.internal.mlkit_common.zzaa.zzr.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzr> r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzr.zzh     // Catch: all -> 0x002c
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_common.zzez$zzc r2 = new com.google.android.gms.internal.mlkit_common.zzez$zzc     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_common.zzaa$zzr r4 = com.google.android.gms.internal.mlkit_common.zzaa.zzr.zzg     // Catch: all -> 0x002c
                r2.<init>(r4)     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_common.zzaa.zzr.zzh = r2     // Catch: all -> 0x002c
            L_0x002a:
                monitor-exit(r3)     // Catch: all -> 0x002c
                goto L_0x002f
            L_0x002c:
                r2 = move-exception
                monitor-exit(r3)     // Catch: all -> 0x002c
                throw r2
            L_0x002f:
                return r2
            L_0x0030:
                com.google.android.gms.internal.mlkit_common.zzaa$zzr r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzr.zzg
                return r2
            L_0x0033:
                r2 = 4
                java.lang.Object[] r2 = new java.lang.Object[r2]
                r3 = 0
                java.lang.String r0 = "zzc"
                r2[r3] = r0
                java.lang.String r3 = "zzd"
                r2[r4] = r3
                r3 = 2
                java.lang.String r4 = "zze"
                r2[r3] = r4
                r3 = 3
                java.lang.String r4 = "zzf"
                r2[r3] = r4
                java.lang.String r3 = "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002"
                com.google.android.gms.internal.mlkit_common.zzaa$zzr r4 = com.google.android.gms.internal.mlkit_common.zzaa.zzr.zzg
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_common.zzez.zza(r4, r3, r2)
                return r2
            L_0x0052:
                com.google.android.gms.internal.mlkit_common.zzaa$zzr$zza r2 = new com.google.android.gms.internal.mlkit_common.zzaa$zzr$zza
                r2.<init>(r3)
                return r2
            L_0x0058:
                com.google.android.gms.internal.mlkit_common.zzaa$zzr r2 = new com.google.android.gms.internal.mlkit_common.zzaa$zzr
                r2.<init>()
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzaa.zzr.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: com.google.mlkit:common@@16.0.0 */
    /* loaded from: classes.dex */
    public static final class zzs extends zzez<zzs, zza> implements zzgj {
        private static final zzs zzg;
        private static volatile zzgr<zzs> zzh;
        private int zzc;
        private zzaf zzd;
        private zzn zze;
        private zzae zzf;

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        /* loaded from: classes.dex */
        public static final class zza extends zzez.zza<zzs, zza> implements zzgj {
            private zza() {
                super(zzs.zzg);
            }

            /* synthetic */ zza(zzac zzacVar) {
                this();
            }
        }

        static {
            zzs zzsVar = new zzs();
            zzg = zzsVar;
            zzez.zza(zzs.class, zzsVar);
        }

        private zzs() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_common.zzez$zzc, com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzs>] */
        /* JADX WARN: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_common.zzez
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_common.zzac.zza
                r4 = 1
                int r2 = r2 - r4
                r2 = r3[r2]
                r3 = 0
                switch(r2) {
                    case 1: goto L_0x0058;
                    case 2: goto L_0x0052;
                    case 3: goto L_0x0033;
                    case 4: goto L_0x0030;
                    case 5: goto L_0x0016;
                    case 6: goto L_0x0011;
                    case 7: goto L_0x0010;
                    default: goto L_0x000a;
                }
            L_0x000a:
                java.lang.UnsupportedOperationException r2 = new java.lang.UnsupportedOperationException
                r2.<init>()
                throw r2
            L_0x0010:
                return r3
            L_0x0011:
                java.lang.Byte r2 = java.lang.Byte.valueOf(r4)
                return r2
            L_0x0016:
                com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzs> r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzs.zzh
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_common.zzaa$zzs> r3 = com.google.android.gms.internal.mlkit_common.zzaa.zzs.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzs> r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzs.zzh     // Catch: all -> 0x002c
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_common.zzez$zzc r2 = new com.google.android.gms.internal.mlkit_common.zzez$zzc     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_common.zzaa$zzs r4 = com.google.android.gms.internal.mlkit_common.zzaa.zzs.zzg     // Catch: all -> 0x002c
                r2.<init>(r4)     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_common.zzaa.zzs.zzh = r2     // Catch: all -> 0x002c
            L_0x002a:
                monitor-exit(r3)     // Catch: all -> 0x002c
                goto L_0x002f
            L_0x002c:
                r2 = move-exception
                monitor-exit(r3)     // Catch: all -> 0x002c
                throw r2
            L_0x002f:
                return r2
            L_0x0030:
                com.google.android.gms.internal.mlkit_common.zzaa$zzs r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzs.zzg
                return r2
            L_0x0033:
                r2 = 4
                java.lang.Object[] r2 = new java.lang.Object[r2]
                r3 = 0
                java.lang.String r0 = "zzc"
                r2[r3] = r0
                java.lang.String r3 = "zzd"
                r2[r4] = r3
                r3 = 2
                java.lang.String r4 = "zze"
                r2[r3] = r4
                r3 = 3
                java.lang.String r4 = "zzf"
                r2[r3] = r4
                java.lang.String r3 = "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002"
                com.google.android.gms.internal.mlkit_common.zzaa$zzs r4 = com.google.android.gms.internal.mlkit_common.zzaa.zzs.zzg
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_common.zzez.zza(r4, r3, r2)
                return r2
            L_0x0052:
                com.google.android.gms.internal.mlkit_common.zzaa$zzs$zza r2 = new com.google.android.gms.internal.mlkit_common.zzaa$zzs$zza
                r2.<init>(r3)
                return r2
            L_0x0058:
                com.google.android.gms.internal.mlkit_common.zzaa$zzs r2 = new com.google.android.gms.internal.mlkit_common.zzaa$zzs
                r2.<init>()
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzaa.zzs.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: com.google.mlkit:common@@16.0.0 */
    /* loaded from: classes.dex */
    public static final class zzt extends zzez<zzt, zza> implements zzgj {
        private static final zzt zzg;
        private static volatile zzgr<zzt> zzh;
        private int zzc;
        private zzaf zzd;
        private zzn zze;
        private zzae zzf;

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        /* loaded from: classes.dex */
        public static final class zza extends zzez.zza<zzt, zza> implements zzgj {
            private zza() {
                super(zzt.zzg);
            }

            /* synthetic */ zza(zzac zzacVar) {
                this();
            }
        }

        static {
            zzt zztVar = new zzt();
            zzg = zztVar;
            zzez.zza(zzt.class, zztVar);
        }

        private zzt() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_common.zzez$zzc, com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzt>] */
        /* JADX WARN: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_common.zzez
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_common.zzac.zza
                r4 = 1
                int r2 = r2 - r4
                r2 = r3[r2]
                r3 = 0
                switch(r2) {
                    case 1: goto L_0x0058;
                    case 2: goto L_0x0052;
                    case 3: goto L_0x0033;
                    case 4: goto L_0x0030;
                    case 5: goto L_0x0016;
                    case 6: goto L_0x0011;
                    case 7: goto L_0x0010;
                    default: goto L_0x000a;
                }
            L_0x000a:
                java.lang.UnsupportedOperationException r2 = new java.lang.UnsupportedOperationException
                r2.<init>()
                throw r2
            L_0x0010:
                return r3
            L_0x0011:
                java.lang.Byte r2 = java.lang.Byte.valueOf(r4)
                return r2
            L_0x0016:
                com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzt> r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzt.zzh
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_common.zzaa$zzt> r3 = com.google.android.gms.internal.mlkit_common.zzaa.zzt.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzt> r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzt.zzh     // Catch: all -> 0x002c
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_common.zzez$zzc r2 = new com.google.android.gms.internal.mlkit_common.zzez$zzc     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_common.zzaa$zzt r4 = com.google.android.gms.internal.mlkit_common.zzaa.zzt.zzg     // Catch: all -> 0x002c
                r2.<init>(r4)     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_common.zzaa.zzt.zzh = r2     // Catch: all -> 0x002c
            L_0x002a:
                monitor-exit(r3)     // Catch: all -> 0x002c
                goto L_0x002f
            L_0x002c:
                r2 = move-exception
                monitor-exit(r3)     // Catch: all -> 0x002c
                throw r2
            L_0x002f:
                return r2
            L_0x0030:
                com.google.android.gms.internal.mlkit_common.zzaa$zzt r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzt.zzg
                return r2
            L_0x0033:
                r2 = 4
                java.lang.Object[] r2 = new java.lang.Object[r2]
                r3 = 0
                java.lang.String r0 = "zzc"
                r2[r3] = r0
                java.lang.String r3 = "zzd"
                r2[r4] = r3
                r3 = 2
                java.lang.String r4 = "zze"
                r2[r3] = r4
                r3 = 3
                java.lang.String r4 = "zzf"
                r2[r3] = r4
                java.lang.String r3 = "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002"
                com.google.android.gms.internal.mlkit_common.zzaa$zzt r4 = com.google.android.gms.internal.mlkit_common.zzaa.zzt.zzg
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_common.zzez.zza(r4, r3, r2)
                return r2
            L_0x0052:
                com.google.android.gms.internal.mlkit_common.zzaa$zzt$zza r2 = new com.google.android.gms.internal.mlkit_common.zzaa$zzt$zza
                r2.<init>(r3)
                return r2
            L_0x0058:
                com.google.android.gms.internal.mlkit_common.zzaa$zzt r2 = new com.google.android.gms.internal.mlkit_common.zzaa$zzt
                r2.<init>()
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzaa.zzt.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: com.google.mlkit:common@@16.0.0 */
    /* loaded from: classes.dex */
    public static final class zzu extends zzez<zzu, zza> implements zzgj {
        private static final zzu zzg;
        private static volatile zzgr<zzu> zzh;
        private int zzc;
        private zzaf zzd;
        private zzn zze;
        private zzae zzf;

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        /* loaded from: classes.dex */
        public static final class zza extends zzez.zza<zzu, zza> implements zzgj {
            private zza() {
                super(zzu.zzg);
            }

            /* synthetic */ zza(zzac zzacVar) {
                this();
            }
        }

        static {
            zzu zzuVar = new zzu();
            zzg = zzuVar;
            zzez.zza(zzu.class, zzuVar);
        }

        private zzu() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_common.zzez$zzc, com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzu>] */
        /* JADX WARN: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_common.zzez
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_common.zzac.zza
                r4 = 1
                int r2 = r2 - r4
                r2 = r3[r2]
                r3 = 0
                switch(r2) {
                    case 1: goto L_0x0058;
                    case 2: goto L_0x0052;
                    case 3: goto L_0x0033;
                    case 4: goto L_0x0030;
                    case 5: goto L_0x0016;
                    case 6: goto L_0x0011;
                    case 7: goto L_0x0010;
                    default: goto L_0x000a;
                }
            L_0x000a:
                java.lang.UnsupportedOperationException r2 = new java.lang.UnsupportedOperationException
                r2.<init>()
                throw r2
            L_0x0010:
                return r3
            L_0x0011:
                java.lang.Byte r2 = java.lang.Byte.valueOf(r4)
                return r2
            L_0x0016:
                com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzu> r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzu.zzh
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_common.zzaa$zzu> r3 = com.google.android.gms.internal.mlkit_common.zzaa.zzu.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzu> r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzu.zzh     // Catch: all -> 0x002c
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_common.zzez$zzc r2 = new com.google.android.gms.internal.mlkit_common.zzez$zzc     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_common.zzaa$zzu r4 = com.google.android.gms.internal.mlkit_common.zzaa.zzu.zzg     // Catch: all -> 0x002c
                r2.<init>(r4)     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_common.zzaa.zzu.zzh = r2     // Catch: all -> 0x002c
            L_0x002a:
                monitor-exit(r3)     // Catch: all -> 0x002c
                goto L_0x002f
            L_0x002c:
                r2 = move-exception
                monitor-exit(r3)     // Catch: all -> 0x002c
                throw r2
            L_0x002f:
                return r2
            L_0x0030:
                com.google.android.gms.internal.mlkit_common.zzaa$zzu r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzu.zzg
                return r2
            L_0x0033:
                r2 = 4
                java.lang.Object[] r2 = new java.lang.Object[r2]
                r3 = 0
                java.lang.String r0 = "zzc"
                r2[r3] = r0
                java.lang.String r3 = "zzd"
                r2[r4] = r3
                r3 = 2
                java.lang.String r4 = "zze"
                r2[r3] = r4
                r3 = 3
                java.lang.String r4 = "zzf"
                r2[r3] = r4
                java.lang.String r3 = "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002"
                com.google.android.gms.internal.mlkit_common.zzaa$zzu r4 = com.google.android.gms.internal.mlkit_common.zzaa.zzu.zzg
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_common.zzez.zza(r4, r3, r2)
                return r2
            L_0x0052:
                com.google.android.gms.internal.mlkit_common.zzaa$zzu$zza r2 = new com.google.android.gms.internal.mlkit_common.zzaa$zzu$zza
                r2.<init>(r3)
                return r2
            L_0x0058:
                com.google.android.gms.internal.mlkit_common.zzaa$zzu r2 = new com.google.android.gms.internal.mlkit_common.zzaa$zzu
                r2.<init>()
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzaa.zzu.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: com.google.mlkit:common@@16.0.0 */
    /* loaded from: classes.dex */
    public static final class zzv extends zzez<zzv, zza> implements zzgj {
        private static final zzv zzg;
        private static volatile zzgr<zzv> zzh;
        private int zzc;
        private zzaf zzd;
        private zzn zze;
        private zzae zzf;

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        /* loaded from: classes.dex */
        public static final class zza extends zzez.zza<zzv, zza> implements zzgj {
            private zza() {
                super(zzv.zzg);
            }

            /* synthetic */ zza(zzac zzacVar) {
                this();
            }
        }

        static {
            zzv zzvVar = new zzv();
            zzg = zzvVar;
            zzez.zza(zzv.class, zzvVar);
        }

        private zzv() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_common.zzez$zzc, com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzv>] */
        /* JADX WARN: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_common.zzez
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_common.zzac.zza
                r4 = 1
                int r2 = r2 - r4
                r2 = r3[r2]
                r3 = 0
                switch(r2) {
                    case 1: goto L_0x0058;
                    case 2: goto L_0x0052;
                    case 3: goto L_0x0033;
                    case 4: goto L_0x0030;
                    case 5: goto L_0x0016;
                    case 6: goto L_0x0011;
                    case 7: goto L_0x0010;
                    default: goto L_0x000a;
                }
            L_0x000a:
                java.lang.UnsupportedOperationException r2 = new java.lang.UnsupportedOperationException
                r2.<init>()
                throw r2
            L_0x0010:
                return r3
            L_0x0011:
                java.lang.Byte r2 = java.lang.Byte.valueOf(r4)
                return r2
            L_0x0016:
                com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzv> r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzv.zzh
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_common.zzaa$zzv> r3 = com.google.android.gms.internal.mlkit_common.zzaa.zzv.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzv> r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzv.zzh     // Catch: all -> 0x002c
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_common.zzez$zzc r2 = new com.google.android.gms.internal.mlkit_common.zzez$zzc     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_common.zzaa$zzv r4 = com.google.android.gms.internal.mlkit_common.zzaa.zzv.zzg     // Catch: all -> 0x002c
                r2.<init>(r4)     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_common.zzaa.zzv.zzh = r2     // Catch: all -> 0x002c
            L_0x002a:
                monitor-exit(r3)     // Catch: all -> 0x002c
                goto L_0x002f
            L_0x002c:
                r2 = move-exception
                monitor-exit(r3)     // Catch: all -> 0x002c
                throw r2
            L_0x002f:
                return r2
            L_0x0030:
                com.google.android.gms.internal.mlkit_common.zzaa$zzv r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzv.zzg
                return r2
            L_0x0033:
                r2 = 4
                java.lang.Object[] r2 = new java.lang.Object[r2]
                r3 = 0
                java.lang.String r0 = "zzc"
                r2[r3] = r0
                java.lang.String r3 = "zzd"
                r2[r4] = r3
                r3 = 2
                java.lang.String r4 = "zze"
                r2[r3] = r4
                r3 = 3
                java.lang.String r4 = "zzf"
                r2[r3] = r4
                java.lang.String r3 = "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002"
                com.google.android.gms.internal.mlkit_common.zzaa$zzv r4 = com.google.android.gms.internal.mlkit_common.zzaa.zzv.zzg
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_common.zzez.zza(r4, r3, r2)
                return r2
            L_0x0052:
                com.google.android.gms.internal.mlkit_common.zzaa$zzv$zza r2 = new com.google.android.gms.internal.mlkit_common.zzaa$zzv$zza
                r2.<init>(r3)
                return r2
            L_0x0058:
                com.google.android.gms.internal.mlkit_common.zzaa$zzv r2 = new com.google.android.gms.internal.mlkit_common.zzaa$zzv
                r2.<init>()
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzaa.zzv.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: com.google.mlkit:common@@16.0.0 */
    /* loaded from: classes.dex */
    public static final class zzw extends zzez<zzw, zza> implements zzgj {
        private static final zzw zzg;
        private static volatile zzgr<zzw> zzh;
        private int zzc;
        private zzaf zzd;
        private zzn zze;
        private zzae zzf;

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        /* loaded from: classes.dex */
        public static final class zza extends zzez.zza<zzw, zza> implements zzgj {
            private zza() {
                super(zzw.zzg);
            }

            /* synthetic */ zza(zzac zzacVar) {
                this();
            }
        }

        static {
            zzw zzwVar = new zzw();
            zzg = zzwVar;
            zzez.zza(zzw.class, zzwVar);
        }

        private zzw() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_common.zzez$zzc, com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzw>] */
        /* JADX WARN: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_common.zzez
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_common.zzac.zza
                r4 = 1
                int r2 = r2 - r4
                r2 = r3[r2]
                r3 = 0
                switch(r2) {
                    case 1: goto L_0x0058;
                    case 2: goto L_0x0052;
                    case 3: goto L_0x0033;
                    case 4: goto L_0x0030;
                    case 5: goto L_0x0016;
                    case 6: goto L_0x0011;
                    case 7: goto L_0x0010;
                    default: goto L_0x000a;
                }
            L_0x000a:
                java.lang.UnsupportedOperationException r2 = new java.lang.UnsupportedOperationException
                r2.<init>()
                throw r2
            L_0x0010:
                return r3
            L_0x0011:
                java.lang.Byte r2 = java.lang.Byte.valueOf(r4)
                return r2
            L_0x0016:
                com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzw> r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzw.zzh
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_common.zzaa$zzw> r3 = com.google.android.gms.internal.mlkit_common.zzaa.zzw.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzw> r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzw.zzh     // Catch: all -> 0x002c
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_common.zzez$zzc r2 = new com.google.android.gms.internal.mlkit_common.zzez$zzc     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_common.zzaa$zzw r4 = com.google.android.gms.internal.mlkit_common.zzaa.zzw.zzg     // Catch: all -> 0x002c
                r2.<init>(r4)     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_common.zzaa.zzw.zzh = r2     // Catch: all -> 0x002c
            L_0x002a:
                monitor-exit(r3)     // Catch: all -> 0x002c
                goto L_0x002f
            L_0x002c:
                r2 = move-exception
                monitor-exit(r3)     // Catch: all -> 0x002c
                throw r2
            L_0x002f:
                return r2
            L_0x0030:
                com.google.android.gms.internal.mlkit_common.zzaa$zzw r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzw.zzg
                return r2
            L_0x0033:
                r2 = 4
                java.lang.Object[] r2 = new java.lang.Object[r2]
                r3 = 0
                java.lang.String r0 = "zzc"
                r2[r3] = r0
                java.lang.String r3 = "zzd"
                r2[r4] = r3
                r3 = 2
                java.lang.String r4 = "zze"
                r2[r3] = r4
                r3 = 3
                java.lang.String r4 = "zzf"
                r2[r3] = r4
                java.lang.String r3 = "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002"
                com.google.android.gms.internal.mlkit_common.zzaa$zzw r4 = com.google.android.gms.internal.mlkit_common.zzaa.zzw.zzg
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_common.zzez.zza(r4, r3, r2)
                return r2
            L_0x0052:
                com.google.android.gms.internal.mlkit_common.zzaa$zzw$zza r2 = new com.google.android.gms.internal.mlkit_common.zzaa$zzw$zza
                r2.<init>(r3)
                return r2
            L_0x0058:
                com.google.android.gms.internal.mlkit_common.zzaa$zzw r2 = new com.google.android.gms.internal.mlkit_common.zzaa$zzw
                r2.<init>()
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzaa.zzw.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: com.google.mlkit:common@@16.0.0 */
    /* loaded from: classes.dex */
    public static final class zzy extends zzez<zzy, zzb> implements zzgj {
        private static final zzy zzi;
        private static volatile zzgr<zzy> zzj;
        private int zzc;
        private zzaf zzd;
        private zzam zze;
        private zzfi<zza> zzf = zzez.zzl();
        private zzfi<zza> zzg = zzez.zzl();
        private long zzh;

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        /* loaded from: classes.dex */
        public static final class zzb extends zzez.zza<zzy, zzb> implements zzgj {
            private zzb() {
                super(zzy.zzi);
            }

            /* synthetic */ zzb(zzac zzacVar) {
                this();
            }
        }

        static {
            zzy zzyVar = new zzy();
            zzi = zzyVar;
            zzez.zza(zzy.class, zzyVar);
        }

        private zzy() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Type inference failed for: r3v14, types: [com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzy>, com.google.android.gms.internal.mlkit_common.zzez$zzc] */
        /* JADX WARN: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_common.zzez
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object zza(int r3, java.lang.Object r4, java.lang.Object r5) {
            /*
                r2 = this;
                java.lang.Class<com.google.android.gms.internal.mlkit_common.zzaa$zzy$zza> r4 = com.google.android.gms.internal.mlkit_common.zzaa.zzy.zza.class
                int[] r5 = com.google.android.gms.internal.mlkit_common.zzac.zza
                r0 = 1
                int r3 = r3 - r0
                r3 = r5[r3]
                r5 = 0
                switch(r3) {
                    case 1: goto L_0x006b;
                    case 2: goto L_0x0065;
                    case 3: goto L_0x0035;
                    case 4: goto L_0x0032;
                    case 5: goto L_0x0018;
                    case 6: goto L_0x0013;
                    case 7: goto L_0x0012;
                    default: goto L_0x000c;
                }
            L_0x000c:
                java.lang.UnsupportedOperationException r3 = new java.lang.UnsupportedOperationException
                r3.<init>()
                throw r3
            L_0x0012:
                return r5
            L_0x0013:
                java.lang.Byte r3 = java.lang.Byte.valueOf(r0)
                return r3
            L_0x0018:
                com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzy> r3 = com.google.android.gms.internal.mlkit_common.zzaa.zzy.zzj
                if (r3 != 0) goto L_0x0031
                java.lang.Class<com.google.android.gms.internal.mlkit_common.zzaa$zzy> r4 = com.google.android.gms.internal.mlkit_common.zzaa.zzy.class
                monitor-enter(r4)
                com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzy> r3 = com.google.android.gms.internal.mlkit_common.zzaa.zzy.zzj     // Catch: all -> 0x002e
                if (r3 != 0) goto L_0x002c
                com.google.android.gms.internal.mlkit_common.zzez$zzc r3 = new com.google.android.gms.internal.mlkit_common.zzez$zzc     // Catch: all -> 0x002e
                com.google.android.gms.internal.mlkit_common.zzaa$zzy r5 = com.google.android.gms.internal.mlkit_common.zzaa.zzy.zzi     // Catch: all -> 0x002e
                r3.<init>(r5)     // Catch: all -> 0x002e
                com.google.android.gms.internal.mlkit_common.zzaa.zzy.zzj = r3     // Catch: all -> 0x002e
            L_0x002c:
                monitor-exit(r4)     // Catch: all -> 0x002e
                goto L_0x0031
            L_0x002e:
                r3 = move-exception
                monitor-exit(r4)     // Catch: all -> 0x002e
                throw r3
            L_0x0031:
                return r3
            L_0x0032:
                com.google.android.gms.internal.mlkit_common.zzaa$zzy r3 = com.google.android.gms.internal.mlkit_common.zzaa.zzy.zzi
                return r3
            L_0x0035:
                r3 = 8
                java.lang.Object[] r3 = new java.lang.Object[r3]
                r5 = 0
                java.lang.String r1 = "zzc"
                r3[r5] = r1
                java.lang.String r5 = "zzd"
                r3[r0] = r5
                r5 = 2
                java.lang.String r0 = "zze"
                r3[r5] = r0
                r5 = 3
                java.lang.String r0 = "zzf"
                r3[r5] = r0
                r5 = 4
                r3[r5] = r4
                r5 = 5
                java.lang.String r0 = "zzg"
                r3[r5] = r0
                r5 = 6
                r3[r5] = r4
                r4 = 7
                java.lang.String r5 = "zzh"
                r3[r4] = r5
                java.lang.String r4 = "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0002\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003\u001b\u0004\u001b\u0005ဃ\u0002"
                com.google.android.gms.internal.mlkit_common.zzaa$zzy r5 = com.google.android.gms.internal.mlkit_common.zzaa.zzy.zzi
                java.lang.Object r3 = com.google.android.gms.internal.mlkit_common.zzez.zza(r5, r4, r3)
                return r3
            L_0x0065:
                com.google.android.gms.internal.mlkit_common.zzaa$zzy$zzb r3 = new com.google.android.gms.internal.mlkit_common.zzaa$zzy$zzb
                r3.<init>(r5)
                return r3
            L_0x006b:
                com.google.android.gms.internal.mlkit_common.zzaa$zzy r3 = new com.google.android.gms.internal.mlkit_common.zzaa$zzy
                r3.<init>()
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzaa.zzy.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        /* loaded from: classes.dex */
        public static final class zza extends zzez<zza, zzb> implements zzgj {
            private static final zza zzf;
            private static volatile zzgr<zza> zzg;
            private int zzc;
            private int zzd;
            private zzfg zze = zzez.zzk();

            /* compiled from: com.google.mlkit:common@@16.0.0 */
            /* renamed from: com.google.android.gms.internal.mlkit_common.zzaa$zzy$zza$zza  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            public enum EnumC0113zza implements zzfb {
                UNKNOWN_DATA_TYPE(0),
                TYPE_FLOAT32(1),
                TYPE_INT32(2),
                TYPE_BYTE(3),
                TYPE_LONG(4);
                
                private static final zzfe<EnumC0113zza> zzf = new zzaj();
                private final int zzg;

                EnumC0113zza(int i) {
                    this.zzg = i;
                }

                public static zzfd zzb() {
                    return zzai.zza;
                }

                @Override // java.lang.Enum
                public final String toString() {
                    return "<" + EnumC0113zza.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzg + " name=" + name() + '>';
                }

                @Override // com.google.android.gms.internal.mlkit_common.zzfb
                public final int zza() {
                    return this.zzg;
                }
            }

            /* compiled from: com.google.mlkit:common@@16.0.0 */
            /* loaded from: classes.dex */
            public static final class zzb extends zzez.zza<zza, zzb> implements zzgj {
                private zzb() {
                    super(zza.zzf);
                }

                /* synthetic */ zzb(zzac zzacVar) {
                    this();
                }
            }

            static {
                zza zzaVar = new zza();
                zzf = zzaVar;
                zzez.zza(zza.class, zzaVar);
            }

            private zza() {
            }

            /* JADX INFO: Access modifiers changed from: protected */
            /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_common.zzez$zzc, com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzy$zza>] */
            /* JADX WARN: Unknown variable types count: 1 */
            @Override // com.google.android.gms.internal.mlkit_common.zzez
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
                /*
                    r1 = this;
                    int[] r3 = com.google.android.gms.internal.mlkit_common.zzac.zza
                    r4 = 1
                    int r2 = r2 - r4
                    r2 = r3[r2]
                    r3 = 0
                    switch(r2) {
                        case 1: goto L_0x005a;
                        case 2: goto L_0x0054;
                        case 3: goto L_0x0033;
                        case 4: goto L_0x0030;
                        case 5: goto L_0x0016;
                        case 6: goto L_0x0011;
                        case 7: goto L_0x0010;
                        default: goto L_0x000a;
                    }
                L_0x000a:
                    java.lang.UnsupportedOperationException r2 = new java.lang.UnsupportedOperationException
                    r2.<init>()
                    throw r2
                L_0x0010:
                    return r3
                L_0x0011:
                    java.lang.Byte r2 = java.lang.Byte.valueOf(r4)
                    return r2
                L_0x0016:
                    com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzy$zza> r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzy.zza.zzg
                    if (r2 != 0) goto L_0x002f
                    java.lang.Class<com.google.android.gms.internal.mlkit_common.zzaa$zzy$zza> r3 = com.google.android.gms.internal.mlkit_common.zzaa.zzy.zza.class
                    monitor-enter(r3)
                    com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzy$zza> r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzy.zza.zzg     // Catch: all -> 0x002c
                    if (r2 != 0) goto L_0x002a
                    com.google.android.gms.internal.mlkit_common.zzez$zzc r2 = new com.google.android.gms.internal.mlkit_common.zzez$zzc     // Catch: all -> 0x002c
                    com.google.android.gms.internal.mlkit_common.zzaa$zzy$zza r4 = com.google.android.gms.internal.mlkit_common.zzaa.zzy.zza.zzf     // Catch: all -> 0x002c
                    r2.<init>(r4)     // Catch: all -> 0x002c
                    com.google.android.gms.internal.mlkit_common.zzaa.zzy.zza.zzg = r2     // Catch: all -> 0x002c
                L_0x002a:
                    monitor-exit(r3)     // Catch: all -> 0x002c
                    goto L_0x002f
                L_0x002c:
                    r2 = move-exception
                    monitor-exit(r3)     // Catch: all -> 0x002c
                    throw r2
                L_0x002f:
                    return r2
                L_0x0030:
                    com.google.android.gms.internal.mlkit_common.zzaa$zzy$zza r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzy.zza.zzf
                    return r2
                L_0x0033:
                    r2 = 4
                    java.lang.Object[] r2 = new java.lang.Object[r2]
                    r3 = 0
                    java.lang.String r0 = "zzc"
                    r2[r3] = r0
                    java.lang.String r3 = "zzd"
                    r2[r4] = r3
                    r3 = 2
                    com.google.android.gms.internal.mlkit_common.zzfd r4 = com.google.android.gms.internal.mlkit_common.zzaa.zzy.zza.EnumC0113zza.zzb()
                    r2[r3] = r4
                    r3 = 3
                    java.lang.String r4 = "zze"
                    r2[r3] = r4
                    java.lang.String r3 = "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001ဌ\u0000\u0002\u0016"
                    com.google.android.gms.internal.mlkit_common.zzaa$zzy$zza r4 = com.google.android.gms.internal.mlkit_common.zzaa.zzy.zza.zzf
                    java.lang.Object r2 = com.google.android.gms.internal.mlkit_common.zzez.zza(r4, r3, r2)
                    return r2
                L_0x0054:
                    com.google.android.gms.internal.mlkit_common.zzaa$zzy$zza$zzb r2 = new com.google.android.gms.internal.mlkit_common.zzaa$zzy$zza$zzb
                    r2.<init>(r3)
                    return r2
                L_0x005a:
                    com.google.android.gms.internal.mlkit_common.zzaa$zzy$zza r2 = new com.google.android.gms.internal.mlkit_common.zzaa$zzy$zza
                    r2.<init>()
                    return r2
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzaa.zzy.zza.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
            }
        }
    }

    /* compiled from: com.google.mlkit:common@@16.0.0 */
    /* renamed from: com.google.android.gms.internal.mlkit_common.zzaa$zzaa  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0101zzaa extends zzez<C0101zzaa, zza> implements zzgj {
        private static final C0101zzaa zzf;
        private static volatile zzgr<C0101zzaa> zzg;
        private int zzc;
        private int zzd;
        private boolean zze;

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        /* renamed from: com.google.android.gms.internal.mlkit_common.zzaa$zzaa$zza */
        /* loaded from: classes.dex */
        public static final class zza extends zzez.zza<C0101zzaa, zza> implements zzgj {
            private zza() {
                super(C0101zzaa.zzf);
            }

            /* synthetic */ zza(zzac zzacVar) {
                this();
            }
        }

        static {
            C0101zzaa zzaaVar = new C0101zzaa();
            zzf = zzaaVar;
            zzez.zza(C0101zzaa.class, zzaaVar);
        }

        private C0101zzaa() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_common.zzez$zzc, com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzaa>] */
        /* JADX WARN: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_common.zzez
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_common.zzac.zza
                r4 = 1
                int r2 = r2 - r4
                r2 = r3[r2]
                r3 = 0
                switch(r2) {
                    case 1: goto L_0x005a;
                    case 2: goto L_0x0054;
                    case 3: goto L_0x0033;
                    case 4: goto L_0x0030;
                    case 5: goto L_0x0016;
                    case 6: goto L_0x0011;
                    case 7: goto L_0x0010;
                    default: goto L_0x000a;
                }
            L_0x000a:
                java.lang.UnsupportedOperationException r2 = new java.lang.UnsupportedOperationException
                r2.<init>()
                throw r2
            L_0x0010:
                return r3
            L_0x0011:
                java.lang.Byte r2 = java.lang.Byte.valueOf(r4)
                return r2
            L_0x0016:
                com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzaa> r2 = com.google.android.gms.internal.mlkit_common.zzaa.C0101zzaa.zzg
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_common.zzaa$zzaa> r3 = com.google.android.gms.internal.mlkit_common.zzaa.C0101zzaa.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzaa> r2 = com.google.android.gms.internal.mlkit_common.zzaa.C0101zzaa.zzg     // Catch: all -> 0x002c
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_common.zzez$zzc r2 = new com.google.android.gms.internal.mlkit_common.zzez$zzc     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_common.zzaa$zzaa r4 = com.google.android.gms.internal.mlkit_common.zzaa.C0101zzaa.zzf     // Catch: all -> 0x002c
                r2.<init>(r4)     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_common.zzaa.C0101zzaa.zzg = r2     // Catch: all -> 0x002c
            L_0x002a:
                monitor-exit(r3)     // Catch: all -> 0x002c
                goto L_0x002f
            L_0x002c:
                r2 = move-exception
                monitor-exit(r3)     // Catch: all -> 0x002c
                throw r2
            L_0x002f:
                return r2
            L_0x0030:
                com.google.android.gms.internal.mlkit_common.zzaa$zzaa r2 = com.google.android.gms.internal.mlkit_common.zzaa.C0101zzaa.zzf
                return r2
            L_0x0033:
                r2 = 4
                java.lang.Object[] r2 = new java.lang.Object[r2]
                r3 = 0
                java.lang.String r0 = "zzc"
                r2[r3] = r0
                java.lang.String r3 = "zzd"
                r2[r4] = r3
                r3 = 2
                com.google.android.gms.internal.mlkit_common.zzfd r4 = com.google.android.gms.internal.mlkit_common.zzaa.zzal.zza.zzb()
                r2[r3] = r4
                r3 = 3
                java.lang.String r4 = "zze"
                r2[r3] = r4
                java.lang.String r3 = "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဇ\u0001"
                com.google.android.gms.internal.mlkit_common.zzaa$zzaa r4 = com.google.android.gms.internal.mlkit_common.zzaa.C0101zzaa.zzf
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_common.zzez.zza(r4, r3, r2)
                return r2
            L_0x0054:
                com.google.android.gms.internal.mlkit_common.zzaa$zzaa$zza r2 = new com.google.android.gms.internal.mlkit_common.zzaa$zzaa$zza
                r2.<init>(r3)
                return r2
            L_0x005a:
                com.google.android.gms.internal.mlkit_common.zzaa$zzaa r2 = new com.google.android.gms.internal.mlkit_common.zzaa$zzaa
                r2.<init>()
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzaa.C0101zzaa.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: com.google.mlkit:common@@16.0.0 */
    /* loaded from: classes.dex */
    public static final class zzae extends zzez<zzae, zzb> implements zzgj {
        private static final zzae zzg;
        private static volatile zzgr<zzae> zzh;
        private int zzc;
        private int zzd;
        private int zze;
        private int zzf;

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        /* loaded from: classes.dex */
        public enum zza implements zzfb {
            UNKNOWN_FORMAT(0),
            NV16(1),
            NV21(2),
            YV12(3),
            YUV_420_888(7),
            JPEG(8),
            BITMAP(4),
            CM_SAMPLE_BUFFER_REF(5),
            UI_IMAGE(6);
            
            private static final zzfe<zza> zzj = new zzba();
            private final int zzk;

            zza(int i) {
                this.zzk = i;
            }

            public static zzfd zzb() {
                return zzaz.zza;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "<" + zza.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzk + " name=" + name() + '>';
            }

            @Override // com.google.android.gms.internal.mlkit_common.zzfb
            public final int zza() {
                return this.zzk;
            }
        }

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        /* loaded from: classes.dex */
        public static final class zzb extends zzez.zza<zzae, zzb> implements zzgj {
            private zzb() {
                super(zzae.zzg);
            }

            /* synthetic */ zzb(zzac zzacVar) {
                this();
            }
        }

        static {
            zzae zzaeVar = new zzae();
            zzg = zzaeVar;
            zzez.zza(zzae.class, zzaeVar);
        }

        private zzae() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_common.zzez$zzc, com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzae>] */
        /* JADX WARN: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_common.zzez
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_common.zzac.zza
                r4 = 1
                int r2 = r2 - r4
                r2 = r3[r2]
                r3 = 0
                switch(r2) {
                    case 1: goto L_0x005f;
                    case 2: goto L_0x0059;
                    case 3: goto L_0x0033;
                    case 4: goto L_0x0030;
                    case 5: goto L_0x0016;
                    case 6: goto L_0x0011;
                    case 7: goto L_0x0010;
                    default: goto L_0x000a;
                }
            L_0x000a:
                java.lang.UnsupportedOperationException r2 = new java.lang.UnsupportedOperationException
                r2.<init>()
                throw r2
            L_0x0010:
                return r3
            L_0x0011:
                java.lang.Byte r2 = java.lang.Byte.valueOf(r4)
                return r2
            L_0x0016:
                com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzae> r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzae.zzh
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_common.zzaa$zzae> r3 = com.google.android.gms.internal.mlkit_common.zzaa.zzae.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzae> r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzae.zzh     // Catch: all -> 0x002c
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_common.zzez$zzc r2 = new com.google.android.gms.internal.mlkit_common.zzez$zzc     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_common.zzaa$zzae r4 = com.google.android.gms.internal.mlkit_common.zzaa.zzae.zzg     // Catch: all -> 0x002c
                r2.<init>(r4)     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_common.zzaa.zzae.zzh = r2     // Catch: all -> 0x002c
            L_0x002a:
                monitor-exit(r3)     // Catch: all -> 0x002c
                goto L_0x002f
            L_0x002c:
                r2 = move-exception
                monitor-exit(r3)     // Catch: all -> 0x002c
                throw r2
            L_0x002f:
                return r2
            L_0x0030:
                com.google.android.gms.internal.mlkit_common.zzaa$zzae r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzae.zzg
                return r2
            L_0x0033:
                r2 = 5
                java.lang.Object[] r2 = new java.lang.Object[r2]
                r3 = 0
                java.lang.String r0 = "zzc"
                r2[r3] = r0
                java.lang.String r3 = "zzd"
                r2[r4] = r3
                r3 = 2
                com.google.android.gms.internal.mlkit_common.zzfd r4 = com.google.android.gms.internal.mlkit_common.zzaa.zzae.zza.zzb()
                r2[r3] = r4
                r3 = 3
                java.lang.String r4 = "zze"
                r2[r3] = r4
                r3 = 4
                java.lang.String r4 = "zzf"
                r2[r3] = r4
                java.lang.String r3 = "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဋ\u0001\u0003ဋ\u0002"
                com.google.android.gms.internal.mlkit_common.zzaa$zzae r4 = com.google.android.gms.internal.mlkit_common.zzaa.zzae.zzg
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_common.zzez.zza(r4, r3, r2)
                return r2
            L_0x0059:
                com.google.android.gms.internal.mlkit_common.zzaa$zzae$zzb r2 = new com.google.android.gms.internal.mlkit_common.zzaa$zzae$zzb
                r2.<init>(r3)
                return r2
            L_0x005f:
                com.google.android.gms.internal.mlkit_common.zzaa$zzae r2 = new com.google.android.gms.internal.mlkit_common.zzaa$zzae
                r2.<init>()
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzaa.zzae.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: com.google.mlkit:common@@16.0.0 */
    /* loaded from: classes.dex */
    public static final class zzaf extends zzez<zzaf, zza> implements zzgj {
        private static final zzaf zzk;
        private static volatile zzgr<zzaf> zzl;
        private int zzc;
        private long zzd;
        private int zze;
        private boolean zzf;
        private boolean zzg;
        private boolean zzh;
        private boolean zzi;
        private int zzj;

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        /* loaded from: classes.dex */
        public static final class zza extends zzez.zza<zzaf, zza> implements zzgj {
            private zza() {
                super(zzaf.zzk);
            }

            /* synthetic */ zza(zzac zzacVar) {
                this();
            }
        }

        static {
            zzaf zzafVar = new zzaf();
            zzk = zzafVar;
            zzez.zza(zzaf.class, zzafVar);
        }

        private zzaf() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzaf>, com.google.android.gms.internal.mlkit_common.zzez$zzc] */
        /* JADX WARN: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_common.zzez
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_common.zzac.zza
                r4 = 1
                int r2 = r2 - r4
                r2 = r3[r2]
                r3 = 0
                switch(r2) {
                    case 1: goto L_0x0075;
                    case 2: goto L_0x006f;
                    case 3: goto L_0x0033;
                    case 4: goto L_0x0030;
                    case 5: goto L_0x0016;
                    case 6: goto L_0x0011;
                    case 7: goto L_0x0010;
                    default: goto L_0x000a;
                }
            L_0x000a:
                java.lang.UnsupportedOperationException r2 = new java.lang.UnsupportedOperationException
                r2.<init>()
                throw r2
            L_0x0010:
                return r3
            L_0x0011:
                java.lang.Byte r2 = java.lang.Byte.valueOf(r4)
                return r2
            L_0x0016:
                com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzaf> r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzaf.zzl
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_common.zzaa$zzaf> r3 = com.google.android.gms.internal.mlkit_common.zzaa.zzaf.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzaf> r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzaf.zzl     // Catch: all -> 0x002c
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_common.zzez$zzc r2 = new com.google.android.gms.internal.mlkit_common.zzez$zzc     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_common.zzaa$zzaf r4 = com.google.android.gms.internal.mlkit_common.zzaa.zzaf.zzk     // Catch: all -> 0x002c
                r2.<init>(r4)     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_common.zzaa.zzaf.zzl = r2     // Catch: all -> 0x002c
            L_0x002a:
                monitor-exit(r3)     // Catch: all -> 0x002c
                goto L_0x002f
            L_0x002c:
                r2 = move-exception
                monitor-exit(r3)     // Catch: all -> 0x002c
                throw r2
            L_0x002f:
                return r2
            L_0x0030:
                com.google.android.gms.internal.mlkit_common.zzaa$zzaf r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzaf.zzk
                return r2
            L_0x0033:
                r2 = 9
                java.lang.Object[] r2 = new java.lang.Object[r2]
                r3 = 0
                java.lang.String r0 = "zzc"
                r2[r3] = r0
                java.lang.String r3 = "zzd"
                r2[r4] = r3
                r3 = 2
                java.lang.String r4 = "zze"
                r2[r3] = r4
                r3 = 3
                com.google.android.gms.internal.mlkit_common.zzfd r4 = com.google.android.gms.internal.mlkit_common.zzal.zzb()
                r2[r3] = r4
                r3 = 4
                java.lang.String r4 = "zzf"
                r2[r3] = r4
                r3 = 5
                java.lang.String r4 = "zzg"
                r2[r3] = r4
                r3 = 6
                java.lang.String r4 = "zzh"
                r2[r3] = r4
                r3 = 7
                java.lang.String r4 = "zzi"
                r2[r3] = r4
                r3 = 8
                java.lang.String r4 = "zzj"
                r2[r3] = r4
                java.lang.String r3 = "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0000\u0000\u0001ဃ\u0000\u0002ဌ\u0001\u0003ဇ\u0002\u0004ဇ\u0003\u0005ဇ\u0004\u0006ဇ\u0005\u0007ဋ\u0006"
                com.google.android.gms.internal.mlkit_common.zzaa$zzaf r4 = com.google.android.gms.internal.mlkit_common.zzaa.zzaf.zzk
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_common.zzez.zza(r4, r3, r2)
                return r2
            L_0x006f:
                com.google.android.gms.internal.mlkit_common.zzaa$zzaf$zza r2 = new com.google.android.gms.internal.mlkit_common.zzaa$zzaf$zza
                r2.<init>(r3)
                return r2
            L_0x0075:
                com.google.android.gms.internal.mlkit_common.zzaa$zzaf r2 = new com.google.android.gms.internal.mlkit_common.zzaa$zzaf
                r2.<init>()
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzaa.zzaf.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: com.google.mlkit:common@@16.0.0 */
    /* loaded from: classes.dex */
    public static final class zzah extends zzez<zzah, zza> implements zzgj {
        private static final zzah zzf;
        private static volatile zzgr<zzah> zzg;
        private int zzc;
        private int zzd;
        private boolean zze;

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        /* loaded from: classes.dex */
        public static final class zza extends zzez.zza<zzah, zza> implements zzgj {
            private zza() {
                super(zzah.zzf);
            }

            /* synthetic */ zza(zzac zzacVar) {
                this();
            }
        }

        static {
            zzah zzahVar = new zzah();
            zzf = zzahVar;
            zzez.zza(zzah.class, zzahVar);
        }

        private zzah() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzah>, com.google.android.gms.internal.mlkit_common.zzez$zzc] */
        /* JADX WARN: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_common.zzez
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_common.zzac.zza
                r4 = 1
                int r2 = r2 - r4
                r2 = r3[r2]
                r3 = 0
                switch(r2) {
                    case 1: goto L_0x005a;
                    case 2: goto L_0x0054;
                    case 3: goto L_0x0033;
                    case 4: goto L_0x0030;
                    case 5: goto L_0x0016;
                    case 6: goto L_0x0011;
                    case 7: goto L_0x0010;
                    default: goto L_0x000a;
                }
            L_0x000a:
                java.lang.UnsupportedOperationException r2 = new java.lang.UnsupportedOperationException
                r2.<init>()
                throw r2
            L_0x0010:
                return r3
            L_0x0011:
                java.lang.Byte r2 = java.lang.Byte.valueOf(r4)
                return r2
            L_0x0016:
                com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzah> r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzah.zzg
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_common.zzaa$zzah> r3 = com.google.android.gms.internal.mlkit_common.zzaa.zzah.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzah> r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzah.zzg     // Catch: all -> 0x002c
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_common.zzez$zzc r2 = new com.google.android.gms.internal.mlkit_common.zzez$zzc     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_common.zzaa$zzah r4 = com.google.android.gms.internal.mlkit_common.zzaa.zzah.zzf     // Catch: all -> 0x002c
                r2.<init>(r4)     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_common.zzaa.zzah.zzg = r2     // Catch: all -> 0x002c
            L_0x002a:
                monitor-exit(r3)     // Catch: all -> 0x002c
                goto L_0x002f
            L_0x002c:
                r2 = move-exception
                monitor-exit(r3)     // Catch: all -> 0x002c
                throw r2
            L_0x002f:
                return r2
            L_0x0030:
                com.google.android.gms.internal.mlkit_common.zzaa$zzah r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzah.zzf
                return r2
            L_0x0033:
                r2 = 4
                java.lang.Object[] r2 = new java.lang.Object[r2]
                r3 = 0
                java.lang.String r0 = "zzc"
                r2[r3] = r0
                java.lang.String r3 = "zzd"
                r2[r4] = r3
                r3 = 2
                com.google.android.gms.internal.mlkit_common.zzfd r4 = com.google.android.gms.internal.mlkit_common.zzaa.zzal.zza.zzb()
                r2[r3] = r4
                r3 = 3
                java.lang.String r4 = "zze"
                r2[r3] = r4
                java.lang.String r3 = "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဇ\u0001"
                com.google.android.gms.internal.mlkit_common.zzaa$zzah r4 = com.google.android.gms.internal.mlkit_common.zzaa.zzah.zzf
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_common.zzez.zza(r4, r3, r2)
                return r2
            L_0x0054:
                com.google.android.gms.internal.mlkit_common.zzaa$zzah$zza r2 = new com.google.android.gms.internal.mlkit_common.zzaa$zzah$zza
                r2.<init>(r3)
                return r2
            L_0x005a:
                com.google.android.gms.internal.mlkit_common.zzaa$zzah r2 = new com.google.android.gms.internal.mlkit_common.zzaa$zzah
                r2.<init>()
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzaa.zzah.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: com.google.mlkit:common@@16.0.0 */
    /* loaded from: classes.dex */
    public static final class zzan extends zzez<zzan, zzb> implements zzgj {
        private static final zzan zzh;
        private static volatile zzgr<zzan> zzi;
        private int zzc;
        private int zzd;
        private float zze;
        private int zzf;
        private int zzg;

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        /* loaded from: classes.dex */
        public enum zza implements zzfb {
            CATEGORY_UNKNOWN(0),
            CATEGORY_HOME_GOOD(1),
            CATEGORY_FASHION_GOOD(2),
            CATEGORY_ANIMAL(3),
            CATEGORY_FOOD(4),
            CATEGORY_PLACE(5),
            CATEGORY_PLANT(6);
            
            private static final zzfe<zza> zzh = new zzbm();
            private final int zzi;

            zza(int i) {
                this.zzi = i;
            }

            public static zzfd zzb() {
                return zzbl.zza;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "<" + zza.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzi + " name=" + name() + '>';
            }

            @Override // com.google.android.gms.internal.mlkit_common.zzfb
            public final int zza() {
                return this.zzi;
            }
        }

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        /* loaded from: classes.dex */
        public static final class zzb extends zzez.zza<zzan, zzb> implements zzgj {
            private zzb() {
                super(zzan.zzh);
            }

            /* synthetic */ zzb(zzac zzacVar) {
                this();
            }
        }

        static {
            zzan zzanVar = new zzan();
            zzh = zzanVar;
            zzez.zza(zzan.class, zzanVar);
        }

        private zzan() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_common.zzez$zzc, com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzan>] */
        /* JADX WARN: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_common.zzez
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_common.zzac.zza
                r4 = 1
                int r2 = r2 - r4
                r2 = r3[r2]
                r3 = 0
                switch(r2) {
                    case 1: goto L_0x0064;
                    case 2: goto L_0x005e;
                    case 3: goto L_0x0033;
                    case 4: goto L_0x0030;
                    case 5: goto L_0x0016;
                    case 6: goto L_0x0011;
                    case 7: goto L_0x0010;
                    default: goto L_0x000a;
                }
            L_0x000a:
                java.lang.UnsupportedOperationException r2 = new java.lang.UnsupportedOperationException
                r2.<init>()
                throw r2
            L_0x0010:
                return r3
            L_0x0011:
                java.lang.Byte r2 = java.lang.Byte.valueOf(r4)
                return r2
            L_0x0016:
                com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzan> r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzan.zzi
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_common.zzaa$zzan> r3 = com.google.android.gms.internal.mlkit_common.zzaa.zzan.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzan> r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzan.zzi     // Catch: all -> 0x002c
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_common.zzez$zzc r2 = new com.google.android.gms.internal.mlkit_common.zzez$zzc     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_common.zzaa$zzan r4 = com.google.android.gms.internal.mlkit_common.zzaa.zzan.zzh     // Catch: all -> 0x002c
                r2.<init>(r4)     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_common.zzaa.zzan.zzi = r2     // Catch: all -> 0x002c
            L_0x002a:
                monitor-exit(r3)     // Catch: all -> 0x002c
                goto L_0x002f
            L_0x002c:
                r2 = move-exception
                monitor-exit(r3)     // Catch: all -> 0x002c
                throw r2
            L_0x002f:
                return r2
            L_0x0030:
                com.google.android.gms.internal.mlkit_common.zzaa$zzan r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzan.zzh
                return r2
            L_0x0033:
                r2 = 6
                java.lang.Object[] r2 = new java.lang.Object[r2]
                r3 = 0
                java.lang.String r0 = "zzc"
                r2[r3] = r0
                java.lang.String r3 = "zzd"
                r2[r4] = r3
                r3 = 2
                com.google.android.gms.internal.mlkit_common.zzfd r4 = com.google.android.gms.internal.mlkit_common.zzaa.zzan.zza.zzb()
                r2[r3] = r4
                r3 = 3
                java.lang.String r4 = "zze"
                r2[r3] = r4
                r3 = 4
                java.lang.String r4 = "zzf"
                r2[r3] = r4
                r3 = 5
                java.lang.String r4 = "zzg"
                r2[r3] = r4
                java.lang.String r3 = "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဌ\u0000\u0002ခ\u0001\u0003င\u0002\u0004ဋ\u0003"
                com.google.android.gms.internal.mlkit_common.zzaa$zzan r4 = com.google.android.gms.internal.mlkit_common.zzaa.zzan.zzh
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_common.zzez.zza(r4, r3, r2)
                return r2
            L_0x005e:
                com.google.android.gms.internal.mlkit_common.zzaa$zzan$zzb r2 = new com.google.android.gms.internal.mlkit_common.zzaa$zzan$zzb
                r2.<init>(r3)
                return r2
            L_0x0064:
                com.google.android.gms.internal.mlkit_common.zzaa$zzan r2 = new com.google.android.gms.internal.mlkit_common.zzaa$zzan
                r2.<init>()
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzaa.zzan.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: com.google.mlkit:common@@16.0.0 */
    /* loaded from: classes.dex */
    public static final class zzaq extends zzez<zzaq, zza> implements zzgj {
        private static final zzaq zzf;
        private static volatile zzgr<zzaq> zzg;
        private int zzc;
        private zzat zzd;
        private int zze;

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        /* loaded from: classes.dex */
        public static final class zza extends zzez.zza<zzaq, zza> implements zzgj {
            private zza() {
                super(zzaq.zzf);
            }

            /* synthetic */ zza(zzac zzacVar) {
                this();
            }
        }

        static {
            zzaq zzaqVar = new zzaq();
            zzf = zzaqVar;
            zzez.zza(zzaq.class, zzaqVar);
        }

        private zzaq() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_common.zzez$zzc, com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzaq>] */
        /* JADX WARN: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_common.zzez
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_common.zzac.zza
                r4 = 1
                int r2 = r2 - r4
                r2 = r3[r2]
                r3 = 0
                switch(r2) {
                    case 1: goto L_0x005a;
                    case 2: goto L_0x0054;
                    case 3: goto L_0x0033;
                    case 4: goto L_0x0030;
                    case 5: goto L_0x0016;
                    case 6: goto L_0x0011;
                    case 7: goto L_0x0010;
                    default: goto L_0x000a;
                }
            L_0x000a:
                java.lang.UnsupportedOperationException r2 = new java.lang.UnsupportedOperationException
                r2.<init>()
                throw r2
            L_0x0010:
                return r3
            L_0x0011:
                java.lang.Byte r2 = java.lang.Byte.valueOf(r4)
                return r2
            L_0x0016:
                com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzaq> r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzaq.zzg
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_common.zzaa$zzaq> r3 = com.google.android.gms.internal.mlkit_common.zzaa.zzaq.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzaq> r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzaq.zzg     // Catch: all -> 0x002c
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_common.zzez$zzc r2 = new com.google.android.gms.internal.mlkit_common.zzez$zzc     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_common.zzaa$zzaq r4 = com.google.android.gms.internal.mlkit_common.zzaa.zzaq.zzf     // Catch: all -> 0x002c
                r2.<init>(r4)     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_common.zzaa.zzaq.zzg = r2     // Catch: all -> 0x002c
            L_0x002a:
                monitor-exit(r3)     // Catch: all -> 0x002c
                goto L_0x002f
            L_0x002c:
                r2 = move-exception
                monitor-exit(r3)     // Catch: all -> 0x002c
                throw r2
            L_0x002f:
                return r2
            L_0x0030:
                com.google.android.gms.internal.mlkit_common.zzaa$zzaq r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzaq.zzf
                return r2
            L_0x0033:
                r2 = 4
                java.lang.Object[] r2 = new java.lang.Object[r2]
                r3 = 0
                java.lang.String r0 = "zzc"
                r2[r3] = r0
                java.lang.String r3 = "zzd"
                r2[r4] = r3
                r3 = 2
                java.lang.String r4 = "zze"
                r2[r3] = r4
                r3 = 3
                com.google.android.gms.internal.mlkit_common.zzfd r4 = com.google.android.gms.internal.mlkit_common.zzal.zzb()
                r2[r3] = r4
                java.lang.String r3 = "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဌ\u0001"
                com.google.android.gms.internal.mlkit_common.zzaa$zzaq r4 = com.google.android.gms.internal.mlkit_common.zzaa.zzaq.zzf
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_common.zzez.zza(r4, r3, r2)
                return r2
            L_0x0054:
                com.google.android.gms.internal.mlkit_common.zzaa$zzaq$zza r2 = new com.google.android.gms.internal.mlkit_common.zzaa$zzaq$zza
                r2.<init>(r3)
                return r2
            L_0x005a:
                com.google.android.gms.internal.mlkit_common.zzaa$zzaq r2 = new com.google.android.gms.internal.mlkit_common.zzaa$zzaq
                r2.<init>()
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzaa.zzaq.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: com.google.mlkit:common@@16.0.0 */
    /* loaded from: classes.dex */
    public static final class zzas extends zzez<zzas, zza> implements zzgj {
        private static final zzff<Integer, zzal> zzf = new zzbt();
        private static final zzas zzi;
        private static volatile zzgr<zzas> zzj;
        private int zzc;
        private zzat zzd;
        private zzfg zze = zzez.zzk();
        private long zzg;
        private long zzh;

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        /* loaded from: classes.dex */
        public static final class zza extends zzez.zza<zzas, zza> implements zzgj {
            private zza() {
                super(zzas.zzi);
            }

            /* synthetic */ zza(zzac zzacVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [com.google.android.gms.internal.mlkit_common.zzff<java.lang.Integer, com.google.android.gms.internal.mlkit_common.zzal>, com.google.android.gms.internal.mlkit_common.zzbt] */
        static {
            zzas zzasVar = new zzas();
            zzi = zzasVar;
            zzez.zza(zzas.class, zzasVar);
        }

        private zzas() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_common.zzez$zzc, com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzas>] */
        /* JADX WARN: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_common.zzez
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_common.zzac.zza
                r4 = 1
                int r2 = r2 - r4
                r2 = r3[r2]
                r3 = 0
                switch(r2) {
                    case 1: goto L_0x0064;
                    case 2: goto L_0x005e;
                    case 3: goto L_0x0033;
                    case 4: goto L_0x0030;
                    case 5: goto L_0x0016;
                    case 6: goto L_0x0011;
                    case 7: goto L_0x0010;
                    default: goto L_0x000a;
                }
            L_0x000a:
                java.lang.UnsupportedOperationException r2 = new java.lang.UnsupportedOperationException
                r2.<init>()
                throw r2
            L_0x0010:
                return r3
            L_0x0011:
                java.lang.Byte r2 = java.lang.Byte.valueOf(r4)
                return r2
            L_0x0016:
                com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzas> r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzas.zzj
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_common.zzaa$zzas> r3 = com.google.android.gms.internal.mlkit_common.zzaa.zzas.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzas> r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzas.zzj     // Catch: all -> 0x002c
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_common.zzez$zzc r2 = new com.google.android.gms.internal.mlkit_common.zzez$zzc     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_common.zzaa$zzas r4 = com.google.android.gms.internal.mlkit_common.zzaa.zzas.zzi     // Catch: all -> 0x002c
                r2.<init>(r4)     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_common.zzaa.zzas.zzj = r2     // Catch: all -> 0x002c
            L_0x002a:
                monitor-exit(r3)     // Catch: all -> 0x002c
                goto L_0x002f
            L_0x002c:
                r2 = move-exception
                monitor-exit(r3)     // Catch: all -> 0x002c
                throw r2
            L_0x002f:
                return r2
            L_0x0030:
                com.google.android.gms.internal.mlkit_common.zzaa$zzas r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzas.zzi
                return r2
            L_0x0033:
                r2 = 6
                java.lang.Object[] r2 = new java.lang.Object[r2]
                r3 = 0
                java.lang.String r0 = "zzc"
                r2[r3] = r0
                java.lang.String r3 = "zzd"
                r2[r4] = r3
                r3 = 2
                java.lang.String r4 = "zze"
                r2[r3] = r4
                r3 = 3
                com.google.android.gms.internal.mlkit_common.zzfd r4 = com.google.android.gms.internal.mlkit_common.zzal.zzb()
                r2[r3] = r4
                r3 = 4
                java.lang.String r4 = "zzg"
                r2[r3] = r4
                r3 = 5
                java.lang.String r4 = "zzh"
                r2[r3] = r4
                java.lang.String r3 = "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001ဉ\u0000\u0002\u001e\u0003ဃ\u0001\u0004ဃ\u0002"
                com.google.android.gms.internal.mlkit_common.zzaa$zzas r4 = com.google.android.gms.internal.mlkit_common.zzaa.zzas.zzi
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_common.zzez.zza(r4, r3, r2)
                return r2
            L_0x005e:
                com.google.android.gms.internal.mlkit_common.zzaa$zzas$zza r2 = new com.google.android.gms.internal.mlkit_common.zzaa$zzas$zza
                r2.<init>(r3)
                return r2
            L_0x0064:
                com.google.android.gms.internal.mlkit_common.zzaa$zzas r2 = new com.google.android.gms.internal.mlkit_common.zzaa$zzas
                r2.<init>()
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzaa.zzas.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: com.google.mlkit:common@@16.0.0 */
    /* loaded from: classes.dex */
    public static final class zzav extends zzez<zzav, zza> implements zzgj {
        private static final zzav zzf;
        private static volatile zzgr<zzav> zzg;
        private int zzc;
        private zzaw zzd;
        private int zze;

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        /* loaded from: classes.dex */
        public static final class zza extends zzez.zza<zzav, zza> implements zzgj {
            private zza() {
                super(zzav.zzf);
            }

            /* synthetic */ zza(zzac zzacVar) {
                this();
            }
        }

        static {
            zzav zzavVar = new zzav();
            zzf = zzavVar;
            zzez.zza(zzav.class, zzavVar);
        }

        private zzav() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzav>, com.google.android.gms.internal.mlkit_common.zzez$zzc] */
        /* JADX WARN: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_common.zzez
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_common.zzac.zza
                r4 = 1
                int r2 = r2 - r4
                r2 = r3[r2]
                r3 = 0
                switch(r2) {
                    case 1: goto L_0x005a;
                    case 2: goto L_0x0054;
                    case 3: goto L_0x0033;
                    case 4: goto L_0x0030;
                    case 5: goto L_0x0016;
                    case 6: goto L_0x0011;
                    case 7: goto L_0x0010;
                    default: goto L_0x000a;
                }
            L_0x000a:
                java.lang.UnsupportedOperationException r2 = new java.lang.UnsupportedOperationException
                r2.<init>()
                throw r2
            L_0x0010:
                return r3
            L_0x0011:
                java.lang.Byte r2 = java.lang.Byte.valueOf(r4)
                return r2
            L_0x0016:
                com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzav> r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzav.zzg
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_common.zzaa$zzav> r3 = com.google.android.gms.internal.mlkit_common.zzaa.zzav.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzav> r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzav.zzg     // Catch: all -> 0x002c
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_common.zzez$zzc r2 = new com.google.android.gms.internal.mlkit_common.zzez$zzc     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_common.zzaa$zzav r4 = com.google.android.gms.internal.mlkit_common.zzaa.zzav.zzf     // Catch: all -> 0x002c
                r2.<init>(r4)     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_common.zzaa.zzav.zzg = r2     // Catch: all -> 0x002c
            L_0x002a:
                monitor-exit(r3)     // Catch: all -> 0x002c
                goto L_0x002f
            L_0x002c:
                r2 = move-exception
                monitor-exit(r3)     // Catch: all -> 0x002c
                throw r2
            L_0x002f:
                return r2
            L_0x0030:
                com.google.android.gms.internal.mlkit_common.zzaa$zzav r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzav.zzf
                return r2
            L_0x0033:
                r2 = 4
                java.lang.Object[] r2 = new java.lang.Object[r2]
                r3 = 0
                java.lang.String r0 = "zzc"
                r2[r3] = r0
                java.lang.String r3 = "zzd"
                r2[r4] = r3
                r3 = 2
                java.lang.String r4 = "zze"
                r2[r3] = r4
                r3 = 3
                com.google.android.gms.internal.mlkit_common.zzfd r4 = com.google.android.gms.internal.mlkit_common.zzal.zzb()
                r2[r3] = r4
                java.lang.String r3 = "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဌ\u0001"
                com.google.android.gms.internal.mlkit_common.zzaa$zzav r4 = com.google.android.gms.internal.mlkit_common.zzaa.zzav.zzf
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_common.zzez.zza(r4, r3, r2)
                return r2
            L_0x0054:
                com.google.android.gms.internal.mlkit_common.zzaa$zzav$zza r2 = new com.google.android.gms.internal.mlkit_common.zzaa$zzav$zza
                r2.<init>(r3)
                return r2
            L_0x005a:
                com.google.android.gms.internal.mlkit_common.zzaa$zzav r2 = new com.google.android.gms.internal.mlkit_common.zzaa$zzav
                r2.<init>()
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzaa.zzav.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: com.google.mlkit:common@@16.0.0 */
    /* loaded from: classes.dex */
    public static final class zzaw extends zzez<zzaw, zzb> implements zzgj {
        private static final zzaw zzj;
        private static volatile zzgr<zzaw> zzk;
        private int zzc;
        private int zzd;
        private boolean zze;
        private boolean zzf;
        private int zzg;
        private float zzh;
        private zzam zzi;

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        /* loaded from: classes.dex */
        public enum zza implements zzfb {
            MODE_UNSPECIFIED(0),
            STREAM(1),
            SINGLE_IMAGE(2);
            
            private static final zzfe<zza> zzd = new zzbv();
            private final int zze;

            zza(int i) {
                this.zze = i;
            }

            public static zzfd zzb() {
                return zzbu.zza;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "<" + zza.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zze + " name=" + name() + '>';
            }

            @Override // com.google.android.gms.internal.mlkit_common.zzfb
            public final int zza() {
                return this.zze;
            }
        }

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        /* loaded from: classes.dex */
        public static final class zzb extends zzez.zza<zzaw, zzb> implements zzgj {
            private zzb() {
                super(zzaw.zzj);
            }

            /* synthetic */ zzb(zzac zzacVar) {
                this();
            }
        }

        static {
            zzaw zzawVar = new zzaw();
            zzj = zzawVar;
            zzez.zza(zzaw.class, zzawVar);
        }

        private zzaw() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzaw>, com.google.android.gms.internal.mlkit_common.zzez$zzc] */
        /* JADX WARN: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_common.zzez
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_common.zzac.zza
                r4 = 1
                int r2 = r2 - r4
                r2 = r3[r2]
                r3 = 0
                switch(r2) {
                    case 1: goto L_0x006f;
                    case 2: goto L_0x0069;
                    case 3: goto L_0x0033;
                    case 4: goto L_0x0030;
                    case 5: goto L_0x0016;
                    case 6: goto L_0x0011;
                    case 7: goto L_0x0010;
                    default: goto L_0x000a;
                }
            L_0x000a:
                java.lang.UnsupportedOperationException r2 = new java.lang.UnsupportedOperationException
                r2.<init>()
                throw r2
            L_0x0010:
                return r3
            L_0x0011:
                java.lang.Byte r2 = java.lang.Byte.valueOf(r4)
                return r2
            L_0x0016:
                com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzaw> r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzaw.zzk
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_common.zzaa$zzaw> r3 = com.google.android.gms.internal.mlkit_common.zzaa.zzaw.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzaw> r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzaw.zzk     // Catch: all -> 0x002c
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_common.zzez$zzc r2 = new com.google.android.gms.internal.mlkit_common.zzez$zzc     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_common.zzaa$zzaw r4 = com.google.android.gms.internal.mlkit_common.zzaa.zzaw.zzj     // Catch: all -> 0x002c
                r2.<init>(r4)     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_common.zzaa.zzaw.zzk = r2     // Catch: all -> 0x002c
            L_0x002a:
                monitor-exit(r3)     // Catch: all -> 0x002c
                goto L_0x002f
            L_0x002c:
                r2 = move-exception
                monitor-exit(r3)     // Catch: all -> 0x002c
                throw r2
            L_0x002f:
                return r2
            L_0x0030:
                com.google.android.gms.internal.mlkit_common.zzaa$zzaw r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzaw.zzj
                return r2
            L_0x0033:
                r2 = 8
                java.lang.Object[] r2 = new java.lang.Object[r2]
                r3 = 0
                java.lang.String r0 = "zzc"
                r2[r3] = r0
                java.lang.String r3 = "zzd"
                r2[r4] = r3
                r3 = 2
                com.google.android.gms.internal.mlkit_common.zzfd r4 = com.google.android.gms.internal.mlkit_common.zzaa.zzaw.zza.zzb()
                r2[r3] = r4
                r3 = 3
                java.lang.String r4 = "zze"
                r2[r3] = r4
                r3 = 4
                java.lang.String r4 = "zzf"
                r2[r3] = r4
                r3 = 5
                java.lang.String r4 = "zzg"
                r2[r3] = r4
                r3 = 6
                java.lang.String r4 = "zzh"
                r2[r3] = r4
                r3 = 7
                java.lang.String r4 = "zzi"
                r2[r3] = r4
                java.lang.String r3 = "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဇ\u0001\u0003ဇ\u0002\u0004ဋ\u0003\u0005ခ\u0004\u0006ဉ\u0005"
                com.google.android.gms.internal.mlkit_common.zzaa$zzaw r4 = com.google.android.gms.internal.mlkit_common.zzaa.zzaw.zzj
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_common.zzez.zza(r4, r3, r2)
                return r2
            L_0x0069:
                com.google.android.gms.internal.mlkit_common.zzaa$zzaw$zzb r2 = new com.google.android.gms.internal.mlkit_common.zzaa$zzaw$zzb
                r2.<init>(r3)
                return r2
            L_0x006f:
                com.google.android.gms.internal.mlkit_common.zzaa$zzaw r2 = new com.google.android.gms.internal.mlkit_common.zzaa$zzaw
                r2.<init>()
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzaa.zzaw.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: com.google.mlkit:common@@16.0.0 */
    /* loaded from: classes.dex */
    public static final class zzax extends zzez<zzax, zza> implements zzgj {
        private static final zzax zzh;
        private static volatile zzgr<zzax> zzi;
        private int zzc;
        private zzaf zzd;
        private zzae zze;
        private zzaw zzf;
        private zzfi<zzan> zzg = zzez.zzl();

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        /* loaded from: classes.dex */
        public static final class zza extends zzez.zza<zzax, zza> implements zzgj {
            private zza() {
                super(zzax.zzh);
            }

            /* synthetic */ zza(zzac zzacVar) {
                this();
            }
        }

        static {
            zzax zzaxVar = new zzax();
            zzh = zzaxVar;
            zzez.zza(zzax.class, zzaxVar);
        }

        private zzax() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzax>, com.google.android.gms.internal.mlkit_common.zzez$zzc] */
        /* JADX WARN: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_common.zzez
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_common.zzac.zza
                r4 = 1
                int r2 = r2 - r4
                r2 = r3[r2]
                r3 = 0
                switch(r2) {
                    case 1: goto L_0x0062;
                    case 2: goto L_0x005c;
                    case 3: goto L_0x0033;
                    case 4: goto L_0x0030;
                    case 5: goto L_0x0016;
                    case 6: goto L_0x0011;
                    case 7: goto L_0x0010;
                    default: goto L_0x000a;
                }
            L_0x000a:
                java.lang.UnsupportedOperationException r2 = new java.lang.UnsupportedOperationException
                r2.<init>()
                throw r2
            L_0x0010:
                return r3
            L_0x0011:
                java.lang.Byte r2 = java.lang.Byte.valueOf(r4)
                return r2
            L_0x0016:
                com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzax> r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzax.zzi
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_common.zzaa$zzax> r3 = com.google.android.gms.internal.mlkit_common.zzaa.zzax.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzax> r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzax.zzi     // Catch: all -> 0x002c
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_common.zzez$zzc r2 = new com.google.android.gms.internal.mlkit_common.zzez$zzc     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_common.zzaa$zzax r4 = com.google.android.gms.internal.mlkit_common.zzaa.zzax.zzh     // Catch: all -> 0x002c
                r2.<init>(r4)     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_common.zzaa.zzax.zzi = r2     // Catch: all -> 0x002c
            L_0x002a:
                monitor-exit(r3)     // Catch: all -> 0x002c
                goto L_0x002f
            L_0x002c:
                r2 = move-exception
                monitor-exit(r3)     // Catch: all -> 0x002c
                throw r2
            L_0x002f:
                return r2
            L_0x0030:
                com.google.android.gms.internal.mlkit_common.zzaa$zzax r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzax.zzh
                return r2
            L_0x0033:
                r2 = 6
                java.lang.Object[] r2 = new java.lang.Object[r2]
                r3 = 0
                java.lang.String r0 = "zzc"
                r2[r3] = r0
                java.lang.String r3 = "zzd"
                r2[r4] = r3
                r3 = 2
                java.lang.String r4 = "zze"
                r2[r3] = r4
                r3 = 3
                java.lang.String r4 = "zzf"
                r2[r3] = r4
                r3 = 4
                java.lang.String r4 = "zzg"
                r2[r3] = r4
                r3 = 5
                java.lang.Class<com.google.android.gms.internal.mlkit_common.zzaa$zzan> r4 = com.google.android.gms.internal.mlkit_common.zzaa.zzan.class
                r2[r3] = r4
                java.lang.String r3 = "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002\u0004\u001b"
                com.google.android.gms.internal.mlkit_common.zzaa$zzax r4 = com.google.android.gms.internal.mlkit_common.zzaa.zzax.zzh
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_common.zzez.zza(r4, r3, r2)
                return r2
            L_0x005c:
                com.google.android.gms.internal.mlkit_common.zzaa$zzax$zza r2 = new com.google.android.gms.internal.mlkit_common.zzaa$zzax$zza
                r2.<init>(r3)
                return r2
            L_0x0062:
                com.google.android.gms.internal.mlkit_common.zzaa$zzax r2 = new com.google.android.gms.internal.mlkit_common.zzaa$zzax
                r2.<init>()
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzaa.zzax.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: com.google.mlkit:common@@16.0.0 */
    /* loaded from: classes.dex */
    public static final class zzay extends zzez<zzay, zza> implements zzgj {
        private static final zzay zzh;
        private static volatile zzgr<zzay> zzi;
        private int zzc;
        private zzaw zzd;
        private int zze;
        private long zzf;
        private long zzg;

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        /* loaded from: classes.dex */
        public static final class zza extends zzez.zza<zzay, zza> implements zzgj {
            private zza() {
                super(zzay.zzh);
            }

            /* synthetic */ zza(zzac zzacVar) {
                this();
            }
        }

        static {
            zzay zzayVar = new zzay();
            zzh = zzayVar;
            zzez.zza(zzay.class, zzayVar);
        }

        private zzay() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzay>, com.google.android.gms.internal.mlkit_common.zzez$zzc] */
        /* JADX WARN: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_common.zzez
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_common.zzac.zza
                r4 = 1
                int r2 = r2 - r4
                r2 = r3[r2]
                r3 = 0
                switch(r2) {
                    case 1: goto L_0x0064;
                    case 2: goto L_0x005e;
                    case 3: goto L_0x0033;
                    case 4: goto L_0x0030;
                    case 5: goto L_0x0016;
                    case 6: goto L_0x0011;
                    case 7: goto L_0x0010;
                    default: goto L_0x000a;
                }
            L_0x000a:
                java.lang.UnsupportedOperationException r2 = new java.lang.UnsupportedOperationException
                r2.<init>()
                throw r2
            L_0x0010:
                return r3
            L_0x0011:
                java.lang.Byte r2 = java.lang.Byte.valueOf(r4)
                return r2
            L_0x0016:
                com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzay> r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzay.zzi
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_common.zzaa$zzay> r3 = com.google.android.gms.internal.mlkit_common.zzaa.zzay.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzay> r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzay.zzi     // Catch: all -> 0x002c
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_common.zzez$zzc r2 = new com.google.android.gms.internal.mlkit_common.zzez$zzc     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_common.zzaa$zzay r4 = com.google.android.gms.internal.mlkit_common.zzaa.zzay.zzh     // Catch: all -> 0x002c
                r2.<init>(r4)     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_common.zzaa.zzay.zzi = r2     // Catch: all -> 0x002c
            L_0x002a:
                monitor-exit(r3)     // Catch: all -> 0x002c
                goto L_0x002f
            L_0x002c:
                r2 = move-exception
                monitor-exit(r3)     // Catch: all -> 0x002c
                throw r2
            L_0x002f:
                return r2
            L_0x0030:
                com.google.android.gms.internal.mlkit_common.zzaa$zzay r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzay.zzh
                return r2
            L_0x0033:
                r2 = 6
                java.lang.Object[] r2 = new java.lang.Object[r2]
                r3 = 0
                java.lang.String r0 = "zzc"
                r2[r3] = r0
                java.lang.String r3 = "zzd"
                r2[r4] = r3
                r3 = 2
                java.lang.String r4 = "zze"
                r2[r3] = r4
                r3 = 3
                com.google.android.gms.internal.mlkit_common.zzfd r4 = com.google.android.gms.internal.mlkit_common.zzal.zzb()
                r2[r3] = r4
                r3 = 4
                java.lang.String r4 = "zzf"
                r2[r3] = r4
                r3 = 5
                java.lang.String r4 = "zzg"
                r2[r3] = r4
                java.lang.String r3 = "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဌ\u0001\u0003ဃ\u0002\u0004ဃ\u0003"
                com.google.android.gms.internal.mlkit_common.zzaa$zzay r4 = com.google.android.gms.internal.mlkit_common.zzaa.zzay.zzh
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_common.zzez.zza(r4, r3, r2)
                return r2
            L_0x005e:
                com.google.android.gms.internal.mlkit_common.zzaa$zzay$zza r2 = new com.google.android.gms.internal.mlkit_common.zzaa$zzay$zza
                r2.<init>(r3)
                return r2
            L_0x0064:
                com.google.android.gms.internal.mlkit_common.zzaa$zzay r2 = new com.google.android.gms.internal.mlkit_common.zzaa$zzay
                r2.<init>()
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzaa.zzay.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: com.google.mlkit:common@@16.0.0 */
    /* loaded from: classes.dex */
    public static final class zzbe extends zzez<zzbe, zzb> implements zzgj {
        private static final zzbe zzl;
        private static volatile zzgr<zzbe> zzm;
        private int zzc;
        private zzaf zzd;
        private zzbh zze;
        private int zzf;
        private int zzg;
        private int zzh;
        private int zzi;
        private int zzj;
        private int zzk;

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        /* loaded from: classes.dex */
        public enum zza implements zzfb {
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
            
            private static final zzfe<zza> zzai = new zzcd();
            private final int zzaj;

            zza(int i) {
                this.zzaj = i;
            }

            public static zzfd zzb() {
                return zzcc.zza;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "<" + zza.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzaj + " name=" + name() + '>';
            }

            @Override // com.google.android.gms.internal.mlkit_common.zzfb
            public final int zza() {
                return this.zzaj;
            }
        }

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        /* loaded from: classes.dex */
        public static final class zzb extends zzez.zza<zzbe, zzb> implements zzgj {
            private zzb() {
                super(zzbe.zzl);
            }

            /* synthetic */ zzb(zzac zzacVar) {
                this();
            }
        }

        static {
            zzbe zzbeVar = new zzbe();
            zzl = zzbeVar;
            zzez.zza(zzbe.class, zzbeVar);
        }

        private zzbe() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_common.zzez$zzc, com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzbe>] */
        /* JADX WARN: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_common.zzez
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_common.zzac.zza
                r4 = 1
                int r2 = r2 - r4
                r2 = r3[r2]
                r3 = 0
                switch(r2) {
                    case 1: goto L_0x007b;
                    case 2: goto L_0x0075;
                    case 3: goto L_0x0033;
                    case 4: goto L_0x0030;
                    case 5: goto L_0x0016;
                    case 6: goto L_0x0011;
                    case 7: goto L_0x0010;
                    default: goto L_0x000a;
                }
            L_0x000a:
                java.lang.UnsupportedOperationException r2 = new java.lang.UnsupportedOperationException
                r2.<init>()
                throw r2
            L_0x0010:
                return r3
            L_0x0011:
                java.lang.Byte r2 = java.lang.Byte.valueOf(r4)
                return r2
            L_0x0016:
                com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzbe> r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzbe.zzm
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_common.zzaa$zzbe> r3 = com.google.android.gms.internal.mlkit_common.zzaa.zzbe.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzbe> r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzbe.zzm     // Catch: all -> 0x002c
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_common.zzez$zzc r2 = new com.google.android.gms.internal.mlkit_common.zzez$zzc     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_common.zzaa$zzbe r4 = com.google.android.gms.internal.mlkit_common.zzaa.zzbe.zzl     // Catch: all -> 0x002c
                r2.<init>(r4)     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_common.zzaa.zzbe.zzm = r2     // Catch: all -> 0x002c
            L_0x002a:
                monitor-exit(r3)     // Catch: all -> 0x002c
                goto L_0x002f
            L_0x002c:
                r2 = move-exception
                monitor-exit(r3)     // Catch: all -> 0x002c
                throw r2
            L_0x002f:
                return r2
            L_0x0030:
                com.google.android.gms.internal.mlkit_common.zzaa$zzbe r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzbe.zzl
                return r2
            L_0x0033:
                r2 = 10
                java.lang.Object[] r2 = new java.lang.Object[r2]
                r3 = 0
                java.lang.String r0 = "zzc"
                r2[r3] = r0
                java.lang.String r3 = "zzd"
                r2[r4] = r3
                r3 = 2
                java.lang.String r4 = "zze"
                r2[r3] = r4
                r3 = 3
                java.lang.String r4 = "zzf"
                r2[r3] = r4
                r3 = 4
                java.lang.String r4 = "zzg"
                r2[r3] = r4
                r3 = 5
                java.lang.String r4 = "zzh"
                r2[r3] = r4
                r3 = 6
                java.lang.String r4 = "zzi"
                r2[r3] = r4
                r3 = 7
                java.lang.String r4 = "zzj"
                r2[r3] = r4
                r3 = 8
                com.google.android.gms.internal.mlkit_common.zzfd r4 = com.google.android.gms.internal.mlkit_common.zzaa.zzbe.zza.zzb()
                r2[r3] = r4
                r3 = 9
                java.lang.String r4 = "zzk"
                r2[r3] = r4
                java.lang.String r3 = "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003င\u0002\u0004င\u0003\u0005င\u0004\u0006င\u0005\u0007ဌ\u0006\bင\u0007"
                com.google.android.gms.internal.mlkit_common.zzaa$zzbe r4 = com.google.android.gms.internal.mlkit_common.zzaa.zzbe.zzl
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_common.zzez.zza(r4, r3, r2)
                return r2
            L_0x0075:
                com.google.android.gms.internal.mlkit_common.zzaa$zzbe$zzb r2 = new com.google.android.gms.internal.mlkit_common.zzaa$zzbe$zzb
                r2.<init>(r3)
                return r2
            L_0x007b:
                com.google.android.gms.internal.mlkit_common.zzaa$zzbe r2 = new com.google.android.gms.internal.mlkit_common.zzaa$zzbe
                r2.<init>()
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzaa.zzbe.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: com.google.mlkit:common@@16.0.0 */
    /* loaded from: classes.dex */
    public static final class zzj extends zzez<zzj, zza> implements zzgj {
        private static final zzj zze;
        private static volatile zzgr<zzj> zzf;
        private int zzc;
        private int zzd;

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        /* loaded from: classes.dex */
        public static final class zza extends zzez.zza<zzj, zza> implements zzgj {
            private zza() {
                super(zzj.zze);
            }

            /* synthetic */ zza(zzac zzacVar) {
                this();
            }
        }

        static {
            zzj zzjVar = new zzj();
            zze = zzjVar;
            zzez.zza(zzj.class, zzjVar);
        }

        private zzj() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzj>, com.google.android.gms.internal.mlkit_common.zzez$zzc] */
        /* JADX WARN: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_common.zzez
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_common.zzac.zza
                r4 = 1
                int r2 = r2 - r4
                r2 = r3[r2]
                r3 = 0
                switch(r2) {
                    case 1: goto L_0x0055;
                    case 2: goto L_0x004f;
                    case 3: goto L_0x0033;
                    case 4: goto L_0x0030;
                    case 5: goto L_0x0016;
                    case 6: goto L_0x0011;
                    case 7: goto L_0x0010;
                    default: goto L_0x000a;
                }
            L_0x000a:
                java.lang.UnsupportedOperationException r2 = new java.lang.UnsupportedOperationException
                r2.<init>()
                throw r2
            L_0x0010:
                return r3
            L_0x0011:
                java.lang.Byte r2 = java.lang.Byte.valueOf(r4)
                return r2
            L_0x0016:
                com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzj> r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzj.zzf
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_common.zzaa$zzj> r3 = com.google.android.gms.internal.mlkit_common.zzaa.zzj.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzj> r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzj.zzf     // Catch: all -> 0x002c
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_common.zzez$zzc r2 = new com.google.android.gms.internal.mlkit_common.zzez$zzc     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_common.zzaa$zzj r4 = com.google.android.gms.internal.mlkit_common.zzaa.zzj.zze     // Catch: all -> 0x002c
                r2.<init>(r4)     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_common.zzaa.zzj.zzf = r2     // Catch: all -> 0x002c
            L_0x002a:
                monitor-exit(r3)     // Catch: all -> 0x002c
                goto L_0x002f
            L_0x002c:
                r2 = move-exception
                monitor-exit(r3)     // Catch: all -> 0x002c
                throw r2
            L_0x002f:
                return r2
            L_0x0030:
                com.google.android.gms.internal.mlkit_common.zzaa$zzj r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzj.zze
                return r2
            L_0x0033:
                r2 = 3
                java.lang.Object[] r2 = new java.lang.Object[r2]
                r3 = 0
                java.lang.String r0 = "zzc"
                r2[r3] = r0
                java.lang.String r3 = "zzd"
                r2[r4] = r3
                r3 = 2
                com.google.android.gms.internal.mlkit_common.zzfd r4 = com.google.android.gms.internal.mlkit_common.zzal.zzb()
                r2[r3] = r4
                java.lang.String r3 = "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဌ\u0000"
                com.google.android.gms.internal.mlkit_common.zzaa$zzj r4 = com.google.android.gms.internal.mlkit_common.zzaa.zzj.zze
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_common.zzez.zza(r4, r3, r2)
                return r2
            L_0x004f:
                com.google.android.gms.internal.mlkit_common.zzaa$zzj$zza r2 = new com.google.android.gms.internal.mlkit_common.zzaa$zzj$zza
                r2.<init>(r3)
                return r2
            L_0x0055:
                com.google.android.gms.internal.mlkit_common.zzaa$zzj r2 = new com.google.android.gms.internal.mlkit_common.zzaa$zzj
                r2.<init>()
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzaa.zzj.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: com.google.mlkit:common@@16.0.0 */
    /* loaded from: classes.dex */
    public static final class zzl extends zzez<zzl, zza> implements zzgj {
        private static final zzff<Integer, zzal> zzg = new zzaf();
        private static final zzl zzi;
        private static volatile zzgr<zzl> zzj;
        private int zzc;
        private zzam zzd;
        private zzam zze;
        private zzfg zzf = zzez.zzk();
        private long zzh;

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        /* loaded from: classes.dex */
        public static final class zza extends zzez.zza<zzl, zza> implements zzgj {
            private zza() {
                super(zzl.zzi);
            }

            /* synthetic */ zza(zzac zzacVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [com.google.android.gms.internal.mlkit_common.zzaf, com.google.android.gms.internal.mlkit_common.zzff<java.lang.Integer, com.google.android.gms.internal.mlkit_common.zzal>] */
        static {
            zzl zzlVar = new zzl();
            zzi = zzlVar;
            zzez.zza(zzl.class, zzlVar);
        }

        private zzl() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzl>, com.google.android.gms.internal.mlkit_common.zzez$zzc] */
        /* JADX WARN: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_common.zzez
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_common.zzac.zza
                r4 = 1
                int r2 = r2 - r4
                r2 = r3[r2]
                r3 = 0
                switch(r2) {
                    case 1: goto L_0x0064;
                    case 2: goto L_0x005e;
                    case 3: goto L_0x0033;
                    case 4: goto L_0x0030;
                    case 5: goto L_0x0016;
                    case 6: goto L_0x0011;
                    case 7: goto L_0x0010;
                    default: goto L_0x000a;
                }
            L_0x000a:
                java.lang.UnsupportedOperationException r2 = new java.lang.UnsupportedOperationException
                r2.<init>()
                throw r2
            L_0x0010:
                return r3
            L_0x0011:
                java.lang.Byte r2 = java.lang.Byte.valueOf(r4)
                return r2
            L_0x0016:
                com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzl> r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzl.zzj
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_common.zzaa$zzl> r3 = com.google.android.gms.internal.mlkit_common.zzaa.zzl.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzl> r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzl.zzj     // Catch: all -> 0x002c
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_common.zzez$zzc r2 = new com.google.android.gms.internal.mlkit_common.zzez$zzc     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_common.zzaa$zzl r4 = com.google.android.gms.internal.mlkit_common.zzaa.zzl.zzi     // Catch: all -> 0x002c
                r2.<init>(r4)     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_common.zzaa.zzl.zzj = r2     // Catch: all -> 0x002c
            L_0x002a:
                monitor-exit(r3)     // Catch: all -> 0x002c
                goto L_0x002f
            L_0x002c:
                r2 = move-exception
                monitor-exit(r3)     // Catch: all -> 0x002c
                throw r2
            L_0x002f:
                return r2
            L_0x0030:
                com.google.android.gms.internal.mlkit_common.zzaa$zzl r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzl.zzi
                return r2
            L_0x0033:
                r2 = 6
                java.lang.Object[] r2 = new java.lang.Object[r2]
                r3 = 0
                java.lang.String r0 = "zzc"
                r2[r3] = r0
                java.lang.String r3 = "zzd"
                r2[r4] = r3
                r3 = 2
                java.lang.String r4 = "zze"
                r2[r3] = r4
                r3 = 3
                java.lang.String r4 = "zzf"
                r2[r3] = r4
                r3 = 4
                com.google.android.gms.internal.mlkit_common.zzfd r4 = com.google.android.gms.internal.mlkit_common.zzal.zzb()
                r2[r3] = r4
                r3 = 5
                java.lang.String r4 = "zzh"
                r2[r3] = r4
                java.lang.String r3 = "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003\u001e\u0004ဃ\u0002"
                com.google.android.gms.internal.mlkit_common.zzaa$zzl r4 = com.google.android.gms.internal.mlkit_common.zzaa.zzl.zzi
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_common.zzez.zza(r4, r3, r2)
                return r2
            L_0x005e:
                com.google.android.gms.internal.mlkit_common.zzaa$zzl$zza r2 = new com.google.android.gms.internal.mlkit_common.zzaa$zzl$zza
                r2.<init>(r3)
                return r2
            L_0x0064:
                com.google.android.gms.internal.mlkit_common.zzaa$zzl r2 = new com.google.android.gms.internal.mlkit_common.zzaa$zzl
                r2.<init>()
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzaa.zzl.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: com.google.mlkit:common@@16.0.0 */
    /* loaded from: classes.dex */
    public static final class zzn extends zzez<zzn, zza> implements zzgj {
        private static final zzn zzf;
        private static volatile zzgr<zzn> zzg;
        private int zzc;
        private int zzd;
        private int zze;

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        /* loaded from: classes.dex */
        public static final class zza extends zzez.zza<zzn, zza> implements zzgj {
            private zza() {
                super(zzn.zzf);
            }

            /* synthetic */ zza(zzac zzacVar) {
                this();
            }
        }

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        /* loaded from: classes.dex */
        public enum zzb implements zzfb {
            UNKNOWN_MODEL_TYPE(0),
            STABLE_MODEL(1),
            LATEST_MODEL(2);
            
            private static final zzfe<zzb> zzd = new zzag();
            private final int zze;

            zzb(int i) {
                this.zze = i;
            }

            public static zzfd zzb() {
                return zzah.zza;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "<" + zzb.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zze + " name=" + name() + '>';
            }

            @Override // com.google.android.gms.internal.mlkit_common.zzfb
            public final int zza() {
                return this.zze;
            }
        }

        static {
            zzn zznVar = new zzn();
            zzf = zznVar;
            zzez.zza(zzn.class, zznVar);
        }

        private zzn() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzn>, com.google.android.gms.internal.mlkit_common.zzez$zzc] */
        /* JADX WARN: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_common.zzez
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_common.zzac.zza
                r4 = 1
                int r2 = r2 - r4
                r2 = r3[r2]
                r3 = 0
                switch(r2) {
                    case 1: goto L_0x005a;
                    case 2: goto L_0x0054;
                    case 3: goto L_0x0033;
                    case 4: goto L_0x0030;
                    case 5: goto L_0x0016;
                    case 6: goto L_0x0011;
                    case 7: goto L_0x0010;
                    default: goto L_0x000a;
                }
            L_0x000a:
                java.lang.UnsupportedOperationException r2 = new java.lang.UnsupportedOperationException
                r2.<init>()
                throw r2
            L_0x0010:
                return r3
            L_0x0011:
                java.lang.Byte r2 = java.lang.Byte.valueOf(r4)
                return r2
            L_0x0016:
                com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzn> r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzn.zzg
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_common.zzaa$zzn> r3 = com.google.android.gms.internal.mlkit_common.zzaa.zzn.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzn> r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzn.zzg     // Catch: all -> 0x002c
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_common.zzez$zzc r2 = new com.google.android.gms.internal.mlkit_common.zzez$zzc     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_common.zzaa$zzn r4 = com.google.android.gms.internal.mlkit_common.zzaa.zzn.zzf     // Catch: all -> 0x002c
                r2.<init>(r4)     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_common.zzaa.zzn.zzg = r2     // Catch: all -> 0x002c
            L_0x002a:
                monitor-exit(r3)     // Catch: all -> 0x002c
                goto L_0x002f
            L_0x002c:
                r2 = move-exception
                monitor-exit(r3)     // Catch: all -> 0x002c
                throw r2
            L_0x002f:
                return r2
            L_0x0030:
                com.google.android.gms.internal.mlkit_common.zzaa$zzn r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzn.zzf
                return r2
            L_0x0033:
                r2 = 4
                java.lang.Object[] r2 = new java.lang.Object[r2]
                r3 = 0
                java.lang.String r0 = "zzc"
                r2[r3] = r0
                java.lang.String r3 = "zzd"
                r2[r4] = r3
                r3 = 2
                java.lang.String r4 = "zze"
                r2[r3] = r4
                r3 = 3
                com.google.android.gms.internal.mlkit_common.zzfd r4 = com.google.android.gms.internal.mlkit_common.zzaa.zzn.zzb.zzb()
                r2[r3] = r4
                java.lang.String r3 = "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001င\u0000\u0002ဌ\u0001"
                com.google.android.gms.internal.mlkit_common.zzaa$zzn r4 = com.google.android.gms.internal.mlkit_common.zzaa.zzn.zzf
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_common.zzez.zza(r4, r3, r2)
                return r2
            L_0x0054:
                com.google.android.gms.internal.mlkit_common.zzaa$zzn$zza r2 = new com.google.android.gms.internal.mlkit_common.zzaa$zzn$zza
                r2.<init>(r3)
                return r2
            L_0x005a:
                com.google.android.gms.internal.mlkit_common.zzaa$zzn r2 = new com.google.android.gms.internal.mlkit_common.zzaa$zzn
                r2.<init>()
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzaa.zzn.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: com.google.mlkit:common@@16.0.0 */
    /* loaded from: classes.dex */
    public static final class zzx extends zzez<zzx, zza> implements zzgj {
        private static final zzx zzf;
        private static volatile zzgr<zzx> zzg;
        private int zzc;
        private zzam zzd;
        private int zze;

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        /* loaded from: classes.dex */
        public static final class zza extends zzez.zza<zzx, zza> implements zzgj {
            private zza() {
                super(zzx.zzf);
            }

            /* synthetic */ zza(zzac zzacVar) {
                this();
            }
        }

        static {
            zzx zzxVar = new zzx();
            zzf = zzxVar;
            zzez.zza(zzx.class, zzxVar);
        }

        private zzx() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_common.zzez$zzc, com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzx>] */
        /* JADX WARN: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_common.zzez
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_common.zzac.zza
                r4 = 1
                int r2 = r2 - r4
                r2 = r3[r2]
                r3 = 0
                switch(r2) {
                    case 1: goto L_0x005a;
                    case 2: goto L_0x0054;
                    case 3: goto L_0x0033;
                    case 4: goto L_0x0030;
                    case 5: goto L_0x0016;
                    case 6: goto L_0x0011;
                    case 7: goto L_0x0010;
                    default: goto L_0x000a;
                }
            L_0x000a:
                java.lang.UnsupportedOperationException r2 = new java.lang.UnsupportedOperationException
                r2.<init>()
                throw r2
            L_0x0010:
                return r3
            L_0x0011:
                java.lang.Byte r2 = java.lang.Byte.valueOf(r4)
                return r2
            L_0x0016:
                com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzx> r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzx.zzg
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_common.zzaa$zzx> r3 = com.google.android.gms.internal.mlkit_common.zzaa.zzx.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzx> r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzx.zzg     // Catch: all -> 0x002c
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_common.zzez$zzc r2 = new com.google.android.gms.internal.mlkit_common.zzez$zzc     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_common.zzaa$zzx r4 = com.google.android.gms.internal.mlkit_common.zzaa.zzx.zzf     // Catch: all -> 0x002c
                r2.<init>(r4)     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_common.zzaa.zzx.zzg = r2     // Catch: all -> 0x002c
            L_0x002a:
                monitor-exit(r3)     // Catch: all -> 0x002c
                goto L_0x002f
            L_0x002c:
                r2 = move-exception
                monitor-exit(r3)     // Catch: all -> 0x002c
                throw r2
            L_0x002f:
                return r2
            L_0x0030:
                com.google.android.gms.internal.mlkit_common.zzaa$zzx r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzx.zzf
                return r2
            L_0x0033:
                r2 = 4
                java.lang.Object[] r2 = new java.lang.Object[r2]
                r3 = 0
                java.lang.String r0 = "zzc"
                r2[r3] = r0
                java.lang.String r3 = "zzd"
                r2[r4] = r3
                r3 = 2
                java.lang.String r4 = "zze"
                r2[r3] = r4
                r3 = 3
                com.google.android.gms.internal.mlkit_common.zzfd r4 = com.google.android.gms.internal.mlkit_common.zzal.zzb()
                r2[r3] = r4
                java.lang.String r3 = "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဌ\u0001"
                com.google.android.gms.internal.mlkit_common.zzaa$zzx r4 = com.google.android.gms.internal.mlkit_common.zzaa.zzx.zzf
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_common.zzez.zza(r4, r3, r2)
                return r2
            L_0x0054:
                com.google.android.gms.internal.mlkit_common.zzaa$zzx$zza r2 = new com.google.android.gms.internal.mlkit_common.zzaa$zzx$zza
                r2.<init>(r3)
                return r2
            L_0x005a:
                com.google.android.gms.internal.mlkit_common.zzaa$zzx r2 = new com.google.android.gms.internal.mlkit_common.zzaa$zzx
                r2.<init>()
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzaa.zzx.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: com.google.mlkit:common@@16.0.0 */
    /* loaded from: classes.dex */
    public static final class zzz extends zzez<zzz, zza> implements zzgj {
        private static final zzff<Integer, zzal> zzg = new zzak();
        private static final zzz zzj;
        private static volatile zzgr<zzz> zzk;
        private int zzc;
        private zzam zzd;
        private zzam zze;
        private zzfg zzf = zzez.zzk();
        private long zzh;
        private boolean zzi;

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        /* loaded from: classes.dex */
        public static final class zza extends zzez.zza<zzz, zza> implements zzgj {
            private zza() {
                super(zzz.zzj);
            }

            /* synthetic */ zza(zzac zzacVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [com.google.android.gms.internal.mlkit_common.zzff<java.lang.Integer, com.google.android.gms.internal.mlkit_common.zzal>, com.google.android.gms.internal.mlkit_common.zzak] */
        static {
            zzz zzzVar = new zzz();
            zzj = zzzVar;
            zzez.zza(zzz.class, zzzVar);
        }

        private zzz() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzz>, com.google.android.gms.internal.mlkit_common.zzez$zzc] */
        /* JADX WARN: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_common.zzez
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_common.zzac.zza
                r4 = 1
                int r2 = r2 - r4
                r2 = r3[r2]
                r3 = 0
                switch(r2) {
                    case 1: goto L_0x0069;
                    case 2: goto L_0x0063;
                    case 3: goto L_0x0033;
                    case 4: goto L_0x0030;
                    case 5: goto L_0x0016;
                    case 6: goto L_0x0011;
                    case 7: goto L_0x0010;
                    default: goto L_0x000a;
                }
            L_0x000a:
                java.lang.UnsupportedOperationException r2 = new java.lang.UnsupportedOperationException
                r2.<init>()
                throw r2
            L_0x0010:
                return r3
            L_0x0011:
                java.lang.Byte r2 = java.lang.Byte.valueOf(r4)
                return r2
            L_0x0016:
                com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzz> r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzz.zzk
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_common.zzaa$zzz> r3 = com.google.android.gms.internal.mlkit_common.zzaa.zzz.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzz> r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzz.zzk     // Catch: all -> 0x002c
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_common.zzez$zzc r2 = new com.google.android.gms.internal.mlkit_common.zzez$zzc     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_common.zzaa$zzz r4 = com.google.android.gms.internal.mlkit_common.zzaa.zzz.zzj     // Catch: all -> 0x002c
                r2.<init>(r4)     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_common.zzaa.zzz.zzk = r2     // Catch: all -> 0x002c
            L_0x002a:
                monitor-exit(r3)     // Catch: all -> 0x002c
                goto L_0x002f
            L_0x002c:
                r2 = move-exception
                monitor-exit(r3)     // Catch: all -> 0x002c
                throw r2
            L_0x002f:
                return r2
            L_0x0030:
                com.google.android.gms.internal.mlkit_common.zzaa$zzz r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzz.zzj
                return r2
            L_0x0033:
                r2 = 7
                java.lang.Object[] r2 = new java.lang.Object[r2]
                r3 = 0
                java.lang.String r0 = "zzc"
                r2[r3] = r0
                java.lang.String r3 = "zzd"
                r2[r4] = r3
                r3 = 2
                java.lang.String r4 = "zze"
                r2[r3] = r4
                r3 = 3
                java.lang.String r4 = "zzf"
                r2[r3] = r4
                r3 = 4
                com.google.android.gms.internal.mlkit_common.zzfd r4 = com.google.android.gms.internal.mlkit_common.zzal.zzb()
                r2[r3] = r4
                r3 = 5
                java.lang.String r4 = "zzh"
                r2[r3] = r4
                r3 = 6
                java.lang.String r4 = "zzi"
                r2[r3] = r4
                java.lang.String r3 = "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003\u001e\u0004ဃ\u0002\u0005ဇ\u0003"
                com.google.android.gms.internal.mlkit_common.zzaa$zzz r4 = com.google.android.gms.internal.mlkit_common.zzaa.zzz.zzj
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_common.zzez.zza(r4, r3, r2)
                return r2
            L_0x0063:
                com.google.android.gms.internal.mlkit_common.zzaa$zzz$zza r2 = new com.google.android.gms.internal.mlkit_common.zzaa$zzz$zza
                r2.<init>(r3)
                return r2
            L_0x0069:
                com.google.android.gms.internal.mlkit_common.zzaa$zzz r2 = new com.google.android.gms.internal.mlkit_common.zzaa$zzz
                r2.<init>()
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzaa.zzz.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: com.google.mlkit:common@@16.0.0 */
    /* loaded from: classes.dex */
    public static final class zzag extends zzez<zzag, zza> implements zzgj {
        private static final zzag zzk;
        private static volatile zzgr<zzag> zzl;
        private int zzc;
        private long zzd;
        private int zze;
        private int zzf;
        private int zzg;
        private int zzh;
        private int zzi;
        private int zzj;

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        /* loaded from: classes.dex */
        public static final class zza extends zzez.zza<zzag, zza> implements zzgj {
            private zza() {
                super(zzag.zzk);
            }

            /* synthetic */ zza(zzac zzacVar) {
                this();
            }
        }

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        /* loaded from: classes.dex */
        public enum zzb implements zzfb {
            SOURCE_UNKNOWN(0),
            BITMAP(1),
            BYTEARRAY(2),
            BYTEBUFFER(3),
            FILEPATH(4),
            ANDROID_MEDIA_IMAGE(5);
            
            private static final zzfe<zzb> zzg = new zzbb();
            private final int zzh;

            zzb(int i) {
                this.zzh = i;
            }

            public static zzfd zzb() {
                return zzbc.zza;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "<" + zzb.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzh + " name=" + name() + '>';
            }

            @Override // com.google.android.gms.internal.mlkit_common.zzfb
            public final int zza() {
                return this.zzh;
            }
        }

        static {
            zzag zzagVar = new zzag();
            zzk = zzagVar;
            zzez.zza(zzag.class, zzagVar);
        }

        private zzag() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzag>, com.google.android.gms.internal.mlkit_common.zzez$zzc] */
        /* JADX WARN: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_common.zzez
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_common.zzac.zza
                r4 = 1
                int r2 = r2 - r4
                r2 = r3[r2]
                r3 = 0
                switch(r2) {
                    case 1: goto L_0x007d;
                    case 2: goto L_0x0077;
                    case 3: goto L_0x0033;
                    case 4: goto L_0x0030;
                    case 5: goto L_0x0016;
                    case 6: goto L_0x0011;
                    case 7: goto L_0x0010;
                    default: goto L_0x000a;
                }
            L_0x000a:
                java.lang.UnsupportedOperationException r2 = new java.lang.UnsupportedOperationException
                r2.<init>()
                throw r2
            L_0x0010:
                return r3
            L_0x0011:
                java.lang.Byte r2 = java.lang.Byte.valueOf(r4)
                return r2
            L_0x0016:
                com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzag> r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzag.zzl
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_common.zzaa$zzag> r3 = com.google.android.gms.internal.mlkit_common.zzaa.zzag.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzag> r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzag.zzl     // Catch: all -> 0x002c
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_common.zzez$zzc r2 = new com.google.android.gms.internal.mlkit_common.zzez$zzc     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_common.zzaa$zzag r4 = com.google.android.gms.internal.mlkit_common.zzaa.zzag.zzk     // Catch: all -> 0x002c
                r2.<init>(r4)     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_common.zzaa.zzag.zzl = r2     // Catch: all -> 0x002c
            L_0x002a:
                monitor-exit(r3)     // Catch: all -> 0x002c
                goto L_0x002f
            L_0x002c:
                r2 = move-exception
                monitor-exit(r3)     // Catch: all -> 0x002c
                throw r2
            L_0x002f:
                return r2
            L_0x0030:
                com.google.android.gms.internal.mlkit_common.zzaa$zzag r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzag.zzk
                return r2
            L_0x0033:
                r2 = 10
                java.lang.Object[] r2 = new java.lang.Object[r2]
                r3 = 0
                java.lang.String r0 = "zzc"
                r2[r3] = r0
                java.lang.String r3 = "zzd"
                r2[r4] = r3
                r3 = 2
                java.lang.String r4 = "zze"
                r2[r3] = r4
                r3 = 3
                com.google.android.gms.internal.mlkit_common.zzfd r4 = com.google.android.gms.internal.mlkit_common.zzaa.zzag.zzb.zzb()
                r2[r3] = r4
                r3 = 4
                java.lang.String r4 = "zzf"
                r2[r3] = r4
                r3 = 5
                com.google.android.gms.internal.mlkit_common.zzfd r4 = com.google.android.gms.internal.mlkit_common.zzaa.zzae.zza.zzb()
                r2[r3] = r4
                r3 = 6
                java.lang.String r4 = "zzg"
                r2[r3] = r4
                r3 = 7
                java.lang.String r4 = "zzh"
                r2[r3] = r4
                r3 = 8
                java.lang.String r4 = "zzi"
                r2[r3] = r4
                r3 = 9
                java.lang.String r4 = "zzj"
                r2[r3] = r4
                java.lang.String r3 = "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0000\u0000\u0001ဃ\u0000\u0002ဌ\u0001\u0003ဌ\u0002\u0004ဋ\u0003\u0005ဋ\u0004\u0006ဋ\u0005\u0007ဋ\u0006"
                com.google.android.gms.internal.mlkit_common.zzaa$zzag r4 = com.google.android.gms.internal.mlkit_common.zzaa.zzag.zzk
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_common.zzez.zza(r4, r3, r2)
                return r2
            L_0x0077:
                com.google.android.gms.internal.mlkit_common.zzaa$zzag$zza r2 = new com.google.android.gms.internal.mlkit_common.zzaa$zzag$zza
                r2.<init>(r3)
                return r2
            L_0x007d:
                com.google.android.gms.internal.mlkit_common.zzaa$zzag r2 = new com.google.android.gms.internal.mlkit_common.zzaa$zzag
                r2.<init>()
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzaa.zzag.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: com.google.mlkit:common@@16.0.0 */
    /* loaded from: classes.dex */
    public static final class zzao extends zzez<zzao, zzc> implements zzgj {
        private static final zzff<Integer, zza> zzg = new zzbn();
        private static final zzff<Integer, zzb> zzi = new zzbo();
        private static final zzao zzk;
        private static volatile zzgr<zzao> zzl;
        private int zzc;
        private zzaf zzd;
        private zzck.zza zze;
        private zzfg zzf = zzez.zzk();
        private zzfg zzh = zzez.zzk();
        private zzae zzj;

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        /* loaded from: classes.dex */
        public enum zza implements zzfb {
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
            
            private static final zzfe<zza> zzo = new zzbq();
            private final int zzp;

            zza(int i) {
                this.zzp = i;
            }

            public static zzfd zzb() {
                return zzbp.zza;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "<" + zza.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzp + " name=" + name() + '>';
            }

            @Override // com.google.android.gms.internal.mlkit_common.zzfb
            public final int zza() {
                return this.zzp;
            }
        }

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        /* loaded from: classes.dex */
        public enum zzb implements zzfb {
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
            
            private static final zzfe<zzb> zzn = new zzbr();
            private final int zzo;

            zzb(int i) {
                this.zzo = i;
            }

            public static zzfd zzb() {
                return zzbs.zza;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "<" + zzb.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzo + " name=" + name() + '>';
            }

            @Override // com.google.android.gms.internal.mlkit_common.zzfb
            public final int zza() {
                return this.zzo;
            }
        }

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        /* loaded from: classes.dex */
        public static final class zzc extends zzez.zza<zzao, zzc> implements zzgj {
            private zzc() {
                super(zzao.zzk);
            }

            /* synthetic */ zzc(zzac zzacVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [com.google.android.gms.internal.mlkit_common.zzff<java.lang.Integer, com.google.android.gms.internal.mlkit_common.zzaa$zzao$zza>, com.google.android.gms.internal.mlkit_common.zzbn] */
        /* JADX WARN: Type inference failed for: r0v1, types: [com.google.android.gms.internal.mlkit_common.zzff<java.lang.Integer, com.google.android.gms.internal.mlkit_common.zzaa$zzao$zzb>, com.google.android.gms.internal.mlkit_common.zzbo] */
        static {
            zzao zzaoVar = new zzao();
            zzk = zzaoVar;
            zzez.zza(zzao.class, zzaoVar);
        }

        private zzao() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_common.zzez$zzc, com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzao>] */
        /* JADX WARN: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_common.zzez
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_common.zzac.zza
                r4 = 1
                int r2 = r2 - r4
                r2 = r3[r2]
                r3 = 0
                switch(r2) {
                    case 1: goto L_0x0071;
                    case 2: goto L_0x006b;
                    case 3: goto L_0x0033;
                    case 4: goto L_0x0030;
                    case 5: goto L_0x0016;
                    case 6: goto L_0x0011;
                    case 7: goto L_0x0010;
                    default: goto L_0x000a;
                }
            L_0x000a:
                java.lang.UnsupportedOperationException r2 = new java.lang.UnsupportedOperationException
                r2.<init>()
                throw r2
            L_0x0010:
                return r3
            L_0x0011:
                java.lang.Byte r2 = java.lang.Byte.valueOf(r4)
                return r2
            L_0x0016:
                com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzao> r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzao.zzl
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_common.zzaa$zzao> r3 = com.google.android.gms.internal.mlkit_common.zzaa.zzao.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzao> r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzao.zzl     // Catch: all -> 0x002c
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_common.zzez$zzc r2 = new com.google.android.gms.internal.mlkit_common.zzez$zzc     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_common.zzaa$zzao r4 = com.google.android.gms.internal.mlkit_common.zzaa.zzao.zzk     // Catch: all -> 0x002c
                r2.<init>(r4)     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_common.zzaa.zzao.zzl = r2     // Catch: all -> 0x002c
            L_0x002a:
                monitor-exit(r3)     // Catch: all -> 0x002c
                goto L_0x002f
            L_0x002c:
                r2 = move-exception
                monitor-exit(r3)     // Catch: all -> 0x002c
                throw r2
            L_0x002f:
                return r2
            L_0x0030:
                com.google.android.gms.internal.mlkit_common.zzaa$zzao r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzao.zzk
                return r2
            L_0x0033:
                r2 = 8
                java.lang.Object[] r2 = new java.lang.Object[r2]
                r3 = 0
                java.lang.String r0 = "zzc"
                r2[r3] = r0
                java.lang.String r3 = "zzd"
                r2[r4] = r3
                r3 = 2
                java.lang.String r4 = "zze"
                r2[r3] = r4
                r3 = 3
                java.lang.String r4 = "zzf"
                r2[r3] = r4
                r3 = 4
                com.google.android.gms.internal.mlkit_common.zzfd r4 = com.google.android.gms.internal.mlkit_common.zzaa.zzao.zza.zzb()
                r2[r3] = r4
                r3 = 5
                java.lang.String r4 = "zzh"
                r2[r3] = r4
                r3 = 6
                com.google.android.gms.internal.mlkit_common.zzfd r4 = com.google.android.gms.internal.mlkit_common.zzaa.zzao.zzb.zzb()
                r2[r3] = r4
                r3 = 7
                java.lang.String r4 = "zzj"
                r2[r3] = r4
                java.lang.String r3 = "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0002\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003\u001e\u0004\u001e\u0005ဉ\u0002"
                com.google.android.gms.internal.mlkit_common.zzaa$zzao r4 = com.google.android.gms.internal.mlkit_common.zzaa.zzao.zzk
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_common.zzez.zza(r4, r3, r2)
                return r2
            L_0x006b:
                com.google.android.gms.internal.mlkit_common.zzaa$zzao$zzc r2 = new com.google.android.gms.internal.mlkit_common.zzaa$zzao$zzc
                r2.<init>(r3)
                return r2
            L_0x0071:
                com.google.android.gms.internal.mlkit_common.zzaa$zzao r2 = new com.google.android.gms.internal.mlkit_common.zzaa$zzao
                r2.<init>()
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzaa.zzao.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: com.google.mlkit:common@@16.0.0 */
    /* loaded from: classes.dex */
    public static final class zzba extends zzez<zzba, zza> implements zzgj {
        private static final zzba zzf;
        private static volatile zzgr<zzba> zzg;
        private int zzc;
        private int zzd;
        private int zze;

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        /* loaded from: classes.dex */
        public static final class zza extends zzez.zza<zzba, zza> implements zzgj {
            private zza() {
                super(zzba.zzf);
            }

            /* synthetic */ zza(zzac zzacVar) {
                this();
            }
        }

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        /* loaded from: classes.dex */
        public enum zzb implements zzfb {
            INVALID_MODE(0),
            STREAM(1),
            SINGLE_IMAGE(2);
            
            private static final zzfe<zzb> zzd = new zzbw();
            private final int zze;

            zzb(int i) {
                this.zze = i;
            }

            public static zzfd zzb() {
                return zzbx.zza;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "<" + zzb.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zze + " name=" + name() + '>';
            }

            @Override // com.google.android.gms.internal.mlkit_common.zzfb
            public final int zza() {
                return this.zze;
            }
        }

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        /* loaded from: classes.dex */
        public enum zzc implements zzfb {
            UNKNOWN_PERFORMANCE(0),
            FAST(1),
            ACCURATE(2);
            
            private static final zzfe<zzc> zzd = new zzbz();
            private final int zze;

            zzc(int i) {
                this.zze = i;
            }

            public static zzfd zzb() {
                return zzby.zza;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "<" + zzc.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zze + " name=" + name() + '>';
            }

            @Override // com.google.android.gms.internal.mlkit_common.zzfb
            public final int zza() {
                return this.zze;
            }
        }

        static {
            zzba zzbaVar = new zzba();
            zzf = zzbaVar;
            zzez.zza(zzba.class, zzbaVar);
        }

        private zzba() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_common.zzez$zzc, com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzba>] */
        /* JADX WARN: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_common.zzez
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_common.zzac.zza
                r4 = 1
                int r2 = r2 - r4
                r2 = r3[r2]
                r3 = 0
                switch(r2) {
                    case 1: goto L_0x0061;
                    case 2: goto L_0x005b;
                    case 3: goto L_0x0033;
                    case 4: goto L_0x0030;
                    case 5: goto L_0x0016;
                    case 6: goto L_0x0011;
                    case 7: goto L_0x0010;
                    default: goto L_0x000a;
                }
            L_0x000a:
                java.lang.UnsupportedOperationException r2 = new java.lang.UnsupportedOperationException
                r2.<init>()
                throw r2
            L_0x0010:
                return r3
            L_0x0011:
                java.lang.Byte r2 = java.lang.Byte.valueOf(r4)
                return r2
            L_0x0016:
                com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzba> r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzba.zzg
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_common.zzaa$zzba> r3 = com.google.android.gms.internal.mlkit_common.zzaa.zzba.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzba> r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzba.zzg     // Catch: all -> 0x002c
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_common.zzez$zzc r2 = new com.google.android.gms.internal.mlkit_common.zzez$zzc     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_common.zzaa$zzba r4 = com.google.android.gms.internal.mlkit_common.zzaa.zzba.zzf     // Catch: all -> 0x002c
                r2.<init>(r4)     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_common.zzaa.zzba.zzg = r2     // Catch: all -> 0x002c
            L_0x002a:
                monitor-exit(r3)     // Catch: all -> 0x002c
                goto L_0x002f
            L_0x002c:
                r2 = move-exception
                monitor-exit(r3)     // Catch: all -> 0x002c
                throw r2
            L_0x002f:
                return r2
            L_0x0030:
                com.google.android.gms.internal.mlkit_common.zzaa$zzba r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzba.zzf
                return r2
            L_0x0033:
                r2 = 5
                java.lang.Object[] r2 = new java.lang.Object[r2]
                r3 = 0
                java.lang.String r0 = "zzc"
                r2[r3] = r0
                java.lang.String r3 = "zzd"
                r2[r4] = r3
                r3 = 2
                com.google.android.gms.internal.mlkit_common.zzfd r4 = com.google.android.gms.internal.mlkit_common.zzaa.zzba.zzb.zzb()
                r2[r3] = r4
                r3 = 3
                java.lang.String r4 = "zze"
                r2[r3] = r4
                r3 = 4
                com.google.android.gms.internal.mlkit_common.zzfd r4 = com.google.android.gms.internal.mlkit_common.zzaa.zzba.zzc.zzb()
                r2[r3] = r4
                java.lang.String r3 = "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဌ\u0001"
                com.google.android.gms.internal.mlkit_common.zzaa$zzba r4 = com.google.android.gms.internal.mlkit_common.zzaa.zzba.zzf
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_common.zzez.zza(r4, r3, r2)
                return r2
            L_0x005b:
                com.google.android.gms.internal.mlkit_common.zzaa$zzba$zza r2 = new com.google.android.gms.internal.mlkit_common.zzaa$zzba$zza
                r2.<init>(r3)
                return r2
            L_0x0061:
                com.google.android.gms.internal.mlkit_common.zzaa$zzba r2 = new com.google.android.gms.internal.mlkit_common.zzaa$zzba
                r2.<init>()
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzaa.zzba.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: com.google.mlkit:common@@16.0.0 */
    /* loaded from: classes.dex */
    public static final class zzbf extends zzez<zzbf, zzb> implements zzgj {
        private static final zzff<Integer, zza> zzf = new zzce();
        private static final zzff<Integer, zza> zzh = new zzcg();
        private static final zzff<Integer, zza> zzj = new zzcf();
        private static final zzbf zzl;
        private static volatile zzgr<zzbf> zzm;
        private int zzc;
        private long zzd;
        private zzfg zze = zzez.zzk();
        private zzfg zzg = zzez.zzk();
        private zzfg zzi = zzez.zzk();
        private int zzk;

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        /* loaded from: classes.dex */
        public enum zza implements zzfb {
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
            
            private static final zzfe<zza> zzm = new zzci();
            private final int zzn;

            zza(int i) {
                this.zzn = i;
            }

            public static zzfd zzb() {
                return zzch.zza;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "<" + zza.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzn + " name=" + name() + '>';
            }

            @Override // com.google.android.gms.internal.mlkit_common.zzfb
            public final int zza() {
                return this.zzn;
            }
        }

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        /* loaded from: classes.dex */
        public static final class zzb extends zzez.zza<zzbf, zzb> implements zzgj {
            private zzb() {
                super(zzbf.zzl);
            }

            /* synthetic */ zzb(zzac zzacVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [com.google.android.gms.internal.mlkit_common.zzff<java.lang.Integer, com.google.android.gms.internal.mlkit_common.zzaa$zzbf$zza>, com.google.android.gms.internal.mlkit_common.zzce] */
        /* JADX WARN: Type inference failed for: r0v1, types: [com.google.android.gms.internal.mlkit_common.zzff<java.lang.Integer, com.google.android.gms.internal.mlkit_common.zzaa$zzbf$zza>, com.google.android.gms.internal.mlkit_common.zzcg] */
        /* JADX WARN: Type inference failed for: r0v2, types: [com.google.android.gms.internal.mlkit_common.zzff<java.lang.Integer, com.google.android.gms.internal.mlkit_common.zzaa$zzbf$zza>, com.google.android.gms.internal.mlkit_common.zzcf] */
        static {
            zzbf zzbfVar = new zzbf();
            zzl = zzbfVar;
            zzez.zza(zzbf.class, zzbfVar);
        }

        private zzbf() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_common.zzez$zzc, com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzbf>] */
        /* JADX WARN: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_common.zzez
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_common.zzac.zza
                r4 = 1
                int r2 = r2 - r4
                r2 = r3[r2]
                r3 = 0
                switch(r2) {
                    case 1: goto L_0x0079;
                    case 2: goto L_0x0073;
                    case 3: goto L_0x0033;
                    case 4: goto L_0x0030;
                    case 5: goto L_0x0016;
                    case 6: goto L_0x0011;
                    case 7: goto L_0x0010;
                    default: goto L_0x000a;
                }
            L_0x000a:
                java.lang.UnsupportedOperationException r2 = new java.lang.UnsupportedOperationException
                r2.<init>()
                throw r2
            L_0x0010:
                return r3
            L_0x0011:
                java.lang.Byte r2 = java.lang.Byte.valueOf(r4)
                return r2
            L_0x0016:
                com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzbf> r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzbf.zzm
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_common.zzaa$zzbf> r3 = com.google.android.gms.internal.mlkit_common.zzaa.zzbf.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzbf> r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzbf.zzm     // Catch: all -> 0x002c
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_common.zzez$zzc r2 = new com.google.android.gms.internal.mlkit_common.zzez$zzc     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_common.zzaa$zzbf r4 = com.google.android.gms.internal.mlkit_common.zzaa.zzbf.zzl     // Catch: all -> 0x002c
                r2.<init>(r4)     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_common.zzaa.zzbf.zzm = r2     // Catch: all -> 0x002c
            L_0x002a:
                monitor-exit(r3)     // Catch: all -> 0x002c
                goto L_0x002f
            L_0x002c:
                r2 = move-exception
                monitor-exit(r3)     // Catch: all -> 0x002c
                throw r2
            L_0x002f:
                return r2
            L_0x0030:
                com.google.android.gms.internal.mlkit_common.zzaa$zzbf r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzbf.zzl
                return r2
            L_0x0033:
                r2 = 9
                java.lang.Object[] r2 = new java.lang.Object[r2]
                r3 = 0
                java.lang.String r0 = "zzc"
                r2[r3] = r0
                java.lang.String r3 = "zzd"
                r2[r4] = r3
                r3 = 2
                java.lang.String r4 = "zze"
                r2[r3] = r4
                r3 = 3
                com.google.android.gms.internal.mlkit_common.zzfd r4 = com.google.android.gms.internal.mlkit_common.zzaa.zzbf.zza.zzb()
                r2[r3] = r4
                r3 = 4
                java.lang.String r4 = "zzg"
                r2[r3] = r4
                r3 = 5
                com.google.android.gms.internal.mlkit_common.zzfd r4 = com.google.android.gms.internal.mlkit_common.zzaa.zzbf.zza.zzb()
                r2[r3] = r4
                r3 = 6
                java.lang.String r4 = "zzi"
                r2[r3] = r4
                r3 = 7
                com.google.android.gms.internal.mlkit_common.zzfd r4 = com.google.android.gms.internal.mlkit_common.zzaa.zzbf.zza.zzb()
                r2[r3] = r4
                r3 = 8
                java.lang.String r4 = "zzk"
                r2[r3] = r4
                java.lang.String r3 = "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0003\u0000\u0001ဃ\u0000\u0002\u001e\u0003\u001e\u0004\u001e\u0005င\u0001"
                com.google.android.gms.internal.mlkit_common.zzaa$zzbf r4 = com.google.android.gms.internal.mlkit_common.zzaa.zzbf.zzl
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_common.zzez.zza(r4, r3, r2)
                return r2
            L_0x0073:
                com.google.android.gms.internal.mlkit_common.zzaa$zzbf$zzb r2 = new com.google.android.gms.internal.mlkit_common.zzaa$zzbf$zzb
                r2.<init>(r3)
                return r2
            L_0x0079:
                com.google.android.gms.internal.mlkit_common.zzaa$zzbf r2 = new com.google.android.gms.internal.mlkit_common.zzaa$zzbf
                r2.<init>()
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzaa.zzbf.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: com.google.mlkit:common@@16.0.0 */
    /* loaded from: classes.dex */
    public static final class zzac extends zzez<zzac, zzb> implements zzgj {
        private static final zzac zzj;
        private static volatile zzgr<zzac> zzk;
        private int zzc;
        private int zzd;
        private int zze;
        private int zzf;
        private int zzg;
        private boolean zzh;
        private float zzi;

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        /* loaded from: classes.dex */
        public enum zza implements zzfb {
            UNKNOWN_CLASSIFICATIONS(0),
            NO_CLASSIFICATIONS(1),
            ALL_CLASSIFICATIONS(2);
            
            private static final zzfe<zza> zzd = new zzas();
            private final int zze;

            zza(int i) {
                this.zze = i;
            }

            public static zzfd zzb() {
                return zzar.zza;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "<" + zza.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zze + " name=" + name() + '>';
            }

            @Override // com.google.android.gms.internal.mlkit_common.zzfb
            public final int zza() {
                return this.zze;
            }
        }

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        /* loaded from: classes.dex */
        public static final class zzb extends zzez.zza<zzac, zzb> implements zzgj {
            private zzb() {
                super(zzac.zzj);
            }

            /* synthetic */ zzb(zzac zzacVar) {
                this();
            }
        }

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        /* loaded from: classes.dex */
        public enum zzc implements zzfb {
            UNKNOWN_CONTOURS(0),
            NO_CONTOURS(1),
            ALL_CONTOURS(2);
            
            private static final zzfe<zzc> zzd = new zzat();
            private final int zze;

            zzc(int i) {
                this.zze = i;
            }

            public static zzfd zzb() {
                return zzau.zza;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "<" + zzc.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zze + " name=" + name() + '>';
            }

            @Override // com.google.android.gms.internal.mlkit_common.zzfb
            public final int zza() {
                return this.zze;
            }
        }

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        /* loaded from: classes.dex */
        public enum zzd implements zzfb {
            UNKNOWN_LANDMARKS(0),
            NO_LANDMARKS(1),
            ALL_LANDMARKS(2);
            
            private static final zzfe<zzd> zzd = new zzaw();
            private final int zze;

            zzd(int i) {
                this.zze = i;
            }

            public static zzfd zzb() {
                return zzav.zza;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "<" + zzd.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zze + " name=" + name() + '>';
            }

            @Override // com.google.android.gms.internal.mlkit_common.zzfb
            public final int zza() {
                return this.zze;
            }
        }

        /* compiled from: com.google.mlkit:common@@16.0.0 */
        /* loaded from: classes.dex */
        public enum zze implements zzfb {
            UNKNOWN_PERFORMANCE(0),
            FAST(1),
            ACCURATE(2);
            
            private static final zzfe<zze> zzd = new zzax();
            private final int zze;

            zze(int i) {
                this.zze = i;
            }

            public static zzfd zzb() {
                return zzay.zza;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "<" + zze.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zze + " name=" + name() + '>';
            }

            @Override // com.google.android.gms.internal.mlkit_common.zzfb
            public final int zza() {
                return this.zze;
            }
        }

        static {
            zzac zzacVar = new zzac();
            zzj = zzacVar;
            zzez.zza(zzac.class, zzacVar);
        }

        private zzac() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_common.zzez$zzc, com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzac>] */
        /* JADX WARN: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_common.zzez
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_common.zzac.zza
                r4 = 1
                int r2 = r2 - r4
                r2 = r3[r2]
                r3 = 0
                switch(r2) {
                    case 1: goto L_0x0087;
                    case 2: goto L_0x0081;
                    case 3: goto L_0x0033;
                    case 4: goto L_0x0030;
                    case 5: goto L_0x0016;
                    case 6: goto L_0x0011;
                    case 7: goto L_0x0010;
                    default: goto L_0x000a;
                }
            L_0x000a:
                java.lang.UnsupportedOperationException r2 = new java.lang.UnsupportedOperationException
                r2.<init>()
                throw r2
            L_0x0010:
                return r3
            L_0x0011:
                java.lang.Byte r2 = java.lang.Byte.valueOf(r4)
                return r2
            L_0x0016:
                com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzac> r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzac.zzk
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_common.zzaa$zzac> r3 = com.google.android.gms.internal.mlkit_common.zzaa.zzac.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_common.zzgr<com.google.android.gms.internal.mlkit_common.zzaa$zzac> r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzac.zzk     // Catch: all -> 0x002c
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_common.zzez$zzc r2 = new com.google.android.gms.internal.mlkit_common.zzez$zzc     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_common.zzaa$zzac r4 = com.google.android.gms.internal.mlkit_common.zzaa.zzac.zzj     // Catch: all -> 0x002c
                r2.<init>(r4)     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_common.zzaa.zzac.zzk = r2     // Catch: all -> 0x002c
            L_0x002a:
                monitor-exit(r3)     // Catch: all -> 0x002c
                goto L_0x002f
            L_0x002c:
                r2 = move-exception
                monitor-exit(r3)     // Catch: all -> 0x002c
                throw r2
            L_0x002f:
                return r2
            L_0x0030:
                com.google.android.gms.internal.mlkit_common.zzaa$zzac r2 = com.google.android.gms.internal.mlkit_common.zzaa.zzac.zzj
                return r2
            L_0x0033:
                r2 = 11
                java.lang.Object[] r2 = new java.lang.Object[r2]
                r3 = 0
                java.lang.String r0 = "zzc"
                r2[r3] = r0
                java.lang.String r3 = "zzd"
                r2[r4] = r3
                r3 = 2
                com.google.android.gms.internal.mlkit_common.zzfd r4 = com.google.android.gms.internal.mlkit_common.zzaa.zzac.zzd.zzb()
                r2[r3] = r4
                r3 = 3
                java.lang.String r4 = "zze"
                r2[r3] = r4
                r3 = 4
                com.google.android.gms.internal.mlkit_common.zzfd r4 = com.google.android.gms.internal.mlkit_common.zzaa.zzac.zza.zzb()
                r2[r3] = r4
                r3 = 5
                java.lang.String r4 = "zzf"
                r2[r3] = r4
                r3 = 6
                com.google.android.gms.internal.mlkit_common.zzfd r4 = com.google.android.gms.internal.mlkit_common.zzaa.zzac.zze.zzb()
                r2[r3] = r4
                r3 = 7
                java.lang.String r4 = "zzg"
                r2[r3] = r4
                r3 = 8
                com.google.android.gms.internal.mlkit_common.zzfd r4 = com.google.android.gms.internal.mlkit_common.zzaa.zzac.zzc.zzb()
                r2[r3] = r4
                r3 = 9
                java.lang.String r4 = "zzh"
                r2[r3] = r4
                r3 = 10
                java.lang.String r4 = "zzi"
                r2[r3] = r4
                java.lang.String r3 = "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဌ\u0001\u0003ဌ\u0002\u0004ဌ\u0003\u0005ဇ\u0004\u0006ခ\u0005"
                com.google.android.gms.internal.mlkit_common.zzaa$zzac r4 = com.google.android.gms.internal.mlkit_common.zzaa.zzac.zzj
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_common.zzez.zza(r4, r3, r2)
                return r2
            L_0x0081:
                com.google.android.gms.internal.mlkit_common.zzaa$zzac$zzb r2 = new com.google.android.gms.internal.mlkit_common.zzaa$zzac$zzb
                r2.<init>(r3)
                return r2
            L_0x0087:
                com.google.android.gms.internal.mlkit_common.zzaa$zzac r2 = new com.google.android.gms.internal.mlkit_common.zzaa$zzac
                r2.<init>()
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzaa.zzac.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }
}
