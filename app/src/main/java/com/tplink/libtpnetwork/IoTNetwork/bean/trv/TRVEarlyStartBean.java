package com.tplink.libtpnetwork.IoTNetwork.bean.trv;

/* compiled from: TRVEarlyStartBean.kt */
/* loaded from: classes3.dex */
public final class TRVEarlyStartBean {
    private boolean enable;

    public TRVEarlyStartBean(boolean z) {
        this.enable = z;
    }

    public static /* synthetic */ TRVEarlyStartBean copy$default(TRVEarlyStartBean tRVEarlyStartBean, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = tRVEarlyStartBean.enable;
        }
        return tRVEarlyStartBean.copy(z);
    }

    public final boolean component1() {
        return this.enable;
    }

    public final TRVEarlyStartBean copy(boolean z) {
        return new TRVEarlyStartBean(z);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof TRVEarlyStartBean) && this.enable == ((TRVEarlyStartBean) obj).enable;
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
        return "TRVEarlyStartBean(enable=" + this.enable + ")";
    }
}
