package com.tplink.iot.adapter.deviceshare;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.cloud.bean.share.result.ShareBlacklistItemResult;
import com.tplink.iot.R;
import com.tplink.libtpcontrols.TPCircleMaskView;
import java.util.List;

/* loaded from: classes2.dex */
public class DeviceShareBlacklistAdapter extends RecyclerView.Adapter<b> {
    private List<ShareBlacklistItemResult> a;

    /* renamed from: b  reason: collision with root package name */
    private Context f5448b;

    /* renamed from: c  reason: collision with root package name */
    private c f5449c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ ShareBlacklistItemResult f5450c;

        a(ShareBlacklistItemResult shareBlacklistItemResult) {
            this.f5450c = shareBlacklistItemResult;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (DeviceShareBlacklistAdapter.this.f5449c != null) {
                DeviceShareBlacklistAdapter.this.f5449c.G0(this.f5450c);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class b extends RecyclerView.ViewHolder {
        TPCircleMaskView a;

        /* renamed from: b  reason: collision with root package name */
        TextView f5452b;

        /* renamed from: c  reason: collision with root package name */
        TextView f5453c;

        /* renamed from: d  reason: collision with root package name */
        ImageView f5454d;

        public b(View view) {
            super(view);
            this.a = (TPCircleMaskView) view.findViewById(R.id.img_icon);
            this.f5452b = (TextView) view.findViewById(R.id.tv_nickname);
            this.f5453c = (TextView) view.findViewById(R.id.tv_email);
            this.f5454d = (ImageView) view.findViewById(R.id.iv_delete);
        }
    }

    /* loaded from: classes2.dex */
    public interface c {
        void G0(ShareBlacklistItemResult shareBlacklistItemResult);
    }

    public DeviceShareBlacklistAdapter(Activity activity, List<ShareBlacklistItemResult> list) {
        this.f5448b = activity;
        this.a = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<ShareBlacklistItemResult> list = this.a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    /* renamed from: n */
    public void onBindViewHolder(@NonNull b bVar, int i) {
        ShareBlacklistItemResult shareBlacklistItemResult = this.a.get(i);
        bVar.a.setImageUrl(shareBlacklistItemResult.getAvatarUrl());
        bVar.f5452b.setText(shareBlacklistItemResult.getNickname());
        bVar.f5453c.setText(shareBlacklistItemResult.getEmail());
        bVar.f5454d.setOnClickListener(new a(shareBlacklistItemResult));
    }

    @NonNull
    /* renamed from: o */
    public b onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new b(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_device_share_blacklist, viewGroup, false));
    }

    public void p(List<ShareBlacklistItemResult> list) {
        this.a = list;
        notifyDataSetChanged();
    }

    public void q(c cVar) {
        this.f5449c = cVar;
    }
}
