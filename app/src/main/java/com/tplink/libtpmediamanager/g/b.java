package com.tplink.libtpmediamanager.g;

import com.tplink.libtpappcommonmedia.bean.TPMediaDeviceContext;

/* compiled from: MediaBaseRootRepository.java */
/* loaded from: classes3.dex */
public abstract class b {
    protected TPMediaDeviceContext deviceContext;

    public b(TPMediaDeviceContext tPMediaDeviceContext) {
        this.deviceContext = tPMediaDeviceContext;
    }

    public abstract void loadCacheData();

    public abstract void onCleared();
}
