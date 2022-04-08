package com.tplink.iot.view.ipcamera.setting;

import androidx.core.app.NotificationCompat;
import androidx.databinding.BindingAdapter;
import com.tplink.iot.widget.camerasetting.SimpleProcessBarNewIpc;
import com.tplink.libtpnetwork.cameranetwork.model.SdCardStatus;

/* compiled from: ProgressBarBindingAdapter.java */
/* loaded from: classes2.dex */
public class c5 {
    @BindingAdapter({"percent"})
    public static void a(SimpleProcessBarNewIpc simpleProcessBarNewIpc, int i) {
        simpleProcessBarNewIpc.setProcess(i);
    }

    @BindingAdapter({NotificationCompat.CATEGORY_STATUS})
    public static void b(SimpleProcessBarNewIpc simpleProcessBarNewIpc, SdCardStatus sdCardStatus) {
        simpleProcessBarNewIpc.setStatus(sdCardStatus);
    }
}
