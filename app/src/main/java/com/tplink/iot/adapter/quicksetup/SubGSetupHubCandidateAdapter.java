package com.tplink.iot.adapter.quicksetup;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.R;
import com.tplink.iot.Utils.z0.l;
import com.tplink.iot.model.iot.e;
import com.tplink.libtpnetwork.IoTNetwork.bean.hub.result.LoadInfoBean;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* loaded from: classes2.dex */
public class SubGSetupHubCandidateAdapter extends RecyclerView.Adapter {
    private final Context a;

    /* renamed from: b  reason: collision with root package name */
    private final List<e> f5927b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    private f f5928c;

    /* loaded from: classes2.dex */
    private class a extends RecyclerView.ViewHolder {
        ImageView a;

        /* renamed from: b  reason: collision with root package name */
        TextView f5929b;

        /* renamed from: c  reason: collision with root package name */
        TextView f5930c;

        /* renamed from: d  reason: collision with root package name */
        TextView f5931d;

        /* renamed from: e  reason: collision with root package name */
        ImageView f5932e;

        a(View view) {
            super(view);
            this.a = (ImageView) view.findViewById(R.id.device_avatar);
            this.f5929b = (TextView) view.findViewById(R.id.device_name);
            this.f5930c = (TextView) view.findViewById(R.id.device_location);
            this.f5931d = (TextView) view.findViewById(R.id.device_load_status);
            this.f5932e = (ImageView) view.findViewById(R.id.iv_update_hint);
        }

        void c(String str, @ColorRes int i, @DrawableRes int i2) {
            this.f5931d.setText(str);
            this.f5931d.setTextColor(SubGSetupHubCandidateAdapter.this.a.getResources().getColor(i));
            this.f5931d.setCompoundDrawablesRelativeWithIntrinsicBounds(i2 != -1 ? ContextCompat.getDrawable(SubGSetupHubCandidateAdapter.this.a, i2) : null, (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }

    public SubGSetupHubCandidateAdapter(Context context) {
        this.a = context;
    }

    private Comparator<e> o() {
        return b.f5936c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ int p(e eVar, e eVar2) {
        String c2 = eVar.c();
        String c3 = eVar2.c();
        if (c3 == null) {
            return -1;
        }
        if (c2 == null) {
            return 1;
        }
        return LoadInfoBean.getLoadLevelInt(c2) - LoadInfoBean.getLoadLevelInt(c3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: q */
    public /* synthetic */ void r(RecyclerView.ViewHolder viewHolder, View view) {
        f fVar = this.f5928c;
        if (fVar != null) {
            fVar.a(view, viewHolder.getAdapterPosition());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<e> list = this.f5927b;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Nullable
    public e n(int i) {
        if (i < 0 || i >= getItemCount()) {
            return null;
        }
        return this.f5927b.get(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @SuppressLint({"SetTextI18n"})
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder viewHolder, int i) {
        a aVar = (a) viewHolder;
        e eVar = this.f5927b.get(i);
        BaseALIoTDevice<?> b2 = eVar.b();
        l.p(this.a, b2, aVar.a);
        aVar.f5929b.setText(l.e(this.a, b2.getDeviceType(), b2.getDeviceName(), b2.getDeviceModel()));
        String b3 = l.b(this.a, b2);
        if (!TextUtils.isEmpty(b3)) {
            aVar.f5930c.setText(b3);
            aVar.f5930c.setVisibility(0);
        } else {
            aVar.f5930c.setText("");
            aVar.f5930c.setVisibility(8);
        }
        aVar.itemView.setAlpha(b2.isOnline() ? 1.0f : 0.5f);
        aVar.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tplink.iot.adapter.quicksetup.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SubGSetupHubCandidateAdapter.this.r(viewHolder, view);
            }
        });
        String c2 = eVar.c();
        if (c2 == null || !b2.isOnline()) {
            aVar.f5931d.setVisibility(8);
        } else {
            aVar.f5931d.setVisibility(0);
            int loadLevelInt = LoadInfoBean.getLoadLevelInt(c2);
            if (loadLevelInt == 2) {
                aVar.c(this.a.getString(R.string.hub_setting_load_level) + ": " + this.a.getString(R.string.setting_load_level_middle), R.color.common_iot_orange, R.mipmap.icon_warning_yellow);
            } else if (loadLevelInt == 3) {
                aVar.c(this.a.getString(R.string.hub_setting_load_level) + ": " + this.a.getString(R.string.setting_load_level_high), R.color.common_iot_red, R.mipmap.smart_warning_icon);
            } else {
                aVar.c(this.a.getString(R.string.hub_setting_load_level) + ": " + this.a.getString(R.string.hub_load_level_light), R.color.common_iot_light_black, -1);
            }
        }
        if (!eVar.d() || !b2.isOnline()) {
            aVar.f5932e.setVisibility(8);
        } else {
            aVar.f5932e.setVisibility(0);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new a(LayoutInflater.from(this.a).inflate(R.layout.item_subg_hub_layout, viewGroup, false));
    }

    public void s(List<e> list) {
        if (list != null && !list.isEmpty()) {
            this.f5927b.clear();
            Collections.sort(list, o());
            this.f5927b.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void t(f fVar) {
        this.f5928c = fVar;
    }
}
