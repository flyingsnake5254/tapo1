package com.tplink.libtpnetwork.cameranetwork.business.repo;

import com.tplink.libtpnetwork.cameranetwork.TPCameraDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.business.model.a;
import com.tplink.libtpnetwork.cameranetwork.business.model.b;
import com.tplink.libtpnetwork.cameranetwork.business.repo.l7.c;
import com.tplink.libtpnetwork.cameranetwork.g4.m;
import com.tplink.libtpnetwork.cameranetwork.model.AlarmInfo;
import com.tplink.libtpnetwork.cameranetwork.model.AlarmMode;
import com.tplink.libtpnetwork.cameranetwork.model.AlarmPlanInfo;
import com.tplink.libtpnetwork.cameranetwork.model.AlarmSoundType;
import com.tplink.libtpnetwork.cameranetwork.model.OptionSwitch;
import com.tplink.libtpnetwork.cameranetwork.model.Schedule;
import com.tplink.libtpnetwork.cameranetwork.model.ScheduleParser;
import io.reactivex.g0.g;
import io.reactivex.q;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class AlarmSettingRepository extends c {

    /* renamed from: d  reason: collision with root package name */
    private b f14170d = new b();

    public AlarmSettingRepository(TPCameraDeviceContext tPCameraDeviceContext) {
        super(tPCameraDeviceContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: B */
    public /* synthetic */ void C(AlarmInfo alarmInfo) throws Exception {
        List<AlarmMode> fromStringList = AlarmMode.fromStringList(alarmInfo.getModes());
        this.f14170d.h(OptionSwitch.isOn(alarmInfo.getEnabled()));
        this.f14170d.i(fromStringList.contains(AlarmMode.LIGHT));
        this.f14170d.l(fromStringList.contains(AlarmMode.SOUND));
        this.f14170d.m(AlarmSoundType.fromString(alarmInfo.getAlarmType()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: D */
    public /* synthetic */ void E(b bVar) throws Exception {
        this.f14170d = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: G */
    public /* synthetic */ void H(AlarmInfo alarmInfo, Boolean bool) throws Exception {
        List<AlarmMode> fromStringList = AlarmMode.fromStringList(alarmInfo.getModes());
        this.f14170d.h(OptionSwitch.isOn(alarmInfo.getEnabled()));
        this.f14170d.i(fromStringList.contains(AlarmMode.LIGHT));
        this.f14170d.l(fromStringList.contains(AlarmMode.SOUND));
        this.f14170d.m(AlarmSoundType.fromString(alarmInfo.getAlarmType()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: J */
    public /* synthetic */ void K(AlarmPlanInfo alarmPlanInfo, Boolean bool) throws Exception {
        this.f14170d.k(OptionSwitch.isOn(alarmPlanInfo.getEnabled()));
        Schedule parseSchedule = ScheduleParser.parseSchedule(alarmPlanInfo.getPlan());
        if (parseSchedule != null) {
            this.f14170d.j(new a(parseSchedule));
        }
    }

    private q<Boolean> N(final AlarmInfo alarmInfo) {
        return l().m2(alarmInfo).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a()).g0(h.f14449c).E(new g() { // from class: com.tplink.libtpnetwork.cameranetwork.business.repo.f
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                AlarmSettingRepository.this.H(alarmInfo, (Boolean) obj);
            }
        });
    }

    private q<Boolean> O(final AlarmPlanInfo alarmPlanInfo) {
        return l().n2(alarmPlanInfo).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a()).g0(b.f14341c).E(new g() { // from class: com.tplink.libtpnetwork.cameranetwork.business.repo.g
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                AlarmSettingRepository.this.K(alarmPlanInfo, (Boolean) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static b w(AlarmInfo alarmInfo, AlarmPlanInfo alarmPlanInfo) {
        b bVar = new b();
        List<AlarmMode> fromStringList = AlarmMode.fromStringList(alarmInfo.getModes());
        bVar.h(OptionSwitch.isOn(alarmInfo.getEnabled()));
        bVar.i(fromStringList.contains(AlarmMode.LIGHT));
        bVar.l(fromStringList.contains(AlarmMode.SOUND));
        bVar.m(AlarmSoundType.fromString(alarmInfo.getAlarmType()));
        bVar.k(OptionSwitch.isOn(alarmPlanInfo.getEnabled()));
        Schedule parseSchedule = ScheduleParser.parseSchedule(alarmPlanInfo.getPlan());
        if (parseSchedule != null) {
            bVar.j(new a(parseSchedule));
        }
        return bVar;
    }

    private AlarmInfo x() {
        AlarmSoundType c2 = this.f14170d.c();
        if (c2 == null) {
            c2 = AlarmSoundType.ALARM;
        }
        ArrayList arrayList = new ArrayList();
        if (this.f14170d.g() || this.f14170d.e()) {
            if (this.f14170d.e()) {
                arrayList.add(AlarmMode.LIGHT.getRaw());
            }
            if (this.f14170d.g()) {
                arrayList.add(AlarmMode.SOUND.getRaw());
            }
        } else {
            arrayList.add(AlarmMode.SOUND.getRaw());
        }
        return new AlarmInfo(c2.getRaw(), OptionSwitch.fromBoolean(this.f14170d.d()).getRaw(), "0", arrayList);
    }

    public q<AlarmInfo> L() {
        return l().x().i(m.a()).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a()).E(new g() { // from class: com.tplink.libtpnetwork.cameranetwork.business.repo.c
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                AlarmSettingRepository.this.C((AlarmInfo) obj);
            }
        });
    }

    public q<b> M() {
        return l().x().i(m.a()).i1(l().y().i(m.a()), d.f14368c).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a()).E(new g() { // from class: com.tplink.libtpnetwork.cameranetwork.business.repo.e
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                AlarmSettingRepository.this.E((b) obj);
            }
        });
    }

    public void P(boolean z) {
        this.f14170d.h(z);
    }

    public void Q(AlarmInfo alarmInfo) {
        if (alarmInfo != null) {
            List<AlarmMode> fromStringList = AlarmMode.fromStringList(alarmInfo.getModes());
            this.f14170d.h(OptionSwitch.isOn(alarmInfo.getEnabled()));
            this.f14170d.i(fromStringList.contains(AlarmMode.LIGHT));
            this.f14170d.l(fromStringList.contains(AlarmMode.SOUND));
            this.f14170d.m(AlarmSoundType.fromString(alarmInfo.getAlarmType()));
        }
    }

    public q<Boolean> s(boolean z) {
        AlarmInfo x = x();
        return N(new AlarmInfo(x.getAlarmType(), OptionSwitch.fromBoolean(z).getRaw(), x.getLightType(), x.getModes()));
    }

    public q<Boolean> t(boolean z, boolean z2) {
        AlarmInfo x = x();
        ArrayList arrayList = new ArrayList();
        if (z2) {
            arrayList.add(AlarmMode.LIGHT.getRaw());
        }
        if (z) {
            arrayList.add(AlarmMode.SOUND.getRaw());
        }
        return N(new AlarmInfo(x.getAlarmType(), x.getEnabled(), x.getLightType(), arrayList));
    }

    public q<Boolean> u(boolean z, a aVar) {
        return O(new AlarmPlanInfo(OptionSwitch.fromBoolean(z).getRaw(), ScheduleParser.formatAlarmSchedule(aVar.b())));
    }

    public q<Boolean> v(AlarmSoundType alarmSoundType) {
        AlarmInfo x = x();
        return N(new AlarmInfo(alarmSoundType.getRaw(), x.getEnabled(), x.getLightType(), x.getModes()));
    }

    public boolean y() {
        return this.f14170d.d();
    }

    public b z() {
        return this.f14170d;
    }
}
