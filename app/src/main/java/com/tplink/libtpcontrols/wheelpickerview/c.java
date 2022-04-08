package com.tplink.libtpcontrols.wheelpickerview;

import android.os.Handler;
import android.os.Message;
import com.tplink.libtpcontrols.wheelpickerview.LoopView;

/* compiled from: MessageHandler.java */
/* loaded from: classes3.dex */
final class c extends Handler {
    final LoopView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(LoopView loopView) {
        this.a = loopView;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        int i = message.what;
        if (i == 1000) {
            this.a.invalidate();
        } else if (i == 2000) {
            this.a.h(LoopView.ACTION.FLING);
        } else if (i == 3000) {
            this.a.e();
        }
    }
}
