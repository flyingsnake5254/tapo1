package com.google.android.exoplayer2.util;

import java.io.IOException;
import java.util.Collections;
import java.util.PriorityQueue;

/* loaded from: classes.dex */
public final class PriorityTaskManager {
    private final Object a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private final PriorityQueue<Integer> f3884b = new PriorityQueue<>(10, Collections.reverseOrder());

    /* renamed from: c  reason: collision with root package name */
    private int f3885c = Integer.MIN_VALUE;

    /* loaded from: classes.dex */
    public static class PriorityTooLowException extends IOException {
        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public PriorityTooLowException(int r3, int r4) {
            /*
                r2 = this;
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r1 = 60
                r0.<init>(r1)
                java.lang.String r1 = "Priority too low [priority="
                r0.append(r1)
                r0.append(r3)
                java.lang.String r3 = ", highest="
                r0.append(r3)
                r0.append(r4)
                java.lang.String r3 = "]"
                r0.append(r3)
                java.lang.String r3 = r0.toString()
                r2.<init>(r3)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.util.PriorityTaskManager.PriorityTooLowException.<init>(int, int):void");
        }
    }

    public void a(int i) {
        synchronized (this.a) {
            this.f3884b.add(Integer.valueOf(i));
            this.f3885c = Math.max(this.f3885c, i);
        }
    }

    public void b(int i) {
        synchronized (this.a) {
            this.f3884b.remove(Integer.valueOf(i));
            this.f3885c = this.f3884b.isEmpty() ? Integer.MIN_VALUE : ((Integer) o0.i(this.f3884b.peek())).intValue();
            this.a.notifyAll();
        }
    }
}
