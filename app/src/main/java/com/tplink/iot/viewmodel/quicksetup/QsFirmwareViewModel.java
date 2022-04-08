package com.tplink.iot.viewmodel.quicksetup;

import android.annotation.SuppressLint;
import android.app.Application;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.tplink.cloud.bean.firmware.params.FirmwareInfoParams;
import com.tplink.cloud.bean.firmware.result.FirmwareListResult;
import com.tplink.iot.cloud.bean.thing.common.ThingFirmware;
import com.tplink.libtpmediastatistics.SSLClient;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.IoTNetwork.ThingContext;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.IoTDataWrapper;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.LocalIoTBaseDevice;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.result.AutoUpdateBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.result.ComponentBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.quicksetup.params.QuickSetupDeviceInfoBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.quicksetup.result.FwDownloadStatus;
import com.tplink.libtpnetwork.IoTNetwork.repository.QuickSetupRepository;
import com.tplink.libtpnetwork.Utils.x;
import com.tplink.libtpnetwork.enumerate.EnumIoTDeviceState;
import io.reactivex.g0.j;
import io.reactivex.q;
import io.reactivex.t;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public class QsFirmwareViewModel extends AndroidViewModel {
    private QuickSetupRepository a;

    /* renamed from: c  reason: collision with root package name */
    private MutableLiveData<i<ThingFirmware>> f11182c = new MutableLiveData<>();

    /* renamed from: d  reason: collision with root package name */
    private MutableLiveData<FwDownloadStatus> f11183d = new MutableLiveData<>();

    /* renamed from: b  reason: collision with root package name */
    private TPIoTClientManager f11181b = (TPIoTClientManager) b.d.b.f.b.a(b.d.s.a.a.f(), TPIoTClientManager.class);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements io.reactivex.g0.g<IoTDataWrapper<ThingFirmware>> {
        a() {
        }

        /* renamed from: a */
        public void accept(IoTDataWrapper<ThingFirmware> ioTDataWrapper) throws Exception {
            if (ioTDataWrapper == null || ioTDataWrapper.getData() == null) {
                b.d.w.c.a.d("getFirmwareLatestInfoAndDeviceInfo get fw失败或没有新固件");
                QsFirmwareViewModel.this.f11182c.postValue(new i(1, null));
                return;
            }
            b.d.w.c.a.d("getFirmwareLatestInfoAndDeviceInfo get fw成功");
            QsFirmwareViewModel.this.f11182c.postValue(new i(0, ioTDataWrapper.getData()));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class b implements j<IoTDataWrapper<LocalIoTBaseDevice>, t<IoTDataWrapper<ThingFirmware>>> {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ QuickSetupDeviceInfoBean f11185c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ int f11186d;

        b(QuickSetupDeviceInfoBean quickSetupDeviceInfoBean, int i) {
            this.f11185c = quickSetupDeviceInfoBean;
            this.f11186d = i;
        }

        /* renamed from: a */
        public t<IoTDataWrapper<ThingFirmware>> apply(IoTDataWrapper<LocalIoTBaseDevice> ioTDataWrapper) throws Exception {
            if (ioTDataWrapper == null || ioTDataWrapper.getData() == null) {
                b.d.w.c.a.d("getFirmwareLatestInfoAndDeviceInfo get Device Info失败");
                return q.f0(new IoTDataWrapper());
            }
            b.d.w.c.a.d("getFirmwareLatestInfoAndDeviceInfo get Device Info成功");
            LocalIoTBaseDevice data = ioTDataWrapper.getData();
            QuickSetupDeviceInfoBean quickSetupDeviceInfoBean = this.f11185c;
            if (quickSetupDeviceInfoBean != null) {
                QsFirmwareViewModel.this.y(quickSetupDeviceInfoBean, this.f11186d);
            }
            return QsFirmwareViewModel.this.m(data);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class c implements j<FirmwareListResult, t<IoTDataWrapper<ThingFirmware>>> {
        c() {
        }

        /* renamed from: a */
        public t<IoTDataWrapper<ThingFirmware>> apply(FirmwareListResult firmwareListResult) throws Exception {
            if (firmwareListResult == null || firmwareListResult.getFwList() == null || firmwareListResult.getFwList().isEmpty()) {
                return q.f0(new IoTDataWrapper());
            }
            return QsFirmwareViewModel.this.a.r5();
        }
    }

    /* loaded from: classes3.dex */
    class d implements io.reactivex.g0.g<Throwable> {
        d() {
        }

        /* renamed from: a */
        public void accept(Throwable th) throws Exception {
            QsFirmwareViewModel.this.f11183d.postValue(new FwDownloadStatus(3));
        }
    }

    /* loaded from: classes3.dex */
    class e implements io.reactivex.g0.g<FwDownloadStatus> {
        e() {
        }

        /* renamed from: a */
        public void accept(FwDownloadStatus fwDownloadStatus) throws Exception {
            QsFirmwareViewModel.this.w(fwDownloadStatus);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class f implements io.reactivex.g0.g<Long> {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ FwDownloadStatus f11191c;

        f(FwDownloadStatus fwDownloadStatus) {
            this.f11191c = fwDownloadStatus;
        }

        /* renamed from: a */
        public void accept(Long l) throws Exception {
            this.f11191c.setErrorCode(6);
            QsFirmwareViewModel.this.f11183d.postValue(this.f11191c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class g implements io.reactivex.g0.c<IoTDataWrapper<LocalIoTBaseDevice>, IoTDataWrapper<List<ComponentBean>>, IoTDataWrapper<LocalIoTBaseDevice>> {
        g() {
        }

        /* renamed from: a */
        public IoTDataWrapper<LocalIoTBaseDevice> apply(IoTDataWrapper<LocalIoTBaseDevice> ioTDataWrapper, IoTDataWrapper<List<ComponentBean>> ioTDataWrapper2) throws Exception {
            if (ioTDataWrapper == null || ioTDataWrapper.getData() == null || ioTDataWrapper2 == null || ioTDataWrapper2.getData() == null) {
                LocalIoTBaseDevice localIoTBaseDevice = null;
                if (ioTDataWrapper != null) {
                    localIoTBaseDevice = ioTDataWrapper.getData();
                }
                if (!(QsFirmwareViewModel.this.a.b() == null || QsFirmwareViewModel.this.a.b().getIoTDevice() == null)) {
                    QsFirmwareViewModel.this.a.b().getIoTDevice().setLocalIoTDevice(localIoTBaseDevice);
                    QsFirmwareViewModel.this.a.b().getIoTDevice().setDeviceState(EnumIoTDeviceState.OFFLINE);
                    QsFirmwareViewModel.this.f11181b.L3();
                }
            } else {
                LocalIoTBaseDevice data = ioTDataWrapper.getData();
                if (data != null) {
                    data.setComponents(ioTDataWrapper2.getData());
                }
                if (!(QsFirmwareViewModel.this.a.b() == null || QsFirmwareViewModel.this.a.b().getIoTDevice() == null)) {
                    QsFirmwareViewModel.this.a.b().getIoTDevice().updateLocalIoTDevice(data);
                    QsFirmwareViewModel.this.f11181b.L3();
                }
            }
            return ioTDataWrapper;
        }
    }

    public QsFirmwareViewModel(@NonNull Application application, ThingContext thingContext) {
        super(application);
        this.a = (QuickSetupRepository) com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.a(thingContext, QuickSetupRepository.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public q<IoTDataWrapper<ThingFirmware>> m(LocalIoTBaseDevice localIoTBaseDevice) {
        FirmwareInfoParams firmwareInfoParams = new FirmwareInfoParams();
        firmwareInfoParams.setDeviceId(localIoTBaseDevice.getDeviceId());
        firmwareInfoParams.setFwId(localIoTBaseDevice.getFwId());
        firmwareInfoParams.setHwId(localIoTBaseDevice.getHwId());
        firmwareInfoParams.setOemId(localIoTBaseDevice.getOemId());
        firmwareInfoParams.setDevFwCurrentVer(v(localIoTBaseDevice.getFwVer()));
        firmwareInfoParams.setLocale(x.d(Locale.getDefault()));
        return this.f11181b.P1(firmwareInfoParams).T0(10L, TimeUnit.SECONDS).q0(new FirmwareListResult()).N(new c());
    }

    private q<IoTDataWrapper<LocalIoTBaseDevice>> n() {
        return q.f1(this.a.q5(), this.a.k5(), new g());
    }

    private String v(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        int indexOf = str.indexOf(SSLClient.WHITE_SPACE);
        if (indexOf <= 0) {
            return str;
        }
        try {
            return str.substring(0, indexOf);
        } catch (Exception unused) {
            return str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"CheckResult"})
    public void w(FwDownloadStatus fwDownloadStatus) {
        this.f11183d.postValue(fwDownloadStatus);
        if (fwDownloadStatus != null && fwDownloadStatus.getErrorCode() == 5) {
            int installTime = fwDownloadStatus.getInstallTime();
            if (installTime > 0) {
                q.W0(installTime, TimeUnit.SECONDS).G0(new f(fwDownloadStatus));
                return;
            }
            fwDownloadStatus.setErrorCode(6);
            this.f11183d.postValue(fwDownloadStatus);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(QuickSetupDeviceInfoBean quickSetupDeviceInfoBean, int i) {
        this.a.y5(quickSetupDeviceInfoBean, i).y();
    }

    public String o(String str) {
        return this.f11181b.S1(str);
    }

    public String p(String str) {
        return this.f11181b.U1(str);
    }

    public String r(String str) {
        return this.f11181b.V1(str);
    }

    @SuppressLint({"CheckResult"})
    public void s(QuickSetupDeviceInfoBean quickSetupDeviceInfoBean, int i) {
        if (this.a == null) {
            b.d.w.c.a.d("getFirmwareLatestInfoAndDeviceInfo");
            this.f11182c.postValue(new i<>(1, null));
            return;
        }
        n().N(new b(quickSetupDeviceInfoBean, i)).G0(new a());
    }

    public MutableLiveData<FwDownloadStatus> t() {
        return this.f11183d;
    }

    public LiveData<i<ThingFirmware>> u() {
        return this.f11182c;
    }

    public void x(int i) {
        QuickSetupRepository quickSetupRepository = this.a;
        if (quickSetupRepository != null) {
            quickSetupRepository.S4(new AutoUpdateBean(true, i, 120)).y();
        }
    }

    public void z() {
        QuickSetupRepository quickSetupRepository = this.a;
        if (quickSetupRepository == null) {
            this.f11183d.postValue(new FwDownloadStatus(1));
        } else {
            quickSetupRepository.A5().E(new e()).C(new d()).F0();
        }
    }
}
