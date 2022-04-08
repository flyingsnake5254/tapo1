package com.tplink.iot.viewmodel.ipcamera.onboardingv2;

import android.annotation.SuppressLint;
import android.app.Application;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.databinding.ObservableField;
import b.d.b.f.b;
import b.d.s.a.a;
import com.tplink.iot.cloud.bean.family.common.RoomInfo;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.FamilyManagerRepository;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class CameraSaveSettingViewModel extends OnBoardingFragmentViewModel {
    public final ObservableField<String> a = new ObservableField<>("");

    /* renamed from: b  reason: collision with root package name */
    private final TPIoTClientManager f10417b = (TPIoTClientManager) b.a(a.f(), TPIoTClientManager.class);

    /* renamed from: c  reason: collision with root package name */
    private final FamilyManagerRepository f10418c = (FamilyManagerRepository) b.a(a.f(), FamilyManagerRepository.class);

    public CameraSaveSettingViewModel(@NonNull Application application) {
        super(application);
    }

    private List<RoomInfo> f() {
        if (this.f10417b.Q1() == null) {
            return null;
        }
        return this.f10417b.Q1().getRooms();
    }

    @SuppressLint({"CheckResult"})
    private void g(String str, String str2, String str3) {
        String str4;
        boolean z;
        Iterator<RoomInfo> it = f().iterator();
        while (true) {
            if (!it.hasNext()) {
                str4 = null;
                z = true;
                break;
            }
            RoomInfo next = it.next();
            if (TextUtils.equals(next.getName(), str2)) {
                str4 = next.getId();
                z = false;
                break;
            }
        }
        this.f10418c.b1(str3, str, str4, str2, z, true).y();
    }

    @SuppressLint({"CheckResult"})
    public void h(String str, String str2) {
        String id = this.f10417b.Q1() != null ? this.f10417b.Q1().getId() : null;
        if (TextUtils.isEmpty(id) || TextUtils.isEmpty(str)) {
            b.d.w.c.a.d("setDeviceFamilyAndRoom2Cloud return");
        } else if (!TextUtils.isEmpty(str2)) {
            b.d.w.c.a.d("setDeviceFamilyAndRoom2Cloud set room");
            g(id, str, str2);
        }
    }
}
