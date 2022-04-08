package skin.support.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import f.a.a;
import f.a.f.a.d;

/* loaded from: classes4.dex */
public class SkinCompatToolbar extends Toolbar implements g {

    /* renamed from: c  reason: collision with root package name */
    private int f17728c;

    /* renamed from: d  reason: collision with root package name */
    private int f17729d;

    /* renamed from: f  reason: collision with root package name */
    private int f17730f;
    private a q;

    public SkinCompatToolbar(Context context) {
        this(context, null);
    }

    private void a() {
        int a = c.a(this.f17730f);
        this.f17730f = a;
        if (a != 0) {
            setNavigationIcon(d.d(getContext(), this.f17730f));
        }
    }

    private void b() {
        int a = c.a(this.f17729d);
        this.f17729d = a;
        if (a != 0) {
            setSubtitleTextColor(d.a(getContext(), this.f17729d));
        }
    }

    private void c() {
        int a = c.a(this.f17728c);
        this.f17728c = a;
        if (a != 0) {
            setTitleTextColor(d.a(getContext(), this.f17728c));
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(@DrawableRes int i) {
        super.setBackgroundResource(i);
        a aVar = this.q;
        if (aVar != null) {
            aVar.d(i);
        }
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setNavigationIcon(@DrawableRes int i) {
        super.setNavigationIcon(i);
        this.f17730f = i;
        a();
    }

    public SkinCompatToolbar(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, a.toolbarStyle);
    }

    public SkinCompatToolbar(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f17728c = 0;
        this.f17729d = 0;
        this.f17730f = 0;
        a aVar = new a(this);
        this.q = aVar;
        aVar.c(attributeSet, i);
        int[] iArr = f.a.d.Toolbar;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i, 0);
        this.f17730f = obtainStyledAttributes.getResourceId(f.a.d.Toolbar_navigationIcon, 0);
        int resourceId = obtainStyledAttributes.getResourceId(f.a.d.Toolbar_titleTextAppearance, 0);
        int resourceId2 = obtainStyledAttributes.getResourceId(f.a.d.Toolbar_subtitleTextAppearance, 0);
        obtainStyledAttributes.recycle();
        if (resourceId != 0) {
            TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(resourceId, f.a.d.SkinTextAppearance);
            this.f17728c = obtainStyledAttributes2.getResourceId(f.a.d.SkinTextAppearance_android_textColor, 0);
            obtainStyledAttributes2.recycle();
        }
        if (resourceId2 != 0) {
            TypedArray obtainStyledAttributes3 = context.obtainStyledAttributes(resourceId2, f.a.d.SkinTextAppearance);
            this.f17729d = obtainStyledAttributes3.getResourceId(f.a.d.SkinTextAppearance_android_textColor, 0);
            obtainStyledAttributes3.recycle();
        }
        TypedArray obtainStyledAttributes4 = context.obtainStyledAttributes(attributeSet, iArr, i, 0);
        int i2 = f.a.d.Toolbar_titleTextColor;
        if (obtainStyledAttributes4.hasValue(i2)) {
            this.f17728c = obtainStyledAttributes4.getResourceId(i2, 0);
        }
        int i3 = f.a.d.Toolbar_subtitleTextColor;
        if (obtainStyledAttributes4.hasValue(i3)) {
            this.f17729d = obtainStyledAttributes4.getResourceId(i3, 0);
        }
        obtainStyledAttributes4.recycle();
        c();
        b();
        a();
    }
}
