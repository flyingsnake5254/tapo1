package com.tplink.libtpnetwork.IoTNetwork.bean.sub.common;

import java.util.List;
import kotlin.jvm.internal.j;

/* compiled from: IoTSubBase.kt */
/* loaded from: classes3.dex */
public final class SubMultipleRequest {
    private final List<IoTSubRequest<?>> requests;

    /* JADX WARN: Multi-variable type inference failed */
    public SubMultipleRequest(List<? extends IoTSubRequest<?>> requests) {
        j.e(requests, "requests");
        this.requests = requests;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SubMultipleRequest copy$default(SubMultipleRequest subMultipleRequest, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = subMultipleRequest.requests;
        }
        return subMultipleRequest.copy(list);
    }

    public final List<IoTSubRequest<?>> component1() {
        return this.requests;
    }

    public final SubMultipleRequest copy(List<? extends IoTSubRequest<?>> requests) {
        j.e(requests, "requests");
        return new SubMultipleRequest(requests);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof SubMultipleRequest) && j.a(this.requests, ((SubMultipleRequest) obj).requests);
        }
        return true;
    }

    public final List<IoTSubRequest<?>> getRequests() {
        return this.requests;
    }

    public int hashCode() {
        List<IoTSubRequest<?>> list = this.requests;
        if (list != null) {
            return list.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "SubMultipleRequest(requests=" + this.requests + ")";
    }
}
