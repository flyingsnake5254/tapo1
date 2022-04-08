package com.tplink.iot.viewmodel.cloudconnect;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.tplink.iot.viewmodel.quicksetup.i;
import com.tplink.libtpnetwork.IoTNetwork.ThingContext;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.result.CloudConnectStateResult;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.result.CloudConnectStatus;
import com.tplink.libtpnetwork.IoTNetwork.common.ALIoTDevice;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.IoTNetwork.repository.AbstractThingRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.BulbRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.LightStripRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.PlugRepository;
import io.reactivex.g0.g;

/* loaded from: classes2.dex */
public class CloudConnectViewModel extends AndroidViewModel {
    private AbstractThingRepository a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private BaseALIoTDevice f9890b;

    /* renamed from: c  reason: collision with root package name */
    private MutableLiveData<i<CloudConnectStateResult>> f9891c = new MutableLiveData<>();

    /* renamed from: d  reason: collision with root package name */
    private MutableLiveData<CloudConnectStatus> f9892d = new MutableLiveData<>();

    /* renamed from: e  reason: collision with root package name */
    private MutableLiveData<CloudConnectStatus> f9893e = new MutableLiveData<>();

    /* renamed from: f  reason: collision with root package name */
    private io.reactivex.e0.c f9894f;
    private io.reactivex.e0.c g;

    /* loaded from: classes2.dex */
    class a implements g<Throwable> {
        a() {
        }

        /* renamed from: a */
        public void accept(Throwable th) throws Exception {
            CloudConnectViewModel.this.f9892d.postValue(new CloudConnectStatus(1, null));
        }
    }

    /* loaded from: classes2.dex */
    class b implements g<CloudConnectStatus> {
        b() {
        }

        /* renamed from: a */
        public void accept(CloudConnectStatus cloudConnectStatus) throws Exception {
            CloudConnectViewModel.this.f9892d.postValue(cloudConnectStatus);
        }
    }

    /* loaded from: classes2.dex */
    class c implements g<Throwable> {
        c() {
        }

        /* renamed from: a */
        public void accept(Throwable th) throws Exception {
            CloudConnectViewModel.this.f9891c.postValue(new i(1, null));
        }
    }

    /* loaded from: classes2.dex */
    class d implements g<CloudConnectStateResult> {
        d() {
        }

        /* renamed from: a */
        public void accept(CloudConnectStateResult cloudConnectStateResult) throws Exception {
            CloudConnectViewModel.this.f9891c.postValue(new i(0, cloudConnectStateResult));
        }
    }

    /* loaded from: classes2.dex */
    class e implements g<Throwable> {
        e() {
        }

        /* renamed from: a */
        public void accept(Throwable th) throws Exception {
            CloudConnectViewModel.this.f9893e.postValue(new CloudConnectStatus(1, null));
        }
    }

    /* loaded from: classes2.dex */
    class f implements g<CloudConnectStatus> {
        f() {
        }

        /* renamed from: a */
        public void accept(CloudConnectStatus cloudConnectStatus) throws Exception {
            CloudConnectViewModel.this.f9893e.postValue(cloudConnectStatus);
        }
    }

    public CloudConnectViewModel(@NonNull Application application, ThingContext thingContext) {
        super(application);
        ALIoTDevice ioTDevice = thingContext.getIoTDevice();
        this.f9890b = ioTDevice;
        if (ioTDevice == null || !ioTDevice.isBulb()) {
            this.a = (AbstractThingRepository) com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.a(thingContext, PlugRepository.class);
        } else if (this.f9890b.isLightStrip()) {
            this.a = (AbstractThingRepository) com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.a(thingContext, LightStripRepository.class);
        } else {
            this.a = (AbstractThingRepository) com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.a(thingContext, BulbRepository.class);
        }
    }

    @Nullable
    public BaseALIoTDevice i() {
        return this.f9890b;
    }

    public LiveData<i<CloudConnectStateResult>> j() {
        return this.f9891c;
    }

    public void k() {
        this.a.b1().E(new d()).C(new c()).F0();
    }

    public void l() {
        this.g = this.a.e1().E(new f()).C(new e()).F0();
    }

    public LiveData<CloudConnectStatus> m() {
        return this.f9893e;
    }

    public LiveData<CloudConnectStatus> n() {
        return this.f9892d;
    }

    public void o() {
        this.f9894f = this.a.T4().E(new b()).C(new a()).F0();
    }

    public void p() {
        io.reactivex.e0.c cVar = this.g;
        if (cVar != null) {
            cVar.dispose();
            this.g = null;
        }
    }

    public void r() {
        io.reactivex.e0.c cVar = this.f9894f;
        if (cVar != null) {
            cVar.dispose();
            this.f9894f = null;
        }
    }
}
