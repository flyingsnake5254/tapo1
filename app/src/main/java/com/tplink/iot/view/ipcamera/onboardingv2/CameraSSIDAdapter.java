package com.tplink.iot.view.ipcamera.onboardingv2;

import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.R;
import com.tplink.iot.databinding.ItemCameraSsidLayoutBinding;
import com.tplink.iot.view.quicksetup.base.c;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class CameraSSIDAdapter extends RecyclerView.Adapter {
    private List<ScanResult> a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    private final a f8789b;

    /* loaded from: classes2.dex */
    public interface a {
        void a(String str);
    }

    /* loaded from: classes2.dex */
    static class b extends RecyclerView.ViewHolder {
        private ItemCameraSsidLayoutBinding a;

        b(View view) {
            super(view);
        }

        void d(ItemCameraSsidLayoutBinding itemCameraSsidLayoutBinding) {
            this.a = itemCameraSsidLayoutBinding;
        }

        void e(View.OnClickListener onClickListener) {
            this.a.h(onClickListener);
        }

        void f(String str) {
            this.a.i(str);
        }
    }

    public CameraSSIDAdapter(a aVar) {
        this.f8789b = aVar;
    }

    private int m(int i) {
        int calculateSignalLevel = WifiManager.calculateSignalLevel(i, 100);
        if (calculateSignalLevel < 35) {
            return 1;
        }
        return calculateSignalLevel < 70 ? 2 : 3;
    }

    private int n(int i) {
        return c.j0(m(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o */
    public /* synthetic */ void p(int i, View view) {
        this.f8789b.a(this.a.get(i).SSID);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.a.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {
        b bVar = (b) viewHolder;
        ScanResult scanResult = this.a.get(i);
        bVar.f(scanResult.SSID);
        bVar.a.f7159c.setImageResource(n(scanResult.level));
        bVar.e(new View.OnClickListener() { // from class: com.tplink.iot.view.ipcamera.onboardingv2.v0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CameraSSIDAdapter.this.p(i, view);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        ItemCameraSsidLayoutBinding itemCameraSsidLayoutBinding = (ItemCameraSsidLayoutBinding) DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()), R.layout.item_camera_ssid_layout, viewGroup, false);
        b bVar = new b(itemCameraSsidLayoutBinding.getRoot());
        bVar.d(itemCameraSsidLayoutBinding);
        return bVar;
    }

    public void q(List<ScanResult> list) {
        this.a = list;
    }
}
