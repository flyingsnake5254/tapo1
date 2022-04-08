package com.tplink.iot.adapter.group;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.R;
import com.tplink.iot.Utils.z0.l;
import com.tplink.iot.widget.RippleCardView;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class DeviceAdapter extends RecyclerView.Adapter {
    private Activity a;

    /* renamed from: b  reason: collision with root package name */
    private List<BaseALIoTDevice> f5635b = new ArrayList();

    /* loaded from: classes2.dex */
    private class a extends RecyclerView.ViewHolder {
        RippleCardView a;

        /* renamed from: b  reason: collision with root package name */
        TextView f5636b;

        /* renamed from: c  reason: collision with root package name */
        TextView f5637c;

        /* renamed from: d  reason: collision with root package name */
        ImageView f5638d;

        /* renamed from: e  reason: collision with root package name */
        ImageView f5639e;

        a(View view) {
            super(view);
            this.a = (RippleCardView) view.findViewById(R.id.cv_home_item_card);
            this.f5636b = (TextView) view.findViewById(R.id.tv_device_name);
            this.f5637c = (TextView) view.findViewById(R.id.tv_home_location);
            this.f5638d = (ImageView) view.findViewById(R.id.iv_home_plug_icon);
            this.f5639e = (ImageView) view.findViewById(R.id.iv_device_show_icon);
        }

        public void c(BaseALIoTDevice baseALIoTDevice, int i) {
            this.f5636b.setText(l.e(DeviceAdapter.this.a, baseALIoTDevice.getDeviceType(), baseALIoTDevice.getDeviceName(), baseALIoTDevice.getDeviceModel()));
            l.o(DeviceAdapter.this.a, baseALIoTDevice, this.f5638d);
            this.f5637c.setText(l.b(DeviceAdapter.this.a, baseALIoTDevice));
            this.f5639e.setImageResource(R.mipmap.home_item_share_device);
            this.f5639e.setVisibility(baseALIoTDevice.isUserRoleTypeDevice() ? 0 : 4);
            this.a.setCardElevation(0.0f);
            this.a.setCardBackgroundColor(DeviceAdapter.this.a.getResources().getColor(R.color.color_F9F9F9));
            this.f5636b.setTextColor(DeviceAdapter.this.a.getResources().getColor(R.color.color_home_offline));
            this.f5637c.setTextColor(DeviceAdapter.this.a.getResources().getColor(R.color.color_home_offline));
            this.f5636b.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, DeviceAdapter.this.a.getResources().getDrawable(R.mipmap.gray_arrow_right), (Drawable) null);
        }
    }

    public DeviceAdapter(Activity activity) {
        this.a = activity;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<BaseALIoTDevice> list = this.f5635b;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public void n(List<BaseALIoTDevice> list) {
        this.f5635b.clear();
        if (list != null) {
            this.f5635b.addAll(list);
        }
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        ((a) viewHolder).c(this.f5635b.get(i), i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new a(LayoutInflater.from(this.a).inflate(R.layout.item_device_info_layout, viewGroup, false));
    }
}
