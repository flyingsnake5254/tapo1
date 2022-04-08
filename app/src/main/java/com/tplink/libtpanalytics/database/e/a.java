package com.tplink.libtpanalytics.database.e;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;

/* compiled from: EncryptInfoDao.java */
@Dao
/* loaded from: classes3.dex */
public interface a {
    @Query("DELETE FROM ENCRYPT")
    void a();

    @Insert(onConflict = 1)
    void b(com.tplink.libtpanalytics.database.d.a... aVarArr);

    @Query("SELECT * FROM ENCRYPT")
    List<com.tplink.libtpanalytics.database.d.a> c();
}
