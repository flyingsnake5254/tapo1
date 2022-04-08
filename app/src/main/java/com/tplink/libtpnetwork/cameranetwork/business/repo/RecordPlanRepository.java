package com.tplink.libtpnetwork.cameranetwork.business.repo;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.tplink.libtpnetwork.cameranetwork.TPCameraDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.business.model.DayOfWeek;
import com.tplink.libtpnetwork.cameranetwork.business.model.o;
import com.tplink.libtpnetwork.cameranetwork.business.repo.l7.c;
import com.tplink.libtpnetwork.cameranetwork.g4.m;
import com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a;
import com.tplink.libtpnetwork.cameranetwork.model.OptionSwitch;
import com.tplink.libtpnetwork.cameranetwork.model.RecordPlanInfo;
import com.tplink.libtpnetwork.cameranetwork.model.Schedule;
import com.tplink.libtpnetwork.cameranetwork.model.ScheduleParser;
import com.tplink.libtpnetwork.cameranetwork.net.CameraException;
import io.reactivex.g0.g;
import io.reactivex.q;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class RecordPlanRepository extends c {

    /* renamed from: d  reason: collision with root package name */
    private final MutableLiveData<o> f14317d = new MutableLiveData<>();

    /* renamed from: e  reason: collision with root package name */
    private final MutableLiveData<a<CameraException>> f14318e = new MutableLiveData<>();

    /* renamed from: f  reason: collision with root package name */
    private o f14319f;

    public RecordPlanRepository(TPCameraDeviceContext tPCameraDeviceContext) {
        super(tPCameraDeviceContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: C */
    public /* synthetic */ void D(Map map, Boolean bool) throws Exception {
        M(map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: E */
    public /* synthetic */ void F(boolean z, Throwable th) throws Exception {
        u(th);
        o oVar = this.f14319f;
        if (oVar != null) {
            oVar.d(!z);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void G(Boolean bool) throws Exception {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static o I(RecordPlanInfo recordPlanInfo) {
        o oVar = new o();
        oVar.d(OptionSwitch.fromString(recordPlanInfo.getEnabled()) == OptionSwitch.ON);
        oVar.e(DayOfWeek.SUNDAY, ScheduleParser.parseSchedules(recordPlanInfo.getSunday()));
        oVar.e(DayOfWeek.MONDAY, ScheduleParser.parseSchedules(recordPlanInfo.getMonday()));
        oVar.e(DayOfWeek.TUESDAY, ScheduleParser.parseSchedules(recordPlanInfo.getTuesday()));
        oVar.e(DayOfWeek.WEDNESDAY, ScheduleParser.parseSchedules(recordPlanInfo.getWednesday()));
        oVar.e(DayOfWeek.THURSDAY, ScheduleParser.parseSchedules(recordPlanInfo.getThursday()));
        oVar.e(DayOfWeek.FRIDAY, ScheduleParser.parseSchedules(recordPlanInfo.getFriday()));
        oVar.e(DayOfWeek.SATURDAY, ScheduleParser.parseSchedules(recordPlanInfo.getSaturday()));
        return oVar;
    }

    private void M(Map<DayOfWeek, List<Schedule>> map) {
        DayOfWeek[] values;
        o oVar = this.f14319f;
        if (oVar != null) {
            oVar.d(true);
            for (DayOfWeek dayOfWeek : DayOfWeek.values()) {
                this.f14319f.e(dayOfWeek, map.get(dayOfWeek));
            }
        }
    }

    public static RecordPlanInfo s(Map<DayOfWeek, List<Schedule>> map) {
        return new RecordPlanInfo(OptionSwitch.fromBoolean(!map.isEmpty()).getRaw(), ScheduleParser.formatRecordSchedules(map.get(DayOfWeek.MONDAY)), ScheduleParser.formatRecordSchedules(map.get(DayOfWeek.TUESDAY)), ScheduleParser.formatRecordSchedules(map.get(DayOfWeek.WEDNESDAY)), ScheduleParser.formatRecordSchedules(map.get(DayOfWeek.THURSDAY)), ScheduleParser.formatRecordSchedules(map.get(DayOfWeek.FRIDAY)), ScheduleParser.formatRecordSchedules(map.get(DayOfWeek.SATURDAY)), ScheduleParser.formatRecordSchedules(map.get(DayOfWeek.SUNDAY)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(Throwable th) {
        if (th instanceof CameraException) {
            this.f14318e.postValue(new a<>((CameraException) th));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(o oVar) {
        this.f14319f = oVar;
        this.f14317d.postValue(oVar);
    }

    public q<Boolean> H() {
        return l().j0().i(m.a()).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a()).g0(j6.f14479c).E(new g() { // from class: com.tplink.libtpnetwork.cameranetwork.business.repo.h6
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                RecordPlanRepository.this.v((o) obj);
            }
        }).C(new i6(this)).g0(l6.f14511c);
    }

    public void J() {
        this.f14317d.setValue(this.f14319f);
    }

    public q<Boolean> K(final Map<DayOfWeek, List<Schedule>> map) {
        return l().T2(s(map)).i(m.g()).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a()).C(new i6(this)).E(new g() { // from class: com.tplink.libtpnetwork.cameranetwork.business.repo.k6
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                RecordPlanRepository.this.D(map, (Boolean) obj);
            }
        });
    }

    public q<Boolean> L(final boolean z) {
        o oVar = this.f14319f;
        if (oVar == null || oVar.a() == null) {
            return q.f0(Boolean.TRUE);
        }
        RecordPlanInfo s = s(this.f14319f.a());
        s.setEnabled(z ? "on" : "off");
        return l().T2(s).i(m.g()).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a()).C(new g() { // from class: com.tplink.libtpnetwork.cameranetwork.business.repo.g6
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                RecordPlanRepository.this.F(z, (Throwable) obj);
            }
        }).E(f6.f14399c);
    }

    public LiveData<o> t() {
        return this.f14317d;
    }

    public boolean w() {
        o oVar = this.f14319f;
        if (!(oVar == null || oVar.a() == null)) {
            for (List<Schedule> list : this.f14319f.a().values()) {
                for (Schedule schedule : list) {
                    if (schedule.getType() == 2) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean x() {
        o oVar = this.f14319f;
        if (!(oVar == null || oVar.a() == null)) {
            for (List<Schedule> list : this.f14319f.a().values()) {
                for (Schedule schedule : list) {
                    if (schedule.getType() == 1) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
