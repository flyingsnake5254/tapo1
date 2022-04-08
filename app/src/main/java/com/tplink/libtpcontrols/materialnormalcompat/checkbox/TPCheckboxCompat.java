package com.tplink.libtpcontrols.materialnormalcompat.checkbox;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.CompoundButton;
import androidx.appcompat.widget.AppCompatCheckBox;

/* loaded from: classes3.dex */
public class TPCheckboxCompat extends AppCompatCheckBox {

    /* renamed from: c  reason: collision with root package name */
    private a f12320c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f12321d = false;

    /* renamed from: f  reason: collision with root package name */
    private boolean f12322f = false;

    /* loaded from: classes3.dex */
    public interface a {
        void c(CompoundButton compoundButton, boolean z, boolean z2);
    }

    public TPCheckboxCompat(Context context) {
        super(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void b(CompoundButton compoundButton, boolean z) {
        a aVar = this.f12320c;
        if (aVar != null) {
            aVar.c(compoundButton, z, this.f12321d);
        }
        this.f12322f = true;
        this.f12321d = false;
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
            r4.f12322f = r1
            goto L_0x0018
        L_0x0014:
            r4.f12321d = r2
            r4.f12322f = r1
        L_0x0018:
            boolean r5 = super.onTouchEvent(r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tplink.libtpcontrols.materialnormalcompat.checkbox.TPCheckboxCompat.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z) {
        super.setChecked(z);
        if (!this.f12322f) {
            this.f12321d = false;
        }
    }

    public void setOnCheckedChangeListener(a aVar) {
        this.f12320c = aVar;
        setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.tplink.libtpcontrols.materialnormalcompat.checkbox.a
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                TPCheckboxCompat.this.b(compoundButton, z);
            }
        });
    }

    public TPCheckboxCompat(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public TPCheckboxCompat(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
