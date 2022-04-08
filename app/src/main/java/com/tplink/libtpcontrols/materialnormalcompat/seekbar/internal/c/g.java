package com.tplink.libtpcontrols.materialnormalcompat.seekbar.internal.c;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import androidx.annotation.NonNull;

/* compiled from: TrackRoundRectDrawable.java */
/* loaded from: classes3.dex */
public class g extends c {
    private RectF x = new RectF();

    public g(@NonNull ColorStateList colorStateList) {
        super(colorStateList);
    }

    @Override // com.tplink.libtpcontrols.materialnormalcompat.seekbar.internal.c.c
    void a(Canvas canvas, Paint paint) {
        this.x.set(getBounds());
        RectF rectF = this.x;
        canvas.drawRoundRect(rectF, rectF.height() / 2.0f, this.x.height() / 2.0f, paint);
    }
}
