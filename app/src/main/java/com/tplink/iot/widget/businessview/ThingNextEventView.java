package com.tplink.iot.widget.businessview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.tplink.iot.R;
import com.tplink.iot.Utils.o0;
import com.tplink.iot.Utils.p0;
import com.tplink.iot.Utils.t;
import com.tplink.iot.Utils.z0.i;
import com.tplink.iot.cloud.bean.thing.common.NextEvent;
import com.tplink.iot.devices.lightstrip.widget.LightingEffectPointView;
import com.tplink.iot.widget.colorbulb.ColorPointView;
import com.tplink.libtpmediastatistics.SSLClient;
import com.tplink.libtpnetwork.IoTNetwork.bean.bulb.DesiredStatesBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.bulb.result.BulbNextEvent;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.params.LightingEffectData;
import com.tplink.libtpnetwork.IoTNetwork.bean.plug.result.PlugNextEvent;
import com.tplink.libtpnetwork.IoTNetwork.bean.thingmodel.ThingModelDefine;
import com.tplink.libtpnetwork.IoTNetwork.bean.trv.result.TRVNextEvent;
import com.tplink.libtpnetwork.Utils.l;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: classes3.dex */
public class ThingNextEventView extends LinearLayout {
    private TextView H3;
    private ImageView I3;
    private ColorPointView J3;
    private LightingEffectPointView K3;
    private d L3;

    /* renamed from: c  reason: collision with root package name */
    private Timer f11647c;

    /* renamed from: d  reason: collision with root package name */
    private Timer f11648d;

    /* renamed from: f  reason: collision with root package name */
    private b f11649f;
    private Context p0;
    private TextView p1;
    private TextView p2;
    private TextView p3;
    private c q;
    private long x;
    private long y;
    private Handler z;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class b extends TimerTask {

        /* loaded from: classes3.dex */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                int currentTimeMillis = (int) ((ThingNextEventView.this.x - System.currentTimeMillis()) / 1000);
                if (currentTimeMillis < 0) {
                    ThingNextEventView.this.f();
                    ThingNextEventView.this.setVisibility(8);
                    return;
                }
                ThingNextEventView.this.p1.setText(o0.e(currentTimeMillis));
            }
        }

        private b() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            ThingNextEventView.this.z.postDelayed(new a(), 0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class c extends TimerTask {
        private c() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ String a() {
            return "NextEventEndTask run";
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            if (ThingNextEventView.this.L3 != null) {
                l.a(b.f11659c);
                ThingNextEventView.this.L3.a();
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface d {
        void a();
    }

    public ThingNextEventView(Context context) {
        this(context, null);
    }

    private void g() {
        c cVar = this.q;
        if (cVar != null) {
            cVar.cancel();
            this.q = null;
        }
        Timer timer = this.f11648d;
        if (timer != null) {
            timer.cancel();
            this.f11648d = null;
        }
    }

    private long getTodayEndTimeStamp() {
        Calendar instance = Calendar.getInstance();
        instance.set(instance.get(1), instance.get(2), instance.get(5), 23, 59, 59);
        return instance.getTimeInMillis();
    }

    private String h(Context context, long j, String str) {
        Calendar instance = Calendar.getInstance(p0.d(str));
        instance.setTime(new Date(j));
        int i = instance.get(11);
        int i2 = instance.get(12);
        String l = j > getTodayEndTimeStamp() ? com.tplink.iot.Utils.z0.l.l(context, instance.get(7)) : "";
        StringBuilder sb = new StringBuilder();
        sb.append(p0.a(context, (i * 60) + i2));
        if (!TextUtils.isEmpty(l)) {
            l = SSLClient.WHITE_SPACE + l;
        }
        sb.append(l);
        sb.append(p0.e(str));
        return sb.toString();
    }

    private void i() {
        this.J3.setVisibility(8);
        this.p3.setVisibility(8);
        this.K3.setVisibility(8);
        this.H3.setVisibility(8);
    }

    private void j(Context context) {
        this.p0 = context;
        LayoutInflater.from(context).inflate(R.layout.view_next_event_layout, (ViewGroup) this, true);
        this.I3 = (ImageView) findViewById(R.id.iv_next_event_type);
        this.p1 = (TextView) findViewById(R.id.tv_next_event_time);
        this.p2 = (TextView) findViewById(R.id.tv_next_event_action);
        this.H3 = (TextView) findViewById(R.id.tv_next_event_desc);
        this.J3 = (ColorPointView) findViewById(R.id.color_point_view);
        this.K3 = (LightingEffectPointView) findViewById(R.id.lighting_effect_point_view);
        this.p3 = (TextView) findViewById(R.id.tv_brightness);
        this.z = new Handler();
        setVisibility(8);
        i();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ String k() {
        return "startEndTimer";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l */
    public /* synthetic */ String m() {
        return "mTimeStamp: " + this.y + " currentTimestamp: " + System.currentTimeMillis();
    }

    private void n(NextEvent nextEvent, boolean z) {
        Context context;
        int i;
        this.I3.setImageResource(t.a(nextEvent.getType()));
        if (nextEvent.getType() == 3) {
            i();
            TextView textView = this.p2;
            if (z) {
                context = this.p0;
                i = R.string.away_mode_ends;
            } else {
                context = this.p0;
                i = R.string.away_mode_starts;
            }
            textView.setText(context.getString(i));
            return;
        }
        setNextEventAction(nextEvent);
    }

    private void o(String str) {
        this.p3.setVisibility(0);
        this.p3.setText(str);
    }

    private void p() {
        this.f11647c = new Timer();
        b bVar = new b();
        this.f11649f = bVar;
        this.f11647c.schedule(bVar, 0L, 1000L);
    }

    private void q() {
        l.a(a.f11658c);
        this.f11648d = new Timer();
        c cVar = new c();
        this.q = cVar;
        this.f11648d.schedule(cVar, new Date(this.y));
    }

    @SuppressLint({"SetTextI18n"})
    private void setNextEventAction(NextEvent nextEvent) {
        i();
        boolean z = false;
        if (nextEvent instanceof BulbNextEvent) {
            BulbNextEvent bulbNextEvent = (BulbNextEvent) nextEvent;
            Map<String, Object> desiredStates = bulbNextEvent.getDesiredStates();
            DesiredStatesBean formatDesiredStates = bulbNextEvent.getFormatDesiredStates();
            if (desiredStates == null || formatDesiredStates == null || !formatDesiredStates.isOn()) {
                this.p2.setText(this.p0.getString(R.string.turn_device_off));
                return;
            }
            Object obj = desiredStates.get("brightness");
            Object obj2 = desiredStates.get(ThingModelDefine.Property.PROPERTY_COLOR_TEMP);
            Object obj3 = desiredStates.get(ThingModelDefine.Property.PROPERTY_HUE);
            Object obj4 = desiredStates.get(ThingModelDefine.Property.PROPERTY_LIGHTING_EFFECT);
            this.p2.setText(this.p0.getString(R.string.turn_device_on));
            if (formatDesiredStates.isAuto()) {
                this.p2.setText(i.b(this.p0, formatDesiredStates.getAutoMode()));
            } else if (obj4 != null) {
                LightingEffectData lightingEffectData = formatDesiredStates.getLightingEffectData();
                this.K3.setVisibility(0);
                this.K3.h(1);
                if (lightingEffectData.brightness != null) {
                    o(lightingEffectData.brightness + "%");
                }
            } else if (obj2 != null || obj3 != null) {
                if (obj != null) {
                    String e2 = i.e(formatDesiredStates.getColorTemp());
                    o(formatDesiredStates.getBrightness() + "%" + e2);
                }
                this.J3.setVisibility(0);
                this.J3.setInnerCircleColor(i.c(formatDesiredStates.getColorTemp(), formatDesiredStates.getHue(), formatDesiredStates.getSaturation()));
            } else if (obj != null) {
                o(formatDesiredStates.getBrightness() + "%");
            }
        } else if (nextEvent instanceof PlugNextEvent) {
            PlugNextEvent plugNextEvent = (PlugNextEvent) nextEvent;
            if (plugNextEvent.getFormatDesiredStates() != null) {
                z = plugNextEvent.getFormatDesiredStates().isOn();
            } else if (nextEvent.getAction() == 1) {
                z = true;
            }
            Context context = this.p0;
            this.p2.setText(z ? context.getString(R.string.turn_device_on) : context.getString(R.string.turn_device_off));
        } else if (nextEvent instanceof TRVNextEvent) {
            this.p3.setVisibility(8);
            TRVNextEvent tRVNextEvent = (TRVNextEvent) nextEvent;
            if (tRVNextEvent.getDesiredStatesBean() == null) {
                return;
            }
            if (!tRVNextEvent.getDesiredStatesBean().isFrostProtectionOn()) {
                this.p2.setText(this.p0.getString(R.string.smart_action_set_temperature_to_temp, com.tplink.iot.g.d.a.b.e(tRVNextEvent.getDesiredStatesBean().getTargetTemp(), tRVNextEvent.getDesiredStatesBean().getTempUnit())));
                this.H3.setText("");
                this.H3.setVisibility(0);
                return;
            }
            this.p2.setText(this.p0.getString(R.string.smart_action_device_turn_off));
            this.H3.setText("");
            this.H3.setVisibility(8);
        }
    }

    public void e() {
        f();
        g();
        Handler handler = this.z;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.z = null;
        }
    }

    public void f() {
        b bVar = this.f11649f;
        if (bVar != null) {
            bVar.cancel();
            this.f11649f = null;
        }
        Timer timer = this.f11647c;
        if (timer != null) {
            timer.cancel();
            this.f11647c = null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0070, code lost:
        if (r14 != 3) goto L_0x0085;
     */
    /* JADX WARN: Removed duplicated region for block: B:28:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void r(com.tplink.iot.cloud.bean.thing.common.NextEvent r14, java.lang.String r15) {
        /*
            r13 = this;
            r13.g()
            r13.f()
            r0 = 8
            r13.setVisibility(r0)
            if (r14 == 0) goto L_0x0090
            int r0 = r14.getType()
            boolean r0 = com.tplink.iot.Utils.t.h(r0)
            if (r0 == 0) goto L_0x0090
            r0 = 0
            int r2 = r14.getType()
            boolean r2 = com.tplink.iot.Utils.t.h(r2)
            r3 = 1000(0x3e8, double:4.94E-321)
            r5 = 1
            r6 = 3
            r7 = 0
            if (r2 == 0) goto L_0x004e
            int r0 = r14.getStartTime()
            long r0 = com.tplink.iot.Utils.o0.k(r0, r15)
            int r2 = r14.getType()
            if (r2 != r6) goto L_0x0048
            long r8 = java.lang.System.currentTimeMillis()
            int r2 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1))
            if (r2 >= 0) goto L_0x0048
            int r0 = r14.getEndTime()
            long r0 = com.tplink.iot.Utils.o0.k(r0, r15)
            r2 = 1
            goto L_0x0049
        L_0x0048:
            r2 = 0
        L_0x0049:
            long r8 = r0 + r3
            r13.y = r8
            goto L_0x004f
        L_0x004e:
            r2 = 0
        L_0x004f:
            com.tplink.iot.widget.businessview.c r8 = new com.tplink.iot.widget.businessview.c
            r8.<init>()
            com.tplink.libtpnetwork.Utils.l.a(r8)
            long r8 = r13.y
            long r10 = java.lang.System.currentTimeMillis()
            int r12 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r12 <= 0) goto L_0x0064
            r13.q()
        L_0x0064:
            r13.n(r14, r2)
            int r14 = r14.getType()
            if (r14 == r5) goto L_0x007a
            r2 = 2
            if (r14 == r2) goto L_0x0073
            if (r14 == r6) goto L_0x007a
            goto L_0x0085
        L_0x0073:
            long r3 = r3 + r0
            r13.x = r3
            r13.p()
            goto L_0x0085
        L_0x007a:
            android.widget.TextView r14 = r13.p1
            android.content.Context r2 = r13.p0
            java.lang.String r15 = r13.h(r2, r0, r15)
            r14.setText(r15)
        L_0x0085:
            long r14 = java.lang.System.currentTimeMillis()
            int r2 = (r0 > r14 ? 1 : (r0 == r14 ? 0 : -1))
            if (r2 <= 0) goto L_0x0090
            r13.setVisibility(r7)
        L_0x0090:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tplink.iot.widget.businessview.ThingNextEventView.r(com.tplink.iot.cloud.bean.thing.common.NextEvent, java.lang.String):void");
    }

    public void setOnNextEventCallback(d dVar) {
        this.L3 = dVar;
    }

    public ThingNextEventView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ThingNextEventView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.x = 0L;
        this.y = 0L;
        j(context);
    }
}
