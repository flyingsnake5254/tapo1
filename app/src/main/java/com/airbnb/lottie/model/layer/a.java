package com.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build;
import androidx.annotation.CallSuper;
import androidx.annotation.FloatRange;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import com.airbnb.lottie.d;
import com.airbnb.lottie.f;
import com.airbnb.lottie.model.content.Mask;
import com.airbnb.lottie.model.content.h;
import com.airbnb.lottie.model.layer.Layer;
import com.airbnb.lottie.s.b.e;
import com.airbnb.lottie.s.c.a;
import com.airbnb.lottie.s.c.c;
import com.airbnb.lottie.s.c.g;
import com.airbnb.lottie.s.c.o;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: BaseLayer.java */
/* loaded from: classes.dex */
public abstract class a implements e, a.b, com.airbnb.lottie.model.e {

    /* renamed from: f  reason: collision with root package name */
    private final Paint f1039f;
    private final String l;
    final f n;
    final Layer o;
    @Nullable
    private g p;
    @Nullable
    private c q;
    @Nullable
    private a r;
    @Nullable
    private a s;
    private List<a> t;
    final o v;
    private final Path a = new Path();

    /* renamed from: b  reason: collision with root package name */
    private final Matrix f1035b = new Matrix();

    /* renamed from: c  reason: collision with root package name */
    private final Paint f1036c = new com.airbnb.lottie.s.a(1);

    /* renamed from: d  reason: collision with root package name */
    private final Paint f1037d = new com.airbnb.lottie.s.a(1, PorterDuff.Mode.DST_IN);

    /* renamed from: e  reason: collision with root package name */
    private final Paint f1038e = new com.airbnb.lottie.s.a(1, PorterDuff.Mode.DST_OUT);
    private final Paint g = new com.airbnb.lottie.s.a(PorterDuff.Mode.CLEAR);
    private final RectF h = new RectF();
    private final RectF i = new RectF();
    private final RectF j = new RectF();
    private final RectF k = new RectF();
    final Matrix m = new Matrix();
    private final List<com.airbnb.lottie.s.c.a<?, ?>> u = new ArrayList();
    private boolean w = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BaseLayer.java */
    /* renamed from: com.airbnb.lottie.model.layer.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0036a implements a.b {
        C0036a() {
        }

        @Override // com.airbnb.lottie.s.c.a.b
        public void a() {
            a aVar = a.this;
            aVar.H(aVar.q.o() == 1.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BaseLayer.java */
    /* loaded from: classes.dex */
    public static /* synthetic */ class b {
        static final /* synthetic */ int[] a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f1040b;

        static {
            int[] iArr = new int[Mask.MaskMode.values().length];
            f1040b = iArr;
            try {
                iArr[Mask.MaskMode.MASK_MODE_NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1040b[Mask.MaskMode.MASK_MODE_SUBTRACT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1040b[Mask.MaskMode.MASK_MODE_INTERSECT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f1040b[Mask.MaskMode.MASK_MODE_ADD.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[Layer.LayerType.values().length];
            a = iArr2;
            try {
                iArr2[Layer.LayerType.SHAPE.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[Layer.LayerType.PRE_COMP.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[Layer.LayerType.SOLID.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[Layer.LayerType.IMAGE.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[Layer.LayerType.NULL.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[Layer.LayerType.TEXT.ordinal()] = 6;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                a[Layer.LayerType.UNKNOWN.ordinal()] = 7;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(f fVar, Layer layer) {
        com.airbnb.lottie.s.a aVar = new com.airbnb.lottie.s.a(1);
        this.f1039f = aVar;
        this.n = fVar;
        this.o = layer;
        this.l = layer.g() + "#draw";
        if (layer.f() == Layer.MatteType.INVERT) {
            aVar.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        } else {
            aVar.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        }
        o b2 = layer.u().b();
        this.v = b2;
        b2.b(this);
        if (layer.e() != null && !layer.e().isEmpty()) {
            g gVar = new g(layer.e());
            this.p = gVar;
            for (com.airbnb.lottie.s.c.a<h, Path> aVar2 : gVar.a()) {
                aVar2.a(this);
            }
            for (com.airbnb.lottie.s.c.a<Integer, Integer> aVar3 : this.p.c()) {
                i(aVar3);
                aVar3.a(this);
            }
        }
        I();
    }

    private void A() {
        this.n.invalidateSelf();
    }

    private void B(float f2) {
        this.n.m().m().a(this.o.g(), f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H(boolean z) {
        if (z != this.w) {
            this.w = z;
            A();
        }
    }

    private void I() {
        boolean z = true;
        if (!this.o.c().isEmpty()) {
            c cVar = new c(this.o.c());
            this.q = cVar;
            cVar.k();
            this.q.a(new C0036a());
            if (this.q.h().floatValue() != 1.0f) {
                z = false;
            }
            H(z);
            i(this.q);
            return;
        }
        H(true);
    }

    private void j(Canvas canvas, Matrix matrix, Mask mask, com.airbnb.lottie.s.c.a<h, Path> aVar, com.airbnb.lottie.s.c.a<Integer, Integer> aVar2) {
        this.a.set(aVar.h());
        this.a.transform(matrix);
        this.f1036c.setAlpha((int) (aVar2.h().intValue() * 2.55f));
        canvas.drawPath(this.a, this.f1036c);
    }

    private void k(Canvas canvas, Matrix matrix, Mask mask, com.airbnb.lottie.s.c.a<h, Path> aVar, com.airbnb.lottie.s.c.a<Integer, Integer> aVar2) {
        com.airbnb.lottie.v.h.m(canvas, this.h, this.f1037d);
        this.a.set(aVar.h());
        this.a.transform(matrix);
        this.f1036c.setAlpha((int) (aVar2.h().intValue() * 2.55f));
        canvas.drawPath(this.a, this.f1036c);
        canvas.restore();
    }

    private void l(Canvas canvas, Matrix matrix, Mask mask, com.airbnb.lottie.s.c.a<h, Path> aVar, com.airbnb.lottie.s.c.a<Integer, Integer> aVar2) {
        com.airbnb.lottie.v.h.m(canvas, this.h, this.f1036c);
        canvas.drawRect(this.h, this.f1036c);
        this.a.set(aVar.h());
        this.a.transform(matrix);
        this.f1036c.setAlpha((int) (aVar2.h().intValue() * 2.55f));
        canvas.drawPath(this.a, this.f1038e);
        canvas.restore();
    }

    private void m(Canvas canvas, Matrix matrix, Mask mask, com.airbnb.lottie.s.c.a<h, Path> aVar, com.airbnb.lottie.s.c.a<Integer, Integer> aVar2) {
        com.airbnb.lottie.v.h.m(canvas, this.h, this.f1037d);
        canvas.drawRect(this.h, this.f1036c);
        this.f1038e.setAlpha((int) (aVar2.h().intValue() * 2.55f));
        this.a.set(aVar.h());
        this.a.transform(matrix);
        canvas.drawPath(this.a, this.f1038e);
        canvas.restore();
    }

    private void n(Canvas canvas, Matrix matrix, Mask mask, com.airbnb.lottie.s.c.a<h, Path> aVar, com.airbnb.lottie.s.c.a<Integer, Integer> aVar2) {
        com.airbnb.lottie.v.h.m(canvas, this.h, this.f1038e);
        canvas.drawRect(this.h, this.f1036c);
        this.f1038e.setAlpha((int) (aVar2.h().intValue() * 2.55f));
        this.a.set(aVar.h());
        this.a.transform(matrix);
        canvas.drawPath(this.a, this.f1038e);
        canvas.restore();
    }

    private void o(Canvas canvas, Matrix matrix) {
        com.airbnb.lottie.c.a("Layer#saveLayer");
        com.airbnb.lottie.v.h.n(canvas, this.h, this.f1037d, 19);
        if (Build.VERSION.SDK_INT < 28) {
            s(canvas);
        }
        com.airbnb.lottie.c.b("Layer#saveLayer");
        for (int i = 0; i < this.p.b().size(); i++) {
            Mask mask = this.p.b().get(i);
            com.airbnb.lottie.s.c.a<h, Path> aVar = this.p.a().get(i);
            com.airbnb.lottie.s.c.a<Integer, Integer> aVar2 = this.p.c().get(i);
            int i2 = b.f1040b[mask.a().ordinal()];
            if (i2 != 1) {
                if (i2 == 2) {
                    if (i == 0) {
                        this.f1036c.setColor(ViewCompat.MEASURED_STATE_MASK);
                        this.f1036c.setAlpha(255);
                        canvas.drawRect(this.h, this.f1036c);
                    }
                    if (mask.d()) {
                        n(canvas, matrix, mask, aVar, aVar2);
                    } else {
                        p(canvas, matrix, mask, aVar, aVar2);
                    }
                } else if (i2 != 3) {
                    if (i2 == 4) {
                        if (mask.d()) {
                            l(canvas, matrix, mask, aVar, aVar2);
                        } else {
                            j(canvas, matrix, mask, aVar, aVar2);
                        }
                    }
                } else if (mask.d()) {
                    m(canvas, matrix, mask, aVar, aVar2);
                } else {
                    k(canvas, matrix, mask, aVar, aVar2);
                }
            } else if (q()) {
                this.f1036c.setAlpha(255);
                canvas.drawRect(this.h, this.f1036c);
            }
        }
        com.airbnb.lottie.c.a("Layer#restoreLayer");
        canvas.restore();
        com.airbnb.lottie.c.b("Layer#restoreLayer");
    }

    private void p(Canvas canvas, Matrix matrix, Mask mask, com.airbnb.lottie.s.c.a<h, Path> aVar, com.airbnb.lottie.s.c.a<Integer, Integer> aVar2) {
        this.a.set(aVar.h());
        this.a.transform(matrix);
        canvas.drawPath(this.a, this.f1038e);
    }

    private boolean q() {
        if (this.p.a().isEmpty()) {
            return false;
        }
        for (int i = 0; i < this.p.b().size(); i++) {
            if (this.p.b().get(i).a() != Mask.MaskMode.MASK_MODE_NONE) {
                return false;
            }
        }
        return true;
    }

    private void r() {
        if (this.t == null) {
            if (this.s == null) {
                this.t = Collections.emptyList();
                return;
            }
            this.t = new ArrayList();
            for (a aVar = this.s; aVar != null; aVar = aVar.s) {
                this.t.add(aVar);
            }
        }
    }

    private void s(Canvas canvas) {
        com.airbnb.lottie.c.a("Layer#clearLayer");
        RectF rectF = this.h;
        canvas.drawRect(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f, this.g);
        com.airbnb.lottie.c.b("Layer#clearLayer");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public static a u(Layer layer, f fVar, d dVar) {
        switch (b.a[layer.d().ordinal()]) {
            case 1:
                return new e(fVar, layer);
            case 2:
                return new b(fVar, layer, dVar.n(layer.k()), dVar);
            case 3:
                return new f(fVar, layer);
            case 4:
                return new c(fVar, layer);
            case 5:
                return new d(fVar, layer);
            case 6:
                return new g(fVar, layer);
            default:
                com.airbnb.lottie.v.d.c("Unknown layer type " + layer.d());
                return null;
        }
    }

    private void y(RectF rectF, Matrix matrix) {
        this.i.set(0.0f, 0.0f, 0.0f, 0.0f);
        if (w()) {
            int size = this.p.b().size();
            for (int i = 0; i < size; i++) {
                Mask mask = this.p.b().get(i);
                this.a.set(this.p.a().get(i).h());
                this.a.transform(matrix);
                int i2 = b.f1040b[mask.a().ordinal()];
                if (i2 != 1 && i2 != 2) {
                    if ((i2 != 3 && i2 != 4) || !mask.d()) {
                        this.a.computeBounds(this.k, false);
                        if (i == 0) {
                            this.i.set(this.k);
                        } else {
                            RectF rectF2 = this.i;
                            rectF2.set(Math.min(rectF2.left, this.k.left), Math.min(this.i.top, this.k.top), Math.max(this.i.right, this.k.right), Math.max(this.i.bottom, this.k.bottom));
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            }
            if (!rectF.intersect(this.i)) {
                rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
            }
        }
    }

    private void z(RectF rectF, Matrix matrix) {
        if (x() && this.o.f() != Layer.MatteType.INVERT) {
            this.j.set(0.0f, 0.0f, 0.0f, 0.0f);
            this.r.e(this.j, matrix, true);
            if (!rectF.intersect(this.j)) {
                rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
            }
        }
    }

    public void C(com.airbnb.lottie.s.c.a<?, ?> aVar) {
        this.u.remove(aVar);
    }

    void D(com.airbnb.lottie.model.d dVar, int i, List<com.airbnb.lottie.model.d> list, com.airbnb.lottie.model.d dVar2) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void E(@Nullable a aVar) {
        this.r = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void F(@Nullable a aVar) {
        this.s = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void G(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        this.v.j(f2);
        if (this.p != null) {
            for (int i = 0; i < this.p.a().size(); i++) {
                this.p.a().get(i).l(f2);
            }
        }
        if (this.o.t() != 0.0f) {
            f2 /= this.o.t();
        }
        c cVar = this.q;
        if (cVar != null) {
            cVar.l(f2 / this.o.t());
        }
        a aVar = this.r;
        if (aVar != null) {
            this.r.G(aVar.o.t() * f2);
        }
        for (int i2 = 0; i2 < this.u.size(); i2++) {
            this.u.get(i2).l(f2);
        }
    }

    @Override // com.airbnb.lottie.s.c.a.b
    public void a() {
        A();
    }

    @Override // com.airbnb.lottie.s.b.c
    public void b(List<com.airbnb.lottie.s.b.c> list, List<com.airbnb.lottie.s.b.c> list2) {
    }

    @Override // com.airbnb.lottie.model.e
    @CallSuper
    public <T> void c(T t, @Nullable com.airbnb.lottie.w.c<T> cVar) {
        this.v.c(t, cVar);
    }

    @Override // com.airbnb.lottie.model.e
    public void d(com.airbnb.lottie.model.d dVar, int i, List<com.airbnb.lottie.model.d> list, com.airbnb.lottie.model.d dVar2) {
        if (dVar.h(getName(), i)) {
            if (!"__container".equals(getName())) {
                dVar2 = dVar2.a(getName());
                if (dVar.c(getName(), i)) {
                    list.add(dVar2.j(this));
                }
            }
            if (dVar.i(getName(), i)) {
                D(dVar, i + dVar.e(getName(), i), list, dVar2);
            }
        }
    }

    @Override // com.airbnb.lottie.s.b.e
    @CallSuper
    public void e(RectF rectF, Matrix matrix, boolean z) {
        this.h.set(0.0f, 0.0f, 0.0f, 0.0f);
        r();
        this.m.set(matrix);
        if (z) {
            List<a> list = this.t;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.m.preConcat(this.t.get(size).v.f());
                }
            } else {
                a aVar = this.s;
                if (aVar != null) {
                    this.m.preConcat(aVar.v.f());
                }
            }
        }
        this.m.preConcat(this.v.f());
    }

    @Override // com.airbnb.lottie.s.b.e
    public void g(Canvas canvas, Matrix matrix, int i) {
        com.airbnb.lottie.c.a(this.l);
        if (!this.w || this.o.v()) {
            com.airbnb.lottie.c.b(this.l);
            return;
        }
        r();
        com.airbnb.lottie.c.a("Layer#parentMatrix");
        this.f1035b.reset();
        this.f1035b.set(matrix);
        for (int size = this.t.size() - 1; size >= 0; size--) {
            this.f1035b.preConcat(this.t.get(size).v.f());
        }
        com.airbnb.lottie.c.b("Layer#parentMatrix");
        int intValue = (int) ((((i / 255.0f) * (this.v.h() == null ? 100 : this.v.h().h().intValue())) / 100.0f) * 255.0f);
        if (x() || w()) {
            com.airbnb.lottie.c.a("Layer#computeBounds");
            e(this.h, this.f1035b, false);
            z(this.h, matrix);
            this.f1035b.preConcat(this.v.f());
            y(this.h, this.f1035b);
            if (!this.h.intersect(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight())) {
                this.h.set(0.0f, 0.0f, 0.0f, 0.0f);
            }
            com.airbnb.lottie.c.b("Layer#computeBounds");
            if (!this.h.isEmpty()) {
                com.airbnb.lottie.c.a("Layer#saveLayer");
                this.f1036c.setAlpha(255);
                com.airbnb.lottie.v.h.m(canvas, this.h, this.f1036c);
                com.airbnb.lottie.c.b("Layer#saveLayer");
                s(canvas);
                com.airbnb.lottie.c.a("Layer#drawLayer");
                t(canvas, this.f1035b, intValue);
                com.airbnb.lottie.c.b("Layer#drawLayer");
                if (w()) {
                    o(canvas, this.f1035b);
                }
                if (x()) {
                    com.airbnb.lottie.c.a("Layer#drawMatte");
                    com.airbnb.lottie.c.a("Layer#saveLayer");
                    com.airbnb.lottie.v.h.n(canvas, this.h, this.f1039f, 19);
                    com.airbnb.lottie.c.b("Layer#saveLayer");
                    s(canvas);
                    this.r.g(canvas, matrix, intValue);
                    com.airbnb.lottie.c.a("Layer#restoreLayer");
                    canvas.restore();
                    com.airbnb.lottie.c.b("Layer#restoreLayer");
                    com.airbnb.lottie.c.b("Layer#drawMatte");
                }
                com.airbnb.lottie.c.a("Layer#restoreLayer");
                canvas.restore();
                com.airbnb.lottie.c.b("Layer#restoreLayer");
            }
            B(com.airbnb.lottie.c.b(this.l));
            return;
        }
        this.f1035b.preConcat(this.v.f());
        com.airbnb.lottie.c.a("Layer#drawLayer");
        t(canvas, this.f1035b, intValue);
        com.airbnb.lottie.c.b("Layer#drawLayer");
        B(com.airbnb.lottie.c.b(this.l));
    }

    @Override // com.airbnb.lottie.s.b.c
    public String getName() {
        return this.o.g();
    }

    public void i(@Nullable com.airbnb.lottie.s.c.a<?, ?> aVar) {
        if (aVar != null) {
            this.u.add(aVar);
        }
    }

    abstract void t(Canvas canvas, Matrix matrix, int i);

    /* JADX INFO: Access modifiers changed from: package-private */
    public Layer v() {
        return this.o;
    }

    boolean w() {
        g gVar = this.p;
        return gVar != null && !gVar.a().isEmpty();
    }

    boolean x() {
        return this.r != null;
    }
}
