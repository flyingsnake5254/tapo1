package com.tplink.iot.view.ipcamera.widget.multiOperationEditText.a;

import android.graphics.PorterDuff;
import android.os.Build;
import com.tplink.iot.view.ipcamera.widget.multiOperationEditText.a.f;

/* compiled from: ViewUtils.java */
/* loaded from: classes2.dex */
public class k {
    static final f.c a = new a();

    /* compiled from: ViewUtils.java */
    /* loaded from: classes2.dex */
    static class a implements f.c {
        a() {
        }

        @Override // com.tplink.iot.view.ipcamera.widget.multiOperationEditText.a.f.c
        public f createAnimator() {
            return new f(Build.VERSION.SDK_INT >= 12 ? new h() : new g());
        }
    }

    public static f a() {
        return a.createAnimator();
    }

    public static PorterDuff.Mode b(int i, PorterDuff.Mode mode) {
        if (i == 3) {
            return PorterDuff.Mode.SRC_OVER;
        }
        if (i == 5) {
            return PorterDuff.Mode.SRC_IN;
        }
        if (i == 9) {
            return PorterDuff.Mode.SRC_ATOP;
        }
        if (i != 14) {
            return i != 15 ? mode : PorterDuff.Mode.SCREEN;
        }
        return PorterDuff.Mode.MULTIPLY;
    }
}
