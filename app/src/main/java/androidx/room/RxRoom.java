package androidx.room;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.room.InvalidationTracker;
import io.reactivex.BackpressureStrategy;
import io.reactivex.a0;
import io.reactivex.e0.d;
import io.reactivex.g0.a;
import io.reactivex.h;
import io.reactivex.i;
import io.reactivex.j;
import io.reactivex.m;
import io.reactivex.o;
import io.reactivex.q;
import io.reactivex.r;
import io.reactivex.s;
import io.reactivex.w;
import io.reactivex.x;
import io.reactivex.y;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public class RxRoom {
    public static final Object NOTHING = new Object();

    public static h<Object> createFlowable(final RoomDatabase roomDatabase, final String... strArr) {
        return h.f(new j<Object>() { // from class: androidx.room.RxRoom.1
            @Override // io.reactivex.j
            public void subscribe(final i<Object> iVar) throws Exception {
                final InvalidationTracker.Observer observer = new InvalidationTracker.Observer(strArr) { // from class: androidx.room.RxRoom.1.1
                    @Override // androidx.room.InvalidationTracker.Observer
                    public void onInvalidated(@NonNull Set<String> set) {
                        if (!iVar.isCancelled()) {
                            iVar.onNext(RxRoom.NOTHING);
                        }
                    }
                };
                if (!iVar.isCancelled()) {
                    roomDatabase.getInvalidationTracker().addObserver(observer);
                    iVar.a(d.c(new a() { // from class: androidx.room.RxRoom.1.2
                        @Override // io.reactivex.g0.a
                        public void run() throws Exception {
                            roomDatabase.getInvalidationTracker().removeObserver(observer);
                        }
                    }));
                }
                if (!iVar.isCancelled()) {
                    iVar.onNext(RxRoom.NOTHING);
                }
            }
        }, BackpressureStrategy.LATEST);
    }

    public static q<Object> createObservable(final RoomDatabase roomDatabase, final String... strArr) {
        return q.m(new s<Object>() { // from class: androidx.room.RxRoom.3
            @Override // io.reactivex.s
            public void subscribe(final r<Object> rVar) throws Exception {
                final InvalidationTracker.Observer observer = new InvalidationTracker.Observer(strArr) { // from class: androidx.room.RxRoom.3.1
                    @Override // androidx.room.InvalidationTracker.Observer
                    public void onInvalidated(@NonNull Set<String> set) {
                        rVar.onNext(RxRoom.NOTHING);
                    }
                };
                roomDatabase.getInvalidationTracker().addObserver(observer);
                rVar.a(d.c(new a() { // from class: androidx.room.RxRoom.3.2
                    @Override // io.reactivex.g0.a
                    public void run() throws Exception {
                        roomDatabase.getInvalidationTracker().removeObserver(observer);
                    }
                }));
                rVar.onNext(RxRoom.NOTHING);
            }
        });
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static <T> x<T> createSingle(final Callable<T> callable) {
        return x.e(new a0<T>() { // from class: androidx.room.RxRoom.5
            @Override // io.reactivex.a0
            public void subscribe(y<T> yVar) throws Exception {
                try {
                    yVar.onSuccess(callable.call());
                } catch (EmptyResultSetException e2) {
                    yVar.a(e2);
                }
            }
        });
    }

    private static Executor getExecutor(RoomDatabase roomDatabase, boolean z) {
        if (z) {
            return roomDatabase.getTransactionExecutor();
        }
        return roomDatabase.getQueryExecutor();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Deprecated
    public static <T> h<T> createFlowable(RoomDatabase roomDatabase, String[] strArr, Callable<T> callable) {
        return createFlowable(roomDatabase, false, strArr, callable);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Deprecated
    public static <T> q<T> createObservable(RoomDatabase roomDatabase, String[] strArr, Callable<T> callable) {
        return createObservable(roomDatabase, false, strArr, callable);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static <T> h<T> createFlowable(RoomDatabase roomDatabase, boolean z, String[] strArr, Callable<T> callable) {
        w b2 = io.reactivex.l0.a.b(getExecutor(roomDatabase, z));
        final m j = m.j(callable);
        return (h<T>) createFlowable(roomDatabase, strArr).I(b2).L(b2).w(b2).s(new io.reactivex.g0.j<Object, o<T>>() { // from class: androidx.room.RxRoom.2
            @Override // io.reactivex.g0.j
            public o<T> apply(Object obj) throws Exception {
                return m.this;
            }
        });
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static <T> q<T> createObservable(RoomDatabase roomDatabase, boolean z, String[] strArr, Callable<T> callable) {
        w b2 = io.reactivex.l0.a.b(getExecutor(roomDatabase, z));
        final m j = m.j(callable);
        return (q<T>) createObservable(roomDatabase, strArr).L0(b2).b1(b2).l0(b2).U(new io.reactivex.g0.j<Object, o<T>>() { // from class: androidx.room.RxRoom.4
            @Override // io.reactivex.g0.j
            public o<T> apply(Object obj) throws Exception {
                return m.this;
            }
        });
    }
}
