package com.tplink.iot.view.iothub.guardmode;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.R;
import com.tplink.iot.adapter.iothub.GuardModeAlarmTimeAdapter;
import com.tplink.iot.databinding.FragmentGuardModeSetAlarmTimeBinding;
import com.tplink.iot.widget.NumberPickerView;
import com.tplink.libtpnetwork.IoTNetwork.bean.hub.result.GuardModeAlarmTimeBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.hub.result.GuardModeConfigBean;
import com.tplink.libtpnetwork.enumerate.EnumGuardModeAlarmTimeType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import kotlin.collections.o;
import kotlin.jvm.b.l;
import kotlin.jvm.b.q;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import kotlin.p;
import kotlin.text.u;

/* compiled from: SetAlarmTimeFragment.kt */
/* loaded from: classes2.dex */
public class SetAlarmTimeFragment extends BaseGuardModeSettingFragment {
    public static final a p0 = new a(null);
    private HashMap K3;
    private FragmentGuardModeSetAlarmTimeBinding p2;
    private GuardModeAlarmTimeAdapter p3;
    private final int p1 = R.string.gm_config_alarm_time;
    private int H3 = 300;
    private int I3 = -1;
    private int J3 = -1;

    /* compiled from: SetAlarmTimeFragment.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    /* compiled from: SetAlarmTimeFragment.kt */
    /* loaded from: classes2.dex */
    static final class b extends Lambda implements q<GuardModeAlarmTimeAdapter.a, Integer, Boolean, p> {
        b() {
            super(3);
        }

        public final void a(GuardModeAlarmTimeAdapter.a alarmTime, int i, boolean z) {
            j.e(alarmTime, "alarmTime");
            LinearLayout linearLayout = SetAlarmTimeFragment.this.b1().f7017c;
            j.d(linearLayout, "mBinding.llTimePicker");
            int i2 = 0;
            if (!(alarmTime.a() == GuardModeAlarmTimeAdapter.AlarmTimeItemType.CUSTOM)) {
                i2 = 8;
            }
            linearLayout.setVisibility(i2);
        }

        @Override // kotlin.jvm.b.q
        public /* bridge */ /* synthetic */ p invoke(GuardModeAlarmTimeAdapter.a aVar, Integer num, Boolean bool) {
            a(aVar, num.intValue(), bool.booleanValue());
            return p.a;
        }
    }

    /* compiled from: SetAlarmTimeFragment.kt */
    /* loaded from: classes2.dex */
    static final class c implements NumberPickerView.e {
        c() {
        }

        @Override // com.tplink.iot.widget.NumberPickerView.e
        public final void a(NumberPickerView numberPickerView, int i, int i2) {
            SetAlarmTimeFragment.this.I3 = i2;
            SetAlarmTimeFragment.this.Z0();
        }
    }

    /* compiled from: SetAlarmTimeFragment.kt */
    /* loaded from: classes2.dex */
    static final class d implements NumberPickerView.d {
        d() {
        }

        @Override // com.tplink.iot.widget.NumberPickerView.d
        public final void a(NumberPickerView numberPickerView, int i, int i2) {
            SetAlarmTimeFragment.this.f1();
        }
    }

    /* compiled from: SetAlarmTimeFragment.kt */
    /* loaded from: classes2.dex */
    static final class e implements NumberPickerView.e {
        e() {
        }

        @Override // com.tplink.iot.widget.NumberPickerView.e
        public final void a(NumberPickerView numberPickerView, int i, int i2) {
            SetAlarmTimeFragment.this.J3 = i2;
            SetAlarmTimeFragment.this.Z0();
        }
    }

    /* compiled from: SetAlarmTimeFragment.kt */
    /* loaded from: classes2.dex */
    static final class f implements NumberPickerView.d {
        f() {
        }

        @Override // com.tplink.iot.widget.NumberPickerView.d
        public final void a(NumberPickerView numberPickerView, int i, int i2) {
            SetAlarmTimeFragment.this.f1();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SetAlarmTimeFragment.kt */
    /* loaded from: classes2.dex */
    public static final class g<T> implements Observer<GuardModeConfigBean> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: SetAlarmTimeFragment.kt */
        /* loaded from: classes2.dex */
        public static final class a extends Lambda implements l<Integer, p> {
            a() {
                super(1);
            }

            public final void a(int i) {
                SetAlarmTimeFragment.this.H3 = i;
                SetAlarmTimeFragment.this.e1(i);
            }

            @Override // kotlin.jvm.b.l
            public /* bridge */ /* synthetic */ p invoke(Integer num) {
                a(num.intValue());
                return p.a;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: SetAlarmTimeFragment.kt */
        /* loaded from: classes2.dex */
        public static final class b extends Lambda implements l<Integer, p> {
            b() {
                super(1);
            }

            public final void a(int i) {
                SetAlarmTimeFragment setAlarmTimeFragment = SetAlarmTimeFragment.this;
                setAlarmTimeFragment.H3 = setAlarmTimeFragment.a1(i);
                SetAlarmTimeFragment setAlarmTimeFragment2 = SetAlarmTimeFragment.this;
                setAlarmTimeFragment2.e1(setAlarmTimeFragment2.H3);
            }

            @Override // kotlin.jvm.b.l
            public /* bridge */ /* synthetic */ p invoke(Integer num) {
                a(num.intValue());
                return p.a;
            }
        }

        g() {
        }

        /* renamed from: a */
        public final void onChanged(GuardModeConfigBean guardModeConfigBean) {
            if (guardModeConfigBean != null) {
                GuardModeAlarmTimeBean alarmTime = guardModeConfigBean.getAlarmTime();
                if (alarmTime.getEnumType() == EnumGuardModeAlarmTimeType.ALWAYS) {
                    SetAlarmTimeFragment.R0(SetAlarmTimeFragment.this).D(300, new a());
                } else {
                    SetAlarmTimeFragment.R0(SetAlarmTimeFragment.this).D(alarmTime.getTime(), new b());
                }
            }
        }
    }

    public static final /* synthetic */ GuardModeAlarmTimeAdapter R0(SetAlarmTimeFragment setAlarmTimeFragment) {
        GuardModeAlarmTimeAdapter guardModeAlarmTimeAdapter = setAlarmTimeFragment.p3;
        if (guardModeAlarmTimeAdapter == null) {
            j.t("mAdapter");
        }
        return guardModeAlarmTimeAdapter;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Z0() {
        GuardModeAlarmTimeAdapter.b bVar = GuardModeAlarmTimeAdapter.k;
        Integer num = (Integer) kotlin.collections.l.z(bVar.a(), this.I3);
        if (num != null) {
            int intValue = num.intValue();
            Integer num2 = (Integer) kotlin.collections.l.z(bVar.b(), this.J3);
            if (num2 != null) {
                if ((intValue * 60) + num2.intValue() < 5) {
                    e1(5);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int a1(int i) {
        if (i < 5) {
            return 5;
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FragmentGuardModeSetAlarmTimeBinding b1() {
        FragmentGuardModeSetAlarmTimeBinding fragmentGuardModeSetAlarmTimeBinding = this.p2;
        j.c(fragmentGuardModeSetAlarmTimeBinding);
        return fragmentGuardModeSetAlarmTimeBinding;
    }

    private final void c1(int i) {
        Integer valueOf = Integer.valueOf(GuardModeAlarmTimeAdapter.k.a().indexOf(Integer.valueOf(i)));
        int i2 = 0;
        if (!(valueOf.intValue() != -1)) {
            valueOf = null;
        }
        if (valueOf != null) {
            i2 = valueOf.intValue();
        }
        NumberPickerView numberPickerView = b1().f7018d;
        j.d(numberPickerView, "mBinding.npvAlarmTimeMin");
        numberPickerView.setValue(i2);
    }

    private final void d1(int i) {
        Integer valueOf = Integer.valueOf(GuardModeAlarmTimeAdapter.k.b().indexOf(Integer.valueOf(i)));
        int i2 = 1;
        if (!(valueOf.intValue() != -1)) {
            valueOf = null;
        }
        if (valueOf != null) {
            i2 = valueOf.intValue();
        }
        NumberPickerView numberPickerView = b1().f7019f;
        j.d(numberPickerView, "mBinding.npvAlarmTimeSec");
        numberPickerView.setValue(i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e1(int i) {
        c1(i / 60);
        d1(i % 60);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f1() {
        Integer k;
        Integer k2;
        NumberPickerView numberPickerView = b1().f7018d;
        j.d(numberPickerView, "mBinding.npvAlarmTimeMin");
        String contentByCurrValue = numberPickerView.getContentByCurrValue();
        j.d(contentByCurrValue, "mBinding.npvAlarmTimeMin.contentByCurrValue");
        k = u.k(contentByCurrValue);
        if (k != null) {
            int intValue = k.intValue();
            NumberPickerView numberPickerView2 = b1().f7019f;
            j.d(numberPickerView2, "mBinding.npvAlarmTimeSec");
            String contentByCurrValue2 = numberPickerView2.getContentByCurrValue();
            j.d(contentByCurrValue2, "mBinding.npvAlarmTimeSec.contentByCurrValue");
            k2 = u.k(contentByCurrValue2);
            if (k2 != null) {
                int intValue2 = (intValue * 60) + k2.intValue();
                if (intValue2 < 5) {
                    e1(5);
                    intValue2 = 5;
                }
                this.H3 = intValue2;
            }
        }
    }

    @Override // com.tplink.iot.view.iothub.guardmode.BaseGuardModeSettingFragment
    public void H0() {
        HashMap hashMap = this.K3;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    @Override // com.tplink.iot.view.iothub.guardmode.BaseGuardModeSettingFragment
    protected int J0() {
        return this.p1;
    }

    @Override // com.tplink.iot.view.iothub.guardmode.BaseGuardModeSettingFragment
    protected void N0() {
        GuardModeAlarmTimeAdapter guardModeAlarmTimeAdapter = this.p3;
        if (guardModeAlarmTimeAdapter == null) {
            j.t("mAdapter");
        }
        GuardModeAlarmTimeAdapter.a t = guardModeAlarmTimeAdapter.t();
        int i = c.a[t.a().ordinal()];
        if (i == 1) {
            this.H3 = a1(this.H3);
            L0().t(EnumGuardModeAlarmTimeType.CUSTOM_TIME, this.H3);
        } else if (i == 2) {
            L0().t(EnumGuardModeAlarmTimeType.ALWAYS, 0);
        } else if (i == 3) {
            L0().t(EnumGuardModeAlarmTimeType.CUSTOM_TIME, t.b());
        }
    }

    @Override // com.tplink.iot.view.iothub.guardmode.BaseGuardModeSettingFragment
    protected void O0() {
        L0().i().observe(getViewLifecycleOwner(), new g());
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        j.e(inflater, "inflater");
        this.p2 = (FragmentGuardModeSetAlarmTimeBinding) DataBindingUtil.inflate(inflater, R.layout.fragment_guard_mode_set_alarm_time, viewGroup, false);
        return b1().getRoot();
    }

    @Override // com.tplink.iot.view.iothub.guardmode.BaseGuardModeSettingFragment, com.tplink.iot.base.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.p2 = null;
        H0();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        int l;
        int l2;
        j.e(view, "view");
        Context requireContext = requireContext();
        j.d(requireContext, "requireContext()");
        GuardModeAlarmTimeAdapter guardModeAlarmTimeAdapter = new GuardModeAlarmTimeAdapter(requireContext);
        RecyclerView recyclerView = b1().q;
        j.d(recyclerView, "mBinding.rvConfigAlarmTime");
        recyclerView.setAdapter(guardModeAlarmTimeAdapter);
        guardModeAlarmTimeAdapter.y(new b());
        p pVar = p.a;
        this.p3 = guardModeAlarmTimeAdapter;
        NumberPickerView numberPickerView = b1().f7018d;
        List<Integer> a2 = GuardModeAlarmTimeAdapter.k.a();
        l = o.l(a2, 10);
        ArrayList arrayList = new ArrayList(l);
        for (Number number : a2) {
            arrayList.add(String.valueOf(number.intValue()));
        }
        Object[] array = arrayList.toArray(new String[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        numberPickerView.S((String[]) array);
        numberPickerView.setOnValueChangeListenerInScrolling(new c());
        numberPickerView.setOnValueChangedListener(new d());
        NumberPickerView numberPickerView2 = b1().f7019f;
        List<Integer> b2 = GuardModeAlarmTimeAdapter.k.b();
        l2 = o.l(b2, 10);
        ArrayList arrayList2 = new ArrayList(l2);
        for (Number number2 : b2) {
            arrayList2.add(String.valueOf(number2.intValue()));
        }
        Object[] array2 = arrayList2.toArray(new String[0]);
        Objects.requireNonNull(array2, "null cannot be cast to non-null type kotlin.Array<T>");
        numberPickerView2.S((String[]) array2);
        numberPickerView2.setOnValueChangeListenerInScrolling(new e());
        numberPickerView2.setOnValueChangedListener(new f());
        e1(300);
    }
}
