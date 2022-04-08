package skin.support.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

/* loaded from: classes4.dex */
public class SkinCompatView extends View implements g {

    /* renamed from: c  reason: collision with root package name */
    private a f17731c;

    public SkinCompatView(Context context) {
        this(context, null);
    }

    public void a() {
        a aVar = this.f17731c;
        if (aVar != null) {
            aVar.b();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        a aVar = this.f17731c;
        if (aVar != null) {
            aVar.d(i);
        }
    }

    public SkinCompatView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SkinCompatView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a aVar = new a(this);
        this.f17731c = aVar;
        aVar.c(attributeSet, i);
    }
}
