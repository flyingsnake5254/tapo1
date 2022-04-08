package com.tplink.iot.adapter.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.collections.n;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.q;

/* compiled from: Adapter.kt */
/* loaded from: classes2.dex */
public class DataBindingListAdapter extends RecyclerView.Adapter<ViewHolder> {

    /* renamed from: f  reason: collision with root package name */
    private View f5436f;
    private View g;
    private ArrayList<?> j;
    private int k;
    private int[] l;
    private LifecycleOwner m;
    private final int n;
    private final int[] o;
    private final int[] p;
    private final Object[] q;

    /* renamed from: c  reason: collision with root package name */
    public static final a f5433c = new a(null);
    private static int a = a.f5447f;

    /* renamed from: b  reason: collision with root package name */
    private static int f5432b = a.a;

    /* renamed from: d  reason: collision with root package name */
    private final int f5434d = 2147483645;

    /* renamed from: e  reason: collision with root package name */
    private final int f5435e = 2147483644;
    private final MutableLiveData<Integer> h = new MutableLiveData<>();
    private ArrayList<Object> i = new ArrayList<>();

    /* compiled from: Adapter.kt */
    /* loaded from: classes2.dex */
    public static final class ViewHolder extends RecyclerView.ViewHolder {
        private final ViewDataBinding a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(ViewDataBinding dataBinding) {
            super(dataBinding.getRoot());
            j.e(dataBinding, "dataBinding");
            this.a = dataBinding;
        }

        public final ViewDataBinding c() {
            return this.a;
        }
    }

    /* compiled from: Adapter.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public final int a() {
            return DataBindingListAdapter.f5432b;
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    public DataBindingListAdapter(int i, int[] variableIds, int[] identifyIds, Object... variable) {
        ArrayList<?> c2;
        j.e(variableIds, "variableIds");
        j.e(identifyIds, "identifyIds");
        j.e(variable, "variable");
        this.n = i;
        this.o = variableIds;
        this.p = identifyIds;
        this.q = variable;
        c2 = n.c(Arrays.copyOf(variable, variable.length));
        this.j = c2;
        j.c(c2);
        g.f(c2, this.i);
        if (identifyIds.length == 0) {
            int length = variableIds.length;
            int[] iArr = new int[length];
            for (int i2 = 0; i2 < length; i2++) {
                iArr[i2] = i2;
            }
            this.l = iArr;
        } else {
            this.l = new int[identifyIds.length];
            int length2 = identifyIds.length;
            for (int i3 = 0; i3 < length2; i3++) {
                int[] iArr2 = this.l;
                int[] iArr3 = this.o;
                int length3 = iArr3.length;
                int i4 = 0;
                while (true) {
                    if (i4 >= length3) {
                        i4 = -1;
                        break;
                    }
                    if (iArr3[i4] == this.p[i3]) {
                        break;
                    }
                    i4++;
                }
                iArr2[i3] = i4;
            }
        }
        registerAdapterDataObserver(new RecyclerView.AdapterDataObserver() { // from class: com.tplink.iot.adapter.databinding.DataBindingListAdapter.3
            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onChanged() {
                super.onChanged();
                DataBindingListAdapter.this.n();
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeChanged(int i5, int i6) {
                super.onItemRangeChanged(i5, i6);
                DataBindingListAdapter.this.n();
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeInserted(int i5, int i6) {
                super.onItemRangeInserted(i5, i6);
                DataBindingListAdapter.this.n();
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeMoved(int i5, int i6, int i7) {
                super.onItemRangeMoved(i5, i6, i7);
                DataBindingListAdapter.this.n();
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeRemoved(int i5, int i6) {
                super.onItemRangeRemoved(i5, i6);
                DataBindingListAdapter.this.n();
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeChanged(int i5, int i6, Object obj) {
                super.onItemRangeChanged(i5, i6, obj);
                DataBindingListAdapter.this.n();
            }
        });
        t();
    }

    private final boolean o() {
        return this.f5436f != null;
    }

    private final boolean p() {
        return this.g != null;
    }

    private final boolean q(int i) {
        return o() && i == getItemCount() - 1;
    }

    private final boolean r(int i) {
        return p() && i == 0;
    }

    private final void t() {
        this.k = 0;
        for (int i : this.l) {
            int d2 = g.d(this.i.get(i));
            if (d2 > this.k) {
                this.k = d2;
            }
        }
    }

    private final void z(RecyclerView.ViewHolder viewHolder) {
        View view = viewHolder.itemView;
        j.d(view, "holder.itemView");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof StaggeredGridLayoutManager.LayoutParams) {
            ((StaggeredGridLayoutManager.LayoutParams) layoutParams).setFullSpan(true);
        }
    }

    public final void A(View view) {
        char c2;
        View view2 = this.g;
        if (view2 == null && view != null) {
            c2 = 1;
        } else if (view2 != null && view == null) {
            c2 = 65535;
        } else if (view2 != null || view != null) {
            c2 = 0;
        } else {
            return;
        }
        this.g = view;
        if (c2 == 1) {
            notifyItemInserted(0);
        } else if (c2 == 65535) {
            notifyItemRemoved(0);
        } else {
            notifyItemChanged(0);
        }
        if (c2 == 1) {
            this.h.setValue(1);
        } else if (c2 == 65535) {
            this.h.setValue(0);
        }
    }

    public final void B(LifecycleOwner lifecycleOwner) {
        j.e(lifecycleOwner, "lifecycleOwner");
        this.m = lifecycleOwner;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        boolean p = p();
        return (p ? 1 : 0) + this.k + (o() ? 1 : 0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        return r(i) ? this.f5435e : q(i) ? this.f5434d : super.getItemViewType(i);
    }

    public final void n() {
        int hashCode = this.i.hashCode();
        ArrayList<?> arrayList = this.j;
        if (hashCode != (arrayList != null ? arrayList.hashCode() : 0)) {
            ArrayList<?> arrayList2 = this.j;
            j.c(arrayList2);
            g.f(arrayList2, this.i);
            t();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void registerAdapterDataObserver(RecyclerView.AdapterDataObserver observer) {
        j.e(observer, "observer");
        super.registerAdapterDataObserver(new DislocationNotifyObserver(observer, this.h));
    }

    public final void s() {
        ArrayList<Object> arrayList = this.i;
        ArrayList<?> arrayList2 = this.j;
        j.c(arrayList2);
        DiffUtil.DiffResult calculateDiff = DiffUtil.calculateDiff(new DiffCallBack(arrayList, arrayList2, this.l), true);
        j.d(calculateDiff, "DiffUtil.calculateDiff(\n…           true\n        )");
        n();
        calculateDiff.dispatchUpdatesTo(this);
    }

    /* renamed from: u */
    public void onBindViewHolder(ViewHolder holder, int i) {
        j.e(holder, "holder");
        if (!r(i) && !q(i)) {
            int i2 = i - (p() ? 1 : 0);
            if (f5432b != -1) {
                holder.c().setVariable(f5432b, Integer.valueOf(i2));
            }
            int length = this.o.length;
            for (int i3 = 0; i3 < length; i3++) {
                holder.c().setVariable(this.o[i3], g.c(this.i.get(i3), i2));
            }
            holder.c().executePendingBindings();
        }
    }

    /* renamed from: v */
    public void onBindViewHolder(ViewHolder holder, int i, List<Object> payloads) {
        j.e(holder, "holder");
        j.e(payloads, "payloads");
        if (payloads.isEmpty()) {
            onBindViewHolder(holder, i);
            return;
        }
        int i2 = i - (p() ? 1 : 0);
        Object obj = payloads.get(0);
        Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlin.collections.MutableMap<*, *>");
        Map a2 = q.a(obj);
        int length = this.o.length;
        for (int i3 = 0; i3 < length; i3++) {
            if (j.a(a2.get(Integer.valueOf(i3)), Boolean.TRUE)) {
                holder.c().setVariable(this.o[i3], g.c(this.i.get(i3), i2));
            }
        }
        int i4 = f5432b;
        if (i4 != -1 && j.a(a2.get(Integer.valueOf(i4)), Boolean.TRUE)) {
            holder.c().setVariable(f5432b, Integer.valueOf(i2));
        }
    }

    /* renamed from: w */
    public ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        ViewHolder viewHolder;
        j.e(parent, "parent");
        if (i == this.f5435e) {
            if (this.g != null) {
                View view = this.g;
                j.c(view);
                ViewDataBinding bind = DataBindingUtil.bind(view);
                j.c(bind);
                viewHolder = new ViewHolder(bind);
            } else {
                throw new RuntimeException("HeaderView is Null!!");
            }
        } else if (i != this.f5434d) {
            ViewDataBinding inflate = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), this.n, parent, false);
            j.d(inflate, "DataBindingUtil.inflate(…lse\n                    )");
            LifecycleOwner lifecycleOwner = this.m;
            if (lifecycleOwner != null) {
                inflate.setLifecycleOwner(lifecycleOwner);
            }
            viewHolder = new ViewHolder(inflate);
        } else if (this.f5436f != null) {
            View view2 = this.f5436f;
            j.c(view2);
            ViewDataBinding bind2 = DataBindingUtil.bind(view2);
            j.c(bind2);
            viewHolder = new ViewHolder(bind2);
        } else {
            throw new RuntimeException("FooterView is Null!!");
        }
        if (a != -1) {
            viewHolder.c().setVariable(a, viewHolder);
        }
        return viewHolder;
    }

    /* renamed from: x */
    public void onViewAttachedToWindow(ViewHolder holder) {
        j.e(holder, "holder");
        super.onViewAttachedToWindow(holder);
        if (q(holder.getLayoutPosition())) {
            z(holder);
        }
    }

    public final void y(View view) {
        View view2 = this.f5436f;
        char c2 = (view2 != null || view == null) ? (view2 == null || view != null) ? (char) 0 : (char) 65535 : (char) 1;
        this.f5436f = view;
        if (c2 == 1) {
            notifyItemInserted(getItemCount() - 1);
        } else if (c2 == 65535) {
            notifyItemRemoved(getItemCount() - 1);
        } else {
            notifyItemChanged(getItemCount() - 1);
        }
    }
}
