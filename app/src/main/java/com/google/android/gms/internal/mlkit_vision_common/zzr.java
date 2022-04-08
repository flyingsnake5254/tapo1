package com.google.android.gms.internal.mlkit_vision_common;

import androidx.core.app.FrameMetricsAggregator;
import com.google.android.gms.internal.mlkit_vision_common.zzcb;
import com.google.android.gms.internal.mlkit_vision_common.zzek;
import com.google.android.gms.internal.mlkit_vision_common.zzhx;
import com.google.firebase.messaging.ServiceStarter;

/* compiled from: com.google.mlkit:vision-common@@16.0.0 */
/* loaded from: classes.dex */
public final class zzr {

    /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
    /* loaded from: classes.dex */
    public static final class zzag extends zzek<zzag, zza> implements zzfx {
        private static final zzag zzk;
        private static volatile zzgf<zzag> zzl;
        private int zzc;
        private long zzd;
        private int zze;
        private int zzf;
        private int zzg;
        private int zzh;
        private int zzi;
        private int zzj;

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        /* loaded from: classes.dex */
        public static final class zza extends zzek.zzb<zzag, zza> implements zzfx {
            private zza() {
                super(zzag.zzk);
            }

            public final zza zza(long j) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zzag) this.zza).zza(j);
                return this;
            }

            public final zza zzb(int i) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zzag) this.zza).zzc(i);
                return this;
            }

            public final zza zzc(int i) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zzag) this.zza).zzd(i);
                return this;
            }

            /* synthetic */ zza(zzt zztVar) {
                this();
            }

            public final zza zza(zzb zzbVar) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zzag) this.zza).zza(zzbVar);
                return this;
            }

            public final zza zza(zzae.zza zzaVar) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zzag) this.zza).zza(zzaVar);
                return this;
            }

            public final zza zza(int i) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zzag) this.zza).zzb(i);
                return this;
            }
        }

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        /* loaded from: classes.dex */
        public enum zzb implements zzep {
            SOURCE_UNKNOWN(0),
            BITMAP(1),
            BYTEARRAY(2),
            BYTEBUFFER(3),
            FILEPATH(4),
            ANDROID_MEDIA_IMAGE(5);
            
            private static final zzeo<zzb> zzg = new zzas();
            private final int zzh;

            zzb(int i) {
                this.zzh = i;
            }

            public static zzer zzb() {
                return zzat.zza;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "<" + zzb.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzh + " name=" + name() + '>';
            }

            @Override // com.google.android.gms.internal.mlkit_vision_common.zzep
            public final int zza() {
                return this.zzh;
            }
        }

        static {
            zzag zzagVar = new zzag();
            zzk = zzagVar;
            zzek.zza(zzag.class, zzagVar);
        }

        private zzag() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(long j) {
            this.zzc |= 1;
            this.zzd = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzb(int i) {
            this.zzc |= 8;
            this.zzg = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzc(int i) {
            this.zzc |= 16;
            this.zzh = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzd(int i) {
            this.zzc |= 32;
            this.zzi = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(zzb zzbVar) {
            this.zze = zzbVar.zza();
            this.zzc |= 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(zzae.zza zzaVar) {
            this.zzf = zzaVar.zza();
            this.zzc |= 4;
        }

        public static zza zza() {
            return zzk.zzh();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_common.zzek$zza, com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzag>] */
        /* JADX WARN: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzek
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_common.zzt.zza
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
                com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzag> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzag.zzl
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzr$zzag> r3 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzag.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzag> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzag.zzl     // Catch: all -> 0x002c
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_common.zzek$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzek$zza     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzag r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzag.zzk     // Catch: all -> 0x002c
                r2.<init>(r4)     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_vision_common.zzr.zzag.zzl = r2     // Catch: all -> 0x002c
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzag r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzag.zzk
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
                com.google.android.gms.internal.mlkit_vision_common.zzer r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzag.zzb.zzb()
                r2[r3] = r4
                r3 = 4
                java.lang.String r4 = "zzf"
                r2[r3] = r4
                r3 = 5
                com.google.android.gms.internal.mlkit_vision_common.zzer r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzae.zza.zzb()
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzag r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzag.zzk
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_common.zzek.zza(r4, r3, r2)
                return r2
            L_0x0077:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzag$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzag$zza
                r2.<init>(r3)
                return r2
            L_0x007d:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzag r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzag
                r2.<init>()
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.zzr.zzag.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
    /* loaded from: classes.dex */
    public static final class zzad extends zzek.zzc<zzad, zza> implements zzfx {
        private static final zzad zzbd;
        private static volatile zzgf<zzad> zzbe;
        private zzp zzaa;
        private zzm zzab;
        private zzo zzac;
        private C0145zzr zzad;
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
        private zzes<zzhx.zzf> zzay = zzek.zzl();

        static {
            zzad zzadVar = new zzad();
            zzbd = zzadVar;
            zzek.zza(zzad.class, zzadVar);
        }

        private zzad() {
        }

        public static zza zza(zzad zzadVar) {
            return (zza) zzbd.zza(zzadVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(zzag zzagVar) {
            this.zzg = zzagVar.zza();
            this.zzd |= 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(zzag zzagVar) {
            zzagVar.getClass();
            this.zzba = zzagVar;
            this.zze |= 16384;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(zzbg zzbgVar) {
            zzbgVar.getClass();
            this.zzf = zzbgVar;
            this.zzd |= 1;
        }

        public static zza zzb() {
            return (zza) zzbd.zzh();
        }

        public final zzbg zza() {
            zzbg zzbgVar = this.zzf;
            return zzbgVar == null ? zzbg.zzc() : zzbgVar;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Type inference failed for: r3v14, types: [com.google.android.gms.internal.mlkit_vision_common.zzek$zza, com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzad>] */
        /* JADX WARN: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzek
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object zza(int r3, java.lang.Object r4, java.lang.Object r5) {
            /*
                Method dump skipped, instructions count: 414
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.zzr.zzad.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        /* loaded from: classes.dex */
        public static final class zza extends zzek.zzd<zzad, zza> implements zzfx {
            private zza() {
                super(zzad.zzbd);
            }

            /* synthetic */ zza(zzt zztVar) {
                this();
            }

            public final zza zza(zzbg.zza zzaVar) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zzad) this.zza).zza((zzbg) ((zzek) zzaVar.zzg()));
                return this;
            }

            public final zzbg zza() {
                return ((zzad) this.zza).zza();
            }

            public final zza zza(zzag zzagVar) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zzad) this.zza).zza(zzagVar);
                return this;
            }

            public final zza zza(zzag.zza zzaVar) {
                if (this.zzb) {
                    zzc();
                    this.zzb = false;
                }
                ((zzad) this.zza).zza((zzag) ((zzek) zzaVar.zzg()));
                return this;
            }
        }
    }

    /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
    /* loaded from: classes.dex */
    public static final class zzbg extends zzek<zzbg, zza> implements zzfx {
        private static final zzbg zzo;
        private static volatile zzgf<zzbg> zzp;
        private int zzc;
        private String zzd = "";
        private String zze = "";
        private String zzf = "";
        private String zzg = "";
        private String zzh = "";
        private String zzi = "";
        private String zzj = "";
        private zzes<String> zzk = zzek.zzl();
        private String zzl = "";
        private boolean zzm;
        private boolean zzn;

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        /* loaded from: classes.dex */
        public static final class zza extends zzek.zzb<zzbg, zza> implements zzfx {
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

            /* synthetic */ zza(zzt zztVar) {
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
            zzek.zza(zzbg.class, zzbgVar);
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
            zzes<String> zzesVar = this.zzk;
            if (!zzesVar.zza()) {
                int size = zzesVar.size();
                this.zzk = zzesVar.zzb(size == 0 ? 10 : size << 1);
            }
            zzda.zza(iterable, this.zzk);
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
        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_common.zzek$zza, com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzbg>] */
        /* JADX WARN: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzek
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_common.zzt.zza
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
                com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzbg> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzbg.zzp
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzr$zzbg> r3 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzbg.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzbg> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzbg.zzp     // Catch: all -> 0x002c
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_common.zzek$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzek$zza     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzbg r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzbg.zzo     // Catch: all -> 0x002c
                r2.<init>(r4)     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_vision_common.zzr.zzbg.zzp = r2     // Catch: all -> 0x002c
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzbg r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzbg.zzo
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzbg r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzbg.zzo
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_common.zzek.zza(r4, r3, r2)
                return r2
            L_0x007f:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzbg$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzbg$zza
                r2.<init>(r3)
                return r2
            L_0x0085:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzbg r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzbg
                r2.<init>()
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.zzr.zzbg.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
    /* loaded from: classes.dex */
    public static final class zzam extends zzek<zzam, zzb> implements zzfx {
        private static final zzam zzh;
        private static volatile zzgf<zzam> zzi;
        private int zzc;
        private zzal zzd;
        private zza zze;
        private zza zzf;
        private boolean zzg;

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        /* loaded from: classes.dex */
        public static final class zzb extends zzek.zzb<zzam, zzb> implements zzfx {
            private zzb() {
                super(zzam.zzh);
            }

            /* synthetic */ zzb(zzt zztVar) {
                this();
            }
        }

        static {
            zzam zzamVar = new zzam();
            zzh = zzamVar;
            zzek.zza(zzam.class, zzamVar);
        }

        private zzam() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_common.zzek$zza, com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzam>] */
        /* JADX WARN: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzek
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_common.zzt.zza
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
                com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzam> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzam.zzi
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzr$zzam> r3 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzam.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzam> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzam.zzi     // Catch: all -> 0x002c
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_common.zzek$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzek$zza     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzam r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzam.zzh     // Catch: all -> 0x002c
                r2.<init>(r4)     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_vision_common.zzr.zzam.zzi = r2     // Catch: all -> 0x002c
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzam r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzam.zzh
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzam r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzam.zzh
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_common.zzek.zza(r4, r3, r2)
                return r2
            L_0x0057:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzam$zzb r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzam$zzb
                r2.<init>(r3)
                return r2
            L_0x005d:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzam r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzam
                r2.<init>()
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.zzr.zzam.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        /* loaded from: classes.dex */
        public static final class zza extends zzek<zza, C0134zza> implements zzfx {
            private static final zza zzh;
            private static volatile zzgf<zza> zzi;
            private int zzc;
            private boolean zzd;
            private boolean zze;
            private boolean zzf;
            private boolean zzg;

            /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
            /* renamed from: com.google.android.gms.internal.mlkit_vision_common.zzr$zzam$zza$zza  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            public static final class C0134zza extends zzek.zzb<zza, C0134zza> implements zzfx {
                private C0134zza() {
                    super(zza.zzh);
                }

                /* synthetic */ C0134zza(zzt zztVar) {
                    this();
                }
            }

            static {
                zza zzaVar = new zza();
                zzh = zzaVar;
                zzek.zza(zza.class, zzaVar);
            }

            private zza() {
            }

            /* JADX INFO: Access modifiers changed from: protected */
            /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_common.zzek$zza, com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzam$zza>] */
            /* JADX WARN: Unknown variable types count: 1 */
            @Override // com.google.android.gms.internal.mlkit_vision_common.zzek
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
                /*
                    r1 = this;
                    int[] r3 = com.google.android.gms.internal.mlkit_vision_common.zzt.zza
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
                    com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzam$zza> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzam.zza.zzi
                    if (r2 != 0) goto L_0x002f
                    java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzr$zzam$zza> r3 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzam.zza.class
                    monitor-enter(r3)
                    com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzam$zza> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzam.zza.zzi     // Catch: all -> 0x002c
                    if (r2 != 0) goto L_0x002a
                    com.google.android.gms.internal.mlkit_vision_common.zzek$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzek$zza     // Catch: all -> 0x002c
                    com.google.android.gms.internal.mlkit_vision_common.zzr$zzam$zza r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzam.zza.zzh     // Catch: all -> 0x002c
                    r2.<init>(r4)     // Catch: all -> 0x002c
                    com.google.android.gms.internal.mlkit_vision_common.zzr.zzam.zza.zzi = r2     // Catch: all -> 0x002c
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
                    com.google.android.gms.internal.mlkit_vision_common.zzr$zzam$zza r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzam.zza.zzh
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
                    com.google.android.gms.internal.mlkit_vision_common.zzr$zzam$zza r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzam.zza.zzh
                    java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_common.zzek.zza(r4, r3, r2)
                    return r2
                L_0x0057:
                    com.google.android.gms.internal.mlkit_vision_common.zzr$zzam$zza$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzam$zza$zza
                    r2.<init>(r3)
                    return r2
                L_0x005d:
                    com.google.android.gms.internal.mlkit_vision_common.zzr$zzam$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzam$zza
                    r2.<init>()
                    return r2
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.zzr.zzam.zza.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
            }
        }
    }

    /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
    /* loaded from: classes.dex */
    public static final class zzau extends zzek<zzau, zzb> implements zzfx {
        private static final zzau zzh;
        private static volatile zzgf<zzau> zzi;
        private int zzc;
        private zzaf zzd;
        private zzai zze;
        private zzc zzf;
        private zzd zzg;

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        /* loaded from: classes.dex */
        public static final class zzb extends zzek.zzb<zzau, zzb> implements zzfx {
            private zzb() {
                super(zzau.zzh);
            }

            /* synthetic */ zzb(zzt zztVar) {
                this();
            }
        }

        static {
            zzau zzauVar = new zzau();
            zzh = zzauVar;
            zzek.zza(zzau.class, zzauVar);
        }

        private zzau() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_common.zzek$zza, com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzau>] */
        /* JADX WARN: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzek
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_common.zzt.zza
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
                com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzau> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzau.zzi
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzr$zzau> r3 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzau.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzau> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzau.zzi     // Catch: all -> 0x002c
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_common.zzek$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzek$zza     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzau r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzau.zzh     // Catch: all -> 0x002c
                r2.<init>(r4)     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_vision_common.zzr.zzau.zzi = r2     // Catch: all -> 0x002c
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzau r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzau.zzh
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzau r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzau.zzh
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_common.zzek.zza(r4, r3, r2)
                return r2
            L_0x0057:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzau$zzb r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzau$zzb
                r2.<init>(r3)
                return r2
            L_0x005d:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzau r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzau
                r2.<init>()
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.zzr.zzau.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        /* loaded from: classes.dex */
        public static final class zza extends zzek<zza, C0135zza> implements zzfx {
            private static final zza zzf;
            private static volatile zzgf<zza> zzg;
            private int zzc;
            private float zzd;
            private String zze = "";

            /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
            /* renamed from: com.google.android.gms.internal.mlkit_vision_common.zzr$zzau$zza$zza  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            public static final class C0135zza extends zzek.zzb<zza, C0135zza> implements zzfx {
                private C0135zza() {
                    super(zza.zzf);
                }

                /* synthetic */ C0135zza(zzt zztVar) {
                    this();
                }
            }

            static {
                zza zzaVar = new zza();
                zzf = zzaVar;
                zzek.zza(zza.class, zzaVar);
            }

            private zza() {
            }

            /* JADX INFO: Access modifiers changed from: protected */
            /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_common.zzek$zza, com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzau$zza>] */
            /* JADX WARN: Unknown variable types count: 1 */
            @Override // com.google.android.gms.internal.mlkit_vision_common.zzek
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
                /*
                    r1 = this;
                    int[] r3 = com.google.android.gms.internal.mlkit_vision_common.zzt.zza
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
                    com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzau$zza> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzau.zza.zzg
                    if (r2 != 0) goto L_0x002f
                    java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzr$zzau$zza> r3 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzau.zza.class
                    monitor-enter(r3)
                    com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzau$zza> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzau.zza.zzg     // Catch: all -> 0x002c
                    if (r2 != 0) goto L_0x002a
                    com.google.android.gms.internal.mlkit_vision_common.zzek$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzek$zza     // Catch: all -> 0x002c
                    com.google.android.gms.internal.mlkit_vision_common.zzr$zzau$zza r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzau.zza.zzf     // Catch: all -> 0x002c
                    r2.<init>(r4)     // Catch: all -> 0x002c
                    com.google.android.gms.internal.mlkit_vision_common.zzr.zzau.zza.zzg = r2     // Catch: all -> 0x002c
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
                    com.google.android.gms.internal.mlkit_vision_common.zzr$zzau$zza r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzau.zza.zzf
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
                    com.google.android.gms.internal.mlkit_vision_common.zzr$zzau$zza r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzau.zza.zzf
                    java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_common.zzek.zza(r4, r3, r2)
                    return r2
                L_0x004d:
                    com.google.android.gms.internal.mlkit_vision_common.zzr$zzau$zza$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzau$zza$zza
                    r2.<init>(r3)
                    return r2
                L_0x0053:
                    com.google.android.gms.internal.mlkit_vision_common.zzr$zzau$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzau$zza
                    r2.<init>()
                    return r2
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.zzr.zzau.zza.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
            }
        }

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        /* loaded from: classes.dex */
        public static final class zzc extends zzek<zzc, zza> implements zzfx {
            private static final zzc zze;
            private static volatile zzgf<zzc> zzf;
            private int zzc;
            private zza zzd;

            /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
            /* loaded from: classes.dex */
            public static final class zza extends zzek.zzb<zzc, zza> implements zzfx {
                private zza() {
                    super(zzc.zze);
                }

                /* synthetic */ zza(zzt zztVar) {
                    this();
                }
            }

            static {
                zzc zzcVar = new zzc();
                zze = zzcVar;
                zzek.zza(zzc.class, zzcVar);
            }

            private zzc() {
            }

            /* JADX INFO: Access modifiers changed from: protected */
            /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_common.zzek$zza, com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzau$zzc>] */
            /* JADX WARN: Unknown variable types count: 1 */
            @Override // com.google.android.gms.internal.mlkit_vision_common.zzek
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
                /*
                    r1 = this;
                    int[] r3 = com.google.android.gms.internal.mlkit_vision_common.zzt.zza
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
                    com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzau$zzc> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzau.zzc.zzf
                    if (r2 != 0) goto L_0x002f
                    java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzr$zzau$zzc> r3 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzau.zzc.class
                    monitor-enter(r3)
                    com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzau$zzc> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzau.zzc.zzf     // Catch: all -> 0x002c
                    if (r2 != 0) goto L_0x002a
                    com.google.android.gms.internal.mlkit_vision_common.zzek$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzek$zza     // Catch: all -> 0x002c
                    com.google.android.gms.internal.mlkit_vision_common.zzr$zzau$zzc r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzau.zzc.zze     // Catch: all -> 0x002c
                    r2.<init>(r4)     // Catch: all -> 0x002c
                    com.google.android.gms.internal.mlkit_vision_common.zzr.zzau.zzc.zzf = r2     // Catch: all -> 0x002c
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
                    com.google.android.gms.internal.mlkit_vision_common.zzr$zzau$zzc r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzau.zzc.zze
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
                    com.google.android.gms.internal.mlkit_vision_common.zzr$zzau$zzc r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzau.zzc.zze
                    java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_common.zzek.zza(r4, r3, r2)
                    return r2
                L_0x0048:
                    com.google.android.gms.internal.mlkit_vision_common.zzr$zzau$zzc$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzau$zzc$zza
                    r2.<init>(r3)
                    return r2
                L_0x004e:
                    com.google.android.gms.internal.mlkit_vision_common.zzr$zzau$zzc r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzau$zzc
                    r2.<init>()
                    return r2
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.zzr.zzau.zzc.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
            }
        }

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        /* loaded from: classes.dex */
        public static final class zzd extends zzek<zzd, zza> implements zzfx {
            private static final zzd zzd;
            private static volatile zzgf<zzd> zze;
            private zzes<zza> zzc = zzek.zzl();

            /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
            /* loaded from: classes.dex */
            public static final class zza extends zzek.zzb<zzd, zza> implements zzfx {
                private zza() {
                    super(zzd.zzd);
                }

                /* synthetic */ zza(zzt zztVar) {
                    this();
                }
            }

            static {
                zzd zzdVar = new zzd();
                zzd = zzdVar;
                zzek.zza(zzd.class, zzdVar);
            }

            private zzd() {
            }

            /* JADX INFO: Access modifiers changed from: protected */
            /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_common.zzek$zza, com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzau$zzd>] */
            /* JADX WARN: Unknown variable types count: 1 */
            @Override // com.google.android.gms.internal.mlkit_vision_common.zzek
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
                /*
                    r1 = this;
                    int[] r3 = com.google.android.gms.internal.mlkit_vision_common.zzt.zza
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
                    com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzau$zzd> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzau.zzd.zze
                    if (r2 != 0) goto L_0x002f
                    java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzr$zzau$zzd> r3 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzau.zzd.class
                    monitor-enter(r3)
                    com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzau$zzd> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzau.zzd.zze     // Catch: all -> 0x002c
                    if (r2 != 0) goto L_0x002a
                    com.google.android.gms.internal.mlkit_vision_common.zzek$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzek$zza     // Catch: all -> 0x002c
                    com.google.android.gms.internal.mlkit_vision_common.zzr$zzau$zzd r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzau.zzd.zzd     // Catch: all -> 0x002c
                    r2.<init>(r4)     // Catch: all -> 0x002c
                    com.google.android.gms.internal.mlkit_vision_common.zzr.zzau.zzd.zze = r2     // Catch: all -> 0x002c
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
                    com.google.android.gms.internal.mlkit_vision_common.zzr$zzau$zzd r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzau.zzd.zzd
                    return r2
                L_0x0033:
                    r2 = 2
                    java.lang.Object[] r2 = new java.lang.Object[r2]
                    r3 = 0
                    java.lang.String r0 = "zzc"
                    r2[r3] = r0
                    java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzr$zzau$zza> r3 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzau.zza.class
                    r2[r4] = r3
                    java.lang.String r3 = "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b"
                    com.google.android.gms.internal.mlkit_vision_common.zzr$zzau$zzd r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzau.zzd.zzd
                    java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_common.zzek.zza(r4, r3, r2)
                    return r2
                L_0x0048:
                    com.google.android.gms.internal.mlkit_vision_common.zzr$zzau$zzd$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzau$zzd$zza
                    r2.<init>(r3)
                    return r2
                L_0x004e:
                    com.google.android.gms.internal.mlkit_vision_common.zzr$zzau$zzd r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzau$zzd
                    r2.<init>()
                    return r2
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.zzr.zzau.zzd.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
            }
        }
    }

    /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
    /* loaded from: classes.dex */
    public static final class zzbc extends zzek<zzbc, zza> implements zzfx {
        private static final zzbc zzi;
        private static volatile zzgf<zzbc> zzj;
        private int zzc;
        private zzaf zzd;
        private zzes<zzc> zze = zzek.zzl();
        private int zzf;
        private int zzg;
        private int zzh;

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        /* loaded from: classes.dex */
        public static final class zza extends zzek.zzb<zzbc, zza> implements zzfx {
            private zza() {
                super(zzbc.zzi);
            }

            /* synthetic */ zza(zzt zztVar) {
                this();
            }
        }

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        /* loaded from: classes.dex */
        public enum zzb implements zzep {
            NO_ERROR(0),
            STATUS_SENSITIVE_TOPIC(1),
            STATUS_QUALITY_THRESHOLDED(2),
            STATUS_INTERNAL_ERROR(3),
            STATUS_NOT_SUPPORTED_LANGUAGE(101),
            STATUS_32_BIT_CPU(1001),
            STATUS_32_BIT_APP(1002);
            
            private static final zzeo<zzb> zzh = new zzbr();
            private final int zzi;

            zzb(int i) {
                this.zzi = i;
            }

            public static zzer zzb() {
                return zzbs.zza;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "<" + zzb.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzi + " name=" + name() + '>';
            }

            @Override // com.google.android.gms.internal.mlkit_vision_common.zzep
            public final int zza() {
                return this.zzi;
            }
        }

        static {
            zzbc zzbcVar = new zzbc();
            zzi = zzbcVar;
            zzek.zza(zzbc.class, zzbcVar);
        }

        private zzbc() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzbc>, com.google.android.gms.internal.mlkit_vision_common.zzek$zza] */
        /* JADX WARN: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzek
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_common.zzt.zza
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
                com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzbc> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzbc.zzj
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzr$zzbc> r3 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzbc.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzbc> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzbc.zzj     // Catch: all -> 0x002c
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_common.zzek$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzek$zza     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzbc r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzbc.zzi     // Catch: all -> 0x002c
                r2.<init>(r4)     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_vision_common.zzr.zzbc.zzj = r2     // Catch: all -> 0x002c
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzbc r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzbc.zzi
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
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzr$zzbc$zzc> r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzbc.zzc.class
                r2[r3] = r4
                r3 = 4
                java.lang.String r4 = "zzf"
                r2[r3] = r4
                r3 = 5
                com.google.android.gms.internal.mlkit_vision_common.zzer r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzbc.zzb.zzb()
                r2[r3] = r4
                r3 = 6
                java.lang.String r4 = "zzg"
                r2[r3] = r4
                r3 = 7
                java.lang.String r4 = "zzh"
                r2[r3] = r4
                java.lang.String r3 = "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0000\u0001ဉ\u0000\u0002\u001b\u0003ဌ\u0001\u0004င\u0002\u0005င\u0003"
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzbc r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzbc.zzi
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_common.zzek.zza(r4, r3, r2)
                return r2
            L_0x0069:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzbc$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzbc$zza
                r2.<init>(r3)
                return r2
            L_0x006f:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzbc r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzbc
                r2.<init>()
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.zzr.zzbc.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        /* loaded from: classes.dex */
        public static final class zzc extends zzek<zzc, zza> implements zzfx {
            private static final zzc zze;
            private static volatile zzgf<zzc> zzf;
            private int zzc;
            private float zzd;

            /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
            /* loaded from: classes.dex */
            public static final class zza extends zzek.zzb<zzc, zza> implements zzfx {
                private zza() {
                    super(zzc.zze);
                }

                /* synthetic */ zza(zzt zztVar) {
                    this();
                }
            }

            static {
                zzc zzcVar = new zzc();
                zze = zzcVar;
                zzek.zza(zzc.class, zzcVar);
            }

            private zzc() {
            }

            /* JADX INFO: Access modifiers changed from: protected */
            /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_common.zzek$zza, com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzbc$zzc>] */
            /* JADX WARN: Unknown variable types count: 1 */
            @Override // com.google.android.gms.internal.mlkit_vision_common.zzek
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
                /*
                    r1 = this;
                    int[] r3 = com.google.android.gms.internal.mlkit_vision_common.zzt.zza
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
                    com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzbc$zzc> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzbc.zzc.zzf
                    if (r2 != 0) goto L_0x002f
                    java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzr$zzbc$zzc> r3 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzbc.zzc.class
                    monitor-enter(r3)
                    com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzbc$zzc> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzbc.zzc.zzf     // Catch: all -> 0x002c
                    if (r2 != 0) goto L_0x002a
                    com.google.android.gms.internal.mlkit_vision_common.zzek$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzek$zza     // Catch: all -> 0x002c
                    com.google.android.gms.internal.mlkit_vision_common.zzr$zzbc$zzc r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzbc.zzc.zze     // Catch: all -> 0x002c
                    r2.<init>(r4)     // Catch: all -> 0x002c
                    com.google.android.gms.internal.mlkit_vision_common.zzr.zzbc.zzc.zzf = r2     // Catch: all -> 0x002c
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
                    com.google.android.gms.internal.mlkit_vision_common.zzr$zzbc$zzc r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzbc.zzc.zze
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
                    com.google.android.gms.internal.mlkit_vision_common.zzr$zzbc$zzc r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzbc.zzc.zze
                    java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_common.zzek.zza(r4, r3, r2)
                    return r2
                L_0x0048:
                    com.google.android.gms.internal.mlkit_vision_common.zzr$zzbc$zzc$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzbc$zzc$zza
                    r2.<init>(r3)
                    return r2
                L_0x004e:
                    com.google.android.gms.internal.mlkit_vision_common.zzr$zzbc$zzc r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzbc$zzc
                    r2.<init>()
                    return r2
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.zzr.zzbc.zzc.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
            }
        }
    }

    /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
    /* loaded from: classes.dex */
    public static final class zza extends zzek<zza, zzb> implements zzfx {
        private static final zza zzg;
        private static volatile zzgf<zza> zzh;
        private int zzc;
        private C0132zza zzd;
        private int zze;
        private zzab zzf;

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        /* loaded from: classes.dex */
        public static final class zzb extends zzek.zzb<zza, zzb> implements zzfx {
            private zzb() {
                super(zza.zzg);
            }

            /* synthetic */ zzb(zzt zztVar) {
                this();
            }
        }

        static {
            zza zzaVar = new zza();
            zzg = zzaVar;
            zzek.zza(zza.class, zzaVar);
        }

        private zza() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_common.zzek$zza, com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zza>] */
        /* JADX WARN: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzek
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_common.zzt.zza
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
                com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zza> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zza.zzh
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzr$zza> r3 = com.google.android.gms.internal.mlkit_vision_common.zzr.zza.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zza> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zza.zzh     // Catch: all -> 0x002c
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_common.zzek$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzek$zza     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_vision_common.zzr$zza r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zza.zzg     // Catch: all -> 0x002c
                r2.<init>(r4)     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_vision_common.zzr.zza.zzh = r2     // Catch: all -> 0x002c
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zza r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zza.zzg
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zza r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zza.zzg
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_common.zzek.zza(r4, r3, r2)
                return r2
            L_0x0052:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zza$zzb r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zza$zzb
                r2.<init>(r3)
                return r2
            L_0x0058:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zza
                r2.<init>()
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.zzr.zza.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        /* renamed from: com.google.android.gms.internal.mlkit_vision_common.zzr$zza$zza  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0132zza extends zzek<C0132zza, C0133zza> implements zzfx {
            private static final C0132zza zzh;
            private static volatile zzgf<C0132zza> zzi;
            private int zzc;
            private int zzd;
            private boolean zze;
            private zzae zzf;
            private zzam zzg;

            /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
            /* renamed from: com.google.android.gms.internal.mlkit_vision_common.zzr$zza$zza$zza  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            public static final class C0133zza extends zzek.zzb<C0132zza, C0133zza> implements zzfx {
                private C0133zza() {
                    super(C0132zza.zzh);
                }

                /* synthetic */ C0133zza(zzt zztVar) {
                    this();
                }
            }

            static {
                C0132zza zzaVar = new C0132zza();
                zzh = zzaVar;
                zzek.zza(C0132zza.class, zzaVar);
            }

            private C0132zza() {
            }

            /* JADX INFO: Access modifiers changed from: protected */
            /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_common.zzek$zza, com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zza$zza>] */
            /* JADX WARN: Unknown variable types count: 1 */
            @Override // com.google.android.gms.internal.mlkit_vision_common.zzek
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
                /*
                    r1 = this;
                    int[] r3 = com.google.android.gms.internal.mlkit_vision_common.zzt.zza
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
                    com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zza$zza> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zza.C0132zza.zzi
                    if (r2 != 0) goto L_0x002f
                    java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzr$zza$zza> r3 = com.google.android.gms.internal.mlkit_vision_common.zzr.zza.C0132zza.class
                    monitor-enter(r3)
                    com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zza$zza> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zza.C0132zza.zzi     // Catch: all -> 0x002c
                    if (r2 != 0) goto L_0x002a
                    com.google.android.gms.internal.mlkit_vision_common.zzek$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzek$zza     // Catch: all -> 0x002c
                    com.google.android.gms.internal.mlkit_vision_common.zzr$zza$zza r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zza.C0132zza.zzh     // Catch: all -> 0x002c
                    r2.<init>(r4)     // Catch: all -> 0x002c
                    com.google.android.gms.internal.mlkit_vision_common.zzr.zza.C0132zza.zzi = r2     // Catch: all -> 0x002c
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
                    com.google.android.gms.internal.mlkit_vision_common.zzr$zza$zza r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zza.C0132zza.zzh
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
                    com.google.android.gms.internal.mlkit_vision_common.zzer r4 = com.google.android.gms.internal.mlkit_vision_common.zzac.zzb()
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
                    com.google.android.gms.internal.mlkit_vision_common.zzr$zza$zza r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zza.C0132zza.zzh
                    java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_common.zzek.zza(r4, r3, r2)
                    return r2
                L_0x005e:
                    com.google.android.gms.internal.mlkit_vision_common.zzr$zza$zza$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zza$zza$zza
                    r2.<init>(r3)
                    return r2
                L_0x0064:
                    com.google.android.gms.internal.mlkit_vision_common.zzr$zza$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zza$zza
                    r2.<init>()
                    return r2
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.zzr.zza.C0132zza.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
            }
        }
    }

    /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
    /* loaded from: classes.dex */
    public static final class zzab extends zzek<zzab, zza> implements zzfx {
        private static final zzab zzj;
        private static volatile zzgf<zzab> zzk;
        private int zzc;
        private long zzd;
        private long zze;
        private long zzf;
        private long zzg;
        private long zzh;
        private long zzi;

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        /* loaded from: classes.dex */
        public static final class zza extends zzek.zzb<zzab, zza> implements zzfx {
            private zza() {
                super(zzab.zzj);
            }

            /* synthetic */ zza(zzt zztVar) {
                this();
            }
        }

        static {
            zzab zzabVar = new zzab();
            zzj = zzabVar;
            zzek.zza(zzab.class, zzabVar);
        }

        private zzab() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzab>, com.google.android.gms.internal.mlkit_vision_common.zzek$zza] */
        /* JADX WARN: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzek
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_common.zzt.zza
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
                com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzab> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzab.zzk
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzr$zzab> r3 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzab.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzab> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzab.zzk     // Catch: all -> 0x002c
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_common.zzek$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzek$zza     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzab r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzab.zzj     // Catch: all -> 0x002c
                r2.<init>(r4)     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_vision_common.zzr.zzab.zzk = r2     // Catch: all -> 0x002c
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzab r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzab.zzj
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzab r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzab.zzj
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_common.zzek.zza(r4, r3, r2)
                return r2
            L_0x0061:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzab$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzab$zza
                r2.<init>(r3)
                return r2
            L_0x0067:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzab r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzab
                r2.<init>()
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.zzr.zzab.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
    /* loaded from: classes.dex */
    public static final class zzai extends zzek<zzai, zza> implements zzfx {
        private static final zzai zzg;
        private static volatile zzgf<zzai> zzh;
        private int zzc;
        private float zzd;
        private float zze;
        private float zzf;

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        /* loaded from: classes.dex */
        public static final class zza extends zzek.zzb<zzai, zza> implements zzfx {
            private zza() {
                super(zzai.zzg);
            }

            /* synthetic */ zza(zzt zztVar) {
                this();
            }
        }

        static {
            zzai zzaiVar = new zzai();
            zzg = zzaiVar;
            zzek.zza(zzai.class, zzaiVar);
        }

        private zzai() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_common.zzek$zza, com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzai>] */
        /* JADX WARN: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzek
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_common.zzt.zza
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
                com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzai> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzai.zzh
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzr$zzai> r3 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzai.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzai> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzai.zzh     // Catch: all -> 0x002c
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_common.zzek$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzek$zza     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzai r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzai.zzg     // Catch: all -> 0x002c
                r2.<init>(r4)     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_vision_common.zzr.zzai.zzh = r2     // Catch: all -> 0x002c
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzai r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzai.zzg
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzai r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzai.zzg
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_common.zzek.zza(r4, r3, r2)
                return r2
            L_0x0052:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzai$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzai$zza
                r2.<init>(r3)
                return r2
            L_0x0058:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzai r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzai
                r2.<init>()
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.zzr.zzai.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
    /* loaded from: classes.dex */
    public static final class zzap extends zzek<zzap, zza> implements zzfx {
        private static final zzap zzj;
        private static volatile zzgf<zzap> zzk;
        private int zzc;
        private zzaf zzd;
        private zzcb.zzb zze;
        private zzae zzf;
        private zzac zzg;
        private int zzh;
        private int zzi;

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        /* loaded from: classes.dex */
        public static final class zza extends zzek.zzb<zzap, zza> implements zzfx {
            private zza() {
                super(zzap.zzj);
            }

            /* synthetic */ zza(zzt zztVar) {
                this();
            }
        }

        static {
            zzap zzapVar = new zzap();
            zzj = zzapVar;
            zzek.zza(zzap.class, zzapVar);
        }

        private zzap() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzap>, com.google.android.gms.internal.mlkit_vision_common.zzek$zza] */
        /* JADX WARN: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzek
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_common.zzt.zza
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
                com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzap> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzap.zzk
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzr$zzap> r3 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzap.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzap> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzap.zzk     // Catch: all -> 0x002c
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_common.zzek$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzek$zza     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzap r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzap.zzj     // Catch: all -> 0x002c
                r2.<init>(r4)     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_vision_common.zzr.zzap.zzk = r2     // Catch: all -> 0x002c
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzap r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzap.zzj
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzap r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzap.zzj
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_common.zzek.zza(r4, r3, r2)
                return r2
            L_0x0061:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzap$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzap$zza
                r2.<init>(r3)
                return r2
            L_0x0067:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzap r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzap
                r2.<init>()
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.zzr.zzap.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
    /* loaded from: classes.dex */
    public static final class zzar extends zzek<zzar, zza> implements zzfx {
        private static final zzar zzi;
        private static volatile zzgf<zzar> zzj;
        private int zzc;
        private zzaf zzd;
        private zzat zze;
        private zzae zzf;
        private int zzg;
        private float zzh;

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        /* loaded from: classes.dex */
        public static final class zza extends zzek.zzb<zzar, zza> implements zzfx {
            private zza() {
                super(zzar.zzi);
            }

            /* synthetic */ zza(zzt zztVar) {
                this();
            }
        }

        static {
            zzar zzarVar = new zzar();
            zzi = zzarVar;
            zzek.zza(zzar.class, zzarVar);
        }

        private zzar() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzar>, com.google.android.gms.internal.mlkit_vision_common.zzek$zza] */
        /* JADX WARN: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzek
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_common.zzt.zza
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
                com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzar> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzar.zzj
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzr$zzar> r3 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzar.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzar> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzar.zzj     // Catch: all -> 0x002c
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_common.zzek$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzek$zza     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzar r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzar.zzi     // Catch: all -> 0x002c
                r2.<init>(r4)     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_vision_common.zzr.zzar.zzj = r2     // Catch: all -> 0x002c
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzar r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzar.zzi
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzar r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzar.zzi
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_common.zzek.zza(r4, r3, r2)
                return r2
            L_0x005c:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzar$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzar$zza
                r2.<init>(r3)
                return r2
            L_0x0062:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzar r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzar
                r2.<init>()
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.zzr.zzar.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
    /* loaded from: classes.dex */
    public static final class zzat extends zzek<zzat, zza> implements zzfx {
        private static final zzat zzg;
        private static volatile zzgf<zzat> zzh;
        private int zzc;
        private int zzd;
        private float zze;
        private zzam zzf;

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        /* loaded from: classes.dex */
        public static final class zza extends zzek.zzb<zzat, zza> implements zzfx {
            private zza() {
                super(zzat.zzg);
            }

            /* synthetic */ zza(zzt zztVar) {
                this();
            }
        }

        static {
            zzat zzatVar = new zzat();
            zzg = zzatVar;
            zzek.zza(zzat.class, zzatVar);
        }

        private zzat() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_common.zzek$zza, com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzat>] */
        /* JADX WARN: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzek
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_common.zzt.zza
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
                com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzat> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzat.zzh
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzr$zzat> r3 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzat.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzat> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzat.zzh     // Catch: all -> 0x002c
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_common.zzek$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzek$zza     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzat r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzat.zzg     // Catch: all -> 0x002c
                r2.<init>(r4)     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_vision_common.zzr.zzat.zzh = r2     // Catch: all -> 0x002c
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzat r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzat.zzg
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzat r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzat.zzg
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_common.zzek.zza(r4, r3, r2)
                return r2
            L_0x0052:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzat$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzat$zza
                r2.<init>(r3)
                return r2
            L_0x0058:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzat r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzat
                r2.<init>()
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.zzr.zzat.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
    /* loaded from: classes.dex */
    public static final class zzaz extends zzek<zzaz, zza> implements zzfx {
        private static final zzaz zzg;
        private static volatile zzgf<zzaz> zzh;
        private int zzc;
        private zzaf zzd;
        private zzae zze;
        private zzba zzf;

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        /* loaded from: classes.dex */
        public static final class zza extends zzek.zzb<zzaz, zza> implements zzfx {
            private zza() {
                super(zzaz.zzg);
            }

            /* synthetic */ zza(zzt zztVar) {
                this();
            }
        }

        static {
            zzaz zzazVar = new zzaz();
            zzg = zzazVar;
            zzek.zza(zzaz.class, zzazVar);
        }

        private zzaz() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_common.zzek$zza, com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzaz>] */
        /* JADX WARN: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzek
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_common.zzt.zza
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
                com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzaz> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzaz.zzh
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzr$zzaz> r3 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzaz.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzaz> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzaz.zzh     // Catch: all -> 0x002c
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_common.zzek$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzek$zza     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzaz r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzaz.zzg     // Catch: all -> 0x002c
                r2.<init>(r4)     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_vision_common.zzr.zzaz.zzh = r2     // Catch: all -> 0x002c
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzaz r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzaz.zzg
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzaz r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzaz.zzg
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_common.zzek.zza(r4, r3, r2)
                return r2
            L_0x0052:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzaz$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzaz$zza
                r2.<init>(r3)
                return r2
            L_0x0058:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzaz r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzaz
                r2.<init>()
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.zzr.zzaz.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
    /* loaded from: classes.dex */
    public static final class zzb extends zzek<zzb, C0137zzb> implements zzfx {
        private static final zzb zzg;
        private static volatile zzgf<zzb> zzh;
        private int zzc;
        private zza zzd;
        private int zze;
        private zzab zzf;

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        /* renamed from: com.google.android.gms.internal.mlkit_vision_common.zzr$zzb$zzb  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0137zzb extends zzek.zzb<zzb, C0137zzb> implements zzfx {
            private C0137zzb() {
                super(zzb.zzg);
            }

            /* synthetic */ C0137zzb(zzt zztVar) {
                this();
            }
        }

        static {
            zzb zzbVar = new zzb();
            zzg = zzbVar;
            zzek.zza(zzb.class, zzbVar);
        }

        private zzb() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_common.zzek$zza, com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzb>] */
        /* JADX WARN: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzek
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_common.zzt.zza
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
                com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzb> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzb.zzh
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzr$zzb> r3 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzb.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzb> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzb.zzh     // Catch: all -> 0x002c
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_common.zzek$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzek$zza     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzb r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzb.zzg     // Catch: all -> 0x002c
                r2.<init>(r4)     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_vision_common.zzr.zzb.zzh = r2     // Catch: all -> 0x002c
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzb r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzb.zzg
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzb r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzb.zzg
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_common.zzek.zza(r4, r3, r2)
                return r2
            L_0x0052:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzb$zzb r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzb$zzb
                r2.<init>(r3)
                return r2
            L_0x0058:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzb r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzb
                r2.<init>()
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.zzr.zzb.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        /* loaded from: classes.dex */
        public static final class zza extends zzek<zza, C0136zza> implements zzfx {
            private static final zza zzi;
            private static volatile zzgf<zza> zzj;
            private int zzc;
            private int zzd;
            private boolean zze;
            private zzes<zzy.zza> zzf = zzek.zzl();
            private zzes<zzy.zza> zzg = zzek.zzl();
            private zzam zzh;

            /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
            /* renamed from: com.google.android.gms.internal.mlkit_vision_common.zzr$zzb$zza$zza  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            public static final class C0136zza extends zzek.zzb<zza, C0136zza> implements zzfx {
                private C0136zza() {
                    super(zza.zzi);
                }

                /* synthetic */ C0136zza(zzt zztVar) {
                    this();
                }
            }

            static {
                zza zzaVar = new zza();
                zzi = zzaVar;
                zzek.zza(zza.class, zzaVar);
            }

            private zza() {
            }

            /* JADX INFO: Access modifiers changed from: protected */
            /* JADX WARN: Type inference failed for: r3v14, types: [com.google.android.gms.internal.mlkit_vision_common.zzek$zza, com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzb$zza>] */
            /* JADX WARN: Unknown variable types count: 1 */
            @Override // com.google.android.gms.internal.mlkit_vision_common.zzek
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final java.lang.Object zza(int r3, java.lang.Object r4, java.lang.Object r5) {
                /*
                    r2 = this;
                    java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzr$zzy$zza> r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzy.zza.class
                    int[] r5 = com.google.android.gms.internal.mlkit_vision_common.zzt.zza
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
                    com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzb$zza> r3 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzb.zza.zzj
                    if (r3 != 0) goto L_0x0031
                    java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzr$zzb$zza> r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzb.zza.class
                    monitor-enter(r4)
                    com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzb$zza> r3 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzb.zza.zzj     // Catch: all -> 0x002e
                    if (r3 != 0) goto L_0x002c
                    com.google.android.gms.internal.mlkit_vision_common.zzek$zza r3 = new com.google.android.gms.internal.mlkit_vision_common.zzek$zza     // Catch: all -> 0x002e
                    com.google.android.gms.internal.mlkit_vision_common.zzr$zzb$zza r5 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzb.zza.zzi     // Catch: all -> 0x002e
                    r3.<init>(r5)     // Catch: all -> 0x002e
                    com.google.android.gms.internal.mlkit_vision_common.zzr.zzb.zza.zzj = r3     // Catch: all -> 0x002e
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
                    com.google.android.gms.internal.mlkit_vision_common.zzr$zzb$zza r3 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzb.zza.zzi
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
                    com.google.android.gms.internal.mlkit_vision_common.zzer r0 = com.google.android.gms.internal.mlkit_vision_common.zzac.zzb()
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
                    com.google.android.gms.internal.mlkit_vision_common.zzr$zzb$zza r5 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzb.zza.zzi
                    java.lang.Object r3 = com.google.android.gms.internal.mlkit_vision_common.zzek.zza(r5, r4, r3)
                    return r3
                L_0x006d:
                    com.google.android.gms.internal.mlkit_vision_common.zzr$zzb$zza$zza r3 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzb$zza$zza
                    r3.<init>(r5)
                    return r3
                L_0x0073:
                    com.google.android.gms.internal.mlkit_vision_common.zzr$zzb$zza r3 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzb$zza
                    r3.<init>()
                    return r3
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.zzr.zzb.zza.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
            }
        }
    }

    /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
    /* loaded from: classes.dex */
    public static final class zzbb extends zzek<zzbb, zza> implements zzfx {
        private static final zzbb zzf;
        private static volatile zzgf<zzbb> zzg;
        private int zzc;
        private zzaf zzd;
        private zzae zze;

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        /* loaded from: classes.dex */
        public static final class zza extends zzek.zzb<zzbb, zza> implements zzfx {
            private zza() {
                super(zzbb.zzf);
            }

            /* synthetic */ zza(zzt zztVar) {
                this();
            }
        }

        static {
            zzbb zzbbVar = new zzbb();
            zzf = zzbbVar;
            zzek.zza(zzbb.class, zzbbVar);
        }

        private zzbb() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzbb>, com.google.android.gms.internal.mlkit_vision_common.zzek$zza] */
        /* JADX WARN: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzek
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_common.zzt.zza
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
                com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzbb> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzbb.zzg
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzr$zzbb> r3 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzbb.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzbb> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzbb.zzg     // Catch: all -> 0x002c
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_common.zzek$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzek$zza     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzbb r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzbb.zzf     // Catch: all -> 0x002c
                r2.<init>(r4)     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_vision_common.zzr.zzbb.zzg = r2     // Catch: all -> 0x002c
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzbb r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzbb.zzf
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzbb r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzbb.zzf
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_common.zzek.zza(r4, r3, r2)
                return r2
            L_0x004d:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzbb$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzbb$zza
                r2.<init>(r3)
                return r2
            L_0x0053:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzbb r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzbb
                r2.<init>()
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.zzr.zzbb.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
    /* loaded from: classes.dex */
    public static final class zzbd extends zzek<zzbd, zza> implements zzfx {
        private static final zzbd zzf;
        private static volatile zzgf<zzbd> zzg;
        private int zzc;
        private zzaf zzd;
        private zzae zze;

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        /* loaded from: classes.dex */
        public static final class zza extends zzek.zzb<zzbd, zza> implements zzfx {
            private zza() {
                super(zzbd.zzf);
            }

            /* synthetic */ zza(zzt zztVar) {
                this();
            }
        }

        static {
            zzbd zzbdVar = new zzbd();
            zzf = zzbdVar;
            zzek.zza(zzbd.class, zzbdVar);
        }

        private zzbd() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzbd>, com.google.android.gms.internal.mlkit_vision_common.zzek$zza] */
        /* JADX WARN: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzek
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_common.zzt.zza
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
                com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzbd> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzbd.zzg
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzr$zzbd> r3 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzbd.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzbd> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzbd.zzg     // Catch: all -> 0x002c
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_common.zzek$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzek$zza     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzbd r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzbd.zzf     // Catch: all -> 0x002c
                r2.<init>(r4)     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_vision_common.zzr.zzbd.zzg = r2     // Catch: all -> 0x002c
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzbd r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzbd.zzf
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzbd r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzbd.zzf
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_common.zzek.zza(r4, r3, r2)
                return r2
            L_0x004d:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzbd$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzbd$zza
                r2.<init>(r3)
                return r2
            L_0x0053:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzbd r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzbd
                r2.<init>()
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.zzr.zzbd.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
    /* loaded from: classes.dex */
    public static final class zzbh extends zzek<zzbh, zza> implements zzfx {
        private static final zzbh zzf;
        private static volatile zzgf<zzbh> zzg;
        private int zzc;
        private String zzd = "";
        private String zze = "";

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        /* loaded from: classes.dex */
        public static final class zza extends zzek.zzb<zzbh, zza> implements zzfx {
            private zza() {
                super(zzbh.zzf);
            }

            /* synthetic */ zza(zzt zztVar) {
                this();
            }
        }

        static {
            zzbh zzbhVar = new zzbh();
            zzf = zzbhVar;
            zzek.zza(zzbh.class, zzbhVar);
        }

        private zzbh() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_common.zzek$zza, com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzbh>] */
        /* JADX WARN: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzek
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_common.zzt.zza
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
                com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzbh> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzbh.zzg
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzr$zzbh> r3 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzbh.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzbh> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzbh.zzg     // Catch: all -> 0x002c
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_common.zzek$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzek$zza     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzbh r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzbh.zzf     // Catch: all -> 0x002c
                r2.<init>(r4)     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_vision_common.zzr.zzbh.zzg = r2     // Catch: all -> 0x002c
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzbh r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzbh.zzf
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzbh r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzbh.zzf
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_common.zzek.zza(r4, r3, r2)
                return r2
            L_0x004d:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzbh$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzbh$zza
                r2.<init>(r3)
                return r2
            L_0x0053:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzbh r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzbh
                r2.<init>()
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.zzr.zzbh.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
    /* loaded from: classes.dex */
    public static final class zzc extends zzek<zzc, zzb> implements zzfx {
        private static final zzc zzg;
        private static volatile zzgf<zzc> zzh;
        private int zzc;
        private zza zzd;
        private int zze;
        private zzab zzf;

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        /* loaded from: classes.dex */
        public static final class zzb extends zzek.zzb<zzc, zzb> implements zzfx {
            private zzb() {
                super(zzc.zzg);
            }

            /* synthetic */ zzb(zzt zztVar) {
                this();
            }
        }

        static {
            zzc zzcVar = new zzc();
            zzg = zzcVar;
            zzek.zza(zzc.class, zzcVar);
        }

        private zzc() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_common.zzek$zza, com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzc>] */
        /* JADX WARN: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzek
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_common.zzt.zza
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
                com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzc> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzc.zzh
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzr$zzc> r3 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzc.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzc> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzc.zzh     // Catch: all -> 0x002c
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_common.zzek$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzek$zza     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzc r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzc.zzg     // Catch: all -> 0x002c
                r2.<init>(r4)     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_vision_common.zzr.zzc.zzh = r2     // Catch: all -> 0x002c
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzc r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzc.zzg
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzc r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzc.zzg
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_common.zzek.zza(r4, r3, r2)
                return r2
            L_0x0052:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzc$zzb r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzc$zzb
                r2.<init>(r3)
                return r2
            L_0x0058:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzc r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzc
                r2.<init>()
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.zzr.zzc.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        /* loaded from: classes.dex */
        public static final class zza extends zzek<zza, C0138zza> implements zzfx {
            private static final zzet<Integer, zzao.zza> zzj = new zzv();
            private static final zzet<Integer, zzao.zzb> zzl = new zzu();
            private static final zza zzm;
            private static volatile zzgf<zza> zzn;
            private int zzc;
            private int zzd;
            private boolean zze;
            private boolean zzf;
            private zzae zzg;
            private zzcb.zza zzh;
            private zzeq zzi = zzek.zzk();
            private zzeq zzk = zzek.zzk();

            /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
            /* renamed from: com.google.android.gms.internal.mlkit_vision_common.zzr$zzc$zza$zza  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            public static final class C0138zza extends zzek.zzb<zza, C0138zza> implements zzfx {
                private C0138zza() {
                    super(zza.zzm);
                }

                /* synthetic */ C0138zza(zzt zztVar) {
                    this();
                }
            }

            /* JADX WARN: Type inference failed for: r0v0, types: [com.google.android.gms.internal.mlkit_vision_common.zzv, com.google.android.gms.internal.mlkit_vision_common.zzet<java.lang.Integer, com.google.android.gms.internal.mlkit_vision_common.zzr$zzao$zza>] */
            /* JADX WARN: Type inference failed for: r0v1, types: [com.google.android.gms.internal.mlkit_vision_common.zzu, com.google.android.gms.internal.mlkit_vision_common.zzet<java.lang.Integer, com.google.android.gms.internal.mlkit_vision_common.zzr$zzao$zzb>] */
            static {
                zza zzaVar = new zza();
                zzm = zzaVar;
                zzek.zza(zza.class, zzaVar);
            }

            private zza() {
            }

            /* JADX INFO: Access modifiers changed from: protected */
            /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_common.zzek$zza, com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzc$zza>] */
            /* JADX WARN: Unknown variable types count: 1 */
            @Override // com.google.android.gms.internal.mlkit_vision_common.zzek
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
                /*
                    r1 = this;
                    int[] r3 = com.google.android.gms.internal.mlkit_vision_common.zzt.zza
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
                    com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzc$zza> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzc.zza.zzn
                    if (r2 != 0) goto L_0x002f
                    java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzr$zzc$zza> r3 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzc.zza.class
                    monitor-enter(r3)
                    com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzc$zza> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzc.zza.zzn     // Catch: all -> 0x002c
                    if (r2 != 0) goto L_0x002a
                    com.google.android.gms.internal.mlkit_vision_common.zzek$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzek$zza     // Catch: all -> 0x002c
                    com.google.android.gms.internal.mlkit_vision_common.zzr$zzc$zza r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzc.zza.zzm     // Catch: all -> 0x002c
                    r2.<init>(r4)     // Catch: all -> 0x002c
                    com.google.android.gms.internal.mlkit_vision_common.zzr.zzc.zza.zzn = r2     // Catch: all -> 0x002c
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
                    com.google.android.gms.internal.mlkit_vision_common.zzr$zzc$zza r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzc.zza.zzm
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
                    com.google.android.gms.internal.mlkit_vision_common.zzer r4 = com.google.android.gms.internal.mlkit_vision_common.zzac.zzb()
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
                    com.google.android.gms.internal.mlkit_vision_common.zzer r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzao.zza.zzb()
                    r2[r3] = r4
                    r3 = 9
                    java.lang.String r4 = "zzk"
                    r2[r3] = r4
                    r3 = 10
                    com.google.android.gms.internal.mlkit_vision_common.zzer r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzao.zzb.zzb()
                    r2[r3] = r4
                    java.lang.String r3 = "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0002\u0000\u0001ဌ\u0000\u0002ဇ\u0001\u0003ဇ\u0002\u0004ဉ\u0003\u0005ဉ\u0004\u0006\u001e\u0007\u001e"
                    com.google.android.gms.internal.mlkit_vision_common.zzr$zzc$zza r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzc.zza.zzm
                    java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_common.zzek.zza(r4, r3, r2)
                    return r2
                L_0x007f:
                    com.google.android.gms.internal.mlkit_vision_common.zzr$zzc$zza$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzc$zza$zza
                    r2.<init>(r3)
                    return r2
                L_0x0085:
                    com.google.android.gms.internal.mlkit_vision_common.zzr$zzc$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzc$zza
                    r2.<init>()
                    return r2
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.zzr.zzc.zza.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
            }
        }
    }

    /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
    /* loaded from: classes.dex */
    public static final class zzd extends zzek<zzd, zzb> implements zzfx {
        private static final zzd zzg;
        private static volatile zzgf<zzd> zzh;
        private int zzc;
        private zza zzd;
        private int zze;
        private zzab zzf;

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        /* loaded from: classes.dex */
        public static final class zzb extends zzek.zzb<zzd, zzb> implements zzfx {
            private zzb() {
                super(zzd.zzg);
            }

            /* synthetic */ zzb(zzt zztVar) {
                this();
            }
        }

        static {
            zzd zzdVar = new zzd();
            zzg = zzdVar;
            zzek.zza(zzd.class, zzdVar);
        }

        private zzd() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_common.zzek$zza, com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzd>] */
        /* JADX WARN: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzek
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_common.zzt.zza
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
                com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzd> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzd.zzh
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzr$zzd> r3 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzd.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzd> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzd.zzh     // Catch: all -> 0x002c
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_common.zzek$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzek$zza     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzd r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzd.zzg     // Catch: all -> 0x002c
                r2.<init>(r4)     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_vision_common.zzr.zzd.zzh = r2     // Catch: all -> 0x002c
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzd r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzd.zzg
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzd r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzd.zzg
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_common.zzek.zza(r4, r3, r2)
                return r2
            L_0x0052:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzd$zzb r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzd$zzb
                r2.<init>(r3)
                return r2
            L_0x0058:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzd r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzd
                r2.<init>()
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.zzr.zzd.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        /* loaded from: classes.dex */
        public static final class zza extends zzek<zza, C0139zza> implements zzfx {
            private static final zza zzj;
            private static volatile zzgf<zza> zzk;
            private int zzc;
            private int zzd;
            private boolean zze;
            private zzae zzf;
            private zzac zzg;
            private int zzh;
            private int zzi;

            /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
            /* renamed from: com.google.android.gms.internal.mlkit_vision_common.zzr$zzd$zza$zza  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            public static final class C0139zza extends zzek.zzb<zza, C0139zza> implements zzfx {
                private C0139zza() {
                    super(zza.zzj);
                }

                /* synthetic */ C0139zza(zzt zztVar) {
                    this();
                }
            }

            static {
                zza zzaVar = new zza();
                zzj = zzaVar;
                zzek.zza(zza.class, zzaVar);
            }

            private zza() {
            }

            /* JADX INFO: Access modifiers changed from: protected */
            /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_common.zzek$zza, com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzd$zza>] */
            /* JADX WARN: Unknown variable types count: 1 */
            @Override // com.google.android.gms.internal.mlkit_vision_common.zzek
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
                /*
                    r1 = this;
                    int[] r3 = com.google.android.gms.internal.mlkit_vision_common.zzt.zza
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
                    com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzd$zza> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzd.zza.zzk
                    if (r2 != 0) goto L_0x002f
                    java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzr$zzd$zza> r3 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzd.zza.class
                    monitor-enter(r3)
                    com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzd$zza> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzd.zza.zzk     // Catch: all -> 0x002c
                    if (r2 != 0) goto L_0x002a
                    com.google.android.gms.internal.mlkit_vision_common.zzek$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzek$zza     // Catch: all -> 0x002c
                    com.google.android.gms.internal.mlkit_vision_common.zzr$zzd$zza r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzd.zza.zzj     // Catch: all -> 0x002c
                    r2.<init>(r4)     // Catch: all -> 0x002c
                    com.google.android.gms.internal.mlkit_vision_common.zzr.zzd.zza.zzk = r2     // Catch: all -> 0x002c
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
                    com.google.android.gms.internal.mlkit_vision_common.zzr$zzd$zza r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzd.zza.zzj
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
                    com.google.android.gms.internal.mlkit_vision_common.zzer r4 = com.google.android.gms.internal.mlkit_vision_common.zzac.zzb()
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
                    com.google.android.gms.internal.mlkit_vision_common.zzr$zzd$zza r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzd.zza.zzj
                    java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_common.zzek.zza(r4, r3, r2)
                    return r2
                L_0x0069:
                    com.google.android.gms.internal.mlkit_vision_common.zzr$zzd$zza$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzd$zza$zza
                    r2.<init>(r3)
                    return r2
                L_0x006f:
                    com.google.android.gms.internal.mlkit_vision_common.zzr$zzd$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzd$zza
                    r2.<init>()
                    return r2
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.zzr.zzd.zza.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
            }
        }
    }

    /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
    /* loaded from: classes.dex */
    public static final class zze extends zzek<zze, zzb> implements zzfx {
        private static final zze zzg;
        private static volatile zzgf<zze> zzh;
        private int zzc;
        private zza zzd;
        private int zze;
        private zzab zzf;

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        /* loaded from: classes.dex */
        public static final class zzb extends zzek.zzb<zze, zzb> implements zzfx {
            private zzb() {
                super(zze.zzg);
            }

            /* synthetic */ zzb(zzt zztVar) {
                this();
            }
        }

        static {
            zze zzeVar = new zze();
            zzg = zzeVar;
            zzek.zza(zze.class, zzeVar);
        }

        private zze() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zze>, com.google.android.gms.internal.mlkit_vision_common.zzek$zza] */
        /* JADX WARN: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzek
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_common.zzt.zza
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
                com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zze> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zze.zzh
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzr$zze> r3 = com.google.android.gms.internal.mlkit_vision_common.zzr.zze.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zze> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zze.zzh     // Catch: all -> 0x002c
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_common.zzek$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzek$zza     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_vision_common.zzr$zze r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zze.zzg     // Catch: all -> 0x002c
                r2.<init>(r4)     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_vision_common.zzr.zze.zzh = r2     // Catch: all -> 0x002c
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zze r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zze.zzg
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zze r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zze.zzg
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_common.zzek.zza(r4, r3, r2)
                return r2
            L_0x0052:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zze$zzb r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zze$zzb
                r2.<init>(r3)
                return r2
            L_0x0058:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zze r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zze
                r2.<init>()
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.zzr.zze.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        /* loaded from: classes.dex */
        public static final class zza extends zzek<zza, C0140zza> implements zzfx {
            private static final zza zzh;
            private static volatile zzgf<zza> zzi;
            private int zzc;
            private int zzd;
            private boolean zze;
            private zzae zzf;
            private zzat zzg;

            /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
            /* renamed from: com.google.android.gms.internal.mlkit_vision_common.zzr$zze$zza$zza  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            public static final class C0140zza extends zzek.zzb<zza, C0140zza> implements zzfx {
                private C0140zza() {
                    super(zza.zzh);
                }

                /* synthetic */ C0140zza(zzt zztVar) {
                    this();
                }
            }

            static {
                zza zzaVar = new zza();
                zzh = zzaVar;
                zzek.zza(zza.class, zzaVar);
            }

            private zza() {
            }

            /* JADX INFO: Access modifiers changed from: protected */
            /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zze$zza>, com.google.android.gms.internal.mlkit_vision_common.zzek$zza] */
            /* JADX WARN: Unknown variable types count: 1 */
            @Override // com.google.android.gms.internal.mlkit_vision_common.zzek
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
                /*
                    r1 = this;
                    int[] r3 = com.google.android.gms.internal.mlkit_vision_common.zzt.zza
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
                    com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zze$zza> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zze.zza.zzi
                    if (r2 != 0) goto L_0x002f
                    java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzr$zze$zza> r3 = com.google.android.gms.internal.mlkit_vision_common.zzr.zze.zza.class
                    monitor-enter(r3)
                    com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zze$zza> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zze.zza.zzi     // Catch: all -> 0x002c
                    if (r2 != 0) goto L_0x002a
                    com.google.android.gms.internal.mlkit_vision_common.zzek$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzek$zza     // Catch: all -> 0x002c
                    com.google.android.gms.internal.mlkit_vision_common.zzr$zze$zza r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zze.zza.zzh     // Catch: all -> 0x002c
                    r2.<init>(r4)     // Catch: all -> 0x002c
                    com.google.android.gms.internal.mlkit_vision_common.zzr.zze.zza.zzi = r2     // Catch: all -> 0x002c
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
                    com.google.android.gms.internal.mlkit_vision_common.zzr$zze$zza r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zze.zza.zzh
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
                    com.google.android.gms.internal.mlkit_vision_common.zzer r4 = com.google.android.gms.internal.mlkit_vision_common.zzac.zzb()
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
                    com.google.android.gms.internal.mlkit_vision_common.zzr$zze$zza r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zze.zza.zzh
                    java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_common.zzek.zza(r4, r3, r2)
                    return r2
                L_0x005e:
                    com.google.android.gms.internal.mlkit_vision_common.zzr$zze$zza$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zze$zza$zza
                    r2.<init>(r3)
                    return r2
                L_0x0064:
                    com.google.android.gms.internal.mlkit_vision_common.zzr$zze$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zze$zza
                    r2.<init>()
                    return r2
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.zzr.zze.zza.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
            }
        }
    }

    /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
    /* loaded from: classes.dex */
    public static final class zzf extends zzek<zzf, zzb> implements zzfx {
        private static final zzf zzg;
        private static volatile zzgf<zzf> zzh;
        private int zzc;
        private zza zzd;
        private int zze;
        private zzab zzf;

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        /* loaded from: classes.dex */
        public static final class zzb extends zzek.zzb<zzf, zzb> implements zzfx {
            private zzb() {
                super(zzf.zzg);
            }

            /* synthetic */ zzb(zzt zztVar) {
                this();
            }
        }

        static {
            zzf zzfVar = new zzf();
            zzg = zzfVar;
            zzek.zza(zzf.class, zzfVar);
        }

        private zzf() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzf>, com.google.android.gms.internal.mlkit_vision_common.zzek$zza] */
        /* JADX WARN: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzek
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_common.zzt.zza
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
                com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzf> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzf.zzh
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzr$zzf> r3 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzf.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzf> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzf.zzh     // Catch: all -> 0x002c
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_common.zzek$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzek$zza     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzf r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzf.zzg     // Catch: all -> 0x002c
                r2.<init>(r4)     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_vision_common.zzr.zzf.zzh = r2     // Catch: all -> 0x002c
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzf r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzf.zzg
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzf r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzf.zzg
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_common.zzek.zza(r4, r3, r2)
                return r2
            L_0x0052:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzf$zzb r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzf$zzb
                r2.<init>(r3)
                return r2
            L_0x0058:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzf r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzf
                r2.<init>()
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.zzr.zzf.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        /* loaded from: classes.dex */
        public static final class zza extends zzek<zza, C0141zza> implements zzfx {
            private static final zza zzi;
            private static volatile zzgf<zza> zzj;
            private int zzc;
            private int zzd;
            private boolean zze;
            private boolean zzf;
            private zzae zzg;
            private zzaw zzh;

            /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
            /* renamed from: com.google.android.gms.internal.mlkit_vision_common.zzr$zzf$zza$zza  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            public static final class C0141zza extends zzek.zzb<zza, C0141zza> implements zzfx {
                private C0141zza() {
                    super(zza.zzi);
                }

                /* synthetic */ C0141zza(zzt zztVar) {
                    this();
                }
            }

            static {
                zza zzaVar = new zza();
                zzi = zzaVar;
                zzek.zza(zza.class, zzaVar);
            }

            private zza() {
            }

            /* JADX INFO: Access modifiers changed from: protected */
            /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_common.zzek$zza, com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzf$zza>] */
            /* JADX WARN: Unknown variable types count: 1 */
            @Override // com.google.android.gms.internal.mlkit_vision_common.zzek
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
                /*
                    r1 = this;
                    int[] r3 = com.google.android.gms.internal.mlkit_vision_common.zzt.zza
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
                    com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzf$zza> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzf.zza.zzj
                    if (r2 != 0) goto L_0x002f
                    java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzr$zzf$zza> r3 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzf.zza.class
                    monitor-enter(r3)
                    com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzf$zza> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzf.zza.zzj     // Catch: all -> 0x002c
                    if (r2 != 0) goto L_0x002a
                    com.google.android.gms.internal.mlkit_vision_common.zzek$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzek$zza     // Catch: all -> 0x002c
                    com.google.android.gms.internal.mlkit_vision_common.zzr$zzf$zza r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzf.zza.zzi     // Catch: all -> 0x002c
                    r2.<init>(r4)     // Catch: all -> 0x002c
                    com.google.android.gms.internal.mlkit_vision_common.zzr.zzf.zza.zzj = r2     // Catch: all -> 0x002c
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
                    com.google.android.gms.internal.mlkit_vision_common.zzr$zzf$zza r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzf.zza.zzi
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
                    com.google.android.gms.internal.mlkit_vision_common.zzer r4 = com.google.android.gms.internal.mlkit_vision_common.zzac.zzb()
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
                    com.google.android.gms.internal.mlkit_vision_common.zzr$zzf$zza r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzf.zza.zzi
                    java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_common.zzek.zza(r4, r3, r2)
                    return r2
                L_0x0063:
                    com.google.android.gms.internal.mlkit_vision_common.zzr$zzf$zza$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzf$zza$zza
                    r2.<init>(r3)
                    return r2
                L_0x0069:
                    com.google.android.gms.internal.mlkit_vision_common.zzr$zzf$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzf$zza
                    r2.<init>()
                    return r2
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.zzr.zzf.zza.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
            }
        }
    }

    /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
    /* loaded from: classes.dex */
    public static final class zzg extends zzek<zzg, zzb> implements zzfx {
        private static final zzg zzg;
        private static volatile zzgf<zzg> zzh;
        private int zzc;
        private zza zzd;
        private int zze;
        private zzab zzf;

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        /* loaded from: classes.dex */
        public static final class zzb extends zzek.zzb<zzg, zzb> implements zzfx {
            private zzb() {
                super(zzg.zzg);
            }

            /* synthetic */ zzb(zzt zztVar) {
                this();
            }
        }

        static {
            zzg zzgVar = new zzg();
            zzg = zzgVar;
            zzek.zza(zzg.class, zzgVar);
        }

        private zzg() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzg>, com.google.android.gms.internal.mlkit_vision_common.zzek$zza] */
        /* JADX WARN: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzek
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_common.zzt.zza
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
                com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzg> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzg.zzh
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzr$zzg> r3 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzg.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzg> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzg.zzh     // Catch: all -> 0x002c
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_common.zzek$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzek$zza     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzg r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzg.zzg     // Catch: all -> 0x002c
                r2.<init>(r4)     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_vision_common.zzr.zzg.zzh = r2     // Catch: all -> 0x002c
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzg r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzg.zzg
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzg r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzg.zzg
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_common.zzek.zza(r4, r3, r2)
                return r2
            L_0x0052:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzg$zzb r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzg$zzb
                r2.<init>(r3)
                return r2
            L_0x0058:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzg r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzg
                r2.<init>()
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.zzr.zzg.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        /* loaded from: classes.dex */
        public static final class zza extends zzek<zza, C0142zza> implements zzfx {
            private static final zza zzh;
            private static volatile zzgf<zza> zzi;
            private int zzc;
            private int zzd;
            private boolean zze;
            private zzae zzf;
            private zzba zzg;

            /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
            /* renamed from: com.google.android.gms.internal.mlkit_vision_common.zzr$zzg$zza$zza  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            public static final class C0142zza extends zzek.zzb<zza, C0142zza> implements zzfx {
                private C0142zza() {
                    super(zza.zzh);
                }

                /* synthetic */ C0142zza(zzt zztVar) {
                    this();
                }
            }

            static {
                zza zzaVar = new zza();
                zzh = zzaVar;
                zzek.zza(zza.class, zzaVar);
            }

            private zza() {
            }

            /* JADX INFO: Access modifiers changed from: protected */
            /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_common.zzek$zza, com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzg$zza>] */
            /* JADX WARN: Unknown variable types count: 1 */
            @Override // com.google.android.gms.internal.mlkit_vision_common.zzek
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
                /*
                    r1 = this;
                    int[] r3 = com.google.android.gms.internal.mlkit_vision_common.zzt.zza
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
                    com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzg$zza> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzg.zza.zzi
                    if (r2 != 0) goto L_0x002f
                    java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzr$zzg$zza> r3 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzg.zza.class
                    monitor-enter(r3)
                    com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzg$zza> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzg.zza.zzi     // Catch: all -> 0x002c
                    if (r2 != 0) goto L_0x002a
                    com.google.android.gms.internal.mlkit_vision_common.zzek$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzek$zza     // Catch: all -> 0x002c
                    com.google.android.gms.internal.mlkit_vision_common.zzr$zzg$zza r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzg.zza.zzh     // Catch: all -> 0x002c
                    r2.<init>(r4)     // Catch: all -> 0x002c
                    com.google.android.gms.internal.mlkit_vision_common.zzr.zzg.zza.zzi = r2     // Catch: all -> 0x002c
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
                    com.google.android.gms.internal.mlkit_vision_common.zzr$zzg$zza r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzg.zza.zzh
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
                    com.google.android.gms.internal.mlkit_vision_common.zzer r4 = com.google.android.gms.internal.mlkit_vision_common.zzac.zzb()
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
                    com.google.android.gms.internal.mlkit_vision_common.zzr$zzg$zza r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzg.zza.zzh
                    java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_common.zzek.zza(r4, r3, r2)
                    return r2
                L_0x005e:
                    com.google.android.gms.internal.mlkit_vision_common.zzr$zzg$zza$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzg$zza$zza
                    r2.<init>(r3)
                    return r2
                L_0x0064:
                    com.google.android.gms.internal.mlkit_vision_common.zzr$zzg$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzg$zza
                    r2.<init>()
                    return r2
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.zzr.zzg.zza.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
            }
        }
    }

    /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
    /* loaded from: classes.dex */
    public static final class zzh extends zzek<zzh, zzb> implements zzfx {
        private static final zzh zzg;
        private static volatile zzgf<zzh> zzh;
        private int zzc;
        private zza zzd;
        private int zze;
        private zzab zzf;

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        /* loaded from: classes.dex */
        public static final class zzb extends zzek.zzb<zzh, zzb> implements zzfx {
            private zzb() {
                super(zzh.zzg);
            }

            /* synthetic */ zzb(zzt zztVar) {
                this();
            }
        }

        static {
            zzh zzhVar = new zzh();
            zzg = zzhVar;
            zzek.zza(zzh.class, zzhVar);
        }

        private zzh() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzh>, com.google.android.gms.internal.mlkit_vision_common.zzek$zza] */
        /* JADX WARN: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzek
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_common.zzt.zza
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
                com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzh> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzh.zzh
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzr$zzh> r3 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzh.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzh> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzh.zzh     // Catch: all -> 0x002c
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_common.zzek$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzek$zza     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzh r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzh.zzg     // Catch: all -> 0x002c
                r2.<init>(r4)     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_vision_common.zzr.zzh.zzh = r2     // Catch: all -> 0x002c
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzh r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzh.zzg
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzh r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzh.zzg
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_common.zzek.zza(r4, r3, r2)
                return r2
            L_0x0052:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzh$zzb r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzh$zzb
                r2.<init>(r3)
                return r2
            L_0x0058:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzh r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzh
                r2.<init>()
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.zzr.zzh.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        /* loaded from: classes.dex */
        public static final class zza extends zzek<zza, C0143zza> implements zzfx {
            private static final zza zzg;
            private static volatile zzgf<zza> zzh;
            private int zzc;
            private int zzd;
            private boolean zze;
            private zzae zzf;

            /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
            /* renamed from: com.google.android.gms.internal.mlkit_vision_common.zzr$zzh$zza$zza  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            public static final class C0143zza extends zzek.zzb<zza, C0143zza> implements zzfx {
                private C0143zza() {
                    super(zza.zzg);
                }

                /* synthetic */ C0143zza(zzt zztVar) {
                    this();
                }
            }

            static {
                zza zzaVar = new zza();
                zzg = zzaVar;
                zzek.zza(zza.class, zzaVar);
            }

            private zza() {
            }

            /* JADX INFO: Access modifiers changed from: protected */
            /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_common.zzek$zza, com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzh$zza>] */
            /* JADX WARN: Unknown variable types count: 1 */
            @Override // com.google.android.gms.internal.mlkit_vision_common.zzek
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
                /*
                    r1 = this;
                    int[] r3 = com.google.android.gms.internal.mlkit_vision_common.zzt.zza
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
                    com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzh$zza> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzh.zza.zzh
                    if (r2 != 0) goto L_0x002f
                    java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzr$zzh$zza> r3 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzh.zza.class
                    monitor-enter(r3)
                    com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzh$zza> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzh.zza.zzh     // Catch: all -> 0x002c
                    if (r2 != 0) goto L_0x002a
                    com.google.android.gms.internal.mlkit_vision_common.zzek$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzek$zza     // Catch: all -> 0x002c
                    com.google.android.gms.internal.mlkit_vision_common.zzr$zzh$zza r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzh.zza.zzg     // Catch: all -> 0x002c
                    r2.<init>(r4)     // Catch: all -> 0x002c
                    com.google.android.gms.internal.mlkit_vision_common.zzr.zzh.zza.zzh = r2     // Catch: all -> 0x002c
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
                    com.google.android.gms.internal.mlkit_vision_common.zzr$zzh$zza r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzh.zza.zzg
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
                    com.google.android.gms.internal.mlkit_vision_common.zzer r4 = com.google.android.gms.internal.mlkit_vision_common.zzac.zzb()
                    r2[r3] = r4
                    r3 = 3
                    java.lang.String r4 = "zze"
                    r2[r3] = r4
                    r3 = 4
                    java.lang.String r4 = "zzf"
                    r2[r3] = r4
                    java.lang.String r3 = "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဇ\u0001\u0003ဉ\u0002"
                    com.google.android.gms.internal.mlkit_vision_common.zzr$zzh$zza r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzh.zza.zzg
                    java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_common.zzek.zza(r4, r3, r2)
                    return r2
                L_0x0059:
                    com.google.android.gms.internal.mlkit_vision_common.zzr$zzh$zza$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzh$zza$zza
                    r2.<init>(r3)
                    return r2
                L_0x005f:
                    com.google.android.gms.internal.mlkit_vision_common.zzr$zzh$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzh$zza
                    r2.<init>()
                    return r2
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.zzr.zzh.zza.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
            }
        }
    }

    /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
    /* loaded from: classes.dex */
    public static final class zzi extends zzek<zzi, zzb> implements zzfx {
        private static final zzi zzg;
        private static volatile zzgf<zzi> zzh;
        private int zzc;
        private zza zzd;
        private int zze;
        private zzab zzf;

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        /* loaded from: classes.dex */
        public static final class zzb extends zzek.zzb<zzi, zzb> implements zzfx {
            private zzb() {
                super(zzi.zzg);
            }

            /* synthetic */ zzb(zzt zztVar) {
                this();
            }
        }

        static {
            zzi zziVar = new zzi();
            zzg = zziVar;
            zzek.zza(zzi.class, zziVar);
        }

        private zzi() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_common.zzek$zza, com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzi>] */
        /* JADX WARN: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzek
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_common.zzt.zza
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
                com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzi> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzi.zzh
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzr$zzi> r3 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzi.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzi> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzi.zzh     // Catch: all -> 0x002c
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_common.zzek$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzek$zza     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzi r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzi.zzg     // Catch: all -> 0x002c
                r2.<init>(r4)     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_vision_common.zzr.zzi.zzh = r2     // Catch: all -> 0x002c
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzi r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzi.zzg
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzi r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzi.zzg
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_common.zzek.zza(r4, r3, r2)
                return r2
            L_0x0052:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzi$zzb r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzi$zzb
                r2.<init>(r3)
                return r2
            L_0x0058:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzi r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzi
                r2.<init>()
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.zzr.zzi.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        /* loaded from: classes.dex */
        public static final class zza extends zzek<zza, C0144zza> implements zzfx {
            private static final zza zzh;
            private static volatile zzgf<zza> zzi;
            private int zzc;
            private int zzd;
            private boolean zze;
            private boolean zzf;
            private zzae zzg;

            /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
            /* renamed from: com.google.android.gms.internal.mlkit_vision_common.zzr$zzi$zza$zza  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            public static final class C0144zza extends zzek.zzb<zza, C0144zza> implements zzfx {
                private C0144zza() {
                    super(zza.zzh);
                }

                /* synthetic */ C0144zza(zzt zztVar) {
                    this();
                }
            }

            static {
                zza zzaVar = new zza();
                zzh = zzaVar;
                zzek.zza(zza.class, zzaVar);
            }

            private zza() {
            }

            /* JADX INFO: Access modifiers changed from: protected */
            /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_common.zzek$zza, com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzi$zza>] */
            /* JADX WARN: Unknown variable types count: 1 */
            @Override // com.google.android.gms.internal.mlkit_vision_common.zzek
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
                /*
                    r1 = this;
                    int[] r3 = com.google.android.gms.internal.mlkit_vision_common.zzt.zza
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
                    com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzi$zza> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzi.zza.zzi
                    if (r2 != 0) goto L_0x002f
                    java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzr$zzi$zza> r3 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzi.zza.class
                    monitor-enter(r3)
                    com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzi$zza> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzi.zza.zzi     // Catch: all -> 0x002c
                    if (r2 != 0) goto L_0x002a
                    com.google.android.gms.internal.mlkit_vision_common.zzek$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzek$zza     // Catch: all -> 0x002c
                    com.google.android.gms.internal.mlkit_vision_common.zzr$zzi$zza r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzi.zza.zzh     // Catch: all -> 0x002c
                    r2.<init>(r4)     // Catch: all -> 0x002c
                    com.google.android.gms.internal.mlkit_vision_common.zzr.zzi.zza.zzi = r2     // Catch: all -> 0x002c
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
                    com.google.android.gms.internal.mlkit_vision_common.zzr$zzi$zza r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzi.zza.zzh
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
                    com.google.android.gms.internal.mlkit_vision_common.zzer r4 = com.google.android.gms.internal.mlkit_vision_common.zzac.zzb()
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
                    com.google.android.gms.internal.mlkit_vision_common.zzr$zzi$zza r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzi.zza.zzh
                    java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_common.zzek.zza(r4, r3, r2)
                    return r2
                L_0x005e:
                    com.google.android.gms.internal.mlkit_vision_common.zzr$zzi$zza$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzi$zza$zza
                    r2.<init>(r3)
                    return r2
                L_0x0064:
                    com.google.android.gms.internal.mlkit_vision_common.zzr$zzi$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzi$zza
                    r2.<init>()
                    return r2
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.zzr.zzi.zza.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
            }
        }
    }

    /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
    /* loaded from: classes.dex */
    public static final class zzk extends zzek<zzk, zza> implements zzfx {
        private static final zzk zzi;
        private static volatile zzgf<zzk> zzj;
        private int zzc;
        private zzaf zzd;
        private zzam zze;
        private long zzf;
        private float zzg;
        private zzae zzh;

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        /* loaded from: classes.dex */
        public static final class zza extends zzek.zzb<zzk, zza> implements zzfx {
            private zza() {
                super(zzk.zzi);
            }

            /* synthetic */ zza(zzt zztVar) {
                this();
            }
        }

        static {
            zzk zzkVar = new zzk();
            zzi = zzkVar;
            zzek.zza(zzk.class, zzkVar);
        }

        private zzk() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_common.zzek$zza, com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzk>] */
        /* JADX WARN: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzek
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_common.zzt.zza
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
                com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzk> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzk.zzj
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzr$zzk> r3 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzk.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzk> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzk.zzj     // Catch: all -> 0x002c
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_common.zzek$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzek$zza     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzk r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzk.zzi     // Catch: all -> 0x002c
                r2.<init>(r4)     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_vision_common.zzr.zzk.zzj = r2     // Catch: all -> 0x002c
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzk r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzk.zzi
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzk r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzk.zzi
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_common.zzek.zza(r4, r3, r2)
                return r2
            L_0x005c:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzk$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzk$zza
                r2.<init>(r3)
                return r2
            L_0x0062:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzk r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzk
                r2.<init>()
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.zzr.zzk.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
    /* loaded from: classes.dex */
    public static final class zzm extends zzek<zzm, zza> implements zzfx {
        private static final zzm zzg;
        private static volatile zzgf<zzm> zzh;
        private int zzc;
        private zzaf zzd;
        private zzn zze;
        private zzae zzf;

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        /* loaded from: classes.dex */
        public static final class zza extends zzek.zzb<zzm, zza> implements zzfx {
            private zza() {
                super(zzm.zzg);
            }

            /* synthetic */ zza(zzt zztVar) {
                this();
            }
        }

        static {
            zzm zzmVar = new zzm();
            zzg = zzmVar;
            zzek.zza(zzm.class, zzmVar);
        }

        private zzm() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_common.zzek$zza, com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzm>] */
        /* JADX WARN: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzek
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_common.zzt.zza
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
                com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzm> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzm.zzh
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzr$zzm> r3 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzm.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzm> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzm.zzh     // Catch: all -> 0x002c
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_common.zzek$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzek$zza     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzm r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzm.zzg     // Catch: all -> 0x002c
                r2.<init>(r4)     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_vision_common.zzr.zzm.zzh = r2     // Catch: all -> 0x002c
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzm r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzm.zzg
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzm r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzm.zzg
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_common.zzek.zza(r4, r3, r2)
                return r2
            L_0x0052:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzm$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzm$zza
                r2.<init>(r3)
                return r2
            L_0x0058:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzm r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzm
                r2.<init>()
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.zzr.zzm.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
    /* loaded from: classes.dex */
    public static final class zzo extends zzek<zzo, zza> implements zzfx {
        private static final zzo zzg;
        private static volatile zzgf<zzo> zzh;
        private int zzc;
        private zzaf zzd;
        private zzn zze;
        private zzae zzf;

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        /* loaded from: classes.dex */
        public static final class zza extends zzek.zzb<zzo, zza> implements zzfx {
            private zza() {
                super(zzo.zzg);
            }

            /* synthetic */ zza(zzt zztVar) {
                this();
            }
        }

        static {
            zzo zzoVar = new zzo();
            zzg = zzoVar;
            zzek.zza(zzo.class, zzoVar);
        }

        private zzo() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_common.zzek$zza, com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzo>] */
        /* JADX WARN: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzek
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_common.zzt.zza
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
                com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzo> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzo.zzh
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzr$zzo> r3 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzo.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzo> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzo.zzh     // Catch: all -> 0x002c
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_common.zzek$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzek$zza     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzo r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzo.zzg     // Catch: all -> 0x002c
                r2.<init>(r4)     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_vision_common.zzr.zzo.zzh = r2     // Catch: all -> 0x002c
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzo r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzo.zzg
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzo r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzo.zzg
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_common.zzek.zza(r4, r3, r2)
                return r2
            L_0x0052:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzo$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzo$zza
                r2.<init>(r3)
                return r2
            L_0x0058:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzo r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzo
                r2.<init>()
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.zzr.zzo.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
    /* loaded from: classes.dex */
    public static final class zzp extends zzek<zzp, zza> implements zzfx {
        private static final zzp zzg;
        private static volatile zzgf<zzp> zzh;
        private int zzc;
        private zzaf zzd;
        private zzn zze;
        private zzae zzf;

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        /* loaded from: classes.dex */
        public static final class zza extends zzek.zzb<zzp, zza> implements zzfx {
            private zza() {
                super(zzp.zzg);
            }

            /* synthetic */ zza(zzt zztVar) {
                this();
            }
        }

        static {
            zzp zzpVar = new zzp();
            zzg = zzpVar;
            zzek.zza(zzp.class, zzpVar);
        }

        private zzp() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_common.zzek$zza, com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzp>] */
        /* JADX WARN: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzek
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_common.zzt.zza
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
                com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzp> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzp.zzh
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzr$zzp> r3 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzp.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzp> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzp.zzh     // Catch: all -> 0x002c
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_common.zzek$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzek$zza     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzp r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzp.zzg     // Catch: all -> 0x002c
                r2.<init>(r4)     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_vision_common.zzr.zzp.zzh = r2     // Catch: all -> 0x002c
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzp r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzp.zzg
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzp r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzp.zzg
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_common.zzek.zza(r4, r3, r2)
                return r2
            L_0x0052:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzp$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzp$zza
                r2.<init>(r3)
                return r2
            L_0x0058:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzp r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzp
                r2.<init>()
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.zzr.zzp.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
    /* loaded from: classes.dex */
    public static final class zzq extends zzek<zzq, zza> implements zzfx {
        private static final zzq zzg;
        private static volatile zzgf<zzq> zzh;
        private int zzc;
        private zzaf zzd;
        private zzn zze;
        private zzae zzf;

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        /* loaded from: classes.dex */
        public static final class zza extends zzek.zzb<zzq, zza> implements zzfx {
            private zza() {
                super(zzq.zzg);
            }

            /* synthetic */ zza(zzt zztVar) {
                this();
            }
        }

        static {
            zzq zzqVar = new zzq();
            zzg = zzqVar;
            zzek.zza(zzq.class, zzqVar);
        }

        private zzq() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_common.zzek$zza, com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzq>] */
        /* JADX WARN: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzek
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_common.zzt.zza
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
                com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzq> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzq.zzh
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzr$zzq> r3 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzq.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzq> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzq.zzh     // Catch: all -> 0x002c
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_common.zzek$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzek$zza     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzq r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzq.zzg     // Catch: all -> 0x002c
                r2.<init>(r4)     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_vision_common.zzr.zzq.zzh = r2     // Catch: all -> 0x002c
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzq r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzq.zzg
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzq r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzq.zzg
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_common.zzek.zza(r4, r3, r2)
                return r2
            L_0x0052:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzq$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzq$zza
                r2.<init>(r3)
                return r2
            L_0x0058:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzq r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzq
                r2.<init>()
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.zzr.zzq.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
    /* renamed from: com.google.android.gms.internal.mlkit_vision_common.zzr$zzr  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0145zzr extends zzek<C0145zzr, zza> implements zzfx {
        private static final C0145zzr zzg;
        private static volatile zzgf<C0145zzr> zzh;
        private int zzc;
        private zzaf zzd;
        private zzn zze;
        private zzae zzf;

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        /* renamed from: com.google.android.gms.internal.mlkit_vision_common.zzr$zzr$zza */
        /* loaded from: classes.dex */
        public static final class zza extends zzek.zzb<C0145zzr, zza> implements zzfx {
            private zza() {
                super(C0145zzr.zzg);
            }

            /* synthetic */ zza(zzt zztVar) {
                this();
            }
        }

        static {
            C0145zzr zzrVar = new C0145zzr();
            zzg = zzrVar;
            zzek.zza(C0145zzr.class, zzrVar);
        }

        private C0145zzr() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_common.zzek$zza, com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzr>] */
        /* JADX WARN: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzek
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_common.zzt.zza
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
                com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzr> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.C0145zzr.zzh
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzr$zzr> r3 = com.google.android.gms.internal.mlkit_vision_common.zzr.C0145zzr.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzr> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.C0145zzr.zzh     // Catch: all -> 0x002c
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_common.zzek$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzek$zza     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzr r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.C0145zzr.zzg     // Catch: all -> 0x002c
                r2.<init>(r4)     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_vision_common.zzr.C0145zzr.zzh = r2     // Catch: all -> 0x002c
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzr r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.C0145zzr.zzg
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzr r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.C0145zzr.zzg
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_common.zzek.zza(r4, r3, r2)
                return r2
            L_0x0052:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzr$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzr$zza
                r2.<init>(r3)
                return r2
            L_0x0058:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzr r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzr
                r2.<init>()
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.zzr.C0145zzr.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
    /* loaded from: classes.dex */
    public static final class zzs extends zzek<zzs, zza> implements zzfx {
        private static final zzs zzg;
        private static volatile zzgf<zzs> zzh;
        private int zzc;
        private zzaf zzd;
        private zzn zze;
        private zzae zzf;

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        /* loaded from: classes.dex */
        public static final class zza extends zzek.zzb<zzs, zza> implements zzfx {
            private zza() {
                super(zzs.zzg);
            }

            /* synthetic */ zza(zzt zztVar) {
                this();
            }
        }

        static {
            zzs zzsVar = new zzs();
            zzg = zzsVar;
            zzek.zza(zzs.class, zzsVar);
        }

        private zzs() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_common.zzek$zza, com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzs>] */
        /* JADX WARN: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzek
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_common.zzt.zza
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
                com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzs> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzs.zzh
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzr$zzs> r3 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzs.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzs> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzs.zzh     // Catch: all -> 0x002c
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_common.zzek$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzek$zza     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzs r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzs.zzg     // Catch: all -> 0x002c
                r2.<init>(r4)     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_vision_common.zzr.zzs.zzh = r2     // Catch: all -> 0x002c
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzs r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzs.zzg
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzs r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzs.zzg
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_common.zzek.zza(r4, r3, r2)
                return r2
            L_0x0052:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzs$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzs$zza
                r2.<init>(r3)
                return r2
            L_0x0058:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzs r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzs
                r2.<init>()
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.zzr.zzs.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
    /* loaded from: classes.dex */
    public static final class zzt extends zzek<zzt, zza> implements zzfx {
        private static final zzt zzg;
        private static volatile zzgf<zzt> zzh;
        private int zzc;
        private zzaf zzd;
        private zzn zze;
        private zzae zzf;

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        /* loaded from: classes.dex */
        public static final class zza extends zzek.zzb<zzt, zza> implements zzfx {
            private zza() {
                super(zzt.zzg);
            }

            /* synthetic */ zza(zzt zztVar) {
                this();
            }
        }

        static {
            zzt zztVar = new zzt();
            zzg = zztVar;
            zzek.zza(zzt.class, zztVar);
        }

        private zzt() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_common.zzek$zza, com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzt>] */
        /* JADX WARN: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzek
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_common.zzt.zza
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
                com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzt> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzt.zzh
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzr$zzt> r3 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzt.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzt> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzt.zzh     // Catch: all -> 0x002c
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_common.zzek$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzek$zza     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzt r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzt.zzg     // Catch: all -> 0x002c
                r2.<init>(r4)     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_vision_common.zzr.zzt.zzh = r2     // Catch: all -> 0x002c
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzt r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzt.zzg
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzt r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzt.zzg
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_common.zzek.zza(r4, r3, r2)
                return r2
            L_0x0052:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzt$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzt$zza
                r2.<init>(r3)
                return r2
            L_0x0058:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzt r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzt
                r2.<init>()
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.zzr.zzt.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
    /* loaded from: classes.dex */
    public static final class zzu extends zzek<zzu, zza> implements zzfx {
        private static final zzu zzg;
        private static volatile zzgf<zzu> zzh;
        private int zzc;
        private zzaf zzd;
        private zzn zze;
        private zzae zzf;

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        /* loaded from: classes.dex */
        public static final class zza extends zzek.zzb<zzu, zza> implements zzfx {
            private zza() {
                super(zzu.zzg);
            }

            /* synthetic */ zza(zzt zztVar) {
                this();
            }
        }

        static {
            zzu zzuVar = new zzu();
            zzg = zzuVar;
            zzek.zza(zzu.class, zzuVar);
        }

        private zzu() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzu>, com.google.android.gms.internal.mlkit_vision_common.zzek$zza] */
        /* JADX WARN: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzek
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_common.zzt.zza
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
                com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzu> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzu.zzh
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzr$zzu> r3 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzu.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzu> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzu.zzh     // Catch: all -> 0x002c
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_common.zzek$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzek$zza     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzu r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzu.zzg     // Catch: all -> 0x002c
                r2.<init>(r4)     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_vision_common.zzr.zzu.zzh = r2     // Catch: all -> 0x002c
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzu r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzu.zzg
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzu r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzu.zzg
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_common.zzek.zza(r4, r3, r2)
                return r2
            L_0x0052:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzu$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzu$zza
                r2.<init>(r3)
                return r2
            L_0x0058:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzu r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzu
                r2.<init>()
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.zzr.zzu.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
    /* loaded from: classes.dex */
    public static final class zzv extends zzek<zzv, zza> implements zzfx {
        private static final zzv zzg;
        private static volatile zzgf<zzv> zzh;
        private int zzc;
        private zzaf zzd;
        private zzn zze;
        private zzae zzf;

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        /* loaded from: classes.dex */
        public static final class zza extends zzek.zzb<zzv, zza> implements zzfx {
            private zza() {
                super(zzv.zzg);
            }

            /* synthetic */ zza(zzt zztVar) {
                this();
            }
        }

        static {
            zzv zzvVar = new zzv();
            zzg = zzvVar;
            zzek.zza(zzv.class, zzvVar);
        }

        private zzv() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzv>, com.google.android.gms.internal.mlkit_vision_common.zzek$zza] */
        /* JADX WARN: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzek
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_common.zzt.zza
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
                com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzv> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzv.zzh
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzr$zzv> r3 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzv.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzv> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzv.zzh     // Catch: all -> 0x002c
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_common.zzek$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzek$zza     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzv r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzv.zzg     // Catch: all -> 0x002c
                r2.<init>(r4)     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_vision_common.zzr.zzv.zzh = r2     // Catch: all -> 0x002c
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzv r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzv.zzg
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzv r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzv.zzg
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_common.zzek.zza(r4, r3, r2)
                return r2
            L_0x0052:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzv$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzv$zza
                r2.<init>(r3)
                return r2
            L_0x0058:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzv r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzv
                r2.<init>()
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.zzr.zzv.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
    /* loaded from: classes.dex */
    public static final class zzw extends zzek<zzw, zza> implements zzfx {
        private static final zzw zzg;
        private static volatile zzgf<zzw> zzh;
        private int zzc;
        private zzaf zzd;
        private zzn zze;
        private zzae zzf;

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        /* loaded from: classes.dex */
        public static final class zza extends zzek.zzb<zzw, zza> implements zzfx {
            private zza() {
                super(zzw.zzg);
            }

            /* synthetic */ zza(zzt zztVar) {
                this();
            }
        }

        static {
            zzw zzwVar = new zzw();
            zzg = zzwVar;
            zzek.zza(zzw.class, zzwVar);
        }

        private zzw() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzw>, com.google.android.gms.internal.mlkit_vision_common.zzek$zza] */
        /* JADX WARN: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzek
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_common.zzt.zza
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
                com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzw> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzw.zzh
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzr$zzw> r3 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzw.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzw> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzw.zzh     // Catch: all -> 0x002c
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_common.zzek$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzek$zza     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzw r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzw.zzg     // Catch: all -> 0x002c
                r2.<init>(r4)     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_vision_common.zzr.zzw.zzh = r2     // Catch: all -> 0x002c
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzw r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzw.zzg
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzw r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzw.zzg
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_common.zzek.zza(r4, r3, r2)
                return r2
            L_0x0052:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzw$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzw$zza
                r2.<init>(r3)
                return r2
            L_0x0058:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzw r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzw
                r2.<init>()
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.zzr.zzw.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
    /* loaded from: classes.dex */
    public static final class zzy extends zzek<zzy, zzb> implements zzfx {
        private static final zzy zzi;
        private static volatile zzgf<zzy> zzj;
        private int zzc;
        private zzaf zzd;
        private zzam zze;
        private zzes<zza> zzf = zzek.zzl();
        private zzes<zza> zzg = zzek.zzl();
        private long zzh;

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        /* loaded from: classes.dex */
        public static final class zzb extends zzek.zzb<zzy, zzb> implements zzfx {
            private zzb() {
                super(zzy.zzi);
            }

            /* synthetic */ zzb(zzt zztVar) {
                this();
            }
        }

        static {
            zzy zzyVar = new zzy();
            zzi = zzyVar;
            zzek.zza(zzy.class, zzyVar);
        }

        private zzy() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Type inference failed for: r3v14, types: [com.google.android.gms.internal.mlkit_vision_common.zzek$zza, com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzy>] */
        /* JADX WARN: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzek
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object zza(int r3, java.lang.Object r4, java.lang.Object r5) {
            /*
                r2 = this;
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzr$zzy$zza> r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzy.zza.class
                int[] r5 = com.google.android.gms.internal.mlkit_vision_common.zzt.zza
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
                com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzy> r3 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzy.zzj
                if (r3 != 0) goto L_0x0031
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzr$zzy> r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzy.class
                monitor-enter(r4)
                com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzy> r3 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzy.zzj     // Catch: all -> 0x002e
                if (r3 != 0) goto L_0x002c
                com.google.android.gms.internal.mlkit_vision_common.zzek$zza r3 = new com.google.android.gms.internal.mlkit_vision_common.zzek$zza     // Catch: all -> 0x002e
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzy r5 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzy.zzi     // Catch: all -> 0x002e
                r3.<init>(r5)     // Catch: all -> 0x002e
                com.google.android.gms.internal.mlkit_vision_common.zzr.zzy.zzj = r3     // Catch: all -> 0x002e
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzy r3 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzy.zzi
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzy r5 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzy.zzi
                java.lang.Object r3 = com.google.android.gms.internal.mlkit_vision_common.zzek.zza(r5, r4, r3)
                return r3
            L_0x0065:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzy$zzb r3 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzy$zzb
                r3.<init>(r5)
                return r3
            L_0x006b:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzy r3 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzy
                r3.<init>()
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.zzr.zzy.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        /* loaded from: classes.dex */
        public static final class zza extends zzek<zza, zzb> implements zzfx {
            private static final zza zzf;
            private static volatile zzgf<zza> zzg;
            private int zzc;
            private int zzd;
            private zzeq zze = zzek.zzk();

            /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
            /* renamed from: com.google.android.gms.internal.mlkit_vision_common.zzr$zzy$zza$zza  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            public enum EnumC0146zza implements zzep {
                UNKNOWN_DATA_TYPE(0),
                TYPE_FLOAT32(1),
                TYPE_INT32(2),
                TYPE_BYTE(3),
                TYPE_LONG(4);
                
                private static final zzeo<EnumC0146zza> zzf = new zzaa();
                private final int zzg;

                EnumC0146zza(int i) {
                    this.zzg = i;
                }

                public static zzer zzb() {
                    return zzz.zza;
                }

                @Override // java.lang.Enum
                public final String toString() {
                    return "<" + EnumC0146zza.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzg + " name=" + name() + '>';
                }

                @Override // com.google.android.gms.internal.mlkit_vision_common.zzep
                public final int zza() {
                    return this.zzg;
                }
            }

            /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
            /* loaded from: classes.dex */
            public static final class zzb extends zzek.zzb<zza, zzb> implements zzfx {
                private zzb() {
                    super(zza.zzf);
                }

                /* synthetic */ zzb(zzt zztVar) {
                    this();
                }
            }

            static {
                zza zzaVar = new zza();
                zzf = zzaVar;
                zzek.zza(zza.class, zzaVar);
            }

            private zza() {
            }

            /* JADX INFO: Access modifiers changed from: protected */
            /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_common.zzek$zza, com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzy$zza>] */
            /* JADX WARN: Unknown variable types count: 1 */
            @Override // com.google.android.gms.internal.mlkit_vision_common.zzek
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
                /*
                    r1 = this;
                    int[] r3 = com.google.android.gms.internal.mlkit_vision_common.zzt.zza
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
                    com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzy$zza> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzy.zza.zzg
                    if (r2 != 0) goto L_0x002f
                    java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzr$zzy$zza> r3 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzy.zza.class
                    monitor-enter(r3)
                    com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzy$zza> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzy.zza.zzg     // Catch: all -> 0x002c
                    if (r2 != 0) goto L_0x002a
                    com.google.android.gms.internal.mlkit_vision_common.zzek$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzek$zza     // Catch: all -> 0x002c
                    com.google.android.gms.internal.mlkit_vision_common.zzr$zzy$zza r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzy.zza.zzf     // Catch: all -> 0x002c
                    r2.<init>(r4)     // Catch: all -> 0x002c
                    com.google.android.gms.internal.mlkit_vision_common.zzr.zzy.zza.zzg = r2     // Catch: all -> 0x002c
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
                    com.google.android.gms.internal.mlkit_vision_common.zzr$zzy$zza r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzy.zza.zzf
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
                    com.google.android.gms.internal.mlkit_vision_common.zzer r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzy.zza.EnumC0146zza.zzb()
                    r2[r3] = r4
                    r3 = 3
                    java.lang.String r4 = "zze"
                    r2[r3] = r4
                    java.lang.String r3 = "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001ဌ\u0000\u0002\u0016"
                    com.google.android.gms.internal.mlkit_vision_common.zzr$zzy$zza r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzy.zza.zzf
                    java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_common.zzek.zza(r4, r3, r2)
                    return r2
                L_0x0054:
                    com.google.android.gms.internal.mlkit_vision_common.zzr$zzy$zza$zzb r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzy$zza$zzb
                    r2.<init>(r3)
                    return r2
                L_0x005a:
                    com.google.android.gms.internal.mlkit_vision_common.zzr$zzy$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzy$zza
                    r2.<init>()
                    return r2
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.zzr.zzy.zza.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
            }
        }
    }

    /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
    /* loaded from: classes.dex */
    public static final class zzaa extends zzek<zzaa, zza> implements zzfx {
        private static final zzaa zzf;
        private static volatile zzgf<zzaa> zzg;
        private int zzc;
        private int zzd;
        private boolean zze;

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        /* loaded from: classes.dex */
        public static final class zza extends zzek.zzb<zzaa, zza> implements zzfx {
            private zza() {
                super(zzaa.zzf);
            }

            /* synthetic */ zza(zzt zztVar) {
                this();
            }
        }

        static {
            zzaa zzaaVar = new zzaa();
            zzf = zzaaVar;
            zzek.zza(zzaa.class, zzaaVar);
        }

        private zzaa() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzaa>, com.google.android.gms.internal.mlkit_vision_common.zzek$zza] */
        /* JADX WARN: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzek
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_common.zzt.zza
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
                com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzaa> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzaa.zzg
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzr$zzaa> r3 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzaa.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzaa> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzaa.zzg     // Catch: all -> 0x002c
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_common.zzek$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzek$zza     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzaa r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzaa.zzf     // Catch: all -> 0x002c
                r2.<init>(r4)     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_vision_common.zzr.zzaa.zzg = r2     // Catch: all -> 0x002c
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzaa r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzaa.zzf
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
                com.google.android.gms.internal.mlkit_vision_common.zzer r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzal.zza.zzb()
                r2[r3] = r4
                r3 = 3
                java.lang.String r4 = "zze"
                r2[r3] = r4
                java.lang.String r3 = "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဇ\u0001"
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzaa r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzaa.zzf
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_common.zzek.zza(r4, r3, r2)
                return r2
            L_0x0054:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzaa$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzaa$zza
                r2.<init>(r3)
                return r2
            L_0x005a:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzaa r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzaa
                r2.<init>()
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.zzr.zzaa.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
    /* loaded from: classes.dex */
    public static final class zzae extends zzek<zzae, zzb> implements zzfx {
        private static final zzae zzg;
        private static volatile zzgf<zzae> zzh;
        private int zzc;
        private int zzd;
        private int zze;
        private int zzf;

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        /* loaded from: classes.dex */
        public enum zza implements zzep {
            UNKNOWN_FORMAT(0),
            NV16(1),
            NV21(2),
            YV12(3),
            YUV_420_888(7),
            JPEG(8),
            BITMAP(4),
            CM_SAMPLE_BUFFER_REF(5),
            UI_IMAGE(6);
            
            private static final zzeo<zza> zzj = new zzar();
            private final int zzk;

            zza(int i) {
                this.zzk = i;
            }

            public static zzer zzb() {
                return zzaq.zza;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "<" + zza.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzk + " name=" + name() + '>';
            }

            @Override // com.google.android.gms.internal.mlkit_vision_common.zzep
            public final int zza() {
                return this.zzk;
            }
        }

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        /* loaded from: classes.dex */
        public static final class zzb extends zzek.zzb<zzae, zzb> implements zzfx {
            private zzb() {
                super(zzae.zzg);
            }

            /* synthetic */ zzb(zzt zztVar) {
                this();
            }
        }

        static {
            zzae zzaeVar = new zzae();
            zzg = zzaeVar;
            zzek.zza(zzae.class, zzaeVar);
        }

        private zzae() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_common.zzek$zza, com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzae>] */
        /* JADX WARN: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzek
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_common.zzt.zza
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
                com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzae> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzae.zzh
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzr$zzae> r3 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzae.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzae> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzae.zzh     // Catch: all -> 0x002c
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_common.zzek$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzek$zza     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzae r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzae.zzg     // Catch: all -> 0x002c
                r2.<init>(r4)     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_vision_common.zzr.zzae.zzh = r2     // Catch: all -> 0x002c
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzae r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzae.zzg
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
                com.google.android.gms.internal.mlkit_vision_common.zzer r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzae.zza.zzb()
                r2[r3] = r4
                r3 = 3
                java.lang.String r4 = "zze"
                r2[r3] = r4
                r3 = 4
                java.lang.String r4 = "zzf"
                r2[r3] = r4
                java.lang.String r3 = "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဋ\u0001\u0003ဋ\u0002"
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzae r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzae.zzg
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_common.zzek.zza(r4, r3, r2)
                return r2
            L_0x0059:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzae$zzb r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzae$zzb
                r2.<init>(r3)
                return r2
            L_0x005f:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzae r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzae
                r2.<init>()
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.zzr.zzae.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
    /* loaded from: classes.dex */
    public static final class zzaf extends zzek<zzaf, zza> implements zzfx {
        private static final zzaf zzk;
        private static volatile zzgf<zzaf> zzl;
        private int zzc;
        private long zzd;
        private int zze;
        private boolean zzf;
        private boolean zzg;
        private boolean zzh;
        private boolean zzi;
        private int zzj;

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        /* loaded from: classes.dex */
        public static final class zza extends zzek.zzb<zzaf, zza> implements zzfx {
            private zza() {
                super(zzaf.zzk);
            }

            /* synthetic */ zza(zzt zztVar) {
                this();
            }
        }

        static {
            zzaf zzafVar = new zzaf();
            zzk = zzafVar;
            zzek.zza(zzaf.class, zzafVar);
        }

        private zzaf() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_common.zzek$zza, com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzaf>] */
        /* JADX WARN: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzek
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_common.zzt.zza
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
                com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzaf> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzaf.zzl
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzr$zzaf> r3 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzaf.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzaf> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzaf.zzl     // Catch: all -> 0x002c
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_common.zzek$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzek$zza     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzaf r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzaf.zzk     // Catch: all -> 0x002c
                r2.<init>(r4)     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_vision_common.zzr.zzaf.zzl = r2     // Catch: all -> 0x002c
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzaf r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzaf.zzk
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
                com.google.android.gms.internal.mlkit_vision_common.zzer r4 = com.google.android.gms.internal.mlkit_vision_common.zzac.zzb()
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzaf r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzaf.zzk
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_common.zzek.zza(r4, r3, r2)
                return r2
            L_0x006f:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzaf$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzaf$zza
                r2.<init>(r3)
                return r2
            L_0x0075:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzaf r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzaf
                r2.<init>()
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.zzr.zzaf.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
    /* loaded from: classes.dex */
    public static final class zzah extends zzek<zzah, zza> implements zzfx {
        private static final zzah zzf;
        private static volatile zzgf<zzah> zzg;
        private int zzc;
        private int zzd;
        private boolean zze;

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        /* loaded from: classes.dex */
        public static final class zza extends zzek.zzb<zzah, zza> implements zzfx {
            private zza() {
                super(zzah.zzf);
            }

            /* synthetic */ zza(zzt zztVar) {
                this();
            }
        }

        static {
            zzah zzahVar = new zzah();
            zzf = zzahVar;
            zzek.zza(zzah.class, zzahVar);
        }

        private zzah() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_common.zzek$zza, com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzah>] */
        /* JADX WARN: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzek
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_common.zzt.zza
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
                com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzah> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzah.zzg
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzr$zzah> r3 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzah.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzah> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzah.zzg     // Catch: all -> 0x002c
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_common.zzek$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzek$zza     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzah r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzah.zzf     // Catch: all -> 0x002c
                r2.<init>(r4)     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_vision_common.zzr.zzah.zzg = r2     // Catch: all -> 0x002c
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzah r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzah.zzf
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
                com.google.android.gms.internal.mlkit_vision_common.zzer r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzal.zza.zzb()
                r2[r3] = r4
                r3 = 3
                java.lang.String r4 = "zze"
                r2[r3] = r4
                java.lang.String r3 = "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဇ\u0001"
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzah r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzah.zzf
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_common.zzek.zza(r4, r3, r2)
                return r2
            L_0x0054:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzah$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzah$zza
                r2.<init>(r3)
                return r2
            L_0x005a:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzah r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzah
                r2.<init>()
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.zzr.zzah.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
    /* loaded from: classes.dex */
    public static final class zzaj extends zzek<zzaj, zzb> implements zzfx {
        private static final zzaj zze;
        private static volatile zzgf<zzaj> zzf;
        private int zzc;
        private int zzd;

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        /* loaded from: classes.dex */
        public enum zza implements zzep {
            UNKNOWN(0),
            TRANSLATE(1);
            
            private static final zzeo<zza> zzc = new zzau();
            private final int zzd;

            zza(int i) {
                this.zzd = i;
            }

            public static zzer zzb() {
                return zzav.zza;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "<" + zza.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzd + " name=" + name() + '>';
            }

            @Override // com.google.android.gms.internal.mlkit_vision_common.zzep
            public final int zza() {
                return this.zzd;
            }
        }

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        /* loaded from: classes.dex */
        public static final class zzb extends zzek.zzb<zzaj, zzb> implements zzfx {
            private zzb() {
                super(zzaj.zze);
            }

            /* synthetic */ zzb(zzt zztVar) {
                this();
            }
        }

        static {
            zzaj zzajVar = new zzaj();
            zze = zzajVar;
            zzek.zza(zzaj.class, zzajVar);
        }

        private zzaj() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_common.zzek$zza, com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzaj>] */
        /* JADX WARN: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzek
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_common.zzt.zza
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
                com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzaj> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzaj.zzf
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzr$zzaj> r3 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzaj.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzaj> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzaj.zzf     // Catch: all -> 0x002c
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_common.zzek$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzek$zza     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzaj r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzaj.zze     // Catch: all -> 0x002c
                r2.<init>(r4)     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_vision_common.zzr.zzaj.zzf = r2     // Catch: all -> 0x002c
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzaj r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzaj.zze
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
                com.google.android.gms.internal.mlkit_vision_common.zzer r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzaj.zza.zzb()
                r2[r3] = r4
                java.lang.String r3 = "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဌ\u0000"
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzaj r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzaj.zze
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_common.zzek.zza(r4, r3, r2)
                return r2
            L_0x004f:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzaj$zzb r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzaj$zzb
                r2.<init>(r3)
                return r2
            L_0x0055:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzaj r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzaj
                r2.<init>()
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.zzr.zzaj.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
    /* loaded from: classes.dex */
    public static final class zzan extends zzek<zzan, zzb> implements zzfx {
        private static final zzan zzh;
        private static volatile zzgf<zzan> zzi;
        private int zzc;
        private int zzd;
        private float zze;
        private int zzf;
        private int zzg;

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        /* loaded from: classes.dex */
        public enum zza implements zzep {
            CATEGORY_UNKNOWN(0),
            CATEGORY_HOME_GOOD(1),
            CATEGORY_FASHION_GOOD(2),
            CATEGORY_ANIMAL(3),
            CATEGORY_FOOD(4),
            CATEGORY_PLACE(5),
            CATEGORY_PLANT(6);
            
            private static final zzeo<zza> zzh = new zzbd();
            private final int zzi;

            zza(int i) {
                this.zzi = i;
            }

            public static zzer zzb() {
                return zzbc.zza;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "<" + zza.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzi + " name=" + name() + '>';
            }

            @Override // com.google.android.gms.internal.mlkit_vision_common.zzep
            public final int zza() {
                return this.zzi;
            }
        }

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        /* loaded from: classes.dex */
        public static final class zzb extends zzek.zzb<zzan, zzb> implements zzfx {
            private zzb() {
                super(zzan.zzh);
            }

            /* synthetic */ zzb(zzt zztVar) {
                this();
            }
        }

        static {
            zzan zzanVar = new zzan();
            zzh = zzanVar;
            zzek.zza(zzan.class, zzanVar);
        }

        private zzan() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_common.zzek$zza, com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzan>] */
        /* JADX WARN: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzek
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_common.zzt.zza
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
                com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzan> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzan.zzi
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzr$zzan> r3 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzan.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzan> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzan.zzi     // Catch: all -> 0x002c
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_common.zzek$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzek$zza     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzan r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzan.zzh     // Catch: all -> 0x002c
                r2.<init>(r4)     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_vision_common.zzr.zzan.zzi = r2     // Catch: all -> 0x002c
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzan r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzan.zzh
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
                com.google.android.gms.internal.mlkit_vision_common.zzer r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzan.zza.zzb()
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzan r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzan.zzh
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_common.zzek.zza(r4, r3, r2)
                return r2
            L_0x005e:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzan$zzb r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzan$zzb
                r2.<init>(r3)
                return r2
            L_0x0064:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzan r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzan
                r2.<init>()
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.zzr.zzan.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
    /* loaded from: classes.dex */
    public static final class zzaq extends zzek<zzaq, zza> implements zzfx {
        private static final zzaq zzf;
        private static volatile zzgf<zzaq> zzg;
        private int zzc;
        private zzat zzd;
        private int zze;

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        /* loaded from: classes.dex */
        public static final class zza extends zzek.zzb<zzaq, zza> implements zzfx {
            private zza() {
                super(zzaq.zzf);
            }

            /* synthetic */ zza(zzt zztVar) {
                this();
            }
        }

        static {
            zzaq zzaqVar = new zzaq();
            zzf = zzaqVar;
            zzek.zza(zzaq.class, zzaqVar);
        }

        private zzaq() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzaq>, com.google.android.gms.internal.mlkit_vision_common.zzek$zza] */
        /* JADX WARN: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzek
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_common.zzt.zza
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
                com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzaq> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzaq.zzg
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzr$zzaq> r3 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzaq.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzaq> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzaq.zzg     // Catch: all -> 0x002c
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_common.zzek$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzek$zza     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzaq r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzaq.zzf     // Catch: all -> 0x002c
                r2.<init>(r4)     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_vision_common.zzr.zzaq.zzg = r2     // Catch: all -> 0x002c
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzaq r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzaq.zzf
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
                com.google.android.gms.internal.mlkit_vision_common.zzer r4 = com.google.android.gms.internal.mlkit_vision_common.zzac.zzb()
                r2[r3] = r4
                java.lang.String r3 = "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဌ\u0001"
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzaq r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzaq.zzf
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_common.zzek.zza(r4, r3, r2)
                return r2
            L_0x0054:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzaq$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzaq$zza
                r2.<init>(r3)
                return r2
            L_0x005a:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzaq r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzaq
                r2.<init>()
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.zzr.zzaq.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
    /* loaded from: classes.dex */
    public static final class zzas extends zzek<zzas, zza> implements zzfx {
        private static final zzet<Integer, zzac> zzf = new zzbk();
        private static final zzas zzi;
        private static volatile zzgf<zzas> zzj;
        private int zzc;
        private zzat zzd;
        private zzeq zze = zzek.zzk();
        private long zzg;
        private long zzh;

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        /* loaded from: classes.dex */
        public static final class zza extends zzek.zzb<zzas, zza> implements zzfx {
            private zza() {
                super(zzas.zzi);
            }

            /* synthetic */ zza(zzt zztVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [com.google.android.gms.internal.mlkit_vision_common.zzbk, com.google.android.gms.internal.mlkit_vision_common.zzet<java.lang.Integer, com.google.android.gms.internal.mlkit_vision_common.zzac>] */
        static {
            zzas zzasVar = new zzas();
            zzi = zzasVar;
            zzek.zza(zzas.class, zzasVar);
        }

        private zzas() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzas>, com.google.android.gms.internal.mlkit_vision_common.zzek$zza] */
        /* JADX WARN: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzek
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_common.zzt.zza
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
                com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzas> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzas.zzj
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzr$zzas> r3 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzas.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzas> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzas.zzj     // Catch: all -> 0x002c
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_common.zzek$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzek$zza     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzas r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzas.zzi     // Catch: all -> 0x002c
                r2.<init>(r4)     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_vision_common.zzr.zzas.zzj = r2     // Catch: all -> 0x002c
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzas r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzas.zzi
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
                com.google.android.gms.internal.mlkit_vision_common.zzer r4 = com.google.android.gms.internal.mlkit_vision_common.zzac.zzb()
                r2[r3] = r4
                r3 = 4
                java.lang.String r4 = "zzg"
                r2[r3] = r4
                r3 = 5
                java.lang.String r4 = "zzh"
                r2[r3] = r4
                java.lang.String r3 = "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001ဉ\u0000\u0002\u001e\u0003ဃ\u0001\u0004ဃ\u0002"
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzas r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzas.zzi
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_common.zzek.zza(r4, r3, r2)
                return r2
            L_0x005e:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzas$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzas$zza
                r2.<init>(r3)
                return r2
            L_0x0064:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzas r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzas
                r2.<init>()
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.zzr.zzas.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
    /* loaded from: classes.dex */
    public static final class zzav extends zzek<zzav, zza> implements zzfx {
        private static final zzav zzf;
        private static volatile zzgf<zzav> zzg;
        private int zzc;
        private zzaw zzd;
        private int zze;

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        /* loaded from: classes.dex */
        public static final class zza extends zzek.zzb<zzav, zza> implements zzfx {
            private zza() {
                super(zzav.zzf);
            }

            /* synthetic */ zza(zzt zztVar) {
                this();
            }
        }

        static {
            zzav zzavVar = new zzav();
            zzf = zzavVar;
            zzek.zza(zzav.class, zzavVar);
        }

        private zzav() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_common.zzek$zza, com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzav>] */
        /* JADX WARN: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzek
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_common.zzt.zza
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
                com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzav> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzav.zzg
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzr$zzav> r3 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzav.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzav> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzav.zzg     // Catch: all -> 0x002c
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_common.zzek$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzek$zza     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzav r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzav.zzf     // Catch: all -> 0x002c
                r2.<init>(r4)     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_vision_common.zzr.zzav.zzg = r2     // Catch: all -> 0x002c
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzav r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzav.zzf
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
                com.google.android.gms.internal.mlkit_vision_common.zzer r4 = com.google.android.gms.internal.mlkit_vision_common.zzac.zzb()
                r2[r3] = r4
                java.lang.String r3 = "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဌ\u0001"
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzav r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzav.zzf
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_common.zzek.zza(r4, r3, r2)
                return r2
            L_0x0054:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzav$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzav$zza
                r2.<init>(r3)
                return r2
            L_0x005a:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzav r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzav
                r2.<init>()
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.zzr.zzav.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
    /* loaded from: classes.dex */
    public static final class zzaw extends zzek<zzaw, zzb> implements zzfx {
        private static final zzaw zzj;
        private static volatile zzgf<zzaw> zzk;
        private int zzc;
        private int zzd;
        private boolean zze;
        private boolean zzf;
        private int zzg;
        private float zzh;
        private zzam zzi;

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        /* loaded from: classes.dex */
        public enum zza implements zzep {
            MODE_UNSPECIFIED(0),
            STREAM(1),
            SINGLE_IMAGE(2);
            
            private static final zzeo<zza> zzd = new zzbm();
            private final int zze;

            zza(int i) {
                this.zze = i;
            }

            public static zzer zzb() {
                return zzbl.zza;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "<" + zza.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zze + " name=" + name() + '>';
            }

            @Override // com.google.android.gms.internal.mlkit_vision_common.zzep
            public final int zza() {
                return this.zze;
            }
        }

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        /* loaded from: classes.dex */
        public static final class zzb extends zzek.zzb<zzaw, zzb> implements zzfx {
            private zzb() {
                super(zzaw.zzj);
            }

            /* synthetic */ zzb(zzt zztVar) {
                this();
            }
        }

        static {
            zzaw zzawVar = new zzaw();
            zzj = zzawVar;
            zzek.zza(zzaw.class, zzawVar);
        }

        private zzaw() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_common.zzek$zza, com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzaw>] */
        /* JADX WARN: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzek
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_common.zzt.zza
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
                com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzaw> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzaw.zzk
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzr$zzaw> r3 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzaw.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzaw> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzaw.zzk     // Catch: all -> 0x002c
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_common.zzek$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzek$zza     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzaw r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzaw.zzj     // Catch: all -> 0x002c
                r2.<init>(r4)     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_vision_common.zzr.zzaw.zzk = r2     // Catch: all -> 0x002c
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzaw r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzaw.zzj
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
                com.google.android.gms.internal.mlkit_vision_common.zzer r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzaw.zza.zzb()
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzaw r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzaw.zzj
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_common.zzek.zza(r4, r3, r2)
                return r2
            L_0x0069:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzaw$zzb r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzaw$zzb
                r2.<init>(r3)
                return r2
            L_0x006f:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzaw r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzaw
                r2.<init>()
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.zzr.zzaw.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
    /* loaded from: classes.dex */
    public static final class zzax extends zzek<zzax, zza> implements zzfx {
        private static final zzax zzh;
        private static volatile zzgf<zzax> zzi;
        private int zzc;
        private zzaf zzd;
        private zzae zze;
        private zzaw zzf;
        private zzes<zzan> zzg = zzek.zzl();

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        /* loaded from: classes.dex */
        public static final class zza extends zzek.zzb<zzax, zza> implements zzfx {
            private zza() {
                super(zzax.zzh);
            }

            /* synthetic */ zza(zzt zztVar) {
                this();
            }
        }

        static {
            zzax zzaxVar = new zzax();
            zzh = zzaxVar;
            zzek.zza(zzax.class, zzaxVar);
        }

        private zzax() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_common.zzek$zza, com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzax>] */
        /* JADX WARN: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzek
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_common.zzt.zza
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
                com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzax> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzax.zzi
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzr$zzax> r3 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzax.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzax> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzax.zzi     // Catch: all -> 0x002c
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_common.zzek$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzek$zza     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzax r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzax.zzh     // Catch: all -> 0x002c
                r2.<init>(r4)     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_vision_common.zzr.zzax.zzi = r2     // Catch: all -> 0x002c
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzax r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzax.zzh
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
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzr$zzan> r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzan.class
                r2[r3] = r4
                java.lang.String r3 = "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002\u0004\u001b"
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzax r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzax.zzh
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_common.zzek.zza(r4, r3, r2)
                return r2
            L_0x005c:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzax$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzax$zza
                r2.<init>(r3)
                return r2
            L_0x0062:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzax r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzax
                r2.<init>()
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.zzr.zzax.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
    /* loaded from: classes.dex */
    public static final class zzay extends zzek<zzay, zza> implements zzfx {
        private static final zzay zzh;
        private static volatile zzgf<zzay> zzi;
        private int zzc;
        private zzaw zzd;
        private int zze;
        private long zzf;
        private long zzg;

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        /* loaded from: classes.dex */
        public static final class zza extends zzek.zzb<zzay, zza> implements zzfx {
            private zza() {
                super(zzay.zzh);
            }

            /* synthetic */ zza(zzt zztVar) {
                this();
            }
        }

        static {
            zzay zzayVar = new zzay();
            zzh = zzayVar;
            zzek.zza(zzay.class, zzayVar);
        }

        private zzay() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_common.zzek$zza, com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzay>] */
        /* JADX WARN: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzek
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_common.zzt.zza
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
                com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzay> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzay.zzi
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzr$zzay> r3 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzay.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzay> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzay.zzi     // Catch: all -> 0x002c
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_common.zzek$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzek$zza     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzay r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzay.zzh     // Catch: all -> 0x002c
                r2.<init>(r4)     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_vision_common.zzr.zzay.zzi = r2     // Catch: all -> 0x002c
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzay r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzay.zzh
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
                com.google.android.gms.internal.mlkit_vision_common.zzer r4 = com.google.android.gms.internal.mlkit_vision_common.zzac.zzb()
                r2[r3] = r4
                r3 = 4
                java.lang.String r4 = "zzf"
                r2[r3] = r4
                r3 = 5
                java.lang.String r4 = "zzg"
                r2[r3] = r4
                java.lang.String r3 = "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဌ\u0001\u0003ဃ\u0002\u0004ဃ\u0003"
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzay r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzay.zzh
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_common.zzek.zza(r4, r3, r2)
                return r2
            L_0x005e:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzay$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzay$zza
                r2.<init>(r3)
                return r2
            L_0x0064:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzay r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzay
                r2.<init>()
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.zzr.zzay.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
    /* loaded from: classes.dex */
    public static final class zzbe extends zzek<zzbe, zzb> implements zzfx {
        private static final zzbe zzl;
        private static volatile zzgf<zzbe> zzm;
        private int zzc;
        private zzaf zzd;
        private zzbh zze;
        private int zzf;
        private int zzg;
        private int zzh;
        private int zzi;
        private int zzj;
        private int zzk;

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        /* loaded from: classes.dex */
        public enum zza implements zzep {
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
            
            private static final zzeo<zza> zzai = new zzbu();
            private final int zzaj;

            zza(int i) {
                this.zzaj = i;
            }

            public static zzer zzb() {
                return zzbt.zza;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "<" + zza.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzaj + " name=" + name() + '>';
            }

            @Override // com.google.android.gms.internal.mlkit_vision_common.zzep
            public final int zza() {
                return this.zzaj;
            }
        }

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        /* loaded from: classes.dex */
        public static final class zzb extends zzek.zzb<zzbe, zzb> implements zzfx {
            private zzb() {
                super(zzbe.zzl);
            }

            /* synthetic */ zzb(zzt zztVar) {
                this();
            }
        }

        static {
            zzbe zzbeVar = new zzbe();
            zzl = zzbeVar;
            zzek.zza(zzbe.class, zzbeVar);
        }

        private zzbe() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_common.zzek$zza, com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzbe>] */
        /* JADX WARN: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzek
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_common.zzt.zza
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
                com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzbe> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzbe.zzm
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzr$zzbe> r3 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzbe.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzbe> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzbe.zzm     // Catch: all -> 0x002c
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_common.zzek$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzek$zza     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzbe r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzbe.zzl     // Catch: all -> 0x002c
                r2.<init>(r4)     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_vision_common.zzr.zzbe.zzm = r2     // Catch: all -> 0x002c
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzbe r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzbe.zzl
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
                com.google.android.gms.internal.mlkit_vision_common.zzer r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzbe.zza.zzb()
                r2[r3] = r4
                r3 = 9
                java.lang.String r4 = "zzk"
                r2[r3] = r4
                java.lang.String r3 = "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003င\u0002\u0004င\u0003\u0005င\u0004\u0006င\u0005\u0007ဌ\u0006\bင\u0007"
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzbe r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzbe.zzl
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_common.zzek.zza(r4, r3, r2)
                return r2
            L_0x0075:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzbe$zzb r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzbe$zzb
                r2.<init>(r3)
                return r2
            L_0x007b:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzbe r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzbe
                r2.<init>()
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.zzr.zzbe.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
    /* loaded from: classes.dex */
    public static final class zzj extends zzek<zzj, zza> implements zzfx {
        private static final zzj zze;
        private static volatile zzgf<zzj> zzf;
        private int zzc;
        private int zzd;

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        /* loaded from: classes.dex */
        public static final class zza extends zzek.zzb<zzj, zza> implements zzfx {
            private zza() {
                super(zzj.zze);
            }

            /* synthetic */ zza(zzt zztVar) {
                this();
            }
        }

        static {
            zzj zzjVar = new zzj();
            zze = zzjVar;
            zzek.zza(zzj.class, zzjVar);
        }

        private zzj() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_common.zzek$zza, com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzj>] */
        /* JADX WARN: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzek
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_common.zzt.zza
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
                com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzj> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzj.zzf
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzr$zzj> r3 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzj.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzj> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzj.zzf     // Catch: all -> 0x002c
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_common.zzek$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzek$zza     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzj r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzj.zze     // Catch: all -> 0x002c
                r2.<init>(r4)     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_vision_common.zzr.zzj.zzf = r2     // Catch: all -> 0x002c
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzj r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzj.zze
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
                com.google.android.gms.internal.mlkit_vision_common.zzer r4 = com.google.android.gms.internal.mlkit_vision_common.zzac.zzb()
                r2[r3] = r4
                java.lang.String r3 = "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဌ\u0000"
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzj r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzj.zze
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_common.zzek.zza(r4, r3, r2)
                return r2
            L_0x004f:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzj$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzj$zza
                r2.<init>(r3)
                return r2
            L_0x0055:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzj r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzj
                r2.<init>()
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.zzr.zzj.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
    /* loaded from: classes.dex */
    public static final class zzl extends zzek<zzl, zza> implements zzfx {
        private static final zzet<Integer, zzac> zzg = new zzw();
        private static final zzl zzi;
        private static volatile zzgf<zzl> zzj;
        private int zzc;
        private zzam zzd;
        private zzam zze;
        private zzeq zzf = zzek.zzk();
        private long zzh;

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        /* loaded from: classes.dex */
        public static final class zza extends zzek.zzb<zzl, zza> implements zzfx {
            private zza() {
                super(zzl.zzi);
            }

            /* synthetic */ zza(zzt zztVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [com.google.android.gms.internal.mlkit_vision_common.zzw, com.google.android.gms.internal.mlkit_vision_common.zzet<java.lang.Integer, com.google.android.gms.internal.mlkit_vision_common.zzac>] */
        static {
            zzl zzlVar = new zzl();
            zzi = zzlVar;
            zzek.zza(zzl.class, zzlVar);
        }

        private zzl() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_common.zzek$zza, com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzl>] */
        /* JADX WARN: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzek
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_common.zzt.zza
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
                com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzl> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzl.zzj
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzr$zzl> r3 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzl.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzl> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzl.zzj     // Catch: all -> 0x002c
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_common.zzek$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzek$zza     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzl r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzl.zzi     // Catch: all -> 0x002c
                r2.<init>(r4)     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_vision_common.zzr.zzl.zzj = r2     // Catch: all -> 0x002c
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzl r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzl.zzi
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
                com.google.android.gms.internal.mlkit_vision_common.zzer r4 = com.google.android.gms.internal.mlkit_vision_common.zzac.zzb()
                r2[r3] = r4
                r3 = 5
                java.lang.String r4 = "zzh"
                r2[r3] = r4
                java.lang.String r3 = "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003\u001e\u0004ဃ\u0002"
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzl r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzl.zzi
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_common.zzek.zza(r4, r3, r2)
                return r2
            L_0x005e:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzl$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzl$zza
                r2.<init>(r3)
                return r2
            L_0x0064:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzl r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzl
                r2.<init>()
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.zzr.zzl.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
    /* loaded from: classes.dex */
    public static final class zzn extends zzek<zzn, zza> implements zzfx {
        private static final zzn zzf;
        private static volatile zzgf<zzn> zzg;
        private int zzc;
        private int zzd;
        private int zze;

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        /* loaded from: classes.dex */
        public static final class zza extends zzek.zzb<zzn, zza> implements zzfx {
            private zza() {
                super(zzn.zzf);
            }

            /* synthetic */ zza(zzt zztVar) {
                this();
            }
        }

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        /* loaded from: classes.dex */
        public enum zzb implements zzep {
            UNKNOWN_MODEL_TYPE(0),
            STABLE_MODEL(1),
            LATEST_MODEL(2);
            
            private static final zzeo<zzb> zzd = new zzx();
            private final int zze;

            zzb(int i) {
                this.zze = i;
            }

            public static zzer zzb() {
                return zzy.zza;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "<" + zzb.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zze + " name=" + name() + '>';
            }

            @Override // com.google.android.gms.internal.mlkit_vision_common.zzep
            public final int zza() {
                return this.zze;
            }
        }

        static {
            zzn zznVar = new zzn();
            zzf = zznVar;
            zzek.zza(zzn.class, zznVar);
        }

        private zzn() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_common.zzek$zza, com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzn>] */
        /* JADX WARN: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzek
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_common.zzt.zza
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
                com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzn> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzn.zzg
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzr$zzn> r3 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzn.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzn> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzn.zzg     // Catch: all -> 0x002c
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_common.zzek$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzek$zza     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzn r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzn.zzf     // Catch: all -> 0x002c
                r2.<init>(r4)     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_vision_common.zzr.zzn.zzg = r2     // Catch: all -> 0x002c
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzn r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzn.zzf
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
                com.google.android.gms.internal.mlkit_vision_common.zzer r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzn.zzb.zzb()
                r2[r3] = r4
                java.lang.String r3 = "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001င\u0000\u0002ဌ\u0001"
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzn r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzn.zzf
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_common.zzek.zza(r4, r3, r2)
                return r2
            L_0x0054:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzn$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzn$zza
                r2.<init>(r3)
                return r2
            L_0x005a:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzn r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzn
                r2.<init>()
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.zzr.zzn.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
    /* loaded from: classes.dex */
    public static final class zzx extends zzek<zzx, zza> implements zzfx {
        private static final zzx zzf;
        private static volatile zzgf<zzx> zzg;
        private int zzc;
        private zzam zzd;
        private int zze;

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        /* loaded from: classes.dex */
        public static final class zza extends zzek.zzb<zzx, zza> implements zzfx {
            private zza() {
                super(zzx.zzf);
            }

            /* synthetic */ zza(zzt zztVar) {
                this();
            }
        }

        static {
            zzx zzxVar = new zzx();
            zzf = zzxVar;
            zzek.zza(zzx.class, zzxVar);
        }

        private zzx() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzx>, com.google.android.gms.internal.mlkit_vision_common.zzek$zza] */
        /* JADX WARN: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzek
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_common.zzt.zza
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
                com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzx> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzx.zzg
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzr$zzx> r3 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzx.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzx> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzx.zzg     // Catch: all -> 0x002c
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_common.zzek$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzek$zza     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzx r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzx.zzf     // Catch: all -> 0x002c
                r2.<init>(r4)     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_vision_common.zzr.zzx.zzg = r2     // Catch: all -> 0x002c
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzx r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzx.zzf
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
                com.google.android.gms.internal.mlkit_vision_common.zzer r4 = com.google.android.gms.internal.mlkit_vision_common.zzac.zzb()
                r2[r3] = r4
                java.lang.String r3 = "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဌ\u0001"
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzx r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzx.zzf
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_common.zzek.zza(r4, r3, r2)
                return r2
            L_0x0054:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzx$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzx$zza
                r2.<init>(r3)
                return r2
            L_0x005a:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzx r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzx
                r2.<init>()
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.zzr.zzx.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
    /* loaded from: classes.dex */
    public static final class zzz extends zzek<zzz, zza> implements zzfx {
        private static final zzet<Integer, zzac> zzg = new zzab();
        private static final zzz zzj;
        private static volatile zzgf<zzz> zzk;
        private int zzc;
        private zzam zzd;
        private zzam zze;
        private zzeq zzf = zzek.zzk();
        private long zzh;
        private boolean zzi;

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        /* loaded from: classes.dex */
        public static final class zza extends zzek.zzb<zzz, zza> implements zzfx {
            private zza() {
                super(zzz.zzj);
            }

            /* synthetic */ zza(zzt zztVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [com.google.android.gms.internal.mlkit_vision_common.zzab, com.google.android.gms.internal.mlkit_vision_common.zzet<java.lang.Integer, com.google.android.gms.internal.mlkit_vision_common.zzac>] */
        static {
            zzz zzzVar = new zzz();
            zzj = zzzVar;
            zzek.zza(zzz.class, zzzVar);
        }

        private zzz() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_common.zzek$zza, com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzz>] */
        /* JADX WARN: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzek
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_common.zzt.zza
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
                com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzz> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzz.zzk
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzr$zzz> r3 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzz.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzz> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzz.zzk     // Catch: all -> 0x002c
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_common.zzek$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzek$zza     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzz r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzz.zzj     // Catch: all -> 0x002c
                r2.<init>(r4)     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_vision_common.zzr.zzz.zzk = r2     // Catch: all -> 0x002c
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzz r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzz.zzj
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
                com.google.android.gms.internal.mlkit_vision_common.zzer r4 = com.google.android.gms.internal.mlkit_vision_common.zzac.zzb()
                r2[r3] = r4
                r3 = 5
                java.lang.String r4 = "zzh"
                r2[r3] = r4
                r3 = 6
                java.lang.String r4 = "zzi"
                r2[r3] = r4
                java.lang.String r3 = "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003\u001e\u0004ဃ\u0002\u0005ဇ\u0003"
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzz r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzz.zzj
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_common.zzek.zza(r4, r3, r2)
                return r2
            L_0x0063:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzz$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzz$zza
                r2.<init>(r3)
                return r2
            L_0x0069:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzz r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzz
                r2.<init>()
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.zzr.zzz.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
    /* loaded from: classes.dex */
    public static final class zzak extends zzek<zzak, zza> implements zzfx {
        private static final zzak zzj;
        private static volatile zzgf<zzak> zzk;
        private int zzc;
        private zzam zzd;
        private long zze;
        private int zzf;
        private long zzg;
        private int zzh;
        private long zzi;

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        /* loaded from: classes.dex */
        public static final class zza extends zzek.zzb<zzak, zza> implements zzfx {
            private zza() {
                super(zzak.zzj);
            }

            /* synthetic */ zza(zzt zztVar) {
                this();
            }
        }

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        /* loaded from: classes.dex */
        public enum zzb implements zzep {
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
            
            private static final zzeo<zzb> zzm = new zzaw();
            private final int zzn;

            zzb(int i) {
                this.zzn = i;
            }

            public static zzer zzb() {
                return zzax.zza;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "<" + zzb.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzn + " name=" + name() + '>';
            }

            @Override // com.google.android.gms.internal.mlkit_vision_common.zzep
            public final int zza() {
                return this.zzn;
            }
        }

        static {
            zzak zzakVar = new zzak();
            zzj = zzakVar;
            zzek.zza(zzak.class, zzakVar);
        }

        private zzak() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_common.zzek$zza, com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzak>] */
        /* JADX WARN: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzek
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_common.zzt.zza
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
                com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzak> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzak.zzk
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzr$zzak> r3 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzak.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzak> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzak.zzk     // Catch: all -> 0x002c
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_common.zzek$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzek$zza     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzak r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzak.zzj     // Catch: all -> 0x002c
                r2.<init>(r4)     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_vision_common.zzr.zzak.zzk = r2     // Catch: all -> 0x002c
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzak r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzak.zzj
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
                com.google.android.gms.internal.mlkit_vision_common.zzer r4 = com.google.android.gms.internal.mlkit_vision_common.zzac.zzb()
                r2[r3] = r4
                r3 = 5
                java.lang.String r4 = "zzg"
                r2[r3] = r4
                r3 = 6
                java.lang.String r4 = "zzh"
                r2[r3] = r4
                r3 = 7
                com.google.android.gms.internal.mlkit_vision_common.zzer r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzak.zzb.zzb()
                r2[r3] = r4
                r3 = 8
                java.lang.String r4 = "zzi"
                r2[r3] = r4
                java.lang.String r3 = "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဃ\u0001\u0003ဌ\u0002\u0004ဃ\u0003\u0005ဌ\u0004\u0006ဂ\u0005"
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzak r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzak.zzj
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_common.zzek.zza(r4, r3, r2)
                return r2
            L_0x0071:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzak$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzak$zza
                r2.<init>(r3)
                return r2
            L_0x0077:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzak r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzak
                r2.<init>()
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.zzr.zzak.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
    /* loaded from: classes.dex */
    public static final class zzal extends zzek<zzal, zzb> implements zzfx {
        private static final zzal zzl;
        private static volatile zzgf<zzal> zzm;
        private int zzc;
        private int zzf;
        private int zzi;
        private long zzj;
        private boolean zzk;
        private String zzd = "";
        private String zze = "";
        private String zzg = "";
        private String zzh = "";

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        /* loaded from: classes.dex */
        public enum zza implements zzep {
            TYPE_UNKNOWN(0),
            CUSTOM(1),
            AUTOML_IMAGE_LABELING(2),
            BASE_TRANSLATE(3),
            CUSTOM_OBJECT_DETECTION(4),
            CUSTOM_IMAGE_LABELING(5);
            
            private static final zzeo<zza> zzg = new zzaz();
            private final int zzh;

            zza(int i) {
                this.zzh = i;
            }

            public static zzer zzb() {
                return zzay.zza;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "<" + zza.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzh + " name=" + name() + '>';
            }

            @Override // com.google.android.gms.internal.mlkit_vision_common.zzep
            public final int zza() {
                return this.zzh;
            }
        }

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        /* loaded from: classes.dex */
        public static final class zzb extends zzek.zzb<zzal, zzb> implements zzfx {
            private zzb() {
                super(zzal.zzl);
            }

            /* synthetic */ zzb(zzt zztVar) {
                this();
            }
        }

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        /* loaded from: classes.dex */
        public enum zzc implements zzep {
            SOURCE_UNKNOWN(0),
            APP_ASSET(1),
            LOCAL(2),
            CLOUD(3),
            SDK_BUILT_IN(4);
            
            private static final zzeo<zzc> zzf = new zzba();
            private final int zzg;

            zzc(int i) {
                this.zzg = i;
            }

            public static zzer zzb() {
                return zzbb.zza;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "<" + zzc.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzg + " name=" + name() + '>';
            }

            @Override // com.google.android.gms.internal.mlkit_vision_common.zzep
            public final int zza() {
                return this.zzg;
            }
        }

        static {
            zzal zzalVar = new zzal();
            zzl = zzalVar;
            zzek.zza(zzal.class, zzalVar);
        }

        private zzal() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_common.zzek$zza, com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzal>] */
        /* JADX WARN: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzek
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_common.zzt.zza
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
                com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzal> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzal.zzm
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzr$zzal> r3 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzal.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzal> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzal.zzm     // Catch: all -> 0x002c
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_common.zzek$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzek$zza     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzal r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzal.zzl     // Catch: all -> 0x002c
                r2.<init>(r4)     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_vision_common.zzr.zzal.zzm = r2     // Catch: all -> 0x002c
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzal r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzal.zzl
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
                com.google.android.gms.internal.mlkit_vision_common.zzer r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzal.zzc.zzb()
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
                com.google.android.gms.internal.mlkit_vision_common.zzer r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzal.zza.zzb()
                r2[r3] = r4
                r3 = 9
                java.lang.String r4 = "zzj"
                r2[r3] = r4
                r3 = 10
                java.lang.String r4 = "zzk"
                r2[r3] = r4
                java.lang.String r3 = "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဌ\u0002\u0004ဈ\u0003\u0005ဈ\u0004\u0006ဌ\u0005\u0007ဃ\u0006\bဇ\u0007"
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzal r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzal.zzl
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_common.zzek.zza(r4, r3, r2)
                return r2
            L_0x007d:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzal$zzb r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzal$zzb
                r2.<init>(r3)
                return r2
            L_0x0083:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzal r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzal
                r2.<init>()
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.zzr.zzal.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
    /* loaded from: classes.dex */
    public static final class zzao extends zzek<zzao, zzc> implements zzfx {
        private static final zzet<Integer, zza> zzg = new zzbe();
        private static final zzet<Integer, zzb> zzi = new zzbf();
        private static final zzao zzk;
        private static volatile zzgf<zzao> zzl;
        private int zzc;
        private zzaf zzd;
        private zzcb.zza zze;
        private zzeq zzf = zzek.zzk();
        private zzeq zzh = zzek.zzk();
        private zzae zzj;

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        /* loaded from: classes.dex */
        public enum zza implements zzep {
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
            
            private static final zzeo<zza> zzo = new zzbh();
            private final int zzp;

            zza(int i) {
                this.zzp = i;
            }

            public static zzer zzb() {
                return zzbg.zza;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "<" + zza.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzp + " name=" + name() + '>';
            }

            @Override // com.google.android.gms.internal.mlkit_vision_common.zzep
            public final int zza() {
                return this.zzp;
            }
        }

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        /* loaded from: classes.dex */
        public enum zzb implements zzep {
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
            
            private static final zzeo<zzb> zzn = new zzbi();
            private final int zzo;

            zzb(int i) {
                this.zzo = i;
            }

            public static zzer zzb() {
                return zzbj.zza;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "<" + zzb.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzo + " name=" + name() + '>';
            }

            @Override // com.google.android.gms.internal.mlkit_vision_common.zzep
            public final int zza() {
                return this.zzo;
            }
        }

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        /* loaded from: classes.dex */
        public static final class zzc extends zzek.zzb<zzao, zzc> implements zzfx {
            private zzc() {
                super(zzao.zzk);
            }

            /* synthetic */ zzc(zzt zztVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [com.google.android.gms.internal.mlkit_vision_common.zzbe, com.google.android.gms.internal.mlkit_vision_common.zzet<java.lang.Integer, com.google.android.gms.internal.mlkit_vision_common.zzr$zzao$zza>] */
        /* JADX WARN: Type inference failed for: r0v1, types: [com.google.android.gms.internal.mlkit_vision_common.zzbf, com.google.android.gms.internal.mlkit_vision_common.zzet<java.lang.Integer, com.google.android.gms.internal.mlkit_vision_common.zzr$zzao$zzb>] */
        static {
            zzao zzaoVar = new zzao();
            zzk = zzaoVar;
            zzek.zza(zzao.class, zzaoVar);
        }

        private zzao() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_common.zzek$zza, com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzao>] */
        /* JADX WARN: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzek
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_common.zzt.zza
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
                com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzao> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzao.zzl
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzr$zzao> r3 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzao.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzao> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzao.zzl     // Catch: all -> 0x002c
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_common.zzek$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzek$zza     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzao r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzao.zzk     // Catch: all -> 0x002c
                r2.<init>(r4)     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_vision_common.zzr.zzao.zzl = r2     // Catch: all -> 0x002c
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzao r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzao.zzk
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
                com.google.android.gms.internal.mlkit_vision_common.zzer r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzao.zza.zzb()
                r2[r3] = r4
                r3 = 5
                java.lang.String r4 = "zzh"
                r2[r3] = r4
                r3 = 6
                com.google.android.gms.internal.mlkit_vision_common.zzer r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzao.zzb.zzb()
                r2[r3] = r4
                r3 = 7
                java.lang.String r4 = "zzj"
                r2[r3] = r4
                java.lang.String r3 = "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0002\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003\u001e\u0004\u001e\u0005ဉ\u0002"
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzao r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzao.zzk
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_common.zzek.zza(r4, r3, r2)
                return r2
            L_0x006b:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzao$zzc r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzao$zzc
                r2.<init>(r3)
                return r2
            L_0x0071:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzao r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzao
                r2.<init>()
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.zzr.zzao.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
    /* loaded from: classes.dex */
    public static final class zzba extends zzek<zzba, zza> implements zzfx {
        private static final zzba zzf;
        private static volatile zzgf<zzba> zzg;
        private int zzc;
        private int zzd;
        private int zze;

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        /* loaded from: classes.dex */
        public static final class zza extends zzek.zzb<zzba, zza> implements zzfx {
            private zza() {
                super(zzba.zzf);
            }

            /* synthetic */ zza(zzt zztVar) {
                this();
            }
        }

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        /* loaded from: classes.dex */
        public enum zzb implements zzep {
            INVALID_MODE(0),
            STREAM(1),
            SINGLE_IMAGE(2);
            
            private static final zzeo<zzb> zzd = new zzbn();
            private final int zze;

            zzb(int i) {
                this.zze = i;
            }

            public static zzer zzb() {
                return zzbo.zza;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "<" + zzb.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zze + " name=" + name() + '>';
            }

            @Override // com.google.android.gms.internal.mlkit_vision_common.zzep
            public final int zza() {
                return this.zze;
            }
        }

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        /* loaded from: classes.dex */
        public enum zzc implements zzep {
            UNKNOWN_PERFORMANCE(0),
            FAST(1),
            ACCURATE(2);
            
            private static final zzeo<zzc> zzd = new zzbq();
            private final int zze;

            zzc(int i) {
                this.zze = i;
            }

            public static zzer zzb() {
                return zzbp.zza;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "<" + zzc.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zze + " name=" + name() + '>';
            }

            @Override // com.google.android.gms.internal.mlkit_vision_common.zzep
            public final int zza() {
                return this.zze;
            }
        }

        static {
            zzba zzbaVar = new zzba();
            zzf = zzbaVar;
            zzek.zza(zzba.class, zzbaVar);
        }

        private zzba() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzba>, com.google.android.gms.internal.mlkit_vision_common.zzek$zza] */
        /* JADX WARN: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzek
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_common.zzt.zza
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
                com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzba> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzba.zzg
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzr$zzba> r3 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzba.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzba> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzba.zzg     // Catch: all -> 0x002c
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_common.zzek$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzek$zza     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzba r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzba.zzf     // Catch: all -> 0x002c
                r2.<init>(r4)     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_vision_common.zzr.zzba.zzg = r2     // Catch: all -> 0x002c
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzba r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzba.zzf
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
                com.google.android.gms.internal.mlkit_vision_common.zzer r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzba.zzb.zzb()
                r2[r3] = r4
                r3 = 3
                java.lang.String r4 = "zze"
                r2[r3] = r4
                r3 = 4
                com.google.android.gms.internal.mlkit_vision_common.zzer r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzba.zzc.zzb()
                r2[r3] = r4
                java.lang.String r3 = "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဌ\u0001"
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzba r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzba.zzf
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_common.zzek.zza(r4, r3, r2)
                return r2
            L_0x005b:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzba$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzba$zza
                r2.<init>(r3)
                return r2
            L_0x0061:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzba r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzba
                r2.<init>()
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.zzr.zzba.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
    /* loaded from: classes.dex */
    public static final class zzbf extends zzek<zzbf, zzb> implements zzfx {
        private static final zzet<Integer, zza> zzf = new zzbv();
        private static final zzet<Integer, zza> zzh = new zzbx();
        private static final zzet<Integer, zza> zzj = new zzbw();
        private static final zzbf zzl;
        private static volatile zzgf<zzbf> zzm;
        private int zzc;
        private long zzd;
        private zzeq zze = zzek.zzk();
        private zzeq zzg = zzek.zzk();
        private zzeq zzi = zzek.zzk();
        private int zzk;

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        /* loaded from: classes.dex */
        public enum zza implements zzep {
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
            
            private static final zzeo<zza> zzm = new zzbz();
            private final int zzn;

            zza(int i) {
                this.zzn = i;
            }

            public static zzer zzb() {
                return zzby.zza;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "<" + zza.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzn + " name=" + name() + '>';
            }

            @Override // com.google.android.gms.internal.mlkit_vision_common.zzep
            public final int zza() {
                return this.zzn;
            }
        }

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        /* loaded from: classes.dex */
        public static final class zzb extends zzek.zzb<zzbf, zzb> implements zzfx {
            private zzb() {
                super(zzbf.zzl);
            }

            /* synthetic */ zzb(zzt zztVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [com.google.android.gms.internal.mlkit_vision_common.zzet<java.lang.Integer, com.google.android.gms.internal.mlkit_vision_common.zzr$zzbf$zza>, com.google.android.gms.internal.mlkit_vision_common.zzbv] */
        /* JADX WARN: Type inference failed for: r0v1, types: [com.google.android.gms.internal.mlkit_vision_common.zzet<java.lang.Integer, com.google.android.gms.internal.mlkit_vision_common.zzr$zzbf$zza>, com.google.android.gms.internal.mlkit_vision_common.zzbx] */
        /* JADX WARN: Type inference failed for: r0v2, types: [com.google.android.gms.internal.mlkit_vision_common.zzet<java.lang.Integer, com.google.android.gms.internal.mlkit_vision_common.zzr$zzbf$zza>, com.google.android.gms.internal.mlkit_vision_common.zzbw] */
        static {
            zzbf zzbfVar = new zzbf();
            zzl = zzbfVar;
            zzek.zza(zzbf.class, zzbfVar);
        }

        private zzbf() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_common.zzek$zza, com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzbf>] */
        /* JADX WARN: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzek
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_common.zzt.zza
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
                com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzbf> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzbf.zzm
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzr$zzbf> r3 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzbf.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzbf> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzbf.zzm     // Catch: all -> 0x002c
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_common.zzek$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzek$zza     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzbf r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzbf.zzl     // Catch: all -> 0x002c
                r2.<init>(r4)     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_vision_common.zzr.zzbf.zzm = r2     // Catch: all -> 0x002c
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzbf r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzbf.zzl
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
                com.google.android.gms.internal.mlkit_vision_common.zzer r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzbf.zza.zzb()
                r2[r3] = r4
                r3 = 4
                java.lang.String r4 = "zzg"
                r2[r3] = r4
                r3 = 5
                com.google.android.gms.internal.mlkit_vision_common.zzer r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzbf.zza.zzb()
                r2[r3] = r4
                r3 = 6
                java.lang.String r4 = "zzi"
                r2[r3] = r4
                r3 = 7
                com.google.android.gms.internal.mlkit_vision_common.zzer r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzbf.zza.zzb()
                r2[r3] = r4
                r3 = 8
                java.lang.String r4 = "zzk"
                r2[r3] = r4
                java.lang.String r3 = "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0003\u0000\u0001ဃ\u0000\u0002\u001e\u0003\u001e\u0004\u001e\u0005င\u0001"
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzbf r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzbf.zzl
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_common.zzek.zza(r4, r3, r2)
                return r2
            L_0x0073:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzbf$zzb r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzbf$zzb
                r2.<init>(r3)
                return r2
            L_0x0079:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzbf r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzbf
                r2.<init>()
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.zzr.zzbf.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
    /* loaded from: classes.dex */
    public static final class zzac extends zzek<zzac, zzb> implements zzfx {
        private static final zzac zzj;
        private static volatile zzgf<zzac> zzk;
        private int zzc;
        private int zzd;
        private int zze;
        private int zzf;
        private int zzg;
        private boolean zzh;
        private float zzi;

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        /* loaded from: classes.dex */
        public enum zza implements zzep {
            UNKNOWN_CLASSIFICATIONS(0),
            NO_CLASSIFICATIONS(1),
            ALL_CLASSIFICATIONS(2);
            
            private static final zzeo<zza> zzd = new zzaj();
            private final int zze;

            zza(int i) {
                this.zze = i;
            }

            public static zzer zzb() {
                return zzai.zza;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "<" + zza.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zze + " name=" + name() + '>';
            }

            @Override // com.google.android.gms.internal.mlkit_vision_common.zzep
            public final int zza() {
                return this.zze;
            }
        }

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        /* loaded from: classes.dex */
        public static final class zzb extends zzek.zzb<zzac, zzb> implements zzfx {
            private zzb() {
                super(zzac.zzj);
            }

            /* synthetic */ zzb(zzt zztVar) {
                this();
            }
        }

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        /* loaded from: classes.dex */
        public enum zzc implements zzep {
            UNKNOWN_CONTOURS(0),
            NO_CONTOURS(1),
            ALL_CONTOURS(2);
            
            private static final zzeo<zzc> zzd = new zzak();
            private final int zze;

            zzc(int i) {
                this.zze = i;
            }

            public static zzer zzb() {
                return zzal.zza;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "<" + zzc.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zze + " name=" + name() + '>';
            }

            @Override // com.google.android.gms.internal.mlkit_vision_common.zzep
            public final int zza() {
                return this.zze;
            }
        }

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        /* loaded from: classes.dex */
        public enum zzd implements zzep {
            UNKNOWN_LANDMARKS(0),
            NO_LANDMARKS(1),
            ALL_LANDMARKS(2);
            
            private static final zzeo<zzd> zzd = new zzan();
            private final int zze;

            zzd(int i) {
                this.zze = i;
            }

            public static zzer zzb() {
                return zzam.zza;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "<" + zzd.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zze + " name=" + name() + '>';
            }

            @Override // com.google.android.gms.internal.mlkit_vision_common.zzep
            public final int zza() {
                return this.zze;
            }
        }

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        /* loaded from: classes.dex */
        public enum zze implements zzep {
            UNKNOWN_PERFORMANCE(0),
            FAST(1),
            ACCURATE(2);
            
            private static final zzeo<zze> zzd = new zzao();
            private final int zze;

            zze(int i) {
                this.zze = i;
            }

            public static zzer zzb() {
                return zzap.zza;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "<" + zze.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zze + " name=" + name() + '>';
            }

            @Override // com.google.android.gms.internal.mlkit_vision_common.zzep
            public final int zza() {
                return this.zze;
            }
        }

        static {
            zzac zzacVar = new zzac();
            zzj = zzacVar;
            zzek.zza(zzac.class, zzacVar);
        }

        private zzac() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzac>, com.google.android.gms.internal.mlkit_vision_common.zzek$zza] */
        /* JADX WARN: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzek
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_common.zzt.zza
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
                com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzac> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzac.zzk
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzr$zzac> r3 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzac.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzr$zzac> r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzac.zzk     // Catch: all -> 0x002c
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_common.zzek$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzek$zza     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzac r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzac.zzj     // Catch: all -> 0x002c
                r2.<init>(r4)     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_vision_common.zzr.zzac.zzk = r2     // Catch: all -> 0x002c
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
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzac r2 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzac.zzj
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
                com.google.android.gms.internal.mlkit_vision_common.zzer r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzac.zzd.zzb()
                r2[r3] = r4
                r3 = 3
                java.lang.String r4 = "zze"
                r2[r3] = r4
                r3 = 4
                com.google.android.gms.internal.mlkit_vision_common.zzer r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzac.zza.zzb()
                r2[r3] = r4
                r3 = 5
                java.lang.String r4 = "zzf"
                r2[r3] = r4
                r3 = 6
                com.google.android.gms.internal.mlkit_vision_common.zzer r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzac.zze.zzb()
                r2[r3] = r4
                r3 = 7
                java.lang.String r4 = "zzg"
                r2[r3] = r4
                r3 = 8
                com.google.android.gms.internal.mlkit_vision_common.zzer r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzac.zzc.zzb()
                r2[r3] = r4
                r3 = 9
                java.lang.String r4 = "zzh"
                r2[r3] = r4
                r3 = 10
                java.lang.String r4 = "zzi"
                r2[r3] = r4
                java.lang.String r3 = "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဌ\u0001\u0003ဌ\u0002\u0004ဌ\u0003\u0005ဇ\u0004\u0006ခ\u0005"
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzac r4 = com.google.android.gms.internal.mlkit_vision_common.zzr.zzac.zzj
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_common.zzek.zza(r4, r3, r2)
                return r2
            L_0x0081:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzac$zzb r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzac$zzb
                r2.<init>(r3)
                return r2
            L_0x0087:
                com.google.android.gms.internal.mlkit_vision_common.zzr$zzac r2 = new com.google.android.gms.internal.mlkit_vision_common.zzr$zzac
                r2.<init>()
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.zzr.zzac.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }
}
