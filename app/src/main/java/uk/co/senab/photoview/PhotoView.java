package uk.co.senab.photoview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.View;
import android.widget.ImageView;
import uk.co.senab.photoview.d;

/* loaded from: classes4.dex */
public class PhotoView extends ImageView implements c {

    /* renamed from: c  reason: collision with root package name */
    private d f17748c;

    /* renamed from: d  reason: collision with root package name */
    private ImageView.ScaleType f17749d;

    public PhotoView(Context context) {
        this(context, null);
    }

    protected void a() {
        d dVar = this.f17748c;
        if (dVar == null || dVar.s() == null) {
            this.f17748c = new d(this);
        }
        ImageView.ScaleType scaleType = this.f17749d;
        if (scaleType != null) {
            setScaleType(scaleType);
            this.f17749d = null;
        }
    }

    public Matrix getDisplayMatrix() {
        return this.f17748c.o();
    }

    public RectF getDisplayRect() {
        return this.f17748c.p();
    }

    public c getIPhotoViewImplementation() {
        return this.f17748c;
    }

    @Deprecated
    public float getMaxScale() {
        return getMaximumScale();
    }

    public float getMaximumScale() {
        return this.f17748c.v();
    }

    public float getMediumScale() {
        return this.f17748c.w();
    }

    @Deprecated
    public float getMidScale() {
        return getMediumScale();
    }

    @Deprecated
    public float getMinScale() {
        return getMinimumScale();
    }

    public float getMinimumScale() {
        return this.f17748c.x();
    }

    @Deprecated
    public d.f getOnPhotoTapListener() {
        return this.f17748c.y();
    }

    @Deprecated
    public d.i getOnViewTapListener() {
        return this.f17748c.z();
    }

    public float getScale() {
        return this.f17748c.A();
    }

    @Override // android.widget.ImageView
    public ImageView.ScaleType getScaleType() {
        return this.f17748c.B();
    }

    public Bitmap getVisibleRectangleBitmap() {
        return this.f17748c.D();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        a();
        super.onAttachedToWindow();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        this.f17748c.n();
        super.onDetachedFromWindow();
    }

    public void setAllowParentInterceptOnEdge(boolean z) {
        this.f17748c.H(z);
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        d dVar = this.f17748c;
        if (dVar != null) {
            dVar.c0();
        }
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        super.setImageResource(i);
        d dVar = this.f17748c;
        if (dVar != null) {
            dVar.c0();
        }
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        d dVar = this.f17748c;
        if (dVar != null) {
            dVar.c0();
        }
    }

    @Deprecated
    public void setMaxScale(float f2) {
        setMaximumScale(f2);
    }

    public void setMaximumScale(float f2) {
        this.f17748c.K(f2);
    }

    public void setMediumScale(float f2) {
        this.f17748c.L(f2);
    }

    @Deprecated
    public void setMidScale(float f2) {
        setMediumScale(f2);
    }

    @Deprecated
    public void setMinScale(float f2) {
        setMinimumScale(f2);
    }

    public void setMinimumScale(float f2) {
        this.f17748c.M(f2);
    }

    public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        this.f17748c.N(onDoubleTapListener);
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.f17748c.O(onLongClickListener);
    }

    public void setOnMatrixChangeListener(d.e eVar) {
        this.f17748c.P(eVar);
    }

    public void setOnPhotoTapListener(d.f fVar) {
        this.f17748c.Q(fVar);
    }

    public void setOnScaleChangeListener(d.g gVar) {
        this.f17748c.R(gVar);
    }

    public void setOnSingleFlingListener(d.h hVar) {
        this.f17748c.S(hVar);
    }

    public void setOnViewTapListener(d.i iVar) {
        this.f17748c.T(iVar);
    }

    public void setPhotoViewRotation(float f2) {
        this.f17748c.V(f2);
    }

    public void setRotationBy(float f2) {
        this.f17748c.U(f2);
    }

    public void setRotationTo(float f2) {
        this.f17748c.V(f2);
    }

    public void setScale(float f2) {
        this.f17748c.W(f2);
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        d dVar = this.f17748c;
        if (dVar != null) {
            dVar.Z(scaleType);
        } else {
            this.f17749d = scaleType;
        }
    }

    public void setZoomTransitionDuration(int i) {
        this.f17748c.a0(i);
    }

    public void setZoomable(boolean z) {
        this.f17748c.b0(z);
    }

    public PhotoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PhotoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        super.setScaleType(ImageView.ScaleType.MATRIX);
        a();
    }
}
