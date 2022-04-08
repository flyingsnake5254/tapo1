package com.tplink.iot.adapter.home;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.R;
import java.util.List;

/* loaded from: classes2.dex */
public class DeviceMoveSelectMenuAdapter extends RecyclerView.Adapter {
    private Activity a;

    /* renamed from: b  reason: collision with root package name */
    private List<HomeFamilySelectBean> f5685b;

    /* renamed from: c  reason: collision with root package name */
    private b f5686c;

    /* loaded from: classes2.dex */
    class a implements View.OnClickListener {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ HomeFamilySelectBean f5687c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ int f5688d;

        a(HomeFamilySelectBean homeFamilySelectBean, int i) {
            this.f5687c = homeFamilySelectBean;
            this.f5688d = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!this.f5687c.isSelected()) {
                for (HomeFamilySelectBean homeFamilySelectBean : DeviceMoveSelectMenuAdapter.this.f5685b) {
                    homeFamilySelectBean.setSelected(false);
                }
                ((HomeFamilySelectBean) DeviceMoveSelectMenuAdapter.this.f5685b.get(this.f5688d)).setSelected(true);
                DeviceMoveSelectMenuAdapter.this.notifyDataSetChanged();
                if (DeviceMoveSelectMenuAdapter.this.f5686c != null) {
                    DeviceMoveSelectMenuAdapter.this.f5686c.a(view, this.f5688d);
                }
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
        ImageView f5690b;

        /* renamed from: c  reason: collision with root package name */
        TextView f5691c;

        c(View view) {
            super(view);
            this.a = (TextView) view.findViewById(R.id.tv_family_name);
            this.f5690b = (ImageView) view.findViewById(R.id.img_family_select);
            this.f5691c = (TextView) view.findViewById(R.id.tv_setting);
        }
    }

    public DeviceMoveSelectMenuAdapter(Activity activity, List<HomeFamilySelectBean> list) {
        this.a = activity;
        this.f5685b = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<HomeFamilySelectBean> list = this.f5685b;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public void o(b bVar) {
        this.f5686c = bVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        c cVar = (c) viewHolder;
        HomeFamilySelectBean homeFamilySelectBean = this.f5685b.get(i);
        cVar.a.setText(homeFamilySelectBean.getFamilyName());
        cVar.f5690b.setImageResource(homeFamilySelectBean.isSelected() ? R.mipmap.home_radio_on : R.mipmap.home_radio_off);
        cVar.itemView.setOnClickListener(new a(homeFamilySelectBean, i));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new c(LayoutInflater.from(this.a).inflate(R.layout.device_move_pop_menu_item_layout, viewGroup, false));
    }
}
