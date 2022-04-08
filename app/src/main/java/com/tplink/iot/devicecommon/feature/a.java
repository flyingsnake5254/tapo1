package com.tplink.iot.devicecommon.feature;

import android.app.Activity;
import android.content.DialogInterface;
import com.tplink.iot.viewmodel.home.u;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;

/* compiled from: LoseControlDialogController.kt */
/* loaded from: classes2.dex */
public final class a {
    private boolean a;

    /* compiled from: LoseControlDialogController.kt */
    /* renamed from: com.tplink.iot.devicecommon.feature.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    static final class DialogInterface$OnDismissListenerC0198a implements DialogInterface.OnDismissListener {
        DialogInterface$OnDismissListenerC0198a() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public final void onDismiss(DialogInterface dialogInterface) {
            a.this.a = false;
        }
    }

    public final void b(Activity activity, BaseALIoTDevice<?> baseALIoTDevice) {
        if (!this.a) {
            this.a = true;
            String str = null;
            String deviceType = baseALIoTDevice != null ? baseALIoTDevice.getDeviceType() : null;
            String deviceModel = baseALIoTDevice != null ? baseALIoTDevice.getDeviceModel() : null;
            if (baseALIoTDevice != null) {
                str = baseALIoTDevice.getDeviceHwVer();
            }
            u.k(activity, deviceType, deviceModel, str, new DialogInterface$OnDismissListenerC0198a());
        }
    }
}
