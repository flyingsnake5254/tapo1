package com.google.android.gms.internal.mlkit_vision_common;

import com.google.android.gms.internal.mlkit_vision_common.zzda;
import com.google.android.gms.internal.mlkit_vision_common.zzdd;

/* compiled from: com.google.mlkit:vision-common@@16.0.0 */
/* loaded from: classes.dex */
public abstract class zzdd<MessageType extends zzda<MessageType, BuilderType>, BuilderType extends zzdd<MessageType, BuilderType>> implements zzfu {
    protected abstract BuilderType zza(MessageType messagetype);

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.mlkit_vision_common.zzfu
    public final /* synthetic */ zzfu zza(zzfv zzfvVar) {
        if (zzn().getClass().isInstance(zzfvVar)) {
            return zza((zzdd<MessageType, BuilderType>) ((zzda) zzfvVar));
        }
        throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
    }

    /* renamed from: zzb */
    public abstract BuilderType clone();
}
