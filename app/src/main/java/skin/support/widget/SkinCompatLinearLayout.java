package skin.support.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/* loaded from: classes4.dex */
public class SkinCompatLinearLayout extends LinearLayout implements g {

    /* renamed from: c  reason: collision with root package name */
    private a f17710c;

    public SkinCompatLinearLayout(Context context) {
        this(context, null);
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        a aVar = this.f17710c;
        if (aVar != null) {
            aVar.d(i);
        }
    }

    public SkinCompatLinearLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SkinCompatLinearLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a aVar = new a(this);
        this.f17710c = aVar;
        aVar.c(attributeSet, i);
    }
}
