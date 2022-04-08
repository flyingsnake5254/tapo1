package com.tplink.iot.widget.businessview;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.SpannableString;
import android.text.style.RelativeSizeSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.tplink.iot.R;
import com.tplink.iot.Utils.z0.l;
import com.tplink.iot.cloud.bean.thing.common.ThingUsage;
import com.tplink.iot.cloud.bean.thing.common.ThingUsageDetail;
import com.tplink.libtpmediastatistics.SSLClient;

/* loaded from: classes3.dex */
public class ThingUsageView extends LinearLayout {
    private ThingUsage H3;
    private boolean I3;

    /* renamed from: c  reason: collision with root package name */
    private View f11653c;

    /* renamed from: d  reason: collision with root package name */
    private RadioGroup f11654d;

    /* renamed from: f  reason: collision with root package name */
    private RadioButton f11655f;
    private TextView p0;
    private View p1;
    private boolean p2;
    private Context p3;
    private RadioButton q;
    private RadioButton x;
    private TextView y;
    private TextView z;

    /* loaded from: classes3.dex */
    class a implements RadioGroup.OnCheckedChangeListener {
        a() {
        }

        @Override // android.widget.RadioGroup.OnCheckedChangeListener
        public void onCheckedChanged(RadioGroup radioGroup, int i) {
            if (!ThingUsageView.this.I3) {
                ThingUsageView thingUsageView = ThingUsageView.this;
                thingUsageView.n(thingUsageView.H3, i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (ThingUsageView.this.I3) {
                ThingUsageView thingUsageView = ThingUsageView.this;
                thingUsageView.p2 = thingUsageView.k(thingUsageView.H3);
                ThingUsageView thingUsageView2 = ThingUsageView.this;
                thingUsageView2.p(thingUsageView2.H3);
                return;
            }
            ThingUsageView thingUsageView3 = ThingUsageView.this;
            thingUsageView3.p2 = thingUsageView3.l(thingUsageView3.H3);
            ThingUsageView thingUsageView4 = ThingUsageView.this;
            thingUsageView4.n(thingUsageView4.H3, ThingUsageView.this.f11654d.getCheckedRadioButtonId());
        }
    }

    public ThingUsageView(Context context) {
        this(context, null);
    }

    private SpannableString i(int i) {
        String string = this.p3.getString(R.string.power_unit);
        StringBuilder sb = new StringBuilder();
        sb.append(l.g(i));
        sb.append(this.p2 ? "\n" : SSLClient.WHITE_SPACE);
        sb.append(string);
        SpannableString spannableString = new SpannableString(sb.toString());
        spannableString.setSpan(new RelativeSizeSpan(0.7f), spannableString.length() - string.length(), spannableString.length(), 17);
        return spannableString;
    }

    private SpannableString j(int i) {
        String string = this.p3.getString(R.string.time_h);
        StringBuilder sb = new StringBuilder();
        sb.append(l.i(i));
        sb.append(this.p2 ? "\n" : SSLClient.WHITE_SPACE);
        sb.append(string);
        SpannableString spannableString = new SpannableString(sb.toString());
        spannableString.setSpan(new RelativeSizeSpan(0.7f), spannableString.length() - string.length(), spannableString.length(), 17);
        return spannableString;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean k(ThingUsage thingUsage) {
        if (thingUsage == null || thingUsage.getTimeUsage() == null) {
            return false;
        }
        ThingUsageDetail timeUsage = thingUsage.getTimeUsage();
        int today = timeUsage.getToday();
        int past7 = timeUsage.getPast7();
        int past30 = timeUsage.getPast30();
        String string = this.p3.getString(R.string.time_h);
        int max = Math.max(Math.max(today, past7), past30);
        StringBuilder sb = new StringBuilder();
        sb.append(l.i(max));
        sb.append(SSLClient.WHITE_SPACE);
        sb.append(string);
        return ((int) this.y.getPaint().measureText(sb.toString())) > this.y.getWidth() && this.y.getWidth() > 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean l(ThingUsage thingUsage) {
        if (thingUsage == null || thingUsage.getTimeUsage() == null || thingUsage.getPowerUsage() == null || thingUsage.getSavedUsage() == null) {
            return false;
        }
        String string = this.p3.getString(R.string.time_h);
        int max = Math.max(thingUsage.getTimeUsage().getToday(), thingUsage.getTimeUsage().getPast30());
        String str = l.i(max) + SSLClient.WHITE_SPACE + string;
        String string2 = this.p3.getString(R.string.power_unit);
        int max2 = Math.max(thingUsage.getPowerUsage().getToday(), thingUsage.getPowerUsage().getPast30());
        int max3 = Math.max(thingUsage.getSavedUsage().getToday(), thingUsage.getSavedUsage().getPast30());
        StringBuilder sb = new StringBuilder();
        sb.append(l.g(Math.max(max2, max3)));
        sb.append(SSLClient.WHITE_SPACE);
        sb.append(string2);
        return Math.max((int) this.y.getPaint().measureText(str), (int) this.y.getPaint().measureText(sb.toString())) > this.y.getWidth() && this.y.getWidth() > 0;
    }

    private void m(int i) {
        RadioButton radioButton;
        this.f11655f.setTextSize(2, 14.0f);
        this.q.setTextSize(2, 14.0f);
        this.x.setTextSize(2, 14.0f);
        if (i == R.id.rb_today) {
            radioButton = this.f11655f;
        } else {
            radioButton = i == R.id.rb_past_7days ? this.q : this.x;
        }
        radioButton.setTextSize(2, 15.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(ThingUsage thingUsage, int i) {
        m(i);
        if (thingUsage == null || thingUsage.getTimeUsage() == null || thingUsage.getPowerUsage() == null || thingUsage.getSavedUsage() == null) {
            this.y.setText("--");
            this.z.setText("--");
            this.p0.setText("--");
            return;
        }
        switch (i) {
            case R.id.rb_past_30days /* 2131363766 */:
                this.y.setText(j(thingUsage.getTimeUsage().getPast30()));
                this.z.setText(i(thingUsage.getPowerUsage().getPast30()));
                this.p0.setText(i(thingUsage.getSavedUsage().getPast30()));
                return;
            case R.id.rb_past_7days /* 2131363767 */:
                this.y.setText(j(thingUsage.getTimeUsage().getPast7()));
                this.z.setText(i(thingUsage.getPowerUsage().getPast7()));
                this.p0.setText(i(thingUsage.getSavedUsage().getPast7()));
                return;
            case R.id.rb_today /* 2131363776 */:
                this.y.setText(j(thingUsage.getTimeUsage().getToday()));
                this.z.setText(i(thingUsage.getPowerUsage().getToday()));
                this.p0.setText(i(thingUsage.getSavedUsage().getToday()));
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(ThingUsage thingUsage) {
        ThingUsageDetail timeUsage = thingUsage != null ? thingUsage.getTimeUsage() : null;
        if (timeUsage != null) {
            this.y.setText(j(timeUsage.getToday()));
            this.z.setText(j(timeUsage.getPast7()));
            this.p0.setText(j(timeUsage.getPast30()));
            return;
        }
        this.y.setText(j(0));
        this.z.setText(j(0));
        this.p0.setText(j(0));
    }

    public void o(ThingUsage thingUsage) {
        this.H3 = thingUsage;
        this.y.post(new b());
    }

    public ThingUsageView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ThingUsageView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.p2 = false;
        this.I3 = false;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.tplink.iot.b.ThingUsageView, i, 0);
        if (obtainStyledAttributes != null) {
            this.I3 = obtainStyledAttributes.getBoolean(0, false);
        }
        LayoutInflater.from(context).inflate(R.layout.view_device_usage_layout, (ViewGroup) this, true);
        this.p3 = context;
        this.f11653c = findViewById(R.id.ll_days);
        this.f11654d = (RadioGroup) findViewById(R.id.rg_days);
        this.f11655f = (RadioButton) findViewById(R.id.rb_today);
        this.q = (RadioButton) findViewById(R.id.rb_past_7days);
        this.x = (RadioButton) findViewById(R.id.rb_past_30days);
        this.y = (TextView) findViewById(R.id.tv_runtime);
        this.z = (TextView) findViewById(R.id.tv_power);
        this.p0 = (TextView) findViewById(R.id.tv_saved);
        this.p1 = findViewById(R.id.ll_usage_type);
        if (this.I3) {
            this.f11654d.setVisibility(8);
            this.f11653c.setVisibility(0);
            this.p1.setVisibility(8);
        } else {
            this.f11654d.setVisibility(0);
            this.f11653c.setVisibility(8);
            this.p1.setVisibility(0);
        }
        this.f11654d.setOnCheckedChangeListener(new a());
    }
}
