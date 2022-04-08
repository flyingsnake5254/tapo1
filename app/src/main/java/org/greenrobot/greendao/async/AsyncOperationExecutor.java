package org.greenrobot.greendao.async;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.DaoLog;
import org.greenrobot.greendao.async.AsyncOperation;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.query.Query;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class AsyncOperationExecutor implements Runnable, Handler.Callback {
    private static ExecutorService executorService = Executors.newCachedThreadPool();
    private int countOperationsCompleted;
    private int countOperationsEnqueued;
    private volatile boolean executorRunning;
    private Handler handlerMainThread;
    private int lastSequenceNumber;
    private volatile AsyncOperationListener listener;
    private volatile AsyncOperationListener listenerMainThread;
    private final BlockingQueue<AsyncOperation> queue = new LinkedBlockingQueue();
    private volatile int maxOperationCountToMerge = 50;
    private volatile int waitForMergeMillis = 50;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: org.greenrobot.greendao.async.AsyncOperationExecutor$1  reason: invalid class name */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$greenrobot$greendao$async$AsyncOperation$OperationType;

        static {
            int[] iArr = new int[AsyncOperation.OperationType.values().length];
            $SwitchMap$org$greenrobot$greendao$async$AsyncOperation$OperationType = iArr;
            try {
                iArr[AsyncOperation.OperationType.Delete.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$greenrobot$greendao$async$AsyncOperation$OperationType[AsyncOperation.OperationType.DeleteInTxIterable.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$greenrobot$greendao$async$AsyncOperation$OperationType[AsyncOperation.OperationType.DeleteInTxArray.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$greenrobot$greendao$async$AsyncOperation$OperationType[AsyncOperation.OperationType.Insert.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$greenrobot$greendao$async$AsyncOperation$OperationType[AsyncOperation.OperationType.InsertInTxIterable.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$org$greenrobot$greendao$async$AsyncOperation$OperationType[AsyncOperation.OperationType.InsertInTxArray.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$org$greenrobot$greendao$async$AsyncOperation$OperationType[AsyncOperation.OperationType.InsertOrReplace.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$org$greenrobot$greendao$async$AsyncOperation$OperationType[AsyncOperation.OperationType.InsertOrReplaceInTxIterable.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$org$greenrobot$greendao$async$AsyncOperation$OperationType[AsyncOperation.OperationType.InsertOrReplaceInTxArray.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$org$greenrobot$greendao$async$AsyncOperation$OperationType[AsyncOperation.OperationType.Update.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$org$greenrobot$greendao$async$AsyncOperation$OperationType[AsyncOperation.OperationType.UpdateInTxIterable.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$org$greenrobot$greendao$async$AsyncOperation$OperationType[AsyncOperation.OperationType.UpdateInTxArray.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$org$greenrobot$greendao$async$AsyncOperation$OperationType[AsyncOperation.OperationType.TransactionRunnable.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$org$greenrobot$greendao$async$AsyncOperation$OperationType[AsyncOperation.OperationType.TransactionCallable.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$org$greenrobot$greendao$async$AsyncOperation$OperationType[AsyncOperation.OperationType.QueryList.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$org$greenrobot$greendao$async$AsyncOperation$OperationType[AsyncOperation.OperationType.QueryUnique.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                $SwitchMap$org$greenrobot$greendao$async$AsyncOperation$OperationType[AsyncOperation.OperationType.DeleteByKey.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                $SwitchMap$org$greenrobot$greendao$async$AsyncOperation$OperationType[AsyncOperation.OperationType.DeleteAll.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                $SwitchMap$org$greenrobot$greendao$async$AsyncOperation$OperationType[AsyncOperation.OperationType.Load.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                $SwitchMap$org$greenrobot$greendao$async$AsyncOperation$OperationType[AsyncOperation.OperationType.LoadAll.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                $SwitchMap$org$greenrobot$greendao$async$AsyncOperation$OperationType[AsyncOperation.OperationType.Count.ordinal()] = 21;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                $SwitchMap$org$greenrobot$greendao$async$AsyncOperation$OperationType[AsyncOperation.OperationType.Refresh.ordinal()] = 22;
            } catch (NoSuchFieldError unused22) {
            }
        }
    }

    private void executeOperation(AsyncOperation asyncOperation) {
        asyncOperation.timeStarted = System.currentTimeMillis();
        try {
            switch (AnonymousClass1.$SwitchMap$org$greenrobot$greendao$async$AsyncOperation$OperationType[asyncOperation.type.ordinal()]) {
                case 1:
                    asyncOperation.dao.delete(asyncOperation.parameter);
                    break;
                case 2:
                    asyncOperation.dao.deleteInTx((Iterable) asyncOperation.parameter);
                    break;
                case 3:
                    asyncOperation.dao.deleteInTx((Object[]) asyncOperation.parameter);
                    break;
                case 4:
                    asyncOperation.dao.insert(asyncOperation.parameter);
                    break;
                case 5:
                    asyncOperation.dao.insertInTx((Iterable) asyncOperation.parameter);
                    break;
                case 6:
                    asyncOperation.dao.insertInTx((Object[]) asyncOperation.parameter);
                    break;
                case 7:
                    asyncOperation.dao.insertOrReplace(asyncOperation.parameter);
                    break;
                case 8:
                    asyncOperation.dao.insertOrReplaceInTx((Iterable) asyncOperation.parameter);
                    break;
                case 9:
                    asyncOperation.dao.insertOrReplaceInTx((Object[]) asyncOperation.parameter);
                    break;
                case 10:
                    asyncOperation.dao.update(asyncOperation.parameter);
                    break;
                case 11:
                    asyncOperation.dao.updateInTx((Iterable) asyncOperation.parameter);
                    break;
                case 12:
                    asyncOperation.dao.updateInTx((Object[]) asyncOperation.parameter);
                    break;
                case 13:
                    executeTransactionRunnable(asyncOperation);
                    break;
                case 14:
                    executeTransactionCallable(asyncOperation);
                    break;
                case 15:
                    asyncOperation.result = ((Query) asyncOperation.parameter).forCurrentThread().list();
                    break;
                case 16:
                    asyncOperation.result = ((Query) asyncOperation.parameter).forCurrentThread().unique();
                    break;
                case 17:
                    asyncOperation.dao.deleteByKey(asyncOperation.parameter);
                    break;
                case 18:
                    asyncOperation.dao.deleteAll();
                    break;
                case 19:
                    asyncOperation.result = asyncOperation.dao.load(asyncOperation.parameter);
                    break;
                case 20:
                    asyncOperation.result = asyncOperation.dao.loadAll();
                    break;
                case 21:
                    asyncOperation.result = Long.valueOf(asyncOperation.dao.count());
                    break;
                case 22:
                    asyncOperation.dao.refresh(asyncOperation.parameter);
                    break;
                default:
                    throw new DaoException("Unsupported operation: " + asyncOperation.type);
            }
        } catch (Throwable th) {
            asyncOperation.throwable = th;
        }
        asyncOperation.timeCompleted = System.currentTimeMillis();
    }

    private void executeOperationAndPostCompleted(AsyncOperation asyncOperation) {
        executeOperation(asyncOperation);
        handleOperationCompleted(asyncOperation);
    }

    private void executeTransactionCallable(AsyncOperation asyncOperation) throws Exception {
        Database database = asyncOperation.getDatabase();
        database.beginTransaction();
        try {
            asyncOperation.result = ((Callable) asyncOperation.parameter).call();
            database.setTransactionSuccessful();
        } finally {
            database.endTransaction();
        }
    }

    private void executeTransactionRunnable(AsyncOperation asyncOperation) {
        Database database = asyncOperation.getDatabase();
        database.beginTransaction();
        try {
            ((Runnable) asyncOperation.parameter).run();
            database.setTransactionSuccessful();
        } finally {
            database.endTransaction();
        }
    }

    private void handleOperationCompleted(AsyncOperation asyncOperation) {
        asyncOperation.setCompleted();
        AsyncOperationListener asyncOperationListener = this.listener;
        if (asyncOperationListener != null) {
            asyncOperationListener.onAsyncOperationCompleted(asyncOperation);
        }
        if (this.listenerMainThread != null) {
            if (this.handlerMainThread == null) {
                this.handlerMainThread = new Handler(Looper.getMainLooper(), this);
            }
            this.handlerMainThread.sendMessage(this.handlerMainThread.obtainMessage(1, asyncOperation));
        }
        synchronized (this) {
            int i = this.countOperationsCompleted + 1;
            this.countOperationsCompleted = i;
            if (i == this.countOperationsEnqueued) {
                notifyAll();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0063, code lost:
        r4 = false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void mergeTxAndExecute(org.greenrobot.greendao.async.AsyncOperation r8, org.greenrobot.greendao.async.AsyncOperation r9) {
        /*
            r7 = this;
            java.lang.String r0 = "Async transaction could not be ended, success so far was: "
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r1.add(r8)
            r1.add(r9)
            org.greenrobot.greendao.database.Database r8 = r8.getDatabase()
            r8.beginTransaction()
            r9 = 0
            r2 = 0
        L_0x0016:
            int r3 = r1.size()     // Catch: all -> 0x00b5
            r4 = 1
            if (r2 >= r3) goto L_0x0063
            java.lang.Object r3 = r1.get(r2)     // Catch: all -> 0x00b5
            org.greenrobot.greendao.async.AsyncOperation r3 = (org.greenrobot.greendao.async.AsyncOperation) r3     // Catch: all -> 0x00b5
            r7.executeOperation(r3)     // Catch: all -> 0x00b5
            boolean r5 = r3.isFailed()     // Catch: all -> 0x00b5
            if (r5 == 0) goto L_0x002d
            goto L_0x0063
        L_0x002d:
            int r5 = r1.size()     // Catch: all -> 0x00b5
            int r5 = r5 - r4
            if (r2 != r5) goto L_0x0060
            java.util.concurrent.BlockingQueue<org.greenrobot.greendao.async.AsyncOperation> r5 = r7.queue     // Catch: all -> 0x00b5
            java.lang.Object r5 = r5.peek()     // Catch: all -> 0x00b5
            org.greenrobot.greendao.async.AsyncOperation r5 = (org.greenrobot.greendao.async.AsyncOperation) r5     // Catch: all -> 0x00b5
            int r6 = r7.maxOperationCountToMerge     // Catch: all -> 0x00b5
            if (r2 >= r6) goto L_0x005c
            boolean r3 = r3.isMergeableWith(r5)     // Catch: all -> 0x00b5
            if (r3 == 0) goto L_0x005c
            java.util.concurrent.BlockingQueue<org.greenrobot.greendao.async.AsyncOperation> r3 = r7.queue     // Catch: all -> 0x00b5
            java.lang.Object r3 = r3.remove()     // Catch: all -> 0x00b5
            org.greenrobot.greendao.async.AsyncOperation r3 = (org.greenrobot.greendao.async.AsyncOperation) r3     // Catch: all -> 0x00b5
            if (r3 != r5) goto L_0x0054
            r1.add(r3)     // Catch: all -> 0x00b5
            goto L_0x0060
        L_0x0054:
            org.greenrobot.greendao.DaoException r1 = new org.greenrobot.greendao.DaoException     // Catch: all -> 0x00b5
            java.lang.String r2 = "Internal error: peeked op did not match removed op"
            r1.<init>(r2)     // Catch: all -> 0x00b5
            throw r1     // Catch: all -> 0x00b5
        L_0x005c:
            r8.setTransactionSuccessful()     // Catch: all -> 0x00b5
            goto L_0x0064
        L_0x0060:
            int r2 = r2 + 1
            goto L_0x0016
        L_0x0063:
            r4 = 0
        L_0x0064:
            r8.endTransaction()     // Catch: RuntimeException -> 0x0069
            r9 = r4
            goto L_0x007c
        L_0x0069:
            r8 = move-exception
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r0)
            r2.append(r4)
            java.lang.String r0 = r2.toString()
            org.greenrobot.greendao.DaoLog.i(r0, r8)
        L_0x007c:
            if (r9 == 0) goto L_0x0098
            int r8 = r1.size()
            java.util.Iterator r9 = r1.iterator()
        L_0x0086:
            boolean r0 = r9.hasNext()
            if (r0 == 0) goto L_0x00b4
            java.lang.Object r0 = r9.next()
            org.greenrobot.greendao.async.AsyncOperation r0 = (org.greenrobot.greendao.async.AsyncOperation) r0
            r0.mergedOperationsCount = r8
            r7.handleOperationCompleted(r0)
            goto L_0x0086
        L_0x0098:
            java.lang.String r8 = "Reverted merged transaction because one of the operations failed. Executing operations one by one instead..."
            org.greenrobot.greendao.DaoLog.i(r8)
            java.util.Iterator r8 = r1.iterator()
        L_0x00a1:
            boolean r9 = r8.hasNext()
            if (r9 == 0) goto L_0x00b4
            java.lang.Object r9 = r8.next()
            org.greenrobot.greendao.async.AsyncOperation r9 = (org.greenrobot.greendao.async.AsyncOperation) r9
            r9.reset()
            r7.executeOperationAndPostCompleted(r9)
            goto L_0x00a1
        L_0x00b4:
            return
        L_0x00b5:
            r1 = move-exception
            r8.endTransaction()     // Catch: RuntimeException -> 0x00ba
            goto L_0x00cd
        L_0x00ba:
            r8 = move-exception
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r0)
            r2.append(r9)
            java.lang.String r9 = r2.toString()
            org.greenrobot.greendao.DaoLog.i(r9, r8)
        L_0x00cd:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.greenrobot.greendao.async.AsyncOperationExecutor.mergeTxAndExecute(org.greenrobot.greendao.async.AsyncOperation, org.greenrobot.greendao.async.AsyncOperation):void");
    }

    public void enqueue(AsyncOperation asyncOperation) {
        synchronized (this) {
            int i = this.lastSequenceNumber + 1;
            this.lastSequenceNumber = i;
            asyncOperation.sequenceNumber = i;
            this.queue.add(asyncOperation);
            this.countOperationsEnqueued++;
            if (!this.executorRunning) {
                this.executorRunning = true;
                executorService.execute(this);
            }
        }
    }

    public AsyncOperationListener getListener() {
        return this.listener;
    }

    public AsyncOperationListener getListenerMainThread() {
        return this.listenerMainThread;
    }

    public int getMaxOperationCountToMerge() {
        return this.maxOperationCountToMerge;
    }

    public int getWaitForMergeMillis() {
        return this.waitForMergeMillis;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        AsyncOperationListener asyncOperationListener = this.listenerMainThread;
        if (asyncOperationListener == null) {
            return false;
        }
        asyncOperationListener.onAsyncOperationCompleted((AsyncOperation) message.obj);
        return false;
    }

    public synchronized boolean isCompleted() {
        return this.countOperationsEnqueued == this.countOperationsCompleted;
    }

    @Override // java.lang.Runnable
    public void run() {
        AsyncOperation poll;
        while (true) {
            try {
                AsyncOperation poll2 = this.queue.poll(1L, TimeUnit.SECONDS);
                if (poll2 == null) {
                    synchronized (this) {
                        poll2 = this.queue.poll();
                        if (poll2 == null) {
                            return;
                        }
                    }
                }
                if (!poll2.isMergeTx() || (poll = this.queue.poll(this.waitForMergeMillis, TimeUnit.MILLISECONDS)) == null) {
                    executeOperationAndPostCompleted(poll2);
                } else if (poll2.isMergeableWith(poll)) {
                    mergeTxAndExecute(poll2, poll);
                } else {
                    executeOperationAndPostCompleted(poll2);
                    executeOperationAndPostCompleted(poll);
                }
            } catch (InterruptedException e2) {
                DaoLog.w(Thread.currentThread().getName() + " was interruppted", e2);
                return;
            } finally {
                this.executorRunning = false;
            }
        }
    }

    public void setListener(AsyncOperationListener asyncOperationListener) {
        this.listener = asyncOperationListener;
    }

    public void setListenerMainThread(AsyncOperationListener asyncOperationListener) {
        this.listenerMainThread = asyncOperationListener;
    }

    public void setMaxOperationCountToMerge(int i) {
        this.maxOperationCountToMerge = i;
    }

    public void setWaitForMergeMillis(int i) {
        this.waitForMergeMillis = i;
    }

    public synchronized void waitForCompletion() {
        while (!isCompleted()) {
            try {
                wait();
            } catch (InterruptedException e2) {
                throw new DaoException("Interrupted while waiting for all operations to complete", e2);
            }
        }
    }

    public synchronized boolean waitForCompletion(int i) {
        if (!isCompleted()) {
            try {
                wait(i);
            } catch (InterruptedException e2) {
                throw new DaoException("Interrupted while waiting for all operations to complete", e2);
            }
        }
        return isCompleted();
    }
}
