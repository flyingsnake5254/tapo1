package com.tplink.libtpanalytics.database.e;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import io.netty.handler.codec.http.websocketx.WebSocketServerHandshaker;
import java.util.ArrayList;
import java.util.List;

/* compiled from: EventDao_Impl.java */
/* loaded from: classes3.dex */
public final class d implements c {
    private final RoomDatabase a;

    /* renamed from: b  reason: collision with root package name */
    private final EntityInsertionAdapter<com.tplink.libtpanalytics.database.d.b> f11983b;

    /* renamed from: c  reason: collision with root package name */
    private final EntityDeletionOrUpdateAdapter<com.tplink.libtpanalytics.database.d.b> f11984c;

    /* renamed from: d  reason: collision with root package name */
    private final SharedSQLiteStatement f11985d;

    /* compiled from: EventDao_Impl.java */
    /* loaded from: classes3.dex */
    class a extends EntityInsertionAdapter<com.tplink.libtpanalytics.database.d.b> {
        a(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        /* renamed from: a */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, com.tplink.libtpanalytics.database.d.b bVar) {
            if (bVar.e() == null) {
                supportSQLiteStatement.bindNull(1);
            } else {
                supportSQLiteStatement.bindString(1, bVar.e());
            }
            if (bVar.f() == null) {
                supportSQLiteStatement.bindNull(2);
            } else {
                supportSQLiteStatement.bindString(2, bVar.f());
            }
            if (bVar.m() == null) {
                supportSQLiteStatement.bindNull(3);
            } else {
                supportSQLiteStatement.bindString(3, bVar.m());
            }
            supportSQLiteStatement.bindLong(4, bVar.l());
            if (bVar.d() == null) {
                supportSQLiteStatement.bindNull(5);
            } else {
                supportSQLiteStatement.bindString(5, bVar.d());
            }
            if (bVar.j() == null) {
                supportSQLiteStatement.bindNull(6);
            } else {
                supportSQLiteStatement.bindString(6, bVar.j());
            }
            supportSQLiteStatement.bindLong(7, bVar.h());
            supportSQLiteStatement.bindLong(8, bVar.b());
            if (bVar.a() == null) {
                supportSQLiteStatement.bindNull(9);
            } else {
                supportSQLiteStatement.bindString(9, bVar.a());
            }
            if (bVar.k() == null) {
                supportSQLiteStatement.bindNull(10);
            } else {
                supportSQLiteStatement.bindString(10, bVar.k());
            }
            if (bVar.i() == null) {
                supportSQLiteStatement.bindNull(11);
            } else {
                supportSQLiteStatement.bindString(11, bVar.i());
            }
            if (bVar.g() == null) {
                supportSQLiteStatement.bindNull(12);
            } else {
                supportSQLiteStatement.bindString(12, bVar.g());
            }
            if (bVar.c() == null) {
                supportSQLiteStatement.bindNull(13);
            } else {
                supportSQLiteStatement.bindString(13, bVar.c());
            }
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "INSERT OR REPLACE INTO `EVENT` (`EVENT_ID`,`EVENT_NAME`,`USER_ID`,`TIME`,`ENCRYPTED_PARAM`,`PLAINTEXT_PARAM`,`LEN`,`ENCRYPT_VER`,`APP_VER`,`REGION`,`OS_VER`,`LANGUAGE`,`ENCRYPT_VERSION_ID`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
        }
    }

    /* compiled from: EventDao_Impl.java */
    /* loaded from: classes3.dex */
    class b extends EntityDeletionOrUpdateAdapter<com.tplink.libtpanalytics.database.d.b> {
        b(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        /* renamed from: a */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, com.tplink.libtpanalytics.database.d.b bVar) {
            if (bVar.e() == null) {
                supportSQLiteStatement.bindNull(1);
            } else {
                supportSQLiteStatement.bindString(1, bVar.e());
            }
        }

        @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "DELETE FROM `EVENT` WHERE `EVENT_ID` = ?";
        }
    }

    /* compiled from: EventDao_Impl.java */
    /* loaded from: classes3.dex */
    class c extends SharedSQLiteStatement {
        c(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "DELETE FROM EVENT";
        }
    }

    public d(RoomDatabase roomDatabase) {
        this.a = roomDatabase;
        this.f11983b = new a(roomDatabase);
        this.f11984c = new b(roomDatabase);
        this.f11985d = new c(roomDatabase);
    }

    @Override // com.tplink.libtpanalytics.database.e.c
    public void a() {
        this.a.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.f11985d.acquire();
        this.a.beginTransaction();
        try {
            acquire.executeUpdateDelete();
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
            this.f11985d.release(acquire);
        }
    }

    @Override // com.tplink.libtpanalytics.database.e.c
    public void b(List<com.tplink.libtpanalytics.database.d.b> list) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            this.f11984c.handleMultiple(list);
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }

    @Override // com.tplink.libtpanalytics.database.e.c
    public void c(com.tplink.libtpanalytics.database.d.b... bVarArr) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            this.f11983b.insert(bVarArr);
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }

    @Override // com.tplink.libtpanalytics.database.e.c
    public int count() {
        int i = 0;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT count(*) FROM EVENT", 0);
        this.a.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.a, acquire, false, null);
        try {
            if (query.moveToFirst()) {
                i = query.getInt(0);
            }
            return i;
        } finally {
            query.close();
            acquire.release();
        }
    }

    @Override // com.tplink.libtpanalytics.database.e.c
    public List<com.tplink.libtpanalytics.database.d.b> d(List<String> list) {
        RoomSQLiteQuery roomSQLiteQuery;
        Throwable th;
        StringBuilder newStringBuilder = StringUtil.newStringBuilder();
        newStringBuilder.append("SELECT ");
        newStringBuilder.append(WebSocketServerHandshaker.SUB_PROTOCOL_WILDCARD);
        newStringBuilder.append(" FROM EVENT WHERE EVENT_ID IN (");
        int size = list.size();
        StringUtil.appendPlaceholders(newStringBuilder, size);
        newStringBuilder.append(")");
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire(newStringBuilder.toString(), size + 0);
        int i = 1;
        for (String str : list) {
            if (str == null) {
                acquire.bindNull(i);
            } else {
                acquire.bindString(i, str);
            }
            i++;
        }
        this.a.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.a, acquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "EVENT_ID");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "EVENT_NAME");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "USER_ID");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "TIME");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "ENCRYPTED_PARAM");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "PLAINTEXT_PARAM");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "LEN");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "ENCRYPT_VER");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "APP_VER");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "REGION");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "OS_VER");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "LANGUAGE");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "ENCRYPT_VERSION_ID");
            roomSQLiteQuery = acquire;
            try {
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    com.tplink.libtpanalytics.database.d.b bVar = new com.tplink.libtpanalytics.database.d.b();
                    bVar.r(query.getString(columnIndexOrThrow));
                    bVar.s(query.getString(columnIndexOrThrow2));
                    bVar.z(query.getString(columnIndexOrThrow3));
                    bVar.y(query.getLong(columnIndexOrThrow4));
                    bVar.q(query.getString(columnIndexOrThrow5));
                    bVar.w(query.getString(columnIndexOrThrow6));
                    bVar.u(query.getInt(columnIndexOrThrow7));
                    bVar.o(query.getInt(columnIndexOrThrow8));
                    bVar.n(query.getString(columnIndexOrThrow9));
                    bVar.x(query.getString(columnIndexOrThrow10));
                    bVar.v(query.getString(columnIndexOrThrow11));
                    bVar.t(query.getString(columnIndexOrThrow12));
                    bVar.p(query.getString(columnIndexOrThrow13));
                    arrayList.add(bVar);
                    arrayList = arrayList;
                    columnIndexOrThrow = columnIndexOrThrow;
                }
                query.close();
                roomSQLiteQuery.release();
                return arrayList;
            } catch (Throwable th2) {
                th = th2;
                query.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            roomSQLiteQuery = acquire;
        }
    }
}
