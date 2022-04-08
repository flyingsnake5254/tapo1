package com.tplink.libtpnetwork.IoTNetwork.bean.sub.params;

/* compiled from: DoubleClickInfoBean.kt */
/* loaded from: classes3.dex */
public final class DoubleClickInfoBean {
    private boolean enable;
    private int interval;

    public DoubleClickInfoBean(boolean z, int i) {
        this.enable = z;
        this.interval = i;
    }

    public static /* synthetic */ DoubleClickInfoBean copy$default(DoubleClickInfoBean doubleClickInfoBean, boolean z, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = doubleClickInfoBean.enable;
        }
        if ((i2 & 2) != 0) {
            i = doubleClickInfoBean.interval;
        }
        return doubleClickInfoBean.copy(z, i);
    }

    public final boolean component1() {
        return this.enable;
    }

    public final int component2() {
        return this.interval;
    }

    public final DoubleClickInfoBean copy(boolean z, int i) {
        return new DoubleClickInfoBean(z, i);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof DoubleClickInfoBean)) {
            return false;
        }
        boolean z = this.enable;
        if (z || ((DoubleClickInfoBean) obj).enable) {
            DoubleClickInfoBean doubleClickInfoBean = (DoubleClickInfoBean) obj;
            if (!(z == doubleClickInfoBean.enable && this.interval == doubleClickInfoBean.interval)) {
                return false;
            }
        }
        return true;
    }

    public final boolean getEnable() {
        return this.enable;
    }

    public final int getInterval() {
        return this.interval;
    }

    public int hashCode() {
        boolean z = this.enable;
        if (z) {
            z = true;
        }
        int i = z ? 1 : 0;
        int i2 = z ? 1 : 0;
        int i3 = z ? 1 : 0;
        return (i * 31) + this.interval;
    }

    public final void setEnable(boolean z) {
        this.enable = z;
    }

    public final void setInterval(int i) {
        this.interval = i;
    }

    public String toString() {
        return "DoubleClickInfoBean(enable=" + this.enable + ", interval=" + this.interval + ")";
    }
}
