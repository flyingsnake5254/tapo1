package org.apache.commons.lang.mutable;

import java.io.Serializable;

/* loaded from: classes4.dex */
public class MutableObject implements Serializable {
    private static final long serialVersionUID = 86241875189L;
    private Object value;

    public MutableObject() {
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof MutableObject)) {
            return false;
        }
        Object obj2 = ((MutableObject) obj).value;
        Object obj3 = this.value;
        return obj3 == obj2 || (obj3 != null && obj3.equals(obj2));
    }

    public Object getValue() {
        return this.value;
    }

    public int hashCode() {
        Object obj = this.value;
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public void setValue(Object obj) {
        this.value = obj;
    }

    public String toString() {
        Object obj = this.value;
        return obj == null ? "null" : obj.toString();
    }

    public MutableObject(Object obj) {
        this.value = obj;
    }
}
