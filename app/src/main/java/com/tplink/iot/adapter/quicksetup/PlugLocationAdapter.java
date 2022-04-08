package com.tplink.iot.adapter.quicksetup;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.R;
import com.tplink.iot.model.iot.EnumDeviceNicknameType;
import java.util.List;

/* loaded from: classes2.dex */
public class PlugLocationAdapter extends RecyclerView.Adapter {
    private Context a;

    /* renamed from: b  reason: collision with root package name */
    private List<SelectLocationBean> f5896b;

    /* renamed from: c  reason: collision with root package name */
    private f f5897c;

    /* loaded from: classes2.dex */
    class a implements View.OnClickListener {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f5898c;

        a(int i) {
            this.f5898c = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            for (SelectLocationBean selectLocationBean : PlugLocationAdapter.this.f5896b) {
                selectLocationBean.setSelect(false);
            }
            ((SelectLocationBean) PlugLocationAdapter.this.f5896b.get(this.f5898c)).setSelect(true);
            PlugLocationAdapter.this.notifyDataSetChanged();
            if (PlugLocationAdapter.this.f5897c != null) {
                PlugLocationAdapter.this.f5897c.a(view, this.f5898c);
            }
        }
    }

    /* loaded from: classes2.dex */
    private class b extends RecyclerView.ViewHolder {
        TextView a;

        /* renamed from: b  reason: collision with root package name */
        ImageView f5900b;

        b(View view) {
            super(view);
            this.a = (TextView) view.findViewById(R.id.tv_device_place);
            this.f5900b = (ImageView) view.findViewById(R.id.image_check);
        }
    }

    public PlugLocationAdapter(Context context, List<SelectLocationBean> list) {
        this.a = context;
        this.f5896b = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<SelectLocationBean> list = this.f5896b;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public void o(f fVar) {
        this.f5897c = fVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        b bVar = (b) viewHolder;
        SelectLocationBean selectLocationBean = this.f5896b.get(i);
        bVar.a.setText(EnumDeviceNicknameType.fromType(selectLocationBean.getLocation()));
        bVar.f5900b.setSelected(selectLocationBean.isSelect());
        bVar.itemView.setOnClickListener(new a(i));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new b(LayoutInflater.from(this.a).inflate(R.layout.item_qs_plug_location, viewGroup, false));
    }
}
