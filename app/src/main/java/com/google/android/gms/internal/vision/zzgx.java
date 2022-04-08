package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzgx;
import com.google.android.gms.internal.vision.zzgx.zza;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
/* loaded from: classes.dex */
public abstract class zzgx<MessageType extends zzgx<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>> extends zzey<MessageType, BuilderType> {
    private static Map<Object, zzgx<?, ?>> zzwu = new ConcurrentHashMap();
    protected zzjr zzws = zzjr.zzih();
    private int zzwt = -1;

    /* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
    /* loaded from: classes.dex */
    public static abstract class zzb<MessageType extends zze<MessageType, BuilderType>, BuilderType extends zzb<MessageType, BuilderType>> extends zza<MessageType, BuilderType> implements zzij {
        protected zzb(MessageType messagetype) {
            super(messagetype);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.vision.zzgx.zza
        public void zzfz() {
            super.zzfz();
            MessageType messagetype = this.zzwq;
            ((zze) messagetype).zzwz = (zzgn) ((zze) messagetype).zzwz.clone();
        }

        @Override // com.google.android.gms.internal.vision.zzgx.zza
        public /* synthetic */ zzgx zzga() {
            return (zze) zzgc();
        }

        @Override // com.google.android.gms.internal.vision.zzgx.zza, com.google.android.gms.internal.vision.zzig
        public /* synthetic */ zzih zzgc() {
            if (this.zzwr) {
                return (zze) this.zzwq;
            }
            ((zze) this.zzwq).zzwz.zzdq();
            return (zze) super.zzgc();
        }
    }

    /* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
    /* loaded from: classes.dex */
    public static class zzc<T extends zzgx<T, ?>> extends zzfd<T> {
        private final T zzwp;

        public zzc(T t) {
            this.zzwp = t;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
    /* loaded from: classes.dex */
    public static final class zzd implements zzgp<zzd> {
        final zzkf zzww;
        final zzha<?> zzwv = null;
        final int number = 202056002;
        final boolean zzwx = true;
        final boolean zzwy = false;

        zzd(zzha<?> zzhaVar, int i, zzkf zzkfVar, boolean z, boolean z2) {
            this.zzww = zzkfVar;
        }

        @Override // java.lang.Comparable
        public final /* synthetic */ int compareTo(Object obj) {
            return this.number - ((zzd) obj).number;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.android.gms.internal.vision.zzgp
        public final zzig zza(zzig zzigVar, zzih zzihVar) {
            return ((zza) zzigVar).zza((zza) ((zzgx) zzihVar));
        }

        @Override // com.google.android.gms.internal.vision.zzgp
        public final int zzah() {
            return this.number;
        }

        @Override // com.google.android.gms.internal.vision.zzgp
        public final zzkf zzft() {
            return this.zzww;
        }

        @Override // com.google.android.gms.internal.vision.zzgp
        public final zzki zzfu() {
            return this.zzww.zziq();
        }

        @Override // com.google.android.gms.internal.vision.zzgp
        public final boolean zzfv() {
            return this.zzwx;
        }

        @Override // com.google.android.gms.internal.vision.zzgp
        public final boolean zzfw() {
            return this.zzwy;
        }

        @Override // com.google.android.gms.internal.vision.zzgp
        public final zzim zza(zzim zzimVar, zzim zzimVar2) {
            throw new UnsupportedOperationException();
        }
    }

    /* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
    /* loaded from: classes.dex */
    public static abstract class zze<MessageType extends zze<MessageType, BuilderType>, BuilderType extends zzb<MessageType, BuilderType>> extends zzgx<MessageType, BuilderType> implements zzij {
        protected zzgn<zzd> zzwz = zzgn.zzfo();

        /* JADX WARN: Type inference failed for: r1v6, types: [Type, java.util.List, java.util.ArrayList] */
        /* JADX WARN: Unknown variable types count: 1 */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final <Type> Type zzc(com.google.android.gms.internal.vision.zzgj<MessageType, Type> r4) {
            /*
                r3 = this;
                com.google.android.gms.internal.vision.zzgx$zzg r4 = com.google.android.gms.internal.vision.zzgx.zzb(r4)
                ContainingType extends com.google.android.gms.internal.vision.zzih r0 = r4.zzxo
                com.google.android.gms.internal.vision.zzih r1 = r3.zzge()
                com.google.android.gms.internal.vision.zzgx r1 = (com.google.android.gms.internal.vision.zzgx) r1
                if (r0 != r1) goto L_0x004f
                com.google.android.gms.internal.vision.zzgn<com.google.android.gms.internal.vision.zzgx$zzd> r0 = r3.zzwz
                com.google.android.gms.internal.vision.zzgx$zzd r1 = r4.zzxq
                java.lang.Object r0 = r0.zza(r1)
                if (r0 != 0) goto L_0x001b
                Type r4 = r4.zzgl
                return r4
            L_0x001b:
                com.google.android.gms.internal.vision.zzgx$zzd r1 = r4.zzxq
                boolean r2 = r1.zzwx
                if (r2 == 0) goto L_0x004a
                com.google.android.gms.internal.vision.zzkf r1 = r1.zzww
                com.google.android.gms.internal.vision.zzki r1 = r1.zziq()
                com.google.android.gms.internal.vision.zzki r2 = com.google.android.gms.internal.vision.zzki.ENUM
                if (r1 != r2) goto L_0x0049
                java.util.ArrayList r1 = new java.util.ArrayList
                r1.<init>()
                java.util.List r0 = (java.util.List) r0
                java.util.Iterator r0 = r0.iterator()
            L_0x0036:
                boolean r2 = r0.hasNext()
                if (r2 == 0) goto L_0x0048
                java.lang.Object r2 = r0.next()
                java.lang.Object r2 = r4.zzj(r2)
                r1.add(r2)
                goto L_0x0036
            L_0x0048:
                return r1
            L_0x0049:
                return r0
            L_0x004a:
                java.lang.Object r4 = r4.zzj(r0)
                return r4
            L_0x004f:
                java.lang.IllegalArgumentException r4 = new java.lang.IllegalArgumentException
                java.lang.String r0 = "This extension is for a different message type.  Please make sure that you are not suppressing any generics type warnings."
                r4.<init>(r0)
                throw r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.zzgx.zze.zzc(com.google.android.gms.internal.vision.zzgj):java.lang.Object");
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final zzgn<zzd> zzgl() {
            if (this.zzwz.isImmutable()) {
                this.zzwz = (zzgn) this.zzwz.clone();
            }
            return this.zzwz;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier removed */
    /* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
    /* loaded from: classes.dex */
    public static final class zzf {
        public static final int zzxa = 1;
        public static final int zzxb = 2;
        public static final int zzxc = 3;
        public static final int zzxd = 4;
        public static final int zzxe = 5;
        public static final int zzxf = 6;
        public static final int zzxg = 7;
        public static final int zzxi = 1;
        public static final int zzxj = 2;
        public static final int zzxl = 1;
        public static final int zzxm = 2;
        private static final /* synthetic */ int[] zzxh = {1, 2, 3, 4, 5, 6, 7};
        private static final /* synthetic */ int[] zzxk = {1, 2};
        private static final /* synthetic */ int[] zzxn = {1, 2};

        public static int[] values$50KLMJ33DTMIUPRFDTJMOP9FE1P6UT3FC9QMCBQ7CLN6ASJ1EHIM8JB5EDPM2PR59HKN8P949LIN8Q3FCHA6UIBEEPNMMP9R0() {
            return (int[]) zzxh.clone();
        }
    }

    /* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
    /* loaded from: classes.dex */
    public static class zzg<ContainingType extends zzih, Type> extends zzgj<ContainingType, Type> {
        final Type zzgl;
        final ContainingType zzxo;
        final zzih zzxp;
        final zzd zzxq;

        zzg(ContainingType containingtype, Type type, zzih zzihVar, zzd zzdVar, Class cls) {
            if (containingtype == null) {
                throw new IllegalArgumentException("Null containingTypeDefaultInstance");
            } else if (zzdVar.zzww == zzkf.MESSAGE && zzihVar == null) {
                throw new IllegalArgumentException("Null messageDefaultInstance");
            } else {
                this.zzxo = containingtype;
                this.zzgl = type;
                this.zzxp = zzihVar;
                this.zzxq = zzdVar;
            }
        }

        final Object zzj(Object obj) {
            return this.zzxq.zzww.zziq() == zzki.ENUM ? this.zzxq.zzwv.zzh(((Integer) obj).intValue()) : obj;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <T extends zzgx<?, ?>> void zza(Class<T> cls, T t) {
        zzwu.put(cls, t);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T extends zzgx<?, ?>> T zzd(Class<T> cls) {
        zzgx<?, ?> zzgxVar = zzwu.get(cls);
        if (zzgxVar == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                zzgxVar = zzwu.get(cls);
            } catch (ClassNotFoundException e2) {
                throw new IllegalStateException("Class initialization cannot fail.", e2);
            }
        }
        if (zzgxVar == null) {
            zzgxVar = (T) ((zzgx) ((zzgx) zzju.zzh(cls)).zza(zzf.zzxf, (Object) null, (Object) null));
            if (zzgxVar != null) {
                zzwu.put(cls, zzgxVar);
            } else {
                throw new IllegalStateException();
            }
        }
        return (T) zzgxVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Type inference failed for: r0v0, types: [com.google.android.gms.internal.vision.zzhc, com.google.android.gms.internal.vision.zzgz] */
    public static zzhc zzgh() {
        return zzgz.zzgm();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <E> zzhe<E> zzgi() {
        return zziv.zzhs();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return zzis.zzhp().zzv(this).equals(this, (zzgx) obj);
        }
        return false;
    }

    public int hashCode() {
        int i = this.zzrx;
        if (i != 0) {
            return i;
        }
        int hashCode = zzis.zzhp().zzv(this).hashCode(this);
        this.zzrx = hashCode;
        return hashCode;
    }

    @Override // com.google.android.gms.internal.vision.zzij
    public final boolean isInitialized() {
        return zza(this, true);
    }

    public String toString() {
        return zzii.zza(this, super.toString());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract Object zza(int i, Object obj, Object obj2);

    @Override // com.google.android.gms.internal.vision.zzey
    final void zzae(int i) {
        this.zzwt = i;
    }

    @Override // com.google.android.gms.internal.vision.zzih
    public final void zzb(zzgf zzgfVar) throws IOException {
        zzis.zzhp().zzv(this).zza(this, zzgh.zza(zzgfVar));
    }

    @Override // com.google.android.gms.internal.vision.zzey
    final int zzdm() {
        return this.zzwt;
    }

    @Override // com.google.android.gms.internal.vision.zzij
    public final /* synthetic */ zzih zzge() {
        return (zzgx) zza(zzf.zzxf, (Object) null, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final <MessageType extends zzgx<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>> BuilderType zzgf() {
        return (BuilderType) ((zza) zza(zzf.zzxe, (Object) null, (Object) null));
    }

    @Override // com.google.android.gms.internal.vision.zzih
    public final int zzgg() {
        if (this.zzwt == -1) {
            this.zzwt = zzis.zzhp().zzv(this).zzs(this);
        }
        return this.zzwt;
    }

    @Override // com.google.android.gms.internal.vision.zzih
    public final /* synthetic */ zzig zzgj() {
        zza zzaVar = (zza) zza(zzf.zzxe, (Object) null, (Object) null);
        zzaVar.zza((zza) this);
        return zzaVar;
    }

    @Override // com.google.android.gms.internal.vision.zzih
    public final /* synthetic */ zzig zzgk() {
        return (zza) zza(zzf.zzxe, (Object) null, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static Object zza(zzih zzihVar, String str, Object[] objArr) {
        return new zziu(zzihVar, str, objArr);
    }

    public static <ContainingType extends zzih, Type> zzg<ContainingType, Type> zza(ContainingType containingtype, zzih zzihVar, zzha<?> zzhaVar, int i, zzkf zzkfVar, boolean z, Class cls) {
        return new zzg<>(containingtype, Collections.emptyList(), zzihVar, new zzd(null, 202056002, zzkfVar, true, false), cls);
    }

    /* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
    /* loaded from: classes.dex */
    public static abstract class zza<MessageType extends zzgx<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>> extends zzfb<MessageType, BuilderType> {
        private final MessageType zzwp;
        protected MessageType zzwq;
        protected boolean zzwr = false;

        /* JADX INFO: Access modifiers changed from: protected */
        public zza(MessageType messagetype) {
            this.zzwp = messagetype;
            this.zzwq = (MessageType) ((zzgx) messagetype.zza(zzf.zzxd, null, null));
        }

        private final BuilderType zzb(byte[] bArr, int i, int i2, zzgi zzgiVar) throws zzhh {
            if (this.zzwr) {
                zzfz();
                this.zzwr = false;
            }
            try {
                zzis.zzhp().zzv(this.zzwq).zza(this.zzwq, bArr, 0, i2 + 0, new zzfg(zzgiVar));
                return this;
            } catch (zzhh e2) {
                throw e2;
            } catch (IOException e3) {
                throw new RuntimeException("Reading from byte array should not throw IOException.", e3);
            } catch (IndexOutOfBoundsException unused) {
                throw zzhh.zzgn();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.android.gms.internal.vision.zzfb
        public /* synthetic */ Object clone() throws CloneNotSupportedException {
            zza zzaVar = (zza) this.zzwp.zza(zzf.zzxe, null, null);
            zzaVar.zza((zza) ((zzgx) zzgc()));
            return zzaVar;
        }

        @Override // com.google.android.gms.internal.vision.zzij
        public final boolean isInitialized() {
            return zzgx.zza(this.zzwq, false);
        }

        public final BuilderType zza(MessageType messagetype) {
            if (this.zzwr) {
                zzfz();
                this.zzwr = false;
            }
            zza(this.zzwq, messagetype);
            return this;
        }

        @Override // com.google.android.gms.internal.vision.zzfb
        public final /* synthetic */ zzfb zzdo() {
            return (zza) clone();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public void zzfz() {
            MessageType messagetype = (MessageType) ((zzgx) this.zzwq.zza(zzf.zzxd, null, null));
            zza(messagetype, this.zzwq);
            this.zzwq = messagetype;
        }

        /* renamed from: zzga */
        public MessageType zzgc() {
            if (this.zzwr) {
                return this.zzwq;
            }
            MessageType messagetype = this.zzwq;
            zzis.zzhp().zzv(messagetype).zzh(messagetype);
            this.zzwr = true;
            return this.zzwq;
        }

        /* renamed from: zzgb */
        public final MessageType zzgd() {
            MessageType messagetype = (MessageType) ((zzgx) zzgc());
            if (messagetype.isInitialized()) {
                return messagetype;
            }
            throw new zzjp(messagetype);
        }

        @Override // com.google.android.gms.internal.vision.zzij
        public final /* synthetic */ zzih zzge() {
            return this.zzwp;
        }

        private static void zza(MessageType messagetype, MessageType messagetype2) {
            zzis.zzhp().zzv(messagetype).zzd(messagetype, messagetype2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.android.gms.internal.vision.zzfb
        protected final /* synthetic */ zzfb zza(zzey zzeyVar) {
            return zza((zza<MessageType, BuilderType>) ((zzgx) zzeyVar));
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: zzb */
        public final BuilderType zza(zzfy zzfyVar, zzgi zzgiVar) throws IOException {
            if (this.zzwr) {
                zzfz();
                this.zzwr = false;
            }
            try {
                zzis.zzhp().zzv(this.zzwq).zza(this.zzwq, zzgd.zza(zzfyVar), zzgiVar);
                return this;
            } catch (RuntimeException e2) {
                if (e2.getCause() instanceof IOException) {
                    throw ((IOException) e2.getCause());
                }
                throw e2;
            }
        }

        @Override // com.google.android.gms.internal.vision.zzfb
        public final /* synthetic */ zzfb zza(byte[] bArr, int i, int i2, zzgi zzgiVar) throws zzhh {
            return zzb(bArr, 0, i2, zzgiVar);
        }
    }

    private static <T extends zzgx<T, ?>> T zzb(T t) throws zzhh {
        if (t == null || t.isInitialized()) {
            return t;
        }
        throw new zzhh(new zzjp(t).getMessage()).zzg(t);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object zza(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e2) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e2);
        } catch (InvocationTargetException e3) {
            Throwable cause = e3.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            } else if (cause instanceof Error) {
                throw ((Error) cause);
            } else {
                throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <MessageType extends zze<MessageType, BuilderType>, BuilderType extends zzb<MessageType, BuilderType>, T> zzg<MessageType, T> zza(zzgj<MessageType, T> zzgjVar) {
        return (zzg) zzgjVar;
    }

    protected static final <T extends zzgx<T, ?>> boolean zza(T t, boolean z) {
        byte byteValue = ((Byte) t.zza(zzf.zzxa, null, null)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean zzu = zzis.zzhp().zzv(t).zzu(t);
        if (z) {
            t.zza(zzf.zzxb, zzu ? t : null, null);
        }
        return zzu;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <E> zzhe<E> zza(zzhe<E> zzheVar) {
        int size = zzheVar.size();
        return zzheVar.zzah(size == 0 ? 10 : size << 1);
    }

    private static <T extends zzgx<T, ?>> T zza(T t, byte[] bArr, int i, int i2, zzgi zzgiVar) throws zzhh {
        T t2 = (T) ((zzgx) t.zza(zzf.zzxd, null, null));
        try {
            zziw zzv = zzis.zzhp().zzv(t2);
            zzv.zza(t2, bArr, 0, i2, new zzfg(zzgiVar));
            zzv.zzh(t2);
            if (t2.zzrx == 0) {
                return t2;
            }
            throw new RuntimeException();
        } catch (IOException e2) {
            if (e2.getCause() instanceof zzhh) {
                throw ((zzhh) e2.getCause());
            }
            throw new zzhh(e2.getMessage()).zzg(t2);
        } catch (IndexOutOfBoundsException unused) {
            throw zzhh.zzgn().zzg(t2);
        }
    }

    protected static <T extends zzgx<T, ?>> T zza(T t, byte[] bArr) throws zzhh {
        return (T) zzb(zza(t, bArr, 0, bArr.length, zzgi.zzfm()));
    }

    protected static <T extends zzgx<T, ?>> T zza(T t, byte[] bArr, zzgi zzgiVar) throws zzhh {
        return (T) zzb(zza(t, bArr, 0, bArr.length, zzgiVar));
    }
}
