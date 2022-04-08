package com.tplink.libtpcontrols.colorpicker;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import com.tplink.libtpcontrols.colorpicker.TPArcColorView;
import com.tplink.libtpcontrols.s0;
import com.tplink.libtpcontrols.t0;
import com.tplink.libtpcontrols.x0;
import com.tplink.libtpcontrols.z0.e;

/* loaded from: classes3.dex */
public class TPArcColorLayout extends LinearLayout {

    /* renamed from: c  reason: collision with root package name */
    private TPArcColorView f12192c;

    /* renamed from: d  reason: collision with root package name */
    private ImageView f12193d;

    /* renamed from: f  reason: collision with root package name */
    int f12194f;
    private e p1;
    int q;
    int x;
    int y;
    private a z = null;
    private b p0 = null;

    /* loaded from: classes3.dex */
    public interface a {
        void a(int i, boolean z);
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(float f2, boolean z);
    }

    public TPArcColorLayout(Context context) {
        super(context);
        a(context, null);
    }

    private void a(Context context, AttributeSet attributeSet) {
        if (attributeSet == null) {
            this.f12194f = ContextCompat.getColor(context, 17170456);
            this.q = ContextCompat.getColor(context, 17170443);
            this.x = ContextCompat.getColor(context, 17170450);
            this.y = ContextCompat.getColor(context, 17170445);
        } else {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, x0.TPArcColorLayout);
            this.f12194f = obtainStyledAttributes.getColor(x0.TPArcColorLayout_tpc_start_color, ContextCompat.getColor(context, 17170456));
            this.q = obtainStyledAttributes.getColor(x0.TPArcColorLayout_tpc_middle_color, ContextCompat.getColor(context, 17170443));
            this.x = obtainStyledAttributes.getColor(x0.TPArcColorLayout_tpc_end_color, ContextCompat.getColor(context, 17170450));
            this.y = obtainStyledAttributes.getColor(x0.TPArcColorLayout_tpc_default_color, ContextCompat.getColor(context, 17170445));
            obtainStyledAttributes.recycle();
        }
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(t0.layout_automation_common_arc_color_picker, this);
        this.f12193d = (ImageView) findViewById(s0.img_center);
        TPArcColorView tPArcColorView = (TPArcColorView) findViewById(s0.arc_view);
        this.f12192c = tPArcColorView;
        tPArcColorView.setStartColor(this.f12194f);
        this.f12192c.setMiddleColor(this.q);
        this.f12192c.setEndColor(this.x);
        this.f12192c.setDefaultColor(this.y);
        this.f12193d.setColorFilter(this.q, PorterDuff.Mode.SRC_ATOP);
        this.f12192c.setOnColorChangedListener(new TPArcColorView.a() { // from class: com.tplink.libtpcontrols.colorpicker.a
            @Override // com.tplink.libtpcontrols.colorpicker.TPArcColorView.a
            public final void a(int i, boolean z) {
                TPArcColorLayout.this.c(i, z);
            }
        });
        this.f12192c.setOnProgressListener(new TPArcColorView.b() { // from class: com.tplink.libtpcontrols.colorpicker.c
            @Override // com.tplink.libtpcontrols.colorpicker.TPArcColorView.b
            public final void a(float f2, boolean z) {
                TPArcColorLayout.this.e(f2, z);
            }
        });
        this.f12192c.setOnTouchListener(new View.OnTouchListener() { // from class: com.tplink.libtpcontrols.colorpicker.d
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return TPArcColorLayout.this.g(view, motionEvent);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void c(int i, boolean z) {
        this.f12193d.setColorFilter(i, PorterDuff.Mode.SRC_ATOP);
        a aVar = this.z;
        if (aVar != null) {
            aVar.a(i, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public /* synthetic */ void e(float f2, boolean z) {
        b bVar = this.p0;
        if (bVar != null) {
            bVar.a(f2, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public /* synthetic */ boolean g(View view, MotionEvent motionEvent) {
        e eVar;
        if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
            e eVar2 = this.p1;
            if (eVar2 != null) {
                eVar2.a(true);
            }
        } else if ((motionEvent.getAction() == 0 || motionEvent.getAction() == 2) && (eVar = this.p1) != null) {
            eVar.a(false);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public /* synthetic */ void i(float f2) {
        this.f12192c.setProgress(f2);
    }

    public float getProgress() {
        TPArcColorView tPArcColorView = this.f12192c;
        if (tPArcColorView != null) {
            return tPArcColorView.getProgress();
        }
        return 0.0f;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            requestDisallowInterceptTouchEvent(false);
        } else {
            requestDisallowInterceptTouchEvent(true);
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setOnColorChangedListener(a aVar) {
        this.z = aVar;
    }

    public void setOnProgressListener(b bVar) {
        this.p0 = bVar;
    }

    public void setOnTouchCancelListener(e eVar) {
        this.p1 = eVar;
    }

    public void setProgress(final float f2) {
        TPArcColorView tPArcColorView = this.f12192c;
        if (tPArcColorView != null) {
            tPArcColorView.postDelayed(new Runnable() { // from class: com.tplink.libtpcontrols.colorpicker.b
                @Override // java.lang.Runnable
                public final void run() {
                    TPArcColorLayout.this.i(f2);
                }
            }, 300L);
        }
    }

    public TPArcColorLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet);
    }

    public TPArcColorLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context, attributeSet);
    }
}
