package com.tplink.iot.adapter.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.R;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class DeviceMoveAdapter extends RecyclerView.Adapter {
    private Context a;

    /* renamed from: b  reason: collision with root package name */
    private List<com.tplink.iot.model.home.c> f5679b;

    /* renamed from: c  reason: collision with root package name */
    private b f5680c;

    /* loaded from: classes2.dex */
    class a implements View.OnClickListener {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ com.tplink.iot.model.home.c f5681c;

        a(com.tplink.iot.model.home.c cVar) {
            this.f5681c = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (DeviceMoveAdapter.this.f5680c != null) {
                DeviceMoveAdapter.this.f5680c.Z(this.f5681c);
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface b {
        void Z(com.tplink.iot.model.home.c cVar);
    }

    /* loaded from: classes2.dex */
    class c extends RecyclerView.ViewHolder {
        TextView a;

        /* renamed from: b  reason: collision with root package name */
        TextView f5683b;

        public c(View view) {
            super(view);
            this.a = (TextView) view.findViewById(R.id.tv_room_name);
            this.f5683b = (TextView) view.findViewById(R.id.tv_room_numbers);
        }
    }

    public DeviceMoveAdapter(Context context) {
        this.a = context;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<com.tplink.iot.model.home.c> list = this.f5679b;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public void n(List<com.tplink.iot.model.home.c> list) {
        if (this.f5679b == null) {
            this.f5679b = new ArrayList();
        }
        this.f5679b.clear();
        if (list != null && !list.isEmpty()) {
            this.f5679b.addAll(list);
        }
        notifyDataSetChanged();
    }

    public void o(b bVar) {
        this.f5680c = bVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        com.tplink.iot.model.home.c cVar = this.f5679b.get(i);
        c cVar2 = (c) viewHolder;
        cVar2.a.setText(cVar.c());
        int a2 = cVar.a();
        if (a2 == 0) {
            cVar2.f5683b.setText(this.a.getResources().getString(R.string.no_devices));
        } else {
            cVar2.f5683b.setText(this.a.getResources().getQuantityString(R.plurals.devices_num, a2, Integer.valueOf(a2)));
        }
        cVar2.itemView.setOnClickListener(new a(cVar));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new c(LayoutInflater.from(this.a).inflate(R.layout.item_device_move_list, viewGroup, false));
    }
}
