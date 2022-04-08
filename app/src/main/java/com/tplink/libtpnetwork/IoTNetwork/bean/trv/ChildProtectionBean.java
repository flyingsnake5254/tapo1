package com.tplink.libtpnetwork.IoTNetwork.bean.trv;

/* compiled from: ChildProtectionBean.kt */
/* loaded from: classes3.dex */
public final class ChildProtectionBean {
    private boolean enable;

    public ChildProtectionBean(boolean z) {
        this.enable = z;
    }

    public static /* synthetic */ ChildProtectionBean copy$default(ChildProtectionBean childProtectionBean, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = childProtectionBean.enable;
        }
        return childProtectionBean.copy(z);
    }

    public final boolean component1() {
        return this.enable;
    }

    public final ChildProtectionBean copy(boolean z) {
        return new ChildProtectionBean(z);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof ChildProtectionBean) && this.enable == ((ChildProtectionBean) obj).enable;
        }
        return true;
    }

    public final boolean getEnable() {
        return this.enable;
    }

    public int hashCode() {
        boolean z = this.enable;
        if (z) {
            return 1;
        }
        return z ? 1 : 0;
    }

    public final void setEnable(boolean z) {
        this.enable = z;
    }

    public String toString() {
        return "ChildProtectionBean(enable=" + this.enable + ")";
    }
}
