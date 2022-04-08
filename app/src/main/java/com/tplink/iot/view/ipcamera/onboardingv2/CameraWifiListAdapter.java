package com.tplink.iot.view.ipcamera.onboardingv2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.R;
import com.tplink.iot.databinding.ItemCameraSsidLayoutBinding;
import com.tplink.iot.view.quicksetup.base.c;
import com.tplink.libtpnetwork.cameranetwork.model.Wifi;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class CameraWifiListAdapter extends RecyclerView.Adapter {
    private List<Wifi> a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    private boolean f8792b = false;

    /* renamed from: c  reason: collision with root package name */
    private final a f8793c;

    /* loaded from: classes2.dex */
    public interface a {
        void a(Wifi wifi);
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

    public CameraWifiListAdapter(a aVar) {
        this.f8793c = aVar;
    }

    private int m(int i) {
        return c.j0(i);
    }

    private boolean n(int i) {
        List<Wifi> list = this.a;
        return list == null || i >= list.size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o */
    public /* synthetic */ void p(int i, View view) {
        this.f8793c.a(this.a.get(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: q */
    public /* synthetic */ void r(View view) {
        a aVar = this.f8793c;
        if (aVar != null) {
            aVar.a(null);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<Wifi> list = this.a;
        if (list == null) {
            return 1;
        }
        return 1 + list.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        return n(i) ? 1 : 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {
        boolean z;
        b bVar = (b) viewHolder;
        float f2 = 1.0f;
        if (!n(i)) {
            Wifi wifi = this.a.get(i);
            bVar.f(wifi.getSsid());
            int i2 = 0;
            if (!this.f8792b) {
                z = !wifi.isWEP() && !wifi.isWPA3();
            } else {
                z = !wifi.isWEP();
            }
            bVar.a.q.setEnabled(z);
            RelativeLayout relativeLayout = bVar.a.q;
            if (!z) {
                f2 = 0.3f;
            }
            relativeLayout.setAlpha(f2);
            bVar.a.f7159c.setImageResource(z ? m(wifi.getRssi()) : wifi.isWEP() ? R.mipmap.wep : R.mipmap.icon_wpa3_disabled);
            ImageView imageView = bVar.a.f7160d;
            if (wifi.getAuth() == 0 || wifi.getAuth() == 1) {
                i2 = 4;
            }
            imageView.setVisibility(i2);
            bVar.itemView.setClickable(true);
            bVar.e(new View.OnClickListener() { // from class: com.tplink.iot.view.ipcamera.onboardingv2.e1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CameraWifiListAdapter.this.p(i, view);
                }
            });
            return;
        }
        bVar.itemView.setAlpha(1.0f);
        bVar.itemView.setClickable(true);
        bVar.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tplink.iot.view.ipcamera.onboardingv2.d1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CameraWifiListAdapter.this.r(view);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        if (i != 0) {
            return new b(from.inflate(R.layout.layout_plug_scan_ap_add_item, viewGroup, false));
        }
        ItemCameraSsidLayoutBinding itemCameraSsidLayoutBinding = (ItemCameraSsidLayoutBinding) DataBindingUtil.inflate(from, R.layout.item_camera_ssid_layout, viewGroup, false);
        b bVar = new b(itemCameraSsidLayoutBinding.getRoot());
        bVar.d(itemCameraSsidLayoutBinding);
        return bVar;
    }

    public void s(List<Wifi> list) {
        this.a = list;
    }

    public void t(boolean z) {
        this.f8792b = z;
    }
}
