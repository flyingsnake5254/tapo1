package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzin;
import com.google.android.gms.internal.measurement.zzio;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement-base@@19.0.0 */
/* loaded from: classes.dex */
public abstract class zzio<MessageType extends zzio<MessageType, BuilderType>, BuilderType extends zzin<MessageType, BuilderType>> implements zzli {
    protected int zzb = 0;

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public static <T> void zzbs(Iterable<T> iterable, List<? super T> list) {
        zzkl.zza(iterable);
        if (iterable instanceof zzks) {
            List<?> zzh = ((zzks) iterable).zzh();
            zzks zzksVar = (zzks) list;
            int size = list.size();
            for (Object obj : zzh) {
                if (obj == null) {
                    int size2 = zzksVar.size();
                    StringBuilder sb = new StringBuilder(37);
                    sb.append("Element at index ");
                    sb.append(size2 - size);
                    sb.append(" is null.");
                    String sb2 = sb.toString();
                    int size3 = zzksVar.size();
                    while (true) {
                        size3--;
                        if (size3 < size) {
                            break;
                        }
                        zzksVar.remove(size3);
                    }
                    throw new NullPointerException(sb2);
                } else if (obj instanceof zzjd) {
                    zzksVar.zzf((zzjd) obj);
                } else {
                    zzksVar.add((String) obj);
                }
            }
        } else if (!(iterable instanceof zzlp)) {
            if ((list instanceof ArrayList) && (iterable instanceof Collection)) {
                ((ArrayList) list).ensureCapacity(list.size() + iterable.size());
            }
            int size4 = list.size();
            for (T t : iterable) {
                if (t == 0) {
                    int size5 = list.size();
                    StringBuilder sb3 = new StringBuilder(37);
                    sb3.append("Element at index ");
                    sb3.append(size5 - size4);
                    sb3.append(" is null.");
                    String sb4 = sb3.toString();
                    int size6 = list.size();
                    while (true) {
                        size6--;
                        if (size6 < size4) {
                            break;
                        }
                        list.remove(size6);
                    }
                    throw new NullPointerException(sb4);
                }
                list.add(t);
            }
        } else {
            list.addAll(iterable);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzli
    public final zzjd zzbo() {
        try {
            int zzbw = zzbw();
            zzjd zzjdVar = zzjd.zzb;
            byte[] bArr = new byte[zzbw];
            zzjk zzt = zzjk.zzt(bArr);
            zzbv(zzt);
            zzt.zzC();
            return new zzjb(bArr);
        } catch (IOException e2) {
            String name = getClass().getName();
            StringBuilder sb = new StringBuilder(name.length() + 72);
            sb.append("Serializing ");
            sb.append(name);
            sb.append(" to a ByteString threw an IOException (should never happen).");
            throw new RuntimeException(sb.toString(), e2);
        }
    }

    public final byte[] zzbp() {
        try {
            byte[] bArr = new byte[zzbw()];
            zzjk zzt = zzjk.zzt(bArr);
            zzbv(zzt);
            zzt.zzC();
            return bArr;
        } catch (IOException e2) {
            String name = getClass().getName();
            StringBuilder sb = new StringBuilder(name.length() + 72);
            sb.append("Serializing ");
            sb.append(name);
            sb.append(" to a byte array threw an IOException (should never happen).");
            throw new RuntimeException(sb.toString(), e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int zzbq() {
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void zzbr(int i) {
        throw null;
    }
}
