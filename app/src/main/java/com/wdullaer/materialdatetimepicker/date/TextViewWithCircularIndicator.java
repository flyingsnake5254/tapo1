package com.wdullaer.materialdatetimepicker.date;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import com.wdullaer.materialdatetimepicker.a;
import com.wdullaer.materialdatetimepicker.c;

/* loaded from: classes3.dex */
public class TextViewWithCircularIndicator extends TextView {

    /* renamed from: c  reason: collision with root package name */
    Paint f15298c = new Paint();

    /* renamed from: d  reason: collision with root package name */
    private int f15299d;

    /* renamed from: f  reason: collision with root package name */
    private final String f15300f;
    private boolean q;

    public TextViewWithCircularIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f15299d = ContextCompat.getColor(context, a.mdtp_accent_color);
        this.f15300f = context.getResources().getString(c.mdtp_item_is_selected);
        b();
    }

    private void b() {
        this.f15298c.setFakeBoldText(true);
        this.f15298c.setAntiAlias(true);
        this.f15298c.setColor(this.f15299d);
        this.f15298c.setTextAlign(Paint.Align.CENTER);
        this.f15298c.setStyle(Paint.Style.FILL);
        this.f15298c.setAlpha(255);
    }

    public void a(boolean z) {
        this.q = z;
    }

    @Override // android.view.View
    public CharSequence getContentDescription() {
        CharSequence text = getText();
        return this.q ? String.format(this.f15300f, text) : text;
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(@NonNull Canvas canvas) {
        if (this.q) {
            int width = getWidth();
            int height = getHeight();
            canvas.drawCircle(width / 2, height / 2, Math.min(width, height) / 2, this.f15298c);
        }
        setSelected(this.q);
        super.onDraw(canvas);
    }
}
