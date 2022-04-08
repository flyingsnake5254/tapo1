package io.reactivex.internal.util;

import io.reactivex.e0.c;
import io.reactivex.h0.b.h;
import io.reactivex.h0.b.i;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.queue.b;
import io.reactivex.v;

/* compiled from: QueueDrainHelper.java */
/* loaded from: classes4.dex */
public final class j {
    public static <T, U> boolean a(boolean z, boolean z2, v<?> vVar, boolean z3, i<?> iVar, c cVar, g<T, U> gVar) {
        if (gVar.d()) {
            iVar.clear();
            cVar.dispose();
            return true;
        } else if (!z) {
            return false;
        } else {
            if (!z3) {
                Throwable e2 = gVar.e();
                if (e2 != null) {
                    iVar.clear();
                    if (cVar != null) {
                        cVar.dispose();
                    }
                    vVar.onError(e2);
                    return true;
                } else if (!z2) {
                    return false;
                } else {
                    if (cVar != null) {
                        cVar.dispose();
                    }
                    vVar.onComplete();
                    return true;
                }
            } else if (!z2) {
                return false;
            } else {
                if (cVar != null) {
                    cVar.dispose();
                }
                Throwable e3 = gVar.e();
                if (e3 != null) {
                    vVar.onError(e3);
                } else {
                    vVar.onComplete();
                }
                return true;
            }
        }
    }

    public static <T> i<T> b(int i) {
        if (i < 0) {
            return new b(-i);
        }
        return new SpscArrayQueue(i);
    }

    public static <T, U> void c(h<T> hVar, v<? super U> vVar, boolean z, c cVar, g<T, U> gVar) {
        int i = 1;
        while (!a(gVar.c(), hVar.isEmpty(), vVar, z, hVar, cVar, gVar)) {
            while (true) {
                boolean c2 = gVar.c();
                T poll = hVar.poll();
                boolean z2 = poll == null;
                if (!a(c2, z2, vVar, z, hVar, cVar, gVar)) {
                    if (z2) {
                        i = gVar.b(-i);
                        if (i == 0) {
                            return;
                        }
                    } else {
                        gVar.a(vVar, poll);
                    }
                } else {
                    return;
                }
            }
        }
    }

    public static void d(e.b.c cVar, int i) {
        cVar.request(i < 0 ? Long.MAX_VALUE : i);
    }
}
