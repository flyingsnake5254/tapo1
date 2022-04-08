package com.tplink.iot.view.smart.actionsetup;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.iot.R;
import com.tplink.iot.base.BaseFragment;
import com.tplink.iot.cloud.bean.smart.common.SmartAction;
import com.tplink.iot.cloud.bean.smart.common.SmartInfo;
import com.tplink.iot.cloud.bean.smart.common.SmartTrigger;
import com.tplink.iot.cloud.bean.thing.common.ThingModel;
import com.tplink.iot.view.smart.b.h;
import com.tplink.iot.view.smart.b.i;
import com.tplink.iot.viewmodel.smart.ActionSetupViewModel;
import com.tplink.iot.viewmodel.smart.DeviceChooseViewModel;
import com.tplink.iot.widget.ItemSmartSettingLayout;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.b.l;

/* loaded from: classes2.dex */
public class ConditionAddFragment extends BaseFragment {
    private DeviceChooseViewModel p0;
    private f p1;
    private ItemSmartSettingLayout q;
    private ItemSmartSettingLayout x;
    private ActionDetailActivity y;
    private ActionSetupViewModel z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements Observer<SmartInfo> {
        a() {
        }

        /* renamed from: a */
        public void onChanged(@Nullable SmartInfo smartInfo) {
            ConditionAddFragment.this.h();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ConditionAddFragment.this.B0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ConditionAddFragment.this.p1 != null) {
                ConditionAddFragment.this.p1.b();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ConditionAddFragment.this.p1 != null) {
                ConditionAddFragment.this.p1.c();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class e implements View.OnClickListener {
        e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SmartInfo v = ConditionAddFragment.this.z.v();
            SmartTrigger smartTrigger = new SmartTrigger();
            smartTrigger.setManual(true);
            v.setTriggerSetting(smartTrigger);
            ConditionAddFragment.this.z.i0(true);
            ConditionAddFragment.this.z.p0(v);
            if (ConditionAddFragment.this.p1 != null) {
                ConditionAddFragment.this.p1.a();
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface f {
        void a();

        void b();

        void c();
    }

    /* loaded from: classes2.dex */
    public static class g extends com.bumptech.glide.request.k.d<ItemSmartSettingLayout, Drawable> {
        private ImageView z;

        /* JADX INFO: Access modifiers changed from: package-private */
        public g(@NonNull ItemSmartSettingLayout itemSmartSettingLayout) {
            super(itemSmartSettingLayout);
            this.z = (ImageView) itemSmartSettingLayout.findViewById(R.id.iv_setting_item_icon);
        }

        @Override // com.bumptech.glide.request.k.j
        public void h(@Nullable Drawable drawable) {
            ImageView imageView = this.z;
            if (imageView != null) {
                imageView.setImageResource(R.mipmap.ic_blue_add);
            }
        }

        @Override // com.bumptech.glide.request.k.d
        protected void l(@Nullable Drawable drawable) {
        }

        /* renamed from: o */
        public void e(@NonNull Drawable drawable, @Nullable com.bumptech.glide.request.l.b<? super Drawable> bVar) {
            ImageView imageView = this.z;
            if (imageView != null) {
                imageView.setImageDrawable(drawable);
            }
        }
    }

    private void K0(View view) {
        ((TextView) view.findViewById(R.id.toolbar_title)).setText(R.string.smart_action_add_condition);
        ((Toolbar) view.findViewById(R.id.toolbar)).setNavigationOnClickListener(new b());
        this.q = (ItemSmartSettingLayout) view.findViewById(R.id.rl_with_tap);
        ItemSmartSettingLayout itemSmartSettingLayout = (ItemSmartSettingLayout) view.findViewById(R.id.rl_trigger_timer);
        this.x = (ItemSmartSettingLayout) view.findViewById(R.id.rl_trigger_device);
        com.bumptech.glide.c.x(this.y).s("file:///android_asset/smart_icons/SmartOneClickBlueBackground.png").u0(new g(this.q));
        com.bumptech.glide.c.x(this.y).s("file:///android_asset/smart_icons/SmartTimeTriggerBlueBackground.png").u0(new g(itemSmartSettingLayout));
        com.bumptech.glide.c.x(this.y).s("file:///android_asset/smart_icons/SmartDeviceTriggerBlueBackground.png").u0(new g(this.x));
        itemSmartSettingLayout.setOnClickListener(new c());
        this.x.setOnClickListener(new d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: N0 */
    public /* synthetic */ ThingModel O0(BaseALIoTDevice baseALIoTDevice) {
        return this.p0.i(baseALIoTDevice);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ List P0(List list) {
        return list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q0(List<BaseALIoTDevice> list) {
        boolean z;
        boolean z2;
        SmartAction actionSetting = this.z.v().getActionSetting();
        final ArrayList arrayList = new ArrayList();
        if (!(actionSetting == null || actionSetting.getThings() == null)) {
            arrayList.addAll(actionSetting.getThings());
        }
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(new com.tplink.iot.view.smart.b.e());
        arrayList2.add(new com.tplink.iot.view.smart.b.g(new l() { // from class: com.tplink.iot.view.smart.actionsetup.o
            @Override // kotlin.jvm.b.l
            public final Object invoke(Object obj) {
                return ConditionAddFragment.this.O0((BaseALIoTDevice) obj);
            }
        }));
        arrayList2.add(new h());
        arrayList2.add(new i(new kotlin.jvm.b.a() { // from class: com.tplink.iot.view.smart.actionsetup.n
            @Override // kotlin.jvm.b.a
            public final Object invoke() {
                List list2 = arrayList;
                ConditionAddFragment.P0(list2);
                return list2;
            }
        }));
        arrayList2.add(new com.tplink.iot.view.smart.b.f());
        if (list != null) {
            for (BaseALIoTDevice<?> baseALIoTDevice : list) {
                Iterator it = arrayList2.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (!((com.tplink.iot.view.smart.b.d) it.next()).a(baseALIoTDevice)) {
                            z2 = false;
                            continue;
                            break;
                        }
                    } else {
                        z2 = true;
                        continue;
                        break;
                    }
                }
                if (z2) {
                    z = true;
                    break;
                }
            }
        }
        z = false;
        if (z) {
            this.x.setEnabled(true);
            this.x.setItemEnable(true);
            this.x.setItemInfo(getString(R.string.smart_action_trigger_device_description));
            return;
        }
        this.x.setEnabled(false);
        this.x.setItemEnable(false);
        this.x.setItemInfo(getString(R.string.not_add_device_remind));
    }

    private void S0() {
        this.z.D().observe(getViewLifecycleOwner(), new a());
        this.z.r().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tplink.iot.view.smart.actionsetup.m
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ConditionAddFragment.this.Q0((List) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        if (this.z.P()) {
            this.q.setVisibility(8);
            return;
        }
        this.q.setVisibility(0);
        this.q.setOnClickListener(new e());
    }

    public void R0(f fVar) {
        this.p1 = fVar;
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
        View inflate = layoutInflater.inflate(R.layout.fragment_smart_add_conditions, viewGroup, false);
        ActionDetailActivity actionDetailActivity = (ActionDetailActivity) getActivity();
        this.y = actionDetailActivity;
        if (actionDetailActivity == null) {
            B0();
        }
        com.tplink.iot.view.quicksetup.base.d.J(this.y, inflate.findViewById(R.id.toolbar));
        this.z = (ActionSetupViewModel) ViewModelProviders.of(this.y).get(ActionSetupViewModel.class);
        this.p0 = (DeviceChooseViewModel) ViewModelProviders.of(this.y).get(DeviceChooseViewModel.class);
        setHasOptionsMenu(true);
        K0(inflate);
        S0();
        return inflate;
    }
}
