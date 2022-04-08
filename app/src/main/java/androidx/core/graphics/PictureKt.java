package androidx.core.graphics;

import android.graphics.Canvas;
import android.graphics.Picture;
import kotlin.jvm.b.l;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.j;
import kotlin.p;

/* compiled from: Picture.kt */
/* loaded from: classes.dex */
public final class PictureKt {
    public static final Picture record(Picture record, int i, int i2, l<? super Canvas, p> block) {
        j.f(record, "$this$record");
        j.f(block, "block");
        Canvas c2 = record.beginRecording(i, i2);
        try {
            j.b(c2, "c");
            block.invoke(c2);
            return record;
        } finally {
            i.b(1);
            record.endRecording();
            i.a(1);
        }
    }
}
