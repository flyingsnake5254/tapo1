package com.tplink.iot.Utils;

import com.tplink.libtpmediastatistics.SSLClient;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/* compiled from: TimeUtils.java */
/* loaded from: classes2.dex */
public class q0 {
    public static String a(int i) {
        String str = i + ":00";
        if (i >= 10) {
            return str;
        }
        return 0 + str;
    }

    public static String b(String str) {
        if (str == null) {
            return "";
        }
        String[] split = str.split(SSLClient.WHITE_SPACE);
        if (split.length == 2) {
            String[] split2 = split[1].split(SSLClient.COLON);
            if (split2.length == 3) {
                return split2[0] + SSLClient.COLON + split2[1];
            }
        }
        return "";
    }

    public static long c() {
        return System.currentTimeMillis();
    }

    public static boolean d(Calendar calendar, Calendar calendar2) {
        return calendar.get(1) == calendar2.get(1) && calendar.get(2) == calendar2.get(2) && calendar.get(5) == calendar2.get(5);
    }

    public static boolean e(Date date, Date date2) {
        return f(date, date2, TimeZone.getDefault());
    }

    public static boolean f(Date date, Date date2, TimeZone timeZone) {
        Calendar instance = Calendar.getInstance(timeZone);
        instance.setTime(date);
        Calendar instance2 = Calendar.getInstance(timeZone);
        instance2.setTime(date2);
        return d(instance, instance2);
    }

    public static boolean g(Calendar calendar, Calendar calendar2) {
        return calendar.get(1) == calendar2.get(1) && calendar.get(2) == calendar2.get(2);
    }

    public static boolean h(Date date, Date date2) {
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        Calendar instance2 = Calendar.getInstance();
        instance2.setTime(date2);
        return g(instance, instance2);
    }

    public static boolean i(Date date, TimeZone timeZone) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        simpleDateFormat.setTimeZone(timeZone);
        try {
            Date parse = simpleDateFormat.parse(simpleDateFormat.format(new Date()));
            Date parse2 = simpleDateFormat.parse(simpleDateFormat.format(date));
            if (!(parse == null || parse2 == null)) {
                return parse.getTime() - parse2.getTime() == 86400000;
            }
        } catch (ParseException e2) {
            e2.printStackTrace();
        }
        return false;
    }
}
