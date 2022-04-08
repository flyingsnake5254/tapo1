package com.tplink.iot.model.home;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.animation.Animation;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.R;
import com.tplink.iot.Utils.j;
import com.tplink.iot.Utils.u0;
import com.tplink.iot.Utils.w;
import com.tplink.iot.Utils.z0.l;
import com.tplink.iot.Utils.z0.o;
import com.tplink.iot.Utils.z0.p;
import com.tplink.iot.Utils.z0.r;
import com.tplink.iot.adapter.home.i;
import com.tplink.iot.devices.lightstrip.widget.LightingEffectPointView;
import com.tplink.iot.widget.RippleCardView;
import com.tplink.iot.widget.colorbulb.ColorPointHomeView;
import com.tplink.libtpcontrols.materialnormalcompat.checkbox.TPCheckboxCompat;
import com.tplink.libtpnetwork.IoTNetwork.bean.group.GroupBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.IoTLightStripDevice;
import com.tplink.libtpnetwork.IoTNetwork.bean.sub.common.TriggerLog;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.IoTNetwork.repository.SensorRepository;
import com.tplink.libtpnetwork.IoTNetwork.repository.SwitchRepository;
import com.tplink.libtpnetwork.Utils.g;
import com.tplink.libtpnetwork.cameranetwork.bean.ALCameraDevice;
import com.tplink.libtpnetwork.enumerate.EnumIoTComponent;
import com.tplink.libtpnetwork.enumerate.EnumIoTDeviceState;

/* loaded from: classes2.dex */
public class DeviceInfoHolder extends RecyclerView.ViewHolder implements i {
    private TextView H3;
    private TextView I3;
    private TextView J3;
    private TextView K3;
    private ColorPointHomeView L3;
    private RelativeLayout M3;
    private LightingEffectPointView N3;
    private ImageView O3;
    private TPCheckboxCompat P3;
    private RippleCardView Q3;
    private CardView R3;
    private ImageView S3;
    private View T3;
    private ImageView U3;
    private boolean V3;

    /* renamed from: c  reason: collision with root package name */
    private Context f8129c;

    /* renamed from: d  reason: collision with root package name */
    private Animation f8130d;

    /* renamed from: f  reason: collision with root package name */
    private e f8131f;
    private ImageView p0;
    private TextView p1;
    private TextView p2;
    private TextView p3;
    private TextView q;
    private TextView x;
    private ImageView y;
    private ImageView z;

    /* loaded from: classes2.dex */
    class a implements View.OnLongClickListener {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ e f8132c;

        a(e eVar) {
            this.f8132c = eVar;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            if (DeviceInfoHolder.this.V3) {
                return DeviceInfoHolder.this.y(this.f8132c);
            }
            return true;
        }
    }

    /* loaded from: classes2.dex */
    class b implements View.OnClickListener {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ e f8134c;

        b(e eVar) {
            this.f8134c = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!DeviceInfoHolder.this.t()) {
                e eVar = this.f8134c;
                if (eVar instanceof k) {
                    ((k) eVar).B(false);
                }
                DeviceInfoHolder.this.v(this.f8134c);
            }
        }
    }

    /* loaded from: classes2.dex */
    class c implements TPCheckboxCompat.a {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ e f8136c;

        c(e eVar) {
            this.f8136c = eVar;
        }

        @Override // com.tplink.libtpcontrols.materialnormalcompat.checkbox.TPCheckboxCompat.a
        public void c(CompoundButton compoundButton, boolean z, boolean z2) {
            if (z2) {
                if (z) {
                    DeviceInfoHolder.this.B(this.f8136c);
                } else {
                    DeviceInfoHolder.this.A(this.f8136c);
                }
            }
            DeviceInfoHolder.this.x();
        }
    }

    /* loaded from: classes2.dex */
    class d implements View.OnClickListener {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ e f8138c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ int f8139d;

        /* loaded from: classes2.dex */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                DeviceInfoHolder.this.S3.setEnabled(true);
            }
        }

        d(e eVar, int i) {
            this.f8138c = eVar;
            this.f8139d = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            DeviceInfoHolder.this.S3.setEnabled(false);
            e eVar = this.f8138c;
            if (eVar instanceof k) {
                ((k) eVar).B(false);
            }
            DeviceInfoHolder.this.S3.setSelected(!DeviceInfoHolder.this.S3.isSelected());
            DeviceInfoHolder.this.Q3.e(DeviceInfoHolder.this.S3.isSelected());
            u0.a(DeviceInfoHolder.this.f8129c, 100L);
            DeviceInfoHolder deviceInfoHolder = DeviceInfoHolder.this;
            deviceInfoHolder.z(this.f8139d, this.f8138c, deviceInfoHolder.S3.isSelected());
            DeviceInfoHolder.this.S3.postDelayed(new a(), 500L);
        }
    }

    /* loaded from: classes2.dex */
    public interface e {
        boolean a();

        void b(e eVar);

        void c(boolean z);

        void d(e eVar);

        boolean g(e eVar);

        void h();

        void i(e eVar);

        void j(e eVar);

        void l(int i, e eVar, boolean z);
    }

    public DeviceInfoHolder(Context context, View view, Animation animation) {
        this(context, view, animation, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A(e eVar) {
        e eVar2 = this.f8131f;
        if (eVar2 != null) {
            eVar2.d(eVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B(e eVar) {
        e eVar2 = this.f8131f;
        if (eVar2 != null) {
            eVar2.b(eVar);
        }
    }

    private void C() {
        E();
        this.P3.setCompoundDrawablesRelativeWithIntrinsicBounds(this.f8129c.getResources().getDrawable(R.drawable.selector_home_long_click_off), (Drawable) null, (Drawable) null, (Drawable) null);
        this.z.clearAnimation();
        this.z.setVisibility(4);
        this.Q3.setCardElevation(0.0f);
        this.Q3.setCardBackgroundColor(this.f8129c.getResources().getColor(R.color.color_F9F9F9));
        this.R3.setCardBackgroundColor(o());
        this.q.setTextColor(this.f8129c.getResources().getColor(R.color.color_home_offline));
        this.x.setTextColor(this.f8129c.getResources().getColor(R.color.color_home_offline));
        this.p2.setVisibility(t() ? 8 : 0);
        this.S3.setVisibility(4);
        this.p2.setText(this.f8129c.getResources().getString(R.string.act_locked));
    }

    private void D() {
        this.P3.setCompoundDrawablesRelativeWithIntrinsicBounds(this.f8129c.getResources().getDrawable(R.drawable.selector_home_long_click_off), (Drawable) null, (Drawable) null, (Drawable) null);
        this.Q3.setCardBackgroundColor(this.f8129c.getResources().getColor(R.color.white));
        this.q.setTextColor(this.f8129c.getResources().getColor(R.color.color_333333));
        this.x.setTextColor(this.f8129c.getResources().getColor(R.color.color_home_location_off));
        this.S3.setVisibility(4);
    }

    private void E() {
        this.p3.setVisibility(8);
        this.p0.setVisibility(8);
        this.L3.setVisibility(8);
        this.H3.setVisibility(8);
        this.I3.setVisibility(8);
        this.N3.setVisibility(8);
        this.K3.setVisibility(8);
        this.J3.setVisibility(8);
    }

    private void F() {
        E();
        this.S3.setVisibility(4);
        this.p2.setVisibility(8);
        this.Q3.setCardElevation(j.a(this.f8129c, 2.0f));
        if (t()) {
            this.z.setVisibility(4);
            this.z.clearAnimation();
        } else {
            this.z.setVisibility(0);
            if (this.z.getAnimation() == null) {
                this.z.startAnimation(this.f8130d);
            }
        }
        this.P3.setCompoundDrawablesRelativeWithIntrinsicBounds(this.f8129c.getResources().getDrawable(R.drawable.selector_home_long_click_off), (Drawable) null, (Drawable) null, (Drawable) null);
        this.Q3.setCardBackgroundColor(this.f8129c.getResources().getColor(R.color.white));
        this.R3.setCardBackgroundColor(o());
        this.q.setTextColor(this.f8129c.getResources().getColor(R.color.color_333333));
        this.x.setTextColor(this.f8129c.getResources().getColor(R.color.color_home_location_off));
    }

    private void G() {
        E();
        this.P3.setCompoundDrawablesRelativeWithIntrinsicBounds(this.f8129c.getResources().getDrawable(R.drawable.selector_home_long_click_off), (Drawable) null, (Drawable) null, (Drawable) null);
        this.z.clearAnimation();
        this.z.setVisibility(4);
        this.Q3.setCardElevation(0.0f);
        this.Q3.setCardBackgroundColor(this.f8129c.getResources().getColor(R.color.color_F9F9F9));
        this.R3.setCardBackgroundColor(o());
        this.q.setTextColor(this.f8129c.getResources().getColor(R.color.color_home_offline));
        this.x.setTextColor(this.f8129c.getResources().getColor(R.color.color_home_offline));
        this.p2.setVisibility(t() ? 8 : 0);
        this.S3.setVisibility(4);
    }

    private void H() {
        E();
        if (w.c()) {
            this.S3.setImageResource(R.drawable.device_on_check_jp_selector);
        } else {
            this.S3.setImageResource(R.drawable.device_on_check_selector);
        }
        this.S3.setVisibility(t() ? 4 : 0);
        this.z.clearAnimation();
        this.z.setVisibility(4);
        this.p2.setVisibility(4);
        this.Q3.setCardElevation(j.a(this.f8129c, 2.0f));
    }

    private void I(k kVar) {
        BaseALIoTDevice g;
        if (kVar != null && (g = kVar.g()) != null) {
            int i = 0;
            this.p1.setVisibility((!kVar.t() || !this.V3) ? 8 : 0);
            this.q.setText(l.e(this.f8129c, g.getDeviceType(), g.getDeviceName(), g.getDeviceModel()));
            l.o(this.f8129c, g, this.y);
            this.x.setText(l.b(this.f8129c, g));
            this.U3.setImageResource(R.mipmap.home_item_share_device);
            ImageView imageView = this.U3;
            if (!g.isUserRoleTypeDevice()) {
                i = 4;
            }
            imageView.setVisibility(i);
            this.p2.setText(R.string.home_item_offline);
            this.R3.setVisibility(8);
            M(g);
        }
    }

    private void J(GroupBean groupBean) {
        this.p0.setVisibility(8);
        this.P3.setVisibility(t() ? 0 : 4);
        if (groupBean.isOnline() || groupBean.isPartOffline()) {
            H();
            if (groupBean.isDeviceOn()) {
                if (groupBean.isBulbGroup()) {
                    this.p3.setText(String.format("%d%%", Integer.valueOf(groupBean.getBrightness())));
                    this.p3.setVisibility(0);
                    if (o.f(groupBean.getGroupInfo())) {
                        this.L3.setVisibility(0);
                        this.L3.setInnerCircleColor(g.e(groupBean.getGroupInfo()));
                    } else {
                        this.L3.setVisibility(8);
                    }
                }
                P();
                return;
            }
            O();
        } else if (groupBean.isOffLine() || groupBean.isEmpty()) {
            G();
        } else {
            F();
        }
    }

    private void K(g gVar) {
        GroupBean h;
        if (gVar != null && (h = gVar.h()) != null) {
            this.p1.setVisibility(8);
            this.q.setText(o.d(this.f8129c, h.getName()));
            o.h(h, this.y);
            this.x.setText(o.b(h));
            this.U3.setImageResource(R.mipmap.part_offline);
            this.U3.setVisibility(h.isPartOffline() ? 0 : 4);
            this.p2.setText(h.isEmpty() ? R.string.no_devices : R.string.home_item_offline);
            this.R3.setVisibility(0);
            J(h);
        }
    }

    private void L() {
        this.P3.setCompoundDrawablesRelativeWithIntrinsicBounds(this.f8129c.getResources().getDrawable(R.drawable.selector_home_long_click_off), (Drawable) null, (Drawable) null, (Drawable) null);
        this.Q3.setCardBackgroundColor(this.f8129c.getResources().getColor(R.color.white));
        this.q.setTextColor(this.f8129c.getResources().getColor(R.color.color_333333));
        this.x.setTextColor(this.f8129c.getResources().getColor(R.color.color_home_location_off));
    }

    @SuppressLint({"DefaultLocale"})
    private void M(BaseALIoTDevice baseALIoTDevice) {
        int i = 0;
        this.M3.setVisibility(0);
        this.P3.setVisibility(t() ? 0 : 4);
        u(baseALIoTDevice);
        if ((baseALIoTDevice instanceof ALCameraDevice) && ((ALCameraDevice) baseALIoTDevice).isCameraLocked()) {
            C();
        } else if (baseALIoTDevice.isOnline()) {
            H();
            S(baseALIoTDevice);
            R(baseALIoTDevice);
            if (baseALIoTDevice.isCamera()) {
                D();
            } else if (baseALIoTDevice.isHub() || baseALIoTDevice.isSensor() || baseALIoTDevice.isEnergy()) {
                L();
                if (baseALIoTDevice.isHub()) {
                    if (baseALIoTDevice.getGuardOn()) {
                        this.S3.setImageResource(p.b(baseALIoTDevice.getGuardMode()));
                    } else {
                        this.S3.setVisibility(4);
                    }
                } else if (baseALIoTDevice.isSensor()) {
                    this.S3.setVisibility(4);
                } else if (com.tplink.iot.g.d.a.b.k(baseALIoTDevice)) {
                    RelativeLayout relativeLayout = this.M3;
                    if (!t()) {
                        i = 8;
                    }
                    relativeLayout.setVisibility(i);
                    this.S3.setVisibility(4);
                    Q(baseALIoTDevice);
                }
            } else {
                boolean isDeviceOn = baseALIoTDevice.isDeviceOn();
                int i2 = R.mipmap.music_rhythm_card_on;
                if (isDeviceOn) {
                    if (baseALIoTDevice.isBulb()) {
                        this.p3.setText(String.format("%d%%", Integer.valueOf(baseALIoTDevice.getBrightness())));
                        if (baseALIoTDevice.isLightStrip() && (baseALIoTDevice.getLocalIoTDevice() instanceof IoTLightStripDevice)) {
                            IoTLightStripDevice ioTLightStripDevice = (IoTLightStripDevice) baseALIoTDevice.getLocalIoTDevice();
                            this.N3.setVisibility(0);
                            if (ioTLightStripDevice.isLightingEffectEnabled()) {
                                this.N3.h(1);
                                this.p3.setVisibility(0);
                                this.p3.setText(String.format("%d%%", Integer.valueOf(ioTLightStripDevice.getLightingEffectBrightness())));
                                this.O3.setVisibility(4);
                            } else if (ioTLightStripDevice.isMusicRhythmEnable() == null || !ioTLightStripDevice.isMusicRhythmEnable().booleanValue() || ioTLightStripDevice.isV1MusicRhythmEnableComponent()) {
                                this.N3.setColor(com.tplink.iot.g.b.c.c.m(ioTLightStripDevice));
                                this.N3.h(0);
                                this.p3.setVisibility(0);
                                this.O3.setVisibility(4);
                            } else {
                                this.N3.setVisibility(8);
                                this.p3.setVisibility(8);
                                this.O3.setVisibility(0);
                                ImageView imageView = this.O3;
                                if (!ioTLightStripDevice.isDeviceOn()) {
                                    i2 = R.mipmap.music_rhythm_card_off;
                                }
                                imageView.setImageResource(i2);
                            }
                        } else if (!com.tplink.iot.Utils.w0.a.e(baseALIoTDevice.getDeviceIdMD5())) {
                            this.p3.setVisibility(0);
                        } else if (baseALIoTDevice.isDynamicLightEffectEnable()) {
                            this.p0.setVisibility(0);
                            this.p0.setImageResource(com.tplink.iot.Utils.z0.i.f(baseALIoTDevice.getDynamicLightEffectId()));
                        } else {
                            this.p3.setVisibility(0);
                            this.L3.setVisibility(0);
                            this.L3.setInnerCircleColor(com.tplink.iot.Utils.z0.i.c(baseALIoTDevice.getColorTemp(), baseALIoTDevice.getHue(), baseALIoTDevice.getSaturation()));
                        }
                    }
                    P();
                    return;
                }
                if (baseALIoTDevice.isLightStrip() && (baseALIoTDevice.getLocalIoTDevice() instanceof IoTLightStripDevice)) {
                    IoTLightStripDevice ioTLightStripDevice2 = (IoTLightStripDevice) baseALIoTDevice.getLocalIoTDevice();
                    if (ioTLightStripDevice2.isMusicRhythmEnable() == null || !ioTLightStripDevice2.isMusicRhythmEnable().booleanValue() || ioTLightStripDevice2.isV1MusicRhythmEnableComponent()) {
                        this.O3.setVisibility(4);
                    } else {
                        this.N3.setVisibility(8);
                        this.p3.setVisibility(8);
                        this.O3.setVisibility(0);
                        ImageView imageView2 = this.O3;
                        if (!ioTLightStripDevice2.isDeviceOn()) {
                            i2 = R.mipmap.music_rhythm_card_off;
                        }
                        imageView2.setImageResource(i2);
                    }
                }
                O();
            }
        } else if (baseALIoTDevice.isDeviceOffLine()) {
            G();
        } else {
            F();
        }
    }

    private void N(boolean z) {
        e eVar = this.f8131f;
        if (eVar != null) {
            eVar.c(z);
        }
    }

    private void O() {
        this.P3.setCompoundDrawablesRelativeWithIntrinsicBounds(this.f8129c.getResources().getDrawable(R.drawable.selector_home_long_click_off), (Drawable) null, (Drawable) null, (Drawable) null);
        this.Q3.setCardBackgroundColor(this.f8129c.getResources().getColor(R.color.white));
        this.R3.setCardBackgroundColor(o());
        this.q.setTextColor(this.f8129c.getResources().getColor(R.color.color_333333));
        this.x.setTextColor(this.f8129c.getResources().getColor(R.color.color_home_location_off));
        this.S3.setSelected(false);
    }

    private void P() {
        this.P3.setCompoundDrawablesRelativeWithIntrinsicBounds(this.f8129c.getResources().getDrawable(R.drawable.selector_home_long_click_on), (Drawable) null, (Drawable) null, (Drawable) null);
        this.Q3.setCardBackgroundColor(this.f8129c.getResources().getColor(R.color.common_iot_main_blue));
        this.R3.setCardBackgroundColor(this.f8129c.getResources().getColor(R.color.color_19BFF0));
        this.q.setTextColor(this.f8129c.getResources().getColor(R.color.white));
        this.x.setTextColor(this.f8129c.getResources().getColor(R.color.color_home_location_on));
        this.S3.setSelected(true);
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x013b  */
    @android.annotation.SuppressLint({"SetTextI18n"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void Q(com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice<?> r9) {
        /*
            Method dump skipped, instructions count: 543
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tplink.iot.model.home.DeviceInfoHolder.Q(com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice):void");
    }

    private void R(@NonNull BaseALIoTDevice baseALIoTDevice) {
        if (baseALIoTDevice.isSupportIoTComponent(EnumIoTComponent.BATTERY_DETECT) && !com.tplink.iot.g.d.a.b.k(baseALIoTDevice) && q(baseALIoTDevice)) {
            boolean isSwitch = baseALIoTDevice.isSwitch();
            int i = R.drawable.ic_trv_power;
            if (isSwitch) {
                this.I3.setVisibility(0);
                Resources resources = this.f8129c.getResources();
                if (baseALIoTDevice.isDeviceOn()) {
                    i = R.drawable.ic_trv_power_white;
                }
                this.I3.setCompoundDrawablesRelativeWithIntrinsicBounds(ResourcesCompat.getDrawable(resources, i, null), (Drawable) null, (Drawable) null, (Drawable) null);
                this.I3.setTextColor(r(baseALIoTDevice));
            } else if (!baseALIoTDevice.isSensor()) {
            } else {
                if (this.H3.getVisibility() == 0) {
                    this.H3.setCompoundDrawablesRelativeWithIntrinsicBounds(ResourcesCompat.getDrawable(this.f8129c.getResources(), R.drawable.ic_trv_power, null), (Drawable) null, (Drawable) null, (Drawable) null);
                    return;
                }
                this.I3.setVisibility(0);
            }
        }
    }

    private void S(BaseALIoTDevice<?> baseALIoTDevice) {
        TriggerLog p;
        boolean isSupportIoTComponent = baseALIoTDevice.isSupportIoTComponent(EnumIoTComponent.TRIGGER_LOG);
        boolean isSwitch = baseALIoTDevice.isSwitch();
        if (isSupportIoTComponent && !isSwitch && (p = p(baseALIoTDevice)) != null && p.getTimestamp() > 0) {
            int i = 0;
            this.H3.setVisibility(0);
            this.H3.setText(r.b(this.f8129c, baseALIoTDevice, p));
            this.H3.setTextColor(this.f8129c.getResources().getColor(R.color.color_333333));
            if (baseALIoTDevice.isSensor()) {
                RelativeLayout relativeLayout = this.M3;
                if (!t()) {
                    i = 8;
                }
                relativeLayout.setVisibility(i);
            }
        }
    }

    private boolean n(e eVar) {
        e eVar2 = this.f8131f;
        if (eVar2 != null) {
            return eVar2.g(eVar);
        }
        return false;
    }

    private int o() {
        return this.f8129c.getResources().getColor(R.color.color_d9d9d9);
    }

    @Nullable
    private TriggerLog p(@NonNull BaseALIoTDevice<?> baseALIoTDevice) {
        if (baseALIoTDevice.isSwitch()) {
            return ((SwitchRepository) com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.d(baseALIoTDevice.getDeviceIdMD5(), SwitchRepository.class)).k1().getValue();
        }
        return ((SensorRepository) com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.d(baseALIoTDevice.getDeviceIdMD5(), SensorRepository.class)).j4();
    }

    private boolean q(@NonNull BaseALIoTDevice baseALIoTDevice) {
        if (baseALIoTDevice.isSwitch()) {
            return ((SwitchRepository) com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.d(baseALIoTDevice.getDeviceIdMD5(), SwitchRepository.class)).o4();
        }
        return ((SensorRepository) com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.d(baseALIoTDevice.getDeviceIdMD5(), SensorRepository.class)).k4();
    }

    private int r(BaseALIoTDevice baseALIoTDevice) {
        return baseALIoTDevice.isDeviceOn() ? this.f8129c.getResources().getColor(R.color.white) : this.f8129c.getResources().getColor(R.color.color_333333);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean t() {
        e eVar = this.f8131f;
        if (eVar != null) {
            return eVar.a();
        }
        return false;
    }

    private void u(BaseALIoTDevice baseALIoTDevice) {
        EnumIoTDeviceState lastDeviceStatus = baseALIoTDevice.getLastDeviceStatus();
        EnumIoTDeviceState deviceState = baseALIoTDevice.getDeviceState();
        long loadingStartTimestamp = baseALIoTDevice.getLoadingStartTimestamp();
        boolean isOnline = baseALIoTDevice.isOnline();
        EnumIoTDeviceState enumIoTDeviceState = EnumIoTDeviceState.LOADING;
        if (deviceState != enumIoTDeviceState) {
            if (lastDeviceStatus == enumIoTDeviceState && loadingStartTimestamp > 0) {
                com.tplink.iot.Utils.x0.j.a(baseALIoTDevice.getDeviceIdMD5(), System.currentTimeMillis() - loadingStartTimestamp, isOnline);
                baseALIoTDevice.setLoadingStartTimestamp(0L);
            }
            if (deviceState != lastDeviceStatus && lastDeviceStatus != enumIoTDeviceState) {
                com.tplink.iot.Utils.x0.j.b(baseALIoTDevice.getDeviceIdMD5(), isOnline);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(e eVar) {
        e eVar2 = this.f8131f;
        if (eVar2 != null) {
            eVar2.i(eVar);
        }
    }

    private void w(e eVar) {
        e eVar2 = this.f8131f;
        if (eVar2 != null) {
            eVar2.j(eVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        e eVar = this.f8131f;
        if (eVar != null) {
            eVar.h();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean y(e eVar) {
        if (t()) {
            return true;
        }
        B(eVar);
        w(eVar);
        N(true);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(int i, e eVar, boolean z) {
        e eVar2 = this.f8131f;
        if (eVar2 != null) {
            eVar2.l(i, eVar, z);
        }
    }

    @Override // com.tplink.iot.adapter.home.i
    public void a() {
        this.T3.setScaleX(1.0f);
        this.T3.setScaleY(1.0f);
    }

    @Override // com.tplink.iot.adapter.home.i
    public void b() {
        this.T3.setScaleX(1.1f);
        this.T3.setScaleY(1.1f);
    }

    public void s(e eVar, int i, e eVar2) {
        this.f8131f = eVar2;
        if (eVar instanceof k) {
            k kVar = (k) eVar;
            I(kVar);
            if (kVar.s()) {
                this.S3.setEnabled(false);
            } else {
                this.S3.setEnabled(true);
            }
        } else if (eVar instanceof g) {
            K((g) eVar);
        } else {
            return;
        }
        this.T3.setOnLongClickListener(new a(eVar));
        this.T3.setOnClickListener(new b(eVar));
        this.P3.setOnCheckedChangeListener(new c(eVar));
        this.P3.setChecked(n(eVar));
        this.S3.setOnClickListener(new d(eVar, i));
    }

    public DeviceInfoHolder(Context context, View view, Animation animation, boolean z) {
        super(view);
        this.f8129c = context;
        this.T3 = view;
        this.f8130d = animation;
        this.V3 = z;
        this.q = (TextView) view.findViewById(R.id.tv_device_name);
        this.x = (TextView) view.findViewById(R.id.tv_home_location);
        this.y = (ImageView) view.findViewById(R.id.iv_home_plug_icon);
        this.p0 = (ImageView) view.findViewById(R.id.iv_light_effect);
        this.p2 = (TextView) view.findViewById(R.id.iv_home_status);
        this.p3 = (TextView) view.findViewById(R.id.iv_bulb_brightness);
        this.L3 = (ColorPointHomeView) view.findViewById(R.id.color_point_view);
        this.H3 = (TextView) view.findViewById(R.id.tv_detected_log);
        this.I3 = (TextView) view.findViewById(R.id.tv_low_battery);
        this.J3 = (TextView) view.findViewById(R.id.tv_trv_temp);
        this.K3 = (TextView) view.findViewById(R.id.tv_trv_state);
        this.M3 = (RelativeLayout) view.findViewById(R.id.rl_device_state);
        this.N3 = (LightingEffectPointView) view.findViewById(R.id.lighting_effect_point_view);
        this.O3 = (ImageView) view.findViewById(R.id.music_rhythm_point_view);
        this.P3 = (TPCheckboxCompat) view.findViewById(R.id.cb_home_item);
        this.Q3 = (RippleCardView) view.findViewById(R.id.cv_home_item_card);
        this.R3 = (CardView) view.findViewById(R.id.group_bg);
        this.S3 = (ImageView) view.findViewById(R.id.home_item_switch_img);
        this.p1 = (TextView) view.findViewById(R.id.iv_new_device);
        this.z = (ImageView) view.findViewById(R.id.iv_device_loading);
        this.U3 = (ImageView) view.findViewById(R.id.iv_device_show_icon);
        if (w.c()) {
            this.S3.setImageResource(R.drawable.device_on_check_jp_selector);
        } else {
            this.S3.setImageResource(R.drawable.device_on_check_selector);
        }
        this.N3.setEffectImageId(R.mipmap.icon_lighting_effect_white);
    }
}
