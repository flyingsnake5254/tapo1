package com.tplink.iot.Utils;

import android.content.Context;
import android.telephony.TelephonyManager;
import java.util.Calendar;
import java.util.Date;

/* compiled from: AppMarketUtils.java */
/* loaded from: classes2.dex */
public class f {
    public static int a(Date date, Date date2) {
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        Calendar instance2 = Calendar.getInstance();
        instance2.setTime(date2);
        int i = instance.get(6);
        int i2 = instance2.get(6);
        int i3 = instance.get(1);
        int i4 = instance2.get(1);
        if (i3 == i4) {
            return i2 - i;
        }
        int i5 = 0;
        while (i3 < i4) {
            i5 = ((i3 % 4 != 0 || i3 % 100 == 0) && i3 % 400 != 0) ? i5 + 365 : i5 + 366;
            i3++;
        }
        return i5 + (i2 - i);
    }

    public static String b(Context context) {
        String str = null;
        if (context == null) {
            return null;
        }
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager != null && ((str = telephonyManager.getSimCountryIso()) == null || str.isEmpty())) {
            str = telephonyManager.getNetworkCountryIso();
        }
        return (str == null || str.isEmpty()) ? context.getResources().getConfiguration().locale.getCountry() : str;
    }
}
