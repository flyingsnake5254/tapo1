package com.tplink.iot.adapter.deviceshare;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.cloud.bean.share.result.ShareBlacklistItemResult;
import com.tplink.iot.R;
import com.tplink.libtpcontrols.TPCircleMaskView;
import com.tplink.libtpnetwork.TPCloudNetwork.bean.ShareBlacklistCacheBean;
import java.util.List;

/* loaded from: classes2.dex */
public class DeviceShareBlacklistRecordAdapter extends RecyclerView.Adapter<b> {
    private List<ShareBlacklistCacheBean> a;

    /* renamed from: b  reason: collision with root package name */
    private Context f5455b;

    /* renamed from: c  reason: collision with root package name */
    private c f5456c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ ShareBlacklistItemResult f5457c;

        a(ShareBlacklistItemResult shareBlacklistItemResult) {
            this.f5457c = shareBlacklistItemResult;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (DeviceShareBlacklistRecordAdapter.this.f5456c != null) {
                DeviceShareBlacklistRecordAdapter.this.f5456c.a(this.f5457c);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class b extends RecyclerView.ViewHolder {
        TPCircleMaskView a;

        /* renamed from: b  reason: collision with root package name */
        TextView f5459b;

        /* renamed from: c  reason: collision with root package name */
        TextView f5460c;

        public b(View view) {
            super(view);
            this.a = (TPCircleMaskView) view.findViewById(R.id.img_icon);
            this.f5459b = (TextView) view.findViewById(R.id.tv_nickname);
            this.f5460c = (TextView) view.findViewById(R.id.tv_email);
        }
    }

    /* loaded from: classes2.dex */
    public interface c {
        void a(ShareBlacklistItemResult shareBlacklistItemResult);
    }

    public DeviceShareBlacklistRecordAdapter(Activity activity, List<ShareBlacklistCacheBean> list) {
        this.f5455b = activity;
        this.a = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<ShareBlacklistCacheBean> list = this.a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    /* renamed from: n */
    public void onBindViewHolder(@NonNull b bVar, int i) {
        ShareBlacklistCacheBean shareBlacklistCacheBean = this.a.get(i);
        bVar.a.setImageUrl(shareBlacklistCacheBean.getAvatarUrl());
        bVar.f5459b.setText(shareBlacklistCacheBean.getNickname());
        bVar.f5460c.setText(shareBlacklistCacheBean.getEmail());
        bVar.itemView.setOnClickListener(new a(shareBlacklistCacheBean));
    }

    @NonNull
    /* renamed from: o */
    public b onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new b(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_device_share_blacklist_record, viewGroup, false));
    }

    public void p(c cVar) {
        this.f5456c = cVar;
    }
}
