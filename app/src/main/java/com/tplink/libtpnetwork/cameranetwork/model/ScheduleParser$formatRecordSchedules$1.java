package com.tplink.libtpnetwork.cameranetwork.model;

import kotlin.jvm.b.l;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ModelAdapter.kt */
/* loaded from: classes3.dex */
public final class ScheduleParser$formatRecordSchedules$1 extends Lambda implements l<Schedule, CharSequence> {
    public static final ScheduleParser$formatRecordSchedules$1 INSTANCE = new ScheduleParser$formatRecordSchedules$1();

    ScheduleParser$formatRecordSchedules$1() {
        super(1);
    }

    public final CharSequence invoke(Schedule it) {
        j.e(it, "it");
        return ScheduleParser.formatRecordSchedule(it);
    }
}
