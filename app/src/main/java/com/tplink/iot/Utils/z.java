package com.tplink.iot.Utils;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: RecyclerScrollUtils.java */
/* loaded from: classes2.dex */
public class z {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RecyclerScrollUtils.java */
    /* loaded from: classes2.dex */
    public static class a extends RecyclerView.OnScrollListener {
        final /* synthetic */ int a;

        a(int i) {
            this.a = i;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            if (i == 0) {
                recyclerView.removeOnScrollListener(this);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(@NonNull RecyclerView recyclerView, int i, int i2) {
            if (recyclerView.getLayoutManager().findViewByPosition(this.a) != null) {
                z.a(recyclerView, this.a);
                recyclerView.removeOnScrollListener(this);
            }
        }
    }

    public static void a(RecyclerView recyclerView, int i) {
        int childLayoutPosition = recyclerView.getChildLayoutPosition(recyclerView.getChildAt(0));
        int childLayoutPosition2 = recyclerView.getChildLayoutPosition(recyclerView.getChildAt(recyclerView.getChildCount() - 1));
        if (i < childLayoutPosition) {
            recyclerView.smoothScrollToPosition(i);
        } else if (i <= childLayoutPosition2) {
            int i2 = i - childLayoutPosition;
            if (i2 >= 0 && i2 < recyclerView.getChildCount()) {
                recyclerView.smoothScrollBy(0, recyclerView.getChildAt(i2).getTop());
            }
        } else {
            recyclerView.smoothScrollToPosition(i);
            recyclerView.addOnScrollListener(new a(i));
        }
    }
}
