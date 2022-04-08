package uk.co.senab.photoview.e;

import android.annotation.TargetApi;
import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;

/* compiled from: FroyoGestureDetector.java */
@TargetApi(8)
/* loaded from: classes4.dex */
public class c extends b {
    protected final ScaleGestureDetector j;

    /* compiled from: FroyoGestureDetector.java */
    /* loaded from: classes4.dex */
    class a implements ScaleGestureDetector.OnScaleGestureListener {
        a() {
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            float scaleFactor = scaleGestureDetector.getScaleFactor();
            if (Float.isNaN(scaleFactor) || Float.isInfinite(scaleFactor)) {
                return false;
            }
            c.this.a.b(scaleFactor, scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY());
            return true;
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            return true;
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
        }
    }

    public c(Context context) {
        super(context);
        this.j = new ScaleGestureDetector(context, new a());
    }

    @Override // uk.co.senab.photoview.e.a, uk.co.senab.photoview.e.d
    public boolean c() {
        return this.j.isInProgress();
    }

    @Override // uk.co.senab.photoview.e.b, uk.co.senab.photoview.e.a, uk.co.senab.photoview.e.d
    public boolean onTouchEvent(MotionEvent motionEvent) {
        try {
            this.j.onTouchEvent(motionEvent);
            return super.onTouchEvent(motionEvent);
        } catch (IllegalArgumentException unused) {
            return true;
        }
    }
}
