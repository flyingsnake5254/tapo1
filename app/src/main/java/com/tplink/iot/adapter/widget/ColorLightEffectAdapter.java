package com.tplink.iot.adapter.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.R;
import com.tplink.iot.Utils.z0.i;
import com.tplink.iot.widget.colorbulb.ColorPointView;
import com.tplink.libtpnetwork.IoTNetwork.bean.colorbulb.LightStateBean;
import java.util.List;

/* loaded from: classes2.dex */
public class ColorLightEffectAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context a;

    /* renamed from: b  reason: collision with root package name */
    private List<LightStateBean> f6064b;

    /* renamed from: c  reason: collision with root package name */
    private c f6065c;

    /* loaded from: classes2.dex */
    class a extends RecyclerView.ViewHolder {
        ColorPointView a;

        public a(View view) {
            super(view);
            this.a = (ColorPointView) view.findViewById(R.id.item_color_circle_add);
        }
    }

    /* loaded from: classes2.dex */
    class b extends RecyclerView.ViewHolder {
        ColorPointView a;

        public b(View view) {
            super(view);
            this.a = (ColorPointView) view.findViewById(R.id.item_color_circle);
        }
    }

    /* loaded from: classes2.dex */
    public interface c {
        void a(int i, boolean z);
    }

    public ColorLightEffectAdapter(Context context, List<LightStateBean> list) {
        this.a = context;
        this.f6064b = list;
    }

    private boolean m(int i) {
        List<LightStateBean> list;
        return (i != getItemCount() - 1 || (list = this.f6064b) == null || list.size() == 8) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n */
    public /* synthetic */ void o(int i, View view) {
        c cVar = this.f6065c;
        if (cVar != null) {
            cVar.a(i, m(i));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<LightStateBean> list = this.f6064b;
        if (list != null && list.size() >= 8) {
            return this.f6064b.size();
        }
        List<LightStateBean> list2 = this.f6064b;
        if (list2 == null) {
            return 1;
        }
        return 1 + list2.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        List<LightStateBean> list;
        return (i != getItemCount() - 1 || (list = this.f6064b) == null || list.size() >= 8) ? 0 : 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {
        if (viewHolder instanceof b) {
            b bVar = (b) viewHolder;
            bVar.a.setInnerCircleColor(i.d(this.f6064b.get(i)));
            bVar.a.setOutlineColor(-1315861);
        }
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tplink.iot.adapter.widget.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ColorLightEffectAdapter.this.o(i, view);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (i == 1) {
            return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_color_light_effect_add, viewGroup, false));
        }
        return new b(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_color_light_effect, viewGroup, false));
    }

    public void p(c cVar) {
        this.f6065c = cVar;
    }
}
