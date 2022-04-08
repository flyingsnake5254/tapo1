package com.tplink.libtpanalytics.database.e;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.tplink.libtpanalytics.database.d.c;
import java.util.ArrayList;
import java.util.List;

/* compiled from: TempEventDao_Impl.java */
/* loaded from: classes3.dex */
public final class f implements e {
    private final RoomDatabase a;

    /* renamed from: b  reason: collision with root package name */
    private final EntityInsertionAdapter<c> f11986b;

    /* renamed from: c  reason: collision with root package name */
    private final SharedSQLiteStatement f11987c;

    /* compiled from: TempEventDao_Impl.java */
    /* loaded from: classes3.dex */
    class a extends EntityInsertionAdapter<c> {
        a(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        /* renamed from: a */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, c cVar) {
            if (cVar.a() == null) {
                supportSQLiteStatement.bindNull(1);
            } else {
                supportSQLiteStatement.bindString(1, cVar.a());
            }
            supportSQLiteStatement.bindLong(2, cVar.b());
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "INSERT OR REPLACE INTO `TEMP_EVENT` (`EVENT_ID`,`LEN`) VALUES (?,?)";
        }
    }

    /* compiled from: TempEventDao_Impl.java */
    /* loaded from: classes3.dex */
    class b extends SharedSQLiteStatement {
        b(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "DELETE FROM TEMP_EVENT";
        }
    }

    public f(RoomDatabase roomDatabase) {
        this.a = roomDatabase;
        this.f11986b = new a(roomDatabase);
        this.f11987c = new b(roomDatabase);
    }

    @Override // com.tplink.libtpanalytics.database.e.e
    public void a() {
        this.a.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.f11987c.acquire();
        this.a.beginTransaction();
        try {
            acquire.executeUpdateDelete();
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
            this.f11987c.release(acquire);
        }
    }

    @Override // com.tplink.libtpanalytics.database.e.e
    public List<String> b(int i) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("select EVENT_ID from TEMP_EVENT limit ?, 300", 1);
        acquire.bindLong(1, i);
        this.a.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.a, acquire, false, null);
        try {
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                arrayList.add(query.getString(0));
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    @Override // com.tplink.libtpanalytics.database.e.e
    public int count() {
        int i = 0;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT count(*) FROM TEMP_EVENT", 0);
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
}
