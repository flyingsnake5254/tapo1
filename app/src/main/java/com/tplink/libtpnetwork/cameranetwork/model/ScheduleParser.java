package com.tplink.libtpnetwork.cameranetwork.model;

import io.netty.util.internal.StringUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.jvm.internal.j;
import kotlin.text.w;

/* compiled from: ModelAdapter.kt */
/* loaded from: classes3.dex */
public final class ScheduleParser {
    public static final ScheduleParser INSTANCE = new ScheduleParser();
    private static final Pattern pattern = Pattern.compile(".*(\\d{2})(\\d{2})-(\\d{2})(\\d{2})[,:](\\d+).*");
    private static final Pattern pattern2 = Pattern.compile(".*(\\d{2})(\\d{2})-(\\d{2})(\\d{2}).*");

    private ScheduleParser() {
    }

    public static final String formatAlarmSchedule(Schedule schedule) {
        j.e(schedule, "schedule");
        String format = String.format(Locale.US, "%02d%02d-%02d%02d,%d", Arrays.copyOf(new Object[]{Integer.valueOf(schedule.getStartHour()), Integer.valueOf(schedule.getStartMinute()), Integer.valueOf(schedule.getEndHour()), Integer.valueOf(schedule.getEndMinute()), Integer.valueOf(schedule.getType())}, 5));
        j.d(format, "java.lang.String.format(locale, this, *args)");
        return format;
    }

    public static final String formatIntrusionSchedule(IntrusionSchedule schedule) {
        j.e(schedule, "schedule");
        String format = String.format(Locale.US, "\"%02d%02d-%02d%02d\"", Arrays.copyOf(new Object[]{Integer.valueOf(schedule.getStartHour()), Integer.valueOf(schedule.getStartMinute()), Integer.valueOf(schedule.getEndHour()), Integer.valueOf(schedule.getEndMinute())}, 4));
        j.d(format, "java.lang.String.format(locale, this, *args)");
        return format;
    }

    /* JADX WARN: Code restructure failed: missing block: B:3:0x0002, code lost:
        r9 = kotlin.collections.v.E(r9, com.tplink.libtpmediastatistics.SSLClient.COMMA, "[", "]", 0, null, com.tplink.libtpnetwork.cameranetwork.model.ScheduleParser$formatIntrusionSchedules$1.INSTANCE, 24, null);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.String formatIntrusionSchedules(java.util.List<com.tplink.libtpnetwork.cameranetwork.model.IntrusionSchedule> r9) {
        /*
            if (r9 == 0) goto L_0x0017
            r4 = 0
            r5 = 0
            com.tplink.libtpnetwork.cameranetwork.model.ScheduleParser$formatIntrusionSchedules$1 r6 = com.tplink.libtpnetwork.cameranetwork.model.ScheduleParser$formatIntrusionSchedules$1.INSTANCE
            r7 = 24
            r8 = 0
            java.lang.String r1 = ","
            java.lang.String r2 = "["
            java.lang.String r3 = "]"
            r0 = r9
            java.lang.String r9 = kotlin.collections.l.E(r0, r1, r2, r3, r4, r5, r6, r7, r8)
            if (r9 == 0) goto L_0x0017
            goto L_0x0019
        L_0x0017:
            java.lang.String r9 = "[]"
        L_0x0019:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tplink.libtpnetwork.cameranetwork.model.ScheduleParser.formatIntrusionSchedules(java.util.List):java.lang.String");
    }

    public static final String formatRecordSchedule(Schedule schedule) {
        j.e(schedule, "schedule");
        String format = String.format(Locale.US, "\"%02d%02d-%02d%02d:%d\"", Arrays.copyOf(new Object[]{Integer.valueOf(schedule.getStartHour()), Integer.valueOf(schedule.getStartMinute()), Integer.valueOf(schedule.getEndHour()), Integer.valueOf(schedule.getEndMinute()), Integer.valueOf(schedule.getType())}, 5));
        j.d(format, "java.lang.String.format(locale, this, *args)");
        return format;
    }

    /* JADX WARN: Code restructure failed: missing block: B:3:0x0002, code lost:
        r9 = kotlin.collections.v.E(r9, com.tplink.libtpmediastatistics.SSLClient.COMMA, "[", "]", 0, null, com.tplink.libtpnetwork.cameranetwork.model.ScheduleParser$formatRecordSchedules$1.INSTANCE, 24, null);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.String formatRecordSchedules(java.util.List<com.tplink.libtpnetwork.cameranetwork.model.Schedule> r9) {
        /*
            if (r9 == 0) goto L_0x0017
            r4 = 0
            r5 = 0
            com.tplink.libtpnetwork.cameranetwork.model.ScheduleParser$formatRecordSchedules$1 r6 = com.tplink.libtpnetwork.cameranetwork.model.ScheduleParser$formatRecordSchedules$1.INSTANCE
            r7 = 24
            r8 = 0
            java.lang.String r1 = ","
            java.lang.String r2 = "["
            java.lang.String r3 = "]"
            r0 = r9
            java.lang.String r9 = kotlin.collections.l.E(r0, r1, r2, r3, r4, r5, r6, r7, r8)
            if (r9 == 0) goto L_0x0017
            goto L_0x0019
        L_0x0017:
            java.lang.String r9 = "[]"
        L_0x0019:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tplink.libtpnetwork.cameranetwork.model.ScheduleParser.formatRecordSchedules(java.util.List):java.lang.String");
    }

    public static final String formatTime(int i, int i2) {
        String format = String.format(Locale.US, "%02d%02d", Arrays.copyOf(new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}, 2));
        j.d(format, "java.lang.String.format(locale, this, *args)");
        return format;
    }

    public static final IntrusionSchedule parseIntrusionSchedule(String str) {
        if (str == null) {
            return null;
        }
        Matcher matcher = pattern2.matcher(str);
        if (!matcher.matches()) {
            return null;
        }
        String group = matcher.group(1);
        j.d(group, "matcher.group(1)");
        int parseInt = Integer.parseInt(group);
        String group2 = matcher.group(2);
        j.d(group2, "matcher.group(2)");
        int parseInt2 = Integer.parseInt(group2);
        String group3 = matcher.group(3);
        j.d(group3, "matcher.group(3)");
        int parseInt3 = Integer.parseInt(group3);
        String group4 = matcher.group(4);
        j.d(group4, "matcher.group(4)");
        return new IntrusionSchedule(parseInt, parseInt2, parseInt3, Integer.parseInt(group4));
    }

    public static final List<IntrusionSchedule> parseIntrusionSchedules(String str) {
        List<String> e0;
        ArrayList arrayList = new ArrayList();
        if (str != null) {
            e0 = w.e0(str, new char[]{StringUtil.COMMA}, false, 0, 6, null);
            for (String str2 : e0) {
                IntrusionSchedule parseIntrusionSchedule = parseIntrusionSchedule(str2);
                if (parseIntrusionSchedule != null) {
                    arrayList.add(parseIntrusionSchedule);
                }
            }
        }
        return arrayList;
    }

    public static final Schedule parseSchedule(String str) {
        if (str == null) {
            return null;
        }
        Matcher matcher = pattern.matcher(str);
        if (!matcher.matches()) {
            return null;
        }
        String group = matcher.group(1);
        j.d(group, "matcher.group(1)");
        int parseInt = Integer.parseInt(group);
        String group2 = matcher.group(2);
        j.d(group2, "matcher.group(2)");
        int parseInt2 = Integer.parseInt(group2);
        String group3 = matcher.group(3);
        j.d(group3, "matcher.group(3)");
        int parseInt3 = Integer.parseInt(group3);
        String group4 = matcher.group(4);
        j.d(group4, "matcher.group(4)");
        int parseInt4 = Integer.parseInt(group4);
        String group5 = matcher.group(5);
        j.d(group5, "matcher.group(5)");
        return new Schedule(parseInt, parseInt2, parseInt3, parseInt4, Integer.parseInt(group5));
    }

    public static final List<Schedule> parseSchedules(String str) {
        List<String> e0;
        ArrayList arrayList = new ArrayList();
        if (str != null) {
            e0 = w.e0(str, new char[]{StringUtil.COMMA}, false, 0, 6, null);
            for (String str2 : e0) {
                Schedule parseSchedule = parseSchedule(str2);
                if (parseSchedule != null) {
                    arrayList.add(parseSchedule);
                }
            }
        }
        return arrayList;
    }
}
