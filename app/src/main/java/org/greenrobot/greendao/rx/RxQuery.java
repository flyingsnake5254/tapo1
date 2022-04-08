package org.greenrobot.greendao.rx;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import org.greenrobot.greendao.annotation.apihint.Experimental;
import org.greenrobot.greendao.query.LazyList;
import org.greenrobot.greendao.query.Query;
import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.exceptions.Exceptions;

@Experimental
/* loaded from: classes4.dex */
public class RxQuery<T> extends RxBase {
    private final Query<T> query;

    public RxQuery(Query<T> query) {
        this.query = query;
    }

    @Override // org.greenrobot.greendao.rx.RxBase
    @Experimental
    public /* bridge */ /* synthetic */ Scheduler getScheduler() {
        return super.getScheduler();
    }

    @Experimental
    public Observable<List<T>> list() {
        return (Observable<List<T>>) wrap((Callable<List<T>>) new Callable<List<T>>() { // from class: org.greenrobot.greendao.rx.RxQuery.1
            @Override // java.util.concurrent.Callable
            public List<T> call() throws Exception {
                return RxQuery.this.query.forCurrentThread().list();
            }
        });
    }

    public Observable<T> oneByOne() {
        return (Observable<T>) wrap(Observable.create(new Observable.OnSubscribe<T>() { // from class: org.greenrobot.greendao.rx.RxQuery.3
            public /* bridge */ /* synthetic */ void call(Object obj) {
                call((Subscriber) ((Subscriber) obj));
            }

            public void call(Subscriber<? super T> subscriber) {
                try {
                    LazyList<T> listLazyUncached = RxQuery.this.query.forCurrentThread().listLazyUncached();
                    Iterator<T> it = listLazyUncached.iterator();
                    while (it.hasNext()) {
                        T next = it.next();
                        if (subscriber.isUnsubscribed()) {
                            break;
                        }
                        subscriber.onNext(next);
                    }
                    listLazyUncached.close();
                    if (!subscriber.isUnsubscribed()) {
                        subscriber.onCompleted();
                    }
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    subscriber.onError(th);
                }
            }
        }));
    }

    @Experimental
    public Observable<T> unique() {
        return (Observable<T>) wrap((Callable<T>) new Callable<T>() { // from class: org.greenrobot.greendao.rx.RxQuery.2
            @Override // java.util.concurrent.Callable
            public T call() throws Exception {
                return RxQuery.this.query.forCurrentThread().unique();
            }
        });
    }

    public RxQuery(Query<T> query, Scheduler scheduler) {
        super(scheduler);
        this.query = query;
    }
}
