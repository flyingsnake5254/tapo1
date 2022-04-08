package com.tplink.libtpnetwork.cameranetwork.model;

import com.google.gson.q.c;
import java.util.List;
import kotlin.jvm.internal.j;

/* compiled from: Model.kt */
/* loaded from: classes3.dex */
public final class ServiceList {
    @c("service_list")
    private final List<TapoCareList> functions;

    public ServiceList(List<TapoCareList> functions) {
        j.e(functions, "functions");
        this.functions = functions;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ServiceList copy$default(ServiceList serviceList, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = serviceList.functions;
        }
        return serviceList.copy(list);
    }

    public final List<TapoCareList> component1() {
        return this.functions;
    }

    public final ServiceList copy(List<TapoCareList> functions) {
        j.e(functions, "functions");
        return new ServiceList(functions);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof ServiceList) && j.a(this.functions, ((ServiceList) obj).functions);
        }
        return true;
    }

    public final List<TapoCareList> getFunctions() {
        return this.functions;
    }

    public int hashCode() {
        List<TapoCareList> list = this.functions;
        if (list != null) {
            return list.hashCode();
        }
        return 0;
    }

    public final boolean isComponentNeedSubscription(ComponentType type) {
        j.e(type, "type");
        if (this.functions.isEmpty()) {
            return false;
        }
        for (TapoCareList tapoCareList : this.functions) {
            if (type == ComponentType.fromComponentName(tapoCareList.getName())) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        return "ServiceList(functions=" + this.functions + ")";
    }
}
