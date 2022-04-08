package com.tplink.iot.viewmodel.ipcamera.factory;

import android.app.Activity;
import android.app.Application;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.cameranetwork.TPCameraDeviceContext;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes2.dex */
public class CameraViewModelFactory extends ViewModelProvider.NewInstanceFactory {
    private Application a;

    /* renamed from: b  reason: collision with root package name */
    private TPCameraDeviceContext f10380b;

    public CameraViewModelFactory(@NonNull FragmentActivity fragmentActivity, String str) {
        this.a = b(fragmentActivity);
        this.f10380b = TPIoTClientManager.K1(str);
    }

    private static Activity a(Fragment fragment) {
        FragmentActivity activity = fragment.getActivity();
        if (activity != null) {
            return activity;
        }
        throw new IllegalStateException("Can't create IoTViewModelFactory for detached fragment");
    }

    private static Application b(Activity activity) {
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
            return cls.getConstructor(Application.class, TPCameraDeviceContext.class).newInstance(this.a, this.f10380b);
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

    public CameraViewModelFactory(@NonNull Fragment fragment, String str) {
        this.a = b(a(fragment));
        this.f10380b = TPIoTClientManager.K1(str);
    }
}
