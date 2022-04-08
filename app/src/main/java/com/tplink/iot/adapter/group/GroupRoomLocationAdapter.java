package com.tplink.iot.adapter.group;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.R;
import com.tplink.iot.Utils.b0;
import com.tplink.iot.adapter.quicksetup.f;
import com.tplink.iot.cloud.bean.family.common.RoomInfo;
import java.util.List;

/* loaded from: classes2.dex */
public class GroupRoomLocationAdapter extends RecyclerView.Adapter {
    private Context a;

    /* renamed from: b  reason: collision with root package name */
    private List<RoomInfo> f5671b;

    /* renamed from: c  reason: collision with root package name */
    private int f5672c;

    /* renamed from: d  reason: collision with root package name */
    private f f5673d;

    /* loaded from: classes2.dex */
    class a implements View.OnClickListener {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f5674c;

        a(int i) {
            this.f5674c = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!(this.f5674c == GroupRoomLocationAdapter.this.f5672c || this.f5674c == GroupRoomLocationAdapter.this.getItemCount() - 1)) {
                GroupRoomLocationAdapter.this.f5672c = this.f5674c;
                GroupRoomLocationAdapter.this.notifyDataSetChanged();
            }
            if (GroupRoomLocationAdapter.this.f5673d != null) {
                GroupRoomLocationAdapter.this.f5673d.a(view, this.f5674c);
            }
        }
    }

    /* loaded from: classes2.dex */
    private class b extends RecyclerView.ViewHolder {
        TextView a;

        /* renamed from: b  reason: collision with root package name */
        ImageView f5676b;

        /* renamed from: c  reason: collision with root package name */
        ImageView f5677c;

        b(View view) {
            super(view);
            this.a = (TextView) view.findViewById(R.id.tv_device_place);
            this.f5676b = (ImageView) view.findViewById(R.id.image_check);
            this.f5677c = (ImageView) view.findViewById(R.id.img_right_arrow);
        }
    }

    public GroupRoomLocationAdapter(Activity activity, List<RoomInfo> list, int i) {
        this.f5672c = 0;
        this.a = activity;
        this.f5671b = list;
        this.f5672c = i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<RoomInfo> list = this.f5671b;
        if (list == null) {
            return 1;
        }
        return 1 + list.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        b bVar = (b) viewHolder;
        bVar.a.setText(i < p() ? this.f5671b.get(i).getName() : b0.a(R.string.location_custom));
        boolean z = true;
        if (i != getItemCount() - 1) {
            bVar.f5676b.setVisibility(0);
            bVar.f5677c.setVisibility(8);
        } else {
            bVar.f5676b.setVisibility(8);
            bVar.f5677c.setVisibility(0);
        }
        ImageView imageView = bVar.f5676b;
        if (i != this.f5672c) {
            z = false;
        }
        imageView.setSelected(z);
        bVar.itemView.setOnClickListener(new a(i));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new b(LayoutInflater.from(this.a).inflate(R.layout.item_group_room_location, viewGroup, false));
    }

    public int p() {
        List<RoomInfo> list = this.f5671b;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public void q(f fVar) {
        this.f5673d = fVar;
    }

    public void r(int i) {
        if (i != this.f5672c && i < p()) {
            this.f5672c = i;
            notifyDataSetChanged();
        }
    }
}
