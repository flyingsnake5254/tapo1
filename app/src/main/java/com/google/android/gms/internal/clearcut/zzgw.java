package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.zzcg;
import java.util.List;
import java.util.Objects;

/* loaded from: classes.dex */
public final class zzgw {

    /* loaded from: classes.dex */
    public static final class zza extends zzcg<zza, C0096zza> implements zzdq {
        private static volatile zzdz<zza> zzbg;
        private static final zza zzbir;
        private zzcn<zzb> zzbiq = zzcg.zzbb();

        /* renamed from: com.google.android.gms.internal.clearcut.zzgw$zza$zza  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0096zza extends zzcg.zza<zza, C0096zza> implements zzdq {
            private C0096zza() {
                super(zza.zzbir);
            }

            /* synthetic */ C0096zza(zzgx zzgxVar) {
                this();
            }
        }

        /* loaded from: classes.dex */
        public static final class zzb extends zzcg<zzb, C0097zza> implements zzdq {
            private static volatile zzdz<zzb> zzbg;
            private static final zzb zzbiv;
            private int zzbb;
            private String zzbis = "";
            private long zzbit;
            private long zzbiu;
            private int zzya;

            /* renamed from: com.google.android.gms.internal.clearcut.zzgw$zza$zzb$zza  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            public static final class C0097zza extends zzcg.zza<zzb, C0097zza> implements zzdq {
                private C0097zza() {
                    super(zzb.zzbiv);
                }

                /* synthetic */ C0097zza(zzgx zzgxVar) {
                    this();
                }

                public final C0097zza zzn(String str) {
                    zzbf();
                    ((zzb) this.zzjt).zzm(str);
                    return this;
                }

                public final C0097zza zzr(long j) {
                    zzbf();
                    ((zzb) this.zzjt).zzp(j);
                    return this;
                }

                public final C0097zza zzs(long j) {
                    zzbf();
                    ((zzb) this.zzjt).zzq(j);
                    return this;
                }
            }

            static {
                zzb zzbVar = new zzb();
                zzbiv = zzbVar;
                zzcg.zza(zzb.class, zzbVar);
            }

            private zzb() {
            }

            public static C0097zza zzfz() {
                return (C0097zza) ((zzcg.zza) zzbiv.zza(zzcg.zzg.zzkh, (Object) null, (Object) null));
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void zzm(String str) {
                Objects.requireNonNull(str);
                this.zzbb |= 2;
                this.zzbis = str;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void zzp(long j) {
                this.zzbb |= 4;
                this.zzbit = j;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void zzq(long j) {
                this.zzbb |= 8;
                this.zzbiu = j;
            }

            public final int getEventCode() {
                return this.zzya;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.clearcut.zzdz<com.google.android.gms.internal.clearcut.zzgw$zza$zzb>, com.google.android.gms.internal.clearcut.zzcg$zzb] */
            /* JADX WARN: Unknown variable types count: 1 */
            @Override // com.google.android.gms.internal.clearcut.zzcg
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
                /*
                    r1 = this;
                    int[] r3 = com.google.android.gms.internal.clearcut.zzgx.zzba
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
                    com.google.android.gms.internal.clearcut.zzdz<com.google.android.gms.internal.clearcut.zzgw$zza$zzb> r2 = com.google.android.gms.internal.clearcut.zzgw.zza.zzb.zzbg
                    if (r2 != 0) goto L_0x002f
                    java.lang.Class<com.google.android.gms.internal.clearcut.zzgw$zza$zzb> r3 = com.google.android.gms.internal.clearcut.zzgw.zza.zzb.class
                    monitor-enter(r3)
                    com.google.android.gms.internal.clearcut.zzdz<com.google.android.gms.internal.clearcut.zzgw$zza$zzb> r2 = com.google.android.gms.internal.clearcut.zzgw.zza.zzb.zzbg     // Catch: all -> 0x002c
                    if (r2 != 0) goto L_0x002a
                    com.google.android.gms.internal.clearcut.zzcg$zzb r2 = new com.google.android.gms.internal.clearcut.zzcg$zzb     // Catch: all -> 0x002c
                    com.google.android.gms.internal.clearcut.zzgw$zza$zzb r4 = com.google.android.gms.internal.clearcut.zzgw.zza.zzb.zzbiv     // Catch: all -> 0x002c
                    r2.<init>(r4)     // Catch: all -> 0x002c
                    com.google.android.gms.internal.clearcut.zzgw.zza.zzb.zzbg = r2     // Catch: all -> 0x002c
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
                    com.google.android.gms.internal.clearcut.zzgw$zza$zzb r2 = com.google.android.gms.internal.clearcut.zzgw.zza.zzb.zzbiv
                    return r2
                L_0x0033:
                    r2 = 5
                    java.lang.Object[] r2 = new java.lang.Object[r2]
                    r3 = 0
                    java.lang.String r0 = "zzbb"
                    r2[r3] = r0
                    java.lang.String r3 = "zzya"
                    r2[r4] = r3
                    r3 = 2
                    java.lang.String r4 = "zzbis"
                    r2[r3] = r4
                    r3 = 3
                    java.lang.String r4 = "zzbit"
                    r2[r3] = r4
                    r3 = 4
                    java.lang.String r4 = "zzbiu"
                    r2[r3] = r4
                    java.lang.String r3 = "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0005\u0000\u0000\u0000\u0001\u0004\u0000\u0002\b\u0001\u0003\u0002\u0002\u0004\u0002\u0003"
                    com.google.android.gms.internal.clearcut.zzgw$zza$zzb r4 = com.google.android.gms.internal.clearcut.zzgw.zza.zzb.zzbiv
                    java.lang.Object r2 = com.google.android.gms.internal.clearcut.zzcg.zza(r4, r3, r2)
                    return r2
                L_0x0057:
                    com.google.android.gms.internal.clearcut.zzgw$zza$zzb$zza r2 = new com.google.android.gms.internal.clearcut.zzgw$zza$zzb$zza
                    r2.<init>(r3)
                    return r2
                L_0x005d:
                    com.google.android.gms.internal.clearcut.zzgw$zza$zzb r2 = new com.google.android.gms.internal.clearcut.zzgw$zza$zzb
                    r2.<init>()
                    return r2
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.clearcut.zzgw.zza.zzb.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
            }

            public final boolean zzfv() {
                return (this.zzbb & 1) == 1;
            }

            public final String zzfw() {
                return this.zzbis;
            }

            public final long zzfx() {
                return this.zzbit;
            }

            public final long zzfy() {
                return this.zzbiu;
            }
        }

        static {
            zza zzaVar = new zza();
            zzbir = zzaVar;
            zzcg.zza(zza.class, zzaVar);
        }

        private zza() {
        }

        public static zza zzft() {
            return zzbir;
        }

        public static zza zzi(byte[] bArr) throws zzco {
            return (zza) zzcg.zzb(zzbir, bArr);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.clearcut.zzcg$zzb, com.google.android.gms.internal.clearcut.zzdz<com.google.android.gms.internal.clearcut.zzgw$zza>] */
        /* JADX WARN: Unknown variable types count: 1 */
        @Override // com.google.android.gms.internal.clearcut.zzcg
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object zza(int r2, java.lang.Object r3, java.lang.Object r4) {
            /*
                r1 = this;
                int[] r3 = com.google.android.gms.internal.clearcut.zzgx.zzba
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
                com.google.android.gms.internal.clearcut.zzdz<com.google.android.gms.internal.clearcut.zzgw$zza> r2 = com.google.android.gms.internal.clearcut.zzgw.zza.zzbg
                if (r2 != 0) goto L_0x002f
                java.lang.Class<com.google.android.gms.internal.clearcut.zzgw$zza> r3 = com.google.android.gms.internal.clearcut.zzgw.zza.class
                monitor-enter(r3)
                com.google.android.gms.internal.clearcut.zzdz<com.google.android.gms.internal.clearcut.zzgw$zza> r2 = com.google.android.gms.internal.clearcut.zzgw.zza.zzbg     // Catch: all -> 0x002c
                if (r2 != 0) goto L_0x002a
                com.google.android.gms.internal.clearcut.zzcg$zzb r2 = new com.google.android.gms.internal.clearcut.zzcg$zzb     // Catch: all -> 0x002c
                com.google.android.gms.internal.clearcut.zzgw$zza r4 = com.google.android.gms.internal.clearcut.zzgw.zza.zzbir     // Catch: all -> 0x002c
                r2.<init>(r4)     // Catch: all -> 0x002c
                com.google.android.gms.internal.clearcut.zzgw.zza.zzbg = r2     // Catch: all -> 0x002c
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
                com.google.android.gms.internal.clearcut.zzgw$zza r2 = com.google.android.gms.internal.clearcut.zzgw.zza.zzbir
                return r2
            L_0x0033:
                r2 = 2
                java.lang.Object[] r2 = new java.lang.Object[r2]
                r3 = 0
                java.lang.String r0 = "zzbiq"
                r2[r3] = r0
                java.lang.Class<com.google.android.gms.internal.clearcut.zzgw$zza$zzb> r3 = com.google.android.gms.internal.clearcut.zzgw.zza.zzb.class
                r2[r4] = r3
                java.lang.String r3 = "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0002\u0000\u0001\u0000\u0001\u001b"
                com.google.android.gms.internal.clearcut.zzgw$zza r4 = com.google.android.gms.internal.clearcut.zzgw.zza.zzbir
                java.lang.Object r2 = com.google.android.gms.internal.clearcut.zzcg.zza(r4, r3, r2)
                return r2
            L_0x0048:
                com.google.android.gms.internal.clearcut.zzgw$zza$zza r2 = new com.google.android.gms.internal.clearcut.zzgw$zza$zza
                r2.<init>(r3)
                return r2
            L_0x004e:
                com.google.android.gms.internal.clearcut.zzgw$zza r2 = new com.google.android.gms.internal.clearcut.zzgw$zza
                r2.<init>()
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.clearcut.zzgw.zza.zza(int, java.lang.Object, java.lang.Object):java.lang.Object");
        }

        public final List<zzb> zzfs() {
            return this.zzbiq;
        }
    }
}
