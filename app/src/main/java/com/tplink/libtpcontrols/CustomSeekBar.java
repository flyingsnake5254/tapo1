package com.tplink.libtpcontrols;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.SeekBar;
import androidx.appcompat.widget.AppCompatSeekBar;
import androidx.core.text.TextUtilsCompat;

/* loaded from: classes3.dex */
public class CustomSeekBar extends AppCompatSeekBar implements SeekBar.OnSeekBarChangeListener {
    private float H3;
    private float J3;
    private String K3;

    /* renamed from: c  reason: collision with root package name */
    private int f12032c;

    /* renamed from: d  reason: collision with root package name */
    private float f12033d;

    /* renamed from: f  reason: collision with root package name */
    private String f12034f;
    private float p0;
    private float p1;
    private float p2;
    Paint p3;
    private String q;
    private String x;
    private String y;
    private float z;
    private int I3 = 1;
    private a L3 = null;

    /* loaded from: classes3.dex */
    public interface a {
        void onProgressChanged(SeekBar seekBar, int i, boolean z);

        void onStartTrackingTouch(SeekBar seekBar);

        void onStopTrackingTouch(SeekBar seekBar);
    }

    public CustomSeekBar(Context context) {
        super(context);
    }

    private void a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, x0.CustomSeekBar);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = obtainStyledAttributes.getIndex(i);
            if (index == x0.CustomSeekBar_text_size) {
                this.f12033d = obtainStyledAttributes.getDimension(index, 14.0f);
            } else if (index == x0.CustomSeekBar_text_color) {
                this.f12032c = obtainStyledAttributes.getColor(index, getResources().getColor(p0.common_tplink_green));
            } else if (index == x0.CustomSeekBar_text_start) {
                this.q = obtainStyledAttributes.getString(index);
            } else if (index == x0.CustomSeekBar_text_mid) {
                this.x = obtainStyledAttributes.getString(index);
            } else if (index == x0.CustomSeekBar_text_end) {
                this.y = obtainStyledAttributes.getString(index);
            } else if (index == x0.CustomSeekBar_text_margin) {
                this.z = obtainStyledAttributes.getDimension(index, 10.0f);
            } else if (index == x0.CustomSeekBar_text_holder_width) {
                this.p0 = obtainStyledAttributes.getDimension(index, 30.0f);
            } else if (index == x0.CustomSeekBar_text_holder_height) {
                this.p1 = obtainStyledAttributes.getDimension(index, 20.0f);
            } else if (index == x0.CustomSeekBar_text_offset) {
                this.p2 = obtainStyledAttributes.getDimension(index, 0.0f);
            } else if (index == x0.CustomSeekBar_text_family) {
                this.K3 = obtainStyledAttributes.getString(index);
            }
        }
        obtainStyledAttributes.recycle();
        Paint paint = new Paint();
        this.p3 = paint;
        paint.setAntiAlias(true);
        this.p3.setTextSize(this.f12033d);
        this.p3.setColor(this.f12032c);
        if (TextUtils.isEmpty(this.K3)) {
            this.K3 = "sans-serif";
        }
        Typeface create = Typeface.create(this.K3, 0);
        if (create != null) {
            this.p3.setTypeface(create);
        }
        setPadding(((int) Math.ceil(this.p0)) / 2, ((int) Math.ceil(this.p1)) + 10, ((int) Math.ceil(this.p0)) / 2, ((int) Math.ceil(this.p1)) + 10);
        if (getProgress() < getMax() / 4) {
            this.f12034f = this.q;
            setProgress(0);
        } else if (getProgress() > (getMax() * 3) / 4) {
            this.f12034f = this.y;
            setProgress(getMax());
        } else {
            this.f12034f = this.x;
            setProgress(getMax() / 2);
        }
        setOnSeekBarChangeListener(this);
    }

    private void c() {
        Paint.FontMetrics fontMetrics = this.p3.getFontMetrics();
        this.H3 = this.p3.measureText(this.f12034f);
        float f2 = fontMetrics.descent;
        this.J3 = ((this.p1 / 2.0f) - f2) + ((f2 - fontMetrics.ascent) / 2.0f);
    }

    protected boolean b() {
        return TextUtilsCompat.getLayoutDirectionFromLocale(getContext().getResources().getConfiguration().locale) == 1;
    }

    public String getTitleText() {
        return this.f12034f;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.AppCompatSeekBar, android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public synchronized void onDraw(Canvas canvas) {
        float width;
        float f2;
        float f3;
        float f4;
        float f5;
        super.onDraw(canvas);
        c();
        Rect bounds = getProgressDrawable().getBounds();
        if (b()) {
            width = (bounds.width() * (getMax() - getProgress())) / getMax();
            f2 = this.p0;
            f3 = this.H3;
        } else {
            width = (bounds.width() * getProgress()) / getMax();
            f2 = this.p0;
            f3 = this.H3;
        }
        float f6 = width + ((f2 - f3) / 2.0f);
        int i = this.I3;
        if (i == 1) {
            if (b()) {
                f4 = this.p2;
                f6 -= f4;
            } else {
                f5 = this.p2;
                f6 += f5;
            }
        } else if (i != 3) {
            this.f12034f = this.x;
        } else if (b()) {
            f5 = this.p2;
            f6 += f5;
        } else {
            f4 = this.p2;
            f6 -= f4;
        }
        canvas.drawText(this.f12034f, f6, ((float) ((bounds.height() + this.J3) + ((this.p1 * 0.16d) / 2.0d))) - this.z, this.p3);
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        invalidate();
        a aVar = this.L3;
        if (aVar != null) {
            aVar.onProgressChanged(seekBar, i, z);
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar seekBar) {
        a aVar = this.L3;
        if (aVar != null) {
            aVar.onStartTrackingTouch(seekBar);
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStopTrackingTouch(SeekBar seekBar) {
        if (seekBar.getProgress() < seekBar.getMax() / 4) {
            seekBar.setProgress(0);
            this.I3 = 1;
            setTitleText(this.q);
        } else if (seekBar.getProgress() >= (seekBar.getMax() * 3) / 4) {
            seekBar.setProgress(seekBar.getMax());
            this.I3 = 3;
            setTitleText(this.y);
        } else {
            seekBar.setProgress(seekBar.getMax() / 2);
            this.I3 = 2;
            setTitleText(this.x);
        }
        invalidate();
        a aVar = this.L3;
        if (aVar != null) {
            aVar.onStopTrackingTouch(seekBar);
        }
    }

    @Override // android.widget.AbsSeekBar, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 2) {
            setTitleText("");
        } else if (motionEvent.getAction() == 1) {
            if (getProgress() < getMax() / 4) {
                setTitleText(this.q);
                this.I3 = 1;
            } else if (getProgress() < getMax() / 4 || getProgress() >= (getMax() * 3) / 4) {
                setTitleText(this.y);
                this.I3 = 3;
            } else {
                setTitleText(this.x);
                this.I3 = 2;
            }
        }
        invalidate();
        return super.onTouchEvent(motionEvent);
    }

    public void setOnCustomSeekBarChangeListener(a aVar) {
        this.L3 = aVar;
    }

    public void setSeekBarProgress(int i) {
        setProgress(i);
        if (i < getMax() / 4) {
            setProgress(0);
            this.I3 = 1;
            setTitleText(this.q);
        } else if (i >= (getMax() * 3) / 4) {
            setProgress(getMax());
            this.I3 = 3;
            setTitleText(this.y);
        } else {
            setProgress(getMax() / 2);
            this.I3 = 2;
            setTitleText(this.x);
        }
        invalidate();
    }

    public void setTitleText(String str) {
        this.f12034f = str;
    }

    public CustomSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet);
    }

    public CustomSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context, attributeSet);
    }
}
