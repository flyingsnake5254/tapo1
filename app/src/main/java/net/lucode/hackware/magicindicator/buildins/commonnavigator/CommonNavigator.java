package net.lucode.hackware.magicindicator.buildins.commonnavigator;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import java.util.ArrayList;
import java.util.List;
import net.lucode.hackware.magicindicator.b;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.a.c;
import net.lucode.hackware.magicindicator.d;

/* loaded from: classes4.dex */
public class CommonNavigator extends FrameLayout implements net.lucode.hackware.magicindicator.f.a, b.a {
    private int H3;
    private int I3;
    private boolean J3;
    private boolean K3;

    /* renamed from: c  reason: collision with root package name */
    private HorizontalScrollView f16583c;

    /* renamed from: d  reason: collision with root package name */
    private LinearLayout f16584d;

    /* renamed from: f  reason: collision with root package name */
    private LinearLayout f16585f;
    private boolean p0;
    private c q;
    private net.lucode.hackware.magicindicator.buildins.commonnavigator.a.a x;
    private b y;
    private boolean z;
    private float p1 = 0.5f;
    private boolean p2 = true;
    private boolean p3 = true;
    private boolean L3 = true;
    private List<net.lucode.hackware.magicindicator.buildins.commonnavigator.b.a> M3 = new ArrayList();
    private DataSetObserver N3 = new a();

    /* loaded from: classes4.dex */
    class a extends DataSetObserver {
        a() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            CommonNavigator.this.y.m(CommonNavigator.this.x.a());
            CommonNavigator.this.j();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
        }
    }

    public CommonNavigator(Context context) {
        super(context);
        b bVar = new b();
        this.y = bVar;
        bVar.k(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        View view;
        removeAllViews();
        if (this.z) {
            view = LayoutInflater.from(getContext()).inflate(d.pager_navigator_layout_no_scroll, this);
        } else {
            view = LayoutInflater.from(getContext()).inflate(d.pager_navigator_layout, this);
        }
        this.f16583c = (HorizontalScrollView) view.findViewById(net.lucode.hackware.magicindicator.c.scroll_view);
        LinearLayout linearLayout = (LinearLayout) view.findViewById(net.lucode.hackware.magicindicator.c.title_container);
        this.f16584d = linearLayout;
        linearLayout.setPadding(this.I3, 0, this.H3, 0);
        LinearLayout linearLayout2 = (LinearLayout) view.findViewById(net.lucode.hackware.magicindicator.c.indicator_container);
        this.f16585f = linearLayout2;
        if (this.J3) {
            linearLayout2.getParent().bringChildToFront(this.f16585f);
        }
        k();
    }

    private void k() {
        LinearLayout.LayoutParams layoutParams;
        int g = this.y.g();
        for (int i = 0; i < g; i++) {
            net.lucode.hackware.magicindicator.buildins.commonnavigator.a.d c2 = this.x.c(getContext(), i);
            if (c2 instanceof View) {
                View view = (View) c2;
                if (this.z) {
                    layoutParams = new LinearLayout.LayoutParams(0, -1);
                    layoutParams.weight = this.x.d(getContext(), i);
                } else {
                    layoutParams = new LinearLayout.LayoutParams(-2, -1);
                }
                this.f16584d.addView(view, layoutParams);
            }
        }
        net.lucode.hackware.magicindicator.buildins.commonnavigator.a.a aVar = this.x;
        if (aVar != null) {
            c b2 = aVar.b(getContext());
            this.q = b2;
            if (b2 instanceof View) {
                this.f16585f.addView((View) this.q, new FrameLayout.LayoutParams(-1, -1));
            }
        }
    }

    private void l() {
        this.M3.clear();
        int g = this.y.g();
        for (int i = 0; i < g; i++) {
            net.lucode.hackware.magicindicator.buildins.commonnavigator.b.a aVar = new net.lucode.hackware.magicindicator.buildins.commonnavigator.b.a();
            View childAt = this.f16584d.getChildAt(i);
            if (childAt != null) {
                aVar.a = childAt.getLeft();
                aVar.f16586b = childAt.getTop();
                aVar.f16587c = childAt.getRight();
                int bottom = childAt.getBottom();
                aVar.f16588d = bottom;
                if (childAt instanceof net.lucode.hackware.magicindicator.buildins.commonnavigator.a.b) {
                    net.lucode.hackware.magicindicator.buildins.commonnavigator.a.b bVar = (net.lucode.hackware.magicindicator.buildins.commonnavigator.a.b) childAt;
                    aVar.f16589e = bVar.getContentLeft();
                    aVar.f16590f = bVar.getContentTop();
                    aVar.g = bVar.getContentRight();
                    aVar.h = bVar.getContentBottom();
                } else {
                    aVar.f16589e = aVar.a;
                    aVar.f16590f = aVar.f16586b;
                    aVar.g = aVar.f16587c;
                    aVar.h = bottom;
                }
            }
            this.M3.add(aVar);
        }
    }

    @Override // net.lucode.hackware.magicindicator.b.a
    public void a(int i, int i2) {
        LinearLayout linearLayout = this.f16584d;
        if (linearLayout != null) {
            View childAt = linearLayout.getChildAt(i);
            if (childAt instanceof net.lucode.hackware.magicindicator.buildins.commonnavigator.a.d) {
                ((net.lucode.hackware.magicindicator.buildins.commonnavigator.a.d) childAt).a(i, i2);
            }
        }
    }

    @Override // net.lucode.hackware.magicindicator.b.a
    public void b(int i, int i2, float f2, boolean z) {
        LinearLayout linearLayout = this.f16584d;
        if (linearLayout != null) {
            View childAt = linearLayout.getChildAt(i);
            if (childAt instanceof net.lucode.hackware.magicindicator.buildins.commonnavigator.a.d) {
                ((net.lucode.hackware.magicindicator.buildins.commonnavigator.a.d) childAt).b(i, i2, f2, z);
            }
        }
    }

    @Override // net.lucode.hackware.magicindicator.b.a
    public void c(int i, int i2) {
        LinearLayout linearLayout = this.f16584d;
        if (linearLayout != null) {
            View childAt = linearLayout.getChildAt(i);
            if (childAt instanceof net.lucode.hackware.magicindicator.buildins.commonnavigator.a.d) {
                ((net.lucode.hackware.magicindicator.buildins.commonnavigator.a.d) childAt).c(i, i2);
            }
            if (!this.z && !this.p3 && this.f16583c != null && this.M3.size() > 0) {
                net.lucode.hackware.magicindicator.buildins.commonnavigator.b.a aVar = this.M3.get(Math.min(this.M3.size() - 1, i));
                if (this.p0) {
                    float a2 = aVar.a() - (this.f16583c.getWidth() * this.p1);
                    if (this.p2) {
                        this.f16583c.smoothScrollTo((int) a2, 0);
                    } else {
                        this.f16583c.scrollTo((int) a2, 0);
                    }
                } else {
                    int scrollX = this.f16583c.getScrollX();
                    int i3 = aVar.a;
                    if (scrollX <= i3) {
                        int scrollX2 = this.f16583c.getScrollX() + getWidth();
                        int i4 = aVar.f16587c;
                        if (scrollX2 >= i4) {
                            return;
                        }
                        if (this.p2) {
                            this.f16583c.smoothScrollTo(i4 - getWidth(), 0);
                        } else {
                            this.f16583c.scrollTo(i4 - getWidth(), 0);
                        }
                    } else if (this.p2) {
                        this.f16583c.smoothScrollTo(i3, 0);
                    } else {
                        this.f16583c.scrollTo(i3, 0);
                    }
                }
            }
        }
    }

    @Override // net.lucode.hackware.magicindicator.b.a
    public void d(int i, int i2, float f2, boolean z) {
        LinearLayout linearLayout = this.f16584d;
        if (linearLayout != null) {
            View childAt = linearLayout.getChildAt(i);
            if (childAt instanceof net.lucode.hackware.magicindicator.buildins.commonnavigator.a.d) {
                ((net.lucode.hackware.magicindicator.buildins.commonnavigator.a.d) childAt).d(i, i2, f2, z);
            }
        }
    }

    @Override // net.lucode.hackware.magicindicator.f.a
    public void e() {
        j();
    }

    @Override // net.lucode.hackware.magicindicator.f.a
    public void f() {
    }

    public net.lucode.hackware.magicindicator.buildins.commonnavigator.a.a getAdapter() {
        return this.x;
    }

    public int getLeftPadding() {
        return this.I3;
    }

    public c getPagerIndicator() {
        return this.q;
    }

    public int getRightPadding() {
        return this.H3;
    }

    public float getScrollPivotX() {
        return this.p1;
    }

    public LinearLayout getTitleContainer() {
        return this.f16584d;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.x != null) {
            l();
            c cVar = this.q;
            if (cVar != null) {
                cVar.a(this.M3);
            }
            if (this.L3 && this.y.f() == 0) {
                onPageSelected(this.y.e());
                onPageScrolled(this.y.e(), 0.0f, 0);
            }
        }
    }

    @Override // net.lucode.hackware.magicindicator.f.a
    public void onPageScrollStateChanged(int i) {
        if (this.x != null) {
            this.y.h(i);
            c cVar = this.q;
            if (cVar != null) {
                cVar.onPageScrollStateChanged(i);
            }
        }
    }

    @Override // net.lucode.hackware.magicindicator.f.a
    public void onPageScrolled(int i, float f2, int i2) {
        if (this.x != null) {
            this.y.i(i, f2, i2);
            c cVar = this.q;
            if (cVar != null) {
                cVar.onPageScrolled(i, f2, i2);
            }
            if (this.f16583c != null && this.M3.size() > 0 && i >= 0 && i < this.M3.size() && this.p3) {
                int min = Math.min(this.M3.size() - 1, i);
                int min2 = Math.min(this.M3.size() - 1, i + 1);
                float a2 = this.M3.get(min).a() - (this.f16583c.getWidth() * this.p1);
                this.f16583c.scrollTo((int) (a2 + (((this.M3.get(min2).a() - (this.f16583c.getWidth() * this.p1)) - a2) * f2)), 0);
            }
        }
    }

    @Override // net.lucode.hackware.magicindicator.f.a
    public void onPageSelected(int i) {
        if (this.x != null) {
            this.y.j(i);
            c cVar = this.q;
            if (cVar != null) {
                cVar.onPageSelected(i);
            }
        }
    }

    public void setAdapter(net.lucode.hackware.magicindicator.buildins.commonnavigator.a.a aVar) {
        net.lucode.hackware.magicindicator.buildins.commonnavigator.a.a aVar2 = this.x;
        if (aVar2 != aVar) {
            if (aVar2 != null) {
                aVar2.g(this.N3);
            }
            this.x = aVar;
            if (aVar != null) {
                aVar.f(this.N3);
                this.y.m(this.x.a());
                if (this.f16584d != null) {
                    this.x.e();
                    return;
                }
                return;
            }
            this.y.m(0);
            j();
        }
    }

    public void setAdjustMode(boolean z) {
        this.z = z;
    }

    public void setEnablePivotScroll(boolean z) {
        this.p0 = z;
    }

    public void setFollowTouch(boolean z) {
        this.p3 = z;
    }

    public void setIndicatorOnTop(boolean z) {
        this.J3 = z;
    }

    public void setLeftPadding(int i) {
        this.I3 = i;
    }

    public void setReselectWhenLayout(boolean z) {
        this.L3 = z;
    }

    public void setRightPadding(int i) {
        this.H3 = i;
    }

    public void setScrollPivotX(float f2) {
        this.p1 = f2;
    }

    public void setSkimOver(boolean z) {
        this.K3 = z;
        this.y.l(z);
    }

    public void setSmoothScroll(boolean z) {
        this.p2 = z;
    }
}
