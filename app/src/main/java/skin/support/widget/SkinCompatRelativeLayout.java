package skin.support.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

/* loaded from: classes4.dex */
public class SkinCompatRelativeLayout extends RelativeLayout implements g {

    /* renamed from: c  reason: collision with root package name */
    private a f17720c;

    public SkinCompatRelativeLayout(Context context) {
        this(context, null);
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        a aVar = this.f17720c;
        if (aVar != null) {
            aVar.d(i);
        }
    }

    public SkinCompatRelativeLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SkinCompatRelativeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a aVar = new a(this);
        this.f17720c = aVar;
        aVar.c(attributeSet, i);
    }
}
