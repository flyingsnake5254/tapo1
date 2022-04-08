package com.tplink.libtpcontrols.horizontalpageview;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import androidx.viewpager.widget.ViewPager;
import com.tplink.libtpcontrols.horizontalpageview.TPHorizontalPagerAdapter;
import com.tplink.libtpcontrols.s0;
import com.tplink.libtpcontrols.t0;
import com.tplink.libtpcontrols.v0;
import java.util.List;

/* loaded from: classes3.dex */
public class TPHorizontalPageView extends LinearLayout {

    /* renamed from: f  reason: collision with root package name */
    private TPHorizontalPagerAdapter f12259f;
    private ViewPager q;
    private TPCircleIndicator x;
    private int y;

    /* renamed from: c  reason: collision with root package name */
    private b f12257c = null;

    /* renamed from: d  reason: collision with root package name */
    private b f12258d = null;
    private int z = 0;
    private boolean p0 = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements ViewPager.OnPageChangeListener {
        a() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f2, int i2) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            TPHorizontalPageView.this.y = i;
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(int i);
    }

    public TPHorizontalPageView(Context context) {
        super(context);
        b(context);
    }

    private void b(Context context) {
        View inflate = LayoutInflater.from(context).inflate(t0.location_view, this);
        this.q = (ViewPager) inflate.findViewById(s0.viewpager);
        this.x = (TPCircleIndicator) inflate.findViewById(s0.indicator);
        TPHorizontalPagerAdapter tPHorizontalPagerAdapter = new TPHorizontalPagerAdapter(context, getResources().getString(v0.space_add_room), getResources().getString(v0.space_add_room_mipmap_icon));
        this.f12259f = tPHorizontalPagerAdapter;
        this.q.setAdapter(tPHorizontalPagerAdapter);
        this.x.setViewPager(this.q);
        this.f12259f.d(new TPHorizontalPagerAdapter.a() { // from class: com.tplink.libtpcontrols.horizontalpageview.a
            @Override // com.tplink.libtpcontrols.horizontalpageview.TPHorizontalPagerAdapter.a
            public final void a(int i) {
                TPHorizontalPageView.this.d(i);
            }
        });
        this.q.addOnPageChangeListener(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public /* synthetic */ void d(int i) {
        if (!this.p0 || this.f12258d == null || i != this.f12259f.a() - 1) {
            b bVar = this.f12257c;
            if (bVar != null) {
                bVar.a(i);
                return;
            }
            return;
        }
        this.f12258d.a(i);
    }

    public void setAdapterList(List<String> list) {
        if (this.z == 0) {
            this.p0 = true;
            this.f12259f.e(list);
        } else if (list.size() < this.z * 8) {
            this.p0 = true;
            this.f12259f.e(list);
        } else {
            this.p0 = false;
            this.f12259f.f(list);
        }
        this.q.setAdapter(this.f12259f);
        this.q.setCurrentItem(this.y);
        this.x.setViewPager(this.q);
    }

    public void setMaxPage(int i) {
        if (i >= 0) {
            this.z = i;
        } else {
            Log.d("TPHorizontalPageView", "Max Page Number should be Greater than or equal to zero.");
        }
    }

    public void setOnAddClickListener(b bVar) {
        this.f12258d = bVar;
    }

    public void setOnItemClickListener(b bVar) {
        this.f12257c = bVar;
    }

    public TPHorizontalPageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b(context);
    }

    public TPHorizontalPageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        b(context);
    }
}
