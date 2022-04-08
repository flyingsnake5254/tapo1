package com.tplink.iot.adapter.notification;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
import androidx.appcompat.widget.SwitchCompat;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.c;
import com.tplink.iot.R;
import com.tplink.iot.Utils.z0.l;
import com.tplink.iot.model.notification.DeviceNotificationBean;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class MotionDetectionAdapter extends RecyclerView.Adapter {
    private Context a;

    /* renamed from: b  reason: collision with root package name */
    private b f5838b;

    /* renamed from: c  reason: collision with root package name */
    private List<DeviceNotificationBean> f5839c = new ArrayList();

    /* loaded from: classes2.dex */
    class MotionDeviceViewHolder extends RecyclerView.ViewHolder {
        @BindView
        TextView mDeviceLocationTv;
        @BindView
        TextView mMotionDeviceNameTv;
        @BindView
        SwitchCompat mMotionSwitch;

        public MotionDeviceViewHolder(View view) {
            super(view);
            ButterKnife.b(this, view);
        }
    }

    /* loaded from: classes2.dex */
    public class MotionDeviceViewHolder_ViewBinding implements Unbinder {

        /* renamed from: b  reason: collision with root package name */
        private MotionDeviceViewHolder f5840b;

        @UiThread
        public MotionDeviceViewHolder_ViewBinding(MotionDeviceViewHolder motionDeviceViewHolder, View view) {
            this.f5840b = motionDeviceViewHolder;
            motionDeviceViewHolder.mMotionDeviceNameTv = (TextView) c.d(view, R.id.tv_msg_subscribe_type, "field 'mMotionDeviceNameTv'", TextView.class);
            motionDeviceViewHolder.mDeviceLocationTv = (TextView) c.d(view, R.id.tv_device_location, "field 'mDeviceLocationTv'", TextView.class);
            motionDeviceViewHolder.mMotionSwitch = (SwitchCompat) c.d(view, R.id.motion_detection_switch, "field 'mMotionSwitch'", SwitchCompat.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void a() {
            MotionDeviceViewHolder motionDeviceViewHolder = this.f5840b;
            if (motionDeviceViewHolder != null) {
                this.f5840b = null;
                motionDeviceViewHolder.mMotionDeviceNameTv = null;
                motionDeviceViewHolder.mDeviceLocationTv = null;
                motionDeviceViewHolder.mMotionSwitch = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    /* loaded from: classes2.dex */
    class a implements CompoundButton.OnCheckedChangeListener {
        final /* synthetic */ DeviceNotificationBean a;

        a(DeviceNotificationBean deviceNotificationBean) {
            this.a = deviceNotificationBean;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (compoundButton.isPressed() && MotionDetectionAdapter.this.f5838b != null && this.a.getAlIoTDevice() != null) {
                MotionDetectionAdapter.this.f5838b.u(compoundButton, this.a.getAlIoTDevice().getDeviceId(), z, this.a.getAlIoTDevice() != null && this.a.getAlIoTDevice().isCamera());
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface b {
        void u(CompoundButton compoundButton, String str, boolean z, boolean z2);
    }

    public MotionDetectionAdapter(Context context) {
        this.a = context;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<DeviceNotificationBean> list = this.f5839c;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public void n(List<DeviceNotificationBean> list) {
        if (list != null) {
            this.f5839c.clear();
            this.f5839c.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void o(b bVar) {
        this.f5838b = bVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        MotionDeviceViewHolder motionDeviceViewHolder = (MotionDeviceViewHolder) viewHolder;
        DeviceNotificationBean deviceNotificationBean = this.f5839c.get(i);
        motionDeviceViewHolder.mMotionDeviceNameTv.setText(l.c(this.a, deviceNotificationBean.getAlIoTDevice()));
        motionDeviceViewHolder.mDeviceLocationTv.setText(l.b(this.a, deviceNotificationBean.getAlIoTDevice()));
        motionDeviceViewHolder.mMotionSwitch.setChecked(deviceNotificationBean.isSubscribe());
        motionDeviceViewHolder.mMotionSwitch.setOnCheckedChangeListener(new a(deviceNotificationBean));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new MotionDeviceViewHolder(LayoutInflater.from(this.a).inflate(R.layout.item_motion_detection_device, viewGroup, false));
    }
}
