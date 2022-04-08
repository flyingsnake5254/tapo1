package skin.support.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;
import androidx.annotation.DrawableRes;

/* loaded from: classes4.dex */
public class SkinCompatScrollView extends ScrollView implements g {

    /* renamed from: c  reason: collision with root package name */
    private a f17721c;

    public SkinCompatScrollView(Context context) {
        this(context, null);
    }

    @Override // android.view.View
    public void setBackgroundResource(@DrawableRes int i) {
        super.setBackgroundResource(i);
        a aVar = this.f17721c;
        if (aVar != null) {
            aVar.d(i);
        }
    }

    public SkinCompatScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SkinCompatScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a aVar = new a(this);
        this.f17721c = aVar;
        aVar.c(attributeSet, i);
    }
}
