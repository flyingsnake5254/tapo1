package com.tplink.libtpnetwork.IoTNetwork.bean.sub.common;

import java.util.List;
import kotlin.jvm.internal.j;

/* compiled from: IoTSubBase.kt */
/* loaded from: classes3.dex */
public final class SubMultipleResponse {
    private final List<IoTSubResponse<?>> responses;

    /* JADX WARN: Multi-variable type inference failed */
    public SubMultipleResponse(List<? extends IoTSubResponse<?>> responses) {
        j.e(responses, "responses");
        this.responses = responses;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SubMultipleResponse copy$default(SubMultipleResponse subMultipleResponse, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = subMultipleResponse.responses;
        }
        return subMultipleResponse.copy(list);
    }

    public final List<IoTSubResponse<?>> component1() {
        return this.responses;
    }

    public final SubMultipleResponse copy(List<? extends IoTSubResponse<?>> responses) {
        j.e(responses, "responses");
        return new SubMultipleResponse(responses);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof SubMultipleResponse) && j.a(this.responses, ((SubMultipleResponse) obj).responses);
        }
        return true;
    }

    public final List<IoTSubResponse<?>> getResponses() {
        return this.responses;
    }

    public int hashCode() {
        List<IoTSubResponse<?>> list = this.responses;
        if (list != null) {
            return list.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "SubMultipleResponse(responses=" + this.responses + ")";
    }
}
