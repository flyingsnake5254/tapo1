package com.tplink.iot.view.smart.actionsetup.taskdevice;

import android.os.Bundle;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.tplink.iot.cloud.bean.smart.common.SmartThingAction;
import com.tplink.iot.devicecommon.view.IoTMVVMBaseFragment;
import com.tplink.iot.viewmodel.iotplug.factory.IoTViewModelFactory;
import com.tplink.iot.viewmodel.ipcamera.factory.CameraViewModelFactory;
import com.tplink.iot.viewmodel.smart.taskdevice.DeviceControlBaseViewModel;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import java.util.HashMap;
import kotlin.f;
import kotlin.i;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

/* compiled from: DeviceControlBaseFragment.kt */
/* loaded from: classes2.dex */
public abstract class DeviceControlBaseFragment<VDB extends ViewDataBinding> extends IoTMVVMBaseFragment<VDB> {
    private final f p1;
    private SmartThingAction p2;
    private HashMap p3;

    /* compiled from: DeviceControlBaseFragment.kt */
    /* loaded from: classes2.dex */
    static final class a extends Lambda implements kotlin.jvm.b.a<DeviceControlBaseViewModel> {
        a() {
            super(0);
        }

        /* renamed from: a */
        public final DeviceControlBaseViewModel invoke() {
            BaseALIoTDevice<?> W0;
            DeviceControlContainerFragment V0 = DeviceControlBaseFragment.this.V0();
            if (V0 == null || (W0 = V0.W0()) == null || !W0.isCamera()) {
                DeviceControlBaseFragment deviceControlBaseFragment = DeviceControlBaseFragment.this;
                ViewModel viewModel = new ViewModelProvider(deviceControlBaseFragment, new IoTViewModelFactory(deviceControlBaseFragment, deviceControlBaseFragment.K0())).get(DeviceControlBaseViewModel.class);
                j.d(viewModel, "ViewModelProvider(this, …).get<VM>(VM::class.java)");
                return (DeviceControlBaseViewModel) ((AndroidViewModel) viewModel);
            }
            DeviceControlBaseFragment deviceControlBaseFragment2 = DeviceControlBaseFragment.this;
            ViewModel viewModel2 = new ViewModelProvider(deviceControlBaseFragment2, new CameraViewModelFactory(deviceControlBaseFragment2, deviceControlBaseFragment2.K0())).get(DeviceControlBaseViewModel.class);
            j.d(viewModel2, "ViewModelProvider(this, …MD5)).get(VM::class.java)");
            return (DeviceControlBaseViewModel) ((AndroidViewModel) viewModel2);
        }
    }

    public DeviceControlBaseFragment() {
        f b2;
        b2 = i.b(new a());
        this.p1 = b2;
    }

    @Override // com.tplink.iot.devicecommon.view.IoTMVVMBaseFragment
    public void H0() {
        HashMap hashMap = this.p3;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public abstract void T0(SmartThingAction smartThingAction);

    /* JADX INFO: Access modifiers changed from: protected */
    public final DeviceControlBaseViewModel U0() {
        return (DeviceControlBaseViewModel) this.p1.getValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final DeviceControlContainerFragment V0() {
        Fragment parentFragment = getParentFragment();
        if (!(parentFragment instanceof DeviceControlContainerFragment)) {
            parentFragment = null;
        }
        return (DeviceControlContainerFragment) parentFragment;
    }

    protected abstract void W0(SmartThingAction smartThingAction);

    public final void X0(SmartThingAction smartThingAction) {
        this.p2 = smartThingAction;
    }

    @Override // com.tplink.iot.base.BaseFragment, com.tplink.iot.i.a
    public boolean d() {
        return false;
    }

    @Override // com.tplink.iot.devicecommon.view.IoTMVVMBaseFragment, com.tplink.iot.base.BaseFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        H0();
    }

    @Override // com.tplink.iot.devicecommon.view.IoTMVVMBaseFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View view, Bundle bundle) {
        j.e(view, "view");
        super.onViewCreated(view, bundle);
        W0(this.p2);
    }
}
