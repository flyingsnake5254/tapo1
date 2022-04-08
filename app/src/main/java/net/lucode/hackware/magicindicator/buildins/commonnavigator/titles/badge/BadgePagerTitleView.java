package net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.badge;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.a.b;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.a.d;

/* loaded from: classes4.dex */
public class BadgePagerTitleView extends FrameLayout implements b {

    /* renamed from: c  reason: collision with root package name */
    private d f16613c;

    /* renamed from: d  reason: collision with root package name */
    private View f16614d;

    /* renamed from: f  reason: collision with root package name */
    private boolean f16615f = true;
    private a q;
    private a x;

    public BadgePagerTitleView(Context context) {
        super(context);
    }

    @Override // net.lucode.hackware.magicindicator.buildins.commonnavigator.a.d
    public void a(int i, int i2) {
        d dVar = this.f16613c;
        if (dVar != null) {
            dVar.a(i, i2);
        }
    }

    @Override // net.lucode.hackware.magicindicator.buildins.commonnavigator.a.d
    public void b(int i, int i2, float f2, boolean z) {
        d dVar = this.f16613c;
        if (dVar != null) {
            dVar.b(i, i2, f2, z);
        }
    }

    @Override // net.lucode.hackware.magicindicator.buildins.commonnavigator.a.d
    public void c(int i, int i2) {
        d dVar = this.f16613c;
        if (dVar != null) {
            dVar.c(i, i2);
        }
        if (this.f16615f) {
            setBadgeView(null);
        }
    }

    @Override // net.lucode.hackware.magicindicator.buildins.commonnavigator.a.d
    public void d(int i, int i2, float f2, boolean z) {
        d dVar = this.f16613c;
        if (dVar != null) {
            dVar.d(i, i2, f2, z);
        }
    }

    public View getBadgeView() {
        return this.f16614d;
    }

    @Override // net.lucode.hackware.magicindicator.buildins.commonnavigator.a.b
    public int getContentBottom() {
        d dVar = this.f16613c;
        if (dVar instanceof b) {
            return ((b) dVar).getContentBottom();
        }
        return getBottom();
    }

    @Override // net.lucode.hackware.magicindicator.buildins.commonnavigator.a.b
    public int getContentLeft() {
        if (this.f16613c instanceof b) {
            return getLeft() + ((b) this.f16613c).getContentLeft();
        }
        return getLeft();
    }

    @Override // net.lucode.hackware.magicindicator.buildins.commonnavigator.a.b
    public int getContentRight() {
        if (this.f16613c instanceof b) {
            return getLeft() + ((b) this.f16613c).getContentRight();
        }
        return getRight();
    }

    @Override // net.lucode.hackware.magicindicator.buildins.commonnavigator.a.b
    public int getContentTop() {
        d dVar = this.f16613c;
        if (dVar instanceof b) {
            return ((b) dVar).getContentTop();
        }
        return getTop();
    }

    public d getInnerPagerTitleView() {
        return this.f16613c;
    }

    public a getXBadgeRule() {
        return this.q;
    }

    public a getYBadgeRule() {
        return this.x;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        d dVar = this.f16613c;
        if ((dVar instanceof View) && this.f16614d != null) {
            int[] iArr = new int[14];
            View view = (View) dVar;
            iArr[0] = view.getLeft();
            iArr[1] = view.getTop();
            iArr[2] = view.getRight();
            iArr[3] = view.getBottom();
            d dVar2 = this.f16613c;
            if (dVar2 instanceof b) {
                b bVar = (b) dVar2;
                iArr[4] = bVar.getContentLeft();
                iArr[5] = bVar.getContentTop();
                iArr[6] = bVar.getContentRight();
                iArr[7] = bVar.getContentBottom();
            } else {
                for (int i5 = 4; i5 < 8; i5++) {
                    iArr[i5] = iArr[i5 - 4];
                }
            }
            iArr[8] = view.getWidth() / 2;
            iArr[9] = view.getHeight() / 2;
            iArr[10] = iArr[4] / 2;
            iArr[11] = iArr[5] / 2;
            iArr[12] = iArr[6] + ((iArr[2] - iArr[6]) / 2);
            iArr[13] = iArr[7] + ((iArr[3] - iArr[7]) / 2);
            if (this.q != null) {
                throw null;
            } else if (this.x != null) {
                throw null;
            }
        }
    }

    public void setAutoCancelBadge(boolean z) {
        this.f16615f = z;
    }

    public void setBadgeView(View view) {
        if (this.f16614d != view) {
            this.f16614d = view;
            removeAllViews();
            if (this.f16613c instanceof View) {
                addView((View) this.f16613c, new FrameLayout.LayoutParams(-1, -1));
            }
            if (this.f16614d != null) {
                addView(this.f16614d, new FrameLayout.LayoutParams(-2, -2));
            }
        }
    }

    public void setInnerPagerTitleView(d dVar) {
        if (this.f16613c != dVar) {
            this.f16613c = dVar;
            removeAllViews();
            if (this.f16613c instanceof View) {
                addView((View) this.f16613c, new FrameLayout.LayoutParams(-1, -1));
            }
            if (this.f16614d != null) {
                addView(this.f16614d, new FrameLayout.LayoutParams(-2, -2));
            }
        }
    }

    public void setXBadgeRule(a aVar) {
        if (aVar != null) {
            throw null;
        }
    }

    public void setYBadgeRule(a aVar) {
        if (aVar != null) {
            throw null;
        }
    }
}
