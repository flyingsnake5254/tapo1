package com.tplink.iot.widget.colorbulb;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.core.graphics.drawable.DrawableCompat;
import com.tplink.iot.R;

/* loaded from: classes3.dex */
public class NextEventBulbTintView extends RelativeLayout {

    /* renamed from: c  reason: collision with root package name */
    private ImageView f11766c;

    /* renamed from: d  reason: collision with root package name */
    private Drawable f11767d;

    public NextEventBulbTintView(Context context) {
        this(context, null);
    }

    public void setTintColor(int i) {
        if (i == Integer.MAX_VALUE) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        if (i == 0) {
            this.f11766c.setImageResource(R.mipmap.ic_next_event_bulb_auto);
        } else if (i == -2147483647) {
            this.f11766c.setImageResource(R.mipmap.ic_next_event_bulb_white);
        } else {
            DrawableCompat.setTint(this.f11767d, i);
            this.f11766c.setImageDrawable(this.f11767d);
        }
    }

    public NextEventBulbTintView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NextEventBulbTintView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Drawable drawable;
        this.f11766c = new ImageView(context);
        ImageView imageView = new ImageView(context);
        this.f11766c.setImageResource(R.mipmap.ic_next_event_bulb_white);
        imageView.setImageResource(R.mipmap.ic_next_event_bulb_outline);
        addView(this.f11766c, new RelativeLayout.LayoutParams(-2, -2));
        addView(imageView, new RelativeLayout.LayoutParams(-2, -2));
        if (Build.VERSION.SDK_INT < 21) {
            drawable = getResources().getDrawable(R.mipmap.ic_next_event_bulb);
        } else {
            drawable = getResources().getDrawable(R.mipmap.ic_next_event_bulb, context.getTheme());
        }
        this.f11767d = DrawableCompat.wrap(drawable.mutate());
    }
}
