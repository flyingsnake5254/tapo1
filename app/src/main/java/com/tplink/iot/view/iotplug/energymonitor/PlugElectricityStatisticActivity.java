package com.tplink.iot.view.iotplug.energymonitor;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.google.android.material.tabs.TabLayout;
import com.tplink.iot.R;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.databinding.ActivityPlugElectricityStatisticBinding;
import com.tplink.iot.view.iotplug.energymonitor.chart.ElectricityBarChart;
import com.tplink.iot.viewmodel.iotplug.PlugEnergyMonitorViewModel;
import com.tplink.iot.viewmodel.iotplug.factory.IoTViewModelFactory;
import com.tplink.libtpnetwork.IoTNetwork.bean.plug.result.EnergyUsageResult;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import kotlin.collections.n;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.p;

/* compiled from: PlugElectricityStatisticActivity.kt */
/* loaded from: classes2.dex */
public final class PlugElectricityStatisticActivity extends BaseActivity implements OnChartValueSelectedListener {
    public static final a y = new a(null);
    private final kotlin.f H3;
    private EnergyUsageResult I3;
    private boolean J3;
    private boolean K3;
    private ActivityPlugElectricityStatisticBinding p0;
    private final kotlin.f p1;
    private final kotlin.f p2;
    private final kotlin.f p3;
    private String z = "";

    /* compiled from: PlugElectricityStatisticActivity.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        private final Intent b(Context context, int i, String str) {
            Intent intent = new Intent(context, PlugElectricityStatisticActivity.class);
            intent.putExtra("PageType", i);
            intent.putExtra("device_id_md5", str);
            return intent;
        }

        public final void a(Context context, String deviceIdMD5) {
            kotlin.jvm.internal.j.e(context, "context");
            kotlin.jvm.internal.j.e(deviceIdMD5, "deviceIdMD5");
            context.startActivity(b(context, 0, deviceIdMD5));
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: PlugElectricityStatisticActivity.kt */
    /* loaded from: classes2.dex */
    public static final class b extends ValueFormatter {
        private long a;

        /* renamed from: b  reason: collision with root package name */
        private int f8648b;

        public b(long j, int i) {
            this.a = j;
            this.f8648b = i;
        }

        @Override // com.github.mikephil.charting.formatter.ValueFormatter
        @SuppressLint({"SimpleDateFormat"})
        public String getFormattedValue(float f2) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(new Date(this.a));
            calendar.add(5, -((this.f8648b - ((int) f2)) - 1));
            if (calendar.get(5) != 1) {
                return String.valueOf(calendar.get(5));
            }
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("d MMM");
            kotlin.jvm.internal.j.d(calendar, "calendar");
            String format = simpleDateFormat.format(calendar.getTime());
            kotlin.jvm.internal.j.d(format, "SimpleDateFormat(\"d MMM\").format(calendar.time)");
            return format;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: PlugElectricityStatisticActivity.kt */
    /* loaded from: classes2.dex */
    public static final class c extends ValueFormatter {
        private long a;

        /* renamed from: b  reason: collision with root package name */
        private int f8649b;

        public c(long j, int i) {
            this.a = j;
            this.f8649b = i;
        }

        @Override // com.github.mikephil.charting.formatter.ValueFormatter
        @SuppressLint({"SimpleDateFormat"})
        public String getFormattedValue(float f2) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(new Date(this.a));
            calendar.add(2, -((this.f8649b - ((int) f2)) - 1));
            if (calendar.get(2) == 0) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMM yyyy");
                kotlin.jvm.internal.j.d(calendar, "calendar");
                String format = simpleDateFormat.format(calendar.getTime());
                kotlin.jvm.internal.j.d(format, "SimpleDateFormat(\"MMM yyyy\").format(calendar.time)");
                return format;
            }
            SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("MMM");
            kotlin.jvm.internal.j.d(calendar, "calendar");
            String format2 = simpleDateFormat2.format(calendar.getTime());
            kotlin.jvm.internal.j.d(format2, "SimpleDateFormat(\"MMM\").format(calendar.time)");
            return format2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: PlugElectricityStatisticActivity.kt */
    /* loaded from: classes2.dex */
    public static final class d extends ValueFormatter {
        @Override // com.github.mikephil.charting.formatter.ValueFormatter
        public String getFormattedValue(float f2) {
            if (f2 <= 0.0f) {
                return "";
            }
            p pVar = p.a;
            String format = String.format("%.1f", Arrays.copyOf(new Object[]{Float.valueOf(f2)}, 1));
            kotlin.jvm.internal.j.d(format, "java.lang.String.format(format, *args)");
            return format;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PlugElectricityStatisticActivity.kt */
    /* loaded from: classes2.dex */
    public static final class e extends Lambda implements kotlin.jvm.b.l<Float, kotlin.p> {
        e() {
            super(1);
        }

        public final void a(float f2) {
            PlugElectricityStatisticActivity.this.u1(f2);
        }

        @Override // kotlin.jvm.b.l
        public /* bridge */ /* synthetic */ kotlin.p invoke(Float f2) {
            a(f2.floatValue());
            return kotlin.p.a;
        }
    }

    /* compiled from: PlugElectricityStatisticActivity.kt */
    /* loaded from: classes2.dex */
    public static final class f implements TabLayout.OnTabSelectedListener {
        f() {
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabReselected(TabLayout.Tab tab) {
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabSelected(TabLayout.Tab tab) {
            PlugElectricityStatisticActivity.this.A1();
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabUnselected(TabLayout.Tab tab) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PlugElectricityStatisticActivity.kt */
    /* loaded from: classes2.dex */
    public static final class g implements View.OnClickListener {
        g() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            PlugElectricityStatisticActivity.this.l1().a();
        }
    }

    /* compiled from: PlugElectricityStatisticActivity.kt */
    /* loaded from: classes2.dex */
    static final class h extends Lambda implements kotlin.jvm.b.a<ElectricityBarChart> {
        h() {
            super(0);
        }

        /* renamed from: a */
        public final ElectricityBarChart invoke() {
            ElectricityBarChart electricityBarChart = PlugElectricityStatisticActivity.g1(PlugElectricityStatisticActivity.this).f6642c;
            kotlin.jvm.internal.j.d(electricityBarChart, "mViewBinding.pemBarChart");
            return electricityBarChart;
        }
    }

    /* compiled from: PlugElectricityStatisticActivity.kt */
    /* loaded from: classes2.dex */
    static final class i extends Lambda implements kotlin.jvm.b.a<CardView> {
        i() {
            super(0);
        }

        /* renamed from: a */
        public final CardView invoke() {
            CardView cardView = PlugElectricityStatisticActivity.g1(PlugElectricityStatisticActivity.this).f6644f;
            kotlin.jvm.internal.j.d(cardView, "mViewBinding.pemMarkerView");
            return cardView;
        }
    }

    /* compiled from: PlugElectricityStatisticActivity.kt */
    /* loaded from: classes2.dex */
    static final class j extends Lambda implements kotlin.jvm.b.a<PlugEnergyMonitorViewModel> {
        j() {
            super(0);
        }

        /* renamed from: a */
        public final PlugEnergyMonitorViewModel invoke() {
            PlugElectricityStatisticActivity plugElectricityStatisticActivity = PlugElectricityStatisticActivity.this;
            return (PlugEnergyMonitorViewModel) new ViewModelProvider(plugElectricityStatisticActivity, new IoTViewModelFactory(plugElectricityStatisticActivity, plugElectricityStatisticActivity.z)).get(PlugEnergyMonitorViewModel.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PlugElectricityStatisticActivity.kt */
    /* loaded from: classes2.dex */
    public static final class k<T> implements Observer<EnergyUsageResult> {
        k() {
        }

        /* renamed from: a */
        public final void onChanged(EnergyUsageResult energyUsageResult) {
            b.d.w.c.a.a("EnergyUsage Result：" + energyUsageResult);
            PlugElectricityStatisticActivity.this.I3 = energyUsageResult;
            PlugElectricityStatisticActivity.this.B1();
        }
    }

    /* compiled from: PlugElectricityStatisticActivity.kt */
    /* loaded from: classes2.dex */
    static final class l extends Lambda implements kotlin.jvm.b.a<String> {
        l() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            String string = PlugElectricityStatisticActivity.this.getString(R.string.power_unit);
            kotlin.jvm.internal.j.d(string, "getString(R.string.power_unit)");
            return string;
        }
    }

    public PlugElectricityStatisticActivity() {
        kotlin.f b2;
        kotlin.f b3;
        kotlin.f b4;
        kotlin.f b5;
        b2 = kotlin.i.b(new h());
        this.p1 = b2;
        b3 = kotlin.i.b(new i());
        this.p2 = b3;
        b4 = kotlin.i.b(new l());
        this.p3 = b4;
        b5 = kotlin.i.b(new j());
        this.H3 = b5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void A1() {
        x1(true);
        B1();
        t1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void B1() {
        int f2;
        int f3;
        EnergyUsageResult energyUsageResult = this.I3;
        if (energyUsageResult != null) {
            l1().clear();
            if (s1()) {
                List<Integer> past30d = energyUsageResult.getPast30d();
                if (!(past30d == null || past30d.isEmpty())) {
                    ArrayList arrayList = new ArrayList();
                    int i2 = 0;
                    for (Object obj : energyUsageResult.getPast30d()) {
                        i2++;
                        if (i2 < 0) {
                            n.k();
                        }
                        arrayList.add(new BarEntry(i2, w1(((Number) obj).intValue()), Long.valueOf(energyUsageResult.getLocalTimeInMS())));
                    }
                    XAxis xAxis = l1().getXAxis();
                    kotlin.jvm.internal.j.d(xAxis, "mBarChart.xAxis");
                    xAxis.setValueFormatter(new b(energyUsageResult.getLocalTimeInMS(), energyUsageResult.getPast30d().size()));
                    l1().c(arrayList, !this.J3);
                    ElectricityBarChart l1 = l1();
                    f3 = n.f(energyUsageResult.getPast30d());
                    l1.centerViewToAnimated(f3, 0.0f, YAxis.AxisDependency.LEFT, 400L);
                    x1(false);
                    this.J3 = true;
                    return;
                }
                return;
            }
            List<Integer> past1y = energyUsageResult.getPast1y();
            if (!(past1y == null || past1y.isEmpty())) {
                ArrayList arrayList2 = new ArrayList();
                int i3 = 0;
                for (Object obj2 : energyUsageResult.getPast1y()) {
                    i3++;
                    if (i3 < 0) {
                        n.k();
                    }
                    arrayList2.add(new BarEntry(i3, w1(((Number) obj2).intValue()), Long.valueOf(energyUsageResult.getLocalTimeInMS())));
                }
                XAxis xAxis2 = l1().getXAxis();
                kotlin.jvm.internal.j.d(xAxis2, "mBarChart.xAxis");
                xAxis2.setValueFormatter(new c(energyUsageResult.getLocalTimeInMS(), energyUsageResult.getPast1y().size()));
                l1().c(arrayList2, !this.K3);
                ElectricityBarChart l12 = l1();
                f2 = n.f(energyUsageResult.getPast1y());
                l12.centerViewToAnimated(f2, 0.0f, YAxis.AxisDependency.LEFT, 400L);
                x1(false);
                this.K3 = true;
            }
        }
    }

    @SuppressLint({"SimpleDateFormat"})
    private final void C1(float f2, float f3, boolean z) {
        String str;
        if (z) {
            m1().setCardElevation(com.tplink.iot.Utils.j.a(this, 4.0f));
        }
        if (f3 < 0.1f) {
            str = "<0.1";
        } else {
            p pVar = p.a;
            str = String.format("%.1f", Arrays.copyOf(new Object[]{Float.valueOf(f3)}, 1));
            kotlin.jvm.internal.j.d(str, "java.lang.String.format(format, *args)");
        }
        ActivityPlugElectricityStatisticBinding activityPlugElectricityStatisticBinding = this.p0;
        if (activityPlugElectricityStatisticBinding == null) {
            kotlin.jvm.internal.j.t("mViewBinding");
        }
        TextView textView = activityPlugElectricityStatisticBinding.x;
        kotlin.jvm.internal.j.d(textView, "mViewBinding.tvPower");
        y1(textView, str, o1());
        EnergyUsageResult energyUsageResult = this.I3;
        if (energyUsageResult == null) {
            return;
        }
        if (s1()) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(new Date(energyUsageResult.getLocalTimeInMS()));
            calendar.add(5, -((energyUsageResult.getPast30d().size() - ((int) f2)) - 1));
            ActivityPlugElectricityStatisticBinding activityPlugElectricityStatisticBinding2 = this.p0;
            if (activityPlugElectricityStatisticBinding2 == null) {
                kotlin.jvm.internal.j.t("mViewBinding");
            }
            TextView textView2 = activityPlugElectricityStatisticBinding2.y;
            kotlin.jvm.internal.j.d(textView2, "mViewBinding.tvTime");
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMM dd, yyyy");
            kotlin.jvm.internal.j.d(calendar, "calendar");
            textView2.setText(simpleDateFormat.format(calendar.getTime()));
            return;
        }
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(new Date(energyUsageResult.getLocalTimeInMS()));
        calendar2.add(2, -((energyUsageResult.getPast1y().size() - ((int) f2)) - 1));
        ActivityPlugElectricityStatisticBinding activityPlugElectricityStatisticBinding3 = this.p0;
        if (activityPlugElectricityStatisticBinding3 == null) {
            kotlin.jvm.internal.j.t("mViewBinding");
        }
        TextView textView3 = activityPlugElectricityStatisticBinding3.y;
        kotlin.jvm.internal.j.d(textView3, "mViewBinding.tvTime");
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("MMM yyyy");
        kotlin.jvm.internal.j.d(calendar2, "calendar");
        textView3.setText(simpleDateFormat2.format(calendar2.getTime()));
    }

    public static final /* synthetic */ ActivityPlugElectricityStatisticBinding g1(PlugElectricityStatisticActivity plugElectricityStatisticActivity) {
        ActivityPlugElectricityStatisticBinding activityPlugElectricityStatisticBinding = plugElectricityStatisticActivity.p0;
        if (activityPlugElectricityStatisticBinding == null) {
            kotlin.jvm.internal.j.t("mViewBinding");
        }
        return activityPlugElectricityStatisticBinding;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ElectricityBarChart l1() {
        return (ElectricityBarChart) this.p1.getValue();
    }

    private final CardView m1() {
        return (CardView) this.p2.getValue();
    }

    private final PlugEnergyMonitorViewModel n1() {
        return (PlugEnergyMonitorViewModel) this.H3.getValue();
    }

    private final String o1() {
        return (String) this.p3.getValue();
    }

    private final void p1() {
        l1().setOnChartValueSelectedListener(this);
        YAxis yAxis = l1().getYAxis();
        kotlin.jvm.internal.j.d(yAxis, "mBarChart.yAxis");
        yAxis.setValueFormatter(new d());
        l1().setOnDrawHighlightLineListener(new e());
    }

    private final void q1() {
        String str;
        Intent intent = getIntent();
        if (intent == null || (str = intent.getStringExtra("device_id_md5")) == null) {
            str = "";
        }
        this.z = str;
    }

    private final void r1() {
        b1(R.string.plug_electricity_statistic_title);
        ActivityPlugElectricityStatisticBinding activityPlugElectricityStatisticBinding = this.p0;
        if (activityPlugElectricityStatisticBinding == null) {
            kotlin.jvm.internal.j.t("mViewBinding");
        }
        activityPlugElectricityStatisticBinding.q.addOnTabSelectedListener((TabLayout.OnTabSelectedListener) new f());
        Intent intent = getIntent();
        int i2 = 0;
        if (intent != null) {
            i2 = intent.getIntExtra("PageType", 0);
        }
        ActivityPlugElectricityStatisticBinding activityPlugElectricityStatisticBinding2 = this.p0;
        if (activityPlugElectricityStatisticBinding2 == null) {
            kotlin.jvm.internal.j.t("mViewBinding");
        }
        TabLayout tabLayout = activityPlugElectricityStatisticBinding2.q;
        ActivityPlugElectricityStatisticBinding activityPlugElectricityStatisticBinding3 = this.p0;
        if (activityPlugElectricityStatisticBinding3 == null) {
            kotlin.jvm.internal.j.t("mViewBinding");
        }
        tabLayout.selectTab(activityPlugElectricityStatisticBinding3.q.getTabAt(i2));
        m1().setOnClickListener(new g());
        p1();
    }

    private final boolean s1() {
        ActivityPlugElectricityStatisticBinding activityPlugElectricityStatisticBinding = this.p0;
        if (activityPlugElectricityStatisticBinding == null) {
            kotlin.jvm.internal.j.t("mViewBinding");
        }
        TabLayout tabLayout = activityPlugElectricityStatisticBinding.q;
        kotlin.jvm.internal.j.d(tabLayout, "mViewBinding.pemTabLayout");
        return tabLayout.getSelectedTabPosition() == 0;
    }

    private final void t1() {
        if (s1()) {
            com.tplink.iot.Utils.x0.i.k(this.z);
        } else {
            com.tplink.iot.Utils.x0.i.j(this.z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u1(float f2) {
        m1().setTranslationX(Math.min(Math.max(f2 - (m1().getWidth() / 2.0f), 0.0f), l1().getWidth() - m1().getWidth()));
    }

    public static final void v1(Context context, String str) {
        y.a(context, str);
    }

    private final float w1(int i2) {
        return i2 / 1000.0f;
    }

    private final void x1(boolean z) {
        int f2;
        int f3;
        m1().setCardElevation(0.0f);
        m1().animate().translationX(0.0f).start();
        if (z) {
            ActivityPlugElectricityStatisticBinding activityPlugElectricityStatisticBinding = this.p0;
            if (activityPlugElectricityStatisticBinding == null) {
                kotlin.jvm.internal.j.t("mViewBinding");
            }
            TextView textView = activityPlugElectricityStatisticBinding.x;
            kotlin.jvm.internal.j.d(textView, "mViewBinding.tvPower");
            textView.setText("--");
            ActivityPlugElectricityStatisticBinding activityPlugElectricityStatisticBinding2 = this.p0;
            if (activityPlugElectricityStatisticBinding2 == null) {
                kotlin.jvm.internal.j.t("mViewBinding");
            }
            TextView textView2 = activityPlugElectricityStatisticBinding2.y;
            kotlin.jvm.internal.j.d(textView2, "mViewBinding.tvTime");
            textView2.setText("--");
            return;
        }
        EnergyUsageResult energyUsageResult = this.I3;
        if (energyUsageResult != null) {
            boolean z2 = true;
            if (s1()) {
                List<Integer> past30d = energyUsageResult.getPast30d();
                if (past30d != null && !past30d.isEmpty()) {
                    z2 = false;
                }
                if (!z2) {
                    f3 = n.f(energyUsageResult.getPast30d());
                    C1(f3, w1(((Number) kotlin.collections.l.F(energyUsageResult.getPast30d())).intValue()), false);
                    return;
                }
                return;
            }
            List<Integer> past1y = energyUsageResult.getPast1y();
            if (past1y != null && !past1y.isEmpty()) {
                z2 = false;
            }
            if (!z2) {
                f2 = n.f(energyUsageResult.getPast1y());
                C1(f2, w1(((Number) kotlin.collections.l.F(energyUsageResult.getPast1y())).intValue()), false);
            }
        }
    }

    private final void y1(TextView textView, String str, String str2) {
        SpannableString spannableString = new SpannableString(str + ' ' + str2);
        RelativeSizeSpan relativeSizeSpan = new RelativeSizeSpan(1.6f);
        StyleSpan styleSpan = new StyleSpan(1);
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan((int) 4281545523L);
        spannableString.setSpan(relativeSizeSpan, 0, str.length(), 33);
        spannableString.setSpan(styleSpan, 0, str.length(), 33);
        spannableString.setSpan(foregroundColorSpan, 0, str.length(), 33);
        kotlin.p pVar = kotlin.p.a;
        textView.setText(spannableString);
    }

    private final void z1() {
        n1().h().observe(this, new k());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ViewDataBinding contentView = DataBindingUtil.setContentView(this, R.layout.activity_plug_electricity_statistic);
        kotlin.jvm.internal.j.d(contentView, "DataBindingUtil.setConte…ug_electricity_statistic)");
        this.p0 = (ActivityPlugElectricityStatisticBinding) contentView;
        q1();
        r1();
        z1();
    }

    @Override // com.github.mikephil.charting.listener.OnChartValueSelectedListener
    public void onNothingSelected() {
        x1(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        n1().f();
    }

    @Override // com.github.mikephil.charting.listener.OnChartValueSelectedListener
    public void onValueSelected(Entry entry, Highlight highlight) {
        if (entry != null) {
            C1(entry.getX(), entry.getY(), true);
        }
    }
}
