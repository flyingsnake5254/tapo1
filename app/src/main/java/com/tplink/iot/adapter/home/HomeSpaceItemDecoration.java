package com.tplink.iot.adapter.home;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.Utils.j;

/* loaded from: classes2.dex */
public class HomeSpaceItemDecoration extends RecyclerView.ItemDecoration {
    private int a;

    public HomeSpaceItemDecoration(Context context) {
        this.a = j.a(context, 5.0f);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        int i = this.a;
        rect.left = i;
        rect.right = i;
    }
}
