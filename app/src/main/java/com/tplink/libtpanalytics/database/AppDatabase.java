package com.tplink.libtpanalytics.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import com.tplink.libtpanalytics.database.d.a;
import com.tplink.libtpanalytics.database.d.b;
import com.tplink.libtpanalytics.database.d.c;
import com.tplink.libtpanalytics.database.e.e;

@Database(entities = {b.class, c.class, a.class}, version = 3)
/* loaded from: classes3.dex */
public abstract class AppDatabase extends RoomDatabase {
    public abstract com.tplink.libtpanalytics.database.e.a a();

    public abstract com.tplink.libtpanalytics.database.e.c b();

    public abstract e c();
}
