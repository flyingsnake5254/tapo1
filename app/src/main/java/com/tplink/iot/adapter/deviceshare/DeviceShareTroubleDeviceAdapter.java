package com.tplink.iot.adapter.deviceshare;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.R;
import com.tplink.iot.Utils.z0.l;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import java.util.List;

/* loaded from: classes2.dex */
public class DeviceShareTroubleDeviceAdapter extends RecyclerView.Adapter<a> {
    private Context a;

    /* renamed from: b  reason: collision with root package name */
    private List<BaseALIoTDevice> f5489b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a extends RecyclerView.ViewHolder {
        TextView a;

        public a(View view) {
            super(view);
            this.a = (TextView) view.findViewById(R.id.item_content);
        }
    }

    public DeviceShareTroubleDeviceAdapter(Context context, List<BaseALIoTDevice> list) {
        this.a = context;
        this.f5489b = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<BaseALIoTDevice> list = this.f5489b;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    /* renamed from: m */
    public void onBindViewHolder(@NonNull a aVar, int i) {
        BaseALIoTDevice baseALIoTDevice = this.f5489b.get(i);
        aVar.a.setText(l.e(this.a, baseALIoTDevice.getDeviceType(), baseALIoTDevice.getDeviceName(), baseALIoTDevice.getDeviceModel()));
    }

    @NonNull
    /* renamed from: n */
    public a onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_point_text, viewGroup, false));
    }
}
