package com.tplink.libtpnetwork.IoTNetwork.bean.common.result;

import com.google.gson.q.c;
import com.tplink.iot.cloud.bean.thing.common.ThingComponent;
import com.tplink.libtpnetwork.enumerate.EnumIoTComponent;
import java.io.Serializable;

/* loaded from: classes3.dex */
public class ComponentBean implements Serializable {
    private EnumIoTComponent id;
    @c("ver_code")
    private int version;

    public ComponentBean() {
    }

    public EnumIoTComponent getId() {
        return this.id;
    }

    public int getVersion() {
        return this.version;
    }

    public void setId(EnumIoTComponent enumIoTComponent) {
        this.id = enumIoTComponent;
    }

    public void setVersion(int i) {
        this.version = i;
    }

    public ComponentBean(ThingComponent thingComponent) {
        this.id = EnumIoTComponent.fromComponentName(thingComponent.getId());
        this.version = thingComponent.getVerCode();
    }
}
