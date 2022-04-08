package com.tplink.iot.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.CompoundButton;
import androidx.appcompat.widget.SwitchCompat;
import com.tplink.libtpcontrols.z0.e;

/* loaded from: classes3.dex */
public class HomeSwitch extends SwitchCompat {

    /* renamed from: c  reason: collision with root package name */
    private b f11540c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f11541d = false;

    /* renamed from: f  reason: collision with root package name */
    private boolean f11542f = false;
    private e q;

    /* loaded from: classes3.dex */
    class a implements CompoundButton.OnCheckedChangeListener {
        a() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (HomeSwitch.this.f11540c != null) {
                HomeSwitch.this.f11540c.c(compoundButton, z, HomeSwitch.this.f11541d);
            }
            HomeSwitch.this.f11542f = true;
            HomeSwitch.this.f11541d = false;
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void c(CompoundButton compoundButton, boolean z, boolean z2);
    }

    public HomeSwitch(Context context) {
        super(context);
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x000e, code lost:
        if (r0 != 3) goto L_0x0026;
     */
    @Override // androidx.appcompat.widget.SwitchCompat, android.widget.TextView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r5) {
        /*
            r4 = this;
            int r0 = androidx.core.view.MotionEventCompat.getActionMasked(r5)
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x001b
            if (r0 == r2) goto L_0x0011
            r3 = 2
            if (r0 == r3) goto L_0x001b
            r3 = 3
            if (r0 == r3) goto L_0x0011
            goto L_0x0026
        L_0x0011:
            r4.f11542f = r1
            com.tplink.libtpcontrols.z0.e r0 = r4.q
            if (r0 == 0) goto L_0x0026
            r0.a(r2)
            goto L_0x0026
        L_0x001b:
            r4.f11541d = r2
            r4.f11542f = r1
            com.tplink.libtpcontrols.z0.e r0 = r4.q
            if (r0 == 0) goto L_0x0026
            r0.a(r1)
        L_0x0026:
            boolean r5 = super.onTouchEvent(r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tplink.iot.widget.HomeSwitch.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // androidx.appcompat.widget.SwitchCompat, android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z) {
        super.setChecked(z);
        if (!this.f11542f) {
            this.f11541d = false;
        }
    }

    public void setOnSwitchCheckedChangeListener(b bVar) {
        this.f11540c = bVar;
        setOnCheckedChangeListener(new a());
    }

    public void setOnTouchCancelListener(e eVar) {
        this.q = eVar;
    }

    public HomeSwitch(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public HomeSwitch(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
