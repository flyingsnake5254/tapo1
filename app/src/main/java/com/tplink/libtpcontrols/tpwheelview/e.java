package com.tplink.libtpcontrols.tpwheelview;

import androidx.vectordrawable.graphics.drawable.PathInterpolatorCompat;
import java.util.TimerTask;

/* compiled from: MTimer.java */
/* loaded from: classes3.dex */
final class e extends TimerTask {

    /* renamed from: c  reason: collision with root package name */
    int f12458c = Integer.MAX_VALUE;

    /* renamed from: d  reason: collision with root package name */
    int f12459d = 0;

    /* renamed from: f  reason: collision with root package name */
    int f12460f;
    final LoopView q;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(LoopView loopView, int i) {
        this.q = loopView;
        this.f12460f = i;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        if (this.f12458c == Integer.MAX_VALUE) {
            this.q.getClass();
            float f2 = this.q.g4 * 2.0f;
            int i = (int) ((this.f12460f + f2) % f2);
            this.f12460f = i;
            if (i > f2 / 2.0f) {
                this.f12458c = (int) (f2 - i);
            } else {
                this.f12458c = -i;
            }
        }
        int i2 = this.f12458c;
        int i3 = (int) (i2 * 0.1f);
        this.f12459d = i3;
        if (i3 == 0) {
            if (i2 < 0) {
                this.f12459d = -1;
            } else {
                this.f12459d = 1;
            }
        }
        if (Math.abs(i2) <= 0) {
            this.q.a();
            this.q.K3.sendEmptyMessage(PathInterpolatorCompat.MAX_NUM_POINTS);
            return;
        }
        LoopView loopView = this.q;
        loopView.W3 += this.f12459d;
        loopView.K3.sendEmptyMessage(1000);
        this.f12458c -= this.f12459d;
    }
}
