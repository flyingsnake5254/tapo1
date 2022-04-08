package com.tplink.iot.view.smart.actionsetup;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.iot.R;
import com.tplink.iot.base.BaseFragment;
import com.tplink.iot.cloud.bean.smart.common.SmartAction;
import com.tplink.iot.cloud.bean.smart.common.SmartInfo;
import com.tplink.iot.cloud.bean.smart.common.SmartReferAction;
import com.tplink.iot.view.quicksetup.base.d;
import com.tplink.iot.viewmodel.smart.ActionSetupViewModel;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class TaskAutomationEnableFragment extends BaseFragment implements Toolbar.OnMenuItemClickListener {
    private a p0;
    private View q;
    private RadioGroup x;
    private ActionDetailActivity y;
    private ActionSetupViewModel z;

    /* loaded from: classes2.dex */
    public interface a {
        void a();
    }

    private void H0() {
        ((TextView) this.q.findViewById(R.id.toolbar_title)).setText(this.z.u().getName());
        Toolbar toolbar = (Toolbar) this.q.findViewById(R.id.toolbar);
        toolbar.inflateMenu(R.menu.menu_done);
        toolbar.setOnMenuItemClickListener(this);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() { // from class: com.tplink.iot.view.smart.actionsetup.y
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TaskAutomationEnableFragment.this.J0(view);
            }
        });
        this.x = (RadioGroup) this.q.findViewById(R.id.rg_enable_radio);
        if (this.z.u() != null && this.z.s() != null) {
            this.x.check(this.z.s().booleanValue() ? R.id.enable_rb : R.id.disable_rb);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: I0 */
    public /* synthetic */ void J0(View view) {
        d();
    }

    public void K0(a aVar) {
        this.p0 = aVar;
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
        this.q = layoutInflater.inflate(R.layout.fragment_smart_enable_automation, viewGroup, false);
        ActionDetailActivity actionDetailActivity = (ActionDetailActivity) getActivity();
        this.y = actionDetailActivity;
        if (actionDetailActivity == null) {
            B0();
        }
        d.J(this.y, this.q.findViewById(R.id.toolbar));
        setHasOptionsMenu(true);
        this.z = (ActionSetupViewModel) ViewModelProviders.of(this.y).get(ActionSetupViewModel.class);
        H0();
        return this.q;
    }

    @Override // androidx.appcompat.widget.Toolbar.OnMenuItemClickListener
    public boolean onMenuItemClick(MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.action_done && this.p0 != null) {
            SmartInfo v = this.z.v();
            SmartAction actionSetting = v.getActionSetting();
            if (actionSetting == null) {
                actionSetting = new SmartAction();
            }
            List<SmartReferAction> smarts = actionSetting.getSmarts();
            if (smarts == null) {
                smarts = new ArrayList<>();
            }
            String id = this.z.u().getId();
            int i = 1;
            boolean z = true;
            for (SmartReferAction smartReferAction : smarts) {
                if (id.equals(smartReferAction.getId())) {
                    smartReferAction.setAction(this.x.getCheckedRadioButtonId() == R.id.enable_rb ? 1 : 0);
                    z = false;
                }
            }
            if (z) {
                if (this.x.getCheckedRadioButtonId() != R.id.enable_rb) {
                    i = 0;
                }
                SmartReferAction smartReferAction2 = new SmartReferAction(id, i, this.z.F());
                smartReferAction2.setAvatarUrl(this.z.u().getAvatarUrl());
                smartReferAction2.setName(this.z.u().getName());
                smarts.add(0, smartReferAction2);
            }
            actionSetting.setSmarts(smarts);
            if (actionSetting.getThings() != null && actionSetting.getThings().isEmpty()) {
                actionSetting.setThings(null);
            }
            v.setActionSetting(actionSetting);
            this.z.p0(v);
            this.p0.a();
        }
        return false;
    }
}
