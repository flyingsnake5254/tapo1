package com.tplink.iot.view.quicksetup.switches.quicksetup;

import android.os.Bundle;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.R;
import com.tplink.iot.adapter.quicksetup.IoTIconAdapter;
import com.tplink.iot.adapter.quicksetup.e;
import com.tplink.iot.cloud.bean.family.common.RoomInfo;
import com.tplink.iot.databinding.ActivityQsPlugIconSelectIconBinding;
import com.tplink.iot.view.ipcamera.onboardingv2.z1;
import com.tplink.iot.view.quicksetup.switches.quicksetup.base.SwitchButton;
import com.tplink.iot.view.quicksetup.switches.quicksetup.base.SwitchQuickSetupBaseFragment;
import com.tplink.iot.viewmodel.quicksetup.subg.SwitchQuickSetupViewModel;
import com.tplink.libtpnetwork.enumerate.EnumDeviceType;
import com.tplink.libtpnetwork.enumerate.EnumSwitchAvatarType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.o;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.j;

/* compiled from: SwitchQuickSetupAvatarFragment.kt */
/* loaded from: classes2.dex */
public final class SwitchQuickSetupAvatarFragment extends SwitchQuickSetupBaseFragment<ActivityQsPlugIconSelectIconBinding> {
    public static final a p3 = new a(null);
    private final List<e> H3 = new ArrayList();
    private IoTIconAdapter I3;
    private HashMap J3;

    /* compiled from: SwitchQuickSetupAvatarFragment.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    private final int Q0() {
        String z = P0().z(L0());
        Iterator<e> it = this.H3.iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            } else if (j.a(it.next().a(), z)) {
                break;
            } else {
                i++;
            }
        }
        if (i != -1) {
            return i;
        }
        return 0;
    }

    private final void R0() {
        List<RoomInfo> s = O0().s();
        if (s == null || s.isEmpty()) {
            z1 N0 = N0();
            if (N0 != null) {
                N0.e0("SwitchQuickSetupLocationCustomFragment", null);
                return;
            }
            return;
        }
        z1 N02 = N0();
        if (N02 != null) {
            N02.e0("SwitchQuickSetupLocationSelectFragment", null);
        }
    }

    private final void S0() {
        int l;
        List<e> list = this.H3;
        List<String> s220AvatarNames = EnumSwitchAvatarType.getS220AvatarNames();
        j.d(s220AvatarNames, "EnumSwitchAvatarType.getS220AvatarNames()");
        l = o.l(s220AvatarNames, 10);
        ArrayList arrayList = new ArrayList(l);
        for (String str : s220AvatarNames) {
            arrayList.add(new e(str, false));
        }
        list.addAll(arrayList);
        this.H3.get(0).d(true);
    }

    private final void T0() {
        this.I3 = new IoTIconAdapter(this.H3, EnumDeviceType.SWITCH);
        RecyclerView recyclerView = K0().f6658d;
        j.d(recyclerView, "mBinding.iconList");
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        RecyclerView recyclerView2 = K0().f6658d;
        j.d(recyclerView2, "mBinding.iconList");
        recyclerView2.setAdapter(this.I3);
        IoTIconAdapter ioTIconAdapter = this.I3;
        if (ioTIconAdapter != null) {
            ioTIconAdapter.r(Q0());
        }
    }

    private final void U0() {
        String str;
        K0().f6657c.h();
        SwitchQuickSetupViewModel P0 = P0();
        SwitchButton L0 = L0();
        IoTIconAdapter ioTIconAdapter = this.I3;
        if (ioTIconAdapter == null || (str = ioTIconAdapter.o()) == null) {
            str = EnumSwitchAvatarType.SWITCH_S220.getName();
        }
        j.d(str, "mAvatarAdapter?.avatar ?…ype.SWITCH_S220.getName()");
        P0.M(L0, str);
        if (L0() == SwitchButton.FIRST) {
            z1 N0 = N0();
            if (N0 != null) {
                N0.e0("SwitchQuickSetupGuideFragment", SwitchQuickSetupBaseFragment.q.a(SwitchButton.SECOND));
                return;
            }
            return;
        }
        R0();
    }

    @Override // com.tplink.iot.view.quicksetup.switches.quicksetup.base.SwitchQuickSetupBaseFragment
    public void H0() {
        HashMap hashMap = this.J3;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    @Override // com.tplink.iot.view.quicksetup.switches.quicksetup.base.SwitchQuickSetupBaseFragment
    public int J0() {
        return R.layout.activity_qs_plug_icon_select_icon;
    }

    @Override // com.tplink.iot.view.ipcamera.base.g, android.view.View.OnClickListener
    public void onClick(View v) {
        j.e(v, "v");
        int id = v.getId();
        if (id == R.id.btn_bottom) {
            U0();
        } else if (id == R.id.img_back) {
            O0().E0(20002);
        }
    }

    @Override // com.tplink.iot.view.quicksetup.switches.quicksetup.base.SwitchQuickSetupBaseFragment, com.tplink.iot.base.BaseFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        H0();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        j.e(view, "view");
        ActivityQsPlugIconSelectIconBinding K0 = K0();
        K0.f6659f.setOnClickListener(this);
        K0.f6657c.setOnClickListener(this);
        K0.x.setText(R.string.switch_qs_avatar_title);
        S0();
        T0();
    }
}
