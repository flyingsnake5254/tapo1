package skin.support.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.DrawableRes;
import androidx.appcompat.R;
import androidx.appcompat.widget.AppCompatEditText;

/* loaded from: classes4.dex */
public class SkinCompatEditText extends AppCompatEditText implements g {

    /* renamed from: c  reason: collision with root package name */
    private h f17703c;

    /* renamed from: d  reason: collision with root package name */
    private a f17704d;

    public SkinCompatEditText(Context context) {
        this(context, null);
    }

    public int getTextColorResId() {
        h hVar = this.f17703c;
        if (hVar != null) {
            return hVar.h();
        }
        return 0;
    }

    @Override // androidx.appcompat.widget.AppCompatEditText, android.view.View
    public void setBackgroundResource(@DrawableRes int i) {
        super.setBackgroundResource(i);
        a aVar = this.f17704d;
        if (aVar != null) {
            aVar.d(i);
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(@DrawableRes int i, @DrawableRes int i2, @DrawableRes int i3, @DrawableRes int i4) {
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(i, i2, i3, i4);
        h hVar = this.f17703c;
        if (hVar != null) {
            hVar.j(i, i2, i3, i4);
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(@DrawableRes int i, @DrawableRes int i2, @DrawableRes int i3, @DrawableRes int i4) {
        super.setCompoundDrawablesWithIntrinsicBounds(i, i2, i3, i4);
        h hVar = this.f17703c;
        if (hVar != null) {
            hVar.k(i, i2, i3, i4);
        }
    }

    @Override // android.widget.TextView
    public void setTextAppearance(int i) {
        setTextAppearance(getContext(), i);
    }

    public SkinCompatEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.editTextStyle);
    }

    @Override // androidx.appcompat.widget.AppCompatEditText, android.widget.TextView
    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        h hVar = this.f17703c;
        if (hVar != null) {
            hVar.l(context, i);
        }
    }

    public SkinCompatEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a aVar = new a(this);
        this.f17704d = aVar;
        aVar.c(attributeSet, i);
        h g = h.g(this);
        this.f17703c = g;
        g.i(attributeSet, i);
    }
}
