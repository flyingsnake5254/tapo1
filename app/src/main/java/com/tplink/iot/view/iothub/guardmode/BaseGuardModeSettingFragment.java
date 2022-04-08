package com.tplink.iot.view.iothub.guardmode;

import android.content.Context;
import android.os.Bundle;
import androidx.lifecycle.ViewModelProvider;
import com.tplink.iot.base.BaseFragment;
import com.tplink.iot.viewmodel.iothub.guardmode.GuardModeConfigViewModel;
import com.tplink.iot.viewmodel.iotplug.factory.IoTViewModelFactory;
import java.util.HashMap;
import kotlin.f;
import kotlin.i;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

/* compiled from: BaseGuardModeSettingFragment.kt */
/* loaded from: classes2.dex */
public abstract class BaseGuardModeSettingFragment extends BaseFragment {
    protected GuardModeConfigActivity q;
    private String x = "";
    private final f y;
    private HashMap z;

    /* compiled from: BaseGuardModeSettingFragment.kt */
    /* loaded from: classes2.dex */
    static final class a extends Lambda implements kotlin.jvm.b.a<GuardModeConfigViewModel> {
        a() {
            super(0);
        }

        /* renamed from: a */
        public final GuardModeConfigViewModel invoke() {
            GuardModeConfigViewModel guardModeConfigViewModel = (GuardModeConfigViewModel) new ViewModelProvider(BaseGuardModeSettingFragment.this.K0(), new IoTViewModelFactory(BaseGuardModeSettingFragment.this.K0(), BaseGuardModeSettingFragment.this.x)).get(GuardModeConfigViewModel.class);
            guardModeConfigViewModel.w(BaseGuardModeSettingFragment.this.K0().g1());
            return guardModeConfigViewModel;
        }
    }

    public BaseGuardModeSettingFragment() {
        f b2;
        b2 = i.b(new a());
        this.y = b2;
    }

    public void H0() {
        HashMap hashMap = this.z;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    protected abstract int J0();

    /* JADX INFO: Access modifiers changed from: protected */
    public final GuardModeConfigActivity K0() {
        GuardModeConfigActivity guardModeConfigActivity = this.q;
        if (guardModeConfigActivity == null) {
            j.t("mActivity");
        }
        return guardModeConfigActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final GuardModeConfigViewModel L0() {
        return (GuardModeConfigViewModel) this.y.getValue();
    }

    protected abstract void N0();

    protected abstract void O0();

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        O0();
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        String str;
        j.e(context, "context");
        super.onAttach(context);
        GuardModeConfigActivity guardModeConfigActivity = (GuardModeConfigActivity) context;
        this.q = guardModeConfigActivity;
        if (guardModeConfigActivity == null) {
            j.t("mActivity");
        }
        guardModeConfigActivity.b1(J0());
        Bundle arguments = getArguments();
        if (arguments == null || (str = arguments.getString("device_id_md5")) == null) {
            str = "";
        }
        this.x = str;
    }

    @Override // com.tplink.iot.base.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        N0();
        super.onDestroy();
    }

    @Override // com.tplink.iot.base.BaseFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        H0();
    }
}
