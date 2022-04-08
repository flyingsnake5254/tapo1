package uk.co.senab.photoview;

import android.graphics.RectF;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.ImageView;

/* compiled from: DefaultOnDoubleTapListener.java */
/* loaded from: classes4.dex */
public class b implements GestureDetector.OnDoubleTapListener {

    /* renamed from: c  reason: collision with root package name */
    private d f17750c;

    public b(d dVar) {
        a(dVar);
    }

    public void a(d dVar) {
        this.f17750c = dVar;
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTap(MotionEvent motionEvent) {
        d dVar = this.f17750c;
        if (dVar == null) {
            return false;
        }
        try {
            float A = dVar.A();
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            if (A < this.f17750c.w()) {
                d dVar2 = this.f17750c;
                dVar2.X(dVar2.w(), x, y, true);
            } else if (A < this.f17750c.w() || A >= this.f17750c.v()) {
                d dVar3 = this.f17750c;
                dVar3.X(dVar3.x(), x, y, true);
            } else {
                d dVar4 = this.f17750c;
                dVar4.X(dVar4.v(), x, y, true);
            }
        } catch (ArrayIndexOutOfBoundsException unused) {
        }
        return true;
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTapEvent(MotionEvent motionEvent) {
        return false;
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        RectF p;
        d dVar = this.f17750c;
        if (dVar == null) {
            return false;
        }
        ImageView s = dVar.s();
        if (!(this.f17750c.y() == null || (p = this.f17750c.p()) == null)) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            if (p.contains(x, y)) {
                this.f17750c.y().a0(s, (x - p.left) / p.width(), (y - p.top) / p.height());
                return true;
            }
            this.f17750c.y().R();
        }
        if (this.f17750c.z() != null) {
            this.f17750c.z().a(s, motionEvent.getX(), motionEvent.getY());
        }
        return false;
    }
}
