package com.tplink.iot.cloud.bean.smart.common;

import java.util.List;
import java.util.Objects;

/* loaded from: classes2.dex */
public class SmartThingTriggerStateValue {
    private String data;
    private List<String> list;
    private String max;
    private String min;

    public SmartThingTriggerStateValue() {
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        SmartThingTriggerStateValue smartThingTriggerStateValue = (SmartThingTriggerStateValue) obj;
        return Objects.equals(this.data, smartThingTriggerStateValue.data) && Objects.equals(this.min, smartThingTriggerStateValue.min) && Objects.equals(this.max, smartThingTriggerStateValue.max) && Objects.equals(this.list, smartThingTriggerStateValue.list);
    }

    public String getData() {
        return this.data;
    }

    public List<String> getList() {
        return this.list;
    }

    public String getMax() {
        return this.max;
    }

    public String getMin() {
        return this.min;
    }

    public int hashCode() {
        return Objects.hash(this.data, this.min, this.max, this.list);
    }

    public void setData(String str) {
        this.data = str;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public void setMax(String str) {
        this.max = str;
    }

    public void setMin(String str) {
        this.min = str;
    }

    public SmartThingTriggerStateValue(String str) {
        this.data = str;
    }
}
