package org.greenrobot.greendao;

import android.database.CrossProcessCursor;
import android.database.Cursor;
import android.database.CursorWindow;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import org.greenrobot.greendao.annotation.apihint.Experimental;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.identityscope.IdentityScope;
import org.greenrobot.greendao.identityscope.IdentityScopeLong;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.internal.TableStatements;
import org.greenrobot.greendao.query.Query;
import org.greenrobot.greendao.query.QueryBuilder;
import org.greenrobot.greendao.rx.RxDao;
import rx.schedulers.Schedulers;

/* loaded from: classes4.dex */
public abstract class AbstractDao<T, K> {
    protected final DaoConfig config;
    protected final Database db;
    protected final IdentityScope<K, T> identityScope;
    protected final IdentityScopeLong<T> identityScopeLong;
    protected final boolean isStandardSQLite;
    protected final int pkOrdinal;
    private volatile RxDao<T, K> rxDao;
    private volatile RxDao<T, K> rxDaoPlain;
    protected final AbstractDaoSession session;
    protected final TableStatements statements;

    public AbstractDao(DaoConfig daoConfig) {
        this(daoConfig, null);
    }

    private void deleteByKeyInsideSynchronized(K k, DatabaseStatement databaseStatement) {
        if (k instanceof Long) {
            databaseStatement.bindLong(1, ((Long) k).longValue());
        } else if (k != null) {
            databaseStatement.bindString(1, k.toString());
        } else {
            throw new DaoException("Cannot delete entity, key is null");
        }
        databaseStatement.execute();
    }

    private void deleteInTxInternal(Iterable<T> iterable, Iterable<K> iterable2) {
        ArrayList arrayList;
        IdentityScope<K, T> identityScope;
        assertSinglePk();
        DatabaseStatement deleteStatement = this.statements.getDeleteStatement();
        this.db.beginTransaction();
        try {
            synchronized (deleteStatement) {
                IdentityScope<K, T> identityScope2 = this.identityScope;
                if (identityScope2 != null) {
                    identityScope2.lock();
                    arrayList = new ArrayList();
                } else {
                    arrayList = null;
                }
                if (iterable != null) {
                    for (T t : iterable) {
                        K keyVerified = getKeyVerified(t);
                        deleteByKeyInsideSynchronized(keyVerified, deleteStatement);
                        if (arrayList != null) {
                            arrayList.add(keyVerified);
                        }
                    }
                }
                if (iterable2 != null) {
                    for (K k : iterable2) {
                        deleteByKeyInsideSynchronized(k, deleteStatement);
                        if (arrayList != null) {
                            arrayList.add(k);
                        }
                    }
                }
                IdentityScope<K, T> identityScope3 = this.identityScope;
                if (identityScope3 != null) {
                    identityScope3.unlock();
                }
            }
            this.db.setTransactionSuccessful();
            if (!(arrayList == null || (identityScope = this.identityScope) == null)) {
                identityScope.remove((Iterable) arrayList);
            }
        } finally {
            this.db.endTransaction();
        }
    }

    private long executeInsert(T t, DatabaseStatement databaseStatement, boolean z) {
        long j;
        if (this.db.isDbLockedByCurrentThread()) {
            j = insertInsideTx(t, databaseStatement);
        } else {
            this.db.beginTransaction();
            try {
                j = insertInsideTx(t, databaseStatement);
                this.db.setTransactionSuccessful();
            } finally {
                this.db.endTransaction();
            }
        }
        if (z) {
            updateKeyAfterInsertAndAttach(t, j, true);
        }
        return j;
    }

    private void executeInsertInTx(DatabaseStatement databaseStatement, Iterable<T> iterable, boolean z) {
        this.db.beginTransaction();
        try {
            synchronized (databaseStatement) {
                IdentityScope<K, T> identityScope = this.identityScope;
                if (identityScope != null) {
                    identityScope.lock();
                }
                if (this.isStandardSQLite) {
                    SQLiteStatement sQLiteStatement = (SQLiteStatement) databaseStatement.getRawStatement();
                    for (T t : iterable) {
                        bindValues(sQLiteStatement, (SQLiteStatement) t);
                        if (z) {
                            updateKeyAfterInsertAndAttach(t, sQLiteStatement.executeInsert(), false);
                        } else {
                            sQLiteStatement.execute();
                        }
                    }
                } else {
                    for (T t2 : iterable) {
                        bindValues(databaseStatement, (DatabaseStatement) t2);
                        if (z) {
                            updateKeyAfterInsertAndAttach(t2, databaseStatement.executeInsert(), false);
                        } else {
                            databaseStatement.execute();
                        }
                    }
                }
                IdentityScope<K, T> identityScope2 = this.identityScope;
                if (identityScope2 != null) {
                    identityScope2.unlock();
                }
            }
            this.db.setTransactionSuccessful();
        } finally {
            this.db.endTransaction();
        }
    }

    private long insertInsideTx(T t, DatabaseStatement databaseStatement) {
        synchronized (databaseStatement) {
            if (this.isStandardSQLite) {
                SQLiteStatement sQLiteStatement = (SQLiteStatement) databaseStatement.getRawStatement();
                bindValues(sQLiteStatement, (SQLiteStatement) t);
                return sQLiteStatement.executeInsert();
            }
            bindValues(databaseStatement, (DatabaseStatement) t);
            return databaseStatement.executeInsert();
        }
    }

    private void loadAllUnlockOnWindowBounds(Cursor cursor, CursorWindow cursorWindow, List<T> list) {
        int startPosition = cursorWindow.getStartPosition() + cursorWindow.getNumRows();
        int i = 0;
        while (true) {
            list.add(loadCurrent(cursor, 0, false));
            int i2 = i + 1;
            if (i2 >= startPosition) {
                CursorWindow moveToNextUnlocked = moveToNextUnlocked(cursor);
                if (moveToNextUnlocked != null) {
                    startPosition = moveToNextUnlocked.getStartPosition() + moveToNextUnlocked.getNumRows();
                } else {
                    return;
                }
            } else if (!cursor.moveToNext()) {
                return;
            }
            i = i2 + 1;
        }
    }

    private CursorWindow moveToNextUnlocked(Cursor cursor) {
        this.identityScope.unlock();
        try {
            return cursor.moveToNext() ? ((CrossProcessCursor) cursor).getWindow() : null;
        } finally {
            this.identityScope.lock();
        }
    }

    protected void assertSinglePk() {
        if (this.config.pkColumns.length != 1) {
            throw new DaoException(this + " (" + this.config.tablename + ") does not have a single-column primary key");
        }
    }

    protected void attachEntity(T t) {
    }

    protected final void attachEntity(K k, T t, boolean z) {
        attachEntity(t);
        IdentityScope<K, T> identityScope = this.identityScope;
        if (identityScope != null && k != null) {
            if (z) {
                identityScope.put(k, t);
            } else {
                identityScope.putNoLock(k, t);
            }
        }
    }

    protected abstract void bindValues(SQLiteStatement sQLiteStatement, T t);

    protected abstract void bindValues(DatabaseStatement databaseStatement, T t);

    public long count() {
        return this.statements.getCountStatement().simpleQueryForLong();
    }

    public void delete(T t) {
        assertSinglePk();
        deleteByKey(getKeyVerified(t));
    }

    public void deleteAll() {
        Database database = this.db;
        database.execSQL("DELETE FROM '" + this.config.tablename + "'");
        IdentityScope<K, T> identityScope = this.identityScope;
        if (identityScope != null) {
            identityScope.clear();
        }
    }

    public void deleteByKey(K k) {
        assertSinglePk();
        DatabaseStatement deleteStatement = this.statements.getDeleteStatement();
        if (this.db.isDbLockedByCurrentThread()) {
            synchronized (deleteStatement) {
                deleteByKeyInsideSynchronized(k, deleteStatement);
            }
        } else {
            this.db.beginTransaction();
            try {
                synchronized (deleteStatement) {
                    deleteByKeyInsideSynchronized(k, deleteStatement);
                }
                this.db.setTransactionSuccessful();
            } finally {
                this.db.endTransaction();
            }
        }
        IdentityScope<K, T> identityScope = this.identityScope;
        if (identityScope != null) {
            identityScope.remove((IdentityScope<K, T>) k);
        }
    }

    public void deleteByKeyInTx(Iterable<K> iterable) {
        deleteInTxInternal(null, iterable);
    }

    public void deleteInTx(Iterable<T> iterable) {
        deleteInTxInternal(iterable, null);
    }

    public boolean detach(T t) {
        if (this.identityScope == null) {
            return false;
        }
        return this.identityScope.detach(getKeyVerified(t), t);
    }

    public void detachAll() {
        IdentityScope<K, T> identityScope = this.identityScope;
        if (identityScope != null) {
            identityScope.clear();
        }
    }

    public String[] getAllColumns() {
        return this.config.allColumns;
    }

    public Database getDatabase() {
        return this.db;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract K getKey(T t);

    protected K getKeyVerified(T t) {
        K key = getKey(t);
        if (key != null) {
            return key;
        }
        Objects.requireNonNull(t, "Entity may not be null");
        throw new DaoException("Entity has no key");
    }

    public String[] getNonPkColumns() {
        return this.config.nonPkColumns;
    }

    public String[] getPkColumns() {
        return this.config.pkColumns;
    }

    public Property getPkProperty() {
        return this.config.pkProperty;
    }

    public Property[] getProperties() {
        return this.config.properties;
    }

    public AbstractDaoSession getSession() {
        return this.session;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public TableStatements getStatements() {
        return this.config.statements;
    }

    public String getTablename() {
        return this.config.tablename;
    }

    protected abstract boolean hasKey(T t);

    public long insert(T t) {
        return executeInsert(t, this.statements.getInsertStatement(), true);
    }

    public void insertInTx(Iterable<T> iterable) {
        insertInTx(iterable, isEntityUpdateable());
    }

    public long insertOrReplace(T t) {
        return executeInsert(t, this.statements.getInsertOrReplaceStatement(), true);
    }

    public void insertOrReplaceInTx(Iterable<T> iterable, boolean z) {
        executeInsertInTx(this.statements.getInsertOrReplaceStatement(), iterable, z);
    }

    public long insertWithoutSettingPk(T t) {
        return executeInsert(t, this.statements.getInsertOrReplaceStatement(), false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract boolean isEntityUpdateable();

    public T load(K k) {
        T t;
        assertSinglePk();
        if (k == null) {
            return null;
        }
        IdentityScope<K, T> identityScope = this.identityScope;
        return (identityScope == null || (t = identityScope.get(k)) == null) ? loadUniqueAndCloseCursor(this.db.rawQuery(this.statements.getSelectByKey(), new String[]{k.toString()})) : t;
    }

    public List<T> loadAll() {
        return loadAllAndCloseCursor(this.db.rawQuery(this.statements.getSelectAll(), null));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public List<T> loadAllAndCloseCursor(Cursor cursor) {
        try {
            return loadAllFromCursor(cursor);
        } finally {
            cursor.close();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x007d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected java.util.List<T> loadAllFromCursor(android.database.Cursor r7) {
        /*
            r6 = this;
            int r0 = r7.getCount()
            if (r0 != 0) goto L_0x000c
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            return r7
        L_0x000c:
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>(r0)
            r2 = 0
            boolean r3 = r7 instanceof android.database.CrossProcessCursor
            r4 = 0
            if (r3 == 0) goto L_0x004d
            r2 = r7
            android.database.CrossProcessCursor r2 = (android.database.CrossProcessCursor) r2
            android.database.CursorWindow r2 = r2.getWindow()
            if (r2 == 0) goto L_0x004d
            int r3 = r2.getNumRows()
            if (r3 != r0) goto L_0x002d
            org.greenrobot.greendao.internal.FastCursor r7 = new org.greenrobot.greendao.internal.FastCursor
            r7.<init>(r2)
            r3 = 1
            goto L_0x004e
        L_0x002d:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r5 = "Window vs. result size: "
            r3.append(r5)
            int r5 = r2.getNumRows()
            r3.append(r5)
            java.lang.String r5 = "/"
            r3.append(r5)
            r3.append(r0)
            java.lang.String r3 = r3.toString()
            org.greenrobot.greendao.DaoLog.d(r3)
        L_0x004d:
            r3 = 0
        L_0x004e:
            boolean r5 = r7.moveToFirst()
            if (r5 == 0) goto L_0x008a
            org.greenrobot.greendao.identityscope.IdentityScope<K, T> r5 = r6.identityScope
            if (r5 == 0) goto L_0x0060
            r5.lock()
            org.greenrobot.greendao.identityscope.IdentityScope<K, T> r5 = r6.identityScope
            r5.reserveRoom(r0)
        L_0x0060:
            if (r3 != 0) goto L_0x006c
            if (r2 == 0) goto L_0x006c
            org.greenrobot.greendao.identityscope.IdentityScope<K, T> r0 = r6.identityScope     // Catch: all -> 0x0081
            if (r0 == 0) goto L_0x006c
            r6.loadAllUnlockOnWindowBounds(r7, r2, r1)     // Catch: all -> 0x0081
            goto L_0x0079
        L_0x006c:
            java.lang.Object r0 = r6.loadCurrent(r7, r4, r4)     // Catch: all -> 0x0081
            r1.add(r0)     // Catch: all -> 0x0081
            boolean r0 = r7.moveToNext()     // Catch: all -> 0x0081
            if (r0 != 0) goto L_0x006c
        L_0x0079:
            org.greenrobot.greendao.identityscope.IdentityScope<K, T> r7 = r6.identityScope
            if (r7 == 0) goto L_0x008a
            r7.unlock()
            goto L_0x008a
        L_0x0081:
            r7 = move-exception
            org.greenrobot.greendao.identityscope.IdentityScope<K, T> r0 = r6.identityScope
            if (r0 == 0) goto L_0x0089
            r0.unlock()
        L_0x0089:
            throw r7
        L_0x008a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.greenrobot.greendao.AbstractDao.loadAllFromCursor(android.database.Cursor):java.util.List");
    }

    public T loadByRowId(long j) {
        return loadUniqueAndCloseCursor(this.db.rawQuery(this.statements.getSelectByRowId(), new String[]{Long.toString(j)}));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final T loadCurrent(Cursor cursor, int i, boolean z) {
        if (this.identityScopeLong != null) {
            if (i != 0 && cursor.isNull(this.pkOrdinal + i)) {
                return null;
            }
            long j = cursor.getLong(this.pkOrdinal + i);
            IdentityScopeLong<T> identityScopeLong = this.identityScopeLong;
            T t = z ? identityScopeLong.get2(j) : identityScopeLong.get2NoLock(j);
            if (t != null) {
                return t;
            }
            T readEntity = readEntity(cursor, i);
            attachEntity(readEntity);
            if (z) {
                this.identityScopeLong.put2(j, readEntity);
            } else {
                this.identityScopeLong.put2NoLock(j, readEntity);
            }
            return readEntity;
        } else if (this.identityScope != null) {
            K readKey = readKey(cursor, i);
            if (i != 0 && readKey == null) {
                return null;
            }
            IdentityScope<K, T> identityScope = this.identityScope;
            T noLock = z ? identityScope.get(readKey) : identityScope.getNoLock(readKey);
            if (noLock != null) {
                return noLock;
            }
            T readEntity2 = readEntity(cursor, i);
            attachEntity(readKey, readEntity2, z);
            return readEntity2;
        } else if (i != 0 && readKey(cursor, i) == null) {
            return null;
        } else {
            T readEntity3 = readEntity(cursor, i);
            attachEntity(readEntity3);
            return readEntity3;
        }
    }

    protected final <O> O loadCurrentOther(AbstractDao<O, ?> abstractDao, Cursor cursor, int i) {
        return abstractDao.loadCurrent(cursor, i, true);
    }

    protected T loadUnique(Cursor cursor) {
        if (!cursor.moveToFirst()) {
            return null;
        }
        if (cursor.isLast()) {
            return loadCurrent(cursor, 0, true);
        }
        throw new DaoException("Expected unique result, but count was " + cursor.getCount());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public T loadUniqueAndCloseCursor(Cursor cursor) {
        try {
            return loadUnique(cursor);
        } finally {
            cursor.close();
        }
    }

    public QueryBuilder<T> queryBuilder() {
        return QueryBuilder.internalCreate(this);
    }

    public List<T> queryRaw(String str, String... strArr) {
        Database database = this.db;
        return loadAllAndCloseCursor(database.rawQuery(this.statements.getSelectAll() + str, strArr));
    }

    public Query<T> queryRawCreate(String str, Object... objArr) {
        return queryRawCreateListArgs(str, Arrays.asList(objArr));
    }

    public Query<T> queryRawCreateListArgs(String str, Collection<Object> collection) {
        return Query.internalCreate(this, this.statements.getSelectAll() + str, collection.toArray());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract T readEntity(Cursor cursor, int i);

    protected abstract void readEntity(Cursor cursor, T t, int i);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract K readKey(Cursor cursor, int i);

    public void refresh(T t) {
        assertSinglePk();
        K keyVerified = getKeyVerified(t);
        Cursor rawQuery = this.db.rawQuery(this.statements.getSelectByKey(), new String[]{keyVerified.toString()});
        try {
            if (!rawQuery.moveToFirst()) {
                throw new DaoException("Entity does not exist in the database anymore: " + t.getClass() + " with key " + keyVerified);
            } else if (rawQuery.isLast()) {
                readEntity(rawQuery, t, 0);
                attachEntity(keyVerified, t, true);
            } else {
                throw new DaoException("Expected unique result, but count was " + rawQuery.getCount());
            }
        } finally {
            rawQuery.close();
        }
    }

    @Experimental
    public RxDao<T, K> rx() {
        if (this.rxDao == null) {
            this.rxDao = new RxDao<>(this, Schedulers.io());
        }
        return this.rxDao;
    }

    @Experimental
    public RxDao<T, K> rxPlain() {
        if (this.rxDaoPlain == null) {
            this.rxDaoPlain = new RxDao<>(this);
        }
        return this.rxDaoPlain;
    }

    public void save(T t) {
        if (hasKey(t)) {
            update(t);
        } else {
            insert(t);
        }
    }

    public void saveInTx(T... tArr) {
        saveInTx(Arrays.asList(tArr));
    }

    public void update(T t) {
        assertSinglePk();
        DatabaseStatement updateStatement = this.statements.getUpdateStatement();
        if (this.db.isDbLockedByCurrentThread()) {
            synchronized (updateStatement) {
                if (this.isStandardSQLite) {
                    updateInsideSynchronized((AbstractDao<T, K>) t, (SQLiteStatement) updateStatement.getRawStatement(), true);
                } else {
                    updateInsideSynchronized((AbstractDao<T, K>) t, updateStatement, true);
                }
            }
            return;
        }
        this.db.beginTransaction();
        try {
            synchronized (updateStatement) {
                updateInsideSynchronized((AbstractDao<T, K>) t, updateStatement, true);
            }
            this.db.setTransactionSuccessful();
        } finally {
            this.db.endTransaction();
        }
    }

    public void updateInTx(Iterable<T> iterable) {
        RuntimeException e2;
        DatabaseStatement updateStatement = this.statements.getUpdateStatement();
        this.db.beginTransaction();
        try {
            synchronized (updateStatement) {
                IdentityScope<K, T> identityScope = this.identityScope;
                if (identityScope != null) {
                    identityScope.lock();
                }
                if (this.isStandardSQLite) {
                    SQLiteStatement sQLiteStatement = (SQLiteStatement) updateStatement.getRawStatement();
                    for (T t : iterable) {
                        updateInsideSynchronized((AbstractDao<T, K>) t, sQLiteStatement, false);
                    }
                } else {
                    for (T t2 : iterable) {
                        updateInsideSynchronized((AbstractDao<T, K>) t2, updateStatement, false);
                    }
                }
                IdentityScope<K, T> identityScope2 = this.identityScope;
                if (identityScope2 != null) {
                    identityScope2.unlock();
                }
            }
            this.db.setTransactionSuccessful();
        } catch (RuntimeException e3) {
            e2 = e3;
            try {
                this.db.endTransaction();
            } catch (RuntimeException e4) {
                DaoLog.w("Could not end transaction (rethrowing initial exception)", e4);
                throw e2;
            }
        } catch (Throwable th) {
            try {
                this.db.endTransaction();
                throw th;
            } catch (RuntimeException e5) {
                throw e5;
            }
        }
        try {
            this.db.endTransaction();
            e2 = null;
            if (e2 != null) {
                throw e2;
            }
        } catch (RuntimeException e6) {
            throw e6;
        }
    }

    protected void updateInsideSynchronized(T t, DatabaseStatement databaseStatement, boolean z) {
        bindValues(databaseStatement, (DatabaseStatement) t);
        int length = this.config.allColumns.length + 1;
        K key = getKey(t);
        if (key instanceof Long) {
            databaseStatement.bindLong(length, ((Long) key).longValue());
        } else if (key != null) {
            databaseStatement.bindString(length, key.toString());
        } else {
            throw new DaoException("Cannot update entity without key - was it inserted before?");
        }
        databaseStatement.execute();
        attachEntity(key, t, z);
    }

    protected abstract K updateKeyAfterInsert(T t, long j);

    protected void updateKeyAfterInsertAndAttach(T t, long j, boolean z) {
        if (j != -1) {
            attachEntity(updateKeyAfterInsert(t, j), t, z);
        } else {
            DaoLog.w("Could not insert row (executeInsert returned -1)");
        }
    }

    public AbstractDao(DaoConfig daoConfig, AbstractDaoSession abstractDaoSession) {
        this.config = daoConfig;
        this.session = abstractDaoSession;
        Database database = daoConfig.db;
        this.db = database;
        this.isStandardSQLite = database.getRawDatabase() instanceof SQLiteDatabase;
        IdentityScope<K, T> identityScope = (IdentityScope<K, T>) daoConfig.getIdentityScope();
        this.identityScope = identityScope;
        if (identityScope instanceof IdentityScopeLong) {
            this.identityScopeLong = (IdentityScopeLong) identityScope;
        } else {
            this.identityScopeLong = null;
        }
        this.statements = daoConfig.statements;
        Property property = daoConfig.pkProperty;
        this.pkOrdinal = property != null ? property.ordinal : -1;
    }

    public void deleteByKeyInTx(K... kArr) {
        deleteInTxInternal(null, Arrays.asList(kArr));
    }

    public void deleteInTx(T... tArr) {
        deleteInTxInternal(Arrays.asList(tArr), null);
    }

    public void insertInTx(T... tArr) {
        insertInTx(Arrays.asList(tArr), isEntityUpdateable());
    }

    public void saveInTx(Iterable<T> iterable) {
        int i = 0;
        int i2 = 0;
        for (T t : iterable) {
            if (hasKey(t)) {
                i++;
            } else {
                i2++;
            }
        }
        if (i > 0 && i2 > 0) {
            ArrayList arrayList = new ArrayList(i);
            ArrayList arrayList2 = new ArrayList(i2);
            for (T t2 : iterable) {
                if (hasKey(t2)) {
                    arrayList.add(t2);
                } else {
                    arrayList2.add(t2);
                }
            }
            this.db.beginTransaction();
            try {
                updateInTx(arrayList);
                insertInTx(arrayList2);
                this.db.setTransactionSuccessful();
            } finally {
                this.db.endTransaction();
            }
        } else if (i2 > 0) {
            insertInTx(iterable);
        } else if (i > 0) {
            updateInTx(iterable);
        }
    }

    public void insertInTx(Iterable<T> iterable, boolean z) {
        executeInsertInTx(this.statements.getInsertStatement(), iterable, z);
    }

    public void insertOrReplaceInTx(Iterable<T> iterable) {
        insertOrReplaceInTx(iterable, isEntityUpdateable());
    }

    public void insertOrReplaceInTx(T... tArr) {
        insertOrReplaceInTx(Arrays.asList(tArr), isEntityUpdateable());
    }

    protected void updateInsideSynchronized(T t, SQLiteStatement sQLiteStatement, boolean z) {
        bindValues(sQLiteStatement, (SQLiteStatement) t);
        int length = this.config.allColumns.length + 1;
        K key = getKey(t);
        if (key instanceof Long) {
            sQLiteStatement.bindLong(length, ((Long) key).longValue());
        } else if (key != null) {
            sQLiteStatement.bindString(length, key.toString());
        } else {
            throw new DaoException("Cannot update entity without key - was it inserted before?");
        }
        sQLiteStatement.execute();
        attachEntity(key, t, z);
    }

    public void updateInTx(T... tArr) {
        updateInTx(Arrays.asList(tArr));
    }
}
