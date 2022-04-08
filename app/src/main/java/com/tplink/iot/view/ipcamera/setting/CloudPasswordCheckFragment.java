package com.tplink.iot.view.ipcamera.setting;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import com.tplink.iot.R;
import com.tplink.iot.Utils.d0;
import com.tplink.iot.base.BaseFragment;
import com.tplink.iot.databinding.FragmentCloudPasswordCheckBinding;
import com.tplink.iot.view.ipcamera.widget.topsnackbar.TSnackbar;
import com.tplink.iot.viewmodel.ipcamera.setting.PasswordSettingViewModel;

/* loaded from: classes2.dex */
public class CloudPasswordCheckFragment extends BaseFragment implements View.OnClickListener {
    private FragmentCloudPasswordCheckBinding q;
    private PasswordSettingViewModel x;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: H0 */
    public /* synthetic */ void I0(View view) {
        getActivity().finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: J0 */
    public /* synthetic */ void K0() {
        ((PasswordSettingActivity) getActivity()).f1(3);
    }

    private void L0() {
        d0.d(getContext(), this.q.f6969c, R.string.forget_password_tips1, getString(R.string.forget_password_tips2), new d0.g() { // from class: com.tplink.iot.view.ipcamera.setting.w0
            @Override // com.tplink.iot.Utils.d0.g
            public final void a() {
                CloudPasswordCheckFragment.this.K0();
            }
        });
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        this.x = ((PasswordSettingActivity) context).e1();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.cancel) {
            this.x.f10817e.set(null);
        } else if (id == R.id.save) {
            if (this.x.h(this.q.f6970d.getText().toString())) {
                this.q.f6970d.setError(null);
                ((PasswordSettingActivity) getActivity()).f1(0);
                return;
            }
            TSnackbar.B(this, R.string.device_pwd_incorrect, -1).J(getResources().getColor(R.color.common_iot_red)).N();
        }
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        FragmentCloudPasswordCheckBinding fragmentCloudPasswordCheckBinding = (FragmentCloudPasswordCheckBinding) DataBindingUtil.inflate(layoutInflater, R.layout.fragment_cloud_password_check, viewGroup, false);
        this.q = fragmentCloudPasswordCheckBinding;
        fragmentCloudPasswordCheckBinding.i(this.x);
        this.q.h(this);
        this.q.q.setNavigationOnClickListener(new View.OnClickListener() { // from class: com.tplink.iot.view.ipcamera.setting.x0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CloudPasswordCheckFragment.this.I0(view);
            }
        });
        L0();
        return this.q.getRoot();
    }
}
