package com.tplink.iot.view.quicksetup.sub;

import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.tplink.iot.R;
import com.tplink.iot.adapter.quicksetup.RoomLocationAdapter;
import com.tplink.iot.adapter.quicksetup.f;
import com.tplink.iot.cloud.bean.family.common.RoomInfo;
import com.tplink.iot.databinding.FragmentSubGSetupLocationSelectBinding;
import com.tplink.iot.viewmodel.quicksetup.subg.SubGSetupLocationCustomViewModel;
import java.util.List;

/* loaded from: classes2.dex */
public class SubGSetupLocationSelectFragment extends SubGBaseFragment<FragmentSubGSetupLocationSelectBinding, SubGSetupLocationCustomViewModel> {
    private String x;
    private List<RoomInfo> y;

    private void H0() {
        this.f9664f.e0("SubGSetupLocationCustomFragment.TAG", null);
    }

    private void I0(String str) {
        ((FragmentSubGSetupLocationSelectBinding) this.f9662c).f7087c.h();
        this.q.n.set(str);
        this.f9664f.e0("SubGSetupAvatarFragment.TAG", null);
    }

    private void J0() {
        List<RoomInfo> s = this.q.s();
        this.y = s;
        if (s != null && !s.isEmpty()) {
            this.x = this.y.get(0).getName();
        }
    }

    private void K0() {
        ((FragmentSubGSetupLocationSelectBinding) this.f9662c).f7088d.setLayoutManager(new LinearLayoutManager(getActivity()));
        RoomLocationAdapter roomLocationAdapter = new RoomLocationAdapter(getActivity(), this.y, 0);
        ((FragmentSubGSetupLocationSelectBinding) this.f9662c).f7088d.setAdapter(roomLocationAdapter);
        roomLocationAdapter.q(new f() { // from class: com.tplink.iot.view.quicksetup.sub.q
            @Override // com.tplink.iot.adapter.quicksetup.f
            public final void a(View view, int i) {
                SubGSetupLocationSelectFragment.this.N0(view, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: L0 */
    public /* synthetic */ void N0(View view, int i) {
        List<RoomInfo> list = this.y;
        if (list != null && !list.isEmpty()) {
            if (i < this.y.size()) {
                this.x = this.y.get(i).getName();
            } else if (i == this.y.size()) {
                H0();
            }
        }
    }

    @Override // com.tplink.iot.view.quicksetup.sub.SubGBaseFragment
    public int B0() {
        return R.layout.fragment_sub_g_setup_location_select;
    }

    /* renamed from: G0 */
    public SubGSetupLocationCustomViewModel C0() {
        return (SubGSetupLocationCustomViewModel) ViewModelProviders.of(this).get(SubGSetupLocationCustomViewModel.class);
    }

    @Override // com.tplink.iot.view.ipcamera.base.g, android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btn_bottom) {
            I0(this.x);
        } else if (id == R.id.img_back) {
            this.q.E0(20002);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        J0();
        K0();
    }
}
