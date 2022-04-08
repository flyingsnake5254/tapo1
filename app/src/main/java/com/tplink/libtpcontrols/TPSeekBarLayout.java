package com.tplink.libtpcontrols;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.DrawableRes;
import com.tplink.libtpcontrols.materialnormalcompat.seekbar.DiscreteSeekBar;
import com.tplink.libtpcontrols.z0.e;

/* loaded from: classes3.dex */
public class TPSeekBarLayout extends LinearLayout {
    private b H3;
    private e I3;

    /* renamed from: c  reason: collision with root package name */
    private View f12154c;

    /* renamed from: d  reason: collision with root package name */
    private DiscreteSeekBar f12155d;

    /* renamed from: f  reason: collision with root package name */
    private ImageView f12156f;
    private int p0;
    private boolean p1;
    private Bitmap[] p2;
    private Bitmap[] p3;
    private ImageView q;
    private int x;
    private int y;
    private boolean z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements DiscreteSeekBar.d {
        a() {
        }

        @Override // com.tplink.libtpcontrols.materialnormalcompat.seekbar.DiscreteSeekBar.d
        public void a(DiscreteSeekBar discreteSeekBar) {
            if (TPSeekBarLayout.this.p1) {
                TPSeekBarLayout.this.setBrightness(true);
            }
        }

        @Override // com.tplink.libtpcontrols.materialnormalcompat.seekbar.DiscreteSeekBar.d
        public void b(DiscreteSeekBar discreteSeekBar, int i, boolean z) {
            if (TPSeekBarLayout.this.H3 != null) {
                TPSeekBarLayout.this.H3.a(TPSeekBarLayout.this.f12154c, i, z);
            }
        }

        @Override // com.tplink.libtpcontrols.materialnormalcompat.seekbar.DiscreteSeekBar.d
        public void c(DiscreteSeekBar discreteSeekBar) {
            if (TPSeekBarLayout.this.p1) {
                TPSeekBarLayout.this.setBrightness(false);
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(View view, int i, boolean z);
    }

    public TPSeekBarLayout(Context context) {
        super(context);
        g(context, null);
    }

    private Bitmap[] e(@DrawableRes int i) {
        if (i == -1) {
            return null;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(getResources(), i, options);
        options.inSampleSize = 1;
        options.inJustDecodeBounds = false;
        return f(BitmapFactory.decodeResource(getResources(), i, options));
    }

    private Bitmap[] f(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        Bitmap[] bitmapArr = {bitmap.copy(Bitmap.Config.ARGB_8888, true), bitmap.copy(Bitmap.Config.ARGB_8888, true)};
        new Canvas(bitmapArr[1]).drawColor(this.x, PorterDuff.Mode.SRC_IN);
        if (!bitmap.isRecycled()) {
            bitmap.recycle();
        }
        return bitmapArr;
    }

    private void g(Context context, AttributeSet attributeSet) {
        View inflate = LayoutInflater.from(context).inflate(t0.layout_float_seekbar, this);
        this.f12154c = inflate;
        this.f12155d = (DiscreteSeekBar) inflate.findViewById(s0.discrete);
        this.f12156f = (ImageView) this.f12154c.findViewById(s0.img_brightness_left);
        this.q = (ImageView) this.f12154c.findViewById(s0.img_brightness_right);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, x0.TPSeekBarLayout);
        this.x = obtainStyledAttributes.getColor(x0.TPSeekBarLayout_tp_seekbar_primmary_color, getResources().getColor(p0.common_tplink_yellow));
        this.y = obtainStyledAttributes.getColor(x0.TPSeekBarLayout_tp_seekbar_secondary_color, getResources().getColor(p0.seekbar_bg));
        this.z = obtainStyledAttributes.getBoolean(x0.TPSeekBarLayout_tp_seekbar_icon_colorable, false);
        this.p0 = obtainStyledAttributes.getDimensionPixelSize(x0.TPSeekBarLayout_tp_seekbar_left_icon_padding, -1);
        boolean z = obtainStyledAttributes.getBoolean(x0.TPSeekBarLayout_tp_seekbar_enable, true);
        this.p1 = z;
        this.f12155d.setEnabled(z);
        int resourceId = obtainStyledAttributes.getResourceId(x0.TPSeekBarLayout_tp_seekbar_left, u0.brightness_low);
        int resourceId2 = obtainStyledAttributes.getResourceId(x0.TPSeekBarLayout_tp_seekbar_right, u0.brightness);
        this.p2 = e(resourceId);
        this.p3 = e(resourceId2);
        obtainStyledAttributes.recycle();
        int i = this.p0;
        if (i > 0) {
            this.f12156f.setPadding(i, i, i, i);
        }
        DiscreteSeekBar discreteSeekBar = this.f12155d;
        int i2 = this.x;
        discreteSeekBar.r(i2, i2);
        this.f12155d.setScrubberColor(this.x);
        this.f12155d.setTrackColor(this.y);
        this.f12155d.setOnProgressChangeListener(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public /* synthetic */ void i(boolean z) {
        this.I3.a(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setBrightness(boolean z) {
        ImageView imageView = this.f12156f;
        Bitmap[] bitmapArr = this.p2;
        imageView.setImageBitmap(z ? bitmapArr[1] : bitmapArr[0]);
        this.q.setImageBitmap(z ? this.p3[1] : this.p3[0]);
    }

    public int getProgress() {
        return this.f12155d.getProgress();
    }

    @Override // android.view.View
    public boolean isEnabled() {
        return this.p1;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        this.p1 = z;
        this.f12155d.setEnabled(z);
    }

    public void setOnPositionChangeListener(b bVar) {
        this.H3 = bVar;
    }

    public void setOnTouchCancelListener(e eVar) {
        this.I3 = eVar;
        DiscreteSeekBar discreteSeekBar = this.f12155d;
        if (discreteSeekBar != null) {
            discreteSeekBar.setOnTouchCancelListener(new e() { // from class: com.tplink.libtpcontrols.e0
                @Override // com.tplink.libtpcontrols.z0.e
                public final void a(boolean z) {
                    TPSeekBarLayout.this.i(z);
                }
            });
        }
    }

    public void setProgress(int i) {
        this.f12155d.setProgress(i);
    }

    public TPSeekBarLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        g(context, attributeSet);
    }

    public TPSeekBarLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        g(context, attributeSet);
    }
}
