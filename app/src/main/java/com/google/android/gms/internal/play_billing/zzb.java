package com.google.android.gms.internal.play_billing;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;

/* compiled from: com.android.billingclient:billing@@3.0.3 */
/* loaded from: classes.dex */
public final class zzb extends zze implements zzd {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzb(IBinder iBinder) {
        super(iBinder, "com.android.vending.billing.IInAppBillingService");
    }

    @Override // com.google.android.gms.internal.play_billing.zzd
    public final int zza(int i, String str, String str2) throws RemoteException {
        Parcel zzo = zzo();
        zzo.writeInt(i);
        zzo.writeString(str);
        zzo.writeString(str2);
        Parcel zzp = zzp(1, zzo);
        int readInt = zzp.readInt();
        zzp.recycle();
        return readInt;
    }

    @Override // com.google.android.gms.internal.play_billing.zzd
    public final Bundle zzb(int i, String str, String str2, Bundle bundle) throws RemoteException {
        Parcel zzo = zzo();
        zzo.writeInt(3);
        zzo.writeString(str);
        zzo.writeString(str2);
        zzg.zzb(zzo, bundle);
        Parcel zzp = zzp(2, zzo);
        Bundle bundle2 = (Bundle) zzg.zza(zzp, Bundle.CREATOR);
        zzp.recycle();
        return bundle2;
    }

    @Override // com.google.android.gms.internal.play_billing.zzd
    public final Bundle zzc(int i, String str, String str2, String str3, String str4) throws RemoteException {
        Parcel zzo = zzo();
        zzo.writeInt(3);
        zzo.writeString(str);
        zzo.writeString(str2);
        zzo.writeString(str3);
        zzo.writeString(null);
        Parcel zzp = zzp(3, zzo);
        Bundle bundle = (Bundle) zzg.zza(zzp, Bundle.CREATOR);
        zzp.recycle();
        return bundle;
    }

    @Override // com.google.android.gms.internal.play_billing.zzd
    public final Bundle zzd(int i, String str, String str2, String str3) throws RemoteException {
        Parcel zzo = zzo();
        zzo.writeInt(3);
        zzo.writeString(str);
        zzo.writeString(str2);
        zzo.writeString(str3);
        Parcel zzp = zzp(4, zzo);
        Bundle bundle = (Bundle) zzg.zza(zzp, Bundle.CREATOR);
        zzp.recycle();
        return bundle;
    }

    @Override // com.google.android.gms.internal.play_billing.zzd
    public final int zze(int i, String str, String str2) throws RemoteException {
        Parcel zzo = zzo();
        zzo.writeInt(3);
        zzo.writeString(str);
        zzo.writeString(str2);
        Parcel zzp = zzp(5, zzo);
        int readInt = zzp.readInt();
        zzp.recycle();
        return readInt;
    }

    @Override // com.google.android.gms.internal.play_billing.zzd
    public final Bundle zzf(int i, String str, List<String> list, String str2, String str3, String str4) throws RemoteException {
        Parcel zzo = zzo();
        zzo.writeInt(5);
        zzo.writeString(str);
        zzo.writeStringList(list);
        zzo.writeString(str2);
        zzo.writeString("subs");
        zzo.writeString(null);
        Parcel zzp = zzp(7, zzo);
        Bundle bundle = (Bundle) zzg.zza(zzp, Bundle.CREATOR);
        zzp.recycle();
        return bundle;
    }

    @Override // com.google.android.gms.internal.play_billing.zzd
    public final Bundle zzg(int i, String str, String str2, String str3, String str4, Bundle bundle) throws RemoteException {
        Parcel zzo = zzo();
        zzo.writeInt(i);
        zzo.writeString(str);
        zzo.writeString(str2);
        zzo.writeString(str3);
        zzo.writeString(null);
        zzg.zzb(zzo, bundle);
        Parcel zzp = zzp(8, zzo);
        Bundle bundle2 = (Bundle) zzg.zza(zzp, Bundle.CREATOR);
        zzp.recycle();
        return bundle2;
    }

    @Override // com.google.android.gms.internal.play_billing.zzd
    public final Bundle zzh(int i, String str, String str2, String str3, Bundle bundle) throws RemoteException {
        Parcel zzo = zzo();
        zzo.writeInt(6);
        zzo.writeString(str);
        zzo.writeString(str2);
        zzo.writeString(str3);
        zzg.zzb(zzo, bundle);
        Parcel zzp = zzp(9, zzo);
        Bundle bundle2 = (Bundle) zzg.zza(zzp, Bundle.CREATOR);
        zzp.recycle();
        return bundle2;
    }

    @Override // com.google.android.gms.internal.play_billing.zzd
    public final int zzi(int i, String str, String str2, Bundle bundle) throws RemoteException {
        Parcel zzo = zzo();
        zzo.writeInt(7);
        zzo.writeString(str);
        zzo.writeString(str2);
        zzg.zzb(zzo, bundle);
        Parcel zzp = zzp(10, zzo);
        int readInt = zzp.readInt();
        zzp.recycle();
        return readInt;
    }

    @Override // com.google.android.gms.internal.play_billing.zzd
    public final Bundle zzj(int i, String str, String str2, String str3, Bundle bundle) throws RemoteException {
        Parcel zzo = zzo();
        zzo.writeInt(8);
        zzo.writeString(str);
        zzo.writeString(str2);
        zzo.writeString("subs");
        zzg.zzb(zzo, bundle);
        Parcel zzp = zzp(801, zzo);
        Bundle bundle2 = (Bundle) zzg.zza(zzp, Bundle.CREATOR);
        zzp.recycle();
        return bundle2;
    }

    @Override // com.google.android.gms.internal.play_billing.zzd
    public final Bundle zzk(int i, String str, String str2, String str3, Bundle bundle) throws RemoteException {
        Parcel zzo = zzo();
        zzo.writeInt(9);
        zzo.writeString(str);
        zzo.writeString(str2);
        zzo.writeString(str3);
        zzg.zzb(zzo, bundle);
        Parcel zzp = zzp(11, zzo);
        Bundle bundle2 = (Bundle) zzg.zza(zzp, Bundle.CREATOR);
        zzp.recycle();
        return bundle2;
    }

    @Override // com.google.android.gms.internal.play_billing.zzd
    public final Bundle zzl(int i, String str, String str2, Bundle bundle) throws RemoteException {
        Parcel zzo = zzo();
        zzo.writeInt(9);
        zzo.writeString(str);
        zzo.writeString(str2);
        zzg.zzb(zzo, bundle);
        Parcel zzp = zzp(12, zzo);
        Bundle bundle2 = (Bundle) zzg.zza(zzp, Bundle.CREATOR);
        zzp.recycle();
        return bundle2;
    }

    @Override // com.google.android.gms.internal.play_billing.zzd
    public final Bundle zzm(int i, String str, String str2, Bundle bundle, Bundle bundle2) throws RemoteException {
        Parcel zzo = zzo();
        zzo.writeInt(10);
        zzo.writeString(str);
        zzo.writeString(str2);
        zzg.zzb(zzo, bundle);
        zzg.zzb(zzo, bundle2);
        Parcel zzp = zzp(901, zzo);
        Bundle bundle3 = (Bundle) zzg.zza(zzp, Bundle.CREATOR);
        zzp.recycle();
        return bundle3;
    }

    @Override // com.google.android.gms.internal.play_billing.zzd
    public final Bundle zzn(int i, String str, String str2, Bundle bundle) throws RemoteException {
        Parcel zzo = zzo();
        zzo.writeInt(9);
        zzo.writeString(str);
        zzo.writeString(str2);
        zzg.zzb(zzo, bundle);
        Parcel zzp = zzp(902, zzo);
        Bundle bundle2 = (Bundle) zzg.zza(zzp, Bundle.CREATOR);
        zzp.recycle();
        return bundle2;
    }
}
