package org.greenrobot.greendao.query;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.query.AbstractQuery;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public abstract class AbstractQueryData<T, Q extends AbstractQuery<T>> {
    final AbstractDao<T, ?> dao;
    final String[] initialValues;
    final Map<Long, WeakReference<Q>> queriesForThreads = new HashMap();
    final String sql;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractQueryData(AbstractDao<T, ?> abstractDao, String str, String[] strArr) {
        this.dao = abstractDao;
        this.sql = str;
        this.initialValues = strArr;
    }

    protected abstract Q createQuery();

    /* JADX INFO: Access modifiers changed from: package-private */
    public Q forCurrentThread(Q q) {
        if (Thread.currentThread() != q.ownerThread) {
            return forCurrentThread();
        }
        String[] strArr = this.initialValues;
        System.arraycopy(strArr, 0, q.parameters, 0, strArr.length);
        return q;
    }

    void gc() {
        synchronized (this.queriesForThreads) {
            Iterator<Map.Entry<Long, WeakReference<Q>>> it = this.queriesForThreads.entrySet().iterator();
            while (it.hasNext()) {
                if (it.next().getValue().get() == null) {
                    it.remove();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Q forCurrentThread() {
        Q q;
        long id = Thread.currentThread().getId();
        synchronized (this.queriesForThreads) {
            WeakReference<Q> weakReference = this.queriesForThreads.get(Long.valueOf(id));
            q = weakReference != null ? weakReference.get() : null;
            if (q == null) {
                gc();
                q = createQuery();
                this.queriesForThreads.put(Long.valueOf(id), new WeakReference<>(q));
            } else {
                String[] strArr = this.initialValues;
                System.arraycopy(strArr, 0, q.parameters, 0, strArr.length);
            }
        }
        return q;
    }
}
