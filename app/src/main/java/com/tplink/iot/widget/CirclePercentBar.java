package com.tplink.iot.widget;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.tplink.iot.R;

/* loaded from: classes3.dex */
public class CirclePercentBar extends FrameLayout {
    private int H3;
    private Paint I3;
    private Paint J3;
    private ValueAnimator K3;
    private TimeInterpolator L3;
    private c M3;

    /* renamed from: c  reason: collision with root package name */
    private Context f11490c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f11491d;

    /* renamed from: f  reason: collision with root package name */
    private ImageView f11492f;
    private int p0;
    private RectF p1;
    private int p2;
    private int p3;
    private int q;
    private int x;
    private int y;
    private int z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (CirclePercentBar.this.M3 != null) {
                CirclePercentBar.this.M3.n();
            }
        }
    }

    /* loaded from: classes3.dex */
    class b implements ValueAnimator.AnimatorUpdateListener {
        b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            CirclePercentBar.this.p2 = intValue;
            if (intValue < 100) {
                CirclePercentBar.this.f11491d.setVisibility(0);
                CirclePercentBar.this.f11492f.setVisibility(8);
            } else {
                CirclePercentBar.this.f11491d.setVisibility(8);
                CirclePercentBar circlePercentBar = CirclePercentBar.this;
                circlePercentBar.setBackgroundResource(circlePercentBar.p0);
                CirclePercentBar circlePercentBar2 = CirclePercentBar.this;
                circlePercentBar2.y = circlePercentBar2.z / 2;
                CirclePercentBar.this.requestLayout();
            }
            CirclePercentBar.this.invalidate();
        }
    }

    /* loaded from: classes3.dex */
    public interface c {
        void n();
    }

    public CirclePercentBar(Context context) {
        this(context, null);
    }

    private void h() {
        Paint paint = new Paint(1);
        this.J3 = paint;
        paint.setStyle(Paint.Style.STROKE);
        this.J3.setStrokeWidth(this.x);
        this.J3.setColor(this.q);
        this.J3.setStrokeCap(Paint.Cap.BUTT);
        this.J3.setStrokeJoin(Paint.Join.ROUND);
        Paint paint2 = new Paint(1);
        this.I3 = paint2;
        paint2.setStyle(Paint.Style.STROKE);
        this.I3.setStrokeWidth(this.x);
        this.I3.setStrokeCap(Paint.Cap.BUTT);
        this.I3.setStrokeJoin(Paint.Join.ROUND);
        this.p1 = new RectF();
    }

    private void i(Context context, AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.tplink.iot.b.CirclePercentBar, i, 0);
        this.q = obtainStyledAttributes.getColor(2, -1);
        this.x = obtainStyledAttributes.getDimensionPixelSize(4, 3);
        int color = obtainStyledAttributes.getColor(7, 3355443);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(8, 16);
        this.y = obtainStyledAttributes.getDimensionPixelSize(3, 27);
        this.p3 = obtainStyledAttributes.getColor(1, ContextCompat.getColor(this.f11490c, R.color.common_iot_main_blue));
        this.H3 = obtainStyledAttributes.getColor(0, ContextCompat.getColor(this.f11490c, R.color.common_iot_main_blue));
        this.p0 = obtainStyledAttributes.getResourceId(5, R.mipmap.download_success);
        this.z = obtainStyledAttributes.getDimensionPixelSize(6, 54);
        obtainStyledAttributes.recycle();
        View inflate = LayoutInflater.from(context).inflate(R.layout.view_percent, (ViewGroup) this, true);
        TextView textView = (TextView) inflate.findViewById(R.id.tv_process);
        this.f11491d = textView;
        textView.setTextColor(color);
        this.f11491d.setTextSize(0, dimensionPixelSize);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.iv_retry_download);
        this.f11492f = imageView;
        imageView.setOnClickListener(new a());
    }

    private int j(int i) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode == 1073741824) {
            return size;
        }
        int i2 = this.y * 2;
        return mode == Integer.MIN_VALUE ? Math.min(i2, size) : i2;
    }

    private void l() {
        ValueAnimator valueAnimator = this.K3;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.K3.cancel();
        }
    }

    public void k() {
        this.f11491d.setVisibility(0);
        this.f11492f.setVisibility(8);
        this.p2 = 0;
        this.p3 = getResources().getColor(R.color.common_iot_main_blue);
        this.H3 = getResources().getColor(R.color.common_iot_main_blue);
    }

    public void m() {
        this.f11491d.setVisibility(8);
        this.f11492f.setVisibility(0);
        this.p3 = getResources().getColor(R.color.common_iot_red);
        this.H3 = getResources().getColor(R.color.common_iot_red);
        invalidate();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        l();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.p2 < 100) {
            canvas.rotate(-90.0f, getWidth() / 2, getHeight() / 2);
            RectF rectF = this.p1;
            int i = this.x;
            rectF.set(i / 2, i / 2, getWidth() - (this.x / 2), getHeight() - (this.x / 2));
            if (this.q != -1) {
                canvas.drawArc(this.p1, 0.0f, 360.0f, false, this.J3);
            }
            Paint paint = this.I3;
            int i2 = this.p3;
            paint.setShader(new SweepGradient(getWidth() / 2, getHeight() / 2, new int[]{i2, this.H3, i2}, (float[]) null));
            canvas.drawArc(this.p1, 0.0f, (this.p2 * 360) / 100, false, this.I3);
            canvas.rotate(90.0f, getWidth() / 2, getHeight() / 2);
            this.f11491d.setText(getResources().getString(R.string.process, Integer.valueOf(this.p2)));
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(j(i), j(i2));
    }

    public void setListener(c cVar) {
        this.M3 = cVar;
    }

    public void setPercentData(int i) {
        int i2 = this.p2;
        if (i2 != i) {
            this.K3 = ValueAnimator.ofInt(i2, i);
            long abs = Math.abs(this.p2 - i) * 40;
            if (abs > 200) {
                abs = 200;
            }
            this.K3.setDuration(abs);
            this.K3.addUpdateListener(new b());
            this.K3.setInterpolator(this.L3);
            this.K3.start();
        }
    }

    public void setmInterpolator(TimeInterpolator timeInterpolator) {
        this.L3 = timeInterpolator;
    }

    public CirclePercentBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CirclePercentBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.p2 = 0;
        this.f11490c = context;
        this.L3 = new DecelerateInterpolator();
        i(context, attributeSet, i);
        setWillNotDraw(false);
        h();
    }
}
