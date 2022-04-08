package com.tplink.iot.adapter.smart;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.c;
import com.bumptech.glide.load.engine.j;
import com.tplink.iot.R;
import com.tplink.iot.Utils.c0;
import com.tplink.iot.Utils.o0;
import com.tplink.iot.Utils.z0.l;
import com.tplink.iot.adapter.smart.SmartTriggerAdapter;
import com.tplink.iot.cloud.bean.smart.common.SmartScheduleSetting;
import com.tplink.iot.cloud.bean.smart.common.SmartThingStateReported;
import com.tplink.iot.cloud.bean.smart.common.SmartThingTrigger;
import com.tplink.iot.cloud.bean.smart.common.SmartTrigger;
import com.tplink.iot.g.d.a.b;
import com.tplink.iot.model.smart.g;
import com.tplink.iot.view.smart.a.f;
import com.tplink.iot.viewmodel.smart.ActionSetupViewModel;
import com.tplink.libtpmediastatistics.SSLClient;
import com.tplink.libtpnetwork.IoTNetwork.bean.thingmodel.ThingModelDefine;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.IoTNetwork.repository.SmartRepository;
import com.tplink.libtpnetwork.enumerate.EnumRotateDirection;
import io.netty.util.internal.StringUtil;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class SmartTriggerAdapter extends RecyclerView.Adapter {

    /* renamed from: b  reason: collision with root package name */
    private FragmentActivity f6009b;

    /* renamed from: c  reason: collision with root package name */
    private ActionSetupViewModel f6010c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f6011d;

    /* renamed from: f  reason: collision with root package name */
    private a f6013f;
    private List<g> a = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    private boolean f6012e = false;

    /* loaded from: classes2.dex */
    public class TriggerHolder extends RecyclerView.ViewHolder {
        private ImageView a;

        /* renamed from: b  reason: collision with root package name */
        private ImageView f6014b;

        /* renamed from: c  reason: collision with root package name */
        private TextView f6015c;

        /* renamed from: d  reason: collision with root package name */
        private LinearLayout f6016d;

        /* renamed from: e  reason: collision with root package name */
        private TextView f6017e;

        /* renamed from: f  reason: collision with root package name */
        private TextView f6018f;
        private TextView g;
        private View h;

        TriggerHolder(View view) {
            super(view);
            this.a = (ImageView) view.findViewById(R.id.iv_item_trigger_icon);
            this.f6014b = (ImageView) view.findViewById(R.id.iv_item_right_icon);
            this.f6015c = (TextView) view.findViewById(R.id.item_with_one_tap);
            this.f6016d = (LinearLayout) view.findViewById(R.id.ll_item_text);
            this.f6017e = (TextView) view.findViewById(R.id.item_title_hint);
            this.f6018f = (TextView) view.findViewById(R.id.item_time_and_offset);
            this.g = (TextView) view.findViewById(R.id.item_time_schedule);
            this.h = view.findViewById(R.id.bottom_divider);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: d */
        public /* synthetic */ void e(g gVar, View view) {
            if (SmartTriggerAdapter.this.f6013f != null) {
                SmartTriggerAdapter.this.f6013f.o(gVar);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: f */
        public /* synthetic */ void g(g gVar, View view) {
            if (SmartTriggerAdapter.this.f6013f != null) {
                SmartTriggerAdapter.this.f6013f.I(gVar);
            }
        }

        public void c(final g gVar, int i) {
            String str;
            this.itemView.setOnClickListener(null);
            int i2 = 8;
            if (SmartTriggerAdapter.this.f6012e) {
                this.f6015c.setVisibility(0);
                this.f6016d.setVisibility(8);
                str = SmartRepository.i[0];
            } else {
                this.f6015c.setVisibility(8);
                this.f6016d.setVisibility(0);
                if (gVar.a() == 0) {
                    this.g.setVisibility(0);
                    this.f6017e.setText(R.string.smart_action_trigger_time);
                    if (gVar.b() != null) {
                        this.f6018f.setText(SmartTriggerAdapter.this.y(gVar.b()));
                        this.g.setText(SmartTriggerAdapter.this.x(gVar.b()));
                    }
                    str = SmartRepository.h[0];
                } else {
                    if (gVar.a() == 1) {
                        this.g.setVisibility(8);
                        this.f6017e.setText(R.string.common_unknown_device);
                        if (gVar.d() != null) {
                            String nickname = gVar.d().getNickname();
                            if (!TextUtils.isEmpty(nickname)) {
                                this.f6017e.setText(nickname);
                            }
                            BaseALIoTDevice l = SmartTriggerAdapter.this.f6010c.l(gVar.d().getThingName());
                            if (l != null) {
                                this.f6017e.setText(l.e(SmartTriggerAdapter.this.f6009b, l.getDeviceType(), l.getDeviceName(), l.getDeviceModel()));
                            }
                            l.o(SmartTriggerAdapter.this.f6009b, l, this.a);
                            this.f6018f.setText(SmartTriggerAdapter.this.w(gVar.d(), l));
                            this.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tplink.iot.adapter.smart.p
                                @Override // android.view.View.OnClickListener
                                public final void onClick(View view) {
                                    SmartTriggerAdapter.TriggerHolder.this.e(gVar, view);
                                }
                            });
                        }
                    }
                    str = null;
                }
                this.h.setVisibility((!SmartTriggerAdapter.this.f6011d || i != SmartTriggerAdapter.this.getItemCount() - 1) ? 0 : 8);
            }
            if (str != null) {
                c.x(SmartTriggerAdapter.this.f6009b).s("file:///android_asset/smart_icons/" + str + ".png").a(new com.bumptech.glide.request.g().f(j.f1461d)).x0(this.a);
            }
            this.f6018f.setCompoundDrawablesWithIntrinsicBounds(SmartTriggerAdapter.this.z(this.f6018f.getText().toString()) ? ResourcesCompat.getDrawable(SmartTriggerAdapter.this.f6009b.getResources(), R.mipmap.smart_warning_icon, null) : null, (Drawable) null, (Drawable) null, (Drawable) null);
            ImageView imageView = this.f6014b;
            if (!SmartTriggerAdapter.this.f6011d) {
                i2 = 0;
            }
            imageView.setVisibility(i2);
            if (!SmartTriggerAdapter.this.f6011d) {
                this.f6014b.setOnClickListener(new View.OnClickListener() { // from class: com.tplink.iot.adapter.smart.o
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        SmartTriggerAdapter.TriggerHolder.this.g(gVar, view);
                    }
                });
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface a {
        void I(g gVar);

        void o(g gVar);
    }

    public SmartTriggerAdapter(FragmentActivity fragmentActivity, boolean z) {
        this.f6009b = fragmentActivity;
        this.f6011d = z;
        this.f6010c = (ActionSetupViewModel) new ViewModelProvider(fragmentActivity).get(ActionSetupViewModel.class);
    }

    @Nullable
    private String v(@Nullable SmartThingTrigger smartThingTrigger, @Nullable BaseALIoTDevice baseALIoTDevice, String str) {
        if (f.d(smartThingTrigger, baseALIoTDevice)) {
            return str;
        }
        if (this.f6010c.O()) {
            return this.f6009b.getString(R.string.smart_action_tapo_care_not_applied_to_device_hint);
        }
        return this.f6009b.getString(R.string.smart_action_tapo_care_subscription_expired_hint);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String w(@Nullable SmartThingTrigger smartThingTrigger, @Nullable BaseALIoTDevice baseALIoTDevice) {
        if (baseALIoTDevice == null || !baseALIoTDevice.isOnline()) {
            return this.f6009b.getString(R.string.tip_device_offline);
        }
        if (smartThingTrigger == null) {
            return "";
        }
        if (smartThingTrigger.getStateReported() != null) {
            SmartThingStateReported stateReported = smartThingTrigger.getStateReported();
            if (b.k(baseALIoTDevice)) {
                return f.b(stateReported);
            }
        } else if (smartThingTrigger.getEvent() != null) {
            String name = smartThingTrigger.getEvent().getName();
            name.hashCode();
            char c2 = 65535;
            switch (name.hashCode()) {
                case -1984451626:
                    if (name.equals("Motion")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case -1757823456:
                    if (name.equals("singleClick")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case -1690695697:
                    if (name.equals(ThingModelDefine.Event.EVENT_CAMERA_CAMERA_TAMPERING)) {
                        c2 = 2;
                        break;
                    }
                    break;
                case -1643834313:
                    if (name.equals("doubleClick")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case -1068318794:
                    if (name.equals("motion")) {
                        c2 = 4;
                        break;
                    }
                    break;
                case -496124649:
                    if (name.equals("PersonDetected")) {
                        c2 = 5;
                        break;
                    }
                    break;
                case -154750372:
                    if (name.equals(ThingModelDefine.Event.EVENT_CAMERA_AREA_INTRUSION_DETECTION)) {
                        c2 = 6;
                        break;
                    }
                    break;
                case -103138146:
                    if (name.equals(ThingModelDefine.Event.EVENT_CAMERA_LINE_CROSSING_DETECTION)) {
                        c2 = 7;
                        break;
                    }
                    break;
                case -56853649:
                    if (name.equals("keepOpen")) {
                        c2 = '\b';
                        break;
                    }
                    break;
                case -40300674:
                    if (name.equals("rotation")) {
                        c2 = '\t';
                        break;
                    }
                    break;
                case 3417674:
                    if (name.equals("open")) {
                        c2 = '\n';
                        break;
                    }
                    break;
                case 92895825:
                    if (name.equals("alarm")) {
                        c2 = 11;
                        break;
                    }
                    break;
                case 94756344:
                    if (name.equals("close")) {
                        c2 = '\f';
                        break;
                    }
                    break;
                case 1316937012:
                    if (name.equals(ThingModelDefine.Event.EVENT_CAMERA_BABY_CRY)) {
                        c2 = StringUtil.CARRIAGE_RETURN;
                        break;
                    }
                    break;
                case 1862401626:
                    if (name.equals(ThingModelDefine.Event.EVENT_WINDOW_OPEN)) {
                        c2 = 14;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    return this.f6009b.getString(R.string.camera_motion_title);
                case 1:
                    return this.f6009b.getString(R.string.smart_trigger_single_tap);
                case 2:
                    return this.f6009b.getString(R.string.smart_trigger_camera_camera_tampering_detected);
                case 3:
                    if (!baseALIoTDevice.isSwitch() || f.c(smartThingTrigger, baseALIoTDevice)) {
                        return this.f6009b.getString(R.string.smart_trigger_double_tap);
                    }
                    return this.f6009b.getString(R.string.smart_action_double_click_disabled);
                case 4:
                    return this.f6009b.getString(R.string.smart_trigger_motion_detected);
                case 5:
                    return v(smartThingTrigger, baseALIoTDevice, this.f6009b.getString(R.string.camera_person_detection));
                case 6:
                    return this.f6009b.getString(R.string.smart_trigger_camera_area_intrusion_detected);
                case 7:
                    return this.f6009b.getString(R.string.smart_trigger_camera_line_crossing_detected);
                case '\b':
                    return this.f6009b.getString(R.string.smart_trigger_keep_open_one_minute_v2);
                case '\t':
                    EnumRotateDirection a2 = f.a(smartThingTrigger);
                    if (a2 != null && a2 == EnumRotateDirection.CLOCKWISE) {
                        return this.f6009b.getString(R.string.smart_trigger_rotate_clockwise);
                    }
                    if (a2 != null && a2 == EnumRotateDirection.ANTICLOCKWISE) {
                        return this.f6009b.getString(R.string.smart_trigger_rotate_anticlockwise);
                    }
                    return this.f6009b.getString(R.string.smart_trigger_open);
                case '\n':
                    return this.f6009b.getString(R.string.smart_trigger_open);
                case 11:
                    return this.f6009b.getString(R.string.smart_trigger_alarm_triggered);
                case '\f':
                    return this.f6009b.getString(R.string.smart_trigger_close);
                case '\r':
                    return v(smartThingTrigger, baseALIoTDevice, this.f6009b.getString(R.string.smart_trigger_camera_baby_crying_detected));
                case 14:
                    return this.f6009b.getString(R.string.smart_trigger_open_window_detected);
            }
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String x(SmartScheduleSetting smartScheduleSetting) {
        return c0.a(this.f6009b, smartScheduleSetting.getDaysOfWeek());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String y(SmartScheduleSetting smartScheduleSetting) {
        String str;
        if (smartScheduleSetting.getMode() == 2) {
            str = this.f6009b.getResources().getString(R.string.sunset);
        } else {
            str = smartScheduleSetting.getMode() == 1 ? this.f6009b.getResources().getString(R.string.sunrise) : o0.a(this.f6009b, smartScheduleSetting.getTime().intValue());
        }
        String o = (smartScheduleSetting.getMode() == 0 || smartScheduleSetting.getOffsetMins() == null) ? "" : o0.o(this.f6009b, smartScheduleSetting.getOffsetMins().intValue());
        return str + SSLClient.WHITE_SPACE + o;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean z(@Nullable String str) {
        int[] iArr = {R.string.tip_device_offline, R.string.smart_action_double_click_disabled, R.string.smart_action_tapo_care_not_applied_to_device_hint, R.string.smart_action_tapo_care_subscription_expired_hint};
        for (int i = 0; i < 4; i++) {
            if (this.f6009b.getString(iArr[i]).equals(str)) {
                return true;
            }
        }
        return false;
    }

    public void A(SmartTrigger smartTrigger) {
        this.a.clear();
        if (smartTrigger != null) {
            this.f6012e = smartTrigger.isManual();
            List<SmartScheduleSetting> schedules = smartTrigger.getSchedules();
            List<SmartThingTrigger> things = smartTrigger.getThings();
            if (this.f6012e) {
                this.a.add(new g());
            } else {
                if (schedules != null) {
                    for (SmartScheduleSetting smartScheduleSetting : schedules) {
                        this.a.add(new g(0, smartScheduleSetting));
                    }
                }
                if (things != null) {
                    for (SmartThingTrigger smartThingTrigger : things) {
                        this.a.add(new g(1, smartThingTrigger));
                    }
                }
            }
        }
        notifyDataSetChanged();
    }

    public void B(a aVar) {
        this.f6013f = aVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<g> list = this.a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        ((TriggerHolder) viewHolder).c(this.a.get(i), i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new TriggerHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_item_smart_trigger_time_setting, viewGroup, false));
    }
}
