package com.tplink.iot.devices.lightstrip.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.SeekBar;
import androidx.annotation.ColorInt;
import androidx.core.view.ViewCompat;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.i;
import kotlin.collections.n;
import kotlin.collections.o;
import kotlin.collections.s;
import kotlin.jvm.b.l;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.j;
import kotlin.p;
import kotlin.v.d;

/* compiled from: DiscreteSeekBarTextView.kt */
/* loaded from: classes2.dex */
public final class DiscreteSeekBarTextView extends View implements SeekBar.OnSeekBarChangeListener {
    private SeekBar.OnSeekBarChangeListener H3;

    /* renamed from: c  reason: collision with root package name */
    private int f7771c;

    /* renamed from: d  reason: collision with root package name */
    private int f7772d;

    /* renamed from: f  reason: collision with root package name */
    private float f7773f;
    private float p0;
    private int p1;
    private float p2;
    private a p3;
    private final List<Integer> q;
    private Float[] x;
    private List<String> y;
    private final Paint z;

    /* compiled from: DiscreteSeekBarTextView.kt */
    /* loaded from: classes2.dex */
    public interface a {
        String format(int i);
    }

    /* compiled from: DiscreteSeekBarTextView.kt */
    /* loaded from: classes2.dex */
    public static final class b implements a {
        final /* synthetic */ l a;

        b(l lVar) {
            this.a = lVar;
        }

        @Override // com.tplink.iot.devices.lightstrip.widget.DiscreteSeekBarTextView.a
        public String format(int i) {
            return (String) this.a.invoke(Integer.valueOf(i));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DiscreteSeekBarTextView.kt */
    /* loaded from: classes2.dex */
    public static final class c implements Runnable {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ SeekBar f7775d;

        c(SeekBar seekBar) {
            this.f7775d = seekBar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            DiscreteSeekBarTextView.this.p1 = this.f7775d.getProgress();
            DiscreteSeekBarTextView.this.invalidate();
        }
    }

    public DiscreteSeekBarTextView(Context context) {
        this(context, null, 0, 6, null);
    }

    public DiscreteSeekBarTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ DiscreteSeekBarTextView(Context context, AttributeSet attributeSet, int i, int i2, f fVar) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    private final void b() {
        this.z.setTextSize(this.f7773f);
        Paint.FontMetrics fontMetrics = this.z.getFontMetrics();
        this.p0 = (-(fontMetrics.ascent + fontMetrics.descent)) / 2.0f;
    }

    private final String c(int i) {
        String format;
        a aVar = this.p3;
        return (aVar == null || (format = aVar.format(i)) == null) ? String.valueOf(i) : format;
    }

    private final float d(int i) {
        Context context = getContext();
        j.d(context, "context");
        Resources resources = context.getResources();
        j.d(resources, "context.resources");
        return TypedValue.applyDimension(2, i, resources.getDisplayMetrics());
    }

    public static /* synthetic */ void f(DiscreteSeekBarTextView discreteSeekBarTextView, SeekBar seekBar, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        discreteSeekBarTextView.e(seekBar, z);
    }

    public final void e(SeekBar seekBar, boolean z) {
        j.e(seekBar, "seekBar");
        this.q.clear();
        s.p(this.q, new d(0, seekBar.getMax()));
        int size = this.q.size();
        Float[] fArr = new Float[size];
        for (int i = 0; i < size; i++) {
            fArr[i] = Float.valueOf(0.0f);
        }
        this.x = fArr;
        seekBar.setOnSeekBarChangeListener(this);
        if (this.q.size() < 2 || !z) {
            setPadding((seekBar.getPaddingLeft() + getPaddingLeft()) - 8, getPaddingTop(), (seekBar.getPaddingRight() + getPaddingRight()) - 8, getPaddingBottom());
        } else {
            setPadding((int) (seekBar.getPaddingLeft() - (this.z.measureText(c(((Number) kotlin.collections.l.x(this.q)).intValue())) / 2.0f)), getPaddingTop(), (int) (seekBar.getPaddingRight() - (this.z.measureText(c(((Number) kotlin.collections.l.F(this.q)).intValue())) / 2.0f)), getPaddingBottom());
        }
        invalidate();
        seekBar.post(new c(seekBar));
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        j.e(canvas, "canvas");
        float paddingTop = ((getPaddingTop() + getHeight()) - getPaddingBottom()) / 2.0f;
        float paddingLeft = getPaddingLeft();
        int size = this.q.size();
        int i = 0;
        while (i < size) {
            this.z.setColor(i == this.p1 ? this.f7772d : this.f7771c);
            canvas.drawText(this.y.get(i), paddingLeft, this.p0 + paddingTop, this.z);
            paddingLeft += this.x[i].floatValue() + this.p2;
            i++;
        }
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int l;
        float w;
        super.onLayout(z, i, i2, i3, i4);
        List<Integer> list = this.q;
        l = o.l(list, 10);
        ArrayList arrayList = new ArrayList(l);
        for (Number number : list) {
            arrayList.add(c(number.intValue()));
        }
        this.y = arrayList;
        int size = this.q.size();
        for (int i5 = 0; i5 < size; i5++) {
            this.x[i5] = Float.valueOf(this.z.measureText(this.y.get(i5)));
        }
        w = i.w(this.x);
        this.p2 = (((getWidth() - getPaddingLeft()) - getPaddingRight()) - w) / Math.max(this.q.size() - 1, 1);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        Paint.FontMetrics fontMetrics = this.z.getFontMetrics();
        setMeasuredDimension(View.MeasureSpec.getSize(i), View.resolveSize(((int) ((-fontMetrics.top) + fontMetrics.bottom + 16.0f)) + getPaddingTop() + getPaddingBottom(), i2));
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        this.p1 = i;
        invalidate();
        SeekBar.OnSeekBarChangeListener onSeekBarChangeListener = this.H3;
        if (onSeekBarChangeListener != null) {
            onSeekBarChangeListener.onProgressChanged(seekBar, i, z);
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar seekBar) {
        SeekBar.OnSeekBarChangeListener onSeekBarChangeListener = this.H3;
        if (onSeekBarChangeListener != null) {
            onSeekBarChangeListener.onStartTrackingTouch(seekBar);
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStopTrackingTouch(SeekBar seekBar) {
        SeekBar.OnSeekBarChangeListener onSeekBarChangeListener = this.H3;
        if (onSeekBarChangeListener != null) {
            onSeekBarChangeListener.onStopTrackingTouch(seekBar);
        }
    }

    public final void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener listener) {
        j.e(listener, "listener");
        this.H3 = listener;
    }

    public final void setTextColor(@ColorInt int i) {
        this.z.setColor(i);
        invalidate();
    }

    public final void setTextSize(float f2) {
        this.f7773f = f2;
        b();
        requestLayout();
    }

    public final void setValueFormatter(a formatter) {
        j.e(formatter, "formatter");
        this.p3 = formatter;
        invalidate();
    }

    public final void setupWithSeekBar(SeekBar seekBar) {
        f(this, seekBar, false, 2, null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DiscreteSeekBarTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        List<Integer> h;
        int l;
        j.e(context, "context");
        this.f7771c = -12303292;
        this.f7772d = ViewCompat.MEASURED_STATE_MASK;
        this.f7773f = d(16);
        h = n.h(0, 1, 2);
        this.q = h;
        int size = h.size();
        Float[] fArr = new Float[size];
        for (int i2 = 0; i2 < size; i2++) {
            fArr[i2] = Float.valueOf(0.0f);
        }
        this.x = fArr;
        List<Integer> list = this.q;
        l = o.l(list, 10);
        ArrayList arrayList = new ArrayList(l);
        for (Number number : list) {
            arrayList.add(c(number.intValue()));
        }
        this.y = arrayList;
        Paint paint = new Paint(1);
        paint.setFakeBoldText(true);
        p pVar = p.a;
        this.z = paint;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.tplink.iot.b.DiscreteSeekBarTextView);
        this.f7771c = obtainStyledAttributes.getColor(1, this.f7771c);
        this.f7772d = obtainStyledAttributes.getColor(0, this.f7772d);
        this.f7773f = obtainStyledAttributes.getDimension(2, this.f7773f);
        obtainStyledAttributes.recycle();
        paint.setColor(this.f7771c);
        b();
    }

    public final void setValueFormatter(l<? super Integer, String> formatter) {
        j.e(formatter, "formatter");
        this.p3 = new b(formatter);
        invalidate();
    }
}
