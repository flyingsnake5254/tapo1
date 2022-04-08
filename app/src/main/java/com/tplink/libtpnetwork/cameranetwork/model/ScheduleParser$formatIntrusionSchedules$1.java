package com.tplink.libtpnetwork.cameranetwork.model;

import kotlin.jvm.b.l;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

/* compiled from: ModelAdapter.kt */
/* loaded from: classes3.dex */
final class ScheduleParser$formatIntrusionSchedules$1 extends Lambda implements l<IntrusionSchedule, CharSequence> {
    public static final ScheduleParser$formatIntrusionSchedules$1 INSTANCE = new ScheduleParser$formatIntrusionSchedules$1();

    ScheduleParser$formatIntrusionSchedules$1() {
        super(1);
    }

    public final CharSequence invoke(IntrusionSchedule it) {
        j.e(it, "it");
        return ScheduleParser.formatIntrusionSchedule(it);
    }
}
