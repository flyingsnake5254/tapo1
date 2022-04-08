package com.tplink.iot.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import com.tplink.iot.R;
import com.tplink.iot.b;

/* loaded from: classes3.dex */
public class DiffuseCircleView extends View {

    /* renamed from: c  reason: collision with root package name */
    private int f11499c = getResources().getColor(R.color.white);

    public DiffuseCircleView(Context context) {
        super(context);
    }

    public DiffuseCircleView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public DiffuseCircleView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        context.obtainStyledAttributes(attributeSet, b.DiffuseCircleView, i, 0);
    }
}
