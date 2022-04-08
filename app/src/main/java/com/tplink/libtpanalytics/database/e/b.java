package com.tplink.libtpanalytics.database.e;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.util.ArrayList;
import java.util.List;

/* compiled from: EncryptInfoDao_Impl.java */
/* loaded from: classes3.dex */
public final class b implements a {
    private final RoomDatabase a;

    /* renamed from: b  reason: collision with root package name */
    private final EntityInsertionAdapter<com.tplink.libtpanalytics.database.d.a> f11981b;

    /* renamed from: c  reason: collision with root package name */
    private final SharedSQLiteStatement f11982c;

    /* compiled from: EncryptInfoDao_Impl.java */
    /* loaded from: classes3.dex */
    class a extends EntityInsertionAdapter<com.tplink.libtpanalytics.database.d.a> {
        a(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        /* renamed from: a */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, com.tplink.libtpanalytics.database.d.a aVar) {
            if (aVar.a() == null) {
                supportSQLiteStatement.bindNull(1);
            } else {
                supportSQLiteStatement.bindString(1, aVar.a());
            }
            if (aVar.d() == null) {
                supportSQLiteStatement.bindNull(2);
            } else {
                supportSQLiteStatement.bindString(2, aVar.d());
            }
            if (aVar.b() == null) {
                supportSQLiteStatement.bindNull(3);
            } else {
                supportSQLiteStatement.bindString(3, aVar.b());
            }
            supportSQLiteStatement.bindLong(4, aVar.c());
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "INSERT OR REPLACE INTO `ENCRYPT` (`ENCRYPT_VERSION_ID`,`TRANSFORMATION`,`KEY`,`KEY_SIZE`) VALUES (?,?,?,?)";
        }
    }

    /* compiled from: EncryptInfoDao_Impl.java */
    /* renamed from: com.tplink.libtpanalytics.database.e.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    class C0248b extends SharedSQLiteStatement {
        C0248b(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "DELETE FROM ENCRYPT";
        }
    }

    public b(RoomDatabase roomDatabase) {
        this.a = roomDatabase;
        this.f11981b = new a(roomDatabase);
        this.f11982c = new C0248b(roomDatabase);
    }

    @Override // com.tplink.libtpanalytics.database.e.a
    public void a() {
        this.a.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.f11982c.acquire();
        this.a.beginTransaction();
        try {
            acquire.executeUpdateDelete();
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
            this.f11982c.release(acquire);
        }
    }

    @Override // com.tplink.libtpanalytics.database.e.a
    public void b(com.tplink.libtpanalytics.database.d.a... aVarArr) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            this.f11981b.insert(aVarArr);
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }

    @Override // com.tplink.libtpanalytics.database.e.a
    public List<com.tplink.libtpanalytics.database.d.a> c() {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM ENCRYPT", 0);
        this.a.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.a, acquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "ENCRYPT_VERSION_ID");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "TRANSFORMATION");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "KEY");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "KEY_SIZE");
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                com.tplink.libtpanalytics.database.d.a aVar = new com.tplink.libtpanalytics.database.d.a();
                aVar.e(query.getString(columnIndexOrThrow));
                aVar.h(query.getString(columnIndexOrThrow2));
                aVar.f(query.getString(columnIndexOrThrow3));
                aVar.g(query.getInt(columnIndexOrThrow4));
                arrayList.add(aVar);
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }
}
