package skin.support.widget;

import android.annotation.TargetApi;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import androidx.annotation.RequiresApi;
import f.a.f.a.d;

/* compiled from: SkinCompatTextHelperV17.java */
@RequiresApi(17)
@TargetApi(17)
/* loaded from: classes4.dex */
public class i extends h {
    private int h = 0;
    private int i = 0;

    public i(TextView textView) {
        super(textView);
    }

    @Override // skin.support.widget.h
    protected void b() {
        int a = c.a(this.f17746e);
        this.f17746e = a;
        Drawable drawable = null;
        Drawable d2 = a != 0 ? d.d(this.a.getContext(), this.f17746e) : null;
        int a2 = c.a(this.g);
        this.g = a2;
        Drawable d3 = a2 != 0 ? d.d(this.a.getContext(), this.g) : null;
        int a3 = c.a(this.f17747f);
        this.f17747f = a3;
        Drawable d4 = a3 != 0 ? d.d(this.a.getContext(), this.f17747f) : null;
        int a4 = c.a(this.f17745d);
        this.f17745d = a4;
        Drawable d5 = a4 != 0 ? d.d(this.a.getContext(), this.f17745d) : null;
        Drawable d6 = this.h != 0 ? d.d(this.a.getContext(), this.h) : null;
        if (d6 != null) {
            d2 = d6;
        }
        if (this.i != 0) {
            drawable = d.d(this.a.getContext(), this.i);
        }
        if (drawable != null) {
            d4 = drawable;
        }
        if (this.f17746e != 0 || this.g != 0 || this.f17747f != 0 || this.f17745d != 0 || this.h != 0 || this.i != 0) {
            this.a.setCompoundDrawablesWithIntrinsicBounds(d2, d3, d4, d5);
        }
    }

    @Override // skin.support.widget.h
    public void i(AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = this.a.getContext().obtainStyledAttributes(attributeSet, f.a.d.SkinCompatTextHelper, i, 0);
        int i2 = f.a.d.SkinCompatTextHelper_android_drawableStart;
        if (obtainStyledAttributes.hasValue(i2)) {
            int resourceId = obtainStyledAttributes.getResourceId(i2, 0);
            this.h = resourceId;
            this.h = c.a(resourceId);
        }
        int i3 = f.a.d.SkinCompatTextHelper_android_drawableEnd;
        if (obtainStyledAttributes.hasValue(i3)) {
            int resourceId2 = obtainStyledAttributes.getResourceId(i3, 0);
            this.i = resourceId2;
            this.i = c.a(resourceId2);
        }
        obtainStyledAttributes.recycle();
        super.i(attributeSet, i);
    }

    @Override // skin.support.widget.h
    public void j(@DrawableRes int i, @DrawableRes int i2, @DrawableRes int i3, @DrawableRes int i4) {
        this.h = i;
        this.g = i2;
        this.i = i3;
        this.f17745d = i4;
        b();
    }
}
