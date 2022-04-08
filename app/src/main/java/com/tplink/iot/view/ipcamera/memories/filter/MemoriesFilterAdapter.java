package com.tplink.iot.view.ipcamera.memories.filter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.request.g;
import com.tplink.iot.R;
import com.tplink.iot.Utils.y0.c;
import com.tplink.iot.view.ipcamera.setting.z4;
import com.tplink.libtpmediaother.memory.p;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* loaded from: classes2.dex */
public class MemoriesFilterAdapter extends RecyclerView.Adapter {
    private List<p> a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    private Set<String> f8739b = new HashSet();

    /* renamed from: c  reason: collision with root package name */
    private Context f8740c;

    /* loaded from: classes2.dex */
    class a implements View.OnClickListener {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ b f8741c;

        a(b bVar) {
            this.f8741c = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str = "" + view.getTag();
            boolean contains = MemoriesFilterAdapter.this.f8739b.contains(str);
            this.f8741c.f8745d.setImageResource(!contains ? R.mipmap.home_radio_on : R.mipmap.home_radio_off);
            if (contains) {
                MemoriesFilterAdapter.this.f8739b.remove(str);
            } else {
                MemoriesFilterAdapter.this.f8739b.add(str);
            }
        }
    }

    /* loaded from: classes2.dex */
    private class b extends RecyclerView.ViewHolder {
        ImageView a;

        /* renamed from: b  reason: collision with root package name */
        TextView f8743b;

        /* renamed from: c  reason: collision with root package name */
        TextView f8744c;

        /* renamed from: d  reason: collision with root package name */
        ImageView f8745d;

        public b(View view) {
            super(view);
            this.a = (ImageView) view.findViewById(R.id.device_icon);
            this.f8743b = (TextView) view.findViewById(R.id.device_name);
            this.f8744c = (TextView) view.findViewById(R.id.device_location_name);
            this.f8745d = (ImageView) view.findViewById(R.id.item_select);
        }
    }

    public MemoriesFilterAdapter() {
        setHasStableIds(true);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<p> list = this.a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n() {
        this.f8739b.clear();
        notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<String> o() {
        return new ArrayList(this.f8739b);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        p pVar = this.a.get(i);
        b bVar = (b) viewHolder;
        bVar.itemView.setTag(pVar.a());
        bVar.itemView.setOnClickListener(new a(bVar));
        StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append(pVar.a());
        bVar.f8745d.setImageResource(this.f8739b.contains(sb.toString()) ? R.mipmap.home_radio_on : R.mipmap.home_radio_off);
        bVar.f8743b.setText(pVar.a());
        if (TextUtils.isEmpty(pVar.b())) {
            bVar.a.setImageResource(R.mipmap.iot_house_36);
            bVar.f8744c.setText(R.string.onBoarding_set_location_home);
        } else if (!TextUtils.isEmpty(pVar.c())) {
            String c2 = pVar.c();
            g gVar = new g();
            gVar.f0(new c());
            com.bumptech.glide.c.u(this.f8740c).s(c2).a(gVar).x0(bVar.a);
            bVar.f8744c.setText(pVar.b());
        } else {
            bVar.f8744c.setText(z4.c(this.f8740c, pVar.b(), true));
            bVar.a.setImageResource(z4.a(this.f8740c, pVar.b()));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        this.f8740c = viewGroup.getContext();
        return new b(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_memories_filter, viewGroup, false));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p(List<String> list) {
        if (list != null && !list.isEmpty()) {
            this.f8739b.clear();
            this.f8739b.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void q(List<p> list) {
        this.a.addAll(list);
        notifyDataSetChanged();
    }
}
