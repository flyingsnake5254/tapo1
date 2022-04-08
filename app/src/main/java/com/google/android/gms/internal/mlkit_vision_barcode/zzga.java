package com.google.android.gms.internal.mlkit_vision_barcode;

import com.google.android.gms.internal.mlkit_vision_barcode.zzga;
import com.google.android.gms.internal.mlkit_vision_barcode.zzga.zzb;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
/* loaded from: classes.dex */
public abstract class zzga<MessageType extends zzga<MessageType, BuilderType>, BuilderType extends zzb<MessageType, BuilderType>> extends zzer<MessageType, BuilderType> {
    private static Map<Object, zzga<?, ?>> zzd = new ConcurrentHashMap();
    protected zzis zzb = zzis.zza();
    private int zzc = -1;

    /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
    /* loaded from: classes.dex */
    public static class zza<T extends zzga<T, ?>> extends zzes<T> {
        private final T zza;

        public zza(T t) {
            this.zza = t;
        }
    }

    /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
    /* loaded from: classes.dex */
    public static abstract class zzc<MessageType extends zzc<MessageType, BuilderType>, BuilderType extends zzd<MessageType, BuilderType>> extends zzga<MessageType, BuilderType> implements zzhm {
        protected zzfs<zzf> zzc = zzfs.zza();
    }

    /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
    /* loaded from: classes.dex */
    public static abstract class zzd<MessageType extends zzc<MessageType, BuilderType>, BuilderType extends zzd<MessageType, BuilderType>> extends zzb<MessageType, BuilderType> implements zzhm {
        /* JADX INFO: Access modifiers changed from: protected */
        public zzd(MessageType messagetype) {
            super(messagetype);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzga.zzb
        public void zzc() {
            super.zzc();
            MessageType messagetype = this.zza;
            ((zzc) messagetype).zzc = (zzfs) ((zzc) messagetype).zzc.clone();
        }

        @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzga.zzb
        public /* synthetic */ zzga zzd() {
            return (zzc) zzf();
        }

        @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzga.zzb, com.google.android.gms.internal.mlkit_vision_barcode.zzhn
        public /* synthetic */ zzhk zzf() {
            if (this.zzb) {
                return (zzc) this.zza;
            }
            ((zzc) this.zza).zzc.zzb();
            return (zzc) super.zzf();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier removed */
    /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
    /* loaded from: classes.dex */
    public static final class zze {
        public static final int zza = 1;
        public static final int zzb = 2;
        public static final int zzc = 3;
        public static final int zzd = 4;
        public static final int zze = 5;
        public static final int zzf = 6;
        public static final int zzg = 7;
        public static final int zzh = 1;
        public static final int zzi = 2;
        public static final int zzj = 1;
        public static final int zzk = 2;
        private static final /* synthetic */ int[] zzl = {1, 2, 3, 4, 5, 6, 7};
        private static final /* synthetic */ int[] zzm = {1, 2};
        private static final /* synthetic */ int[] zzn = {1, 2};

        public static int[] zza() {
            return (int[]) zzl.clone();
        }
    }

    /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
    /* loaded from: classes.dex */
    static final class zzf implements zzfu<zzf> {
        @Override // java.lang.Comparable
        public final /* synthetic */ int compareTo(Object obj) {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzfu
        public final int zza() {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzfu
        public final zzjh zzb() {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzfu
        public final zzjk zzc() {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzfu
        public final boolean zzd() {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzfu
        public final boolean zze() {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzfu
        public final zzhn zza(zzhn zzhnVar, zzhk zzhkVar) {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzfu
        public final zzhq zza(zzhq zzhqVar, zzhq zzhqVar2) {
            throw new NoSuchMethodError();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static zzgj zzk() {
        return zzgd.zzd();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.google.android.gms.internal.mlkit_vision_barcode.zzgg, com.google.android.gms.internal.mlkit_vision_barcode.zzfy] */
    protected static zzgg zzl() {
        return zzfy.zzd();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <E> zzgl<E> zzm() {
        return zzhz.zzd();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return zzhw.zza().zza((zzhw) this).zza(this, (zzga) obj);
        }
        return false;
    }

    public int hashCode() {
        int i = this.zza;
        if (i != 0) {
            return i;
        }
        int zza2 = zzhw.zza().zza((zzhw) this).zza(this);
        this.zza = zza2;
        return zza2;
    }

    public String toString() {
        return zzhp.zza(this, super.toString());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final <MessageType extends zzga<MessageType, BuilderType>, BuilderType extends zzb<MessageType, BuilderType>> BuilderType zza(MessageType messagetype) {
        return (BuilderType) zzh().zza(messagetype);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract Object zza(int i, Object obj, Object obj2);

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzer
    final int zzg() {
        return this.zzc;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final <MessageType extends zzga<MessageType, BuilderType>, BuilderType extends zzb<MessageType, BuilderType>> BuilderType zzh() {
        return (BuilderType) ((zzb) zza(zze.zze, (Object) null, (Object) null));
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzhm
    public final boolean zzi() {
        return zza(this, true);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzhk
    public final int zzj() {
        if (this.zzc == -1) {
            this.zzc = zzhw.zza().zza((zzhw) this).zzb(this);
        }
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzhk
    public final /* synthetic */ zzhn zzn() {
        zzb zzbVar = (zzb) zza(zze.zze, (Object) null, (Object) null);
        zzbVar.zza((zzb) this);
        return zzbVar;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzhm
    public final /* synthetic */ zzhk zzo() {
        return (zzga) zza(zze.zzf, (Object) null, (Object) null);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzer
    final void zza(int i) {
        this.zzc = i;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzhk
    public final void zza(zzfn zzfnVar) throws IOException {
        zzhw.zza().zza((zzhw) this).zza((zzib) this, (zzjn) zzfp.zza(zzfnVar));
    }

    /* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
    /* loaded from: classes.dex */
    public static abstract class zzb<MessageType extends zzga<MessageType, BuilderType>, BuilderType extends zzb<MessageType, BuilderType>> extends zzeq<MessageType, BuilderType> {
        protected MessageType zza;
        protected boolean zzb = false;
        private final MessageType zzc;

        /* JADX INFO: Access modifiers changed from: protected */
        public zzb(MessageType messagetype) {
            this.zzc = messagetype;
            this.zza = (MessageType) ((zzga) messagetype.zza(zze.zzd, null, null));
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzeq
        public /* synthetic */ Object clone() throws CloneNotSupportedException {
            zzb zzbVar = (zzb) this.zzc.zza(zze.zze, null, null);
            zzbVar.zza((zzb) ((zzga) zzf()));
            return zzbVar;
        }

        public final BuilderType zza(MessageType messagetype) {
            if (this.zzb) {
                zzc();
                this.zzb = false;
            }
            zza(this.zza, messagetype);
            return this;
        }

        @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzeq
        public final /* synthetic */ zzeq zzb() {
            return (zzb) clone();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public void zzc() {
            MessageType messagetype = (MessageType) ((zzga) this.zza.zza(zze.zzd, null, null));
            zza(messagetype, this.zza);
            this.zza = messagetype;
        }

        /* renamed from: zzd */
        public MessageType zzf() {
            if (this.zzb) {
                return this.zza;
            }
            MessageType messagetype = this.zza;
            zzhw.zza().zza((zzhw) messagetype).zzc(messagetype);
            this.zzb = true;
            return this.zza;
        }

        /* renamed from: zze */
        public final MessageType zzg() {
            MessageType messagetype = (MessageType) ((zzga) zzf());
            if (messagetype.zzi()) {
                return messagetype;
            }
            throw new zziq(messagetype);
        }

        @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzhm
        public final boolean zzi() {
            return zzga.zza(this.zza, false);
        }

        @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzhm
        public final /* synthetic */ zzhk zzo() {
            return this.zzc;
        }

        private static void zza(MessageType messagetype, MessageType messagetype2) {
            zzhw.zza().zza((zzhw) messagetype).zzb(messagetype, messagetype2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzeq
        protected final /* synthetic */ zzeq zza(zzer zzerVar) {
            return zza((zzb<MessageType, BuilderType>) ((zzga) zzerVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T extends zzga<?, ?>> T zza(Class<T> cls) {
        zzga<?, ?> zzgaVar = zzd.get(cls);
        if (zzgaVar == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                zzgaVar = zzd.get(cls);
            } catch (ClassNotFoundException e2) {
                throw new IllegalStateException("Class initialization cannot fail.", e2);
            }
        }
        if (zzgaVar == null) {
            zzgaVar = (T) ((zzga) ((zzga) zziz.zza(cls)).zza(zze.zzf, (Object) null, (Object) null));
            if (zzgaVar != null) {
                zzd.put(cls, zzgaVar);
            } else {
                throw new IllegalStateException();
            }
        }
        return (T) zzgaVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <T extends zzga<?, ?>> void zza(Class<T> cls, T t) {
        zzd.put(cls, t);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static Object zza(zzhk zzhkVar, String str, Object[] objArr) {
        return new zzhy(zzhkVar, str, objArr);
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

    protected static final <T extends zzga<T, ?>> boolean zza(T t, boolean z) {
        byte byteValue = ((Byte) t.zza(zze.zza, null, null)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean zzd2 = zzhw.zza().zza((zzhw) t).zzd(t);
        if (z) {
            t.zza(zze.zzb, zzd2 ? t : null, null);
        }
        return zzd2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static zzgj zza(zzgj zzgjVar) {
        int size = zzgjVar.size();
        return zzgjVar.zzb(size == 0 ? 10 : size << 1);
    }
}
