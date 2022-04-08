package com.tplink.iot.view.ipcamera.onboardingv2;

import android.app.Application;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.R;
import com.tplink.iot.databinding.ViewFoundedDeviceItemBinding;
import com.tplink.iot.view.ipcamera.base.c;
import com.tplink.libtpnetwork.TDPNetwork.bean.TDPCameraDevice;
import com.tplink.libtpnetwork.cameranetwork.bean.DeviceModel;
import java.util.List;

/* loaded from: classes2.dex */
public class FoundedDeviceListAdapter extends RecyclerView.Adapter {
    private List<TDPCameraDevice> a;

    /* renamed from: b  reason: collision with root package name */
    private int f8802b;

    /* renamed from: c  reason: collision with root package name */
    private Application f8803c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    private final b f8804d;

    /* loaded from: classes2.dex */
    static class a extends RecyclerView.ViewHolder {
        private ViewFoundedDeviceItemBinding a;

        public a(View view) {
            super(view);
        }

        void d(ViewFoundedDeviceItemBinding viewFoundedDeviceItemBinding) {
            this.a = viewFoundedDeviceItemBinding;
        }
    }

    /* loaded from: classes2.dex */
    public interface b {
        void a(TDPCameraDevice tDPCameraDevice, int i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m */
    public /* synthetic */ void n(TDPCameraDevice tDPCameraDevice, int i, View view) {
        this.f8804d.a(tDPCameraDevice, i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.a.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {
        a aVar = (a) viewHolder;
        final TDPCameraDevice tDPCameraDevice = this.a.get(i);
        aVar.a.h(new View.OnClickListener() { // from class: com.tplink.iot.view.ipcamera.onboardingv2.x1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FoundedDeviceListAdapter.this.n(tDPCameraDevice, i, view);
            }
        });
        if (this.f8802b == i) {
            aVar.a.f7350c.setChecked(true);
        } else {
            aVar.a.f7350c.setChecked(false);
        }
        aVar.a.f7352f.setText(String.format("%s%s", this.f8803c.getText(R.string.onboarding_new_ipc_mac_hint), tDPCameraDevice.getMac()));
        aVar.a.q.setText(tDPCameraDevice.getDeviceName());
        aVar.a.f7351d.setImageResource(c.f(DeviceModel.fromValue(tDPCameraDevice.getDeviceModel())));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        ViewFoundedDeviceItemBinding viewFoundedDeviceItemBinding = (ViewFoundedDeviceItemBinding) DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()), R.layout.view_founded_device_item, viewGroup, false);
        a aVar = new a(viewFoundedDeviceItemBinding.getRoot());
        aVar.d(viewFoundedDeviceItemBinding);
        return aVar;
    }
}
