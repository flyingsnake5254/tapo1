package com.tplink.libtpcontrols.recycleviewpager;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: ViewUtils.java */
/* loaded from: classes3.dex */
public class a {
    public static View a(RecyclerView recyclerView) {
        int childCount = recyclerView.getChildCount();
        if (childCount <= 0) {
            return null;
        }
        for (int i = 0; i < childCount; i++) {
            View childAt = recyclerView.getChildAt(i);
            if (e(recyclerView, childAt)) {
                return childAt;
            }
        }
        return null;
    }

    public static int b(RecyclerView recyclerView) {
        int childCount = recyclerView.getChildCount();
        if (childCount > 0) {
            for (int i = 0; i < childCount; i++) {
                View childAt = recyclerView.getChildAt(i);
                if (e(recyclerView, childAt)) {
                    return recyclerView.getChildAdapterPosition(childAt);
                }
            }
        }
        return childCount;
    }

    public static View c(RecyclerView recyclerView) {
        int childCount = recyclerView.getChildCount();
        if (childCount <= 0) {
            return null;
        }
        for (int i = 0; i < childCount; i++) {
            View childAt = recyclerView.getChildAt(i);
            if (f(recyclerView, childAt)) {
                return childAt;
            }
        }
        return null;
    }

    public static int d(RecyclerView recyclerView) {
        int childCount = recyclerView.getChildCount();
        if (childCount > 0) {
            for (int i = 0; i < childCount; i++) {
                View childAt = recyclerView.getChildAt(i);
                if (f(recyclerView, childAt)) {
                    return recyclerView.getChildAdapterPosition(childAt);
                }
            }
        }
        return childCount;
    }

    public static boolean e(RecyclerView recyclerView, View view) {
        int childCount = recyclerView.getChildCount();
        int[] iArr = new int[2];
        int[] iArr2 = new int[2];
        recyclerView.getLocationOnScreen(iArr);
        int width = iArr[0] + (recyclerView.getWidth() / 2);
        if (childCount <= 0) {
            return false;
        }
        view.getLocationOnScreen(iArr2);
        return iArr2[0] <= width && iArr2[0] + view.getWidth() >= width;
    }

    public static boolean f(RecyclerView recyclerView, View view) {
        int childCount = recyclerView.getChildCount();
        int[] iArr = new int[2];
        int[] iArr2 = new int[2];
        recyclerView.getLocationOnScreen(iArr);
        int height = iArr[1] + (recyclerView.getHeight() / 2);
        if (childCount <= 0) {
            return false;
        }
        view.getLocationOnScreen(iArr2);
        return iArr2[1] <= height && iArr2[1] + view.getHeight() >= height;
    }
}
