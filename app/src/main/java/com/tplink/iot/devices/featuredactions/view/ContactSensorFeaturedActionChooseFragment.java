package com.tplink.iot.devices.featuredactions.view;

import androidx.navigation.fragment.FragmentKt;
import com.tplink.iot.R;
import com.tplink.iot.devices.featuredactions.view.base.AbstractFeaturedActionChooseFragment;
import java.util.HashMap;
import java.util.List;
import kotlin.collections.n;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.j;

/* compiled from: ContactSensorFeaturedActionFragments.kt */
/* loaded from: classes2.dex */
public final class ContactSensorFeaturedActionChooseFragment extends AbstractFeaturedActionChooseFragment {
    public static final a H3 = new a(null);
    private HashMap I3;

    /* compiled from: ContactSensorFeaturedActionFragments.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    @Override // com.tplink.iot.devices.featuredactions.view.base.AbstractFeaturedActionChooseFragment, com.tplink.iot.devicecommon.view.IoTMVVMBaseFragment
    public void H0() {
        HashMap hashMap = this.I3;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    @Override // com.tplink.iot.devices.featuredactions.view.base.AbstractFeaturedActionChooseFragment
    public List<com.tplink.iot.g.a.a.a> U0() {
        List<com.tplink.iot.g.a.a.a> g;
        g = n.g(T0("FA_LightWayWhenArrivingHome", R.string.scene_light_way_when_arriving_home_title), T0("FA_SecureDoorOrWindow", R.string.scene_secure_door_or_window_title));
        return g;
    }

    @Override // com.tplink.iot.devices.featuredactions.view.base.AbstractFeaturedActionChooseFragment, com.tplink.iot.devicecommon.view.IoTMVVMBaseFragment, com.tplink.iot.base.BaseFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        H0();
    }

    @Override // com.tplink.iot.devices.featuredactions.adapter.a
    public void q0(com.tplink.iot.g.a.a.a item) {
        j.e(item, "item");
        String a2 = item.a();
        int hashCode = a2.hashCode();
        if (hashCode != -1700897934) {
            if (hashCode != -507879236) {
                if (hashCode == 399091818 && a2.equals("FA_LightWayWhenArrivingHome")) {
                    FragmentKt.findNavController(this).navigate(R.id.action_contactSensorFeaturedActionChooseFragment_to_contactSensorFALightWayWhenArrivingHomeFragment, V0());
                }
            } else if (a2.equals("FA_SecureDoorOrWindow")) {
                FragmentKt.findNavController(this).navigate(R.id.action_contactSensorFeaturedActionChooseFragment_to_contactSensorFASecureDoorOrWindowFragment, V0());
            }
        } else if (a2.equals("FA_BuildSmartAlarm")) {
            FragmentKt.findNavController(this).navigate(R.id.action_contactSensorFeaturedActionChooseFragment_to_contactSensorFABuildSmartAlarmFragment, V0());
        }
    }
}
