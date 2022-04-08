package com.tplink.iot.viewmodel.smart;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.Observer;
import b.d.b.f.b;
import com.tplink.iot.cloud.bean.smart.common.SmartInfo;
import com.tplink.libtpnetwork.IoTNetwork.repository.SmartRepository;
import com.tplink.libtpnetwork.Utils.SingleLiveEvent;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class ShortcutResortViewModel extends AndroidViewModel {
    private SmartRepository a;

    /* renamed from: b  reason: collision with root package name */
    private SingleLiveEvent<List<SmartInfo>> f11409b = new SingleLiveEvent<>();

    /* loaded from: classes3.dex */
    class a implements Observer<List<SmartInfo>> {
        a() {
        }

        /* renamed from: a */
        public void onChanged(@Nullable List<SmartInfo> list) {
            ShortcutResortViewModel.this.h(list);
        }
    }

    public ShortcutResortViewModel(@NonNull Application application) {
        super(application);
        SmartRepository smartRepository = (SmartRepository) b.a(b.d.s.a.a.f(), SmartRepository.class);
        this.a = smartRepository;
        this.f11409b.addSource(smartRepository.P(), new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(List<SmartInfo> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (SmartInfo smartInfo : list) {
                if (!(smartInfo == null || smartInfo.getTriggerSetting() == null || !smartInfo.getTriggerSetting().isManual())) {
                    arrayList.add(smartInfo);
                }
            }
        }
        this.f11409b.postValue(arrayList);
    }

    public void g() {
        this.a.S().F0();
    }

    public SingleLiveEvent<List<SmartInfo>> i() {
        return this.f11409b;
    }

    public void j(List<SmartInfo> list) {
        this.a.D1(list);
    }
}
