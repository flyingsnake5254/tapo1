package com.tplink.libtpnetwork.cameranetwork.business.repo;

import com.tplink.libtpnetwork.cameranetwork.TPCameraDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.business.model.h;
import com.tplink.libtpnetwork.cameranetwork.business.repo.l7.c;
import com.tplink.libtpnetwork.cameranetwork.g4.m;
import com.tplink.libtpnetwork.cameranetwork.model.MsgPushInfo;
import com.tplink.libtpnetwork.cameranetwork.model.MsgPushPlanInfo;
import com.tplink.libtpnetwork.cameranetwork.model.OptionSwitch;
import com.tplink.libtpnetwork.cameranetwork.model.Schedule;
import com.tplink.libtpnetwork.cameranetwork.model.ScheduleParser;
import io.reactivex.g0.g;
import io.reactivex.q;

/* loaded from: classes3.dex */
public class MsgPushRepository extends c {

    /* renamed from: d  reason: collision with root package name */
    private h f14292d = new h();

    /* loaded from: classes3.dex */
    class a implements io.reactivex.g0.c<MsgPushInfo, MsgPushPlanInfo, Boolean> {
        a() {
        }

        /* renamed from: a */
        public Boolean apply(MsgPushInfo msgPushInfo, MsgPushPlanInfo msgPushPlanInfo) throws Exception {
            MsgPushRepository.this.f14292d.f(OptionSwitch.isOn(msgPushInfo.getNotificationEnabled()));
            MsgPushRepository.this.f14292d.g(OptionSwitch.isOn(msgPushInfo.getRichNotificationEnabled()));
            MsgPushRepository.this.f14292d.e(OptionSwitch.isOn(msgPushPlanInfo.getEnabled()));
            MsgPushRepository.this.f14292d.h(ScheduleParser.parseSchedule(msgPushPlanInfo.getPlan()));
            return Boolean.TRUE;
        }
    }

    public MsgPushRepository(TPCameraDeviceContext tPCameraDeviceContext) {
        super(tPCameraDeviceContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: A */
    public /* synthetic */ void B(boolean z, Schedule schedule, Boolean bool) throws Exception {
        this.f14292d.e(z);
        this.f14292d.h(schedule);
    }

    private MsgPushInfo t(boolean z, boolean z2) {
        return new MsgPushInfo(OptionSwitch.fromBoolean(z).getRaw(), OptionSwitch.fromBoolean(z2).getRaw());
    }

    private MsgPushPlanInfo u(boolean z, Schedule schedule) {
        return new MsgPushPlanInfo(OptionSwitch.fromBoolean(z).getRaw(), ScheduleParser.formatAlarmSchedule(schedule));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: x */
    public /* synthetic */ void y(boolean z, boolean z2, Boolean bool) throws Exception {
        this.f14292d.f(z);
        this.f14292d.g(z2);
    }

    public q<Boolean> C() {
        return this.f14514c.c0().i(m.a()).i1(this.f14514c.d0().i(m.a()), new a()).L0(io.reactivex.l0.a.c()).C(f7.f14400c);
    }

    public q<Boolean> D(final boolean z, final boolean z2) {
        return this.f14514c.L2(t(z, z2)).C(f7.f14400c).i(m.g()).L0(io.reactivex.l0.a.c()).g0(q3.f14565c).E(new g() { // from class: com.tplink.libtpnetwork.cameranetwork.business.repo.t3
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                MsgPushRepository.this.y(z, z2, (Boolean) obj);
            }
        });
    }

    public q<Boolean> E(final boolean z, final Schedule schedule) {
        return this.f14514c.M2(u(z, schedule)).C(f7.f14400c).i(m.g()).L0(io.reactivex.l0.a.c()).g0(s3.f14588c).E(new g() { // from class: com.tplink.libtpnetwork.cameranetwork.business.repo.r3
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                MsgPushRepository.this.B(z, schedule, (Boolean) obj);
            }
        });
    }

    public void F(MsgPushInfo msgPushInfo) {
        if (msgPushInfo != null) {
            this.f14292d.f(OptionSwitch.isOn(msgPushInfo.getNotificationEnabled()));
            this.f14292d.g(OptionSwitch.isOn(msgPushInfo.getRichNotificationEnabled()));
        }
    }

    public h v() {
        return this.f14292d;
    }
}
