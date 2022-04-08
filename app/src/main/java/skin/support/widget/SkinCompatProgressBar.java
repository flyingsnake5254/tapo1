package skin.support.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ProgressBar;

/* loaded from: classes4.dex */
public class SkinCompatProgressBar extends ProgressBar implements g {

    /* renamed from: c  reason: collision with root package name */
    private e f17714c;

    public SkinCompatProgressBar(Context context) {
        this(context, null);
    }

    public SkinCompatProgressBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842871);
    }

    public SkinCompatProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        e eVar = new e(this);
        this.f17714c = eVar;
        eVar.e(attributeSet, i);
    }
}
