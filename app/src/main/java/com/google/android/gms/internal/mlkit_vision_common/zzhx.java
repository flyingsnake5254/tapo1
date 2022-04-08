package com.google.android.gms.internal.mlkit_vision_common;

import com.google.android.gms.internal.mlkit_vision_common.zzek;

/* compiled from: com.google.mlkit:vision-common@@16.0.0 */
/* loaded from: classes.dex */
public final class zzhx {

    /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
    /* loaded from: classes.dex */
    public static final class zzc extends zzek<zzc, zzb> implements zzfx {
        private static final zzc zzm;
        private static volatile zzgf<zzc> zzn;
        private int zzc;
        private int zzd;
        private int zze;
        private zza zzh;
        private zzd zzi;
        private int zzj;
        private int zzl;
        private String zzf = "";
        private String zzg = "";
        private zzes<zzg> zzk = zzek.zzl();

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        /* loaded from: classes.dex */
        public enum zza implements zzep {
            UNKNOWN_ACTION(0),
            INITIALIZATION(1),
            COMPILATION(2),
            EXECUTION(3),
            TEARDOWN(4);
            
            private static final zzeo<zza> zzf = new zzia();
            private final int zzg;

            zza(int i) {
                this.zzg = i;
            }

            public static zzer zzb() {
                return zzib.zza;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "<" + zza.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzg + " name=" + name() + '>';
            }

            @Override // com.google.android.gms.internal.mlkit_vision_common.zzep
            public final int zza() {
                return this.zzg;
            }
        }

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        /* loaded from: classes.dex */
        public static final class zzb extends zzek.zzb<zzc, zzb> implements zzfx {
            private zzb() {
                super(zzc.zzm);
            }

            /* synthetic */ zzb(zzhw zzhwVar) {
                this();
            }
        }

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        /* loaded from: classes.dex */
        public enum zze implements zzep {
            UNKNOWN_STATUS(0),
            COMPLETED_EVENT(1),
            MISSING_END_EVENT(2),
            HANG(3),
            ABANDONED_FROM_HANG(4),
            FORCED_CRASH_FROM_HANG(5);
            
            private static final zzeo<zze> zzg = new zzic();
            private final int zzh;

            zze(int i) {
                this.zzh = i;
            }

            public static zzer zzb() {
                return zzie.zza;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "<" + zze.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzh + " name=" + name() + '>';
            }

            @Override // com.google.android.gms.internal.mlkit_vision_common.zzep
            public final int zza() {
                return this.zzh;
            }
        }

        static {
            zzc zzcVar = new zzc();
            zzm = zzcVar;
            zzek.zza(zzc.class, zzcVar);
        }

        private zzc() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_common.zzek$zza, com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzhx$zzc>] */
        /* JADX WARN: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzek
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_common.zzhw.zza
                r4 = 1
                int r2 = r2 - r4
                r2 = r3[r2]
                r3 = 0
                switch(r2) {
                    case 1: goto L_0x008f;
                    case 2: goto L_0x0089;
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
                com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzhx$zzc> r2 = com.google.android.gms.internal.mlkit_vision_common.zzhx.zzc.zzn
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzhx$zzc> r3 = com.google.android.gms.internal.mlkit_vision_common.zzhx.zzc.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzhx$zzc> r2 = com.google.android.gms.internal.mlkit_vision_common.zzhx.zzc.zzn     // Catch: all -> 0x002c
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_common.zzek$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzek$zza     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_vision_common.zzhx$zzc r4 = com.google.android.gms.internal.mlkit_vision_common.zzhx.zzc.zzm     // Catch: all -> 0x002c
                r2.<init>(r4)     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_vision_common.zzhx.zzc.zzn = r2     // Catch: all -> 0x002c
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
                com.google.android.gms.internal.mlkit_vision_common.zzhx$zzc r2 = com.google.android.gms.internal.mlkit_vision_common.zzhx.zzc.zzm
                return r2
            L_0x0033:
                r2 = 13
                java.lang.Object[] r2 = new java.lang.Object[r2]
                r3 = 0
                java.lang.String r0 = "zzc"
                r2[r3] = r0
                java.lang.String r3 = "zzd"
                r2[r4] = r3
                r3 = 2
                com.google.android.gms.internal.mlkit_vision_common.zzer r4 = com.google.android.gms.internal.mlkit_vision_common.zzhx.zzc.zza.zzb()
                r2[r3] = r4
                r3 = 3
                java.lang.String r4 = "zze"
                r2[r3] = r4
                r3 = 4
                com.google.android.gms.internal.mlkit_vision_common.zzer r4 = com.google.android.gms.internal.mlkit_vision_common.zzhx.zzc.zze.zzb()
                r2[r3] = r4
                r3 = 5
                java.lang.String r4 = "zzf"
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
                r3 = 10
                java.lang.String r4 = "zzk"
                r2[r3] = r4
                r3 = 11
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzhx$zzg> r4 = com.google.android.gms.internal.mlkit_vision_common.zzhx.zzg.class
                r2[r3] = r4
                r3 = 12
                java.lang.String r4 = "zzl"
                r2[r3] = r4
                java.lang.String r3 = "\u0001\t\u0000\u0001\u0001\t\t\u0000\u0001\u0000\u0001ဌ\u0000\u0002ဌ\u0001\u0003ဈ\u0002\u0004ဈ\u0003\u0005ဉ\u0004\u0006ဉ\u0005\u0007င\u0006\b\u001b\tင\u0007"
                com.google.android.gms.internal.mlkit_vision_common.zzhx$zzc r4 = com.google.android.gms.internal.mlkit_vision_common.zzhx.zzc.zzm
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_common.zzek.zza(r4, r3, r2)
                return r2
            L_0x0089:
                com.google.android.gms.internal.mlkit_vision_common.zzhx$zzc$zzb r2 = new com.google.android.gms.internal.mlkit_vision_common.zzhx$zzc$zzb
                r2.<init>(r3)
                return r2
            L_0x008f:
                com.google.android.gms.internal.mlkit_vision_common.zzhx$zzc r2 = new com.google.android.gms.internal.mlkit_vision_common.zzhx$zzc
                r2.<init>()
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.zzhx.zzc.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        /* renamed from: com.google.android.gms.internal.mlkit_vision_common.zzhx$zzc$zzc  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0131zzc extends zzek<C0131zzc, zza> implements zzfx {
            private static final C0131zzc zzf;
            private static volatile zzgf<C0131zzc> zzg;
            private int zzc;
            private int zzd;
            private int zze;

            /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
            /* renamed from: com.google.android.gms.internal.mlkit_vision_common.zzhx$zzc$zzc$zza */
            /* loaded from: classes.dex */
            public static final class zza extends zzek.zzb<C0131zzc, zza> implements zzfx {
                private zza() {
                    super(C0131zzc.zzf);
                }

                /* synthetic */ zza(zzhw zzhwVar) {
                    this();
                }
            }

            static {
                C0131zzc zzcVar = new C0131zzc();
                zzf = zzcVar;
                zzek.zza(C0131zzc.class, zzcVar);
            }

            private C0131zzc() {
            }

            /* JADX INFO: Access modifiers changed from: protected */
            /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_common.zzek$zza, com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzhx$zzc$zzc>] */
            /* JADX WARN: Unknown variable types count: 1 */
            @Override // com.google.android.gms.internal.mlkit_vision_common.zzek
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
                /*
                    r1 = this;
                    int[] r3 = com.google.android.gms.internal.mlkit_vision_common.zzhw.zza
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
                    com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzhx$zzc$zzc> r2 = com.google.android.gms.internal.mlkit_vision_common.zzhx.zzc.C0131zzc.zzg
                    if (r2 != 0) goto L_0x002f
                    java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzhx$zzc$zzc> r3 = com.google.android.gms.internal.mlkit_vision_common.zzhx.zzc.C0131zzc.class
                    monitor-enter(r3)
                    com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzhx$zzc$zzc> r2 = com.google.android.gms.internal.mlkit_vision_common.zzhx.zzc.C0131zzc.zzg     // Catch: all -> 0x002c
                    if (r2 != 0) goto L_0x002a
                    com.google.android.gms.internal.mlkit_vision_common.zzek$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzek$zza     // Catch: all -> 0x002c
                    com.google.android.gms.internal.mlkit_vision_common.zzhx$zzc$zzc r4 = com.google.android.gms.internal.mlkit_vision_common.zzhx.zzc.C0131zzc.zzf     // Catch: all -> 0x002c
                    r2.<init>(r4)     // Catch: all -> 0x002c
                    com.google.android.gms.internal.mlkit_vision_common.zzhx.zzc.C0131zzc.zzg = r2     // Catch: all -> 0x002c
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
                    com.google.android.gms.internal.mlkit_vision_common.zzhx$zzc$zzc r2 = com.google.android.gms.internal.mlkit_vision_common.zzhx.zzc.C0131zzc.zzf
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
                    java.lang.String r3 = "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001င\u0000\u0002င\u0001"
                    com.google.android.gms.internal.mlkit_vision_common.zzhx$zzc$zzc r4 = com.google.android.gms.internal.mlkit_vision_common.zzhx.zzc.C0131zzc.zzf
                    java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_common.zzek.zza(r4, r3, r2)
                    return r2
                L_0x004d:
                    com.google.android.gms.internal.mlkit_vision_common.zzhx$zzc$zzc$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzhx$zzc$zzc$zza
                    r2.<init>(r3)
                    return r2
                L_0x0053:
                    com.google.android.gms.internal.mlkit_vision_common.zzhx$zzc$zzc r2 = new com.google.android.gms.internal.mlkit_vision_common.zzhx$zzc$zzc
                    r2.<init>()
                    return r2
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.zzhx.zzc.C0131zzc.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
            }
        }

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        /* loaded from: classes.dex */
        public static final class zzd extends zzek<zzd, zza> implements zzfx {
            private static final zzd zzg;
            private static volatile zzgf<zzd> zzh;
            private int zzc;
            private C0131zzc zzd;
            private C0131zzc zze;
            private boolean zzf;

            /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
            /* loaded from: classes.dex */
            public static final class zza extends zzek.zzb<zzd, zza> implements zzfx {
                private zza() {
                    super(zzd.zzg);
                }

                /* synthetic */ zza(zzhw zzhwVar) {
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
            /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_common.zzek$zza, com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzhx$zzc$zzd>] */
            /* JADX WARN: Unknown variable types count: 1 */
            @Override // com.google.android.gms.internal.mlkit_vision_common.zzek
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
                /*
                    r1 = this;
                    int[] r3 = com.google.android.gms.internal.mlkit_vision_common.zzhw.zza
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
                    com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzhx$zzc$zzd> r2 = com.google.android.gms.internal.mlkit_vision_common.zzhx.zzc.zzd.zzh
                    if (r2 != 0) goto L_0x002f
                    java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzhx$zzc$zzd> r3 = com.google.android.gms.internal.mlkit_vision_common.zzhx.zzc.zzd.class
                    monitor-enter(r3)
                    com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzhx$zzc$zzd> r2 = com.google.android.gms.internal.mlkit_vision_common.zzhx.zzc.zzd.zzh     // Catch: all -> 0x002c
                    if (r2 != 0) goto L_0x002a
                    com.google.android.gms.internal.mlkit_vision_common.zzek$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzek$zza     // Catch: all -> 0x002c
                    com.google.android.gms.internal.mlkit_vision_common.zzhx$zzc$zzd r4 = com.google.android.gms.internal.mlkit_vision_common.zzhx.zzc.zzd.zzg     // Catch: all -> 0x002c
                    r2.<init>(r4)     // Catch: all -> 0x002c
                    com.google.android.gms.internal.mlkit_vision_common.zzhx.zzc.zzd.zzh = r2     // Catch: all -> 0x002c
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
                    com.google.android.gms.internal.mlkit_vision_common.zzhx$zzc$zzd r2 = com.google.android.gms.internal.mlkit_vision_common.zzhx.zzc.zzd.zzg
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
                    java.lang.String r3 = "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဇ\u0002"
                    com.google.android.gms.internal.mlkit_vision_common.zzhx$zzc$zzd r4 = com.google.android.gms.internal.mlkit_vision_common.zzhx.zzc.zzd.zzg
                    java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_common.zzek.zza(r4, r3, r2)
                    return r2
                L_0x0052:
                    com.google.android.gms.internal.mlkit_vision_common.zzhx$zzc$zzd$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzhx$zzc$zzd$zza
                    r2.<init>(r3)
                    return r2
                L_0x0058:
                    com.google.android.gms.internal.mlkit_vision_common.zzhx$zzc$zzd r2 = new com.google.android.gms.internal.mlkit_vision_common.zzhx$zzc$zzd
                    r2.<init>()
                    return r2
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.zzhx.zzc.zzd.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
            }
        }
    }

    /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
    /* loaded from: classes.dex */
    public static final class zzi extends zzek<zzi, zza> implements zzfx {
        private static final zzi zzd;
        private static volatile zzgf<zzi> zze;
        private zzes<zzb> zzc = zzek.zzl();

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        /* loaded from: classes.dex */
        public static final class zza extends zzek.zzb<zzi, zza> implements zzfx {
            private zza() {
                super(zzi.zzd);
            }

            /* synthetic */ zza(zzhw zzhwVar) {
                this();
            }
        }

        static {
            zzi zziVar = new zzi();
            zzd = zziVar;
            zzek.zza(zzi.class, zziVar);
        }

        private zzi() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzhx$zzi>, com.google.android.gms.internal.mlkit_vision_common.zzek$zza] */
        /* JADX WARN: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzek
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_common.zzhw.zza
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
                com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzhx$zzi> r2 = com.google.android.gms.internal.mlkit_vision_common.zzhx.zzi.zze
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzhx$zzi> r3 = com.google.android.gms.internal.mlkit_vision_common.zzhx.zzi.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzhx$zzi> r2 = com.google.android.gms.internal.mlkit_vision_common.zzhx.zzi.zze     // Catch: all -> 0x002c
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_common.zzek$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzek$zza     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_vision_common.zzhx$zzi r4 = com.google.android.gms.internal.mlkit_vision_common.zzhx.zzi.zzd     // Catch: all -> 0x002c
                r2.<init>(r4)     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_vision_common.zzhx.zzi.zze = r2     // Catch: all -> 0x002c
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
                com.google.android.gms.internal.mlkit_vision_common.zzhx$zzi r2 = com.google.android.gms.internal.mlkit_vision_common.zzhx.zzi.zzd
                return r2
            L_0x0033:
                r2 = 2
                java.lang.Object[] r2 = new java.lang.Object[r2]
                r3 = 0
                java.lang.String r0 = "zzc"
                r2[r3] = r0
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzhx$zzi$zzb> r3 = com.google.android.gms.internal.mlkit_vision_common.zzhx.zzi.zzb.class
                r2[r4] = r3
                java.lang.String r3 = "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b"
                com.google.android.gms.internal.mlkit_vision_common.zzhx$zzi r4 = com.google.android.gms.internal.mlkit_vision_common.zzhx.zzi.zzd
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_common.zzek.zza(r4, r3, r2)
                return r2
            L_0x0048:
                com.google.android.gms.internal.mlkit_vision_common.zzhx$zzi$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzhx$zzi$zza
                r2.<init>(r3)
                return r2
            L_0x004e:
                com.google.android.gms.internal.mlkit_vision_common.zzhx$zzi r2 = new com.google.android.gms.internal.mlkit_vision_common.zzhx$zzi
                r2.<init>()
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.zzhx.zzi.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        /* loaded from: classes.dex */
        public static final class zzb extends zzek<zzb, zza> implements zzfx {
            private static final zzb zzh;
            private static volatile zzgf<zzb> zzi;
            private int zzc;
            private int zze;
            private long zzg;
            private String zzd = "";
            private String zzf = "";

            /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
            /* loaded from: classes.dex */
            public static final class zza extends zzek.zzb<zzb, zza> implements zzfx {
                private zza() {
                    super(zzb.zzh);
                }

                /* synthetic */ zza(zzhw zzhwVar) {
                    this();
                }
            }

            static {
                zzb zzbVar = new zzb();
                zzh = zzbVar;
                zzek.zza(zzb.class, zzbVar);
            }

            private zzb() {
            }

            /* JADX INFO: Access modifiers changed from: protected */
            /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_common.zzek$zza, com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzhx$zzi$zzb>] */
            /* JADX WARN: Unknown variable types count: 1 */
            @Override // com.google.android.gms.internal.mlkit_vision_common.zzek
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
                /*
                    r1 = this;
                    int[] r3 = com.google.android.gms.internal.mlkit_vision_common.zzhw.zza
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
                    com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzhx$zzi$zzb> r2 = com.google.android.gms.internal.mlkit_vision_common.zzhx.zzi.zzb.zzi
                    if (r2 != 0) goto L_0x002f
                    java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzhx$zzi$zzb> r3 = com.google.android.gms.internal.mlkit_vision_common.zzhx.zzi.zzb.class
                    monitor-enter(r3)
                    com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzhx$zzi$zzb> r2 = com.google.android.gms.internal.mlkit_vision_common.zzhx.zzi.zzb.zzi     // Catch: all -> 0x002c
                    if (r2 != 0) goto L_0x002a
                    com.google.android.gms.internal.mlkit_vision_common.zzek$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzek$zza     // Catch: all -> 0x002c
                    com.google.android.gms.internal.mlkit_vision_common.zzhx$zzi$zzb r4 = com.google.android.gms.internal.mlkit_vision_common.zzhx.zzi.zzb.zzh     // Catch: all -> 0x002c
                    r2.<init>(r4)     // Catch: all -> 0x002c
                    com.google.android.gms.internal.mlkit_vision_common.zzhx.zzi.zzb.zzi = r2     // Catch: all -> 0x002c
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
                    com.google.android.gms.internal.mlkit_vision_common.zzhx$zzi$zzb r2 = com.google.android.gms.internal.mlkit_vision_common.zzhx.zzi.zzb.zzh
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
                    java.lang.String r3 = "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဈ\u0000\u0002င\u0001\u0003ဈ\u0002\u0004ဂ\u0003"
                    com.google.android.gms.internal.mlkit_vision_common.zzhx$zzi$zzb r4 = com.google.android.gms.internal.mlkit_vision_common.zzhx.zzi.zzb.zzh
                    java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_common.zzek.zza(r4, r3, r2)
                    return r2
                L_0x0057:
                    com.google.android.gms.internal.mlkit_vision_common.zzhx$zzi$zzb$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzhx$zzi$zzb$zza
                    r2.<init>(r3)
                    return r2
                L_0x005d:
                    com.google.android.gms.internal.mlkit_vision_common.zzhx$zzi$zzb r2 = new com.google.android.gms.internal.mlkit_vision_common.zzhx$zzi$zzb
                    r2.<init>()
                    return r2
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.zzhx.zzi.zzb.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
            }
        }
    }

    /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
    /* loaded from: classes.dex */
    public static final class zzb extends zzek<zzb, zza> implements zzfx {
        private static final zzb zzn;
        private static volatile zzgf<zzb> zzo;
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

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        /* loaded from: classes.dex */
        public static final class zza extends zzek.zzb<zzb, zza> implements zzfx {
            private zza() {
                super(zzb.zzn);
            }

            /* synthetic */ zza(zzhw zzhwVar) {
                this();
            }
        }

        static {
            zzb zzbVar = new zzb();
            zzn = zzbVar;
            zzek.zza(zzb.class, zzbVar);
        }

        private zzb() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_common.zzek$zza, com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzhx$zzb>] */
        /* JADX WARN: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzek
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_common.zzhw.zza
                r4 = 1
                int r2 = r2 - r4
                r2 = r3[r2]
                r3 = 0
                switch(r2) {
                    case 1: goto L_0x007f;
                    case 2: goto L_0x0079;
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
                com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzhx$zzb> r2 = com.google.android.gms.internal.mlkit_vision_common.zzhx.zzb.zzo
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzhx$zzb> r3 = com.google.android.gms.internal.mlkit_vision_common.zzhx.zzb.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzhx$zzb> r2 = com.google.android.gms.internal.mlkit_vision_common.zzhx.zzb.zzo     // Catch: all -> 0x002c
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_common.zzek$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzek$zza     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_vision_common.zzhx$zzb r4 = com.google.android.gms.internal.mlkit_vision_common.zzhx.zzb.zzn     // Catch: all -> 0x002c
                r2.<init>(r4)     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_vision_common.zzhx.zzb.zzo = r2     // Catch: all -> 0x002c
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
                com.google.android.gms.internal.mlkit_vision_common.zzhx$zzb r2 = com.google.android.gms.internal.mlkit_vision_common.zzhx.zzb.zzn
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
                java.lang.String r3 = "\u0001\n\u0000\u0001\u0001\n\n\u0000\u0000\u0000\u0001င\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004ဈ\u0003\u0005ဈ\u0004\u0006ဈ\u0005\u0007ဈ\u0006\bဈ\u0007\tဈ\b\nဈ\t"
                com.google.android.gms.internal.mlkit_vision_common.zzhx$zzb r4 = com.google.android.gms.internal.mlkit_vision_common.zzhx.zzb.zzn
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_common.zzek.zza(r4, r3, r2)
                return r2
            L_0x0079:
                com.google.android.gms.internal.mlkit_vision_common.zzhx$zzb$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzhx$zzb$zza
                r2.<init>(r3)
                return r2
            L_0x007f:
                com.google.android.gms.internal.mlkit_vision_common.zzhx$zzb r2 = new com.google.android.gms.internal.mlkit_vision_common.zzhx$zzb
                r2.<init>()
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.zzhx.zzb.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
    /* loaded from: classes.dex */
    public static final class zzd extends zzek<zzd, zza> implements zzfx {
        private static final zzd zzk;
        private static volatile zzgf<zzd> zzl;
        private int zzc;
        private int zzg;
        private int zzh;
        private int zzj;
        private String zzd = "";
        private String zze = "";
        private String zzf = "";
        private String zzi = "";

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        /* loaded from: classes.dex */
        public static final class zza extends zzek.zzb<zzd, zza> implements zzfx {
            private zza() {
                super(zzd.zzk);
            }

            /* synthetic */ zza(zzhw zzhwVar) {
                this();
            }
        }

        static {
            zzd zzdVar = new zzd();
            zzk = zzdVar;
            zzek.zza(zzd.class, zzdVar);
        }

        private zzd() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_common.zzek$zza, com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzhx$zzd>] */
        /* JADX WARN: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzek
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_common.zzhw.zza
                r4 = 1
                int r2 = r2 - r4
                r2 = r3[r2]
                r3 = 0
                switch(r2) {
                    case 1: goto L_0x006d;
                    case 2: goto L_0x0067;
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
                com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzhx$zzd> r2 = com.google.android.gms.internal.mlkit_vision_common.zzhx.zzd.zzl
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzhx$zzd> r3 = com.google.android.gms.internal.mlkit_vision_common.zzhx.zzd.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzhx$zzd> r2 = com.google.android.gms.internal.mlkit_vision_common.zzhx.zzd.zzl     // Catch: all -> 0x002c
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_common.zzek$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzek$zza     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_vision_common.zzhx$zzd r4 = com.google.android.gms.internal.mlkit_vision_common.zzhx.zzd.zzk     // Catch: all -> 0x002c
                r2.<init>(r4)     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_vision_common.zzhx.zzd.zzl = r2     // Catch: all -> 0x002c
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
                com.google.android.gms.internal.mlkit_vision_common.zzhx$zzd r2 = com.google.android.gms.internal.mlkit_vision_common.zzhx.zzd.zzk
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
                java.lang.String r3 = "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004င\u0003\u0005င\u0004\u0006ဈ\u0005\u0007င\u0006"
                com.google.android.gms.internal.mlkit_vision_common.zzhx$zzd r4 = com.google.android.gms.internal.mlkit_vision_common.zzhx.zzd.zzk
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_common.zzek.zza(r4, r3, r2)
                return r2
            L_0x0067:
                com.google.android.gms.internal.mlkit_vision_common.zzhx$zzd$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzhx$zzd$zza
                r2.<init>(r3)
                return r2
            L_0x006d:
                com.google.android.gms.internal.mlkit_vision_common.zzhx$zzd r2 = new com.google.android.gms.internal.mlkit_vision_common.zzhx$zzd
                r2.<init>()
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.zzhx.zzd.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
    /* loaded from: classes.dex */
    public static final class zze extends zzek<zze, zza> implements zzfx {
        private static final zze zze;
        private static volatile zzgf<zze> zzf;
        private int zzc;
        private int zzd;

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        /* loaded from: classes.dex */
        public static final class zza extends zzek.zzb<zze, zza> implements zzfx {
            private zza() {
                super(zze.zze);
            }

            /* synthetic */ zza(zzhw zzhwVar) {
                this();
            }
        }

        static {
            zze zzeVar = new zze();
            zze = zzeVar;
            zzek.zza(zze.class, zzeVar);
        }

        private zze() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_common.zzek$zza, com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzhx$zze>] */
        /* JADX WARN: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzek
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_common.zzhw.zza
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
                com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzhx$zze> r2 = com.google.android.gms.internal.mlkit_vision_common.zzhx.zze.zzf
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzhx$zze> r3 = com.google.android.gms.internal.mlkit_vision_common.zzhx.zze.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzhx$zze> r2 = com.google.android.gms.internal.mlkit_vision_common.zzhx.zze.zzf     // Catch: all -> 0x002c
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_common.zzek$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzek$zza     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_vision_common.zzhx$zze r4 = com.google.android.gms.internal.mlkit_vision_common.zzhx.zze.zze     // Catch: all -> 0x002c
                r2.<init>(r4)     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_vision_common.zzhx.zze.zzf = r2     // Catch: all -> 0x002c
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
                com.google.android.gms.internal.mlkit_vision_common.zzhx$zze r2 = com.google.android.gms.internal.mlkit_vision_common.zzhx.zze.zze
                return r2
            L_0x0033:
                r2 = 2
                java.lang.Object[] r2 = new java.lang.Object[r2]
                r3 = 0
                java.lang.String r0 = "zzc"
                r2[r3] = r0
                java.lang.String r3 = "zzd"
                r2[r4] = r3
                java.lang.String r3 = "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001င\u0000"
                com.google.android.gms.internal.mlkit_vision_common.zzhx$zze r4 = com.google.android.gms.internal.mlkit_vision_common.zzhx.zze.zze
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_common.zzek.zza(r4, r3, r2)
                return r2
            L_0x0048:
                com.google.android.gms.internal.mlkit_vision_common.zzhx$zze$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzhx$zze$zza
                r2.<init>(r3)
                return r2
            L_0x004e:
                com.google.android.gms.internal.mlkit_vision_common.zzhx$zze r2 = new com.google.android.gms.internal.mlkit_vision_common.zzhx$zze
                r2.<init>()
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.zzhx.zze.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
    /* loaded from: classes.dex */
    public static final class zzg extends zzek<zzg, zza> implements zzfx {
        private static final zzg zzd;
        private static volatile zzgf<zzg> zze;
        private zzeq zzc = zzek.zzk();

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        /* loaded from: classes.dex */
        public static final class zza extends zzek.zzb<zzg, zza> implements zzfx {
            private zza() {
                super(zzg.zzd);
            }

            /* synthetic */ zza(zzhw zzhwVar) {
                this();
            }
        }

        static {
            zzg zzgVar = new zzg();
            zzd = zzgVar;
            zzek.zza(zzg.class, zzgVar);
        }

        private zzg() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Type inference failed for: r1v13, types: [com.google.android.gms.internal.mlkit_vision_common.zzek$zza, com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzhx$zzg>] */
        /* JADX WARN: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzek
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object zza(int r1, java.lang.Object r2, java.lang.Object r3) {
            /*
                r0 = this;
                int[] r2 = com.google.android.gms.internal.mlkit_vision_common.zzhw.zza
                r3 = 1
                int r1 = r1 - r3
                r1 = r2[r1]
                r2 = 0
                switch(r1) {
                    case 1: goto L_0x0049;
                    case 2: goto L_0x0043;
                    case 3: goto L_0x0033;
                    case 4: goto L_0x0030;
                    case 5: goto L_0x0016;
                    case 6: goto L_0x0011;
                    case 7: goto L_0x0010;
                    default: goto L_0x000a;
                }
            L_0x000a:
                java.lang.UnsupportedOperationException r1 = new java.lang.UnsupportedOperationException
                r1.<init>()
                throw r1
            L_0x0010:
                return r2
            L_0x0011:
                java.lang.Byte r1 = java.lang.Byte.valueOf(r3)
                return r1
            L_0x0016:
                com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzhx$zzg> r1 = com.google.android.gms.internal.mlkit_vision_common.zzhx.zzg.zze
                if (r1 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzhx$zzg> r2 = com.google.android.gms.internal.mlkit_vision_common.zzhx.zzg.class
                monitor-enter(r2)
                com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzhx$zzg> r1 = com.google.android.gms.internal.mlkit_vision_common.zzhx.zzg.zze     // Catch: all -> 0x002c
                if (r1 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_common.zzek$zza r1 = new com.google.android.gms.internal.mlkit_vision_common.zzek$zza     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_vision_common.zzhx$zzg r3 = com.google.android.gms.internal.mlkit_vision_common.zzhx.zzg.zzd     // Catch: all -> 0x002c
                r1.<init>(r3)     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_vision_common.zzhx.zzg.zze = r1     // Catch: all -> 0x002c
            L_0x002a:
                monitor-exit(r2)     // Catch: all -> 0x002c
                goto L_0x002f
            L_0x002c:
                r1 = move-exception
                monitor-exit(r2)     // Catch: all -> 0x002c
                throw r1
            L_0x002f:
                return r1
            L_0x0030:
                com.google.android.gms.internal.mlkit_vision_common.zzhx$zzg r1 = com.google.android.gms.internal.mlkit_vision_common.zzhx.zzg.zzd
                return r1
            L_0x0033:
                java.lang.Object[] r1 = new java.lang.Object[r3]
                r2 = 0
                java.lang.String r3 = "zzc"
                r1[r2] = r3
                java.lang.String r2 = "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u0016"
                com.google.android.gms.internal.mlkit_vision_common.zzhx$zzg r3 = com.google.android.gms.internal.mlkit_vision_common.zzhx.zzg.zzd
                java.lang.Object r1 = com.google.android.gms.internal.mlkit_vision_common.zzek.zza(r3, r2, r1)
                return r1
            L_0x0043:
                com.google.android.gms.internal.mlkit_vision_common.zzhx$zzg$zza r1 = new com.google.android.gms.internal.mlkit_vision_common.zzhx$zzg$zza
                r1.<init>(r2)
                return r1
            L_0x0049:
                com.google.android.gms.internal.mlkit_vision_common.zzhx$zzg r1 = new com.google.android.gms.internal.mlkit_vision_common.zzhx$zzg
                r1.<init>()
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.zzhx.zzg.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
    /* loaded from: classes.dex */
    public static final class zzh extends zzek<zzh, zza> implements zzfx {
        private static final zzh zzf;
        private static volatile zzgf<zzh> zzg;
        private int zzc;
        private String zzd = "";
        private int zze;

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        /* loaded from: classes.dex */
        public static final class zza extends zzek.zzb<zzh, zza> implements zzfx {
            private zza() {
                super(zzh.zzf);
            }

            /* synthetic */ zza(zzhw zzhwVar) {
                this();
            }
        }

        static {
            zzh zzhVar = new zzh();
            zzf = zzhVar;
            zzek.zza(zzh.class, zzhVar);
        }

        private zzh() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_common.zzek$zza, com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzhx$zzh>] */
        /* JADX WARN: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzek
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_common.zzhw.zza
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
                com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzhx$zzh> r2 = com.google.android.gms.internal.mlkit_vision_common.zzhx.zzh.zzg
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzhx$zzh> r3 = com.google.android.gms.internal.mlkit_vision_common.zzhx.zzh.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzhx$zzh> r2 = com.google.android.gms.internal.mlkit_vision_common.zzhx.zzh.zzg     // Catch: all -> 0x002c
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_common.zzek$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzek$zza     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_vision_common.zzhx$zzh r4 = com.google.android.gms.internal.mlkit_vision_common.zzhx.zzh.zzf     // Catch: all -> 0x002c
                r2.<init>(r4)     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_vision_common.zzhx.zzh.zzg = r2     // Catch: all -> 0x002c
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
                com.google.android.gms.internal.mlkit_vision_common.zzhx$zzh r2 = com.google.android.gms.internal.mlkit_vision_common.zzhx.zzh.zzf
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
                java.lang.String r3 = "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002င\u0001"
                com.google.android.gms.internal.mlkit_vision_common.zzhx$zzh r4 = com.google.android.gms.internal.mlkit_vision_common.zzhx.zzh.zzf
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_common.zzek.zza(r4, r3, r2)
                return r2
            L_0x004d:
                com.google.android.gms.internal.mlkit_vision_common.zzhx$zzh$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzhx$zzh$zza
                r2.<init>(r3)
                return r2
            L_0x0053:
                com.google.android.gms.internal.mlkit_vision_common.zzhx$zzh r2 = new com.google.android.gms.internal.mlkit_vision_common.zzhx$zzh
                r2.<init>()
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.zzhx.zzh.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
    /* loaded from: classes.dex */
    public static final class zza extends zzek<zza, C0130zza> implements zzfx {
        private static final zza zzf;
        private static volatile zzgf<zza> zzg;
        private int zzc;
        private int zzd;
        private zzj zze;

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        /* renamed from: com.google.android.gms.internal.mlkit_vision_common.zzhx$zza$zza  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0130zza extends zzek.zzb<zza, C0130zza> implements zzfx {
            private C0130zza() {
                super(zza.zzf);
            }

            /* synthetic */ C0130zza(zzhw zzhwVar) {
                this();
            }
        }

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        /* loaded from: classes.dex */
        public enum zzb implements zzep {
            UNKNOWN_ENGINE(0),
            TFLITE(1);
            
            private static final zzeo<zzb> zzc = new zzhy();
            private final int zzd;

            zzb(int i) {
                this.zzd = i;
            }

            public static zzer zzb() {
                return zzhz.zza;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "<" + zzb.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzd + " name=" + name() + '>';
            }

            @Override // com.google.android.gms.internal.mlkit_vision_common.zzep
            public final int zza() {
                return this.zzd;
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
        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_common.zzek$zza, com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzhx$zza>] */
        /* JADX WARN: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzek
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_common.zzhw.zza
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
                com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzhx$zza> r2 = com.google.android.gms.internal.mlkit_vision_common.zzhx.zza.zzg
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzhx$zza> r3 = com.google.android.gms.internal.mlkit_vision_common.zzhx.zza.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzhx$zza> r2 = com.google.android.gms.internal.mlkit_vision_common.zzhx.zza.zzg     // Catch: all -> 0x002c
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_common.zzek$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzek$zza     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_vision_common.zzhx$zza r4 = com.google.android.gms.internal.mlkit_vision_common.zzhx.zza.zzf     // Catch: all -> 0x002c
                r2.<init>(r4)     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_vision_common.zzhx.zza.zzg = r2     // Catch: all -> 0x002c
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
                com.google.android.gms.internal.mlkit_vision_common.zzhx$zza r2 = com.google.android.gms.internal.mlkit_vision_common.zzhx.zza.zzf
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
                com.google.android.gms.internal.mlkit_vision_common.zzer r4 = com.google.android.gms.internal.mlkit_vision_common.zzhx.zza.zzb.zzb()
                r2[r3] = r4
                r3 = 3
                java.lang.String r4 = "zze"
                r2[r3] = r4
                java.lang.String r3 = "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဉ\u0001"
                com.google.android.gms.internal.mlkit_vision_common.zzhx$zza r4 = com.google.android.gms.internal.mlkit_vision_common.zzhx.zza.zzf
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_common.zzek.zza(r4, r3, r2)
                return r2
            L_0x0054:
                com.google.android.gms.internal.mlkit_vision_common.zzhx$zza$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzhx$zza$zza
                r2.<init>(r3)
                return r2
            L_0x005a:
                com.google.android.gms.internal.mlkit_vision_common.zzhx$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzhx$zza
                r2.<init>()
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.zzhx.zza.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
    /* loaded from: classes.dex */
    public static final class zzj extends zzek<zzj, zza> implements zzfx {
        private static final zzj zzg;
        private static volatile zzgf<zzj> zzh;
        private int zzc;
        private int zzd;
        private zzh zze;
        private zze zzf;

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        /* loaded from: classes.dex */
        public static final class zza extends zzek.zzb<zzj, zza> implements zzfx {
            private zza() {
                super(zzj.zzg);
            }

            /* synthetic */ zza(zzhw zzhwVar) {
                this();
            }
        }

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        /* loaded from: classes.dex */
        public enum zzb implements zzep {
            DELEGATE_NONE(0),
            NNAPI(1),
            GPU(2),
            HEXAGON(3);
            
            private static final zzeo<zzb> zze = new zzih();
            private final int zzf;

            zzb(int i) {
                this.zzf = i;
            }

            public static zzer zzb() {
                return zzii.zza;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "<" + zzb.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzf + " name=" + name() + '>';
            }

            @Override // com.google.android.gms.internal.mlkit_vision_common.zzep
            public final int zza() {
                return this.zzf;
            }
        }

        static {
            zzj zzjVar = new zzj();
            zzg = zzjVar;
            zzek.zza(zzj.class, zzjVar);
        }

        private zzj() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzhx$zzj>, com.google.android.gms.internal.mlkit_vision_common.zzek$zza] */
        /* JADX WARN: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzek
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.mlkit_vision_common.zzhw.zza
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
                com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzhx$zzj> r2 = com.google.android.gms.internal.mlkit_vision_common.zzhx.zzj.zzh
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzhx$zzj> r3 = com.google.android.gms.internal.mlkit_vision_common.zzhx.zzj.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzhx$zzj> r2 = com.google.android.gms.internal.mlkit_vision_common.zzhx.zzj.zzh     // Catch: all -> 0x002c
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.mlkit_vision_common.zzek$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzek$zza     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_vision_common.zzhx$zzj r4 = com.google.android.gms.internal.mlkit_vision_common.zzhx.zzj.zzg     // Catch: all -> 0x002c
                r2.<init>(r4)     // Catch: all -> 0x002c
                com.google.android.gms.internal.mlkit_vision_common.zzhx.zzj.zzh = r2     // Catch: all -> 0x002c
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
                com.google.android.gms.internal.mlkit_vision_common.zzhx$zzj r2 = com.google.android.gms.internal.mlkit_vision_common.zzhx.zzj.zzg
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
                com.google.android.gms.internal.mlkit_vision_common.zzer r4 = com.google.android.gms.internal.mlkit_vision_common.zzhx.zzj.zzb.zzb()
                r2[r3] = r4
                r3 = 3
                java.lang.String r4 = "zze"
                r2[r3] = r4
                r3 = 4
                java.lang.String r4 = "zzf"
                r2[r3] = r4
                java.lang.String r3 = "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဉ\u0001\u0003ဉ\u0002"
                com.google.android.gms.internal.mlkit_vision_common.zzhx$zzj r4 = com.google.android.gms.internal.mlkit_vision_common.zzhx.zzj.zzg
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_common.zzek.zza(r4, r3, r2)
                return r2
            L_0x0059:
                com.google.android.gms.internal.mlkit_vision_common.zzhx$zzj$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzhx$zzj$zza
                r2.<init>(r3)
                return r2
            L_0x005f:
                com.google.android.gms.internal.mlkit_vision_common.zzhx$zzj r2 = new com.google.android.gms.internal.mlkit_vision_common.zzhx$zzj
                r2.<init>()
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.zzhx.zzj.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
    /* loaded from: classes.dex */
    public static final class zzk extends zzek.zzc<zzk, zza> implements zzfx {
        private static final zzk zze;
        private static volatile zzgf<zzk> zzf;
        private byte zzd = 2;

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        /* loaded from: classes.dex */
        public static final class zza extends zzek.zzd<zzk, zza> implements zzfx {
            private zza() {
                super(zzk.zze);
            }

            /* synthetic */ zza(zzhw zzhwVar) {
                this();
            }
        }

        static {
            zzk zzkVar = new zzk();
            zze = zzkVar;
            zzek.zza(zzk.class, zzkVar);
        }

        private zzk() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Type inference failed for: r2v13, types: [com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzhx$zzk>, com.google.android.gms.internal.mlkit_vision_common.zzek$zza] */
        /* JADX WARN: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzek
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r4 = com.google.android.gms.internal.mlkit_vision_common.zzhw.zza
                r0 = 1
                int r2 = r2 - r0
                r2 = r4[r2]
                r4 = 0
                switch(r2) {
                    case 1: goto L_0x004a;
                    case 2: goto L_0x0044;
                    case 3: goto L_0x003b;
                    case 4: goto L_0x0038;
                    case 5: goto L_0x001e;
                    case 6: goto L_0x0017;
                    case 7: goto L_0x0010;
                    default: goto L_0x000a;
                }
            L_0x000a:
                java.lang.UnsupportedOperationException r2 = new java.lang.UnsupportedOperationException
                r2.<init>()
                throw r2
            L_0x0010:
                if (r3 != 0) goto L_0x0013
                r0 = 0
            L_0x0013:
                byte r2 = (byte) r0
                r1.zzd = r2
                return r4
            L_0x0017:
                byte r2 = r1.zzd
                java.lang.Byte r2 = java.lang.Byte.valueOf(r2)
                return r2
            L_0x001e:
                com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzhx$zzk> r2 = com.google.android.gms.internal.mlkit_vision_common.zzhx.zzk.zzf
                if (r2 != 0) goto L_0x0037
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzhx$zzk> r3 = com.google.android.gms.internal.mlkit_vision_common.zzhx.zzk.class
                monitor-enter(r3)
                com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzhx$zzk> r2 = com.google.android.gms.internal.mlkit_vision_common.zzhx.zzk.zzf     // Catch: all -> 0x0034
                if (r2 != 0) goto L_0x0032
                com.google.android.gms.internal.mlkit_vision_common.zzek$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzek$zza     // Catch: all -> 0x0034
                com.google.android.gms.internal.mlkit_vision_common.zzhx$zzk r4 = com.google.android.gms.internal.mlkit_vision_common.zzhx.zzk.zze     // Catch: all -> 0x0034
                r2.<init>(r4)     // Catch: all -> 0x0034
                com.google.android.gms.internal.mlkit_vision_common.zzhx.zzk.zzf = r2     // Catch: all -> 0x0034
            L_0x0032:
                monitor-exit(r3)     // Catch: all -> 0x0034
                goto L_0x0037
            L_0x0034:
                r2 = move-exception
                monitor-exit(r3)     // Catch: all -> 0x0034
                throw r2
            L_0x0037:
                return r2
            L_0x0038:
                com.google.android.gms.internal.mlkit_vision_common.zzhx$zzk r2 = com.google.android.gms.internal.mlkit_vision_common.zzhx.zzk.zze
                return r2
            L_0x003b:
                java.lang.String r2 = "\u0001\u0000"
                com.google.android.gms.internal.mlkit_vision_common.zzhx$zzk r3 = com.google.android.gms.internal.mlkit_vision_common.zzhx.zzk.zze
                java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_common.zzek.zza(r3, r2, r4)
                return r2
            L_0x0044:
                com.google.android.gms.internal.mlkit_vision_common.zzhx$zzk$zza r2 = new com.google.android.gms.internal.mlkit_vision_common.zzhx$zzk$zza
                r2.<init>(r4)
                return r2
            L_0x004a:
                com.google.android.gms.internal.mlkit_vision_common.zzhx$zzk r2 = new com.google.android.gms.internal.mlkit_vision_common.zzhx$zzk
                r2.<init>()
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.zzhx.zzk.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
    /* loaded from: classes.dex */
    public static final class zzf extends zzek<zzf, zza> implements zzfx {
        private static final zzf zzo;
        private static volatile zzgf<zzf> zzp;
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

        /* compiled from: com.google.mlkit:vision-common@@16.0.0 */
        /* loaded from: classes.dex */
        public static final class zza extends zzek.zzb<zzf, zza> implements zzfx {
            private zza() {
                super(zzf.zzo);
            }

            /* synthetic */ zza(zzhw zzhwVar) {
                this();
            }
        }

        static {
            zzf zzfVar = new zzf();
            zzo = zzfVar;
            zzek.zza(zzf.class, zzfVar);
        }

        private zzf() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Type inference failed for: r3v14, types: [com.google.android.gms.internal.mlkit_vision_common.zzek$zza, com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzhx$zzf>] */
        /* JADX WARN: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.mlkit_vision_common.zzek
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object zza(int r3, java.lang.Object r4, java.lang.Object r5) {
            /*
                r2 = this;
                int[] r5 = com.google.android.gms.internal.mlkit_vision_common.zzhw.zza
                r0 = 1
                int r3 = r3 - r0
                r3 = r5[r3]
                r5 = 0
                r1 = 0
                switch(r3) {
                    case 1: goto L_0x008f;
                    case 2: goto L_0x0089;
                    case 3: goto L_0x003c;
                    case 4: goto L_0x0039;
                    case 5: goto L_0x001f;
                    case 6: goto L_0x0018;
                    case 7: goto L_0x0011;
                    default: goto L_0x000b;
                }
            L_0x000b:
                java.lang.UnsupportedOperationException r3 = new java.lang.UnsupportedOperationException
                r3.<init>()
                throw r3
            L_0x0011:
                if (r4 != 0) goto L_0x0014
                r0 = 0
            L_0x0014:
                byte r3 = (byte) r0
                r2.zzn = r3
                return r1
            L_0x0018:
                byte r3 = r2.zzn
                java.lang.Byte r3 = java.lang.Byte.valueOf(r3)
                return r3
            L_0x001f:
                com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzhx$zzf> r3 = com.google.android.gms.internal.mlkit_vision_common.zzhx.zzf.zzp
                if (r3 != 0) goto L_0x0038
                java.lang.Class<com.google.android.gms.internal.mlkit_vision_common.zzhx$zzf> r4 = com.google.android.gms.internal.mlkit_vision_common.zzhx.zzf.class
                monitor-enter(r4)
                com.google.android.gms.internal.mlkit_vision_common.zzgf<com.google.android.gms.internal.mlkit_vision_common.zzhx$zzf> r3 = com.google.android.gms.internal.mlkit_vision_common.zzhx.zzf.zzp     // Catch: all -> 0x0035
                if (r3 != 0) goto L_0x0033
                com.google.android.gms.internal.mlkit_vision_common.zzek$zza r3 = new com.google.android.gms.internal.mlkit_vision_common.zzek$zza     // Catch: all -> 0x0035
                com.google.android.gms.internal.mlkit_vision_common.zzhx$zzf r5 = com.google.android.gms.internal.mlkit_vision_common.zzhx.zzf.zzo     // Catch: all -> 0x0035
                r3.<init>(r5)     // Catch: all -> 0x0035
                com.google.android.gms.internal.mlkit_vision_common.zzhx.zzf.zzp = r3     // Catch: all -> 0x0035
            L_0x0033:
                monitor-exit(r4)     // Catch: all -> 0x0035
                goto L_0x0038
            L_0x0035:
                r3 = move-exception
                monitor-exit(r4)     // Catch: all -> 0x0035
                throw r3
            L_0x0038:
                return r3
            L_0x0039:
                com.google.android.gms.internal.mlkit_vision_common.zzhx$zzf r3 = com.google.android.gms.internal.mlkit_vision_common.zzhx.zzf.zzo
                return r3
            L_0x003c:
                r3 = 12
                java.lang.Object[] r3 = new java.lang.Object[r3]
                java.lang.String r4 = "zzc"
                r3[r5] = r4
                java.lang.String r4 = "zzd"
                r3[r0] = r4
                r4 = 2
                java.lang.String r5 = "zze"
                r3[r4] = r5
                r4 = 3
                java.lang.String r5 = "zzg"
                r3[r4] = r5
                r4 = 4
                com.google.android.gms.internal.mlkit_vision_common.zzer r5 = com.google.android.gms.internal.mlkit_vision_common.zzid.zzb()
                r3[r4] = r5
                r4 = 5
                java.lang.String r5 = "zzh"
                r3[r4] = r5
                r4 = 6
                java.lang.String r5 = "zzi"
                r3[r4] = r5
                r4 = 7
                java.lang.String r5 = "zzj"
                r3[r4] = r5
                r4 = 8
                java.lang.String r5 = "zzk"
                r3[r4] = r5
                r4 = 9
                java.lang.String r5 = "zzl"
                r3[r4] = r5
                r4 = 10
                java.lang.String r5 = "zzm"
                r3[r4] = r5
                r4 = 11
                java.lang.String r5 = "zzf"
                r3[r4] = r5
                java.lang.String r4 = "\u0001\n\u0000\u0001\u0001\n\n\u0000\u0000\u0001\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဌ\u0003\u0004ဉ\u0004\u0005ᐉ\u0005\u0006ဂ\u0006\u0007ဂ\u0007\bဇ\b\tင\t\nဉ\u0002"
                com.google.android.gms.internal.mlkit_vision_common.zzhx$zzf r5 = com.google.android.gms.internal.mlkit_vision_common.zzhx.zzf.zzo
                java.lang.Object r3 = com.google.android.gms.internal.mlkit_vision_common.zzek.zza(r5, r4, r3)
                return r3
            L_0x0089:
                com.google.android.gms.internal.mlkit_vision_common.zzhx$zzf$zza r3 = new com.google.android.gms.internal.mlkit_vision_common.zzhx$zzf$zza
                r3.<init>(r1)
                return r3
            L_0x008f:
                com.google.android.gms.internal.mlkit_vision_common.zzhx$zzf r3 = new com.google.android.gms.internal.mlkit_vision_common.zzhx$zzf
                r3.<init>()
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_common.zzhx.zzf.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }
    }
}
