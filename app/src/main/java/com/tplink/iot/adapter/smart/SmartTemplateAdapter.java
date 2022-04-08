package com.tplink.iot.adapter.smart;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.load.engine.j;
import com.bumptech.glide.request.g;
import com.tplink.iot.R;
import com.tplink.iot.cloud.bean.smart.common.SmartTemplate;
import com.tplink.iot.model.smart.SmartTemplateBaseBean;
import com.tplink.iot.model.smart.SmartTemplateEntityBean;
import com.tplink.iot.model.smart.SmartTemplateTitleBean;
import java.util.List;

/* loaded from: classes2.dex */
public class SmartTemplateAdapter extends RecyclerView.Adapter {
    private List<SmartTemplateBaseBean> a;

    /* renamed from: b  reason: collision with root package name */
    private b f6000b;

    /* loaded from: classes2.dex */
    private abstract class a extends RecyclerView.ViewHolder {
        a(View view) {
            super(view);
        }

        public abstract void c(SmartTemplateBaseBean smartTemplateBaseBean, int i);
    }

    /* loaded from: classes2.dex */
    public interface b {
        void A(int i);
    }

    /* loaded from: classes2.dex */
    private class c extends a {

        /* renamed from: b  reason: collision with root package name */
        private ImageView f6001b;

        /* renamed from: c  reason: collision with root package name */
        private TextView f6002c;

        /* loaded from: classes2.dex */
        class a implements View.OnClickListener {

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ int f6004c;

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ SmartTemplate f6005d;

            a(int i, SmartTemplate smartTemplate) {
                this.f6004c = i;
                this.f6005d = smartTemplate;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (SmartTemplateAdapter.this.f6000b != null) {
                    SmartTemplateAdapter.this.f6000b.A(this.f6004c - (this.f6005d.getTriggerSetting().isManual() ? 1 : 2));
                }
            }
        }

        c(View view) {
            super(view);
            this.f6002c = (TextView) view.findViewById(R.id.tv_smart_template_name);
            this.f6001b = (ImageView) view.findViewById(R.id.iv_featured_action_item);
        }

        @Override // com.tplink.iot.adapter.smart.SmartTemplateAdapter.a
        public void c(SmartTemplateBaseBean smartTemplateBaseBean, int i) {
            SmartTemplate entity = ((SmartTemplateEntityBean) smartTemplateBaseBean).getEntity();
            this.f6002c.setText(entity.getName());
            com.bumptech.glide.c.u(this.f6001b.getContext()).s(entity.getTitleImgUrl()).a(new g().V(R.mipmap.smart_bg_shadow).j(R.mipmap.smart_bg_shadow).f(j.f1461d)).x0(this.f6001b);
            this.f6001b.setOnClickListener(new a(i, entity));
        }
    }

    /* loaded from: classes2.dex */
    private class d extends a {

        /* renamed from: b  reason: collision with root package name */
        private TextView f6007b;

        d(View view) {
            super(view);
            this.f6007b = (TextView) view.findViewById(R.id.tv_smart_template_type_name);
        }

        @Override // com.tplink.iot.adapter.smart.SmartTemplateAdapter.a
        public void c(SmartTemplateBaseBean smartTemplateBaseBean, int i) {
            this.f6007b.setText(((SmartTemplateTitleBean) smartTemplateBaseBean).getTitle());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<SmartTemplateBaseBean> list = this.a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        return this.a.get(i).getType();
    }

    public void n(b bVar) {
        this.f6000b = bVar;
    }

    public void o(List<SmartTemplateBaseBean> list) {
        this.a = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        ((a) viewHolder).c(this.a.get(i), i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return i == 0 ? new d(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_smart_template_title, viewGroup, false)) : new c(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_smart_template_card, viewGroup, false));
    }
}
