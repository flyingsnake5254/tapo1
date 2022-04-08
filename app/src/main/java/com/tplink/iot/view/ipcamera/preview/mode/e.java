package com.tplink.iot.view.ipcamera.preview.mode;

import com.tplink.libtpmediaother.database.model.e;
import com.tplink.libtpnetwork.cameranetwork.business.model.DayOfWeek;
import com.tplink.libtpnetwork.cameranetwork.business.model.a;
import com.tplink.libtpnetwork.cameranetwork.business.model.c;
import com.tplink.libtpnetwork.cameranetwork.business.model.d;
import com.tplink.libtpnetwork.cameranetwork.business.repo.AreaIntrusionRepository;
import com.tplink.libtpnetwork.cameranetwork.model.AlarmInfo;
import com.tplink.libtpnetwork.cameranetwork.model.AlarmMode;
import com.tplink.libtpnetwork.cameranetwork.model.AlarmPlanInfo;
import com.tplink.libtpnetwork.cameranetwork.model.ArmScheduleInfo;
import com.tplink.libtpnetwork.cameranetwork.model.BitwiseWeekDayUtils;
import com.tplink.libtpnetwork.cameranetwork.model.IntrusionDetectionRegion;
import com.tplink.libtpnetwork.cameranetwork.model.IntrusionSchedule;
import com.tplink.libtpnetwork.cameranetwork.model.LineCrossingDetectionRegion;
import com.tplink.libtpnetwork.cameranetwork.model.MotionDetectRegion;
import com.tplink.libtpnetwork.cameranetwork.model.MsgPushInfo;
import com.tplink.libtpnetwork.cameranetwork.model.MsgPushPlanInfo;
import com.tplink.libtpnetwork.cameranetwork.model.OptionSwitch;
import com.tplink.libtpnetwork.cameranetwork.model.Schedule;
import com.tplink.libtpnetwork.cameranetwork.model.ScheduleParser;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: HomeAwayDataUtils.java */
/* loaded from: classes2.dex */
public class e {
    private static MotionDetectRegion a(d dVar) {
        return new MotionDetectRegion(dVar.c(), dVar.d(), dVar.b(), dVar.a());
    }

    public static HashMap<String, List<IntrusionDetectionRegion>> b(List<e.c> list) {
        return AreaIntrusionRepository.f14171d.a(c(list));
    }

    public static List<c.a> c(List<e.c> list) {
        ArrayList arrayList = new ArrayList();
        for (e.c cVar : list) {
            c.a aVar = new c.a();
            aVar.e(cVar.c());
            aVar.f(cVar.d());
            aVar.g(cVar.e());
            aVar.h(cVar.f());
            arrayList.add(aVar);
        }
        return arrayList;
    }

    public static List<LineCrossingDetectionRegion> d(List<e.b> list) {
        ArrayList arrayList = new ArrayList();
        for (e.b bVar : list) {
            arrayList.add(bVar.a());
        }
        return arrayList;
    }

    public static HashMap<String, List<LineCrossingDetectionRegion>> e(List<e.b> list) {
        HashMap<String, List<LineCrossingDetectionRegion>> hashMap = new HashMap<>();
        hashMap.put("region_info", d(list));
        return hashMap;
    }

    public static List<d> f(List<e.c> list) {
        ArrayList arrayList = new ArrayList();
        for (e.c cVar : list) {
            d dVar = new d();
            dVar.e(cVar.c());
            dVar.f(cVar.d());
            dVar.g(cVar.e());
            dVar.h(cVar.f());
            arrayList.add(dVar);
        }
        return arrayList;
    }

    public static AlarmInfo g(boolean z, boolean z2, boolean z3, String str) {
        ArrayList arrayList = new ArrayList();
        if (z3) {
            arrayList.add(AlarmMode.LIGHT.getRaw());
        }
        if (z2) {
            arrayList.add(AlarmMode.SOUND.getRaw());
        }
        return new AlarmInfo(str, OptionSwitch.fromBoolean(z).getRaw(), "0", arrayList);
    }

    public static AlarmPlanInfo h(boolean z, int i, int i2, int i3, int i4, int i5) {
        return new AlarmPlanInfo(OptionSwitch.fromBoolean(z).getRaw(), ScheduleParser.formatAlarmSchedule(new a(i, i2, i3, i4, BitwiseWeekDayUtils.daysFromRawSet(i5)).b()));
    }

    public static ArmScheduleInfo i(e.a aVar) {
        Map<DayOfWeek, List<IntrusionSchedule>> m = m(aVar);
        return new ArmScheduleInfo(ScheduleParser.formatIntrusionSchedules(m.get(DayOfWeek.MONDAY)), ScheduleParser.formatIntrusionSchedules(m.get(DayOfWeek.TUESDAY)), ScheduleParser.formatIntrusionSchedules(m.get(DayOfWeek.WEDNESDAY)), ScheduleParser.formatIntrusionSchedules(m.get(DayOfWeek.THURSDAY)), ScheduleParser.formatIntrusionSchedules(m.get(DayOfWeek.FRIDAY)), ScheduleParser.formatIntrusionSchedules(m.get(DayOfWeek.SATURDAY)), ScheduleParser.formatIntrusionSchedules(m.get(DayOfWeek.SUNDAY)));
    }

    public static List<MotionDetectRegion> j(List<d> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (d dVar : list) {
            arrayList.add(a(dVar));
        }
        return arrayList;
    }

    public static MsgPushInfo k(boolean z, boolean z2) {
        return new MsgPushInfo(OptionSwitch.fromBoolean(z).getRaw(), OptionSwitch.fromBoolean(z2).getRaw());
    }

    public static MsgPushPlanInfo l(boolean z, int i, int i2, int i3, int i4, int i5) {
        return new MsgPushPlanInfo(OptionSwitch.fromBoolean(z).getRaw(), ScheduleParser.formatAlarmSchedule(new Schedule(i, i2, i3, i4, i5)));
    }

    public static Map<DayOfWeek, List<IntrusionSchedule>> m(e.a aVar) {
        EnumMap enumMap = new EnumMap(DayOfWeek.class);
        enumMap.put((EnumMap) DayOfWeek.SUNDAY, (DayOfWeek) ScheduleParser.parseIntrusionSchedules(aVar.f()));
        enumMap.put((EnumMap) DayOfWeek.MONDAY, (DayOfWeek) ScheduleParser.parseIntrusionSchedules(aVar.d()));
        enumMap.put((EnumMap) DayOfWeek.TUESDAY, (DayOfWeek) ScheduleParser.parseIntrusionSchedules(aVar.h()));
        enumMap.put((EnumMap) DayOfWeek.WEDNESDAY, (DayOfWeek) ScheduleParser.parseIntrusionSchedules(aVar.i()));
        enumMap.put((EnumMap) DayOfWeek.THURSDAY, (DayOfWeek) ScheduleParser.parseIntrusionSchedules(aVar.g()));
        enumMap.put((EnumMap) DayOfWeek.FRIDAY, (DayOfWeek) ScheduleParser.parseIntrusionSchedules(aVar.c()));
        enumMap.put((EnumMap) DayOfWeek.SATURDAY, (DayOfWeek) ScheduleParser.parseIntrusionSchedules(aVar.e()));
        return enumMap;
    }

    public static String n(int i) {
        return i == 0 ? "low" : i == 50 ? "medium" : i == 100 ? "high" : "low";
    }
}
