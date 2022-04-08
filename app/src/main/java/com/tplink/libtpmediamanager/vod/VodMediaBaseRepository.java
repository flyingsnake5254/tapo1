package com.tplink.libtpmediamanager.vod;

import b.d.b0.a.t;
import com.tplink.libtpappcommonmedia.bean.TPMediaDeviceContext;
import com.tplink.libtpmediamanager.e;
import com.tplink.libtpmediamanager.g.b;

/* loaded from: classes3.dex */
public abstract class VodMediaBaseRepository extends b {
    public VodMediaBaseRepository(TPMediaDeviceContext tPMediaDeviceContext) {
        super(tPMediaDeviceContext);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public t getClient() {
        return e.k().l(this.deviceContext.getDeviceIdMd5());
    }

    @Override // com.tplink.libtpmediamanager.g.b
    public void onCleared() {
    }
}
