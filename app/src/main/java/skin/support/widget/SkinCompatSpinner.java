package skin.support.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.DrawableRes;
import androidx.appcompat.widget.AppCompatSpinner;
import f.a.a;
import f.a.f.a.d;

/* loaded from: classes4.dex */
public class SkinCompatSpinner extends AppCompatSpinner implements g {

    /* renamed from: c  reason: collision with root package name */
    private static final String f17723c = SkinCompatSpinner.class.getSimpleName();

    /* renamed from: d  reason: collision with root package name */
    private static final int[] f17724d = {16843505};

    /* renamed from: f  reason: collision with root package name */
    private a f17725f;
    private int q;

    public SkinCompatSpinner(Context context) {
        this(context, null);
    }

    private void a() {
        int a = c.a(this.q);
        this.q = a;
        if (a != 0) {
            setPopupBackgroundDrawable(d.d(getContext(), this.q));
        }
    }

    @Override // androidx.appcompat.widget.AppCompatSpinner, android.widget.Spinner
    public void setPopupBackgroundResource(@DrawableRes int i) {
        super.setPopupBackgroundResource(i);
        this.q = i;
        a();
    }

    public SkinCompatSpinner(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.spinnerStyle);
    }

    public SkinCompatSpinner(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, -1);
    }

    public SkinCompatSpinner(Context context, AttributeSet attributeSet, int i, int i2) {
        this(context, attributeSet, i, i2, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x003b, code lost:
        if (r1 == null) goto L_0x0045;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public SkinCompatSpinner(android.content.Context r6, android.util.AttributeSet r7, int r8, int r9, android.content.res.Resources.Theme r10) {
        /*
            r5 = this;
            r5.<init>(r6, r7, r8, r9, r10)
            r10 = 0
            r5.q = r10
            int[] r0 = f.a.d.Spinner
            android.content.res.TypedArray r0 = r6.obtainStyledAttributes(r7, r0, r8, r10)
            android.content.Context r1 = r5.getPopupContext()
            if (r1 == 0) goto L_0x005c
            r1 = -1
            r2 = 1
            if (r9 != r1) goto L_0x0045
            int r1 = android.os.Build.VERSION.SDK_INT
            r3 = 11
            if (r1 < r3) goto L_0x0044
            r1 = 0
            int[] r3 = skin.support.widget.SkinCompatSpinner.f17724d     // Catch: all -> 0x0031, Exception -> 0x0033
            android.content.res.TypedArray r1 = r6.obtainStyledAttributes(r7, r3, r8, r10)     // Catch: all -> 0x0031, Exception -> 0x0033
            boolean r6 = r1.hasValue(r10)     // Catch: all -> 0x0031, Exception -> 0x0033
            if (r6 == 0) goto L_0x002d
            int r9 = r1.getInt(r10, r10)     // Catch: all -> 0x0031, Exception -> 0x0033
        L_0x002d:
            r1.recycle()
            goto L_0x0045
        L_0x0031:
            r6 = move-exception
            goto L_0x003e
        L_0x0033:
            r6 = move-exception
            java.lang.String r3 = skin.support.widget.SkinCompatSpinner.f17723c     // Catch: all -> 0x0031
            java.lang.String r4 = "Could not read android:spinnerMode"
            android.util.Log.i(r3, r4, r6)     // Catch: all -> 0x0031
            if (r1 == 0) goto L_0x0045
            goto L_0x002d
        L_0x003e:
            if (r1 == 0) goto L_0x0043
            r1.recycle()
        L_0x0043:
            throw r6
        L_0x0044:
            r9 = 1
        L_0x0045:
            if (r9 != r2) goto L_0x005c
            android.content.Context r6 = r5.getPopupContext()
            int[] r9 = f.a.d.Spinner
            android.content.res.TypedArray r6 = r6.obtainStyledAttributes(r7, r9, r8, r10)
            int r9 = f.a.d.Spinner_android_popupBackground
            int r9 = r6.getResourceId(r9, r10)
            r5.q = r9
            r6.recycle()
        L_0x005c:
            r0.recycle()
            skin.support.widget.a r6 = new skin.support.widget.a
            r6.<init>(r5)
            r5.f17725f = r6
            r6.c(r7, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: skin.support.widget.SkinCompatSpinner.<init>(android.content.Context, android.util.AttributeSet, int, int, android.content.res.Resources$Theme):void");
    }
}
