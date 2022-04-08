package skin.support.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.annotation.DrawableRes;
import androidx.appcompat.widget.AppCompatAutoCompleteTextView;
import f.a.a;
import f.a.f.a.d;

/* loaded from: classes4.dex */
public class SkinCompatAutoCompleteTextView extends AppCompatAutoCompleteTextView implements g {

    /* renamed from: c  reason: collision with root package name */
    private static final int[] f17692c = {16843126};

    /* renamed from: d  reason: collision with root package name */
    private int f17693d;

    /* renamed from: f  reason: collision with root package name */
    private h f17694f;
    private a q;

    public SkinCompatAutoCompleteTextView(Context context) {
        this(context, null);
    }

    private void a() {
        Drawable d2;
        int a = c.a(this.f17693d);
        this.f17693d = a;
        if (a != 0 && (d2 = d.d(getContext(), this.f17693d)) != null) {
            setDropDownBackgroundDrawable(d2);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatAutoCompleteTextView, android.view.View
    public void setBackgroundResource(@DrawableRes int i) {
        super.setBackgroundResource(i);
        a aVar = this.q;
        if (aVar != null) {
            aVar.d(i);
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(@DrawableRes int i, @DrawableRes int i2, @DrawableRes int i3, @DrawableRes int i4) {
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(i, i2, i3, i4);
        h hVar = this.f17694f;
        if (hVar != null) {
            hVar.j(i, i2, i3, i4);
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(@DrawableRes int i, @DrawableRes int i2, @DrawableRes int i3, @DrawableRes int i4) {
        super.setCompoundDrawablesWithIntrinsicBounds(i, i2, i3, i4);
        h hVar = this.f17694f;
        if (hVar != null) {
            hVar.k(i, i2, i3, i4);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatAutoCompleteTextView, android.widget.AutoCompleteTextView
    public void setDropDownBackgroundResource(@DrawableRes int i) {
        super.setDropDownBackgroundResource(i);
        this.f17693d = i;
        a();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(int i) {
        setTextAppearance(getContext(), i);
    }

    public SkinCompatAutoCompleteTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.autoCompleteTextViewStyle);
    }

    @Override // androidx.appcompat.widget.AppCompatAutoCompleteTextView, android.widget.TextView
    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        h hVar = this.f17694f;
        if (hVar != null) {
            hVar.l(context, i);
        }
    }

    public SkinCompatAutoCompleteTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f17693d = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f17692c, i, 0);
        if (obtainStyledAttributes.hasValue(0)) {
            this.f17693d = obtainStyledAttributes.getResourceId(0, 0);
        }
        obtainStyledAttributes.recycle();
        a();
        a aVar = new a(this);
        this.q = aVar;
        aVar.c(attributeSet, i);
        h g = h.g(this);
        this.f17694f = g;
        g.i(attributeSet, i);
    }
}
