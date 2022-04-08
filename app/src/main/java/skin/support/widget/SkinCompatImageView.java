package skin.support.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.DrawableRes;
import androidx.appcompat.widget.AppCompatImageView;

/* loaded from: classes4.dex */
public class SkinCompatImageView extends AppCompatImageView implements g {

    /* renamed from: c  reason: collision with root package name */
    private a f17708c;

    /* renamed from: d  reason: collision with root package name */
    private d f17709d;

    public SkinCompatImageView(Context context) {
        this(context, null);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.view.View
    public void setBackgroundResource(@DrawableRes int i) {
        super.setBackgroundResource(i);
        a aVar = this.f17708c;
        if (aVar != null) {
            aVar.d(i);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageResource(@DrawableRes int i) {
        d dVar = this.f17709d;
        if (dVar != null) {
            dVar.d(i);
        }
    }

    public SkinCompatImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SkinCompatImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a aVar = new a(this);
        this.f17708c = aVar;
        aVar.c(attributeSet, i);
        d dVar = new d(this);
        this.f17709d = dVar;
        dVar.c(attributeSet, i);
    }
}
