package com.tplink.libtpmediaother.database.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import org.greenrobot.greendao.AbstractDaoMaster;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseOpenHelper;
import org.greenrobot.greendao.database.StandardDatabase;
import org.greenrobot.greendao.identityscope.IdentityScopeType;

/* compiled from: DaoMaster.java */
/* loaded from: classes3.dex */
public class a extends AbstractDaoMaster {

    /* compiled from: DaoMaster.java */
    /* renamed from: com.tplink.libtpmediaother.database.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static abstract class AbstractC0257a extends DatabaseOpenHelper {
        public AbstractC0257a(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory) {
            super(context, str, cursorFactory, 5);
        }

        @Override // org.greenrobot.greendao.database.DatabaseOpenHelper
        public void onCreate(Database database) {
            Log.i("greenDAO", "Creating tables for schema version 5");
            a.a(database, false);
        }
    }

    public a(SQLiteDatabase sQLiteDatabase) {
        this(new StandardDatabase(sQLiteDatabase));
    }

    public static void a(Database database, boolean z) {
        DeviceInfoDao.c(database, z);
        FileMemoryInfoDao.c(database, z);
        ModeSettingInfoDao.c(database, z);
    }

    public static void b(Database database, boolean z) {
        DeviceInfoDao.d(database, z);
        FileMemoryInfoDao.d(database, z);
        ModeSettingInfoDao.d(database, z);
    }

    /* renamed from: c */
    public b newSession() {
        return new b(this.db, IdentityScopeType.Session, this.daoConfigMap);
    }

    /* renamed from: d */
    public b newSession(IdentityScopeType identityScopeType) {
        return new b(this.db, identityScopeType, this.daoConfigMap);
    }

    public a(Database database) {
        super(database, 5);
        registerDaoClass(DeviceInfoDao.class);
        registerDaoClass(FileMemoryInfoDao.class);
        registerDaoClass(ModeSettingInfoDao.class);
    }
}
