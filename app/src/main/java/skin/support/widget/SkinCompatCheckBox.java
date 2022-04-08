package skin.support.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.DrawableRes;
import androidx.appcompat.widget.AppCompatCheckBox;
import f.a.a;

/* loaded from: classes4.dex */
public class SkinCompatCheckBox extends AppCompatCheckBox implements g {

    /* renamed from: c  reason: collision with root package name */
    private b f17697c;

    /* renamed from: d  reason: collision with root package name */
    private h f17698d;

    /* renamed from: f  reason: collision with root package name */
    private a f17699f;

    public SkinCompatCheckBox(Context context) {
        this(context, null);
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.view.View
    public void setBackgroundResource(@DrawableRes int i) {
        super.setBackgroundResource(i);
        a aVar = this.f17699f;
        if (aVar != null) {
            aVar.d(i);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.widget.CompoundButton
    public void setButtonDrawable(@DrawableRes int i) {
        super.setButtonDrawable(i);
        b bVar = this.f17697c;
        if (bVar != null) {
            bVar.d(i);
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(@DrawableRes int i, @DrawableRes int i2, @DrawableRes int i3, @DrawableRes int i4) {
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(i, i2, i3, i4);
        h hVar = this.f17698d;
        if (hVar != null) {
            hVar.j(i, i2, i3, i4);
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(@DrawableRes int i, @DrawableRes int i2, @DrawableRes int i3, @DrawableRes int i4) {
        super.setCompoundDrawablesWithIntrinsicBounds(i, i2, i3, i4);
        h hVar = this.f17698d;
        if (hVar != null) {
            hVar.k(i, i2, i3, i4);
        }
    }

    @Override // android.widget.TextView
    public void setTextAppearance(int i) {
        setTextAppearance(getContext(), i);
    }

    public SkinCompatCheckBox(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.checkboxStyle);
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        h hVar = this.f17698d;
        if (hVar != null) {
            hVar.l(context, i);
        }
    }

    public SkinCompatCheckBox(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        b bVar = new b(this);
        this.f17697c = bVar;
        bVar.c(attributeSet, i);
        a aVar = new a(this);
        this.f17699f = aVar;
        aVar.c(attributeSet, i);
        h g = h.g(this);
        this.f17698d = g;
        g.i(attributeSet, i);
    }
}
