package skin.support.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatRatingBar;
import f.a.a;

/* loaded from: classes4.dex */
public class SkinCompatRatingBar extends AppCompatRatingBar implements g {

    /* renamed from: c  reason: collision with root package name */
    private e f17719c;

    public SkinCompatRatingBar(Context context) {
        this(context, null);
    }

    public SkinCompatRatingBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.ratingBarStyle);
    }

    public SkinCompatRatingBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        e eVar = new e(this);
        this.f17719c = eVar;
        eVar.e(attributeSet, i);
    }
}
