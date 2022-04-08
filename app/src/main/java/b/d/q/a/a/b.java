package b.d.q.a.a;

import android.database.Cursor;
import android.text.TextUtils;
import android.util.Log;
import b.d.w.c.a;
import com.tplink.libtpmediaother.database.model.ModeSettingInfoDao;
import com.tplink.libtpmediastatistics.SSLClient;
import java.util.ArrayList;
import java.util.List;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.internal.DaoConfig;

/* compiled from: MigrationHelper.java */
/* loaded from: classes3.dex */
public class b {
    private static b a;

    private static Boolean a(Database database, String str) {
        Cursor rawQuery = database.rawQuery("SELECT count(*) FROM sqlite_master WHERE type='table' AND name='" + str + "'", null);
        if (!rawQuery.moveToNext()) {
            return Boolean.FALSE;
        }
        if (rawQuery.getInt(0) > 0) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    private void b(Database database, Class<? extends AbstractDao<?, ?>>... clsArr) {
        a.e("MigrationHelper", "generateTempTables\n");
        for (Class<? extends AbstractDao<?, ?>> cls : clsArr) {
            DaoConfig daoConfig = new DaoConfig(database, cls);
            String str = daoConfig.tablename;
            String concat = str.concat("_TEMP");
            if (a(database, str).booleanValue()) {
                ArrayList arrayList = new ArrayList();
                StringBuilder sb = new StringBuilder();
                sb.append("CREATE TABLE ");
                sb.append(concat);
                sb.append(" (");
                String str2 = "";
                int i = 0;
                while (true) {
                    Property[] propertyArr = daoConfig.properties;
                    if (i >= propertyArr.length) {
                        break;
                    }
                    String str3 = propertyArr[i].columnName;
                    if (c(database, str).contains(str3)) {
                        arrayList.add(str3);
                        String str4 = null;
                        try {
                            str4 = f(daoConfig.properties[i].type);
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                        sb.append(str2);
                        sb.append(str3);
                        sb.append(SSLClient.WHITE_SPACE);
                        sb.append(str4);
                        if (daoConfig.properties[i].primaryKey) {
                            sb.append(" PRIMARY KEY");
                        }
                        str2 = SSLClient.COMMA;
                    }
                    i++;
                }
                sb.append(");");
                database.execSQL(sb.toString());
                a.e("MigrationHelper", sb.toString());
                StringBuilder sb2 = new StringBuilder();
                sb2.append("INSERT INTO ");
                sb2.append(concat);
                sb2.append(" (");
                sb2.append(TextUtils.join(SSLClient.COMMA, arrayList));
                sb2.append(") SELECT ");
                sb2.append(TextUtils.join(SSLClient.COMMA, arrayList));
                sb2.append(" FROM ");
                sb2.append(str);
                sb2.append(";");
                database.execSQL(sb2.toString());
                a.e("MigrationHelper", sb2.toString());
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0052, code lost:
        if (r1 == null) goto L_0x0055;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0055, code lost:
        return r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.util.List<java.lang.String> c(org.greenrobot.greendao.database.Database r5, java.lang.String r6) {
        /*
            r4 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 0
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: all -> 0x0036, Exception -> 0x0038
            r2.<init>()     // Catch: all -> 0x0036, Exception -> 0x0038
            java.lang.String r3 = "SELECT * FROM "
            r2.append(r3)     // Catch: all -> 0x0036, Exception -> 0x0038
            r2.append(r6)     // Catch: all -> 0x0036, Exception -> 0x0038
            java.lang.String r3 = " limit 1"
            r2.append(r3)     // Catch: all -> 0x0036, Exception -> 0x0038
            java.lang.String r2 = r2.toString()     // Catch: all -> 0x0036, Exception -> 0x0038
            android.database.Cursor r1 = r5.rawQuery(r2, r1)     // Catch: all -> 0x0036, Exception -> 0x0038
            if (r1 == 0) goto L_0x0030
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch: all -> 0x0036, Exception -> 0x0038
            java.lang.String[] r2 = r1.getColumnNames()     // Catch: all -> 0x0036, Exception -> 0x0038
            java.util.List r2 = java.util.Arrays.asList(r2)     // Catch: all -> 0x0036, Exception -> 0x0038
            r5.<init>(r2)     // Catch: all -> 0x0036, Exception -> 0x0038
            r0 = r5
        L_0x0030:
            if (r1 == 0) goto L_0x0055
        L_0x0032:
            r1.close()
            goto L_0x0055
        L_0x0036:
            r5 = move-exception
            goto L_0x0056
        L_0x0038:
            r5 = move-exception
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: all -> 0x0036
            r2.<init>()     // Catch: all -> 0x0036
            java.lang.String r3 = r5.getMessage()     // Catch: all -> 0x0036
            r2.append(r3)     // Catch: all -> 0x0036
            r2.append(r5)     // Catch: all -> 0x0036
            java.lang.String r2 = r2.toString()     // Catch: all -> 0x0036
            b.d.w.c.a.e(r6, r2)     // Catch: all -> 0x0036
            r5.printStackTrace()     // Catch: all -> 0x0036
            if (r1 == 0) goto L_0x0055
            goto L_0x0032
        L_0x0055:
            return r0
        L_0x0056:
            if (r1 == 0) goto L_0x005b
            r1.close()
        L_0x005b:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: b.d.q.a.a.b.c(org.greenrobot.greendao.database.Database, java.lang.String):java.util.List");
    }

    public static b d() {
        if (a == null) {
            a = new b();
        }
        return a;
    }

    private static Object e(Class<?> cls, String str, String str2) {
        if (ModeSettingInfoDao.TABLENAME.equals(str) && cls.equals(Integer.TYPE)) {
            if ("MSG_PUSH_START_HOUR".equals(str2)) {
                return " INTEGER DEFAULT 9";
            }
            if ("MSG_PUSH_END_HOUR".equals(str2)) {
                return " INTEGER DEFAULT 17";
            }
            if ("MSG_PUSH_DAYS".equals(str2)) {
                return " INTEGER DEFAULT 127";
            }
        }
        return cls.equals(Integer.TYPE) ? " INTEGER DEFAULT 0" : cls.equals(Long.TYPE) ? " Long DEFAULT 0" : (!cls.equals(String.class) && cls.equals(Boolean.TYPE)) ? " NUMERIC DEFAULT 0" : " TEXT";
    }

    private String f(Class<?> cls) throws Exception {
        if (cls.equals(String.class)) {
            return "TEXT";
        }
        if (cls.equals(Integer.class) || cls.equals(Integer.TYPE)) {
            return "INTEGER";
        }
        if (cls.equals(Long.class) || cls.equals(Long.TYPE)) {
            return "LONG";
        }
        if (cls.equals(Boolean.class) || cls.equals(Boolean.TYPE)) {
            return "BOOLEAN";
        }
        Exception exc = new Exception("MIGRATION HELPER - CLASS DOESN'T MATCH WITH THE CURRENT PARAMETERS".concat(" - Class: ").concat(cls.toString()));
        exc.printStackTrace();
        throw exc;
    }

    private void h(Database database, Class<? extends AbstractDao<?, ?>>... clsArr) {
        a.e("MigrationHelper", "restoreData\n");
        for (Class<? extends AbstractDao<?, ?>> cls : clsArr) {
            DaoConfig daoConfig = new DaoConfig(database, cls);
            String str = daoConfig.tablename;
            String concat = str.concat("_TEMP");
            ArrayList arrayList = new ArrayList();
            if (a(database, concat).booleanValue()) {
                List<String> c2 = c(database, concat);
                int i = 0;
                while (true) {
                    Property[] propertyArr = daoConfig.properties;
                    if (i >= propertyArr.length) {
                        break;
                    }
                    String str2 = propertyArr[i].columnName;
                    if (!c2.contains(str2)) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("ALTER TABLE " + concat + " ADD COLUMN " + str2 + e(daoConfig.properties[i].type, str, str2));
                        database.execSQL(sb.toString());
                    }
                    arrayList.add(str2);
                    i++;
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append("INSERT INTO ");
                sb2.append(str);
                sb2.append(" (");
                sb2.append(TextUtils.join(SSLClient.COMMA, arrayList));
                sb2.append(") SELECT ");
                sb2.append(TextUtils.join(SSLClient.COMMA, arrayList));
                sb2.append(" FROM ");
                sb2.append(concat);
                sb2.append(";");
                a.e("MigrationHelper", sb2.toString());
                database.execSQL(sb2.toString());
                database.execSQL("DROP TABLE " + concat);
            }
        }
    }

    public void g(Database database, Class<? extends AbstractDao<?, ?>>... clsArr) {
        b(database, clsArr);
        com.tplink.libtpmediaother.database.model.a.b(database, true);
        com.tplink.libtpmediaother.database.model.a.a(database, false);
        try {
            h(database, clsArr);
        } catch (Exception e2) {
            a.e("MigrationHelper", "db migrate fail");
            a.e("MigrationHelper", Log.getStackTraceString(e2));
        }
    }
}
