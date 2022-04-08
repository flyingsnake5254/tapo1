package com.tplink.libtpcontrols.tpwheelview;

import android.os.Handler;
import android.os.Message;

/* compiled from: MessageHandler.java */
/* loaded from: classes3.dex */
final class f extends Handler {
    final LoopView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(LoopView loopView) {
        this.a = loopView;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        if (message.what == 1000) {
            this.a.invalidate();
        }
        int i = message.what;
        if (i == 2000) {
            LoopView.m(this.a);
        } else if (i == 3000) {
            this.a.h();
        }
        super.handleMessage(message);
    }
}
