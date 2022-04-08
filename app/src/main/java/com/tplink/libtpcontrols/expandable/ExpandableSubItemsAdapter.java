package com.tplink.libtpcontrols.expandable;

import android.animation.ValueAnimator;
import android.util.Log;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.LinearInterpolator;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes3.dex */
public class ExpandableSubItemsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final String a = "ExpandableSubItemsAdapter";

    /* renamed from: b  reason: collision with root package name */
    private boolean f12232b = false;

    /* renamed from: c  reason: collision with root package name */
    private boolean f12233c = false;

    /* renamed from: d  reason: collision with root package name */
    private boolean f12234d = false;

    /* renamed from: e  reason: collision with root package name */
    private boolean f12235e = true;

    /* renamed from: f  reason: collision with root package name */
    private int f12236f;
    private ViewGroup g;
    private RecyclerView.Adapter h;

    /* loaded from: classes3.dex */
    class a implements ViewTreeObserver.OnPreDrawListener {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ RecyclerView.ViewHolder f12237c;

        a(RecyclerView.ViewHolder viewHolder) {
            this.f12237c = viewHolder;
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            if (!ExpandableSubItemsAdapter.this.f12234d && !ExpandableSubItemsAdapter.this.p()) {
                this.f12237c.itemView.getLayoutParams().height = 1;
                ExpandableSubItemsAdapter.this.g.setVisibility(8);
                this.f12237c.itemView.getViewTreeObserver().removeOnPreDrawListener(this);
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ExpandableSubItemsAdapter(RecyclerView.Adapter adapter) {
        this.h = adapter;
    }

    private void o(final RecyclerView.ViewHolder viewHolder, final int i) {
        if (this.f12232b || this.f12233c) {
            viewHolder.itemView.measure(-1, -2);
            b.d.w.c.a.d("targetHeight = 280");
            if (this.f12235e) {
                ValueAnimator ofInt = this.f12232b ? ValueAnimator.ofInt(0, 280) : ValueAnimator.ofInt(280, 0);
                ofInt.setInterpolator(new LinearInterpolator());
                ofInt.setDuration(this.f12236f);
                ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tplink.libtpcontrols.expandable.d
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        ExpandableSubItemsAdapter.this.r(i, viewHolder, valueAnimator);
                    }
                });
                ofInt.start();
            } else if (this.f12232b) {
                viewHolder.itemView.getLayoutParams().height = 280;
                this.g.requestLayout();
                if (i == getItemCount() - 1) {
                    this.f12232b = false;
                }
            } else if (this.f12233c) {
                viewHolder.itemView.getLayoutParams().height = 0;
                this.g.requestLayout();
                if (i == getItemCount() - 1) {
                    this.f12233c = false;
                    this.f12234d = false;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: q */
    public /* synthetic */ void r(int i, RecyclerView.ViewHolder viewHolder, ValueAnimator valueAnimator) {
        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        if (this.f12232b) {
            if (intValue == 0) {
                intValue = 1;
            }
            if (intValue == 280 && i == getItemCount() - 1) {
                this.f12232b = false;
            }
        } else if (this.f12233c) {
            if (intValue == 280) {
                intValue = 279;
            }
            if (intValue == 0 && i == getItemCount() - 1) {
                this.f12233c = false;
                this.f12234d = false;
                this.g.setVisibility(8);
            }
        }
        viewHolder.itemView.getLayoutParams().height = intValue;
        this.g.requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.h.getItemCount();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        Log.i(a, "onBindViewHolder");
        if (!this.f12234d && !p()) {
            viewHolder.itemView.getViewTreeObserver().addOnPreDrawListener(new a(viewHolder));
        }
        o(viewHolder, i);
        this.h.onBindViewHolder(viewHolder, i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (this.g == null) {
            this.g = viewGroup;
        }
        return this.h.onCreateViewHolder(viewGroup, i);
    }

    boolean p() {
        return this.f12233c || this.f12232b;
    }
}
