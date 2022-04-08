package com.tplink.iot.cloud.bean.smart.common;

import com.tplink.iot.cloud.enumerate.StateOperator;
import com.tplink.iot.cloud.enumerate.StateValueDataType;
import java.util.Objects;

/* loaded from: classes2.dex */
public class SmartThingTriggerState {
    private StateValueDataType dataType;
    private String key;
    private StateOperator op;
    private SmartThingTriggerStateValue value;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        SmartThingTriggerState smartThingTriggerState = (SmartThingTriggerState) obj;
        return Objects.equals(this.key, smartThingTriggerState.key) && Objects.equals(this.value, smartThingTriggerState.value) && this.dataType == smartThingTriggerState.dataType && this.op == smartThingTriggerState.op;
    }

    public StateValueDataType getDataType() {
        return this.dataType;
    }

    public String getKey() {
        return this.key;
    }

    public StateOperator getOp() {
        return this.op;
    }

    public SmartThingTriggerStateValue getValue() {
        return this.value;
    }

    public int hashCode() {
        return Objects.hash(this.key, this.value, this.dataType, this.op);
    }

    public void setDataType(StateValueDataType stateValueDataType) {
        this.dataType = stateValueDataType;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setOp(StateOperator stateOperator) {
        this.op = stateOperator;
    }

    public void setValue(SmartThingTriggerStateValue smartThingTriggerStateValue) {
        this.value = smartThingTriggerStateValue;
    }
}
