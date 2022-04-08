package com.tplink.libtpcommonstream.stream.control.notification;

import androidx.core.app.NotificationCompat;
import com.google.gson.q.c;

/* loaded from: classes3.dex */
public class StreamStatus {
    public static final String FINISHED = "finished";
    @c(NotificationCompat.CATEGORY_STATUS)
    private String status;

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String str) {
        this.status = str;
    }
}
