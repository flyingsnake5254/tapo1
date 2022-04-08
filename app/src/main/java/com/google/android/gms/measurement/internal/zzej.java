package com.google.android.gms.measurement.internal;

import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import com.tplink.libtpmediastatistics.SSLClient;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@19.0.0 */
/* loaded from: classes.dex */
public final class zzej implements Runnable {
    final /* synthetic */ int zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ Object zzc;
    final /* synthetic */ Object zzd;
    final /* synthetic */ Object zze;
    final /* synthetic */ zzem zzf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzej(zzem zzemVar, int i, String str, Object obj, Object obj2, Object obj3) {
        this.zzf = zzemVar;
        this.zza = i;
        this.zzb = str;
        this.zzc = obj;
        this.zzd = obj2;
        this.zze = obj3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        char c2;
        long j;
        char c3;
        long j2;
        zzfb zzd = this.zzf.zzs.zzd();
        if (zzd.zzu()) {
            c2 = this.zzf.zza;
            if (c2 == 0) {
                if (this.zzf.zzs.zzc().zzh()) {
                    zzem zzemVar = this.zzf;
                    zzemVar.zzs.zzat();
                    zzemVar.zza = 'C';
                } else {
                    zzem zzemVar2 = this.zzf;
                    zzemVar2.zzs.zzat();
                    zzemVar2.zza = 'c';
                }
            }
            j = this.zzf.zzb;
            if (j < 0) {
                zzem zzemVar3 = this.zzf;
                zzemVar3.zzs.zzc().zzf();
                zzemVar3.zzb = 42004L;
            }
            char charAt = "01VDIWEA?".charAt(this.zza);
            c3 = this.zzf.zza;
            j2 = this.zzf.zzb;
            String zzo = zzem.zzo(true, this.zzb, this.zzc, this.zzd, this.zze);
            StringBuilder sb = new StringBuilder(String.valueOf(zzo).length() + 24);
            sb.append(ExifInterface.GPS_MEASUREMENT_2D);
            sb.append(charAt);
            sb.append(c3);
            sb.append(j2);
            sb.append(SSLClient.COLON);
            sb.append(zzo);
            String sb2 = sb.toString();
            if (sb2.length() > 1024) {
                sb2 = this.zzb.substring(0, 1024);
            }
            zzez zzezVar = zzd.zzb;
            if (zzezVar != null) {
                zzezVar.zza(sb2, 1L);
                return;
            }
            return;
        }
        Log.println(6, this.zzf.zzn(), "Persisted config not initialized. Not logging error/warn");
    }
}
