package uk.co.senab.photoview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import androidx.core.view.MotionEventCompat;
import androidx.recyclerview.widget.ItemTouchHelper;
import java.lang.ref.WeakReference;

/* compiled from: PhotoViewAttacher.java */
/* loaded from: classes4.dex */
public class d implements c, View.OnTouchListener, uk.co.senab.photoview.e.e, ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: c  reason: collision with root package name */
    private static final boolean f17751c = Log.isLoggable("PhotoViewAttacher", 3);

    /* renamed from: d  reason: collision with root package name */
    static final Interpolator f17752d = new AccelerateDecelerateInterpolator();

    /* renamed from: f  reason: collision with root package name */
    static int f17753f = 1;
    private uk.co.senab.photoview.e.d H3;
    private final Matrix I3;
    private final Matrix J3;
    private final Matrix K3;
    private final RectF L3;
    private final float[] M3;
    private e N3;
    private f O3;
    private i P3;
    private View.OnLongClickListener Q3;
    private g R3;
    private h S3;
    private int T3;
    private int U3;
    private int V3;
    private int W3;
    private RunnableC0352d X3;
    private int Y3;
    private float Z3;
    private boolean a4;
    private ImageView.ScaleType b4;
    private boolean p0;
    private boolean p1;
    private WeakReference<ImageView> p2;
    private GestureDetector p3;
    int q;
    private float x;
    private float y;
    private float z;

    /* compiled from: PhotoViewAttacher.java */
    /* loaded from: classes4.dex */
    class a extends GestureDetector.SimpleOnGestureListener {
        a() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            if (d.this.S3 == null || d.this.A() > 1.0f || MotionEventCompat.getPointerCount(motionEvent) > d.f17753f || MotionEventCompat.getPointerCount(motionEvent2) > d.f17753f) {
                return false;
            }
            return d.this.S3.onFling(motionEvent, motionEvent2, f2, f3);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            if (d.this.Q3 != null) {
                d.this.Q3.onLongClick(d.this.s());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PhotoViewAttacher.java */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class b {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            a = iArr;
            try {
                iArr[ImageView.ScaleType.MATRIX.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[ImageView.ScaleType.FIT_START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[ImageView.ScaleType.FIT_END.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[ImageView.ScaleType.FIT_CENTER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[ImageView.ScaleType.FIT_XY.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: PhotoViewAttacher.java */
    /* loaded from: classes4.dex */
    public class c implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        private final float f17755c;

        /* renamed from: d  reason: collision with root package name */
        private final float f17756d;

        /* renamed from: f  reason: collision with root package name */
        private final long f17757f = System.currentTimeMillis();
        private final float q;
        private final float x;

        public c(float f2, float f3, float f4, float f5) {
            this.f17755c = f4;
            this.f17756d = f5;
            this.q = f2;
            this.x = f3;
        }

        private float a() {
            return d.f17752d.getInterpolation(Math.min(1.0f, (((float) (System.currentTimeMillis() - this.f17757f)) * 1.0f) / d.this.q));
        }

        @Override // java.lang.Runnable
        public void run() {
            ImageView s = d.this.s();
            if (s != null) {
                float a = a();
                float f2 = this.q;
                d.this.b((f2 + ((this.x - f2) * a)) / d.this.A(), this.f17755c, this.f17756d);
                if (a < 1.0f) {
                    a.d(s, this);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: PhotoViewAttacher.java */
    /* renamed from: uk.co.senab.photoview.d$d  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class RunnableC0352d implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        private final uk.co.senab.photoview.g.d f17758c;

        /* renamed from: d  reason: collision with root package name */
        private int f17759d;

        /* renamed from: f  reason: collision with root package name */
        private int f17760f;

        public RunnableC0352d(Context context) {
            this.f17758c = uk.co.senab.photoview.g.d.f(context);
        }

        public void a() {
            if (d.f17751c) {
                uk.co.senab.photoview.f.a.a().a("PhotoViewAttacher", "Cancel Fling");
            }
            this.f17758c.c(true);
        }

        public void b(int i, int i2, int i3, int i4) {
            int i5;
            int i6;
            int i7;
            int i8;
            RectF p = d.this.p();
            if (p != null) {
                int round = Math.round(-p.left);
                float f2 = i;
                if (f2 < p.width()) {
                    i5 = Math.round(p.width() - f2);
                    i6 = 0;
                } else {
                    i6 = round;
                    i5 = i6;
                }
                int round2 = Math.round(-p.top);
                float f3 = i2;
                if (f3 < p.height()) {
                    i7 = Math.round(p.height() - f3);
                    i8 = 0;
                } else {
                    i8 = round2;
                    i7 = i8;
                }
                this.f17759d = round;
                this.f17760f = round2;
                if (d.f17751c) {
                    uk.co.senab.photoview.f.a.a().a("PhotoViewAttacher", "fling. StartX:" + round + " StartY:" + round2 + " MaxX:" + i5 + " MaxY:" + i7);
                }
                if (round != i5 || round2 != i7) {
                    this.f17758c.b(round, round2, i3, i4, i6, i5, i8, i7, 0, 0);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            ImageView s;
            if (!this.f17758c.g() && (s = d.this.s()) != null && this.f17758c.a()) {
                int d2 = this.f17758c.d();
                int e2 = this.f17758c.e();
                if (d.f17751c) {
                    uk.co.senab.photoview.f.b a = uk.co.senab.photoview.f.a.a();
                    a.a("PhotoViewAttacher", "fling run(). CurrentX:" + this.f17759d + " CurrentY:" + this.f17760f + " NewX:" + d2 + " NewY:" + e2);
                }
                d.this.K3.postTranslate(this.f17759d - d2, this.f17760f - e2);
                d dVar = d.this;
                dVar.I(dVar.r());
                this.f17759d = d2;
                this.f17760f = e2;
                a.d(s, this);
            }
        }
    }

    /* compiled from: PhotoViewAttacher.java */
    /* loaded from: classes4.dex */
    public interface e {
        void a(RectF rectF);
    }

    /* compiled from: PhotoViewAttacher.java */
    /* loaded from: classes4.dex */
    public interface f {
        void R();

        void a0(View view, float f2, float f3);
    }

    /* compiled from: PhotoViewAttacher.java */
    /* loaded from: classes4.dex */
    public interface g {
        void a(float f2, float f3, float f4);
    }

    /* compiled from: PhotoViewAttacher.java */
    /* loaded from: classes4.dex */
    public interface h {
        boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3);
    }

    /* compiled from: PhotoViewAttacher.java */
    /* loaded from: classes4.dex */
    public interface i {
        void a(View view, float f2, float f3);
    }

    public d(ImageView imageView) {
        this(imageView, true);
    }

    private float C(Matrix matrix, int i2) {
        matrix.getValues(this.M3);
        return this.M3[i2];
    }

    private static boolean E(ImageView imageView) {
        return (imageView == null || imageView.getDrawable() == null) ? false : true;
    }

    private static boolean F(ImageView.ScaleType scaleType) {
        if (scaleType == null) {
            return false;
        }
        if (b.a[scaleType.ordinal()] != 1) {
            return true;
        }
        throw new IllegalArgumentException(scaleType.name() + " is not supported in PhotoView");
    }

    private void G() {
        this.K3.reset();
        U(this.Z3);
        I(r());
        l();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I(Matrix matrix) {
        RectF q;
        ImageView s = s();
        if (s != null) {
            k();
            s.setImageMatrix(matrix);
            if (this.N3 != null && (q = q(matrix)) != null) {
                this.N3.a(q);
            }
        }
    }

    private static void J(ImageView imageView) {
        if (imageView != null && !(imageView instanceof c) && !ImageView.ScaleType.MATRIX.equals(imageView.getScaleType())) {
            imageView.setScaleType(ImageView.ScaleType.MATRIX);
        }
    }

    private void d0(Drawable drawable) {
        ImageView s = s();
        if (s != null && drawable != null) {
            float u = u(s);
            float t = t(s);
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            this.I3.reset();
            float f2 = intrinsicWidth;
            float f3 = u / f2;
            float f4 = intrinsicHeight;
            float f5 = t / f4;
            ImageView.ScaleType scaleType = this.b4;
            if (scaleType == ImageView.ScaleType.CENTER) {
                this.I3.postTranslate((u - f2) / 2.0f, (t - f4) / 2.0f);
            } else if (scaleType == ImageView.ScaleType.CENTER_CROP) {
                float max = Math.max(f3, f5);
                this.I3.postScale(max, max);
                this.I3.postTranslate((u - (f2 * max)) / 2.0f, (t - (f4 * max)) / 2.0f);
            } else if (scaleType == ImageView.ScaleType.CENTER_INSIDE) {
                float min = Math.min(1.0f, Math.min(f3, f5));
                this.I3.postScale(min, min);
                this.I3.postTranslate((u - (f2 * min)) / 2.0f, (t - (f4 * min)) / 2.0f);
            } else {
                RectF rectF = new RectF(0.0f, 0.0f, f2, f4);
                RectF rectF2 = new RectF(0.0f, 0.0f, u, t);
                if (((int) this.Z3) % 180 != 0) {
                    rectF = new RectF(0.0f, 0.0f, f4, f2);
                }
                int i2 = b.a[this.b4.ordinal()];
                if (i2 == 2) {
                    this.I3.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.START);
                } else if (i2 == 3) {
                    this.I3.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.END);
                } else if (i2 == 4) {
                    this.I3.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.CENTER);
                } else if (i2 == 5) {
                    this.I3.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.FILL);
                }
            }
            G();
        }
    }

    private void i() {
        RunnableC0352d dVar = this.X3;
        if (dVar != null) {
            dVar.a();
            this.X3 = null;
        }
    }

    private void j() {
        if (l()) {
            I(r());
        }
    }

    private void k() {
        ImageView s = s();
        if (s != null && !(s instanceof c) && !ImageView.ScaleType.MATRIX.equals(s.getScaleType())) {
            throw new IllegalStateException("The ImageView's ScaleType has been changed since attaching a PhotoViewAttacher");
        }
    }

    private boolean l() {
        RectF q;
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        ImageView s = s();
        if (s == null || (q = q(r())) == null) {
            return false;
        }
        float height = q.height();
        float width = q.width();
        float t = t(s);
        float f7 = 0.0f;
        if (height <= t) {
            int i2 = b.a[this.b4.ordinal()];
            if (i2 != 2) {
                if (i2 != 3) {
                    t = (t - height) / 2.0f;
                    f6 = q.top;
                } else {
                    t -= height;
                    f6 = q.top;
                }
                f2 = t - f6;
            } else {
                f5 = q.top;
                f2 = -f5;
            }
        } else {
            f5 = q.top;
            if (f5 <= 0.0f) {
                f6 = q.bottom;
                if (f6 >= t) {
                    f2 = 0.0f;
                }
                f2 = t - f6;
            }
            f2 = -f5;
        }
        float u = u(s);
        if (width <= u) {
            int i3 = b.a[this.b4.ordinal()];
            if (i3 != 2) {
                if (i3 != 3) {
                    f4 = (u - width) / 2.0f;
                    f3 = q.left;
                } else {
                    f4 = u - width;
                    f3 = q.left;
                }
                f7 = f4 - f3;
            } else {
                f7 = -q.left;
            }
            this.Y3 = 2;
        } else {
            float f8 = q.left;
            if (f8 > 0.0f) {
                this.Y3 = 0;
                f7 = -f8;
            } else {
                float f9 = q.right;
                if (f9 < u) {
                    f7 = u - f9;
                    this.Y3 = 1;
                } else {
                    this.Y3 = -1;
                }
            }
        }
        this.K3.postTranslate(f7, f2);
        return true;
    }

    private static void m(float f2, float f3, float f4) {
        if (f2 >= f3) {
            throw new IllegalArgumentException("MinZoom has to be less than MidZoom");
        } else if (f3 >= f4) {
            throw new IllegalArgumentException("MidZoom has to be less than MaxZoom");
        }
    }

    private RectF q(Matrix matrix) {
        Drawable drawable;
        ImageView s = s();
        if (s == null || (drawable = s.getDrawable()) == null) {
            return null;
        }
        this.L3.set(0.0f, 0.0f, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        matrix.mapRect(this.L3);
        return this.L3;
    }

    private int t(ImageView imageView) {
        if (imageView == null) {
            return 0;
        }
        return (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom();
    }

    private int u(ImageView imageView) {
        if (imageView == null) {
            return 0;
        }
        return (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight();
    }

    public float A() {
        return (float) Math.sqrt(((float) Math.pow(C(this.K3, 0), 2.0d)) + ((float) Math.pow(C(this.K3, 3), 2.0d)));
    }

    public ImageView.ScaleType B() {
        return this.b4;
    }

    public Bitmap D() {
        ImageView s = s();
        if (s == null) {
            return null;
        }
        return s.getDrawingCache();
    }

    public void H(boolean z) {
        this.p0 = z;
    }

    public void K(float f2) {
        m(this.x, this.y, f2);
        this.z = f2;
    }

    public void L(float f2) {
        m(this.x, f2, this.z);
        this.y = f2;
    }

    public void M(float f2) {
        m(f2, this.y, this.z);
        this.x = f2;
    }

    public void N(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        if (onDoubleTapListener != null) {
            this.p3.setOnDoubleTapListener(onDoubleTapListener);
        } else {
            this.p3.setOnDoubleTapListener(new b(this));
        }
    }

    public void O(View.OnLongClickListener onLongClickListener) {
        this.Q3 = onLongClickListener;
    }

    public void P(e eVar) {
        this.N3 = eVar;
    }

    public void Q(f fVar) {
        this.O3 = fVar;
    }

    public void R(g gVar) {
        this.R3 = gVar;
    }

    public void S(h hVar) {
        this.S3 = hVar;
    }

    public void T(i iVar) {
        this.P3 = iVar;
    }

    public void U(float f2) {
        this.K3.postRotate(f2 % 360.0f);
        j();
    }

    public void V(float f2) {
        this.K3.setRotate(f2 % 360.0f);
        j();
    }

    public void W(float f2) {
        Y(f2, false);
    }

    public void X(float f2, float f3, float f4, boolean z) {
        ImageView s = s();
        if (s == null) {
            return;
        }
        if (f2 < this.x || f2 > this.z) {
            uk.co.senab.photoview.f.a.a().b("PhotoViewAttacher", "Scale must be within the range of minScale and maxScale");
        } else if (z) {
            s.post(new c(A(), f2, f3, f4));
        } else {
            this.K3.setScale(f2, f2, f3, f4);
            j();
        }
    }

    public void Y(float f2, boolean z) {
        ImageView s = s();
        if (s != null) {
            X(f2, s.getRight() / 2, s.getBottom() / 2, z);
        }
    }

    public void Z(ImageView.ScaleType scaleType) {
        if (F(scaleType) && scaleType != this.b4) {
            this.b4 = scaleType;
            c0();
        }
    }

    @Override // uk.co.senab.photoview.e.e
    public void a(float f2, float f3) {
        if (!this.H3.c()) {
            if (f17751c) {
                uk.co.senab.photoview.f.a.a().a("PhotoViewAttacher", String.format("onDrag: dx: %.2f. dy: %.2f", Float.valueOf(f2), Float.valueOf(f3)));
            }
            ImageView s = s();
            this.K3.postTranslate(f2, f3);
            j();
            ViewParent parent = s.getParent();
            if (this.p0 && !this.H3.c() && !this.p1) {
                int i2 = this.Y3;
                if ((i2 == 2 || ((i2 == 0 && f2 >= 1.0f) || (i2 == 1 && f2 <= -1.0f))) && parent != null) {
                    parent.requestDisallowInterceptTouchEvent(false);
                }
            } else if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }
    }

    public void a0(int i2) {
        if (i2 < 0) {
            i2 = ItemTouchHelper.Callback.DEFAULT_DRAG_ANIMATION_DURATION;
        }
        this.q = i2;
    }

    @Override // uk.co.senab.photoview.e.e
    public void b(float f2, float f3, float f4) {
        if (f17751c) {
            uk.co.senab.photoview.f.a.a().a("PhotoViewAttacher", String.format("onScale: scale: %.2f. fX: %.2f. fY: %.2f", Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)));
        }
        if (A() >= this.z && f2 >= 1.0f) {
            return;
        }
        if (A() > this.x || f2 > 1.0f) {
            g gVar = this.R3;
            if (gVar != null) {
                gVar.a(f2, f3, f4);
            }
            this.K3.postScale(f2, f2, f3, f4);
            j();
        }
    }

    public void b0(boolean z) {
        this.a4 = z;
        c0();
    }

    @Override // uk.co.senab.photoview.e.e
    public void c(float f2, float f3, float f4, float f5) {
        if (f17751c) {
            uk.co.senab.photoview.f.b a2 = uk.co.senab.photoview.f.a.a();
            a2.a("PhotoViewAttacher", "onFling. sX: " + f2 + " sY: " + f3 + " Vx: " + f4 + " Vy: " + f5);
        }
        ImageView s = s();
        RunnableC0352d dVar = new RunnableC0352d(s.getContext());
        this.X3 = dVar;
        dVar.b(u(s), t(s), (int) f4, (int) f5);
        s.post(this.X3);
    }

    public void c0() {
        ImageView s = s();
        if (s == null) {
            return;
        }
        if (this.a4) {
            J(s);
            d0(s.getDrawable());
            return;
        }
        G();
    }

    public void n() {
        WeakReference<ImageView> weakReference = this.p2;
        if (weakReference != null) {
            ImageView imageView = weakReference.get();
            if (imageView != null) {
                ViewTreeObserver viewTreeObserver = imageView.getViewTreeObserver();
                if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
                    viewTreeObserver.removeGlobalOnLayoutListener(this);
                }
                imageView.setOnTouchListener(null);
                i();
            }
            GestureDetector gestureDetector = this.p3;
            if (gestureDetector != null) {
                gestureDetector.setOnDoubleTapListener(null);
            }
            this.N3 = null;
            this.O3 = null;
            this.P3 = null;
            this.p2 = null;
        }
    }

    public Matrix o() {
        return new Matrix(r());
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        ImageView s = s();
        if (s == null) {
            return;
        }
        if (this.a4) {
            int top = s.getTop();
            int right = s.getRight();
            int bottom = s.getBottom();
            int left = s.getLeft();
            if (top != this.T3 || bottom != this.V3 || left != this.W3 || right != this.U3) {
                d0(s.getDrawable());
                this.T3 = top;
                this.U3 = right;
                this.V3 = bottom;
                this.W3 = left;
                return;
            }
            return;
        }
        d0(s.getDrawable());
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0095  */
    @Override // android.view.View.OnTouchListener
    @android.annotation.SuppressLint({"ClickableViewAccessibility"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouch(android.view.View r11, android.view.MotionEvent r12) {
        /*
            r10 = this;
            boolean r0 = r10.a4
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x00a1
            r0 = r11
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            boolean r0 = E(r0)
            if (r0 == 0) goto L_0x00a1
            android.view.ViewParent r0 = r11.getParent()
            int r3 = r12.getAction()
            if (r3 == 0) goto L_0x0049
            if (r3 == r2) goto L_0x001f
            r0 = 3
            if (r3 == r0) goto L_0x001f
            goto L_0x005d
        L_0x001f:
            float r0 = r10.A()
            float r3 = r10.x
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 >= 0) goto L_0x005d
            android.graphics.RectF r0 = r10.p()
            if (r0 == 0) goto L_0x005d
            uk.co.senab.photoview.d$c r9 = new uk.co.senab.photoview.d$c
            float r5 = r10.A()
            float r6 = r10.x
            float r7 = r0.centerX()
            float r8 = r0.centerY()
            r3 = r9
            r4 = r10
            r3.<init>(r5, r6, r7, r8)
            r11.post(r9)
            r11 = 1
            goto L_0x005e
        L_0x0049:
            if (r0 == 0) goto L_0x004f
            r0.requestDisallowInterceptTouchEvent(r2)
            goto L_0x005a
        L_0x004f:
            uk.co.senab.photoview.f.b r11 = uk.co.senab.photoview.f.a.a()
            java.lang.String r0 = "PhotoViewAttacher"
            java.lang.String r3 = "onTouch getParent() returned null"
            r11.b(r0, r3)
        L_0x005a:
            r10.i()
        L_0x005d:
            r11 = 0
        L_0x005e:
            uk.co.senab.photoview.e.d r0 = r10.H3
            if (r0 == 0) goto L_0x0095
            boolean r11 = r0.c()
            uk.co.senab.photoview.e.d r0 = r10.H3
            boolean r0 = r0.a()
            uk.co.senab.photoview.e.d r3 = r10.H3
            boolean r3 = r3.onTouchEvent(r12)
            if (r11 != 0) goto L_0x007e
            uk.co.senab.photoview.e.d r11 = r10.H3
            boolean r11 = r11.c()
            if (r11 != 0) goto L_0x007e
            r11 = 1
            goto L_0x007f
        L_0x007e:
            r11 = 0
        L_0x007f:
            if (r0 != 0) goto L_0x008b
            uk.co.senab.photoview.e.d r0 = r10.H3
            boolean r0 = r0.a()
            if (r0 != 0) goto L_0x008b
            r0 = 1
            goto L_0x008c
        L_0x008b:
            r0 = 0
        L_0x008c:
            if (r11 == 0) goto L_0x0091
            if (r0 == 0) goto L_0x0091
            r1 = 1
        L_0x0091:
            r10.p1 = r1
            r1 = r3
            goto L_0x0096
        L_0x0095:
            r1 = r11
        L_0x0096:
            android.view.GestureDetector r11 = r10.p3
            if (r11 == 0) goto L_0x00a1
            boolean r11 = r11.onTouchEvent(r12)
            if (r11 == 0) goto L_0x00a1
            r1 = 1
        L_0x00a1:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: uk.co.senab.photoview.d.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    public RectF p() {
        l();
        return q(r());
    }

    public Matrix r() {
        this.J3.set(this.I3);
        this.J3.postConcat(this.K3);
        return this.J3;
    }

    public ImageView s() {
        WeakReference<ImageView> weakReference = this.p2;
        ImageView imageView = weakReference != null ? weakReference.get() : null;
        if (imageView == null) {
            n();
            uk.co.senab.photoview.f.a.a().b("PhotoViewAttacher", "ImageView no longer exists. You should not use this PhotoViewAttacher any more.");
        }
        return imageView;
    }

    public float v() {
        return this.z;
    }

    public float w() {
        return this.y;
    }

    public float x() {
        return this.x;
    }

    @Deprecated
    public f y() {
        return this.O3;
    }

    @Deprecated
    public i z() {
        return this.P3;
    }

    public d(ImageView imageView, boolean z) {
        this.q = ItemTouchHelper.Callback.DEFAULT_DRAG_ANIMATION_DURATION;
        this.x = 1.0f;
        this.y = 1.75f;
        this.z = 3.0f;
        this.p0 = true;
        this.p1 = false;
        this.I3 = new Matrix();
        this.J3 = new Matrix();
        this.K3 = new Matrix();
        this.L3 = new RectF();
        this.M3 = new float[9];
        this.Y3 = 2;
        this.b4 = ImageView.ScaleType.FIT_CENTER;
        this.p2 = new WeakReference<>(imageView);
        imageView.setDrawingCacheEnabled(true);
        imageView.setOnTouchListener(this);
        ViewTreeObserver viewTreeObserver = imageView.getViewTreeObserver();
        if (viewTreeObserver != null) {
            viewTreeObserver.addOnGlobalLayoutListener(this);
        }
        J(imageView);
        if (!imageView.isInEditMode()) {
            this.H3 = uk.co.senab.photoview.e.f.a(imageView.getContext(), this);
            GestureDetector gestureDetector = new GestureDetector(imageView.getContext(), new a());
            this.p3 = gestureDetector;
            gestureDetector.setOnDoubleTapListener(new b(this));
            this.Z3 = 0.0f;
            b0(z);
        }
    }
}
