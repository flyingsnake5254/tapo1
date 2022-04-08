package b.d.q.b;

import android.util.Log;
import b.d.w.c.a;
import com.tplink.libtpmediaother.database.model.DeviceInfoDao;
import com.tplink.libtpmediaother.database.model.FileMemoryInfoDao;
import com.tplink.libtpmediaother.database.model.ModeSettingInfoDao;
import com.tplink.libtpmediaother.database.model.c;
import com.tplink.libtpmediaother.database.model.d;
import com.tplink.libtpmediaother.database.model.e;
import com.tplink.libtpnetwork.Utils.f0.b;
import java.io.File;
import java.util.List;
import org.greenrobot.greendao.query.WhereCondition;

/* compiled from: DaoStoreUtils.java */
/* loaded from: classes3.dex */
public class l {
    private static final String a = "l";

    private static void a(String str) {
        File file = new File(str);
        if (file.exists()) {
            file.delete();
        }
    }

    public static void b(final long j, final b<d> bVar) {
        final FileMemoryInfoDao b2 = k.a().b();
        q(new Runnable() { // from class: b.d.q.b.b
            @Override // java.lang.Runnable
            public final void run() {
                l.j(j, b2, bVar);
            }
        });
    }

    public static void c(final String str, final b<d> bVar) {
        final FileMemoryInfoDao b2 = k.a().b();
        q(new Runnable() { // from class: b.d.q.b.e
            @Override // java.lang.Runnable
            public final void run() {
                l.i(FileMemoryInfoDao.this, str, bVar);
            }
        });
    }

    public static void d(String str) {
        c(str, null);
    }

    public static void e(final String str, final b<c> bVar) {
        final DeviceInfoDao a2 = k.a().a();
        q(new Runnable() { // from class: b.d.q.b.f
            @Override // java.lang.Runnable
            public final void run() {
                l.k(DeviceInfoDao.this, str, bVar);
            }
        });
    }

    public static c f(String str) {
        c load = k.a().a().load(str);
        if (load != null) {
            return load;
        }
        c cVar = new c();
        cVar.m(str);
        return cVar;
    }

    public static void g(final String str, final boolean z, final b<e> bVar) {
        final ModeSettingInfoDao c2 = k.a().c();
        q(new Runnable() { // from class: b.d.q.b.d
            @Override // java.lang.Runnable
            public final void run() {
                l.l(ModeSettingInfoDao.this, str, z, bVar);
            }
        });
    }

    public static void h(final b<d> bVar) {
        final FileMemoryInfoDao b2 = k.a().b();
        q(new Runnable() { // from class: b.d.q.b.a
            @Override // java.lang.Runnable
            public final void run() {
                l.m(b.this, b2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void i(FileMemoryInfoDao fileMemoryInfoDao, String str, b bVar) {
        List<d> list = fileMemoryInfoDao.queryBuilder().where(FileMemoryInfoDao.Properties.h.eq(str), new WhereCondition[0]).list();
        d dVar = list.size() > 0 ? list.get(0) : null;
        if (dVar != null) {
            if (bVar != null) {
                bVar.a(dVar);
            }
            fileMemoryInfoDao.delete(dVar);
            if (new File(str).exists()) {
                a(str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void j(long j, FileMemoryInfoDao fileMemoryInfoDao, b bVar) {
        d load = fileMemoryInfoDao.load(String.valueOf(j));
        if (load != null) {
            if (bVar != null) {
                bVar.a(load);
            }
            fileMemoryInfoDao.delete(load);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void k(DeviceInfoDao deviceInfoDao, String str, b bVar) {
        c load = deviceInfoDao.load(str);
        if (load == null) {
            load = new c();
            load.m(str);
        }
        bVar.a(load);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void l(ModeSettingInfoDao modeSettingInfoDao, String str, boolean z, b bVar) {
        List<e> list = modeSettingInfoDao.queryBuilder().where(ModeSettingInfoDao.Properties.a.eq(str), ModeSettingInfoDao.Properties.f12597b.eq(Boolean.valueOf(z))).list();
        e eVar = list.size() > 0 ? list.get(0) : null;
        if (eVar == null) {
            eVar = e.a(str, z);
        }
        bVar.a(eVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void m(b bVar, FileMemoryInfoDao fileMemoryInfoDao) {
        d dVar = new d();
        bVar.a(dVar);
        fileMemoryInfoDao.insertOrReplace(dVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void n(DeviceInfoDao deviceInfoDao, String str, b bVar) {
        c load = deviceInfoDao.load(str);
        if (load == null) {
            c cVar = new c();
            cVar.m(str);
            bVar.a(cVar);
            deviceInfoDao.insertOrReplace(cVar);
            return;
        }
        bVar.a(load);
        deviceInfoDao.update(load);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void o(ModeSettingInfoDao modeSettingInfoDao, String str, boolean z, b bVar) {
        List<e> list = modeSettingInfoDao.queryBuilder().where(ModeSettingInfoDao.Properties.a.eq(str), ModeSettingInfoDao.Properties.f12597b.eq(Boolean.valueOf(z))).list();
        e eVar = list.size() > 0 ? list.get(0) : null;
        if (eVar == null) {
            eVar = e.a(str, z);
        }
        bVar.a(eVar);
        modeSettingInfoDao.insertOrReplace(eVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void p(long j, FileMemoryInfoDao fileMemoryInfoDao, b bVar) {
        String valueOf = String.valueOf(j);
        d load = fileMemoryInfoDao.load(valueOf);
        if (load != null) {
            bVar.a(load);
            fileMemoryInfoDao.update(load);
            return;
        }
        d dVar = new d();
        dVar.w(valueOf);
        bVar.a(dVar);
        fileMemoryInfoDao.insertOrReplace(dVar);
    }

    private static void q(Runnable runnable) {
        try {
            runnable.run();
        } catch (Throwable th) {
            a.e(a, Log.getStackTraceString(th));
        }
    }

    public static void r(final String str, final b<c> bVar) {
        final DeviceInfoDao a2 = k.a().a();
        q(new Runnable() { // from class: b.d.q.b.g
            @Override // java.lang.Runnable
            public final void run() {
                l.n(DeviceInfoDao.this, str, bVar);
            }
        });
    }

    public static void s(final String str, final boolean z, final b<e> bVar) {
        final ModeSettingInfoDao c2 = k.a().c();
        q(new Runnable() { // from class: b.d.q.b.c
            @Override // java.lang.Runnable
            public final void run() {
                l.o(ModeSettingInfoDao.this, str, z, bVar);
            }
        });
    }

    public static void t(final long j, final b<d> bVar) {
        final FileMemoryInfoDao b2 = k.a().b();
        q(new Runnable() { // from class: b.d.q.b.h
            @Override // java.lang.Runnable
            public final void run() {
                l.p(j, b2, bVar);
            }
        });
    }
}
