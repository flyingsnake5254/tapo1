package com.tplink.iot.viewmodel.iotplug.factory;

import android.app.Activity;
import android.app.Application;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.cameranetwork.TPBaseDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.bean.ALCameraDevice;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes2.dex */
public class TPBaseDeviceViewModelFactory extends ViewModelProvider.NewInstanceFactory {
    private Application a;

    /* renamed from: b  reason: collision with root package name */
    private TPBaseDeviceContext f10343b;

    public TPBaseDeviceViewModelFactory(@NonNull FragmentActivity fragmentActivity, String str) {
        this.a = a(fragmentActivity);
        if (TPIoTClientManager.I1(str) instanceof ALCameraDevice) {
            this.f10343b = TPIoTClientManager.K1(str);
        } else {
            this.f10343b = TPIoTClientManager.k2(str);
        }
    }

    private static Application a(Activity activity) {
        Application application = activity.getApplication();
        if (application != null) {
            return application;
        }
        throw new IllegalStateException("Your activity/fragment is not yet attached to Application. You can't request ViewModel before onCreate call.");
    }

    @Override // androidx.lifecycle.ViewModelProvider.NewInstanceFactory, androidx.lifecycle.ViewModelProvider.Factory
    @NonNull
    public <T extends ViewModel> T create(@NonNull Class<T> cls) {
        try {
            return cls.getConstructor(Application.class, TPBaseDeviceContext.class).newInstance(this.a, this.f10343b);
        } catch (IllegalAccessException e2) {
            throw new RuntimeException("Cannot create an instance of " + cls, e2);
        } catch (InstantiationException e3) {
            throw new RuntimeException("Cannot create an instance of " + cls, e3);
        } catch (NoSuchMethodException e4) {
            throw new RuntimeException("Cannot create an instance of " + cls, e4);
        } catch (InvocationTargetException e5) {
            throw new RuntimeException("Cannot create an instance of " + cls, e5);
        }
    }
}
