package com.tplink.iot.widget.springview.widget;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.WebView;
import android.widget.ListView;
import android.widget.ScrollView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.AppBarLayout;

/* compiled from: SpringHelper.java */
/* loaded from: classes3.dex */
class a {
    public static boolean a(AppBarLayout appBarLayout) {
        if (appBarLayout == null) {
            return false;
        }
        for (int i = 0; i < appBarLayout.getChildCount(); i++) {
            if (b(appBarLayout.getChildAt(i))) {
                return true;
            }
        }
        return false;
    }

    private static boolean b(View view) {
        if (view.getLayoutParams() instanceof AppBarLayout.LayoutParams) {
            return (((AppBarLayout.LayoutParams) view.getLayoutParams()).getScrollFlags() & 1) == 1;
        }
        b.d.w.c.a.e("SpringView", "view检查出现异常");
        return false;
    }

    public static AppBarLayout c(View view) {
        ViewParent parent = view.getParent();
        while (parent != null && !(parent instanceof CoordinatorLayout)) {
            parent = parent.getParent();
        }
        if (parent instanceof CoordinatorLayout) {
            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) parent;
            for (int childCount = coordinatorLayout.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = coordinatorLayout.getChildAt(childCount);
                if (childAt instanceof AppBarLayout) {
                    return (AppBarLayout) childAt;
                }
            }
        }
        return null;
    }

    public static View d(View view) {
        if (e(view)) {
            return view;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                View d2 = d(viewGroup.getChildAt(i));
                if (d2 != null) {
                    return d2;
                }
            }
        }
        return null;
    }

    public static boolean e(View view) {
        return (view instanceof ListView) || (view instanceof ScrollView) || (view instanceof NestedScrollView) || (view instanceof RecyclerView) || (view instanceof WebView) || view.canScrollVertically(-1) || view.canScrollVertically(1);
    }
}
