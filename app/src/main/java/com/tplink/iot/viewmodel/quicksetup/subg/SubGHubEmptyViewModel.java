package com.tplink.iot.viewmodel.quicksetup.subg;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import b.d.b.f.b;
import b.d.s.a.a;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class SubGHubEmptyViewModel extends SubGBaseViewModel {
    private TPIoTClientManager a;

    /* renamed from: b  reason: collision with root package name */
    private MediatorLiveData<List<BaseALIoTDevice>> f11329b = new MediatorLiveData<>();

    public SubGHubEmptyViewModel(@NonNull Application application) {
        super(application);
        TPIoTClientManager tPIoTClientManager = (TPIoTClientManager) b.a(a.f(), TPIoTClientManager.class);
        this.a = tPIoTClientManager;
        this.f11329b.addSource(tPIoTClientManager.C1(), new Observer() { // from class: com.tplink.iot.viewmodel.quicksetup.subg.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SubGHubEmptyViewModel.this.h((List) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public /* synthetic */ void h(List list) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            BaseALIoTDevice baseALIoTDevice = (BaseALIoTDevice) it.next();
            if (baseALIoTDevice.isHub()) {
                arrayList.add(baseALIoTDevice);
            }
        }
        this.f11329b.postValue(arrayList);
    }

    public LiveData<List<BaseALIoTDevice>> f() {
        return this.f11329b;
    }
}
