package com.google.android.datatransport.h.x.j;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.os.SystemClock;
import android.util.Base64;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import com.google.android.datatransport.h.h;
import com.google.android.datatransport.h.i;
import com.google.android.datatransport.h.n;
import com.google.android.datatransport.runtime.synchronization.SynchronizationException;
import com.google.android.datatransport.runtime.synchronization.a;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import io.netty.util.internal.StringUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* compiled from: SQLiteEventStore.java */
@WorkerThread
/* loaded from: classes.dex */
public class f0 implements y, com.google.android.datatransport.runtime.synchronization.a {

    /* renamed from: c  reason: collision with root package name */
    private static final com.google.android.datatransport.b f1916c = com.google.android.datatransport.b.b("proto");

    /* renamed from: d  reason: collision with root package name */
    private final h0 f1917d;

    /* renamed from: f  reason: collision with root package name */
    private final com.google.android.datatransport.h.y.a f1918f;
    private final com.google.android.datatransport.h.y.a q;
    private final z x;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SQLiteEventStore.java */
    /* loaded from: classes.dex */
    public interface b<T, U> {
        U apply(T t);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SQLiteEventStore.java */
    /* loaded from: classes.dex */
    public static class c {
        final String a;

        /* renamed from: b  reason: collision with root package name */
        final String f1919b;

        private c(String str, String str2) {
            this.a = str;
            this.f1919b = str2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SQLiteEventStore.java */
    /* loaded from: classes.dex */
    public interface d<T> {
        T a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public f0(com.google.android.datatransport.h.y.a aVar, com.google.android.datatransport.h.y.a aVar2, z zVar, h0 h0Var) {
        this.f1917d = h0Var;
        this.f1918f = aVar;
        this.q = aVar2;
        this.x = zVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ List B(Cursor cursor) {
        ArrayList arrayList = new ArrayList();
        while (cursor.moveToNext()) {
            arrayList.add(n.a().b(cursor.getString(1)).d(com.google.android.datatransport.h.z.a.b(cursor.getInt(2))).c(P(cursor.getString(3))).a());
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ List C(SQLiteDatabase sQLiteDatabase) {
        return (List) U(sQLiteDatabase.rawQuery("SELECT distinct t._id, t.backend_name, t.priority, t.extras FROM transport_contexts AS t, events AS e WHERE e.context_id = t._id", new String[0]), j.a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: D */
    public /* synthetic */ List E(n nVar, SQLiteDatabase sQLiteDatabase) {
        List<e0> N = N(sQLiteDatabase, nVar);
        return s(N, O(sQLiteDatabase, N));
    }

    private /* synthetic */ Object F(List list, n nVar, Cursor cursor) {
        while (cursor.moveToNext()) {
            boolean z = false;
            long j = cursor.getLong(0);
            if (cursor.getInt(7) != 0) {
                z = true;
            }
            i.a k = i.a().j(cursor.getString(1)).i(cursor.getLong(2)).k(cursor.getLong(3));
            if (z) {
                k.h(new h(S(cursor.getString(4)), cursor.getBlob(5)));
            } else {
                k.h(new h(S(cursor.getString(4)), Q(j)));
            }
            if (!cursor.isNull(6)) {
                k.g(Integer.valueOf(cursor.getInt(6)));
            }
            list.add(e0.a(j, nVar, k.d()));
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Object H(Map map, Cursor cursor) {
        while (cursor.moveToNext()) {
            long j = cursor.getLong(0);
            Set set = (Set) map.get(Long.valueOf(j));
            if (set == null) {
                set = new HashSet();
                map.put(Long.valueOf(j), set);
            }
            set.add(new c(cursor.getString(1), cursor.getString(2)));
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: I */
    public /* synthetic */ Long J(n nVar, i iVar, SQLiteDatabase sQLiteDatabase) {
        if (l()) {
            return -1L;
        }
        long e2 = e(sQLiteDatabase, nVar);
        int e3 = this.x.e();
        byte[] a2 = iVar.e().a();
        boolean z = a2.length <= e3;
        ContentValues contentValues = new ContentValues();
        contentValues.put("context_id", Long.valueOf(e2));
        contentValues.put("transport_name", iVar.j());
        contentValues.put("timestamp_ms", Long.valueOf(iVar.f()));
        contentValues.put("uptime_ms", Long.valueOf(iVar.k()));
        contentValues.put("payload_encoding", iVar.e().b().a());
        contentValues.put("code", iVar.d());
        contentValues.put("num_attempts", (Integer) 0);
        contentValues.put("inline", Boolean.valueOf(z));
        contentValues.put("payload", z ? a2 : new byte[0]);
        long insert = sQLiteDatabase.insert("events", null, contentValues);
        if (!z) {
            int ceil = (int) Math.ceil(a2.length / e3);
            for (int i = 1; i <= ceil; i++) {
                byte[] copyOfRange = Arrays.copyOfRange(a2, (i - 1) * e3, Math.min(i * e3, a2.length));
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put("event_id", Long.valueOf(insert));
                contentValues2.put("sequence_num", Integer.valueOf(i));
                contentValues2.put("bytes", copyOfRange);
                sQLiteDatabase.insert("event_payloads", null, contentValues2);
            }
        }
        for (Map.Entry<String, String> entry : iVar.i().entrySet()) {
            ContentValues contentValues3 = new ContentValues();
            contentValues3.put("event_id", Long.valueOf(insert));
            contentValues3.put(AppMeasurementSdk.ConditionalUserProperty.NAME, entry.getKey());
            contentValues3.put("value", entry.getValue());
            sQLiteDatabase.insert("event_metadata", null, contentValues3);
        }
        return Long.valueOf(insert);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ byte[] K(Cursor cursor) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (cursor.moveToNext()) {
            byte[] blob = cursor.getBlob(0);
            arrayList.add(blob);
            i += blob.length;
        }
        byte[] bArr = new byte[i];
        int i2 = 0;
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            byte[] bArr2 = (byte[]) arrayList.get(i3);
            System.arraycopy(bArr2, 0, bArr, i2, bArr2.length);
            i2 += bArr2.length;
        }
        return bArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Object L(String str, SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.compileStatement(str).execute();
        sQLiteDatabase.compileStatement("DELETE FROM events WHERE num_attempts >= 16").execute();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Object M(long j, n nVar, SQLiteDatabase sQLiteDatabase) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("next_request_ms", Long.valueOf(j));
        if (sQLiteDatabase.update("transport_contexts", contentValues, "backend_name = ? and priority = ?", new String[]{nVar.b(), String.valueOf(com.google.android.datatransport.h.z.a.a(nVar.d()))}) < 1) {
            contentValues.put("backend_name", nVar.b());
            contentValues.put("priority", Integer.valueOf(com.google.android.datatransport.h.z.a.a(nVar.d())));
            sQLiteDatabase.insert("transport_contexts", null, contentValues);
        }
        return null;
    }

    private List<e0> N(SQLiteDatabase sQLiteDatabase, final n nVar) {
        final ArrayList arrayList = new ArrayList();
        Long j = j(sQLiteDatabase, nVar);
        if (j == null) {
            return arrayList;
        }
        U(sQLiteDatabase.query("events", new String[]{"_id", "transport_name", "timestamp_ms", "uptime_ms", "payload_encoding", "payload", "code", "inline"}, "context_id = ?", new String[]{j.toString()}, null, null, null, String.valueOf(this.x.d())), new b() { // from class: com.google.android.datatransport.h.x.j.p
            @Override // com.google.android.datatransport.h.x.j.f0.b
            public final Object apply(Object obj) {
                f0.this.G(arrayList, nVar, (Cursor) obj);
                return null;
            }
        });
        return arrayList;
    }

    private Map<Long, Set<c>> O(SQLiteDatabase sQLiteDatabase, List<e0> list) {
        final HashMap hashMap = new HashMap();
        StringBuilder sb = new StringBuilder("event_id IN (");
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i).c());
            if (i < list.size() - 1) {
                sb.append(StringUtil.COMMA);
            }
        }
        sb.append(')');
        U(sQLiteDatabase.query("event_metadata", new String[]{"event_id", AppMeasurementSdk.ConditionalUserProperty.NAME, "value"}, sb.toString(), null, null, null, null), new b() { // from class: com.google.android.datatransport.h.x.j.l
            @Override // com.google.android.datatransport.h.x.j.f0.b
            public final Object apply(Object obj) {
                f0.H(hashMap, (Cursor) obj);
                return null;
            }
        });
        return hashMap;
    }

    private static byte[] P(@Nullable String str) {
        if (str == null) {
            return null;
        }
        return Base64.decode(str, 0);
    }

    private byte[] Q(long j) {
        return (byte[]) U(g().query("event_payloads", new String[]{"bytes"}, "event_id = ?", new String[]{String.valueOf(j)}, null, null, "sequence_num"), b.a);
    }

    private <T> T R(d<T> dVar, b<Throwable, T> bVar) {
        long a2 = this.q.a();
        while (true) {
            try {
                return dVar.a();
            } catch (SQLiteDatabaseLockedException e2) {
                if (this.q.a() >= this.x.b() + a2) {
                    return bVar.apply(e2);
                }
                SystemClock.sleep(50L);
            }
        }
    }

    private static com.google.android.datatransport.b S(@Nullable String str) {
        if (str == null) {
            return f1916c;
        }
        return com.google.android.datatransport.b.b(str);
    }

    private static String T(Iterable<e0> iterable) {
        StringBuilder sb = new StringBuilder("(");
        Iterator<e0> it = iterable.iterator();
        while (it.hasNext()) {
            sb.append(it.next().c());
            if (it.hasNext()) {
                sb.append(StringUtil.COMMA);
            }
        }
        sb.append(')');
        return sb.toString();
    }

    @VisibleForTesting
    static <T> T U(Cursor cursor, b<Cursor, T> bVar) {
        try {
            return bVar.apply(cursor);
        } finally {
            cursor.close();
        }
    }

    private void c(final SQLiteDatabase sQLiteDatabase) {
        R(new d() { // from class: com.google.android.datatransport.h.x.j.g
            @Override // com.google.android.datatransport.h.x.j.f0.d
            public final Object a() {
                sQLiteDatabase.beginTransaction();
                return null;
            }
        }, d.a);
    }

    private long e(SQLiteDatabase sQLiteDatabase, n nVar) {
        Long j = j(sQLiteDatabase, nVar);
        if (j != null) {
            return j.longValue();
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("backend_name", nVar.b());
        contentValues.put("priority", Integer.valueOf(com.google.android.datatransport.h.z.a.a(nVar.d())));
        contentValues.put("next_request_ms", (Integer) 0);
        if (nVar.c() != null) {
            contentValues.put("extras", Base64.encodeToString(nVar.c(), 0));
        }
        return sQLiteDatabase.insert("transport_contexts", null, contentValues);
    }

    private long getPageSize() {
        return g().compileStatement("PRAGMA page_size").simpleQueryForLong();
    }

    private long i() {
        return g().compileStatement("PRAGMA page_count").simpleQueryForLong();
    }

    @Nullable
    private Long j(SQLiteDatabase sQLiteDatabase, n nVar) {
        StringBuilder sb = new StringBuilder("backend_name = ? and priority = ?");
        ArrayList arrayList = new ArrayList(Arrays.asList(nVar.b(), String.valueOf(com.google.android.datatransport.h.z.a.a(nVar.d()))));
        if (nVar.c() != null) {
            sb.append(" and extras = ?");
            arrayList.add(Base64.encodeToString(nVar.c(), 0));
        } else {
            sb.append(" and extras is null");
        }
        return (Long) U(sQLiteDatabase.query("transport_contexts", new String[]{"_id"}, sb.toString(), (String[]) arrayList.toArray(new String[0]), null, null, null), m.a);
    }

    private boolean l() {
        return i() * getPageSize() >= this.x.f();
    }

    private List<e0> s(List<e0> list, Map<Long, Set<c>> map) {
        ListIterator<e0> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            e0 next = listIterator.next();
            if (map.containsKey(Long.valueOf(next.c()))) {
                i.a l = next.b().l();
                for (c cVar : map.get(Long.valueOf(next.c()))) {
                    l.c(cVar.a, cVar.f1919b);
                }
                listIterator.set(e0.a(next.c(), next.d(), l.d()));
            }
        }
        return list;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Object v(Throwable th) {
        throw new SynchronizationException("Timed out while trying to acquire the lock.", th);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ SQLiteDatabase w(Throwable th) {
        throw new SynchronizationException("Timed out while trying to open db.", th);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Long x(Cursor cursor) {
        if (cursor.moveToNext()) {
            return Long.valueOf(cursor.getLong(0));
        }
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Long y(Cursor cursor) {
        if (!cursor.moveToNext()) {
            return null;
        }
        return Long.valueOf(cursor.getLong(0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: z */
    public /* synthetic */ Boolean A(n nVar, SQLiteDatabase sQLiteDatabase) {
        Long j = j(sQLiteDatabase, nVar);
        if (j == null) {
            return Boolean.FALSE;
        }
        return (Boolean) U(g().rawQuery("SELECT 1 FROM events WHERE context_id = ? LIMIT 1", new String[]{j.toString()}), u.a);
    }

    public /* synthetic */ Object G(List list, n nVar, Cursor cursor) {
        F(list, nVar, cursor);
        return null;
    }

    @Override // com.google.android.datatransport.runtime.synchronization.a
    public <T> T a(a.AbstractC0073a<T> aVar) {
        SQLiteDatabase g = g();
        c(g);
        try {
            T execute = aVar.execute();
            g.setTransactionSuccessful();
            return execute;
        } finally {
            g.endTransaction();
        }
    }

    @Override // com.google.android.datatransport.h.x.j.y
    public int b() {
        final long a2 = this.f1918f.a() - this.x.c();
        return ((Integer) k(new b() { // from class: com.google.android.datatransport.h.x.j.c
            @Override // com.google.android.datatransport.h.x.j.f0.b
            public final Object apply(Object obj) {
                Integer valueOf;
                valueOf = Integer.valueOf(((SQLiteDatabase) obj).delete("events", "timestamp_ms < ?", new String[]{String.valueOf(a2)}));
                return valueOf;
            }
        })).intValue();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f1917d.close();
    }

    @Override // com.google.android.datatransport.h.x.j.y
    public void d(Iterable<e0> iterable) {
        if (iterable.iterator().hasNext()) {
            g().compileStatement("DELETE FROM events WHERE _id in " + T(iterable)).execute();
        }
    }

    @Override // com.google.android.datatransport.h.x.j.y
    public void f(final n nVar, final long j) {
        k(new b() { // from class: com.google.android.datatransport.h.x.j.h
            @Override // com.google.android.datatransport.h.x.j.f0.b
            public final Object apply(Object obj) {
                f0.M(j, nVar, (SQLiteDatabase) obj);
                return null;
            }
        });
    }

    @VisibleForTesting
    SQLiteDatabase g() {
        final h0 h0Var = this.f1917d;
        Objects.requireNonNull(h0Var);
        return (SQLiteDatabase) R(new d() { // from class: com.google.android.datatransport.h.x.j.v
            @Override // com.google.android.datatransport.h.x.j.f0.d
            public final Object a() {
                return h0.this.getWritableDatabase();
            }
        }, a.a);
    }

    @Override // com.google.android.datatransport.h.x.j.y
    public Iterable<n> h() {
        return (Iterable) k(o.a);
    }

    @VisibleForTesting
    <T> T k(b<SQLiteDatabase, T> bVar) {
        SQLiteDatabase g = g();
        g.beginTransaction();
        try {
            T apply = bVar.apply(g);
            g.setTransactionSuccessful();
            return apply;
        } finally {
            g.endTransaction();
        }
    }

    @Override // com.google.android.datatransport.h.x.j.y
    public long m(n nVar) {
        return ((Long) U(g().rawQuery("SELECT next_request_ms FROM transport_contexts WHERE backend_name = ? and priority = ?", new String[]{nVar.b(), String.valueOf(com.google.android.datatransport.h.z.a.a(nVar.d()))}), n.a)).longValue();
    }

    @Override // com.google.android.datatransport.h.x.j.y
    public boolean n(final n nVar) {
        return ((Boolean) k(new b() { // from class: com.google.android.datatransport.h.x.j.i
            @Override // com.google.android.datatransport.h.x.j.f0.b
            public final Object apply(Object obj) {
                return f0.this.A(nVar, (SQLiteDatabase) obj);
            }
        })).booleanValue();
    }

    @Override // com.google.android.datatransport.h.x.j.y
    public void o(Iterable<e0> iterable) {
        if (iterable.iterator().hasNext()) {
            final String str = "UPDATE events SET num_attempts = num_attempts + 1 WHERE _id in " + T(iterable);
            k(new b() { // from class: com.google.android.datatransport.h.x.j.f
                @Override // com.google.android.datatransport.h.x.j.f0.b
                public final Object apply(Object obj) {
                    f0.L(str, (SQLiteDatabase) obj);
                    return null;
                }
            });
        }
    }

    @Override // com.google.android.datatransport.h.x.j.y
    public Iterable<e0> p(final n nVar) {
        return (Iterable) k(new b() { // from class: com.google.android.datatransport.h.x.j.k
            @Override // com.google.android.datatransport.h.x.j.f0.b
            public final Object apply(Object obj) {
                return f0.this.E(nVar, (SQLiteDatabase) obj);
            }
        });
    }

    @Override // com.google.android.datatransport.h.x.j.y
    @Nullable
    public e0 r(final n nVar, final i iVar) {
        com.google.android.datatransport.h.v.a.b("SQLiteEventStore", "Storing event with priority=%s, name=%s for destination %s", nVar.d(), iVar.j(), nVar.b());
        long longValue = ((Long) k(new b() { // from class: com.google.android.datatransport.h.x.j.e
            @Override // com.google.android.datatransport.h.x.j.f0.b
            public final Object apply(Object obj) {
                return f0.this.J(nVar, iVar, (SQLiteDatabase) obj);
            }
        })).longValue();
        if (longValue < 1) {
            return null;
        }
        return e0.a(longValue, nVar, iVar);
    }
}
