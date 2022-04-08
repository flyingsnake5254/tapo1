package com.tplink.iot.view.quicksetup.switches.quicksetup.base;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.CallSuper;
import androidx.annotation.LayoutRes;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.tplink.iot.base.BaseFragment;
import com.tplink.iot.view.ipcamera.base.g;
import com.tplink.iot.view.ipcamera.onboardingv2.z1;
import com.tplink.iot.view.quicksetup.switches.quicksetup.base.SwitchButton;
import com.tplink.iot.viewmodel.quicksetup.subg.SubGViewModel;
import com.tplink.iot.viewmodel.quicksetup.subg.SwitchQuickSetupViewModel;
import java.util.HashMap;
import kotlin.f;
import kotlin.i;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

/* compiled from: SwitchQuickSetupBaseFragment.kt */
/* loaded from: classes2.dex */
public abstract class SwitchQuickSetupBaseFragment<VDB extends ViewDataBinding> extends BaseFragment implements g {
    public static final a q = new a(null);
    private final f p0;
    private final f p1;
    private HashMap p2;
    private SwitchButton x = SwitchButton.FIRST;
    protected VDB y;
    private z1 z;

    /* compiled from: SwitchQuickSetupBaseFragment.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public final Bundle a(SwitchButton button) {
            j.e(button, "button");
            Bundle bundle = new Bundle();
            bundle.putInt("ButtonPosArg", button.getPos());
            return bundle;
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    /* compiled from: SwitchQuickSetupBaseFragment.kt */
    /* loaded from: classes2.dex */
    static final class b extends Lambda implements kotlin.jvm.b.a<SubGViewModel> {
        b() {
            super(0);
        }

        /* renamed from: a */
        public final SubGViewModel invoke() {
            ViewModel viewModel = new ViewModelProvider(SwitchQuickSetupBaseFragment.this.requireActivity()).get(SubGViewModel.class);
            j.d(viewModel, "ViewModelProvider(requir…ubGViewModel::class.java)");
            return (SubGViewModel) viewModel;
        }
    }

    /* compiled from: SwitchQuickSetupBaseFragment.kt */
    /* loaded from: classes2.dex */
    static final class c extends Lambda implements kotlin.jvm.b.a<SwitchQuickSetupViewModel> {
        c() {
            super(0);
        }

        /* renamed from: a */
        public final SwitchQuickSetupViewModel invoke() {
            ViewModel viewModel = new ViewModelProvider(SwitchQuickSetupBaseFragment.this.requireActivity()).get(SwitchQuickSetupViewModel.class);
            j.d(viewModel, "ViewModelProvider(requir…tupViewModel::class.java)");
            return (SwitchQuickSetupViewModel) viewModel;
        }
    }

    public SwitchQuickSetupBaseFragment() {
        f b2;
        f b3;
        b2 = i.b(new b());
        this.p0 = b2;
        b3 = i.b(new c());
        this.p1 = b3;
    }

    public static final Bundle I0(SwitchButton switchButton) {
        return q.a(switchButton);
    }

    public void H0() {
        HashMap hashMap = this.p2;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    @LayoutRes
    public abstract int J0();

    /* JADX INFO: Access modifiers changed from: protected */
    public final VDB K0() {
        VDB vdb = this.y;
        if (vdb == null) {
            j.t("mBinding");
        }
        return vdb;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final SwitchButton L0() {
        return this.x;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final z1 N0() {
        return this.z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final SubGViewModel O0() {
        return (SubGViewModel) this.p0.getValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final SwitchQuickSetupViewModel P0() {
        return (SwitchQuickSetupViewModel) this.p1.getValue();
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        j.e(context, "context");
        super.onAttach(context);
        SwitchButton.a aVar = SwitchButton.Companion;
        Bundle arguments = getArguments();
        SwitchButton a2 = aVar.a(arguments != null ? arguments.getInt("ButtonPosArg") : 1);
        if (a2 == null) {
            a2 = SwitchButton.FIRST;
        }
        this.x = a2;
        if (!(context instanceof z1)) {
            context = null;
        }
        this.z = (z1) context;
    }

    @Override // androidx.fragment.app.Fragment
    @CallSuper
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        j.e(inflater, "inflater");
        VDB vdb = (VDB) DataBindingUtil.inflate(inflater, J0(), viewGroup, false);
        j.d(vdb, "DataBindingUtil.inflate(…youtId, container, false)");
        this.y = vdb;
        if (vdb == null) {
            j.t("mBinding");
        }
        vdb.setVariable(94, O0());
        VDB vdb2 = this.y;
        if (vdb2 == null) {
            j.t("mBinding");
        }
        vdb2.setVariable(79, this);
        VDB vdb3 = this.y;
        if (vdb3 == null) {
            j.t("mBinding");
        }
        return vdb3.getRoot();
    }

    @Override // com.tplink.iot.base.BaseFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        H0();
    }

    @Override // com.tplink.iot.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
    }
}
