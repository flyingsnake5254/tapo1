package com.tplink.iot.view.smart.actionsetup;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.R;
import com.tplink.iot.adapter.smart.SmartAvatarAdapter;
import com.tplink.iot.base.BaseFragment;
import com.tplink.iot.cloud.bean.smart.common.SmartInfo;
import com.tplink.iot.view.quicksetup.base.d;
import com.tplink.iot.viewmodel.smart.ActionSetupViewModel;

/* loaded from: classes2.dex */
public class ActionIconChooseFragment extends BaseFragment {
    private View q;
    private ActionDetailActivity x;
    private ActionSetupViewModel y;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ActionIconChooseFragment.this.B0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b implements SmartAvatarAdapter.c {
        b() {
        }

        @Override // com.tplink.iot.adapter.smart.SmartAvatarAdapter.c
        public void a(String str) {
            SmartInfo v = ActionIconChooseFragment.this.y.v();
            v.setAvatarUrl(str);
            ActionIconChooseFragment.this.y.p0(v);
            ActionIconChooseFragment.this.x.U0();
        }
    }

    private void J0() {
        ((TextView) this.q.findViewById(R.id.toolbar_title)).setText(R.string.smart_action_icon);
        ((Toolbar) this.q.findViewById(R.id.toolbar)).setNavigationOnClickListener(new a());
        SmartAvatarAdapter smartAvatarAdapter = new SmartAvatarAdapter();
        smartAvatarAdapter.p(new b());
        RecyclerView recyclerView = (RecyclerView) this.q.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 4));
        recyclerView.setAdapter(smartAvatarAdapter);
    }

    @Override // com.tplink.iot.base.BaseFragment, com.tplink.iot.i.a
    public boolean d() {
        if (getFragmentManager() == null) {
            return true;
        }
        getFragmentManager().popBackStackImmediate();
        return true;
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.q = layoutInflater.inflate(R.layout.fragment_smart_icon_list, viewGroup, false);
        ActionDetailActivity actionDetailActivity = (ActionDetailActivity) getActivity();
        this.x = actionDetailActivity;
        if (actionDetailActivity == null) {
            B0();
        }
        d.J(this.x, this.q.findViewById(R.id.toolbar));
        this.y = (ActionSetupViewModel) ViewModelProviders.of(this.x).get(ActionSetupViewModel.class);
        setHasOptionsMenu(true);
        J0();
        return this.q;
    }
}
