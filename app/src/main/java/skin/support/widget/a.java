package skin.support.widget;

import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.view.ViewCompat;
import f.a.f.a.d;

/* compiled from: SkinCompatBackgroundHelper.java */
/* loaded from: classes4.dex */
public class a extends c {
    private final View a;

    /* renamed from: b  reason: collision with root package name */
    private int f17733b = 0;

    public a(View view) {
        this.a = view;
    }

    public void b() {
        Drawable d2;
        int a = c.a(this.f17733b);
        this.f17733b = a;
        if (a != 0 && (d2 = d.d(this.a.getContext(), this.f17733b)) != null) {
            int paddingLeft = this.a.getPaddingLeft();
            int paddingTop = this.a.getPaddingTop();
            int paddingRight = this.a.getPaddingRight();
            int paddingBottom = this.a.getPaddingBottom();
            ViewCompat.setBackground(this.a, d2);
            this.a.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
        }
    }

    /* JADX WARN: Finally extract failed */
    public void c(AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = this.a.getContext().obtainStyledAttributes(attributeSet, f.a.d.SkinBackgroundHelper, i, 0);
        try {
            int i2 = f.a.d.SkinBackgroundHelper_android_background;
            if (obtainStyledAttributes.hasValue(i2)) {
                this.f17733b = obtainStyledAttributes.getResourceId(i2, 0);
            }
            obtainStyledAttributes.recycle();
            b();
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    public void d(int i) {
        this.f17733b = i;
        b();
    }
}
