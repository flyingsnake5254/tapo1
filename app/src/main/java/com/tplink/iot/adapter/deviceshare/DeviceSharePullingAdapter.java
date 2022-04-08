package com.tplink.iot.adapter.deviceshare;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.R;
import com.tplink.iot.Utils.z0.l;
import com.tplink.iot.cloud.bean.share.result.ShareDeviceResult;
import com.tplink.libtpmediastatistics.SSLClient;
import com.tplink.libtpnetwork.Utils.v;
import com.tplink.libtpnetwork.enumerate.EnumDeviceType;
import java.util.List;

/* loaded from: classes2.dex */
public class DeviceSharePullingAdapter extends RecyclerView.Adapter<c> {
    private Activity a;

    /* renamed from: b  reason: collision with root package name */
    private List<ShareDeviceResult> f5479b;

    /* renamed from: c  reason: collision with root package name */
    private d f5480c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ ShareDeviceResult f5481c;

        a(ShareDeviceResult shareDeviceResult) {
            this.f5481c = shareDeviceResult;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (DeviceSharePullingAdapter.this.f5480c != null) {
                DeviceSharePullingAdapter.this.f5480c.L0(this.f5481c);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ ShareDeviceResult f5483c;

        b(ShareDeviceResult shareDeviceResult) {
            this.f5483c = shareDeviceResult;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (DeviceSharePullingAdapter.this.f5480c != null) {
                DeviceSharePullingAdapter.this.f5480c.S(this.f5483c);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class c extends RecyclerView.ViewHolder {
        ImageView a;

        /* renamed from: b  reason: collision with root package name */
        TextView f5485b;

        /* renamed from: c  reason: collision with root package name */
        TextView f5486c;

        /* renamed from: d  reason: collision with root package name */
        TextView f5487d;

        /* renamed from: e  reason: collision with root package name */
        TextView f5488e;

        public c(View view) {
            super(view);
            this.a = (ImageView) view.findViewById(R.id.iv_iot_avatar);
            this.f5485b = (TextView) view.findViewById(R.id.tv_iot_name);
            this.f5486c = (TextView) view.findViewById(R.id.tv_from_user);
            this.f5487d = (TextView) view.findViewById(R.id.tv_decline);
            this.f5488e = (TextView) view.findViewById(R.id.tv_accept);
        }
    }

    /* loaded from: classes2.dex */
    public interface d {
        void L0(ShareDeviceResult shareDeviceResult);

        void S(ShareDeviceResult shareDeviceResult);
    }

    public DeviceSharePullingAdapter(Activity activity, List<ShareDeviceResult> list) {
        this.a = activity;
        this.f5479b = list;
    }

    private int n(EnumDeviceType enumDeviceType, String str) {
        return enumDeviceType == EnumDeviceType.BULB ? com.tplink.iot.g.b.c.c.i(str) ? R.mipmap.iot_light_strip_48 : R.mipmap.iot_bulb_48 : enumDeviceType == EnumDeviceType.CAMERA ? R.mipmap.iot_camera_54 : enumDeviceType == EnumDeviceType.HUB ? R.mipmap.iot_hub_48 : enumDeviceType == EnumDeviceType.SENSOR ? "T100".equals(str) ? R.mipmap.iot_sensor_48 : "T110".equals(str) ? R.mipmap.iot_sensor_t110_48 : "S200B".equals(str) ? R.mipmap.iot_button_s200b_48 : R.mipmap.iot_share_sensor_54 : enumDeviceType == EnumDeviceType.SWITCH ? "S210".equals(str) ? R.mipmap.iot_switch_s210_48 : R.mipmap.iot_switch_48 : enumDeviceType == EnumDeviceType.ENERGY ? R.mipmap.iot_trv_48 : R.mipmap.iot_plug_48;
    }

    private static String o(Context context, String str, String str2) {
        EnumDeviceType fromType = EnumDeviceType.fromType(str);
        return !TextUtils.isEmpty(str2) ? fromType == EnumDeviceType.CAMERA ? str2 : v.a(str2) : (context == null || fromType == null) ? "" : l.d(context, str, null);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<ShareDeviceResult> list = this.f5479b;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    /* renamed from: p */
    public void onBindViewHolder(@NonNull c cVar, int i) {
        ShareDeviceResult shareDeviceResult = this.f5479b.get(i);
        cVar.a.setImageResource(n(EnumDeviceType.fromType(shareDeviceResult.getDeviceType()), shareDeviceResult.getDeviceName()));
        cVar.f5485b.setText(o(this.a, shareDeviceResult.getDeviceType(), shareDeviceResult.getNickname()));
        TextView textView = cVar.f5486c;
        textView.setText(this.a.getString(R.string.share_device_share_from) + SSLClient.WHITE_SPACE + shareDeviceResult.getOwnerNickname());
        cVar.f5487d.setOnClickListener(new a(shareDeviceResult));
        cVar.f5488e.setOnClickListener(new b(shareDeviceResult));
    }

    @NonNull
    /* renamed from: q */
    public c onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new c(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_device_share_from_other_pulling, viewGroup, false));
    }

    public void r(List<ShareDeviceResult> list) {
        this.f5479b = list;
        notifyDataSetChanged();
    }

    public void s(d dVar) {
        this.f5480c = dVar;
    }
}
