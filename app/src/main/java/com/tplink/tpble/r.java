package com.tplink.tpble;

import android.app.Application;

/* compiled from: BLEManager.java */
/* loaded from: classes3.dex */
class r {
    private Application a;

    /* compiled from: BLEManager.java */
    /* loaded from: classes3.dex */
    private static class a {
        private static final r a = new r();
    }

    r() {
    }

    public static r b() {
        return a.a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Application a() {
        return this.a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(Application application) {
        this.a = application;
    }
}
