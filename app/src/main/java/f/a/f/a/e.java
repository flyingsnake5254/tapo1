package f.a.f.a;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.annotation.RequiresApi;
import androidx.appcompat.R;
import androidx.core.graphics.ColorUtils;

/* compiled from: SkinCompatThemeUtils.java */
/* loaded from: classes4.dex */
public class e {
    private static final ThreadLocal<TypedValue> a = new ThreadLocal<>();

    /* renamed from: b  reason: collision with root package name */
    static final int[] f15586b = {-16842910};

    /* renamed from: c  reason: collision with root package name */
    static final int[] f15587c = {16842910};

    /* renamed from: d  reason: collision with root package name */
    static final int[] f15588d = {16842909};

    /* renamed from: e  reason: collision with root package name */
    static final int[] f15589e = {16842908};

    /* renamed from: f  reason: collision with root package name */
    static final int[] f15590f = {16843518};
    static final int[] g = {16843547};
    static final int[] h = {16843623};
    static final int[] i = {16843624};
    static final int[] j = {16843625};
    static final int[] k = {16842919};
    static final int[] l = {16842912};
    static final int[] m = {16842913};
    static final int[] n = {-16842919, -16842908};
    static final int[] o = new int[0];
    private static final int[] p = new int[1];
    private static final int[] q = {R.attr.colorPrimary};
    private static final int[] r = {R.attr.colorPrimaryDark};
    private static final int[] s = {R.attr.colorAccent};

    public static int a(Context context) {
        return c(context, r);
    }

    public static int b(Context context, int i2) {
        ColorStateList g2 = g(context, i2);
        if (g2 != null && g2.isStateful()) {
            return g2.getColorForState(f15586b, g2.getDefaultColor());
        }
        TypedValue h2 = h();
        context.getTheme().resolveAttribute(16842803, h2, true);
        return f(context, i2, h2.getFloat());
    }

    private static int c(Context context, int[] iArr) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(iArr);
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        obtainStyledAttributes.recycle();
        return resourceId;
    }

    @RequiresApi(api = 21)
    public static int d(Context context) {
        return c(context, new int[]{16843857});
    }

    public static int e(Context context, int i2) {
        int[] iArr = p;
        iArr[0] = i2;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes((AttributeSet) null, iArr);
        try {
            int resourceId = obtainStyledAttributes.getResourceId(0, 0);
            if (resourceId != 0) {
                return d.a(context, resourceId);
            }
            return 0;
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    static int f(Context context, int i2, float f2) {
        int e2 = e(context, i2);
        return ColorUtils.setAlphaComponent(e2, Math.round(Color.alpha(e2) * f2));
    }

    public static ColorStateList g(Context context, int i2) {
        int[] iArr = p;
        iArr[0] = i2;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes((AttributeSet) null, iArr);
        try {
            int resourceId = obtainStyledAttributes.getResourceId(0, 0);
            if (resourceId != 0) {
                return d.b(context, resourceId);
            }
            return null;
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    private static TypedValue h() {
        ThreadLocal<TypedValue> threadLocal = a;
        TypedValue typedValue = threadLocal.get();
        if (typedValue != null) {
            return typedValue;
        }
        TypedValue typedValue2 = new TypedValue();
        threadLocal.set(typedValue2);
        return typedValue2;
    }

    public static int i(Context context) {
        return c(context, new int[]{16842836});
    }
}
