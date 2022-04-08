package com.tplink.iot.devicecommon.adapter;

import android.util.SparseArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.R;
import kotlin.jvm.internal.j;

/* compiled from: SingleCheckMarkAdapter.kt */
/* loaded from: classes2.dex */
public final class SingleCheckMarkViewHolder extends RecyclerView.ViewHolder {
    private final TextView a;

    /* renamed from: b  reason: collision with root package name */
    private final ImageView f7375b;

    /* renamed from: c  reason: collision with root package name */
    private final SparseArray<View> f7376c = new SparseArray<>();

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SingleCheckMarkViewHolder(View view) {
        super(view);
        j.e(view, "view");
        View findViewById = this.itemView.findViewById(R.id.tv_title);
        j.d(findViewById, "itemView.findViewById(R.id.tv_title)");
        this.a = (TextView) findViewById;
        View findViewById2 = this.itemView.findViewById(R.id.iv_check);
        j.d(findViewById2, "itemView.findViewById(R.id.iv_check)");
        this.f7375b = (ImageView) findViewById2;
    }

    public final ImageView c() {
        return this.f7375b;
    }

    public final TextView d() {
        return this.a;
    }

    public final <T extends View> T e(int i) {
        T t = (T) this.f7376c.get(i);
        if (t == null) {
            t = (T) this.itemView.findViewById(i);
            if (t != null) {
                this.f7376c.put(i, t);
            } else {
                t = null;
            }
        }
        if (!(t instanceof View)) {
            return null;
        }
        return t;
    }
}
