package com.tplink.libtpnetwork.IoTNetwork.bean.plug.result;

import com.tplink.iot.cloud.bean.thing.common.NextEvent;
import com.tplink.libtpnetwork.IoTNetwork.bean.bulb.DesiredStatesBean;
import com.tplink.libtpnetwork.Utils.i;
import java.util.Map;

/* loaded from: classes3.dex */
public class PlugNextEvent extends NextEvent {
    private transient DesiredStatesBean formatDesiredStates;

    public PlugNextEvent() {
    }

    public DesiredStatesBean getFormatDesiredStates() {
        return this.formatDesiredStates;
    }

    public void setFormatDesiredStates(DesiredStatesBean desiredStatesBean) {
        this.formatDesiredStates = desiredStatesBean;
    }

    public PlugNextEvent(NextEvent nextEvent) {
        if (nextEvent != null) {
            setId(nextEvent.getId());
            setType(nextEvent.getType());
            setStartTime(nextEvent.getStartTime());
            setEndTime(nextEvent.getEndTime());
            setAction(nextEvent.getAction());
            Map<String, Object> desiredStates = nextEvent.getDesiredStates();
            if (desiredStates != null) {
                this.formatDesiredStates = (DesiredStatesBean) i.a(i.i(desiredStates), DesiredStatesBean.class);
            }
        }
    }
}
