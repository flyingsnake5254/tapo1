package com.tplink.iot.viewmodel.firmware;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import b.d.b.f.b;
import com.tplink.iot.model.firmware.EnumIoTSeriesState;
import com.tplink.iot.model.firmware.FirmwareUpdateManager;
import com.tplink.iot.model.firmware.IotSeriesBean;
import java.util.List;

/* loaded from: classes2.dex */
public class FirmwareSlideDetailViewModel extends AndroidViewModel {
    private FirmwareUpdateManager a;

    /* renamed from: b  reason: collision with root package name */
    private String f10000b;

    /* renamed from: c  reason: collision with root package name */
    private MediatorLiveData<IotSeriesBean> f10001c = new MediatorLiveData<>();

    /* loaded from: classes2.dex */
    class a implements Observer<List<IotSeriesBean>> {
        a() {
        }

        /* renamed from: a */
        public void onChanged(@Nullable List<IotSeriesBean> list) {
            IotSeriesBean o = FirmwareSlideDetailViewModel.this.a.o(FirmwareSlideDetailViewModel.this.f10000b);
            if (o != null) {
                FirmwareSlideDetailViewModel.this.f10001c.postValue(o);
            }
        }
    }

    public FirmwareSlideDetailViewModel(@NonNull Application application, String str) {
        super(application);
        this.f10000b = str;
        FirmwareUpdateManager firmwareUpdateManager = (FirmwareUpdateManager) b.a(b.d.s.a.a.f(), FirmwareUpdateManager.class);
        this.a = firmwareUpdateManager;
        this.f10001c.addSource(firmwareUpdateManager.p(), new a());
    }

    public MediatorLiveData<IotSeriesBean> i() {
        return this.f10001c;
    }

    public void j() {
        IotSeriesBean o = this.a.o(this.f10000b);
        if (o != null) {
            EnumIoTSeriesState currentState = o.getCurrentState();
            EnumIoTSeriesState enumIoTSeriesState = EnumIoTSeriesState.IDLE;
            if (currentState == enumIoTSeriesState || (o.getCurrentState() == EnumIoTSeriesState.SUCCESS && o.getSuccessCount() < o.getIoTDeviceStateList().size())) {
                this.a.m0(o.getId(), o.getCurrentState() != enumIoTSeriesState, true);
            }
        }
    }
}
