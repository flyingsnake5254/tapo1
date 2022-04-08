package com.tplink.iot.adapter.feature;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.R;
import com.tplink.iot.Utils.c0;
import com.tplink.iot.Utils.l0;
import com.tplink.iot.Utils.o0;
import com.tplink.iot.Utils.p0;
import com.tplink.iot.Utils.z0.g;
import com.tplink.iot.Utils.z0.i;
import com.tplink.iot.Utils.z0.l;
import com.tplink.iot.cloud.enumerate.RuleTimeType;
import com.tplink.iot.devices.lightstrip.widget.LightStripTintView;
import com.tplink.iot.widget.WeekdayView;
import com.tplink.iot.widget.colorbulb.SmallBulbTintView;
import com.tplink.libtpcontrols.materialnormalcompat.swicth.TPSwitchCompat;
import com.tplink.libtpmediastatistics.SSLClient;
import com.tplink.libtpnetwork.IoTNetwork.bean.bulb.DesiredStatesBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.result.ScheduleRuleBean;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class ScheduleAdapter extends RecyclerView.Adapter<e> {
    private List<ScheduleRuleBean> a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    private Activity f5573b;

    /* renamed from: c  reason: collision with root package name */
    private Animation f5574c;

    /* renamed from: d  reason: collision with root package name */
    private BaseALIoTDevice f5575d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f5576e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f5577f;
    private String g;
    private f h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ ScheduleRuleBean f5578c;

        a(ScheduleRuleBean scheduleRuleBean) {
            this.f5578c = scheduleRuleBean;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ScheduleAdapter.this.h != null) {
                ScheduleAdapter.this.h.N(this.f5578c);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b implements View.OnLongClickListener {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ ScheduleRuleBean f5580c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ int f5581d;

        b(ScheduleRuleBean scheduleRuleBean, int i) {
            this.f5580c = scheduleRuleBean;
            this.f5581d = i;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            ScheduleAdapter.this.t(view, this.f5580c, this.f5581d);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class c implements TPSwitchCompat.a {
        final /* synthetic */ ScheduleRuleBean a;

        c(ScheduleRuleBean scheduleRuleBean) {
            this.a = scheduleRuleBean;
        }

        @Override // com.tplink.libtpcontrols.materialnormalcompat.swicth.TPSwitchCompat.a
        public void c(CompoundButton compoundButton, boolean z, boolean z2) {
            if (z2) {
                this.a.setEnable(z);
                if (ScheduleAdapter.this.h != null) {
                    ScheduleAdapter.this.h.W(this.a);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class d implements l0.d {
        final /* synthetic */ ScheduleRuleBean a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f5584b;

        d(ScheduleRuleBean scheduleRuleBean, int i) {
            this.a = scheduleRuleBean;
            this.f5584b = i;
        }

        @Override // com.tplink.iot.Utils.l0.d
        public void a(View view, int i) {
            this.a.setDeleting(true);
            ScheduleAdapter.this.notifyItemChanged(this.f5584b);
            if (ScheduleAdapter.this.h != null) {
                ScheduleAdapter.this.h.H0(this.a);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class e extends RecyclerView.ViewHolder {
        SmallBulbTintView a;

        /* renamed from: b  reason: collision with root package name */
        LightStripTintView f5586b;

        /* renamed from: c  reason: collision with root package name */
        private ImageView f5587c;

        /* renamed from: d  reason: collision with root package name */
        TextView f5588d;

        /* renamed from: e  reason: collision with root package name */
        TextView f5589e;

        /* renamed from: f  reason: collision with root package name */
        TextView f5590f;
        WeekdayView g;
        TPSwitchCompat h;
        ImageView i;
        View j;
        TextView k;

        public e(View view) {
            super(view);
            this.a = (SmallBulbTintView) view.findViewById(R.id.iv_color_bulb);
            this.f5586b = (LightStripTintView) view.findViewById(R.id.iv_light_strip_tint);
            this.f5587c = (ImageView) view.findViewById(R.id.iv_device_image);
            this.f5588d = (TextView) view.findViewById(R.id.tv_status_type);
            this.f5589e = (TextView) view.findViewById(R.id.tv_time);
            this.f5590f = (TextView) view.findViewById(R.id.tv_day_tips);
            this.g = (WeekdayView) view.findViewById(R.id.weekday_view);
            this.h = (TPSwitchCompat) view.findViewById(R.id.switch_button);
            this.i = (ImageView) view.findViewById(R.id.iv_delete_item);
            this.j = view.findViewById(R.id.view_cover);
            this.k = (TextView) view.findViewById(R.id.tv_sunrise_sunset_time);
        }

        public void d() {
            this.a.setVisibility(8);
            this.f5586b.setVisibility(8);
            this.f5587c.setVisibility(8);
        }

        public void e(boolean z) {
            if (z) {
                this.i.setVisibility(0);
                this.i.startAnimation(ScheduleAdapter.this.f5574c);
                this.h.setVisibility(8);
                this.j.setVisibility(0);
                return;
            }
            this.i.clearAnimation();
            this.i.setVisibility(8);
            this.h.setVisibility(0);
            this.j.setVisibility(8);
        }
    }

    /* loaded from: classes2.dex */
    public interface f {
        void H0(ScheduleRuleBean scheduleRuleBean);

        void N(ScheduleRuleBean scheduleRuleBean);

        void W(ScheduleRuleBean scheduleRuleBean);
    }

    public ScheduleAdapter(Activity activity, BaseALIoTDevice baseALIoTDevice, boolean z, boolean z2, String str) {
        this.f5573b = activity;
        this.f5574c = AnimationUtils.loadAnimation(activity, R.anim.anim_common_roate);
        this.f5575d = baseALIoTDevice;
        this.f5576e = z;
        this.f5577f = z2;
        this.g = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(View view, ScheduleRuleBean scheduleRuleBean, int i) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f5573b.getString(R.string.common_delete).toUpperCase());
        l0 l0Var = new l0(this.f5573b, arrayList);
        l0Var.setAnimationStyle(R.style.popupAnimLeft);
        l0Var.g(this.f5573b.getResources().getColor(R.color.color_FF2954));
        l0Var.f(new d(scheduleRuleBean, i));
        l0Var.i(view);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<ScheduleRuleBean> list = this.a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @SuppressLint({"SetTextI18n"})
    /* renamed from: p */
    public void onBindViewHolder(@NonNull e eVar, int i) {
        int i2;
        Resources resources;
        ScheduleRuleBean scheduleRuleBean = this.a.get(i);
        eVar.e(scheduleRuleBean.isDeleting());
        DesiredStatesBean desiredStates = scheduleRuleBean.getDesiredStates();
        boolean z = true;
        boolean z2 = desiredStates != null && desiredStates.isOn();
        if (desiredStates == null || !desiredStates.isAuto()) {
            z = false;
        }
        TextView textView = eVar.f5588d;
        Activity activity = this.f5573b;
        textView.setTextColor(z2 ? activity.getResources().getColor(R.color.common_iot_main_blue) : activity.getResources().getColor(R.color.color_999999));
        Activity activity2 = this.f5573b;
        int i3 = R.string.common_off;
        String string = activity2.getString(R.string.common_off);
        eVar.d();
        BaseALIoTDevice baseALIoTDevice = this.f5575d;
        if (baseALIoTDevice != null && baseALIoTDevice.isBulb()) {
            int i4 = 100;
            if (this.f5575d.isLightStrip()) {
                if (desiredStates == null || desiredStates.getLightingEffectData() == null) {
                    eVar.f5586b.setVisibility(0);
                    eVar.f5586b.setTintColor(com.tplink.iot.g.b.c.c.f(scheduleRuleBean.getDesiredStates()));
                    if (z2 && z) {
                        string = this.f5573b.getString(R.string.setting_auto);
                    } else if (z2) {
                        if (desiredStates != null) {
                            i4 = desiredStates.getBrightness();
                        }
                        string = i4 + "%";
                    }
                } else {
                    eVar.f5587c.setVisibility(0);
                    eVar.f5587c.setImageResource(R.mipmap.icon_lighting_effect_scene);
                    string = this.f5573b.getString(R.string.common_on);
                }
                eVar.f5588d.setText(string);
            } else if (this.f5576e) {
                if (z2 && z) {
                    string = this.f5573b.getString(R.string.setting_auto);
                } else if (z2) {
                    if (desiredStates != null) {
                        i4 = desiredStates.getBrightness();
                    }
                    string = i4 + "%";
                }
                eVar.a.setVisibility(0);
                eVar.a.setTintColor(i.g(scheduleRuleBean.getDesiredStates()));
                eVar.f5588d.setText(string);
            } else {
                eVar.a.setVisibility(0);
                eVar.a.setTintColor(g.f(z2));
                if (z2) {
                    if (desiredStates != null) {
                        i4 = desiredStates.getBrightness();
                    }
                    string = i4 + "%";
                }
                eVar.f5588d.setText(string);
            }
        } else if (com.tplink.iot.g.d.a.b.k(this.f5575d)) {
            eVar.f5587c.setVisibility(0);
            l.o(this.f5573b, this.f5575d, eVar.f5587c);
            if (desiredStates != null) {
                boolean isFrostProtectionOn = desiredStates.isFrostProtectionOn();
                if (isFrostProtectionOn) {
                    eVar.f5588d.setText(R.string.common_off);
                } else {
                    eVar.f5588d.setText(com.tplink.iot.g.d.a.b.e(desiredStates.getTargetTemp(), desiredStates.getTempUnit()));
                }
                eVar.f5588d.setTextColor(isFrostProtectionOn ? this.f5573b.getResources().getColor(R.color.color_999999) : this.f5573b.getResources().getColor(R.color.common_iot_orange));
            } else {
                eVar.f5588d.setText(R.string.common_off);
            }
        } else {
            eVar.f5587c.setVisibility(0);
            l.o(this.f5573b, this.f5575d, eVar.f5587c);
            if (desiredStates != null) {
                TextView textView2 = eVar.f5588d;
                if (desiredStates.isOn()) {
                    i3 = R.string.common_on;
                }
                textView2.setText(i3);
            } else {
                TextView textView3 = eVar.f5588d;
                if (scheduleRuleBean.isActionOn()) {
                    i3 = R.string.common_on;
                }
                textView3.setText(i3);
            }
        }
        eVar.h.setChecked(scheduleRuleBean.isEnable());
        eVar.g.setWeekdayTime(scheduleRuleBean.getWeekOfDays());
        if (scheduleRuleBean.getStartTimeType() != RuleTimeType.NORMAL) {
            eVar.k.setVisibility(0);
            TextView textView4 = eVar.k;
            StringBuilder sb = new StringBuilder();
            if (scheduleRuleBean.getStartTimeType() == RuleTimeType.SUNRISE) {
                resources = this.f5573b.getResources();
                i2 = R.string.sunrise;
            } else {
                resources = this.f5573b.getResources();
                i2 = R.string.sunset;
            }
            sb.append(resources.getString(i2));
            sb.append(SSLClient.WHITE_SPACE);
            sb.append(o0.o(this.f5573b, scheduleRuleBean.getTimeOffset()));
            textView4.setText(sb.toString());
        } else {
            eVar.k.setVisibility(8);
        }
        eVar.f5589e.setText(o0.a(this.f5573b, p0.c(scheduleRuleBean.getStartTimeMin(), this.f5577f, this.g)));
        eVar.g.setVisibility(8);
        eVar.f5590f.setVisibility(0);
        eVar.f5590f.setText(c0.a(this.f5573b, scheduleRuleBean.getWeekOfDays()));
        eVar.itemView.setOnClickListener(new a(scheduleRuleBean));
        eVar.itemView.setOnLongClickListener(new b(scheduleRuleBean, i));
        eVar.h.setOnSwitchCheckedChangeListener(new c(scheduleRuleBean));
    }

    @NonNull
    /* renamed from: q */
    public e onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new e(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_schedule, viewGroup, false));
    }

    public void r(List<ScheduleRuleBean> list) {
        this.a.clear();
        this.a.addAll(list);
        notifyDataSetChanged();
    }

    public void s(f fVar) {
        this.h = fVar;
    }
}
