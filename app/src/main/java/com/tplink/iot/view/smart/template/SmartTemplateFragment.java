package com.tplink.iot.view.smart.template;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.R;
import com.tplink.iot.adapter.smart.SmartTemplateAdapter;
import com.tplink.iot.base.BaseFragment;
import com.tplink.iot.model.smart.SmartTemplateBaseBean;
import com.tplink.iot.view.smart.SmartFragment;
import com.tplink.iot.viewmodel.smart.SmartTemplateViewModel;
import com.tplink.iot.widget.g;
import com.tplink.iot.widget.springview.widget.PullToRefreshContainer;
import java.util.List;

/* loaded from: classes2.dex */
public class SmartTemplateFragment extends BaseFragment implements SmartTemplateAdapter.b {
    private boolean p0 = false;
    private View q;
    private PullToRefreshContainer x;
    private SmartTemplateAdapter y;
    private SmartTemplateViewModel z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements PullToRefreshContainer.e {
        a() {
        }

        @Override // com.tplink.iot.widget.springview.widget.PullToRefreshContainer.e
        public void a() {
        }

        @Override // com.tplink.iot.widget.springview.widget.PullToRefreshContainer.e
        public void onRefresh() {
            SmartTemplateFragment.this.p0 = true;
            SmartTemplateFragment.this.P0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b implements Observer<List<SmartTemplateBaseBean>> {
        b() {
        }

        /* renamed from: a */
        public void onChanged(@Nullable List<SmartTemplateBaseBean> list) {
            if (SmartTemplateFragment.this.p0) {
                SmartTemplateFragment.this.x.A();
                SmartTemplateFragment.this.p0 = false;
            }
            SmartTemplateFragment smartTemplateFragment = SmartTemplateFragment.this;
            if (list == null || list.isEmpty()) {
                list = null;
            }
            smartTemplateFragment.O0(list);
        }
    }

    private void N0() {
        SmartTemplateAdapter smartTemplateAdapter = new SmartTemplateAdapter();
        this.y = smartTemplateAdapter;
        smartTemplateAdapter.n(this);
        RecyclerView recyclerView = (RecyclerView) this.q.findViewById(R.id.rv_smart_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(this.y);
        recyclerView.setNestedScrollingEnabled(false);
        PullToRefreshContainer pullToRefreshContainer = (PullToRefreshContainer) this.q.findViewById(R.id.refresh_layout);
        this.x = pullToRefreshContainer;
        pullToRefreshContainer.setHeader(new g());
        this.x.setEnableFooter(false);
        this.x.setListener(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O0(List<SmartTemplateBaseBean> list) {
        this.y.o(list);
        this.y.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P0() {
        this.z.g();
    }

    private void Q0() {
        this.z.k().observe(getViewLifecycleOwner(), new b());
    }

    private void R0() {
        Fragment parentFragment = getParentFragment();
        if (parentFragment instanceof SmartFragment) {
            ((SmartFragment) parentFragment).P0();
        }
    }

    @Override // com.tplink.iot.adapter.smart.SmartTemplateAdapter.b
    public void A(int i) {
        startActivityForResult(SmartTemplateDetailActivity.r1(getContext(), i), 567);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 567 && i2 == -1) {
            R0();
        }
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.q = layoutInflater.inflate(R.layout.fragment_smart_template_list, viewGroup, false);
        setHasOptionsMenu(true);
        this.z = (SmartTemplateViewModel) ViewModelProviders.of(this).get(SmartTemplateViewModel.class);
        N0();
        Q0();
        this.x.e();
        return this.q;
    }
}
