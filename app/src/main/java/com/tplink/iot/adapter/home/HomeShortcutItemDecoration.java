package com.tplink.iot.adapter.home;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.Utils.j;

/* loaded from: classes2.dex */
public class HomeShortcutItemDecoration extends RecyclerView.ItemDecoration {
    private int a;

    public HomeShortcutItemDecoration(Context context) {
        this.a = j.a(context, 16.0f);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        if (recyclerView.getChildAdapterPosition(view) == 0) {
            rect.left = this.a;
        }
    }
}
