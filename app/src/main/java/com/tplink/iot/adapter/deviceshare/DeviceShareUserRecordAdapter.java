package com.tplink.iot.adapter.deviceshare;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.R;
import com.tplink.libtpcontrols.TPCircleMaskView;
import com.tplink.libtpnetwork.TPCloudNetwork.device.TCDeviceUserInfoBean;
import java.util.List;

/* loaded from: classes2.dex */
public class DeviceShareUserRecordAdapter extends RecyclerView.Adapter {
    private Context a;

    /* renamed from: b  reason: collision with root package name */
    private List<TCDeviceUserInfoBean> f5514b;

    /* renamed from: c  reason: collision with root package name */
    private b f5515c;

    /* loaded from: classes2.dex */
    class a implements View.OnClickListener {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f5516c;

        a(int i) {
            this.f5516c = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (DeviceShareUserRecordAdapter.this.f5515c != null) {
                DeviceShareUserRecordAdapter.this.f5515c.a(view, this.f5516c);
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface b {
        void a(View view, int i);
    }

    /* loaded from: classes2.dex */
    private class c extends RecyclerView.ViewHolder {
        TextView a;

        /* renamed from: b  reason: collision with root package name */
        TextView f5518b;

        /* renamed from: c  reason: collision with root package name */
        TextView f5519c;

        /* renamed from: d  reason: collision with root package name */
        TPCircleMaskView f5520d;

        c(View view) {
            super(view);
            this.a = (TextView) view.findViewById(R.id.tv_name);
            this.f5518b = (TextView) view.findViewById(R.id.tv_location);
            this.f5519c = (TextView) view.findViewById(R.id.tv_person);
            this.f5520d = (TPCircleMaskView) view.findViewById(R.id.img_icon);
        }
    }

    public DeviceShareUserRecordAdapter(Context context, List<TCDeviceUserInfoBean> list) {
        this.a = context;
        this.f5514b = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<TCDeviceUserInfoBean> list = this.f5514b;
        if (list == null || list.isEmpty()) {
            return 0;
        }
        return this.f5514b.size();
    }

    public void n(b bVar) {
        this.f5515c = bVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        c cVar = (c) viewHolder;
        TCDeviceUserInfoBean tCDeviceUserInfoBean = this.f5514b.get(i);
        cVar.f5520d.g(tCDeviceUserInfoBean.getAvatarUrl(), R.mipmap.default_profile);
        cVar.a.setText(com.tplink.iot.view.deviceshare.a.c(tCDeviceUserInfoBean));
        cVar.f5518b.setText(tCDeviceUserInfoBean.getCloudUserName());
        cVar.itemView.setOnClickListener(new a(i));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new c(LayoutInflater.from(this.a).inflate(R.layout.layout_device_share_user_item, viewGroup, false));
    }
}
