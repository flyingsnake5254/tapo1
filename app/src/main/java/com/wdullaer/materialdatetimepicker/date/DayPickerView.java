package com.wdullaer.materialdatetimepicker.date;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.NonNull;
import androidx.core.view.GravityCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.libtpmediastatistics.SSLClient;
import com.wdullaer.materialdatetimepicker.GravitySnapHelper;
import com.wdullaer.materialdatetimepicker.d;
import com.wdullaer.materialdatetimepicker.date.MonthAdapter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/* loaded from: classes3.dex */
public abstract class DayPickerView extends RecyclerView implements b {

    /* renamed from: c  reason: collision with root package name */
    private static SimpleDateFormat f15280c = new SimpleDateFormat("yyyy", Locale.getDefault());
    private a H3;
    private LinearLayoutManager I3;
    protected MonthAdapter p0;
    protected MonthAdapter.a p1;
    protected int p2;
    protected Context x;
    protected Handler y;
    protected MonthAdapter.a z;

    /* renamed from: d  reason: collision with root package name */
    protected int f15281d = 6;

    /* renamed from: f  reason: collision with root package name */
    protected boolean f15282f = false;
    protected int q = 7;
    protected int p3 = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f15283c;

        a(int i) {
            this.f15283c = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            ((LinearLayoutManager) DayPickerView.this.getLayoutManager()).scrollToPositionWithOffset(this.f15283c, 0);
        }
    }

    public DayPickerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        e(context);
    }

    private MonthAdapter.a b() {
        MonthView monthView;
        MonthAdapter.a accessibilityFocus;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if ((childAt instanceof MonthView) && (accessibilityFocus = (monthView = (MonthView) childAt).getAccessibilityFocus()) != null) {
                if (Build.VERSION.SDK_INT == 17) {
                    monthView.c();
                }
                return accessibilityFocus;
            }
        }
        return null;
    }

    private static String c(MonthAdapter.a aVar, Locale locale) {
        Calendar instance;
        Calendar.getInstance().set(aVar.f15289b, aVar.f15290c, aVar.f15291d);
        return (("" + instance.getDisplayName(2, 2, locale)) + SSLClient.WHITE_SPACE) + f15280c.format(instance.getTime());
    }

    private int getFirstVisiblePosition() {
        return getChildAdapterPosition(getChildAt(0));
    }

    private boolean i(MonthAdapter.a aVar) {
        if (aVar == null) {
            return false;
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if ((childAt instanceof MonthView) && ((MonthView) childAt).o(aVar)) {
                return true;
            }
        }
        return false;
    }

    public abstract MonthAdapter a(a aVar);

    public boolean d(MonthAdapter.a aVar, boolean z, boolean z2, boolean z3) {
        View childAt;
        if (z2) {
            this.z.a(aVar);
        }
        this.p1.a(aVar);
        int o = (((aVar.f15289b - this.H3.o()) * 12) + aVar.f15290c) - this.H3.p().get(2);
        int i = 0;
        while (true) {
            int i2 = i + 1;
            childAt = getChildAt(i);
            if (childAt == null) {
                break;
            }
            int top = childAt.getTop();
            if (Log.isLoggable("MonthFragment", 3)) {
                StringBuilder sb = new StringBuilder();
                sb.append("child at ");
                sb.append(i2 - 1);
                sb.append(" has top ");
                sb.append(top);
                Log.d("MonthFragment", sb.toString());
            }
            if (top >= 0) {
                break;
            }
            i = i2;
        }
        int childAdapterPosition = childAt != null ? getChildAdapterPosition(childAt) : 0;
        if (z2) {
            this.p0.r(this.z);
        }
        if (Log.isLoggable("MonthFragment", 3)) {
            Log.d("MonthFragment", "GoTo position " + o);
        }
        if (o != childAdapterPosition || z3) {
            setMonthDisplayed(this.p1);
            this.p3 = 1;
            if (z) {
                smoothScrollToPosition(o);
                return true;
            }
            g(o);
        } else if (z2) {
            setMonthDisplayed(this.z);
        }
        return false;
    }

    public void e(Context context) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, this.H3.b() == DatePickerDialog$ScrollOrientation.VERTICAL ? 1 : 0, false);
        this.I3 = linearLayoutManager;
        setLayoutManager(linearLayoutManager);
        this.y = new Handler();
        setLayoutParams(new RecyclerView.LayoutParams(-1, -1));
        setVerticalScrollBarEnabled(false);
        setHorizontalScrollBarEnabled(false);
        this.x = context;
        j();
    }

    public void f() {
        d(this.H3.i(), false, true, true);
    }

    public void g(int i) {
        clearFocus();
        post(new a(i));
    }

    public MonthView getMostVisibleMonth() {
        boolean z = true;
        if (((LinearLayoutManager) getLayoutManager()).getOrientation() != 1) {
            z = false;
        }
        int height = z ? getHeight() : getWidth();
        MonthView monthView = null;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (i < height) {
            View childAt = getChildAt(i2);
            if (childAt == null) {
                break;
            }
            int bottom = z ? childAt.getBottom() : getRight();
            int min = Math.min(bottom, height) - Math.max(0, childAt.getTop());
            if (min > i3) {
                monthView = (MonthView) childAt;
                i3 = min;
            }
            i2++;
            i = bottom;
        }
        return monthView;
    }

    public int getMostVisiblePosition() {
        return getChildAdapterPosition(getMostVisibleMonth());
    }

    protected void h() {
        MonthAdapter monthAdapter = this.p0;
        if (monthAdapter == null) {
            this.p0 = a(this.H3);
        } else {
            monthAdapter.r(this.z);
        }
        setAdapter(this.p0);
    }

    protected void j() {
        setVerticalScrollBarEnabled(false);
        setFadingEdgeLength(0);
        new GravitySnapHelper(this.H3.b() == DatePickerDialog$ScrollOrientation.VERTICAL ? 48 : GravityCompat.START).attachToRecyclerView(this);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(@NonNull AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setItemCount(-1);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        if (Build.VERSION.SDK_INT >= 21) {
            accessibilityNodeInfo.addAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_BACKWARD);
            accessibilityNodeInfo.addAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_FORWARD);
            return;
        }
        accessibilityNodeInfo.addAction(4096);
        accessibilityNodeInfo.addAction(8192);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        i(b());
    }

    @Override // android.view.View
    @SuppressLint({"NewApi"})
    public boolean performAccessibilityAction(int i, Bundle bundle) {
        View childAt;
        if (i != 4096 && i != 8192) {
            return super.performAccessibilityAction(i, bundle);
        }
        int firstVisiblePosition = getFirstVisiblePosition() + this.H3.p().get(2);
        MonthAdapter.a aVar = new MonthAdapter.a((firstVisiblePosition / 12) + this.H3.o(), firstVisiblePosition % 12, 1, this.H3.m());
        if (i == 4096) {
            int i2 = aVar.f15290c + 1;
            aVar.f15290c = i2;
            if (i2 == 12) {
                aVar.f15290c = 0;
                aVar.f15289b++;
            }
        } else if (i == 8192 && (childAt = getChildAt(0)) != null && childAt.getTop() >= -1) {
            int i3 = aVar.f15290c - 1;
            aVar.f15290c = i3;
            if (i3 == -1) {
                aVar.f15290c = 11;
                aVar.f15289b--;
            }
        }
        d.b(this, c(aVar, this.H3.c()));
        d(aVar, true, false, true);
        return true;
    }

    public void setController(a aVar) {
        this.H3 = aVar;
        aVar.d(this);
        this.z = new MonthAdapter.a(this.H3.m());
        this.p1 = new MonthAdapter.a(this.H3.m());
        f15280c = new SimpleDateFormat("yyyy", aVar.c());
        h();
        f();
    }

    protected void setMonthDisplayed(MonthAdapter.a aVar) {
        this.p2 = aVar.f15290c;
    }

    public void setScrollOrientation(int i) {
        this.I3.setOrientation(i);
    }
}
