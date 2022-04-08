package com.tplink.iot.devices.featuredactions.view.base;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.DrawableRes;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.navigation.fragment.FragmentKt;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import com.tplink.iot.R;
import com.tplink.iot.Utils.z0.q;
import com.tplink.iot.cloud.bean.smart.common.SmartInfo;
import com.tplink.iot.cloud.bean.thing.common.ThingModel;
import com.tplink.iot.databinding.FragmentAbstractFeaturedActionBinding;
import com.tplink.iot.devicecommon.view.IoTMVVMBaseFragment;
import com.tplink.iot.devices.featuredactions.adapter.FeaturedActionDeviceSelectAdapter;
import com.tplink.iot.devices.featuredactions.viewmodel.base.AbstractFeaturedActionViewModel;
import com.tplink.iot.view.smart.actionsetup.ActionDetailActivity;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.enumerate.EnumIoTAvatarType;
import com.tplink.libtpnetwork.enumerate.EnumIoTCategory;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.n;
import kotlin.collections.o;
import kotlin.collections.v;
import kotlin.jvm.b.l;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import kotlin.p;

/* compiled from: AbstractFeaturedActionFragment.kt */
/* loaded from: classes2.dex */
public abstract class AbstractFeaturedActionFragment<VM extends AbstractFeaturedActionViewModel> extends IoTMVVMBaseFragment<FragmentAbstractFeaturedActionBinding> {
    public static final a p1 = new a(null);
    private MenuItem H3;
    private FeaturedActionDeviceSelectAdapter I3;
    private HashMap J3;
    private final String p2;
    private final kotlin.f p3;

    /* compiled from: AbstractFeaturedActionFragment.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AbstractFeaturedActionFragment.kt */
    /* loaded from: classes2.dex */
    public static final class b extends Lambda implements kotlin.jvm.b.a<p> {
        b() {
            super(0);
        }

        public final void a() {
            AbstractFeaturedActionFragment.this.h1();
        }

        @Override // kotlin.jvm.b.a
        public /* bridge */ /* synthetic */ p invoke() {
            a();
            return p.a;
        }
    }

    /* compiled from: AbstractFeaturedActionFragment.kt */
    /* loaded from: classes2.dex */
    static final class c extends Lambda implements kotlin.jvm.b.a<VM> {
        c() {
            super(0);
        }

        /* renamed from: a */
        public final VM invoke() {
            return (VM) AbstractFeaturedActionFragment.this.g1();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AbstractFeaturedActionFragment.kt */
    /* loaded from: classes2.dex */
    public static final class d extends Lambda implements l<com.tplink.iot.Utils.extension.f, p> {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ SmartInfo f7445d;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: AbstractFeaturedActionFragment.kt */
        /* loaded from: classes2.dex */
        public static final class a extends Lambda implements kotlin.jvm.b.a<p> {
            a() {
                super(0);
            }

            public final void a() {
                d dVar = d.this;
                AbstractFeaturedActionFragment.this.i1(dVar.f7445d);
            }

            @Override // kotlin.jvm.b.a
            public /* bridge */ /* synthetic */ p invoke() {
                a();
                return p.a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(SmartInfo smartInfo) {
            super(1);
            this.f7445d = smartInfo;
        }

        public final void a(com.tplink.iot.Utils.extension.f receiver) {
            j.e(receiver, "$receiver");
            receiver.h(R.string.scene_apply_dialog_hint);
            com.tplink.iot.Utils.extension.f.e(receiver, R.string.common_cancel, receiver.a(), null, 4, null);
            receiver.f(R.string.common_create, receiver.b(), new a());
        }

        @Override // kotlin.jvm.b.l
        public /* bridge */ /* synthetic */ p invoke(com.tplink.iot.Utils.extension.f fVar) {
            a(fVar);
            return p.a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AbstractFeaturedActionFragment.kt */
    /* loaded from: classes2.dex */
    public static final class e extends Lambda implements l<com.tplink.iot.Utils.extension.f, p> {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ SmartInfo[] f7448d;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: AbstractFeaturedActionFragment.kt */
        /* loaded from: classes2.dex */
        public static final class a extends Lambda implements kotlin.jvm.b.a<p> {
            a() {
                super(0);
            }

            public final void a() {
                AbstractFeaturedActionFragment.this.b1().g(e.this.f7448d);
            }

            @Override // kotlin.jvm.b.a
            public /* bridge */ /* synthetic */ p invoke() {
                a();
                return p.a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(SmartInfo[] smartInfoArr) {
            super(1);
            this.f7448d = smartInfoArr;
        }

        public final void a(com.tplink.iot.Utils.extension.f receiver) {
            j.e(receiver, "$receiver");
            receiver.h(R.string.scene_apply_dialog_multi_smarts_hint);
            com.tplink.iot.Utils.extension.f.e(receiver, R.string.common_cancel, receiver.a(), null, 4, null);
            receiver.f(R.string.create_now, receiver.b(), new a());
        }

        @Override // kotlin.jvm.b.l
        public /* bridge */ /* synthetic */ p invoke(com.tplink.iot.Utils.extension.f fVar) {
            a(fVar);
            return p.a;
        }
    }

    /* compiled from: AbstractFeaturedActionFragment.kt */
    /* loaded from: classes2.dex */
    static final class f<T> implements Observer<List<? extends BaseALIoTDevice<?>>> {
        f() {
        }

        /* renamed from: a */
        public final void onChanged(List<? extends BaseALIoTDevice<?>> list) {
            if (list != null) {
                AbstractFeaturedActionFragment.this.j1(list);
            }
        }
    }

    /* compiled from: AbstractFeaturedActionFragment.kt */
    /* loaded from: classes2.dex */
    static final class g<T> implements Observer<List<? extends com.tplink.iot.g.a.a.b>> {
        g() {
        }

        /* renamed from: a */
        public final void onChanged(List<com.tplink.iot.g.a.a.b> list) {
            if (list != null) {
                AbstractFeaturedActionFragment.this.l1(list);
            }
        }
    }

    /* compiled from: AbstractFeaturedActionFragment.kt */
    /* loaded from: classes2.dex */
    static final class h<T> implements Observer<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Integer>> {
        h() {
        }

        /* renamed from: a */
        public final void onChanged(com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Integer> aVar) {
            if (aVar != null) {
                AbstractFeaturedActionFragment.this.k1(aVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AbstractFeaturedActionFragment.kt */
    /* loaded from: classes2.dex */
    public static final class i extends Lambda implements l<Boolean, p> {
        i() {
            super(1);
        }

        public final void a(boolean z) {
            AbstractFeaturedActionFragment.this.p1(!z);
        }

        @Override // kotlin.jvm.b.l
        public /* bridge */ /* synthetic */ p invoke(Boolean bool) {
            a(bool.booleanValue());
            return p.a;
        }
    }

    public AbstractFeaturedActionFragment() {
        kotlin.f b2;
        b2 = kotlin.i.b(new c());
        this.p3 = b2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h1() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i1(SmartInfo smartInfo) {
        startActivityForResult(ActionDetailActivity.G1(requireContext(), smartInfo), 1180);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j1(List<? extends BaseALIoTDevice<?>> list) {
        List<com.tplink.iot.g.a.a.b> m1 = m1(X0(list));
        List<com.tplink.iot.model.iot.b> Z0 = Z0(m1, d1());
        int i2 = 0;
        boolean z = m1.isEmpty() && Z0.isEmpty();
        TextView textView = J0().q;
        j.d(textView, "mBinding.tvEmpty");
        if (!z) {
            i2 = 8;
        }
        textView.setVisibility(i2);
        if (!z) {
            v1(m1, Z0);
            b1().G(m1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l1(List<com.tplink.iot.g.a.a.b> list) {
        v1(list, Z0(list, d1()));
    }

    private final List<com.tplink.iot.g.a.a.b> m1(List<? extends BaseALIoTDevice<?>> list) {
        int l;
        l = o.l(list, 10);
        ArrayList arrayList = new ArrayList(l);
        for (BaseALIoTDevice<?> baseALIoTDevice : list) {
            arrayList.add(new com.tplink.iot.g.a.a.b(baseALIoTDevice, W0(baseALIoTDevice), null, 4, null));
        }
        return arrayList;
    }

    private final void o1() {
        List<BaseALIoTDevice<?>> list;
        FeaturedActionDeviceSelectAdapter featuredActionDeviceSelectAdapter = this.I3;
        if (featuredActionDeviceSelectAdapter == null || (list = featuredActionDeviceSelectAdapter.J()) == null) {
            list = n.d();
        }
        SmartInfo[] n1 = n1(list);
        if (n1.length == 1) {
            q1(n1[0]);
        } else if (n1.length == 2) {
            r1(n1);
        }
    }

    private final void q1(SmartInfo smartInfo) {
        Context context = getContext();
        if (context != null) {
            com.tplink.iot.Utils.extension.e.r(context, new d(smartInfo));
        }
    }

    private final void r1(SmartInfo[] smartInfoArr) {
        Context context = getContext();
        if (context != null) {
            com.tplink.iot.Utils.extension.e.r(context, new e(smartInfoArr));
        }
    }

    private final void v1(List<com.tplink.iot.g.a.a.b> list, List<com.tplink.iot.model.iot.b> list2) {
        if (this.I3 == null) {
            Context requireContext = requireContext();
            j.d(requireContext, "requireContext()");
            FeaturedActionDeviceSelectAdapter featuredActionDeviceSelectAdapter = new FeaturedActionDeviceSelectAdapter(requireContext);
            featuredActionDeviceSelectAdapter.Q(new i());
            p pVar = p.a;
            this.I3 = featuredActionDeviceSelectAdapter;
            RecyclerView recyclerView = J0().f6820d;
            j.d(recyclerView, "mBinding.recyclerViewDevice");
            recyclerView.setAdapter(this.I3);
        }
        FeaturedActionDeviceSelectAdapter featuredActionDeviceSelectAdapter2 = this.I3;
        if (featuredActionDeviceSelectAdapter2 != null) {
            featuredActionDeviceSelectAdapter2.O(list, list2);
        }
    }

    @Override // com.tplink.iot.base.BaseFragment
    public void B0() {
        FragmentKt.findNavController(this).popBackStack();
    }

    @Override // com.tplink.iot.devicecommon.view.IoTMVVMBaseFragment
    public void H0() {
        HashMap hashMap = this.J3;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    @Override // com.tplink.iot.devicecommon.view.IoTMVVMBaseFragment
    public int I0() {
        return R.layout.fragment_abstract_featured_action;
    }

    @Override // com.tplink.iot.devicecommon.view.IoTMVVMBaseFragment
    public void N0() {
        String str;
        TextView textView = J0().y;
        j.d(textView, "mBinding.tvTitle");
        textView.setText(f1());
        TextView textView2 = J0().f6821f;
        j.d(textView2, "mBinding.tvDescription");
        textView2.setText(a1());
        J0().f6819c.setImageResource(c1());
        TextView textView3 = J0().x;
        textView3.setVisibility(e1() != null ? 0 : 8);
        if (e1() == null) {
            str = "";
        } else {
            str = "* " + e1();
        }
        textView3.setText(str);
        RecyclerView recyclerView = J0().f6820d;
        j.d(recyclerView, "mBinding.recyclerViewDevice");
        RecyclerView.ItemAnimator itemAnimator = recyclerView.getItemAnimator();
        if (!(itemAnimator instanceof SimpleItemAnimator)) {
            itemAnimator = null;
        }
        SimpleItemAnimator simpleItemAnimator = (SimpleItemAnimator) itemAnimator;
        if (simpleItemAnimator != null) {
            simpleItemAnimator.setSupportsChangeAnimations(false);
        }
    }

    @Override // com.tplink.iot.devicecommon.view.IoTMVVMBaseFragment
    @CallSuper
    public void R0() {
        b1().m().observe(getViewLifecycleOwner(), new f());
        b1().r().observe(getViewLifecycleOwner(), new g());
        b1().o().observe(getViewLifecycleOwner(), new h());
    }

    public abstract boolean W0(BaseALIoTDevice<?> baseALIoTDevice);

    protected final List<BaseALIoTDevice<?>> X0(List<? extends BaseALIoTDevice<?>> deviceList) {
        boolean v;
        j.e(deviceList, "deviceList");
        List<EnumIoTCategory> d1 = d1();
        ArrayList arrayList = new ArrayList();
        for (Object obj : deviceList) {
            v = v.v(d1, EnumIoTCategory.fromString(((BaseALIoTDevice) obj).getCategory()));
            if (v) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    protected final com.tplink.iot.model.iot.b Y0(EnumIoTCategory category) {
        j.e(category, "category");
        switch (a.a[category.ordinal()]) {
            case 1:
                String string = getString(R.string.smart_bulb);
                j.d(string, "getString(R.string.smart_bulb)");
                return new com.tplink.iot.model.iot.b(R.mipmap.iot_bulb_48, string, category, "https://www.tapo.com/en/product/smart-light-bulb/");
            case 2:
                String string2 = getString(R.string.smart_light_strip);
                j.d(string2, "getString(R.string.smart_light_strip)");
                return new com.tplink.iot.model.iot.b(R.mipmap.iot_light_strip_48, string2, category, "https://www.tapo.com/en/product/smart-light-bulb/");
            case 3:
                int h2 = q.h(EnumIoTAvatarType.PLUG);
                String string3 = getString(R.string.plug);
                j.d(string3, "getString(R.string.plug)");
                return new com.tplink.iot.model.iot.b(h2, string3, category, "https://www.tapo.com/en/product/smart-plug/");
            case 4:
            case 5:
                String string4 = getString(R.string.smart_hub);
                j.d(string4, "getString(R.string.smart_hub)");
                return new com.tplink.iot.model.iot.b(R.mipmap.iot_hub_48, string4, category, null, 8, null);
            case 6:
                String string5 = getString(R.string.smart_camera);
                j.d(string5, "getString(R.string.smart_camera)");
                return new com.tplink.iot.model.iot.b(R.mipmap.iot_camera_54, string5, category, null, 8, null);
            case 7:
                String string6 = getString(R.string.plug);
                j.d(string6, "getString(R.string.plug)");
                return new com.tplink.iot.model.iot.b(R.mipmap.iot_plug_48, string6, category, null, 8, null);
            case 8:
                String string7 = getString(R.string.smart_switch);
                j.d(string7, "getString(R.string.smart_switch)");
                return new com.tplink.iot.model.iot.b(R.mipmap.iot_switch_48, string7, category, null, 8, null);
            case 9:
                String string8 = getString(R.string.smart_button);
                j.d(string8, "getString(R.string.smart_button)");
                return new com.tplink.iot.model.iot.b(R.mipmap.iot_button_s200b_48, string8, category, null, 8, null);
            case 10:
                String string9 = getString(R.string.iot_motion_sensor);
                j.d(string9, "getString(R.string.iot_motion_sensor)");
                return new com.tplink.iot.model.iot.b(R.mipmap.iot_sensor_48, string9, category, null, 8, null);
            case 11:
                String string10 = getString(R.string.iot_contact_sensor);
                j.d(string10, "getString(R.string.iot_contact_sensor)");
                return new com.tplink.iot.model.iot.b(R.mipmap.iot_sensor_t110_48, string10, category, null, 8, null);
            case 12:
                String string11 = getString(R.string.smart_thermostat);
                j.d(string11, "getString(R.string.smart_thermostat)");
                return new com.tplink.iot.model.iot.b(R.mipmap.iot_trv_48, string11, category, null, 8, null);
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    protected final List<com.tplink.iot.model.iot.b> Z0(List<com.tplink.iot.g.a.a.b> devices, List<? extends EnumIoTCategory> supportCategories) {
        int l;
        j.e(devices, "devices");
        j.e(supportCategories, "supportCategories");
        ArrayList<EnumIoTCategory> arrayList = new ArrayList(supportCategories);
        for (com.tplink.iot.g.a.a.b bVar : devices) {
            if (arrayList.isEmpty()) {
                break;
            }
            arrayList.remove(EnumIoTCategory.fromString(bVar.a().getCategory()));
        }
        l = o.l(arrayList, 10);
        ArrayList arrayList2 = new ArrayList(l);
        for (EnumIoTCategory it : arrayList) {
            j.d(it, "it");
            arrayList2.add(Y0(it));
        }
        return arrayList2;
    }

    public abstract String a1();

    /* JADX INFO: Access modifiers changed from: protected */
    public final VM b1() {
        return (VM) ((AbstractFeaturedActionViewModel) this.p3.getValue());
    }

    @DrawableRes
    public abstract int c1();

    public abstract List<EnumIoTCategory> d1();

    public String e1() {
        return this.p2;
    }

    public abstract String f1();

    public abstract VM g1();

    protected final void k1(com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Integer> event) {
        FragmentActivity activity;
        j.e(event, "event");
        Integer a2 = event.a();
        if (a2 != null && a2.intValue() == 100) {
            FragmentActivity activity2 = getActivity();
            if (activity2 != null) {
                com.tplink.iot.Utils.extension.e.m(activity2, null, 1, null);
            }
        } else if (a2 != null && a2.intValue() == 200) {
            FragmentActivity activity3 = getActivity();
            if (activity3 != null) {
                com.tplink.iot.Utils.extension.e.f(activity3, new b());
            }
        } else if (a2 != null && a2.intValue() == 300 && (activity = getActivity()) != null) {
            com.tplink.iot.Utils.extension.e.e(activity, null, 1, null);
        }
    }

    public abstract SmartInfo[] n1(List<? extends BaseALIoTDevice<?>> list);

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        if (i3 == -1 && i2 == 1180) {
            h1();
        }
    }

    @Override // com.tplink.iot.devicecommon.view.IoTMVVMBaseFragment, com.tplink.iot.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setHasOptionsMenu(true);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        j.e(menu, "menu");
        j.e(inflater, "inflater");
        inflater.inflate(R.menu.menu_apply, menu);
        this.H3 = menu.findItem(R.id.action_apply);
        p1(false);
    }

    @Override // com.tplink.iot.devicecommon.view.IoTMVVMBaseFragment, com.tplink.iot.base.BaseFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        H0();
    }

    @Override // com.tplink.iot.base.BaseFragment, androidx.fragment.app.Fragment
    public boolean onOptionsItemSelected(MenuItem item) {
        j.e(item, "item");
        if (item.getItemId() != R.id.action_apply) {
            return super.onOptionsItemSelected(item);
        }
        o1();
        return true;
    }

    protected final void p1(boolean z) {
        MenuItem menuItem = this.H3;
        if (menuItem != null) {
            menuItem.setEnabled(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean s1(ThingModel supportEvent, String eventId) {
        j.e(supportEvent, "$this$supportEvent");
        j.e(eventId, "eventId");
        return supportEvent.getThingEvent(eventId) != null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean t1(ThingModel supportProperty, String propertyId) {
        j.e(supportProperty, "$this$supportProperty");
        j.e(propertyId, "propertyId");
        return supportProperty.getThingProperty(propertyId) != null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean u1(ThingModel supportService, String serviceId) {
        j.e(supportService, "$this$supportService");
        j.e(serviceId, "serviceId");
        return supportService.getThingService(serviceId) != null;
    }
}
