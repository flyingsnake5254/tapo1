package com.tplink.iot.view.smart.actionsetup.taskdevice.hub;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.R;
import com.tplink.iot.adapter.iothub.GuardModeAlarmTimeAdapter;
import com.tplink.iot.databinding.FragmentGuardModeSetAlarmTimeBinding;
import com.tplink.iot.devicecommon.view.IoTMVVMBaseFragment;
import com.tplink.iot.viewmodel.iotplug.factory.IoTViewModelFactory;
import com.tplink.iot.viewmodel.smart.taskdevice.TaskHubControlViewModel;
import com.tplink.iot.widget.NumberPickerView;
import com.tplink.libtpnetwork.IoTNetwork.bean.hub.result.GuardModeAlarmTimeBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.hub.result.GuardModeConfigBean;
import com.tplink.libtpnetwork.enumerate.EnumGuardModeAlarmTimeType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import kotlin.collections.o;
import kotlin.i;
import kotlin.jvm.b.l;
import kotlin.jvm.b.q;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import kotlin.p;
import kotlin.text.u;

/* compiled from: TaskHubAlarmTimeFragment.kt */
/* loaded from: classes2.dex */
public final class TaskHubAlarmTimeFragment extends IoTMVVMBaseFragment<FragmentGuardModeSetAlarmTimeBinding> {
    private TaskHubControlFragment I3;
    private final kotlin.f J3;
    private HashMap K3;
    private GuardModeAlarmTimeAdapter p1;
    private int p2 = 300;
    private int p3 = -1;
    private int H3 = -1;

    /* compiled from: TaskHubAlarmTimeFragment.kt */
    /* loaded from: classes2.dex */
    static final class a extends Lambda implements kotlin.jvm.b.a<TaskHubControlViewModel> {
        a() {
            super(0);
        }

        /* renamed from: a */
        public final TaskHubControlViewModel invoke() {
            ViewModel viewModel = new ViewModelProvider(TaskHubAlarmTimeFragment.Y0(TaskHubAlarmTimeFragment.this), new IoTViewModelFactory(TaskHubAlarmTimeFragment.Y0(TaskHubAlarmTimeFragment.this), TaskHubAlarmTimeFragment.this.K0())).get(TaskHubControlViewModel.class);
            j.d(viewModel, "ViewModelProvider(mParen…rolViewModel::class.java)");
            return (TaskHubControlViewModel) viewModel;
        }
    }

    /* compiled from: TaskHubAlarmTimeFragment.kt */
    /* loaded from: classes2.dex */
    static final class b extends Lambda implements q<GuardModeAlarmTimeAdapter.a, Integer, Boolean, p> {
        b() {
            super(3);
        }

        public final void a(GuardModeAlarmTimeAdapter.a alarmTime, int i, boolean z) {
            j.e(alarmTime, "alarmTime");
            LinearLayout linearLayout = TaskHubAlarmTimeFragment.V0(TaskHubAlarmTimeFragment.this).f7017c;
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

    /* compiled from: TaskHubAlarmTimeFragment.kt */
    /* loaded from: classes2.dex */
    static final class c implements NumberPickerView.e {
        c() {
        }

        @Override // com.tplink.iot.widget.NumberPickerView.e
        public final void a(NumberPickerView numberPickerView, int i, int i2) {
            TaskHubAlarmTimeFragment.this.p3 = i2;
            TaskHubAlarmTimeFragment.this.e1();
        }
    }

    /* compiled from: TaskHubAlarmTimeFragment.kt */
    /* loaded from: classes2.dex */
    static final class d implements NumberPickerView.d {
        d() {
        }

        @Override // com.tplink.iot.widget.NumberPickerView.d
        public final void a(NumberPickerView numberPickerView, int i, int i2) {
            TaskHubAlarmTimeFragment.this.l1();
        }
    }

    /* compiled from: TaskHubAlarmTimeFragment.kt */
    /* loaded from: classes2.dex */
    static final class e implements NumberPickerView.e {
        e() {
        }

        @Override // com.tplink.iot.widget.NumberPickerView.e
        public final void a(NumberPickerView numberPickerView, int i, int i2) {
            TaskHubAlarmTimeFragment.this.H3 = i2;
            TaskHubAlarmTimeFragment.this.e1();
        }
    }

    /* compiled from: TaskHubAlarmTimeFragment.kt */
    /* loaded from: classes2.dex */
    static final class f implements NumberPickerView.d {
        f() {
        }

        @Override // com.tplink.iot.widget.NumberPickerView.d
        public final void a(NumberPickerView numberPickerView, int i, int i2) {
            TaskHubAlarmTimeFragment.this.l1();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TaskHubAlarmTimeFragment.kt */
    /* loaded from: classes2.dex */
    public static final class g<T> implements Observer<GuardModeConfigBean> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: TaskHubAlarmTimeFragment.kt */
        /* loaded from: classes2.dex */
        public static final class a extends Lambda implements l<Integer, p> {
            a() {
                super(1);
            }

            public final void a(int i) {
                TaskHubAlarmTimeFragment.this.p2 = i;
                TaskHubAlarmTimeFragment.this.k1(i);
            }

            @Override // kotlin.jvm.b.l
            public /* bridge */ /* synthetic */ p invoke(Integer num) {
                a(num.intValue());
                return p.a;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: TaskHubAlarmTimeFragment.kt */
        /* loaded from: classes2.dex */
        public static final class b extends Lambda implements l<Integer, p> {
            b() {
                super(1);
            }

            public final void a(int i) {
                TaskHubAlarmTimeFragment taskHubAlarmTimeFragment = TaskHubAlarmTimeFragment.this;
                taskHubAlarmTimeFragment.p2 = taskHubAlarmTimeFragment.f1(i);
                TaskHubAlarmTimeFragment taskHubAlarmTimeFragment2 = TaskHubAlarmTimeFragment.this;
                taskHubAlarmTimeFragment2.k1(taskHubAlarmTimeFragment2.p2);
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
                    GuardModeAlarmTimeAdapter guardModeAlarmTimeAdapter = TaskHubAlarmTimeFragment.this.p1;
                    if (guardModeAlarmTimeAdapter != null) {
                        guardModeAlarmTimeAdapter.D(300, new a());
                        return;
                    }
                    return;
                }
                GuardModeAlarmTimeAdapter guardModeAlarmTimeAdapter2 = TaskHubAlarmTimeFragment.this.p1;
                if (guardModeAlarmTimeAdapter2 != null) {
                    guardModeAlarmTimeAdapter2.D(alarmTime.getTime(), new b());
                }
            }
        }
    }

    public TaskHubAlarmTimeFragment() {
        kotlin.f b2;
        b2 = i.b(new a());
        this.J3 = b2;
    }

    public static final /* synthetic */ FragmentGuardModeSetAlarmTimeBinding V0(TaskHubAlarmTimeFragment taskHubAlarmTimeFragment) {
        return taskHubAlarmTimeFragment.J0();
    }

    public static final /* synthetic */ TaskHubControlFragment Y0(TaskHubAlarmTimeFragment taskHubAlarmTimeFragment) {
        TaskHubControlFragment taskHubControlFragment = taskHubAlarmTimeFragment.I3;
        if (taskHubControlFragment == null) {
            j.t("mParentFragment");
        }
        return taskHubControlFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e1() {
        GuardModeAlarmTimeAdapter.b bVar = GuardModeAlarmTimeAdapter.k;
        Integer num = (Integer) kotlin.collections.l.z(bVar.a(), this.p3);
        if (num != null) {
            int intValue = num.intValue();
            Integer num2 = (Integer) kotlin.collections.l.z(bVar.b(), this.H3);
            if (num2 != null) {
                if ((intValue * 60) + num2.intValue() < 5) {
                    k1(5);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int f1(int i) {
        if (i < 5) {
            return 5;
        }
        return i;
    }

    private final TaskHubControlViewModel g1() {
        return (TaskHubControlViewModel) this.J3.getValue();
    }

    private final void h1() {
        GuardModeAlarmTimeAdapter.a t;
        GuardModeAlarmTimeAdapter guardModeAlarmTimeAdapter = this.p1;
        if (guardModeAlarmTimeAdapter != null && (t = guardModeAlarmTimeAdapter.t()) != null) {
            int i = a.a[t.a().ordinal()];
            if (i == 1) {
                this.p2 = f1(this.p2);
                g1().u(EnumGuardModeAlarmTimeType.CUSTOM_TIME, this.p2);
            } else if (i == 2) {
                g1().u(EnumGuardModeAlarmTimeType.ALWAYS, 0);
            } else if (i == 3) {
                g1().u(EnumGuardModeAlarmTimeType.CUSTOM_TIME, t.b());
            }
        }
    }

    private final void i1(int i) {
        Integer valueOf = Integer.valueOf(GuardModeAlarmTimeAdapter.k.a().indexOf(Integer.valueOf(i)));
        int i2 = 0;
        if (!(valueOf.intValue() != -1)) {
            valueOf = null;
        }
        if (valueOf != null) {
            i2 = valueOf.intValue();
        }
        NumberPickerView numberPickerView = J0().f7018d;
        j.d(numberPickerView, "mBinding.npvAlarmTimeMin");
        numberPickerView.setValue(i2);
    }

    private final void j1(int i) {
        Integer valueOf = Integer.valueOf(GuardModeAlarmTimeAdapter.k.b().indexOf(Integer.valueOf(i)));
        int i2 = 1;
        if (!(valueOf.intValue() != -1)) {
            valueOf = null;
        }
        if (valueOf != null) {
            i2 = valueOf.intValue();
        }
        NumberPickerView numberPickerView = J0().f7019f;
        j.d(numberPickerView, "mBinding.npvAlarmTimeSec");
        numberPickerView.setValue(i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k1(int i) {
        i1(i / 60);
        j1(i % 60);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l1() {
        Integer k;
        Integer k2;
        NumberPickerView numberPickerView = J0().f7018d;
        j.d(numberPickerView, "mBinding.npvAlarmTimeMin");
        String contentByCurrValue = numberPickerView.getContentByCurrValue();
        j.d(contentByCurrValue, "mBinding.npvAlarmTimeMin.contentByCurrValue");
        k = u.k(contentByCurrValue);
        if (k != null) {
            int intValue = k.intValue();
            NumberPickerView numberPickerView2 = J0().f7019f;
            j.d(numberPickerView2, "mBinding.npvAlarmTimeSec");
            String contentByCurrValue2 = numberPickerView2.getContentByCurrValue();
            j.d(contentByCurrValue2, "mBinding.npvAlarmTimeSec.contentByCurrValue");
            k2 = u.k(contentByCurrValue2);
            if (k2 != null) {
                int intValue2 = (intValue * 60) + k2.intValue();
                if (intValue2 < 5) {
                    k1(5);
                    intValue2 = 5;
                }
                this.p2 = intValue2;
            }
        }
    }

    @Override // com.tplink.iot.devicecommon.view.IoTMVVMBaseFragment
    public void H0() {
        HashMap hashMap = this.K3;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    @Override // com.tplink.iot.devicecommon.view.IoTMVVMBaseFragment
    public int I0() {
        return R.layout.fragment_guard_mode_set_alarm_time;
    }

    @Override // com.tplink.iot.devicecommon.view.IoTMVVMBaseFragment
    public void R0() {
        g1().i().observe(getViewLifecycleOwner(), new g());
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        j.e(context, "context");
        super.onAttach(context);
        Fragment parentFragment = getParentFragment();
        if (!(parentFragment instanceof TaskHubControlFragment)) {
            parentFragment = null;
        }
        TaskHubControlFragment taskHubControlFragment = (TaskHubControlFragment) parentFragment;
        if (taskHubControlFragment == null) {
            getParentFragmentManager().popBackStackImmediate();
        } else {
            this.I3 = taskHubControlFragment;
        }
    }

    @Override // com.tplink.iot.base.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        h1();
        super.onDestroy();
    }

    @Override // com.tplink.iot.devicecommon.view.IoTMVVMBaseFragment, com.tplink.iot.base.BaseFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        H0();
    }

    @Override // com.tplink.iot.devicecommon.view.IoTMVVMBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        int l;
        int l2;
        j.e(view, "view");
        super.onViewCreated(view, bundle);
        Context requireContext = requireContext();
        j.d(requireContext, "requireContext()");
        GuardModeAlarmTimeAdapter guardModeAlarmTimeAdapter = new GuardModeAlarmTimeAdapter(requireContext);
        RecyclerView recyclerView = J0().q;
        j.d(recyclerView, "mBinding.rvConfigAlarmTime");
        recyclerView.setAdapter(guardModeAlarmTimeAdapter);
        guardModeAlarmTimeAdapter.y(new b());
        p pVar = p.a;
        this.p1 = guardModeAlarmTimeAdapter;
        NumberPickerView numberPickerView = J0().f7018d;
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
        NumberPickerView numberPickerView2 = J0().f7019f;
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
        k1(300);
        TaskHubControlFragment taskHubControlFragment = this.I3;
        if (taskHubControlFragment == null) {
            j.t("mParentFragment");
        }
        taskHubControlFragment.f1(R.string.gm_config_alarm_time);
        R0();
    }
}
