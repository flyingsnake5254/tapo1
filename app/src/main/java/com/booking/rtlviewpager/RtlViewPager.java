package com.booking.rtlviewpager;

import android.content.Context;
import android.database.DataSetObserver;
import android.util.AttributeSet;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import androidx.core.text.TextUtilsCompat;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import java.util.Map;

/* loaded from: classes.dex */
public class RtlViewPager extends ViewPager {
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    private final Map<ViewPager.OnPageChangeListener, d> f1269c = new ArrayMap(1);
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private DataSetObserver f1270d;

    /* renamed from: f  reason: collision with root package name */
    private boolean f1271f;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b extends DataSetObserver {
        @NonNull
        private final c a;

        @Override // android.database.DataSetObserver
        public void onChanged() {
            super.onChanged();
            this.a.c();
        }

        private b(@NonNull c cVar) {
            this.a = cVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c extends a {

        /* renamed from: b  reason: collision with root package name */
        private int f1272b;

        public c(@NonNull PagerAdapter pagerAdapter) {
            super(pagerAdapter);
            this.f1272b = pagerAdapter.getCount();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c() {
            int count = getCount();
            int i = this.f1272b;
            if (count != i) {
                RtlViewPager.this.setCurrentItemWithoutNotification(Math.max(0, i - 1));
                this.f1272b = count;
            }
        }

        private int d(int i) {
            return (getCount() - i) - 1;
        }

        @Override // com.booking.rtlviewpager.a, androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            super.destroyItem(viewGroup, d(i), obj);
        }

        @Override // com.booking.rtlviewpager.a, androidx.viewpager.widget.PagerAdapter
        public int getItemPosition(Object obj) {
            int itemPosition = super.getItemPosition(obj);
            return itemPosition < 0 ? itemPosition : d(itemPosition);
        }

        @Override // com.booking.rtlviewpager.a, androidx.viewpager.widget.PagerAdapter
        public CharSequence getPageTitle(int i) {
            return super.getPageTitle(d(i));
        }

        @Override // com.booking.rtlviewpager.a, androidx.viewpager.widget.PagerAdapter
        public float getPageWidth(int i) {
            return super.getPageWidth(d(i));
        }

        @Override // com.booking.rtlviewpager.a, androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            return super.instantiateItem(viewGroup, d(i));
        }

        @Override // com.booking.rtlviewpager.a, androidx.viewpager.widget.PagerAdapter
        public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
            super.setPrimaryItem(viewGroup, (this.f1272b - i) - 1, obj);
        }
    }

    /* loaded from: classes.dex */
    private class d implements ViewPager.OnPageChangeListener {
        @NonNull

        /* renamed from: c  reason: collision with root package name */
        private final ViewPager.OnPageChangeListener f1274c;

        /* renamed from: d  reason: collision with root package name */
        private int f1275d;

        private int a(int i) {
            PagerAdapter adapter = RtlViewPager.this.getAdapter();
            return adapter == null ? i : (adapter.getCount() - i) - 1;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            if (!RtlViewPager.this.f1271f) {
                this.f1274c.onPageScrollStateChanged(i);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f2, int i2) {
            if (!RtlViewPager.this.f1271f) {
                int i3 = (f2 > 0.0f ? 1 : (f2 == 0.0f ? 0 : -1));
                if (i3 == 0 && i2 == 0) {
                    this.f1275d = a(i);
                } else {
                    this.f1275d = a(i + 1);
                }
                ViewPager.OnPageChangeListener onPageChangeListener = this.f1274c;
                int i4 = this.f1275d;
                if (i3 > 0) {
                    f2 = 1.0f - f2;
                }
                onPageChangeListener.onPageScrolled(i4, f2, i2);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (!RtlViewPager.this.f1271f) {
                this.f1274c.onPageSelected(a(i));
            }
        }

        private d(@NonNull ViewPager.OnPageChangeListener onPageChangeListener) {
            this.f1274c = onPageChangeListener;
            this.f1275d = -1;
        }
    }

    public RtlViewPager(Context context) {
        super(context);
    }

    private int c(int i) {
        if (i < 0 || !d()) {
            return i;
        }
        if (getAdapter() == null) {
            return 0;
        }
        return (getAdapter().getCount() - i) - 1;
    }

    private void e(PagerAdapter pagerAdapter) {
        if ((pagerAdapter instanceof c) && this.f1270d == null) {
            b bVar = new b((c) pagerAdapter);
            this.f1270d = bVar;
            pagerAdapter.registerDataSetObserver(bVar);
            ((c) pagerAdapter).c();
        }
    }

    private void f() {
        DataSetObserver dataSetObserver;
        PagerAdapter adapter = super.getAdapter();
        if ((adapter instanceof c) && (dataSetObserver = this.f1270d) != null) {
            adapter.unregisterDataSetObserver(dataSetObserver);
            this.f1270d = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCurrentItemWithoutNotification(int i) {
        this.f1271f = true;
        setCurrentItem(i, false);
        this.f1271f = false;
    }

    @Override // androidx.viewpager.widget.ViewPager
    public void addOnPageChangeListener(@NonNull ViewPager.OnPageChangeListener onPageChangeListener) {
        if (d()) {
            d dVar = new d(onPageChangeListener);
            this.f1269c.put(onPageChangeListener, dVar);
            onPageChangeListener = dVar;
        }
        super.addOnPageChangeListener(onPageChangeListener);
    }

    protected boolean d() {
        return TextUtilsCompat.getLayoutDirectionFromLocale(getContext().getResources().getConfiguration().locale) == 1;
    }

    @Override // androidx.viewpager.widget.ViewPager
    public void fakeDragBy(float f2) {
        if (!d()) {
            f2 = -f2;
        }
        super.fakeDragBy(f2);
    }

    @Override // androidx.viewpager.widget.ViewPager
    @Nullable
    public PagerAdapter getAdapter() {
        PagerAdapter adapter = super.getAdapter();
        return adapter instanceof c ? ((c) adapter).a() : adapter;
    }

    @Override // androidx.viewpager.widget.ViewPager
    public int getCurrentItem() {
        return c(super.getCurrentItem());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        e(super.getAdapter());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        f();
        super.onDetachedFromWindow();
    }

    @Override // androidx.viewpager.widget.ViewPager
    public void removeOnPageChangeListener(@NonNull ViewPager.OnPageChangeListener onPageChangeListener) {
        if (d()) {
            onPageChangeListener = this.f1269c.remove(onPageChangeListener);
        }
        super.removeOnPageChangeListener(onPageChangeListener);
    }

    @Override // androidx.viewpager.widget.ViewPager
    public void setAdapter(@Nullable PagerAdapter pagerAdapter) {
        f();
        boolean z = pagerAdapter != null && d();
        if (z) {
            c cVar = new c(pagerAdapter);
            e(cVar);
            pagerAdapter = cVar;
        }
        super.setAdapter(pagerAdapter);
        if (z) {
            setCurrentItemWithoutNotification(0);
        }
    }

    @Override // androidx.viewpager.widget.ViewPager
    public void setCurrentItem(int i, boolean z) {
        super.setCurrentItem(c(i), z);
    }

    @Override // androidx.viewpager.widget.ViewPager
    public void setCurrentItem(int i) {
        super.setCurrentItem(c(i));
    }

    public RtlViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
