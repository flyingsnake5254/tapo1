package com.tplink.libtpnetwork.IoTNetwork.bean.trv;

import kotlin.jvm.internal.j;

/* compiled from: ShutdownInfoBean.kt */
/* loaded from: classes3.dex */
public final class ShutdownInfoBean {
    private boolean enable;
    private String mode;

    public ShutdownInfoBean(boolean z, String str) {
        this.enable = z;
        this.mode = str;
    }

    public static /* synthetic */ ShutdownInfoBean copy$default(ShutdownInfoBean shutdownInfoBean, boolean z, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            z = shutdownInfoBean.enable;
        }
        if ((i & 2) != 0) {
            str = shutdownInfoBean.mode;
        }
        return shutdownInfoBean.copy(z, str);
    }

    public final boolean component1() {
        return this.enable;
    }

    public final String component2() {
        return this.mode;
    }

    public final ShutdownInfoBean copy(boolean z, String str) {
        return new ShutdownInfoBean(z, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ShutdownInfoBean)) {
            return false;
        }
        ShutdownInfoBean shutdownInfoBean = (ShutdownInfoBean) obj;
        return this.enable == shutdownInfoBean.enable && j.a(this.mode, shutdownInfoBean.mode);
    }

    public final boolean getEnable() {
        return this.enable;
    }

    public final EnumShutdownMode getEnumMode() {
        EnumShutdownMode[] values;
        for (EnumShutdownMode enumShutdownMode : EnumShutdownMode.values()) {
            if (j.a(enumShutdownMode.getValue(), this.mode)) {
                return enumShutdownMode;
            }
        }
        return null;
    }

    public final String getMode() {
        return this.mode;
    }

    public int hashCode() {
        boolean z = this.enable;
        if (z) {
            z = true;
        }
        int i = z ? 1 : 0;
        int i2 = z ? 1 : 0;
        int i3 = z ? 1 : 0;
        int i4 = i * 31;
        String str = this.mode;
        return i4 + (str != null ? str.hashCode() : 0);
    }

    public final void setEnable(boolean z) {
        this.enable = z;
    }

    public final void setMode(String str) {
        this.mode = str;
    }

    public String toString() {
        return "ShutdownInfoBean(enable=" + this.enable + ", mode=" + this.mode + ")";
    }
}
