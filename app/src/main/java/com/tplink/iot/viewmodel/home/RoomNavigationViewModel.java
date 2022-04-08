package com.tplink.iot.viewmodel.home;

import android.annotation.SuppressLint;
import android.app.Application;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import com.tplink.iot.cloud.bean.family.common.FamilyInfo;
import com.tplink.iot.cloud.bean.family.common.RoomInfo;
import com.tplink.libtpnetwork.TPCloudNetwork.bean.ThingDevice;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.FamilyManagerRepository;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.ThingCloudRepository;
import io.reactivex.g0.g;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class RoomNavigationViewModel extends AndroidViewModel {
    private FamilyManagerRepository a;

    /* renamed from: c  reason: collision with root package name */
    private FamilyInfo f10091c;

    /* renamed from: b  reason: collision with root package name */
    private List<ThingDevice> f10090b = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    private MediatorLiveData<Boolean> f10092d = new MediatorLiveData<>();

    /* renamed from: e  reason: collision with root package name */
    private MediatorLiveData<List<com.tplink.iot.model.home.a>> f10093e = new MediatorLiveData<>();

    /* loaded from: classes2.dex */
    class a implements Observer<List<ThingDevice>> {
        a() {
        }

        /* renamed from: a */
        public void onChanged(@Nullable List<ThingDevice> list) {
            RoomNavigationViewModel.this.f10090b.clear();
            if (list != null && !list.isEmpty()) {
                RoomNavigationViewModel.this.f10090b.addAll(list);
            }
            RoomNavigationViewModel.this.k();
        }
    }

    /* loaded from: classes2.dex */
    class b implements io.reactivex.g0.a {
        b() {
        }

        @Override // io.reactivex.g0.a
        public void run() throws Exception {
            RoomNavigationViewModel.this.f10092d.postValue(Boolean.TRUE);
        }
    }

    /* loaded from: classes2.dex */
    class c implements g<Throwable> {
        c() {
        }

        /* renamed from: a */
        public void accept(Throwable th) throws Exception {
            RoomNavigationViewModel.this.f10092d.postValue(Boolean.FALSE);
        }
    }

    public RoomNavigationViewModel(@NonNull Application application) {
        super(application);
        b.d.b.d.b.b c2 = b.d.b.f.b.c(b.d.s.a.a.f());
        this.a = (FamilyManagerRepository) c2.a(FamilyManagerRepository.class);
        this.f10091c = this.a.X();
        this.f10093e.addSource(((ThingCloudRepository) c2.a(ThingCloudRepository.class)).g0(), new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        FamilyInfo familyInfo = this.f10091c;
        if (familyInfo == null || familyInfo.getId() == null || this.f10091c.getRooms() == null || this.f10091c.getRooms().isEmpty()) {
            this.f10093e.postValue(new ArrayList());
            return;
        }
        String id = this.f10091c.getId();
        ArrayList<ThingDevice> arrayList = new ArrayList();
        for (ThingDevice thingDevice : this.f10090b) {
            if (id.equals(thingDevice.getFamilyId())) {
                arrayList.add(thingDevice);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (RoomInfo roomInfo : this.f10091c.getRooms()) {
            String id2 = roomInfo.getId();
            int i = 0;
            for (ThingDevice thingDevice2 : arrayList) {
                if (id2 != null && id2.equals(thingDevice2.getRoomId())) {
                    i++;
                }
            }
            arrayList2.add(new com.tplink.iot.model.home.a(roomInfo.getId(), roomInfo.getName(), i));
        }
        this.f10093e.postValue(arrayList2);
    }

    public MediatorLiveData<List<com.tplink.iot.model.home.a>> i() {
        return this.f10093e;
    }

    public MediatorLiveData<Boolean> j() {
        return this.f10092d;
    }

    @SuppressLint({"CheckResult"})
    public void l(List<String> list) {
        FamilyInfo familyInfo = this.f10091c;
        if (familyInfo == null || TextUtils.isEmpty(familyInfo.getId())) {
            this.f10092d.postValue(Boolean.FALSE);
            return;
        }
        this.a.p1(this.f10091c.getId(), list).A(new b(), new c());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
    }
}
