package com.tplink.iot.viewmodel.iotbulb;

import android.app.Application;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tplink.cloud.bean.common.CloudResult;
import com.tplink.cloud.define.CloudException;
import com.tplink.iot.Utils.x0.o;
import com.tplink.iot.cloud.bean.group.common.GroupInfo;
import com.tplink.iot.cloud.bean.thing.common.ThingFirmware;
import com.tplink.iot.viewmodel.quicksetup.i;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.IoTNetwork.ThingContext;
import com.tplink.libtpnetwork.IoTNetwork.bean.bulb.DefaultStatesBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.bulb.IoTBulbDevice;
import com.tplink.libtpnetwork.IoTNetwork.bean.colorbulb.OnOffGraduallyBean;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.IoTNetwork.repository.BulbRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.GroupRepository;
import com.tplink.libtpnetwork.TPCloudNetwork.bean.familymanager.RoomBean;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.FamilyManagerRepository;
import com.tplink.libtpnetwork.Utils.SingleLiveEvent;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class BulbSettingViewModel extends AndroidViewModel {
    private BulbRepository a;

    /* renamed from: b  reason: collision with root package name */
    private TPIoTClientManager f10163b;

    /* renamed from: c  reason: collision with root package name */
    private GroupRepository f10164c;

    /* renamed from: d  reason: collision with root package name */
    private FamilyManagerRepository f10165d;

    /* renamed from: e  reason: collision with root package name */
    private MediatorLiveData<BaseALIoTDevice> f10166e = new MediatorLiveData<>();

    /* renamed from: f  reason: collision with root package name */
    private MediatorLiveData<IoTBulbDevice> f10167f = new MediatorLiveData<>();
    private MutableLiveData<i<CloudResult<Void>>> g = new MutableLiveData<>();
    private MutableLiveData<i<Void>> h = new MutableLiveData<>();
    private SingleLiveEvent<Boolean> i = new SingleLiveEvent<>();
    private MediatorLiveData<i<RoomBean>> j = new MediatorLiveData<>();
    private MediatorLiveData<List<GroupInfo>> k = new MediatorLiveData<>();

    /* loaded from: classes2.dex */
    class a implements Observer<List<BaseALIoTDevice>> {
        final /* synthetic */ ThingContext a;

        a(ThingContext thingContext) {
            this.a = thingContext;
        }

        /* renamed from: a */
        public void onChanged(@Nullable List<BaseALIoTDevice> list) {
            BulbSettingViewModel.this.f10166e.postValue(BulbSettingViewModel.this.m(this.a.getDeviceIdMD5(), list));
        }
    }

    /* loaded from: classes2.dex */
    class b implements Observer<IoTBulbDevice> {
        b() {
        }

        /* renamed from: a */
        public void onChanged(@Nullable IoTBulbDevice ioTBulbDevice) {
            BulbSettingViewModel.this.f10167f.postValue(ioTBulbDevice);
        }
    }

    /* loaded from: classes2.dex */
    class c implements Observer<List<GroupInfo>> {
        c() {
        }

        /* renamed from: a */
        public void onChanged(@Nullable List<GroupInfo> list) {
            BulbSettingViewModel.this.k.postValue(list);
        }
    }

    /* loaded from: classes2.dex */
    class d implements io.reactivex.g0.g<Throwable> {
        d() {
        }

        /* renamed from: a */
        public void accept(Throwable th) throws Exception {
            if (th instanceof CloudException) {
                BulbSettingViewModel.this.h.postValue(new i(((CloudException) th).getErrCode(), null));
            } else {
                BulbSettingViewModel.this.h.postValue(new i(1, null));
            }
        }
    }

    /* loaded from: classes2.dex */
    class e implements io.reactivex.g0.g<Boolean> {
        e() {
        }

        /* renamed from: a */
        public void accept(Boolean bool) throws Exception {
            BulbSettingViewModel.this.h.postValue(new i(0, null));
        }
    }

    /* loaded from: classes2.dex */
    class f implements io.reactivex.g0.g<Throwable> {
        f() {
        }

        /* renamed from: a */
        public void accept(Throwable th) throws Exception {
            if (th instanceof CloudException) {
                BulbSettingViewModel.this.g.postValue(new i(((CloudException) th).getErrCode(), null));
            } else {
                BulbSettingViewModel.this.g.postValue(new i(1, null));
            }
        }
    }

    /* loaded from: classes2.dex */
    class g implements io.reactivex.g0.a {
        g() {
        }

        @Override // io.reactivex.g0.a
        public void run() throws Exception {
            BulbSettingViewModel.this.g.postValue(new i(0, null));
        }
    }

    public BulbSettingViewModel(@NonNull Application application, ThingContext thingContext) {
        super(application);
        this.a = (BulbRepository) com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.a(thingContext, BulbRepository.class);
        this.f10163b = (TPIoTClientManager) b.d.b.f.b.a(thingContext.getAccountContext(), TPIoTClientManager.class);
        this.f10165d = (FamilyManagerRepository) b.d.b.f.b.a(thingContext.getAccountContext(), FamilyManagerRepository.class);
        this.f10164c = (GroupRepository) b.d.b.f.b.a(thingContext.getAccountContext(), GroupRepository.class);
        this.f10166e.addSource(this.f10163b.C1(), new a(thingContext));
        this.f10167f.addSource(this.a.r5(), new b());
        this.k.addSource(this.f10164c.T(), new c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public BaseALIoTDevice m(String str, List<BaseALIoTDevice> list) {
        if (list != null && !list.isEmpty()) {
            for (BaseALIoTDevice baseALIoTDevice : list) {
                if (baseALIoTDevice.getDeviceIdMD5().equals(str)) {
                    return baseALIoTDevice;
                }
            }
        }
        return null;
    }

    public void A() {
        this.a.p5().F0();
    }

    public LiveData<i<Void>> B() {
        return this.h;
    }

    public void C(List<Integer> list) {
        this.a.Y5(list).y();
    }

    public void D(DefaultStatesBean defaultStatesBean) {
        this.a.Z5(defaultStatesBean).y();
    }

    public void E(boolean z) {
        this.a.c6(new OnOffGraduallyBean(z)).F0();
    }

    public void F(String str) {
        o.u(this.f10166e.getValue());
        this.f10163b.n1(str).L0(io.reactivex.l0.a.c()).E(new e()).C(new d()).F0();
    }

    public void f(String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        this.f10163b.w(arrayList).i(new g()).j(new f()).y();
    }

    public LiveData<i<CloudResult<Void>>> n() {
        return this.g;
    }

    public LiveData<BaseALIoTDevice> o() {
        return this.f10166e;
    }

    public LiveData<List<Integer>> p() {
        return this.a.o5();
    }

    public LiveData<IoTBulbDevice> r() {
        return this.f10167f;
    }

    public int s(List<GroupInfo> list, String str) {
        int i = 0;
        if (!list.isEmpty() && !TextUtils.isEmpty(str)) {
            BaseALIoTDevice Z1 = this.f10163b.Z1(str);
            if (Z1 == null) {
                return 0;
            }
            String deviceId = Z1.getDeviceId();
            if (TextUtils.isEmpty(deviceId)) {
                return 0;
            }
            for (GroupInfo groupInfo : list) {
                List<String> thingNames = groupInfo.getThingNames();
                if (thingNames != null && !thingNames.isEmpty() && thingNames.contains(deviceId)) {
                    i++;
                }
            }
        }
        return i;
    }

    public String t() {
        return (this.a.b() == null || this.a.b().getIoTDevice() == null) ? "" : this.a.b().getIoTDevice().getDeviceName();
    }

    public void u() {
        this.a.p1().F0();
    }

    public void v() {
        this.a.v1().F0();
    }

    public LiveData<ThingFirmware> w() {
        return this.a.w1();
    }

    public MediatorLiveData<List<GroupInfo>> x() {
        return this.k;
    }

    public void y() {
        this.a.x5().F0();
    }

    public LiveData<OnOffGraduallyBean> z() {
        return this.a.y5();
    }
}
