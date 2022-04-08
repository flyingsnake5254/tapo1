package com.tplink.iot.widget.colorbulb;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;
import com.tplink.iot.R;

/* loaded from: classes3.dex */
public class TitleSelectorView extends LinearLayout implements RadioGroup.OnCheckedChangeListener, ViewPager.OnPageChangeListener {

    /* renamed from: c  reason: collision with root package name */
    private RadioButton f11777c;

    /* renamed from: d  reason: collision with root package name */
    private RadioButton f11778d;

    /* renamed from: f  reason: collision with root package name */
    private ViewPager f11779f;
    private RadioGroup q;
    private a x;

    /* loaded from: classes3.dex */
    public interface a {
        void a(int i);
    }

    public TitleSelectorView(Context context) {
        this(context, null);
    }

    @Override // android.widget.RadioGroup.OnCheckedChangeListener
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        switch (i) {
            case R.id.tv_title_1 /* 2131364689 */:
                this.f11777c.setTextColor(getContext().getResources().getColor(R.color.white));
                this.f11778d.setTextColor(getContext().getResources().getColor(R.color.color_999999));
                ViewPager viewPager = this.f11779f;
                if (viewPager != null) {
                    viewPager.setCurrentItem(0);
                }
                a aVar = this.x;
                if (aVar != null) {
                    aVar.a(0);
                    return;
                }
                return;
            case R.id.tv_title_2 /* 2131364690 */:
                this.f11777c.setTextColor(getContext().getResources().getColor(R.color.color_999999));
                this.f11778d.setTextColor(getContext().getResources().getColor(R.color.white));
                ViewPager viewPager2 = this.f11779f;
                if (viewPager2 != null) {
                    viewPager2.setCurrentItem(1);
                }
                a aVar2 = this.x;
                if (aVar2 != null) {
                    aVar2.a(1);
                    return;
                }
                return;
            default:
                return;
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f2, int i2) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.q.check(i == 0 ? R.id.tv_title_1 : R.id.tv_title_2);
    }

    public void setOnSelectedTitleListener(a aVar) {
        this.x = aVar;
    }

    public void setSelectedTitleIndex(int i) {
        this.q.check(i == 0 ? R.id.tv_title_1 : R.id.tv_title_2);
    }

    public TitleSelectorView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TitleSelectorView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        LayoutInflater.from(context).inflate(R.layout.view_title_selector, (ViewGroup) this, true);
        setOrientation(0);
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.rg);
        this.q = radioGroup;
        radioGroup.setOnCheckedChangeListener(this);
        this.f11777c = (RadioButton) findViewById(R.id.tv_title_1);
        this.f11778d = (RadioButton) findViewById(R.id.tv_title_2);
        this.q.check(R.id.tv_title_1);
    }
}
