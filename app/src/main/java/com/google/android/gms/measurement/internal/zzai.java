package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.measurement.zzfo;
import com.google.android.gms.internal.measurement.zzov;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.tplink.libtpmediastatistics.SSLClient;
import io.netty.handler.codec.http.websocketx.WebSocketServerHandshaker;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement@@19.0.0 */
/* loaded from: classes.dex */
public final class zzai extends zzke {
    private static final String[] zza = {"last_bundled_timestamp", "ALTER TABLE events ADD COLUMN last_bundled_timestamp INTEGER;", "last_bundled_day", "ALTER TABLE events ADD COLUMN last_bundled_day INTEGER;", "last_sampled_complex_event_id", "ALTER TABLE events ADD COLUMN last_sampled_complex_event_id INTEGER;", "last_sampling_rate", "ALTER TABLE events ADD COLUMN last_sampling_rate INTEGER;", "last_exempt_from_sampling", "ALTER TABLE events ADD COLUMN last_exempt_from_sampling INTEGER;", "current_session_count", "ALTER TABLE events ADD COLUMN current_session_count INTEGER;"};
    private static final String[] zzb = {"origin", "ALTER TABLE user_attributes ADD COLUMN origin TEXT;"};
    private static final String[] zzc = {"app_version", "ALTER TABLE apps ADD COLUMN app_version TEXT;", "app_store", "ALTER TABLE apps ADD COLUMN app_store TEXT;", "gmp_version", "ALTER TABLE apps ADD COLUMN gmp_version INTEGER;", "dev_cert_hash", "ALTER TABLE apps ADD COLUMN dev_cert_hash INTEGER;", "measurement_enabled", "ALTER TABLE apps ADD COLUMN measurement_enabled INTEGER;", "last_bundle_start_timestamp", "ALTER TABLE apps ADD COLUMN last_bundle_start_timestamp INTEGER;", "day", "ALTER TABLE apps ADD COLUMN day INTEGER;", "daily_public_events_count", "ALTER TABLE apps ADD COLUMN daily_public_events_count INTEGER;", "daily_events_count", "ALTER TABLE apps ADD COLUMN daily_events_count INTEGER;", "daily_conversions_count", "ALTER TABLE apps ADD COLUMN daily_conversions_count INTEGER;", "remote_config", "ALTER TABLE apps ADD COLUMN remote_config BLOB;", "config_fetched_time", "ALTER TABLE apps ADD COLUMN config_fetched_time INTEGER;", "failed_config_fetch_time", "ALTER TABLE apps ADD COLUMN failed_config_fetch_time INTEGER;", "app_version_int", "ALTER TABLE apps ADD COLUMN app_version_int INTEGER;", "firebase_instance_id", "ALTER TABLE apps ADD COLUMN firebase_instance_id TEXT;", "daily_error_events_count", "ALTER TABLE apps ADD COLUMN daily_error_events_count INTEGER;", "daily_realtime_events_count", "ALTER TABLE apps ADD COLUMN daily_realtime_events_count INTEGER;", "health_monitor_sample", "ALTER TABLE apps ADD COLUMN health_monitor_sample TEXT;", "android_id", "ALTER TABLE apps ADD COLUMN android_id INTEGER;", "adid_reporting_enabled", "ALTER TABLE apps ADD COLUMN adid_reporting_enabled INTEGER;", "ssaid_reporting_enabled", "ALTER TABLE apps ADD COLUMN ssaid_reporting_enabled INTEGER;", "admob_app_id", "ALTER TABLE apps ADD COLUMN admob_app_id TEXT;", "linked_admob_app_id", "ALTER TABLE apps ADD COLUMN linked_admob_app_id TEXT;", "dynamite_version", "ALTER TABLE apps ADD COLUMN dynamite_version INTEGER;", "safelisted_events", "ALTER TABLE apps ADD COLUMN safelisted_events TEXT;", "ga_app_id", "ALTER TABLE apps ADD COLUMN ga_app_id TEXT;", "config_last_modified_time", "ALTER TABLE apps ADD COLUMN config_last_modified_time TEXT;"};
    private static final String[] zzd = {"realtime", "ALTER TABLE raw_events ADD COLUMN realtime INTEGER;"};
    private static final String[] zze = {"has_realtime", "ALTER TABLE queue ADD COLUMN has_realtime INTEGER;", "retry_count", "ALTER TABLE queue ADD COLUMN retry_count INTEGER;"};
    private static final String[] zzg = {"session_scoped", "ALTER TABLE event_filters ADD COLUMN session_scoped BOOLEAN;"};
    private static final String[] zzh = {"session_scoped", "ALTER TABLE property_filters ADD COLUMN session_scoped BOOLEAN;"};
    private static final String[] zzi = {"previous_install_count", "ALTER TABLE app2 ADD COLUMN previous_install_count INTEGER;"};
    private final zzka zzk = new zzka(this.zzs.zzay());
    private final zzah zzj = new zzah(this, this.zzs.zzax(), "google_app_measurement.db");

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzai(zzkn zzknVar) {
        super(zzknVar);
        this.zzs.zzc();
    }

    @WorkerThread
    static final void zzX(ContentValues contentValues, String str, Object obj) {
        Preconditions.checkNotEmpty("value");
        Preconditions.checkNotNull(obj);
        if (obj instanceof String) {
            contentValues.put("value", (String) obj);
        } else if (obj instanceof Long) {
            contentValues.put("value", (Long) obj);
        } else if (obj instanceof Double) {
            contentValues.put("value", (Double) obj);
        } else {
            throw new IllegalArgumentException("Invalid value type");
        }
    }

    @WorkerThread
    private final long zzab(String str, String[] strArr) {
        Cursor cursor = null;
        try {
            try {
                Cursor rawQuery = zze().rawQuery(str, strArr);
                if (rawQuery.moveToFirst()) {
                    long j = rawQuery.getLong(0);
                    rawQuery.close();
                    return j;
                }
                throw new SQLiteException("Database returned empty set");
            } catch (SQLiteException e2) {
                this.zzs.zzau().zzb().zzc("Database error", str, e2);
                throw e2;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    @WorkerThread
    private final long zzac(String str, String[] strArr, long j) {
        Cursor cursor = null;
        try {
            try {
                cursor = zze().rawQuery(str, strArr);
                if (cursor.moveToFirst()) {
                    long j2 = cursor.getLong(0);
                    cursor.close();
                    return j2;
                }
                cursor.close();
                return j;
            } catch (SQLiteException e2) {
                this.zzs.zzau().zzb().zzc("Database error", str, e2);
                throw e2;
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    public final void zzA() {
        zzg();
        zzZ();
        if (zzM()) {
            long zza2 = this.zzf.zzn().zza.zza();
            long elapsedRealtime = this.zzs.zzay().elapsedRealtime();
            long abs = Math.abs(elapsedRealtime - zza2);
            this.zzs.zzc();
            if (abs > zzea.zzx.zzb(null).longValue()) {
                this.zzf.zzn().zza.zzb(elapsedRealtime);
                zzg();
                zzZ();
                if (zzM()) {
                    SQLiteDatabase zze2 = zze();
                    this.zzs.zzc();
                    int delete = zze2.delete("queue", "abs(bundle_end_timestamp - ?) > cast(? as integer)", new String[]{String.valueOf(this.zzs.zzay().currentTimeMillis()), String.valueOf(zzae.zzA())});
                    if (delete > 0) {
                        this.zzs.zzau().zzk().zzb("Deleted stale rows. rowsDeleted", Integer.valueOf(delete));
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    @WorkerThread
    public final void zzB(List<Long> list) {
        zzg();
        zzZ();
        Preconditions.checkNotNull(list);
        Preconditions.checkNotZero(list.size());
        if (zzM()) {
            String join = TextUtils.join(SSLClient.COMMA, list);
            StringBuilder sb = new StringBuilder(String.valueOf(join).length() + 2);
            sb.append("(");
            sb.append(join);
            sb.append(")");
            String sb2 = sb.toString();
            StringBuilder sb3 = new StringBuilder(String.valueOf(sb2).length() + 80);
            sb3.append("SELECT COUNT(1) FROM queue WHERE rowid IN ");
            sb3.append(sb2);
            sb3.append(" AND retry_count =  2147483647 LIMIT 1");
            if (zzab(sb3.toString(), null) > 0) {
                this.zzs.zzau().zze().zza("The number of upload retries exceeds the limit. Will remain unchanged.");
            }
            try {
                SQLiteDatabase zze2 = zze();
                StringBuilder sb4 = new StringBuilder(String.valueOf(sb2).length() + 127);
                sb4.append("UPDATE queue SET retry_count = IFNULL(retry_count, 0) + 1 WHERE rowid IN ");
                sb4.append(sb2);
                sb4.append(" AND (retry_count IS NULL OR retry_count < ");
                sb4.append(Integer.MAX_VALUE);
                sb4.append(")");
                zze2.execSQL(sb4.toString());
            } catch (SQLiteException e2) {
                this.zzs.zzau().zzb().zzb("Error incrementing retry count. error", e2);
            }
        }
    }

    @VisibleForTesting
    @WorkerThread
    final Object zzC(Cursor cursor, int i) {
        int type = cursor.getType(i);
        if (type == 0) {
            this.zzs.zzau().zzb().zza("Loaded invalid null value from database");
            return null;
        } else if (type == 1) {
            return Long.valueOf(cursor.getLong(i));
        } else {
            if (type == 2) {
                return Double.valueOf(cursor.getDouble(i));
            }
            if (type == 3) {
                return cursor.getString(i);
            }
            if (type != 4) {
                this.zzs.zzau().zzb().zzb("Loaded invalid unknown value type, ignoring it", Integer.valueOf(type));
                return null;
            }
            this.zzs.zzau().zzb().zza("Loaded invalid blob type value, ignoring it");
            return null;
        }
    }

    @WorkerThread
    public final long zzD() {
        return zzac("select max(bundle_end_timestamp) from queue", null, 0L);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @VisibleForTesting
    @WorkerThread
    public final long zzE(String str, String str2) {
        SQLiteException e2;
        long zzac;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty("first_open_count");
        zzg();
        zzZ();
        SQLiteDatabase zze2 = zze();
        zze2.beginTransaction();
        long j = 0;
        try {
            try {
                StringBuilder sb = new StringBuilder(48);
                sb.append("select ");
                sb.append("first_open_count");
                sb.append(" from app2 where app_id=?");
                zzac = zzac(sb.toString(), new String[]{str}, -1L);
                if (zzac == -1) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("app_id", str);
                    contentValues.put("first_open_count", (Integer) 0);
                    contentValues.put("previous_install_count", (Integer) 0);
                    if (zze2.insertWithOnConflict("app2", null, contentValues, 5) == -1) {
                        this.zzs.zzau().zzb().zzc("Failed to insert column (got -1). appId", zzem.zzl(str), "first_open_count");
                        return -1L;
                    }
                    zzac = 0;
                }
            } catch (SQLiteException e3) {
                e2 = e3;
            }
            try {
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put("app_id", str);
                contentValues2.put("first_open_count", Long.valueOf(1 + zzac));
                if (zze2.update("app2", contentValues2, "app_id = ?", new String[]{str}) == 0) {
                    this.zzs.zzau().zzb().zzc("Failed to update column (got 0). appId", zzem.zzl(str), "first_open_count");
                    return -1L;
                }
                zze2.setTransactionSuccessful();
                return zzac;
            } catch (SQLiteException e4) {
                e2 = e4;
                j = zzac;
                this.zzs.zzau().zzb().zzd("Error inserting column. appId", zzem.zzl(str), "first_open_count", e2);
                return j;
            }
        } finally {
            zze2.endTransaction();
        }
    }

    @WorkerThread
    public final long zzF() {
        return zzac("select max(timestamp) from raw_events", null, 0L);
    }

    public final boolean zzG() {
        return zzab("select count(1) > 0 from raw_events", null) != 0;
    }

    public final boolean zzH() {
        return zzab("select count(1) > 0 from raw_events where realtime = 1", null) != 0;
    }

    public final long zzI(String str) {
        Preconditions.checkNotEmpty(str);
        return zzac("select count(1) from events where app_id=? and name not like '!_%' escape '!'", new String[]{str}, 0L);
    }

    public final boolean zzJ(String str, Long l, long j, zzfo zzfoVar) {
        zzg();
        zzZ();
        Preconditions.checkNotNull(zzfoVar);
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(l);
        byte[] zzbp = zzfoVar.zzbp();
        this.zzs.zzau().zzk().zzc("Saving complex main event, appId, data size", this.zzs.zzm().zzc(str), Integer.valueOf(zzbp.length));
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("event_id", l);
        contentValues.put("children_to_process", Long.valueOf(j));
        contentValues.put("main_event", zzbp);
        try {
            if (zze().insertWithOnConflict("main_event_params", null, contentValues, 5) != -1) {
                return true;
            }
            this.zzs.zzau().zzb().zzb("Failed to insert complex main event (got -1). appId", zzem.zzl(str));
            return false;
        } catch (SQLiteException e2) {
            this.zzs.zzau().zzb().zzc("Error storing complex main event. appId", zzem.zzl(str), e2);
            return false;
        }
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x00d6: MOVE  (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:41:0x00d6 */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00d9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.os.Bundle zzK(java.lang.String r8) {
        /*
            r7 = this;
            r7.zzg()
            r7.zzZ()
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r7.zze()     // Catch: all -> 0x00bc, SQLiteException -> 0x00be
            r2 = 1
            java.lang.String[] r2 = new java.lang.String[r2]     // Catch: all -> 0x00bc, SQLiteException -> 0x00be
            r3 = 0
            r2[r3] = r8     // Catch: all -> 0x00bc, SQLiteException -> 0x00be
            java.lang.String r4 = "select parameters from default_event_params where app_id=?"
            android.database.Cursor r1 = r1.rawQuery(r4, r2)     // Catch: all -> 0x00bc, SQLiteException -> 0x00be
            boolean r2 = r1.moveToFirst()     // Catch: SQLiteException -> 0x00ba, all -> 0x00d5
            if (r2 != 0) goto L_0x0030
            com.google.android.gms.measurement.internal.zzfu r8 = r7.zzs     // Catch: SQLiteException -> 0x00ba, all -> 0x00d5
            com.google.android.gms.measurement.internal.zzem r8 = r8.zzau()     // Catch: SQLiteException -> 0x00ba, all -> 0x00d5
            com.google.android.gms.measurement.internal.zzek r8 = r8.zzk()     // Catch: SQLiteException -> 0x00ba, all -> 0x00d5
            java.lang.String r2 = "Default event parameters not found"
            r8.zza(r2)     // Catch: SQLiteException -> 0x00ba, all -> 0x00d5
            r1.close()
            return r0
        L_0x0030:
            byte[] r2 = r1.getBlob(r3)     // Catch: SQLiteException -> 0x00ba, all -> 0x00d5
            com.google.android.gms.internal.measurement.zzfn r3 = com.google.android.gms.internal.measurement.zzfo.zzk()     // Catch: IOException -> 0x00a2, SQLiteException -> 0x00ba, all -> 0x00d5
            com.google.android.gms.internal.measurement.zzlh r2 = com.google.android.gms.measurement.internal.zzkp.zzt(r3, r2)     // Catch: IOException -> 0x00a2, SQLiteException -> 0x00ba, all -> 0x00d5
            com.google.android.gms.internal.measurement.zzfn r2 = (com.google.android.gms.internal.measurement.zzfn) r2     // Catch: IOException -> 0x00a2, SQLiteException -> 0x00ba, all -> 0x00d5
            com.google.android.gms.internal.measurement.zzkd r2 = r2.zzaA()     // Catch: IOException -> 0x00a2, SQLiteException -> 0x00ba, all -> 0x00d5
            com.google.android.gms.internal.measurement.zzfo r2 = (com.google.android.gms.internal.measurement.zzfo) r2     // Catch: IOException -> 0x00a2, SQLiteException -> 0x00ba, all -> 0x00d5
            com.google.android.gms.measurement.internal.zzkn r8 = r7.zzf     // Catch: SQLiteException -> 0x00ba, all -> 0x00d5
            r8.zzm()     // Catch: SQLiteException -> 0x00ba, all -> 0x00d5
            java.util.List r8 = r2.zza()     // Catch: SQLiteException -> 0x00ba, all -> 0x00d5
            android.os.Bundle r2 = new android.os.Bundle     // Catch: SQLiteException -> 0x00ba, all -> 0x00d5
            r2.<init>()     // Catch: SQLiteException -> 0x00ba, all -> 0x00d5
            java.util.Iterator r8 = r8.iterator()     // Catch: SQLiteException -> 0x00ba, all -> 0x00d5
        L_0x0056:
            boolean r3 = r8.hasNext()     // Catch: SQLiteException -> 0x00ba, all -> 0x00d5
            if (r3 == 0) goto L_0x009e
            java.lang.Object r3 = r8.next()     // Catch: SQLiteException -> 0x00ba, all -> 0x00d5
            com.google.android.gms.internal.measurement.zzfs r3 = (com.google.android.gms.internal.measurement.zzfs) r3     // Catch: SQLiteException -> 0x00ba, all -> 0x00d5
            java.lang.String r4 = r3.zzb()     // Catch: SQLiteException -> 0x00ba, all -> 0x00d5
            boolean r5 = r3.zzi()     // Catch: SQLiteException -> 0x00ba, all -> 0x00d5
            if (r5 == 0) goto L_0x0074
            double r5 = r3.zzj()     // Catch: SQLiteException -> 0x00ba, all -> 0x00d5
            r2.putDouble(r4, r5)     // Catch: SQLiteException -> 0x00ba, all -> 0x00d5
            goto L_0x0056
        L_0x0074:
            boolean r5 = r3.zzg()     // Catch: SQLiteException -> 0x00ba, all -> 0x00d5
            if (r5 == 0) goto L_0x0082
            float r3 = r3.zzh()     // Catch: SQLiteException -> 0x00ba, all -> 0x00d5
            r2.putFloat(r4, r3)     // Catch: SQLiteException -> 0x00ba, all -> 0x00d5
            goto L_0x0056
        L_0x0082:
            boolean r5 = r3.zzc()     // Catch: SQLiteException -> 0x00ba, all -> 0x00d5
            if (r5 == 0) goto L_0x0090
            java.lang.String r3 = r3.zzd()     // Catch: SQLiteException -> 0x00ba, all -> 0x00d5
            r2.putString(r4, r3)     // Catch: SQLiteException -> 0x00ba, all -> 0x00d5
            goto L_0x0056
        L_0x0090:
            boolean r5 = r3.zze()     // Catch: SQLiteException -> 0x00ba, all -> 0x00d5
            if (r5 == 0) goto L_0x0056
            long r5 = r3.zzf()     // Catch: SQLiteException -> 0x00ba, all -> 0x00d5
            r2.putLong(r4, r5)     // Catch: SQLiteException -> 0x00ba, all -> 0x00d5
            goto L_0x0056
        L_0x009e:
            r1.close()
            return r2
        L_0x00a2:
            r2 = move-exception
            com.google.android.gms.measurement.internal.zzfu r3 = r7.zzs     // Catch: SQLiteException -> 0x00ba, all -> 0x00d5
            com.google.android.gms.measurement.internal.zzem r3 = r3.zzau()     // Catch: SQLiteException -> 0x00ba, all -> 0x00d5
            com.google.android.gms.measurement.internal.zzek r3 = r3.zzb()     // Catch: SQLiteException -> 0x00ba, all -> 0x00d5
            java.lang.String r4 = "Failed to retrieve default event parameters. appId"
            java.lang.Object r8 = com.google.android.gms.measurement.internal.zzem.zzl(r8)     // Catch: SQLiteException -> 0x00ba, all -> 0x00d5
            r3.zzc(r4, r8, r2)     // Catch: SQLiteException -> 0x00ba, all -> 0x00d5
            r1.close()
            return r0
        L_0x00ba:
            r8 = move-exception
            goto L_0x00c0
        L_0x00bc:
            r8 = move-exception
            goto L_0x00d7
        L_0x00be:
            r8 = move-exception
            r1 = r0
        L_0x00c0:
            com.google.android.gms.measurement.internal.zzfu r2 = r7.zzs     // Catch: all -> 0x00d5
            com.google.android.gms.measurement.internal.zzem r2 = r2.zzau()     // Catch: all -> 0x00d5
            com.google.android.gms.measurement.internal.zzek r2 = r2.zzb()     // Catch: all -> 0x00d5
            java.lang.String r3 = "Error selecting default event parameters"
            r2.zzb(r3, r8)     // Catch: all -> 0x00d5
            if (r1 == 0) goto L_0x00d4
            r1.close()
        L_0x00d4:
            return r0
        L_0x00d5:
            r8 = move-exception
            r0 = r1
        L_0x00d7:
            if (r0 == 0) goto L_0x00dc
            r0.close()
        L_0x00dc:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzai.zzK(java.lang.String):android.os.Bundle");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:100:0x0343, code lost:
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x0344, code lost:
        r11.put("session_scoped", r0);
        r11.put(com.google.firebase.messaging.Constants.ScionAnalytics.MessageType.DATA_MESSAGE, r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x0358, code lost:
        if (zze().insertWithOnConflict("property_filters", null, r11, 5) != (-1)) goto L_0x036e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x035a, code lost:
        r23.zzs.zzau().zzb().zzb("Failed to insert property filter (got -1). appId", com.google.android.gms.measurement.internal.zzem.zzl(r24));
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x036e, code lost:
        r0 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x0372, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x0373, code lost:
        r23.zzs.zzau().zzb().zzc("Error storing property filter. appId", com.google.android.gms.measurement.internal.zzem.zzl(r24), r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x0386, code lost:
        zzZ();
        zzg();
        com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r24);
        r0 = zze();
        r0.delete("property_filters", r17, new java.lang.String[]{r24, java.lang.String.valueOf(r10)});
        r0.delete("event_filters", r17, new java.lang.String[]{r24, java.lang.String.valueOf(r10)});
        r17 = r17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x03bd, code lost:
        r4 = r21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x018b, code lost:
        r11 = r0.zzc().iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0197, code lost:
        if (r11.hasNext() == false) goto L_0x01be;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x01a3, code lost:
        if (r11.next().zza() != false) goto L_0x0193;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x01a5, code lost:
        r23.zzs.zzau().zze().zzc("Property filter with no ID. Audience definition ignored. appId, audienceId", com.google.android.gms.measurement.internal.zzem.zzl(r24), java.lang.Integer.valueOf(r10));
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x01be, code lost:
        r11 = r0.zzf().iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x01d4, code lost:
        if (r11.hasNext() == false) goto L_0x02aa;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x01d6, code lost:
        r12 = r11.next();
        zzZ();
        zzg();
        com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r24);
        com.google.android.gms.common.internal.Preconditions.checkNotNull(r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x01f0, code lost:
        if (android.text.TextUtils.isEmpty(r12.zzc()) == false) goto L_0x0224;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x01f2, code lost:
        r0 = r23.zzs.zzau().zze();
        r8 = com.google.android.gms.measurement.internal.zzem.zzl(r24);
        r11 = java.lang.Integer.valueOf(r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x020a, code lost:
        if (r12.zza() == false) goto L_0x0217;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x020c, code lost:
        r20 = java.lang.Integer.valueOf(r12.zzb());
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0217, code lost:
        r20 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0219, code lost:
        r0.zzd("Event filter had no event name. Audience definition ignored. appId, audienceId, filterId", r8, r11, java.lang.String.valueOf(r20));
        r21 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0224, code lost:
        r3 = r12.zzbp();
        r21 = r4;
        r4 = new android.content.ContentValues();
        r4.put("app_id", r24);
        r4.put("audience_id", java.lang.Integer.valueOf(r10));
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x023d, code lost:
        if (r12.zza() == false) goto L_0x0248;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x023f, code lost:
        r8 = java.lang.Integer.valueOf(r12.zzb());
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0248, code lost:
        r8 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0249, code lost:
        r4.put("filter_id", r8);
        r4.put("event_name", r12.zzc());
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0259, code lost:
        if (r12.zzk() == false) goto L_0x0264;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x025b, code lost:
        r8 = java.lang.Boolean.valueOf(r12.zzm());
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0264, code lost:
        r8 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0265, code lost:
        r4.put("session_scoped", r8);
        r4.put(com.google.firebase.messaging.Constants.ScionAnalytics.MessageType.DATA_MESSAGE, r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0279, code lost:
        if (zze().insertWithOnConflict("event_filters", null, r4, 5) != (-1)) goto L_0x028e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x027b, code lost:
        r23.zzs.zzau().zzb().zzb("Failed to insert event filter (got -1). appId", com.google.android.gms.measurement.internal.zzem.zzl(r24));
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x028e, code lost:
        r4 = r21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0294, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0295, code lost:
        r23.zzs.zzau().zzb().zzc("Error storing event filter. appId", com.google.android.gms.measurement.internal.zzem.zzl(r24), r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x02aa, code lost:
        r21 = r4;
        r0 = r0.zzc().iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x02b8, code lost:
        if (r0.hasNext() == false) goto L_0x03bd;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x02ba, code lost:
        r3 = r0.next();
        zzZ();
        zzg();
        com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r24);
        com.google.android.gms.common.internal.Preconditions.checkNotNull(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x02d4, code lost:
        if (android.text.TextUtils.isEmpty(r3.zzc()) == false) goto L_0x0303;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x02d6, code lost:
        r0 = r23.zzs.zzau().zze();
        r7 = com.google.android.gms.measurement.internal.zzem.zzl(r24);
        r8 = java.lang.Integer.valueOf(r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x02ee, code lost:
        if (r3.zza() == false) goto L_0x02f9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x02f0, code lost:
        r3 = java.lang.Integer.valueOf(r3.zzb());
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x02f9, code lost:
        r3 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x02fa, code lost:
        r0.zzd("Property filter had no property name. Audience definition ignored. appId, audienceId, filterId", r7, r8, java.lang.String.valueOf(r3));
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x0303, code lost:
        r4 = r3.zzbp();
        r11 = new android.content.ContentValues();
        r11.put("app_id", r24);
        r11.put("audience_id", java.lang.Integer.valueOf(r10));
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x031a, code lost:
        if (r3.zza() == false) goto L_0x0325;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x031c, code lost:
        r12 = java.lang.Integer.valueOf(r3.zzb());
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x0325, code lost:
        r12 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x0326, code lost:
        r11.put("filter_id", r12);
        r11.put("property_name", r3.zzc());
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x0338, code lost:
        if (r3.zzg() == false) goto L_0x0343;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x033a, code lost:
        r0 = java.lang.Boolean.valueOf(r3.zzh());
     */
    @androidx.annotation.WorkerThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zzL(java.lang.String r24, java.util.List<com.google.android.gms.internal.measurement.zzeh> r25) {
        /*
            Method dump skipped, instructions count: 1221
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzai.zzL(java.lang.String, java.util.List):void");
    }

    @VisibleForTesting
    protected final boolean zzM() {
        Context zzax = this.zzs.zzax();
        this.zzs.zzc();
        return zzax.getDatabasePath("google_app_measurement.db").exists();
    }

    /* JADX WARN: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: TypeSearchVarInfo not found in map for var: r3v2 java.lang.Object
    	at jadx.core.dex.visitors.typeinference.TypeSearchState.getVarInfo(TypeSearchState.java:34)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.lambda$resolveIndependentVariables$1(TypeSearch.java:174)
    	at java.base/java.util.stream.MatchOps$1MatchSink.accept(Unknown Source)
    	at java.base/java.util.ArrayList$ArrayListSpliterator.tryAdvance(Unknown Source)
    	at java.base/java.util.stream.ReferencePipeline$7$1.accept(Unknown Source)
    	at java.base/java.util.ArrayList$ArrayListSpliterator.tryAdvance(Unknown Source)
    	at java.base/java.util.stream.ReferencePipeline.forEachWithCancel(Unknown Source)
    	at java.base/java.util.stream.AbstractPipeline.copyIntoWithCancel(Unknown Source)
    	at java.base/java.util.stream.AbstractPipeline.copyInto(Unknown Source)
    	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(Unknown Source)
    	at java.base/java.util.stream.MatchOps$MatchOp.evaluateSequential(Unknown Source)
     */
    /* JADX WARN: Not initialized variable reg: 4, insn: 0x0231: MOVE  (r3 I:??[OBJECT, ARRAY]) = (r4 I:??[OBJECT, ARRAY]), block:B:94:0x0231 */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3, types: [boolean] */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Unknown variable types count: 2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zzW(java.lang.String r21, long r22, long r24, com.google.android.gms.measurement.internal.zzkm r26) {
        /*
            Method dump skipped, instructions count: 568
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzai.zzW(java.lang.String, long, long, com.google.android.gms.measurement.internal.zzkm):void");
    }

    @Override // com.google.android.gms.measurement.internal.zzke
    protected final boolean zzaA() {
        return false;
    }

    @WorkerThread
    public final void zzb() {
        zzZ();
        zze().beginTransaction();
    }

    @WorkerThread
    public final void zzc() {
        zzZ();
        zze().setTransactionSuccessful();
    }

    @WorkerThread
    public final void zzd() {
        zzZ();
        zze().endTransaction();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    @WorkerThread
    public final SQLiteDatabase zze() {
        zzg();
        try {
            return this.zzj.getWritableDatabase();
        } catch (SQLiteException e2) {
            this.zzs.zzau().zze().zzb("Error opening database", e2);
            throw e2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x0150  */
    @androidx.annotation.WorkerThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.google.android.gms.measurement.internal.zzao zzf(java.lang.String r28, java.lang.String r29) {
        /*
            Method dump skipped, instructions count: 340
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzai.zzf(java.lang.String, java.lang.String):com.google.android.gms.measurement.internal.zzao");
    }

    @WorkerThread
    public final void zzh(zzao zzaoVar) {
        Preconditions.checkNotNull(zzaoVar);
        zzg();
        zzZ();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzaoVar.zza);
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.NAME, zzaoVar.zzb);
        contentValues.put("lifetime_count", Long.valueOf(zzaoVar.zzc));
        contentValues.put("current_bundle_count", Long.valueOf(zzaoVar.zzd));
        contentValues.put("last_fire_timestamp", Long.valueOf(zzaoVar.zzf));
        contentValues.put("last_bundled_timestamp", Long.valueOf(zzaoVar.zzg));
        contentValues.put("last_bundled_day", zzaoVar.zzh);
        contentValues.put("last_sampled_complex_event_id", zzaoVar.zzi);
        contentValues.put("last_sampling_rate", zzaoVar.zzj);
        contentValues.put("current_session_count", Long.valueOf(zzaoVar.zze));
        Boolean bool = zzaoVar.zzk;
        contentValues.put("last_exempt_from_sampling", (bool == null || !bool.booleanValue()) ? null : 1L);
        try {
            if (zze().insertWithOnConflict("events", null, contentValues, 5) == -1) {
                this.zzs.zzau().zzb().zzb("Failed to insert/update event aggregates (got -1). appId", zzem.zzl(zzaoVar.zza));
            }
        } catch (SQLiteException e2) {
            this.zzs.zzau().zzb().zzc("Error storing event aggregates. appId", zzem.zzl(zzaoVar.zza), e2);
        }
    }

    @WorkerThread
    public final void zzi(String str, String str2) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzg();
        zzZ();
        try {
            zze().delete("user_attributes", "app_id=? and name=?", new String[]{str, str2});
        } catch (SQLiteException e2) {
            this.zzs.zzau().zzb().zzd("Error deleting user property. appId", zzem.zzl(str), this.zzs.zzm().zze(str2), e2);
        }
    }

    @WorkerThread
    public final boolean zzj(zzks zzksVar) {
        Preconditions.checkNotNull(zzksVar);
        zzg();
        zzZ();
        if (zzk(zzksVar.zza, zzksVar.zzc) == null) {
            if (zzku.zzh(zzksVar.zzc)) {
                if (zzab("select count(1) from user_attributes where app_id=? and name not like '!_%' escape '!'", new String[]{zzksVar.zza}) >= this.zzs.zzc().zzl(zzksVar.zza, zzea.zzF, 25, 100)) {
                    return false;
                }
            } else if (!"_npa".equals(zzksVar.zzc)) {
                long zzab = zzab("select count(1) from user_attributes where app_id=? and origin=? AND name like '!_%' escape '!'", new String[]{zzksVar.zza, zzksVar.zzb});
                this.zzs.zzc();
                if (zzab >= 25) {
                    return false;
                }
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzksVar.zza);
        contentValues.put("origin", zzksVar.zzb);
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.NAME, zzksVar.zzc);
        contentValues.put("set_timestamp", Long.valueOf(zzksVar.zzd));
        zzX(contentValues, "value", zzksVar.zze);
        try {
            if (zze().insertWithOnConflict("user_attributes", null, contentValues, 5) == -1) {
                this.zzs.zzau().zzb().zzb("Failed to insert/update user property (got -1). appId", zzem.zzl(zzksVar.zza));
            }
        } catch (SQLiteException e2) {
            this.zzs.zzau().zzb().zzc("Error storing user property. appId", zzem.zzl(zzksVar.zza), e2);
        }
        return true;
    }

    /* JADX WARN: Not initialized variable reg: 11, insn: 0x00a3: MOVE  (r10 I:??[OBJECT, ARRAY]) = (r11 I:??[OBJECT, ARRAY]), block:B:26:0x00a3 */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00a6  */
    @androidx.annotation.WorkerThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.google.android.gms.measurement.internal.zzks zzk(java.lang.String r20, java.lang.String r21) {
        /*
            r19 = this;
            r1 = r19
            r9 = r21
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r20)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r21)
            r19.zzg()
            r19.zzZ()
            r10 = 0
            android.database.sqlite.SQLiteDatabase r11 = r19.zze()     // Catch: all -> 0x007b, SQLiteException -> 0x007d
            java.lang.String r0 = "set_timestamp"
            java.lang.String r2 = "value"
            java.lang.String r3 = "origin"
            java.lang.String[] r13 = new java.lang.String[]{r0, r2, r3}     // Catch: all -> 0x007b, SQLiteException -> 0x007d
            r0 = 2
            java.lang.String[] r15 = new java.lang.String[r0]     // Catch: all -> 0x007b, SQLiteException -> 0x007d
            r2 = 0
            r15[r2] = r20     // Catch: all -> 0x007b, SQLiteException -> 0x007d
            r3 = 1
            r15[r3] = r9     // Catch: all -> 0x007b, SQLiteException -> 0x007d
            java.lang.String r12 = "user_attributes"
            java.lang.String r14 = "app_id=? and name=?"
            r16 = 0
            r17 = 0
            r18 = 0
            android.database.Cursor r11 = r11.query(r12, r13, r14, r15, r16, r17, r18)     // Catch: all -> 0x007b, SQLiteException -> 0x007d
            boolean r4 = r11.moveToFirst()     // Catch: SQLiteException -> 0x0079, all -> 0x00a2
            if (r4 != 0) goto L_0x0040
            r11.close()
            return r10
        L_0x0040:
            long r6 = r11.getLong(r2)     // Catch: SQLiteException -> 0x0079, all -> 0x00a2
            java.lang.Object r8 = r1.zzC(r11, r3)     // Catch: SQLiteException -> 0x0079, all -> 0x00a2
            if (r8 != 0) goto L_0x004e
            r11.close()
            return r10
        L_0x004e:
            java.lang.String r4 = r11.getString(r0)     // Catch: SQLiteException -> 0x0079, all -> 0x00a2
            com.google.android.gms.measurement.internal.zzks r0 = new com.google.android.gms.measurement.internal.zzks     // Catch: SQLiteException -> 0x0079, all -> 0x00a2
            r2 = r0
            r3 = r20
            r5 = r21
            r2.<init>(r3, r4, r5, r6, r8)     // Catch: SQLiteException -> 0x0079, all -> 0x00a2
            boolean r2 = r11.moveToNext()     // Catch: SQLiteException -> 0x0079, all -> 0x00a2
            if (r2 == 0) goto L_0x0075
            com.google.android.gms.measurement.internal.zzfu r2 = r1.zzs     // Catch: SQLiteException -> 0x0079, all -> 0x00a2
            com.google.android.gms.measurement.internal.zzem r2 = r2.zzau()     // Catch: SQLiteException -> 0x0079, all -> 0x00a2
            com.google.android.gms.measurement.internal.zzek r2 = r2.zzb()     // Catch: SQLiteException -> 0x0079, all -> 0x00a2
            java.lang.String r3 = "Got multiple records for user property, expected one. appId"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzem.zzl(r20)     // Catch: SQLiteException -> 0x0079, all -> 0x00a2
            r2.zzb(r3, r4)     // Catch: SQLiteException -> 0x0079, all -> 0x00a2
        L_0x0075:
            r11.close()
            return r0
        L_0x0079:
            r0 = move-exception
            goto L_0x007f
        L_0x007b:
            r0 = move-exception
            goto L_0x00a4
        L_0x007d:
            r0 = move-exception
            r11 = r10
        L_0x007f:
            com.google.android.gms.measurement.internal.zzfu r2 = r1.zzs     // Catch: all -> 0x00a2
            com.google.android.gms.measurement.internal.zzem r2 = r2.zzau()     // Catch: all -> 0x00a2
            com.google.android.gms.measurement.internal.zzek r2 = r2.zzb()     // Catch: all -> 0x00a2
            java.lang.String r3 = "Error querying user property. appId"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzem.zzl(r20)     // Catch: all -> 0x00a2
            com.google.android.gms.measurement.internal.zzfu r5 = r1.zzs     // Catch: all -> 0x00a2
            com.google.android.gms.measurement.internal.zzeh r5 = r5.zzm()     // Catch: all -> 0x00a2
            java.lang.String r5 = r5.zze(r9)     // Catch: all -> 0x00a2
            r2.zzd(r3, r4, r5, r0)     // Catch: all -> 0x00a2
            if (r11 == 0) goto L_0x00a1
            r11.close()
        L_0x00a1:
            return r10
        L_0x00a2:
            r0 = move-exception
            r10 = r11
        L_0x00a4:
            if (r10 == 0) goto L_0x00a9
            r10.close()
        L_0x00a9:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzai.zzk(java.lang.String, java.lang.String):com.google.android.gms.measurement.internal.zzks");
    }

    @WorkerThread
    public final List<zzks> zzl(String str) {
        Preconditions.checkNotEmpty(str);
        zzg();
        zzZ();
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            try {
                this.zzs.zzc();
                cursor = zze().query("user_attributes", new String[]{AppMeasurementSdk.ConditionalUserProperty.NAME, "origin", "set_timestamp", "value"}, "app_id=?", new String[]{str}, null, null, "rowid", "1000");
                if (cursor.moveToFirst()) {
                    do {
                        String string = cursor.getString(0);
                        String string2 = cursor.getString(1);
                        if (string2 == null) {
                            string2 = "";
                        }
                        long j = cursor.getLong(2);
                        Object zzC = zzC(cursor, 3);
                        if (zzC == null) {
                            this.zzs.zzau().zzb().zzb("Read invalid user property value, ignoring it. appId", zzem.zzl(str));
                        } else {
                            arrayList.add(new zzks(str, string2, string, j, zzC));
                        }
                    } while (cursor.moveToNext());
                    cursor.close();
                    return arrayList;
                }
                cursor.close();
                return arrayList;
            } catch (SQLiteException e2) {
                this.zzs.zzau().zzb().zzc("Error querying user properties. appId", zzem.zzl(str), e2);
                List<zzks> emptyList = Collections.emptyList();
                if (cursor != null) {
                    cursor.close();
                }
                return emptyList;
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x009c, code lost:
        r2 = r16.zzs.zzau().zzb();
        r16.zzs.zzc();
        r2.zzb("Read more than the max allowed user properties, ignoring excess", 1000);
     */
    /* JADX WARN: Removed duplicated region for block: B:36:0x011d A[DONT_GENERATE] */
    @androidx.annotation.WorkerThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.List<com.google.android.gms.measurement.internal.zzks> zzm(java.lang.String r17, java.lang.String r18, java.lang.String r19) {
        /*
            Method dump skipped, instructions count: 295
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzai.zzm(java.lang.String, java.lang.String, java.lang.String):java.util.List");
    }

    @WorkerThread
    public final boolean zzn(zzaa zzaaVar) {
        Preconditions.checkNotNull(zzaaVar);
        zzg();
        zzZ();
        String str = zzaaVar.zza;
        Preconditions.checkNotNull(str);
        if (zzk(str, zzaaVar.zzc.zzb) == null) {
            long zzab = zzab("SELECT COUNT(1) FROM conditional_properties WHERE app_id=?", new String[]{str});
            this.zzs.zzc();
            if (zzab >= 1000) {
                return false;
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("origin", zzaaVar.zzb);
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.NAME, zzaaVar.zzc.zzb);
        zzX(contentValues, "value", Preconditions.checkNotNull(zzaaVar.zzc.zza()));
        contentValues.put("active", Boolean.valueOf(zzaaVar.zze));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME, zzaaVar.zzf);
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT, Long.valueOf(zzaaVar.zzh));
        contentValues.put("timed_out_event", this.zzs.zzl().zzX(zzaaVar.zzg));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, Long.valueOf(zzaaVar.zzd));
        contentValues.put("triggered_event", this.zzs.zzl().zzX(zzaaVar.zzi));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_TIMESTAMP, Long.valueOf(zzaaVar.zzc.zzc));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE, Long.valueOf(zzaaVar.zzj));
        contentValues.put("expired_event", this.zzs.zzl().zzX(zzaaVar.zzk));
        try {
            if (zze().insertWithOnConflict("conditional_properties", null, contentValues, 5) == -1) {
                this.zzs.zzau().zzb().zzb("Failed to insert/update conditional user property (got -1)", zzem.zzl(str));
            }
        } catch (SQLiteException e2) {
            this.zzs.zzau().zzb().zzc("Error storing conditional user property", zzem.zzl(str), e2);
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0120  */
    @androidx.annotation.WorkerThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.google.android.gms.measurement.internal.zzaa zzo(java.lang.String r31, java.lang.String r32) {
        /*
            Method dump skipped, instructions count: 292
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzai.zzo(java.lang.String, java.lang.String):com.google.android.gms.measurement.internal.zzaa");
    }

    @WorkerThread
    public final int zzp(String str, String str2) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzg();
        zzZ();
        try {
            return zze().delete("conditional_properties", "app_id=? and name=?", new String[]{str, str2});
        } catch (SQLiteException e2) {
            this.zzs.zzau().zzb().zzd("Error deleting conditional property", zzem.zzl(str), this.zzs.zzm().zze(str2), e2);
            return 0;
        }
    }

    @WorkerThread
    public final List<zzaa> zzq(String str, String str2, String str3) {
        Preconditions.checkNotEmpty(str);
        zzg();
        zzZ();
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(str);
        StringBuilder sb = new StringBuilder("app_id=?");
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(str2);
            sb.append(" and origin=?");
        }
        if (!TextUtils.isEmpty(str3)) {
            arrayList.add(String.valueOf(str3).concat(WebSocketServerHandshaker.SUB_PROTOCOL_WILDCARD));
            sb.append(" and name glob ?");
        }
        return zzr(sb.toString(), (String[]) arrayList.toArray(new String[arrayList.size()]));
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0058, code lost:
        r2 = r27.zzs.zzau().zzb();
        r27.zzs.zzc();
        r2.zzb("Read more than the max allowed conditional properties, ignoring extra", 1000);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.List<com.google.android.gms.measurement.internal.zzaa> zzr(java.lang.String r28, java.lang.String[] r29) {
        /*
            Method dump skipped, instructions count: 299
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzai.zzr(java.lang.String, java.lang.String[]):java.util.List");
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x011b A[Catch: SQLiteException -> 0x01e8, all -> 0x0207, TryCatch #0 {SQLiteException -> 0x01e8, blocks: (B:4:0x005f, B:8:0x0069, B:10:0x00cc, B:15:0x00d6, B:18:0x011b, B:19:0x0120, B:21:0x0157, B:24:0x0161, B:25:0x0165, B:26:0x0168, B:28:0x0170, B:32:0x0178, B:35:0x018d, B:36:0x0191, B:38:0x019c, B:39:0x01ae, B:41:0x01bf, B:42:0x01c8, B:44:0x01d1), top: B:60:0x005f }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0157 A[Catch: SQLiteException -> 0x01e8, all -> 0x0207, TryCatch #0 {SQLiteException -> 0x01e8, blocks: (B:4:0x005f, B:8:0x0069, B:10:0x00cc, B:15:0x00d6, B:18:0x011b, B:19:0x0120, B:21:0x0157, B:24:0x0161, B:25:0x0165, B:26:0x0168, B:28:0x0170, B:32:0x0178, B:35:0x018d, B:36:0x0191, B:38:0x019c, B:39:0x01ae, B:41:0x01bf, B:42:0x01c8, B:44:0x01d1), top: B:60:0x005f }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x018d A[Catch: SQLiteException -> 0x01e8, all -> 0x0207, TryCatch #0 {SQLiteException -> 0x01e8, blocks: (B:4:0x005f, B:8:0x0069, B:10:0x00cc, B:15:0x00d6, B:18:0x011b, B:19:0x0120, B:21:0x0157, B:24:0x0161, B:25:0x0165, B:26:0x0168, B:28:0x0170, B:32:0x0178, B:35:0x018d, B:36:0x0191, B:38:0x019c, B:39:0x01ae, B:41:0x01bf, B:42:0x01c8, B:44:0x01d1), top: B:60:0x005f }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x019c A[Catch: SQLiteException -> 0x01e8, all -> 0x0207, TryCatch #0 {SQLiteException -> 0x01e8, blocks: (B:4:0x005f, B:8:0x0069, B:10:0x00cc, B:15:0x00d6, B:18:0x011b, B:19:0x0120, B:21:0x0157, B:24:0x0161, B:25:0x0165, B:26:0x0168, B:28:0x0170, B:32:0x0178, B:35:0x018d, B:36:0x0191, B:38:0x019c, B:39:0x01ae, B:41:0x01bf, B:42:0x01c8, B:44:0x01d1), top: B:60:0x005f }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x01bf A[Catch: SQLiteException -> 0x01e8, all -> 0x0207, TryCatch #0 {SQLiteException -> 0x01e8, blocks: (B:4:0x005f, B:8:0x0069, B:10:0x00cc, B:15:0x00d6, B:18:0x011b, B:19:0x0120, B:21:0x0157, B:24:0x0161, B:25:0x0165, B:26:0x0168, B:28:0x0170, B:32:0x0178, B:35:0x018d, B:36:0x0191, B:38:0x019c, B:39:0x01ae, B:41:0x01bf, B:42:0x01c8, B:44:0x01d1), top: B:60:0x005f }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x01d1 A[Catch: SQLiteException -> 0x01e8, all -> 0x0207, TRY_LEAVE, TryCatch #0 {SQLiteException -> 0x01e8, blocks: (B:4:0x005f, B:8:0x0069, B:10:0x00cc, B:15:0x00d6, B:18:0x011b, B:19:0x0120, B:21:0x0157, B:24:0x0161, B:25:0x0165, B:26:0x0168, B:28:0x0170, B:32:0x0178, B:35:0x018d, B:36:0x0191, B:38:0x019c, B:39:0x01ae, B:41:0x01bf, B:42:0x01c8, B:44:0x01d1), top: B:60:0x005f }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x020b  */
    @androidx.annotation.WorkerThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.google.android.gms.measurement.internal.zzg zzs(java.lang.String r34) {
        /*
            Method dump skipped, instructions count: 527
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzai.zzs(java.lang.String):com.google.android.gms.measurement.internal.zzg");
    }

    @WorkerThread
    public final void zzt(zzg zzgVar) {
        Preconditions.checkNotNull(zzgVar);
        zzg();
        zzZ();
        String zzc2 = zzgVar.zzc();
        Preconditions.checkNotNull(zzc2);
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzc2);
        contentValues.put("app_instance_id", zzgVar.zzd());
        contentValues.put("gmp_app_id", zzgVar.zzf());
        contentValues.put("resettable_device_id_hash", zzgVar.zzl());
        contentValues.put("last_bundle_index", Long.valueOf(zzgVar.zzI()));
        contentValues.put("last_bundle_start_timestamp", Long.valueOf(zzgVar.zzp()));
        contentValues.put("last_bundle_end_timestamp", Long.valueOf(zzgVar.zzr()));
        contentValues.put("app_version", zzgVar.zzt());
        contentValues.put("app_store", zzgVar.zzx());
        contentValues.put("gmp_version", Long.valueOf(zzgVar.zzz()));
        contentValues.put("dev_cert_hash", Long.valueOf(zzgVar.zzB()));
        contentValues.put("measurement_enabled", Boolean.valueOf(zzgVar.zzF()));
        contentValues.put("day", Long.valueOf(zzgVar.zzO()));
        contentValues.put("daily_public_events_count", Long.valueOf(zzgVar.zzQ()));
        contentValues.put("daily_events_count", Long.valueOf(zzgVar.zzS()));
        contentValues.put("daily_conversions_count", Long.valueOf(zzgVar.zzU()));
        contentValues.put("config_fetched_time", Long.valueOf(zzgVar.zzJ()));
        contentValues.put("failed_config_fetch_time", Long.valueOf(zzgVar.zzL()));
        contentValues.put("app_version_int", Long.valueOf(zzgVar.zzv()));
        contentValues.put("firebase_instance_id", zzgVar.zzn());
        contentValues.put("daily_error_events_count", Long.valueOf(zzgVar.zzY()));
        contentValues.put("daily_realtime_events_count", Long.valueOf(zzgVar.zzW()));
        contentValues.put("health_monitor_sample", zzgVar.zzaa());
        contentValues.put("android_id", Long.valueOf(zzgVar.zzad()));
        contentValues.put("adid_reporting_enabled", Boolean.valueOf(zzgVar.zzaf()));
        contentValues.put("admob_app_id", zzgVar.zzh());
        contentValues.put("dynamite_version", Long.valueOf(zzgVar.zzD()));
        List<String> zzaj = zzgVar.zzaj();
        if (zzaj != null) {
            if (zzaj.size() == 0) {
                this.zzs.zzau().zze().zzb("Safelisted events should not be an empty list. appId", zzc2);
            } else {
                contentValues.put("safelisted_events", TextUtils.join(SSLClient.COMMA, zzaj));
            }
        }
        zzov.zzb();
        if (this.zzs.zzc().zzn(zzc2, zzea.zzag)) {
            contentValues.put("ga_app_id", zzgVar.zzj());
        }
        try {
            SQLiteDatabase zze2 = zze();
            if (zze2.update("apps", contentValues, "app_id = ?", new String[]{zzc2}) == 0 && zze2.insertWithOnConflict("apps", null, contentValues, 5) == -1) {
                this.zzs.zzau().zzb().zzb("Failed to insert/update app (got -1). appId", zzem.zzl(zzc2));
            }
        } catch (SQLiteException e2) {
            this.zzs.zzau().zzb().zzc("Error storing app. appId", zzem.zzl(zzc2), e2);
        }
    }

    @WorkerThread
    public final zzag zzu(long j, String str, boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        return zzv(j, str, 1L, false, false, z3, false, z5);
    }

    @WorkerThread
    public final zzag zzv(long j, String str, long j2, boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        Preconditions.checkNotEmpty(str);
        zzg();
        zzZ();
        String[] strArr = {str};
        zzag zzagVar = new zzag();
        Cursor cursor = null;
        try {
            try {
                SQLiteDatabase zze2 = zze();
                Cursor query = zze2.query("apps", new String[]{"day", "daily_events_count", "daily_public_events_count", "daily_conversions_count", "daily_error_events_count", "daily_realtime_events_count"}, "app_id=?", new String[]{str}, null, null, null);
                if (!query.moveToFirst()) {
                    this.zzs.zzau().zze().zzb("Not updating daily counts, app is not known. appId", zzem.zzl(str));
                    query.close();
                    return zzagVar;
                }
                if (query.getLong(0) == j) {
                    zzagVar.zzb = query.getLong(1);
                    zzagVar.zza = query.getLong(2);
                    zzagVar.zzc = query.getLong(3);
                    zzagVar.zzd = query.getLong(4);
                    zzagVar.zze = query.getLong(5);
                }
                if (z) {
                    zzagVar.zzb += j2;
                }
                if (z2) {
                    zzagVar.zza += j2;
                }
                if (z3) {
                    zzagVar.zzc += j2;
                }
                if (z4) {
                    zzagVar.zzd += j2;
                }
                if (z5) {
                    zzagVar.zze += j2;
                }
                ContentValues contentValues = new ContentValues();
                contentValues.put("day", Long.valueOf(j));
                contentValues.put("daily_public_events_count", Long.valueOf(zzagVar.zza));
                contentValues.put("daily_events_count", Long.valueOf(zzagVar.zzb));
                contentValues.put("daily_conversions_count", Long.valueOf(zzagVar.zzc));
                contentValues.put("daily_error_events_count", Long.valueOf(zzagVar.zzd));
                contentValues.put("daily_realtime_events_count", Long.valueOf(zzagVar.zze));
                zze2.update("apps", contentValues, "app_id=?", strArr);
                query.close();
                return zzagVar;
            } catch (SQLiteException e2) {
                this.zzs.zzau().zzb().zzc("Error updating daily counts. appId", zzem.zzl(str), e2);
                if (0 != 0) {
                    cursor.close();
                }
                return zzagVar;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    @WorkerThread
    public final void zzw(String str, byte[] bArr, String str2) {
        Preconditions.checkNotEmpty(str);
        zzg();
        zzZ();
        ContentValues contentValues = new ContentValues();
        contentValues.put("remote_config", bArr);
        contentValues.put("config_last_modified_time", str2);
        try {
            if (zze().update("apps", contentValues, "app_id = ?", new String[]{str}) == 0) {
                this.zzs.zzau().zzb().zzb("Failed to update remote config (got 0). appId", zzem.zzl(str));
            }
        } catch (SQLiteException e2) {
            this.zzs.zzau().zzb().zzc("Error storing remote config. appId", zzem.zzl(str), e2);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0047, code lost:
        if (r2 > (com.google.android.gms.measurement.internal.zzae.zzA() + r0)) goto L_0x0049;
     */
    @androidx.annotation.WorkerThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean zzx(com.google.android.gms.internal.measurement.zzfw r8, boolean r9) {
        /*
            Method dump skipped, instructions count: 296
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzai.zzx(com.google.android.gms.internal.measurement.zzfw, boolean):boolean");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0040  */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Unknown variable types count: 1 */
    @androidx.annotation.WorkerThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String zzy() {
        /*
            r6 = this;
            android.database.sqlite.SQLiteDatabase r0 = r6.zze()
            r1 = 0
            java.lang.String r2 = "select app_id from queue order by has_realtime desc, rowid asc limit 1;"
            android.database.Cursor r0 = r0.rawQuery(r2, r1)     // Catch: all -> 0x0020, SQLiteException -> 0x0022
            boolean r2 = r0.moveToFirst()     // Catch: SQLiteException -> 0x001e, all -> 0x003a
            if (r2 == 0) goto L_0x001a
            r2 = 0
            java.lang.String r1 = r0.getString(r2)     // Catch: SQLiteException -> 0x001e, all -> 0x003a
            r0.close()
            return r1
        L_0x001a:
            r0.close()
            return r1
        L_0x001e:
            r2 = move-exception
            goto L_0x0025
        L_0x0020:
            r0 = move-exception
            goto L_0x003e
        L_0x0022:
            r0 = move-exception
            r2 = r0
            r0 = r1
        L_0x0025:
            com.google.android.gms.measurement.internal.zzfu r3 = r6.zzs     // Catch: all -> 0x003a
            com.google.android.gms.measurement.internal.zzem r3 = r3.zzau()     // Catch: all -> 0x003a
            com.google.android.gms.measurement.internal.zzek r3 = r3.zzb()     // Catch: all -> 0x003a
            java.lang.String r4 = "Database error getting next bundle app id"
            r3.zzb(r4, r2)     // Catch: all -> 0x003a
            if (r0 == 0) goto L_0x0039
            r0.close()
        L_0x0039:
            return r1
        L_0x003a:
            r1 = move-exception
            r5 = r1
            r1 = r0
            r0 = r5
        L_0x003e:
            if (r1 == 0) goto L_0x0043
            r1.close()
        L_0x0043:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzai.zzy():java.lang.String");
    }

    public final boolean zzz() {
        return zzab("select count(1) > 0 from queue where has_realtime = 1", null) != 0;
    }
}
