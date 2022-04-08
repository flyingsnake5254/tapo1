package com.tplink.iot.view.ipcamera.widget.calendar.scrollCalendar;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.PagerAdapter;
import com.tplink.iot.R;
import com.tplink.iot.view.ipcamera.widget.calendar.MonthDateView;
import com.tplink.iot.view.ipcamera.widget.calendar.b;
import com.tplink.iot.view.ipcamera.widget.calendar.d;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: ScrollCalendarAdapter.java */
/* loaded from: classes2.dex */
class a extends PagerAdapter {
    private Context a;

    /* renamed from: e  reason: collision with root package name */
    private d f9359e;

    /* renamed from: f  reason: collision with root package name */
    private d f9360f;
    private int g;
    private b h;
    private Calendar j;
    private int l;
    private int m;
    private boolean i = true;

    /* renamed from: b  reason: collision with root package name */
    private Map<String, d> f9356b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    private Map<String, MonthDateView> f9357c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    private Map<String, List<Integer>> f9358d = new HashMap();
    private boolean k = false;
    private boolean n = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(Context context) {
        this.a = context;
        this.l = ContextCompat.getColor(context, R.color.playback_calender_day);
        this.m = ContextCompat.getColor(context, R.color.playback_calender_invalid_day);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d a(int i) {
        return this.f9356b.get(String.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(d dVar) {
        this.g = 99;
        this.f9360f = dVar;
        this.f9359e = dVar;
        this.f9356b.clear();
        this.f9356b.put(String.valueOf(this.g), this.f9360f);
    }

    public void c(int i) {
        this.l = i;
    }

    public void d(boolean z) {
        this.k = z;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        String valueOf = String.valueOf(i);
        MonthDateView remove = this.f9357c.remove(valueOf);
        if (remove != null) {
            remove.setMonthDateClickListener(null);
            viewGroup.removeView(remove);
        }
        this.f9356b.remove(valueOf);
    }

    public void e(b bVar) {
        this.h = bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(Map<String, List<Integer>> map) {
        if (map == null) {
            this.f9358d.clear();
        } else {
            this.f9358d = map;
            for (Map.Entry<String, List<Integer>> entry : map.entrySet()) {
                MonthDateView monthDateView = this.f9357c.get(entry.getKey());
                if (monthDateView != null) {
                    monthDateView.setMarkedDays(entry.getValue());
                }
            }
        }
        notifyDataSetChanged();
    }

    public void g(boolean z) {
        this.n = z;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return 100;
    }

    public void h(int i) {
        this.m = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(d dVar, int i) {
        this.g = i;
        this.f9360f = dVar.clone();
        this.f9356b.put(String.valueOf(i), dVar);
        String valueOf = String.valueOf(i);
        for (Map.Entry<String, MonthDateView> entry : this.f9357c.entrySet()) {
            String key = entry.getKey();
            MonthDateView monthDateView = this.f9357c.get(key);
            if (monthDateView != null) {
                if (key.equals(valueOf)) {
                    monthDateView.setSelectedDayInfo(this.f9360f);
                } else {
                    monthDateView.m();
                }
            }
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        MonthDateView monthDateView;
        d dVar;
        String valueOf = String.valueOf(i);
        if (this.f9357c.containsKey(valueOf)) {
            monthDateView = this.f9357c.remove(valueOf);
        } else {
            monthDateView = new MonthDateView(this.a);
            monthDateView.setIgnoreLastDay(this.i);
            monthDateView.setLastDay(this.j);
            monthDateView.setDayColor(this.l);
            monthDateView.setInterceptTouch(this.k);
            monthDateView.setOutOfDateTextColor(this.m);
            monthDateView.setOnlyMarkClick(this.n);
        }
        if (this.f9356b.containsKey(valueOf)) {
            dVar = this.f9356b.get(valueOf);
        } else {
            dVar = this.f9359e.clone();
            int i2 = 99 - i;
            for (int i3 = 0; i3 < i2; i3++) {
                dVar.f();
            }
        }
        if (i == this.g) {
            monthDateView.setSelectedDayInfo(this.f9360f);
        } else {
            monthDateView.n(dVar.e(), dVar.d());
        }
        if (this.f9358d.containsKey(valueOf)) {
            monthDateView.setMarkedDays(this.f9358d.get(valueOf));
        } else {
            monthDateView.setMarkedDays(null);
        }
        monthDateView.setTag(Integer.valueOf(i));
        monthDateView.setMonthDateClickListener(this.h);
        viewGroup.addView(monthDateView);
        this.f9356b.put(valueOf, dVar);
        this.f9357c.put(valueOf, monthDateView);
        return monthDateView;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j(Calendar calendar, int i) {
        this.j = calendar;
        this.g = i;
        String valueOf = String.valueOf(i);
        for (Map.Entry<String, MonthDateView> entry : this.f9357c.entrySet()) {
            String key = entry.getKey();
            MonthDateView monthDateView = this.f9357c.get(key);
            if (monthDateView != null && key.equals(valueOf)) {
                monthDateView.o(calendar);
            }
        }
    }
}
