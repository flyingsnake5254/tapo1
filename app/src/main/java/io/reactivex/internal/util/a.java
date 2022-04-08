package io.reactivex.internal.util;

import io.reactivex.g0.l;

/* compiled from: AppendOnlyLinkedArrayList.java */
/* loaded from: classes4.dex */
public class a<T> {
    final int a;

    /* renamed from: b  reason: collision with root package name */
    final Object[] f16237b;

    /* renamed from: c  reason: collision with root package name */
    Object[] f16238c;

    /* renamed from: d  reason: collision with root package name */
    int f16239d;

    /* compiled from: AppendOnlyLinkedArrayList.java */
    /* renamed from: io.reactivex.internal.util.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface AbstractC0315a<T> extends l<T> {
        @Override // io.reactivex.g0.l
        boolean test(T t);
    }

    public a(int i) {
        this.a = i;
        Object[] objArr = new Object[i + 1];
        this.f16237b = objArr;
        this.f16238c = objArr;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0019, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public <U> boolean a(io.reactivex.v<? super U> r5) {
        /*
            r4 = this;
            java.lang.Object[] r0 = r4.f16237b
            int r1 = r4.a
        L_0x0004:
            r2 = 0
            if (r0 == 0) goto L_0x001e
        L_0x0007:
            if (r2 >= r1) goto L_0x0019
            r3 = r0[r2]
            if (r3 != 0) goto L_0x000e
            goto L_0x0019
        L_0x000e:
            boolean r3 = io.reactivex.internal.util.NotificationLite.acceptFull(r3, r5)
            if (r3 == 0) goto L_0x0016
            r5 = 1
            return r5
        L_0x0016:
            int r2 = r2 + 1
            goto L_0x0007
        L_0x0019:
            r0 = r0[r1]
            java.lang.Object[] r0 = (java.lang.Object[]) r0
            goto L_0x0004
        L_0x001e:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.util.a.a(io.reactivex.v):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0019, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public <U> boolean b(e.b.b<? super U> r5) {
        /*
            r4 = this;
            java.lang.Object[] r0 = r4.f16237b
            int r1 = r4.a
        L_0x0004:
            r2 = 0
            if (r0 == 0) goto L_0x001e
        L_0x0007:
            if (r2 >= r1) goto L_0x0019
            r3 = r0[r2]
            if (r3 != 0) goto L_0x000e
            goto L_0x0019
        L_0x000e:
            boolean r3 = io.reactivex.internal.util.NotificationLite.acceptFull(r3, r5)
            if (r3 == 0) goto L_0x0016
            r5 = 1
            return r5
        L_0x0016:
            int r2 = r2 + 1
            goto L_0x0007
        L_0x0019:
            r0 = r0[r1]
            java.lang.Object[] r0 = (java.lang.Object[]) r0
            goto L_0x0004
        L_0x001e:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.util.a.b(e.b.b):boolean");
    }

    public void c(T t) {
        int i = this.a;
        int i2 = this.f16239d;
        if (i2 == i) {
            Object[] objArr = new Object[i + 1];
            this.f16238c[i] = objArr;
            this.f16238c = objArr;
            i2 = 0;
        }
        this.f16238c[i2] = t;
        this.f16239d = i2 + 1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0018, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void d(io.reactivex.internal.util.a.AbstractC0315a<? super T> r5) {
        /*
            r4 = this;
            java.lang.Object[] r0 = r4.f16237b
            int r1 = r4.a
        L_0x0004:
            if (r0 == 0) goto L_0x001d
            r2 = 0
        L_0x0007:
            if (r2 >= r1) goto L_0x0018
            r3 = r0[r2]
            if (r3 != 0) goto L_0x000e
            goto L_0x0018
        L_0x000e:
            boolean r3 = r5.test(r3)
            if (r3 == 0) goto L_0x0015
            return
        L_0x0015:
            int r2 = r2 + 1
            goto L_0x0007
        L_0x0018:
            r0 = r0[r1]
            java.lang.Object[] r0 = (java.lang.Object[]) r0
            goto L_0x0004
        L_0x001d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.util.a.d(io.reactivex.internal.util.a$a):void");
    }

    public void e(T t) {
        this.f16237b[0] = t;
    }
}
