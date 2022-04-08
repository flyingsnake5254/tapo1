package com.tplink.libtpcontrols.materialnormalcompat.seekbar.internal.c;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.os.SystemClock;
import androidx.annotation.NonNull;

/* compiled from: ThumbDrawable.java */
/* loaded from: classes3.dex */
public class d extends c implements Animatable {
    private Runnable p0 = new a();
    private final int x;
    private boolean y;
    private boolean z;

    /* compiled from: ThumbDrawable.java */
    /* loaded from: classes3.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.y = true;
            d.this.invalidateSelf();
            d.this.z = false;
        }
    }

    public d(@NonNull ColorStateList colorStateList, int i) {
        super(colorStateList);
        this.x = i;
    }

    @Override // com.tplink.libtpcontrols.materialnormalcompat.seekbar.internal.c.c
    public void a(Canvas canvas, Paint paint) {
        if (!this.y) {
            Rect bounds = getBounds();
            canvas.drawCircle(bounds.centerX(), bounds.centerY(), this.x / 2.0f, paint);
        }
    }

    public void g() {
        this.y = false;
        this.z = false;
        unscheduleSelf(this.p0);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.x;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.x;
    }

    public void h() {
        scheduleSelf(this.p0, SystemClock.uptimeMillis() + 100);
        this.z = true;
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.z;
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        g();
    }
}
