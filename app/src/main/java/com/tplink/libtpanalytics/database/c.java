package com.tplink.libtpanalytics.database;

import android.app.Application;
import androidx.room.Room;
import b.d.c.c.b;
import com.tplink.libtpanalytics.database.e.a;
import com.tplink.libtpanalytics.database.e.e;
import com.tplink.libtpanalytics.utils.i;
import io.reactivex.g0.j;
import io.reactivex.q;
import java.util.ArrayList;
import java.util.List;

/* compiled from: TADatabaseImp.java */
/* loaded from: classes3.dex */
public class c implements b {
    private com.tplink.libtpanalytics.database.e.c a;

    /* renamed from: b  reason: collision with root package name */
    private e f11968b;

    /* renamed from: c  reason: collision with root package name */
    private a f11969c;

    /* renamed from: d  reason: collision with root package name */
    private volatile boolean f11970d = false;

    /* renamed from: e  reason: collision with root package name */
    private AppDatabase f11971e;

    private void l() {
        if (!this.f11970d) {
            throw new DBException("please call init(...) first");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m */
    public /* synthetic */ Integer n(Integer num) throws Exception {
        try {
            this.f11968b.a();
            this.f11971e.beginTransaction();
            this.f11971e.getOpenHelper().getWritableDatabase().execSQL("insert into TEMP_EVENT SELECT EVENT_ID, LEN FROM EVENT Order by TIME Desc , EVENT_ID Desc");
            this.f11971e.setTransactionSuccessful();
            this.f11971e.endTransaction();
            return Integer.valueOf(this.f11968b.count());
        } catch (Exception e2) {
            i.b("----copyEventsToTempTable Failed----");
            d();
            e2.printStackTrace();
            return -1;
        }
    }

    @Override // b.d.c.c.b
    public void a(Application application) {
        if (!this.f11970d) {
            this.f11970d = true;
            AppDatabase appDatabase = (AppDatabase) Room.databaseBuilder(application, AppDatabase.class, "events.db").fallbackToDestructiveMigration().addMigrations(b.a, b.f11967c, b.f11966b).build();
            this.f11971e = appDatabase;
            this.a = appDatabase.b();
            this.f11968b = this.f11971e.c();
            this.f11969c = this.f11971e.a();
        }
    }

    @Override // b.d.c.c.b
    public List<com.tplink.libtpanalytics.database.d.b> b(int i) {
        l();
        try {
            return this.a.d(this.f11968b.b(i));
        } catch (Exception e2) {
            i.b("----getLimitEvent Failed----");
            e2.printStackTrace();
            return new ArrayList();
        }
    }

    @Override // b.d.c.c.b
    public void c(com.tplink.libtpanalytics.database.d.a aVar) {
        l();
        try {
            this.f11969c.b(aVar);
        } catch (Exception e2) {
            i.b("----addEncryptVersionOption Failed----");
            e2.printStackTrace();
        }
    }

    @Override // b.d.c.c.b
    public void d() {
        l();
        try {
            this.f11968b.a();
        } catch (Exception e2) {
            i.b("----deleteTempAll Failed----");
            e2.printStackTrace();
        }
    }

    @Override // b.d.c.c.b
    public void e(List<com.tplink.libtpanalytics.database.d.b> list) {
        l();
        try {
            this.a.b(list);
        } catch (Exception e2) {
            i.b("----deleteEventsWithTempTableAndRange Failed----");
            e2.printStackTrace();
            j();
            d();
        }
    }

    @Override // b.d.c.c.b
    public List<com.tplink.libtpanalytics.database.d.a> f() {
        l();
        try {
            return this.f11969c.c();
        } catch (Exception e2) {
            i.b("----getEncryptVersionOptionAll Failed----");
            e2.printStackTrace();
            return new ArrayList();
        }
    }

    @Override // b.d.c.c.b
    public void g(com.tplink.libtpanalytics.database.d.b bVar) {
        l();
        try {
            this.a.c(bVar);
        } catch (Exception e2) {
            i.b("----addEvent Failed----");
            j();
            e2.printStackTrace();
        }
    }

    @Override // b.d.c.c.b
    public void h() {
        l();
        try {
            this.f11969c.a();
        } catch (Exception e2) {
            i.b("----deleteEncryptVersionOptionAll Failed----");
            e2.printStackTrace();
        }
    }

    @Override // b.d.c.c.b
    public long i() {
        l();
        try {
            return this.a.count();
        } catch (Exception e2) {
            i.b("----getEventsCount Failed----");
            j();
            e2.printStackTrace();
            return 0L;
        }
    }

    @Override // b.d.c.c.b
    public void j() {
        l();
        try {
            this.a.a();
        } catch (Exception e2) {
            i.b("----deleteEventsAll Failed----");
            e2.printStackTrace();
        }
    }

    @Override // b.d.c.c.b
    public q<Integer> k() {
        l();
        return q.f0(1).g0(new j() { // from class: com.tplink.libtpanalytics.database.a
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                return c.this.n((Integer) obj);
            }
        });
    }
}
