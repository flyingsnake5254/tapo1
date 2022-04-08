package com.tplink.libtpcontrols.materialnormalcompat.radio;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.CompoundButton;
import androidx.appcompat.widget.AppCompatRadioButton;

/* loaded from: classes3.dex */
public class TPRadioButton extends AppCompatRadioButton {

    /* renamed from: c  reason: collision with root package name */
    private a f12344c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f12345d = false;

    /* renamed from: f  reason: collision with root package name */
    private boolean f12346f = false;

    /* loaded from: classes3.dex */
    public interface a {
        void c(CompoundButton compoundButton, boolean z, boolean z2);
    }

    public TPRadioButton(Context context) {
        super(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void c(CompoundButton compoundButton, boolean z) {
        a aVar = this.f12344c;
        if (aVar != null) {
            aVar.c(compoundButton, z, this.f12345d);
        }
        this.f12346f = true;
        this.f12345d = false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x000e, code lost:
        if (r0 != 3) goto L_0x0018;
     */
    @Override // android.widget.TextView, android.view.View
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
            if (r0 == 0) goto L_0x0014
            if (r0 == r2) goto L_0x0011
            r3 = 2
            if (r0 == r3) goto L_0x0014
            r2 = 3
            if (r0 == r2) goto L_0x0011
            goto L_0x0018
        L_0x0011:
            r4.f12346f = r1
            goto L_0x0018
        L_0x0014:
            r4.f12345d = r2
            r4.f12346f = r1
        L_0x0018:
            boolean r5 = super.onTouchEvent(r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tplink.libtpcontrols.materialnormalcompat.radio.TPRadioButton.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z) {
        super.setChecked(z);
        if (!this.f12346f) {
            this.f12345d = false;
        }
    }

    public void setOnCheckedChangeListener(a aVar) {
        this.f12344c = aVar;
        setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.tplink.libtpcontrols.materialnormalcompat.radio.a
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                TPRadioButton.this.c(compoundButton, z);
            }
        });
    }

    public TPRadioButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public TPRadioButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
