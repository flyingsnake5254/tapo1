package com.handmark.pulltorefresh.library;

import android.annotation.TargetApi;
import android.view.View;
import com.handmark.pulltorefresh.library.PullToRefreshBase;

/* compiled from: OverscrollHelper.java */
@TargetApi(9)
/* loaded from: classes2.dex */
public final class f {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OverscrollHelper.java */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[PullToRefreshBase.Orientation.values().length];
            a = iArr;
            try {
                iArr[PullToRefreshBase.Orientation.HORIZONTAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[PullToRefreshBase.Orientation.VERTICAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(View view) {
        return view.getOverScrollMode() != 2;
    }

    public static void b(PullToRefreshBase<?> pullToRefreshBase, int i, int i2, int i3, int i4, int i5, int i6, float f2, boolean z) {
        int i7;
        if (a.a[pullToRefreshBase.getPullToRefreshScrollDirection().ordinal()] != 1) {
            i2 = i4;
            i7 = pullToRefreshBase.getScrollY();
            i = i3;
        } else {
            i7 = pullToRefreshBase.getScrollX();
        }
        if (pullToRefreshBase.n() && !pullToRefreshBase.r()) {
            PullToRefreshBase.Mode mode = pullToRefreshBase.getMode();
            if (mode.permitsPullToRefresh() && !z && i != 0) {
                int i8 = i + i2;
                if (i8 < (-i6)) {
                    if (mode.showHeaderLoadingLayout()) {
                        if (i7 == 0) {
                            pullToRefreshBase.E(PullToRefreshBase.State.OVERSCROLLING, new boolean[0]);
                        }
                        pullToRefreshBase.setHeaderScroll((int) (f2 * (i7 + i8)));
                    }
                } else if (i8 > i5 + i6) {
                    if (mode.showFooterLoadingLayout()) {
                        if (i7 == 0) {
                            pullToRefreshBase.E(PullToRefreshBase.State.OVERSCROLLING, new boolean[0]);
                        }
                        pullToRefreshBase.setHeaderScroll((int) (f2 * ((i7 + i8) - i5)));
                    }
                } else if (Math.abs(i8) <= i6 || Math.abs(i8 - i5) <= i6) {
                    pullToRefreshBase.E(PullToRefreshBase.State.RESET, new boolean[0]);
                }
            } else if (z && PullToRefreshBase.State.OVERSCROLLING == pullToRefreshBase.getState()) {
                pullToRefreshBase.E(PullToRefreshBase.State.RESET, new boolean[0]);
            }
        }
    }

    public static void c(PullToRefreshBase<?> pullToRefreshBase, int i, int i2, int i3, int i4, int i5, boolean z) {
        b(pullToRefreshBase, i, i2, i3, i4, i5, 0, 1.0f, z);
    }

    public static void d(PullToRefreshBase<?> pullToRefreshBase, int i, int i2, int i3, int i4, boolean z) {
        c(pullToRefreshBase, i, i2, i3, i4, 0, z);
    }
}
