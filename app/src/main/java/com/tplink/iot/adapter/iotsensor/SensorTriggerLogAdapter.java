package com.tplink.iot.adapter.iotsensor;

import android.content.Context;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.view.ViewKt;
import com.tplink.iot.R;
import com.tplink.iot.Utils.extension.g;
import com.tplink.iot.Utils.p0;
import com.tplink.iot.Utils.q0;
import com.tplink.iot.devicecommon.adapter.GeneralAdapter;
import java.util.Date;
import java.util.TimeZone;
import kotlin.collections.l;
import kotlin.f;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

/* compiled from: SensorTriggerLogAdapter.kt */
/* loaded from: classes2.dex */
public final class SensorTriggerLogAdapter extends GeneralAdapter<a> {

    /* renamed from: d  reason: collision with root package name */
    private String f5825d;

    /* renamed from: e  reason: collision with root package name */
    private final f f5826e;

    /* renamed from: f  reason: collision with root package name */
    private final f f5827f;
    private final f g;

    /* compiled from: SensorTriggerLogAdapter.kt */
    /* loaded from: classes2.dex */
    public static final class a extends ClickableSpan {

        /* renamed from: c  reason: collision with root package name */
        private final int f5828c;

        a() {
            this.f5828c = SensorTriggerLogAdapter.this.r().getResources().getColor(R.color.common_iot_purple);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View widget) {
            j.e(widget, "widget");
            Toast.makeText(SensorTriggerLogAdapter.this.r(), SensorTriggerLogAdapter.this.r().getString(R.string.sensor_view_all_trigger_logs), 0).show();
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint ds) {
            j.e(ds, "ds");
            super.updateDrawState(ds);
            ds.setColor(this.f5828c);
            ds.setUnderlineText(false);
        }
    }

    /* compiled from: SensorTriggerLogAdapter.kt */
    /* loaded from: classes2.dex */
    static final class b extends Lambda implements kotlin.jvm.b.a<String> {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Context f5830c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(Context context) {
            super(0);
            this.f5830c = context;
        }

        /* renamed from: a */
        public final String invoke() {
            return this.f5830c.getString(R.string.today);
        }
    }

    /* compiled from: SensorTriggerLogAdapter.kt */
    /* loaded from: classes2.dex */
    static final class c extends Lambda implements kotlin.jvm.b.a<String> {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Context f5831c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(Context context) {
            super(0);
            this.f5831c = context;
        }

        /* renamed from: a */
        public final String invoke() {
            return this.f5831c.getString(R.string.sensor_view_all_trigger_logs);
        }
    }

    /* compiled from: SensorTriggerLogAdapter.kt */
    /* loaded from: classes2.dex */
    static final class d extends Lambda implements kotlin.jvm.b.a<String> {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Context f5832c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(Context context) {
            super(0);
            this.f5832c = context;
        }

        /* renamed from: a */
        public final String invoke() {
            return this.f5832c.getString(R.string.yesterday);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public SensorTriggerLogAdapter(android.content.Context r2, java.util.List<com.tplink.iot.adapter.iotsensor.a> r3) {
        /*
            r1 = this;
            java.lang.String r0 = "context"
            kotlin.jvm.internal.j.e(r2, r0)
            java.lang.String r0 = "logList"
            kotlin.jvm.internal.j.e(r3, r0)
            java.util.List r3 = kotlin.collections.l.U(r3)
            r1.<init>(r2, r3)
            java.util.TimeZone r3 = java.util.TimeZone.getDefault()
            java.lang.String r0 = "TimeZone.getDefault()"
            kotlin.jvm.internal.j.d(r3, r0)
            java.lang.String r3 = r3.getID()
            java.lang.String r0 = "TimeZone.getDefault().id"
            kotlin.jvm.internal.j.d(r3, r0)
            r1.f5825d = r3
            com.tplink.iot.adapter.iotsensor.SensorTriggerLogAdapter$b r3 = new com.tplink.iot.adapter.iotsensor.SensorTriggerLogAdapter$b
            r3.<init>(r2)
            kotlin.f r3 = kotlin.h.b(r3)
            r1.f5826e = r3
            com.tplink.iot.adapter.iotsensor.SensorTriggerLogAdapter$d r3 = new com.tplink.iot.adapter.iotsensor.SensorTriggerLogAdapter$d
            r3.<init>(r2)
            kotlin.f r3 = kotlin.h.b(r3)
            r1.f5827f = r3
            com.tplink.iot.adapter.iotsensor.SensorTriggerLogAdapter$c r3 = new com.tplink.iot.adapter.iotsensor.SensorTriggerLogAdapter$c
            r3.<init>(r2)
            kotlin.f r2 = kotlin.h.b(r3)
            r1.g = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tplink.iot.adapter.iotsensor.SensorTriggerLogAdapter.<init>(android.content.Context, java.util.List):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0092, code lost:
        r9 = kotlin.text.t.i(r9);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final java.lang.String C(com.tplink.libtpnetwork.IoTNetwork.bean.sub.common.TriggerLog r9) {
        /*
            Method dump skipped, instructions count: 370
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tplink.iot.adapter.iotsensor.SensorTriggerLogAdapter.C(com.tplink.libtpnetwork.IoTNetwork.bean.sub.common.TriggerLog):java.lang.String");
    }

    private final String D(Long l) {
        if (l == null) {
            return "";
        }
        long longValue = l.longValue();
        Date date = new Date();
        Date date2 = new Date(longValue);
        TimeZone deviceTimeZone = p0.d(this.f5825d);
        if (q0.f(date, date2, deviceTimeZone)) {
            String mTodayStr = E();
            j.d(mTodayStr, "mTodayStr");
            return mTodayStr;
        } else if (q0.i(date2, deviceTimeZone)) {
            String mYesterdayStr = G();
            j.d(mYesterdayStr, "mYesterdayStr");
            return mYesterdayStr;
        } else {
            j.d(deviceTimeZone, "deviceTimeZone");
            return g.d(date2, deviceTimeZone, null, 2, null);
        }
    }

    private final String E() {
        return (String) this.f5826e.getValue();
    }

    private final String F() {
        return (String) this.g.getValue();
    }

    private final String G() {
        return (String) this.f5827f.getValue();
    }

    private final SpannableString H(String str) {
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new a(), 0, spannableString.length(), 33);
        return spannableString;
    }

    private final void J(GeneralAdapter.GeneralVH generalVH, a aVar, int i) {
        View c2 = generalVH.c(R.id.view_line_above);
        boolean z = false;
        if (c2 != null) {
            a aVar2 = (a) l.z(s(), i - 1);
            ViewKt.setInvisible(c2, aVar2 != null && aVar2.c());
        }
        View c3 = generalVH.c(R.id.view_line_below);
        if (c3 != null) {
            a aVar3 = (a) l.z(s(), i + 1);
            if (aVar3 == null || aVar3.c()) {
                z = true;
            }
            ViewKt.setInvisible(c3, z);
        }
    }

    /* renamed from: B */
    public void m(GeneralAdapter.GeneralVH holder, a data, int i) {
        j.e(holder, "holder");
        j.e(data, "data");
        if (s().get(i).c()) {
            holder.d(R.id.tv_date, D(data.a()));
            return;
        }
        View c2 = holder.c(R.id.ll_trigger_head);
        if (c2 != null) {
            c2.setVisibility(0);
        }
        holder.d(R.id.tv_trigger_time, C(data.b()));
        J(holder, data, i);
    }

    public final void I(String str) {
        j.e(str, "<set-?>");
        this.f5825d = str;
    }

    @Override // com.tplink.iot.devicecommon.adapter.GeneralAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return s().size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        a aVar = (a) l.z(s(), i);
        return (aVar == null || !aVar.c()) ? 2 : 1;
    }

    @Override // com.tplink.iot.devicecommon.adapter.GeneralAdapter
    public void n(GeneralAdapter.GeneralVH holder, int i) {
        j.e(holder, "holder");
        LinearLayout linearLayout = (LinearLayout) holder.c(R.id.ll_trigger_head);
        if (linearLayout != null) {
            linearLayout.setVisibility(4);
        }
        TextView textView = (TextView) holder.c(R.id.tv_trigger_time);
        if (textView != null) {
            textView.setMovementMethod(new LinkMovementMethod());
            String mViewAllStr = F();
            j.d(mViewAllStr, "mViewAllStr");
            textView.setText(H(mViewAllStr));
        }
    }

    @Override // com.tplink.iot.devicecommon.adapter.GeneralAdapter
    public int p(int i) {
        return i == 2 ? R.layout.item_sensor_trigger_log : R.layout.item_sensor_trigger_log_date;
    }
}
