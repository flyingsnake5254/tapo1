package com.tplink.iot.devicecommon.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.CallSuper;
import androidx.annotation.LayoutRes;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.base.BaseFragment;
import java.util.HashMap;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.j;
import kotlin.p;

/* compiled from: IoTMVVMBaseFragment.kt */
/* loaded from: classes2.dex */
public abstract class IoTMVVMBaseFragment<VDB extends ViewDataBinding> extends BaseFragment {
    public static final a q = new a(null);
    private HashMap p0;
    private VDB x;
    private String y = "";
    private boolean z;

    /* compiled from: IoTMVVMBaseFragment.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public final Bundle a(String str) {
            Bundle bundle = new Bundle();
            if (str == null) {
                str = "";
            }
            bundle.putString("device_id_md5", str);
            return bundle;
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    public void H0() {
        HashMap hashMap = this.p0;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    @LayoutRes
    public abstract int I0();

    /* JADX INFO: Access modifiers changed from: protected */
    public final VDB J0() {
        VDB vdb = this.x;
        j.c(vdb);
        return vdb;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String K0() {
        return this.y;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean L0() {
        return this.z;
    }

    public void N0() {
    }

    public void O0() {
    }

    public final void P0(String str) {
        Bundle bundle = new Bundle();
        if (str == null) {
            str = "";
        }
        bundle.putString("device_id_md5", str);
        p pVar = p.a;
        setArguments(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void Q0(String str) {
        j.e(str, "<set-?>");
        this.y = str;
    }

    public void R0() {
    }

    @Override // com.tplink.iot.base.BaseFragment, androidx.fragment.app.Fragment
    @CallSuper
    public void onCreate(Bundle bundle) {
        String str;
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments == null || (str = arguments.getString("device_id_md5")) == null) {
            str = "";
        }
        this.y = str;
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        j.e(inflater, "inflater");
        this.x = (VDB) DataBindingUtil.inflate(inflater, I0(), viewGroup, false);
        return J0().getRoot();
    }

    @Override // com.tplink.iot.base.BaseFragment, androidx.fragment.app.Fragment
    @CallSuper
    public void onDestroyView() {
        super.onDestroyView();
        this.z = false;
        this.x = null;
        H0();
    }

    @Override // androidx.fragment.app.Fragment
    @CallSuper
    public void onViewCreated(View view, Bundle bundle) {
        j.e(view, "view");
        this.z = true;
        J0().setLifecycleOwner(getViewLifecycleOwner());
        N0();
        R0();
        O0();
    }
}
