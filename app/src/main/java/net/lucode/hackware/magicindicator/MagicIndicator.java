package net.lucode.hackware.magicindicator;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import net.lucode.hackware.magicindicator.f.a;

/* loaded from: classes4.dex */
public class MagicIndicator extends FrameLayout {

    /* renamed from: c  reason: collision with root package name */
    private a f16574c;

    public MagicIndicator(Context context) {
        super(context);
    }

    public void a(int i) {
        a aVar = this.f16574c;
        if (aVar != null) {
            aVar.onPageScrollStateChanged(i);
        }
    }

    public void b(int i, float f2, int i2) {
        a aVar = this.f16574c;
        if (aVar != null) {
            aVar.onPageScrolled(i, f2, i2);
        }
    }

    public void c(int i) {
        a aVar = this.f16574c;
        if (aVar != null) {
            aVar.onPageSelected(i);
        }
    }

    public a getNavigator() {
        return this.f16574c;
    }

    public void setNavigator(a aVar) {
        a aVar2 = this.f16574c;
        if (aVar2 != aVar) {
            if (aVar2 != null) {
                aVar2.f();
            }
            this.f16574c = aVar;
            removeAllViews();
            if (this.f16574c instanceof View) {
                addView((View) this.f16574c, new FrameLayout.LayoutParams(-1, -1));
                this.f16574c.e();
            }
        }
    }

    public MagicIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
