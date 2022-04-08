package com.tplink.iot.view.notification;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SwitchCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.cloud.bean.push.NotificationMsgBean;
import com.tplink.iot.R;
import com.tplink.iot.Utils.x0.q;
import com.tplink.iot.base.BaseFragment;
import com.tplink.iot.viewmodel.notification.MessagePushViewModel;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.Utils.o;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class NotificationFragment extends BaseFragment {
    private View p0;
    private View p1;
    private MessagePushViewModel p2;
    private List<BaseALIoTDevice> p3 = new ArrayList();
    private SwitchCompat q;
    private SwitchCompat x;
    private SwitchCompat y;
    private View z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements CompoundButton.OnCheckedChangeListener {
        a() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            NotificationFragment.this.p2.u(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b implements Observer<List<BaseALIoTDevice>> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes2.dex */
        public class a implements CompoundButton.OnCheckedChangeListener {
            a() {
            }

            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (NotificationFragment.this.p3 != null && NotificationFragment.this.p3.size() > 0) {
                    NotificationFragment.this.p2.x(NotificationFragment.this.p3, z);
                    q.n(z, NotificationMsgBean.MsgType.NEW_FIRMWARE);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.tplink.iot.view.notification.NotificationFragment$b$b  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C0231b implements CompoundButton.OnCheckedChangeListener {
            C0231b() {
            }

            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (NotificationFragment.this.p3 != null && NotificationFragment.this.p3.size() > 0) {
                    NotificationFragment.this.p2.v(NotificationFragment.this.p3, z);
                    q.n(z, "tapoCameraSD");
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes2.dex */
        public class c implements CompoundButton.OnCheckedChangeListener {
            c() {
            }

            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                o.h0().g1(z);
                q.n(z, "tapoCameraSD");
            }
        }

        b() {
        }

        /* renamed from: a */
        public void onChanged(@Nullable List<BaseALIoTDevice> list) {
            if (list == null || list.size() <= 0) {
                NotificationFragment.this.x.setChecked(NotificationFragment.this.p2.n());
                NotificationFragment.this.x.setOnCheckedChangeListener(new c());
                return;
            }
            NotificationFragment.this.p3.clear();
            NotificationFragment.this.p3.addAll(list);
            NotificationFragment.this.x.setChecked(NotificationFragment.this.p2.n());
            NotificationFragment.this.x.setOnCheckedChangeListener(new a());
            NotificationFragment.this.y.setChecked(NotificationFragment.this.p2.m());
            NotificationFragment.this.y.setOnCheckedChangeListener(new C0231b());
            if (NotificationFragment.this.p2.k(list)) {
                NotificationFragment.this.z.setVisibility(0);
            } else {
                NotificationFragment.this.z.setVisibility(8);
            }
            if (NotificationFragment.this.p2.l(list)) {
                NotificationFragment.this.p1.setVisibility(0);
            } else {
                NotificationFragment.this.p1.setVisibility(8);
            }
        }
    }

    private void O0(View view) {
        this.q = (SwitchCompat) view.findViewById(R.id.iac_promotion_msg_switch);
        this.x = (SwitchCompat) view.findViewById(R.id.firmware_update_switch);
        this.y = (SwitchCompat) view.findViewById(R.id.switch_sd_card_status);
        this.z = view.findViewById(R.id.layout_camera_notification);
        this.p1 = view.findViewById(R.id.layout_device_triggered);
        View findViewById = view.findViewById(R.id.layout_item_device_status);
        this.p0 = findViewById;
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.tplink.iot.view.notification.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                NotificationFragment.this.Q0(view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: P0 */
    public /* synthetic */ void Q0(View view) {
        C0(DeviceTriggeredAllActivity.class);
    }

    private void R0() {
        this.q.setChecked(this.p2.o());
        this.q.setOnCheckedChangeListener(new a());
        this.p2.g().observe(this, new b());
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
        this.p2 = (MessagePushViewModel) ViewModelProviders.of(this).get(MessagePushViewModel.class);
        R0();
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_notification_setting, viewGroup, false);
        O0(inflate);
        return inflate;
    }
}
