package com.tplink.iot.devices.featuredactions.view.base;

import android.content.Context;
import android.os.Bundle;
import com.tplink.iot.R;
import com.tplink.iot.databinding.FragmentAbstractFeaturedActionChooseBinding;
import com.tplink.iot.devicecommon.view.IoTMVVMBaseFragment;
import com.tplink.iot.devices.featuredactions.adapter.FeaturedActionChooseAdapter;
import java.util.HashMap;
import java.util.List;
import kotlin.f;
import kotlin.i;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

/* compiled from: AbstractFeaturedActionChooseFragment.kt */
/* loaded from: classes2.dex */
public abstract class AbstractFeaturedActionChooseFragment extends IoTMVVMBaseFragment<FragmentAbstractFeaturedActionChooseBinding> implements com.tplink.iot.devices.featuredactions.adapter.a {
    private final f p1;
    private String p2 = "";
    private HashMap p3;

    /* compiled from: AbstractFeaturedActionChooseFragment.kt */
    /* loaded from: classes2.dex */
    static final class a extends Lambda implements kotlin.jvm.b.a<Bundle> {
        a() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.b.a
        public final Bundle invoke() {
            return IoTMVVMBaseFragment.q.a(AbstractFeaturedActionChooseFragment.this.K0());
        }
    }

    public AbstractFeaturedActionChooseFragment() {
        f b2;
        b2 = i.b(new a());
        this.p1 = b2;
    }

    private final FeaturedActionChooseAdapter W0() {
        Context requireContext = requireContext();
        j.d(requireContext, "requireContext()");
        FeaturedActionChooseAdapter featuredActionChooseAdapter = new FeaturedActionChooseAdapter(requireContext, U0());
        featuredActionChooseAdapter.C(this);
        return featuredActionChooseAdapter;
    }

    @Override // com.tplink.iot.devicecommon.view.IoTMVVMBaseFragment
    public void H0() {
        HashMap hashMap = this.p3;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    @Override // com.tplink.iot.devicecommon.view.IoTMVVMBaseFragment
    public int I0() {
        return R.layout.fragment_abstract_featured_action_choose;
    }

    @Override // com.tplink.iot.devicecommon.view.IoTMVVMBaseFragment
    public void N0() {
        J0().f6822c.setAdapter(W0());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final com.tplink.iot.g.a.a.a T0(String id, int i) {
        j.e(id, "id");
        String string = getString(i);
        j.d(string, "getString(titleId)");
        return new com.tplink.iot.g.a.a.a(id, string);
    }

    public abstract List<com.tplink.iot.g.a.a.a> U0();

    /* JADX INFO: Access modifiers changed from: protected */
    public final Bundle V0() {
        return (Bundle) this.p1.getValue();
    }

    @Override // com.tplink.iot.devicecommon.view.IoTMVVMBaseFragment, com.tplink.iot.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        String str;
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments == null || (str = arguments.getString("DeviceModel")) == null) {
            str = "";
        }
        this.p2 = str;
    }

    @Override // com.tplink.iot.devicecommon.view.IoTMVVMBaseFragment, com.tplink.iot.base.BaseFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        H0();
    }
}
