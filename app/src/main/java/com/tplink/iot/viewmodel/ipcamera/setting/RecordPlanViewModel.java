package com.tplink.iot.viewmodel.ipcamera.setting;

import android.app.Application;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import com.tplink.iot.R;
import com.tplink.libtpnetwork.IoTNetwork.repository.kb.e;
import com.tplink.libtpnetwork.cameranetwork.TPCameraDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.business.model.DayOfWeek;
import com.tplink.libtpnetwork.cameranetwork.business.model.o;
import com.tplink.libtpnetwork.cameranetwork.business.repo.AIDetectionRepository;
import com.tplink.libtpnetwork.cameranetwork.business.repo.AreaIntrusionRepository;
import com.tplink.libtpnetwork.cameranetwork.business.repo.LineCrossingDetectionRepository;
import com.tplink.libtpnetwork.cameranetwork.business.repo.MotionDetectionRepository;
import com.tplink.libtpnetwork.cameranetwork.business.repo.RecordPlanRepository;
import com.tplink.libtpnetwork.cameranetwork.business.repo.TamperDetectionRepository;
import com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a;
import com.tplink.libtpnetwork.cameranetwork.model.RecordPlanBean;
import com.tplink.libtpnetwork.cameranetwork.model.Schedule;
import io.reactivex.e0.b;
import io.reactivex.g0.g;
import io.reactivex.g0.j;
import io.reactivex.q;
import io.reactivex.t;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

/* loaded from: classes3.dex */
public class RecordPlanViewModel extends AndroidViewModel {

    /* renamed from: d  reason: collision with root package name */
    private RecordPlanRepository f10825d;

    /* renamed from: e  reason: collision with root package name */
    private MotionDetectionRepository f10826e;

    /* renamed from: f  reason: collision with root package name */
    private LineCrossingDetectionRepository f10827f;
    private AreaIntrusionRepository g;
    private TamperDetectionRepository h;
    private AIDetectionRepository i;
    private final String n;
    private final String o;
    private String p;
    public ObservableBoolean a = new ObservableBoolean(false);

    /* renamed from: b  reason: collision with root package name */
    public ObservableField<String> f10823b = new ObservableField<>();

    /* renamed from: c  reason: collision with root package name */
    public ObservableBoolean f10824c = new ObservableBoolean(false);
    private b j = new b();
    private MediatorLiveData<o> k = new MediatorLiveData<>();
    private ArrayList<RecordPlanBean> l = new ArrayList<>();
    public MediatorLiveData<a<String>> m = new MediatorLiveData<>();

    public RecordPlanViewModel(@NonNull Application application, TPCameraDeviceContext tPCameraDeviceContext) {
        super(application);
        this.n = application.getString(R.string.setting_recording_schedule);
        this.o = application.getString(R.string.edit_record_plan);
        D(false);
        String deviceIdMD5 = tPCameraDeviceContext.getDeviceIdMD5();
        this.p = deviceIdMD5;
        this.f10826e = (MotionDetectionRepository) e.c(deviceIdMD5, MotionDetectionRepository.class);
        this.f10825d = (RecordPlanRepository) e.c(this.p, RecordPlanRepository.class);
        this.f10827f = (LineCrossingDetectionRepository) e.c(this.p, LineCrossingDetectionRepository.class);
        this.g = (AreaIntrusionRepository) e.c(this.p, AreaIntrusionRepository.class);
        this.h = (TamperDetectionRepository) e.c(this.p, TamperDetectionRepository.class);
        this.i = (AIDetectionRepository) e.c(this.p, AIDetectionRepository.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: A */
    public /* synthetic */ void B(Observer observer, o oVar) {
        DayOfWeek[] values;
        this.l.clear();
        for (DayOfWeek dayOfWeek : DayOfWeek.values()) {
            List<Schedule> b2 = oVar.b(dayOfWeek);
            if (b2 != null) {
                for (Schedule schedule : b2) {
                    this.l.add(G(dayOfWeek, schedule));
                }
            }
        }
        observer.onChanged(this.l);
    }

    private static Pair<DayOfWeek, Schedule> E(RecordPlanBean recordPlanBean) {
        int dayIndex = recordPlanBean.getDayIndex();
        return new Pair<>(dayIndex == 0 ? DayOfWeek.SUNDAY : DayOfWeek.of(dayIndex), new Schedule(recordPlanBean.getStartTime() / 60, recordPlanBean.getStartTime() % 60, recordPlanBean.getEndTime() / 60, recordPlanBean.getEndTime() % 60, recordPlanBean.getRecordType()));
    }

    private static RecordPlanBean G(DayOfWeek dayOfWeek, Schedule schedule) {
        return new RecordPlanBean(schedule.getType(), dayOfWeek == DayOfWeek.SUNDAY ? 0 : dayOfWeek.ordinal() + 1, (schedule.getStartHour() * 60) + schedule.getStartMinute(), (schedule.getEndHour() * 60) + schedule.getEndMinute());
    }

    private void I() {
        LiveData<o> t = this.f10825d.t();
        this.k.removeSource(t);
        final MediatorLiveData<o> mediatorLiveData = this.k;
        mediatorLiveData.getClass();
        mediatorLiveData.addSource(t, new Observer() { // from class: com.tplink.iot.viewmodel.ipcamera.setting.e9
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MediatorLiveData.this.setValue((o) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m */
    public /* synthetic */ void n(Boolean bool) throws Exception {
        I();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o */
    public /* synthetic */ t p(Boolean bool) throws Exception {
        return this.f10826e.X();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: r */
    public /* synthetic */ void s(Boolean bool) throws Exception {
        this.a.set(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: t */
    public /* synthetic */ void u(Throwable th) throws Exception {
        this.a.set(false);
        this.m.postValue(new a<>(getApplication().getString(R.string.general_failed)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: v */
    public /* synthetic */ void w() throws Exception {
        this.f10825d.J();
        this.a.set(false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void x(Boolean bool) throws Exception {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: y */
    public /* synthetic */ void z(Throwable th) throws Exception {
        this.m.postValue(new a<>(getApplication().getString(R.string.general_failed)));
        th.printStackTrace();
    }

    public void C(@Nullable String str) {
        if (str != null) {
            this.j.b(this.f10825d.H().E(new g() { // from class: com.tplink.iot.viewmodel.ipcamera.setting.n7
                @Override // io.reactivex.g0.g
                public final void accept(Object obj) {
                    RecordPlanViewModel.this.n((Boolean) obj);
                }
            }).N(new j() { // from class: com.tplink.iot.viewmodel.ipcamera.setting.m7
                @Override // io.reactivex.g0.j
                public final Object apply(Object obj) {
                    return RecordPlanViewModel.this.p((Boolean) obj);
                }
            }).H0(new g() { // from class: com.tplink.iot.viewmodel.ipcamera.setting.o7
                @Override // io.reactivex.g0.g
                public final void accept(Object obj) {
                    RecordPlanViewModel.this.s((Boolean) obj);
                }
            }, new g() { // from class: com.tplink.iot.viewmodel.ipcamera.setting.l7
                @Override // io.reactivex.g0.g
                public final void accept(Object obj) {
                    RecordPlanViewModel.this.u((Throwable) obj);
                }
            }));
        }
    }

    public void D(boolean z) {
        this.f10823b.set(z ? this.o : this.n);
        this.f10824c.set(z);
    }

    public String F(List<RecordPlanBean> list) {
        EnumMap enumMap = new EnumMap(DayOfWeek.class);
        TreeSet treeSet = new TreeSet();
        StringBuffer stringBuffer = new StringBuffer();
        for (RecordPlanBean recordPlanBean : list) {
            Pair<DayOfWeek, Schedule> E = E(recordPlanBean);
            List list2 = (List) enumMap.get(E.first);
            if (list2 == null) {
                list2 = new ArrayList();
            }
            list2.add(E.second);
            enumMap.put((EnumMap) E.first, (Object) list2);
        }
        for (Map.Entry entry : enumMap.entrySet()) {
            if (((List) entry.getValue()).size() > 10) {
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
        } else if (this.f10825d == null) {
            return null;
        } else {
            com.tplink.iot.Utils.x0.g.h(this.p, enumMap);
            this.a.set(true);
            this.j.b(this.f10825d.K(enumMap).y(new io.reactivex.g0.a() { // from class: com.tplink.iot.viewmodel.ipcamera.setting.i7
                @Override // io.reactivex.g0.a
                public final void run() {
                    RecordPlanViewModel.this.w();
                }
            }).H0(h7.f10960c, new g() { // from class: com.tplink.iot.viewmodel.ipcamera.setting.j7
                @Override // io.reactivex.g0.g
                public final void accept(Object obj) {
                    RecordPlanViewModel.this.z((Throwable) obj);
                }
            }));
            return null;
        }
    }

    public void H(LifecycleOwner lifecycleOwner, final Observer<ArrayList<RecordPlanBean>> observer) {
        this.k.observe(lifecycleOwner, new Observer() { // from class: com.tplink.iot.viewmodel.ipcamera.setting.k7
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                RecordPlanViewModel.this.B(observer, (o) obj);
            }
        });
    }

    public q<Boolean> f() {
        RecordPlanRepository recordPlanRepository = this.f10825d;
        if (recordPlanRepository != null) {
            return recordPlanRepository.L(false);
        }
        return q.f0(Boolean.TRUE);
    }

    public String g() {
        return this.p;
    }

    public ArrayList<RecordPlanBean> h() {
        return this.l;
    }

    public boolean i() {
        RecordPlanRepository recordPlanRepository = this.f10825d;
        if (recordPlanRepository != null) {
            return recordPlanRepository.w();
        }
        return false;
    }

    public boolean j() {
        MotionDetectionRepository motionDetectionRepository = this.f10826e;
        if (motionDetectionRepository != null && motionDetectionRepository.y() != null && this.f10826e.y().e()) {
            return true;
        }
        MotionDetectionRepository motionDetectionRepository2 = this.f10826e;
        return this.f10827f.A().c() || this.g.z().c() || this.h.t().c() || (motionDetectionRepository2 != null && motionDetectionRepository2.y() != null && org.apache.commons.lang.b.b(this.f10826e.y().b())) || com.tplink.libtpnetwork.Utils.j.h(this.i.t()) || com.tplink.libtpnetwork.Utils.j.h(this.i.v());
    }

    public boolean k() {
        RecordPlanRepository recordPlanRepository = this.f10825d;
        if (recordPlanRepository != null) {
            return recordPlanRepository.x();
        }
        return false;
    }

    public boolean l() {
        return this.f10824c.get();
    }
}
