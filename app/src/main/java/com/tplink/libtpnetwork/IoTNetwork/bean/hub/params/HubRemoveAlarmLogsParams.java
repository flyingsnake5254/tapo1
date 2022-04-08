package com.tplink.libtpnetwork.IoTNetwork.bean.hub.params;

import com.google.gson.q.c;
import java.util.List;
import kotlin.jvm.internal.j;

/* compiled from: HubAlarmLogsParams.kt */
/* loaded from: classes3.dex */
public final class HubRemoveAlarmLogsParams {
    private List<RemoveAlarmLogBean> logs;
    @c("remove_all")
    private boolean removeAll;

    /* compiled from: HubAlarmLogsParams.kt */
    /* loaded from: classes3.dex */
    public static final class RemoveAlarmLogBean {
        private int id;

        public RemoveAlarmLogBean(int i) {
            this.id = i;
        }

        public static /* synthetic */ RemoveAlarmLogBean copy$default(RemoveAlarmLogBean removeAlarmLogBean, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = removeAlarmLogBean.id;
            }
            return removeAlarmLogBean.copy(i);
        }

        public final int component1() {
            return this.id;
        }

        public final RemoveAlarmLogBean copy(int i) {
            return new RemoveAlarmLogBean(i);
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof RemoveAlarmLogBean) && this.id == ((RemoveAlarmLogBean) obj).id;
            }
            return true;
        }

        public final int getId() {
            return this.id;
        }

        public int hashCode() {
            return this.id;
        }

        public final void setId(int i) {
            this.id = i;
        }

        public String toString() {
            return "RemoveAlarmLogBean(id=" + this.id + ")";
        }
    }

    public HubRemoveAlarmLogsParams(boolean z, List<RemoveAlarmLogBean> list) {
        this.removeAll = z;
        this.logs = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ HubRemoveAlarmLogsParams copy$default(HubRemoveAlarmLogsParams hubRemoveAlarmLogsParams, boolean z, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            z = hubRemoveAlarmLogsParams.removeAll;
        }
        if ((i & 2) != 0) {
            list = hubRemoveAlarmLogsParams.logs;
        }
        return hubRemoveAlarmLogsParams.copy(z, list);
    }

    public final boolean component1() {
        return this.removeAll;
    }

    public final List<RemoveAlarmLogBean> component2() {
        return this.logs;
    }

    public final HubRemoveAlarmLogsParams copy(boolean z, List<RemoveAlarmLogBean> list) {
        return new HubRemoveAlarmLogsParams(z, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HubRemoveAlarmLogsParams)) {
            return false;
        }
        HubRemoveAlarmLogsParams hubRemoveAlarmLogsParams = (HubRemoveAlarmLogsParams) obj;
        return this.removeAll == hubRemoveAlarmLogsParams.removeAll && j.a(this.logs, hubRemoveAlarmLogsParams.logs);
    }

    public final List<RemoveAlarmLogBean> getLogs() {
        return this.logs;
    }

    public final boolean getRemoveAll() {
        return this.removeAll;
    }

    public int hashCode() {
        boolean z = this.removeAll;
        if (z) {
            z = true;
        }
        int i = z ? 1 : 0;
        int i2 = z ? 1 : 0;
        int i3 = z ? 1 : 0;
        int i4 = i * 31;
        List<RemoveAlarmLogBean> list = this.logs;
        return i4 + (list != null ? list.hashCode() : 0);
    }

    public final void setLogs(List<RemoveAlarmLogBean> list) {
        this.logs = list;
    }

    public final void setRemoveAll(boolean z) {
        this.removeAll = z;
    }

    public String toString() {
        return "HubRemoveAlarmLogsParams(removeAll=" + this.removeAll + ", logs=" + this.logs + ")";
    }
}
