package androidx.core.graphics;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import kotlin.jvm.b.l;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.j;
import kotlin.p;

/* compiled from: Canvas.kt */
/* loaded from: classes.dex */
public final class CanvasKt {
    public static final void withClip(Canvas withClip, Rect clipRect, l<? super Canvas, p> block) {
        j.f(withClip, "$this$withClip");
        j.f(clipRect, "clipRect");
        j.f(block, "block");
        int save = withClip.save();
        withClip.clipRect(clipRect);
        try {
            block.invoke(withClip);
        } finally {
            i.b(1);
            withClip.restoreToCount(save);
            i.a(1);
        }
    }

    public static final void withMatrix(Canvas withMatrix, Matrix matrix, l<? super Canvas, p> block) {
        j.f(withMatrix, "$this$withMatrix");
        j.f(matrix, "matrix");
        j.f(block, "block");
        int save = withMatrix.save();
        withMatrix.concat(matrix);
        try {
            block.invoke(withMatrix);
        } finally {
            i.b(1);
            withMatrix.restoreToCount(save);
            i.a(1);
        }
    }

    public static /* synthetic */ void withMatrix$default(Canvas withMatrix, Matrix matrix, l block, int i, Object obj) {
        if ((i & 1) != 0) {
            matrix = new Matrix();
        }
        j.f(withMatrix, "$this$withMatrix");
        j.f(matrix, "matrix");
        j.f(block, "block");
        int save = withMatrix.save();
        withMatrix.concat(matrix);
        try {
            block.invoke(withMatrix);
        } finally {
            i.b(1);
            withMatrix.restoreToCount(save);
            i.a(1);
        }
    }

    public static final void withRotation(Canvas withRotation, float f2, float f3, float f4, l<? super Canvas, p> block) {
        j.f(withRotation, "$this$withRotation");
        j.f(block, "block");
        int save = withRotation.save();
        withRotation.rotate(f2, f3, f4);
        try {
            block.invoke(withRotation);
        } finally {
            i.b(1);
            withRotation.restoreToCount(save);
            i.a(1);
        }
    }

    public static /* synthetic */ void withRotation$default(Canvas withRotation, float f2, float f3, float f4, l block, int i, Object obj) {
        if ((i & 1) != 0) {
            f2 = 0.0f;
        }
        if ((i & 2) != 0) {
            f3 = 0.0f;
        }
        if ((i & 4) != 0) {
            f4 = 0.0f;
        }
        j.f(withRotation, "$this$withRotation");
        j.f(block, "block");
        int save = withRotation.save();
        withRotation.rotate(f2, f3, f4);
        try {
            block.invoke(withRotation);
        } finally {
            i.b(1);
            withRotation.restoreToCount(save);
            i.a(1);
        }
    }

    public static final void withSave(Canvas withSave, l<? super Canvas, p> block) {
        j.f(withSave, "$this$withSave");
        j.f(block, "block");
        int save = withSave.save();
        try {
            block.invoke(withSave);
        } finally {
            i.b(1);
            withSave.restoreToCount(save);
            i.a(1);
        }
    }

    public static final void withScale(Canvas withScale, float f2, float f3, float f4, float f5, l<? super Canvas, p> block) {
        j.f(withScale, "$this$withScale");
        j.f(block, "block");
        int save = withScale.save();
        withScale.scale(f2, f3, f4, f5);
        try {
            block.invoke(withScale);
        } finally {
            i.b(1);
            withScale.restoreToCount(save);
            i.a(1);
        }
    }

    public static /* synthetic */ void withScale$default(Canvas withScale, float f2, float f3, float f4, float f5, l block, int i, Object obj) {
        if ((i & 1) != 0) {
            f2 = 1.0f;
        }
        if ((i & 2) != 0) {
            f3 = 1.0f;
        }
        if ((i & 4) != 0) {
            f4 = 0.0f;
        }
        if ((i & 8) != 0) {
            f5 = 0.0f;
        }
        j.f(withScale, "$this$withScale");
        j.f(block, "block");
        int save = withScale.save();
        withScale.scale(f2, f3, f4, f5);
        try {
            block.invoke(withScale);
        } finally {
            i.b(1);
            withScale.restoreToCount(save);
            i.a(1);
        }
    }

    public static final void withSkew(Canvas withSkew, float f2, float f3, l<? super Canvas, p> block) {
        j.f(withSkew, "$this$withSkew");
        j.f(block, "block");
        int save = withSkew.save();
        withSkew.skew(f2, f3);
        try {
            block.invoke(withSkew);
        } finally {
            i.b(1);
            withSkew.restoreToCount(save);
            i.a(1);
        }
    }

    public static /* synthetic */ void withSkew$default(Canvas withSkew, float f2, float f3, l block, int i, Object obj) {
        if ((i & 1) != 0) {
            f2 = 0.0f;
        }
        if ((i & 2) != 0) {
            f3 = 0.0f;
        }
        j.f(withSkew, "$this$withSkew");
        j.f(block, "block");
        int save = withSkew.save();
        withSkew.skew(f2, f3);
        try {
            block.invoke(withSkew);
        } finally {
            i.b(1);
            withSkew.restoreToCount(save);
            i.a(1);
        }
    }

    public static final void withTranslation(Canvas withTranslation, float f2, float f3, l<? super Canvas, p> block) {
        j.f(withTranslation, "$this$withTranslation");
        j.f(block, "block");
        int save = withTranslation.save();
        withTranslation.translate(f2, f3);
        try {
            block.invoke(withTranslation);
        } finally {
            i.b(1);
            withTranslation.restoreToCount(save);
            i.a(1);
        }
    }

    public static /* synthetic */ void withTranslation$default(Canvas withTranslation, float f2, float f3, l block, int i, Object obj) {
        if ((i & 1) != 0) {
            f2 = 0.0f;
        }
        if ((i & 2) != 0) {
            f3 = 0.0f;
        }
        j.f(withTranslation, "$this$withTranslation");
        j.f(block, "block");
        int save = withTranslation.save();
        withTranslation.translate(f2, f3);
        try {
            block.invoke(withTranslation);
        } finally {
            i.b(1);
            withTranslation.restoreToCount(save);
            i.a(1);
        }
    }

    public static final void withClip(Canvas withClip, RectF clipRect, l<? super Canvas, p> block) {
        j.f(withClip, "$this$withClip");
        j.f(clipRect, "clipRect");
        j.f(block, "block");
        int save = withClip.save();
        withClip.clipRect(clipRect);
        try {
            block.invoke(withClip);
        } finally {
            i.b(1);
            withClip.restoreToCount(save);
            i.a(1);
        }
    }

    public static final void withClip(Canvas withClip, int i, int i2, int i3, int i4, l<? super Canvas, p> block) {
        j.f(withClip, "$this$withClip");
        j.f(block, "block");
        int save = withClip.save();
        withClip.clipRect(i, i2, i3, i4);
        try {
            block.invoke(withClip);
        } finally {
            i.b(1);
            withClip.restoreToCount(save);
            i.a(1);
        }
    }

    public static final void withClip(Canvas withClip, float f2, float f3, float f4, float f5, l<? super Canvas, p> block) {
        j.f(withClip, "$this$withClip");
        j.f(block, "block");
        int save = withClip.save();
        withClip.clipRect(f2, f3, f4, f5);
        try {
            block.invoke(withClip);
        } finally {
            i.b(1);
            withClip.restoreToCount(save);
            i.a(1);
        }
    }

    public static final void withClip(Canvas withClip, Path clipPath, l<? super Canvas, p> block) {
        j.f(withClip, "$this$withClip");
        j.f(clipPath, "clipPath");
        j.f(block, "block");
        int save = withClip.save();
        withClip.clipPath(clipPath);
        try {
            block.invoke(withClip);
        } finally {
            i.b(1);
            withClip.restoreToCount(save);
            i.a(1);
        }
    }
}
