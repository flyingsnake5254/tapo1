package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzey;
import com.google.android.gms.internal.vision.zzfb;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
/* loaded from: classes.dex */
public abstract class zzfb<MessageType extends zzey<MessageType, BuilderType>, BuilderType extends zzfb<MessageType, BuilderType>> implements zzig {
    protected abstract BuilderType zza(MessageType messagetype);

    public abstract BuilderType zza(zzfy zzfyVar, zzgi zzgiVar) throws IOException;

    public BuilderType zza(byte[] bArr, int i, int i2, zzgi zzgiVar) throws zzhh {
        try {
            zzfy zza = zzfy.zza(bArr, 0, i2, false);
            zza(zza, zzgiVar);
            zza.zzar(0);
            return this;
        } catch (zzhh e2) {
            throw e2;
        } catch (IOException e3) {
            String name = getClass().getName();
            StringBuilder sb = new StringBuilder(name.length() + 60 + "byte array".length());
            sb.append("Reading ");
            sb.append(name);
            sb.append(" from a ");
            sb.append("byte array");
            sb.append(" threw an IOException (should never happen).");
            throw new RuntimeException(sb.toString(), e3);
        }
    }

    /* renamed from: zzdo */
    public abstract BuilderType clone();

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.vision.zzig
    public final /* synthetic */ zzig zza(zzih zzihVar) {
        if (zzge().getClass().isInstance(zzihVar)) {
            return zza((zzfb<MessageType, BuilderType>) ((zzey) zzihVar));
        }
        throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
    }
}
