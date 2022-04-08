package org.greenrobot.greendao.test;

import org.greenrobot.greendao.AbstractDaoMaster;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;

/* loaded from: classes4.dex */
public abstract class AbstractDaoSessionTest<T extends AbstractDaoMaster, S extends AbstractDaoSession> extends DbTest {
    protected T daoMaster;
    private final Class<T> daoMasterClass;
    protected S daoSession;

    public AbstractDaoSessionTest(Class<T> cls) {
        this(cls, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.greenrobot.greendao.test.DbTest
    public void setUp() throws Exception {
        super.setUp();
        try {
            this.daoMaster = this.daoMasterClass.getConstructor(Database.class).newInstance(this.db);
            this.daoMasterClass.getMethod("createAllTables", Database.class, Boolean.TYPE).invoke(null, this.db, Boolean.FALSE);
            this.daoSession = (S) this.daoMaster.newSession();
        } catch (Exception e2) {
            throw new RuntimeException("Could not prepare DAO session test", e2);
        }
    }

    public AbstractDaoSessionTest(Class<T> cls, boolean z) {
        super(z);
        this.daoMasterClass = cls;
    }
}
