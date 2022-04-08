package com.tplink.iot.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.tplink.iot.R;
import net.lucode.hackware.magicindicator.g.b;

/* loaded from: classes3.dex */
public class TextMarkLayout extends LinearLayout {

    /* renamed from: c  reason: collision with root package name */
    private String[] f11603c;

    public TextMarkLayout(Context context) {
        this(context, null);
    }

    private void a(Context context) {
        for (int i = 0; i < this.f11603c.length; i++) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.view_color_temperature_mark_text, (ViewGroup) null);
            ((TextView) inflate.findViewById(R.id.tv_mark)).setText(this.f11603c[i]);
            addView(inflate, new LinearLayout.LayoutParams(-2, -2));
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        int measuredWidth = getMeasuredWidth() - getPaddingRight();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if (i6 == 0) {
                i5 = b.a(getContext(), 12.0d);
            } else {
                i5 = b.a(getContext(), 60.0d) * (i6 + 1);
            }
            childAt.layout(paddingLeft, i5, measuredWidth, childAt.getMeasuredHeight() + i5);
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int i3 = 0;
        if (getChildCount() > 0) {
            i3 = getChildAt(0).getMeasuredHeight();
        }
        setMeasuredDimension(i, LinearLayout.resolveSize(getPaddingTop() + getPaddingBottom() + b.a(getContext(), 240.0d) + i3, i2));
    }

    public TextMarkLayout(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TextMarkLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f11603c = new String[]{getContext().getString(R.string.speaker_recommend_hint), getContext().getString(R.string.color_temperature_white), getContext().getString(R.string.color_temperature_daylight)};
        setOrientation(1);
        a(context);
    }
}
