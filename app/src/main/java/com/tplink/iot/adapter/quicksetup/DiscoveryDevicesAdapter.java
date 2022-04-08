package com.tplink.iot.adapter.quicksetup;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.R;
import com.tplink.iot.Utils.z0.l;
import com.tplink.iot.adapter.quicksetup.DiscoveryDevicesAdapter;
import com.tplink.libtpnetwork.IoTNetwork.common.ALIoTDevice;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.TDPNetwork.bean.TDPCameraDevice;
import com.tplink.libtpnetwork.TDPNetwork.bean.TDPIoTDevice;
import com.tplink.libtpnetwork.cameranetwork.bean.ALCameraDevice;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class DiscoveryDevicesAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<d> a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    private b f5878b;

    /* loaded from: classes2.dex */
    class a extends RecyclerView.ViewHolder {
        private final ImageView a;

        /* renamed from: b  reason: collision with root package name */
        private final TextView f5879b;

        /* renamed from: c  reason: collision with root package name */
        private final TextView f5880c;

        /* renamed from: d  reason: collision with root package name */
        private final ImageView f5881d;

        public a(@NonNull View view) {
            super(view);
            this.a = (ImageView) view.findViewById(R.id.iv_device_image);
            this.f5879b = (TextView) view.findViewById(R.id.tv_device_category);
            this.f5880c = (TextView) view.findViewById(R.id.tv_device_of_room);
            this.f5881d = (ImageView) view.findViewById(R.id.iv_device_select);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: d */
        public /* synthetic */ void e(d dVar, View view) {
            if (DiscoveryDevicesAdapter.this.f5878b != null) {
                DiscoveryDevicesAdapter.this.f5878b.I0(dVar.a());
            }
        }

        public void c(final d dVar) {
            BaseALIoTDevice baseALIoTDevice;
            if (dVar.a() instanceof TDPCameraDevice) {
                baseALIoTDevice = new ALCameraDevice((TDPCameraDevice) dVar.a());
            } else {
                baseALIoTDevice = new ALIoTDevice(dVar.a());
            }
            l.o(this.a.getContext(), baseALIoTDevice, this.a);
            if (dVar.a() != null) {
                this.f5879b.setText(dVar.a().getDeviceModel());
                this.f5880c.setText(String.format("%s%s", this.f5879b.getContext().getString(R.string.onboarding_new_ipc_mac_hint), dVar.a().getMac()));
            } else {
                this.f5879b.setText("");
                this.f5880c.setText("");
            }
            if (dVar.a() != null) {
                this.f5881d.setOnClickListener(new View.OnClickListener() { // from class: com.tplink.iot.adapter.quicksetup.a
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        DiscoveryDevicesAdapter.a.this.e(dVar, view);
                    }
                });
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface b {
        void I0(@NonNull TDPIoTDevice tDPIoTDevice);
    }

    /* loaded from: classes2.dex */
    class c extends RecyclerView.ViewHolder {
        private final TextView a;

        public c(@NonNull View view) {
            super(view);
            this.a = (TextView) view.findViewById(R.id.tv_title);
        }

        public void c(d dVar) {
            this.a.setText(dVar.b());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.a.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        return this.a.get(i).c();
    }

    public void n(b bVar) {
        this.f5878b = bVar;
    }

    public void o(@NonNull List<d> list) {
        this.a.clear();
        this.a.addAll(list);
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if (viewHolder instanceof c) {
            ((c) viewHolder).c(this.a.get(i));
        } else if (viewHolder instanceof a) {
            ((a) viewHolder).c(this.a.get(i));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (i == 1) {
            return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_discovery_device, viewGroup, false));
        }
        return new c(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_list_title, viewGroup, false));
    }
}
