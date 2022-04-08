package com.tplink.libtpmediaother.memory;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import b.d.q.b.k;
import b.d.q.b.l;
import b.d.q.b.n;
import com.tplink.libtpmediaother.database.model.FileMemoryInfoDao;
import com.tplink.libtpmediastatistics.SSLClient;
import io.netty.handler.codec.rtsp.RtspHeaders;
import io.reactivex.q;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import org.greenrobot.greendao.query.QueryBuilder;
import org.greenrobot.greendao.query.WhereCondition;

/* compiled from: MemoryManager.java */
/* loaded from: classes3.dex */
public class r {
    private static final String a = "r";

    /* renamed from: b  reason: collision with root package name */
    private static r f12653b;

    /* renamed from: c  reason: collision with root package name */
    private ArrayList<WeakReference<s>> f12654c = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    private ArrayList<WeakReference<t>> f12655d = new ArrayList<>();

    /* renamed from: f  reason: collision with root package name */
    private Handler f12657f = new Handler(Looper.getMainLooper());

    /* renamed from: e  reason: collision with root package name */
    private ExecutorService f12656e = Executors.newSingleThreadExecutor(new a());

    /* compiled from: MemoryManager.java */
    /* loaded from: classes3.dex */
    class a implements ThreadFactory {

        /* renamed from: c  reason: collision with root package name */
        private final AtomicInteger f12658c = new AtomicInteger(0);

        a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(@NonNull Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setName("pool-MemoryManager.executorService-" + this.f12658c.incrementAndGet());
            return thread;
        }
    }

    /* compiled from: MemoryManager.java */
    /* loaded from: classes3.dex */
    public interface b {
        void a(t tVar);
    }

    /* compiled from: MemoryManager.java */
    /* loaded from: classes3.dex */
    public interface c {
        void a(s sVar);
    }

    /* compiled from: MemoryManager.java */
    /* loaded from: classes3.dex */
    public static final class d {
        private String a;

        /* renamed from: b  reason: collision with root package name */
        private List<String> f12660b;

        /* renamed from: c  reason: collision with root package name */
        private String f12661c;

        /* renamed from: d  reason: collision with root package name */
        private String f12662d;

        /* renamed from: e  reason: collision with root package name */
        private Boolean f12663e;

        /* renamed from: f  reason: collision with root package name */
        private Boolean f12664f;
        private Boolean g;
        private Boolean h;
        private Boolean i;
        private Boolean j;

        public d a(String str) {
            this.f12662d = str;
            return this;
        }

        public QueryBuilder b(int i, int i2) {
            boolean z;
            StringBuilder sb = new StringBuilder();
            if (this.a != null) {
                sb.append("UTC_TIMESTAMP = ");
                sb.append("'");
                sb.append(this.a);
                sb.append("'");
                z = true;
            } else {
                z = false;
            }
            if (this.f12661c != null) {
                if (z) {
                    sb.append(" AND ");
                }
                sb.append(" DEVICE_ID_MD5 = ");
                sb.append("'");
                sb.append(this.f12661c);
                sb.append("'");
                z = true;
            }
            if (this.f12662d != null) {
                if (z) {
                    sb.append(" AND ");
                }
                sb.append(" ASSOCIATED_ACCOUNT IN (");
                sb.append("'");
                sb.append(this.f12662d);
                sb.append("','");
                sb.append(RtspHeaders.Names.PUBLIC);
                sb.append("')");
                z = true;
            }
            Boolean bool = this.f12663e;
            if (!(bool == null && this.f12664f == null) && ((org.apache.commons.lang.b.b(bool) && !org.apache.commons.lang.b.b(this.f12664f)) || (!org.apache.commons.lang.b.b(this.f12663e) && org.apache.commons.lang.b.b(this.f12664f)))) {
                if (z) {
                    sb.append(" AND ");
                }
                if (org.apache.commons.lang.b.b(this.f12663e)) {
                    sb.append(" IS_FAVORITE = ");
                    sb.append(1);
                } else {
                    sb.append(" IS_FAVORITE = ");
                    sb.append(0);
                }
                z = true;
            }
            Boolean bool2 = this.h;
            if (!(bool2 == null && this.g == null && this.i == null) && (!org.apache.commons.lang.b.b(bool2) || !org.apache.commons.lang.b.b(this.g) || !org.apache.commons.lang.b.b(this.i))) {
                if (org.apache.commons.lang.b.b(this.h)) {
                    if (z) {
                        sb.append(" AND (");
                    }
                    sb.append(" FILE_ABSOLUTE_PATH LIKE ");
                    sb.append("'");
                    sb.append("%.jpg");
                    sb.append("'");
                    z = true;
                }
                if (org.apache.commons.lang.b.b(this.g)) {
                    if (z) {
                        if (org.apache.commons.lang.b.b(this.h)) {
                            sb.append(" OR ");
                        } else {
                            sb.append(" AND ");
                        }
                    }
                    if (org.apache.commons.lang.b.b(this.i)) {
                        sb.append(" FILE_ABSOLUTE_PATH LIKE ");
                        sb.append("'");
                        sb.append("%.mp4");
                        sb.append("'");
                    } else {
                        sb.append(" FILE_ABSOLUTE_PATH NOT LIKE ");
                        sb.append("'");
                        sb.append("%cloudvideo%");
                        sb.append("'");
                        sb.append(" AND ");
                        sb.append(" FILE_ABSOLUTE_PATH LIKE ");
                        sb.append("'");
                        sb.append("%.mp4");
                        sb.append("'");
                    }
                } else if (org.apache.commons.lang.b.b(this.i)) {
                    if (z) {
                        if (org.apache.commons.lang.b.b(this.h)) {
                            sb.append(" OR ");
                        } else {
                            sb.append(" AND ");
                        }
                    }
                    sb.append(" FILE_ABSOLUTE_PATH LIKE ");
                    sb.append("'");
                    sb.append("%cloudvideo%");
                    sb.append("'");
                    sb.append(" AND ");
                    sb.append(" FILE_ABSOLUTE_PATH LIKE ");
                    sb.append("'");
                    sb.append("%.mp4");
                    sb.append("'");
                }
                if (org.apache.commons.lang.b.b(this.h) && z) {
                    sb.append(" ) ");
                }
                z = true;
            }
            List<String> list = this.f12660b;
            if (list != null && list.size() > 0) {
                if (z) {
                    sb.append(" AND ");
                }
                sb.append(" DEVICE_ALIAS IN (");
                for (int i3 = 0; i3 < this.f12660b.size(); i3++) {
                    String str = this.f12660b.get(i3);
                    if (i3 != 0) {
                        sb.append(SSLClient.COMMA);
                    }
                    sb.append("'");
                    sb.append(str);
                    sb.append("'");
                }
                sb.append(")");
                z = true;
            }
            if (this.j != null) {
                if (z) {
                    sb.append(" AND ");
                }
                if (org.apache.commons.lang.b.b(this.j)) {
                    sb.append(" IS_DELETED_BY_USER = ");
                    sb.append(1);
                } else {
                    sb.append(" IS_DELETED_BY_USER = ");
                    sb.append(0);
                }
            }
            QueryBuilder<com.tplink.libtpmediaother.database.model.d> queryBuilder = k.a().b().queryBuilder();
            if (!n.a(sb.toString())) {
                queryBuilder.where(new WhereCondition.StringCondition(sb.toString()), new WhereCondition[0]);
            }
            if (!(i == -1 || i2 == -1)) {
                int i4 = i * i2;
                if (i4 < 0) {
                    i4 = 0;
                }
                queryBuilder.offset(i4).limit(i2);
            }
            queryBuilder.orderDesc(FileMemoryInfoDao.Properties.a);
            return queryBuilder;
        }

        public d c(List<String> list) {
            this.f12660b = list;
            return this;
        }

        public d d(String str) {
            this.f12661c = str;
            return this;
        }

        public d e(Boolean bool) {
            this.i = bool;
            return this;
        }

        public d f(Boolean bool) {
            this.f12663e = bool;
            return this;
        }

        public d g(Boolean bool) {
            this.h = bool;
            return this;
        }

        public d h(Boolean bool) {
            this.f12664f = bool;
            return this;
        }

        public d i(Boolean bool) {
            this.g = bool;
            return this;
        }
    }

    private r() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void A(com.tplink.libtpmediaother.database.model.d dVar) {
        dVar.r(true);
        File file = new File(dVar.e());
        if (file.exists()) {
            file.delete();
        }
        if (!n.a(dVar.j())) {
            File file2 = new File(dVar.j());
            File parentFile = file2.getParentFile();
            if (file2.exists()) {
                file2.delete();
            }
            if (parentFile.exists() && parentFile.list().length == 0) {
                parentFile.delete();
            }
        }
    }

    private void D(final QueryBuilder<com.tplink.libtpmediaother.database.model.d> queryBuilder) {
        this.f12656e.submit(new Runnable() { // from class: com.tplink.libtpmediaother.memory.k
            @Override // java.lang.Runnable
            public final void run() {
                r.this.l(queryBuilder);
            }
        });
    }

    public static r f() {
        if (f12653b == null) {
            synchronized (r.class) {
                if (f12653b == null) {
                    f12653b = new r();
                }
            }
        }
        return f12653b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Boolean h(List list) throws Exception {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            MemoryBean memoryBean = (MemoryBean) it.next();
            String videoPath = memoryBean.getVideoPath();
            if (memoryBean.getVideoPath() == null) {
                videoPath = memoryBean.getThumbnailPath();
            }
            File file = new File(videoPath);
            String name = file.getName();
            if (file.exists()) {
                if (memoryBean.getVideoPath() == null) {
                    b.d.q.b.p.b.x(videoPath, name);
                } else {
                    b.d.q.b.p.b.w(videoPath, name);
                }
            }
        }
        return Boolean.TRUE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public /* synthetic */ void j() {
        try {
            final ArrayList arrayList = new ArrayList();
            List<com.tplink.libtpmediaother.database.model.d> queryRaw = k.a().b().queryRaw(" WHERE DEVICE_ID_MD5 IS NOT NULL GROUP BY DEVICE_ALIAS ", new String[0]);
            if (queryRaw != null && queryRaw.size() > 0) {
                for (com.tplink.libtpmediaother.database.model.d dVar : queryRaw) {
                    p pVar = new p();
                    pVar.d(dVar.c());
                    pVar.f(dVar.b());
                    pVar.g(dVar.h());
                    pVar.h(dVar.i());
                    pVar.e(dVar.d());
                    arrayList.add(pVar);
                }
            }
            this.f12657f.post(new Runnable() { // from class: com.tplink.libtpmediaother.memory.e
                @Override // java.lang.Runnable
                public final void run() {
                    r.this.s(arrayList);
                }
            });
        } catch (Exception e2) {
            e2.printStackTrace();
            this.f12657f.post(new Runnable() { // from class: com.tplink.libtpmediaother.memory.c
                @Override // java.lang.Runnable
                public final void run() {
                    r.this.w();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k */
    public /* synthetic */ void l(QueryBuilder queryBuilder) {
        List<com.tplink.libtpmediaother.database.model.d> list = queryBuilder.list();
        final ArrayList arrayList = new ArrayList();
        for (com.tplink.libtpmediaother.database.model.d dVar : list) {
            MemoryBean memoryBean = new MemoryBean();
            memoryBean.setTimestamp(Long.valueOf(dVar.k()).longValue());
            memoryBean.setMark(dVar.g());
            memoryBean.setDeviceAlias(dVar.b());
            memoryBean.setVideoLength(dVar.l());
            memoryBean.setLocationName(dVar.h());
            String e2 = dVar.e();
            if (e2.endsWith(".mp4")) {
                memoryBean.setVideoPath(e2);
                if (!n.a(dVar.j())) {
                    memoryBean.setThumbnailPath(dVar.j());
                } else {
                    memoryBean.setThumbnailPath(e2);
                }
            } else {
                memoryBean.setThumbnailPath(e2);
            }
            memoryBean.setDeviceAvatarUrl(dVar.i());
            arrayList.add(memoryBean);
        }
        this.f12657f.post(new Runnable() { // from class: com.tplink.libtpmediaother.memory.i
            @Override // java.lang.Runnable
            public final void run() {
                r.this.z(arrayList);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m */
    public /* synthetic */ void n(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            l.b(((MemoryBean) it.next()).getTimestamp(), h.a);
        }
        g(this.f12654c, o.a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o */
    public /* synthetic */ void p(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            final MemoryBean memoryBean = (MemoryBean) it.next();
            l.t(memoryBean.getTimestamp(), new com.tplink.libtpnetwork.Utils.f0.b() { // from class: com.tplink.libtpmediaother.memory.d
                @Override // com.tplink.libtpnetwork.Utils.f0.b
                public final void a(Object obj) {
                    ((com.tplink.libtpmediaother.database.model.d) obj).s(MemoryBean.this.isMark());
                }
            });
        }
        g(this.f12654c, n.a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: r */
    public /* synthetic */ void s(final List list) {
        c(this.f12655d, new b() { // from class: com.tplink.libtpmediaother.memory.g
            @Override // com.tplink.libtpmediaother.memory.r.b
            public final void a(t tVar) {
                tVar.a(list);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: v */
    public /* synthetic */ void w() {
        c(this.f12655d, j.a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: y */
    public /* synthetic */ void z(final List list) {
        g(this.f12654c, new c() { // from class: com.tplink.libtpmediaother.memory.l
            @Override // com.tplink.libtpmediaother.memory.r.c
            public final void a(s sVar) {
                sVar.b(list);
            }
        });
    }

    public void B() {
        this.f12656e.submit(new Runnable() { // from class: com.tplink.libtpmediaother.memory.a
            @Override // java.lang.Runnable
            public final void run() {
                r.this.j();
            }
        });
    }

    public void C(d dVar) {
        if (dVar != null) {
            D(dVar.b(-1, -1));
        }
    }

    public void E(MemoryBean memoryBean) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(memoryBean);
        F(arrayList);
    }

    public void F(final List<MemoryBean> list) {
        this.f12656e.submit(new Runnable() { // from class: com.tplink.libtpmediaother.memory.f
            @Override // java.lang.Runnable
            public final void run() {
                r.this.n(list);
            }
        });
    }

    public void G(MemoryBean memoryBean) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(memoryBean);
        H(arrayList);
    }

    public void H(final List<MemoryBean> list) {
        this.f12656e.submit(new Runnable() { // from class: com.tplink.libtpmediaother.memory.b
            @Override // java.lang.Runnable
            public final void run() {
                r.this.p(list);
            }
        });
    }

    public void I(t tVar) {
        if (tVar != null) {
            for (int size = this.f12655d.size() - 1; size >= 0; size--) {
                if (tVar.equals(this.f12655d.get(size).get())) {
                    this.f12655d.set(size, new WeakReference<>(null));
                    return;
                }
            }
        }
    }

    public void J(s sVar) {
        if (sVar != null) {
            for (int size = this.f12654c.size() - 1; size >= 0; size--) {
                if (sVar.equals(this.f12654c.get(size).get())) {
                    this.f12654c.set(size, new WeakReference<>(null));
                    return;
                }
            }
        }
    }

    public void a(t tVar) {
        if (tVar != null) {
            for (int size = this.f12655d.size() - 1; size >= 0; size--) {
                t tVar2 = this.f12655d.get(size).get();
                if (tVar2 != null && tVar2.equals(tVar)) {
                    return;
                }
            }
            this.f12655d.add(new WeakReference<>(tVar));
        }
    }

    public void b(s sVar) {
        if (sVar != null) {
            for (int size = this.f12654c.size() - 1; size >= 0; size--) {
                s sVar2 = this.f12654c.get(size).get();
                if (sVar2 != null && sVar2.equals(sVar)) {
                    return;
                }
            }
            this.f12654c.add(new WeakReference<>(sVar));
        }
    }

    public void c(ArrayList<WeakReference<t>> arrayList, b bVar) {
        if (arrayList != null && arrayList.size() > 0) {
            int i = 0;
            while (i < arrayList.size()) {
                WeakReference<t> weakReference = arrayList.get(i);
                if (weakReference.get() != null) {
                    bVar.a(weakReference.get());
                    i++;
                } else {
                    arrayList.remove(i);
                }
            }
        }
    }

    public q<Boolean> d(List<MemoryBean> list) {
        return q.f0(list).g0(m.f12647c).L0(io.reactivex.l0.a.b(this.f12656e)).l0(io.reactivex.d0.b.a.a());
    }

    public q<Boolean> e(MemoryBean memoryBean) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(memoryBean);
        return d(arrayList);
    }

    public void g(ArrayList<WeakReference<s>> arrayList, c cVar) {
        if (arrayList != null && arrayList.size() > 0) {
            int i = 0;
            while (i < arrayList.size()) {
                WeakReference<s> weakReference = arrayList.get(i);
                if (weakReference.get() != null) {
                    cVar.a(weakReference.get());
                    i++;
                } else {
                    arrayList.remove(i);
                }
            }
        }
    }
}
