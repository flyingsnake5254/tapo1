package com.tplink.iot.view.quicksetup.sub;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.tplink.iot.R;
import com.tplink.iot.databinding.FragmentSubgRemoveCoverBinding;
import com.tplink.iot.viewmodel.quicksetup.subg.SubGEmptyViewModel;
import com.tplink.iot.viewmodel.quicksetup.subg.SubGViewModel;
import java.util.HashMap;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.j;

/* compiled from: SubGRemoveCoverFragment.kt */
/* loaded from: classes2.dex */
public final class SubGRemoveCoverFragment extends SubGBaseFragment<FragmentSubgRemoveCoverBinding, SubGEmptyViewModel> {
    public static final a x = new a(null);
    private HashMap y;

    /* compiled from: SubGRemoveCoverFragment.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    @Override // com.tplink.iot.view.quicksetup.sub.SubGBaseFragment
    public int B0() {
        return R.layout.fragment_subg_remove_cover;
    }

    public void G0() {
        HashMap hashMap = this.y;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    /* renamed from: H0 */
    public SubGEmptyViewModel C0() {
        ViewModel viewModel = new ViewModelProvider(this).get(SubGEmptyViewModel.class);
        j.d(viewModel, "ViewModelProvider(this).…ptyViewModel::class.java)");
        return (SubGEmptyViewModel) viewModel;
    }

    @Override // com.tplink.iot.view.ipcamera.base.g, android.view.View.OnClickListener
    public void onClick(View v) {
        j.e(v, "v");
        int id = v.getId();
        if (id == R.id.btn_next) {
            this.f9664f.e0("SubGGuideFirstFragment.TAG", null);
        } else if (id == R.id.img_back) {
            this.q.E0(20002);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        G0();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        j.e(view, "view");
        TextView textView = ((FragmentSubgRemoveCoverBinding) this.f9662c).z;
        j.d(textView, "binding.tvRemoveCoverTitle");
        SubGViewModel subGViewModel = this.q;
        j.d(subGViewModel, "subGViewModel");
        textView.setText(subGViewModel.z().a());
        TextView textView2 = ((FragmentSubgRemoveCoverBinding) this.f9662c).y;
        j.d(textView2, "binding.tvRemoveCoverHint");
        SubGViewModel subGViewModel2 = this.q;
        j.d(subGViewModel2, "subGViewModel");
        textView2.setText(subGViewModel2.z().b());
        ImageView imageView = ((FragmentSubgRemoveCoverBinding) this.f9662c).f7104f;
        SubGViewModel subGViewModel3 = this.q;
        j.d(subGViewModel3, "subGViewModel");
        imageView.setImageResource(subGViewModel3.z().j());
    }
}
