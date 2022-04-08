package skin.support.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatSeekBar;
import f.a.a;

/* loaded from: classes4.dex */
public class SkinCompatSeekBar extends AppCompatSeekBar implements g {

    /* renamed from: c  reason: collision with root package name */
    private f f17722c;

    public SkinCompatSeekBar(Context context) {
        this(context, null);
    }

    public SkinCompatSeekBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.seekBarStyle);
    }

    public SkinCompatSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        f fVar = new f(this);
        this.f17722c = fVar;
        fVar.e(attributeSet, i);
    }
}
