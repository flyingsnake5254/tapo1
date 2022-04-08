package com.tplink.libtpnetwork.cameranetwork.model;

import kotlin.jvm.internal.j;

/* compiled from: Model.kt */
/* loaded from: classes3.dex */
public final class ComponentBean {
    private String name;
    private int version;

    public ComponentBean(String name, int i) {
        j.e(name, "name");
        this.name = name;
        this.version = i;
    }

    public final String getName() {
        return this.name;
    }

    public final int getVersion() {
        return this.version;
    }

    public final void setName(String str) {
        j.e(str, "<set-?>");
        this.name = str;
    }

    public final void setVersion(int i) {
        this.version = i;
    }
}
