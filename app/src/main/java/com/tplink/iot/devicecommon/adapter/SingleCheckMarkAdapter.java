package com.tplink.iot.devicecommon.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.R;
import java.util.List;
import kotlin.collections.l;
import kotlin.jvm.b.q;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.j;
import kotlin.p;

/* compiled from: SingleCheckMarkAdapter.kt */
/* loaded from: classes2.dex */
public abstract class SingleCheckMarkAdapter<T> extends RecyclerView.Adapter<SingleCheckMarkViewHolder> {
    private final LayoutInflater a;

    /* renamed from: b  reason: collision with root package name */
    private int f7368b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f7369c;

    /* renamed from: d  reason: collision with root package name */
    private q<? super T, ? super Integer, ? super Boolean, p> f7370d;

    /* renamed from: e  reason: collision with root package name */
    private final Context f7371e;

    /* renamed from: f  reason: collision with root package name */
    private final List<T> f7372f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SingleCheckMarkAdapter.kt */
    /* loaded from: classes2.dex */
    public static final class a implements View.OnClickListener {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ int f7374d;

        a(int i) {
            this.f7374d = i;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            SingleCheckMarkAdapter singleCheckMarkAdapter = SingleCheckMarkAdapter.this;
            singleCheckMarkAdapter.o(singleCheckMarkAdapter.s(), this.f7374d, true);
        }
    }

    public /* synthetic */ SingleCheckMarkAdapter(Context context, List list, int i, int i2, f fVar) {
        this(context, list, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o(int i, int i2, boolean z) {
        if (this.f7369c || i != i2) {
            int size = this.f7372f.size();
            if (i2 >= 0 && size > i2) {
                this.f7368b = i2;
                notifyItemChanged(i);
                notifyItemChanged(i2);
                q<? super T, ? super Integer, ? super Boolean, p> qVar = this.f7370d;
                if (qVar != null) {
                    qVar.invoke((T) this.f7372f.get(this.f7368b), Integer.valueOf(this.f7368b), Boolean.valueOf(z));
                }
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f7372f.size();
    }

    public abstract void n(SingleCheckMarkViewHolder singleCheckMarkViewHolder, T t, int i);

    /* JADX INFO: Access modifiers changed from: protected */
    public final Context p() {
        return this.f7371e;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final List<T> q() {
        return this.f7372f;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final LayoutInflater r() {
        return this.a;
    }

    protected final int s() {
        return this.f7368b;
    }

    public final T t() {
        return this.f7372f.get(this.f7368b);
    }

    public final T u() {
        return (T) l.z(this.f7372f, this.f7368b);
    }

    /* renamed from: v */
    public void onBindViewHolder(SingleCheckMarkViewHolder holder, int i) {
        j.e(holder, "holder");
        n(holder, this.f7372f.get(i), i);
        holder.c().setVisibility(i == this.f7368b ? 0 : 4);
        holder.itemView.setOnClickListener(new a(i));
    }

    /* renamed from: w */
    public SingleCheckMarkViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        j.e(parent, "parent");
        View inflate = this.a.inflate(R.layout.item_single_check_mark, parent, false);
        j.d(inflate, "mInflater.inflate(R.layo…heck_mark, parent, false)");
        return new SingleCheckMarkViewHolder(inflate);
    }

    public final void x(boolean z) {
        this.f7369c = z;
    }

    public final void y(q<? super T, ? super Integer, ? super Boolean, p> action) {
        j.e(action, "action");
        this.f7370d = action;
    }

    public final void z(int i) {
        o(this.f7368b, i, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SingleCheckMarkAdapter(Context mContext, List<? extends T> mDataList, int i) {
        j.e(mContext, "mContext");
        j.e(mDataList, "mDataList");
        this.f7371e = mContext;
        this.f7372f = mDataList;
        this.a = LayoutInflater.from(mContext);
        this.f7368b = (i < 0 || mDataList.size() <= i) ? 0 : i;
    }
}
