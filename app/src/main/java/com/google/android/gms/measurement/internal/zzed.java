package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@19.0.0 */
/* loaded from: classes.dex */
public interface zzed extends IInterface {
    void zzd(zzas zzasVar, zzp zzpVar) throws RemoteException;

    void zze(zzkq zzkqVar, zzp zzpVar) throws RemoteException;

    void zzf(zzp zzpVar) throws RemoteException;

    void zzg(zzas zzasVar, String str, @Nullable String str2) throws RemoteException;

    void zzh(zzp zzpVar) throws RemoteException;

    @Nullable
    List<zzkq> zzi(zzp zzpVar, boolean z) throws RemoteException;

    @Nullable
    byte[] zzj(zzas zzasVar, String str) throws RemoteException;

    void zzk(long j, @Nullable String str, @Nullable String str2, String str3) throws RemoteException;

    @Nullable
    String zzl(zzp zzpVar) throws RemoteException;

    void zzm(zzaa zzaaVar, zzp zzpVar) throws RemoteException;

    void zzn(zzaa zzaaVar) throws RemoteException;

    List<zzkq> zzo(@Nullable String str, @Nullable String str2, boolean z, zzp zzpVar) throws RemoteException;

    List<zzkq> zzp(String str, @Nullable String str2, @Nullable String str3, boolean z) throws RemoteException;

    List<zzaa> zzq(@Nullable String str, @Nullable String str2, zzp zzpVar) throws RemoteException;

    List<zzaa> zzr(String str, @Nullable String str2, @Nullable String str3) throws RemoteException;

    void zzs(zzp zzpVar) throws RemoteException;

    void zzt(Bundle bundle, zzp zzpVar) throws RemoteException;

    void zzu(zzp zzpVar) throws RemoteException;
}
