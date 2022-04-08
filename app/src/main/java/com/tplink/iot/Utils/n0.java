package com.tplink.iot.Utils;

import androidx.fragment.app.FragmentManager;
import com.tplink.iot.widget.HMSPickerDialog;
import com.tplink.iot.widget.TimeOffsetPickerDialog;
import com.tplink.iot.widget.TimeScrollPickerDialog;

/* compiled from: TimePickerDialogUtil.java */
/* loaded from: classes2.dex */
public class n0 {
    private static TimeScrollPickerDialog a;

    /* renamed from: b  reason: collision with root package name */
    private static TimeOffsetPickerDialog f5358b;

    /* renamed from: c  reason: collision with root package name */
    private static HMSPickerDialog f5359c;

    public static void a(FragmentManager fragmentManager, int i, HMSPickerDialog.b bVar, String str) {
        HMSPickerDialog hMSPickerDialog = f5359c;
        if (hMSPickerDialog == null || !hMSPickerDialog.isAdded()) {
            HMSPickerDialog a2 = HMSPickerDialog.f11537c.a(i);
            f5359c = a2;
            a2.H0(bVar);
            f5359c.show(fragmentManager, str);
        }
    }

    public static void b(FragmentManager fragmentManager, int i, boolean z, boolean z2, int i2, TimeScrollPickerDialog.a aVar, String str) {
        TimeScrollPickerDialog timeScrollPickerDialog = a;
        if (timeScrollPickerDialog == null || !timeScrollPickerDialog.isAdded()) {
            TimeScrollPickerDialog A0 = TimeScrollPickerDialog.A0(i, z, z2, i2);
            a = A0;
            A0.B0(aVar);
            a.show(fragmentManager, str);
        }
    }

    public static void c(FragmentManager fragmentManager, int i, TimeOffsetPickerDialog.a aVar, String str) {
        d(fragmentManager, i, false, aVar, str);
    }

    public static void d(FragmentManager fragmentManager, int i, boolean z, TimeOffsetPickerDialog.a aVar, String str) {
        TimeOffsetPickerDialog timeOffsetPickerDialog = f5358b;
        if (timeOffsetPickerDialog == null || !timeOffsetPickerDialog.isAdded()) {
            TimeOffsetPickerDialog A0 = TimeOffsetPickerDialog.A0(i, z);
            f5358b = A0;
            A0.B0(aVar);
            f5358b.show(fragmentManager, str);
        }
    }
}
