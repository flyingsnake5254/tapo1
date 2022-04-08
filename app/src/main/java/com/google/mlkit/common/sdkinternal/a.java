package com.google.mlkit.common.sdkinternal;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.mlkit.common.sdkinternal.a;
import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadFactory;

/* compiled from: com.google.mlkit:common@@16.0.0 */
/* loaded from: classes2.dex */
public class a {
    private final ReferenceQueue<Object> a = new ReferenceQueue<>();

    /* renamed from: b  reason: collision with root package name */
    private final Set<b> f4940b = Collections.synchronizedSet(new HashSet());

    /* compiled from: com.google.mlkit:common@@16.0.0 */
    /* renamed from: com.google.mlkit.common.sdkinternal.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface AbstractC0181a {
        @KeepForSdk
        void a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: com.google.mlkit:common@@16.0.0 */
    /* loaded from: classes2.dex */
    public static class b extends PhantomReference<Object> implements AbstractC0181a {
        private final Set<b> a;

        /* renamed from: b  reason: collision with root package name */
        private final Runnable f4941b;

        private b(Object obj, ReferenceQueue<? super Object> referenceQueue, Set<b> set, Runnable runnable) {
            super(obj, referenceQueue);
            this.a = set;
            this.f4941b = runnable;
        }

        @Override // com.google.mlkit.common.sdkinternal.a.AbstractC0181a
        public final void a() {
            if (this.a.remove(this)) {
                clear();
                this.f4941b.run();
            }
        }
    }

    private a() {
    }

    @KeepForSdk
    public static a a() {
        ThreadFactory threadFactory = o.f4967c;
        a aVar = new a();
        aVar.b(aVar, q.f4970c);
        final ReferenceQueue<Object> referenceQueue = aVar.a;
        final Set<b> set = aVar.f4940b;
        threadFactory.newThread(new Runnable(referenceQueue, set) { // from class: com.google.mlkit.common.sdkinternal.p

            /* renamed from: c  reason: collision with root package name */
            private final ReferenceQueue f4968c;

            /* renamed from: d  reason: collision with root package name */
            private final Set f4969d;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f4968c = referenceQueue;
                this.f4969d = set;
            }

            @Override // java.lang.Runnable
            public final void run() {
                ReferenceQueue referenceQueue2 = this.f4968c;
                Set set2 = this.f4969d;
                while (!set2.isEmpty()) {
                    try {
                        ((a.b) referenceQueue2.remove()).a();
                    } catch (InterruptedException unused) {
                    }
                }
            }
        }).start();
        return aVar;
    }

    @KeepForSdk
    public AbstractC0181a b(Object obj, Runnable runnable) {
        b bVar = new b(obj, this.a, this.f4940b, runnable);
        this.f4940b.add(bVar);
        return bVar;
    }
}
