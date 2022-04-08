package com.tplink.iot.view.smart.actionsetup;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.c;
import com.tplink.iot.R;
import com.tplink.iot.Utils.TPMaterialDialogV2;
import com.tplink.iot.Utils.n0;
import com.tplink.iot.Utils.s0;
import com.tplink.iot.Utils.x0.v;
import com.tplink.iot.adapter.smart.SmartTaskAdapter;
import com.tplink.iot.adapter.smart.SmartTriggerAdapter;
import com.tplink.iot.base.BaseFragment;
import com.tplink.iot.cloud.bean.smart.common.SmartAction;
import com.tplink.iot.cloud.bean.smart.common.SmartInfo;
import com.tplink.iot.cloud.bean.smart.common.SmartScheduleSetting;
import com.tplink.iot.cloud.bean.smart.common.SmartThingTrigger;
import com.tplink.iot.cloud.bean.smart.common.SmartTrigger;
import com.tplink.iot.model.smart.e;
import com.tplink.iot.model.smart.g;
import com.tplink.iot.view.quicksetup.base.d;
import com.tplink.iot.viewmodel.smart.ActionSetupViewModel;
import com.tplink.iot.viewmodel.smart.SmartActionViewModel;
import com.tplink.iot.widget.DrawableEditText;
import com.tplink.iot.widget.HMSPickerDialog;
import com.tplink.iot.widget.ItemSmartSettingLayout;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.IoTNetwork.repository.SmartRepository;
import com.tplink.libtpnetwork.Utils.i;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class ActionSetupFragment extends BaseFragment implements TextWatcher, SmartTriggerAdapter.a, SmartTaskAdapter.a, AdapterView.OnItemSelectedListener, View.OnClickListener {
    private TextView H3;
    private ImageView I3;
    private TextView J3;
    private Button K3;
    private ItemSmartSettingLayout L3;
    private ItemSmartSettingLayout M3;
    private TextView N3;
    private View O3;
    private View P3;
    private SmartInfo Q3;
    private SmartTriggerAdapter R3;
    private SmartTaskAdapter S3;
    private ActionSetupViewModel T3;
    private ActionDetailActivity U3;
    private int V3 = 0;
    private int W3 = 0;
    private int X3 = 1;
    private a Y3;
    private AppCompatSpinner p0;
    private LinearLayout p1;
    private ImageView p2;
    private TextView p3;
    private View q;
    private MenuItem x;
    private TextView y;
    private DrawableEditText z;

    /* loaded from: classes2.dex */
    public interface a {
        void a();

        void b(boolean z);

        void c();

        void d();

        void e();

        void f();

        void g();

        void h();

        void i();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class b extends ArrayAdapter<String> {

        /* renamed from: c  reason: collision with root package name */
        private Context f9721c;

        /* renamed from: d  reason: collision with root package name */
        private int f9722d;

        /* renamed from: f  reason: collision with root package name */
        private int f9723f;
        private int q;
        private String[] x;
        private String[] y;

        b(Context context, int i, int i2, int i3, String[] strArr, String[] strArr2) {
            super(context, i, i3, strArr);
            this.f9721c = context;
            this.f9722d = i;
            this.f9723f = i2;
            this.q = i3;
            this.x = strArr;
            this.y = strArr2;
        }

        @Override // android.widget.ArrayAdapter, android.widget.BaseAdapter, android.widget.SpinnerAdapter
        public View getDropDownView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = LayoutInflater.from(this.f9721c).inflate(this.f9723f, viewGroup, false);
            }
            ((TextView) view.findViewById(this.q)).setText(this.y[i]);
            return view;
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = LayoutInflater.from(this.f9721c).inflate(this.f9722d, viewGroup, false);
            }
            ((TextView) view.findViewById(this.q)).setText(this.x[i]);
            return view;
        }
    }

    private void H0() {
        Toolbar toolbar = (Toolbar) this.q.findViewById(R.id.toolbar);
        toolbar.inflateMenu(R.menu.menu_done);
        toolbar.setNavigationIcon(R.mipmap.close);
        TextView textView = (TextView) this.q.findViewById(R.id.toolbar_title);
        this.y = textView;
        textView.setText(R.string.smart_list_tab_title);
        DrawableEditText drawableEditText = (DrawableEditText) this.q.findViewById(R.id.et_edit_action_name);
        this.z = drawableEditText;
        drawableEditText.setMaxLength(64);
        this.z.f(this);
        SmartTriggerAdapter smartTriggerAdapter = new SmartTriggerAdapter(this.U3, false);
        this.R3 = smartTriggerAdapter;
        smartTriggerAdapter.B(this);
        RecyclerView recyclerView = (RecyclerView) this.q.findViewById(R.id.cy_action_schedules);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.U3));
        recyclerView.setAdapter(this.R3);
        recyclerView.setNestedScrollingEnabled(false);
        SmartTaskAdapter smartTaskAdapter = new SmartTaskAdapter(this.U3, false);
        this.S3 = smartTaskAdapter;
        smartTaskAdapter.v(this);
        RecyclerView recyclerView2 = (RecyclerView) this.q.findViewById(R.id.cy_action_tasks);
        recyclerView2.setLayoutManager(new LinearLayoutManager(this.U3));
        recyclerView2.setAdapter(this.S3);
        recyclerView2.setNestedScrollingEnabled(false);
        this.p3 = (TextView) this.q.findViewById(R.id.tv_condition_met_all_warning);
        this.H3 = (TextView) this.q.findViewById(R.id.condition_type_tv);
        this.I3 = (ImageView) this.q.findViewById(R.id.iv_warning);
        String[] stringArray = getResources().getStringArray(R.array.smart_action_condition_item);
        b bVar = new b(this.U3, R.layout.smart_action_spinner, R.layout.smart_action_spinner_dropdown, R.id.text1, stringArray, stringArray);
        AppCompatSpinner appCompatSpinner = (AppCompatSpinner) this.q.findViewById(R.id.condition_type_spinner);
        this.p0 = appCompatSpinner;
        appCompatSpinner.setOnItemSelectedListener(this);
        this.p0.setAdapter((SpinnerAdapter) bVar);
        ItemSmartSettingLayout itemSmartSettingLayout = (ItemSmartSettingLayout) this.q.findViewById(R.id.rl_add_conditions);
        this.L3 = itemSmartSettingLayout;
        itemSmartSettingLayout.setOnClickListener(this);
        ItemSmartSettingLayout itemSmartSettingLayout2 = (ItemSmartSettingLayout) this.q.findViewById(R.id.rl_add_tasks);
        this.M3 = itemSmartSettingLayout2;
        itemSmartSettingLayout2.setOnClickListener(this);
        TextView textView2 = (TextView) this.q.findViewById(R.id.tv_action_tasks_delay);
        this.J3 = textView2;
        textView2.setOnClickListener(this);
        this.p2 = (ImageView) this.q.findViewById(R.id.iv_shortcut_icon);
        LinearLayout linearLayout = (LinearLayout) this.q.findViewById(R.id.ll_shortcut_icon);
        this.p1 = linearLayout;
        linearLayout.setOnClickListener(this);
        Button button = (Button) this.q.findViewById(R.id.btn_edit_action_delete);
        this.K3 = button;
        button.setOnClickListener(this);
        this.N3 = (TextView) this.q.findViewById(R.id.tv_effective_time);
        this.O3 = this.q.findViewById(R.id.e_t_divider);
        this.P3 = this.q.findViewById(R.id.divider_effective_time);
        this.N3.setOnClickListener(this);
    }

    private boolean I0(SmartTrigger smartTrigger) {
        int i;
        if (smartTrigger == null) {
            return true;
        }
        int size = smartTrigger.getSchedules() != null ? smartTrigger.getSchedules().size() + 0 : 0;
        if (smartTrigger.getThings() == null || smartTrigger.getThings().isEmpty()) {
            i = 0;
        } else {
            i = 0;
            for (SmartThingTrigger smartThingTrigger : smartTrigger.getThings()) {
                if (smartThingTrigger.getEvent() != null) {
                    i++;
                } else {
                    smartThingTrigger.getStateReported();
                }
            }
        }
        return size + i <= 1;
    }

    private <T> boolean J0(List<T> list) {
        return list == null || list.isEmpty();
    }

    private void K0() {
        MenuItem menuItem = this.x;
        if (menuItem != null) {
            SmartInfo smartInfo = this.Q3;
            boolean z = false;
            if (smartInfo == null) {
                menuItem.setEnabled(false);
                return;
            }
            SmartTrigger triggerSetting = smartInfo.getTriggerSetting();
            boolean z2 = triggerSetting == null || (!triggerSetting.isManual() && J0(triggerSetting.getSchedules()) && J0(triggerSetting.getThings()));
            boolean z3 = !(this.p0.getSelectedItemPosition() == 1) || I0(triggerSetting);
            SmartAction actionSetting = this.Q3.getActionSetting();
            boolean z4 = actionSetting == null || (J0(actionSetting.getSmarts()) && J0(actionSetting.getThings()));
            boolean i1 = i1(this.z.getText());
            MenuItem menuItem2 = this.x;
            if (!z2 && z3 && !z4 && i1) {
                z = true;
            }
            menuItem2.setEnabled(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: L0 */
    public /* synthetic */ void N0(HMSPickerDialog hMSPickerDialog, int i) {
        if (TextUtils.equals(hMSPickerDialog.getTag(), "tag_action_delay_offset")) {
            this.V3 = i;
            h1(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: O0 */
    public /* synthetic */ void P0(View view) {
        s0.l(this.U3);
        this.T3.j(this.Q3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Q0 */
    public /* synthetic */ void R0(SmartInfo smartInfo) {
        b.d.w.c.a.n("Smart", "ActionSetupFragment smartActionInfo:\n" + i.j(smartInfo));
        this.Q3 = smartInfo;
        h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: S0 */
    public /* synthetic */ void T0(Boolean bool) {
        s0.g();
        if (bool == null || !bool.booleanValue()) {
            s0.n(getActivity(), R.string.operation_failed_try_again);
            return;
        }
        a aVar = this.Y3;
        if (aVar != null) {
            aVar.h();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: U0 */
    public /* synthetic */ void V0(Boolean bool) {
        s0.g();
        if (bool == null || !bool.booleanValue()) {
            s0.n(getActivity(), R.string.operation_failed_try_again);
            return;
        }
        a aVar = this.Y3;
        if (aVar != null) {
            aVar.h();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: W0 */
    public /* synthetic */ void X0(Boolean bool) {
        s0.g();
        if (bool == null || !bool.booleanValue()) {
            s0.n(getActivity(), R.string.operation_failed_try_again);
            return;
        }
        a aVar = this.Y3;
        if (aVar != null) {
            aVar.b(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Y0 */
    public /* synthetic */ void Z0(Boolean bool) {
        if (bool == null || bool.booleanValue()) {
            s0.g();
            s0.n(this.U3, R.string.tapo_request_permission_once);
        } else if (this.X3 == 2) {
            if (this.T3.n0(this.Q3)) {
                s0.p(this.U3, getString(R.string.smart_action_add_limit_tip, 64));
            } else {
                this.T3.k(this.Q3);
            }
        } else if (this.T3.n0(this.Q3) || this.T3.o0()) {
            s0.p(this.U3, getString(R.string.smart_action_add_limit_tip, 64));
        } else {
            this.T3.i(this.Q3);
        }
    }

    private void a1() {
        this.T3.y();
    }

    private boolean c1(@Nullable SmartTrigger smartTrigger) {
        if (smartTrigger == null) {
            return false;
        }
        if (smartTrigger.isManual()) {
            return true;
        }
        return this.T3.H() == 1 && smartTrigger.getSchedules() != null && !smartTrigger.getSchedules().isEmpty();
    }

    private void d1() {
        SmartInfo smartInfo = this.Q3;
        if (smartInfo != null && smartInfo.getTriggerSetting() != null) {
            new TPMaterialDialogV2.Builder(getContext()).j(getString(this.Q3.getTriggerSetting().isManual() ? R.string.smart_action_delete_shortcut : R.string.smart_action_delete_automation)).l(R.string.common_cancel, R.color.common_iot_light_black, null).o(R.string.common_delete, R.color.common_iot_main_blue, new TPMaterialDialogV2.d() { // from class: com.tplink.iot.view.smart.actionsetup.i
                @Override // com.tplink.iot.Utils.TPMaterialDialogV2.d
                public final void onClick(View view) {
                    ActionSetupFragment.this.P0(view);
                }
            }).g(8, 8).setCancelable(false).c(false).create().show();
        }
    }

    private void e1() {
        boolean z;
        String[] strArr = SmartRepository.i;
        String avatarUrl = this.Q3.getAvatarUrl();
        int length = strArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                z = false;
                break;
            } else if (strArr[i].equals(avatarUrl)) {
                z = true;
                break;
            } else {
                i++;
            }
        }
        if (!z) {
            this.Q3.setAvatarUrl(strArr[0]);
        }
        c.w(this).s("file:///android_asset/smart_icons/" + this.Q3.getAvatarUrl() + ".png").x0(this.p2);
    }

    private void f1() {
        this.T3.D().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tplink.iot.view.smart.actionsetup.k
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ActionSetupFragment.this.R0((SmartInfo) obj);
            }
        });
        this.T3.x().observe(this, new Observer() { // from class: com.tplink.iot.view.smart.actionsetup.h
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ActionSetupFragment.this.T0((Boolean) obj);
            }
        });
        this.T3.A().observe(this, new Observer() { // from class: com.tplink.iot.view.smart.actionsetup.g
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ActionSetupFragment.this.V0((Boolean) obj);
            }
        });
        this.T3.z().observe(this, new Observer() { // from class: com.tplink.iot.view.smart.actionsetup.f
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ActionSetupFragment.this.X0((Boolean) obj);
            }
        });
        this.T3.B().observe(this, new Observer() { // from class: com.tplink.iot.view.smart.actionsetup.l
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ActionSetupFragment.this.Z0((Boolean) obj);
            }
        });
    }

    private void g1(SmartInfo smartInfo, List<e> list) {
        if (!(smartInfo == null || smartInfo.getActionSetting() == null)) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (e eVar : list) {
                if (eVar.b() == 1) {
                    arrayList.add(eVar.g());
                } else {
                    arrayList2.add(eVar.f());
                }
            }
            SmartAction actionSetting = smartInfo.getActionSetting();
            if (arrayList.isEmpty()) {
                arrayList = null;
            }
            actionSetting.setThings(arrayList);
            smartInfo.getActionSetting().setSmarts(arrayList2);
        }
    }

    private void h() {
        String str;
        String str2;
        String str3 = "";
        int i = 8;
        if (this.Q3 == null) {
            this.z.setText(str3);
            this.z.setHint(R.string.smart_action_add_tasks_example);
            this.p1.setVisibility(8);
            this.N3.setVisibility(8);
            this.O3.setVisibility(8);
            this.P3.setVisibility(8);
            return;
        }
        this.z.clearFocus();
        SmartTrigger triggerSetting = this.Q3.getTriggerSetting();
        SmartAction actionSetting = this.Q3.getActionSetting();
        this.R3.A(triggerSetting);
        this.S3.t(actionSetting);
        boolean z = triggerSetting != null && triggerSetting.isManual();
        this.T3.i0(z);
        ActionSetupViewModel actionSetupViewModel = this.T3;
        actionSetupViewModel.l0(actionSetupViewModel.g());
        if (!(triggerSetting == null || triggerSetting.getCondition() == null)) {
            this.T3.m0(triggerSetting.getCondition().byteValue());
        }
        int o = this.T3.o();
        this.X3 = o;
        if (o == 1) {
            str = getString(R.string.smart_list_tab_title);
        } else if (z) {
            str = getString(R.string.smart_action_edit_shortcut);
        } else {
            str = getString(R.string.smart_action_edit_automation);
        }
        this.y.setText(str);
        this.z.setText(this.T3.p());
        K0();
        this.W3 = 0;
        if (!(triggerSetting == null || triggerSetting.getSchedules() == null)) {
            this.W3 += triggerSetting.getSchedules().size();
        }
        if (!(triggerSetting == null || triggerSetting.getThings() == null)) {
            this.W3 += triggerSetting.getThings().size();
        }
        this.p1.setVisibility(z ? 0 : 8);
        this.N3.setVisibility((z || this.W3 == 0) ? 8 : 0);
        this.O3.setVisibility((z || this.W3 == 0) ? 8 : 0);
        this.P3.setVisibility((z || this.W3 == 0) ? 8 : 0);
        if (z) {
            e1();
        }
        boolean z2 = !z && this.W3 > 1;
        this.p0.setVisibility(z2 ? 0 : 8);
        byte H = this.T3.H();
        if (z2) {
            this.p0.setSelection(H);
        }
        boolean z3 = z2 && (H == 1) && !I0(triggerSetting);
        this.I3.setVisibility(z3 ? 0 : 8);
        this.p3.setVisibility(z3 ? 0 : 8);
        this.L3.setVisibility(c1(triggerSetting) ? 8 : 0);
        this.L3.setItemInfo(this.R3.getItemCount() > 0 ? str3 : getResources().getString(R.string.smart_action_add_condition_example));
        ItemSmartSettingLayout itemSmartSettingLayout = this.M3;
        if (this.S3.getItemCount() <= 0) {
            str3 = getResources().getString(R.string.smart_action_add_tasks_example);
        }
        itemSmartSettingLayout.setItemInfo(str3);
        int G = this.T3.G(this.Q3);
        this.T3.k0(G);
        TextView textView = this.J3;
        if (G == 0) {
            str2 = getString(R.string.smart_action_then_delay);
        } else {
            int i2 = G % 3600;
            str2 = getString(R.string.smart_action_then_delay_minutes_v2, Integer.valueOf(G / 3600), Integer.valueOf(i2 / 60), Integer.valueOf(i2 % 60));
        }
        textView.setText(str2);
        Button button = this.K3;
        if (this.X3 == 2) {
            i = 0;
        }
        button.setVisibility(i);
    }

    private void h1(int i) {
        String str;
        TextView textView = this.J3;
        if (i == 0) {
            str = getString(R.string.smart_action_then_delay);
        } else {
            int i2 = i % 3600;
            str = getString(R.string.smart_action_then_delay_minutes_v2, Integer.valueOf(i / 3600), Integer.valueOf(i2 / 60), Integer.valueOf(i2 % 60));
        }
        textView.setText(str);
        this.T3.q0(i);
    }

    private boolean i1(CharSequence charSequence) {
        return !TextUtils.isEmpty(charSequence);
    }

    @Override // com.tplink.iot.adapter.smart.SmartTriggerAdapter.a
    public void I(g gVar) {
        List<SmartThingTrigger> things;
        b.d.w.f.a.g(this.U3);
        SmartInfo v = this.T3.v();
        if (!(v == null || v.getTriggerSetting() == null)) {
            if (v.getTriggerSetting().isManual()) {
                v.getTriggerSetting().setManual(false);
                this.T3.i0(false);
            } else if (gVar.a() == 0) {
                List<SmartScheduleSetting> schedules = v.getTriggerSetting().getSchedules();
                if (!(schedules == null || gVar.b() == null)) {
                    schedules.remove(gVar.b());
                }
            } else if (!(gVar.a() != 1 || (things = v.getTriggerSetting().getThings()) == null || gVar.d() == null)) {
                things.remove(gVar.d());
            }
            this.T3.p0(v);
        }
        K0();
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        this.T3.d0(editable.toString());
        K0();
    }

    public void b1(a aVar) {
        this.Y3 = aVar;
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // com.tplink.iot.base.BaseFragment, com.tplink.iot.i.a
    public boolean d() {
        a aVar = this.Y3;
        if (aVar != null) {
            MenuItem menuItem = this.x;
            aVar.b(menuItem != null && menuItem.isEnabled());
        }
        return true;
    }

    @Override // com.tplink.iot.adapter.smart.SmartTaskAdapter.a
    public void i0(int i) {
        b.d.w.f.a.g(this.U3);
        SmartInfo v = this.T3.v();
        List<e> r = this.S3.r();
        r.remove(i);
        g1(v, r);
        this.T3.p0(v);
        ActionSetupViewModel actionSetupViewModel = this.T3;
        actionSetupViewModel.l0(actionSetupViewModel.g());
        K0();
    }

    @Override // com.tplink.iot.adapter.smart.SmartTriggerAdapter.a
    public void o(g gVar) {
        BaseALIoTDevice l;
        b.d.w.f.a.g(this.U3);
        if (gVar != null && gVar.d() != null && (l = ((SmartActionViewModel) ViewModelProviders.of(this.U3).get(SmartActionViewModel.class)).l(gVar.c())) != null && l.getThingDevice() != null) {
            this.T3.f0(l);
            a aVar = this.Y3;
            if (aVar != null) {
                aVar.d();
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        b.d.w.f.a.g(this.U3);
        switch (view.getId()) {
            case R.id.btn_edit_action_delete /* 2131362057 */:
                if (this.X3 == 2) {
                    d1();
                    return;
                }
                return;
            case R.id.ll_shortcut_icon /* 2131363335 */:
                a aVar = this.Y3;
                if (aVar != null) {
                    aVar.c();
                    return;
                }
                return;
            case R.id.rl_add_conditions /* 2131363872 */:
                if (this.W3 >= 10) {
                    s0.p(this.U3, getString(R.string.smart_action_add_condition_limit_tip, 10));
                    return;
                }
                a aVar2 = this.Y3;
                if (aVar2 != null) {
                    aVar2.e();
                    return;
                }
                return;
            case R.id.rl_add_tasks /* 2131363873 */:
                a aVar3 = this.Y3;
                if (aVar3 != null) {
                    aVar3.g();
                    return;
                }
                return;
            case R.id.tv_action_tasks_delay /* 2131364328 */:
                this.V3 = this.T3.F();
                n0.a(getFragmentManager(), this.V3, new HMSPickerDialog.b() { // from class: com.tplink.iot.view.smart.actionsetup.j
                    @Override // com.tplink.iot.widget.HMSPickerDialog.b
                    public final void a(HMSPickerDialog hMSPickerDialog, int i) {
                        ActionSetupFragment.this.N0(hMSPickerDialog, i);
                    }
                }, "tag_action_delay_offset");
                return;
            case R.id.tv_effective_time /* 2131364442 */:
                a aVar4 = this.Y3;
                if (aVar4 != null) {
                    aVar4.i();
                    return;
                }
                return;
            default:
                return;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(R.menu.menu_done, menu);
        this.x = menu.findItem(R.id.action_done);
        K0();
        super.onCreateOptionsMenu(menu, menuInflater);
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.q = layoutInflater.inflate(R.layout.fragment_smart_action_detail, viewGroup, false);
        ActionDetailActivity actionDetailActivity = (ActionDetailActivity) getActivity();
        this.U3 = actionDetailActivity;
        if (actionDetailActivity == null) {
            B0();
        }
        d.J(this.U3, this.q.findViewById(R.id.toolbar));
        setHasOptionsMenu(true);
        H0();
        ActionSetupViewModel actionSetupViewModel = (ActionSetupViewModel) ViewModelProviders.of(this.U3).get(ActionSetupViewModel.class);
        this.T3 = actionSetupViewModel;
        actionSetupViewModel.M(false);
        f1();
        return this.q;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        b.d.w.f.a.g(this.U3);
        SmartInfo v = this.T3.v();
        SmartTrigger triggerSetting = v.getTriggerSetting();
        if (triggerSetting != null && !triggerSetting.isManual() && this.p0.getVisibility() != 8) {
            char c2 = i == 0 ? (char) 1 : (char) 0;
            if (c2 != 0 || I0(triggerSetting)) {
                this.I3.setVisibility(8);
                this.p3.setVisibility(8);
                triggerSetting.setCondition(Byte.valueOf(c2 ^ 1 ? (byte) 1 : (byte) 0));
                v.setTriggerSetting(triggerSetting);
                this.T3.p0(v);
            } else {
                this.I3.setVisibility(0);
                this.p3.setVisibility(0);
            }
            K0();
        }
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    @Override // com.tplink.iot.base.BaseFragment, androidx.fragment.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.action_done) {
            s0.l(this.U3);
            v.d();
            SmartInfo v = this.T3.v();
            v.setName(this.z.getText().toString());
            if (v.getTriggerSetting() == null) {
                v.setTriggerSetting(new SmartTrigger());
            }
            if (this.T3.N()) {
                v.getTriggerSetting().setSchedules(null);
                v.getTriggerSetting().setThings(null);
            } else {
                v.getTriggerSetting().setCondition(Byte.valueOf(this.T3.H()));
            }
            this.T3.j0(this.Q3, false);
            return true;
        } else if (menuItem.getItemId() != 16908332) {
            return true;
        } else {
            d();
            return true;
        }
    }

    @Override // com.tplink.iot.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        a1();
        super.onResume();
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // com.tplink.iot.adapter.smart.SmartTaskAdapter.a
    public void u(int i, e eVar) {
        b.d.w.f.a.g(this.U3);
        if (eVar != null) {
            SmartActionViewModel smartActionViewModel = (SmartActionViewModel) ViewModelProviders.of(this.U3).get(SmartActionViewModel.class);
            if (eVar.b() == 0) {
                SmartInfo m = smartActionViewModel.m(eVar.d());
                if (m != null) {
                    boolean isManual = m.getTriggerSetting().isManual();
                    if (this.Y3 != null && !isManual) {
                        this.T3.h0(m, eVar.a() != 0);
                        this.Y3.f();
                        return;
                    }
                    return;
                }
                return;
            }
            BaseALIoTDevice l = smartActionViewModel.l(eVar.h());
            if (l != null && l.getThingDevice() != null) {
                this.T3.f0(l);
                a aVar = this.Y3;
                if (aVar != null) {
                    aVar.a();
                }
            }
        }
    }
}
