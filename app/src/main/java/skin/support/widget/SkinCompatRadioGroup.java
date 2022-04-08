package skin.support.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RadioGroup;

/* loaded from: classes4.dex */
public class SkinCompatRadioGroup extends RadioGroup implements g {

    /* renamed from: c  reason: collision with root package name */
    private a f17718c;

    public SkinCompatRadioGroup(Context context) {
        this(context, null);
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        a aVar = this.f17718c;
        if (aVar != null) {
            aVar.d(i);
        }
    }

    public SkinCompatRadioGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a aVar = new a(this);
        this.f17718c = aVar;
        aVar.c(attributeSet, 0);
    }
}
