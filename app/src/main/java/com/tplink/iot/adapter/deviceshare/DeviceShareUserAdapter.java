package com.tplink.iot.adapter.deviceshare;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.R;
import com.tplink.iot.Utils.l0;
import com.tplink.libtpcontrols.TPCircleMaskView;
import com.tplink.libtpmediastatistics.SSLClient;
import com.tplink.libtpnetwork.TPCloudNetwork.device.TCDeviceUserInfoBean;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class DeviceShareUserAdapter extends RecyclerView.Adapter {
    private Activity a;

    /* renamed from: b  reason: collision with root package name */
    private List<TCDeviceUserInfoBean> f5491b;

    /* renamed from: c  reason: collision with root package name */
    private d f5492c;

    /* loaded from: classes2.dex */
    class a implements View.OnClickListener {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f5493c;

        a(int i) {
            this.f5493c = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (DeviceShareUserAdapter.this.f5492c != null) {
                DeviceShareUserAdapter.this.f5492c.a(view, this.f5493c);
            }
        }
    }

    /* loaded from: classes2.dex */
    class b implements View.OnLongClickListener {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f5495c;

        b(int i) {
            this.f5495c = i;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            DeviceShareUserAdapter.this.p(view, this.f5495c);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class c implements l0.d {
        final /* synthetic */ int a;

        c(int i) {
            this.a = i;
        }

        @Override // com.tplink.iot.Utils.l0.d
        public void a(View view, int i) {
            if (DeviceShareUserAdapter.this.f5492c != null) {
                DeviceShareUserAdapter.this.f5492c.b(view, this.a);
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface d {
        void a(View view, int i);

        void b(View view, int i);
    }

    /* loaded from: classes2.dex */
    private class e extends RecyclerView.ViewHolder {
        TextView a;

        /* renamed from: b  reason: collision with root package name */
        TextView f5498b;

        /* renamed from: c  reason: collision with root package name */
        TextView f5499c;

        /* renamed from: d  reason: collision with root package name */
        TPCircleMaskView f5500d;

        e(View view) {
            super(view);
            this.a = (TextView) view.findViewById(R.id.tv_name);
            this.f5498b = (TextView) view.findViewById(R.id.tv_location);
            this.f5499c = (TextView) view.findViewById(R.id.tv_person);
            this.f5500d = (TPCircleMaskView) view.findViewById(R.id.img_icon);
        }
    }

    public DeviceShareUserAdapter(Activity activity, List<TCDeviceUserInfoBean> list) {
        this.a = activity;
        this.f5491b = list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(View view, int i) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.a.getString(R.string.common_delete).toUpperCase());
        l0 l0Var = new l0(this.a, arrayList);
        l0Var.setAnimationStyle(R.style.popupAnimLeft);
        l0Var.g(this.a.getResources().getColor(R.color.color_FF2954));
        l0Var.f(new c(i));
        l0Var.i(view);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<TCDeviceUserInfoBean> list = this.f5491b;
        if (list == null || list.isEmpty()) {
            return 0;
        }
        return this.f5491b.size() + 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        List<TCDeviceUserInfoBean> list = this.f5491b;
        return (list == null || list.isEmpty() || i < this.f5491b.size()) ? 1 : 2;
    }

    public void o(d dVar) {
        this.f5492c = dVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        e eVar = (e) viewHolder;
        if (getItemViewType(i) == 1) {
            TCDeviceUserInfoBean tCDeviceUserInfoBean = this.f5491b.get(i);
            eVar.f5500d.g(tCDeviceUserInfoBean.getAvatarUrl(), R.mipmap.default_profile);
            eVar.a.setText(com.tplink.iot.view.deviceshare.a.c(tCDeviceUserInfoBean));
            TextView textView = eVar.f5498b;
            textView.setText(com.tplink.iot.view.iotplug.c.a.b(tCDeviceUserInfoBean.getBindingTime()) + SSLClient.WHITE_SPACE + this.a.getString(R.string._device_share_invite));
            eVar.itemView.setOnClickListener(new a(i));
            eVar.itemView.setOnLongClickListener(new b(i));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new e(i == 1 ? LayoutInflater.from(this.a).inflate(R.layout.layout_device_share_user_item, viewGroup, false) : LayoutInflater.from(this.a).inflate(R.layout.layout_device_share_user_item_blank, viewGroup, false));
    }
}
