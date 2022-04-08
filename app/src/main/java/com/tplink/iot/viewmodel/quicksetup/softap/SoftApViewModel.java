package com.tplink.iot.viewmodel.quicksetup.softap;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a;

/* loaded from: classes3.dex */
public class SoftApViewModel extends SoftApBaseViewModel {
    private MutableLiveData<a<Integer>> a = new MutableLiveData<>();

    public SoftApViewModel(@NonNull Application application) {
        super(application);
    }
}
