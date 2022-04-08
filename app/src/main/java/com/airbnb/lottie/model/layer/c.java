package com.airbnb.lottie.model.layer;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.airbnb.lottie.f;
import com.airbnb.lottie.k;
import com.airbnb.lottie.s.c.a;
import com.airbnb.lottie.s.c.p;
import com.airbnb.lottie.v.h;

/* compiled from: ImageLayer.java */
/* loaded from: classes.dex */
public class c extends a {
    @Nullable
    private a<ColorFilter, ColorFilter> A;
    private final Paint x = new com.airbnb.lottie.s.a(3);
    private final Rect y = new Rect();
    private final Rect z = new Rect();

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(f fVar, Layer layer) {
        super(fVar, layer);
    }

    @Nullable
    private Bitmap J() {
        return this.n.q(this.o.k());
    }

    @Override // com.airbnb.lottie.model.layer.a, com.airbnb.lottie.model.e
    public <T> void c(T t, @Nullable com.airbnb.lottie.w.c<T> cVar) {
        super.c(t, cVar);
        if (t != k.C) {
            return;
        }
        if (cVar == null) {
            this.A = null;
        } else {
            this.A = new p(cVar);
        }
    }

    @Override // com.airbnb.lottie.model.layer.a, com.airbnb.lottie.s.b.e
    public void e(RectF rectF, Matrix matrix, boolean z) {
        super.e(rectF, matrix, z);
        Bitmap J = J();
        if (J != null) {
            rectF.set(0.0f, 0.0f, J.getWidth() * h.e(), J.getHeight() * h.e());
            this.m.mapRect(rectF);
        }
    }

    @Override // com.airbnb.lottie.model.layer.a
    public void t(@NonNull Canvas canvas, Matrix matrix, int i) {
        Bitmap J = J();
        if (J != null && !J.isRecycled()) {
            float e2 = h.e();
            this.x.setAlpha(i);
            a<ColorFilter, ColorFilter> aVar = this.A;
            if (aVar != null) {
                this.x.setColorFilter(aVar.h());
            }
            canvas.save();
            canvas.concat(matrix);
            this.y.set(0, 0, J.getWidth(), J.getHeight());
            this.z.set(0, 0, (int) (J.getWidth() * e2), (int) (J.getHeight() * e2));
            canvas.drawBitmap(J, this.y, this.z, this.x);
            canvas.restore();
        }
    }
}
