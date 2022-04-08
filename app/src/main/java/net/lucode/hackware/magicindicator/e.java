package net.lucode.hackware.magicindicator;

import androidx.viewpager.widget.ViewPager;

/* compiled from: ViewPagerHelper.java */
/* loaded from: classes4.dex */
public class e {

    /* compiled from: ViewPagerHelper.java */
    /* loaded from: classes4.dex */
    static class a implements ViewPager.OnPageChangeListener {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ MagicIndicator f16616c;

        a(MagicIndicator magicIndicator) {
            this.f16616c = magicIndicator;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            this.f16616c.a(i);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f2, int i2) {
            this.f16616c.b(i, f2, i2);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            this.f16616c.c(i);
        }
    }

    public static void a(MagicIndicator magicIndicator, ViewPager viewPager) {
        viewPager.addOnPageChangeListener(new a(magicIndicator));
    }
}
