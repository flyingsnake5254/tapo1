package com.tplink.iot.g.a.a;

import com.tplink.iot.cloud.bean.thing.common.ThingFirmware;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.j;

/* compiled from: FeaturedActionDeviceInfo.kt */
/* loaded from: classes2.dex */
public final class b {
    private final BaseALIoTDevice<?> a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f7941b;

    /* renamed from: c  reason: collision with root package name */
    private ThingFirmware f7942c;

    public b(BaseALIoTDevice<?> device, boolean z, ThingFirmware thingFirmware) {
        j.e(device, "device");
        this.a = device;
        this.f7941b = z;
        this.f7942c = thingFirmware;
    }

    public final BaseALIoTDevice<?> a() {
        return this.a;
    }

    public final boolean b() {
        ThingFirmware thingFirmware = this.f7942c;
        return thingFirmware != null && thingFirmware.isNeedToUpgrade();
    }

    public final boolean c() {
        return this.f7941b;
    }

    public final void d(ThingFirmware thingFirmware) {
        this.f7942c = thingFirmware;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return j.a(this.a, bVar.a) && this.f7941b == bVar.f7941b && j.a(this.f7942c, bVar.f7942c);
    }

    public int hashCode() {
        BaseALIoTDevice<?> baseALIoTDevice = this.a;
        int i = 0;
        int hashCode = (baseALIoTDevice != null ? baseALIoTDevice.hashCode() : 0) * 31;
        boolean z = this.f7941b;
        if (z) {
            z = true;
        }
        int i2 = z ? 1 : 0;
        int i3 = z ? 1 : 0;
        int i4 = z ? 1 : 0;
        int i5 = (hashCode + i2) * 31;
        ThingFirmware thingFirmware = this.f7942c;
        if (thingFirmware != null) {
            i = thingFirmware.hashCode();
        }
        return i5 + i;
    }

    public String toString() {
        return "FeaturedActionDeviceInfo(device=" + this.a + ", isSupport=" + this.f7941b + ", firmware=" + this.f7942c + ")";
    }

    public /* synthetic */ b(BaseALIoTDevice baseALIoTDevice, boolean z, ThingFirmware thingFirmware, int i, f fVar) {
        this(baseALIoTDevice, (i & 2) != 0 ? false : z, (i & 4) != 0 ? null : thingFirmware);
    }
}
