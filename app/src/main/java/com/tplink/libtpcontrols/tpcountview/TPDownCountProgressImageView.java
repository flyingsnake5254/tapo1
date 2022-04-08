package com.tplink.libtpcontrols.tpcountview;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tplink.libtpcontrols.s0;
import com.tplink.libtpcontrols.t0;
import com.tplink.libtpcontrols.tpcountview.TPCircleProgressImageView;
import com.tplink.libtpcontrols.x0;
import io.reactivex.e0.c;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public class TPDownCountProgressImageView extends FrameLayout {
    private TPCircleProgressImageView p0;
    private TextView p1;
    private View p2;
    private a p3;
    private c z;

    /* renamed from: c  reason: collision with root package name */
    private int f12425c = 120;

    /* renamed from: d  reason: collision with root package name */
    private int f12426d = 120;

    /* renamed from: f  reason: collision with root package name */
    private boolean f12427f = false;
    private long q = 1000;
    private TimeUnit x = TimeUnit.MILLISECONDS;
    private boolean y = false;

    /* loaded from: classes3.dex */
    public interface a {
        void a(View view, boolean z);
    }

    public TPDownCountProgressImageView(@NonNull Context context) {
        super(context);
    }

    private void a(Context context, AttributeSet attributeSet) {
        LayoutInflater.from(context).inflate(t0.layout_down_count_progress, (ViewGroup) this, true);
        this.p2 = this;
        TPCircleProgressImageView tPCircleProgressImageView = (TPCircleProgressImageView) findViewById(s0.image_view);
        this.p0 = tPCircleProgressImageView;
        tPCircleProgressImageView.setOnAnimCompleteListener(new TPCircleProgressImageView.d() { // from class: com.tplink.libtpcontrols.tpcountview.a
            @Override // com.tplink.libtpcontrols.tpcountview.TPCircleProgressImageView.d
            public final void a(boolean z) {
                TPDownCountProgressImageView.this.c(z);
            }
        });
        this.p1 = (TextView) findViewById(s0.text);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, x0.TPDownCountProgressImageView);
        int dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(x0.TPDownCountProgressImageView_cpi_center_size, -1);
        if (dimensionPixelOffset != -1) {
            this.p0.setIconCenterSize(dimensionPixelOffset);
        }
        int resourceId = obtainStyledAttributes.getResourceId(x0.TPDownCountProgressImageView_cpi_center_image, -1);
        if (resourceId != -1) {
            this.p0.setCenterImageResource(resourceId);
        }
        int color = obtainStyledAttributes.getColor(x0.TPDownCountProgressImageView_bur_center_color, -1);
        if (color != -1) {
            this.p0.setBurCenterColor(color);
        }
        int color2 = obtainStyledAttributes.getColor(x0.TPDownCountProgressImageView_hook_color, -1);
        if (color2 != -1) {
            this.p0.setHookColor(color2);
        }
        int color3 = obtainStyledAttributes.getColor(x0.TPDownCountProgressImageView_arc_color, -1);
        if (color3 != -1) {
            this.p0.setArcColor(color3);
        }
        int color4 = obtainStyledAttributes.getColor(x0.TPDownCountProgressImageView_circle_color, -1);
        if (color4 != -1) {
            this.p0.setCircleColor(color4);
        }
        float dimensionPixelOffset2 = obtainStyledAttributes.getDimensionPixelOffset(x0.TPDownCountProgressImageView_hook_width, -1);
        if (dimensionPixelOffset2 != -1.0f) {
            this.p0.setHookWidth(dimensionPixelOffset2);
        }
        float dimensionPixelOffset3 = obtainStyledAttributes.getDimensionPixelOffset(x0.TPDownCountProgressImageView_arc_width, -1);
        if (dimensionPixelOffset3 != -1.0f) {
            this.p0.setArcWidth(dimensionPixelOffset3);
        }
        float dimensionPixelOffset4 = obtainStyledAttributes.getDimensionPixelOffset(x0.TPDownCountProgressImageView_circle_padding, -1);
        int i = (dimensionPixelOffset4 > (-1.0f) ? 1 : (dimensionPixelOffset4 == (-1.0f) ? 0 : -1));
        if (i != 0) {
            this.p0.setCirclePadding(dimensionPixelOffset4);
        }
        float dimensionPixelOffset5 = obtainStyledAttributes.getDimensionPixelOffset(x0.TPDownCountProgressImageView_hook_padding, -1);
        if (i != 0) {
            this.p0.setHookPadding(dimensionPixelOffset5);
        }
        int i2 = x0.TPDownCountProgressImageView_inner_arc;
        if (obtainStyledAttributes.hasValue(i2)) {
            this.p0.setInnerArc(obtainStyledAttributes.getBoolean(i2, false));
        }
        int resourceId2 = obtainStyledAttributes.getResourceId(x0.TPDownCountProgressImageView_android_textAppearance, -1);
        if (resourceId2 != -1) {
            this.p1.setTextAppearance(context, resourceId2);
        }
        int i3 = obtainStyledAttributes.getInt(x0.TPDownCountProgressImageView_cpi_max_down_count, 120);
        this.f12425c = i3;
        this.f12426d = i3;
        obtainStyledAttributes.recycle();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void c(boolean z) {
        a aVar = this.p3;
        if (aVar != null) {
            aVar.a(this.p2, z);
        }
    }

    private void d() {
        c cVar = this.z;
        if (cVar != null && !cVar.isDisposed()) {
            this.z.dispose();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        c cVar = this.z;
        if (cVar != null && !cVar.isDisposed()) {
            this.z.dispose();
        }
    }

    public void setEnable(boolean z) {
        this.f12427f = z;
        setClickable(z);
        TPCircleProgressImageView tPCircleProgressImageView = this.p0;
        if (tPCircleProgressImageView != null) {
            tPCircleProgressImageView.setDisableView(!z);
        }
        if (!z) {
            TPCircleProgressImageView tPCircleProgressImageView2 = this.p0;
            if (tPCircleProgressImageView2 != null) {
                tPCircleProgressImageView2.o();
            }
            d();
            this.p1.setText("");
            this.f12426d = this.f12425c;
        }
    }

    public void setMaxProgressNumber(int i) {
        this.f12425c = i;
    }

    public void setNormalProgressNumber(int i) {
        this.f12426d = i;
    }

    public void setOnProgressCompleteListener(a aVar) {
        this.p3 = aVar;
    }

    public TPDownCountProgressImageView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet);
    }

    public TPDownCountProgressImageView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context, attributeSet);
    }
}
