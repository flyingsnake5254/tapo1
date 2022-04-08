package com.tplink.libtpcontrols.horizontalpageview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.libtpcontrols.s0;
import com.tplink.libtpcontrols.t0;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class TPHorizontalRecycleAdapter extends RecyclerView.Adapter<ViewHolder> {
    private Context a;

    /* renamed from: b  reason: collision with root package name */
    private List<String> f12266b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    private List<String> f12267c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    private a f12268d = null;

    /* loaded from: classes3.dex */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public View a;

        /* renamed from: b  reason: collision with root package name */
        public LinearLayout f12269b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f12270c;

        /* renamed from: d  reason: collision with root package name */
        public ImageView f12271d;

        public ViewHolder(View view) {
            super(view);
            this.a = view;
            this.f12269b = (LinearLayout) view.findViewById(s0.layout);
            this.f12270c = (TextView) view.findViewById(s0.tv_name);
            this.f12271d = (ImageView) view.findViewById(s0.image);
        }
    }

    /* loaded from: classes3.dex */
    public interface a {
        void a(int i);
    }

    public TPHorizontalRecycleAdapter(Context context, List<String> list, List<String> list2) {
        this.a = context;
        this.f12266b.clear();
        this.f12267c.clear();
        this.f12266b.addAll(list);
        this.f12267c.addAll(list2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m */
    public /* synthetic */ void n(int i, View view) {
        a aVar = this.f12268d;
        if (aVar != null) {
            aVar.a(i);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<String> list = this.f12266b;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    /* renamed from: o */
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        viewHolder.f12269b.setOnClickListener(new View.OnClickListener() { // from class: com.tplink.libtpcontrols.horizontalpageview.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TPHorizontalRecycleAdapter.this.n(i, view);
            }
        });
        viewHolder.f12270c.setText(this.f12266b.get(i));
        viewHolder.f12271d.setImageResource(this.a.getResources().getIdentifier(this.f12267c.get(i), "mipmap", this.a.getPackageName()));
    }

    @NonNull
    /* renamed from: p */
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(t0.location_recyclew_adapter, viewGroup, false);
        GridLayoutManager.LayoutParams layoutParams = (GridLayoutManager.LayoutParams) inflate.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams).width = viewGroup.getWidth() / 4;
        ((ViewGroup.MarginLayoutParams) layoutParams).height = viewGroup.getHeight() / 2;
        inflate.setLayoutParams(layoutParams);
        return new ViewHolder(inflate);
    }

    public void q(a aVar) {
        this.f12268d = aVar;
    }
}
