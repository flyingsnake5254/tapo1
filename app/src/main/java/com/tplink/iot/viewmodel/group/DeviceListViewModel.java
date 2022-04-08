package com.tplink.iot.viewmodel.group;

import android.annotation.SuppressLint;
import android.app.Application;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import com.tplink.iot.cloud.bean.group.common.GroupInfo;
import com.tplink.iot.cloud.exception.IoTCloudException;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.IoTNetwork.repository.GroupRepository;
import io.reactivex.g0.g;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class DeviceListViewModel extends AndroidViewModel {
    private TPIoTClientManager a;

    /* renamed from: b  reason: collision with root package name */
    private GroupRepository f10011b;

    /* renamed from: c  reason: collision with root package name */
    private MediatorLiveData<List<GroupInfo>> f10012c = new MediatorLiveData<>();

    /* renamed from: d  reason: collision with root package name */
    private MediatorLiveData<Boolean> f10013d = new MediatorLiveData<>();

    /* renamed from: e  reason: collision with root package name */
    private MediatorLiveData<Integer> f10014e = new MediatorLiveData<>();

    /* loaded from: classes2.dex */
    class a implements Observer<List<GroupInfo>> {
        a() {
        }

        /* renamed from: a */
        public void onChanged(List<GroupInfo> list) {
            DeviceListViewModel.this.f10012c.postValue(list);
        }
    }

    /* loaded from: classes2.dex */
    class b implements io.reactivex.g0.a {
        b() {
        }

        @Override // io.reactivex.g0.a
        public void run() throws Exception {
            DeviceListViewModel.this.f10013d.postValue(Boolean.TRUE);
        }
    }

    /* loaded from: classes2.dex */
    class c implements g<Throwable> {
        c() {
        }

        /* renamed from: a */
        public void accept(Throwable th) throws Exception {
            DeviceListViewModel.this.f10013d.postValue(Boolean.FALSE);
        }
    }

    /* loaded from: classes2.dex */
    class d implements io.reactivex.g0.a {
        d() {
        }

        @Override // io.reactivex.g0.a
        public void run() throws Exception {
            DeviceListViewModel.this.f10014e.postValue(0);
        }
    }

    /* loaded from: classes2.dex */
    class e implements g<Throwable> {
        e() {
        }

        /* renamed from: a */
        public void accept(Throwable th) throws Exception {
            if (!(th instanceof IoTCloudException) || ((IoTCloudException) th).getCode() != 15017) {
                DeviceListViewModel.this.f10014e.postValue(1);
            } else {
                DeviceListViewModel.this.f10014e.postValue(15017);
            }
        }
    }

    public DeviceListViewModel(@NonNull Application application) {
        super(application);
        com.tplink.cloud.context.b f2 = b.d.s.a.a.f();
        this.a = (TPIoTClientManager) b.d.b.f.b.a(f2, TPIoTClientManager.class);
        GroupRepository groupRepository = (GroupRepository) b.d.b.f.b.a(f2, GroupRepository.class);
        this.f10011b = groupRepository;
        this.f10012c.addSource(groupRepository.T(), new a());
    }

    private BaseALIoTDevice l(String str) {
        return this.a.Z1(b.d.w.h.a.g(str));
    }

    @SuppressLint({"CheckResult"})
    public void i(String str, List<String> list) {
        this.f10011b.E(str, list).A(new d(), new e());
    }

    public MediatorLiveData<Integer> j() {
        return this.f10014e;
    }

    public List<BaseALIoTDevice> k() {
        return this.a.C1().getValue();
    }

    public MediatorLiveData<Boolean> m() {
        return this.f10013d;
    }

    public int n(GroupInfo groupInfo) {
        BaseALIoTDevice Z1;
        if (groupInfo == null) {
            return 0;
        }
        ArrayList arrayList = new ArrayList();
        List<String> thingNames = groupInfo.getThingNames();
        if (thingNames != null) {
            for (String str : thingNames) {
                if (!TextUtils.isEmpty(str) && (Z1 = this.a.Z1(b.d.w.h.a.g(str))) != null) {
                    arrayList.add(Z1);
                }
            }
        }
        return arrayList.size();
    }

    public MediatorLiveData<List<GroupInfo>> o() {
        return this.f10012c;
    }

    public List<BaseALIoTDevice> p(List<String> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null && !list.isEmpty()) {
            for (String str : list) {
                BaseALIoTDevice l = l(str);
                if (l != null) {
                    arrayList.add(l);
                }
            }
        }
        return arrayList;
    }

    @SuppressLint({"CheckResult"})
    public void r(String str, List<String> list) {
        this.f10011b.L(str, list).A(new b(), new c());
    }
}
