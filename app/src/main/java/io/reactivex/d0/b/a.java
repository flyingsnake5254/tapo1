package io.reactivex.d0.b;

import android.os.Handler;
import android.os.Looper;
import io.reactivex.w;
import java.util.concurrent.Callable;

/* compiled from: AndroidSchedulers.java */
/* loaded from: classes4.dex */
public final class a {
    private static final w a = io.reactivex.d0.a.a.d(new CallableC0290a());

    /* compiled from: AndroidSchedulers.java */
    /* renamed from: io.reactivex.d0.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    static class CallableC0290a implements Callable<w> {
        CallableC0290a() {
        }

        /* renamed from: a */
        public w call() throws Exception {
            return b.a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AndroidSchedulers.java */
    /* loaded from: classes4.dex */
    public static final class b {
        static final w a = new b(new Handler(Looper.getMainLooper()), false);
    }

    public static w a() {
        return io.reactivex.d0.a.a.e(a);
    }
}
