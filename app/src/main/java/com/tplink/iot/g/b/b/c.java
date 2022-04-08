package com.tplink.iot.g.b.b;

import com.tplink.iot.g.b.b.e.a;
import com.tplink.libtpnetwork.IoTNetwork.bean.colorbulb.LightStateBean;
import kotlin.jvm.internal.j;

/* compiled from: NormalColorItem.kt */
/* loaded from: classes2.dex */
public final class c extends a {

    /* renamed from: b  reason: collision with root package name */
    private int f7952b;

    /* renamed from: c  reason: collision with root package name */
    private LightStateBean f7953c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(int i, LightStateBean lightStateBean) {
        super(false);
        j.e(lightStateBean, "lightStateBean");
        this.f7952b = i;
        this.f7953c = lightStateBean;
    }

    public final String c() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f7953c.getHue());
        sb.append('-');
        sb.append(this.f7953c.getSaturation());
        sb.append('-');
        sb.append(this.f7953c.getBrightness());
        sb.append('-');
        sb.append(this.f7953c.getColorTemp());
        return sb.toString();
    }

    public final int d() {
        return this.f7952b;
    }

    public final LightStateBean e() {
        return this.f7953c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return this.f7952b == cVar.f7952b && j.a(this.f7953c, cVar.f7953c);
    }

    public int hashCode() {
        int i = this.f7952b * 31;
        LightStateBean lightStateBean = this.f7953c;
        return i + (lightStateBean != null ? lightStateBean.hashCode() : 0);
    }

    public String toString() {
        return "NormalColorItem(color=" + this.f7952b + ", lightStateBean=" + this.f7953c + ")";
    }
}
