package skin.support.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.DrawableRes;
import androidx.appcompat.R;
import androidx.appcompat.widget.AppCompatImageButton;

/* loaded from: classes4.dex */
public class SkinCompatImageButton extends AppCompatImageButton implements g {

    /* renamed from: c  reason: collision with root package name */
    private a f17706c;

    /* renamed from: d  reason: collision with root package name */
    private d f17707d;

    public SkinCompatImageButton(Context context) {
        this(context, null);
    }

    @Override // androidx.appcompat.widget.AppCompatImageButton, android.view.View
    public void setBackgroundResource(@DrawableRes int i) {
        super.setBackgroundResource(i);
        a aVar = this.f17706c;
        if (aVar != null) {
            aVar.d(i);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatImageButton, android.widget.ImageView
    public void setImageResource(@DrawableRes int i) {
        d dVar = this.f17707d;
        if (dVar != null) {
            dVar.d(i);
        }
    }

    public SkinCompatImageButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.imageButtonStyle);
    }

    public SkinCompatImageButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a aVar = new a(this);
        this.f17706c = aVar;
        aVar.c(attributeSet, i);
        d dVar = new d(this);
        this.f17707d = dVar;
        dVar.c(attributeSet, i);
    }
}
