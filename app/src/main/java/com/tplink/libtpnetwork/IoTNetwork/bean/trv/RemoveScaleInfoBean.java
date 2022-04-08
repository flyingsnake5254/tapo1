package com.tplink.libtpnetwork.IoTNetwork.bean.trv;

/* compiled from: RemoveScaleInfoBean.kt */
/* loaded from: classes3.dex */
public final class RemoveScaleInfoBean {
    private boolean auto;

    public RemoveScaleInfoBean(boolean z) {
        this.auto = z;
    }

    public static /* synthetic */ RemoveScaleInfoBean copy$default(RemoveScaleInfoBean removeScaleInfoBean, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = removeScaleInfoBean.auto;
        }
        return removeScaleInfoBean.copy(z);
    }

    public final boolean component1() {
        return this.auto;
    }

    public final RemoveScaleInfoBean copy(boolean z) {
        return new RemoveScaleInfoBean(z);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof RemoveScaleInfoBean) && this.auto == ((RemoveScaleInfoBean) obj).auto;
        }
        return true;
    }

    public final boolean getAuto() {
        return this.auto;
    }

    public int hashCode() {
        boolean z = this.auto;
        if (z) {
            return 1;
        }
        return z ? 1 : 0;
    }

    public final void setAuto(boolean z) {
        this.auto = z;
    }

    public String toString() {
        return "RemoveScaleInfoBean(auto=" + this.auto + ")";
    }
}
