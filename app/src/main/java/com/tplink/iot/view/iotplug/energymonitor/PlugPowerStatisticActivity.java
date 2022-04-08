package com.tplink.iot.view.iotplug.energymonitor;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
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
import com.tplink.iot.Utils.o0;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.databinding.ActivityPlugPowerStatisticBinding;
import com.tplink.iot.view.iotplug.energymonitor.chart.PowerLineChart;
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
import kotlin.collections.o;
import kotlin.jvm.b.l;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.p;

/* compiled from: PlugPowerStatisticActivity.kt */
/* loaded from: classes2.dex */
public final class PlugPowerStatisticActivity extends BaseActivity implements OnChartValueSelectedListener {
    private EnergyUsageResult H3;
    private boolean I3;
    private boolean J3;
    private boolean K3;
    private final kotlin.f p0;
    private final kotlin.f p1;
    private final kotlin.f p2;
    private final kotlin.f p3;
    private String y = "";
    private ActivityPlugPowerStatisticBinding z;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: PlugPowerStatisticActivity.kt */
    /* loaded from: classes2.dex */
    public static final class a extends ValueFormatter {
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

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: PlugPowerStatisticActivity.kt */
    /* loaded from: classes2.dex */
    public static final class b extends ValueFormatter {
        private long a;

        /* renamed from: b  reason: collision with root package name */
        private int f8656b;

        public b(long j, int i) {
            this.a = j;
            this.f8656b = i;
        }

        @Override // com.github.mikephil.charting.formatter.ValueFormatter
        @SuppressLint({"SimpleDateFormat"})
        public String getFormattedValue(float f2) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(new Date(this.a));
            calendar.add(10, -((this.f8656b - ((int) f2)) - 1));
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd");
            kotlin.jvm.internal.j.d(calendar, "calendar");
            String format = simpleDateFormat.format(calendar.getTime());
            kotlin.jvm.internal.j.d(format, "SimpleDateFormat(\"dd\").format(calendar.time)");
            return format;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: PlugPowerStatisticActivity.kt */
    /* loaded from: classes2.dex */
    public static final class c extends ValueFormatter {
        private long a;

        /* renamed from: b  reason: collision with root package name */
        private int f8657b;

        public c(long j, int i) {
            this.a = j;
            this.f8657b = i;
        }

        @Override // com.github.mikephil.charting.formatter.ValueFormatter
        @SuppressLint({"SimpleDateFormat"})
        public String getFormattedValue(float f2) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(new Date(this.a));
            calendar.add(10, -((this.f8657b - ((int) f2)) - 1));
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("kk:30");
            kotlin.jvm.internal.j.d(calendar, "calendar");
            String format = simpleDateFormat.format(calendar.getTime());
            kotlin.jvm.internal.j.d(format, "SimpleDateFormat(\"kk:30\").format(calendar.time)");
            return format;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PlugPowerStatisticActivity.kt */
    /* loaded from: classes2.dex */
    public static final class d extends Lambda implements l<Float, kotlin.p> {
        d() {
            super(1);
        }

        public final void a(float f2) {
            PlugPowerStatisticActivity.this.u1(f2);
        }

        @Override // kotlin.jvm.b.l
        public /* bridge */ /* synthetic */ kotlin.p invoke(Float f2) {
            a(f2.floatValue());
            return kotlin.p.a;
        }
    }

    /* compiled from: PlugPowerStatisticActivity.kt */
    /* loaded from: classes2.dex */
    public static final class e implements TabLayout.OnTabSelectedListener {
        e() {
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabReselected(TabLayout.Tab tab) {
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabSelected(TabLayout.Tab tab) {
            PlugPowerStatisticActivity.this.z1();
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabUnselected(TabLayout.Tab tab) {
        }
    }

    /* compiled from: PlugPowerStatisticActivity.kt */
    /* loaded from: classes2.dex */
    static final class f extends Lambda implements kotlin.jvm.b.a<PowerLineChart> {
        f() {
            super(0);
        }

        /* renamed from: a */
        public final PowerLineChart invoke() {
            return PlugPowerStatisticActivity.f1(PlugPowerStatisticActivity.this).f6646d;
        }
    }

    /* compiled from: PlugPowerStatisticActivity.kt */
    /* loaded from: classes2.dex */
    static final class g extends Lambda implements kotlin.jvm.b.a<CardView> {
        g() {
            super(0);
        }

        /* renamed from: a */
        public final CardView invoke() {
            return PlugPowerStatisticActivity.f1(PlugPowerStatisticActivity.this).f6647f;
        }
    }

    /* compiled from: PlugPowerStatisticActivity.kt */
    /* loaded from: classes2.dex */
    static final class h extends Lambda implements kotlin.jvm.b.a<PlugEnergyMonitorViewModel> {
        h() {
            super(0);
        }

        /* renamed from: a */
        public final PlugEnergyMonitorViewModel invoke() {
            PlugPowerStatisticActivity plugPowerStatisticActivity = PlugPowerStatisticActivity.this;
            return (PlugEnergyMonitorViewModel) new ViewModelProvider(plugPowerStatisticActivity, new IoTViewModelFactory(plugPowerStatisticActivity, plugPowerStatisticActivity.y)).get(PlugEnergyMonitorViewModel.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PlugPowerStatisticActivity.kt */
    /* loaded from: classes2.dex */
    public static final class i<T> implements Observer<EnergyUsageResult> {
        i() {
        }

        /* renamed from: a */
        public final void onChanged(EnergyUsageResult energyUsageResult) {
            PlugPowerStatisticActivity.this.H3 = energyUsageResult;
            PlugPowerStatisticActivity.this.A1();
        }
    }

    /* compiled from: PlugPowerStatisticActivity.kt */
    /* loaded from: classes2.dex */
    static final class j extends Lambda implements kotlin.jvm.b.a<String> {
        j() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            String string = PlugPowerStatisticActivity.this.getString(R.string.power_unit_W);
            kotlin.jvm.internal.j.d(string, "getString(R.string.power_unit_W)");
            return string;
        }
    }

    public PlugPowerStatisticActivity() {
        kotlin.f b2;
        kotlin.f b3;
        kotlin.f b4;
        kotlin.f b5;
        b2 = kotlin.i.b(new f());
        this.p0 = b2;
        b3 = kotlin.i.b(new g());
        this.p1 = b3;
        b4 = kotlin.i.b(new j());
        this.p2 = b4;
        b5 = kotlin.i.b(new h());
        this.p3 = b5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void A1() {
        List m;
        EnergyUsageResult energyUsageResult = this.H3;
        if (energyUsageResult != null) {
            l1().clear();
            if (s1()) {
                List<Integer> past24h = energyUsageResult.getPast24h();
                if (!(past24h == null || past24h.isEmpty())) {
                    ArrayList arrayList = new ArrayList();
                    int i2 = 0;
                    for (Object obj : energyUsageResult.getPast24h()) {
                        i2++;
                        if (i2 < 0) {
                            n.k();
                        }
                        arrayList.add(new BarEntry(i2, v1(((Number) obj).intValue())));
                    }
                    PowerLineChart mLineChart = l1();
                    kotlin.jvm.internal.j.d(mLineChart, "mLineChart");
                    XAxis xAxis = mLineChart.getXAxis();
                    kotlin.jvm.internal.j.d(xAxis, "mLineChart.xAxis");
                    xAxis.setValueFormatter(new c(energyUsageResult.getLocalTimeInMS(), energyUsageResult.getPast24h().size()));
                    PowerLineChart mLineChart2 = l1();
                    kotlin.jvm.internal.j.d(mLineChart2, "mLineChart");
                    XAxis xAxis2 = mLineChart2.getXAxis();
                    kotlin.jvm.internal.j.d(xAxis2, "mLineChart.xAxis");
                    xAxis2.setLabelCount(5);
                    l1().b(arrayList, !this.I3);
                    w1(false);
                    this.I3 = true;
                    return;
                }
                return;
            }
            List<List<Integer>> past7d = energyUsageResult.getPast7d();
            if (!(past7d == null || past7d.isEmpty())) {
                ArrayList arrayList2 = new ArrayList();
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(new Date(energyUsageResult.getLocalTimeInMS()));
                calendar.add(5, 1);
                calendar.set(11, 0);
                m = o.m(energyUsageResult.getPast7d());
                int i3 = 0;
                for (Object obj2 : m) {
                    i3++;
                    if (i3 < 0) {
                        n.k();
                    }
                    arrayList2.add(new BarEntry(i3, v1(((Number) obj2).intValue())));
                }
                arrayList2.add(new BarEntry(arrayList2.size(), 0.0f));
                PowerLineChart mLineChart3 = l1();
                kotlin.jvm.internal.j.d(mLineChart3, "mLineChart");
                XAxis xAxis3 = mLineChart3.getXAxis();
                kotlin.jvm.internal.j.d(xAxis3, "mLineChart.xAxis");
                kotlin.jvm.internal.j.d(calendar, "calendar");
                Date time = calendar.getTime();
                kotlin.jvm.internal.j.d(time, "calendar.time");
                xAxis3.setValueFormatter(new b(time.getTime(), energyUsageResult.getPast7dCount()));
                PowerLineChart mLineChart4 = l1();
                kotlin.jvm.internal.j.d(mLineChart4, "mLineChart");
                mLineChart4.getXAxis().setLabelCount(8, true);
                l1().b(arrayList2, !this.J3);
                w1(false);
                this.J3 = true;
            }
        }
    }

    @SuppressLint({"SimpleDateFormat"})
    private final void B1(float f2, float f3, boolean z, boolean z2) {
        CardView mMarkerView = m1();
        kotlin.jvm.internal.j.d(mMarkerView, "mMarkerView");
        mMarkerView.setCardElevation(z2 ? com.tplink.iot.Utils.j.a(this, 4.0f) : 0.0f);
        ActivityPlugPowerStatisticBinding activityPlugPowerStatisticBinding = this.z;
        if (activityPlugPowerStatisticBinding == null) {
            kotlin.jvm.internal.j.t("mViewBinding");
        }
        TextView textView = activityPlugPowerStatisticBinding.x;
        kotlin.jvm.internal.j.d(textView, "mViewBinding.tvPower");
        p pVar = p.a;
        String format = String.format("%.1f", Arrays.copyOf(new Object[]{Float.valueOf(f3)}, 1));
        kotlin.jvm.internal.j.d(format, "java.lang.String.format(format, *args)");
        x1(textView, format, o1());
        EnergyUsageResult energyUsageResult = this.H3;
        if (energyUsageResult != null) {
            String str = o0.p(this) ? "H" : "h";
            String str2 = o0.p(this) ? "" : " a";
            if (z) {
                ActivityPlugPowerStatisticBinding activityPlugPowerStatisticBinding2 = this.z;
                if (activityPlugPowerStatisticBinding2 == null) {
                    kotlin.jvm.internal.j.t("mViewBinding");
                }
                TextView textView2 = activityPlugPowerStatisticBinding2.y;
                kotlin.jvm.internal.j.d(textView2, "mViewBinding.tvTime");
                textView2.setText(new SimpleDateFormat(str + ":mm" + str2 + ", MMM dd, yyyy").format(new Date(energyUsageResult.getLocalTimeInMS())));
            } else if (s1()) {
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(new Date(energyUsageResult.getLocalTimeInMS()));
                calendar.add(10, -((energyUsageResult.getPast24h().size() - ((int) f2)) - 1));
                ActivityPlugPowerStatisticBinding activityPlugPowerStatisticBinding3 = this.z;
                if (activityPlugPowerStatisticBinding3 == null) {
                    kotlin.jvm.internal.j.t("mViewBinding");
                }
                TextView textView3 = activityPlugPowerStatisticBinding3.y;
                kotlin.jvm.internal.j.d(textView3, "mViewBinding.tvTime");
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str + ":30" + str2 + ", MMM dd, yyyy");
                kotlin.jvm.internal.j.d(calendar, "calendar");
                textView3.setText(simpleDateFormat.format(calendar.getTime()));
            } else {
                Calendar calendar2 = Calendar.getInstance();
                calendar2.setTime(new Date(energyUsageResult.getLocalTimeInMS()));
                calendar2.add(5, 1);
                calendar2.set(11, 0);
                calendar2.add(10, -(energyUsageResult.getPast7dCount() - ((int) f2)));
                ActivityPlugPowerStatisticBinding activityPlugPowerStatisticBinding4 = this.z;
                if (activityPlugPowerStatisticBinding4 == null) {
                    kotlin.jvm.internal.j.t("mViewBinding");
                }
                TextView textView4 = activityPlugPowerStatisticBinding4.y;
                kotlin.jvm.internal.j.d(textView4, "mViewBinding.tvTime");
                SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat(str + ":30" + str2 + ", MMM dd, yyyy");
                kotlin.jvm.internal.j.d(calendar2, "calendar");
                textView4.setText(simpleDateFormat2.format(calendar2.getTime()));
            }
        }
    }

    public static final /* synthetic */ ActivityPlugPowerStatisticBinding f1(PlugPowerStatisticActivity plugPowerStatisticActivity) {
        ActivityPlugPowerStatisticBinding activityPlugPowerStatisticBinding = plugPowerStatisticActivity.z;
        if (activityPlugPowerStatisticBinding == null) {
            kotlin.jvm.internal.j.t("mViewBinding");
        }
        return activityPlugPowerStatisticBinding;
    }

    private final void k1() {
        boolean p = o0.p(this);
        if (p != this.K3) {
            this.K3 = p;
            PowerLineChart mLineChart = l1();
            kotlin.jvm.internal.j.d(mLineChart, "mLineChart");
            if (mLineChart.getHighlighted() != null) {
                PowerLineChart l1 = l1();
                PowerLineChart mLineChart2 = l1();
                kotlin.jvm.internal.j.d(mLineChart2, "mLineChart");
                Highlight[] highlighted = mLineChart2.getHighlighted();
                l1.highlightValue(highlighted != null ? (Highlight) kotlin.collections.e.l(highlighted, 0) : null, true);
                return;
            }
            A1();
        }
    }

    private final PowerLineChart l1() {
        return (PowerLineChart) this.p0.getValue();
    }

    private final CardView m1() {
        return (CardView) this.p1.getValue();
    }

    private final PlugEnergyMonitorViewModel n1() {
        return (PlugEnergyMonitorViewModel) this.p3.getValue();
    }

    private final String o1() {
        return (String) this.p2.getValue();
    }

    private final void p1() {
        l1().setOnChartValueSelectedListener(this);
        YAxis yAxis = l1().getYAxis();
        kotlin.jvm.internal.j.d(yAxis, "mLineChart.yAxis");
        yAxis.setValueFormatter(new a());
        l1().setOnDrawHighlightLineListener(new d());
    }

    private final void q1() {
        String str;
        Intent intent = getIntent();
        if (intent == null || (str = intent.getStringExtra("device_id_md5")) == null) {
            str = "";
        }
        this.y = str;
    }

    private final void r1() {
        b1(R.string.plug_power_statistic_title);
        ActivityPlugPowerStatisticBinding activityPlugPowerStatisticBinding = this.z;
        if (activityPlugPowerStatisticBinding == null) {
            kotlin.jvm.internal.j.t("mViewBinding");
        }
        activityPlugPowerStatisticBinding.q.addOnTabSelectedListener((TabLayout.OnTabSelectedListener) new e());
        p1();
    }

    private final boolean s1() {
        ActivityPlugPowerStatisticBinding activityPlugPowerStatisticBinding = this.z;
        if (activityPlugPowerStatisticBinding == null) {
            kotlin.jvm.internal.j.t("mViewBinding");
        }
        TabLayout tabLayout = activityPlugPowerStatisticBinding.q;
        kotlin.jvm.internal.j.d(tabLayout, "mViewBinding.pemTabLayout");
        return tabLayout.getSelectedTabPosition() == 0;
    }

    private final void t1() {
        if (s1()) {
            com.tplink.iot.Utils.x0.i.l(this.y);
        } else {
            com.tplink.iot.Utils.x0.i.m(this.y);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u1(float f2) {
        CardView mMarkerView = m1();
        kotlin.jvm.internal.j.d(mMarkerView, "mMarkerView");
        CardView mMarkerView2 = m1();
        kotlin.jvm.internal.j.d(mMarkerView2, "mMarkerView");
        float max = Math.max(f2 - (mMarkerView2.getWidth() / 2.0f), 0.0f);
        PowerLineChart mLineChart = l1();
        kotlin.jvm.internal.j.d(mLineChart, "mLineChart");
        int width = mLineChart.getWidth();
        CardView mMarkerView3 = m1();
        kotlin.jvm.internal.j.d(mMarkerView3, "mMarkerView");
        mMarkerView.setTranslationX(Math.min(max, width - mMarkerView3.getWidth()));
    }

    private final float v1(int i2) {
        float f2 = i2;
        if (f2 < 0.1f) {
            return 0.0f;
        }
        return f2;
    }

    private final void w1(boolean z) {
        CardView mMarkerView = m1();
        kotlin.jvm.internal.j.d(mMarkerView, "mMarkerView");
        mMarkerView.setCardElevation(0.0f);
        m1().animate().translationX(0.0f).start();
        if (z) {
            ActivityPlugPowerStatisticBinding activityPlugPowerStatisticBinding = this.z;
            if (activityPlugPowerStatisticBinding == null) {
                kotlin.jvm.internal.j.t("mViewBinding");
            }
            TextView textView = activityPlugPowerStatisticBinding.x;
            kotlin.jvm.internal.j.d(textView, "mViewBinding.tvPower");
            textView.setText("--");
            ActivityPlugPowerStatisticBinding activityPlugPowerStatisticBinding2 = this.z;
            if (activityPlugPowerStatisticBinding2 == null) {
                kotlin.jvm.internal.j.t("mViewBinding");
            }
            TextView textView2 = activityPlugPowerStatisticBinding2.y;
            kotlin.jvm.internal.j.d(textView2, "mViewBinding.tvTime");
            textView2.setText("--");
            return;
        }
        EnergyUsageResult energyUsageResult = this.H3;
        if (energyUsageResult != null) {
            B1(-1.0f, energyUsageResult.getCurrentPower() / 1000.0f, true, false);
        }
    }

    private final void x1(TextView textView, String str, String str2) {
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

    private final void y1() {
        n1().h().observe(this, new i());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void z1() {
        w1(true);
        A1();
        t1();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ViewDataBinding contentView = DataBindingUtil.setContentView(this, R.layout.activity_plug_power_statistic);
        kotlin.jvm.internal.j.d(contentView, "DataBindingUtil.setConte…ity_plug_power_statistic)");
        this.z = (ActivityPlugPowerStatisticBinding) contentView;
        q1();
        r1();
        y1();
        this.K3 = o0.p(this);
    }

    @Override // com.github.mikephil.charting.listener.OnChartValueSelectedListener
    public void onNothingSelected() {
        w1(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        n1().f();
        k1();
    }

    @Override // com.github.mikephil.charting.listener.OnChartValueSelectedListener
    public void onValueSelected(Entry entry, Highlight highlight) {
        if (entry != null) {
            B1(entry.getX(), entry.getY(), false, true);
        }
    }
}
