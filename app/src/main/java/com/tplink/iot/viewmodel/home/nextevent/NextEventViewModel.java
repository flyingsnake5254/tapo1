package com.tplink.iot.viewmodel.home.nextevent;

import android.annotation.SuppressLint;
import android.app.Application;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import com.tplink.iot.Utils.t;
import com.tplink.iot.cloud.bean.thing.common.NextEvent;
import com.tplink.iot.cloud.bean.thing.common.ThingNextEvent;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.ThingCloudRepository;
import io.reactivex.g0.g;
import io.reactivex.q;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public class NextEventViewModel extends AndroidViewModel {

    /* renamed from: c  reason: collision with root package name */
    private io.reactivex.e0.c f10112c;

    /* renamed from: b  reason: collision with root package name */
    private MutableLiveData<List<ThingNextEvent>> f10111b = new MutableLiveData<>();

    /* renamed from: d  reason: collision with root package name */
    private Comparator<ThingNextEvent> f10113d = new c();
    private ThingCloudRepository a = (ThingCloudRepository) b.d.b.f.b.c(b.d.s.a.a.f()).a(ThingCloudRepository.class);

    /* loaded from: classes2.dex */
    class a implements g<List<ThingNextEvent>> {
        a() {
        }

        /* renamed from: a */
        public void accept(List<ThingNextEvent> list) throws Exception {
            NextEventViewModel.this.o(NextEventViewModel.this.j(list));
        }
    }

    /* loaded from: classes2.dex */
    class b implements g<Throwable> {
        b() {
        }

        /* renamed from: a */
        public void accept(Throwable th) throws Exception {
            NextEventViewModel.this.p();
            NextEventViewModel.this.f10111b.postValue(new ArrayList());
        }
    }

    /* loaded from: classes2.dex */
    class c implements Comparator<ThingNextEvent> {
        c() {
        }

        /* renamed from: a */
        public int compare(ThingNextEvent thingNextEvent, ThingNextEvent thingNextEvent2) {
            if (thingNextEvent.getNextEvent() == null || thingNextEvent2.getNextEvent() == null) {
                return 1;
            }
            return thingNextEvent.getNextEvent().getStartTime() - thingNextEvent2.getNextEvent().getStartTime();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class d implements g<Long> {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ List f10117c;

        d(List list) {
            this.f10117c = list;
        }

        /* renamed from: a */
        public void accept(Long l) throws Exception {
            NextEventViewModel.this.r(this.f10117c);
            NextEventViewModel.this.f10111b.postValue(this.f10117c);
        }
    }

    public NextEventViewModel(@NonNull Application application) {
        super(application);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<ThingNextEvent> j(List<ThingNextEvent> list) {
        BaseALIoTDevice I1;
        ArrayList arrayList = new ArrayList();
        if (list != null && list.size() > 0) {
            for (ThingNextEvent thingNextEvent : list) {
                String str = null;
                if (!(thingNextEvent == null || TextUtils.isEmpty(thingNextEvent.getThingName()) || (I1 = TPIoTClientManager.I1(b.d.w.h.a.g(thingNextEvent.getThingName()))) == null)) {
                    str = I1.getDeviceRegion();
                }
                if (t.i(thingNextEvent, str)) {
                    arrayList.add(thingNextEvent);
                }
            }
        }
        return arrayList;
    }

    private boolean n(List<ThingNextEvent> list) {
        for (ThingNextEvent thingNextEvent : list) {
            if (thingNextEvent.getNextEvent().getType() == 2) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(List<ThingNextEvent> list) {
        p();
        if (list == null || list.isEmpty()) {
            this.f10111b.postValue(list);
            return;
        }
        Collections.sort(list, k());
        if (!n(list)) {
            this.f10111b.postValue(list);
        } else {
            this.f10112c = q.a0(0L, 1L, TimeUnit.SECONDS).E(new d(list)).F0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(List<ThingNextEvent> list) {
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        Iterator<ThingNextEvent> it = list.iterator();
        while (it.hasNext()) {
            NextEvent nextEvent = it.next().getNextEvent();
            if (nextEvent.getType() == 2) {
                int startTime = (int) (nextEvent.getStartTime() - currentTimeMillis);
                if (startTime < 0) {
                    it.remove();
                } else {
                    nextEvent.setEndTime(startTime);
                }
            }
        }
        if (!n(list)) {
            p();
        }
    }

    public Comparator<ThingNextEvent> k() {
        return this.f10113d;
    }

    @SuppressLint({"CheckResult"})
    public void l(String str) {
        this.a.b0(str).H0(new a(), new b());
    }

    public MutableLiveData<List<ThingNextEvent>> m() {
        return this.f10111b;
    }

    public void p() {
        io.reactivex.e0.c cVar = this.f10112c;
        if (cVar != null) {
            cVar.dispose();
        }
    }
}
