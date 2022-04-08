package com.tplink.libtpmediaother.database.model;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.internal.DaoConfig;

/* loaded from: classes3.dex */
public class FileMemoryInfoDao extends AbstractDao<d, String> {
    public static final String TABLENAME = "FILE_MEMORY_INFO";

    /* loaded from: classes3.dex */
    public static class Properties {
        public static final Property i;
        public static final Property j;
        public static final Property a = new Property(0, String.class, "utcTimestamp", true, "UTC_TIMESTAMP");

        /* renamed from: b  reason: collision with root package name */
        public static final Property f12588b = new Property(1, String.class, "deviceAlias", false, "DEVICE_ALIAS");

        /* renamed from: c  reason: collision with root package name */
        public static final Property f12589c = new Property(2, String.class, "deviceModel", false, "DEVICE_MODEL");

        /* renamed from: d  reason: collision with root package name */
        public static final Property f12590d = new Property(3, String.class, "deviceIdMD5", false, "DEVICE_ID_MD5");

        /* renamed from: e  reason: collision with root package name */
        public static final Property f12591e = new Property(4, String.class, "locationUrl", false, "LOCATION_URL");

        /* renamed from: f  reason: collision with root package name */
        public static final Property f12592f = new Property(5, String.class, "locationName", false, "LOCATION_NAME");
        public static final Property g = new Property(6, String.class, "associatedAccount", false, "ASSOCIATED_ACCOUNT");
        public static final Property h = new Property(7, String.class, "fileAbsolutePath", false, "FILE_ABSOLUTE_PATH");
        public static final Property k = new Property(10, String.class, "snapshotImagePath", false, "SNAPSHOT_IMAGE_PATH");
        public static final Property l = new Property(11, Integer.TYPE, "videoLength", false, "VIDEO_LENGTH");

        static {
            Class cls = Boolean.TYPE;
            i = new Property(8, cls, "isFavorite", false, "IS_FAVORITE");
            j = new Property(9, cls, "isDeletedByUser", false, "IS_DELETED_BY_USER");
        }
    }

    public FileMemoryInfoDao(DaoConfig daoConfig, b bVar) {
        super(daoConfig, bVar);
    }

    public static void c(Database database, boolean z) {
        String str = z ? "IF NOT EXISTS " : "";
        database.execSQL("CREATE TABLE " + str + "\"FILE_MEMORY_INFO\" (\"UTC_TIMESTAMP\" TEXT PRIMARY KEY NOT NULL ,\"DEVICE_ALIAS\" TEXT,\"DEVICE_MODEL\" TEXT,\"DEVICE_ID_MD5\" TEXT,\"LOCATION_URL\" TEXT,\"LOCATION_NAME\" TEXT,\"ASSOCIATED_ACCOUNT\" TEXT,\"FILE_ABSOLUTE_PATH\" TEXT,\"IS_FAVORITE\" INTEGER NOT NULL ,\"IS_DELETED_BY_USER\" INTEGER NOT NULL ,\"SNAPSHOT_IMAGE_PATH\" TEXT,\"VIDEO_LENGTH\" INTEGER NOT NULL );");
    }

    public static void d(Database database, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("DROP TABLE ");
        sb.append(z ? "IF EXISTS " : "");
        sb.append("\"FILE_MEMORY_INFO\"");
        database.execSQL(sb.toString());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public final void bindValues(SQLiteStatement sQLiteStatement, d dVar) {
        sQLiteStatement.clearBindings();
        String k = dVar.k();
        if (k != null) {
            sQLiteStatement.bindString(1, k);
        }
        String b2 = dVar.b();
        if (b2 != null) {
            sQLiteStatement.bindString(2, b2);
        }
        String d2 = dVar.d();
        if (d2 != null) {
            sQLiteStatement.bindString(3, d2);
        }
        String c2 = dVar.c();
        if (c2 != null) {
            sQLiteStatement.bindString(4, c2);
        }
        String i = dVar.i();
        if (i != null) {
            sQLiteStatement.bindString(5, i);
        }
        String h = dVar.h();
        if (h != null) {
            sQLiteStatement.bindString(6, h);
        }
        String a = dVar.a();
        if (a != null) {
            sQLiteStatement.bindString(7, a);
        }
        String e2 = dVar.e();
        if (e2 != null) {
            sQLiteStatement.bindString(8, e2);
        }
        long j = 1;
        sQLiteStatement.bindLong(9, dVar.g() ? 1L : 0L);
        if (!dVar.f()) {
            j = 0;
        }
        sQLiteStatement.bindLong(10, j);
        String j2 = dVar.j();
        if (j2 != null) {
            sQLiteStatement.bindString(11, j2);
        }
        sQLiteStatement.bindLong(12, dVar.l());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: b */
    public final void bindValues(DatabaseStatement databaseStatement, d dVar) {
        databaseStatement.clearBindings();
        String k = dVar.k();
        if (k != null) {
            databaseStatement.bindString(1, k);
        }
        String b2 = dVar.b();
        if (b2 != null) {
            databaseStatement.bindString(2, b2);
        }
        String d2 = dVar.d();
        if (d2 != null) {
            databaseStatement.bindString(3, d2);
        }
        String c2 = dVar.c();
        if (c2 != null) {
            databaseStatement.bindString(4, c2);
        }
        String i = dVar.i();
        if (i != null) {
            databaseStatement.bindString(5, i);
        }
        String h = dVar.h();
        if (h != null) {
            databaseStatement.bindString(6, h);
        }
        String a = dVar.a();
        if (a != null) {
            databaseStatement.bindString(7, a);
        }
        String e2 = dVar.e();
        if (e2 != null) {
            databaseStatement.bindString(8, e2);
        }
        long j = 1;
        databaseStatement.bindLong(9, dVar.g() ? 1L : 0L);
        if (!dVar.f()) {
            j = 0;
        }
        databaseStatement.bindLong(10, j);
        String j2 = dVar.j();
        if (j2 != null) {
            databaseStatement.bindString(11, j2);
        }
        databaseStatement.bindLong(12, dVar.l());
    }

    /* renamed from: e */
    public String getKey(d dVar) {
        if (dVar != null) {
            return dVar.k();
        }
        return null;
    }

    /* renamed from: f */
    public boolean hasKey(d dVar) {
        return dVar.k() != null;
    }

    /* renamed from: g */
    public d readEntity(Cursor cursor, int i) {
        int i2 = i + 0;
        String str = null;
        String string = cursor.isNull(i2) ? null : cursor.getString(i2);
        int i3 = i + 1;
        String string2 = cursor.isNull(i3) ? null : cursor.getString(i3);
        int i4 = i + 2;
        String string3 = cursor.isNull(i4) ? null : cursor.getString(i4);
        int i5 = i + 3;
        String string4 = cursor.isNull(i5) ? null : cursor.getString(i5);
        int i6 = i + 4;
        String string5 = cursor.isNull(i6) ? null : cursor.getString(i6);
        int i7 = i + 5;
        String string6 = cursor.isNull(i7) ? null : cursor.getString(i7);
        int i8 = i + 6;
        String string7 = cursor.isNull(i8) ? null : cursor.getString(i8);
        int i9 = i + 7;
        String string8 = cursor.isNull(i9) ? null : cursor.getString(i9);
        boolean z = true;
        boolean z2 = cursor.getShort(i + 8) != 0;
        if (cursor.getShort(i + 9) == 0) {
            z = false;
        }
        int i10 = i + 10;
        if (!cursor.isNull(i10)) {
            str = cursor.getString(i10);
        }
        return new d(string, string2, string3, string4, string5, string6, string7, string8, z2, z, str, cursor.getInt(i + 11));
    }

    /* renamed from: h */
    public void readEntity(Cursor cursor, d dVar, int i) {
        int i2 = i + 0;
        String str = null;
        dVar.w(cursor.isNull(i2) ? null : cursor.getString(i2));
        int i3 = i + 1;
        dVar.n(cursor.isNull(i3) ? null : cursor.getString(i3));
        int i4 = i + 2;
        dVar.p(cursor.isNull(i4) ? null : cursor.getString(i4));
        int i5 = i + 3;
        dVar.o(cursor.isNull(i5) ? null : cursor.getString(i5));
        int i6 = i + 4;
        dVar.u(cursor.isNull(i6) ? null : cursor.getString(i6));
        int i7 = i + 5;
        dVar.t(cursor.isNull(i7) ? null : cursor.getString(i7));
        int i8 = i + 6;
        dVar.m(cursor.isNull(i8) ? null : cursor.getString(i8));
        int i9 = i + 7;
        dVar.q(cursor.isNull(i9) ? null : cursor.getString(i9));
        boolean z = true;
        dVar.s(cursor.getShort(i + 8) != 0);
        if (cursor.getShort(i + 9) == 0) {
            z = false;
        }
        dVar.r(z);
        int i10 = i + 10;
        if (!cursor.isNull(i10)) {
            str = cursor.getString(i10);
        }
        dVar.v(str);
        dVar.x(cursor.getInt(i + 11));
    }

    /* renamed from: i */
    public String readKey(Cursor cursor, int i) {
        int i2 = i + 0;
        if (cursor.isNull(i2)) {
            return null;
        }
        return cursor.getString(i2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.greenrobot.greendao.AbstractDao
    public final boolean isEntityUpdateable() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: j */
    public final String updateKeyAfterInsert(d dVar, long j) {
        return dVar.k();
    }
}
