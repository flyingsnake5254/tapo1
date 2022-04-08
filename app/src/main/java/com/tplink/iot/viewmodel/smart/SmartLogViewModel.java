package com.tplink.iot.viewmodel.smart;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.Observer;
import b.d.s.a.a;
import com.tplink.cloud.context.b;
import com.tplink.iot.cloud.bean.smart.common.SmartLog;
import com.tplink.libtpnetwork.IoTNetwork.repository.SmartRepository;
import com.tplink.libtpnetwork.Utils.SingleLiveEvent;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class SmartLogViewModel extends AndroidViewModel {
    private b a;

    /* renamed from: b  reason: collision with root package name */
    private SmartRepository f11415b;

    /* renamed from: c  reason: collision with root package name */
    private SingleLiveEvent<List<SmartLog>> f11416c = new SingleLiveEvent<>();

    public SmartLogViewModel(@NonNull Application application) {
        super(application);
        b f2 = a.f();
        this.a = f2;
        SmartRepository smartRepository = (SmartRepository) b.d.b.f.b.a(f2, SmartRepository.class);
        this.f11415b = smartRepository;
        this.f11416c.addSource(smartRepository.i0(), new Observer() { // from class: com.tplink.iot.viewmodel.smart.l
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SmartLogViewModel.this.v((List) obj);
            }
        });
        this.f11416c.addSource(this.f11415b.e0(), new Observer() { // from class: com.tplink.iot.viewmodel.smart.m
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SmartLogViewModel.this.u((List) obj);
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean n(java.util.List<com.tplink.iot.cloud.bean.smart.common.SmartLog> r4) {
        /*
            r3 = this;
            r0 = 0
            if (r4 == 0) goto L_0x002f
            boolean r1 = r4.isEmpty()
            if (r1 == 0) goto L_0x000a
            goto L_0x002f
        L_0x000a:
            java.util.Iterator r4 = r4.iterator()
        L_0x000e:
            boolean r1 = r4.hasNext()
            if (r1 == 0) goto L_0x002d
            java.lang.Object r1 = r4.next()
            com.tplink.iot.cloud.bean.smart.common.SmartLog r1 = (com.tplink.iot.cloud.bean.smart.common.SmartLog) r1
            java.lang.String r2 = r1.getTimestamp()
            if (r2 == 0) goto L_0x002c
            java.lang.String r2 = r1.getTriggerId()
            if (r2 == 0) goto L_0x002c
            java.lang.String r1 = r1.getSmartId()
            if (r1 != 0) goto L_0x000e
        L_0x002c:
            return r0
        L_0x002d:
            r4 = 1
            return r4
        L_0x002f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tplink.iot.viewmodel.smart.SmartLogViewModel.n(java.util.List):boolean");
    }

    private boolean o(@NonNull List<SmartLog> list, @NonNull List<SmartLog> list2) {
        if (list.size() != list2.size()) {
            return false;
        }
        for (int i = 0; i < list.size(); i++) {
            SmartLog smartLog = list.get(i);
            SmartLog smartLog2 = list2.get(i);
            if (!smartLog.getTimestamp().equals(smartLog2.getTimestamp()) || !smartLog.getTriggerId().equals(smartLog2.getTriggerId()) || !smartLog.getSmartId().equals(smartLog2.getSmartId())) {
                return false;
            }
        }
        return true;
    }

    private void s(List<SmartLog> list) {
        if (!(list == null || list.isEmpty())) {
            HashSet hashSet = new HashSet();
            ArrayList arrayList = new ArrayList();
            for (SmartLog smartLog : list) {
                if (!hashSet.contains(smartLog.getId())) {
                    arrayList.add(smartLog);
                    hashSet.add(smartLog.getId());
                }
            }
            hashSet.clear();
            list.clear();
            list.addAll(arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(List<SmartLog> list) {
        List<SmartLog> j = j();
        if (list == null) {
            list = new ArrayList<>();
        }
        if (!n(j)) {
            j = new ArrayList<>();
        }
        j.addAll(list);
        Calendar instance = Calendar.getInstance();
        instance.add(5, -30);
        long timeInMillis = instance.getTimeInMillis();
        Iterator<SmartLog> it = j.iterator();
        while (it.hasNext()) {
            if (Long.parseLong(it.next().getTimestamp()) * 1000 < timeInMillis) {
                it.remove();
            }
        }
        s(j);
        t(j);
        this.f11416c.postValue(j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(List<SmartLog> list) {
        List<SmartLog> j = j();
        if (list == null) {
            list = new ArrayList<>();
        }
        if (list.size() < 100 && n(j) && !o(list, j)) {
            list.addAll(j);
        }
        Calendar instance = Calendar.getInstance();
        instance.add(5, -30);
        long timeInMillis = instance.getTimeInMillis();
        Iterator<SmartLog> it = list.iterator();
        while (it.hasNext()) {
            if (Long.parseLong(it.next().getTimestamp()) * 1000 < timeInMillis) {
                it.remove();
            }
        }
        s(list);
        t(list);
        this.f11416c.postValue(list);
    }

    public void f() {
        this.f11415b.G().y();
    }

    public SingleLiveEvent<Boolean> g() {
        return this.f11415b.Y();
    }

    public SingleLiveEvent<List<SmartLog>> h() {
        return this.f11416c;
    }

    public void i(Integer num) {
        this.f11415b.g0(null, num).F0();
    }

    public List<SmartLog> j() {
        if (this.a.c() == null || this.a.c().getCloudUserName() == null) {
            return new ArrayList();
        }
        List<SmartLog> c2 = b.d.w.d.a.c(b.d.w.h.a.g(this.a.c().getCloudUserName()), "smart_log_cache_list", "smart_log_cache_list", SmartLog.class);
        if (c2 != null && !c2.isEmpty()) {
            s(c2);
        }
        return c2;
    }

    public Integer k() {
        List<SmartLog> j = j();
        if (n(j)) {
            return Integer.valueOf(Integer.parseInt(j.get(j.size() - 1).getTimestamp()));
        }
        return 0;
    }

    public void l(Integer num) {
        this.f11415b.h0(num, null).F0();
    }

    public Integer m() {
        List<SmartLog> j = j();
        if (n(j)) {
            return Integer.valueOf(Integer.parseInt(j.get(0).getTimestamp()));
        }
        return 0;
    }

    public void t(List<SmartLog> list) {
        if (this.a.c() != null && this.a.c().getCloudUserName() != null) {
            b.d.w.d.a.l(b.d.w.h.a.g(this.a.c().getCloudUserName()), list, "smart_log_cache_list", "smart_log_cache_list");
        }
    }
}
