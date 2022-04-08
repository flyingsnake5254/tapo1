package com.tplink.libtpcontrols.shadow;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.content.ContextCompat;
import com.tplink.libtpcontrols.p0;
import com.tplink.libtpcontrols.s0;
import com.tplink.libtpcontrols.t0;
import com.tplink.libtpcontrols.x0;

/* loaded from: classes3.dex */
public class TPShadowButton extends FrameLayout {
    private int H3;
    private int I3;
    private View J3;
    private boolean K3;

    /* renamed from: c  reason: collision with root package name */
    private final float f12392c;

    /* renamed from: d  reason: collision with root package name */
    private final float f12393d;

    /* renamed from: f  reason: collision with root package name */
    private final int f12394f;
    private float p0;
    private float p1;
    private View p2;
    private String p3;
    private AppCompatButton q;
    private TPShadowLayout x;
    private int y;
    private int z;

    public TPShadowButton(Context context) {
        this(context, null, 0);
    }

    private void a(Context context, AttributeSet attributeSet) {
        View inflate = LayoutInflater.from(context).inflate(t0.shadow_button_main, (ViewGroup) this, true);
        this.p2 = inflate;
        this.q = (AppCompatButton) inflate.findViewById(s0.sb_button);
        this.x = (TPShadowLayout) this.p2.findViewById(s0.sb_shadow);
        this.J3 = this.p2.findViewById(s0.button_background_cover);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, x0.TPShadowButton);
        this.q.setBackground(obtainStyledAttributes.getDrawable(x0.TPShadowButton_sb_background));
        this.p0 = obtainStyledAttributes.getDimension(x0.TPShadowButton_sb_shadow_radius, this.f12392c);
        this.p1 = obtainStyledAttributes.getDimension(x0.TPShadowButton_sb_shadow_corner_radius, this.f12393d);
        this.y = obtainStyledAttributes.getColor(x0.TPShadowButton_sb_shadow_color_normal, ContextCompat.getColor(context, p0.common_tplink_teal));
        this.z = obtainStyledAttributes.getColor(x0.TPShadowButton_sb_shadow_color_pressed, ContextCompat.getColor(context, p0.common_tplink_teal_pressed));
        String string = obtainStyledAttributes.getString(x0.TPShadowButton_android_text);
        this.p3 = string;
        this.q.setText(string);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(x0.TPShadowButton_android_textSize, this.f12394f);
        this.H3 = dimensionPixelSize;
        this.q.setTextSize(0, dimensionPixelSize);
        int color = obtainStyledAttributes.getColor(x0.TPShadowButton_android_textColor, ContextCompat.getColor(context, p0.white));
        this.I3 = color;
        this.q.setTextColor(color);
        post(new Runnable() { // from class: com.tplink.libtpcontrols.shadow.a
            @Override // java.lang.Runnable
            public final void run() {
                TPShadowButton.this.e();
            }
        });
        this.q.setEnabled(isEnabled());
        obtainStyledAttributes.recycle();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void c() {
        if (!this.K3) {
            this.x.setShadowColor(this.z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public /* synthetic */ void e() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.x.getLayoutParams();
        layoutParams.topMargin = (int) this.p0;
        this.x.setLayoutParams(layoutParams);
        this.x.setShadowRadius(this.p0);
        this.x.setShadowCornerRadius(this.p1);
        this.x.setShadowColor(this.y);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.q.getLayoutParams();
        layoutParams2.bottomMargin = (int) this.p0;
        this.q.setLayoutParams(layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.J3.getLayoutParams();
        layoutParams3.bottomMargin = (int) this.p0;
        this.J3.setLayoutParams(layoutParams3);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.K3 = false;
            postDelayed(new Runnable() { // from class: com.tplink.libtpcontrols.shadow.b
                @Override // java.lang.Runnable
                public final void run() {
                    TPShadowButton.this.c();
                }
            }, 200L);
        } else if (action == 1 || action == 3) {
            this.K3 = true;
            this.x.setShadowColor(this.y);
            performClick();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        this.q.setEnabled(z);
    }

    public void setText(int i) {
        this.q.setText(i);
    }

    public TPShadowButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void setText(CharSequence charSequence) {
        this.q.setText(charSequence);
    }

    public TPShadowButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f12392c = getResources().getDisplayMetrics().density * 6.0f;
        this.f12393d = getResources().getDisplayMetrics().density * 18.0f;
        this.f12394f = (int) (getResources().getDisplayMetrics().density * 18.0f);
        this.y = -1;
        this.z = -1;
        this.H3 = 15;
        this.I3 = -1;
        this.K3 = false;
        a(context, attributeSet);
    }
}
