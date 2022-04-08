package com.tplink.iot.Utils;

import android.app.NotificationManager;
import android.content.Context;
import com.tplink.libtpcommonstream.stream.control.common.StreamControlType;

/* compiled from: NotificationUtils.java */
/* loaded from: classes2.dex */
public class u {
    public static void a(Context context) {
        if (context != null) {
            try {
                NotificationManager notificationManager = (NotificationManager) context.getSystemService(StreamControlType.NOTIFICATION);
                if (notificationManager != null) {
                    notificationManager.cancelAll();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
