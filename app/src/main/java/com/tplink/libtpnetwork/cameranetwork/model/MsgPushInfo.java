package com.tplink.libtpnetwork.cameranetwork.model;

import com.google.gson.q.c;
import kotlin.jvm.internal.j;

/* compiled from: Model.kt */
/* loaded from: classes3.dex */
public final class MsgPushInfo {
    @c("notification_enabled")
    private final String notificationEnabled;
    @c("rich_notification_enabled")
    private final String richNotificationEnabled;

    public MsgPushInfo(String notificationEnabled, String richNotificationEnabled) {
        j.e(notificationEnabled, "notificationEnabled");
        j.e(richNotificationEnabled, "richNotificationEnabled");
        this.notificationEnabled = notificationEnabled;
        this.richNotificationEnabled = richNotificationEnabled;
    }

    public static /* synthetic */ MsgPushInfo copy$default(MsgPushInfo msgPushInfo, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = msgPushInfo.notificationEnabled;
        }
        if ((i & 2) != 0) {
            str2 = msgPushInfo.richNotificationEnabled;
        }
        return msgPushInfo.copy(str, str2);
    }

    public final String component1() {
        return this.notificationEnabled;
    }

    public final String component2() {
        return this.richNotificationEnabled;
    }

    public final MsgPushInfo copy(String notificationEnabled, String richNotificationEnabled) {
        j.e(notificationEnabled, "notificationEnabled");
        j.e(richNotificationEnabled, "richNotificationEnabled");
        return new MsgPushInfo(notificationEnabled, richNotificationEnabled);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MsgPushInfo)) {
            return false;
        }
        MsgPushInfo msgPushInfo = (MsgPushInfo) obj;
        return j.a(this.notificationEnabled, msgPushInfo.notificationEnabled) && j.a(this.richNotificationEnabled, msgPushInfo.richNotificationEnabled);
    }

    public final String getNotificationEnabled() {
        return this.notificationEnabled;
    }

    public final String getRichNotificationEnabled() {
        return this.richNotificationEnabled;
    }

    public int hashCode() {
        String str = this.notificationEnabled;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.richNotificationEnabled;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "MsgPushInfo(notificationEnabled=" + this.notificationEnabled + ", richNotificationEnabled=" + this.richNotificationEnabled + ")";
    }
}
