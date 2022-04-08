package com.tplink.iot.viewmodel.ipcamera.setting;

import android.app.Application;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import b.d.q.b.l;
import com.tplink.iot.R;
import com.tplink.iot.Utils.x0.d;
import com.tplink.libtpmediaother.database.model.e;
import com.tplink.libtpnetwork.IoTNetwork.repository.kb.e;
import com.tplink.libtpnetwork.cameranetwork.TPCameraDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.business.model.DayOfWeek;
import com.tplink.libtpnetwork.cameranetwork.business.model.c;
import com.tplink.libtpnetwork.cameranetwork.business.repo.AreaIntrusionRepository;
import com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a;
import com.tplink.libtpnetwork.cameranetwork.model.IntrusionSchedule;
import com.tplink.libtpnetwork.cameranetwork.model.RecordPlanBean;
import com.tplink.libtpnetwork.cameranetwork.model.ScheduleParser;
import io.reactivex.e0.b;
import io.reactivex.g0.g;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

/* loaded from: classes3.dex */
public class AreaIntrusionScheduleViewModel extends AndroidViewModel {
    private String a;

    /* renamed from: b  reason: collision with root package name */
    private AreaIntrusionRepository f10697b;
    private final String j;
    private final String k;

    /* renamed from: c  reason: collision with root package name */
    public ObservableBoolean f10698c = new ObservableBoolean(false);

    /* renamed from: d  reason: collision with root package name */
    public ObservableField<String> f10699d = new ObservableField<>();

    /* renamed from: e  reason: collision with root package name */
    private ArrayList<RecordPlanBean> f10700e = new ArrayList<>();

    /* renamed from: f  reason: collision with root package name */
    private MutableLiveData<ArrayList<RecordPlanBean>> f10701f = new MutableLiveData<>();
    public ObservableBoolean g = new ObservableBoolean(false);
    private final b h = new b();
    public MediatorLiveData<a<String>> i = new MediatorLiveData<>();
    private int l = 3;

    public AreaIntrusionScheduleViewModel(@NonNull Application application, TPCameraDeviceContext tPCameraDeviceContext) {
        super(application);
        this.j = application.getString(R.string.setting_recording_schedule);
        this.k = application.getString(R.string.edit_record_plan);
        w(false);
        String deviceIdMD5 = tPCameraDeviceContext.getDeviceIdMD5();
        this.a = deviceIdMD5;
        this.f10697b = (AreaIntrusionRepository) e.c(deviceIdMD5, AreaIntrusionRepository.class);
    }

    private void A(Map<DayOfWeek, List<IntrusionSchedule>> map) {
        boolean z = true;
        if (this.l != 1) {
            z = false;
        }
        final e.a f2 = f(map);
        l.s(this.a, z, new com.tplink.libtpnetwork.Utils.f0.b() { // from class: com.tplink.iot.viewmodel.ipcamera.setting.e0
            @Override // com.tplink.libtpnetwork.Utils.f0.b
            public final void a(Object obj) {
                ((com.tplink.libtpmediaother.database.model.e) obj).Z(e.a.this);
            }
        });
    }

    private RecordPlanBean B(DayOfWeek dayOfWeek, IntrusionSchedule intrusionSchedule) {
        return new RecordPlanBean(1, dayOfWeek == DayOfWeek.SUNDAY ? 0 : dayOfWeek.ordinal() + 1, (intrusionSchedule.getStartHour() * 60) + intrusionSchedule.getStartMinute(), (intrusionSchedule.getEndHour() * 60) + intrusionSchedule.getEndMinute());
    }

    private e.a f(Map<DayOfWeek, List<IntrusionSchedule>> map) {
        return new e.a(ScheduleParser.formatIntrusionSchedules(map.get(DayOfWeek.MONDAY)), ScheduleParser.formatIntrusionSchedules(map.get(DayOfWeek.TUESDAY)), ScheduleParser.formatIntrusionSchedules(map.get(DayOfWeek.WEDNESDAY)), ScheduleParser.formatIntrusionSchedules(map.get(DayOfWeek.THURSDAY)), ScheduleParser.formatIntrusionSchedules(map.get(DayOfWeek.FRIDAY)), ScheduleParser.formatIntrusionSchedules(map.get(DayOfWeek.SATURDAY)), ScheduleParser.formatIntrusionSchedules(map.get(DayOfWeek.SUNDAY)));
    }

    private void g(c cVar) {
        DayOfWeek[] values;
        for (DayOfWeek dayOfWeek : DayOfWeek.values()) {
            List<IntrusionSchedule> b2 = cVar.b(dayOfWeek);
            if (b2 != null) {
                for (IntrusionSchedule intrusionSchedule : b2) {
                    this.f10700e.add(B(dayOfWeek, intrusionSchedule));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l */
    public /* synthetic */ void m(com.tplink.libtpmediaother.database.model.e eVar) {
        e.a k = eVar.k();
        c cVar = new c();
        x(cVar, k);
        g(cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n */
    public /* synthetic */ void o() throws Exception {
        this.f10698c.set(false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void p(Boolean bool) throws Exception {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: r */
    public /* synthetic */ void s(Throwable th) throws Exception {
        this.i.postValue(new a<>(getApplication().getString(R.string.general_failed)));
        th.printStackTrace();
    }

    private void u() {
        boolean z = true;
        if (this.l != 1) {
            z = false;
        }
        l.g(this.a, z, new com.tplink.libtpnetwork.Utils.f0.b() { // from class: com.tplink.iot.viewmodel.ipcamera.setting.d0
            @Override // com.tplink.libtpnetwork.Utils.f0.b
            public final void a(Object obj) {
                AreaIntrusionScheduleViewModel.this.m((com.tplink.libtpmediaother.database.model.e) obj);
            }
        });
    }

    private void x(c cVar, e.a aVar) {
        cVar.f(DayOfWeek.SUNDAY, ScheduleParser.parseIntrusionSchedules(aVar.f()));
        cVar.f(DayOfWeek.MONDAY, ScheduleParser.parseIntrusionSchedules(aVar.d()));
        cVar.f(DayOfWeek.TUESDAY, ScheduleParser.parseIntrusionSchedules(aVar.h()));
        cVar.f(DayOfWeek.WEDNESDAY, ScheduleParser.parseIntrusionSchedules(aVar.i()));
        cVar.f(DayOfWeek.THURSDAY, ScheduleParser.parseIntrusionSchedules(aVar.g()));
        cVar.f(DayOfWeek.FRIDAY, ScheduleParser.parseIntrusionSchedules(aVar.c()));
        cVar.f(DayOfWeek.SATURDAY, ScheduleParser.parseIntrusionSchedules(aVar.e()));
    }

    private Pair<DayOfWeek, IntrusionSchedule> y(RecordPlanBean recordPlanBean) {
        int dayIndex = recordPlanBean.getDayIndex();
        return new Pair<>(dayIndex == 0 ? DayOfWeek.SUNDAY : DayOfWeek.of(dayIndex), new IntrusionSchedule(recordPlanBean.getStartTime() / 60, recordPlanBean.getStartTime() % 60, recordPlanBean.getEndTime() / 60, recordPlanBean.getEndTime() % 60));
    }

    public ArrayList<RecordPlanBean> h() {
        return this.f10700e;
    }

    public MutableLiveData<ArrayList<RecordPlanBean>> i() {
        return this.f10701f;
    }

    public void j(int i) {
        this.l = i;
    }

    public boolean k() {
        return this.g.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        this.h.dispose();
    }

    public void v() {
        this.f10700e.clear();
        if (this.l == 3) {
            g(this.f10697b.z());
        } else {
            u();
        }
        this.f10701f.postValue(this.f10700e);
    }

    public void w(boolean z) {
        this.f10699d.set(z ? this.k : this.j);
        this.g.set(z);
    }

    public String z(List<RecordPlanBean> list) {
        Map<DayOfWeek, List<IntrusionSchedule>> enumMap = new EnumMap<>(DayOfWeek.class);
        TreeSet treeSet = new TreeSet();
        StringBuffer stringBuffer = new StringBuffer();
        for (RecordPlanBean recordPlanBean : list) {
            Pair<DayOfWeek, IntrusionSchedule> y = y(recordPlanBean);
            List<IntrusionSchedule> list2 = enumMap.get(y.first);
            if (list2 == null) {
                list2 = new ArrayList<>();
            }
            list2.add(y.second);
            enumMap.put(y.first, list2);
        }
        for (Map.Entry<DayOfWeek, List<IntrusionSchedule>> entry : enumMap.entrySet()) {
            if (entry.getValue().size() > 6) {
                treeSet.add(entry.getKey());
            }
        }
        if (treeSet.size() > 0) {
            Iterator it = treeSet.iterator();
            while (it.hasNext()) {
                DayOfWeek dayOfWeek = (DayOfWeek) it.next();
                if (stringBuffer.length() == 0) {
                    stringBuffer.append(dayOfWeek.name());
                } else {
                    stringBuffer.append(", ");
                    stringBuffer.append(dayOfWeek.name());
                }
            }
            return stringBuffer.toString();
        }
        boolean z = true;
        if (this.l != 3) {
            A(enumMap);
        } else if (this.f10697b != null) {
            this.f10698c.set(true);
            this.h.b(this.f10697b.E(enumMap).y(new io.reactivex.g0.a() { // from class: com.tplink.iot.viewmodel.ipcamera.setting.g0
                @Override // io.reactivex.g0.a
                public final void run() {
                    AreaIntrusionScheduleViewModel.this.o();
                }
            }).H0(f0.f10936c, new g() { // from class: com.tplink.iot.viewmodel.ipcamera.setting.h0
                @Override // io.reactivex.g0.g
                public final void accept(Object obj) {
                    AreaIntrusionScheduleViewModel.this.s((Throwable) obj);
                }
            }));
        }
        e.a f2 = f(enumMap);
        String str = this.a;
        if (this.l == 3) {
            z = false;
        }
        d.d(str, f2, z);
        return null;
    }
}
