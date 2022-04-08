package com.tplink.iot.base;

import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.base.BaseAdapter;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public abstract class BaseAdapter<T> extends RecyclerView.Adapter<VH> {
    private List<T> a;

    /* loaded from: classes2.dex */
    public static class VH extends RecyclerView.ViewHolder {
        private SparseArray<View> a = new SparseArray<>();

        /* renamed from: b  reason: collision with root package name */
        private View f6074b;

        private VH(View view) {
            super(view);
            this.f6074b = view;
        }

        public static VH c(ViewGroup viewGroup, int i) {
            return new VH(LayoutInflater.from(viewGroup.getContext()).inflate(i, viewGroup, false));
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: e */
        public /* synthetic */ void f(a aVar, View view) {
            aVar.A0(getLayoutPosition(), view);
        }

        /* JADX WARN: Incorrect return type in method signature: <T:Landroid/view/View;>(ILcom/tplink/iot/base/BaseAdapter$a;)TT; */
        public View d(int i, final a aVar) {
            View view = this.a.get(i);
            if (view == null) {
                view = this.f6074b.findViewById(i);
                if (aVar != null) {
                    view.setOnClickListener(new View.OnClickListener() { // from class: com.tplink.iot.base.a
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view2) {
                            BaseAdapter.VH.this.f(aVar, view2);
                        }
                    });
                }
                this.a.put(i, view);
            }
            return view;
        }
    }

    /* loaded from: classes2.dex */
    public interface a {
        <T> void A0(int i, View view);
    }

    public BaseAdapter(List<T> list) {
        this.a = list;
    }

    public T getItem(int i) {
        if (this.a == null) {
            this.a = new ArrayList();
        }
        return this.a.get(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.a.size();
    }

    public void m(List<T> list) {
        if (this.a == null) {
            this.a = new ArrayList();
        }
        int size = this.a.size();
        this.a.addAll(list);
        notifyItemRangeInserted(size, list.size());
    }

    public abstract void n(VH vh, T t, int i);

    public abstract int o(int i);

    /* renamed from: p */
    public void onBindViewHolder(VH vh, int i) {
        n(vh, this.a.get(i), i);
    }

    /* renamed from: q */
    public VH onCreateViewHolder(ViewGroup viewGroup, int i) {
        return VH.c(viewGroup, o(i));
    }
}
