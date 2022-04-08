package com.tplink.iot.dailysummary.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.R;
import com.tplink.iot.dailysummary.view.SummaryHistoryActivity;
import com.tplink.iot.dailysummary.view.SummaryPlayActivity;
import com.tplink.iot.dailysummary.view.viewhodlder.SummaryHistoryViewHolder;
import com.tplink.iot.dailysummary.viewmodel.SummaryHistoryViewModel;
import com.tplink.iot.databinding.ItemSummaryHistoryBinding;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.j;

/* compiled from: SummaryHistoryAdapter.kt */
/* loaded from: classes2.dex */
public final class SummaryHistoryAdapter extends RecyclerView.Adapter<SummaryHistoryViewHolder> {
    private final SummaryHistoryActivity a;

    /* renamed from: b  reason: collision with root package name */
    private final SummaryHistoryViewModel f6349b;

    /* renamed from: c  reason: collision with root package name */
    private ArrayList<com.tplink.iot.dailysummary.model.b> f6350c = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    private boolean f6351d;

    /* compiled from: SummaryHistoryAdapter.kt */
    /* loaded from: classes2.dex */
    static final class a<T> implements Observer<ArrayList<com.tplink.iot.dailysummary.model.b>> {
        final /* synthetic */ SummaryHistoryViewModel a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ SummaryHistoryAdapter f6352b;

        a(SummaryHistoryViewModel summaryHistoryViewModel, SummaryHistoryAdapter summaryHistoryAdapter) {
            this.a = summaryHistoryViewModel;
            this.f6352b = summaryHistoryAdapter;
        }

        /* renamed from: a */
        public final void onChanged(ArrayList<com.tplink.iot.dailysummary.model.b> it) {
            if (j.a(this.a.P().getValue(), Boolean.FALSE)) {
                SummaryHistoryAdapter summaryHistoryAdapter = this.f6352b;
                j.d(it, "it");
                summaryHistoryAdapter.f6350c = it;
                this.f6352b.notifyDataSetChanged();
            }
        }
    }

    /* compiled from: SummaryHistoryAdapter.kt */
    /* loaded from: classes2.dex */
    static final class b<T> implements Observer<Boolean> {
        b() {
        }

        /* renamed from: a */
        public final void onChanged(Boolean it) {
            SummaryHistoryAdapter summaryHistoryAdapter = SummaryHistoryAdapter.this;
            j.d(it, "it");
            summaryHistoryAdapter.t(it.booleanValue());
        }
    }

    /* compiled from: SummaryHistoryAdapter.kt */
    /* loaded from: classes2.dex */
    static final class c<T> implements Observer<Boolean> {
        c() {
        }

        /* renamed from: a */
        public final void onChanged(Boolean bool) {
            SummaryHistoryAdapter.this.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SummaryHistoryAdapter.kt */
    /* loaded from: classes2.dex */
    public static final class d implements View.OnClickListener {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ SummaryHistoryViewHolder f6354d;

        d(SummaryHistoryViewHolder summaryHistoryViewHolder) {
            this.f6354d = summaryHistoryViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View it) {
            int bindingAdapterPosition = this.f6354d.getBindingAdapterPosition();
            if (SummaryHistoryAdapter.this.f6351d) {
                j.d(it, "it");
                it.setClickable(false);
                SummaryHistoryAdapter.this.f6349b.L(bindingAdapterPosition);
                SummaryHistoryAdapter.this.notifyItemChanged(bindingAdapterPosition);
                it.setClickable(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SummaryHistoryAdapter.kt */
    /* loaded from: classes2.dex */
    public static final class e implements View.OnLongClickListener {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ SummaryHistoryViewHolder f6356d;

        e(SummaryHistoryViewHolder summaryHistoryViewHolder) {
            this.f6356d = summaryHistoryViewHolder;
        }

        @Override // android.view.View.OnLongClickListener
        public final boolean onLongClick(View view) {
            int bindingAdapterPosition = this.f6356d.getBindingAdapterPosition();
            if (!SummaryHistoryAdapter.this.f6351d) {
                SummaryHistoryAdapter.this.a.p1(true);
            }
            SummaryHistoryAdapter.this.f6349b.L(bindingAdapterPosition);
            SummaryHistoryAdapter.this.notifyItemChanged(bindingAdapterPosition);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SummaryHistoryAdapter.kt */
    /* loaded from: classes2.dex */
    public static final class f implements View.OnClickListener {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ SummaryHistoryViewHolder f6358d;

        f(SummaryHistoryViewHolder summaryHistoryViewHolder) {
            this.f6358d = summaryHistoryViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            int bindingAdapterPosition = this.f6358d.getBindingAdapterPosition();
            SummaryHistoryAdapter.this.f6349b.k(bindingAdapterPosition, 1);
            SummaryHistoryAdapter.this.notifyItemChanged(bindingAdapterPosition);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SummaryHistoryAdapter.kt */
    /* loaded from: classes2.dex */
    public static final class g implements View.OnClickListener {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ SummaryHistoryViewHolder f6360d;

        g(SummaryHistoryViewHolder summaryHistoryViewHolder) {
            this.f6360d = summaryHistoryViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            int bindingAdapterPosition = this.f6360d.getBindingAdapterPosition();
            SummaryHistoryAdapter.this.f6349b.k(bindingAdapterPosition, 0);
            SummaryHistoryAdapter.this.notifyItemChanged(bindingAdapterPosition);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SummaryHistoryAdapter.kt */
    /* loaded from: classes2.dex */
    public static final class h implements View.OnClickListener {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ SummaryHistoryViewHolder f6362d;

        h(SummaryHistoryViewHolder summaryHistoryViewHolder) {
            this.f6362d = summaryHistoryViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            SummaryPlayActivity.y.a(SummaryHistoryAdapter.this.a, ((com.tplink.iot.dailysummary.model.b) SummaryHistoryAdapter.this.f6350c.get(this.f6362d.getBindingAdapterPosition())).c());
        }
    }

    public SummaryHistoryAdapter(Context context, SummaryHistoryViewModel viewModel) {
        j.e(context, "context");
        j.e(viewModel, "viewModel");
        SummaryHistoryActivity summaryHistoryActivity = (SummaryHistoryActivity) context;
        this.a = summaryHistoryActivity;
        this.f6349b = viewModel;
        viewModel.C().observe(summaryHistoryActivity, new a(viewModel, this));
        viewModel.P().observe(summaryHistoryActivity, new b());
        viewModel.U().observe(summaryHistoryActivity, new c());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f6350c.size();
    }

    /* renamed from: r */
    public void onBindViewHolder(SummaryHistoryViewHolder holder, int i) {
        j.e(holder, "holder");
        com.tplink.iot.dailysummary.model.b bVar = this.f6350c.get(i);
        j.d(bVar, "mSummaryList[position]");
        holder.c(bVar, this.f6349b);
    }

    /* renamed from: s */
    public SummaryHistoryViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        j.e(parent, "parent");
        ItemSummaryHistoryBinding binding = (ItemSummaryHistoryBinding) DataBindingUtil.inflate(LayoutInflater.from(this.a), R.layout.item_summary_history, parent, false);
        j.d(binding, "binding");
        SummaryHistoryViewHolder summaryHistoryViewHolder = new SummaryHistoryViewHolder(binding);
        binding.setLifecycleOwner(this.a);
        binding.z.setOnClickListener(new d(summaryHistoryViewHolder));
        binding.z.setOnLongClickListener(new e(summaryHistoryViewHolder));
        binding.f7203d.setOnClickListener(new f(summaryHistoryViewHolder));
        binding.f7202c.setOnClickListener(new g(summaryHistoryViewHolder));
        binding.f7204f.setOnClickListener(new h(summaryHistoryViewHolder));
        return summaryHistoryViewHolder;
    }

    public final void t(boolean z) {
        this.f6351d = z;
        if (z) {
            Iterator<com.tplink.iot.dailysummary.model.b> it = this.f6350c.iterator();
            while (it.hasNext()) {
                com.tplink.iot.dailysummary.model.b next = it.next();
                next.q(true);
                next.p(false);
            }
        } else {
            Iterator<com.tplink.iot.dailysummary.model.b> it2 = this.f6350c.iterator();
            while (it2.hasNext()) {
                com.tplink.iot.dailysummary.model.b next2 = it2.next();
                next2.q(false);
                next2.p(false);
            }
        }
        notifyDataSetChanged();
    }
}
