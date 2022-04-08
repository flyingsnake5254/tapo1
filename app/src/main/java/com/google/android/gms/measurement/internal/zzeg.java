package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteFullException;
import android.os.Parcel;
import android.os.SystemClock;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.util.VisibleForTesting;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@19.0.0 */
/* loaded from: classes.dex */
public final class zzeg extends zzf {
    private final zzef zza;
    private boolean zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzeg(zzfu zzfuVar) {
        super(zzfuVar);
        Context zzax = this.zzs.zzax();
        this.zzs.zzc();
        this.zza = new zzef(this, zzax, "google_app_measurement_local.db");
    }

    /* JADX WARN: Removed duplicated region for block: B:71:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0129  */
    @androidx.annotation.WorkerThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final boolean zzq(int r17, byte[] r18) {
        /*
            Method dump skipped, instructions count: 318
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzeg.zzq(int, byte[]):boolean");
    }

    @Override // com.google.android.gms.measurement.internal.zzf
    protected final boolean zze() {
        return false;
    }

    @WorkerThread
    public final void zzh() {
        int delete;
        zzg();
        try {
            SQLiteDatabase zzo = zzo();
            if (zzo != null && (delete = zzo.delete("messages", null, null)) > 0) {
                this.zzs.zzau().zzk().zzb("Reset local analytics data. records", Integer.valueOf(delete));
            }
        } catch (SQLiteException e2) {
            this.zzs.zzau().zzb().zzb("Error resetting local analytics data. error", e2);
        }
    }

    public final boolean zzi(zzas zzasVar) {
        Parcel obtain = Parcel.obtain();
        zzat.zza(zzasVar, obtain, 0);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        if (marshall.length <= 131072) {
            return zzq(0, marshall);
        }
        this.zzs.zzau().zzc().zza("Event is too long for local database. Sending event directly to service");
        return false;
    }

    public final boolean zzj(zzkq zzkqVar) {
        Parcel obtain = Parcel.obtain();
        zzkr.zza(zzkqVar, obtain, 0);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        if (marshall.length <= 131072) {
            return zzq(1, marshall);
        }
        this.zzs.zzau().zzc().zza("User property too long for local database. Sending directly to service");
        return false;
    }

    public final boolean zzk(zzaa zzaaVar) {
        byte[] zzX = this.zzs.zzl().zzX(zzaaVar);
        if (zzX.length <= 131072) {
            return zzq(2, zzX);
        }
        this.zzs.zzau().zzc().zza("Conditional user property too long for local database. Sending directly to service");
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:122:0x0215  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0225  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0242  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0250  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0255  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x01fb A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:168:0x01d6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0248 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:181:0x0248 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0248 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.List<com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable> zzl(int r23) {
        /*
            Method dump skipped, instructions count: 618
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzeg.zzl(int):java.util.List");
    }

    @WorkerThread
    public final boolean zzm() {
        return zzq(3, new byte[0]);
    }

    @WorkerThread
    public final boolean zzn() {
        zzg();
        if (!this.zzb && zzp()) {
            int i = 5;
            for (int i2 = 0; i2 < 5; i2++) {
                SQLiteDatabase sQLiteDatabase = null;
                try {
                    SQLiteDatabase zzo = zzo();
                    if (zzo == null) {
                        this.zzb = true;
                        return false;
                    }
                    zzo.beginTransaction();
                    zzo.delete("messages", "type == ?", new String[]{Integer.toString(3)});
                    zzo.setTransactionSuccessful();
                    zzo.endTransaction();
                    zzo.close();
                    return true;
                } catch (SQLiteDatabaseLockedException unused) {
                    SystemClock.sleep(i);
                    i += 20;
                    if (0 == 0) {
                    }
                    sQLiteDatabase.close();
                } catch (SQLiteFullException e2) {
                    this.zzs.zzau().zzb().zzb("Error deleting app launch break from local database", e2);
                    this.zzb = true;
                    if (0 == 0) {
                    }
                    sQLiteDatabase.close();
                } catch (SQLiteException e3) {
                    if (0 != 0) {
                        try {
                            if (sQLiteDatabase.inTransaction()) {
                                sQLiteDatabase.endTransaction();
                            }
                        } catch (Throwable th) {
                            if (0 != 0) {
                                sQLiteDatabase.close();
                            }
                            throw th;
                        }
                    }
                    this.zzs.zzau().zzb().zzb("Error deleting app launch break from local database", e3);
                    this.zzb = true;
                    if (0 != 0) {
                        sQLiteDatabase.close();
                    }
                }
            }
            this.zzs.zzau().zze().zza("Error deleting app launch break from local database in reasonable time");
        }
        return false;
    }

    @VisibleForTesting
    @WorkerThread
    final SQLiteDatabase zzo() throws SQLiteException {
        if (this.zzb) {
            return null;
        }
        SQLiteDatabase writableDatabase = this.zza.getWritableDatabase();
        if (writableDatabase != null) {
            return writableDatabase;
        }
        this.zzb = true;
        return null;
    }

    @VisibleForTesting
    final boolean zzp() {
        Context zzax = this.zzs.zzax();
        this.zzs.zzc();
        return zzax.getDatabasePath("google_app_measurement_local.db").exists();
    }
}
