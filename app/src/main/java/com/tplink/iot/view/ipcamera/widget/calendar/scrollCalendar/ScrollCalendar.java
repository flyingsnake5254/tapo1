package com.tplink.iot.view.ipcamera.widget.calendar.scrollCalendar;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;
import com.tplink.iot.R;
import com.tplink.iot.b;
import com.tplink.iot.view.ipcamera.widget.calendar.c;
import com.tplink.iot.view.ipcamera.widget.calendar.d;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.TimeZone;

/* loaded from: classes2.dex */
public class ScrollCalendar extends FrameLayout implements ViewPager.OnPageChangeListener {

    /* renamed from: c  reason: collision with root package name */
    private ScrollCalendarViewPager f9350c;

    /* renamed from: d  reason: collision with root package name */
    private a f9351d;

    /* renamed from: f  reason: collision with root package name */
    private TimeZone f9352f;
    private d q;
    private c x;
    private int y;
    private a z;

    /* loaded from: classes2.dex */
    private enum a {
        HIDDEN,
        SHOWN
    }

    public ScrollCalendar(Context context) {
        this(context, null);
    }

    private int a(d dVar) {
        return 99 - (((this.q.e() - dVar.e()) * 12) + (this.q.d() - dVar.d()));
    }

    private void b(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b.ScrollCalendar);
            obtainStyledAttributes.getColor(4, ContextCompat.getColor(getContext(), R.color.background_black));
            obtainStyledAttributes.getColor(5, ContextCompat.getColor(getContext(), R.color.background_black));
            int color = obtainStyledAttributes.getColor(0, ContextCompat.getColor(context, R.color.playback_calender_day));
            int color2 = obtainStyledAttributes.getColor(2, ContextCompat.getColor(context, R.color.playback_calender_invalid_day));
            boolean z = obtainStyledAttributes.getBoolean(3, false);
            boolean z2 = obtainStyledAttributes.getBoolean(1, false);
            this.f9351d.c(color);
            this.f9351d.h(color2);
            this.f9351d.g(z);
            this.f9351d.d(z2);
            obtainStyledAttributes.recycle();
        }
    }

    private void c(Context context) {
        this.f9350c = (ScrollCalendarViewPager) LayoutInflater.from(context).inflate(R.layout.widget_scroll_calendar, (ViewGroup) this, true).findViewById(R.id.widget_scroll_calendar_view_pager);
        a aVar = new a(getContext());
        this.f9351d = aVar;
        this.f9350c.setAdapter(aVar);
        this.f9350c.addOnPageChangeListener(this);
        this.f9350c.setCurrentItem(99);
    }

    public void d(Calendar calendar) {
        this.y = 99;
        this.f9351d.j(calendar, 99);
        this.f9350c.setCurrentItem(this.y);
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f2, int i2) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        d a2;
        if (this.y != i) {
            this.y = i;
            if (this.x != null && (a2 = this.f9351d.a(i)) != null) {
                this.x.M0(a2.clone());
            }
        }
    }

    public void setCurrentDate(d dVar) {
        this.q = dVar;
        this.f9351d.b(dVar);
        this.y = 99;
    }

    public void setMarkDays(List<d> list) {
        if (list != null) {
            HashMap hashMap = new HashMap();
            for (d dVar : list) {
                String valueOf = String.valueOf(a(dVar));
                List list2 = (List) hashMap.get(valueOf);
                if (list2 == null) {
                    list2 = new ArrayList();
                }
                list2.add(Integer.valueOf(dVar.c()));
                hashMap.put(valueOf, list2);
            }
            this.f9351d.f(hashMap);
            return;
        }
        this.f9351d.f(null);
    }

    public void setMonthDateClickListener(com.tplink.iot.view.ipcamera.widget.calendar.b bVar) {
        this.f9351d.e(bVar);
    }

    public void setOnMonthSelectedListener(c cVar) {
        this.x = cVar;
    }

    public void setSelectMonth(d dVar) {
        int a2 = a(dVar);
        this.y = a2;
        this.f9350c.setCurrentItem(a2);
    }

    public void setSelectedDay(d dVar) {
        if (dVar != null) {
            if (this.q == null) {
                this.q = new d(dVar.e(), dVar.d(), dVar.c());
            }
            int a2 = a(dVar);
            this.y = a2;
            this.f9351d.i(dVar, a2);
            this.f9350c.setCurrentItem(this.y);
        }
    }

    public ScrollCalendar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        c(context);
        b(context, attributeSet);
    }

    public ScrollCalendar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f9352f = TimeZone.getDefault();
        this.z = a.HIDDEN;
        c(context);
        b(context, attributeSet);
    }
}
