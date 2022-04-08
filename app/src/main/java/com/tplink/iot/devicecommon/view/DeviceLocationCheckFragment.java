package com.tplink.iot.devicecommon.view;

import androidx.appcompat.app.AppCompatActivity;
import com.tplink.iot.base.BaseLocationFragment;
import java.util.HashMap;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.j;

/* compiled from: DeviceLocationCheckFragment.kt */
/* loaded from: classes2.dex */
public final class DeviceLocationCheckFragment extends BaseLocationFragment {
    public static final a x = new a(null);
    private b y;
    private HashMap z;

    /* compiled from: DeviceLocationCheckFragment.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public final DeviceLocationCheckFragment a(b callback) {
            j.e(callback, "callback");
            DeviceLocationCheckFragment deviceLocationCheckFragment = new DeviceLocationCheckFragment();
            deviceLocationCheckFragment.T0(callback);
            return deviceLocationCheckFragment;
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    /* compiled from: DeviceLocationCheckFragment.kt */
    /* loaded from: classes2.dex */
    public interface b {
        void X();
    }

    @Override // com.tplink.iot.base.BaseLocationFragment
    public void K0() {
        b bVar = this.y;
        if (bVar != null) {
            bVar.X();
        }
    }

    public void R0() {
        HashMap hashMap = this.z;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public final void S0(AppCompatActivity activity) {
        j.e(activity, "activity");
        if (activity.getSupportFragmentManager().findFragmentByTag("DeviceLocationCheckFragment") == null) {
            activity.getSupportFragmentManager().beginTransaction().add(this, "DeviceLocationCheckFragment").commitAllowingStateLoss();
        }
    }

    public final void T0(b callback) {
        j.e(callback, "callback");
        this.y = callback;
    }

    @Override // com.tplink.iot.base.BaseFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        R0();
    }
}
